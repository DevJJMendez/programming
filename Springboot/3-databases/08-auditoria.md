## Hibernate Envers
Hibernate Envers es un módulo de Hibernate que facilita el versionado y auditoría de entidades en una base de datos. Con Envers, puedes realizar un seguimiento de los cambios en las entidades a lo largo del tiempo, lo que es útil para auditorías, restauración de datos a un estado anterior, y para mantener un historial detallado de todas las modificaciones.

### ¿Qué es Hibernate Envers?
Hibernate Envers proporciona un marco simple para el versionado y auditoría de entidades. Registra automáticamente cada cambio en una entidad persistente en una tabla de auditoría separada, permitiendo consultar versiones anteriores de la entidad y reconstruir su historial.

### ¿Cómo Funciona Hibernate Envers?
1. **Tablas de Auditoría**:

   * Cuando activas Envers, se crean tablas de auditoría adicionales para cada entidad que quieres versionar. Estas tablas almacenan el historial de las entidades, incluyendo las versiones anteriores de los datos.

   * Por ejemplo, si tienes una entidad Product, Envers creará una tabla de auditoría Product_AUD que contendrá todas las versiones de los productos con un identificador de versión y marcas de tiempo.

2. **Versionado de Entidades**:

   * Cada vez que se realiza una operación **insert**, **update**, o **delete** en una entidad, **Envers** crea una nueva entrada en la tabla de auditoría correspondiente. Esta entrada incluye el estado anterior de la entidad y la información sobre la operación realizada.

3. **Consultas de Versiones**:

   * **Envers** permite consultar versiones anteriores de una entidad. Puedes recuperar una entidad tal como era en un momento específico, o ver todas las versiones entre dos puntos en el tiempo.

### Configuración Básica de Hibernate Envers
1. **Dependencia en el POM (Maven)**
Para utilizar Hibernate Envers, primero debes incluir la dependencia en tu archivo pom.xml (si usas Maven):

    ```xml
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-envers</artifactId>
        <version>6.2.5.Final</version>
    </dependency>
    ```
    Asegúrate de usar la versión correcta según la versión de Hibernate que estés utilizando.

2. **Anotaciones de Auditoría**
Para habilitar el versionado en una entidad, simplemente agrega la anotación `@Audited` a la clase de la entidad.

```java
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    // Getters y Setters
}
```
Esto indicará a Envers que debe crear una tabla de auditoría para `Product` y registrar los cambios en la misma.

3. Configuración de `hibernate.cfg.xml` o `application.properties`
Generalmente, no necesitas una configuración adicional en el archivo `hibernate.cfg.xml` o `application.properties` más allá de asegurarte de que Envers esté presente en las dependencias del proyecto.

### Consultas y Recuperación de Datos con Envers
Una vez que has configurado y anotado tus entidades con `@Audited`, puedes usar la API de Envers para consultar las versiones anteriores de las entidades.

1. **Obtener una Entidad en un Momento Específico**
Puedes recuperar una versión específica de una entidad utilizando su ID y el número de versión.

    ```java
    AuditReader auditReader = AuditReaderFactory.get(entityManager);
    Product productVersion = auditReader.find(Product.class, productId, versionNumber);
    ```

2. **Obtener Todas las Versiones de una Entidad**
Puedes obtener todas las versiones de una entidad en orden cronológico:

    ```java
    List<Number> revisions = auditReader.getRevisions(Product.class, productId);
    for (Number revision : revisions) {
        Product productVersion = auditReader.find(Product.class, productId, revision);
        // Procesar cada versión de la entidad
    }
    ```

3. **Consultar Cambios entre Versiones**
**Envers** también permite comparar los cambios entre dos versiones de una entidad:

    ```java
    Product productOldVersion = auditReader.find(Product.class, productId, oldRevision);
    Product productNewVersion = auditReader.find(Product.class, productId, newRevision);

    // Comparar atributos entre productOldVersion y productNewVersion
    ```