#Logic
# Lógica Proposicional
Es un sistema formal para representar y razonar sobre afirmaciones que pueden ser verdaderas o falsas. Nada más, nada menos.

Una proposición es cualquier afirmación con valor de verdad definido:
```text
"Java es un lenguaje orientado a objetos"  → Verdadero
"2 + 2 = 5"                                → Falso
"¿Qué hora es?"                            → ❌ No es proposición (pregunta)
"Haz esto"                                 → ❌ No es proposición (orden)
```

## ¿Qué resuelve?
El problema de razonar sin ambigüedad.

El lenguaje natural es impreciso:
```text
"Si no llueve, salgo... pero si tengo trabajo, tampoco salgo"
```
¿Qué pasa exactamente si no llueve y tengo trabajo? En lenguaje natural, ambiguo. En lógica proposicional, exacto.

Las computadoras toman decisiones basadas en **condiciones**. La lógica proposicional es el fundamento de todo eso: **`if`, `while`, `switch`, validaciones, flujos de control.**

## ¿Cómo lo resuelve?
Convierte el lenguaje natural en símbolos y operadores que se pueden evaluar mecánicamente.

# Proposiciones
Una proposición es un enunciado declarativo que puede ser **verdadero (`V`)** o **falso (`F`)**, pero nunca ambos al mismo tiempo.

* **`p`: "Llueve"**
* **`q`: "Llevo paraguas"**

**`p`** y **`q`** representan proposiciones simples que pueden ser verdaderas o falsas, Sirven como variables para construir proposiciones compuestas y analizar sus valores de verdad mediante operadores lógicos como la **conjunción (`y`), la disyunción (`o`), la implicación (si... entonces), y el bicondicional (si y solo si).** 

* Ejemplos:
  * `"2 + 2 = 4" → V.`

  * **"Hoy es lunes"** → depende del día, pero siempre será `V` o `F`.

  * **"El cielo es azul"** → `V` (contexto normal).

* No son proposiciones:
  * **"¿Qué hora es?"** → no afirma nada.
  * `"x + 2 > 5"` → depende de `x` (esto entra en lógica de predicados, no proposicional).

* En programación, cada proposición se representa como una expresión booleana (`true` o `false`).

## Proposiciones atómicas
Son las unidades básicas, se representan con letras:
```
p = "Está lloviendo"
q = "Tengo paraguas"
r = "Llego mojado"
```



# Operadores Lógicos
Un operador lógico es un símbolo o palabra que se utiliza para conectar dos o más expresiones de modo que el valor de la expresión compuesta producida dependa únicamente del de las expresiones originales y del significado del operador. Los operadores lógicos comunes incluyen `AND`, `OR` y `NOT`.

## Precedencia (Jerarquia) de Operadores Lógicos
Igual que en matemáticas `2 + 3 × 4` no es `20` sino `14`, en lógica el orden cambia completamente el resultado.

Sin precedencia, una expresión como:
```
¬p ∧ q ∨ r → s ↔ t
```
Sería ambigua. La precedencia dice qué se evalúa primero.

### La jerarquía completa
```
Prioridad 1 (MAYOR)  →   ¬   (NOT / Negación)
Prioridad 2          →   ∧   (AND / Conjunción)
Prioridad 3          →   ∨   (OR  / Disyunción)
Prioridad 4          →   →   (Implicación)
Prioridad 5 (MENOR)  →   ↔   (Bicondicional)
```
Regla mnemotécnica: "No And Or Implies Both" Not → And → Or → Implies → Biconditional

Ejemplos:
1. Prioridad 1 — **`¬` (NOT)** -> Se aplica inmediatamente sobre lo que tiene a la derecha.
```
Expresión:   ¬p ∧ q

Se evalúa:   (¬p) ∧ q     ← NOT se aplica solo sobre p, no sobre todo
NO es:       ¬(p ∧ q)     ← eso sería diferente
```
Tabla de verdad para verlo claro:
```
p | q | ¬p | (¬p) ∧ q | ¬(p ∧ q)
V | V |  F |     F    |    F
V | F |  F |     F    |    V     ← aquí difieren
F | V |  V |     V    |    V
F | F |  V |     F    |    V     ← aquí difieren
```
Son expresiones distintas. El paréntesis importa.

