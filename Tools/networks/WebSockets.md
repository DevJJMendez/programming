# Web Sockets
WebSocket es un protocolo de comunicación bidireccional que proporciona un canal de comunicación persistente y a tiempo real entre el cliente (normalmente un navegador web) y el servidor. A diferencia de los modelos tradicionales de comunicación HTTP, donde cada solicitud y respuesta son independientes, WebSocket permite que ambos extremos (cliente y servidor) mantengan una conexión abierta y puedan intercambiar datos en tiempo real, sin la necesidad de reabrir la conexión para cada mensaje.

## Características principales de WebSocket:
Conexión persistente:

Una vez que se establece la conexión WebSocket, se mantiene abierta durante la duración de la sesión. Esto permite un intercambio continuo de datos entre el cliente y el servidor sin la sobrecarga de abrir y cerrar conexiones repetidamente.

Comunicación bidireccional:

A diferencia de HTTP, que es tradicionalmente un protocolo de comunicación unidireccional (cliente a servidor), WebSocket permite la comunicación bidireccional en tiempo real. El cliente y el servidor pueden enviar mensajes en cualquier momento, sin tener que esperar una solicitud de la otra parte.

Bajo consumo de recursos:

Dado que no hay necesidad de establecer y cerrar conexiones repetidamente, WebSocket reduce la sobrecarga de las comunicaciones, lo que mejora la eficiencia en comparación con el modelo tradicional de solicitud-respuesta de HTTP.

Soporte para eventos en tiempo real:

Es especialmente útil en aplicaciones donde los datos necesitan ser actualizados en tiempo real, como en aplicaciones de chat, notificaciones en tiempo real, juegos en línea, o cualquier otra aplicación que requiera una actualización continua de datos.

## Estructura de WebSocket
Establecimiento de la conexión:

1. Petición de conexión (Handshake):

La conexión WebSocket comienza con una solicitud de handshake (apretón de manos) HTTP estándar. El cliente (normalmente un navegador) envía una solicitud HTTP con un encabezado especial que indica al servidor que desea usar el protocolo WebSocket.

Esta solicitud HTTP inicial incluye un encabezado especial Upgrade que indica que la solicitud está pidiendo un cambio de protocolo de HTTP a WebSocket.

Ejemplo de solicitud de cliente para iniciar un WebSocket:
```bash
GET /chat HTTP/1.1
Host: example.com
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==
Sec-WebSocket-Version: 13
```
Sec-WebSocket-Key: Un valor único generado aleatoriamente que ayuda a proteger la comunicación.

Sec-WebSocket-Version: La versión del protocolo WebSocket que se está utilizando (normalmente 13).

2. Respuesta del servidor:

Si el servidor es compatible con WebSockets y acepta la conexión, responde con un código de estado 101 (Cambio de protocolo) y realiza el "upgrade" a WebSocket.

Ejemplo de respuesta del servidor:
```bash
HTTP/1.1 101 Switching Protocols
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Accept: dGhlIHNhbXBsZSBub25jZQ==
```
Sec-WebSocket-Accept: Una clave generada por el servidor para confirmar que ha aceptado la conexión WebSocket.

3. Establecimiento de la conexión:

Una vez que el servidor responde al cliente con el código de estado 101, la conexión WebSocket está abierta y los datos pueden comenzar a fluir de manera bidireccional. La comunicación entre el cliente y el servidor ya no está restringida a solicitudes y respuestas HTTP.

## Mensajes WebSocket:
* Los mensajes enviados a través de WebSocket se dividen en frames (fragmentos) de datos. Los datos pueden ser enviados en textos o en binarios.

  * Text Frames: Mensajes en formato de texto (normalmente en UTF-8).

  * Binary Frames: Mensajes en formato binario (por ejemplo, imágenes, archivos o datos codificados binariamente).

* Frames de control:

  * WebSocket también puede usar frames de control, como ping y pong, para mantener la conexión activa y asegurarse de que ambas partes estén aún conectadas.

## Cierre de la conexión:
Cuando una de las partes desea finalizar la conexión, envía un mensaje de cierre especial. El otro extremo responde con un mensaje de cierre para cerrar formalmente la conexión.

## ¿Qué resuelve WebSocket?
Comunicación en tiempo real:

