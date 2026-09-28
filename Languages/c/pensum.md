
Toma el rol de un ingeniero de software senior, experto en los siguientes temas: Lógica de Programación, Pensamiento Algorítmico, Descomposición de problemas, Creación de algoritmos eficientes, Análisis de entradas y salidas.

la idea de es aprender los fundamentos de programación, el lenguage que usaremos sera C. 

Hablemos de los tipos de datos
¿que son? ¿cuales son? ¿que resuelven? ¿como lo resuelve? ¿como se utilizan? ¿cuando se utilizan? enseñame todo lo que debo saber
Hablemos de las variables
## pensum
## 
1. fundamentos
   * Memoria Heap y Stack.
   * Asignación estática vs. Asignación dinámica.
   * Punteros y manejo de memoria.
   * Variables locales, globales, y estáticas.
   * Scope (alcance) y lifetime (duración) de variables.

2. Tipos de Datos:

   * Tipos de datos primitivos (int, char, float, double).
   * Tipos de datos compuestos (structs, arrays, etc.).
   * Tipos de datos definidos por el usuario (typedef, enum).

3. Operadores:

   * Operadores aritméticos, lógicos, relacionales.
   * Operadores de bits (bitwise).
   * Operadores de incremento/decremento.
   * Operadores de asignación.

4. Control de Flujo:

   * Condicionales (if, else, switch).
   * Bucles (for, while, do-while).
   * Recursión (concepto de llamada a sí mismo).

## Lógica de Programación
Pensamiento Algorítmico:

Descomposición de problemas.
Creación de algoritmos eficientes.
Análisis de entradas y salidas.
Estructuras de Control:

Condiciones complejas.
Bucles anidados.
Manipulación de listas o arrays en bucles.
Recursión:

Base de la recursión.
Funciones recursivas (con ejemplos como factorial, Fibonacci).
Comparación entre recursión y bucles.

Estructuras de Datos Básicas:

Arrays.
Cadenas de texto (strings).
Matrices (arrays multidimensionales).

## Manejo de Funciones
Funciones en C:
Parámetros por valor y por referencia.
Funciones con y sin retorno.
Declaración y definición de funciones.
Stack de Funciones:
Pila de ejecución y gestión del contexto de funciones.
Paso de argumentos y variables locales en la pila.
Recursividad:
Casos base y recursivos.
Memoria en la recursividad (manejo de stack overflow).

## Punteros y Manejo de Memoria
Punteros:

Conceptos básicos de punteros.
Punteros a funciones.
Punteros dobles (punteros a punteros).
Asignación dinámica de memoria:

Uso de malloc(), calloc(), realloc(), free().
Errores comunes en manejo de memoria (fugas de memoria).
Arreglos y Punteros:

Relación entre arrays y punteros.
Arreglos dinámicos.

## Estructuras de Datos Avanzadas
Estructuras de datos lineales:

Listas enlazadas simples y dobles.
Pilas (stacks).
Colas (queues).
Estructuras de datos no lineales:

Árboles (árbol binario, AVL, B-Trees).
Grafos (búsqueda en profundidad, búsqueda en anchura).
Tablas Hash:

Concepto de hashing.
Implementación de tablas hash.
Resolución de colisiones (chaining, open addressing).

## Algoritmos Básicos y Avanzados
Algoritmos de Búsqueda:

Búsqueda lineal.
Búsqueda binaria.
Algoritmos de Ordenamiento:

Básicos: Burbuja, inserción, selección.
Avanzados: Merge Sort, Quick Sort, Heapsort.
Algoritmos Recursivos:

Backtracking.
Divide y vencerás.
Algoritmos de Optimización:

Algoritmos de programación dinámica (ej. Fibonacci con memoización).
Algoritmos de grafos (Dijkstra, A*).

## Programación Orientada a Objetos (OOP)
Conceptos de OOP:

Clases y objetos.
Herencia.
Encapsulamiento.
Polimorfismo.
Abstracción.
Diseño de clases:

Jerarquías de clases.
Modularización y reutilización de código.


## Temas Avanzados en Programación
* Concurrencia y Paralelismo:

  * Hilos (multithreading).

  * Sincronización (mutex, semáforos).

  * Programación asíncrona.

* Sistemas Distribuidos:

  * Comunicación entre procesos (IPC).
  * Sockets y redes.
  * RPC (Remote Procedure Call).

* Patrones de Diseño Avanzados:

  * Patrones arquitectónicos (Microservicios, CQRS).
  * Patrones de concurrencia (Productor-Consumidor).

##  Técnicas y Herramientas de Optimización
Optimización de código:

Optimización de memoria.
Optimización en tiempo de ejecución.
Uso de herramientas de perfilado (gprof, valgrind).
Compiladores y Ensamblador:

Proceso de compilación (preprocesador, compilador, ensamblador, enlazador).
Optimización a nivel de ensamblador.
Testing:

Pruebas unitarias (con bibliotecas como Google Test).
Pruebas de integración.
TDD (Desarrollo guiado por pruebas).


Antes de iniciar hablemos de esto:
```c
#include <stdio.h>
int main(int argc, char const *argv[])
{
  /* code */
  return 0;
}
```
¿que es?
¿que son esos parametros que recibe main?
¿que es return 0, para que se usa?

hablemos de las directivas o comandos de preprocesador, ¿que son? ¿cuales son? ¿que resuelven? ¿para que sirven? ¿cuando se usan?