# Data Transfer Object
Un Data Transfer Object (DTO) es un objeto plano que se utiliza exclusivamente para transportar datos entre diferentes partes de un sistema, como entre la capa de negocio y la capa de presentación (o viceversa). A diferencia de las entidades, los DTO no contienen lógica de negocio ni métodos complejos, únicamente almacenan datos.

## ¿Para qué sirve?
* **Reducir la cantidad de datos transferidos**: Solo contiene los campos necesarios para la operación en curso, en lugar de enviar una entidad completa con información innecesaria.

* **Aislar las entidades del dominio**: Protege las entidades del dominio al evitar que sean directamente expuestas a la capa de presentación o a los consumidores externos, como clientes REST.

* **Adaptar los datos para cada consumidor**: Permite estructurar los datos de manera personalizada para cumplir con los requisitos específicos de una interfaz o cliente.

* **Mejorar la seguridad y privacidad**: Oculta información sensible o irrelevante de los consumidores externos.

## ¿Cuáles son sus características?
* **Objeto plano (POJO)**: Los DTO son objetos simples que contienen solo atributos y métodos `getter` y `setter`.

* **No contienen lógica de negocio ni dependencias de frameworks.**

* **Serializables**: Se diseñan para ser serializables, lo que permite transferirlos fácilmente entre diferentes capas o sistemas (por ejemplo, en `JSON`, `XML`).

* **Independientes del dominio**: No están directamente ligados a las entidades del modelo de dominio.

* **Campos específicos**: Solo incluyen los datos necesarios para un caso de uso particular.

* **Flexibilidad**: Se pueden combinar datos de múltiples entidades en un único DTO si es necesario.

## ¿Qué resuelve?
* **Exposición de entidades del dominio**: Evita que las entidades del dominio sean accesibles fuera de la capa de negocio, reduciendo riesgos de seguridad y garantizando encapsulación.

* **Transferencia de datos innecesarios**: Reduce el ancho de banda utilizado al transferir solo los datos requeridos, mejorando el rendimiento en sistemas distribuidos.

* **Incompatibilidad de formatos**: Proporciona un formato uniforme para el intercambio de datos entre sistemas que podrían tener estructuras de datos diferentes.

* **Requisitos específicos de los consumidores**: Permite personalizar los datos para diferentes consumidores, como aplicaciones móviles o clientes web.

## ¿Cómo lo resuelve?
1. **Creación de objetos dedicados**, Define un objeto para transportar datos específicos en lugar de usar directamente las entidades del dominio:
```java
public class EmployeeDTO{
  private String fullName;
  private String departmentName;

  // Getters y setters
}
```
2. **Mapeo entre entidades y DTOs**: Se utilizan herramientas o manualmente se escriben métodos para convertir entidades en DTOs y viceversa.

Ejemplo usando un servicio:
```java
public EmployeeDTO toEmployeeDTO(Employee employee) {
    EmployeeDTO dto = new EmployeeDTO();
    dto.setFullName(employee.getFirstName() + " " + employee.getLastName());
    dto.setDepartmentName(employee.getDepartment().getName());
    return dto;
}
```

3. **Uso en controladores**, Los DTOs se devuelven desde controladores en lugar de las entidades:
```java
@GetMapping("/employees/{id}")
public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
    Employee employee = employeeService.getEmployeeById(id);
    EmployeeDTO dto = employeeService.toEmployeeDTO(employee);
    return ResponseEntity.ok(dto);
}
```

4. **Serialización y deserialización**: Los DTOs se serializan fácilmente en formatos como `JSON` o `XML` para ser enviados a través de la red.
```json
{
    "fullName": "John Doe",
    "departmentName": "Engineering"
}
```

## Características clave en el uso de DTOs en Spring Boot
1. **Anotaciones comunes**:

   * `@JsonProperty`: Permite personalizar nombres de propiedades al serializar o deserializar JSON.

   * `@JsonInclude`: Excluye campos nulos de la serialización

```java
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
    @JsonProperty("full_name")
    private String fullName;
}
```

2. **Uso de librerías como `MapStruct` o `ModelMapper`**: Estas librerías facilitan la conversión entre entidades y DTOs, eliminando la necesidad de escribir código repetitivo.

Ejemplo con `MapStruct`:
```java
@Mapper
public interface EmployeeMapper {
    EmployeeDTO toEmployeeDTO(Employee employee);
}
```

3. **Validación**: Los DTOs se pueden validar con anotaciones de `javax.validation` antes de procesarlos.

```java
public class EmployeeDTO {
    @NotBlank
    private String fullName;

    @NotNull
    private String departmentName;
}
```

4. **Relación con servicios y repositorios**:
   * Los servicios convierten entidades a DTOs antes de enviarlos al controlador o a través de APIs REST.

   * Los repositorios trabajan exclusivamente con entidades y no con DTOs.

# Ejemplo completo
Supongamos que tienes un sistema para gestionar empleados y departamentos:

```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Department department;

    // Getters y setters
}
```
```java
public class EmployeeDTO {
    private String fullName;
    private String departmentName;

    // Getters y setters
}
```
```java
@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFullName(employee.getFirstName() + " " + employee.getLastName());
        dto.setDepartmentName(employee.getDepartment().getName());
        return dto;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return employees.stream().map(this::toEmployeeDTO).collect(Collectors.toList());
    }
}
```
```java
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
}
```

