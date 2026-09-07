## Crear bases de datos con JPA
Crear bases de datos utilizando **JPA (Java Persistence API)** se realiza típicamente en conjunto con un framework ORM como **Hibernate**, y un entorno de configuración como Spring Boot. En un entorno típico de Spring Boot, puedes configurar tu aplicación para que cree automáticamente la base de datos y las tablas necesarias a partir de tus entidades **JPA**.

1. **Configuración del Archivo `application.properties`**

El archivo `application.properties` (o `application.yml` si prefieres YAML) se utiliza para configurar la conexión a la base de datos y la estrategia de generación del esquema de la base de datos.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mi_base_de_datos?createDatabaseIfNotExist=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Estrategia de generación del esquema de la base de datos
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### Estrategia de Generación del Esquema
El valor de `spring.jpa.hibernate.ddl-auto` determina cómo Hibernate gestiona el esquema de la base de datos:

* `none`

  * No se realiza ninguna acción en el esquema de la base de datos.
  
  * **Uso**: Cuando quieres gestionar completamente el esquema de la base de datos manualmente o a través de herramientas externas de gestión de bases de datos.

    ```properties
    spring.jpa.hibernate.ddl-auto=none
    ```

* `validate`

  * Valida el esquema de la base de datos contra las entidades mapeadas. No realiza ningún cambio en la base de datos.

  * **Uso**: Para asegurarte de que el esquema de la base de datos es compatible con las entidades antes de iniciar la aplicación.

    ```properties
    spring.jpa.hibernate.ddl-auto=validate
    ```

* `update`
  
  * Actualiza el esquema de la base de datos para que coincida con las entidades mapeadas. No elimina datos existentes.

  * **Uso**: Durante el desarrollo para aplicar cambios incrementales en el esquema sin perder datos.

* `create`

  * Crea el esquema de la base de datos en cada inicio de la aplicación, eliminando los datos existentes y creando nuevamente todas las tablas.

  * **Uso**: Durante el desarrollo inicial o en entornos de prueba donde los datos pueden ser recreados cada vez que la aplicación se inicia.

* `create-drop`

  * Similar a create, pero además elimina el esquema cuando la sesión de la fábrica de sesiones de Hibernate se cierra.

  * **Uso**: Útil en entornos de prueba donde necesitas limpiar la base de datos al final de la ejecución de la aplicación.

* `drop`
  
  * Elimina el esquema de la base de datos. No es comúnmente usado solo.

  * **Uso**: En casos específicos donde necesitas asegurarte de que la base de datos se elimina, aunque generalmente se usa en combinación con otras estrategias.

#### Consideraciones

* **Entorno de Desarrollo**: `create`, `create-drop` y `update` son útiles para el desarrollo y pruebas, pero deben usarse con precaución en producción.

* **Entorno de Producción**: `validate` o `none` son más apropiados en producción. Para gestionar cambios en el esquema de manera controlada, se recomienda el uso de herramientas de migración de bases de datos como `Flyway` o `Liquibase`.

* **Pérdida de Datos**: `create` y `create-drop` eliminarán los datos existentes cada vez que se reinicie la aplicación, por lo que deben evitarse en entornos donde los datos son importantes.

* **Herramientas de Migración**: En un entorno profesional, se recomienda utilizar herramientas de migración para manejar los cambios en el esquema de manera segura y auditable.

## Logging SQL

```properties
# Reduce logging level
logging.level.root=warn

# Configura el logger para las consultas SQL
logging.level.org.hibernate.SQL=DEBUG

## Add logging configs to display SQL Statements
logging.level.org.hibernate.orm.jdbc.bind=trace

# Configura el logger para los parámetros de las consultas SQL
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Habilita el registro de SQL
spring.jpa.show-sql=true

# Habilita el formato bonito de las consultas SQL
spring.jpa.properties.hibernate.format_sql=true

# Habilita el registro de estadísticas y otras operaciones detalladas
spring.jpa.properties.hibernate.generate_statistics=true
```
### Explicación de las Propiedades

* `spring.jpa.show-sql=true`: Habilita la visualización de las consultas SQL en la consola.

* `spring.jpa.properties.hibernate.format_sql=true`: Formatea las consultas SQL para que sean más legibles.

* `spring.jpa.properties.hibernate.generate_statistics=true`: Habilita la generación de estadísticas detalladas de Hibernate, lo cual puede ser útil para el análisis de rendimiento.

* `logging.level.org.hibernate.SQL=DEBUG`: Configura el nivel de logging de las consultas **SQL** a **DEBUG** para asegurarse de que se registren.

* `logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE`: Configura el nivel de logging para los parámetros de las consultas **SQL** a **TRACE** para registrar los valores de los parámetros.