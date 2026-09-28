Un lenguaje de programación es un sistema formal de comunicación entre el humano y la máquina. Define un conjunto de reglas sintácticas y semánticas que permiten expresar instrucciones que una computadora puede eventualmente ejecutar.

No es solo "una forma de escribir código". Es un modelo de pensamiento. Cada lenguaje te obliga a pensar el problema de una manera distinta.

```
Lenguaje natural:   "suma todos los números pares de esta lista"
Lenguaje de programación:  reglas exactas, sin ambigüedad, ejecutables
Código máquina:     10110000 01100001 00000010...
```
El lenguaje de programación vive en el medio. Permite expresar ideas complejas con precisión ejecutable.

## ¿Qué resuelven?
La brecha de abstracción entre cómo piensa un humano y cómo opera el hardware:
```
Nivel 0 — Hardware:
  transistores, voltajes, señales eléctricas

Nivel 1 — Código máquina:
  10110000 01100001

Nivel 2 — Ensamblador:
  MOV AL, 61h

Nivel 3 — Lenguajes de bajo nivel (C):
  int x = 5;

Nivel 4 — Lenguajes de alto nivel (Java, Python):
  persona.calcularSalario()

Nivel 5 — Lenguajes de dominio específico (SQL):
  SELECT * FROM empleados WHERE salario > 5000
```
Cada nivel resuelve el problema de la abstracción añadiendo más distancia entre el programador y el hardware.

## La taxonomía completa
Los lenguajes se clasifican por múltiples dimensiones simultáneas. Un lenguaje no pertenece a una sola categoría, pertenece a varias al mismo tiempo.
```
Java es:
  → Alto nivel
  → Compilado (a bytecode)
  → Orientado a objetos
  → Estáticamente tipado
  → Fuertemente tipado
  → De propósito general
  → Imperativo
```
Entender estas dimensiones te permite elegir la herramienta correcta para cada problema.

## Dimensión 1: Nivel de Abstracción
### Lenguajes de Bajo Nivel
**Código Máquina** -> El único lenguaje que el procesador entiende directamente. Binario puro.
```
10110000 01100001
│        │
MOV      AL, 97   ← esto significa: mueve el valor 97 al registro AL
```

Ensamblador (Assembly)
Una capa mínima sobre código máquina. Cada instrucción ensambladora corresponde a exactamente una instrucción de máquina.
```assembly
section .data
    msg db "Hola", 0

section .text
    global _start
_start:
    mov eax, 4      ; syscall: write
    mov ebx, 1      ; stdout
    mov ecx, msg    ; dirección del mensaje
    mov edx, 4      ; longitud
    int 0x80        ; llamada al kernel
```
**Pros**:
✅ Control total de registros y memoria
✅ Máxima optimización posible
✅ Necesario para drivers y bootloaders

**Contras**:
❌ Extremadamente verboso
❌ Específico por arquitectura
❌ Sin abstracciones (no hay funciones, clases, etc.)

**Cuándo se usa hoy:**
→ Firmware de microcontroladores
→ Bootloaders (el código que arranca tu PC)
→ Partes críticas de sistemas operativos
→ Optimizaciones de rendimiento en criptografía
→ Ingeniería inversa y seguridad

### Lenguajes de Nivel Medio
**C** -> El "lenguaje portátil de bajo nivel". Suficiente abstracción para ser legible, suficiente control para tocar el hardware.
```c
#include <stdio.h>

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int suma = 0;

    for (int i = 0; i < 5; i++) {
        suma += arr[i];
    }

    printf("Suma: %d\n", suma);
    return 0;
}
```
**Pros**:
✅ Velocidad casi igual a ensamblador
✅ Portabilidad entre arquitecturas
✅ Control manual de memoria (malloc/free)
✅ Base de Linux, Windows, macOS, iOS, Android

**Contras**:
❌ Gestión manual de memoria → bugs difíciles
❌ Sin orientación a objetos nativa
❌ Buffer overflows, dangling pointers

**Cuándo se usa:**
→ Sistemas operativos (Linux kernel está en C)
→ Drivers de hardware
→ Sistemas embebidos
→ Base de intérpretes (CPython está en C)
→ Donde cada microsegundo importa

