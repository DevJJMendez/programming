#algorithms
# Complejidad Algoritmica 
La complejidad mide **cuánto crece el costo** (tiempo o memoria) de un algoritmo a medida que crece el tamaño de la entrada (`n`).

Es decir: ***“¿Qué tan rápido empeora tu algoritmo cuando aumentan los datos?”***

## Modelos de coste (cómo medimos el esfuerzo computacional)

Hay dos formas de analizar un algoritmo:

1. **Modelo empírico**
   * Mides el tiempo real de ejecución con un cronómetro (ej. `System.nanoTime()`).

     * Pros: refleja la realidad.
     * Contras: depende del **hardware, compilador, caché, SO** → no universal.

2. **Modelo teórico (RAM model)**
   * Asumimos:

     * Cada operación elemental (suma, resta, asignación, comparación, acceso a array) cuesta 1 unidad de tiempo.

     * Ignoramos el hardware y medimos el crecimiento relativo.

     * Este es el modelo que usamos para **Big O notation**.

## Tipos de complejidad
| **Tipo**     | **Qué mide**                  | **Ejemplo**                              |
| ------------ | ----------------------------- | ---------------------------------------- |
| `Temporal`   | Número de operaciones básicas | Lo que tardas                            |
| `Espacial`   | Memoria adicional requerida   | Lo que consumes                          |
| `Amortizada` | Promedio a largo plazo        | **Ej**: `ArrayList` crecimiento dinámico |

## Notaciones Asintóticas
Estas notaciones describen el crecimiento del costo cuando `n → ∞`.

| **Notación** | **Significado**               | **Ejemplo**                 |
| ------------ | ----------------------------- | --------------------------- |
| `O(f(n))`    | Cota superior (peor caso)     | QuickSort → O(n²) peor caso |
| `Ω(f(n))`    | Cota inferior (mejor caso)    | QuickSort → Ω(n log n)      |
| `Θ(f(n))`    | Cota ajustada (caso promedio) | MergeSort → Θ(n log n)      |

En la práctica, usamos `Big O (O(...))` casi siempre, porque queremos saber qué tan mal puede ir el algoritmo.

## Órdenes de crecimiento más comunes
| **Complejidad** | **Nombre**  | **Ejemplo**                  |
| --------------- | ----------- | ---------------------------- |
| `O(1)`          | Constante   | Acceso a array `arr[i]`      |
| `O(log n)`      | Logarítmica | Búsqueda binaria             |
| `O(n)`          | Lineal      | Recorrer lista               |
| `O(n log n)`    | Cuasilineal | **MergeSort**, **QuickSort** |
| `O(n²)`         | Cuadrática  | Doble bucle anidado          |
| `O(2ⁿ)`         | Exponencial | **Backtracking** sin poda    |
| `O(n!)`         | Factorial   | Permutaciones                |

Regla mental: cada vez que duplicas `n`, el tiempo se multiplica por un factor según su orden de crecimiento.

### Ejemplo
```java
public class ComplejidadEjemplo {

    // O(1): acceso directo
    public static int getFirst(int[] arr) {
        return arr[0];
    }

    // O(n): recorrido lineal
    public static int sum(int[] arr) {
        int suma = 0;
        for (int n : arr) {
            suma += n;
        }
        return suma;
    }

    // O(n²): bucle anidado
    public static void imprimirPares(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }
}
```
Análisis:
| Método          | Complejidad temporal | Complejidad espacial |
| --------------- | -------------------- | -------------------- |
| getFirst()      | O(1)                 | O(1)                 |
| sum()           | O(n)                 | O(1)                 |
| imprimirPares() | O(n²)                | O(1)                 |

## Cálculo formal de complejidad
Ejemplo
```java
int suma = 0;              // 1 operación
for (int i = 0; i < n; i++) { // n comparaciones + n asignaciones
    suma += i;             // n operaciones
}
System.out.println(suma);  // 1 operación
```
Total ≈ 1 + (n + n + n) + 1 = 3n + 2

Cuando n → ∞, 3n + 2 ≈ O(n)
(se eliminan constantes y términos no dominantes).

## Reglas de simplificación de Big O
Solo nos quedamos con el término dominante.

