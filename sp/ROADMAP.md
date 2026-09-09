```
                    ┌─────────────────────────┐
                    │  1. Java sólido         │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  2. Spring Fundamentals │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  3. Spring Boot         │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  4. REST APIs            │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  5. Persistencia         │
                    │     JPA / Hibernate      │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  6. Arquitectura         │
                    │     SOLID / Clean Code   │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  7. Seguridad            │
                    │     Spring Security      │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  8. Testing              │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │  9. Escalabilidad        │
                    │     Redis / Kafka / etc. │
                    └────────────┬────────────┘
                                 ↓
                    ┌─────────────────────────┐
                    │ 10. Producción           │
                    │ Docker / CI/CD / Cloud   │
                    └─────────────────────────┘
```

# IoC + DI
Este es probablemente el concepto más importante de Spring.

Debes comprender:
```
Sin Spring

Controller
    ↓
new Service()
    ↓
new Repository()
```
vs.
```
Con Spring

        Spring Container
              │
       ┌──────┼──────┐
       ↓      ↓      ↓
 Controller Service Repository
       │      │      │
       └──────┴──────┘
```
Temas
- IoC
- Dependency Injection
- Spring Container
- Beans
- ApplicationContext
- Component scanning
- @Component
- @Service
- @Repository
- @Controller

Y posteriormente:
- Bean lifecycle
- Bean scopes
- Configuration
- Profiles
- @Configuration
- @Bean

# Spring Boot
Conceptos
- Spring Boot
- Starters
- Auto Configuration
- Embedded servers
- application.properties
- application.yml
- Profiles
- Configuration properties
- Environment variables
- Actuator

Aprenderás a construir:
```
Spring Boot Application
        │
        ├── Configuration
        ├── Beans
        ├── Controllers
        ├── Services
        └── Repositories
```

# Spring Web / REST API
Esta será una de nuestras primeras grandes etapas prácticas.

Aprenderás a construir APIs como:
```
GET    /api/users
GET    /api/users/{id}
POST   /api/users
PUT    /api/users/{id}
DELETE /api/users/{id}
```
## Spring MVC
- @RestController
- @RequestMapping
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping


## HTTP
Necesitas dominar:
- GET
- POST
- PUT
- PATCH
- DELETE

Y:
- 200 OK
- 201 Created
- 204 No Content
- 400 Bad Request
- 401 Unauthorized
- 403 Forbidden
- 404 Not Found
- 409 Conflict
- 500 Internal Server Error

### DTOs
Uno de los puntos donde quiero que desarrolles criterio arquitectónico.

Aprender:
```
Entity
   ↓
Mapper
   ↓
DTO
   ↓
Controller
```
En lugar de:
```
Controller
   ↓
Entity
```
También:
- Request DTO
- Response DTO
- Validation DTO

## Validación
Spring Validation:
```java
@NotNull
@NotBlank
@NotEmpty
@Email
@Size
@Min
@Max
@Pattern
```
Y:
```java
@Valid
```

## Exception Handling
Aprenderemos:
```java
@ControllerAdvice
@ExceptionHandler
```
para construir respuestas consistentes:
```json
{
    "status": 404,
    "message": "User not found",
    "timestamp": "...",
    "path": "/api/users/10"
}
```

# Persistencia
Aquí entran:

JPA + Hibernate + Spring Data JPA
Debes entender primero JPA, después Hibernate y finalmente Spring Data.

## JPA
- Entity
- Persistence Context
- EntityManager
- Primary Key
- Relationships
- Transactions

Relaciones:
```java
@OneToOne

@OneToMany

@ManyToOne

@ManyToMany
```
Y entender:
- LAZY
- EAGER
- Cascade
- Orphan removal
- Fetch strategies

## Spring Data JPA
```java
public interface UserRepository
        extends JpaRepository<User, Long> {
}
```
Aprender:
- Derived queries
- JPQL
- Native queries
- Specifications
- Pagination
- Sorting
- Projections

## Transacciones
Fundamental:
```java
@Transactional
```
Pero no quiero que simplemente memorices la anotación.

Debes entender:
```
Transaction
    │
    ├── Atomicity
    ├── Consistency
    ├── Isolation
    └── Durability
```
Y problemas como:
- Dirty reads
- Non-repeatable reads
- Phantom reads
- Optimistic locking
- Pessimistic locking

# SOLID + Clean Code + Arquitectura
Aquí comienza la parte que considero más importante para convertirte en un buen backend developer.

No quiero que solamente sepas hacer:
```
Controller → Service → Repository
```
Quiero que entiendas cuándo esa estructura tiene sentido y cuándo no.

## SOLID
- **S — Single Responsibility** - Una clase debe tener una única razón para cambiar.

- **O — Open/Closed** - Abierto a extensión, cerrado a modificación.

- **L — Liskov Substitution** - Las abstracciones deben poder sustituirse correctamente.

- **I — Interface Segregation** - Interfaces pequeñas y específicas.

- **D — Dependency Inversion** - Los módulos de alto nivel no deben depender de detalles.

## Clean Code
Aprenderemos:
- Naming
- Métodos pequeños
- Clases pequeñas
- Cohesión
- Acoplamiento
- DRY
- KISS
- YAGNI
- Early return
- Eliminación de código muerto
- Evitar comentarios innecesarios
- Diseño de APIs internas

