# Cross-Origin Resource Sharing
CORS (Cross-Origin Resource Sharing) es un mecanismo de seguridad que permite o restringe que los navegadores web realicen peticiones a un dominio diferente (origen) del que sirve el contenido de la página actual.

Cross-Origin significa cruzar orígenes, es decir, hacer peticiones HTTP a un servidor que está en un dominio distinto.

En pocas palabras, CORS permite que los navegadores interactúen de manera controlada con recursos de diferentes dominios.

## ¿Por qué es necesario?
El origen de una página web es un combinado de:

Protocolo: http, https, etc.

Dominio: example.com, api.example.com, etc.

Puerto: 80, 443, etc.

Cuando el origen de la página y el origen del recurso al que se hace la petición son diferentes, el navegador bloquea la solicitud por motivos de seguridad (para prevenir ataques como el cross-site request forgery o CSRF).

Ejemplo de orígenes diferentes:
Página web: https://www.miweb.com

API: https://api.miweb.com

Aunque ambas pertenecen al mismo sitio web, se consideran orígenes diferentes porque son subdominios distintos.

## ¿Cómo resuelve CORS los problemas de seguridad?
Cuando el navegador intenta hacer una solicitud a otro dominio, CORS le pide al servidor remoto que autorice esta interacción mediante el uso de cabeceras HTTP específicas. Si el servidor acepta la solicitud, el navegador permitirá que la petición se complete. Si no, bloqueará la solicitud.

Por ejemplo, cuando un cliente intenta hacer una solicitud AJAX o una fetch a otro dominio, el navegador agrega una cabecera especial llamada Origin, que indica el origen de la página que hizo la solicitud. El servidor, entonces, responde con una cabecera CORS que indica si la solicitud es permitida o no.

Flujo de CORS:
El navegador envía una solicitud de origen cruzado (por ejemplo, un AJAX o fetch a una API en otro dominio).

El servidor responde con una cabecera Access-Control-Allow-Origin, especificando si el origen de la página es permitido o no.

Si la cabecera es válida, el navegador permitirá el acceso al recurso; de lo contrario, bloqueará la solicitud.

## ¿Cuáles son las cabeceras principales de CORS?
Aquí tienes algunas de las cabeceras más importantes que el servidor puede enviar en la respuesta:

1. Access-Control-Allow-Origin
Es la cabecera más importante en CORS.

Indica qué orígenes tienen permitido acceder al recurso.

Puede ser un origen específico (https://miweb.com) o el valor especial * (permitiendo cualquier origen).

Ejemplo:
```bash
Access-Control-Allow-Origin: https://miweb.com
```
O para permitir todos los orígenes:
```bash
Access-Control-Allow-Origin: *
```

2. Access-Control-Allow-Methods
Especifica qué métodos HTTP (GET, POST, PUT, DELETE, etc.) están permitidos.
Ejemplo:
```bash
Access-Control-Allow-Methods: GET, POST, PUT
```

3. Access-Control-Allow-Headers
Indica qué cabeceras adicionales pueden ser enviadas con la solicitud.

Ejemplo:
```bash
Access-Control-Allow-Headers: Content-Type, Authorization
```

4. Access-Control-Allow-Credentials
Indica si el navegador puede enviar credenciales (cookies, cabeceras de autenticación) con la solicitud.

Ejemplo:
```bash
Access-Control-Allow-Credentials: true
```

5. Access-Control-Max-Age
Indica por cuánto tiempo el resultado de la verificación CORS debe ser cacheado por el navegador.

Ejemplo
```bash
Access-Control-Max-Age: 3600
```

6. Access-Control-Expose-Headers
Indica qué cabeceras pueden ser leídas por el código cliente, aparte de las estándar (como Content-Type o Content-Length).

Ejemplo:
```bash
Access-Control-Expose-Headers: X-Custom-Header
```

## Tipos de solicitudes CORS
1. Solicitudes Simples (Simple Requests)
Una solicitud se considera "simple" cuando cumple con ciertas condiciones, como el uso de métodos HTTP seguros (GET, POST, HEAD) y cabeceras estándar (por ejemplo, Content-Type: application/json).

El navegador solo envía una solicitud con la cabecera Origin y espera una respuesta con Access-Control-Allow-Origin.

2. Preflight Requests (Solicitud Previa)
Si la solicitud no es "simple" (por ejemplo, usa métodos PUT, DELETE, o cabeceras no estándar), el navegador primero envía una solicitud de tipo "preflight" (verificación preliminar). Esta es una solicitud OPTIONS al servidor para comprobar si el servidor acepta solicitudes de ese origen.

La respuesta a esta solicitud contiene cabeceras como Access-Control-Allow-Methods y Access-Control-Allow-Headers.

Ejemplo de una solicitud de preflight
```bash
OPTIONS /api/resource
Host: api.miweb.com
Origin: https://www.miweb.com
Access-Control-Request-Method: POST
Access-Control-Request-Headers: Content-Type
```

## ¿Cuáles son los problemas comunes al trabajar con CORS?
1. Error: No se permite el origen
Si no se especifica correctamente el origen en el servidor, o si se usa * de forma inadecuada (por ejemplo, cuando se manejan credenciales), el navegador bloqueará la solicitud.

2. Error con las cabeceras personalizadas
Si un cliente intenta enviar una cabecera personalizada (como Authorization) y el servidor no lo permite en Access-Control-Allow-Headers, la solicitud será bloqueada.

3. Preflight fallido
Si el servidor no responde correctamente a la solicitud OPTIONS, el navegador no completará la solicitud CORS.

## Ejemplo de implementación de CORS
En un servidor Node.js usando Express, podrías configurar CORS de la siguiente manera:
```js
const express = require('express');
const cors = require('cors');
const app = express();

// Permitir solicitudes CORS de un dominio específico
app.use(cors({
  origin: 'https://www.miweb.com',
  methods: ['GET', 'POST'],
  allowedHeaders: ['Content-Type', 'Authorization'],
  credentials: true
}));

app.get('/data', (req, res) => {
  res.json({ message: "¡Acceso permitido!" });
});

app.listen(3000, () => console.log('Servidor corriendo en el puerto 3000'));
```