# Representational State Transfer
Es un estilo arquitectónico para diseñar servicios web ligeros, escalables y fáciles de mantener, propuesto por Roy Fielding en su tesis doctoral en el año 2000.

REST no es un protocolo (como HTTP o FTP).
REST es un conjunto de principios para construir APIs que funcionen bien sobre HTTP (aunque se podría aplicar sobre otros protocolos).

## ¿Cuál es su estructura o componentes principales?
Una API RESTful (es decir, que respeta REST) tiene que aplicar los siguientes principios o restricciones:

Principio REST	Explicación
Identificación de recursos	Cada recurso (datos como usuarios, productos, órdenes) debe tener una URL única. Ejemplo: /users/123
Representación de recursos	El cliente recibe una "representación" del recurso, usualmente en JSON, XML u otro formato.
Comunicación stateless	Cada request debe contener toda la información necesaria. El servidor no guarda estado entre peticiones.
Operaciones uniformes	Se usan métodos HTTP estándar: GET, POST, PUT, PATCH, DELETE.
Uso de hipermedios (HATEOAS)	(Opcional) La respuesta puede contener enlaces para navegar entre recursos relacionados.
Caché	Las respuestas deben ser cacheables cuando sea posible para optimizar el rendimiento.

## Componentes básicos en una API REST
Recursos: Entidades que deseas exponer (ej.: Usuario, Producto, Pedido).

URI: Localización del recurso (ej.: /api/products/12).

Métodos HTTP: Qué acción se realiza sobre el recurso.

Representaciones: Cómo se envían los datos (ej.: JSON, XML).

Headers: Para definir detalles como el tipo de contenido (Content-Type: application/json).

## ¿Qué resuelve REST?
Antes de REST:

Las APIs eran pesadas (como SOAP).

Cada sistema podía inventarse su propia forma de comunicar (dificultad de integración).

Las integraciones eran lentas, costosas, frágiles.

REST resuelve:

✅ Crear APIs predecibles, escalables y fáciles de consumir.
✅ Estándar común: todo el mundo entiende una API REST bien hecha.
✅ Acelerar el desarrollo y mantenimiento de APIs y clientes (móvil, web, microservicios).
✅ Separar claramente cliente y servidor.

## ¿Cómo lo resuelve?
REST define unas restricciones claras para que:

El servidor se enfoque en servir recursos.

El cliente pueda entender qué hacer con esos recursos.

Se puedan cachear respuestas, mejorar performance y mantener escalabilidad horizontal (multiplicar servidores sin problema).

La simplicidad y el uso de estándares web como HTTP y URI hacen que REST sea eficiente.

## Ejemplo práctico de REST
Imagina una API de una tienda en línea.

￼
Acción	Método HTTP	URI
Obtener lista de productos	GET	/api/products
Obtener un producto	GET	/api/products/123
Crear un nuevo producto	POST	/api/products
Actualizar un producto completo	PUT	/api/products/123
Actualizar parcialmente un producto	PATCH	/api/products/123
Borrar un producto	DELETE	/api/products/123

Request para crear un producto:
```bash
POST /api/products
Content-Type: application/json

{
  "name": "Teclado Mecánico",
  "price": 79.99
}
```
Response esperada:
```bash
HTTP/1.1 201 Created
Location: /api/products/124

{
  "id": 124,
  "name": "Teclado Mecánico",
  "price": 79.99
}
```

## Buenas prácticas RESTful que debes dominar
✅ Usa sustantivos en las URIs (/products), no verbos (/getProducts).
✅ Responde con los códigos HTTP correctos (200 OK, 201 Created, 400 Bad Request, 404 Not Found, 500 Internal Server Error).
✅ Mantén stateless cada request (no dependas de sesión de servidor).
✅ Usa versionamiento en la API (/api/v1/products).
✅ Paginar resultados cuando haya muchas entidades (GET /products?page=2&size=10).
✅ Permite filtrar y ordenar (GET /products?category=teclados&sort=price_desc).
✅ Sé consistente en las respuestas: formatos, errores, estructuras.
✅ Documenta todo el API.

# Identificación de Recursos
En sistemas distribuidos y en APIs (REST, gRPC, etc.), un recurso es cualquier entidad lógica que se puede acceder, manipular o representar:

Un usuario, un producto, una factura, un carrito de compras, etc.

Identificación de recursos significa:

Cómo nombramos (URI/URL/ID).

Cómo estructuramos la ruta.

Cómo referenciamos de forma clara, predecible y consistente a cada recurso en el sistema.

En REST, la URI (Uniform Resource Identifier) es el medio para identificar recursos.

## Nomenclaturas
1. Usa sustantivos (no verbos)
✅ Correcto:
```bash
GET /users
POST /products
DELETE /orders/23
```
Porque los recursos son "cosas", no "acciones".

❌ Incorrecto:
```bash
GET /getUsers
POST /createProduct
DELETE /deleteOrder
```
El verbo va en el método HTTP (GET, POST, DELETE), no en la ruta.

2. Pluraliza los recursos
✅ Correcto:
```bash
/users
/products
/invoices
```
Porque normalmente accedemos a colecciones de recursos.

❌ Incorrecto:
```bash
/user
/product
/invoice
```
El singular rompe el modelo de colecciones y crea inconsistencias.

3. Usa rutas jerárquicas (parentesco lógico)
Ejemplo:
```bash
/users/45/orders/107
```
Usuario 45 tiene orden 107.

No inventes estructuras extrañas como:
```bash
/orders?userId=45
```
(aunque en algunos filtros avanzados puede aceptarse).

4. Usa minúsculas y guiones (-) o sin espacios
✅ Correcto:
```bash
/user-profiles
/customer-orders
/payment-methods
```
No uses:

CamelCase (/UserProfiles) ❌

Espacios codificados (/user%20profiles) ❌

5. Usa IDs para recursos específicos
Cuando quieres un recurso único:
```bash
/users/1234
/products/5678
/orders/2024-INV-007
```
El ID puede ser:

Numérico (1234).

UUID (c5fcb5b6-27c4-4b5e-8d50-31b39b218a52).

Códigos empresariales (ORD-2024-01).

✅ Siempre los IDs deben ser únicos y no ambiguos.

6. No pongas tipos de recurso en la URI
Ejemplo:

✅ Correcto:
```bash
/users/1234
```
❌ Incorrecto:
```bash
/users/1234.json
/users/1234.xml
```
El tipo de contenido (application/json, application/xml) debe ser negociado usando headers (Accept), no en la URL.

7. Filtrado, ordenamiento y paginación en Query Parameters
✅ Correcto:
```bash
/products?category=electronics&sort=price_desc&page=2&limit=20
```
Separas claramente:

Recurso /products

Operaciones adicionales en los query parameters.

## Ejemplo
```bash
GET /products
GET /products/9876
POST /products
PUT /products/9876
DELETE /products/9876

GET /categories
GET /categories/5/products

GET /users
GET /users/1234/orders
GET /users/1234/cart
POST /users/1234/cart
DELETE /users/1234/cart/6789

POST /checkout
```

# Versionamiento
El versionamiento de API es el proceso de gestionar cambios en la API de manera que:

Nuevas funcionalidades o cambios no rompan a los consumidores actuales.

Se permita la evolución controlada de la API.

Se garantice la retrocompatibilidad (backward compatibility) o se maneje su ruptura de manera organizada.

## ¿Para qué sirve el versionamiento?
✅ Separar cambios mayores: Cuando agregas o cambias el comportamiento de tu API, no forzarás a todos los clientes a adaptarse inmediatamente.

✅ Permitir múltiples versiones activas: Algunos clientes seguirán usando la versión anterior mientras otros usan la nueva.

✅ Controlar la transición: Planificar y comunicar de forma clara cuándo se deprecara una versión.

✅ Minimizar riesgos: No romper sistemas en producción.

✅ Facilitar evolución tecnológica: Puedes reestructurar o mejorar tu API sin afectar contratos anteriores.

## ¿Cómo se versiona una API?
### Versionado en la URI (URL Versioning) ✅ [La más común]
Incluir la versión en la ruta.

Ejemplo:
```bash
GET /api/v1/users
POST /api/v2/orders
```
✅ Ventajas:

Muy explícito.

Fácil de entender y documentar.

Fácil en arquitecturas basadas en rutas (routing).

❌ Desventajas:

Puede generar redundancia si no se gestiona bien.

### Versionado en el Header
Pedir que los clientes especifiquen la versión como un custom header.

Ejemplo:
```bash
GET /users
Header: Accept-Version: v1
```
✅ Ventajas:

URI limpia.

Buen control desde el cliente.

❌ Desventajas:

Más difícil de depurar/debuggear desde navegador.

No siempre bien soportado en herramientas como navegadores, proxies, etc.

### Versionado en el Content-Type (Content Negotiation)
Usar media types personalizados.

Ejemplo:
```bash
GET /users
Header: Accept: application/vnd.myapp.v1+json
```
✅ Ventajas:

Muy RESTful.

Estándar en APIs empresariales grandes.

❌ Desventajas:

Más complejo.

Menos conocido para clientes principiantes.

### Versionado basado en Parámetros de Query (menos recomendado)
Agregar versión como parámetro en la URL.

Ejemplo:
```bash
GET /users?version=1
```
✅ Ventajas:

Simple de implementar.

❌ Desventajas:

Poco intuitivo.

Rompe buenas prácticas REST.

## Buenas Prácticas de Versionado de API
￼
Concepto	Buenas Prácticas
Versión visible	Haz visible la versión (URI o Header), no oculta.
Cambios mayores = nueva versión	Si el cambio rompe compatibilidad (breaking change), sube de versión (v1 -> v2).
Cambios menores = misma versión	Cambios compatibles hacia atrás (agregar campos opcionales) no requieren nueva versión.
Deprecación clara	Anuncia las deprecaciones con tiempo y proporciona documentación de migración.
Evita eternizar versiones	Establece políticas para retirar (sunset) versiones antiguas.
Mantén la simplicidad	No compliques el cliente con múltiples métodos para la misma operación.
Documentación por versión	Cada versión de la API debe tener su propia documentación.

## Cosas Avanzadas que debes saber
￼
Tema	Detalle
SemVer (Semantic Versioning)	Algunas APIs internas aplican SemVer (v1.2.0), aunque en APIs públicas normalmente solo v1, v2 para simplificar.
Soft vs Hard Versioning	Puedes hacer cambios suaves (añadir campos) sin nueva versión, cambios duros (cambiar comportamiento) requieren nueva versión.
Sunset Header	Puedes usar el header Sunset para indicar que una versión será eliminada.
API Gateways	En APIs modernas (AWS API Gateway, Apigee, Kong), se puede manejar múltiples versiones centralizadamente.
Backward Compatibility	Es el corazón de un buen versionado: nunca rompas a clientes existentes sin aviso.

## Ejemplo
Supongamos que tienes una API de productos:

v1
```bash
GET /api/v1/products
Response:
[
  { "id": 1, "name": "Laptop" }
]
```
v2
```bash
GET /api/v2/products
Response:
[
  { "id": 1, "name": "Laptop", "price": 1500 }
]
```
En v2, se agregó el precio.

Los clientes que usan v1 no rompen su integración.