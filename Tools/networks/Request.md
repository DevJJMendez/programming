# Request
En el contexto de la informática y, específicamente, en las aplicaciones web y la arquitectura de redes, el concepto de request o solicitud hace referencia al proceso en el cual un cliente (generalmente un navegador web o una aplicación) solicita un servicio o recurso a un servidor. Este proceso es esencial en la comunicación cliente-servidor, que es el núcleo de la mayoría de las aplicaciones distribuidas modernas, como las basadas en la web.

¿Qué es un Request?
Un request es simplemente una petición enviada desde un cliente hacia un servidor para obtener información o realizar alguna acción. Los request pueden involucrar solicitudes de datos, ejecución de operaciones en el servidor, autenticación de usuarios, envío de datos (por ejemplo, formularios) o la solicitud de recursos como imágenes, scripts o archivos.

En el contexto de aplicaciones web, un request HTTP (o solicitud HTTP) es una de las solicitudes más comunes que los clientes (por ejemplo, navegadores web) realizan hacia los servidores web.

## Estructura de un Request HTTP
Un request HTTP consta de varias partes, que permiten al servidor entender y procesar la solicitud. La estructura básica de un request HTTP es la siguiente:

1. Línea de solicitud (Request Line):

Es la primera línea del request y define qué tipo de solicitud está realizando el cliente.

Tiene tres componentes:

Método HTTP: Indica la acción que el cliente quiere realizar. Los métodos más comunes son:

GET: Solicita información del servidor (por ejemplo, obtener una página web).

POST: Envia datos al servidor (por ejemplo, enviar un formulario).

PUT: Actualiza recursos en el servidor.

DELETE: Elimina recursos del servidor.

PATCH: Realiza actualizaciones parciales de un recurso.

Ruta del recurso (Request URI): Especifica el recurso o dirección que se está solicitando. Por ejemplo, /index.html o /api/users.

Versión del protocolo HTTP: Indica la versión del protocolo HTTP que está utilizando el cliente (por ejemplo, HTTP/1.1 o HTTP/2).

Ejemplo
```bash
GET /index.html HTTP/1.1
```

2. Encabezados de solicitud (Request Headers):

Son líneas adicionales que siguen a la línea de solicitud. Estos encabezados proporcionan metadatos sobre la solicitud o el cliente que realiza la petición.

Los encabezados comunes incluyen:

Host: El dominio al que se realiza la solicitud (por ejemplo, www.example.com).

User-Agent: Información sobre el navegador o cliente que está realizando la solicitud (por ejemplo, un navegador web).

Accept: Indica qué tipos de contenido puede manejar el cliente (por ejemplo, text/html, application/json).

Authorization: Información para autenticarse en el servidor, como un token o credenciales básicas.

Ejemplo:
```bash
Host: www.example.com
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3
Accept: text/html, application/xhtml+xml, application/xml;q=0.9, image/webp,*/*;q=0.8
```

3. Cuerpo de la solicitud (Request Body) (opcional):

Es el cuerpo de la solicitud que puede contener datos enviados por el cliente al servidor. Este cuerpo es común en métodos como POST y PUT, que envían datos al servidor (por ejemplo, datos de un formulario o un archivo).

El cuerpo puede estar en diferentes formatos, como JSON, XML, formulario URL-encoded, multipart/form-data, entre otros.

En una solicitud GET, generalmente no hay cuerpo de solicitud, ya que los parámetros se pasan a través de la URL.

Ejemplo:
```bash
{
  "username": "john_doe",
  "password": "mypassword"
}
```

4. Parámetros de la URL (Query Parameters) (opcional):

En los métodos GET y otros, los parámetros adicionales se pueden incluir en la URL, separados por ? (y, si hay más parámetros, separados por &).

Por ejemplo, al buscar en un sitio web o enviar datos a través de la URL.

Ejemplo de URL con parámetros:
```bash
GET /search?q=python&lang=en HTTP/1.1
```

## ¿Qué Resuelve un Request?
Los requests resuelven varios problemas esenciales en el ámbito de las aplicaciones distribuidas:

Solicitar Datos: Permite a los clientes obtener recursos del servidor, como HTML, imágenes, o datos a través de APIs.

