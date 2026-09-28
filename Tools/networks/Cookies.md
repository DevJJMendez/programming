# Cookies
Una cookie es un pequeño fragmento de información textual (clave-valor) que un servidor envía al navegador del cliente, y este almacena localmente para que sea enviado nuevamente al servidor en futuras solicitudes.

📌 Su propósito es recordar información entre peticiones HTTP, ya que HTTP es un protocolo **stateless**.

## ¿Cuál es su estructura?
Una cookie HTTP tiene la siguiente sintaxis general en la respuesta:
```bash
Set-Cookie: nombre=valor; Expires=fecha; Path=/; Domain=ejemplo.com; Secure; HttpOnly; SameSite
```
Campos comunes:
| Campo             | Descripción                                      |
| ----------------- | ------------------------------------------------ |
| name=value        | Clave y valor de la cookie                       |
| Expires o Max-Age | Tiempo de vida de la cookie                      |
| Path              | Rutas donde la cookie es válida                  |
| Domain            | Dominios donde se debe enviar                    |
| Secure            | Solo se envía por HTTPS                          |
| HttpOnly          | No accesible desde JavaScript                    |
| SameSite          | Controla el envío entre sitios (CSRF protection) |

## ¿Cómo se envía?
1. Desde el servidor al cliente (respuesta):
```bash
HTTP/1.1 200 OK
Set-Cookie: session_id=abc123; HttpOnly; Secure; SameSite=Strict
``` 
2. Desde el cliente al servidor (siguiente request):
```bash
GET /perfil HTTP/1.1
Cookie: session_id=abc123
```

## ¿Qué problema resuelve?
El problema principal que resuelve es la persistencia de información entre múltiples solicitudes HTTP.

| Sin Cookies                 | Con Cookies                                  |
| --------------------------- | -------------------------------------------- |
| HTTP no tiene memoria       | Se puede mantener estado                     |
| No hay sesión de usuario    | Se pueden gestionar sesiones                 |
| No se recuerda preferencias | Se puede guardar configuraciones por usuario |

## ¿Cómo lo resuelve?
Mediante el envío automático de cookies con cada request al mismo dominio, permitiendo:

Autenticación (tokens, sesión)

Personalización de contenido

Cesta de compras

Analytics

Rastreo de actividad

## Tipos de Cookies
| Tipo                | Descripción                                    |
| ------------------- | ---------------------------------------------- |
| Session Cookies     | Se eliminan al cerrar el navegador             |
| Persistent Cookies  | Tienen una fecha de expiración fija            |
| Secure Cookies      | Solo se transmiten sobre HTTPS                 |
| HttpOnly Cookies    | No son accesibles desde JS (protección XSS)    |
| SameSite Cookies    | Previenen ataques CSRF                         |
| Third-Party Cookies | Provenientes de dominios externos al principal |

## Seguridad con Cookies
* Usar Secure: Solo sobre HTTPS.
* Usar HttpOnly: Evita acceso JS (mitiga XSS).
* Usar SameSite=Strict o Lax: Protege de CSRF.
* Rotación de cookies: Regenerar en cada login.
* Cifrado de valores sensibles: Nunca pongas datos confidenciales en plano.

## Buenas prácticas
* Nunca almacenes tokens sensibles en cookies sin protección.
* Prefiere cookies HttpOnly + Secure para autenticación.
* Define Path y Domain correctamente para evitar exposición innecesaria.
* Implementa SameSite=Lax como mínimo.
* No almacenes estados complejos; solo IDs o referencias.

## Ejemplo real: Login de usuario
El usuario envía POST /login.

El backend valida credenciales y responde con:
```bash
Set-Cookie: auth_token=eyJhbGciOiJIUzI1NiIsInR5...; HttpOnly; Secure; SameSite=Strict
```
El navegador guarda la cookie y la envía automáticamente en cada request posterior.

El backend verifica esa cookie para autenticar la sesión.

## Cookies vs LocalStorage vs SessionStorage
| Característica   | Cookie   | LocalStorage | SessionStorage       |
| ---------------- | -------- | ------------ | -------------------- |
| Acceso desde JS  | Opcional | Sí           | Sí                   |
| Envío automático | Sí       | No           | No                   |
| Límite de tamaño | ~4 KB    | ~5 MB        | ~5 MB                |
| Soporta HttpOnly | Sí       | No           | No                   |
| Persistencia     | Opcional | Permanente   | Hasta cerrar pestaña |