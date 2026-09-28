# Imperativo
El paradigma imperativo es la forma más antigua y directa de programar. Le dices a la computadora **exactamente qué hacer, paso a paso, en qué orden**.

La palabra "imperativo" viene del latín *imperare* — **ordenar, mandar**.
```
Tú eres el comandante.
La computadora es el soldado.
Cada línea es una orden directa.
```
No describes qué quieres obtener. Describes el **proceso exacto para obtenerlo**.


## ¿Qué resuelve?
El problema de traducir un proceso humano a instrucciones ejecutables.

Cuando un humano piensa en cómo hacer algo, naturalmente piensa en pasos:
```
"Para hacer café:
  1. Pon agua en la cafetera
  2. Agrega el café molido
  3. Enciende la cafetera
  4. Espera 5 minutos
  5. Sirve en la taza"
```
El paradigma imperativo refleja exactamente esa forma de pensar. Es el paradigma más intuitivo porque mapea directamente con cómo los humanos resolvemos problemas.

## La esencia filosófica
```
DECLARATIVO:   QUÉ quieres
IMPERATIVO:    CÓMO lo obtienes

Declarativo:   "Dame todos los números pares"
Imperativo:    "Recorre la lista. Para cada elemento,
                verifica si es divisible entre 2.
                Si lo es, agrégalo a una nueva lista.
                Cuando termines, retorna esa lista."
```

## Los tres pilares del paradigma imperativo
Todo código imperativo se construye con tres estructuras. Sin excepción.
```
┌─────────────────────────────────────────┐
│         PARADIGMA IMPERATIVO            │
│                                         │
│  ┌─────────────┐                        │
│  │  SECUENCIA  │  pasos en orden        │
│  └─────────────┘                        │
│                                         │
│  ┌─────────────┐                        │
│  │  SELECCIÓN  │  decisiones (if/switch)│
│  └─────────────┘                        │
│                                         │
│  ┌─────────────┐                        │
│  │  ITERACIÓN  │  repetición (loops)    │
│  └─────────────┘                        │
└─────────────────────────────────────────┘
```
Con solo estos tres elementos puedes expresar **cualquier algoritmo computable**. Esto se llama el **Teorema de Böhm-Jacopini** (1966) y es uno de los fundamentos teóricos de la computación.

### Pilar 1 — Secuencia
Las instrucciones se ejecutan una tras otra, en el orden en que aparecen. El orden importa absolutamente.
```java
// Cada línea es una orden directa
int precio     = 100;          // Orden 1: crea precio con valor 100
double impuesto = precio * 0.19;  // Orden 2: calcula impuesto
double total   = precio + impuesto; // Orden 3: calcula total
System.out.println(total);    // Orden 4: muestra el resultado
// Output: 119.0
```
Cambia el orden y el programa se rompe:
```java
// Orden alterado — falla
System.out.println(total);    // ❌ total no existe aún
double total    = precio + impuesto;
double impuesto = precio * 0.19;
int precio      = 100;
```
La secuencia no es un detalle, es la estructura fundamental. El procesador ejecuta instrucciones en secuencia a nivel de hardware. El paradigma imperativo refleja eso directamente.

### Pilar 2 — Selección
Permite que el flujo tome caminos distintos según condiciones. Sin selección, todo programa haría siempre lo mismo.

* **`if / else if / else`**
```java
int temperatura = 28;

if (temperatura > 35) {
    System.out.println("Calor extremo");
} else if (temperatura > 25) {
    System.out.println("Calor moderado");   // ← este se ejecuta
} else if (temperatura > 15) {
    System.out.println("Temperatura agradable");
} else {
    System.out.println("Frío");
}
```
La computadora evalúa de arriba a abajo, entra al primer bloque cuya condición sea verdadera y salta el resto.

* **`switch` — selección por valor exacto**
```java
String dia = "LUNES";

switch (dia) {
    case "LUNES":
    case "MARTES":
    case "MIERCOLES":
    case "JUEVES":
    case "VIERNES":
        System.out.println("Día laborable");
        break;
    case "SABADO":
    case "DOMINGO":
        System.out.println("Fin de semana");
        break;
    default:
        System.out.println("Día inválido");
}
```

* **`switch expression` (Java 14+) — más limpio**
```java
String resultado = switch (dia) {
    case "LUNES", "MARTES", "MIERCOLES",
         "JUEVES", "VIERNES"          -> "Día laborable";
    case "SABADO", "DOMINGO"           -> "Fin de semana";
    default                            -> "Día inválido";
};
```