WebSocket resuelve la necesidad de una comunicación bidireccional y en tiempo real entre clientes y servidores. Esto es ideal para aplicaciones de chat, notificaciones en tiempo real, actualizaciones de información en vivo, y aplicaciones interactivas como juegos en línea.

Reducción de latencia y sobrecarga:

En un sistema tradicional basado en HTTP, cada mensaje requiere una nueva conexión TCP (o una solicitud HTTP separada). WebSocket, al ser una conexión persistente, reduce la sobrecarga de abrir y cerrar conexiones constantemente, lo que mejora el rendimiento y reduce la latencia en la comunicación.

Mejora de la eficiencia:

Al mantener una conexión abierta, WebSocket mejora la eficiencia en términos de recursos, ya que no es necesario enviar múltiples solicitudes HTTP para lograr una comunicación continua. Esto es particularmente útil en aplicaciones con un alto volumen de mensajes.

Escalabilidad en aplicaciones con alta demanda de interacciones en tiempo real:

WebSocket es ideal para aplicaciones que requieren un alto volumen de comunicaciones simultáneas, como aplicaciones de redes sociales, aplicaciones de colaboración en tiempo real, o sistemas de trading de alta frecuencia.

## ¿Cómo lo resuelve?
Canal de comunicación persistente:

WebSocket permite una conexión persistente de bajo costo entre el cliente y el servidor. Esto evita la necesidad de crear nuevas conexiones cada vez que se necesita enviar un mensaje, lo que mejora la eficiencia y reduce la latencia.

Interacción bidireccional sin bloqueos:

A través de WebSocket, tanto el cliente como el servidor pueden enviar datos en cualquier momento sin esperar una solicitud del otro extremo. Esto permite que las aplicaciones funcionen en tiempo real, como en aplicaciones de chat, donde las respuestas del servidor pueden ser enviadas tan pronto como haya un nuevo evento.

Mejor rendimiento en aplicaciones interactivas:

WebSocket permite el intercambio instantáneo de mensajes, lo que es crucial para aplicaciones donde la actualización en tiempo real es importante, como en juegos en línea, aplicaciones de colaboración o paneles de monitoreo.

## Ventajas de WebSocket
Comunicación bidireccional:

Ambos extremos pueden enviar datos de manera independiente y simultánea, lo que facilita la interacción en tiempo real.

Conexión persistente:

No es necesario abrir una nueva conexión para cada mensaje, lo que reduce la sobrecarga en el sistema.

Bajo consumo de recursos:

Al eliminar la necesidad de abrir y cerrar conexiones, WebSocket reduce significativamente la carga sobre el servidor y la red.

Menor latencia:

La persistencia de la conexión permite que los mensajes se envíen casi instantáneamente, lo que es esencial para aplicaciones que requieren una baja latencia.

## Desventajas de WebSocket
Compatibilidad de red:

Algunas redes corporativas y firewalls pueden bloquear o restringir las conexiones WebSocket debido a que este protocolo utiliza puertos no estándar y no siempre está habilitado en redes privadas.

No adecuado para todas las aplicaciones:

No todas las aplicaciones requieren comunicación en tiempo real o bidireccional. Para aplicaciones que solo necesitan una interacción ocasional (como un simple formulario o búsqueda), HTTP tradicional es más eficiente.

Gestión de conexiones:

WebSocket requiere que el servidor gestione las conexiones persistentes, lo que puede ser un desafío en aplicaciones de gran escala, especialmente cuando se necesita manejar muchas conexiones abiertas al mismo tiempo.

## Casos de Uso Comunes de WebSocket
Aplicaciones de chat en tiempo real:

WebSocket es perfecto para aplicaciones de mensajería instantánea donde la comunicación en tiempo real es crucial.

Notificaciones en tiempo real:

WebSocket se usa para enviar notificaciones inmediatas a los clientes sin necesidad de que estos hagan una nueva solicitud.

Juegos en línea:

Muchos juegos en línea utilizan WebSocket para la interacción en tiempo real entre los jugadores.

Aplicaciones financieras:

WebSocket es utilizado en sistemas de trading en tiempo real, donde los precios de las acciones o las criptomonedas se actualizan instantáneamente.

Monitoreo y análisis en vivo:

WebSocket se usa para enviar datos en vivo, como paneles de control o análisis en tiempo real.