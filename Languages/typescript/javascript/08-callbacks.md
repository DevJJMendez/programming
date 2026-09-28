# Callbacks
Un callback es una función que se pasa como argumento a otra función y se ejecuta después de que se completa una operación específica. Los callbacks son especialmente útiles para manejar tareas que tardan un tiempo indeterminado en completarse, como operaciones de entrada/salida, solicitudes de red, o temporizadores.

**Ejemplo**
```js
function greeting(name) {
    console.log("Hola, " + name);
}

function processUserInput(callback) {
    var name = prompt("Por favor ingresa tu nombre.");
    callback(name);
}

processUserInput(greeting);
```
En este ejemplo, `greeting` es una función **`callback`** que se pasa a `processUserInput`. Cuando el usuario ingresa su nombre, `processUserInput` llama a `greeting` y le pasa el nombre.

## ¿Para qué sirve?
1. **Manejo de Asincronía**: Los callbacks son fundamentales para manejar la asincronía en JavaScript. Permiten que el código continúe ejecutándose mientras espera que se completen operaciones como la carga de datos desde un servidor.

2. **Separación de Lógica**: Ayudan a mantener el código modular y organizado, ya que permiten separar la lógica que se ejecuta en respuesta a una acción específica.

3. **Personalización**: Puedes pasar diferentes callbacks para personalizar el comportamiento de funciones que tienen lógica común.

## ¿Qué resuelve?
* **Operaciones Asíncronas**: Los callbacks permiten ejecutar código después de que se completan operaciones asíncronas sin bloquear el hilo principal de ejecución.

* **Flujo de Control**: Ayudan a manejar el flujo de control en situaciones donde se necesita realizar una acción después de que se complete otra acción.

* **Evitar Bloqueos**: Con los callbacks, puedes evitar que tu aplicación se congele mientras espera que se completen tareas largas.

## ¿Cómo lo resuelve?
Los callbacks resuelven el manejo de operaciones asíncronas al permitir que una función se ejecute cuando otra operación ha finalizado. A continuación, se presentan algunos escenarios típicos donde se utilizan callbacks.

1. **Operaciones de Entrada/Salida**: En aplicaciones web, cuando haces una solicitud a un servidor para obtener datos, puedes usar callbacks para manejar la respuesta:

```js
function fetchData(url, callback) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            callback(data); // Llama al callback con los datos recibidos
        })
        .catch(error => console.error('Error:', error));
}

fetchData('https://api.example.com/data', function(data) {
    console.log(data); // Procesa los datos
});
```

2. **Temporizadores**: Los callbacks también se utilizan con funciones de temporizador:
```js
console.log("Inicio");

setTimeout(function() {
    console.log("Esto se ejecuta después de 2 segundos");
}, 2000);

console.log("Fin");
```
En este ejemplo, la función dentro de setTimeout es un callback que se ejecuta después de 2 segundos.

## Consideraciones sobre Callbacks
1. **Callback Hell**: Cuando se anidan muchos callbacks, el código puede volverse difícil de leer y mantener, lo que se conoce como "callback hell". Este problema ha llevado al uso de **`Promises`** y **`async/await`** como alternativas más legibles.
```js
doSomething(function(result) {
    doSomethingElse(result, function(newResult) {
        doThirdThing(newResult, function(finalResult) {
            console.log('Resultado final: ' + finalResult);
        });
    });
});
```

2. Errores: Asegúrate de manejar errores en callbacks. Puedes pasar un primer argumento a los callbacks para representar errores, siguiendo el patrón de callback de estilo Node.js.
```js
function fetchData(url, callback) {
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => callback(null, data))
        .catch(error => callback(error, null));
}

fetchData('https://api.example.com/data', function(error, data) {
    if (error) {
        console.error('Error:', error);
    } else {
        console.log('Datos recibidos:', data);
    }
});
```