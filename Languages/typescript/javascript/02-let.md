# `let`
Es una palabra clave de JavaScript para declarar variables que permite crear una variable que se puede reasignar. A diferencia de const (que también fue introducida en ES6), let permite que el valor de la variable cambie a lo largo del código.

## ¿Para qué sirve?
let sirve para almacenar datos que pueden ser cambiantes durante la ejecución del código. Su objetivo es permitir la declaración de variables con alcance de bloque, lo cual es útil para manejar valores que cambian en ciclos, condicionales, o bloques de código específicos.

**Ejemplo**
```js
let nombre = "Juan";
console.log(nombre); // Juan
nombre = "Ana";
console.log(nombre); // Ana
```

## ¿Qué resuelve?
`let` resuelve varios problemas que `var` tenía en el manejo de variables en JavaScript, específicamente:

1. **Alcance de bloque (block scope)**: A diferencia de `var`, que tiene alcance de función, let limita la visibilidad de la variable al bloque donde se declara, como dentro de un ciclo for, if, o cualquier otro bloque de código delimitado por `{ }`. Esto reduce errores y hace que el código sea más predecible.

2. **Hoisting más seguro**: Aunque `let` también es "hoisted" (elevado) en JavaScript, su declaración se encuentra en una "zona temporal muerta" hasta que el código realmente la declara. Esto evita el problema de acceder a la variable antes de su declaración y ayuda a mantener un código más limpio.

## ¿Cómo lo resuelve?
1. **Alcance de bloque (block scope)**: let permite declarar variables en un contexto de bloque, lo que significa que estas variables solo existen dentro del bloque en el que fueron declaradas. Esto es útil para evitar conflictos y errores de alcance, ya que asegura que las variables no afectarán a otros bloques fuera de su contexto.

```js
if (true) {
    let saludo = "Hola";
    console.log(saludo); // "Hola"
}
console.log(saludo); // Error: saludo is not defined
```
En este ejemplo, saludo solo existe dentro del bloque if, y fuera de él la variable ya no está disponible.

2. **Zona temporal muerta y hoisting**: Aunque las variables declaradas con let también son "hoisted" (elevadas), no pueden ser usadas antes de su declaración debido a la zona temporal muerta (temporal dead zone, TDZ). Esto significa que cualquier intento de acceder a la variable antes de su declaración generará un error, lo que hace el código más seguro.

```js
console.log(valor); // Error: Cannot access 'valor' before initialization
let valor = 10;
```
En este ejemplo, JavaScript muestra un error porque valor no está disponible hasta que se declara formalmente. Esto evita errores sutiles y difíciles de rastrear en el código.

3. Evita la contaminación de variables globales: Las variables let solo existen en el contexto donde se declaran. Esto significa que no se agregan automáticamente al objeto global window en el navegador, reduciendo la probabilidad de conflictos entre variables y mejorando la seguridad del código.