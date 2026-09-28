# `application.properties`
Es un archivo de configuración clave en Spring Boot que permite definir configuraciones específicas para la aplicación. Este archivo es el punto central para definir propiedades de entorno, configuraciones de bases de datos, puertos de servidor, nivel de logging, entre otros.

## ¿Qué es?
`application.properties` es el archivo de configuración predeterminado que Spring Boot lee cuando se inicia una aplicación. Este archivo permite establecer configuraciones de entorno y comportamientos para la aplicación de una manera centralizada, fácil de modificar y mantener.

## ¿Para qué sirve?
El archivo application.properties sirve para:

* **Configurar propiedades** de la aplicación de Spring Boot, como el puerto del servidor, las credenciales de la base de datos, el comportamiento de las transacciones, el nivel de logging, entre otros.

* **Controlar el entorno** en el que se ejecuta la aplicación (por ejemplo, desarrollo, pruebas, producción), lo que permite crear perfiles para cada ambiente y cargar configuraciones específicas.

* **Facilitar la personalización** de comportamientos sin necesidad de modificar el código fuente directamente.

## ¿Qué problema resuelve?
application.properties ayuda a centralizar la configuración de una aplicación, permitiendo:

* **Separar la configuración del código**: Facilita cambiar parámetros de la aplicación sin tener que modificar el código, lo que contribuye a un despliegue más seguro y ágil.

* **Simplificar el mantenimiento**: Facilita el mantenimiento y la actualización de la configuración, ya que todas las propiedades se encuentran en un solo archivo.

* **Adaptarse a entornos**: Permite definir propiedades específicas para cada entorno (desarrollo, pruebas, producción), lo que minimiza el riesgo de problemas de configuración en el despliegue.

## ¿Cómo lo resuelve?
Spring Boot carga automáticamente el archivo `application.properties` desde la carpeta `src/main/resources` al iniciar la aplicación. Todas las propiedades definidas se aplican en el arranque de la aplicación, configurando los componentes y módulos de acuerdo con los valores especificados. Spring Boot también permite definir múltiples archivos de propiedades para cada perfil, como application-dev.properties, application-prod.properties, y aplicar configuraciones específicas según el entorno.

## Propiedades
1. Configuración del servidor:
   * `server.port`: Define el puerto en el que se ejecuta el servidor. Ejemplo
```properties
server.port=8080
```

2. Configuración de base de datos:
   * `spring.datasource.url`: URL de conexión a la base de datos.

   * `spring.datasource.username`: Usuario de la base de datos.

   * `spring.datasource.password`: Contraseña de la base de datos.

   * `spring.jpa.hibernate.ddl-auto`: Controla el comportamiento de creación de esquemas (por ejemplo, `update`, `create`, `validate`, `none`).

3. Logging:
   * `logging.level.root`: Nivel de logging global (por ejemplo, `DEBUG`, `INFO`, `WARN`).

   * `logging.level.org.springframework`: Nivel de logging específico para paquetes.

4. Manejo de perfiles:
   * spring.profiles.active: Define el perfil activo (ejemplo: dev, prod). Ejemplo
```properties
spring.profiles.active=dev
```

5. Mensajes personalizados: `spring.messages.basename`: Especifica el archivo de mensajes para internacionalización (`i18n`).

6. Parámetros de cache: `spring.cache.type`: Configura el tipo de cache (none, caffeine, redis, etc.).

### Ejemplo de application.properties
Supongamos que tienes una aplicación que se ejecuta en localhost en el puerto 8081, con conexión a una base de datos MySQL y un nivel de logging personalizado. El archivo application.properties podría verse así:

```properties
# Configuración del servidor
server.port=8081

# Configuración de base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.jpa.hibernate.ddl-auto=update

# Configuración de logging
logging.level.root=INFO
logging.level.org.hibernate.SQL=DEBUG

# Configuración de perfiles
spring.profiles.active=dev

# Configuración de mensajes personalizados
spring.messages.basename=messages
```

## Relación con otros archivos de configuración
Spring Boot también admite archivos de configuración YAML (como application.yml), que pueden usarse en lugar de application.properties. En muchos casos, los desarrolladores prefieren application.yml por su formato jerárquico, especialmente cuando se tiene una configuración con muchas propiedades anidadas.

## Propiedades personalizadas en application.properties
Si tienes propiedades específicas de negocio o configuración de lógica de negocio, puedes crear tus propias propiedades en el archivo application.properties:
```properties
miaplicacion.mensajeBienvenida=Bienvenido a la aplicación
miaplicacion.maximoUsuarios=100
```
Luego, puedes acceder a estas propiedades en tu código mediante la anotación `@Value`:
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MiServicio {

    @Value("${miaplicacion.mensajeBienvenida}")
    private String mensajeBienvenida;

    @Value("${miaplicacion.maximoUsuarios}")
    private int maximoUsuarios;

    public void mostrarMensaje() {
        System.out.println(mensajeBienvenida + ", máximo de usuarios: " + maximoUsuarios);
    }
}
```

## Configuración por perfil
Para entornos específicos, puedes definir propiedades en archivos como application-dev.properties o application-prod.properties, que se activarán automáticamente según el perfil definido en spring.profiles.active. Esto permite personalizar la configuración por ambiente, ideal para gestionar diferencias de desarrollo, pruebas y producción.