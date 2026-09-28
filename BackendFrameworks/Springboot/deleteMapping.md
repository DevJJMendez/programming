El diseño de los métodos con @DeleteMapping para APIs REST debe seguir prácticas que garanticen claridad, idempotencia, y un manejo adecuado de errores. Un método DELETE se utiliza para eliminar un recurso existente y debe ser idempotente, es decir, múltiples solicitudes DELETE para el mismo recurso deberían producir el mismo estado final en el servidor.

1.  Implementación Básica
Un método básico para manejar una solicitud DELETE se ve así:
```java
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.ok("Category deleted successfully");
}
```
Explicación
@PathVariable: Captura el ID del recurso desde la URL.
Respuesta:
Devuelve 200 OK si la eliminación fue exitosa.
No hace verificación previa sobre la existencia del recurso.

2. Manejo de Errores
Es importante manejar el caso donde el recurso no existe o no puede ser eliminado.
```java
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
    if (!categoryService.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found");
    }
    categoryService.deleteCategory(id);
    return ResponseEntity.ok("Category deleted successfully");
}
```
Mejoras
Validación previa: Comprueba si el recurso existe antes de intentar eliminarlo.
Manejo de errores: Devuelve un código 404 Not Found si el recurso no se encuentra.

3. Uso de Respuestas Estandarizadas -> Para una API más consistente, utiliza una clase (APIResponse) para estructurar las respuestas.

4. Uso de Servicios para Desacoplar Lógica -> La lógica de negocios debe estar en un servicio, no en el controlador.

5. Manejo Global de Excepciones
Es una buena práctica capturar las excepciones en un controlador global para simplificar el código.

Controlador de Excepciones Global
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(ex.getMessage(), false));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("An unexpected error occurred", false));
    }
}
```
Controlador Simplificado
Con un controlador de excepciones, el método DELETE queda mucho más limpio:
```java
@DeleteMapping("/{id}")
public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.ok(new ApiResponse("Category deleted successfully", true));
}
```

### Implementación Escalable y Eficiente
1. Validación de Permisos
Si los recursos están asociados a un usuario, puedes validar que el usuario actual tiene permisos para eliminarlos.
```java
@DeleteMapping("/{id}")
public ResponseEntity<ApiResponse> deleteCategory(
        @PathVariable Long id,
        @AuthenticationPrincipal UserDetails userDetails) {
    if (!categoryService.isOwnedByUser(id, userDetails.getUsername())) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ApiResponse("You do not have permission to delete this category", false));
    }
    categoryService.deleteCategory(id);
    return ResponseEntity.ok(new ApiResponse("Category deleted successfully", true));
}
```

2. Uso de Soft Deletes
En lugar de eliminar un recurso físicamente, puedes implementar un "soft delete" (eliminar lógicamente) marcándolo como inactivo.
```java
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private boolean deleted = false;

    // Getters y setters
}
```
Servicio con Soft Delete
```java
public void deleteCategory(Long id) {
    Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Category not found"));

    category.setDeleted(true);
    categoryRepository.save(category);
}
```

## Documentación y Versionamiento
Versionamiento de APIs
Si realizas cambios en la estructura de la API, utiliza el versionamiento:
```java
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    // Métodos aquí
}
```
Respuesta Documentada
Usa herramientas como Swagger para generar documentación automática:
```java
@DeleteMapping("/{id}")
@ApiOperation(value = "Delete a category", notes = "Deletes a category by its ID")
public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.ok(new ApiResponse("Category deleted successfully", true));
}
```
