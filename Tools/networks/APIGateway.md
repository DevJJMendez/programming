# API Gateway
Un API Gateway es un único punto de entrada (entry point) para todos los clientes que interactúan con un conjunto de microservicios backend o APIs internas. Se encarga de recibir, enrutar, transformar, asegurar y monitorear las solicitudes.

🔁 Piensa en él como el portero y coordinador central que decide a dónde enviar cada solicitud, cómo transformarla, y cómo aplicar reglas de seguridad y control de acceso.

## estructura
```bash
[Cliente] ---> [API Gateway] ---> [Microservicio 1]
                              ---> [Microservicio 2]
                              ---> [Microservicio 3]
```
El Gateway se encarga de:
📍 Enrutamiento (routing inteligente)

🔒 Seguridad (autenticación, autorización)

📊 Rate limiting y throttling

🔁 Transformación de payloads (JSON ↔️ XML, etc.)

📥 Agregación de respuestas de múltiples servicios

🛡️ Validación de tokens (OAuth2, JWT)

📃 Logging, métricas, tracing

🔄 Caching de respuestas

## ¿Qué resuelve?
| Problema en microservicios/API        | Cómo lo resuelve un API Gateway                    |
| ------------------------------------- | -------------------------------------------------- |
| Múltiples puntos de entrada           | Único endpoint centralizado                        |
| Lógica repetida en cada microservicio | Se centraliza en el gateway                        |
| Seguridad descentralizada             | Se aplica en el gateway                            |
| Alta latencia por múltiples llamadas  | Agregación de respuestas                           |
| Diversidad de clientes                | Negociación de contenido (Content-Type, versiones) |

## ¿Cómo lo resuelve?
El API Gateway funciona como un middleware inteligente entre el cliente y tus servicios internos. Algunas funciones clave:

✅ Validación de autenticación: valida JWT, OAuth2, API Keys.

🗺️ Routing dinámico: por path, subdominio, headers o versión.

🔄 Reescritura de solicitudes/respuestas: cambia body, headers, formatos.

⏱️ Rate Limiting y Quotas: controla uso de recursos.

📦 Caching: cachea respuestas comunes.

🔍 Métricas y logging: útiles para observabilidad y debugging.

🧩 Service Discovery: sabe a qué servicio enviar la petición dinámicamente (útil con Kubernetes, Consul, etc.).

## Ejemplo real en un ecommerce
Imagina este flujo:
```bash
https://api.mi-tienda.com/

- /catalogo  → servicio de productos
- /carrito   → servicio de compras
- /usuario   → servicio de autenticación
- /pago      → servicio de pasarela
```
Todo esto pasa por el API Gateway, que:

✅ Valida el token JWT del usuario

🔀 Redirige al microservicio correcto

🚫 Limita la cantidad de llamadas por minuto

🔐 Aplica CORS y HTTPS

🔁 Convierte una respuesta en JSON aunque el backend hable XML

## Ejemplos de API Gateway en la industria
🔧 Open Source:
Kong: basado en NGINX, muy extensible.

KrakenD: ideal para agregación de microservicios.

Ambassador: pensado para Kubernetes, sobre Envoy.

Traefik: se integra muy bien con Docker/Kubernetes.

☁️ Cloud (Managed):
AWS API Gateway

Azure API Management

Google API Gateway

Apigee (Google)

## Diferencia entre API Gateway y Reverse Proxy
| Característica      | Reverse Proxy         | API Gateway                |
| ------------------- | --------------------- | -------------------------- |
| Enrutamiento        | Sí                    | Sí                         |
| Autenticación       | Opcional              | Incorporada                |
| Transformaciones    | Limitadas             | Avanzadas (JSON/XML, etc.) |
| Rate Limiting       | No siempre            | Sí                         |
| Agregación de datos | No                    | Sí                         |
| Ideal para          | Capa de red / tráfico | Microservicios y APIs      |

## Buenas prácticas
Usa JWT o OAuth2 como método de autenticación.

Implementa rate limiting para proteger tus backends.

Aplica logging estructurado para trazabilidad.

Divide endpoints por versión (/v1/, /v2/) y tipo (/admin/, /public/).

Haz pruebas con herramientas como Postman, Insomnia y K6.

Monitorea métricas con Prometheus + Grafana o Datadog.