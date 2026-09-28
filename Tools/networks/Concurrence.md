# Concurrencia
La concurrencia es la capacidad de un sistema para ejecutar múltiples tareas lógicamente al mismo tiempo.

Es importante entender que concurrencia ≠ paralelismo:

Concurrencia: múltiples tareas progresan al mismo tiempo.

Paralelismo: múltiples tareas se ejecutan físicamente al mismo tiempo (varios núcleos).

## ¿Cuál es su estructura / cómo se organiza?
La concurrencia puede organizarse mediante distintos mecanismos:

🔹 A nivel de software
Threads (hilos): cada uno ejecuta una tarea concurrentemente.

Procesos: múltiples procesos concurrentes (menos eficientes que los hilos).

Corutinas (coroutines): ligeras, ideales para I/O intensivo (ej. async/await).

Fibras (fibers): más bajo nivel, parecidas a corutinas.

🔹 A nivel de arquitectura
Event Loop (como en Node.js o Python asyncio)

Message Queues (como RabbitMQ, Kafka)

Actors (como en Akka o Elixir)

Worker Pools (como en Golang con goroutines y channels)

## ¿Qué resuelve?
| Problema en sistemas       | Solución con concurrencia                        |
| -------------------------- | ------------------------------------------------ |
| Tiempos de espera en I/O   | Permite continuar mientras esperas               |
| Procesos bloqueantes       | Usa hilos/corutinas para no detener el flujo     |
| Bajo uso de CPU por espera | Optimiza el uso de recursos                      |
| Escalabilidad de servicios | Permite manejar múltiples peticiones simultáneas |

## ¿Cómo lo resuelve?
Depende del lenguaje/plataforma:

🧵 Con Threads:
Cada tarea se ejecuta en un hilo separado, el sistema operativo intercala su ejecución.
```java
Thread hilo = new Thread(() -> hacerTarea());
hilo.start();
```
Con async/await:
Se utiliza un event loop que gestiona múltiples tareas en espera (ideal para I/O).
```js
async function fetchData() {
  const data = await fetch('api/data');
  return data.json();
}
```

Con goroutines (Go):
Golang permite lanzar funciones concurrentes muy ligeras.
```go
go procesarPedido()
```

Con colas:
Los productores envían tareas a una cola, los consumidores las procesan en paralelo.

## Ejemplo en la vida real
Imagina una API de eCommerce:

Cada solicitud para consultar productos puede ir en una corutina o hilo.

Si hay llamadas externas (pagos, correos), se hacen de forma asíncrona.

El sistema puede procesar múltiples carritos simultáneamente sin bloquear otros.

## Peligros y desafíos
Race conditions: cuando dos tareas acceden/modifican un recurso al mismo tiempo sin sincronización.

Deadlocks: dos tareas esperan eternamente por recursos bloqueados entre sí.

Starvation: una tarea nunca obtiene acceso al recurso por mal diseño de prioridades.

Context switching overhead: muchos hilos mal gestionados pueden degradar el rendimiento.

## Buenas prácticas
Usa corutinas/async para operaciones I/O.

Usa sincronización (mutexes, semáforos, locks) solo donde sea necesario.

Evita bloqueos prolongados en tareas concurrentes.

Mide y monitorea la performance y latencia en sistemas concurrentes.

Prueba con herramientas como stress tests y race detectors.

## Conclusión
La concurrencia es clave para escalar y optimizar software moderno, especialmente en microservicios, APIs, bases de datos, motores de juego, etc. Aprender a dominarla te abre las puertas a resolver problemas complejos de rendimiento y arquitectura.