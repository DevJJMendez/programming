#memory
```
STACK  →  una torre de bandejas en una cafetería
           solo puedes agregar o quitar por arriba
           ordenado, predecible, rápido

HEAP   →  un estacionamiento enorme
           puedes parquear en cualquier espacio libre
           flexible, grande, pero necesitas administración
```

# Stack
Una región de memoria contigua, ordenada y de tamaño predefinido que la JVM asigna en el momento en que se lanza el programa. Su estructura interna sigue el principio **LIFO (Last In, First Out)**.

No es solo "donde viven variables locales". Es el motor de ejecución del programa. Sin stack no hay ejecución, no hay llamadas a métodos, no hay retornos.

## Estructura interna del Stack
El stack está compuesto por Stack Frames. Cada llamada a un método genera exactamente un frame. Cada frame tiene su propia estructura interna:

```
┌─────────────────────────────────────────┐
│              STACK FRAME                │
├─────────────────────────────────────────┤
│  Local Variable Array                   │
│  ┌────┬────┬────┬────┬────┐             │
│  │ 0  │ 1  │ 2  │ 3  │...│              │
│  │this│ x  │ y  │ z  │   │              │
│  └────┴────┴────┴────┴────┘             │
├─────────────────────────────────────────┤
│  Operand Stack                          │
│  (pila temporal para operaciones)       │
├─────────────────────────────────────────┤
│  Frame Data                             │
│  - referencia al pool de constantes     │
│  - dirección de retorno                 │
│  - referencia al frame anterior         │
└─────────────────────────────────────────┘
```
1. **Local Variable Array** Contiene todas las variables locales del método indexadas por posición. El índice `0` en métodos de instancia siempre es `this`.

2. **Operand Stack** Una pila interna donde la JVM realiza operaciones aritméticas y lógicas temporales. Es donde ocurre el cálculo real antes de asignar a una variable.

3. **Frame Data Metadatos del frame**: referencia al **Constant Pool** de la clase, dirección de retorno para saber adónde volver cuando el método termine, y referencia al frame anterior.

## Ciclo de vida de un Stack Frame
```java
public class Calculadora {

    public static void main(String[] args) {       // Frame 1
        int a = 10;
        int b = 20;
        int resultado = sumar(a, b);               // invoca Frame 2
        System.out.println(resultado);
    }

    public static int sumar(int x, int y) {        // Frame 2
        int total = x + y;
        return total;                              // Frame 2 destruido
    }
}
```
**Evolución del stack paso a paso:**
```
PASO 1: JVM inicia, main() se apila
━━━━━━━━━━━━━━━━━━━━━
│  Frame: main()      │  ← tope
│  args = (ref)       │
│  a = ?              │
│  b = ?              │
│  resultado = ?      │
━━━━━━━━━━━━━━━━━━━━━


PASO 2: Se asignan a y b
━━━━━━━━━━━━━━━━━━━━━
│  Frame: main()      │  ← tope
│  args = (ref)       │
│  a = 10             │
│  b = 20             │
│  resultado = ?      │
━━━━━━━━━━━━━━━━━━━━━


PASO 3: sumar() es invocado, se apila su frame
━━━━━━━━━━━━━━━━━━━━━
│  Frame: sumar()     │  ← tope
│  x = 10             │
│  y = 20             │
│  total = ?          │
├─────────────────────┤
│  Frame: main()      │
│  args = (ref)       │
│  a = 10             │
│  b = 20             │
│  resultado = ?      │
━━━━━━━━━━━━━━━━━━━━━


PASO 4: total es calculado
━━━━━━━━━━━━━━━━━━━━━
│  Frame: sumar()     │  ← tope
│  x = 10             │
│  y = 20             │
│  total = 30         │
├─────────────────────┤
│  Frame: main()      │
│  args = (ref)       │
│  a = 10             │
│  b = 20             │
│  resultado = ?      │
━━━━━━━━━━━━━━━━━━━━━


PASO 5: sumar() retorna 30, su frame es destruido
━━━━━━━━━━━━━━━━━━━━━
│  Frame: main()      │  ← tope
│  args = (ref)       │
│  a = 10             │
│  b = 20             │
│  resultado = 30     │  ← valor retornado asignado
━━━━━━━━━━━━━━━━━━━━━


PASO 6: main() termina, stack vacío
━━━━━━━━━━━━━━━━━━━━━
│  (vacío)            │
━━━━━━━━━━━━━━━━━━━━━
```
### Stack con herencia y polimorfismo
```java
public class Animal {
    public void hacerSonido() {         // Frame: Animal.hacerSonido()
        String sonido = obtenerSonido();
    }

    public String obtenerSonido() {     // Frame: Animal.obtenerSonido()
        return "...";
    }
}

public class Perro extends Animal {
    @Override
    public String obtenerSonido() {     // Frame: Perro.obtenerSonido()
        return "Guau";
    }
}
```
Cuando ejecutas:
```java
Animal a = new Perro();
a.hacerSonido();
```
Stack:
```
━━━━━━━━━━━━━━━━━━━━━━━━━━
│ Frame: Perro.obtenerSonido() │  ← polimorfismo
├──────────────────────────────┤
│ Frame: Animal.hacerSonido()  │
├──────────────────────────────┤
│ Frame: main()                │
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```
El stack refleja exactamente qué método real se está ejecutando, no el tipo de la referencia.

### Stack y Recursividad
Cada llamada recursiva apila un nuevo frame. Si no hay condición de parada, el stack se llena:
```java
public static int factorial(int n) {
    if (n == 0) return 1;          // condición de parada
    return n * factorial(n - 1);   // llamada recursiva
}

factorial(4);
```
```
━━━━━━━━━━━━━━━━━━━━
│ factorial(0)      │  ← tope, retorna 1
├───────────────────┤
│ factorial(1)      │  espera resultado de factorial(0)
├───────────────────┤
│ factorial(2)      │  espera resultado de factorial(1)
├───────────────────┤
│ factorial(3)      │  espera resultado de factorial(2)
├───────────────────┤
│ factorial(4)      │  espera resultado de factorial(3)
├───────────────────┤
│ main()            │
━━━━━━━━━━━━━━━━━━━━
```
Luego los frames se van destruyendo de arriba hacia abajo:
```java
factorial(0) retorna 1
factorial(1) retorna 1×1 = 1
factorial(2) retorna 2×1 = 2
factorial(3) retorna 3×2 = 6
factorial(4) retorna 4×6 = 24
```

### Características técnicas del Stack
1. Tamaño default en JVM:
  * 512KB a 1MB por thread (depende del OS y JVM)
  * Configurable con: java -Xss2m MiPrograma

2. Velocidad:
  * O(1) para push y pop
  * Acceso directo por offset de memoria
  * Localidad de caché excelente (memoria contigua)

1. Thread safety:
   * Cada thread tiene SU PROPIO stack
   * No se comparte entre threads
   * No necesita sincronización

# Heap