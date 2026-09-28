# Interpretes
Un intérprete es un programa que lee, analiza y ejecuta código fuente directamente, línea a línea, sin producir un archivo ejecutable previo.

La diferencia fundamental con un compilador:
```
COMPILADOR:
Código fuente ──► [compilador] ──► ejecutable ──► ejecución
                  ocurre ANTES                   ocurre DESPUÉS
                  una sola vez                   sin compilador presente

INTÉRPRETE:
Código fuente ──► [intérprete] ──► ejecución
                  ocurre DURANTE
                  traducción y ejecución son simultáneas
                  el intérprete siempre debe estar presente
```

## ¿Qué resuelve?
El problema de la portabilidad y el ciclo de desarrollo:
```
Sin intérprete:   escribes → compilas → ejecutas → error → repites
Con intérprete:   escribes → ejecutas → error → repites
                  (elimina la fase de compilación del ciclo)
```
También resuelve la portabilidad: el mismo código Python corre en Windows, Linux y Mac sin recompilar, porque el intérprete instalado en cada sistema se encarga de la traducción.

## ¿Cómo funciona internamente?
Un intérprete no es una caja mágica. Internamente tiene las mismas fases frontales que un compilador, pero en lugar de generar código, ejecuta directamente:
```
Código fuente
      │
      ▼
┌─────────────┐
│   Lexer     │  tokeniza el texto
└──────┬──────┘
       │  tokens
       ▼
┌─────────────┐
│   Parser    │  construye el AST
└──────┬──────┘
       │  AST
       ▼
┌─────────────┐
│  Evaluador  │  recorre el AST y ejecuta cada nodo
│  (Evaluator)│  directamente, sin generar código
└──────┬──────┘
       │
       ▼
    Resultado
```
La diferencia clave está en el último paso. Un compilador generaría código a partir del AST. El intérprete camina el árbol y ejecuta.

## Todo lo que debes saber
### 1. El ciclo de ejecución línea a línea
```python
x = 10        # intérprete ejecuta esto
y = 20        # luego esto
z = x + y     # luego esto
print(z)      # luego esto → imprime 30
```
El intérprete no sabe qué viene después de cada línea hasta que llega a ella. Esto tiene consecuencias importantes:
```python
x = 10
print(x)        # imprime 10 ✅
print(y)        # ❌ NameError: y no está definida
y = 20          # esta línea nunca se alcanza
```
Un compilador hubiera detectado el problema de `y` **antes** de ejecutar. El intérprete lo descubre **en el momento** en que intenta ejecutar `print(y)`.

### 2. Tipos de intérpretes
**Intérprete de AST (Tree-Walking Interpreter)** -> El más simple conceptualmente. Construye el AST y lo recorre ejecutando cada nodo:
```
AST:
      Assign
     ┌──┴──┐
     x    Add
         ┌─┴─┐
         2   3

Evaluador recorre:
→ Nodo Assign
  → Evalúa lado derecho: Nodo Add
    → Evalúa hijo izquierdo: 2  → retorna 2
    → Evalúa hijo derecho:  3  → retorna 3
    → Suma: 2+3 → retorna 5
  → Asigna 5 a x
```
**Usado por:** primeras versiones de Ruby, algunos intérpretes de Lisp, intérpretes educativos.

**Intérprete de Bytecode** -> El más común en producción. Compila el código fuente a **bytecode interno** (no portable como el de Java, sino específico del intérprete) y luego ejecuta ese bytecode en una máquina virtual.
```
Código fuente (.py)
      │
      ▼
  [Compilador interno]
      │
      ▼
  Bytecode (.pyc)    ← se cachea en disco
      │
      ▼
  [Máquina Virtual]  ← ejecuta el bytecode
      │
      ▼
   Resultado
```
CPython (Python estándar):
```python
# Este código Python
x = 2 + 3

# Se convierte en bytecode (visible con dis module):
import dis
dis.dis("x = 2 + 3")

# Output:
#   LOAD_CONST   5    (2+3 ya optimizado a 5)
#   STORE_NAME   x
```
**Características:**
✅ Más rápido que tree-walking
✅ El bytecode se puede cachear (.pyc en Python)
✅ Portabilidad entre plataformas
❌ Más complejo de implementar
❌ Aún más lento que código nativo compilado

