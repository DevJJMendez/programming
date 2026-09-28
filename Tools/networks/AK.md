# AK
Una API Key (clave de API) es un identificador único (habitualmente una cadena alfanumérica larga) que se utiliza para autenticar y en algunos casos autorizar el acceso a una API.

*Es como una "contraseña pública" que una aplicación cliente incluye en sus solicitudes para identificarse ante el servidor.*

## ¿Cuál es su propósito?
Autenticación: Saber qué cliente está haciendo la petición.

Control de acceso: Permitir o denegar operaciones específicas.

Trazabilidad: Rastrear el uso de la API por aplicación o usuario.

Rate Limiting: Aplicar límites por cliente.

Facturación: Controlar planes de uso y tarifas por consumo.

## ¿Qué resuelve?
Sin una API Key, cualquier usuario o bot podría enviar peticiones a una API. Con API Keys, puedes:

Bloquear accesos no autorizados.

Identificar abuso o uso indebido.

Gestionar permisos y roles básicos por clave.

Delegar control por entorno, aplicación o usuario.

## ¿Cómo funciona?
1. Generación de la API Key
El servidor o sistema (como una consola de desarrollador) genera una clave única.

Esta clave se asocia a un usuario, aplicación o servicio específico.

2. Uso en una petición HTTP
La clave se envía usualmente en el header:
```bash
GET /api/data HTTP/1.1
Host: api.example.com
Authorization: Api-Key abc123xyz456
```
O en la query string (menos recomendado por seguridad):
```bash
GET /api/data?api_key=abc123xyz456
```

## Estructura de una API Key
Aunque depende del proveedor, normalmente son:

Cadenas alfanuméricas largas.

A veces prefijadas (ej. sk_live_, pk_test_).

Opcionalmente expiran o tienen versiones.

Ejemplo:
```bash
sk_live_92f8eb0a56f841e4b3a32f45d79a2acb
```

## Seguridad y Buenas Prácticas
￼
Práctica	Descripción
❌ No en frontend	Nunca expongas API Keys secretas en apps frontend (JS, HTML, etc).
🔐 Usa HTTPS	Protege la API Key de sniffing con cifrado en tránsito.
📋 Rotación periódica	Permite revocar y regenerar claves comprometidas.
🎯 Permisos limitados	API Keys deben tener los permisos mínimos (principio de menor privilegio).
🚫 Expiración automática	Opcional pero recomendable en entornos sensibles.
📊 Trazabilidad	Loggear cada uso y monitorear el consumo.
🔄 Revoke	Poder invalidar una API Key comprometida de inmediato.

## Comparación rápida con otros métodos
￼
Método	Autenticación fuerte	Control de permisos	Exposición
API Key	🟡 Media	🟡 Básico	🔴 Alta
OAuth 2.0	🟢 Alta	🟢 Completo	🟢 Segura
JWT	🟢 Alta	🟢 Medio/Alto	🟡 Media
Basic Auth	🔴 Baja	🔴 Ninguno	🔴 Alta
📌 Una API Key no sustituye a OAuth o JWT cuando se necesita autorización por usuario, scopes, roles, etc. Pero es muy útil para apps públicas, SDKs, o servicios internos.

## Casos de uso típicos
Servicios públicos como Google Maps, SendGrid, Twilio.

Comunicación entre microservicios internos.

SDKs frontend donde la autenticación de usuario no es obligatoria.

Aplicaciones móviles que consumen servicios públicos (con precauciones).