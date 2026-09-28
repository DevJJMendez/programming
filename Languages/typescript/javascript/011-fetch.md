# `fetch`
fetch es una API nativa de JavaScript que permite realizar solicitudes HTTP para obtener, enviar o modificar datos de un servidor. Es una herramienta clave para el desarrollo de aplicaciones web que requieren comunicación con servidores externos, como cargar información de una API o enviar datos de usuario a un backend.

## ¿Qué es fetch?
fetch es una función global en JavaScript que devuelve una promesa para realizar operaciones HTTP de manera asíncrona. Permite realizar solicitudes utilizando varios métodos HTTP, como GET, POST, PUT, DELETE, entre otros, y es compatible con la mayoría de los navegadores modernos.

## Sintaxis básica de fetch

```js
fetch(url, options)
```

* `url`: La URL a la que deseas hacer la solicitud. Esta puede ser una dirección absoluta o relativa.

* `options` (opcional): Un objeto que contiene parámetros adicionales para la solicitud, como el método HTTP, encabezados, cuerpo, etc.

## ¿Para qué sirve fetch?
fetch se utiliza para:

Obtener datos de una API o servidor.
Enviar datos al servidor desde una aplicación web.
Actualizar o eliminar datos en el servidor.

Con fetch, es posible integrar datos externos en una aplicación y comunicar el frontend con el backend.

## ¿Qué resuelve fetch?
fetch resuelve la necesidad de realizar solicitudes HTTP de manera fácil, segura y flexible en el navegador, eliminando la complejidad de métodos anteriores, como XMLHttpRequest. Además, proporciona una forma más limpia y fácil de manejar respuestas asíncronas y errores, haciendo uso de promesas.

## ¿Cómo lo resuelve?
fetch utiliza promesas, lo cual facilita el manejo de operaciones asincrónicas, como solicitar datos y esperar su respuesta. A través de fetch, puedes escribir código más limpio y entendible en comparación con XMLHttpRequest, y permite el uso de async y await para un código más legible.

## Todo lo que debes saber sobre fetch
* Uso básico de fetch
El ejemplo más simple de fetch es realizar una solicitud GET para obtener datos:

```js
fetch("https://jsonplaceholder.typicode.com/todos/1")
    .then(response => {
        if (!response.ok) throw new Error("Error en la solicitud");
        return response.json();
    })
    .then(data => console.log(data))
    .catch(error => console.error("Error:", error));
```
Explicación:
* fetch("URL"): Realiza una solicitud a la URL especificada.

* .then(response => response.json()): Convierte la respuesta en formato JSON para poder trabajar con los datos.

* .catch(error => ...): Captura errores en caso de que la solicitud falle.

* Ejemplo usando async y await
Usando fetch con async y await, el código se ve más limpio y secuencial:
```js
async function obtenerDatos() {
    try {
        const respuesta = await fetch("https://jsonplaceholder.typicode.com/todos/1");
        if (!respuesta.ok) throw new Error("Error en la solicitud");
        const datos = await respuesta.json();
        console.log(datos);
    } catch (error) {
        console.error("Error al obtener datos:", error);
    }
}

obtenerDatos();
```
En este ejemplo:
* await fetch(...) realiza la solicitud y espera hasta que obtenga la respuesta.

* await respuesta.json() convierte la respuesta en JSON.

* Si ocurre un error, es capturado en el bloque catch.

* Realizar solicitudes POST, PUT y DELETE
fetch permite especificar el método HTTP mediante un objeto de configuración en el segundo parámetro.
```js
async function enviarDatos() {
    try {
        const respuesta = await fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                title: "Nuevo Post",
                body: "Este es el contenido del post",
                userId: 1
            })
        });

        if (!respuesta.ok) throw new Error("Error en la solicitud");

        const datos = await respuesta.json();
        console.log("Datos enviados:", datos);
    } catch (error) {
        console.error("Error al enviar datos:", error);
    }
}

enviarDatos();
```
Aquí:
* method: Define el método HTTP, en este caso POST.

* headers: Indica los encabezados de la solicitud, como Content-Type.

* body: Contiene los datos en formato JSON.

* Manejo de errores en fetch
Si la solicitud falla, fetch solo genera un error de red; no lanza un error si recibe un código de estado HTTP 404 o 500. Por lo tanto, es necesario verificar la propiedad ok de la respuesta.
```js
fetch("https://jsonplaceholder.typicode.com/posts/9999")
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => console.log(data))
    .catch(error => console.error("Error:", error));
```

* fetch y CORS
Si se intenta acceder a recursos en un dominio diferente al del sitio actual, el navegador puede bloquear la solicitud debido a la política de CORS (Cross-Origin Resource Sharing). Para resolver esto, el servidor de destino debe permitir solicitudes de origen cruzado configurando los encabezados CORS adecuados.

## Opciones de configuración
El segundo parámetro de fetch es un objeto de configuración que permite personalizar la solicitud. A continuación, se detallan algunas de las propiedades más comunes que puedes incluir:

method: Especifica el método HTTP a utilizar (GET, POST, PUT, DELETE, etc.).
headers: Un objeto que contiene los encabezados de la solicitud.
body: Los datos a enviar con la solicitud, generalmente en formato JSON.
mode: Controla la política de CORS (cors, no-cors, same-origin).
credentials: Indica si se deben incluir credenciales en la solicitud (include, same-origin, omit).
cache: Define la política de caché (default, no-store, reload, force-cache, etc.).