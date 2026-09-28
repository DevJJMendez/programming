## Variables Dinámicas
Las variables de entorno dinámicas en Postman son una característica que permite generar o modificar valores automáticamente durante la ejecución de las solicitudes. Esto resulta extremadamente útil para crear datos únicos, gestionar tokens de autenticación, y realizar pruebas más complejas sin necesidad de modificar manualmente los valores de las variables. Estas variables se pueden generar mediante scripts de pre-solicitud (pre-request) o post-solicitud (post-request).

### ¿Qué son las Variables Dinámicas?
Las variables dinámicas son valores que se generan automáticamente en Postman mediante scripts o funciones internas del entorno. Pueden ser números, textos aleatorios, fechas, UUIDs (Universally Unique Identifiers), y más. También pueden actualizarse en función de los resultados de las respuestas de la API.

### ¿Por qué son Útiles?
1. **Automatización**: Te permiten evitar la necesidad de ingresar valores manualmente, generando datos únicos en cada ejecución.

2. **Pruebas Realistas**: Crean datos dinámicos, como nombres de usuario, correos electrónicos, o tokens de autenticación, lo que simula un entorno de prueba realista.

3. **Flexibilidad**: Pueden actualizarse automáticamente en función de las respuestas de la API o de valores obtenidos durante la ejecución de pruebas.

### Variables Dinámicas Integradas en Postman
Postman proporciona algunas variables dinámicas listas para usar, sin necesidad de scripts. Estas se pueden insertar directamente en las solicitudes utilizando la sintaxis `{{$variable}}`. Algunas de las más útiles incluyen:

* `{{$guid}}`: Genera un UUID aleatorio.

* `{{$timestamp}}`: Genera una marca de tiempo UNIX (segundos desde el 1 de enero de 1970).

* `{{$randomInt}}`: Genera un número entero aleatorio.

* `{{$randomFirstName}}`: Genera un nombre de pila aleatorio.

* `{{$randomLastName}}`: Genera un apellido aleatorio.

* `{{$randomEmail}}`: Genera un correo electrónico aleatorio.

* `{{$randomPhoneNumber}}`: Genera un número de teléfono aleatorio.

Estas variables son especialmente útiles cuando estás creando pruebas que requieren valores únicos, como nombres de usuario o correos electrónicos, y no quieres repetirlos en cada solicitud.

### Uso de Variables Dinámicas en Scripts
Postman también permite usar JavaScript para definir y modificar variables de entorno dinámicamente. Estas variables pueden generarse o actualizarse utilizando scripts de pre-request o post-request.

Ejemplo de Script de Pre-request para Generar Variables Dinámicas:
Supongamos que deseas generar un token de autenticación único y almacenar la marca de tiempo para utilizarlo en las pruebas posteriores. Puedes usar el siguiente script en el campo Pre-request Script:

```js
// Generar un token de autenticación simulado (esto es solo un ejemplo, normalmente obtendrás el token de la API)
var token = 'Bearer ' + Math.random().toString(36).substring(7);

// Guardar el token como una variable de entorno
pm.environment.set("auth_token", token);

// Guardar la marca de tiempo actual
pm.environment.set("current_timestamp", new Date().toISOString());
```
Con este script, puedes generar un token dinámico para cada solicitud y almacenarlo como una variable de entorno. Luego, puedes usar {{auth_token}} y {{current_timestamp}} en tus solicitudes para utilizarlas de manera dinámica.

### Ejemplo de Script de Post-request:
Puedes utilizar un script de post-request para actualizar variables dinámicamente en función de la respuesta de la API. Esto es útil para almacenar datos como un token de autenticación o un ID generado por el servidor.

```js
// Obtener el token de la respuesta de la API
var responseJson = pm.response.json();
pm.environment.set("auth_token", responseJson.token);

// Obtener el ID del usuario recién creado y almacenarlo en una variable
pm.environment.set("user_id", responseJson.id);
```
Este script se ejecuta después de que se reciba la respuesta de la API. Extrae el valor del token y el ID del usuario de la respuesta JSON y los almacena como variables de entorno para usarlos en las siguientes solicitudes.

### Variables Dinámicas en Ambientes
Además de crear variables dinámicas en scripts de pre o post-request, también puedes usarlas con diferentes ambientes (environments) en Postman. Por ejemplo, puedes definir un valor dinámico que cambia según el ambiente actual (desarrollo, prueba, producción). Esto se hace utilizando el sistema de ambientes de Postman:

```js
// Cambia dinámicamente la URL base según el entorno
var baseUrl;
if (pm.environment.name === "Development") {
    baseUrl = "https://dev.api.example.com";
} else if (pm.environment.name === "Production") {
    baseUrl = "https://api.example.com";
}
pm.environment.set("base_url", baseUrl);
```
Esto permite que tus pruebas se adapten automáticamente al entorno en el que te encuentres.