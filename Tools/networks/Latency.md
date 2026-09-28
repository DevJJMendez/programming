# Latencia
La latencia es el tiempo que tarda un paquete de datos en viajar desde el origen hasta el destino.

En términos simples:
Latencia = Tiempo de espera
(desde que se hace una solicitud hasta que se empieza a recibir una respuesta).

Se mide usualmente en milisegundos (ms).

## ¿Qué partes afectan la latencia?
La latencia puede incluir:

⌛ Tiempo de ida de la solicitud.

⌛ Tiempo de procesamiento en el servidor o dispositivo remoto.

⌛ Tiempo de vuelta de la respuesta.

## Tipos de latencia
￼
Tipo	Descripción
Latencia de red	Tiempo de viaje de datos entre dispositivos a través de la red.
Latencia de aplicación	Tiempo que tarda el software en procesar una solicitud.
Latencia de disco	Tiempo que tarda en acceder a datos desde almacenamiento.
Latencia de base de datos	Tiempo para ejecutar una consulta SQL.
Latencia de renderizado (frontend)	Tiempo que tarda una página en mostrarse al usuario.

## ¿Qué resuelve medir la latencia?
Medir la latencia te permite:

Diagnosticar cuellos de botella.

Garantizar experiencia de usuario fluida.

Tomar decisiones de arquitectura (ej. usar CDN, cache, colas).

Elegir proveedores cloud (AWS, Azure, GCP) basados en rendimiento.

## ¿Cómo se mide?
Herramientas comunes:

ping → mide latencia de red (ICMP).

curl -w → mide latencia HTTP.

Monitorización de APM (Application Performance Monitoring): New Relic, Datadog, Elastic APM.

Logs + timestamps de peticiones/respuestas.

Lighthouse o Web Vitals en el frontend.

## ¿Qué causa una alta latencia?
Distancia geográfica entre cliente y servidor.

Congestión en la red.

DNS lento.

Procesamiento ineficiente del backend.

Servidores sobrecargados o mal dimensionados.

Sistemas sin cache.

Filtros de seguridad o firewalls.

## ¿Cómo reducir la latencia?
￼
Estrategia	Cómo ayuda
CDN (Content Delivery Network)	Acerca los recursos al cliente.
Cache (HTTP, Redis, etc)	Evita procesamiento innecesario.
Minimizar payloads	Reduce el tamaño de los datos transmitidos.
Balanceo de carga	Distribuye el tráfico y evita cuellos de botella.
Optimización del backend	Mejores algoritmos, menos operaciones costosas.
Ubicación de servidores	Acercarse geográficamente al usuario final.
Preprocesamiento asíncrono	Delegar tareas pesadas a workers (colas, eventos).

## Ejemplo práctico
Imagina que tienes una API en AWS (Irlanda) y un cliente desde Perú.
El round-trip de red puede ser de 200ms.
Si tu backend tarda 300ms y no usas cache ni CDN, la latencia total será de 500ms o más.

Con CDN + cache + workers, podrías reducirla a menos de 100ms.

## Latencia vs Ancho de banda
￼
Concepto	¿Qué mide?
Latencia	Tiempo que tarda una solicitud.
Ancho de banda	Cantidad de datos que se pueden transferir por segundo.
Puedes tener alta banda (descargas rápidas) y aún así mucha latencia (espera inicial larga).