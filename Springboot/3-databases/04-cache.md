## Cache
El manejo de caché en Hibernate es un aspecto fundamental para optimizar el rendimiento de las aplicaciones, reduciendo la necesidad de acceder a la base de datos para obtener información que ya ha sido cargada previamente. Hibernate soporta múltiples niveles de caché y proporciona mecanismos para gestionar cómo y cuándo los datos se almacenan y se recuperan desde el caché.

### Estrategias de Concurrencia para Caché
Cuando se utiliza el caché de segundo nivel, es importante definir una estrategia de concurrencia adecuada para manejar el acceso concurrente a los datos cacheados:

* **READ_ONLY**: Para datos que no cambian (como tablas estáticas), permite múltiples lecturas sin bloqueo.

* **NONSTRICT_READ_WRITE**: Para datos que cambian raramente, no garantiza la sincronización perfecta con la base de datos.

* **READ_WRITE**: Para datos que cambian y necesitan coherencia entre la caché y la base de datos. Implementa un bloqueo suave.

* **TRANSACTIONAL**: Para entornos de clúster donde se requiere coherencia estricta. Se sincroniza con las transacciones JTA.

### Consideraciones de Uso del Caché
* **Coherencia de Datos**: Al usar caché de segundo nivel, debes considerar la posibilidad de que los datos en caché no estén completamente sincronizados con la base de datos, especialmente si se utilizan estrategias de concurrencia como NONSTRICT_READ_WRITE.

* **Invalidez de Caché**: Cuando una entidad es actualizada o eliminada, las entradas correspondientes en el caché deben ser invalidadas para mantener la coherencia de los datos.

* **Tamaño del Caché**: Configurar el tamaño adecuado del caché es crucial para evitar el uso excesivo de memoria y para asegurarse de que las entradas más importantes se mantengan en caché.

* `Evict` y `Clear`: Hibernate proporciona métodos para controlar manualmente la limpieza del caché.

  * `session.evict(entity)` elimina una entidad específica del caché de primer nivel.

  * `session.clear()` elimina todas las entidades del caché de primer nivel para esa sesión.

* **Uso de Estadísticas**: Hibernate permite monitorear el rendimiento del caché mediante la API de estadísticas (Statistics), lo que ayuda a optimizar el uso del caché.

## Cache en Primer Nivel
El Caché de Primer Nivel (First-Level Cache) en Hibernate es un mecanismo fundamental que está integrado directamente en la sesión de Hibernate (Session). Este tipo de caché es exclusivo de la sesión y tiene como objetivo mejorar el rendimiento al evitar que Hibernate realice múltiples consultas a la base de datos para las mismas entidades durante una única sesión.

### Conceptos Clave del Caché de Primer Nivel
1. **Naturaleza de la Caché de Primer Nivel**:

   * **Alcance de la Caché**: El caché de primer nivel está ligado a la sesión de Hibernate (Session). Esto significa que cada instancia de Session tiene su propio caché de primer nivel, y este caché es válido únicamente durante la vida de esa sesión.

   * **Automático y Obligatorio**: Este caché está siempre habilitado y no se puede desactivar. Hibernate utiliza el caché de primer nivel de manera interna para gestionar la sesión y optimizar las interacciones con la base de datos.

   * **Transparencia**: Para el desarrollador, el uso del caché de primer nivel es transparente. Hibernate gestiona automáticamente el almacenamiento y la recuperación de entidades desde el caché.

2. **Comportamiento de la Caché de Primer Nivel**:

   * **Almacenamiento de Entidades**: Cuando una entidad es cargada desde la base de datos mediante una operación como `session.get()` o `session.load()`, Hibernate almacena esa entidad en el caché de primer nivel. Si una operación posterior en la misma sesión intenta acceder a la misma entidad (por su ID), Hibernate la recupera desde el caché en lugar de hacer una nueva consulta a la base de datos.

   * **Identidad de Entidades**: Dentro de la misma sesión, Hibernate garantiza que cualquier acceso a la misma entidad (misma clase y mismo identificador) devolverá la misma instancia de la entidad. Esto asegura la coherencia de datos dentro de la sesión.

