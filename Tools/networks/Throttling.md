# Throttling
Throttling (estrangulamiento o limitación de velocidad) es una técnica de control de tráfico que restringe la cantidad de solicitudes o peticiones que un cliente puede hacer a un servidor, API o sistema, durante un período de tiempo específico.

*🔐 Es una capa de defensa que protege recursos compartidos y mejora la disponibilidad del sistema.*

##  ¿Cuál es su estructura/concepto técnico?
Imagina un sistema que impone una regla como:

“Cada usuario puede hacer máximo 100 requests por minuto”.

Se usan contadores, ventanas de tiempo y almacenamiento en memoria (como Redis) o en tokens para seguir el número de peticiones por cliente.

## ¿Qué resuelve?
Throttling ayuda a resolver varios problemas críticos:

Prevención de abusos (como ataques de denegación de servicio).

Mejora la calidad de servicio (evita la sobrecarga).

Fair usage policy (todos los usuarios tienen igual acceso).

Control de costos en servicios que se cobran por uso.

Protección ante errores de programación en clientes (bucles de requests).

## ¿Cómo lo resuelve?
Existen varios enfoques comunes:

📏 Rate-based (por cantidad):
Ej: 60 requests por minuto.

Se implementa con contadores y ventanas de tiempo.

🎫 Token Bucket:
Se genera un “bucket” con tokens (p. ej., 100).

Cada solicitud consume un token.

Los tokens se regeneran con el tiempo.

⏳ Leaky Bucket:
Como una cubeta con agujero: las solicitudes entran y se procesan a velocidad constante.

Exceso se descarta o se pone en cola.

🔁 Sliding Window:
Se cuentan las solicitudes dentro de una ventana de tiempo móvil (no fija como en “por minuto”).

## Ejemplo real:
Supón que una API pública impone:
```bash
X-RateLimit-Limit: 60
X-RateLimit-Remaining: 3
X-RateLimit-Reset: 1682456660
```
Significa:

Tienes un límite de 60 requests.

Te quedan 3.

El límite se restablece en el timestamp Unix 1682456660.

## ¿Dónde se usa Throttling?
￼
Área	Ejemplo de uso
APIs REST	Limitar consumo por IP/token
Servicios Web	Restringir ataques o abuso
Servicios cloud (AWS, GCP)	Control de costos y recursos
Bases de datos	Evitar exceso de consultas simultáneas
UI/UX	Limitar inputs del usuario (debounce)

## ¿Throttling vs Rate Limiting?
Rate Limiting: Específico en cuántas solicitudes puedes hacer.

Throttling: Es más flexible, puede incluir demoras, colas, o rechazos parciales.

💡 En la práctica, muchas veces ambos términos se usan como sinónimos, pero rate limiting es un subtipo de throttling.