**Intérprete con JIT integrado** -> El más avanzado. Combina interpretación con compilación en caliente, igual que la JVM pero como parte del intérprete.
```
Código fuente
      │
      ▼
  Bytecode interno
      │
      ▼
  [VM + Monitor de ejecución]
      │
      ├── código "frío" ──► intérprete normal
      │
      └── código "caliente" ──► [JIT] ──► código nativo
                                           (cache + reuso)
```
**Ejemplos:**
PyPy      → Python con JIT     (5-50x más rápido que CPython)
LuaJIT    → Lua con JIT        (uno de los más rápidos)
V8        → JavaScript con JIT (motor de Chrome y Node.js)
SpiderMonkey → JavaScript      (motor de Firefox)

### **3. Intérpretes famosos y cómo funcionan**

#### **CPython — el intérprete de Python**
```
Arquitectura:
.py → [Lexer] → [Parser] → [AST] → [Compiler] → bytecode (.pyc)
                                                       │
                                                  [CPython VM]
                                                       │
                                                   ejecución

El GIL (Global Interpreter Lock):
→ CPython tiene un lock global
→ Solo un thread ejecuta bytecode Python a la vez
→ Limitación histórica de CPython
→ Python 3.13 trabaja en eliminarlo
```

#### **V8 — el intérprete/compilador de JavaScript**
```
JavaScript
    │
    ▼
  [Parser] → AST
    │
    ▼
  [Ignition]         ← intérprete de bytecode
  bytecode
    │
    ▼ (código "caliente")
  [TurboFan]         ← compilador JIT optimizador
  código nativo
    │
    ▼
  ejecución ultra rápida
```

V8 es la razón por la que JavaScript moderno es tan rápido. Es técnicamente un intérprete con JIT tan agresivo que en la práctica se comporta casi como un compilador nativo.

#### **JRuby — Ruby sobre la JVM**
```
Ruby (.rb)
    │
    ▼
  [JRuby Parser]
    │
    ▼
  JVM Bytecode
    │
    ▼
  [JVM + JIT]
    │
    ▼
  código nativo
```
Ejemplo de cómo una lenguaje interpretado puede ganar velocidad al correr sobre una VM con JIT maduro.

## Tabla de símbolos y scope en intérpretes
El intérprete mantiene una tabla de símbolos en memoria que mapea nombres a valores. El scope determina qué tabla consulta en cada momento:
```python
x = 10          # tabla global: {x: 10}

def funcion():
    y = 20      # tabla local: {y: 20}
    print(x)    # no está en tabla local → busca en global → 10 ✅
    print(y)    # está en tabla local → 20 ✅

funcion()
print(y)        # no está en global → NameError ❌
```
Representación interna:
```
GLOBAL SCOPE
┌────────────────────┐
│  x → 10           │
│  funcion → <func>  │
└────────────────────┘
        │
        │ (funcion() se ejecuta)
        ▼
LOCAL SCOPE (funcion)
┌────────────────────┐
│  y → 20            │
└────────────────────┘
  (al terminar funcion, este scope se destruye)
```
La cadena de búsqueda en Python sigue la regla **LEGB**: Local → Enclosing → Global → Built-in

## Evaluación lazy vs eager
Eager (inmediata) — la mayoría de intérpretes:
```python
x = calcular_algo()   # se evalúa AHORA, aunque x no se use después
```

**Lazy (diferida) — Haskell, y estructuras específicas:**
```
x = calcular_algo()   # se guarda la "promesa" de calcular
                      # solo se ejecuta cuando x se usa realmente
```
En Python puedes simular lazy evaluation con generadores:
```
# Eager — crea toda la lista en memoria
numeros = [x * 2 for x in range(1000000)]   # 1M elementos en RAM

# Lazy — genera valores solo cuando se piden
numeros = (x * 2 for x in range(1000000))   # generador, casi 0 RAM
```

---

### **6. REPL — el intérprete interactivo**

