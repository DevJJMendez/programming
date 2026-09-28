# Asíncrono
El término asíncrono se refiere a un modelo de ejecución no bloqueante en el que una operación se inicia y luego continúa su ejecución, sin esperar a que la operación finalice para seguir con otras tareas.

*Es como dejar la ropa en la lavandería: haces el encargo, te vas a hacer otras cosas, y luego vuelves por ella cuando está lista.*

## ¿Cuál es su estructura?
Una operación asíncrona tiene dos componentes clave:

Inicio de la tarea

Manejo del resultado cuando esté disponible (callback, promesa, evento, observable…)

Ejemplo abstracto:
```bash
Cliente --> [ Inicia tarea ]
Cliente --> [ Continúa otras tareas ]
Servidor --> [ Respuesta llega más tarde ]
Cliente --> [ Maneja la respuesta ]
```

## ¿Qué resuelve?
✅ El modelo asíncrono optimiza el uso de recursos y mejora el rendimiento del sistema, resolviendo problemas como:

🧍‍♂️ Bloqueo del cliente	El cliente no espera, puede seguir haciendo otras tareas.
🔄 Escalabilidad	Se pueden manejar miles de tareas concurrentes sin bloquear hilos.
🐢 Latencia externa	Ideal para llamadas a APIs lentas, I/O, base de datos, etc.

## ¿Cómo lo resuelve?
El patrón asíncrono emplea:

Callbacks (funciones que se ejecutan al completarse una tarea)

Promises (JS), Futures (Java), async/await (JS, Python, etc.)

Eventos y colas de mensajes (RabbitMQ, Kafka)

Observables (RxJS)

## Ejemplo en JavaScript
```js
fetch('/api/users')
  .then(response => response.json())
  .then(data => console.log(data));
```
O con `async`/`await`:
```js
async function loadUsers() {
  const response = await fetch('/api/users');
  const data = await response.json();
  console.log(data);
}
```
Aquí, la función loadUsers se pausa sin bloquear el hilo mientras se espera la respuesta.

## ¿Dónde se usa lo Asíncrono?
🔧 Casos típicos:

Llamadas a servicios externos (APIs REST, GraphQL)

Operaciones de E/S (bases de datos, archivos)

Notificaciones push / WebSockets

Procesamiento en background

Microservicios que se comunican por eventos o colas (event-driven architecture)

## Ejemplo de arquitectura real
Imagina una aplicación de ecommerce que al recibir una orden:

Crea la orden (síncrono)

Encola un mensaje para facturación (asíncrono)

Encola otro mensaje para envío de email (asíncrono)

Así, el usuario no tiene que esperar a que todos los servicios terminen su trabajo.

## Conceptos relacionados
Event Loop: núcleo del modelo asíncrono en JavaScript.

Event-driven architecture: microservicios que reaccionan a eventos.

Pub/Sub: patrón para comunicación asíncrona entre servicios.

## Desventajas
￼
Desventaja	Explicación
🔄 Complejidad	El flujo lógico puede volverse difícil de seguir
🧪 Difícil de testear	Los test deben esperar o simular resultados
🪲 Errores difíciles de detectar	Bugs como "race conditions" o "callback hell"