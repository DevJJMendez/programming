# Statefull
El término Stateful hace referencia a cualquier sistema, servicio, protocolo o aplicación que mantiene el estado de la interacción con el cliente o con otros sistemas a lo largo del tiempo.

En otras palabras, un sistema stateful recuerda información previa sobre una sesión o una serie de solicitudes, y esta información afecta cómo se maneja la siguiente interacción.

## Ejemplo simple:
Supongamos que estás navegando en una tienda online:

Te logueas.

Agregas productos al carrito.

Vuelves más tarde y el carrito sigue ahí.

Eso significa que el servidor "recuerda" que tú (tu sesión) habías iniciado sesión y que tenías productos en el carrito. Este es un sistema stateful.

## Características de un sistema Stateful
Característica	Descripción
Persistencia de datos temporales	Guarda el estado de las operaciones para usarlas después.
Dependencia del contexto anterior	Requiere conocer el historial de interacciones.
Sesiones activas	Normalmente implementa sesiones de usuario o mecanismos como cookies.
Más complejo de escalar horizontalmente	Porque el estado debe ser compartido o sincronizado entre instancias.

## Comparación: Stateful vs Stateless
￼
Característica	Stateful	Stateless
Guarda información	Sí (estado de sesión, historial)	No, cada solicitud es independiente
Escalabilidad	Más compleja	Más sencilla
Tolerancia a fallos	Menor (estado puede perderse)	Alta (nada que perder entre peticiones)
Ejemplo típico	Base de datos, servidor FTP	REST API, HTTP puro

## Ejemplos de sistemas Stateful
Sistemas de base de datos tradicionales (como PostgreSQL o MySQL).

Sesiones en servidores web que almacenan login y cookies.

Protocolos como FTP, Telnet, SSH: mantienen una conexión viva y estado asociado.

Juegos multijugador online: el servidor guarda el progreso, ubicación, inventario, etc.

Aplicaciones en tiempo real (chat, videollamadas).

## ¿Cómo se implementa el estado?
Memoria del servidor: Mantener el estado en RAM (por ejemplo, sesiones en memoria).

Cookies y tokens: Se almacena el identificador de sesión en el cliente y el estado en el servidor.

Bases de datos: Se persiste información del usuario o sesión.

Caches distribuidas: Como Redis o Memcached, para sesiones compartidas entre varios servidores.

## Desafíos de los sistemas Stateful
Escalabilidad horizontal: Para escalar a múltiples servidores, debes replicar o compartir el estado.

Persistencia del estado: Si el servidor se reinicia o cae, se puede perder el estado.

Complejidad operativa: Requiere mecanismos para compartir sesiones entre nodos (como sticky sessions, bases de datos compartidas o almacenamiento en Redis).

## Aplicaciones web: ¿cuándo usar stateful?
Si necesitas sesiones persistentes, como login o carritos de compra.

Si trabajas con WebSockets, donde se mantiene una conexión viva bidireccional.

Si haces transacciones que dependen de acciones previas (ej: checkout de e-commerce).

En juegos, chats, dashboards en tiempo real.

## Recomendación como ingeniero:
👉 Usa arquitecturas stateless siempre que sea posible, porque son más simples de mantener y escalar.

👉 Cuando necesites mantener estado:

Usa herramientas como Redis o bases de datos distribuidas.

Implementa sticky sessions solo si no hay otra alternativa.

Centraliza la gestión del estado para no acoplarlo al servidor de aplicación.