El diseño de los @PutMapping en las APIs REST requiere seguir prácticas estándar para garantizar que el sistema sea robusto, escalable y mantenible. Un PUT se usa para actualizar recursos existentes, aunque en algunos casos puede crear recursos si aún no existen (idempotencia).

Estructura Básica de un PUT
Un método básico para manejar una solicitud PUT es recibir un recurso completo que será actualizado:
```java
@PutMapping("/{id}")
public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category) {
    categoryService.updateCategory(id, category);
    return ResponseEntity.ok("Category updated successfully");
}
```
Explicación
@PathVariable: Captura el ID del recurso a actualizar desde la URL.
@RequestBody: Recibe el cuerpo de la solicitud con el objeto a actualizar.
Respuesta: Devuelve un código 200 OK con un mensaje de confirmación.

Añadiendo Validaciones Básicas
Se pueden agregar validaciones para garantizar que los datos enviados son correctos.
```java
@PutMapping("/{id}")
public ResponseEntity<?> updateCategory(
        @PathVariable Long id,
        @Valid @RequestBody Category category) {
    if (!categoryService.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found");
    }
    categoryService.updateCategory(id, category);
    return ResponseEntity.ok("Category updated successfully");
}
```
Mejoras
Validación con @Valid: Usa anotaciones como @NotNull, @Size y otras en la clase Category.
Verificación de existencia: Comprueba si el recurso existe antes de intentar actualizarlo.

Clase Category con validaciones
```java
public class Category {
    @NotNull
    private String name;

    @Size(max = 255)
    private String description;

    // Getters y setters
}
```

Uso de DTOs para Desacoplar la Entrada
Los DTOs (Data Transfer Objects) permiten separar los datos de entrada de las entidades del dominio. Esto ayuda a prevenir problemas como la sobreexposición de datos y facilita la validación.

DTO para actualización
```java
public class UpdateCategoryDTO {
    @NotNull
    private String name;

    @Size(max = 255)
    private String description;

    // Getters y setters
}
```
Controlador con DTO
```java
@PutMapping("/{id}")
public ResponseEntity<?> updateCategory(
        @PathVariable Long id,
        @Valid @RequestBody UpdateCategoryDTO updateCategoryDTO) {
    if (!categoryService.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found");
    }

    categoryService.updateCategory(id, updateCategoryDTO);
    return ResponseEntity.ok("Category updated successfully");
}
```
Ventajas de usar DTOs
Desacopla la capa de dominio de la API pública.
Facilita la validación personalizada.
Mejora la claridad y el mantenimiento.

Respuestas Estandarizadas
Para que la API sea más comprensible, utiliza un objeto de respuesta estándar en lugar de devolver cadenas de texto.

Clase estándar de respuesta
```java
public class ApiResponse<T> {
    private String message;
    private T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // Getters y setters
}
```
Método con respuesta estándar
```java
@PutMapping("/{id}")
public ResponseEntity<ApiResponse<Category>> updateCategory(
        @PathVariable Long id,
        @Valid @RequestBody UpdateCategoryDTO updateCategoryDTO) {
    if (!categoryService.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>("Category not found", null));
    }

    Category updatedCategory = categoryService.updateCategory(id, updateCategoryDTO);
    return ResponseEntity.ok(new ApiResponse<>("Category updated successfully", updatedCategory));
}
```

## Implementación Escalable y Segura
Para una implementación escalable y robusta:

1. Controlador de Errores Global: Captura excepciones como EntityNotFoundException o ConstraintViolationException.
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(ex.getMessage(), null));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationErrors(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>("Validation failed", ex.getMessage()));
    }
}
```
2. Servicios desacoplados: Usa un servicio para manejar la lógica de actualización.
```java
@Service
public class CategoryService {

    public Category updateCategory(Long id, UpdateCategoryDTO dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        return categoryRepository.save(category);
    }
}
```
Respuesta HTTP adecuada:
200 OK: Actualización exitosa.
404 Not Found: Recurso no encontrado.
400 Bad Request: Datos inválidos.

### Uso de Patrones Avanzados
1. Patrón Builder para la Respuesta: Crea una clase de ayuda para construir respuestas HTTP.
```java
public class ResponseBuilder {
    public static <T> ResponseEntity<ApiResponse<T>> build(String message, T data, HttpStatus status) {
        return ResponseEntity.status(status)
                .body(new ApiResponse<>(message, data));
    }
}
```
Uso en el Controlador
```java
@PutMapping("/{id}")
public ResponseEntity<?> updateCategory(
        @PathVariable Long id,
        @Valid @RequestBody UpdateCategoryDTO dto) {
    if (!categoryService.existsById(id)) {
        return ResponseBuilder.build("Category not found", null, HttpStatus.NOT_FOUND);
    }

    Category updatedCategory = categoryService.updateCategory(id, dto);
    return ResponseBuilder.build("Category updated successfully", updatedCategory, HttpStatus.OK);
}
```
Versionamiento de APIs: Diseña APIs versionadas (/v1/categories, /v2/categories) para cambios futuros sin romper integraciones.