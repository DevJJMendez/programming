# `spring.jpa` `spring.jpa.hibernate`
Las configuraciones de spring.jpa y spring.jpa.hibernate en Spring Boot se utilizan para controlar cómo se gestionan las entidades y las operaciones de JPA y Hibernate en una aplicación. Estas propiedades permiten definir el comportamiento de la persistencia, el mapeo, la generación de esquemas y más, lo que ayuda a optimizar el rendimiento y la consistencia de la base de datos en la aplicación.

## Configuración de `spring.jpa`
### 1. Configuraciones Básicas
* `spring.jpa.database`: Especifica el tipo de base de datos que se está utilizando. Ayuda a Hibernate a elegir el dialecto adecuado. Los valores comunes incluyen mysql, postgresql, oracle, h2, etc.
```properties
spring.jpa.database=mysql
```

* `spring.jpa.database-platform`: Especifica el dialecto de la base de datos de Hibernate directamente (por ejemplo, org.hibernate.dialect.MySQLDialect). Esto puede ser útil si se necesita un dialecto específico.
```properties
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

* `spring.jpa.show-sql`: Si está habilitado (`true`), Hibernate imprimirá en el registro las consultas SQL ejecutadas, útil en entornos de desarrollo.
```properties
spring.jpa.show-sql=true
```

* `spring.jpa.generate-ddl`: Define si JPA debe generar el esquema de la base de datos al inicio. Esto es útil para entornos de prueba y desarrollo, pero generalmente no se usa en producción.
```properties
spring.jpa.generate-ddl=true
```

* `spring.jpa.hibernate.ddl-auto`: Controla la estrategia de generación de esquemas en Hibernate. Los valores comunes son:
  * `none`: no se generará ni validará el esquema.

  * `validate`: valida el esquema existente contra las entidades.

  * `update`: actualiza el esquema según las entidades.

  * `create`: crea el esquema cada vez que se inicia la aplicación.

  * `create-drop`: crea el esquema al inicio y lo elimina al cerrar.
```properties
spring.jpa.hibernate.ddl-auto=update
```

### 2. Configuración de Transacciones
* `spring.jpa.open-in-view`: Controla el patrón "**Open Session in View**", que mantiene la sesión abierta durante la visualización en aplicaciones web. Por defecto, está en `true`, pero se recomienda cambiarlo a `false` para evitar problemas de rendimiento.
```properties
spring.jpa.open-in-view=false
```

### 3. Configuración de Propiedades de JPA
* `spring.jpa.properties.*`: Permite definir propiedades adicionales de JPA que se pueden pasar directamente a la implementación subyacente, como Hibernate. Por ejemplo, para habilitar el modo de consulta por lotes (**`batching`**):
```properties
spring.jpa.properties.hibernate.jdbc.batch_size=10
```

* `spring.jpa.properties.hibernate.format_sql`: Si está habilitado (`true`), formatea la salida SQL para facilitar su lectura.

### Ejemplo Completo de Configuración de spring.jpa
```properties
# Configuración básica
spring.jpa.database=mysql
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false

# Configuraciones adicionales de JPA
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.batch_size=10
```

## Configuraciones de spring.jpa.hibernate
Estas propiedades adicionales específicas de Hibernate controlan aspectos avanzados de la generación de esquemas, la configuración de caché, las estrategias de acceso y más.

### 1. onfiguración de Caché
Hibernate admite caché de segundo nivel y caché de consultas para mejorar el rendimiento de la aplicación al almacenar en caché las consultas y los resultados de entidades.

* `spring.jpa.properties.hibernate.cache.use_second_level_cache`: Habilita o deshabilita la caché de segundo nivel.

* `spring.jpa.properties.hibernate.cache.region.factory_class`: Especifica el proveedor de caché de segundo nivel, como org.hibernate.cache.jcache.JCacheRegionFactory.

* `spring.jpa.properties.hibernate.cache.use_query_cache`: Habilita el uso de caché para consultas.
```properties
spring.jpa.properties.hibernate.cache.use_second_level_cache=true
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
spring.jpa.properties.hibernate.cache.use_query_cache=true
```

### 2. Configuración de Batch Processing
Para optimizar el rendimiento, Hibernate permite agrupar operaciones en lotes.

* `spring.jpa.properties.hibernate.jdbc.batch_size`: Define el tamaño del lote.

* `spring.jpa.properties.hibernate.order_inserts` y `spring.jpa.properties.hibernate.order_updates`: Ordenan las inserciones y actualizaciones para mejorar la eficiencia.
```properties
spring.jpa.properties.hibernate.jdbc.batch_size=50
spring.jpa.properties.hibernate.order_inserts=true
spring.jpa.properties.hibernate.order_updates=true
```

### 3. Estrategia de Fetching (Carga de Datos)
La estrategia de "fetching" determina cómo se cargan las asociaciones (relaciones entre entidades).

* `spring.jpa.properties.hibernate.default_batch_fetch_size`: Define el tamaño de la carga de lotes para relaciones.
```properties
spring.jpa.properties.hibernate.default_batch_fetch_size=16
```

### Otras Propiedades Útiles de Hibernate
* `spring.jpa.properties.hibernate.format_sql`: Formatea las consultas SQL para facilitar su lectura.

* `spring.jpa.properties.hibernate.use_sql_comments`: Agrega comentarios al SQL generado para facilitar la depuración.

* `spring.jpa.properties.hibernate.show_sql`: Muestra las consultas SQL en la consola.

* `spring.jpa.properties.hibernate.generate_statistics`: Habilita la generación de estadísticas de Hibernate para optimizar consultas y transacciones.
```properties
spring.jpa.properties.hibernate.generate_statistics=true
```

### Ejemplo Completo de Configuración de spring.jpa y spring.jpa.hibernate
```properties
# Configuraciones básicas de JPA
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Configuraciones avanzadas de Hibernate
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.generate_statistics=true

# Configuración de batch processing para optimización
spring.jpa.properties.hibernate.jdbc.batch_size=20
spring.jpa.properties.hibernate.order_inserts=true
spring.jpa.properties.hibernate.order_updates=true

# Configuración de caché de segundo nivel
spring.jpa.properties.hibernate.cache.use_second_level_cache=true
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.jcache.JCacheRegionFactory
spring.jpa.properties.hibernate.cache.use_query_cache=true

# Configuración de carga en lotes para asociaciones
spring.jpa.properties.hibernate.default_batch_fetch_size=10
```