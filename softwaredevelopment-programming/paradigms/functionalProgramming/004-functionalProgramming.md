# Programación Funcional
El paradigma funcional es un estilo de programación que se basa en funciones matemáticas puras y evita el uso de estados mutables y efectos secundarios. A diferencia del paradigma imperativo, donde el enfoque está en describir **cómo** se debe realizar una tarea (paso a paso), en el paradigma funcional, el enfoque está en **qué** se quiere lograr, utilizando funciones como bloques fundamentales.

## ¿Qué es la Programación Funcional?
La programación funcional es un paradigma en el que las funciones son tratadas como ciudadanos de primera clase, lo que significa que pueden ser asignadas a variables, pasadas como argumentos a otras funciones, o retornadas desde funciones. Este paradigma se basa en los siguientes principios:

* **Funciones puras**: Una función es pura si, dado el mismo conjunto de entradas, siempre devuelve el mismo conjunto de salidas y no tiene efectos secundarios (es decir, no modifica el estado externo).

* **Inmutabilidad**: Las estructuras de datos no cambian una vez que se crean. En lugar de modificar los datos, se crean nuevas versiones con los cambios aplicados.

* **Expresiones y evaluación perezosa**: La evaluación de las expresiones se pospone hasta que se necesiten sus resultados.

* **Funciones de orden superior**: Las funciones pueden recibir otras funciones como argumentos o devolverlas como resultado, promoviendo una mayor flexibilidad en la composición de código.

* **Transparencia referencial**: El valor de una expresión puede ser reemplazado por su valor sin alterar el comportamiento del programa.

## Características Clave de la Programación Funcional
1. **Composición de funciones**: La capacidad de combinar funciones pequeñas en otras más complejas es uno de los conceptos fundamentales de la programación funcional. Esto promueve la creación de código modular y reutilizable.

2. **Recursión en lugar de bucles**: La recursión es una técnica común en la programación funcional, ya que en lugar de utilizar bucles, las funciones se llaman a sí mismas para repetir tareas.

3. **Sin efectos secundarios**: Al evitar modificar el estado global o los datos externos, el código es más predecible y fácil de depurar.

## ¿Para qué sirve la Programación Funcional?
La programación funcional es especialmente útil en aplicaciones donde:

1. **Concurrencia y paralelismo**: Dado que las funciones no tienen efectos secundarios y las estructuras de datos son inmutables, no hay riesgo de que múltiples hilos de ejecución modifiquen el mismo estado, lo que simplifica el desarrollo de programas concurrentes y paralelos.

2. **Transformación de datos**: Este paradigma es ideal para la manipulación de datos, filtrado, mapeo, reducción y composición de transformaciones, lo que lo hace popular en el ámbito de big data y procesamiento de flujos.

3. **Desarrollo declarativo**: La programación funcional permite escribir código más conciso y declarativo, describiendo lo que se quiere lograr en lugar de cómo lograrlo.

## ¿Qué resuelve la Programación Funcional?
La programación funcional resuelve varios problemas comunes en el desarrollo de software:

1. **Estados compartidos y mutabilidad**: En sistemas complejos, mantener y gestionar estados compartidos puede generar errores difíciles de detectar. La inmutabilidad en la programación funcional elimina estos problemas.

2. **Efectos secundarios**: Los efectos secundarios, como la modificación de variables globales o de objetos fuera de una función, pueden provocar inconsistencias. La programación funcional, al evitar estos efectos, hace que el código sea más fácil de razonar y depurar.

3. **Complejidad de concurrencia**: Al eliminar estados mutables y efectos secundarios, la programación funcional facilita la ejecución paralela de tareas, ya que no es necesario preocuparse por condiciones de carrera o bloqueos de recursos compartidos.

## ¿Cómo lo resuelve?
1. **Funciones puras**: Una función pura no tiene efectos secundarios y siempre devuelve el mismo resultado para los mismos argumentos. Esto garantiza que el comportamiento del programa es más predecible y fácil de entender.

* Ejemplo de función pura en JavaScript:

  ```js
  const sumar = (a, b) => a + b;
  ```
  Dado que `sumar(2, 3)` siempre devolverá `5`, es una función pura. No tiene efectos secundarios, no modifica ningún estado externo.

