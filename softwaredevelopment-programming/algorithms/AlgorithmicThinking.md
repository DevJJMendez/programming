#algorithms
# Pensamiento Algorítmico
El pensamiento algorítmico es **la capacidad de analizar un problema, descomponerlo en pasos lógicos y definir un conjunto finito de instrucciones que conduzcan a una solución eficiente.**

**En otras palabras**: Es pensar como una máquina, transformar un problema complejo en una secuencia ordenada, precisa y optimizable de pasos ejecutables.

**Intuición**: Cuando tú programas, no le dices a la computadora qué quieres, sino cómo debe hacerlo. El pensamiento algorítmico es el proceso mental que traduce la intención humana en una solución computable.

### Ejemplo simple:
* Problema: “Encuentra el número más grande de una lista.”

* Pensamiento algorítmico:
  * Asumo que el primer número es el mayor.
  * Recorro los demás.
  * Si encuentro uno mayor, lo actualizo.
  * Al final, retorno el mayor.

```java
int max = arr[0];
for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) max = arr[i];
}
return max;
```

## ¿Para qué sirve el pensamiento algorítmico?
Sirve para resolver problemas de manera estructurada, eficiente y reproducible.

| Propósito                           | Explicación                                                           |
| ----------------------------------- | --------------------------------------------------------------------- |
| **Descomponer problemas complejos** | Divide el problema en subproblemas simples y manejables.              |
| **Diseñar soluciones eficientes**   | Permite optimizar pasos, detectar redundancias y reducir complejidad. |
| **Predecir comportamiento**         | Saber cómo escalará la solución cuando crezcan los datos.             |
| **Garantizar corrección**           | Los algoritmos son lógicos, predecibles y demostrables.               |
| **Reutilizar conocimiento**         | Aprendes patrones que se aplican en miles de contextos.               |

## ¿Qué problema resuelve?
El pensamiento algorítmico **resuelve el “caos mental”** entre:

* **Entender** un problema en lenguaje natural, y **Poder** expresarlo como una secuencia precisa de operaciones.

Sin este pensamiento, escribes código al azar, “probando a ver si funciona”. Con él, **razonas, modelas, y garantizas la corrección antes de codificar.**

## ¿Cómo lo resuelve?
Lo hace a través de cuatro habilidades cognitivas clave, que debes desarrollar progresivamente.

Cada una representa una “fase mental” del pensamiento algorítmico, las cuales son: **Descomposición**, **Reconocimiento de patrones**, **Abstracción**, **Diseño algorítmico**.

FASE 1: Descomposición
Dividir el problema en partes más pequeñas.

👉 “Divide y vencerás.”

Ejemplo:
Problema → “Ordenar una lista de números.”

Descomposición:

Si la lista tiene 1 elemento, ya está ordenada.

Dividir la lista en dos mitades.

Ordenar cada mitad (recursivamente).

Combinar los resultados.

➡️ Acabas de describir MergeSort sin darte cuenta.

FASE 2: Reconocimiento de patrones
Identificar similitudes entre problemas o estructuras.

Ejemplo:

“Buscar un elemento en una lista ordenada” y “adivinar un número entre 1 y 100” comparten el mismo patrón: búsqueda binaria.

📘 Este reconocimiento te permite:

Reutilizar soluciones previas.

Detectar la estructura del problema.

Seleccionar el paradigma adecuado (divide & conquer, greedy, DP, etc).

FASE 3: Abstracción
Separar lo esencial del ruido.

👉 “Ignorar los detalles irrelevantes para centrarse en el comportamiento general.”

Ejemplo:
No importa si una lista está implementada como ArrayList o LinkedList;
lo importante es que puedes recorrer sus elementos secuencialmente.

📘 En algoritmia:

Abstraes la estructura (lista, árbol, grafo).

Abstraes operaciones (insertar, buscar, recorrer).

Diseñas sobre modelos conceptuales, no sobre implementaciones.