### Uso del Caché de Primer Nivel dentro de una Session
1. **Carga y Recuperación de Entidades**:

   * Cuando se carga una entidad desde la base de datos por primera vez:

      ```java
      Session session = sessionFactory.openSession();
      Empleado empleado1 = session.get(Empleado.class, 1); // Carga de la base de datos
      ```
      Hibernate ejecuta una consulta SQL y almacena la entidad en el caché de primer nivel.

   * Al intentar cargar la misma entidad nuevamente dentro de la misma sesión:
      ```java
      Empleado empleado2 = session.get(Empleado.class, 1); // Carga desde el caché de primer nivel
      ```
      Hibernate recupera la entidad del caché, evitando otra consulta a la base de datos.

2. **Actualizar y Sincronizar Entidades**:

   * Si una entidad se modifica dentro de la sesión, el caché de primer nivel mantiene la versión modificada de la entidad hasta que se confirma la transacción (**flush**).

      ```java
      empleado1.setNombre("Nuevo Nombre");
      session.update(empleado1); // Actualiza la entidad en el caché de primer nivel
      ```
   *  Cuando se realiza un `flush`, las modificaciones en el caché de primer nivel se sincronizan con la base de datos:

      ```java
      session.flush(); // Las actualizaciones se envían a la base de datos
      ```

3. **Evicción y Limpieza del Caché**:

   * Es posible controlar manualmente el contenido del caché de primer nivel usando los métodos `evict()` y `clear()`:

     * `session.evict(entity)` elimina una entidad específica del caché de primer nivel.

         ```java
         session.evict(empleado1); // Elimina 'empleado1' del caché de primer nivel
         ```

     * `session.clear()` elimina todas las entidades del caché de primer nivel.

         ```java
         session.clear(); // Elimina todas las entidades del caché de primer nivel
         ```
         Estos métodos son útiles cuando se desea liberar memoria o forzar que una entidad sea recargada desde la base de datos.

4. **Cierre de la Sesión**:

   * Cuando se cierra una sesión (`session.close()`), el caché de primer nivel asociado a esa sesión se destruye. Ninguna entidad almacenada en el caché se mantiene más allá del ciclo de vida de la sesión.

      ```java
      session.close(); // Destruye la sesión y el caché de primer nivel
      ```

## Caché en Segundo Nivel
El Caché de Segundo Nivel en Hibernate es una extensión del caché de primer nivel que permite almacenar entidades y colecciones en un caché compartido entre múltiples sesiones (**Session**). A diferencia del caché de primer nivel, que es específico de una sesión y dura solo durante su ciclo de vida, el caché de segundo nivel es específico de la **SessionFactory** y puede persistir más allá del ciclo de vida de una sola sesión. Esto permite reducir aún más las consultas a la base de datos y mejorar el rendimiento de la aplicación.

### Conceptos Clave del Caché de Segundo Nivel
1. **Alcance y Propósito**:

   * **Alcance Global**: El caché de segundo nivel es compartido por todas las sesiones creadas por una **SessionFactory**.

   * **Propósito**: Almacenar datos que son frecuentemente accedidos y no cambian con frecuencia, como datos de referencia, configuraciones o tablas maestras.

2. **Proveedores de Caché**:

   * Hibernate no implementa su propio caché de segundo nivel, sino que se integra con diferentes proveedores de caché como **EHCache**, **Infinispan**, **Hazelcast**, entre otros.

   * Cada proveedor tiene sus propias características, configuraciones y capacidades, como el soporte para caché distribuido, replicación y persistencia en disco.

3. **Estrategias de Concurrencia**:

   * **READ_ONLY**: Para datos que no cambian.

   * **NONSTRICT_READ_WRITE**: Permite algunas inconsistencias y es útil para datos que cambian raramente.

   * **READ_WRITE**: Usa bloqueos suaves para mantener la coherencia.

   * **TRANSACTIONAL**: Para datos que requieren coherencia estricta en entornos distribuidos.

