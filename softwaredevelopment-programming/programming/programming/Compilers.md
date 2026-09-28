# Compiladores
Un compilador es un programa que traduce código fuente escrito en un lenguaje de alto nivel a otro lenguaje, generalmente de menor nivel, que la máquina puede ejecutar.

No es solo un "traductor". Es un pipeline complejo que analiza, verifica, optimiza y transforma tu código en múltiples etapas antes de producir una salida ejecutable.
```
Código fuente          Compilador           Salida
(lo que escribes)  ───────────────►  (lo que ejecuta la máquina)
     Main.java                            Main.class / Main.exe
```

## ¿Qué resuelve?
El problema fundamental de la brecha entre el pensamiento humano y el hardware:
```
Humano piensa:   "suma estos dos números"
CPU entiende:    10110000 01100001 00000010 ...

El compilador cierra esa brecha.
```
Sin compiladores escribirías en ensamblador o directamente en binario. Todo lenguaje moderno existe gracias a que existe un compilador que lo traduce.

## La gran distinción: Compilación vs Interpretación
Antes de los tipos, necesitas entender esta diferencia porque define todo lo demás:
```
COMPILACIÓN:
Código fuente → [compilador] → ejecutable
                    │
              ocurre UNA VEZ
              antes de ejecutar

INTERPRETACIÓN:
Código fuente → [intérprete] → ejecución
                    │
              ocurre LÍNEA A LÍNEA
              durante la ejecución

Compilado:    más rápido en ejecución, menos flexible
Interpretado: más lento en ejecución, más flexible y portable
```

## Las fases internas de un compilador
Un compilador no es una caja negra. Tiene un pipeline de fases bien definidas. Entenderlas te hace mejor desarrollador porque sabes exactamente dónde y por qué tu código falla.
```
Código fuente
      │
      ▼
┌─────────────────┐
│  ANÁLISIS       │  Front-end
│  LÉXICO         │  (entiende el texto)
└────────┬────────┘
         │  tokens
         ▼
┌─────────────────┐
│  ANÁLISIS       │
│  SINTÁCTICO     │  (entiende la estructura)
└────────┬────────┘
         │  AST
         ▼
┌─────────────────┐
│  ANÁLISIS       │
│  SEMÁNTICO      │  (entiende el significado)
└────────┬────────┘
         │  AST anotado
         ▼
┌─────────────────┐
│  GENERACIÓN     │  Middle-end
│  CÓDIGO         │  (traduce)
│  INTERMEDIO     │
└────────┬────────┘
         │  IR (Intermediate Representation)
         ▼
┌─────────────────┐
│  OPTIMIZACIÓN   │  (mejora el código)
└────────┬────────┘
         │  IR optimizado
         ▼
┌─────────────────┐
│  GENERACIÓN     │  Back-end
│  CÓDIGO         │  (produce la salida)
│  FINAL          │
└────────┬────────┘
         │
         ▼
   Código objeto / bytecode / ejecutable
```

### Fase 1 — Análisis Léxico (Lexer / Scanner)
Convierte el texto plano del código en tokens. Un token es la unidad mínima con significado.
```
int resultado = a + b * 2;

El lexer lo convierte en:
Token(KEYWORD,    "int")
Token(IDENTIFIER, "resultado")
Token(OPERATOR,   "=")
Token(IDENTIFIER, "a")
Token(OPERATOR,   "+")
Token(IDENTIFIER, "b")
Token(OPERATOR,   "*")
Token(NUMBER,     "2")
Token(SEMICOLON,  ";")
```
El lexer también elimina espacios, saltos de línea y comentarios. Para el compilador no existen.

Error en esta fase:
```java
int result@do = 5;  // '@' no es un token válido en Java
                    // → Error léxico
```

### Fase 2 — Análisis Sintáctico (Parser)
Toma los tokens y construye un AST (Abstract Syntax Tree) — un árbol que representa la estructura gramatical del programa.
```
int resultado = a + b * 2;
```

AST resultante:
         AssignmentExpr
        ┌──────┴──────┐
   Variable          BinaryExpr (+)
 "resultado"        ┌──────┴──────┐
                Variable       BinaryExpr (*)
                  "a"          ┌──────┴──────┐
                            Variable       Literal
                              "b"            2
```
El árbol refleja la precedencia de operadores. La multiplicación está más profunda porque se evalúa primero.

Error en esta fase:
```java
int resultado = a + * 2;  // '+' seguido de '*' no es gramaticalmente válido
                           // → Error sintáctico
```

### Fase 3 — Análisis Semántico
Verifica que el código tiene sentido lógico, no solo estructura correcta. Aquí vive la tabla de símbolos y el type checking.
```
int resultado = "hola" + 5;  // sintácticamente válido
                              // semánticamente inválido en Java
                              // → Error semántico: tipos incompatibles

