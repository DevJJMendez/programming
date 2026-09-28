# Sets
En JavaScript, el objeto Set es una estructura de datos introducida en ES6 (ECMAScript 2015) que permite almacenar valores únicos, es decir, valores que no se repiten. Esta característica hace que los sets sean especialmente útiles cuando necesitas gestionar datos sin duplicados.

¿Qué es un Set?
Un Set es una colección de valores en la que cada valor aparece solo una vez, sin duplicados. A diferencia de un array, en un Set cada elemento es único, y no se permite duplicidad, incluso si se intenta añadir el mismo valor repetidamente. Además, los sets son ordenados, lo cual significa que los valores se mantienen en el orden en que se agregaron.

¿Para qué sirve un Set?
Los sets son útiles para:

Eliminar duplicados de una colección de datos: Permiten crear conjuntos de datos únicos fácilmente.
Operaciones de conjuntos: Como unión, intersección y diferencia.
Verificar rápidamente la presencia de un valor en una colección sin preocuparse por su posición.
¿Qué resuelve el uso de un Set?
El uso de un Set resuelve problemas donde se necesita mantener una colección de valores únicos, eliminando duplicados sin hacer una verificación exhaustiva. Esto es especialmente útil en escenarios donde se trabaja con grandes cantidades de datos y se necesita optimizar la eficiencia y la claridad del código.

¿Cómo lo resuelve?
El Set maneja automáticamente la unicidad de los valores internamente. Cuando se añade un valor a un Set, se comprueba si ya existe en la colección; si no existe, se agrega, y si ya está, se ignora. Esto evita la necesidad de implementar manualmente validaciones o búsquedas en arrays para evitar duplicados.

## Principales Métodos y Propiedades de Set
1. Creación de un Set
Para crear un set, se puede usar la sintaxis:
```js
const mySet = new Set();
```
También puedes inicializarlo con valores:
```js
const mySet = new Set([1, 2, 3, 4, 4]); // 4 solo aparecerá una vez
console.log(mySet); // Set { 1, 2, 3, 4 }
```

Métodos Clave de Set
add(value): Agrega un nuevo valor al Set. Si el valor ya existe, se ignora.
```js
const mySet = new Set();
mySet.add(10);
mySet.add(20);
mySet.add(10); // Ignorado
console.log(mySet); // Set { 10, 20 }
```
delete(value): Elimina un valor específico del Set.
```js
mySet.delete(10);
console.log(mySet); // Set { 20 }
```
has(value): Verifica si el Set contiene un valor específico, retornando true o false.
```js
console.log(mySet.has(20)); // true
console.log(mySet.has(10)); // false
```
clear(): Elimina todos los elementos del Set.
```js
mySet.clear();
console.log(mySet); // Set {}
```
size: Propiedad que devuelve la cantidad de elementos en el Set.
```js
const mySet = new Set([1, 2, 3]);
console.log(mySet.size); // 3
```