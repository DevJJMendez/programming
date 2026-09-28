#AlgorithmicThinking
# Reconocimiento de Patrones
El reconocimiento de patrones es la capacidad de **identificar similitudes, estructuras o comportamientos repetitivos** dentro de un problema, o entre distintos problemas, para reutilizar soluciones o estrategias previamente conocidas.

**En otras palabras**: Es detectar que un problema nuevo “se parece” a otro que ya resolviste antes, aunque se presente de una forma distinta.

**Intuición**: Piensa en cuando ves un nuevo desafío y dices:
* *“Esto se parece al problema de los pares que suman un número…”*
* *“Esto tiene pinta de una búsqueda binaria…”*
* *“Esto se resuelve con una pila…”*

En ese momento, **no estás adivinando**, estás **reconociendo** un patrón algorítmico.

## En ciencias de la computación:
Un patrón no es solo una repetición visual, sino una estructura lógica común que aparece en muchos contextos diferentes.

Por ejemplo:
* “Recorrer algo elemento por elemento” → patrón de iteración.

* “Revisar los elementos previos para tomar una decisión” → patrón de acumulación o memoria.

* “Resolver el mismo problema más pequeño dentro del grande” → patrón de recursión.

## ¿Para qué sirve el Reconocimiento de Patrones?
Sirve para pensar más rápido, más eficiente y con mayor precisión. Es el “atajo mental” del ingeniero experto.

| Propósito                      | Descripción                                                             |
| ------------------------------ | ----------------------------------------------------------------------- |
| Reutilización de conocimiento  | Puedes aplicar soluciones probadas a nuevos problemas.                  |
| Reducción de complejidad       | Te enfocas solo en las diferencias, no en reinventar todo.              |
| Diseño más rápido              | Reconocer un patrón acelera la creación de la solución.                 |
| Selección de estrategia óptima | Te permite saber si el problema requiere divide & conquer, greedy, etc. |
| Claridad en la implementación  | Tu código sigue una forma estructurada y predecible.                    |

En ingeniería, este es el paso donde tu cerebro dice: **“`Este problema es de tipo búsqueda / recorrido / combinación / optimización`”.**

## ¿Qué resuelve?
Resuelve el problema de reconocimiento: Cuando no sabes `por dónde empezar`, el patrón te muestra `qué camino seguir`.

Sin esta fase, pasas horas intentando inventar una solución nueva cada vez. Con esta fase, **identificas el tipo de problema**, **recuerdas una estructura conocida**, y **adaptas** la solución.

## Estructura del Reconocimiento de Patrones
El reconocimiento sigue una secuencia cognitiva o estructura mental que los expertos aplican sin darse cuenta. Podemos formalizarla así:

* **Estructura mental**
  1. Identifica la forma general del problema.
     * ¿Se trata de buscar, ordenar, optimizar, contar, generar, decidir?

  2. Compara con patrones conocidos.
     * ¿Se parece a algún algoritmo o estructura clásica?

  3. Aísla la parte que coincide.
     * ¿Qué parte del problema sigue ese patrón?

  4. Adapta el patrón a los nuevos datos.
     * Ajusta la implementación o estructura según el contexto.

  5. Evalúa si el patrón es suficiente.
     * ¿Resuelve completamente el problema o necesitas combinarlo con otro patrón?

* **Ejemplo simple**:
  * Problema: **“Dado un array de enteros, determina si hay duplicados.”**
    
    1. Paso 1: Forma general
       * “Comparar elementos entre sí.”

    2. Paso 2: Patrón conocido
       * “He visto algo similar al verificar si un número ya fue visto antes.”
       * Patrón: uso de `HashSet` para detección de repetidos.

    3. Paso 3: Aislar coincidencia
       * El patrón aplica a cada número: “Si ya lo vi, hay duplicado.”

    4. Paso 4: Adaptar
```java
Set<Integer> seen = new HashSet<>();
for (int num : arr) {
    if (!seen.add(num)) return true;
}
return false;
```
**Reconociste un patrón de detección por historial.**

## Tipos de patrones algorítmicos más comunes
A medida que estudies más algoritmos, verás que la mayoría son combinaciones de estos patrones base:

