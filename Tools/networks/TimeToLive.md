# Time To Live
TTL (Time To Live) es un valor que indica cuánto tiempo un dato es válido antes de ser descartado, actualizado o eliminado.

***Es como ponerle fecha de vencimiento a una información.***

## ¿Dónde se usa el TTL?
TTL es transversal a muchas tecnologías. Algunos casos comunes:
🔗 Redes	TTL en cabecera IP para evitar loops infinitos
🌐 DNS	TTL para la caché de la resolución de nombres
🗃️ Base de datos	TTL para expirar datos temporales (MongoDB, Redis, etc.)
🔐 Seguridad	Tokens o claves con expiración (JWT, OTP, etc.)
🧠 Cachés	TTL en respuestas almacenadas (CDN, Redis, Varnish, etc.)
🧾 APIs idempotentes	TTL para las Idempotency-Key (ej: 24h de validez)

## Estructura general de un TTL
Dependiendo del sistema, puede ser:

En segundos o milisegundos (ttl = 86400)

Como timestamp de expiración (expireAt = 2025-04-25T00:00:00Z)

Como fecha relativa ("expira en 30 minutos")

## ¿Qué resuelve el TTL?
Problema	Solución con TTL
📉 Datos obsoletos	Elimina automáticamente info vencida
♻️ Memoria/caché saturada	Libera recursos con datos que ya no sirven
⌛ Reintentos duplicados (API)	Controla vida útil de claves temporales
🔄 Evitar reconsultas constantes	Mantiene respuesta en caché por un periodo
🔐 Accesos indebidos	Vence sesiones, tokens o contraseñas

## Buenas prácticas con TTL
Recomendación	Detalle
⏱️ Usa TTL para toda info temporal	OTPs, tokens, sesiones, claves de API, etc.
🧹 TTL = autoclean	No necesitas tareas manuales de limpieza
⚠️ Evita TTL excesivamente bajos	Pueden causar expiraciones anticipadas y errores UX
🧪 Testea expiraciones	Asegúrate que el sistema no quede con datos colgados
🗃️ TTL + persistencia opcional	Redis con AOF, Mongo con TTL Index