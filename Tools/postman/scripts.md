En Postman, los Pre-request y Post-request son scripts que se ejecutan en momentos específicos del ciclo de una solicitud HTTP. Estos scripts son escritos en JavaScript y permiten automatizar tareas, gestionar datos y controlar el flujo de las pruebas.

## Pre-request
Un Pre-request Script es un bloque de código que se ejecuta antes de que se envíe una solicitud. Este tipo de script es útil para preparar datos, establecer variables dinámicas, generar tokens de autenticación, o manipular cualquier otro valor que la solicitud requiera.

**Funciones Comunes del Pre-request Script:**
* **Generar Tokens**: Se puede usar para generar o recuperar tokens de autenticación (por ejemplo, OAuth) antes de enviar la solicitud.

* **Establecer Variables Dinámicas**: Puede configurar variables que serán utilizadas dentro de la solicitud.

* **Gestionar Dependencias**: Si una solicitud depende de los resultados de otras pruebas o datos previos, se pueden preparar aquí.

Ejemplo de un Pre-request Script:
```js
// Generar un token de autenticación dinámico
var token = 'Bearer ' + Math.random().toString(36).substring(7);
pm.environment.set("auth_token", token);

// Establecer la fecha actual en formato ISO
pm.environment.set("current_date", new Date().toISOString());
```
En este ejemplo:

* Se genera un token aleatorio y se guarda en la variable de entorno `auth_token`.

* Se guarda la fecha actual en la variable `current_date`, para que pueda usarse en la solicitud.

Este script se ejecuta antes de enviar la solicitud, lo que asegura que los datos necesarios estén listos y actualizados.

## Post-request Script
Un Post-request Script es un bloque de código que se ejecuta después de que se recibe una respuesta de la API. Este script se usa típicamente para validar la respuesta, extraer datos, o modificar variables en función del resultado.

**Funciones Comunes del Post-request Script:**
* **Validación de Respuesta**: Comprobar si los datos de la respuesta son correctos, validar el código de estado HTTP, o verificar el contenido de la respuesta.

* **Guardar Datos de la Respuesta**: Extraer valores de la respuesta y guardarlos en variables para su uso en futuras solicitudes (como IDs de usuarios creados, tokens de autenticación, etc.).

* **Automatización de Pruebas**: Ejecutar pruebas automáticas o lógicas condicionales basadas en el contenido de la respuesta.

**Ejemplo de un Post-request Script**
```js
// Extraer el ID de usuario de la respuesta y guardarlo como variable de entorno
var responseJson = pm.response.json();
pm.environment.set("user_id", responseJson.id);

// Verificar que el código de estado sea 200
pm.test("El código de estado es 200", function () {
    pm.response.to.have.status(200);
});
```
En este ejemplo:

* Se extrae el id del usuario de la respuesta y se guarda en la variable user_id.

* Se valida que el código de estado de la respuesta sea 200, lo que asegura que la solicitud fue exitosa.

## ¿Cuándo usar Pre-request y Post-request Scripts?
1. **Pre-request Scripts**: Úsalos cuando necesites preparar datos, generar tokens, o configurar variables antes de enviar la solicitud. Son útiles cuando tu solicitud necesita información dinámica que debe generarse en el momento.

2. **Post-request Scripts**: Úsalos para validar la respuesta de la solicitud, extraer datos de la respuesta para su uso posterior, o para automatizar verificaciones de pruebas después de que se ha recibido la respuesta.

### Flujo de Trabajo Común en una Prueba de API:
* **Pre-request Script**: Prepara datos como tokens o parámetros dinámicos.

* **Solicitud HTTP**: Envía la solicitud HTTP utilizando los datos preparados.

* **Post-request Script**: Valida los resultados, extrae datos y prepara las siguientes solicitudes en función de la respuesta.