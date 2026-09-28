#Logic
# Conectores Lógicos
Los conectores lógicos (u operadores lógicos) permiten combinar proposiciones simples para formar proposiciones compuestas.

## Negación (`¬p` NOT)
**Invierte el valor de verdad.** 

La negación lógica es un operador que invierte el valor de verdad de una proposición, volviéndola falsa si era verdadera y verdadera si era falsa.

| p   | `¬p` |
| --- | ---- |
| V   | F    |
| F   | V    |
```
p = "Está lloviendo"
¬p = "NO está lloviendo"

p = "No está lloviendo"
¬p = "Está lloviendo"
```

## Conjunción (`p ∧ q` AND)
Verdadera solo si ambas son verdaderas.

Una conjunción matemática (también llamada «**y lógico**») es un operador que une dos proposiciones, formando una proposición compuesta que es verdadera solo si ambas proposiciones originales son verdaderas

| p   | q   | p ∧ q |
| --- | --- | ----- |
| V   | V   | V     |
| V   | F   | F     |
| F   | V   | F     |
| F   | F   | F     |
```
"Está lloviendo" AND "Tengo paraguas"
→ Solo verdadero si las DOS se cumplen
```

## Disyunción inclusiva — (`p ∨ q` OR)
Verdadera si al menos una es verdadera.

También llamada disyunción débil o lógica "`o`", es un conector lógico que afirma que al menos uno de los dos enunciados conectados es verdadero, e incluso que ambos puedan serlo. Esta disyunción es verdadera si uno de sus componentes es verdadero o si ambos lo son, y solo se vuelve falsa cuando los dos enunciados son falsos.

| p   | q   | p ∨ q |
| --- | --- | ----- |
| V   | V   | V     |
| V   | F   | V     |
| F   | V   | V     |
| F   | F   | F     |

## Disyunción exclusiva — (`p ⊕ q` XOR)
Verdadera si exactamente una es verdadera. No ambas.

La disyunción exclusiva (a menudo representada como `XOR` o `P ⊕ Q`) es un conector lógico que es verdadero únicamente cuando uno de sus componentes (proposiciones) es verdadero, pero el otro es falso. Es falsa si ambos componentes tienen el mismo valor de verdad (ambos verdaderos o ambos falsos).

| p   | q   | p ⊕ q |
| --- | --- | ----- |
| V   | V   | F     |
| V   | F   | V     |
| F   | V   | V     |
| F   | F   | F     |
```
"Ganó el equipo A" XOR "Ganó el equipo B"
→ En un partido solo puede ganar uno (o ninguno si empatan)
```

## Implicación — (`p → q` Si... entonces)
El caso más confuso. Falsa solo cuando p es verdadera y q es falsa.

Una implicación matemática (o declaración condicional) es una proposición que se lee como "si p, entonces q", y se representa como p ⇒ q. Se considera falsa únicamente cuando el antecedente (p) es verdadero y el consecuente (q) es falso; en todos los demás casos, es verdadera. Las implicaciones son fundamentales en la lógica y las matemáticas, ya que establecen una relación donde, si la hipótesis es cierta, la conclusión también debe serlo.

| p   | q   | p → q |
| --- | --- | ----- |
| V   | V   | V     |
| V   | F   | F     |
| F   | V   | V     |
| F   | F   | V     |
```
p = "Estudio"
q = "Apruebo"

p → q = "Si estudio, entonces apruebo"

¿Cuándo esta promesa se rompe?
→ Solo si estudié y NO aprobé. Ahí la implicación es Falsa.
Si no estudié, la promesa no se rompió (no dijiste qué pasa si no estudias)
```

## Doble implicación o Bicondicional (`p ↔ q` (Si y solo si))
Verdadera cuando ambas tienen el mismo valor.

También llamada equivalencia o bicondicional (simbolizada como `p ↔ q`), es una proposición lógica que es verdadera únicamente cuando ambas proposiciones (`p` y `q`) tienen el mismo valor de verdad; es decir, cuando ambas son verdaderas o ambas son falsas. Se lee como "`p` si y solo si `q`", y es equivalente a la conjunción de una implicación y su recíproca: **(`p ⇒ q`) `∧` (`q ⇒ p`)**. 

| p   | q   | p ↔ q |
| --- | --- | ----- |
| V   | V   | V     |
| V   | F   | F     |
| F   | V   | F     |
| F   | F   | V     |
```
"Apruebo si y solo si estudio"
→ Apruebo = Estudio (van juntos o no van)
```