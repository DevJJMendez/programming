# Spring Cloud LoadBalancer
Spring Cloud LoadBalancer es la solución integrada en Spring Cloud para realizar balanceo de carga entre instancias de microservicios.

* Reemplaza a Ribbon, que fue descontinuado.
* Soporta balanceo de carga sin necesidad de un servidor externo (como un proxy).
* Se integra con Eureka, Kubernetes, y otros service discovery.
* Compatible con Spring WebFlux y Spring MVC.

## ¿Para qué sirve?
* Distribuye las peticiones entre múltiples instancias de un microservicio.
* Optimiza el rendimiento, evitando que una instancia reciba toda la carga.
* Asegura alta disponibilidad, redirigiendo peticiones si una instancia falla.
* Reduce la latencia, seleccionando la mejor instancia disponible.

## ¿Qué problema resuelve?
**Problema sin balanceo de carga**
* Un servicio podría sobrecargarse si todas las peticiones van a la misma instancia.
* Si una instancia falla, no hay un mecanismo para redirigir las peticiones.
* No hay una forma automática de distribuir las solicitudes entre instancias disponibles.

**Spring Cloud LoadBalancer lo soluciona**
* Distribuye el tráfico entre varias instancias del mismo servicio.
* Reintenta peticiones si una instancia falla.
* Utiliza algoritmos de balanceo como Round Robin o Weighted Response Time.

## Arquitectura de Spring Cloud LoadBalancer
Ejemplo de arquitectura con balanceo de carga:
```golang
             Cliente (Frontend, API Gateway)
                        |
              +------------------+
              |  Load Balancer   |
              +------------------+
               |       |       |
    +---------------------------+
    |         Eureka Server      |
    +---------------------------+
     |          |          |
+--------+  +--------+  +--------+
| Inst 1 |  | Inst 2 |  | Inst 3 |
| 8081   |  | 8082   |  | 8083   |
+--------+  +--------+  +--------+
```
* El cliente solo interactúa con el balanceador.
* Spring Cloud LoadBalancer elige la mejor instancia disponible.

## Configuración de Spring Cloud LoadBalancer
1. Agregar dependencias en `pom.xml`
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
* spring-cloud-starter-loadbalancer proporciona el balanceo de carga.
* spring-cloud-starter-netflix-eureka-client se usa si queremos trabajar con Eureka.

2. Configurar application.yml para habilitar Eureka: Si usamos Eureka, debemos registrar el servicio en application.yml:
```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```
Esto permite que el servicio descubra instancias disponibles en Eureka Server.

3. Habilitar el Balanceo de Carga en un Cliente REST. Ejemplo de cliente con balanceo de carga automático:
```java
@LoadBalanced  // Habilita el balanceo de carga
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}
```
Uso en una llamada REST a otro microservicio:
```java
@Autowired
private RestTemplate restTemplate;

public String getOrderServiceResponse() {
    return restTemplate.getForObject("http://ORDER-SERVICE/orders", String.class);
}
```

## Algoritmos de Balanceo de Carga
Spring Cloud LoadBalancer usa diferentes estrategias para seleccionar instancias.

📌 Ejemplo de configuración para elegir estrategia en application.yml:
```yaml
spring:
  cloud:
    loadbalancer:
      ribbon:
        enabled: false
      retry:
        enabled: true
```
Estrategias disponibles:
1️⃣ Round Robin (Por defecto) → Distribuye equitativamente las peticiones entre todas las instancias.
2️⃣ Random → Selecciona una instancia al azar.
3️⃣ Weighted Response Time → Prioriza instancias con menor tiempo de respuesta.

📌 Ejemplo de configuración personalizada en Java:
```java
@Bean
public ReactorLoadBalancer<ServiceInstance> customLoadBalancer(Environment environment, LoadBalancerClientFactory factory) {
    String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
    return new RoundRobinLoadBalancer(factory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
}
```
Aquí estamos configurando el algoritmo de "Round Robin".

## Integración con API Gateway y Feign
Si usamos Spring Cloud Gateway, podemos integrar LoadBalancer:

Ejemplo de configuración en application.yml
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: order-service
          uri: lb://ORDER-SERVICE
          predicates:
            - Path=/orders/**
```
`lb://ORDER-SERVICE` indica que se usará LoadBalancer para seleccionar una instancia.

Si usamos Feign Client, también soporta LoadBalancer:
```java
@FeignClient(name = "ORDER-SERVICE")
public interface OrderServiceClient {
    @GetMapping("/orders")
    List<Order> getOrders();
}
```
Feign automáticamente usará LoadBalancer para balancear las solicitudes.


## Implementando Retry (Reintentos Automáticos)
Spring Cloud LoadBalancer permite reintentar peticiones en caso de fallo.

📌 Agregar dependencia en pom.xml
```xml
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
Configurar reintentos en application.yml
```yaml
spring:
  cloud:
    loadbalancer:
      retry:
        enabled: true
```
Si una instancia falla, LoadBalancer intentará otra antes de devolver un error.