resultado = otraVariable;     // ¿existe otraVariable? ¿está en scope?
                              // si no → Error semántico: variable no declarada
```
**Lo que verifica:**
→ Tipos compatibles en operaciones
→ Variables declaradas antes de usarse
→ Métodos llamados con los parámetros correctos
→ Acceso a miembros de clase correctos
→ Return types correctos

### Fase 4 — Generación de Código Intermedio (IR)
Produce una representación intermedia independiente del hardware. No es código fuente ni código máquina, es algo en el medio.
```
int resultado = a + b * 2;

En IR (Three Address Code):
```
t1 = b * 2
t2 = a + t1
resultado = t2
```
El IR es independiente del procesador. Esto permite que un mismo compilador produzca código para x86, ARM, MIPS, etc., cambiando solo el back-end.

### Fase 5 — Optimización
El compilador mejora el IR sin cambiar el comportamiento del programa. Es donde ocurre la magia de rendimiento.

* Constant Folding:
```java
int x = 2 * 3 * 10;
// El compilador lo reemplaza por:
int x = 60;
// No hay multiplicaciones en tiempo de ejecución
```
* Dead Code Elimination:
```java
int x = 5;
if (false) {
    x = 10;   // nunca ejecuta → el compilador lo elimina
}
```
* Inlining:
```java
// Código original
int doble(int x) { return x * 2; }
int resultado = doble(5);

// Después del inlining
int resultado = 5 * 2;   // el llamado al método desaparece
```
* Loop Unrolling:
```java
// Original
for (int i = 0; i < 4; i++) {
    arr[i] = i;
}

// Unrolled (evita el overhead del loop)
arr[0] = 0;
arr[1] = 1;
arr[2] = 2;
arr[3] = 3;
```

### Fase 6 — Generación de Código Final
Transforma el IR optimizado en código de la arquitectura objetivo: código máquina, bytecode o código ensambla
```
IR:              t1 = b * 2

x86 Assembly:    mov eax, [b]
                 imul eax, 2
                 mov [t1], eax

JVM Bytecode:    iload_2      (cargar b)
                 iconst_2     (constante 2)
                 imul         (multiplicar)
                 istore_3     (guardar en t1)
```

## Tipos de Compiladores
1. Compilador Nativo (AOT — Ahead of Time) -> Traduce el código fuente directamente a **código máquina** específico para el procesador y sistema operativo objetivo. El resultado es un ejecutable binario.
```
Código fuente (.c / .cpp / .rs)
          │
    [Compilador AOT]
          │
    Ejecutable binario
    (.exe en Windows / sin extensión en Linux)
          │
    CPU lo ejecuta directamente
```
**Características:**
✅ Máxima velocidad de ejecución
✅ No necesita runtime adicional
✅ El código máquina está listo antes de ejecutar
❌ No portable (compilas para una arquitectura específica)
❌ Compilación lenta para proyectos grandes

**Ejemplos:**
GCC    → compila C y C++   → Linux/Windows/Mac
Clang  → compila C y C++   → multiplataforma
rustc  → compila Rust       → multiplataforma
gfortran → compila Fortran

```
# Ejemplo con GCC
gcc main.c -o main        # compila
./main                    # ejecuta el binario directamente
```

1. Compilador a Bytecode (Java / JVM) -> Traduce el código fuente a un **código intermedio portable** llamado bytecode. No es código máquina virtual.
```
Código fuente (.java)
          │
   [javac — compilador]
          │
     Bytecode (.class)
          │
   [JVM — intérprete/JIT]
          │
    Ejecución en cualquier OS
```
**Características:**
✅ Portable: "Write Once, Run Anywhere"
✅ Verificable: la JVM valida el bytecode antes de ejecutar
✅ Seguro: no accede directamente al hardware
❌ Necesita JVM instalada
❌ Más lento que nativo (aunque el JIT reduce esta diferencia)

El bytecode de `int x = 2 + 3`:
iconst_2    // apila el 2
iconst_3    // apila el 3
iadd        // suma los dos valores del tope
istore_1    // guarda en variable local 1

3. Compilador JIT (Just in Time) -> No es un compilador standalone, es parte del runtime. Compila **bytecode a código máquina nativo en tiempo de ejecución**, solo para el código que realmente se ejecuta frecuentemente.
```
Bytecode (.class)
          │
    [JVM inicia]
          │
    ┌─────▼──────────────────────────────┐
    │  Intérprete ejecuta bytecode       │
    │  JIT monitorea qué código es       │
    │  "hot" (ejecutado frecuentemente)  │
    └─────┬──────────────────────────────┘
          │  código "hot" detectado
          ▼
    [JIT Compiler]
    compila ese bytecode a código nativo
          │
          ▼
    Código nativo en cache
    (velocidad casi igual a AOT)
```
**El proceso de calentamiento (warmup):**
```
Ejecución 1-100:      intérprete (lento)
Ejecución 100-10000:  JIT compila (overhead de compilación)
Ejecución 10000+:     código nativo en cache (muy rápido)
```
Por eso los servidores Java son lentos al iniciar pero muy rápidos después de "calentar".

