# Response
¿Qué es una HTTP Response?
Es el mensaje que el servidor envía de vuelta al cliente como resultado de una solicitud (request). Este mensaje contiene:

Un código de estado que indica el resultado de la operación

Headers que describen metadatos de la respuesta

Un cuerpo opcional que incluye los datos solicitados o mensajes de error

**Es como cuando tú (cliente) haces una pregunta al backend (servidor), y él te responde con un "mensaje estructurado".**

## ¿Cuál es su estructura?
Una respuesta HTTP tiene tres partes principales:

1. Status Line
La primera línea indica:
```bash
HTTP/1.1 200 OK
```
HTTP/1.1 → Versión del protocolo

200 → Código de estado

OK → Mensaje textual del estado

2. Headers
Metadatos que describen la respuesta:
```bash
Content-Type: application/json
Content-Length: 123
Cache-Control: no-cache
```

3. Body (Opcional)
Contiene los datos de la respuesta:
```bash
{
  "id": 101,
  "nombre": "Producto A",
  "precio": 49.99
}
```
El cuerpo es opcional. Algunos códigos como 204 No Content o 304 Not Modified no lo tienen.

## Ejemplo completo de una respuesta
```bash
{
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 85
Cache-Control: no-cache

{
  "status": "ok",
  "mensaje": "Usuario autenticado",
  "usuario": {
    "id": 123,
    "nombre": "Carlos"
  }
}
```