Y algo fundamental: Clean Code no significa código bonito. Significa código fácil de cambiar.

## Arquitecturas
Aquí vamos a profundizar bastante.

1. Arquitectura por capas
```
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Después:

2. Hexagonal Architecture
```
              ┌───────────────┐
              │   REST API    │
              └───────┬───────┘
                      ↓
             ┌─────────────────┐
             │     DOMAIN      │
             │                 │
             │ Business Rules  │
             └─────────────────┘
                      ↑
             ┌────────┴────────┐
             │                 │
        Database           External API
```

Y después:

3. Clean Architecture
```
          Frameworks
               ↓
       Interface Adapters
               ↓
        Application Layer
               ↓
          Domain Layer
```
Aprenderemos:
- Dependency Rule
- Ports & Adapters
- Use Cases
- Entities
- DTOs
- Mappers
- Ports
- Adapters

# Spring Security
Una aplicación real necesita seguridad.

Aprenderemos:

* **Authentication**
```
¿Quién eres?
```
* **Authorization**
```
¿Qué puedes hacer?
```
Temas:
- Spring Security
- Security Filter Chain
- Authentication
- Authorization
- Password hashing
- BCrypt
- Roles
- Authorities
- JWT
- Refresh tokens
- CORS
- CSRF
- OAuth2
- OAuth2 Resource Server

Y diseñaremos:
```
Client
   ↓
JWT
   ↓
Spring Security
   ↓
Authentication
   ↓
Authorization
   ↓
Controller
```

# Testing
Un backend profesional no solamente funciona.

Debe poder demostrar que funciona.

* **Unit Testing**
  - JUnit
  - Mockito
  - Assertions
  - Test doubles
  - Mocks
  - Stubs
  - Spies

* Integration Testing
  - @SpringBootTest
  - @WebMvcTest
  - @DataJpaTest
  - Testcontainers

Y posteriormente:
```
Application
     ↓
Real database
     ↓
Real infrastructure
```
* **Testing de APIs**
  - MockMvc
  - REST Assured

Y aprenderemos también: Qué debemos testear y qué no necesitamos testear.

# Aplicaciones distribuidas y escalables
Cuando ya dominemos Spring Boot tradicional, entramos en terreno avanzado.

## Caching
Redis:
```
Client
  ↓
API
  ↓
Redis
  ↓
Database
```
Aprender:
- Cache
- Cache eviction
- TTL
- Cache aside
- Spring Cache

## Mensajería
**Kafka / RabbitMQ.**

Conceptos:
- Producer
- Consumer
- Topic
- Partition
- Offset
- Consumer group
- Message ordering
- Retry
- Dead Letter Queue

Arquitectura:
```
Service A
    │
    ↓
   Kafka
    │
    ├────────→ Service B
    │
    └────────→ Service C
```

## Microservicios
No empezaremos aquí.

Primero monolitos bien diseñados.

Después:
```
Monolith
   ↓
Modular Monolith
   ↓
Distributed System
   ↓
Microservices
```

Estudiaremos:
- Service discovery
- API Gateway
- Configuration server
- Resilience
- Circuit breaker
- Retry
- Timeout
- Distributed tracing

## Performance
Una aplicación puede funcionar perfectamente y ser pésima en producción.

Aprenderemos:

## Database
- Índices
- Query optimization
- N+1 problem
- Connection pool
- HikariCP
- Pagination

## JVM
- Heap
- Stack
- GC
- Threads
- Profiling

## Spring
- Bean initialization
- Lazy loading
- Caching
- Async processing

Y herramientas para medir antes de optimizar. No optimizamos por intuición. Medimos.

## Observabilidad
Aplicaciones profesionales necesitan poder responder:

¿Qué está pasando en producción?

Aprenderás:
- Logs
- Metrics
- Traces

Stack típico:
```
Spring Boot
    │
    ├── Actuator
    ├── Micrometer
    ├── Prometheus
    └── Grafana
```

Además:
- Structured logging
- Correlation ID
- Distributed tracing
- Health checks
- Readiness
- Liveness

## Docker + CI/CD + Producción
Finalmente:

## Docker
```
Spring Boot
      ↓
Docker Image
      ↓
Container
```
Aprender:
- Dockerfile
- Images
- Containers
- Volumes
- Networks
- Docker Compose

## CI/CD
Pipeline:
```
Git
 ↓
Build
 ↓
Tests
 ↓
Static Analysis
 ↓
Docker Image
 ↓
Deploy
```
Herramientas que podemos estudiar:
- GitHub Actions
- Jenkins
- SonarQube

# Y hay otro roadmap que quiero que estudies en paralelo
Porque saber Spring Boot no es suficiente.

Mientras avanzamos quiero introducir progresivamente:

Patrones de diseño
Primero:
```
Strategy
Factory
Builder
Adapter
Decorator
Template Method
Observer
Command
Facade
```
Después patrones arquitectónicos:
```
Repository
Service Layer
Unit of Work
CQRS
Event Sourcing
Saga
Outbox
```
No los estudiaremos como teoría aislada.

Los aprenderemos cuando exista un problema real que justifique el patrón.