**Niveles de compilación JIT en HotSpot JVM:**
```
Nivel 0:  Interpretado puro
Nivel 1:  Compilación C1 simple (rápida, sin optimización profunda)
Nivel 2:  Compilación C1 con contadores
Nivel 3:  Compilación C1 completa
Nivel 4:  Compilación C2 (optimización agresiva, más lenta de compilar)
```

4. Transpilador (Source to Source)** -> Traduce código de **un lenguaje de alto nivel a otro lenguaje de alto nivel**. También llamado compilador fuente a fuente.
```
TypeScript (.ts)
      │
 [Transpilador]
      │
JavaScript (.js)
```
```
Kotlin (.kt)
      │
 [Transpilador]
      │
JavaScript (.js)    ← Kotlin/JS
```

**Casos de uso:**
```
TypeScript  → JavaScript    (type safety para web)
Sass/Less   → CSS           (preprocesadores de estilos)
Kotlin      → JavaScript    (Kotlin Multiplatform)
CoffeeScript → JavaScript   (sintaxis más limpia)
Babel       → JavaScript    (ES6+ a ES5 para compatibilidad)
```

5. Intérprete -> Técnicamente no es un compilador, pero siempre se estudian juntos porque son las dos caras de la misma moneda.
```
Código fuente
      │
 [Intérprete]
      │
 Lee línea por línea
 Ejecuta inmediatamente
 Sin producir ejecutable
```
✅ Inicio inmediato (no hay fase de compilación)
✅ Más fácil de depurar (errores en tiempo real)
✅ Flexible (puede modificar código mientras corre)
❌ Más lento (traduce en cada ejecución)
❌ Errores de tipo solo se detectan al ejecutar esa línea

**Ejemplos:**
```
Python    → CPython interpreta .py
Ruby      → MRI Ruby
PHP       → Zend Engine
Bash      → interpreta scripts línea a línea
```

6. Compilador de Optimización (Ejemplo: GraalVM) -> Un compilador que puede funcionar en múltiples modos y aplica optimizaciones avanzadas entre lenguajes.
```
raalVM:
  Java, Kotlin, Scala, Groovy
  JavaScript, Python, Ruby, R
  C, C++, Rust (via LLVM)
          │
   [GraalVM Compiler]
          │
  ┌───────┴───────┐
  │               │
JIT mode      AOT mode (Native Image)
(runtime)     (ejecutable nativo)
```
GraalVM Native Image elimina el problema de warmup de Java:
```
java -jar app.jar        → startup: ~2 segundos  (JIT tradicional)
./app (native image)     → startup: ~10ms         (AOT via GraalVM)
```

## El caso Java — los tres compiladores en uno

Java es único porque usa **tres mecanismos en capas**:
```
Main.java
    │
    ▼ javac (AOT a bytecode)
Main.class  (bytecode portable)
    │
    ▼ JVM Intérprete (primeras ejecuciones)
    │
    ▼ JIT C1 (código "tibio" — optimización rápida)
    │
    ▼ JIT C2 (código "caliente" — optimización agresiva)
    │
    ▼ Código máquina nativo en cache
```
```
javac   →  compilador AOT parcial (a bytecode, no a nativo)
JVM     →  intérprete de bytecode
JIT     →  compilador en runtime (bytecode → nativo)
```

## Compiladores y su relación con los errores

Ahora entiendes exactamente qué tipo de error viene de qué fase:
```
Error léxico:     símbolo inválido (@, #fuera de contexto)
                  → Lexer

Error sintáctico: estructura inválida (falta ; o {})
                  → Parser

Error semántico:  tipo incorrecto, variable no declarada
                  → Análisis semántico

Error en runtime: NullPointerException, StackOverflow
                  → Errores que el compilador no puede detectar
                    (dependen de los datos en ejecución)
```
En Java específicamente
```java
// Error léxico
int x@ = 5;       // '@' no es válido → javac falla en lexer

// Error sintáctico
int x = ;         // falta expresión → javac falla en parser

// Error semántico
int x = "hola";   // tipo incompatible → javac falla en semántico

// Error de runtime (compilador no lo detecta)
String s = null;
s.length();       // NullPointerException → solo ocurre al ejecutar
```