FASE 4: Diseño algorítmico
Crear un plan paso a paso para resolver el problema eficientemente.

Aquí aplicas todo lo anterior:

Definir entradas y salidas.

Establecer invariantes (condiciones que siempre deben cumplirse).

Elegir estructuras de datos adecuadas.

Optimizar el flujo (iterativo, recursivo, dividido, greedy, etc).

Analizar complejidad temporal y espacial.

Componentes esenciales del pensamiento algorítmico
| Componente              | Descripción                                  | Ejemplo                                   |
| ----------------------- | -------------------------------------------- | ----------------------------------------- |
| Entrada y salida        | Claridad en lo que entra y lo que debe salir | Entrada: array, Salida: número máximo     |
| Invariante              | Condición que se mantiene siempre            | “max contiene el mayor hasta el índice i” |
| Recurrencia o iteración | Cómo se avanza paso a paso                   | for, while, o recursión                   |
| Condición de parada     | Cuándo terminar                              | “i == n” o “base case”                    |
| Eficiencia              | Cuántas operaciones requiere                 | O(n), O(n²), etc.                         |
| Corrección              | Que el algoritmo haga lo que debe            | Se demuestra con invariantes o inducción  |

Paradigmas de diseño algorítmico (el cómo)
Una vez piensas algorítmicamente, puedes elegir el paradigma más adecuado según el tipo de problema:
| Paradigma           | Descripción                                    | Ejemplo clásico      |
| ------------------- | ---------------------------------------------- | -------------------- |
| Divide & Conquer    | Divide el problema, resuelve y combina         | MergeSort, QuickSort |
| Greedy              | Elige siempre la mejor opción local            | Dijkstra, Huffman    |
| Dynamic Programming | Divide y memoriza resultados                   | Fibonacci, Knapsack  |
| Backtracking        | Explora todas las soluciones posibles con poda | N-Reinas, Sudoku     |
| Brute Force         | Prueba todas las combinaciones posibles        | Permutaciones        |
| Recursión           | Define el problema en términos de sí mismo     | Factorial, Fibonacci |
| Iterativo           | Usa bucles en lugar de recursión               | Búsqueda lineal      |


# Entrada / Salida
La entrada (Input) de un algoritmo es el conjunto de datos iniciales que se le proporciona para que realice un proceso y produzca un resultado. En otras palabras: **Es todo lo que el algoritmo necesita saber antes de comenzar su ejecución.**

Intuición: Imagina el algoritmo como una máquina de transformación:
```bash
[Entrada]  →  [Proceso lógico / Algoritmo]  →  [Salida]
```
Sin entrada, no hay materia prima para procesar.
Es como intentar calcular un promedio sin tener números.

Propósitos de la entrada:
| Propósito                             | Descripción                                             |
| ------------------------------------- | ------------------------------------------------------- |
| 1️⃣ Definir el contexto del problema    | Le da significado al algoritmo (¿de qué trata?).        |
| 2️⃣ Delimitar el alcance                | Determina qué parte de la realidad modela el algoritmo. |
| 3️⃣ Proveer datos para el procesamiento | Es la información sobre la cual operará el algoritmo.   |
| 4️⃣ Permitir variabilidad               | Permite que el algoritmo se aplique a distintos casos.  |

Propiedades de una buena entrada
| Propiedad     | Descripción                                                       |
| ------------- | ----------------------------------------------------------------- |
| Finita        | Debe tener un tamaño finito, aunque pueda ser variable.           |
| Bien definida | Cada dato debe tener un significado claro y tipo conocido.        |
| Válida        | Cumple con las restricciones del problema (rango, formato, etc.). |
| Controlada    | Debe existir validación de errores o datos corruptos.             |
| Relevante     | Solo incluir información necesaria para la resolución.            |

Ejemplo: Problema: Calcular el promedio de una lista de notas.
  * Entrada: Una lista de números (`List<Double> notas`)