Enviar Datos al Servidor: Los requests como POST o PUT permiten enviar datos (por ejemplo, formularios de usuario, archivos) al servidor para ser procesados o almacenados.

Realizar Acciones: Los requests permiten a los usuarios ejecutar acciones en el servidor, como eliminar recursos (con el método DELETE) o actualizar información (con el método PUT o PATCH).

Autenticación y Seguridad: Los requests pueden incluir información para la autenticación (por ejemplo, Authorization headers), lo que permite que el servidor verifique la identidad del cliente antes de permitir el acceso a recursos protegidos.

## ¿Cómo Resuelve un Request?
El request resuelve la comunicación entre el cliente y el servidor de la siguiente manera:

Procesamiento del Request por el Servidor:

Cuando el servidor recibe una solicitud, primero valida la línea de solicitud para asegurarse de que se trata de una solicitud válida.

Luego, examina los encabezados para obtener detalles adicionales sobre la solicitud (como el tipo de contenido que espera el cliente, el tipo de cliente, etc.).

Si el request contiene un cuerpo de solicitud, el servidor lo procesa, por ejemplo, validando los datos del formulario o ejecutando la acción solicitada.

Finalmente, el servidor prepara una respuesta HTTP, que generalmente incluirá los datos solicitados, una confirmación de la acción realizada o un error si algo salió mal.

Flujo de Respuesta:

Una vez procesado el request, el servidor envía una respuesta HTTP de vuelta al cliente, que incluye el código de estado HTTP (por ejemplo, 200 OK, 404 Not Found) y, si es necesario, los datos solicitados.

## Tipos de Requests Comunes
GET: Solicita un recurso del servidor. Los datos se pasan generalmente a través de la URL.

POST: Envia datos al servidor para que sean procesados o almacenados. Es comúnmente usado para enviar formularios.

PUT: Actualiza un recurso existente en el servidor.

DELETE: Elimina un recurso en el servidor.

PATCH: Realiza modificaciones parciales a un recurso existente.

HEAD: Similar a GET, pero solo obtiene los encabezados sin el cuerpo de la respuesta.

OPTIONS: Obtiene las opciones disponibles para un recurso o servidor.

# Request Headers
Los Request Headers (cabeceras de solicitud) son componentes clave de una solicitud HTTP que permiten al cliente (por ejemplo, un navegador o una app móvil) enviar información adicional al servidor. Esta información ayuda al servidor a entender:

Quién hace la solicitud

Cómo manejar la respuesta

Qué tipo de contenido espera el cliente

Qué capacidades tiene el cliente

Si se requiere autenticación

Entre muchos otros detalles…

Son una parte crítica del protocolo HTTP, y permiten que el sistema sea flexible, seguro, y adaptable.

## ¿Cuál es su estructura?
Los headers están organizados como pares clave-valor. Cada línea representa un header:
```bash
Header-Name: Header-Value
```
Ejemplo real de un bloque de headers en un request:
```bash
GET /api/products HTTP/1.1
Host: api.mitienda.com
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)
Accept: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
```

## ¿Qué resuelve?
Negociación de contenido
El cliente puede decirle al servidor qué tipo de contenido espera (Accept) o en qué idioma lo prefiere (Accept-Language).

Autenticación y Seguridad
Headers como Authorization, Cookie, y X-CSRF-Token permiten autenticación segura y validación.

Control de caché
Headers como Cache-Control o If-Modified-Since permiten controlar la respuesta según el estado del contenido.

Soporte de tecnología y compatibilidad
Headers como User-Agent informan al servidor sobre el dispositivo y navegador, permitiendo respuestas personalizadas.

Control de origen y seguridad CORS
Headers como Origin permiten saber si la solicitud vino de un dominio confiable.

## ¿Cómo lo resuelve?
El servidor interpreta estos headers antes de procesar el cuerpo del request. En función de estos, puede:

Personalizar la respuesta (idioma, formato, compresión)

Validar si el usuario está autenticado

Rechazar la solicitud si viene de un origen no autorizado

Aplicar reglas de caché o rate limiting

