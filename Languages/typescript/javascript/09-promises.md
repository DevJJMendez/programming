# Promises
Las Promises o Promesas en JavaScript son un mecanismo para manejar operaciones asíncronas de manera más controlada y legible, resolviendo varios problemas de los callbacks tradicionales, como el "**callback hell**". 

## ¿Qué es una Promise?
Una Promise es un objeto que representa un valor que puede estar disponible ahora, en el futuro o nunca. Su propósito es gestionar el resultado eventual (éxito o error) de una operación asíncrona de una manera estructurada y limpia.

Una Promise tiene tres estados:

1. **Pendiente (`pending`)**: El estado inicial, en el que la operación asíncrona aún no ha finalizado.

2. **Cumplida (`fulfilled`)**: La operación asíncrona se ha completado exitosamente y se ha obtenido un valor.

3. **Rechazada (`rejected`)**: La operación asíncrona ha fallado, produciendo un error.

## ¿Para qué sirve?
Las promesas permiten:

1. Manejar operaciones asíncronas como solicitudes **HTTP**, temporizadores y operaciones de E/S sin bloquear el hilo principal.

2. Evitar el **callback hell** proporcionando una cadena ordenada y limpia de **`then`**, **`catch`** y **`finally`**, en lugar de anidar múltiples callbacks.

## ¿Qué resuelve?
Las promesas resuelven varios problemas comunes en el manejo de operaciones asíncronas:

1. **Callback Hell**: Evitan el anidamiento excesivo de `callbacks` al permitir que se encadenen, lo que hace que el código sea más legible.

2. **Manejo Centralizado de Errores**: Con catch, puedes manejar errores en un solo lugar en lugar de en cada callback anidado.

3. **Previsibilidad**: Una promesa solo puede cumplir o rechazar una vez, evitando comportamientos impredecibles.

## ¿Cómo lo resuelve?
La estructura de las promesas permite encadenar tareas asíncronas de forma ordenada y manejar los errores en un solo punto. Al dividir el flujo de éxito y el flujo de errores en then y catch, el código se mantiene limpio y fácil de seguir.

## Sintaxis Básica
Crear una promesa:
```js
const promise = new Promise((resolve, reject) => {
    // Operación asíncrona
    const success = true; // Cambia a false para simular un error

    if (success) {
        resolve("La operación fue exitosa");
    } else {
        reject("Hubo un error en la operación");
    }
});
```
Aquí se define la promesa, que recibe una función con dos parámetros: `resolve` y `reject`. Se llama a resolve cuando la operación asíncrona es exitosa y a reject cuando falla.

## Uso de una Promise
```js
promise
    .then(result => {
        console.log(result); // Muestra "La operación fue exitosa" si la promesa se cumple
    })
    .catch(error => {
        console.error(error); // Muestra "Hubo un error en la operación" si la promesa falla
    })
    .finally(() => {
        console.log("Operación completada"); // Se ejecuta tanto si la promesa se cumple o falla
    });
```
* **`then()`**: Se ejecuta cuando la promesa se cumple exitosamente.

* **`catch()`**: Se ejecuta cuando la promesa es rechazada.

* **`finally()`**: Se ejecuta independientemente del resultado, al finalizar la operación.

## Ejemplo Práctico
Supongamos que quieres obtener datos de una API de usuarios:
```js
function fetchUserData(userId) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const success = true; // Cambia a false para simular un error
            if (success) {
                resolve({ id: userId, name: "Juan" });
            } else {
                reject("Error al obtener los datos del usuario");
            }
        }, 1000); // Simula un retardo de 1 segundo
    });
}

fetchUserData(1)
    .then(user => {
        console.log("Usuario obtenido:", user);
    })
    .catch(error => {
        console.error(error);
    })
    .finally(() => {
        console.log("Operación de fetchUserData completada");
    });
```

## Encadenamiento de Promesas
Uno de los grandes beneficios de las promesas es el encadenamiento, que permite ejecutar una secuencia de operaciones asíncronas una después de la otra:
```js
fetchUserData(1)
    .then(user => {
        console.log("Usuario obtenido:", user);
        return fetchUserPosts(user.id); // Supongamos que esta función también devuelve una promesa
    })
    .then(posts => {
        console.log("Posts del usuario:", posts);
    })
    .catch(error => {
        console.error("Error:", error);
    })
    .finally(() => {
        console.log("Proceso completado");
    });
```
Aquí, fetchUserPosts solo se ejecuta si fetchUserData se resuelve exitosamente. Si ocurre algún error en cualquier parte del encadenamiento, catch manejará el error.

## Métodos Principales de Promesas
* **`Promise.all(iterable)`**: Se utiliza para ejecutar varias promesas en paralelo y esperar a que todas se completen. Si alguna de las promesas falla, Promise.all se rechaza inmediatamente.
```js
const promise1 = Promise.resolve(3);
const promise2 = new Promise((resolve) => setTimeout(resolve, 1000, 'foo'));

Promise.all([promise1, promise2])
    .then(results => console.log(results)) // [3, "foo"]
    .catch(error => console.error(error));
```

* **`Promise.race(iterable)`**: Espera a que la primera promesa en el iterable se complete o sea rechazada.
```js
const promise1 = new Promise((resolve) => setTimeout(resolve, 500, "primer"));
const promise2 = new Promise((resolve) => setTimeout(resolve, 1000, "segundo"));

Promise.race([promise1, promise2]).then(result => console.log(result)); // "primer"
```
* **`Promise.allSettled(iterable)`**: Espera a que todas las promesas se completen, sin importar si fueron cumplidas o rechazadas.
```js
const promise1 = Promise.resolve(42);
const promise2 = Promise.reject("Error en la segunda promesa");

Promise.allSettled([promise1, promise2]).then(results => console.log(results));
```