O(n³ + n²) → O(n³)

Las constantes no importan.

O(3n) → O(n)

Si hay operaciones secuenciales, se suman.

O(f(n)) + O(g(n)) = O(max(f, g))

4. Si hay operaciones anidadas, se multiplican.

O(f(n) * g(n))

## Tipos de análisis de caso
| Caso                    | Qué mide                         | Ejemplo                             |
| ----------------------- | -------------------------------- | ----------------------------------- |
| Peor caso (worst case)  | Límite máximo del tiempo         | Búsqueda de un elemento que no está |
| Mejor caso (best case)  | Límite inferior                  | Primer elemento ya es el buscado    |
| Promedio (average case) | Esperado con entradas aleatorias | Normalmente el que más interesa     |

En la práctica de ingeniería, optimizar el peor caso es clave en sistemas críticos.

---

# Complejidad Temporal
La complejidad temporal mide cuánto tiempo tarda un algoritmo en ejecutarse en función del tamaño de su entrada (`n`).

En otras palabras: No mide el tiempo real en segundos. **Mide cuántas operaciones básicas ejecuta el algoritmo según crece `n`.**

## Ejemplo intuitivo
Supongamos que tienes una lista con n elementos, y quieres sumar todos:
```java
public int sumar(int[] arr) {
    int suma = 0;
    for (int num : arr) {
        suma += num;
    }
    return suma;
}
```
El número de operaciones crece linealmente con n.
Si duplicas el tamaño del array, el tiempo se duplica.
Por eso decimos: O(n).

## ¿Para qué sirve?
* Evaluar eficiencia antes de implementar
Te permite comparar distintos algoritmos o estructuras sin probarlos físicamente.

Ejemplo:

Búsqueda lineal → O(n)

Búsqueda binaria → O(log n)
Entonces, ya sabes teóricamente que la binaria escalará mejor.

* Diseñar sistemas escalables
Cuando diseñas software que puede crecer (millones de usuarios, datos, etc.), la complejidad temporal te dice cuándo tu algoritmo dejará de ser viable.

Ejemplo:

O(n²) puede funcionar para 1000 elementos → bien.

Pero con 1,000,000 → colapsa (tiempo ≈ 10¹² operaciones).

O(n log n) escalará mucho mejor.

* Identificar cuellos de botella
Cuando un programa es lento, la complejidad temporal te dice dónde está el cuello de botella: si el problema es algorítmico, no de hardware.

## ¿Qué problema resuelve?
Resuelve la pregunta:
"¿Cuánto trabajo hace mi algoritmo a medida que aumenta el tamaño del problema?"

Sin este análisis:

No puedes comparar dos soluciones de manera objetiva.

No puedes garantizar que tu código escale.

No sabes si un cambio empeora o mejora el rendimiento.

## ¿Cómo lo resuelve?
La complejidad temporal lo resuelve modelando el costo de las operaciones.
En vez de medir segundos, mide operaciones básicas, bajo el modelo RAM (Random Access Machine):

* Supuestos del modelo RAM:
Cada operación elemental (suma, asignación, comparación, acceso) cuesta 1 unidad de tiempo.

No se considera el tiempo de E/S ni particularidades del hardware.

3. El tiempo total ≈ número total de operaciones elementales.

Entonces:

Tiempo total = f(n) → donde f(n) es una función que crece con el tamaño del input.

Y el análisis asintótico (Big O) se queda solo con la tendencia dominante de f(n) cuando n → ∞.

## Cómo se mide formalmente
Ejemplo:
```java
int suma = 0;                    // c1
for (int i = 0; i < n; i++) {    // c2 * n
    suma += i;                   // c3 * n
}
return suma;                     // c4
```
Total:
T(n) = c1 + c2n + c3n + c4 = (c2 + c3)n + (c1 + c4)

El término dominante → n
Constantes → irrelevantes
→ T(n) = O(n)

## Cómo clasificar la complejidad temporal

