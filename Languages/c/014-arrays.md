## Arrays
Un array en C es una estructura de datos que permite almacenar una colección de elementos del mismo tipo bajo un único nombre. Cada elemento del array se accede utilizando un índice. Los arrays se utilizan cuando se necesitan múltiples elementos de un tipo de dato, pero no se quiere declarar una variable individual para cada uno de ellos.

### ¿Qué resuelven los arrays?
Los arrays resuelven la necesidad de manejar múltiples valores del mismo tipo de manera eficiente. En lugar de declarar muchas variables para cada valor, puedes almacenar todos esos valores en un array y acceder a ellos mediante índices, lo que facilita el manejo de grandes cantidades de datos.

### ¿Cómo lo resuelven?
Los arrays permiten:

* Almacenar un conjunto de valores consecutivos del mismo tipo en memoria.
* Acceder a estos valores de manera rápida y eficiente utilizando un índice.
* Simplificar la manipulación de conjuntos de datos, como listas, tablas o matrices.

### Arrays
En C, hay dos tipos principales de arrays:

* **Arrays unidimensionales** (una sola fila de elementos, también conocidos como vectores).
* **Arrays multidimensionales** (arrays de dos o más dimensiones, como matrices).

### Declaración de un array
**Sintaxis**
```c
tipo nombrArray[tamaño]
```
* **tipo**: Tipo de dato que almacenará el array (como `int`, `float`, `char`, etc.).
* **nombreArray**: Nombre que se le da al array.
* **tamaño**: Número de elementos que contendrá el array.

**Ejemplo de un array unidimensional**
```c
int numbers[5];
```

### Inicialización de un array
Puedes inicializar un array en el momento de su declaración.
```c
int numbers[5] = {10,20,30,40,50};
```
Si no se inicializan todos los elementos, los no inicializados se configuran en 0 de forma predeterminada:
```c
int numbers[5] = {10,20}; // Solo los primeros dos elementos se inicializan, el resto será 0
```

### Acceso a los elementos del array
Los elementos de un array se acceden utilizando el índice del array. El índice empieza en 0 (el primer elemento está en la posición 0).
```c
printf("%d", numbers[0]);  // Imprime el primer elemento (10)
```
**Modificicación de un elemento del array**
```c
numbers[2] = 60;
```

## Arrays y memoria
Un array ocupa una memoria contigua, es decir, todos los elementos del array están almacenados uno después de otro en la memoria. El tamaño total de un array se puede calcular como **tamaño = número de elementos * tamaño de cada elemento**. Por ejemplo, un array de 5 enteros (`int`) en una arquitectura donde `int` ocupa 4 bytes tendrá un tamaño de **5 * 4 = 20 bytes**.

## ¿Cuándo utilizar arrays?
* Cuando necesitas almacenar y manipular una colección de elementos del mismo tipo.
* Cuando necesitas acceder rápidamente a elementos mediante un índice.
* Cuando trabajas con tablas, matrices o listas de datos.
* Cuando quieres reducir la cantidad de variables declaradas y mantener un código más limpio.