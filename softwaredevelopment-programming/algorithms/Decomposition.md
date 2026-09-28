#AlgorithmicThinking
# FASE 1: Descomposición
La Descomposición algorítmica es el proceso de **dividir un problema complejo en subproblemas más simples**, hasta que cada subproblema pueda resolverse fácilmente y de forma independiente.

**En palabras simples**: Es **“partir el problema en pedazos lógicos”** que juntos forman la solución completa.

**Intuición**: Piensa en un rompecabezas, No intentas armarlo todo a la vez; separas las piezas por colores, bordes o formas.
Eso es exactamente descomponer.

### Ejemplo
* Problema: “Ordena una lista de números.”

| Etapa                  | Acción                              |
| ---------------------- | ----------------------------------- |
| **Problema principal** | Ordenar toda la lista.              |
| **Subproblemas**       | Ordenar las mitades.                |
| **Sub-subproblemas**   | Ordenar listas más pequeñas.        |
| **Caso base**          | Lista con 1 elemento (ya ordenada). |
| **Composición**        | Combinar las partes ordenadas.      |

## Para qué sirve la Descomposición?
Sirve para controlar la complejidad y estructurar la resolución de un problema.

| Beneficio          | Descripción                                                     |
| ------------------ | --------------------------------------------------------------- |
| **Entendimiento**  | Hace el problema más fácil de analizar y razonar.               |
| **Reutilización**  | Los subproblemas pueden resolverse con funciones reutilizables. |
| **Escalabilidad**  | Permite atacar problemas grandes con recursos limitados.        |
| **Paralelización** | Subproblemas independientes pueden ejecutarse en paralelo.      |
| **Mantenibilidad** | El código se vuelve modular, legible y testeable.               |

**En ingeniería de software, descomponer un problema equivale a diseñar una arquitectura modular.**

## ¿Cuál es su estructura mental?
Cuando descompones un problema algorítmicamente, sigues un patrón mental similar al siguiente:

* **Estructura general**:
  1. **Define el problema principal**.
      * ¿Qué quiero resolver? ¿Cuál es la salida esperada?
  
  2. **Identifica las partes o pasos clave.**
     * ¿Qué tareas puedo aislar o dividir?

  3. **Establece dependencias.**
     * ¿Alguna parte necesita el resultado de otra?

  4. **Resuelve los subproblemas.**
     * Cada subproblema debe ser resoluble por sí solo.

  5. **Combina las soluciones parciales.**
     * Ensambla los resultados para resolver el problema completo.

* **Estructura algorítmica:** Podemos formalizarlo como una función recursiva general:
```markdown
f(Problema P):
    si P es simple → resolver directamente
    sino:
        dividir P en subproblemas más pequeños (P1, P2, ..., Pn)
        resolver cada Pi con f(Pi)
        combinar las soluciones parciales
```
**Este patrón se conoce como “Divide & Conquer” (Divide y vencerás), el cual está basado 100% en descomposición.**

## Tipos de Descomposición
La descomposición puede darse a distintos niveles, tanto conceptuales como técnicos.

| Tipo           | Descripción                                           | Ejemplo                           |
| -------------- | ----------------------------------------------------- | --------------------------------- |
| **Funcional**  | Dividir según las funciones que se deben realizar.    | Validar, procesar, guardar.       |
| **Secuencial** | Dividir según pasos de ejecución.                     | Paso 1 `→` Paso 2 `→` Paso 3.     |
| **Jerárquica** | Dividir en subniveles de detalle.                     | Módulo `→` Submódulo `→` Función. |
| **Recursiva**  | Dividir en versiones más pequeñas del mismo problema. | `MergeSort`, `Binary Search`.     |
| **Por datos**  | Dividir el conjunto de datos.                         | Dividir lista en mitades.         |

## Cómo aplicar la descomposición (método paso a paso)

* Supongamos que tienes este problema: Dado un array de enteros, encuentra el segundo número más grande.
  
  1. Paso 1: Entiende el problema
     * Entrada: `int[] arr`
     * Salida: `int secondLargest`

  2. Paso 2: Descompónlo en partes
     * Encuentra el número más grande.
     * Encuentra el segundo más grande.

  3. Paso 3: Define los subproblemas
     * Subproblema 1: recorrer el array y hallar el máximo.
     
     * Subproblema 2: recorrer nuevamente ignorando el máximo, y hallar el siguiente.

  4. Paso 4: Implementa cada subproblema
```java
int findMax(int[] arr) {
    int max = arr[0];
    for (int num : arr) {
        if (num > max) max = num;
    }
    return max;
}

int findSecondMax(int[] arr) {
    int max = findMax(arr);
    int second = Integer.MIN_VALUE;
    for (int num : arr) {
        if (num != max && num > second) second = num;
    }
    return second;
}
```

  5. Paso 5: Combina las partes
```java
int secondLargest = findSecondMax(arr);
```
**Has descompuesto un problema de una sola frase en dos funciones simples y reutilizables.**

## Descomposición en Java (Patrones Prácticos)
La descomposición se refleja directamente en cómo estructuras tu código.

| Nivel              | Forma de descomposición                              | Ejemplo                          |
| ------------------ | ---------------------------------------------------- | -------------------------------- |
| Métodos            | Cada método resuelve una parte del problema.         | `findMax()`, `findMin()`, etc.   |
| Clases             | Cada clase representa una entidad o responsabilidad. | `class Sorter`, `class Searcher` |
| Paquetes / Módulos | Agrupas funcionalidades relacionadas.                | `com.algorithms.sorting`         |
| Arquitectura       | Divides por capas (presentación, lógica, datos).     | MVC, Clean Architecture          |

**A nivel de algoritmo y a nivel de arquitectura, la descomposición es el mismo principio con distinto alcance.**

### Cómo entrenar la descomposición
1. **Describe el problema en tus palabras.**
   * Qué se pide, qué se sabe, qué se debe producir.

2. **Identifica pasos lógicos.**
   * Divide en tareas independientes o secuenciales.

3. **Define funciones por subproblema.**
   * Cada función debe hacer una sola cosa (principio SRP de SOLID).

4. **Comprueba dependencias.**
   * ¿Un subproblema necesita otro? Define el orden correcto.

5. **Compón la solución.**
   * Ensambla los resultados parciales en un resultado final.

### Descomposición = Modularidad + Recursión + Claridad
**“*Descomponer bien un problema es ya la mitad de la solución*.”**

**En algoritmia, esto significa:**
* Reducir complejidad cognitiva.
* Mejorar reusabilidad.
* Facilitar el análisis y optimización.

**En software, significa:**
* Código limpio, mantenible y extensible.