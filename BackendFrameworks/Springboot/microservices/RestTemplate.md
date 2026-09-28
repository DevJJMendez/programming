# Spring RestTemplate
RestTemplate es una clase en Spring Framework utilizada para realizar llamadas HTTP a servicios RESTful desde una aplicación Spring Boot. Aunque ha sido reemplazada por WebClient en aplicaciones reactivas, sigue siendo útil en aplicaciones bloqueantes y sincrónicas.

## ¿Qué es RestTemplate?
RestTemplate es una clase de Spring que proporciona métodos para realizar solicitudes HTTP a API externas de forma sencilla.

✅ Permite hacer peticiones GET, POST, PUT, DELETE, PATCH.
✅ Maneja automáticamente la conversión de objetos Java (POJOs) a JSON y viceversa.
✅ Usa Apache HttpClient o JDK HttpURLConnection internamente.
✅ Admite personalización con interceptores, autenticación y manejo de errores.

## ¿Para qué sirve RestTemplate?
Spring RestTemplate se usa para:
✅ Consumir APIs REST desde una aplicación Spring Boot.
✅ Realizar llamadas entre microservicios en una arquitectura distribuida.
✅ Enviar y recibir datos en formato JSON o XML.
✅ Integrarse con servicios de terceros, como APIs de pagos, clima, etc.

## ¿Qué problema resuelve?
En una aplicación monolítica, podríamos acceder a los datos desde una base de datos local, pero en microservicios y aplicaciones distribuidas, necesitamos comunicarnos con otros servicios a través de HTTP.

✅ Antes: Sin RestTemplate, teníamos que usar HttpURLConnection o Apache HttpClient manualmente.
✅ Ahora: RestTemplate simplifica las llamadas HTTP con métodos fáciles de usar.

## Ejemplo de uso de RestTemplate en Spring Boot
1. Agregar dependencia en pom.xml. Si usas Spring Boot 2.x, la dependencia ya está incluida. Para versiones anteriores, usa:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
spring-boot-starter-web incluye RestTemplate y Jackson para serialización JSON.

2. Configurar RestTemplate como un Bean
```java
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```
Esto permite inyectar RestTemplate en cualquier parte de la aplicación.

3. Ejemplo de solicitud GET con RestTemplate

Consumimos un API externa (ejemplo: obtener usuario desde JSONPlaceholder)
```java
@Service
public class UserService {
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(Long userId) {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        return restTemplate.getForObject(url, User.class);
    }
}
```
* getForObject(url, User.class) convierte automáticamente la respuesta JSON en un objeto Java.

4. Ejemplo de solicitud POST con RestTemplate

📌 Enviamos un objeto JSON a un servicio REST
```java
public User createUser(User user) {
    String url = "https://jsonplaceholder.typicode.com/users";
    return restTemplate.postForObject(url, user, User.class);
}
```
Convierte automáticamente el objeto User a JSON antes de enviarlo.

5. Ejemplo de solicitud PUT con RestTemplate

📌 Actualizamos un usuario en una API externa
```java
public void updateUser(Long userId, User user) {
    String url = "https://jsonplaceholder.typicode.com/users/" + userId;
    restTemplate.put(url, user);
}
```
PUT no devuelve respuesta, por eso usamos void.

6. Ejemplo de solicitud DELETE con RestTemplate

📌 Eliminar un usuario en la API externa
```java
public void deleteUser(Long userId) {
    String url = "https://jsonplaceholder.typicode.com/users/" + userId;
    restTemplate.delete(url);
}
```

## Manejo de Respuestas con ResponseEntity
Podemos usar ResponseEntity<T> para manejar respuestas HTTP completas.

Ejemplo de GET con ResponseEntity
```java
public ResponseEntity<User> getUserById(Long userId) {
    String url = "https://jsonplaceholder.typicode.com/users/" + userId;
    return restTemplate.getForEntity(url, User.class);
}
```
Nos permite obtener el código de estado HTTP, cabeceras y cuerpo de la respuesta.

## Manejo de Errores con RestTemplate
Podemos capturar excepciones cuando hay errores en la solicitud.

Ejemplo de manejo de errores con try-catch
```java
public User getUserById(Long userId) {
    try {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        return restTemplate.getForObject(url, User.class);
    } catch (RestClientException e) {
        log.error("Error al consumir API: {}", e.getMessage());
        return null;
    }
}
```
Evita que la aplicación se caiga si la API externa falla.

## Configuración Avanzada de RestTemplate
1️⃣ Personalizar Timeouts en RestTemplate. Podemos configurar tiempo de espera para evitar bloqueos.
```java
@Bean
public RestTemplate restTemplate() {
    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
    factory.setConnectTimeout(5000);  // 5 segundos para conectar
    factory.setReadTimeout(5000);     // 5 segundos para leer respuesta
    return new RestTemplate(factory);
}
```
Evita que las llamadas HTTP se congelen indefinidamente.

2️⃣ Agregar Cabeceras Personalizadas con HttpHeaders. Podemos personalizar las cabeceras HTTP en cada solicitud.
```java
public User getUserWithHeaders(Long userId) {
    String url = "https://jsonplaceholder.typicode.com/users/" + userId;

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer token123");
    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, entity, User.class);
    return response.getBody();
}
```
Útil para enviar tokens de autenticación o claves de API.

## Desventajas de RestTemplate y Alternativa (WebClient)
RestTemplate es sincrónico y bloqueante, lo que significa que cada llamada HTTP detiene el hilo hasta recibir la respuesta.

✅ Si usas Spring Boot 2.4+, considera usar WebClient en lugar de RestTemplate:
```java
WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

public Mono<User> getUserById(Long userId) {
    return webClient.get()
            .uri("/users/{id}", userId)
            .retrieve()
            .bodyToMono(User.class);
}
```
WebClient es asíncrono y no bloqueante, lo que mejora el rendimiento en aplicaciones reactivas.