```java
List<Double> notas = Arrays.asList(4.0, 3.5, 4.8, 5.0);
```
La entrada:
* Es finita.
* Tiene tipo definido (Double).
* Contiene información relevante.

Tipos de entrada
| Tipo                 | Ejemplo                                   | Uso                                   |
| -------------------- | ----------------------------------------- | ------------------------------------- |
| Escalar              | int n = 10;                               | Un solo valor.                        |
| Estructurada         | int[] arr = {1,2,3,4};                    | Conjunto de datos homogéneos.         |
| Compuesta            | List<User> users                          | Datos con múltiples atributos.        |
| Funcional            | Una función o predicado (Predicate<T>)    | Permite comportamiento parametrizado. |
| Interactiva          | Datos ingresados por el usuario (Scanner) | Programas con entrada dinámica.       |
| Desde archivos o red | Lectura de JSON, CSV, API, etc.           | Procesamiento de datos externos.      |

## ¿Qué es la Salida en un algoritmo?
📖 Definición formal:
La salida (Output) es el resultado producido por el algoritmo después de procesar las entradas según las reglas definidas.

En otras palabras:

Es la respuesta final del proceso computacional.

Intuición:
Si la entrada es la pregunta, la salida es la respuesta.
Cada algoritmo debe tener al menos una salida, explícita o implícita,
pues esa es la razón de su existencia.

Propósitos de la salida:
| Propósito                                | Descripción                                               |
| ---------------------------------------- | --------------------------------------------------------- |
| 1️⃣ Mostrar el resultado del procesamiento | Indica qué hizo el algoritmo.                             |
| 2️⃣ Validar la corrección del diseño       | Si la salida no es correcta, el algoritmo falla.          |
| 3️⃣ Comunicar información al entorno       | Permite que otras partes del sistema usen los resultados. |
| 4️⃣ Medir eficiencia o comportamiento      | La salida puede incluir métricas (tiempo, conteo, etc.).  |

Propiedades de una buena salida
| Propiedad      | Descripción                                              |
| -------------- | -------------------------------------------------------- |
| Finita         | Debe producir un resultado en tiempo finito.             |
| Bien           | definida	El significado del resultado debe ser claro.    |
| Correcta       | Debe corresponder al objetivo del algoritmo.             |
| Consistente    | Para la misma entrada, debe dar siempre la misma salida. |
| Interpretables | Debe ser útil para el usuario o para otro sistema.       |

Ejemplo
Continuando con el ejemplo del promedio:

Salida esperada:
Un valor double que representa el promedio.

```java
public static double calcularPromedio(List<Double> notas) {
    double suma = 0;
    for (double nota : notas) {
        suma += nota;
    }
    return suma / notas.size();
}
```
📘 Entrada → List<Double>
📘 Salida → double

Propiedades relacionales clave
| Concepto                                                             | Descripción                                        |
| -------------------------------------------------------------------- | -------------------------------------------------- |
| Determinismo                                                         | Misma entrada → misma salida.                      |
| Completitud	Siempre produce una salida (no queda en bucle infinito). |
| Eficiencia                                                           | Produce la salida en tiempo y espacio razonables.  |
| Exactitud                                                            | La salida cumple el objetivo lógico del algoritmo. |

Tipos de salida
| Tipo                    | Ejemplo                            | Uso                                     |
| ----------------------- | ---------------------------------- | --------------------------------------- |
| Escalar                 | int resultado = 42;                | Un único valor.                         |
| Estructurada            | int[] resultado = {1, 2, 3};       | Conjunto ordenado.                      |
| Compuesta (objeto)      | UserData user = new UserData(...); | Información compleja.                   |
| Booleano                | true / false                       | Validaciones o decisiones.              |
| Void / efecto colateral | System.out.println("Hola");        | No devuelve valor, pero realiza acción. |


---
[](Decomposition.md)
[](PatternRecognition)
[](Abstraction)
[](AlgorithmicDesign.md)