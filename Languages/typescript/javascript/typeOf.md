# `typeOf`
En JavaScript, typeof es un operador que se utiliza para determinar el tipo de una variable o expresión. Es una herramienta fundamental que te permite verificar qué tipo de datos estás tratando en tu código, lo cual es especialmente útil en un lenguaje de tipado dinámico como JavaScript.

¿Qué es typeof?
typeof es un operador unario que devuelve una cadena de texto que representa el tipo de dato de su operando. Se puede utilizar con cualquier tipo de valor, ya sea un número, cadena, objeto, función, etc.

¿Para qué sirve typeof?
El operador typeof sirve para:

Verificar el tipo de una variable: Permite identificar qué tipo de dato tiene una variable en tiempo de ejecución.
Debugging: Es útil para depurar problemas en tu código, al verificar que las variables contienen los tipos de datos esperados.
Condicionales: Facilita la ejecución de diferentes bloques de código en función del tipo de dato.
¿Qué resuelve?
typeof resuelve varios problemas comunes relacionados con la gestión de tipos en JavaScript:

Ambigüedad de tipos: En JavaScript, es común que una variable cambie de tipo a lo largo del tiempo. typeof ayuda a identificar el tipo actual de la variable.
Errores en la manipulación de datos: Si intentas realizar operaciones en tipos incorrectos (por ejemplo, sumar un número y una cadena), typeof puede ayudar a detectar el problema antes de que cause un error en el código.
Comprobación de tipos: A menudo, es necesario realizar operaciones específicas según el tipo de dato, y typeof permite implementar esta lógica de manera efectiva.
¿Cómo lo resuelve?
typeof realiza su función evaluando el operando y devolviendo una cadena que representa su tipo. El operador es fácil de usar y se puede aplicar directamente a una variable o valor.

## Sintaxis
La sintaxis del operador typeof es simple:
```js
typeof operand;
```
operand puede ser cualquier valor: una variable, un literal, una expresión, etc.

## Tipos de Resultado de typeof
El operador typeof devuelve una de las siguientes cadenas:

"undefined": Si la variable no ha sido asignada o no existe.
"boolean": Si el valor es un booleano (true o false).
"number": Si el valor es un número (incluyendo NaN y Infinity).
"string": Si el valor es una cadena de texto.
"function": Si el valor es una función.
"object": Si el valor es un objeto (también se devuelve para null, lo cual es una peculiaridad de JavaScript).
"symbol": Para valores de tipo símbolo (introducido en ES6).
"bigint": Para valores de tipo BigInt (también introducido en ES6).

## Ejemplos de Uso de typeof
1. Verificar Tipos Básicos
```js
console.log(typeof 42); // "number"
console.log(typeof "Hello, World!"); // "string"
console.log(typeof true); // "boolean"
console.log(typeof undefined); // "undefined"
console.log(typeof null); // "object" (peculiaridad de JavaScript)
console.log(typeof Symbol("sym")); // "symbol"
console.log(typeof 123n); // "bigint"
```
2. Verificar Funciones
```js
function myFunction() {}
console.log(typeof myFunction); // "function"
```
3. Verificar Objetos
```js
const obj = { name: "Alice" };
console.log(typeof obj); // "object"

const arr = [1, 2, 3];
console.log(typeof arr); // "object" (los arreglos son un tipo de objeto)
```
4. Comprobación Condicional
Puedes usar typeof en condiciones para realizar diferentes acciones según el tipo:
```js
let value = 42;

if (typeof value === "number") {
    console.log("Es un número.");
} else if (typeof value === "string") {
    console.log("Es una cadena.");
} else if (typeof value === "object") {
    console.log("Es un objeto.");
}
```

## Consideraciones y Limitaciones
Null como Objeto: Como se mencionó, typeof null devuelve "object", lo que puede ser confuso. Esto es un legado de la implementación original de JavaScript y no indica que null sea un objeto.

Diferenciación de Arreglos: typeof devuelve "object" para arreglos. Si necesitas verificar específicamente si un valor es un arreglo, debes usar Array.isArray():
```js
console.log(Array.isArray(arr)); // true
```
Objetos Literales vs. Funciones: Ambos devolverán "object" y "function" respectivamente. Para determinar si algo es una función, es mejor usar typeof y hacer una comparación directa.