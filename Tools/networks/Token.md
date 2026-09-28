# Token
Un Token es un fragmento de datos cifrados o codificados que representa la identidad o el permiso de un usuario o sistema.
Se usa para identificar, verificar o autorizar a un cliente (usuario, aplicación, etc.) ante un servidor.

*🔐 Es como una credencial digital temporal.*

## ¿Qué resuelve?
Los tokens resuelven el problema de:

Autenticar usuarios sin necesidad de enviar credenciales en cada request.

Autorizar operaciones sin mantener sesiones en el servidor.

Proveer comunicación segura entre servicios distribuidos.

## ¿Cuál es su estructura?
La estructura depende del tipo de token, pero en el más usado, JWT (JSON Web Token), la estructura es:
```bash
header.payload.signature
```
Header: Tipo de token y algoritmo de firma (ej. HS256).

Payload: Datos del usuario o claims (ej. user_id, roles).

Signature: Firma digital generada con clave secreta o clave pública.

Ejemplo (token codificado):
```bash
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiSkoiLCJpYXQiOjE2ODAwMDAwMDB9.KC4pTNdDqPlCyWLM8zTuN1eH8U2WYQ5gk_yAY1wXZQA
```

## ¿Cómo lo resuelve?
Cuando el usuario inicia sesión con usuario/contraseña:

El servidor valida las credenciales.

Si son válidas, genera un token (por ejemplo JWT).

El token se entrega al cliente (por header o almacenamiento local).

En cada petición futura, el cliente envía el token (por header Authorization).

El servidor valida el token y autoriza el acceso.

## Tipos comunes de Token
￼
Tipo	Uso principal	Características clave
JWT	Autenticación/Autorización	Firmado, puede incluir datos, stateless
Opaque	Autenticación/Autorización	No interpretable, asociado a un registro de sesión
Bearer	En el header Authorization	"Bearer <token>", muy usado con OAuth2
Refresh	Renovar un token expirado	Más duradero, usado para obtener nuevos tokens
CSRF Token	Protección de formularios	Previene ataques CSRF, único por sesión

## ¿Dónde se guarda el token?
sessionStorage o localStorage → si es una SPA

Cookies seguras (HttpOnly + Secure) → si se desea más seguridad

Memory storage → cuando se quiere evitar almacenamiento persistente

## Buenas prácticas
🔒 No almacenar tokens sensibles en localStorage si no es necesario.

❌ Nunca compartir tokens por URL.

✅ Usar HTTPS siempre.

💣 Implementar expiración, revocación y rotación de tokens.