* **Operador ternario — selección en una línea**
```java
int edad = 20;
String acceso = edad >= 18 ? "Permitido" : "Denegado";
// equivale a:
// if (edad >= 18) acceso = "Permitido"; else acceso = "Denegado";
```

### Pilar 3 — Iteración
Permite repetir instrucciones sin copiar y pegar código. Sin iteración, procesar 1 millón de registros requeriría 1 millón de líneas.

* **`for` — cuando sabes cuántas veces iterar**
```java
// Estructura: inicialización ; condición ; actualización
for (int i = 0; i < 5; i++) {
    System.out.println("Iteración: " + i);
}
// Output: 0, 1, 2, 3, 4

// Iterar una colección con for-each
List<String> nombres = List.of("Ana", "Luis", "Carlos");
for (String nombre : nombres) {
    System.out.println("Hola, " + nombre);
}
```

* **`while` — cuando no sabes cuántas veces iterar**
```java
// Condición se evalúa ANTES de cada iteración
int intentos = 0;
int clave    = 1234;
int intento  = 0;

while (intento != clave) {
    System.out.print("Ingresa la clave: ");
    intento = scanner.nextInt();
    intentos++;
}
System.out.println("Correcto en " + intentos + " intentos");
```

* **`do-while` — cuando debes ejecutar al menos una vez**
```java
// Condición se evalúa DESPUÉS de cada iteración
int numero;

do {
    System.out.print("Ingresa un número positivo: ");
    numero = scanner.nextInt();
} while (numero <= 0);
// Garantiza que se pregunta al menos una vez
```
**Cuándo usar cada uno:**
* `for` -> número de iteraciones conocido recorrer arrays, rangos numéricos.
* `for-each` -> recorrer colecciones completas, cuando no necesitas el índice.
* `while` -> número de iteraciones desconocido, esperar una condición externa.
* `do-while` -> cuando debes ejecutar al menos una vez menús, validaciones de input.

### Estado mutable — el núcleo del imperativo
El paradigma imperativo se basa completamente en estado mutable: variables que cambian de valor a lo largo del programa.

```java
// El estado cambia con cada instrucción
int contador = 0;          // estado inicial: 0
contador = contador + 1;   // estado: 1
contador = contador + 1;   // estado: 2
contador = contador + 1;   // estado: 3
// el "contador" al final no es el mismo que al inicio
```

El programa es esencialmente una **secuencia de mutaciones de estado**. Cada instrucción transforma el estado actual en un nuevo estado.
```
Estado 0 ──► instrucción 1 ──► Estado 1
Estado 1 ──► instrucción 2 ──► Estado 2
Estado 2 ──► instrucción 3 ──► Estado 3

Estado N = resultado final
```

### Variables y asignación
En el paradigma imperativo las variables son contenedores de estado mutable, no variables matemáticas.
```java
// En matemáticas: x = x + 1 es absurdo (ningún número es igual a sí mismo + 1)
// En imperativo:  x = x + 1 significa "el nuevo valor de x es el viejo valor + 1"
int x = 5;
x = x + 1;   // x ahora es 6 — perfectamente válido
```
```java
// La asignación no es una ecuación, es una orden
//   "toma el valor de la derecha y guárdalo en la variable de la izquierda"

int a = 10;
int b = 20;
int temp;

// Intercambio de valores — clásico ejercicio imperativo
temp = a;    // temp = 10
a    = b;    // a    = 20
b    = temp; // b    = 10
// a y b intercambiaron valores
```

### Procedimientos y funciones
El imperativo puro trabaja con procedimientos — bloques de instrucciones con nombre que pueden reutilizarse. Son el mecanismo de abstracción básico del paradigma.
```java
// Procedimiento — ejecuta acciones, no retorna valor útil
static void imprimirSeparador(int longitud) {
    for (int i = 0; i < longitud; i++) {
        System.out.print("-");
    }
    System.out.println();
}

// Función — calcula y retorna un valor
static double calcularPromedio(int[] numeros) {
    int suma = 0;
    for (int n : numeros) {
        suma += n;
    }
    return (double) suma / numeros.length;
}

// Uso en secuencia
public static void main(String[] args) {
    int[] calificaciones = {85, 92, 78, 95, 88};

    imprimirSeparador(30);
    System.out.println("Promedio: " + calcularPromedio(calificaciones));
    imprimirSeparador(30);
}
```

## Algoritmos imperativos clásicos
El paradigma imperativo brilla en algoritmos donde el control explícito es necesario.

Búsqueda lineal
```java
static int buscarLineal(int[] arr, int objetivo) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == objetivo) {
            return i;    // retorna el índice donde lo encontró
        }
    }
    return -1;           // no encontrado
}
```