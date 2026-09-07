## Migraciones y Versionado
Las migraciones y el versionado de bases de datos son aspectos esenciales en el desarrollo de software para gestionar los cambios en la estructura de la base de datos de manera controlada y reproducible. A medida que las aplicaciones evolucionan, las bases de datos también deben adaptarse, y es crucial mantener estas actualizaciones de manera consistente en todos los entornos de desarrollo, prueba y producción.

### Conceptos Clave
1. **Migraciones de Bases de Datos**:

   * Definición: Las migraciones de bases de datos son scripts que definen cambios en la estructura de la base de datos, como la creación de tablas, la modificación de columnas, la adición de índices, etc.

   * Propósito: Permiten aplicar cambios en la base de datos de forma incremental y en orden, asegurando que todos los entornos (desarrollo, prueba, producción) estén sincronizados con el mismo esquema.

2. **Versionado de Bases de Datos**:

   * Definición: El versionado de bases de datos es el proceso de asignar un número de versión a cada estado del esquema de la base de datos, lo que permite rastrear los cambios a lo largo del tiempo.

   * Propósito: Facilita la gestión de cambios, permite revertir a versiones anteriores si es necesario, y asegura que el esquema de la base de datos esté en el estado correcto en cualquier punto del ciclo de vida del software.

### Herramientas Populares para Migraciones y Versionado
1. **Flyway**:

   * Descripción: Es una herramienta ligera y poderosa para gestionar migraciones de bases de datos mediante scripts SQL o código Java.

   * Características:
     * Migraciones basadas en archivos.

     * Soporte para múltiples bases de datos (PostgreSQL, MySQL, Oracle, etc.).

     * Capacidad de ejecutar migraciones automáticas al inicio de la aplicación.

   * Versionado: Los scripts de migración se nombran siguiendo un patrón de versión (V1__inicial.sql, V2__agregar_columnas.sql), y Flyway asegura que las migraciones se apliquen en el orden correcto.

2. **Liquibase**:

   * Descripción: Es una herramienta de código abierto que gestiona el versionado de bases de datos y permite definir migraciones utilizando XML, YAML, JSON o SQL.

   * Características:
     * Soporte para múltiples lenguajes de definición de migraciones.

     * Capacidad para generar y aplicar migraciones de manera automática.

     * Potente soporte para refactorizaciones complejas.

   * Versionado: Utiliza un archivo changelog que lista las migraciones en orden, asegurando que se apliquen secuencialmente.

### Ciclo de Vida de una Migración
1. **Crear una Migración**:

   * Desarrollador define un cambio en la base de datos (crear una nueva tabla, añadir una columna, etc.).

   * Se crea un script de migración que representa este cambio.

   * El script se guarda en el control de versiones junto con el código de la aplicación.

2. **Aplicar la Migración**:

   * Cuando la aplicación se despliega en un entorno (desarrollo, prueba, producción), la herramienta de migración (Flyway, Liquibase) ejecuta los scripts en orden, aplicando los cambios necesarios.

   * La herramienta mantiene un registro de las migraciones aplicadas, para evitar duplicados o errores.

3. **Versionado y Control de Cambios**:

   * Cada migración incrementa el número de versión del esquema de la base de datos.

   * Si se encuentra un problema, es posible revertir a una versión anterior utilizando los scripts de rollback.

4. **Rollback (Reversión de Migraciones)**:

   * En caso de error, algunas herramientas como Liquibase permiten definir scripts de rollback para deshacer los cambios.

   * Flyway no tiene soporte nativo para rollback, pero es posible crear scripts manuales para revertir migraciones específicas.

## Versionado de Entidades: Uso de @Version para manejo de concurrencia optimista.
El versionado de entidades mediante la anotación `@Version` en Hibernate es una técnica utilizada para gestionar la concurrencia optimista en aplicaciones que interactúan con bases de datos. La concurrencia optimista es una estrategia que permite a múltiples transacciones acceder y modificar datos simultáneamente sin bloquear recursos, pero asegurando que los cambios realizados no entren en conflicto.

### ¿Qué es la Concurrencia Optimista?
La concurrencia optimista asume que los conflictos entre transacciones son raros, por lo que no bloquea los recursos de manera preventiva. En lugar de bloquear, permite que múltiples transacciones lean y modifiquen los datos de forma concurrente. Sin embargo, antes de aplicar las modificaciones, verifica si los datos han cambiado desde que fueron leídos. Si detecta que han cambiado, la transacción se aborta para evitar la sobrescritura de datos.

### ¿Qué es la Anotación @Version?
La anotación @Version se utiliza en Hibernate para implementar la concurrencia optimista. Marca un campo en una entidad como la versión de la entidad. Este campo se actualiza automáticamente cada vez que se realiza un cambio en la entidad. Antes de aplicar una actualización en la base de datos, Hibernate verifica que el valor de la versión no haya cambiado desde que la entidad fue leída.

### Ejemplo de Uso de @Version
Supongamos que tenemos una entidad Product y queremos asegurarnos de que cuando dos usuarios intentan actualizar el mismo producto al mismo tiempo, no sobrescriban los cambios del otro.

```java
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Version
    private int version; // Campo de versión para manejo de concurrencia optimista

    // Getters y Setters
}
```
En este ejemplo, el campo version está marcado con `@Version`. Este campo puede ser de tipo **int**, **long**, **Timestamp**, o cualquier tipo de datos que pueda representarse como un número.

### ¿Cómo Funciona @Version?
1. **Lectura de la Entidad**:

   * Cuando una entidad se carga desde la base de datos, Hibernate también carga el valor del campo version.

2. **Modificación de la Entidad**:

   * Se realizan cambios en la entidad en la memoria (en la sesión de Hibernate).

3. **Actualización en la Base de Datos**:

   * Cuando se intenta persistir los cambios, Hibernate genera una sentencia SQL que incluye una verificación del valor de la versión.

   * La actualización solo se realiza si el valor de la versión en la base de datos coincide con el valor que Hibernate tiene en memoria.

      ```sql
      UPDATE product 
      SET name = ?, price = ?, version = version + 1 
      WHERE id = ? AND version = ?;
      ```
      * Si el valor de la versión no coincide, Hibernate lanzará una excepción `OptimisticLockException` o `StaleObjectStateException`, indicando que otro proceso ha modificado la entidad.