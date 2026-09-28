# HyperText Transfer Protocol
HTTP (Protocolo de Transferencia de Hipertexto) es un protocolo de la capa de aplicación, sin estado (stateless), que permite la comunicación entre clientes (navegadores, apps, etc.) y servidores web. Se basa en el modelo petición-respuesta.

## Estructura de una petición HTTP
Una petición HTTP tiene esta forma:
```bash
GET /api/productos HTTP/1.1
Host: tienda.com
User-Agent: Mozilla/5.0
Accept: application/json
Authorization: Bearer <token>

(body opcional para POST, PUT, etc.)
```
Componentes:
Línea de petición: método + URL + versión del protocolo

Cabeceras (Headers): metadatos

Cuerpo (Body): opcional (usado en POST, PUT, PATCH)

## Métodos HTTP
￼
Método	Uso común	Idempotente
GET	Obtener recursos	✅ Sí
POST	Crear recursos	❌ No
PUT	Reemplazar recursos	✅ Sí
PATCH	Actualización parcial	❌ No
DELETE	Eliminar recursos	✅ Sí
HEAD	Obtener solo los headers	✅ Sí
OPTIONS	Obtener métodos permitidos	✅ Sí

## Estructura de una respuesta HTTP
```bash
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 123

{
  "producto": "camisa",
  "precio": 25.99
}
```
Línea de estado: versión + código de estado + descripción

Headers

Body (contenido del recurso o mensaje de error)

## HTTP es Stateless
HTTP no mantiene estado entre peticiones. Cada solicitud es independiente. Por eso usamos:

Cookies / Sessiones (estado en el cliente/servidor)

JWTs / Tokens (estado en el cliente, validación en el servidor)

Bases de datos / Caché para persistir información

## Seguridad
HTTPS (HTTP + TLS): cifra los datos entre cliente y servidor.

CORS: define qué orígenes pueden hacer peticiones a tu servidor.

Rate Limiting, CSRF, XSS Protection: fundamentales para APIs seguras.

## Versiones de HTTP
￼
Versión	Características principales
HTTP/1.0	Conexión por cada petición, sin persistencia
HTTP/1.1	Conexiones persistentes, caché, chunked transfer
HTTP/2	Multiplexación, compresión de headers, binario
HTTP/3	Basado en QUIC (UDP), más rápido, más seguro

## Mejores prácticas
Usa HTTPS siempre

Usa los status codes correctamente

Utiliza caché con headers como ETag, Cache-Control

Minimiza payloads: usa gzip, Brotli

Implementa Rate Limiting, Auth y Logs

Usa métodos HTTP y nombres de recursos RESTful

## asos de uso típicos
APIs RESTful (GET /productos/1)

Servicios SOAP o GraphQL sobre HTTP

Webhooks (POST a una URL específica)

Comunicación entre microservicios

Aplicaciones SPA usando fetch, axios, etc.

# Hypertext Transfer Protocol Secure
HTTPS (Hypertext Transfer Protocol Secure) es una versión segura del HTTP (Hypertext Transfer Protocol), el protocolo que se utiliza para la transferencia de información entre un navegador web y un servidor web. La principal diferencia entre HTTP y HTTPS es que HTTPS utiliza un cifrado SSL/TLS para proteger la comunicación.

Cuando un sitio web utiliza HTTPS, significa que todas las comunicaciones entre el cliente (navegador) y el servidor están cifradas, lo que garantiza la confidencialidad, integridad y autenticidad de los datos intercambiados.

En términos simples, HTTPS asegura que la información que envías y recibes a través de tu navegador esté protegida de ataques e interceptaciones.

## ¿Cuál es Su Estructura?
HTTPS se compone de dos elementos principales:

Protocolo HTTP: Este es el protocolo que define cómo se deben estructurar y transferir las solicitudes y respuestas entre un cliente (navegador) y un servidor. HTTP es responsable de solicitar recursos (como páginas web, imágenes, etc.) de un servidor y de enviar esos recursos al cliente.

Cifrado SSL/TLS: Esta es la capa de seguridad que se encuentra sobre HTTP, utilizando el Protocolo SSL (Secure Sockets Layer) o su sucesor TLS (Transport Layer Security) para cifrar los datos. El cifrado SSL/TLS garantiza que la información no sea accesible a terceros y protege contra intercepciones o modificaciones.

La estructura de HTTPS implica los siguientes pasos:

Establecimiento de una Conexión Segura: Cuando un cliente se conecta a un servidor que utiliza HTTPS, primero se realiza una negociación SSL/TLS para establecer una conexión segura. Este proceso implica el uso de certificados digitales para verificar la identidad del servidor.

Intercambio de Claves: Durante el proceso de establecimiento de la conexión, se intercambian claves de sesión que se utilizarán para cifrar la información durante toda la sesión.

Cifrado de la Comunicación: Una vez establecida la conexión segura, los datos que se intercambian entre el servidor y el cliente se cifran utilizando las claves de sesión generadas durante el proceso de negociación.

## ¿Qué Resuelve HTTPS?
HTTPS resuelve varios problemas críticos relacionados con la seguridad y la integridad de la información que se transmite a través de internet:

Intercepción de Datos:

Sin HTTPS, la información transmitida entre el navegador y el servidor puede ser fácilmente interceptada por atacantes que utilicen técnicas como el sniffing de paquetes.

Problema: Datos sensibles, como contraseñas, detalles de tarjetas de crédito o información personal, pueden ser robados.

Solución: HTTPS cifra toda la información enviada entre el cliente y el servidor, lo que hace que incluso si los datos son interceptados, sean prácticamente imposibles de leer sin la clave adecuada.

Modificación de Datos:

Sin HTTPS, los datos pueden ser modificados en el camino por atacantes. Esto puede incluir la modificación de contenido, como la inyección de código malicioso o cambios en los datos enviados.

Problema: Un atacante podría modificar un formulario de inicio de sesión o cambiar el contenido de una página web.

Solución: HTTPS garantiza que los datos no se pueden alterar en el camino mediante un proceso llamado integridad de los datos. Si los datos son modificados, se detectará durante la verificación de integridad de la conexión.

Autenticidad del Servidor:

En HTTP, no hay ninguna forma de verificar que el servidor al que se conecta el cliente es realmente el servidor que afirma ser.

Problema: Los atacantes pueden crear sitios web falsos que imitan a los legítimos, lo que pone en riesgo la privacidad y seguridad del usuario (un ataque conocido como phishing).

Solución: HTTPS utiliza certificados digitales emitidos por autoridades de certificación (CA), que permiten verificar que el servidor es quien dice ser, ayudando a prevenir ataques de phishing.

Confidencialidad de la Información:

Sin HTTPS, la información, incluidos los datos de inicio de sesión, puede ser visible para otras personas en la misma red (por ejemplo, en redes Wi-Fi públicas).

Problema: Las contraseñas y los datos confidenciales pueden ser leídos por atacantes.

Solución: HTTPS cifra toda la comunicación, lo que hace que incluso si alguien está observando la red, no pueda leer los datos transmitidos.

##  ¿Cómo Resuelve HTTPS Estos Problemas?
HTTPS resuelve los problemas mencionados a través de un proceso detallado que involucra dos capas principales: el protocolo HTTP y el cifrado SSL/TLS. A continuación, se explica cómo funciona cada parte:

Cifrado SSL/TLS:

Cifrado Simétrico: Una vez que se establece una conexión segura, se utiliza un cifrado simétrico para proteger los datos transmitidos. Ambas partes (cliente y servidor) utilizan la misma clave para cifrar y descifrar la información.

Cifrado Asimétrico: Durante el establecimiento de la conexión, se utiliza cifrado asimétrico para intercambiar de forma segura una clave secreta (llamada clave de sesión) entre el cliente y el servidor. Este proceso garantiza que ambas partes pueden compartir una clave sin que un atacante pueda obtenerla.

Certificados Digitales: Los servidores HTTPS deben tener un certificado SSL/TLS emitido por una Autoridad Certificadora (CA). Este certificado contiene una clave pública que ayuda a asegurar que el servidor es auténtico y que la comunicación es segura.

Autenticación mediante Certificados Digitales:

Durante la negociación inicial de la conexión HTTPS, el servidor presenta su certificado digital al cliente. El cliente verifica la autenticidad del servidor utilizando una cadena de confianza. Si el certificado es válido y emitido por una CA confiable, el cliente procede a establecer una conexión segura.

Esto previene ataques man-in-the-middle (MITM), en los que un atacante se coloca entre el cliente y el servidor para interceptar o modificar la comunicación.

Integridad de los Datos:

HTTPS utiliza mecanismos de hashing para asegurarse de que los datos no hayan sido alterados durante la transmisión. Si los datos se modifican, la verificación de integridad falla y la conexión se cierra.

Esto garantiza que los datos transmitidos entre el servidor y el cliente sean exactamente los mismos en ambos extremos.

Prevención de Ataques:

HTTPS también ayuda a prevenir ataques de suplantación de identidad y phishing mediante el uso de la autenticación del servidor y los certificados digitales, que ayudan a garantizar que el cliente se esté comunicando con el servidor legítimo y no con un imitador.

## Importancia de HTTPS en la Web Moderna
SEO (Optimización para Motores de Búsqueda): Los motores de búsqueda como Google dan preferencia a los sitios web que utilizan HTTPS en su clasificación. Un sitio que no usa HTTPS puede perder posiciones en los resultados de búsqueda.

Confianza del Usuario: Los navegadores modernos muestran un candado verde junto a la URL cuando se accede a un sitio HTTPS. Esto da confianza a los usuarios de que el sitio es seguro y que sus datos están protegidos.

Requerimiento de Navegadores: Los navegadores como Google Chrome y Mozilla Firefox han comenzado a marcar los sitios HTTP como "no seguros", lo que alerta a los usuarios sobre los riesgos de seguridad.

Requerido para Funciones de Seguridad Avanzadas: Para utilizar características avanzadas como HTTP/2, Content Security Policy (CSP) o Service Workers, HTTPS es obligatorio.