| Clase              | Notación   | Ejemplo                    | Intuición                       |
| ------------------ | ---------- | -------------------------- | ------------------------------- |
| Constante          | O(1)       | Acceso arr[i]              | No depende de n                 |
| Logarítmica        | O(log n)   | Búsqueda binaria           | Divide el problema a la mitad   |
| Lineal             | O(n)       | Recorrer lista             | Crece proporcionalmente         |
| Lineal-logarítmica | O(n log n) | MergeSort	Divide y combina |                                 |
| Cuadrática         | O(n²)      | Bucles anidados            | Se multiplica por n             |
| Cúbica             | O(n³)      | 3 bucles anidados          | Muy costoso                     |
| Exponencial        | O(2ⁿ)      | Backtracking               | Explosión combinatoria          |
| Factorial          | O(n!)      | Permutaciones              | Prácticamente imposible escalar |

## Tipos de casos analizados
| Tipo de caso  | Qué mide	Ejemplo                    |
| ------------- | ----------------------------------- |
| Mejor caso    | Tiempo mínimo posible               | Primer elemento encontrado  |
| Peor caso     | Tiempo máximo posible               | Elemento no encontrado      |
| Caso promedio | Tiempo esperado en entradas típicas | Normalmente el más realista |

Como ingeniero, casi siempre analizas el peor caso (O(...)), para garantizar rendimiento bajo carga.

## Reglas de composición de complejidad
| Estructura  | Regla	Ejemplo                    |
| ----------- | -------------------------------- | ---------------------------------- |
| Secuencia   | Se suman y se elige la dominante | O(n) + O(1) → O(n)                 |
| Anidamiento | Se multiplican                   | O(n) * O(n) → O(n²)                |
| Condicional | Toma el caso más costoso         | if con O(n) y O(1) → O(n)          |
| Recursión   | Se usa una recurrencia           | T(n) = 2T(n/2) + O(n) → O(n log n) |

---

# Complejidad Espacial
La complejidad espacial mide la cantidad de memoria adicional (RAM) que necesita un algoritmo para ejecutarse en función del tamaño de la entrada (n).

No mide el tamaño de los datos de entrada, sino el espacio extra que el algoritmo necesita para trabajar.

## Diferencia con la complejidad temporal
| Tipo     | Qué mide                         | Ejemplo                                     |
| -------- | -------------------------------- | ------------------------------------------- |
| Temporal | Cuánto tiempo tarda el algoritmo | Número de operaciones                       |
| Espacial | Cuánta memoria usa el algoritmo  | Número de variables, estructuras auxiliares |
￼
Ambas están relacionadas: muchas veces mejorar una empeora la otra (trade-off tiempo vs espacio).

## ¿Para qué sirve?
La complejidad espacial sirve para:

* Evaluar eficiencia en memoria
Determina si un algoritmo cabe en RAM o si va a consumir demasiada memoria (por ejemplo, en dispositivos limitados o sistemas concurrentes).

* Comparar algoritmos con igual complejidad temporal
Ejemplo: dos algoritmos O(n log n) en tiempo, pero uno usa O(1) espacio y el otro O(n).
➡️ Si ambos son rápidos, el segundo puede ser inviable por consumo de memoria.

* Detectar fugas o crecimiento no controlado de estructuras
Analizar la complejidad espacial ayuda a detectar patrones donde tu estructura crece más rápido de lo necesario (por ejemplo, arrays que se duplican indefinidamente, o recursión profunda sin control).

## ¿Qué problema resuelve?
Resuelve la pregunta:

“¿Cuánta memoria adicional necesita mi algoritmo para ejecutarse correctamente?”

Sin este análisis:

No sabes si tu algoritmo escala en memoria.

No puedes garantizar estabilidad bajo grandes volúmenes de datos.

No puedes optimizar estructuras que se replican o crean recursivamente.

## ¿Cómo se mide?
La complejidad espacial mide cuántas celdas de memoria (variables, estructuras, recursión, buffers, etc.) se usan en función de n.

Se suele expresar con Big O, igual que el tiempo.

## Componentes de la complejidad espacial
Se compone de tres partes principales:

| Tipo de espacio                | Qué es                                                 | Ejemplo                                 |
| ------------------------------ | ------------------------------------------------------ | --------------------------------------- |
| Espacio fijo (constante)       | Memoria para variables y punteros que no dependen de n | contadores, referencias                 |
| Espacio dependiente de entrada | Memoria para los datos de entrada                      | array, lista original                   |
| Espacio auxiliar (extra)       | Memoria que el algoritmo crea durante su ejecución     | estructuras temporales, recursion stack |

 La complejidad espacial mide el espacio auxiliar.
(El espacio de entrada no cuenta en el análisis asintótico).

## Ejemplos prácticos
* Ejemplo 1: Complejidad O(1)
```java
int sum(int[] arr) {
    int total = 0; // espacio constante
    for (int n : arr) {
        total += n;
    }
    return total;
}
```
Solo usa una variable auxiliar (total) → O(1) espacio adicional.

* Ejemplo 2: Complejidad O(n)
```java
int[] duplicar(int[] arr) {
    int[] resultado = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        resultado[i] = arr[i] * 2;
    }
    return resultado;
}
```
Crea un nuevo array del mismo tamaño que el de entrada → O(n) espacio adicional.

* Ejemplo 3: Complejidad O(log n)
```java
int binarySearch(int[] arr, int left, int right, int target) {
    if (left > right) return -1;
    int mid = (left + right) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] > target)
        return binarySearch(arr, left, mid - 1, target);
    else
        return binarySearch(arr, mid + 1, right, target);
}
```
Cada llamada recursiva agrega una capa al stack de llamadas.
➡️ Profundidad de recursión = O(log n)
➡️ Complejidad espacial = O(log n).

## Cómo analizar formalmente la complejidad espacial
1️⃣ Cuenta las variables primitivas y referencias fijas → O(1)
2️⃣ Cuenta las estructuras auxiliares creadas según n → O(f(n))
3️⃣ Incluye el stack de recursión (cada llamada ocupa espacio).
4️⃣ Ignora la entrada original, salvo si el algoritmo la copia.


Ejemplo
```java
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```
No crea estructuras auxiliares.

Pero usa recursión con profundidad n.
➡️ Complejidad espacial = O(n) (por stack frames).

## Trade-off Tiempo vs Espacio
Una de las habilidades clave de un ingeniero senior: balancear tiempo y espacio.

| Estrategia                    | Beneficio	Costo   |
| ----------------------------- | ----------------- | ---------------------------- |
| Usar cache/memoization        | Acelera tiempo    | Aumenta espacio              |
| Usar estructuras auxiliares   | Simplifica lógica | Más RAM                      |
| Reutilizar memoria (in-place) | Ahorra espacio    | Aumenta tiempo o complejidad |
| Recursión → Iteración         | Ahorra stack      | Código más complejo          |

Ejemplo clásico:

MergeSort: O(n log n) tiempo, O(n) espacio

QuickSort (in-place): O(n log n) tiempo, O(log n) espacio
👉 mismo rendimiento temporal, menor espacio.

## Categorías comunes de complejidad espacial
| Complejidad | Qué significa       | Ejemplo                                  |
| ----------- | ------------------- | ---------------------------------------- |
| O(1)        | Espacio constante   | Sumar elementos, invertir array in-place |
| O(log n)    | Espacio logarítmico | Recursión binaria                        |
| O(n)        | Espacio lineal      | Copiar array o lista                     |
| O(n²)       | Espacio cuadrático  | Matriz de adyacencia, DP bidimensional   |
| O(2ⁿ)       | Exponencial         | Backtracking sin poda                    |
| O(n!)       | Factorial           | Generar todas las permutaciones          |


## Ejemplo de comparación práctica
🧩 A. Invertir un array “in-place”
```java
void invertirInPlace(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++; j--;
    }
}
```
→ Espacio: O(1) (usa solo temp, i, j)
→ Tiempo: O(n)

B. Invertir creando un nuevo array
```java
int[] invertirNuevo(int[] arr) {
    int[] nuevo = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        nuevo[arr.length - 1 - i] = arr[i];
    }
    return nuevo;
}
```
→ Espacio: O(n) (nuevo array)
→ Tiempo: O(n)

Mismo tiempo, pero distinta eficiencia espacial.
En sistemas con mucha RAM, no importa;
en sistemas embebidos o intensivos, sí.

# Complejidad Amortizada