2. Prioridad 2 — **`∧` (AND)** -> Se evalúa antes que OR, implicación y bicondicional.
```
Expresión:   p ∨ q ∧ r

Se evalúa:   p ∨ (q ∧ r)     ← AND va primero
NO es:       (p ∨ q) ∧ r
```
Ejemplo concreto con valores:
```
p = F,  q = V,  r = V

Correcto:   F ∨ (V ∧ V)  =  F ∨ V  =  V
Incorrecto: (F ∨ V) ∧ V  =  V ∧ V  =  V   ← aquí coinciden

p = F,  q = V,  r = F

Correcto:   F ∨ (V ∧ F)  =  F ∨ F  =  F
Incorrecto: (F ∨ V) ∧ F  =  V ∧ F  =  F   ← aquí también

p = F,  q = F,  r = V

Correcto:   F ∨ (F ∧ V)  =  F ∨ F  =  F
Incorrecto: (F ∨ F) ∧ V  =  F ∧ V  =  F
```
Para ver la diferencia real:
```
p = V,  q = F,  r = V

Correcto:   V ∨ (F ∧ V)  =  V ∨ F  =  V
Incorrecto: (V ∨ F) ∧ V  =  V ∧ V  =  V

p = F,  q = V,  r = F

Correcto:   F ∨ (V ∧ F)  =  F ∨ F  =  F
Incorrecto: (F ∨ V) ∧ F  =  V ∧ F  =  F
```
El caso donde claramente difieren:
```
p = V,  q = V,  r = F

Correcto:   V ∨ (V ∧ F)  =  V ∨ F  =  V
Incorrecto: (V ∨ V) ∧ F  =  V ∧ F  =  F   ✅ diferencia clara
```

3. Prioridad 3 — **`∨` (OR)** -> Se evalúa antes que implicación y bicondicional, pero después de AND.
```
Expresión:   p ∧ q ∨ r → s

Se evalúa:   ((p ∧ q) ∨ r) → s
```
Paso a paso:
```
p = V,  q = F,  r = V,  s = F

Paso 1 (AND):    p ∧ q        =  V ∧ F  =  F
Paso 2 (OR):     F ∨ r        =  F ∨ V  =  V
Paso 3 (→):      V → s        =  V → F  =  F
```

4. Prioridad 4 — **`→` (Implicación)** -> Se evalúa antes que el bicondicional, después de todo lo demás.
```
Expresión:   p → q ↔ r

Se evalúa:   (p → q) ↔ r     ← implicación va primero
```
Ejemplo:
```
p = V,  q = F,  r = F

Paso 1 (→):   p → q   =  V → F  =  F
Paso 2 (↔):   F ↔ r   =  F ↔ F  =  V
```

Versus si fuera al revés (con paréntesis):
```
p → (q ↔ r)

Paso 1 (↔):   q ↔ r   =  F ↔ F  =  V
Paso 2 (→):   p → V   =  V → V  =  V
```
Mismo resultado aquí, pero con otros valores cambia. La estructura importa.

5. Prioridad 5 — **`↔` (Bicondicional)** -> El último en evaluarse. Todo lo demás ya fue resuelto.
```
Expresión:   ¬p ∧ q → r ↔ p ∨ s

Se evalúa así, paso a paso:

1. ¬p                    (NOT primero)
2. (¬p) ∧ q              (AND)
3. p ∨ s                 (OR)
4. ((¬p) ∧ q) → r        (Implicación)
5. (((¬p) ∧ q) → r) ↔ (p ∨ s)   (Bicondicional, al final)
```

Cómo leer una expresión compleja — método práctico -> Ante ¬p ∧ q ∨ r → s ↔ t, aplica esto:
```
Paso 1: Resuelve todas las ¬
        (¬p) ∧ q ∨ r → s ↔ t

Paso 2: Agrupa todos los ∧
        ((¬p) ∧ q) ∨ r → s ↔ t

Paso 3: Agrupa todos los ∨
        (((¬p) ∧ q) ∨ r) → s ↔ t

Paso 4: Agrupa la →
        ((((¬p) ∧ q) ∨ r) → s) ↔ t

Paso 5: El ↔ envuelve todo
        ((((¬p) ∧ q) ∨ r) → s) ↔ t   ✅ expresión completamente parentizada
```
