# flujo de desarrollo
## 1. Estructura general de un proyecto Spring Boot (recomendada)
```bash
mi-app/
├── src/
│   ├── main/
│   │   ├── java/com/empresa/miapp/
│   │   │   ├── MiAppApplication.java          ← Clase principal
│   │   │   ├── config/                        ← Configuraciones (Security, JPA, etc)
│   │   │   ├── controller/                    ← REST Controllers
│   │   │   ├── service/                       ← Interfaces + Implementaciones
│   │   │   ├── repository/                    ← Repositorios (Spring Data JPA)
│   │   │   ├── model/ o domain/               ← Entidades JPA + DTOs
│   │   │   ├── dto/                           ← Data Transfer Objects
│   │   │   ├── exception/                     ← Manejo de excepciones
│   │   │   ├── mapper/                        ← MapStruct o manual
│   │   │   └── util/ o helper/
│   │   └── resources/
│   │       ├── application.yml (o .properties)
│   │       ├── application-dev.yml
│   │       ├── application-prod.yml
│   │       └── ...
│   └── test/...
├── pom.xml (Maven) o build.gradle (Gradle)
```
## 2. Flujo de desarrollo de un CRUD completo (el más común)
1. Definir la Entidad (Domain Model)
```java
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String email;
    // getters, setters, equals, hashCode (o usar Lombok)
}
```
2. Crear el Repository
```java

```
3. Crear DTOs (muy importante para no exponer entidades)
   * UsuarioRequestDTO, UsuarioResponseDTO, etc.

4. Crear el Service (capa de negocio)
   * Interfaz UsuarioService
   * Implementación UsuarioServiceImpl

5. Crear el Controller (REST API)
```java
@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() { ... }
    
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crear(@Valid @RequestBody UsuarioRequestDTO dto) { ... }
}
```
6. Manejo de Excepciones Global (@ControllerAdvice)

7. Validaciones (@Valid, Jakarta Validation)

## 3. Flujo de una petición HTTP (lo que realmente pasa)
1. Cliente → Controller (recibe la petición)
2. Controller → Service (llama a la lógica de negocio)
3. Service → Repository (accede a la base de datos)
4. Repository → JPA/Hibernate → Base de datos
5. La respuesta vuelve por el mismo camino (Service → Controller → JSON)

## 4. Seguridad (Spring Security) – Flujo típico actual (2026)
La forma moderna y recomendada es usar Spring Security 6 + JWT o OAuth2:

* SecurityConfig.java (con @Configuration)
* SecurityFilterChain bean
* JwtAuthenticationFilter
* UserDetailsService + UserDetails
* Roles y permisos con @PreAuthorize en los controllers/services

Ejemplo básico de estructura:
```bash
config/
├── SecurityConfig.java
├── Jwt/
│   ├── JwtService.java
│   ├── JwtAuthenticationFilter.java
│   └── JwtAuthenticationEntryPoint.java
└── UserDetailsServiceImpl.java
```

## Flujo recomendado de desarrollo (Buenas prácticas)
1. Crear rama (feature/usuarios-crud)
2. Crear Entidad
3. Crear Repository
4. Crear DTOs
5. Crear Service + implementación
6. Crear Controller
7. Agregar validaciones y excepciones
8. Escribir tests (al menos unitarios de Service)
9. Pull Request + Code Review
10. Merge a develop

## Buenas prácticas que deberías ver en el repositorio de tu empresa
* Uso de Lombok (@Data, @Builder, @AllArgsConstructor, etc.)
* MapStruct para mapear Entity ↔ DTO
* Spring Data JPA (evitar queries JPQL cuando se pueda)
* Profiles (dev, test, prod)
* Properties externalizados
* OpenAPI / Swagger para documentación
* Global Exception Handler
* Logging estructurado (SLF4J + MDC)
* Paginated responses