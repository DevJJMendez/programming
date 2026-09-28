# Spring Cloud OpenFeign
Spring Cloud OpenFeign es un cliente HTTP declarativo que permite realizar llamadas a servicios REST sin necesidad de escribir manualmente código para consumir APIs.

* Simplifica la comunicación entre microservicios.
* Usa interfaces Java para definir clientes REST.
* Se integra con Eureka, LoadBalancer y Spring Security.
* Soporta reintentos automáticos y manejo de errores.

## ¿Para qué sirve?
* Evita escribir código repetitivo con RestTemplate o WebClient.
* Facilita la integración con APIs externas o internas.
* Simplifica el mantenimiento de clientes REST.
* Se integra con Eureka para hacer descubrimiento de servicios.

## ¿Qué problema resuelve?
* Problema sin OpenFeign: Con RestTemplate o WebClient, se necesita escribir código repetitivo:
```java
RestTemplate restTemplate = new RestTemplate();
String response = restTemplate.getForObject("http://ORDER-SERVICE/orders", String.class);
```
Necesitamos configurar manualmente balanceo de carga y autenticación.

* OpenFeign lo soluciona
  * Nos permite definir clientes con interfaces Java sin lógica adicional.
  * Automáticamente maneja balanceo de carga con Spring Cloud LoadBalancer.
  * Soporta codificadores/decodificadores para procesar respuestas fácilmente.

## Configuración de Spring Cloud OpenFeign
1. Agregar dependencias en pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
* spring-cloud-starter-openfeign → Activa Feign como cliente REST.
* spring-cloud-starter-netflix-eureka-client → Permite resolver instancias de servicios con Eureka.

2. Habilitar Feign en el microservicio: En la clase principal @SpringBootApplication, agregamos @EnableFeignClients:
```java
@SpringBootApplication
@EnableFeignClients  // Habilita OpenFeign
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
```
Esto le dice a Spring que busque clientes Feign en el proyecto.

3. Definir un Cliente Feign: Creamos una interfaz para consumir el servicio REST:
```java
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {
    
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
```
* @FeignClient(name = "PRODUCT-SERVICE") → Hace referencia al nombre del servicio en Eureka.
* @GetMapping("/products/{id}") → Define la ruta del endpoint.
* Product getProductById(@PathVariable("id") Long id); → Llama al servicio REST y convierte la respuesta en un objeto Product.

4. Usar el Cliente Feign en un Servicio: Inyectamos el cliente Feign en nuestra clase de servicio:
```java
@Service
public class OrderService {
    
    @Autowired
    private ProductClient productClient;

    public Product fetchProduct(Long productId) {
        return productClient.getProductById(productId);
    }
}
```
Feign maneja automáticamente la llamada HTTP y devuelve un objeto Product.

## Integración con Eureka y LoadBalancer
Si usamos Eureka, OpenFeign resuelve automáticamente el nombre del servicio.

Configuración en application.yml
```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
* Ahora OpenFeign consulta Eureka para descubrir las instancias disponibles.
* No es necesario definir la URL completa del servicio, solo el nombre (PRODUCT-SERVICE).

## Manejo de Fallos y Reintentos
OpenFeign permite configurar reintentos en caso de fallos.

Activar reintentos en application.yml
```yaml
feign:
  client:
    config:
      default:
        connectTimeout: 5000
        readTimeout: 5000
        retryer: feign.Retryer.Default
```
* connectTimeout: 5000 → Espera 5 segundos para conectar.
* readTimeout: 5000 → Espera 5 segundos para recibir respuesta.
* retryer: feign.Retryer.Default → Activa intentos de reconexión.

## Manejo de Errores con FeignErrorDecoder
Podemos personalizar el manejo de errores cuando un servicio responde con 400, 500, etc.

Implementamos un FeignErrorDecoder:
```java
@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("Solicitud incorrecta a " + methodKey);
            case 404:
                return new NotFoundException("No se encontró el recurso en " + methodKey);
            default:
                return new Exception("Error inesperado: " + response.reason());
        }
    }
}
```
Feign ahora captura los errores y los convierte en excepciones personalizadas.

Registramos el ErrorDecoder en Feign:
```java
@Bean
public ErrorDecoder errorDecoder() {
    return new CustomErrorDecoder();
}
```
Ahora, cuando un servicio devuelva un 400 o 404, Feign lo manejará correctamente.

## Uso de Headers y Autenticación en Feign
Podemos enviar headers personalizados en cada solicitud.

Ejemplo de cliente Feign enviando un token JWT:
```java
@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/users/me")
    User getUser(@RequestHeader("Authorization") String token);
}
```
Uso en el servicio:
```java
public User getUserInfo(String token) {
    return userClient.getUser("Bearer " + token);
}
```
Ahora Feign enviará el header Authorization con cada solicitud.

## Integración con API Gateway
Si tenemos un Spring Cloud Gateway, podemos configurar Feign para pasar los headers correctamente.

📌 Configuración en application.yml:
```yaml
feign:
  client:
    default:
      requestInterceptors:
        - com.example.auth.AuthInterceptor
```
Implementamos un RequestInterceptor para pasar el token automáticamente:
```java
@Component
public class AuthInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + getAuthToken());
    }

    private String getAuthToken() {
        return "mi-token-de-autenticacion";
    }
}
```
Ahora todas las llamadas Feign incluirán el token de autenticación.