# Casos de Uso
## Transferencia de datos entre capas de la aplicación
En una arquitectura en capas (por ejemplo, capa de presentación, capa de negocio, y capa de persistencia), los DTOs son utilizados para transferir datos entre estas capas sin exponer directamente las entidades del dominio.

* **Ejemplo**: En una aplicación de ecommerce, se puede usar un DTO para enviar al cliente información del carrito de compras, pero omitiendo campos internos como identificadores de bases de datos o datos sensibles.

```java
public class CartItemDTO {
    private String productName;
    private int quantity;
    private double price;
}
```

## En APIs REST o servicios web
Los DTOs son esenciales para estructurar los datos enviados y recibidos en APIs REST, especialmente al trabajar con formatos como JSON o XML.

* **Objetivo**:
  * Reducir el tamaño de los datos enviados.

  * Personalizar la estructura según las necesidades del cliente.

  * Proteger la lógica interna de la aplicación.

* **Ejemplo**: En un servicio REST que expone información de usuarios, un UserDTO puede incluir solo los campos necesarios para el frontend, ocultando contraseñas u otros detalles sensibles.
```java
public class UserDTO {
    private String username;
    private String email;
}
```

## Agregación de datos de múltiples entidades
Un DTO puede combinar datos de varias entidades relacionadas para cumplir con los requisitos de un cliente o una operación específica.

* Ejemplo: En un sistema de gestión de proyectos, se puede crear un DTO que combine información de un proyecto, sus tareas y el equipo asociado.
```java
public class ProjectDetailsDTO {
    private String projectName;
    private String managerName;
    private List<TaskDTO> tasks;
    private List<MemberDTO> teamMembers;
}
```

## Reducción del tráfico en aplicaciones distribuidas
En sistemas distribuidos o aplicaciones con microservicios, los DTOs permiten transferir solo los datos necesarios, reduciendo el consumo de ancho de banda y mejorando el rendimiento.

**Ejemplo**: Un microservicio de "Catálogo de productos" podría enviar solo los datos relevantes (como nombre, precio y disponibilidad) al microservicio de "Carrito", en lugar de enviar toda la entidad del producto.

##  Interoperabilidad entre sistemas
Los DTOs son útiles para estandarizar los datos entre sistemas con diferentes estructuras o tecnologías, facilitando la interoperabilidad.

**Ejemplo**: Al consumir un servicio externo que devuelve datos en un formato no compatible con tu aplicación, puedes usar un DTO para mapear esos datos al formato requerido.

## Validación de datos en entradas del cliente
Los DTOs pueden incluir anotaciones de validación para asegurar que los datos enviados por el cliente sean válidos antes de procesarlos.

**Ejemplo**: En un formulario de registro de usuario:
```java
public class UserRegistrationDTO {
    @NotBlank
    private String username;

    @Email
    private String email;

    @Size(min = 8, max = 20)
    private String password;
}
```
Estos datos son validados antes de mapearlos a una entidad del dominio.

## Proyección de datos en consultas personalizadas
Los DTOs son utilizados en consultas de bases de datos para devolver datos específicos sin cargar las entidades completas.

Ejemplo (en JPA o Hibernate):
Una consulta que devuelve un ProductSummaryDTO en lugar de la entidad completa Product.
```java
@Query("SELECT new com.example.dto.ProductSummaryDTO(p.name, p.price) FROM Product p WHERE p.available = true")
List<ProductSummaryDTO> findAvailableProducts();
```
```java
public class ProductSummaryDTO {
    private String name;
    private double price;

    public ProductSummaryDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
```

## Aislamiento de entidades en aplicaciones de terceros
En sistemas donde se exponen datos a aplicaciones de terceros (por ejemplo, integraciones con otras empresas), los DTOs son usados para asegurar que no se exponga lógica interna ni estructuras de datos complejas.

* Ejemplo: En una API pública, se puede usar un ProductDTO para devolver datos de productos sin incluir campos internos como supplierId o warehouseLocation.

## Formateo o transformación de datos
Los DTOs permiten transformar datos antes de enviarlos al cliente o al sistema externo. Esto es útil cuando los datos necesitan un formato específico.

**Ejemplo**: Convertir una fecha almacenada como LocalDateTime en un formato legible para el cliente, como "dd/MM/yyyy":
```java
public class EventDTO {
    private String eventName;
    private String eventDate; // Formato "dd/MM/yyyy"
}
```

## Pruebas unitarias y Mocking
En pruebas unitarias, los DTOs se utilizan como objetos de prueba para simular datos enviados o recibidos sin necesidad de usar entidades reales.

* **Ejemplo**: Crear un DTO simulado para probar un controlador:
```java
UserDTO mockUser = new UserDTO();
mockUser.setUsername("john_doe");
mockUser.setEmail("john.doe@example.com");
```

## Paginación y filtrado
Los DTOs se usan para manejar respuestas de paginación y filtrado en APIs REST, agrupando tanto los datos como la información de la paginación.

**Ejemplo**: Un DTO para devolver una página de resultados:
```java
public class PaginatedResponseDTO<T> {
    private List<T> data;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
}
```

## Auditoría o reportes
En sistemas de auditoría o generación de reportes, los DTOs se usan para representar los datos finales que se mostrarán en los reportes.

**Ejemplo**: Un reporte de transacciones puede usar un TransactionReportDTO que incluya solo los datos relevantes para el reporte, como monto, fecha y usuario.