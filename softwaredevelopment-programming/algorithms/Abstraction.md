#AlgorithmicThinking
# Abstracción
La abstracción es el proceso de **identificar los elementos esenciales** de un problema y eliminar los detalles irrelevantes, para centrarse solo en lo que realmente importa para diseñar la solución.

**En otras palabras**: Es ignorar lo que no afecta al resultado y resumir lo que sí importa de forma más general y reutilizable.

**Intuición**: Cuando diseñas un algoritmo, **no piensas en los detalles concretos de los datos** (si es una lista de usuarios o de números), sino en la estructura y las **operaciones necesarias (recorrer, buscar, comparar, ordenar)**.

**Ejemplo**: Si tu algoritmo necesita recorrer elementos secuencialmente, no te importa si es un `ArrayList`, una `LinkedList`, o un `Queue`. Lo que te importa es: “Puedo acceder a los elementos uno a uno”.

Eso es pensar en términos abstractos.

## ¿Para qué sirve la Abstracción?
La abstracción sirve para **simplificar el pensamiento, reducir la complejidad y mejorar la reutilización del código.**

| Propósito                                  | Descripción                                                       |
| ------------------------------------------ | ----------------------------------------------------------------- |
| Simplificar problemas complejos            | Permite enfocarte solo en lo esencial del problema.               |
| Reutilizar código y conocimiento           | Diseñas soluciones más generales y aplicables en otros contextos. |
| Diseñar mejores interfaces                 | Define qué hace algo sin importar cómo lo hace.                   |
| Aumentar la escalabilidad y mantenibilidad | Menos dependencia de los detalles concretos del sistema.          |
| Mejorar la comunicación entre ingenieros   | Hablas en términos de conceptos, no implementaciones.             |

## ¿Qué resuelve?
Resuelve el problema de la complejidad cognitiva.

**`Sin abstracción, cada problema parece diferente, cada solución parece nueva, y tu cerebro se satura con detalles innecesarios.`**

La abstracción permite **crear modelos mentales y de código más simples**, para que te concentres en el **“qué”** antes que en el **“cómo”**.

## Estructura de la Abstracción
Podemos dividir la abstracción en cuatro niveles progresivos, tanto mental como en diseño de software:

| Nivel                    | En algoritmia                                   | En ingeniería de software            |
| ------------------------ | ----------------------------------------------- | ------------------------------------ |
| **Datos**                | Identificar qué datos son relevantes.           | Tipos de datos, estructuras.         |
| **Operaciones**          | Qué operaciones son necesarias sobre los datos. | Métodos, funciones.                  |
| **Relaciones**           | Cómo interactúan los datos y operaciones.       | Diseño de clases, dependencias.      |
| **Modelos / Interfaces** | Qué interfaz general representa al sistema.     | Abstracciones, interfaces, patrones. |

* **Estructura mental del proceso**
  1. Identificar los datos esenciales.
     * ¿Qué información realmente importa para resolver el problema?

  2. Eliminar los detalles irrelevantes.
     * ¿Qué parte del problema no influye en la solución?

  3. Definir las operaciones necesarias.
     * ¿Qué necesito hacer con esos datos?

  4. Crear un modelo general.
     * ¿Puedo representar este conjunto de datos y operaciones de forma genérica?

5. Expresarlo con una interfaz clara.
   * ¿Cómo se usaría esta abstracción en código?

## Ejemplo: Abstracción en acción (conceptual)
* Problema concreto: **“Tengo una lista de productos y quiero encontrar el más caro.”**

* **Sin abstracción:**
  * Piensas en:
    * Cómo está almacenada la lista.
    * Cómo recorrerla.
    * Cómo comparar precios.
    * Cómo devolver el resultado.
    * Mucho detalle = mucho ruido.

* **Con abstracción:**
  * Piensas en:
    * “Tengo una colección de elementos. Quiero el máximo según una propiedad.”
      * Ahí descubres el patrón general: “buscar el máximo”.
      * **Ya no importa si son productos, enteros o temperaturas. Importa el modelo abstracto del problema.**

Ejemplo en código Java
```java
public static <T extends Comparable<T>> T findMax(List<T> items) {
    T max = items.get(0);
    for (T item : items) {
        if (item.compareTo(max) > 0) {
            max = item;
        }
    }
    return max;
}
```
**Este método no depende del tipo de dato concreto, solo de que los elementos sean comparables.**

Eso es abstracción aplicada:
* Ignoramos los detalles específicos.
* Creamos una función genérica que puede servir para cualquier tipo.

## Tipos de Abstracción
1. **Abstracción de datos**
   * Oculta los detalles de cómo se almacenan los datos, mostrando solo las operaciones posibles.

   * Ejemplo:
   ```java
   List<Integer> numbers = new ArrayList<>();
   numbers.add(5);
   numbers.add(10);
   ```
   * No sabes cómo se almacena internamente (array dinámico, nodos, etc.), solo que puedes agregar y acceder a elementos

2. Abstracción funcional
   * Te enfocas en qué hace una función, no cómo lo hace.
   
   * Ejemplo:
   ```java
   Collections.sort(list);
   ```
   * No importa si usa QuickSort o MergeSort internamente; solo importa que “ordena la lista”.

3. Abstracción de control
   * Representa el flujo del programa sin entrar en los detalles de control.

   * Ejemplo:
   ```java
   list.forEach(System.out::println);
   ```
   * No ves los `for` ni los **índices**; te concentras en la acción abstracta: **“Para cada elemento, imprime su valor.**

4. Abstracción por interfaz (en diseño OO)
   * Define un contrato general, sin importar la implementación.
   
   * Ejemplo:
   ```java
   interface PaymentProcessor {
      void process(double amount);
   }
   ```
   * No importa si se paga con tarjeta, PayPal o criptomonedas. Cada clase implementa el mismo contrato abstracto.

## ¿Cómo se implementa la abstracción (paso a paso)?
1. Paso 1: Analiza el problema y elimina lo superficial
   * Ejemplo:
     * “Quiero calcular la media de edades de usuarios.”

   * Abstracción:
     * “Necesito sumar valores y dividir entre su cantidad.”

2. Paso 2: Encuentra el patrón común
   * “Esto es un cálculo de promedio.”
     * Generalizable a cualquier lista de números.

3. Paso 3: Generaliza la solución
   ```java
   public static double average(List<Integer> list) {
      return list.stream()
                  .mapToInt(Integer::intValue)
                  .average()
                  .orElse(0.0);
   }
   ```

4. Paso 4: Crea una interfaz más genérica si es necesario
   ```java
   public interface Aggregator<T> {
      T aggregate(List<T> items);
   }
   ```
Luego puedes implementar `AverageAggregator`, `SumAggregator`, etc.


5. Paso 5: Encapsula los detalles
   * El usuario del método no necesita saber cómo se calcula.
     * Solo usa la abstracción.