## Headers más comunes y su función
| Header            | ¿Qué hace?                                  | Ejemplo                                          |
| ----------------- | ------------------------------------------- | ------------------------------------------------ |
| Host              | Especifica el dominio del servidor          | Host: www.example.com                            |
| User-Agent        | Identifica al cliente (navegador, app, bot) | User-Agent: Mozilla/5.0                          |
| Accept            | Tipos MIME que acepta el cliente            | Accept: application/json                         |
| Accept-Language   | Idiomas preferidos                          | Accept-Language: es-ES, en-US                    |
| Accept-Encoding   | Algoritmos de compresión soportados         | Accept-Encoding: gzip, deflate                   |
| Authorization     | Token o credenciales de autenticación       | Authorization: Bearer abc123...                  |
| Content-Type      | Tipo de datos en el cuerpo (para POST/PUT)  | Content-Type: application/json                   |
| Content-Length    | Tamaño del cuerpo en bytes                  | Content-Length: 348                              |
| Cookie            | Cookies enviadas por el cliente             | Cookie: sessionId=abc123                         |
| Referer           | URL de origen de la petición                | Referer: https://google.com                      |
| Origin            | Dominio de origen de la solicitud           | Origin: https://frontend.com                     |
| X-Requested-With  | Usado para identificar AJAX requests        | X-Requested-With: XMLHttpRequest                 |
| If-Modified-Since | Permite caching condicional                 | If-Modified-Since: Wed, 21 Oct 2023 07:28:00 GMT |

## Headers personalizados (Custom Headers)
Puedes crear headers propios. Se recomienda usar el prefijo X- para evitar colisiones con los estándares oficiales:

```bash
X-Client-Version: 1.0.3
X-Request-ID: 9a8b7c
```
Son útiles para:
* Debugging
* Trazabilidad
* Versionamiento de APIs
* Autenticación extendida

## Consideraciones de seguridad
* No envíes tokens en Query String, usa Authorization header o cookies seguras.
* Usa HTTPS para proteger todos los headers durante el transporte.
* Revisa los headers en proxies e intermediarios, pueden modificar o filtrar contenido sensible.

# Request Body
El Request Body es la parte del mensaje HTTP que contiene los datos que el cliente envía al servidor. Se utiliza típicamente en métodos como POST, PUT, PATCH, DELETE, donde se necesita enviar información adicional para crear, actualizar o eliminar recursos.

* No se usa en métodos como GET, ya que estos no deben tener cuerpo por estándar (aunque técnicamente puede incluirse, no está soportado por todos los servidores).

## ¿Cuál es su estructura?
El cuerpo es un bloque de datos en bruto que puede tener diversos formatos según el tipo de contenido (definido en el header Content-Type).

Ejemplos:

JSON (común en APIs RESTful):
```json
{
  "nombre": "Carlos",
  "email": "carlos@example.com",
  "edad": 30
}
```
`Content-Type: application/json`

Form URL Encoded (típico en formularios HTML):
```bash
nombre=Carlos&email=carlos%40example.com&edad=30
```
Content-Type: application/x-www-form-urlencoded

Multipart Form Data (para enviar archivos y datos combinados):
```bash
--boundary
Content-Disposition: form-data; name="username"

Carlos
--boundary
Content-Disposition: form-data; name="file"; filename="foto.jpg"
Content-Type: image/jpeg

[binary data]
--boundary--
```
`Content-Type: multipart/form-data; boundary=...`

Texto plano:
```bash
Hola, este es un mensaje simple.
```
`Content-Type: text/plain`

## ¿Qué resuelve?
📦 Transporte de datos estructurados entre el cliente y el servidor.

📝 Permite el envío de formularios, objetos, archivos, imágenes, etc.

🧠 Habilita operaciones CRUD completas en sistemas backend/API.

🔹 ¿Cómo lo resuelve?
✅ El cliente prepara el cuerpo del request con los datos que quiere enviar.

✅ Define el tipo de contenido con el header Content-Type.

✅ El servidor lee y parsea el body según el tipo especificado.

✅ Los datos extraídos son procesados para ejecutar acciones como:

Guardar en base de datos

Validar formularios

Autenticar usuarios

Subir archivos, etc.

## ¿Cómo se ve un request completo con body?
```bash
POST /api/usuarios HTTP/1.1
Host: api.miapp.com
Content-Type: application/json
Authorization: Bearer abc123
Content-Length: 69

{
  "nombre": "Carlos",
  "email": "carlos@example.com",
  "password": "123456"
}
```