**C++** -> **C** con orientación a objetos y abstracciones de alto nivel, sin perder el control de bajo nivel.
```cpp
#include <iostream>
#include <vector>
#include <algorithm>

class Estudiante {
public:
    std::string nombre;
    double promedio;

    Estudiante(std::string n, double p) : nombre(n), promedio(p) {}
};

int main() {
    std::vector<Estudiante> estudiantes = {
        {"Ana", 9.5}, {"Luis", 8.2}, {"Carlos", 9.8}
    };

    std::sort(estudiantes.begin(), estudiantes.end(),
        [](const Estudiante& a, const Estudiante& b) {
            return a.promedio > b.promedio;
        });

    for (const auto& e : estudiantes) {
        std::cout << e.nombre << ": " << e.promedio << "\n";
    }
}
```
**Pros**:
✅ Rendimiento de **C** con abstracciones modernas
✅ Templates (genéricos poderosos)
✅ STL (librería estándar rica)
✅ Usado en motores de videojuegos, bases de datos

**Contras**:
❌ Extremadamente complejo
❌ Curva de aprendizaje brutal
❌ Gestión de memoria aún manual (aunque smart pointers ayudan)

**Cuándo se usa:**
→ Motores de videojuegos (Unreal Engine)
→ Bases de datos (MySQL, MongoDB internamente)
→ Navegadores (Chrome, Firefox)
→ Sistemas de trading de alta frecuencia
→ Simulaciones científicas

### Lenguajes de Alto Nivel
**Java** -> Diseñado para ser portable, seguro y orientado a objetos desde el inicio.
```java
import java.util.List;
import java.util.Comparator;

public class Main {
    record Estudiante(String nombre, double promedio) {}

    public static void main(String[] args) {
        List<Estudiante> estudiantes = List.of(
            new Estudiante("Ana", 9.5),
            new Estudiante("Luis", 8.2),
            new Estudiante("Carlos", 9.8)
        );

        estudiantes.stream()
            .sorted(Comparator.comparingDouble(
                Estudiante::promedio).reversed())
            .forEach(e ->
                System.out.println(e.nombre() + ": " + e.promedio()));
    }
}
```
**Pros**:
✅ Portabilidad total (JVM)
✅ Garbage Collector automático
✅ Ecosistema masivo
✅ Tipado estático fuerte
✅ Excelente para sistemas empresariales

**Contras**:
❌ Verboso
❌ Arranque lento (JVM warmup)
❌ Consumo de memoria mayor que C/C++

**Python** -> Prioriza legibilidad y productividad del desarrollador sobre velocidad de ejecución.
```py
from dataclasses import dataclass

@dataclass
class Estudiante:
    nombre: str
    promedio: float

estudiantes = [
    Estudiante("Ana", 9.5),
    Estudiante("Luis", 8.2),
    Estudiante("Carlos", 9.8)
]

ordenados = sorted(estudiantes,
                   key=lambda e: e.promedio,
                   reverse=True)

for e in ordenados:
    print(f"{e.nombre}: {e.promedio}")
```
**Pros:**
✅ Sintaxis extremadamente legible
✅ Productividad muy alta
✅ Ecosistema de ciencia de datos (NumPy, Pandas, TensorFlow)
✅ Scripting y automatización

**Contras:**
❌ Lento comparado con lenguajes compilados
❌ GIL limita paralelismo real
❌ Tipado dinámico → errores en runtime

## Dimensión 2: Paradigma de Programación
Un paradigma es una filosofía sobre cómo estructurar y pensar el código.

Paradigma Imperativo -> Le dices a la computadora cómo hacer algo, paso a paso.
```java
// Imperativo: instrucciones explícitas
List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);
List<Integer> pares = new ArrayList<>();

for (int n : numeros) {
    if (n % 2 == 0) {
        pares.add(n);
    }
}
```
Foco:    el CÓMO
Base:    instrucciones secuenciales
Estado:  mutable, cambia con cada instrucción

Paradigma Declarativo -> Le dices a la computadora qué quieres, no cómo obtenerlo.
```java
// Declarativo: describes el resultado deseado
List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);
List<Integer> pares = numeros.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
```
```sql
-- SQL es declarativo puro
SELECT * FROM numeros WHERE valor % 2 = 0
```
Foco:    el QUÉ
Base:    expresiones y transformaciones
Estado:  el motor decide cómo obtenerlo

