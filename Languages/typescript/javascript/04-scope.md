# Scope
El scope o "ámbito" en JavaScript determina dónde una variable o función es accesible dentro de un programa. El scope es clave para entender cómo funciona el código, controlar la visibilidad de variables y evitar errores de uso involuntario de datos.

El scope se refiere al contexto en el cual las variables y funciones son visibles y accesibles. En JavaScript, cada variable o función tiene un scope asociado, lo que establece en qué áreas del programa pueden usarse.

## ¿Para qué sirve?
El scope permite:

* **Organizar y encapsular el código**: Mantener variables limitadas a ciertos bloques de código o funciones ayuda a organizar el programa y a evitar interferencias no deseadas.

* **Controlar la visibilidad y vida de las variables**: Al delimitar la accesibilidad de las variables, el scope protege datos y minimiza el riesgo de colisión de nombres.

* **Optimizar el uso de memoria**: Al liberar variables fuera de uso en ciertos scopes (especialmente en bloques y funciones) se mejora el manejo de memoria.

## ¿Qué resuelve?
El scope ayuda a:

* **Evitar colisiones de nombres**: Si varias variables tienen el mismo nombre, el scope define cuál variable se usará en cada contexto, evitando errores y confusiones.

* **Asegurar la encapsulación de datos**: Las variables solo son visibles en el scope en que se declaran, lo que protege los datos y garantiza que solo los fragmentos de código adecuados accedan a ellos.

* **Gestionar el ciclo de vida de las variables**: Las variables declaradas dentro de un scope desaparecen al salir de dicho scope (como en funciones y bloques), lo que mejora la eficiencia de la memoria.

## ¿Cómo lo resuelve?
JavaScript ofrece varios tipos de scope:

1. **Scope Global**: Es el scope más amplio. Las variables declaradas fuera de cualquier función o bloque son accesibles en todo el código.

```js
let globalVariable = "Estoy en el scope global";

function muestraGlobal() {
    console.log(globalVariable); // "Estoy en el scope global"
}

muestraGlobal();
```

2. **Scope de Función**: Las variables declaradas dentro de una función solo existen dentro de esa función. Se definen mediante `var`, `let`, o `const` y no se puede acceder a ellas desde fuera.

```js
function miFuncion() {
    let funcionVariable = "Estoy en el scope de función";
    console.log(funcionVariable); // "Estoy en el scope de función"
}

miFuncion();
console.log(funcionVariable); // Error: funcionVariable is not defined
```

3. **Scope de Bloque**: Introducido en ES6, el scope de bloque se refiere a variables declaradas con `let` o `const` dentro de bloques de código (dentro de `{}`), como en `if`, `for`, o funciones anidadas. var no tiene alcance de bloque.

```js
if (true) {
    let bloqueVariable = "Estoy en el scope de bloque";
    console.log(bloqueVariable); // "Estoy en el scope de bloque"
}

console.log(bloqueVariable); // Error: bloqueVariable is not defined
```

4. **Scope Léxico**: JavaScript utiliza un scope léxico o estático, lo que significa que el alcance de una variable se determina en tiempo de escritura (y no en tiempo de ejecución). Esto implica que las funciones tienen acceso a las variables del contexto en el que fueron creadas, incluso si se ejecutan en otro lugar.

```js
function padre() {
    let padreVariable = "Variable en el scope padre";

    function hijo() {
        console.log(padreVariable); // "Variable en el scope padre"
    }

    hijo();
}

padre();
```

## Scope y el uso de var, let y const
* **`var`**: Tiene un alcance de función o global si se declara fuera de una función. No respeta el scope de bloque, por lo que puede generar errores.

```js
if (true) {
    var numero = 10;
}

console.log(numero); // 10, aunque esté fuera del bloque if
```

* **`let` y `const`**: Ambos tienen alcance de bloque y solo son accesibles dentro del bloque **`{}`** donde se declaran. Esta característica ayuda a evitar errores de reasignación involuntaria y mejora la claridad del código.

```js
if (true) {
    let contador = 1;
    const PI = 3.14;
}

console.log(contador); // Error: contador is not defined
console.log(PI); // Error: PI is not defined
```

## Hoisting y Scope
En JavaScript, las declaraciones de variables y funciones se "elevan" al inicio de su scope. Este proceso se llama hoisting. Sin embargo, solo la declaración es elevada, no la inicialización.

* **Hoisting con `var`**: Las variables declaradas con var se elevan y se inicializan con undefined.
```js
console.log(miVar); // undefined
var miVar = "Hola";
```

* **Hoisting con `let` y `const`**: Aunque también son elevadas, no están inicializadas hasta su declaración. Intentar acceder a ellas antes de la declaración da un error de referencia (zona temporal muerta).
```js
console.log(miLet); // Error: Cannot access 'miLet' before initialization
let miLet = "Hola";
```