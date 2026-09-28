# Síncrono
Síncrono se refiere a una forma de comunicación o ejecución en la que una tarea debe esperar a que otra termine antes de continuar.

Es como una fila en una panadería: cada cliente (tarea) espera su turno hasta que el anterior haya sido atendido.

## ¿Cuál es su estructura?
En una llamada síncrona, el cliente envía una petición al servidor, y espera hasta recibir la respuesta para continuar.

📦 Estructura típica de una operación síncrona:
```bash
[ Cliente ] --> (request) --> [ Servidor ]
             <-- (response) <--
```
Durante esa espera:

El hilo que realiza la solicitud se bloquea.

No puede ejecutar nada más hasta que reciba la respuesta.

## ¿Qué problema resuelve?
El modelo síncrono es más fácil de razonar y depurar, porque:

Las tareas se ejecutan en orden predecible.

Los errores se capturan en el mismo flujo.

El código tiende a ser más secuencial y lineal, lo cual facilita la lógica.

## ¿Cómo lo resuelve?
Resuelve la necesidad de control estricto en escenarios como:

| Escenario                 | Cómo lo resuelve                                                                                |
| ------------------------- | ----------------------------------------------------------------------------------------------- |
| Operaciones dependientes  | Si la tarea B necesita el resultado de la tarea A, el flujo síncrono asegura el orden correcto. |
| Procesamiento paso a paso | El cliente puede tomar decisiones basadas en la respuesta inmediatamente después de recibirla.  |
| Consistencia inmediata    | Asegura que las operaciones ocurran en un orden definido, lo cual es útil en transacciones.     |

## Ejemplo en la vida real
Imagina que estás usando una API REST para hacer un pago con tarjeta:
```bash
POST /procesar-pago
{
  "monto": 100,
  "tarjeta": "**** **** **** 1234"
}
```
El cliente espera una respuesta del servidor:

200 OK si se procesó bien.

402 Payment Required si hubo un fallo.

El cliente no puede continuar hasta saber si el pago fue exitoso.

## Ejemplo en código
🔹 En JavaScript (con fetch síncrono con await)
```js
async function getUser() {
  const response = await fetch('/api/user/42'); // Espera hasta que termine
  const data = await response.json();
  console.log(data);
}
```

## Desventajas del modelo Síncrono
Problema	Descripción
⏱️ Bloqueo	El cliente o el hilo se queda esperando y no puede hacer otra cosa.
🐢 Lentitud	Si el servidor demora, el cliente se ve afectado directamente.
📶 Fragilidad	Si hay errores de red o caídas, el cliente no puede seguir.

## Cuándo usar Síncrono
✅ Úsalo cuando:

El resultado de una operación es necesario inmediatamente para continuar.

La llamada es rápida y confiable.

Estás trabajando en entornos controlados o monolíticos.

🚫 Evítalo cuando:

Tienes múltiples clientes concurrentes.

Requieres alta disponibilidad y escalabilidad.

Lidiarás con llamadas remotas lentas o intermitentes.

##  Aplicaciones del modelo Síncrono
Llamadas a funciones locales en cualquier lenguaje.

HTTP APIs sincrónicas tradicionales.

Consultas SQL directas.

Servicios SOAP o gRPC con espera de respuesta inmediata.