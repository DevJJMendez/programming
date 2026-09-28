# Rate Limiting
Rate Limiting (limitación de tasa) es una técnica utilizada en sistemas de redes, aplicaciones web y APIs para controlar la cantidad de solicitudes o peticiones que un usuario o cliente puede hacer a un servidor dentro de un período de tiempo determinado. El objetivo principal de esta técnica es proteger los recursos del servidor, asegurando que no se sobrecargue o sea vulnerable a ataques de denegación de servicio (DoS), abuso o tráfico malicioso.

## ¿Por Qué es Importante el Rate Limiting?
Protección contra abusos: Limitar la cantidad de solicitudes que un cliente puede realizar ayuda a prevenir abusos o el uso excesivo de los recursos. Por ejemplo, un usuario que realiza peticiones repetitivas podría intentar sobrecargar el sistema o acceder a recursos de manera indebida.

Seguridad: Ayuda a mitigar ataques como brute force o ataques de denegación de servicio distribuida (DDoS), donde se hacen múltiples solicitudes en un corto período de tiempo para intentar comprometer un servicio.

Gestión de recursos: Cuando múltiples usuarios o clientes acceden a un servicio, el rate limiting permite asegurar que ningún cliente consuma recursos excesivos y cause interrupciones o lentitud en el servicio para otros usuarios.

Aseguramiento de calidad de servicio (QoS): Al limitar el número de solicitudes de los clientes, se puede garantizar que los servicios mantengan un nivel constante de rendimiento y no se vean afectados por picos de tráfico no controlados.

## ¿Cómo Funciona el Rate Limiting?
El rate limiting controla la cantidad de solicitudes o peticiones que un cliente puede realizar en un período de tiempo específico. Para implementarlo de forma efectiva, se pueden usar diversas estrategias y algoritmos.


Métodos de Implementación Comunes
1. Token Bucket Algorithm (Algoritmo de Cubo de Tokens):

Funcionamiento: Este algoritmo utiliza un "cubo de tokens", donde los tokens se generan a una tasa constante. Para realizar una solicitud, el cliente debe consumir un token. Si el cubo se vacía, el cliente no puede realizar más solicitudes hasta que se llenen nuevos tokens.

Ventajas: Permite un "exceso" ocasional de solicitudes si el cliente ha estado inactivo durante un período, ya que el cubo se recarga gradualmente.

Ejemplo: Si el servidor permite 100 solicitudes por minuto, el cubo puede almacenar hasta 100 tokens. Si un cliente hace 50 solicitudes rápidamente, el cubo se vacía, pero el cliente podrá hacer más solicitudes tan pronto como se recarguen los tokens.

2. Leaky Bucket Algorithm (Algoritmo del Cubo con Fugas):

Funcionamiento: Similar al token bucket, pero con una diferencia clave: las solicitudes se procesan a una tasa constante. Si el cubo se llena (es decir, si las solicitudes llegan más rápido de lo que el sistema puede procesar), las solicitudes adicionales se descartan.

Ventajas: El leaky bucket tiene un control más estricto sobre la tasa de procesamiento, lo que significa que las solicitudes se manejan de manera uniforme y no hay picos bruscos.

3. Fixed Window (Ventanas Fijas):

Funcionamiento: Se divide el tiempo en ventanas fijas (por ejemplo, cada minuto o cada hora). Dentro de una ventana, se permite una cantidad fija de solicitudes. Si el límite de solicitudes se alcanza, no se permite ninguna solicitud adicional hasta que comience la siguiente ventana.

Desventajas: Este enfoque puede generar "picos" al final de una ventana de tiempo, cuando los clientes realizan todas las solicitudes justo antes de que comience una nueva ventana.

Ejemplo: Si se permite 100 solicitudes por minuto, los usuarios solo podrán hacer 100 solicitudes en cada minuto, sin importar si hicieron las solicitudes en los primeros segundos o en los últimos segundos.

4. Rolling Window (Ventanas Deslizantes):

Funcionamiento: A diferencia de las ventanas fijas, el sistema realiza un seguimiento del número de solicitudes realizadas durante un período móvil. En lugar de tener un contador que se reinicia al comienzo de cada minuto, las solicitudes se cuentan en un período constante de 60 segundos hacia atrás.