Paradigma Orientado a Objetos (OOP) -> Organiza el código alrededor de objetos que combinan estado y comportamiento.
```java
public class CuentaBancaria {
    private double saldo;
    private String titular;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo   = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto > saldo) return false;
        saldo -= monto;
        return true;
    }

    public double getSaldo() { return saldo; }
}
```
Pilares:    Encapsulación, Herencia, Polimorfismo, Abstracción
Foco:       modelar el mundo real como objetos
Lenguajes:  Java, C++, C#, Python, Ruby, Kotlin

Paradigma Funcional -> Trata la computación como evaluación de funciones matemáticas. Evita el estado mutable y los efectos secundarios.
```java
// Java con estilo funcional
List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

int sumaDeCuadradosDePares = numeros.stream()
    .filter(n -> n % 2 == 0)        // filtrar pares
    .map(n -> n * n)                 // elevar al cuadrado
    .reduce(0, Integer::sum);        // sumar todo

System.out.println(sumaDeCuadradosDePares);  // 220
```
```haskell
-- Haskell: funcional puro
sumaDeCuadradosDePares = sum . map (^2) . filter even $ [1..10]
```
Principios:
  → Funciones puras (mismo input → mismo output siempre)
  → Inmutabilidad (los datos no cambian)
  → Sin efectos secundarios
  → Funciones como ciudadanos de primera clase

Ventajas:
  ✅ Código predecible y testeable
  ✅ Paralelización natural (sin estado compartido)
  ✅ Sin bugs de estado mutable

Lenguajes:  Haskell, Erlang, Clojure, F#
Influencia: Java Streams, Python map/filter, Kotlin

**Paradigma Lógico** -> Defines hechos y reglas, y el motor deduce las respuestas.
```prolog
% Prolog — paradigma lógico
padre(juan, carlos).
padre(carlos, ana).

abuelo(X, Z) :- padre(X, Y), padre(Y, Z).

% Pregunta: ¿quién es abuelo de ana?
?- abuelo(X, ana).
X = juan.
```
No dices cómo encontrar la respuesta.
Defines qué es verdad y el motor infiere.

Usado en:  IA simbólica, sistemas expertos,
           análisis de lenguaje natural


Paradigma Reactivo -> Programa orientado a flujos de datos y propagación de cambios.
```java
// RxJava — paradigma reactivo en Java
Observable.fromIterable(List.of(1, 2, 3, 4, 5))
    .filter(n -> n % 2 == 0)
    .map(n -> n * 10)
    .subscribe(
        valor -> System.out.println("Valor: " + valor),
        error -> System.err.println("Error: " + error),
        ()    -> System.out.println("Completado")
    );
```
Foco:    flujos de eventos asíncronos
Útil en: UIs, sistemas de tiempo real, microservicios
Libs:    RxJava, Project Reactor, RxJS

## Dimensión 3: Sistema de Tipos
Tipado Estático vs Dinámico

ESTÁTICO:
  Los tipos se verifican en COMPILACIÓN
  Debes declarar tipos explícitamente (o el compilador los infiere)

Java:    int x = 5;         // tipo declarado
Kotlin:  val x = 5          // tipo inferido, pero estático
C:       int x = 5;

DINÁMICO:
  Los tipos se verifican en RUNTIME
  Las variables pueden cambiar de tipo

  Python:  x = 5      # int
           x = "hola" # ahora es str, sin error
  JavaScript: let x = 5; x = "hola"; // válido

Tipado Fuerte vs Débil
FUERTE:
  No permite operaciones entre tipos incompatibles sin conversión explícita

  Python (fuerte):
    "5" + 5  →  TypeError ❌  (aunque es dinámico, es fuerte)

  Java (fuerte):
    String s = "5";
    int x = 5;
    s + x  →  "55"  (Java convierte x automáticamente, caso especial)

DÉBIL:
  Hace coerciones implícitas entre tipos

  JavaScript (débil):
    "5" + 5   →  "55"  (número convertido a string)
    "5" - 5   →  0     (string convertido a número)
    [] + {}   →  "[object Object]"  ← JavaScript siendo JavaScript

## Dimensión 4: Propósito
Lenguajes de Propósito General

Pueden resolver cualquier tipo de problema:

Java        → enterprise, Android, backend
Python      → ciencia de datos, web, scripting, IA
C/C++       → sistemas, juegos, embebidos
JavaScript  → web frontend, backend (Node.js), móvil
Kotlin      → Android, backend, multiplatform
Rust        → sistemas, WebAssembly, seguridad
Go          → microservicios, herramientas de red

