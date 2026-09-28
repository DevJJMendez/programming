#Logic
# Tablas de Verdad
Son una herramienta que lista sistemáticamente todos los escenarios posibles de una expresión lógica y muestra el resultado en cada uno.

Son el equivalente a hacer una prueba exhaustiva de una condición, sin dejar ningún caso sin evaluar.

## ¿Qué resuelven?
El problema de la incertidumbre lógica. Sin ellas, ante una expresión como:
```
¿Es (p → q) ↔ (¬p ∨ q) siempre verdad?
¿O depende de los valores?
```
Tendrías que razonarlo en tu cabeza, con riesgo de error. La tabla lo responde mecánicamente, sin ambigüedad.

Resuelven tres cosas concretas:
```
1. Evaluar expresiones complejas en todos sus casos
2. Verificar equivalencias lógicas
3. Clasificar fórmulas (tautología, contradicción, contingencia)
```

## Estructura
Una tabla de verdad tiene tres zonas:
```
┌─────────────────┬──────────────────┬───────────────┐
│   PROPOSICIONES │  SUBEXPRESIONES  │   RESULTADO   │
│   ATÓMICAS      │  INTERMEDIAS     │   FINAL       │
│   p  │  q  │ r │ ¬p │ p∧q │ p∧q∨r │ expresión     │
└─────────────────┴──────────────────┴───────────────┘
```
* **Proposiciones atómicas** → las variables base
* **Subexpresiones intermedias** → pasos del cálculo
* **Resultado final** → la expresión completa

## Todo lo que debes saber
### 1. ¿Cuántas filas necesitas?
La fórmula es simple:
```
n proposiciones  →  2ⁿ filas

1 proposición  →  2¹ =  2 filas
2 proposiciones →  2² =  4 filas
3 proposiciones →  2³ =  8 filas
4 proposiciones →  2⁴ = 16 filas
5 proposiciones →  2⁵ = 32 filas
```
Cada proposición nueva duplica el tamaño de la tabla.

### 2. ¿Cómo llenar las columnas de proposiciones?
Hay un patrón mecánico, no lo inventes cada vez:
```
Última proposición   →  alterna cada 1:  V F V F V F V F
Penúltima            →  alterna cada 2:  V V F F V V F F
Antepenúltima        →  alterna cada 4:  V V V V F F F F
La anterior          →  alterna cada 8:  V V V V V V V V F F F F F F F F
```
Para 3 proposiciones (8 filas):
```
p | q | r
V | V | V
V | V | F
V | F | V
V | F | F
F | V | V
F | V | F
F | F | V
F | F | F
```
Nunca se repite ningunNunca se repite ninguna combinación, y están todas. Eso es lo que buscas.a combinación, y están todas. Eso es lo que buscas.

### Cómo construir una tabla paso a paso
Expresión: `¬p ∧ (q ∨ r)`

1. Paso 1 — Identifica las proposiciones atómicas
```
p, q, r  →  3 proposiciones  →  2³ = 8 filas
```

2. Paso 2 — Aplica el patrón para llenar proposiciones
```
p | q | r
V | V | V
V | V | F
V | F | V
V | F | F
F | V | V
F | V | F
F | F | V
F | F | F
```

3. Paso 3 — Agrega columnas por precedencia
Primero `¬p`, luego `q ∨ r`, finalmente `¬p ∧ (q ∨ r)`:
```
p | q | r | ¬p | q∨r | ¬p ∧ (q∨r)
V | V | V |  F |  V  |      F
V | V | F |  F |  V  |      F
V | F | V |  F |  V  |      F
V | F | F |  F |  F  |      F
F | V | V |  V |  V  |      V
F | V | F |  V |  V  |      V
F | F | V |  V |  V  |      V
F | F | F |  V |  F  |      F
```

4. Paso 4 — Lee el resultado
```
Mezcla de V y F  →  Contingencia
```

5. Verificar equivalencias lógicas
Dos expresiones son lógicamente equivalentes (`φ ≡ ψ`) si sus columnas de resultado son idénticas.

Verificando la equivalencia más importante:
```
p → q   ≡   ¬p ∨ q

p | q | p→q | ¬p | ¬p∨q
V | V |  V  |  F |  V    ← iguales
V | F |  F  |  F |  F    ← iguales
F | V |  V  |  V |  V    ← iguales
F | F |  V  |  V |  V    ← iguales
```
**Columnas idénticas → son equivalentes. ✅**: Esta equivalencia es crítica. En código no existe el operador `→`, así que cuando necesites modelar una implicación, usas `!p || q`.

### Tabla con implicación y bicondicional
Expresión: `(p → q) ↔ (¬p ∨ q)`
```
p | q | p→q | ¬p | ¬p∨q | (p→q)↔(¬p∨q)
V | V |  V  |  F |   V  |      V
V | F |  F  |  F |   F  |      V
F | V |  V  |  V |   V  |      V
F | F |  V  |  V |   V  |      V
```
Siempre V → Tautología. Confirma que `p → q` y `¬p ∨ q` son lo mismo.

### Tabla para verificar De Morgan
```
¬(p ∧ q)   ≡   ¬p ∨ ¬q

p | q | p∧q | ¬(p∧q) | ¬p | ¬q | ¬p∨¬q
V | V |  V  |    F   |  F |  F |   F     ← iguales
V | F |  F  |    V   |  F |  V |   V     ← iguales
F | V |  F  |    V   |  V |  F |   V     ← iguales
F | F |  F  |    V   |  V |  V |   V     ← iguales
```
Columnas idénticas → De Morgan verificado. ✅

### Errores comunes
```
❌ Error 1 — Olvidar filas
   Con 3 variables hacer 6 filas en vez de 8

❌ Error 2 — No seguir el patrón de alternancia
   Inventar el orden de V y F
   → Terminas con combinaciones repetidas o faltantes

❌ Error 3 — Saltar subexpresiones
   Ir directo al resultado sin columnas intermedias
   → Errores de cálculo en expresiones complejas

❌ Error 4 — Ignorar la precedencia
   Evaluar de izquierda a derecha sin respetar jerarquía
   → Resultado completamente incorrecto

❌ Error 5 — Confundir ∧ con ∨ bajo negación
   Escribir ¬(p ∧ q) = ¬p ∧ ¬q
   → Violación directa de De Morgan
```