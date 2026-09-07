## SpringBoot
Es un proyecto que se construye sobre el **Spring Framework** para simplificar el desarrollo de aplicaciones Spring. Su principal objetivo es hacer que el proceso de configuración y despliegue sea más rápido y sencillo.

**Caracteristicas**
1. **Configuración Automática**: Proporciona configuración automática para muchas de las bibliotecas y componentes de Spring, reduciendo la necesidad de configuración manual.

2. **Aplicaciones Autónomas**: Permite crear aplicaciones autónomas que pueden ejecutarse como un JAR ejecutable, sin necesidad de un servidor de aplicaciones externo.

3. **Servidor Embebido**: Incluye servidores embebidos como **Tomcat**, **Jetty** y **Undertow**, facilitando el desarrollo y despliegue.

4. **Dependencias Simplificadas**: Ofrece un gestor de dependencias simplificado a través de `starter POMs`, que proporcionan un conjunto de dependencias preconfiguradas para diferentes tipos de aplicaciones.

5. **Actuadores**: Proporciona endpoints de monitoreo y administración para la aplicación, facilitando la observación y la gestión.

## Diferencias Claves
* **Configuración**: **Spring** requiere una configuración más manual y detallada, mientras que **Spring Boot** automatiza gran parte de la configuración.

* **Arranque y Despliegue**: Spring Boot permite crear aplicaciones que se ejecutan por sí solas (con servidores embebidos), mientras que con Spring tradicional, generalmente necesitas un servidor de aplicaciones externo.

* **Simplicidad y Conveniencia**: Spring Boot simplifica el desarrollo proporcionando configuraciones por defecto y herramientas de desarrollo rápidas, lo que lo hace más adecuado para microservicios y prototipos rápidos.

## Estructura
Spring Boot también tiene una estructura modular, pero está diseñada para simplificar la configuración y el desarrollo de aplicaciones Spring. Proporciona una serie de "`starter POMs`" que incluyen todas las dependencias necesarias para comenzar a trabajar con diferentes tecnologías y funcionalidades. 

1. **Starters**

   * `spring-boot-starter`: Incluye las dependencias centrales necesarias para cualquier aplicación Spring Boot.

   * `spring-boot-starter-web`: Dependencias para desarrollar aplicaciones web, incluyendo Spring MVC, REST y Tomcat embebido.

   * `spring-boot-starter-data-jpa`: Dependencias para trabajar con **JPA** y **Spring Data JPA**.

   * `spring-boot-starter-security`: Dependencias para añadir soporte de seguridad a la aplicación.

   * `spring-boot-starter-test`: Dependencias para pruebas unitarias e integración, incluyendo JUnit, Hamcrest y Mockito.

   * `spring-boot-starter-thymeleaf`: Dependencias para trabajar con el motor de plantillas Thymeleaf.

   * `spring-boot-starter-actuator`: Herramientas para monitoreo y administración de la aplicación.

   * `spring-boot-starter-logging`: Configuración de logging, utilizando Logback como el motor de logging predeterminado.

   * `spring-boot-starter-aop`: Soporte para la programación orientada a aspectos (AOP).

2. **Core**

   * `spring-boot`: Contiene las clases fundamentales y la lógica de arranque.

   * `spring-boot-autoconfigure`: Proporciona configuraciones automáticas para los componentes más comunes.

   * `spring-boot-starter-logging`: Configuración predeterminada de logging.

3. **DevTools**

   * `spring-boot-devtools`: Herramientas para facilitar el desarrollo, como el reinicio automático y la carga en caliente de clases.

4. **Actuator**

   * `spring-boot-actuator`: Proporciona endpoints para monitoreo y administración de la aplicación, como información de salud, métricas, y configuración del entorno.

5. **CLI**

   * `spring-boot-cli`: Herramientas de línea de comandos para crear y probar aplicaciones Spring Boot.

6. **Configuration**

   * `spring-boot-configuration-processor`: Procesador de anotaciones que genera metadatos de configuración para autocompletar en IDEs.

**Diagrama de estructura**
```bash
spring-boot/
|-- spring-boot-project/
|   |-- spring-boot/
|   |-- spring-boot-autoconfigure/
|   |-- spring-boot-actuator/
|   |-- spring-boot-cli/
|   |-- spring-boot-starters/
|   |   |-- spring-boot-starter/
|   |   |-- spring-boot-starter-web/
|   |   |-- spring-boot-starter-data-jpa/
|   |   |-- spring-boot-starter-security/
|   |   |-- spring-boot-starter-test/
|   |   |-- spring-boot-starter-thymeleaf/
|   |   |-- spring-boot-starter-actuator/
|   |   |-- spring-boot-starter-logging/
|   |   |-- spring-boot-starter-aop/
|-- spring-boot-devtools/
|-- spring-boot-configuration-processor/
```
## Estructura de Directorios
La estructura de una aplicación Spring Boot es similar a la de una aplicación **Spring Framework** estándar, pero está optimizada para seguir convenciones y configuraciones predeterminadas que simplifican el desarrollo.