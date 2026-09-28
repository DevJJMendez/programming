# `async` and `await`
async y await son palabras clave en JavaScript que facilitan el trabajo con promesas, proporcionando una sintaxis más legible y estructurada para manejar operaciones asíncronas. Introducidas en ES2017, estas palabras clave permiten escribir código que parece síncrono pero que en realidad realiza operaciones asíncronas, haciendo el flujo de ejecución más intuitivo y reduciendo el uso de cadenas complejas de .then() y .catch().

## ¿Qué son async y await?
* `async`: Una palabra clave que se coloca antes de una función para declarar que esa función es asíncrona, lo cual permite utilizar await en su interior y hace que la función devuelva una promesa de forma implícita.

* `await`: Una palabra clave que se usa dentro de una función async para pausar la ejecución de esa función hasta que una promesa se resuelva o se rechace. Al usar await, el valor de la promesa se obtiene directamente.

## ¿Para qué sirven async y await?
async y await sirven para simplificar el manejo de código asíncrono en JavaScript, especialmente en funciones que dependen de resultados de operaciones como llamadas a APIs, lectura de archivos, o cualquier otra tarea que toma tiempo para completarse. Su objetivo principal es hacer el código más legible, eliminando la necesidad de múltiples .then() y permitiendo que el flujo de trabajo se exprese de forma lineal.

## ¿Qué resuelven async y await?
Estos dos keywords resuelven problemas comunes asociados con el anidamiento excesivo de promesas (conocido como “callback hell” o “promise chaining”), donde el código se vuelve difícil de leer y mantener. Además, simplifican el manejo de errores en funciones asíncronas, ya que se pueden capturar con try...catch de manera natural.

## ¿Cómo resuelven estos problemas?
async y await permiten estructurar el código asíncrono de manera que parezca secuencial, sin perder la naturaleza no bloqueante de las promesas. En lugar de múltiples .then() y .catch(), el flujo de trabajo se maneja en una estructura de try...catch, y las promesas se manejan de manera directa usando await, lo cual mejora tanto la legibilidad como la mantenibilidad del código.

## Todo lo que necesitas saber sobre async y await
* Sintaxis y Uso Básico
```js
// Declaración de una función asíncrona con `async`
async function obtenerDatos() {
    try {
        const respuesta = await fetch('https://api.misitio.com/data');
        const datos = await respuesta.json();
        console.log(datos); // Se accede al resultado como un valor
    } catch (error) {
        console.error('Error al obtener los datos:', error);
    }
}

obtenerDatos();
```
En este ejemplo:

* **`async`** indica que obtenerDatos es una función asíncrona.

* **`await`** pausa la ejecución dentro de la función async hasta que fetch y response.json() se resuelvan.

* Cómo async convierte el resultado en una promesa
Al declarar una función con async, cualquier valor que esta devuelva se convierte automáticamente en una promesa. Esto es útil porque podemos retornar valores normales sin preocuparnos de crear manualmente una promesa.

```js
async function ejemplo() {
    return "Resultado"; // Devuelve una promesa automáticamente
}

ejemplo().then(console.log); // Salida: "Resultado"
```

* Uso de await con múltiples operaciones asíncronas
Cuando una función depende de varios resultados asíncronos, await puede usarse para hacer cada operación secuencialmente.
```js
async function cargarDatos() {
    const datos1 = await obtenerDatosDesdeAPI1();
    const datos2 = await obtenerDatosDesdeAPI2(datos1);
    console.log('Datos combinados:', { datos1, datos2 });
}

cargarDatos();
```
Aquí, await permite que cada operación espere el resultado de la anterior antes de continuar, garantizando que datos2 depende de datos1.

* Manejo de errores con async y await
async y await permiten un manejo de errores más intuitivo, utilizando try...catch para capturar excepciones en una sola estructura:
```js
async function obtenerDatosConManejoDeErrores() {
    try {
        const datos = await fetch('https://api.misitio.com/data');
        const jsonData = await datos.json();
        console.log(jsonData);
    } catch (error) {
        console.error('Error capturado:', error);
    }
}

obtenerDatosConManejoDeErrores();
```
En este ejemplo, cualquier error que ocurra en fetch o en json() será capturado en el bloque catch, lo cual hace el flujo de error más claro y fácil de mantener.

* await y ejecución paralela de promesas
Si varias operaciones no dependen entre sí y quieres ejecutarlas en paralelo, puedes evitar el await en cada línea y en su lugar usar Promise.all para optimizar la velocidad.
```js
async function cargarDatosParalelo() {
    const [datos1, datos2] = await Promise.all([
        obtenerDatosDesdeAPI1(),
        obtenerDatosDesdeAPI2()
    ]);
    console.log('Resultados paralelos:', { datos1, datos2 });
}

cargarDatosParalelo();
```
Aquí, ambas funciones (obtenerDatosDesdeAPI1 y obtenerDatosDesdeAPI2) se ejecutan en paralelo, y el await espera hasta que ambas se completen. Esto puede reducir considerablemente el tiempo de espera total.