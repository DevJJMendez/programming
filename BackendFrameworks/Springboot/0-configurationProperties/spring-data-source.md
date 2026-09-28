# `spring.datasource`
La configuración de spring.datasource en Spring Boot es fundamental para gestionar las conexiones de base de datos. Define las propiedades necesarias para conectarse y configurar el comportamiento de la conexión con la base de datos, como el tipo de base de datos, la URL de conexión, el usuario, la contraseña, el pool de conexiones, y más.

## Configuraciones Principales de spring.datasource
### 1. Datos Básicos de la Conexión
* **`spring.datasource.url`**: Define la URL de conexión a la base de datos.

* **`spring.datasource.username`**: Nombre de usuario para la conexión a la base de datos.

* **`spring.datasource.password`**: Contraseña del usuario de la base de datos.

* **`spring.datasource.driver-class-name`**: Clase del driver JDBC. En la mayoría de los casos, Spring Boot la detecta automáticamente, pero en algunos casos puede ser útil especificarla.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=host
spring.datasource.password=yourPassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Configuración del Pool de Conexiones
Spring Boot admite múltiples proveedores de pools de conexiones (como HikariCP, Tomcat, y DBCP), y selecciona automáticamente HikariCP como la opción predeterminada por su alto rendimiento y bajo consumo de recursos.

* `spring.datasource.hikari.*`: Configuraciones específicas para HikariCP, el proveedor predeterminado de Spring Boot.

* `spring.datasource.hikari.maximum-pool-size`: Número máximo de conexiones en el pool.

* `spring.datasource.hikari.minimum-idle`: Número mínimo de conexiones inactivas que se mantendrán en el pool.

* `spring.datasource.hikari.connection-timeout`: Tiempo máximo de espera para obtener una conexión, en milisegundos.

* `spring.datasource.hikari.idle-timeout`: Tiempo máximo que una conexión inactiva puede permanecer en el pool antes de ser eliminada.

* `spring.datasource.hikari.max-lifetime`: Tiempo máximo de vida de una conexión, independientemente de su estado.

### Configuraciones Generales de Pool de Conexiones
Si estás utilizando otro proveedor de pool de conexiones (como Tomcat o DBCP), puedes especificar configuraciones generales.

* `spring.datasource.initialization-mode`: Controla si la base de datos debe inicializarse con scripts al inicio. Los valores posibles son `always`, `embedded` o `never`.
```properties
spring.datasource.initialization-mode=always
```

* `spring.datasource.max-active`: Número máximo de conexiones activas en el pool (solo para Tomcat).

* `spring.datasource.max-idle`: Número máximo de conexiones inactivas (solo para Tomcat).

* `spring.datasource.min-idle`: Número mínimo de conexiones inactivas (solo para Tomcat).

### Configuración de Inicialización de la Base de Datos
Estas propiedades controlan los scripts que se ejecutarán para inicializar la base de datos.

* `spring.datasource.schema`: Especifica uno o más scripts de esquema SQL que se ejecutarán al iniciar.
```properties
spring.datasource.schema=classpath:schema.sql
```

* `spring.datasource.data`: Define scripts de datos SQL para poblar la base de datos.
```properties
spring.datasource.data=classpath:data.sql
```

* `spring.datasource.continue-on-error`: Define si Spring Boot debe continuar con los scripts de inicialización en caso de error (valor true o false).

* `spring.datasource.sql-script-encoding`: Define la codificación de los archivos SQL.

### Configuración de Transacciones
* `spring.datasource.isolation-level`: Establece el nivel de aislamiento de transacciones (valores como `READ_COMMITTED`, `READ_UNCOMMITTED`, `REPEATABLE_READ`, `SERIALIZABLE`).

* `spring.datasource.enable-auto-commit`: Si las transacciones deben confirmarse automáticamente (`true` o `false`).

### Otros Parámetros Útiles
* `spring.datasource.jndi-name`: Nombre **`JNDI`** para definir la fuente de datos desde el servidor de aplicaciones en lugar de una conexión directa.
```properties
spring.datasource.jndi-name=java:comp/env/jdbc/MyDataSource
```

* `spring.datasource.connection-properties`: Propiedades adicionales específicas para el driver de la base de datos.

## Ejemplo Completo de application.properties para Configuración de Base de Datos
```properties
# Configuración básica de la conexión
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración del pool de conexiones con HikariCP
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000
spring.datasource.hikari.max-lifetime=1800000

# Inicialización de la base de datos
spring.datasource.initialization-mode=always
spring.datasource.schema=classpath:schema.sql
spring.datasource.data=classpath:data.sql
spring.datasource.continue-on-error=false

# Propiedades de transacción
spring.datasource.isolation-level=READ_COMMITTED
spring.datasource.enable-auto-commit=false
```

### Consideraciones Importantes
* **Pool de Conexiones**: HikariCP es la opción predeterminada y es altamente eficiente, por lo que se recomienda para la mayoría de los casos. Si prefieres otro pool, puedes cambiarlo y configurarlo con las propiedades adecuadas.

* **Inicialización de Base de Datos**: Útil en entornos de desarrollo, pero es mejor desactivarla o controlarla cuidadosamente en entornos de producción.

* **Auto-Commit**: Desactivarlo permite que el código gestione explícitamente el ciclo de vida de las transacciones, lo que es ideal para garantizar la consistencia en bases de datos.