# Webhooks
Un webhook es un mecanismo de comunicación HTTP basado en eventos, donde un sistema (emisor) envía automáticamente una petición HTTP (generalmente POST) a otro sistema (receptor) cuando ocurre un evento específico.

*Es una forma pasiva y event-driven de integrar sistemas. En lugar de que un sistema tenga que hacer polling constantemente para preguntar “¿hay algo nuevo?”, el emisor simplemente notifica al receptor cuando algo ocurre.*

## ¿Cuál es su estructura?
Un webhook es básicamente una petición HTTP POST, enviada a una URL configurada previamente, y que contiene datos relevantes del evento.

Ejemplo de estructura de un webhook:
Request:
```bash
POST /webhook/pedido HTTP/1.1
Host: api.misitio.com
Content-Type: application/json

{
  "event": "order.created",
  "data": {
    "id": "12345",
    "status": "paid",
    "customer": {
      "name": "Juan Pérez"
    }
  },
  "timestamp": "2025-04-25T12:00:00Z"
}
```
Componentes clave:
URL de destino (endpoint receptor).

Método HTTP (generalmente POST).

Cabeceras (a veces incluyen firma de autenticidad).

Payload con los datos del evento.

## ¿Qué resuelve?
Notificaciones en tiempo real entre sistemas.

Integraciones automáticas entre APIs o servicios.

Sincronización de datos, sin hacer polling.

Desacoplamiento entre sistemas (arquitectura orientada a eventos).

## ¿Cómo lo resuelve?
Un sistema (emisor) detecta un evento (ej. pago recibido, usuario creado).

Dispara un webhook: hace una petición POST con los datos del evento a la URL configurada.

El receptor (tu backend o microservicio) procesa esa petición como cualquier otra.

Opcionalmente, responde con un HTTP 200 OK para confirmar la recepción.

## Ejemplos reales de Webhooks
￼
Escenario	Qué sucede
🛒 Stripe - Pago recibido	Stripe envía un webhook a tu backend con los datos del pago.
📦 Shopify - Nuevo pedido	Shopify te notifica cuando un usuario hace una compra.
🧠 GitHub - Push a repositorio	GitHub lanza un webhook que actualiza tu CI/CD pipeline.
📧 Mailgun - Email entregado o rebotado	Puedes rastrear eventos de emails.
💬 Slack - Slash command o integración externa	Envía datos a tu servidor para responder interacciones.

## Ventajas
Bajo acoplamiento.

Eficiencia (sin polling).

Escalabilidad orientada a eventos.

Rápida integración entre servicios.

## Consideraciones de seguridad
Verifica firmas (ej. HMAC-SHA256) para asegurarte que provienen del emisor real.

HTTPS obligatorio.

Autenticación opcional mediante headers o tokens.

Rate limiting y retry policies para evitar abuso.

Logs para trazabilidad.

## Buenas prácticas
￼
Recomendación	Por qué
Usar un endpoint dedicado (/webhooks/...)	Para mejor trazabilidad y separación de lógica.
Registrar eventos recibidos en base de datos	Para debugging, monitoreo y replay manual.
Implementar reintentos en caso de error (HTTP ≠ 200)	Algunos servicios reintentan automáticamente.
Validar la estructura del payload	Evita errores y exploits.
Hacer procesamiento asíncrono (guardar y delegar a un worker)	No bloquear la respuesta HTTP y escalar mejor.

## Herramientas para trabajar con Webhooks
ngrok: Para exponer tu backend local y testear webhooks.

Webhook.site: Para inspeccionar peticiones entrantes.

Postman: Para simular eventos.

Servicios como Zapier / n8n: Permiten orquestar flujos de webhooks.

## Diferencias entre Webhooks vs APIs REST tradicionales
￼
Característica	Webhook	REST API
Flujo	Pushed (evento)	Pulled (consulta)
Iniciador	Emisor (otro sistema)	Cliente (tú)
Tiempo de ejecución	Asíncrono/event-driven	Sincrónico
Ideal para	Notificaciones en tiempo real	Operaciones CRUD