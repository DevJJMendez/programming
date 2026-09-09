# Spring Boot
Es un framework construido sobre el **Spring Framework** (no lo reemplaza, lo potencia) que permite crear aplicaciones Java de forma rápida, con configuración mínima y con todo lo necesario para producción listo desde el principio.

Piénsalo así: **Spring Framework** es el motor, y **Spring Boot** es el auto ya armado, con las llaves puestas y listo para arrancar. Spring por sí solo te da un ecosistema de módulos increíblemente potente (Core, MVC, Data, Security, etc.), pero configurarlo manualmente (XML interminables, beans definidos a mano, servidores externos) era tedioso y propenso a errores.

--- 

## ¿Qué problema intenta resolver?
Antes de Spring Boot (época de Spring "clásico"), desarrollar una app tenía estos dolores de cabeza:

- **Configuración excesiva**: Archivos XML gigantes o clases `@Configuration` repetitivas para cada proyecto nuevo.

- **Gestión manual de dependencias**: Había que saber exactamente qué versión de cada librería era compatible con las demás (el famoso "dependency hell").

- **Despliegue complicado**: Necesitabas un servidor externo (Tomcat, JBoss, WildFly) instalado, configurado, y empaquetar un `.war` para desplegar ahí.

- **Repetir el mismo boilerplate en cada proyecto nuevo**: configurar el DataSource, el ViewResolver, el logging, etc.

- **Falta de estandarización**: Cada equipo montaba su proyecto Spring de forma distinta.

---
# ¿Cómo lo resuelve?
Spring Boot ataca estos problemas con 4 pilares fundamentales:
1. **Autoconfiguración (`@EnableAutoConfiguration`)**
   - Detecta automáticamente qué hay en tu classpath y configura los beans necesarios. Si detecta el driver de **PostgreSQL**, configura un DataSource automáticamente. Si detecta **spring-webmvc**, configura un DispatcherServlet. Todo esto sigue el principio de "convención sobre configuración": valores por defecto sensatos que puedes sobrescribir si lo necesitas.
```java
@SpringBootApplication // Combina @Configuration, @EnableAutoConfiguration y @ComponentScan
public class MiApp {
    public static void main(String[] args) {
        SpringApplication.run(MiApp.class, args);
    }
}
```

2. **Starters (Dependencias curadas)**
   - En lugar de agregar 10 dependencias sueltas y rezar que sean compatibles, agregas un solo "starter" que ya trae todo lo necesario, testeado y compatible entre sí.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
Esto solo, te trae: Spring MVC, Tomcat embebido, Jackson para JSON, validación, etc.

3. **Servidor embebido**
   - Ya no necesitas instalar Tomcat aparte. Spring Boot lo empaqueta dentro de tu aplicación. Generas un `.jar` ejecutable y corres java `-jar mi-app.jar`. Eso es todo. Ideal para contenedores (Docker) y microservicios.

4. Producción lista (Production-ready)
   - Con `spring-boot-starter-actuator` obtienes métricas, health checks, endpoints de monitoreo, sin escribir una sola línea extra.

---
## ¿Cuál es su estructura/arquitectura?
Una app típica de Spring Boot sigue esta arquitectura en capas:
```bash
com.miempresa.miapp
│
├── MiAppApplication.java        → Punto de entrada (main)
│
├── controller/                  → Capa de presentación (REST/MVC)
│   └── UsuarioController.java   → @RestController, recibe requests HTTP
│
├── service/                     → Capa de lógica de negocio
│   └── UsuarioService.java      → @Service, orquesta reglas de negocio
│
├── repository/                  → Capa de acceso a datos
│   └── UsuarioRepository.java   → @Repository, interactúa con la BD (JPA)
│
├── model/ (o domain/entity/)    → Entidades del dominio
│   └── Usuario.java             → @Entity, mapea tablas de BD
│
├── dto/                         → Objetos de transferencia de datos
│   └── UsuarioDTO.java
│
├── config/                      → Configuraciones personalizadas
│   └── SecurityConfig.java
│
├── exception/                   → Manejo centralizado de errores
│   └── GlobalExceptionHandler.java
│
resources/
├── application.properties       → Configuración (o application.yml)
└── static/, templates/          → Recursos web (si aplica)
```
Flujo de una petición típica:
```
Cliente HTTP → Controller → Service → Repository → Base de Datos
                  ↓            ↓           ↓
               DTO/JSON    Lógica de   Entidad JPA
                            negocio
```
Esta arquitectura sigue el patrón por capas (layered architecture), con inyección de dependencias como columna vertebral: cada capa depende de una interfaz/abstracción, no de una implementación concreta, lo cual facilita testing y mantenibilidad.