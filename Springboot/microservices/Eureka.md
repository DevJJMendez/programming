# Spring Cloud Eureka
Eureka es un Service Discovery desarrollado por Netflix y parte del ecosistema Spring Cloud. Es un registro de servicios donde las aplicaciones pueden registrarse y descubrir otras aplicaciones sin necesidad de conocer sus direcciones IP o puertos de antemano.

## ¿Para qué sirve Eureka?
Eureka es un registro dinámico de servicios, lo que significa que los microservicios pueden:

✅ Registrarse automáticamente en el servidor Eureka.
✅ Descubrir otros servicios sin depender de configuraciones manuales.
✅ Balancear carga al distribuir solicitudes entre múltiples instancias de un mismo servicio.
✅ Manejar fallos eliminando servicios inactivos o no disponibles.

## ¿Qué problemas resuelve?
En arquitecturas de microservicios, los servicios pueden:
❌ Cambiar de dirección IP o puerto dinámicamente (por escalamiento o reinicios).
❌ Ser difíciles de rastrear y conectar sin un punto centralizado.
❌ Depender de configuraciones manuales que se vuelven difíciles de mantener.

🔹 Eureka resuelve esto permitiendo que los servicios se registren automáticamente y sean descubiertos sin necesidad de configuraciones estáticas.

## ¿Cómo lo resuelve?
Eureka funciona con un modelo cliente-servidor:
1️⃣ Eureka Server → Actúa como registro central donde los servicios se registran.
2️⃣ Eureka Clients → Microservicios que se registran y consultan Eureka para descubrir otros servicios.
3️⃣ Heartbeat → Los servicios envían señales periódicas para indicar que siguen activos.
4️⃣ Load Balancing → Los clientes pueden elegir entre múltiples instancias de un servicio.

## Implementación de Eureka
1️⃣ Configurar Eureka Server
Primero, creamos un servidor Eureka.

📌 Agregar dependencias en el pom.xml del servidor Eureka
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
Habilitar Eureka en la aplicación
```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```
Configurar application.yml
```yaml
server:
  port: 8761

eureka:
  client:
    registerWithEureka: false # El servidor no se registra a sí mismo
    fetchRegistry: false
```
Después de iniciar, el servidor Eureka estará disponible en http://localhost:8761.

## 2️⃣ Configurar Eureka Client
Ahora configuramos un microservicio para registrarse en Eureka.

📌 Agregar dependencias en el pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
Habilitar Eureka Client
```java
@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
```
Configurar application.yml
```yaml
server:
  port: 8081

spring:
  application:
    name: user-service

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```
Este servicio se registrará automáticamente en Eureka Server.

## 3️⃣ Descubrir Servicios desde otro Microservicio
Supongamos que el order-service necesita comunicarse con user-service.

📌 Usar DiscoveryClient para obtener la URL de otro servicio
```java
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/users")
    public List<ServiceInstance> getUserServiceInstances() {
        return discoveryClient.getInstances("user-service");
    }
}
```
Esto devolverá todas las instancias de user-service registradas en Eureka.

##  Funcionalidades Clave de Eureka
✅ Registro Dinámico → Los microservicios se registran automáticamente.
✅ Failover → Si un servicio falla, Eureka lo elimina del registro.
✅ Load Balancing → Se puede usar junto con Ribbon para balancear carga.
✅ Estrategias de Conexión → Eureka permite obtener solo servicios disponibles.