REPL significa **Read, Eval, Print, Loop**. Es la interfaz interactiva que usan la mayoría de lenguajes interpretados:
```
Read:   lee una expresión del usuario
Eval:   evalúa la expresión
Print:  imprime el resultado
Loop:   vuelve al inicio

>>> x = 5        ← Read
>>> x + 3        ← Read
8                ← Eval + Print
>>>              ← Loop
```
El REPL es posible gracias a la naturaleza del intérprete: no necesita un programa completo para ejecutar, puede evaluar expresiones individuales.

Un compilador no puede ofrecer esto fácilmente porque necesita el programa completo para compilar.

## Errores en intérpretes vs compiladores
Esta diferencia es crítica para el desarrollo:
```python
# Python (interpretado)
def funcion_con_error():
    x = 10
    y = "hola"
    return x + y    # TypeError: solo se detecta al LLAMAR la función

funcion_con_error()   # ❌ TypeError aquí en runtime
```
```java
// Java (compilado)
public int funcionConError() {
    int x = 10;
    String y = "hola";
    return x + y;    // ❌ Error de compilación ANTES de ejecutar
}
```
Intérprete:
  → Errores de tipo en runtime
  → Puedes tener código roto sin saberlo
  → Solo falla cuando esa línea se ejecuta
  → Necesitas tests que cubran todos los caminos

Compilador:
  → Errores de tipo en compilación
  → No puedes ejecutar código inválido
  → El compilador es tu primera línea de defensa

## Intérpretes en Java — el patrón Interpreter
Java usa intérprete internamente (JVM interpreta bytecode), pero también existe el patrón de diseño Interpreter para construir mini-lenguajes dentro de tu código:
```java
// Ejemplo: intérprete de expresiones matemáticas simples
interface Expression {
    int interpret();
}

class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

class Add implements Expression {
    private Expression left;
    private Expression right;

    public Add(Expression left, Expression right) {
        this.left  = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Multiply implements Expression {
    private Expression left;
    private Expression right;

    public Multiply(Expression left, Expression right) {
        this.left  = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

// Uso: representa (2 + 3) * 4
public class Main {
    public static void main(String[] args) {
        Expression expr = new Multiply(
            new Add(new Number(2), new Number(3)),
            new Number(4)
        );

        System.out.println(expr.interpret());  // 20
    }
}
```
Esto construye el mismo AST que construiría un intérprete real, pero con objetos Java.

## Intérprete vs Compilador — la tabla definitiva
```
┌──────────────────┬───────────────────────┬────────────────────────┐
│ Característica   │ INTÉRPRETE            │ COMPILADOR             │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Cuándo traduce   │ En tiempo de          │ Antes de ejecutar      │
│                  │ ejecución             │                        │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Produce          │ Nada (ejecuta         │ Ejecutable o bytecode  │
│                  │ directamente)         │                        │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Velocidad        │ Más lento             │ Más rápido             │
│                  │ (traduce siempre)     │ (ya traducido)         │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Inicio           │ Inmediato             │ Requiere compilar      │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Errores de tipo  │ Runtime               │ Compilación            │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Portabilidad     │ Alta (el intérprete   │ Baja (binario          │
│                  │ se encarga)           │ específico por OS/arch)│
├──────────────────┼───────────────────────┼────────────────────────┤
│ Debugging        │ Más fácil             │ Más difícil            │
├──────────────────┼───────────────────────┼────────────────────────┤
│ REPL             │ ✅ Natural            │ ❌ Complejo            │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Optimización     │ Limitada              │ Agresiva               │
├──────────────────┼───────────────────────┼────────────────────────┤
│ Ejemplos         │ Python, Ruby,         │ GCC, javac,            │
│                  │ PHP, Bash             │ rustc, clang           │
└──────────────────┴───────────────────────┴────────────────────────┘
```
### **10. La realidad moderna — la línea se borró**

En 2024 la distinción pura ya casi no existe:
```
Python:     intérprete + bytecode interno + PyPy con JIT
JavaScript: V8 con JIT tan agresivo que es casi AOT
Java:       compilado a bytecode + JIT en runtime
PHP 8:      JIT integrado desde PHP 8.0
Ruby 3:     YJIT (Yet Another JIT) integrado
```

La pregunta ya no es "¿compilado o interpretado?" sino **¿en qué punto del pipeline ocurre la traducción a código nativo?**