### Configuración del Caché de Segundo Nivel
Para utilizar el caché de segundo nivel en Hibernate, es necesario configurarlo en la configuración de Hibernate (`hibernate.cfg.xml` o `application.properties`) y en las entidades que se desean cachear.

### **Paso 1: Configuración General de Hibernate**
Dependiendo del proveedor de caché que elijas, las propiedades de configuración variarán ligeramente.

Ejemplo de **EHCache**

1. **Dependencia Maven**

      ```xml
      <dependency>
         <groupId>org.hibernate.orm</groupId>
         <artifactId>hibernate-ehcache</artifactId>
         <version>5.6.10.Final</version>
      </dependency>
      ```
2. **Configuración en `hibernate.cfg.xml`**:

      ```xml
      <property name="hibernate.cache.use_second_level_cache">true</property>
      <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
      <property name="hibernate.cache.use_query_cache">true</property>
      ```

3. **Archivo de configuración de EHCache (`ehcache.xml`)**:

      ```xml
      <ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:noNamespaceSchemaLocation="ehcache.xsd"
               updateCheck="false"
               monitoring="autodetect"
               dynamicConfig="true">

         <cache name="com.example.Empleado"
               maxEntriesLocalHeap="1000"
               timeToLiveSeconds="120">
         </cache>
      </ehcache>
      ```

Ejemplo de **Infinispan**

1. Dependencia Maven:

      ```xml
      <dependency>
         <groupId>org.infinispan</groupId>
         <artifactId>infinispan-hibernate-cache</artifactId>
         <version>13.0.0.Final</version>
      </dependency>
      ```

2. Configuración en hibernate.cfg.xml:

      ```xml
      <property name="hibernate.cache.use_second_level_cache">true</property>
      <property name="hibernate.cache.region.factory_class">org.hibernate.cache.infinispan.InfinispanRegionFactory</property>
      <property name="hibernate.cache.infinispan.cfg">infinispan-config.xml</property>
      <property name="hibernate.cache.use_query_cache">true</property>
      ```

3. Archivo de configuración de Infinispan (infinispan-config.xml):

      ```xml
      <infinispan>
         <cache-container name="hibernate" default-cache="local-query">
            <local-cache name="entity">
                  <expiration lifespan="60000"/>
            </local-cache>
         </cache-container>
      </infinispan>
      ```

### **Paso 2: Configuración de las Entidades**
Para que una entidad sea cacheada en el caché de segundo nivel, debes anotar la clase de entidad con `@Cacheable` y `@Cache`:

```java
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Empleado {
    @Id
    private Integer id;
    
    private String nombre;
    
    // Otros campos, getters y setters
}
```

### Uso del Caché de Segundo Nivel
1. **Recuperación desde el Caché**:

   * Cuando una entidad marcada como cacheable es cargada, Hibernate primero verifica si está en el caché de segundo nivel. Si está disponible, se recupera desde allí; si no, se carga desde la base de datos y se almacena en el caché de segundo nivel para futuras solicitudes.

2. **Actualización y Sincronización**:

   * Las actualizaciones a entidades cacheadas se reflejan en el caché de segundo nivel según la estrategia de concurrencia elegida (READ_ONLY, NONSTRICT_READ_WRITE, READ_WRITE, TRANSACTIONAL).

3. **Invalidación del Caché**:

   * Cuando una entidad se actualiza o elimina, la entrada correspondiente en el caché de segundo nivel se invalida para evitar inconsistencias entre el caché y la base de datos.

## Caché de Consultas: Caché de resultados de consultas.
El Caché de Consultas en Hibernate se utiliza para almacenar los resultados de consultas, lo que permite que Hibernate evite ejecutar la misma consulta repetidamente contra la base de datos cuando los datos subyacentes no han cambiado. Esto es particularmente útil en aplicaciones donde se realizan muchas consultas que devuelven los mismos resultados, como en sistemas de informes o en la generación de vistas que se actualizan con poca frecuencia.