Lenguajes de Dominio Específico (DSL)
Diseñados para un dominio particular. No son de propósito general pero son extremadamente expresivos en su área:
```sql
-- SQL: manipulación de datos relacionales
SELECT e.nombre, d.nombre AS departamento, AVG(e.salario)
FROM empleados e
JOIN departamentos d ON e.dept_id = d.id
GROUP BY e.nombre, d.nombre
HAVING AVG(e.salario) > 50000
ORDER BY AVG(e.salario) DESC;
```
```html
<!-- HTML: estructura de documentos web -->
<article>
  <h1>Título</h1>
  <p>Contenido del artículo</p>
</article>
```
```css
/* CSS: presentación visual */
.card {
    display: flex;
    background: linear-gradient(135deg, #667eea, #764ba2);
    border-radius: 12px;
}
```
```regex
/* Regex: patrones en texto */
^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$
/* valida un email */
```
```yaml
# YAML: configuración
services:
  database:
    image: postgres:15
    environment:
      POSTGRES_DB: myapp
      POSTGRES_PASSWORD: secret
```

## Dimensión 5: Gestión de Memoria
Manual
El programador controla completamente cuándo se asigna y libera memoria:
```c
// C — gestión manual
int* arr = malloc(10 * sizeof(int));   // asignar
arr[0] = 42;
free(arr);                             // liberar — si olvidas esto: memory leak
arr = NULL;                            // si no haces esto: dangling pointer
```
✅ Máximo control y rendimiento
❌ Memory leaks si olvidas free()
❌ Dangling pointers → crashes y vulnerabilidades
❌ Double free → comportamiento indefinido

Garbage Collector -> Un proceso automático detecta y libera memoria no utilizada:
```java
// Java — GC automático
Person p = new Person("Carlos");   // JVM asigna en heap
p = null;                          // objeto sin referencias
// GC lo elimina automáticamente en algún momento
```

Ownership (Rust) -> Un sistema de tipos que garantiza en compilación que no hay memory leaks ni data races:
```rust
fn main() {
    let s1 = String::from("hola");  // s1 es dueño de la memoria
    let s2 = s1;                    // ownership transferido a s2
    // println!("{}", s1);          // ❌ Error de compilación
                                    // s1 ya no es dueño
    println!("{}", s2);             // ✅ s2 es el dueño actual
}   // s2 sale de scope → memoria liberada automáticamente
    // sin GC, sin malloc/free manual
```
✅ Sin GC y sin gestión manual
✅ Garantías en tiempo de compilación
✅ Cero cost abstractions
❌ Curva de aprendizaje muy alta
❌ El borrow checker puede ser frustrante al inicio

### Los lenguajes más importantes hoy
```
┌─────────────┬──────────┬───────────┬──────────────────────────┐
│ Lenguaje    │ Paradigma│ Tipado    │ Casos de uso             │
├─────────────┼──────────┼───────────┼──────────────────────────┤
│ Java        │ OOP      │ Est/Fuerte│ Enterprise, Android      │
│ Python      │ Multi    │ Din/Fuerte│ IA, Data Science, web    │
│ JavaScript  │ Multi    │ Din/Débil │ Web, Node.js, móvil      │
│ TypeScript  │ Multi    │ Est/Fuerte│ Web tipado               │
│ Kotlin      │ Multi    │ Est/Fuerte│ Android, backend         │
│ Rust        │ Multi    │ Est/Fuerte│ Sistemas, WebAssembly    │
│ Go          │ Imp/Conc │ Est/Fuerte│ Microservicios, DevOps   │
│ C#          │ OOP      │ Est/Fuerte│ .NET, videojuegos Unity  │
│ Swift       │ Multi    │ Est/Fuerte│ iOS, macOS               │
│ SQL         │ Decl/DSL │ Est       │ Bases de datos           │
└─────────────┴──────────┴───────────┴──────────────────────────┘
```

### Cómo elegir un lenguaje
¿Aplicación enterprise o backend robusto?
  → Java, Kotlin, C#

¿Ciencia de datos, IA o Machine Learning?
  → Python

¿Frontend web?
  → JavaScript / TypeScript

¿Aplicaciones Android?
  → Kotlin (Java es legacy)

¿Aplicaciones iOS/macOS?
  → Swift

¿Máximo rendimiento, sistemas operativos?
  → C, C++, Rust

¿Microservicios simples y rápidos?
  → Go

¿Bases de datos?
  → SQL

---
[](Compilers.md)
[](Interpreter.md)
[](Transpiler.md)