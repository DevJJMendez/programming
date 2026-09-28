# Spring Cloud Config Server
Spring Cloud Config Server es un servicio centralizado para gestionar configuraciones de múltiples aplicaciones en un sistema distribuido.

📌 2. ¿Para qué sirve?
✅ Centraliza la configuración de múltiples microservicios.
✅ Permite cambiar configuraciones sin necesidad de redeployar las aplicaciones.
✅ Soporta diferentes fuentes como Git, archivos locales, bases de datos, HashiCorp Vault.
✅ Facilita el versionado y rollback de configuraciones.
✅ Compatible con perfiles (dev, qa, prod) y encriptación de valores sensibles.

📌 3. ¿Qué problema resuelve?
🔴 Problema:
En un sistema de microservicios con múltiples aplicaciones, cada servicio maneja su propio application.yml, lo que genera problemas como:

Configuraciones duplicadas en cada microservicio.
Inconsistencias en entornos (dev, qa, prod).
Dificultad para actualizar configuraciones sin reiniciar servicios.
🟢 Solución con Config Server:
✅ Unifica las configuraciones en un solo lugar (repositorio Git o base de datos).
✅ Carga dinámica de configuración sin reiniciar los servicios.
✅ Aplicación de cambios en tiempo real con Actuator y Bus.

📌 4. Arquitectura de Spring Cloud Config
Spring Cloud Config tiene dos componentes principales:

1️⃣ Config Server

Provee los archivos de configuración a los microservicios.
Se conecta a un repositorio de configuración (Git, base de datos, archivos locales).
Expone configuraciones mediante una API REST.
2️⃣ Config Clients

Microservicios que consumen las configuraciones centralizadas desde el Config Server.
Se configuran para obtener datos dinámicamente.
Pueden recargar configuraciones sin reiniciar la aplicación.
📌 Ejemplo de flujo de configuración:

Un microservicio (user-service) solicita su configuración a Config Server.
Config Server obtiene la configuración desde Git y la devuelve al microservicio.
user-service usa la configuración sin necesidad de tener archivos locales.
📌 5. Configuración de Config Server
✅ Paso 1: Crear el Servidor de Configuración
📌 1️⃣ Crear un nuevo repositorio config-server
Ejemplo: git@github.com:empresa/config-server.git

📌 2️⃣ Agregar dependencias en pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
3️⃣ Crear ConfigServerApplication.java
```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```
4️⃣ Configurar application.yml
```java
server:
  port: 8888

spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/empresa/config-repo
          default-label: main
          search-paths: config-files
```
Aquí config-repo es el repositorio donde guardaremos los archivos de configuración.

5️⃣ Crear el repositorio de configuración en Git
Ejemplo: https://github.com/empresa/config-repo
Dentro del repositorio, creamos archivos YAML para cada servicio:
```golang
/config-repo
  ├── application.yml
  ├── user-service.yml
  ├── order-service.yml
  ├── payment-service.yml
```

6️⃣ Ejemplo de user-service.yml
```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/userdb
    username: user
    password: secret
```

7️⃣ Levantar el Config Server Ejecutamos la aplicación y verificamos en http://localhost:8888/user-service/default.

## Configuración del Config Client
📌 1️⃣ Agregar dependencias en el microservicio (user-service)
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
2️⃣ Configurar bootstrap.yml en user-service
```yaml
spring:
  application:
    name: user-service
  cloud:
    config:
      uri: http://localhost:8888
```
3️⃣ Verificar la configuración cargada
```java
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @GetMapping
    public String getConfig() {
        return "DB URL: " + dbUrl;
    }
}
```
4️⃣ Acceder a la configuración vía API
```bash
curl http://localhost:8081/config
```
Salida esperada:
```bash
DB URL: jdbc:mysql://localhost:3306/userdb
```

## Actualizar Configuración en Tiempo Real
Si cambiamos un valor en config-repo/user-service.yml, los cambios no se aplican automáticamente. Para recargarlos sin reiniciar, usamos Spring Actuator y Spring Cloud Bus.

📌 1️⃣ Agregar dependencias en user-service
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```
2️⃣ Configurar application.yml
```yaml
management:
  endpoints:
    web:
      exposure:
        include: refresh, busrefresh
```
3️⃣ Aplicar cambios sin reiniciar
```bash
curl -X POST http://localhost:8081/actuator/refresh
```
Ahora la configuración se recarga dinámicamente. 