### Conceptos Clave del Caché de Consultas
1. **Naturaleza del Caché de Consultas**:

   * **Alcance**: El caché de consultas es independiente del caché de primer y segundo nivel. Mientras que el caché de segundo nivel almacena entidades individuales, el caché de consultas almacena el conjunto de resultados de las consultas HQL (Hibernate Query Language) o Criteria.

   * **Composición**: El caché de consultas almacena el ID de las entidades y sus estados de parámetros, no los objetos en sí. Cuando se accede a los resultados cacheados, Hibernate consulta el caché de segundo nivel para recuperar las entidades asociadas.

2. **Condiciones para Cachear Consultas**:

   * Las consultas deben ser marcadas explícitamente como cacheables.

   * Los resultados solo se cachean si todas las entidades involucradas en la consulta son cacheables.

3. **Sincronización**:

   * El caché de consultas es invalidado o actualizado automáticamente cuando se detecta que los datos subyacentes en la base de datos han cambiado, manteniendo la coherencia entre los datos cacheados y los datos en la base de datos.

### Configuración del Caché de Consultas
Para utilizar el caché de consultas en Hibernate, es necesario realizar algunas configuraciones en el archivo de configuración de Hibernate y en el código donde se ejecutan las consultas.

* **Paso 1: Configuración General de Hibernate**: Debes asegurarte de que el caché de segundo nivel esté habilitado, ya que el caché de consultas depende de él.

Ejemplo de Configuración en `hibernate.cfg.xml`:
```xml
<property name="hibernate.cache.use_second_level_cache">true</property>
<property name="hibernate.cache.use_query_cache">true</property>
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
```
Si estás usando `application.properties` o `application.yml` en una aplicación Spring Boot:
```properties
spring.jpa.properties.hibernate.cache.use_second_level_cache=true
spring.jpa.properties.hibernate.cache.use_query_cache=true
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
```

* **Paso 2: Configuración del Proveedor de Caché**

Como con el caché de segundo nivel, necesitas configurar un proveedor de caché (por ejemplo, EHCache o Infinispan) para el caché de consultas.

Ejemplo de Configuración de EHCache (`ehcache.xml`):
```xml
<cache name="hibernate.query.cache"
       maxEntriesLocalHeap="1000"
       timeToLiveSeconds="300">
</cache>
```

* **Paso 3: Marcar Consultas como Cacheables**: Debes marcar explícitamente las consultas como cacheables en tu código:

1. En HQL/JPQL:
```java
Query query = session.createQuery("FROM Empleado WHERE departamento = :dept");
query.setParameter("dept", "Ventas");
query.setCacheable(true);  // Marca la consulta como cacheable
List<Empleado> empleados = query.list();
```

2. En Criteria:
```java
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Empleado> criteria = builder.createQuery(Empleado.class);
Root<Empleado> root = criteria.from(Empleado.class);
criteria.select(root).where(builder.equal(root.get("departamento"), "Ventas"));

Query<Empleado> query = session.createQuery(criteria);
query.setCacheable(true);  // Marca la consulta como cacheable
List<Empleado> empleados = query.getResultList();
```

3. En Named Queries:
```java
@NamedQuery(name = "Empleado.findByDepartamento", 
            query = "FROM Empleado WHERE departamento = :dept", 
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") })
```

### Uso del Caché de Consultas
1. **Almacenamiento de Resultados**:

   * Cuando una consulta cacheable se ejecuta por primera vez, Hibernate guarda el conjunto de resultados (IDs de entidades) en el caché de consultas.
En ejecuciones subsecuentes, si la misma consulta se ejecuta con los mismos parámetros, Hibernate recupera los IDs de las entidades desde el caché y luego obtiene las entidades completas desde el caché de segundo nivel.

2. **Invalidación Automática**:

   * Si una entidad cacheada involucrada en una consulta es modificada (insertada, actualizada, eliminada), Hibernate invalidará automáticamente las entradas correspondientes en el caché de consultas.

3. **Ámbito del Caché**:

   * El caché de consultas se puede utilizar para cachear resultados de consultas que son caras de ejecutar, especialmente en escenarios de paginación o donde se esperan múltiples accesos a los mismos datos.