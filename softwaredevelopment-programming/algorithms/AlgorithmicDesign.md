#AlgorithmicThinking
# Diseño Algorítmico
El Diseño Algorítmico es el proceso sistemático de **planificar y construir un conjunto ordenado de pasos (algoritmo)** para resolver un problema, **usando principios de eficiencia, claridad y generalización.**

**En otras palabras**: Es convertir una idea abstracta en un procedimiento concreto, estructurado y computable.

**Intuición**: Cuando un ingeniero diseña un algoritmo, no piensa directamente en código, sino en cómo organizar la lógica para resolver el problema de la mejor forma posible. **No es “cómo lo escribo”, sino “cómo lo pienso”.**

**Ejemplo**:
* **Problema**: Encontrar el número más grande en un arreglo.
  * Diseño algorítmico:
    * Inicia con el primer número como máximo.

    * Recorre el arreglo.

    * Si encuentras un número mayor, actualiza el máximo.

    * Devuelve el máximo.

  * Simple, pero estructurado. Eso es diseñar un algoritmo.

## ¿Para qué sirve el Diseño Algorítmico?
| Propósito                                   | Descripción                                                                     |
| ------------------------------------------- | ------------------------------------------------------------------------------- |
| Convertir ideas en soluciones computables   | Permite pasar del razonamiento abstracto a un conjunto de pasos ejecutables.    |
| Optimizar recursos                          | Busca minimizar tiempo (complejidad temporal) y memoria (complejidad espacial). |
| Garantizar corrección                       | El algoritmo debe producir el resultado esperado en todos los casos.            |
| Aumentar escalabilidad                      | Diseños eficientes se adaptan a datos grandes.                                  |
| Facilitar la implementación y mantenimiento | Un diseño claro se traduce en código limpio y modular.                          |

## ¿Qué resuelve?
Resuelve el problema de la formalización: **Tienes una idea de solución, pero no sabes cómo estructurarla paso a paso.**

El diseño algorítmico transforma el razonamiento intuitivo en una secuencia lógica y computable que la máquina puede ejecutar.

## Estructura del Diseño Algorítmico
El diseño de algoritmos no se hace al azar — sigue una estructura mental clara que combina las fases previas:

Estructura general:
| Fase                           | Descripción                                                      |
| ------------------------------ | ---------------------------------------------------------------- |
| 1. Comprensión del problema    | Analizar el problema, restricciones, entradas y salidas.         |
| 1. Descomposición              | Dividir el problema en subproblemas manejables.                  |
| 2. Reconocimiento de patrones  | Identificar estructuras o estrategias que ya conoces.            |
| 3. Abstracción                 | Centrarte en lo esencial, dejando de lado detalles irrelevantes. |
| 4. Diseño de la solución       | Construir la secuencia lógica de pasos.                          |
| 5. Análisis de eficiencia      | Evaluar complejidad temporal y espacial.                         |
| 6. Refinamiento / Optimización | Mejorar el diseño inicial eliminando redundancias.               |
| 7. Implementación              | Traducir el diseño en código limpio y modular.                   |

Esquema mental:
```markdown
1️⃣ Entiende → 2️⃣ Divide → 3️⃣ Reconoce → 4️⃣ Abstrae → 5️⃣ Diseña → 6️⃣ Optimiza → 7️⃣ Implementa
```

## Cómo se implementa un diseño algorítmico en la práctica
1. Paso 1: Especifica el problema
   * Define entradas, salidas y restricciones (por ejemplo, límites de tamaño de datos).

2. Paso 2: Modela el problema
   * Representa la información con estructuras adecuadas (arrays, listas, grafos...).

3. Paso 3: Elige la estrategia de diseño
   * Divide & Conquer, DP, Greedy, Backtracking, etc.

4. Paso 4: Crea un pseudocódigo
   * Antes de codificar, expresa el algoritmo en pasos lógicos.

5. Paso 5: Analiza complejidad
   * Evalúa tiempo y espacio.

6. Paso 6: Implementa en código limpio
   * Usa funciones pequeñas, nombres claros, y evita redundancia.

7. Paso 7: Prueba y refina
   * Asegúrate de que funcione con casos normales y límites extremos.