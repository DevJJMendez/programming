# Spring Cloud
Spring Cloud es un conjunto de herramientas y frameworks que facilitan el desarrollo de arquitecturas de microservicios en Java. Se basa en Spring Boot y proporciona soluciones para configuración centralizada, balanceo de carga, descubrimiento de servicios, tolerancia a fallos, gateways API, seguridad, y más.

## ¿Para qué sirve?
Spring Cloud simplifica la gestión y comunicación entre microservicios al proporcionar componentes listos para usar en sistemas distribuidos.

**Principales beneficios:**
✅ Centraliza la configuración con **`Config Server`**

✅ Facilita el descubrimiento de servicios con **`Eureka`**

✅ Implementa balanceo de carga con **`Ribbon`** / **`LoadBalancer`**

✅ Maneja fallos con **`Resilience4j (Circuit Breaker)`**

✅ Protege APIs con **`Spring Security`** y **`OAuth2`**

✅ Implementa comunicación entre microservicios con `Feign Client`

✅ Gestiona tráfico con **`Spring Cloud Gateway`**

✅ Observabilidad con **`Sleuth`** y **`Zipkin`**

## ¿Qué problema resuelve?
**Problemas en arquitecturas monolíticas o microservicios sin gestión centralizada**
* Dificultad en configuración: Cada servicio tiene su propio application.yml.

* Comunicación manual: Necesidad de configurar URLs y puertos estáticos.

* No hay balanceo de carga: Un solo servicio podría saturarse.

* Falta de tolerancia a fallos: Si un microservicio falla, el sistema colapsa.

* Complejidad en la seguridad: Manejar autenticación en cada servicio es difícil.

* Dificultad en monitoreo: Sin herramientas centralizadas, es complicado detectar problemas.

**Spring Cloud lo soluciona con sus módulos**:
✅ Spring Cloud Config → Centraliza configuraciones
✅ Spring Cloud Eureka → Descubrimiento de servicios
✅ Spring Cloud LoadBalancer → Balanceo de carga
✅ Spring Cloud Gateway → API Gateway
✅ Spring Cloud Sleuth + Zipkin → Trazabilidad y monitoreo
✅ Spring Cloud Security → Seguridad OAuth2 y JWT

## Arquitectura de Spring Cloud
Spring Cloud sigue una arquitectura de microservicios desacoplados, donde cada servicio tiene una función específica y se comunican entre sí mediante REST o eventos.

```go
                           +------------------------+
                           | Spring Cloud Gateway  |
                           +-----------+------------+
                                       |
       +---------------------+---------------------+-------------------+
       |                     |                     |                   |
+---------------+    +---------------+    +---------------+    +---------------+
| User Service  |    | Order Service |    | Payment Serv. |    | Inventory Serv.|
+---------------+    +---------------+    +---------------+    +---------------+
       |                     |                     |                   |
       |                     |                     |                   |
       |                     |                     |                   |
+---------------------------------------------------------------+
|                    Spring Cloud Eureka                        |
+---------------------------------------------------------------+

+---------------------------------------------------------------+
|                    Spring Cloud Config                        |
+---------------------------------------------------------------+
```
✔ Spring Cloud Gateway: Entrada única para APIs.
✔ Eureka: Registra y descubre servicios dinámicamente.
✔ Config Server: Administra configuraciones de todos los microservicios.
✔ Servicios independientes: Cada microservicio maneja su lógica de negocio.