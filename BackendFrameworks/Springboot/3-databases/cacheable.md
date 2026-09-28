La anotación @Cacheable es una herramienta poderosa de Spring que permite integrar fácilmente el almacenamiento en caché en una aplicación.

## ¿Qué es @Cacheable?
@Cacheable es una anotación de Spring que marca un método o una clase como elegible para almacenamiento en caché. Cuando se aplica a un método, el resultado de la ejecución se almacena en un caché, y las llamadas posteriores al mismo método, con los mismos parámetros, devolverán el valor almacenado en lugar de ejecutar nuevamente el método.

## ¿Para qué sirve?
@Cacheable sirve para:

Mejorar el rendimiento: Almacena resultados de métodos que consumen recursos (consulta de bases de datos, cálculos complejos, llamadas a servicios externos, etc.).
Reducir la latencia: Devuelve respuestas más rápidas, ya que evita operaciones repetitivas.
Optimizar el uso de recursos: Reduce la carga en la base de datos, red o CPU.

## ¿Qué resuelve?
Problema de operaciones repetitivas costosas:

Ejemplo: Consultas frecuentes a una base de datos para datos que no cambian con frecuencia.
Demoras en cálculos complejos o procesamiento de datos:

Ejemplo: Procesar grandes volúmenes de datos.
Ineficiencias en el manejo de datos inmutables o semidinámicos:

Ejemplo: Consultar una lista de productos que solo cambia una vez al día.

## ¿Cómo lo resuelve?
Spring utiliza un mecanismo de caché que almacena el resultado de un método en un almacenamiento temporal (como memoria, Redis, Ehcache, etc.). En las llamadas posteriores:

Si el resultado ya está en el caché y los parámetros coinciden, lo devuelve directamente desde el caché.
Si no está en el caché, ejecuta el método, almacena el resultado en el caché y luego lo devuelve.

## Funcionamiento Básico
Ejemplo 1: Uso básico de @Cacheable
```java
@Service
public class ProductService {

    @Cacheable("products")
    public List<Product> getAllProducts() {
        // Simula una consulta costosa
        simulateSlowService();
        return List.of(new Product(1, "Laptop"), new Product(2, "Phone"));
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000); // Simula un retraso de 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
```
Comportamiento:
La primera vez que se llama al método getAllProducts(), tarda 3 segundos porque ejecuta el método completo.
Las llamadas posteriores devuelven el resultado almacenado en caché inmediatamente.

## Configuración de Caché
Habilitar caché en tu aplicación:
1. Anota la clase de configuración principal con @EnableCaching
```java
@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("products");
    }
}
```
* ConcurrentMapCacheManager es un gestor de caché en memoria simple.
* Puedes usar gestores más avanzados como Redis, Ehcache, o Caffeine para producción.

## Opciones Avanzadas de @Cacheable
1. value o cacheNames: Especifica el nombre del caché donde se almacenará el resultado.

2. key: Define cómo se genera la clave en el caché (por defecto, usa los parámetros del método).
```java
@Cacheable(value = "products", key = "#id")
public Product getProductById(Long id) { ... }
```

3. condition: Almacena en caché solo si se cumple una condición.
```java
@Cacheable(value = "products", condition = "#id > 10")
public Product getProductById(Long id) { ... }
```

4. unless: Similar a condition, pero excluye resultados de ser almacenados en caché.
```java
@Cacheable(value = "products", unless = "#result.price > 1000")
public Product getProductById(Long id) { ... }
```

5. sync: Evita el problema de concurrencia al bloquear la ejecución del método hasta que se calcule el valor de la caché.
```java
@Cacheable(value = "products", sync = true)
public Product getProductById(Long id) { ... }
```

## Integración con Gestores de Caché Externos
Para aplicaciones avanzadas, puedes usar gestores como Redis o Caffeine para almacenamiento distribuido.

Ejemplo: Configuración con Redis
1. Añade la dependencia de Redis en pom.xml:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
2. Configura Redis en application.properties:
```properties
spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379
```
3. Usa @Cacheable normalmente. Spring manejará el almacenamiento en Redis automáticamente

### Buenas Prácticas para @Cacheable
Selecciona correctamente el gestor de caché:

Usa ConcurrentMapCache para aplicaciones simples.
Usa Redis o Ehcache para aplicaciones distribuidas y de alta concurrencia.
Cuidado con la invalidez del caché:

Si los datos cambian, usa @CacheEvict para eliminar entradas del caché.
```java
@CacheEvict(value = "products", allEntries = true)
public void refreshProductsCache() { ... }
```
Evita almacenar grandes volúmenes de datos en caché:

Limita el tamaño del caché y configura políticas de expiración (TTL).
Documenta y controla las claves del caché:

Define explícitamente las claves para evitar conflictos.
Mide el impacto del caché:

Usa herramientas como Spring Actuator para monitorear métricas del caché.

### Consideraciones Finales
@Cacheable es una herramienta esencial para optimizar aplicaciones Spring, pero requiere un diseño cuidadoso:

Define correctamente las políticas de invalidez.
Usa herramientas avanzadas (como Redis) para aplicaciones escalables.
Integra métricas y monitoreo para evaluar el impacto en el rendimiento.

---
