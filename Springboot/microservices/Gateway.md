# Spring Cloud Gateway
Spring Cloud Gateway es un API Gateway moderno y liviano basado en Spring Boot y Spring WebFlux. Se encarga de manejar el tráfico de entrada hacia los microservicios, actuando como un proxy que gestiona rutas, autenticación, balanceo de carga, seguridad y más.

* Sustituto de Zuul 1 (Netflix Zuul quedó obsoleto).
* Basado en Spring WebFlux, lo que lo hace más rápido y reactivo.
* Se integra con Eureka, OAuth2, JWT, Circuit Breaker (Resilience4j) y más.

## ¿Para qué sirve?
Spring Cloud Gateway sirve para:

* Centralizar la entrada de tráfico a los microservicios.

* Proteger APIs con autenticación (JWT, OAuth2).

* Balancear carga entre múltiples instancias de un servicio.

* Implementar filtros (logs, seguridad, compresión, caché).

* Definir reglas de enrutamiento dinámico con predicados.

* Actuar como un proxy inverso entre clientes y microservicios.

## ¿Qué problema resuelve?
**Problemas en arquitecturas sin API Gateway**
* Los clientes deben conocer la ubicación de cada microservicio.
* Cada microservicio maneja su propia seguridad y autenticación.
* No hay control centralizado del tráfico y balanceo de carga.
* Es difícil aplicar filtros comunes a todos los servicios.

**Spring Cloud Gateway lo soluciona**:
* Actúa como punto único de entrada para todos los microservicios.
* Redirige las peticiones sin que el cliente conozca los detalles internos.
* Aplica autenticación, logs, caché y seguridad en un solo lugar.
* Implementa balanceo de carga junto con Eureka y LoadBalancer.

## Arquitectura de Spring Cloud Gateway
**Componentes Claves**
1. Route (Ruta): Define cómo una solicitud debe ser manejada y a qué servicio dirigirla.
2. Predicate (Predicado): Define condiciones para que una ruta se active (por ejemplo, URL, headers, etc.).
3. Filter (Filtro): Permite modificar la solicitud o la respuesta (por ejemplo, añadir JWT, logs, etc.).
4. Circuit Breaker: Protege los microservicios de fallos en cascada.

```golang
                           +------------------------+
                           | Spring Cloud Gateway  |
                           +-----------+------------+
                                       |
       +---------------------+---------------------+-------------------+
       |                     |                     |                   |
+---------------+    +---------------+    +---------------+    +---------------+
| User Service  |    | Order Service |    | Payment Serv. |    | Inventory Serv.|
+---------------+    +---------------+    +---------------+    +---------------+
```
* El cliente solo interactúa con el API Gateway.
* Spring Cloud Gateway dirige el tráfico a los microservicios correctos.

## Configuración de Spring Cloud Gateway
1. Agregar dependencias en pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

2. Configurar application.yml con rutas
```yaml
server:
  port: 8080

spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
          filters:
            - AddRequestHeader=User-Header, my-header-value

        - id: order-service
          uri: lb://ORDER-SERVICE
          predicates:
            - Path=/orders/**
          filters:
            - AddRequestParameter=customParam, value123
```
**Explicación**
* `lb://USER-SERVICE`: Redirige las peticiones a Eureka para encontrar el servicio.

* `Path=/users/**`: Redirige todas las peticiones que comiencen con /users/.

* `AddRequestHeader`: Añade un header a las solicitudes.

* `AddRequestParameter`: Agrega un parámetro a la solicitud.

3. Registrar el Gateway en Eureka: Si estamos usando Eureka, configuramos el `application.yml`:
```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```
Esto permite que el Gateway se registre automáticamente en Eureka Server.

### Agregando Seguridad con JWT
Podemos proteger nuestras rutas con autenticación JWT utilizando `spring-boot-starter-oauth2-resource-server`.

Configurar autenticación en application.yml
```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:9000/auth
```

Ejemplo de filtro para validar JWT
```java
@Bean
public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
    return http
        .authorizeExchange()
        .pathMatchers("/users/**").authenticated()
        .pathMatchers("/public/**").permitAll()
        .and()
        .oauth2ResourceServer().jwt()
        .and().build();
}
```
* Las rutas `/users/**` requieren autenticación con JWT.
* Las rutas `/public/**` están abiertas al público.

### Filtros Globales en Spring Cloud Gateway
Los filtros permiten modificar todas las solicitudes o respuestas antes de enviarlas a los microservicios.

Ejemplo de filtro global
```java
@Component
public class LoggingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Petición: " + exchange.getRequest().getURI());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
```
Intercepta todas las peticiones y las imprime en consola.

### Manejo de Errores y Circuit Breaker con Resilience4j
Para evitar fallos en cascada, podemos usar Resilience4j para circuit breakers.

Agregar dependencia en pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-circuitbreaker-reactor-resilience4j</artifactId>
</dependency>
```

Configurar un Circuit Breaker en application.yml
```yaml
resilience4j:
  circuitbreaker:
    instances:
      userServiceCircuitBreaker:
        failureRateThreshold: 50
        waitDurationInOpenState: 10000
```

Aplicar Circuit Breaker en Spring Cloud Gateway
```yaml
filters:
  - name: CircuitBreaker
    args:
      name: userServiceCircuitBreaker
      fallbackUri: forward:/fallback/user
```