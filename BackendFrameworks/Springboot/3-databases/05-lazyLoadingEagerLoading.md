## Fetch Types
El concepto de Fetch Types en JPA y Hibernate se refiere a la estrategia utilizada para cargar entidades relacionadas desde la base de datos. Esta configuración es crucial para optimizar el rendimiento de una aplicación, ya que determina cuándo y cómo se recuperan las relaciones entre entidades.

### Tipos de Fetch en JPA/Hibernate
JPA define dos tipos principales de carga (FetchType):

* `FetchType.EAGER`: Carga ansiosa o inmediata.

* `FetchType.LAZY`: Carga perezosa o diferida.

### FetchType.EAGER
Cuando se utiliza `FetchType.EAGER`, las entidades relacionadas se cargan **inmediatamente** junto con la entidad principal. Esto significa que tan pronto como la entidad principal es recuperada, todas las relaciones marcadas con `FetchType.EAGER` también se recuperan en la misma consulta.

`FetchType.EAGER` es útil cuando sabes que siempre necesitarás acceder a las entidades relacionadas junto con la entidad principal. Es ideal para relaciones donde el acceso a los datos relacionados es imprescindible para el funcionamiento de la aplicación.

**Ejemplo**
```java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
    private List<Pedido> pedidos;

    // Getters y Setters
}
```
En este caso, cada vez que se cargue un `Usuario`, sus `Pedidos` asociados se cargarán automáticamente.

* **Ventajas**:

  * **Simplicidad**: Las entidades relacionadas están siempre disponibles sin necesidad de llamadas adicionales.

  * **Consistencia**: Garantiza que todos los datos necesarios se carguen juntos, evitando la posibilidad de que algunas relaciones no estén presentes.

* **Desventajas**:

  * **Rendimiento**: Puede generar problemas de rendimiento, especialmente si la relación tiene un gran número de entidades relacionadas. La consulta resultante puede ser más compleja y costosa, tanto en términos de tiempo como de memoria.

  * **Sobrecarga**: Si no necesitas siempre las entidades relacionadas, estarás cargando datos innecesarios, lo que puede afectar la eficiencia.

### FetchType.LAZY
Con `FetchType.LAZY`, las entidades relacionadas no se cargan de inmediato. En lugar de eso, se cargan solo cuando se accede a ellas explícitamente. Esto se logra a través de un proxy que retrasa la carga hasta el momento del acceso.

`FetchType.LAZY` es la opción por defecto en relaciones `@OneToMany` y `@ManyToMany` y es útil cuando no siempre necesitas los datos relacionados. Es ideal para optimizar el rendimiento cuando es probable que solo necesites la entidad principal.

**Ejemplo**
```java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Pedido> pedidos;

    // Getters y Setters
}
```
En este caso, los `Pedidos` no se cargarán hasta que realmente se acceda a la colección de `pedidos`.

* **Ventajas**:

  * **Rendimiento**: Reduce la cantidad de datos cargados, lo que mejora el rendimiento cuando solo necesitas la entidad principal.

  * **Eficiencia**: Evita la carga de datos innecesarios, especialmente útil en relaciones con muchas entidades o cuando el acceso a los datos relacionados es infrecuente.

* **Desventajas**:

  * `LazyInitializationException`: Si intentas acceder a una entidad relacionada después de que la sesión de Hibernate se haya cerrado, se lanzará una `LazyInitializationException`. Esto ocurre porque la entidad relacionada no se cargó y la sesión ya no está disponible para hacerlo.

  * `Complejidad`: Puede requerir una gestión adicional, como asegurarte de que la sesión de Hibernate esté abierta cuando accedes a las entidades relacionadas.

## JOIN FETCH
`JOIN FETC`H es una poderosa funcionalidad de **JPQL (Java Persistence Query Language)** y **HQL (Hibernate Query Language)** que permite cargar entidades relacionadas en una sola consulta a la base de datos. Esto es especialmente útil para evitar el problema de **N+1 queries** cuando se usan asociaciones LAZY (perezosas) en JPA/Hibernate.

