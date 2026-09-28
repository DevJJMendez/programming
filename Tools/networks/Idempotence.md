# idempotencia
La idempotencia es una propiedad de ciertas operaciones donde repetir la misma operación múltiples veces produce el mismo resultado que hacerlo una sola vez, sin causar efectos secundarios adicionales.

En otras palabras:
Hacerlo 1 vez = hacerlo 100 veces = mismo estado final del sistema.

## ¿Cuál es su propósito?
Evitar duplicaciones o efectos secundarios al reenviar solicitudes (por fallos, timeouts, retry automático).

Permitir que una operación pueda repetirse de forma segura.

Ayudar en el diseño de APIs REST, microservicios y sistemas distribuidos confiables.

## ¿Qué resuelve?
Problema	¿Cómo lo resuelve?
Reintentos por fallas de red	Permite repetir la operación sin duplicar el efecto
Garantía de consistencia	Ayuda a mantener el sistema en un estado coherente
Comportamiento predecible	Evita efectos colaterales inesperados
Evitar duplicados	Especialmente útil en operaciones como pagos o transferencias

## ¿Cómo se clasifica según el verbo HTTP?
| Método | ¿Es idempotente? | Explicación                                           |
| ------ | ---------------- | ----------------------------------------------------- |
| GET    | Si               | Leer recurso no lo modifica                           |
| HEAD   | Si               | Igual que GET pero sin cuerpo                         |
| PUT    | Si               | Actualiza o reemplaza el recurso                      |
| DELETE | Si (en teoría)   | Eliminar varias veces = mismo resultado (no existe)   |
| POST   | No               | Crea recursos → múltiples POST = múltiples creaciones |
| PATCH  | Depende          | Si modifica parcialmente puede no ser idempotente     |

## Ejemplos de idempotencia
✅ Ejemplo idempotente: PUT
```bash
PUT /usuario/123
Body: {
  "nombre": "Juan",
  "email": "juan@email.com"
}
```
Llamarlo 1 vez o 100 veces → mismo resultado: usuario actualizado con esos datos.

## Ejemplo NO idempotente: POST
```bash
POST /transaccion
Body: {
  "monto": 100,
  "cliente": "A"
}
```
Cada llamada crea una nueva transacción → múltiples efectos → no es idempotente

## ¿Cómo se implementa la idempotencia?
Depende del caso de uso y el backend. Algunas estrategias:

1. Uso de tokens únicos de idempotencia (idempotency key)
En cada request se envía un header:
```bash
Idempotency-Key: abc123
```
El servidor guarda el resultado para esa clave. Si vuelve a recibir la misma clave, devuelve el resultado anterior.

✅ Muy usado en sistemas de pago como Stripe, MercadoPago.

2. Chequeo de existencia antes de operar
```sql
IF NOT EXISTS (SELECT * FROM usuarios WHERE id = 123) THEN INSERT
```

3. Diseño basado en reemplazo total
Ejemplo:
```bash
PUT /producto/456
Body: {...nuevo estado completo...}
```
Sobrescribe, sin importar cuántas veces lo envíes.

## Buenas prácticas en diseño de APIs idempotentes
* Los métodos GET, PUT y DELETE deben ser idempotentes por diseño.
* Los POST deben evitar efectos colaterales irreversibles sin protección.
* Implementa control de duplicidad en operaciones críticas (como pagos).
* Usa tokens de idempotencia si tu API puede recibir reintentos automáticos.
* Loguea correctamente y responde siempre de forma coherente.

# Idempotency-Key
Es un header HTTP que se utiliza para identificar de forma única una operación específica de una solicitud HTTP.
Permite que el servidor reconozca solicitudes repetidas (por reintentos, caídas de conexión, etc.) y evite procesarlas varias veces.

En lugar de repetir la operación, el servidor devuelve el mismo resultado que generó la primera vez que recibió esa Idempotency-Key.

## ¿Cuál es su propósito?
Evitar duplicación de acciones (como cobros, creación de recursos, etc.)

Garantizar consistencia en operaciones críticas

Soportar reintentos automáticos seguros

Diseñar APIs robustas y tolerantes a fallos

## ¿Cómo funciona?
1. El cliente genera un token único
```bash
POST /transacciones
Idempotency-Key: c26b7ac7-f7dd-4f91-bccf-b81e54d19900
Content-Type: application/json

{
  "cliente_id": 123,
  "monto": 100
}
```