2. **Inmutabilidad**: En programación funcional, las estructuras de datos son inmutables, lo que significa que no se pueden modificar después de haber sido creadas. En lugar de cambiar una estructura, se crea una nueva con los cambios aplicados.

* **Ejemplo**

  ```js
  const lista = [1, 2, 3];
  const nuevaLista = [...lista, 4]; // nuevaLista es [1, 2, 3, 4], lista sigue siendo [1, 2, 3]
  ```
  Este enfoque evita errores al modificar estructuras compartidas entre diferentes partes de un programa.

3. **Funciones de orden superior**: Una función de orden superior es aquella que toma una o más funciones como argumentos, o bien devuelve una función como resultado. Esto promueve la reutilización y composición de funciones.

* **Ejemplo**

  ```js
  const aplicarOperacion = (operacion, a, b) => operacion(a, b);

  const sumar = (a, b) => a + b;
  const multiplicar = (a, b) => a * b;

  console.log(aplicarOperacion(sumar, 2, 3)); // Resultado: 5
  console.log(aplicarOperacion(multiplicar, 2, 3)); // Resultado: 6
  ```
  En este ejemplo, la función `aplicarOperacion` puede recibir cualquier función como parámetro, haciendo que el código sea más modular y flexible.

4. **Transparencia referencial**: La transparencia referencial significa que cualquier expresión puede ser reemplazada por su valor sin cambiar el comportamiento del programa. Esto es una consecuencia de tener funciones puras y estructuras de datos inmutables.

* Ejemplo en `Haskell`

  ```haskell
  let x = 5 + 3
  let y = x * 2
  ```
  En este caso, `x` siempre será **8**, y podemos reemplazar `x` por **8** en cualquier lugar del código sin cambiar el resultado.

5. **Evaluación perezosa**: La evaluación perezosa significa que las expresiones no se calculan hasta que se necesiten. Esto puede mejorar el rendimiento, ya que evita realizar cálculos innecesarios.

* **Ejemplo**

  ```haskell
  take 3 [1..] -- Retorna [1, 2, 3]
  ```
  La lista `[1..]` es una lista infinita de números, pero gracias a la evaluación perezosa, solo se calculan los primeros tres elementos, lo que permite trabajar con estructuras de datos potencialmente infinitas sin problemas de rendimiento.

## Ventajas
1. **Facilidad para razonar sobre el código**: Al eliminar efectos secundarios y usar funciones puras, es más fácil razonar sobre el comportamiento del código.

2. **Reutilización de código**: Las funciones son bloques modulares y reutilizables que pueden ser combinados de diversas maneras.

3. **Fácil de probar**: Las funciones puras son más fáciles de probar debido a que no dependen de estados externos.

4. **Paralelismo y concurrencia simplificados**: Al evitar la mutabilidad y los efectos secundarios, es más fácil ejecutar tareas en paralelo sin problemas de sincronización.

## Desventajas:
1. **Curva de aprendizaje**: La programación funcional puede ser difícil de entender para desarrolladores acostumbrados a paradigmas imperativos.

2. **Rendimiento**: En algunos casos, la inmutabilidad puede introducir sobrecarga en términos de rendimiento debido a la creación constante de nuevas estructuras de datos.

3. **Escasa adopción en proyectos empresariales**: A pesar de sus ventajas, el paradigma funcional es menos adoptado en aplicaciones empresariales comparado con la orientación a objetos.

## Lenguajes Funcionales Populares
* **Haskell**: Un lenguaje puramente funcional que implementa todos los principios del paradigma funcional.

* **Erlang**: Un lenguaje funcional enfocado en la concurrencia y tolerancia a fallos, utilizado en sistemas de telecomunicaciones.

* **Scala**: Combina programación funcional y orientación a objetos, y es ampliamente utilizado en la industria.

* `F#`: Un lenguaje funcional para la plataforma `.NET` que también admite programación imperativa y orientada a objetos.

* `JavaScript`: Aunque no es un lenguaje funcional puro, tiene características de programación funcional, como funciones de orden superior, inmutabilidad y funciones como ciudadanos de primera clase.