### Concepto de JOIN FETCH
En JPQL y HQL, cuando se hace una consulta con un JOIN normal, las entidades relacionadas pueden no ser cargadas inmediatamente si la asociación está configurada como `FetchType.LAZY`. En estos casos, Hibernate carga las entidades relacionadas solo cuando se accede a ellas, lo que puede llevar a múltiples consultas adicionales (una por cada entidad relacionada), lo que se conoce como el problema de **N+1 queries**.

Con `JOIN FETCH`, puedes forzar la carga de las entidades relacionadas junto con la entidad principal en una única consulta SQL. Esto es útil para optimizar el rendimiento y reducir el número de consultas necesarias para cargar los datos.

### Ejemplo Básico de JOIN FETCH
Supongamos que tienes dos entidades: `Usuario` y `Pedido` con una relación `@OneToMany`. La relación está configurada como `LAZY`, por lo que los `Pedidos` no se cargarán automáticamente cuando recuperes un `Usuario`.

```java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    // Getters y Setters
}

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters y Setters
}
```
### Consulta con JOIN FETCH
Si quieres recuperar un `Usuario` con todos sus `Pedidos` en una sola consulta, puedes usar **JOIN FETCH**:

```java
String jpql = "SELECT u FROM Usuario u JOIN FETCH u.pedidos WHERE u.id = :id";
Usuario usuario = entityManager.createQuery(jpql, Usuario.class)
                               .setParameter("id", 1L)
                               .getSingleResult();
```

### ¿Qué Hace JOIN FETCH?
* **Consulta Normal con `JOIN`**: Si usas un JOIN estándar, Hibernate recuperará la entidad principal (Usuario), pero los Pedidos se cargarán en una consulta separada cuando accedas a la colección.

```java
String jpql = "SELECT u FROM Usuario u JOIN u.pedidos WHERE u.id = :id";
Usuario usuario = entityManager.createQuery(jpql, Usuario.class)
                               .setParameter("id", 1L)
                               .getSingleResult();
// Aquí se lanzaría una segunda consulta cuando accedes a `usuario.getPedidos()`.
List<Pedido> pedidos = usuario.getPedidos();
```

* **Consulta con `JOIN FETCH`**: Con `JOIN FETCH`, Hibernate genera una única consulta que carga tanto el `Usuario` como sus `Pedidos` asociados, evitando el problema de **N+1 queries**.

### Ventajas de JOIN FETCH
* **Optimización de Consultas**: Carga las entidades relacionadas en una sola consulta SQL, lo que puede mejorar significativamente el rendimiento de la aplicación, especialmente cuando trabajas con relaciones complejas y datos voluminosos.

* **Evita N+1 Queries**: Elimina el problema de N+1 queries al garantizar que todas las entidades necesarias se cargan de una vez.

* **Control Fino sobre la Carga**: Te permite elegir explícitamente cuándo cargar las entidades relacionadas, independientemente de la configuración de FetchType en las anotaciones.

### Consideraciones de Uso
Duplicación de Resultados: Cuando usas **JOIN FETCH**, la consulta resultante podría devolver filas duplicadas si estás utilizando una relación `@OneToMany` o `@ManyToMany`. Esto se debe a que cada combinación de la entidad principal con una entidad relacionada aparece como una fila separada en el resultado. Para evitarlo, puedes utilizar **DISTINCT** en tu consulta JPQL:

```java
String jpql = "SELECT DISTINCT u FROM Usuario u JOIN FETCH u.pedidos WHERE u.id = :id";
Usuario usuario = entityManager.createQuery(jpql, Usuario.class)
                               .setParameter("id", 1L)
                               .getSingleResult();
```

* **Limitaciones con `@OneToMany` y `@ManyToMany`**: Debido a las características de las relaciones de muchos, debes tener cuidado al usar JOIN FETCH en combinaciones con paginación (**LIMIT**, **OFFSET**). La combinación puede no funcionar como se espera debido a la forma en que SQL trata las relaciones de muchos a muchos y la duplicación de filas.

* **Uso Responsable**: Aunque **JOIN FETCH** es una herramienta poderosa, abusar de ella puede llevar a consultas extremadamente grandes y complicadas, lo que podría impactar negativamente el rendimiento de la base de datos. Es importante usarlo solo cuando realmente necesitas cargar todas las entidades relacionadas.