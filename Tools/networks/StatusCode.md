# Status Code
Los Status Code son códigos numéricos de 3 dígitos que forman parte de la respuesta HTTP, enviados por el servidor al cliente para indicar el resultado de una solicitud.

## ¿Cuál es su estructura?
Todos tienen 3 dígitos:

El primer dígito indica la categoría del código

Los dos siguientes dan más detalle del estado

Ejemplo:
```bash
200 → 2 (Éxito) + 00 (Operación OK)
404 → 4 (Error cliente) + 04 (No encontrado)
```

## Clasificación
### 1xx – Informativos
El servidor recibió la solicitud y continúa procesándola

100 ->	Continue
101 ->	Switching Protocols
102 ->	Processing (WebDAV)

### 2xx – Éxito
La solicitud fue recibida, entendida y procesada correctamente

200 ->	OK
201 ->	Created
202 ->	Accepted
204 ->	No Content

### 3xx – Redirección
El recurso se movió o requiere acción adicional

301	-> Moved Permanently
302	-> Found (Temporal)
304	-> Not Modified (cache)

### 4xx – Errores del cliente
El cliente hizo algo mal (datos inválidos, no autorizado, etc.)

400 ->	Bad Request
401 ->	Unauthorized
403 ->	Forbidden
404 ->	Not Found
405 ->	Method Not Allowed
409 ->	Conflict
422 ->	Unprocessable Entity (datos mal estructurados)

### 5xx – Errores del servidor
El servidor falló al procesar una solicitud válida

500 ->	Internal Server Error
501 ->	Not Implemented
502 ->	Bad Gateway
503 ->	Service Unavailable
504 ->	Gateway Timeout

## Casos reales de uso (APIs)
Acción - 	Status recomendado
* Crear recurso (POST) -> 201 Created
* Solicitud OK (GET/PUT/DELETE)	 -> 200 OK
* Eliminación sin retorno -> 	204 No Content
* Validación fallida -> 	400 Bad Request
* Token inválido o vencido -> 401 Unauthorized
* Usuario sin permisos -> 403 Forbidden
* Ruta inexistente	-> 404 Not Found
* Error al guardar en la BD	 -> 500 Internal Server Error
* Microservicio no disponible	 -> 503 Service Unavailable

## Buenas prácticas como ingeniero
Buenas prácticas	Por qué
Usa códigos precisos	No pongas todo como 200 OK
Acompaña errores con mensaje claro en el body	Mejora la DX (developer experience)
En producción no devuelvas errores sensibles	Protege información interna
Usa 204 cuando no hay body	Evita tráfico innecesario
Usa herramientas como Postman, curl, logs HTTP	Para testeo y debug