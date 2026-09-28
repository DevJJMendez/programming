## Tipos de datos
Los tipos de datos en C son las categorías de valores que una variable puede almacenar. Indican al compilador el tamaño de la memoria que se debe reservar para esa variable y las operaciones que pueden realizarse sobre los datos almacenados.

### ¿Qué resuelven los tipos de datos?
1. **Gestión de memoria**: Cada tipo de dato indica al compilador cuánta memoria se debe asignar a una variable. Esto es crucial para manejar los recursos de manera eficiente.

2. **Operaciones válidas**: Determinan las operaciones permitidas. Por ejemplo, puedes sumar dos enteros, pero no puedes sumar directamente un entero con una cadena de texto.

3. **Seguridad en el código**: Garantizan que las operaciones entre variables sean coherentes y minimizan errores, ya que el compilador puede detectar incompatibilidades.

## Datos Primitivos
Los datos primitivos son los tipos de datos básicos o fundamentales en un lenguaje de programación como C. Son las unidades más simples de información que una computadora puede manipular y representan valores elementales. No están compuestos por otros tipos de datos y son la base sobre la que se construyen los tipos de datos más complejos.

En términos generales, los datos primitivos proporcionan una forma eficiente de almacenar y manipular la información más fundamental (como números y caracteres) en la memoria de una computadora.

1. `int`: Representa números enteros, tanto positivos como negativos.

   * Ejemplo: `int edad = 25;`

2. `float`: Representa números con decimales (de coma flotante) de simple precisión.

   * Ejemplo: `float temperatura = 36.6;`

3. `double`: Representa números con decimales (de coma flotante) de doble precisión.

   * Ejemplo: `double distancia = 12345.6789;`

4. `char`: Representa un único carácter (letras, dígitos o símbolos).

   * Ejemplo: `char inicial = 'A';`

5. `void`: Indica la ausencia de un valor o un tipo vacío. Se usa principalmente en funciones que no devuelven un valor.

   * Ejemplo: `void funcion_sin_valor() { ... }`

### ¿Qué resuelven los Datos Primitivos?
Los datos primitivos resuelven los problemas fundamentales de almacenamiento de información básica y control de memoria en un programa. Algunas de las necesidades que cubren son:

1. **Almacenar valores simples**: Números enteros, números decimales y caracteres.

2. **Definir el tamaño de memoria**: Los datos primitivos tienen tamaños específicos que ayudan al compilador a 
asignar eficientemente la memoria.

3. **Controlar la precisión**: Los diferentes tipos de datos permiten al programador elegir entre precisión simple (como float) y precisión doble (como double).

4. **Facilitar operaciones matemáticas y lógicas**: Los tipos de datos como int y float permiten realizar 
operaciones aritméticas y comparaciones.

### ¿Cómo resuelven estos problemas?
1. **Asignación de memoria**: Cada tipo de dato primitivo tiene un tamaño fijo. Por ejemplo, un int normalmente ocupa 4 bytes, mientras que un char ocupa 1 byte. Esto permite al compilador asignar y gestionar de manera óptima la memoria durante la ejecución del programa.

2. **Precisión y rango**: Los tipos de datos como float y double permiten manejar números con decimales y decidir el nivel de precisión que se necesita. Si no es necesario manejar muchos decimales, usar float es suficiente y ahorra memoria.

3. **Velocidad de ejecución**: Los datos primitivos se procesan rápidamente ya que están directamente soportados por el hardware de la computadora.

4. **Facilidad para realizar cálculos**: Con los tipos de datos numéricos (int, float, double), puedes realizar operaciones aritméticas como suma, resta, multiplicación y división.

## Datos No Primitivos
Los datos no primitivos (también conocidos como tipos de datos compuestos o estructurados) son tipos de datos que se construyen a partir de los datos primitivos. Estos datos no son fundamentales, sino que combinan múltiples elementos o proporcionan abstracciones más complejas sobre los datos primitivos. En **C**, los datos no primitivos pueden incluir estructuras, uniones, arreglos, punteros, y tipos definidos por el usuario.

Estos tipos permiten manejar conjuntos de datos más complejos y son esenciales para estructurar grandes programas.

1. **Arrays**: Conjuntos de elementos del mismo tipo.

2. **Estructuras (struct)**: Agrupación de variables de diferentes tipos bajo un solo nombre.

3. **Uniones (union)**: Similar a las estructuras, pero con la particularidad de que todos los miembros comparten la misma posición de memoria.

3. **Punteros**: Variables que almacenan la dirección de memoria de otras variables.

4. **Enumeraciones (enum)**: Conjunto de constantes enteras con nombre.

5. **Tipos definidos por el usuario (`typedef`)**: Se utiliza para crear alias de tipos de datos existentes.

### ¿Qué resuelven los Datos No Primitivos?
Los datos no primitivos resuelven problemas relacionados con:

1. **Agrupación de datos**: Permiten agrupar múltiples variables en una sola unidad lógica, facilitando la organización de los datos en estructuras más complejas.

2. **Modularidad**: Facilitan la división del código en módulos reutilizables, lo que hace que el software sea más fácil de entender y mantener.

3. **Eficiencia en la gestión de memoria**: Especialmente los punteros, permiten manejar datos dinámicamente y trabajar directamente con direcciones de memoria.

4. **Abstracción de datos**: Permiten crear estructuras que representen entidades del mundo real, como objetos o registros, mejorando la claridad del código.

### ¿Cómo resuelven estos problemas?
1. **Agrupación lógica**: Los arrays y estructuras agrupan datos del mismo o diferentes tipos, proporcionando una forma eficiente de acceder y manipular grandes cantidades de datos de forma ordenada.

2. **Control de memoria**: Los punteros permiten el acceso directo a la memoria, lo que es crucial para manejar estructuras de datos dinámicas y trabajar con memoria asignada en tiempo de ejecución (uso de malloc y free).

3. **Flexibilidad en la representación de datos**: Las estructuras y uniones permiten representar entidades complejas con propiedades diversas en un solo bloque de memoria, haciendo que el código sea más claro y fácil de mantener.

5. **Optimización**: Al agrupar datos y reutilizar memoria, los tipos no primitivos permiten optimizar el rendimiento y reducir el uso de recursos.