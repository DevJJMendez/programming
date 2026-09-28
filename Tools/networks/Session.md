# Session
Una Session (Sesión) es un almacenamiento temporal en el servidor que permite asociar múltiples peticiones de un mismo usuario a lo largo del tiempo. Es un mecanismo que permite mantener el estado de un usuario entre peticiones HTTP.

📌 En términos simples, una sesión permite que el servidor “recuerde” quién eres entre múltiples peticiones.

## ¿Qué puede almacenar una Session?
Una sesión puede almacenar cualquier tipo de datos relacionados al usuario o flujo:

ID de usuario

Rol o permisos

Token de autenticación

Preferencias de UI

Contenido del carrito de compras

Paso actual de un formulario multistep

## ¿Cuál es la estructura de una sesión?
En términos generales, una sesión consiste en:

Un ID de sesión único (Session ID), generado por el servidor.

Un espacio de almacenamiento en el servidor (en memoria, disco, base de datos o cache).

Un mecanismo de asociación entre cliente y sesión, normalmente mediante cookies o headers.
```bash
Set-Cookie: session_id=abc123; HttpOnly; Secure
```
En backend, una estructura típica puede ser:
```json
{
  "session_id": "abc123",
  "user_id": 1001,
  "role": "admin",
  "cart": [123, 456, 789]
}
```

## ¿Cómo funciona una sesión?
El usuario inicia sesión con sus credenciales.

El servidor valida y genera un session_id.

Este session_id se guarda en una cookie (Set-Cookie) y se envía al navegador.

En cada nueva petición, el navegador envía esa cookie automáticamente.

El servidor usa el session_id para buscar los datos almacenados previamente.

## Qué problema resuelve?
Principalmente resuelve el problema de estado entre peticiones HTTP, ya que HTTP es un protocolo sin estado (stateless).

✅ Permite mantener autenticación activa.

✅ Permite flujos multistep (ej. compras).

✅ Permite personalizar contenido.

## Cómo lo resuelve?
Mediante una combinación de:

Identificador único (cookie, header, etc.)

Almacenamiento temporal (RAM, Redis, DB, etc.)

Vinculación entre requests de un mismo usuario

## Tipos de almacenamiento de sesiones
| Tipo            | Tecnología          | Características                                           |
| --------------- | ------------------- | --------------------------------------------------------- |
| Memory Store    | RAM del servidor    | Rápido, pero volátil (ideal solo para dev)                |
| File Store      | Sistema de archivos | Persistente, pero lento                                   |
| Database Store  | MySQL, PostgreSQL   | Persistente, escalable horizontalmente                    |
| In-Memory Cache | Redis, Memcached    | Alta disponibilidad y rendimiento (ideal para producción) |

## Ejemplo: Login con sesión
```bash
[1] POST /login
  → usuario y contraseña válidos
  → servidor responde con Set-Cookie: session_id=xyz

[2] GET /perfil
  → navegador envía Cookie: session_id=xyz
  → servidor recupera datos de sesión
```

## Seguridad en sesiones
Usa HttpOnly y Secure en cookies.

Gira (rotación) el session_id al reautenticarse.

Establece un TTL (tiempo de vida).

Detecta inactividad y caducidad.

Usa técnicas de regeneración de sesión para mitigar hijacking.

## Consideraciones arquitectónicas
Apps monolíticas: sesión tradicional funciona bien.

Microservicios: conviene token-based o usar Redis centralizado.

SPA (Single Page App): combina cookies HttpOnly + sesiones o JWT.

## Buenas prácticas
Evita almacenar datos sensibles directamente.

Usa Secure, HttpOnly y SameSite.

Expira sesiones tras cierto tiempo o inactividad.

Almacena en Redis para balanceo de carga y escalabilidad.

Si usas sesiones, no mezcles con tokens sin justificación.