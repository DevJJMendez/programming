# Application Programming Interface
Es un conjunto de reglas, protocolos y herramientas que permiten que dos sistemas, aplicaciones o componentes se comuniquen entre sí de manera estructurada y controlada.

*En palabras sencillas: Una API define cómo un programa puede interactuar con otro programa o servicio.*

## ¿Cuál es su estructura o componentes principales?
Una API típicamente tiene:

￼
Componente	Propósito
Endpoint	Dirección o URL donde se accede a una funcionalidad específica.
Método HTTP (en APIs web)	Acción que se quiere realizar (GET, POST, PUT, DELETE).
Request	Petición enviada al API (puede incluir headers, body, params, etc.).
Response	Respuesta entregada por el API (generalmente en JSON, XML u otros formatos).
Autenticación y Autorización	Mecanismos para asegurar que quien usa la API tiene permiso (API Key, OAuth, JWT, etc.).
Documentación	Descripción clara de cómo usar la API (OpenAPI/Swagger para APIs REST, WSDL para APIs SOAP, etc.).

## ¿Qué resuelve?
Antes de las APIs:

Cada programa debía conocer demasiados detalles del otro para comunicarse.

Había acoplamiento fuerte: cambiar un programa podía romper muchos otros.

Era difícil integrar aplicaciones de diferentes proveedores.

Una API resuelve:

✅ Facilitar la integración entre sistemas.
✅ Aislar detalles internos (abstracción).
✅ Permitir la evolución de los sistemas sin romper a otros.
✅ Reutilizar funcionalidades existentes.
✅ Aumentar la seguridad (exponiendo solo lo necesario).

## ¿Cómo lo resuelve?
Define contratos claros: qué datos aceptar, qué datos retornar, en qué formato, bajo qué reglas.

Usa protocolos estándar: HTTP, HTTPS, WebSocket, gRPC, etc.

Usa formatos estándar: JSON, XML, Protobuf, etc.

Controla acceso mediante autenticación/autorización.

Por ejemplo, cuando desarrollas un frontend en React que consume un backend hecho en Java Spring Boot, interactúan a través de una API REST.

## Ejemplo real de uso de una API
Escenario: Una aplicación móvil quiere mostrar el clima actual.

Cómo funciona:

La app envía una Request HTTP a un API de clima (GET https://api.weather.com/v1/current?city=Bogota).

El API procesa la solicitud y responde con datos JSON:
```json
{
  "city": "Bogota",
  "temperature": "22",
  "unit": "Celsius",
  "description": "Clear Sky"
}
```
La app muestra el resultado en pantalla.

La API permite a la app obtener información del clima sin saber cómo internamente funciona el sistema meteorológico.

## Tipos de APIs más comunes
Tipo	Uso principal
REST API	Basada en HTTP, usa recursos y operaciones estándar (GET, POST, PUT, DELETE).
SOAP API	Protocolos más formales basados en XML (muy usado en entornos empresariales).
gRPC API	Alta eficiencia y velocidad, usa HTTP/2 y Protobuf (ideal para microservicios).
GraphQL API	Cliente define exactamente qué datos necesita (ideal para eficiencia en redes móviles).
WebSocket API	Comunicación en tiempo real, bidireccional (chats, juegos online, etc.).