| Tipo de patrón                          | Descripción                                        | Ejemplo                                     |
| --------------------------------------- | -------------------------------------------------- | ------------------------------------------- |
| **Iteración / Recorrido**               | Procesar cada elemento de una colección.           | `for-loop`, `BFS`, `DFS`                    |
| **Selección / Búsqueda**                | Encontrar el mejor o un elemento específico.       | `Binary Search`, `Max Element`              |
| **Acumulación**                         | Combinar resultados parciales.                     | Suma, conteo, producto                      |
| **División y conquista**                | Resolver el problema dividiéndolo recursivamente.  | `MergeSort`, `QuickSort`                    |
| **Recursión**                           | Resolver un problema en términos de sí mismo.      | `Fibonacci`, Factorial                      |
| **Ventana deslizante (Sliding Window)** | Explorar subconjuntos contiguos de datos.          | Subarray con suma máxima                    |
| **Dos punteros (Two Pointers)**         | Mover dos índices con relación entre sí.           | Pares con suma objetivo                     |
| **Greedy (Avaro)**                      | Elegir la mejor opción local.                      | `Dijkstra`, `Huffman`                       |
| **Backtracking**                        | Explorar todas las combinaciones posibles.         | Sudoku, N-Reinas                            |
| **Dynamic Programming**                 | Guardar resultados intermedios para no recalcular. | `Fibonacci DP`, `Knapsack`                  |
| **Divide por estructura de datos**      | Aplicar una estructura que modela el problema.     | `Stack` para paréntesis, `Queue` para `BFS` |

## ¿Cómo se implementa?
Implementar un reconocimiento de patrón no es escribir código directamente, sino traducir el patrón lógico al código adecuado.

1. Paso 1: Detecta el patrón subyacente
   * Ejemplo:
     * “Necesito procesar elementos de izquierda a derecha, acumulando una suma parcial.”
     * → Patrón: Iteración + Acumulación

2. Paso 2: Selecciona la estructura adecuada
   * Iteración → for, while, forEach
   * Acumulación → variable acumuladora, reduce(), o estructura auxiliar

3. Paso 3: Escribe el esqueleto del patrón
```java
int sum = 0;
for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
}
return sum;
```
**Una vez lo entiendes, puedes reutilizar este mismo patrón en miles de problemas: Contar pares, promedios, distancias, etc.**

4. Paso 4: Generaliza el patrónCrea plantillas mentales o de código que representen cada patrón.
   * Por ejemplo: Patrón de búsqueda binaria
```java
int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```
Este patrón se reutiliza en:
* Buscar en listas ordenadas
* Determinar el valor mínimo que cumple una condición
* Optimización binaria en problemas de rango

## Cómo desarrollar esta habilidad
El reconocimiento de patrones se entrena igual que un músculo:

El reconocimiento de patrones se entrena igual que un músculo:

| Ejercicio                                        | Qué entrena                                     |
| ------------------------------------------------ | ----------------------------------------------- |
| Resolver muchos problemas variados               | Exposición a distintos patrones.                |
| Comparar soluciones distintas del mismo problema | Ver el patrón detrás de la forma.               |
| Clasificar problemas por tipo de patrón          | Memoria conceptual.                             |
| Implementar el mismo patrón en varios contextos  | Transferencia de conocimiento.                  |
| Refactorizar código propio                       | Aprender a ver el patrón “oculto” en tu lógica. |

Consejo: Después de resolver un problema, no te preguntes solo “cómo lo hice”, sino “qué patrón utilicé”.

## Reconocimiento de patrones ≠ Memorización
Mucha gente confunde aprender algoritmos con memorizar soluciones. La diferencia clave es esta:

| Memorizar                       | Reconocer patrones                        |
| ------------------------------- | ----------------------------------------- |
| Sabes el algoritmo paso a paso. | Sabes por qué y cuándo aplicarlo.         |
| Reaccionas mecánicamente.       | Piensas estratégicamente.                 |
| No puedes adaptarlo.            | Lo adaptas fácilmente a nuevos problemas. |