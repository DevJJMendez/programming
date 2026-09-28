Los @GetMapping en un controlador de Spring Boot se usan para manejar solicitudes HTTP GET. Diseñar estos endpoints de forma correcta es fundamental para garantizar que tu aplicación sea robusta, escalable, eficiente y fácil de mantener.

# Nivel Básico: Crear un Endpoint Simple
Un @GetMapping básico se utiliza para devolver un recurso o un mensaje simple. Este es un punto de partida para principiantes.

Ejemplo
```java
@RestController
@RequestMapping("/api/v1")
public class BasicController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```
Puntos clave:
@RestController: Combina @Controller y @ResponseBody para devolver respuestas directamente en formato JSON o texto.
@RequestMapping: Establece una ruta base para agrupar endpoints relacionados.

## Nivel Intermedio: Manejar Parámetros de Consulta
Es común que los endpoints necesiten procesar parámetros para filtrar o personalizar la respuesta.

Ejemplo: Parámetros de Consulta (?name=John)
```java
@RestController
@RequestMapping("/api/v1")
public class QueryParamController {

    @GetMapping("/greet")
    public String greetUser(@RequestParam(name = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }
}
```
Puntos clave:
@RequestParam:

Extrae valores de parámetros en la URL.
Proporciona un valor por defecto si el parámetro no está presente.
Buenas prácticas:

Documenta los parámetros en Swagger/OpenAPI.
Maneja valores nulos o vacíos adecuadamente.

## Nivel Avanzado: Devolver Recursos desde una Base de Datos
En aplicaciones reales, los datos suelen provenir de una base de datos. Aquí se usa un repositorio para obtener información.

Ejemplo: Devolver una lista de entidades
```java
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
```
Puntos clave:
@Autowired: Inyecta el repositorio en el controlador.
findAll(): Devuelve todos los productos desde la base de datos.
Devuelve datos estructurados: La lista de productos se convierte automáticamente en JSON.

## Nivel Profesional: Manejo de Excepciones
Un diseño robusto considera casos donde no se encuentran recursos o hay errores inesperados.

Ejemplo: Buscar un recurso por su ID
```java
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return ResponseEntity.ok(product);
    }
}
```
Puntos clave:
@PathVariable: Extrae valores dinámicos de la URL.

Manejo de excepciones:

Define una excepción personalizada (ResourceNotFoundException).
Devuelve un código HTTP 404 en caso de que no se encuentre el recurso.
ResponseEntity:

Permite devolver el cuerpo de la respuesta, junto con códigos de estado HTTP y encabezados personalizados.

## Nivel Escalable: Implementar Paginación y Filtrado
Cuando el conjunto de datos es grande, la paginación y el filtrado mejoran el rendimiento.

Ejemplo: Paginación con Spring Data JPA
```java
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productRepository.findAll(pageable);
    }
}
```
Puntos clave:
Paginación:

Usa Pageable y Page para dividir resultados en páginas.
Permite personalizar el tamaño de página y la propiedad de ordenación.
Beneficios:

Reduce la carga en la base de datos y en la red.
Mejora la experiencia del usuario al cargar datos de manera incremental.

## Nivel Escalable: Uso de DTOs y MapStruct
En lugar de devolver entidades directamente, utiliza DTOs (Data Transfer Objects) para controlar los datos expuestos.

Ejemplo: DTO para ocultar campos sensibles
```java
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
```
Código del DTO
```java
public class ProductDTO {
    private String name;
    private double price;

    // Getters y Setters
}
```
Servicio que usa MapStruct
```java
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        return productMapper.toDTOs(productRepository.findAll());
    }
}
```
Mapper con MapStruct
```java
@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductDTO> toDTOs(List<Product> products);
}
```
Puntos clave:
Separa capas: No devuelvas directamente entidades de la base de datos.
Protección de datos sensibles: Solo expón los campos necesarios.
Automatiza mapeos con MapStruct para reducir errores manuales.

## Nivel Avanzado: Implementar Caching
Para mejorar el rendimiento y reducir la carga en la base de datos, puedes usar caché.

Ejemplo: Añadir caché al endpoint
```java
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @Cacheable("products")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
```
Configuración de caché
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
Puntos clave:
@Cacheable: Guarda en caché los resultados del método.
Reducción de consultas: Una vez en caché, el método no se ejecutará hasta que el caché expire.

## Prácticas Avanzadas para Escalabilidad y Mantenibilidad
Documentación:

Usa Swagger/OpenAPI para documentar tus endpoints automáticamente.
Seguridad:

Protege los endpoints con @PreAuthorize y JWT para manejar la autenticación y autorización.
Versionado de la API:

Usa rutas con versión (/api/v1) para garantizar compatibilidad hacia atrás cuando evolucione la API.
Métricas y Monitoreo:

Integra herramientas como Prometheus y Grafana para rastrear el rendimiento de los endpoints.
Pruebas:

Escribe pruebas unitarias (usando Mockito) y pruebas de integración (con MockMvc) para asegurar la calidad del código.