Ventajas: Este enfoque es más flexible y evita los "picos" de las ventanas fijas, ya que no hay un reinicio repentino del contador.

5. Sliding Log (Registro Deslizante):

Funcionamiento: En lugar de utilizar una ventana de tiempo fija o deslizante, este algoritmo registra cada solicitud con su marca de tiempo y permite que el sistema realice solicitudes solo si la diferencia de tiempo entre la solicitud más antigua y la actual no supera el límite permitido.

Ventajas: Proporciona un control preciso, pero puede ser más costoso en términos de almacenamiento y procesamiento, ya que requiere mantener un registro de todas las solicitudes.

## Tipos de Rate Limiting
Rate Limiting por IP: Limita el número de solicitudes desde una dirección IP específica en un período de tiempo determinado. Esto es útil para evitar que un solo usuario abuse de los recursos del sistema.

Ejemplo: Permitir hasta 1000 solicitudes por minuto desde una sola dirección IP.

Rate Limiting por Usuario: Limita la cantidad de solicitudes que un usuario puede hacer, independientemente de su dirección IP. Es útil para servicios donde los usuarios tienen cuentas y se necesita aplicar restricciones basadas en la identidad del usuario.

Ejemplo: Permitir 1000 solicitudes por minuto por cada usuario autenticado.

Rate Limiting por Aplicación o API Key: Limita la cantidad de solicitudes de una aplicación en particular, identificada por una clave API. Esto es útil en servicios donde varias aplicaciones o servicios pueden acceder a la misma API.

Ejemplo: Limitar a 5000 solicitudes por minuto a cada aplicación o clave API.

## ¿Qué Resuelve el Rate Limiting?
Protección de recursos: Evita que los usuarios consuman una cantidad excesiva de recursos (CPU, memoria, ancho de banda, etc.), asegurando que el servidor pueda manejar múltiples solicitudes sin sobrecargarse.

Prevención de ataques de DoS/DDoS: Al limitar el número de solicitudes que un usuario puede hacer en un período de tiempo determinado, el rate limiting ayuda a prevenir ataques de denegación de servicio donde un atacante intenta inundar un servidor con solicitudes maliciosas.

Garantía de calidad de servicio (QoS): Con el rate limiting, se puede asegurar que todas las solicitudes sean procesadas de manera justa, sin que algunos usuarios saturen el sistema y afecten la experiencia de otros usuarios.

Mejor control de la infraestructura: Proporciona una forma de gestionar la carga en los servidores y de asignar recursos de manera más eficiente.

## Cómo Implementar Rate Limiting
La implementación del rate limiting depende de la tecnología y el stack que estés utilizando, pero generalmente involucra las siguientes etapas:

Definir el límite: Establecer cuántas solicitudes se permiten por usuario, IP, API Key, etc., en un período de tiempo determinado.

Almacenar el conteo: Utilizar almacenamiento temporal (como bases de datos o cachés) para hacer un seguimiento de las solicitudes que un usuario ha realizado en un período de tiempo específico.

Verificar y bloquear: Cada vez que un usuario realiza una solicitud, comprobar si ha superado el límite. Si ha excedido el límite, devolver un error HTTP (generalmente un 429 Too Many Requests).

Reiniciar el conteo: Después de que el período de tiempo (por ejemplo, un minuto o una hora) termine, reiniciar el contador de solicitudes.

## Ejemplo Práctico de Rate Limiting en API
Imagina que una API tiene un límite de 1000 solicitudes por hora para cada usuario. Aquí se utiliza un enfoque basado en ventana deslizante.

El servidor realiza un seguimiento de la hora de cada solicitud y verifica si el número de solicitudes en la última hora ha superado el límite de 1000.

Si el usuario realiza más de 1000 solicitudes en una hora, el servidor responderá con un código 429 Too Many Requests hasta que pase el tiempo suficiente para que algunas de las solicitudes anteriores ya no cuenten.

## Conclusión
Rate limiting es una técnica fundamental para controlar el tráfico de usuarios y proteger los sistemas de sobrecarga y abusos. Mediante el uso de diversos algoritmos y estrategias, se pueden establecer límites de solicitudes en un servidor o API, garantizando la estabilidad del sistema y evitando que los recursos se vean comprometidos. Además, permite mantener una calidad constante de servicio, prevenir ataques maliciosos y gestionar los recursos de manera eficiente.