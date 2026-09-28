# Maps
En JavaScript, un Map es una estructura de datos introducida en ES6 (ECMAScript 2015) que permite almacenar pares de clave-valor y conserva el orden de inserción. A diferencia de los objetos ordinarios en JavaScript, los Maps pueden utilizar cualquier tipo de dato como clave, ya sean objetos, funciones, o valores primitivos.

¿Qué es un Map?
Un Map es una colección de pares de clave-valor en la que cada clave es única. Al igual que en un diccionario o hash en otros lenguajes, el Map permite asignar un valor a una clave, para luego recuperar ese valor mediante la misma clave. En comparación con los objetos tradicionales de JavaScript, el Map es más flexible en cuanto a los tipos de datos que pueden ser claves y ofrece métodos específicos para manipular estos pares.

¿Para qué sirve un Map?
Los Maps son útiles en los siguientes casos:

Almacenar datos indexados por cualquier tipo de clave: Los Maps permiten el uso de valores complejos, como objetos y funciones, como claves, lo cual no es posible en un objeto tradicional.
Gestionar datos con orden de inserción: A diferencia de los objetos, los Maps preservan el orden de los elementos, lo cual es beneficioso cuando el orden de entrada es relevante.
Operaciones rápidas de búsqueda, adición, y eliminación: Los Maps están optimizados para este tipo de operaciones, brindando un rendimiento mejorado en comparación con estructuras alternativas.
¿Qué resuelve el uso de un Map?
El uso de un Map resuelve varias limitaciones de los objetos tradicionales:

Flexibilidad en los tipos de clave: Con un objeto, solo las cadenas y símbolos pueden ser claves, mientras que un Map acepta cualquier tipo de dato.
Mejor rendimiento en operaciones de gran volumen: Los Maps son más eficientes para almacenar y manipular grandes colecciones de datos, especialmente cuando es necesario verificar rápidamente la existencia de una clave o eliminar entradas.
Garantía de orden: Los Maps mantienen el orden de inserción de los pares clave-valor, permitiendo que se iteren en el orden en que fueron agregados.
¿Cómo lo resuelve?
El Map maneja la colección de pares de clave-valor mediante una estructura interna optimizada para almacenar cualquier tipo de clave y facilitar el acceso rápido a los valores. Además, al diferenciar claramente entre las claves y propiedades internas, evita problemas de conflicto con las propiedades del prototipo de JavaScript, como ocurre a veces con los objetos.

## Principales Métodos y Propiedades de Map
1. Creación de un Map
Puedes crear un Map vacío o inicializarlo con pares clave-valor:
```js
const myMap = new Map();

```
O bien, inicializarlo con valores:


```js
const myMap = new Map([
    ["name", "Alice"],
    ["age", 30]
]);
console.log(myMap); // Map { "name" => "Alice", "age" => 30 }

```

Métodos Clave de Map
set(key, value): Añade o actualiza un par clave-valor en el Map.
```js
myMap.set("city", "New York");
console.log(myMap); // Map { "name" => "Alice", "age" => 30, "city" => "New York" }
```
get(key): Devuelve el valor asociado con una clave específica. Si la clave no existe, devuelve undefined.
```js
console.log(myMap.get("name")); // Alice
console.log(myMap.get("country")); // undefined
```
has(key): Verifica si una clave específica existe en el Map.
```js
console.log(myMap.has("age")); // true
console.log(myMap.has("country")); // false
```
delete(key): Elimina el par clave-valor asociado con la clave especificada. Devuelve true si se elimina, o false si la clave no existe.
```js
myMap.delete("age");
console.log(myMap); // Map { "name" => "Alice", "city" => "New York" }
```
clear(): Elimina todos los elementos del Map.
```js
myMap.clear();
console.log(myMap); // Map {}
```
size: Propiedad que devuelve el número de pares clave-valor en el Map.
```js
const myMap = new Map([["name", "Alice"], ["city", "New York"]]);
console.log(myMap.size); // 2
```

## Iteración de Maps
Puedes iterar a través de los elementos de un Map usando bucles for...of, forEach, y otros métodos integrados:

Iterar con for...of:
```js
for (const [key, value] of myMap) {
  console.log(`${key}: ${value}`);
}
```
Métodos de iteración:

keys(): Devuelve un iterador para las claves del Map.
```js
for (const key of myMap.keys()) {
  console.log(key);
}
```
values(): Devuelve un iterador para los valores del Map.
```js
for (const value of myMap.values()) {
  console.log(value);
}
```
entries(): Devuelve un iterador para los pares clave-valor del Map (es similar a Map[Symbol.iterator]).
```js
for (const [key, value] of myMap.entries()) {
  console.log(`${key}: ${value}`);
}
```