## Variables
Las variables son contenedores o espacios en la memoria de la computadora que almacenan valores que pueden cambiar durante la ejecución de un programa. Una variable tiene un **nombre (identificador)**, un **tipo de dato** que define el tipo de valor que puede almacenar (como `int`, `float`, etc.), y un **valor** que puede ser asignado y modificado a lo largo del tiempo.

### ¿Qué resuelven las Variables?
Las variables resuelven varios problemas fundamentales en programación:

1. **Almacenamiento temporal de datos**: Permiten almacenar datos de forma temporal para ser utilizados en diferentes partes del programa.

2. **Facilidad de manipulación de datos**: Facilitan el acceso y modificación de los datos, ya que puedes referirte a ellos a través de un nombre en lugar de una ubicación en memoria.

3. **Legibilidad y reutilización del código**: Usar variables permite hacer que el código sea más comprensible y reutilizable, ya que los valores pueden cambiar sin necesidad de modificar cada parte del código que los usa.

4. **Abstracción del acceso a la memoria**: En lugar de trabajar directamente con direcciones de memoria, las variables proporcionan un acceso más simple y seguro a los datos.

### ¿Cómo se utilizan?
1. **Declaración de una Variable**: Para declarar una variable en **C**, es necesario especificar su tipo y darle un nombre:

  ```c
  int age;
  float height;
  char initial;
  ```

2. **Inicialización de una Variable**: Puedes asignar un valor inicial a una variable cuando la declaras o más tarde en el código:

  ```c
  int age = 75;
  height = 1.74
  ```

3. **Operaciones con Variables**: Puedes utilizar variables para realizar operaciones aritméticas, lógicas, de comparación, etc.:

  ```c
  int sum = 10 + 15;
  int product = sum * 3;
  ```

### ¿Cuándo se utilizan?
1. **Cuando se necesita almacenar datos temporalmente**: Las variables se usan para almacenar datos de entrada, resultados intermedios de cálculos, o valores que cambian con el tiempo durante la ejecución del programa.

2. **Para facilitar el acceso a datos**: Se utilizan cuando se necesita referenciar un valor en múltiples partes del código, evitando tener que recordar la ubicación exacta en memoria.

3. **Para realizar cálculos y operaciones**: En cualquier operación matemática, lógica o de manipulación de datos, es esencial usar variables para guardar resultados y realizar operaciones intermedias.

4. **En funciones y estructuras de control**: Las variables son fundamentales para controlar la lógica de un programa, desde la comparación de valores en sentencias condicionales hasta el uso en bucles para iterar sobre conjuntos de datos.

## Scope
1. **Variables locales**: Declaradas dentro de una función, solo son accesibles dentro de esa función.

2. **Variables globales**: Declaradas fuera de todas las funciones, son accesibles desde cualquier parte del programa.

3. **Variables estáticas**: Mantienen su valor entre múltiples llamadas a la misma función, pero su alcance sigue siendo local a esa función.

4. **Variables externas**: Declaradas en otros archivos de código fuente, pueden ser utilizadas con la palabra clave extern.