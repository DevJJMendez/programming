# HTTP Caching
HTTP Caching es el proceso de almacenar y reutilizar respuestas a solicitudes HTTP para evitar la necesidad de realizar la misma solicitud repetidamente. Esto se hace con el fin de mejorar el rendimiento de la red, reducir la carga en los servidores y acelerar la experiencia del usuario.

Cuando un recurso (como una imagen, archivo de texto, o una página HTML) se solicita desde un servidor, puede ser almacenado temporalmente en un caché. Luego, cuando se hace la misma solicitud de nuevo, el navegador o el servidor puede devolver ese recurso desde el caché, en lugar de obtenerlo nuevamente desde el servidor, lo que ahorra tiempo y recursos.

## ¿Cómo funciona el HTTP Caching?
El proceso de caché en HTTP se basa principalmente en cabeceras HTTP que controlan cómo y cuándo un recurso debe ser almacenado y reutilizado.

1. Cabeceras de Control de Caché
Algunos ejemplos clave de cabeceras que controlan el caché en HTTP son:

a. Cache-Control
La cabecera Cache-Control es la principal cabecera utilizada para controlar el comportamiento del caché. Puedes usarla para establecer directivas como cuánto tiempo almacenar un recurso o si un recurso debe ser revalidado antes de ser reutilizado.

Algunas directivas comunes son:

max-age: Define el tiempo máximo en segundos que un recurso se considera "fresco" y puede ser reutilizado sin verificar con el servidor.
```bash
Cache-Control: max-age=3600  # El recurso es válido durante 1 hora
```
no-cache: Indica que el recurso no debe ser almacenado en caché sin ser revalidado con el servidor.
```bash
Cache-Control: no-cache
```
no-store: Impide que el recurso sea almacenado en caché.
```bash
Cache-Control: no-store
```
public: Indica que el recurso puede ser almacenado en caché por cualquier intermediario (como un CDN o un proxy).
```bash
Cache-Control: public
```
private: Indica que el recurso debe ser almacenado solo en el caché del cliente, no en caches compartidos.
```bash
Cache-Control: private
```

b. Expires
La cabecera Expires es más antigua y funciona junto con Cache-Control, pero se utiliza para establecer una fecha de caducidad específica.

Expires indica la fecha y hora en que el recurso deja de ser considerado válido.
```bash
Expires: Wed, 21 Oct 2025 07:28:00 GMT
```
Si se utiliza tanto Expires como Cache-Control, Cache-Control tiene prioridad.

c. ETag
El ETag es un identificador único asignado a una versión específica de un recurso. El servidor genera este identificador y lo envía como parte de la respuesta. En futuras solicitudes, el cliente envía el ETag en la cabecera If-None-Match para ver si el recurso ha cambiado.

ETag: El servidor genera un valor único para el recurso.
```bash
ETag: "v1.0.1"
```
If-None-Match: El cliente envía el ETag con la solicitud para verificar si el recurso ha cambiado.
```bash
If-None-Match: "v1.0.1"
```
Si el recurso no ha cambiado, el servidor puede devolver un código 304 (Not Modified), indicando que el cliente puede seguir usando su versión almacenada en caché.

d. Last-Modified
La cabecera Last-Modified indica la última vez que se modificó el recurso. El cliente puede usar esta fecha en la cabecera If-Modified-Since en futuras solicitudes para verificar si el recurso ha cambiado.

Last-Modified: Fecha de la última modificación del recurso.
```bash
Last-Modified: Tue, 20 Oct 2025 10:00:00 GMT
```
If-Modified-Since: El cliente envía esta cabecera para comprobar si el recurso ha sido modificado después de esa fecha.
```bash
If-Modified-Since: Tue, 20 Oct 2025 10:00:00 GMT
```
Si el recurso no ha cambiado desde la fecha proporcionada, el servidor puede responder con un 304 Not Modified.

## ¿Qué resuelve HTTP Caching?
Mejora el rendimiento:

Evita tener que volver a cargar recursos de manera repetitiva, acelerando la carga de las páginas y mejorando la experiencia del usuario.

Reduce la carga del servidor:

El caché reduce el número de solicitudes que se realizan al servidor, lo que disminuye la carga en el servidor y ahorra ancho de banda.

Optimiza el uso de recursos de red:

Al evitar las solicitudes innecesarias, se reduce el tráfico de red y se optimiza el ancho de banda disponible.

Mejora la escalabilidad:

Al usar técnicas como el caché en proxies o en CDNs, se pueden servir recursos desde ubicaciones geográficamente cercanas al cliente, lo que mejora la latencia y la escalabilidad del sistema.

## ¿Cuáles son los tipos de caché en HTTP?
Caché del navegador:

Es el caché que los navegadores web mantienen localmente. Los recursos como imágenes, archivos JavaScript y hojas de estilo se pueden almacenar en el caché del navegador para evitar descargas repetidas.

Caché intermedia (CDNs, proxies, etc.):

Los CDNs y proxies almacenan recursos en caché en servidores intermedios, lo que permite que las solicitudes a esos recursos se resuelvan rápidamente sin ir hasta el servidor original.

Caché del servidor:

Algunos servidores de aplicaciones también pueden almacenar recursos en caché para evitar tener que procesar solicitudes repetidas.

## Ejemplo práctico de uso de Cache-Control
Imagina que tienes una API que devuelve una lista de productos y quieres asegurarte de que la respuesta se almacene en caché durante 1 hora.

Cabecera de respuesta con Cache-Control:
```bash
Cache-Control: public, max-age=3600
```
Esto indica que el recurso es público y puede ser almacenado en caché por cualquier intermediario, como un CDN o un proxy, y que es válido durante 3600 segundos (1 hora).

En una página web estática que contiene recursos como imágenes, podrías configurar los encabezados así:
```bash
Cache-Control: public, max-age=31536000, immutable
```
max-age=31536000: 1 año.

immutable: Indica que el recurso no cambiará durante su vida útil, lo que hace que el navegador no lo verifique durante ese tiempo.

## Buenas prácticas para HTTP Caching
Caché inteligente: No caches recursos dinámicos (como resultados de búsqueda o datos que cambian frecuentemente).

Invalida el caché correctamente: Usa ETags o Last-Modified para verificar si un recurso ha cambiado.

Evita almacenar datos sensibles: Nunca almacenes en caché datos sensibles como contraseñas o información financiera.