2. El servidor:
Verifica si ya procesó una solicitud con ese Idempotency-Key

Si ya existe:

❌ No ejecuta la operación de nuevo

✅ Devuelve el resultado guardado

Si no existe:

✅ Procesa normalmente

✅ Guarda el resultado junto con la clave

## Ejemplo visual
```bash
# Cliente intenta realizar un POST para pagar
curl -X POST https://api.miapp.com/pago \
     -H "Idempotency-Key: 9f8a23b5" \
     -d '{ "monto": 100 }'

# Se cae el cliente y vuelve a intentar...
curl -X POST https://api.miapp.com/pago \
     -H "Idempotency-Key: 9f8a23b5" \
     -d '{ "monto": 100 }'

# El servidor responde: ya lo procesé, aquí está el resultado anterior
```

## ¿Qué debe guardar el servidor?
idempotency_key

URL del request

Método HTTP (POST, PUT, etc)

Cuerpo de la solicitud

Resultado de la respuesta

Timestamp (con TTL opcional)

🧠 Esto se guarda en una tabla o caché persistente (ej: Redis, PostgreSQL, Mongo, etc.)

## Buenas prácticas al implementar Idempotency-Key
Práctica	Descripción
✅ Generar el token desde el cliente	Usa UUID v4 o un hash único
✅ Guardar request + response	Para poder comparar y devolver correctamente
✅ TTL o expiración	Evita saturar la base con claves antiguas
✅ Validar consistencia	Si llega un request con misma key pero distinto body → Error 409 Conflict
⚠️ No usar en operaciones GET	Solo se usa en operaciones con efectos secundarios (POST/PUT/PATCH/DELETE)

¿Dónde debes usar idempotencia?
1. Operaciones que modifican estado
Especialmente las que crean recursos o tienen efectos importantes.

POST /pagos

POST /ordenes

PUT /usuario/123

DELETE /producto/456

2. APIs financieras o de misión crítica
Bancos

Pasarelas de pago

Creación de cuentas o pedidos

## ¿Qué pasa si dos clientes mandan la misma clave?
Debes asegurar aislamiento de usuario.
La Idempotency-Key debe estar asociada a la combinación de:

Usuario autenticado

Método HTTP

Ruta de la solicitud

Así se evita que un usuario interfiera con otro.

## Errores comunes
No guardar el resultado de la primera ejecución → no se puede devolver luego

Usar body dinámico con la misma clave → inconsistencia

No definir un tiempo de expiración para las claves

# No-Idempotency
Este término está directamente relacionado con el comportamiento de las operaciones HTTP y la forma en que los sistemas manejan los reintentos o las peticiones repetidas.

🧠 ¿Qué significa "No-Idempotente"?
Una operación no-idempotente es aquella en la que repetir una misma solicitud produce efectos diferentes cada vez que se ejecuta.

⚠️ En otras palabras: cada ejecución cambia el estado del sistema de forma distinta, incluso si el input es el mismo.

## Cuál es su estructura o ejemplos?
Las operaciones no-idempotentes suelen estar asociadas a:

POST en HTTP

Creación de recursos

Transacciones financieras

Envío de correos/SMS

Inserciones en bases de datos

Ejemplo:
```bash
POST /ordenes
Body:
{
  "producto": "Laptop",
  "cantidad": 1
}
```
✅ La primera vez crea una orden.

❌ Si reenvías esta misma solicitud sin protección, creas otra orden igual.

## ¿Qué problema representa?
En caso de fallos de red o timeouts, el cliente puede reenviar la petición.

Si la operación es no-idempotente, el servidor puede duplicar efectos no deseados:

compras dobles

cobros múltiples

generación de contenido duplicado

## Casos reales donde NO quieres ser idempotente
POST /pagos → Debe realizar un cobro único

POST /envios/sms → Cada petición debe enviar un mensaje

POST /notificaciones/push → Envía una notificación única por evento

POST /tickets/soporte → Cada uno es una nueva solicitud

Pero incluso aquí quieres protegerte contra reintentos, por eso combinas con mecanismos como:

UUIDs únicos por operación

Claves de idempotencia

Validaciones de unicidad

## ¿Cómo se prueba la no-idempotencia?
Simula reenvíos de la misma petición y verifica que:

El sistema no debe ejecutar la acción de nuevo si ya lo hizo.

El sistema debe responder con el mismo resultado o con una advertencia (ej. 409 Conflict, 422 Unprocessable Entity, etc.).