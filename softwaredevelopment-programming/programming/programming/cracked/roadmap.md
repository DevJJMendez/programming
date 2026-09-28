# Roadmap: De cero a Cracked Dev
# Fase 1 — Fundamentos del pensamiento computacional
Antes de escribir código, tienes que pensar como una computadora.

* Lógica proposicional y booleana
* Diagramas de flujo (representar problemas visualmente)
* Pseudocódigo
* Sistemas numéricos (binario, hexadecimal)
* Cómo funciona la memoria (stack vs heap)

# Estructuras de Datos
Aquí empieza el juego real.

* Arrays y Strings
* Listas enlazadas (simple, doble, circular)
* Pilas (Stack) y Colas (Queue)
* Árboles (BST, AVL, árboles N-arios)
* Grafos (representación con matriz y lista de adyacencia)
* Tablas hash (HashMap internamente)
* Heaps / Priority Queue

# Algoritmia
El núcleo de ser cracked.

* Complejidad temporal y espacial (notación Big-O)
* Búsqueda lineal y binaria
* Ordenamiento: Bubble, Selection, Insertion, Merge Sort, Quick Sort
* Recursividad profunda y backtracking
* Two pointers y sliding window
* Divide y vencerás
* Programación dinámica (memoization y tabulation)
* Algoritmos sobre grafos: BFS, DFS, Dijkstra, Floyd-Warshall
* Algoritmos greedy

# Clean Code
Saber resolver problemas no es suficiente, hay que escribir código que otros (y tú en 6 meses) puedan leer.

* Naming: variables, funciones, clases con intención
* Funciones pequeñas y con una sola responsabilidad
* Comentarios: cuándo sí y cuándo no
* Evitar código muerto y duplicado
* Refactoring continuo
* Libro de referencia: Clean Code — Robert C. Martin

# SOLID Principles
Diseño de software orientado a objetos de nivel profesional.

* S — Single Responsibility Principle
* O — Open/Closed Principle
* L — Liskov Substitution Principle
* I — Interface Segregation Principle
* D — Dependency Inversion Principle

# Design Patterns
Soluciones probadas a problemas recurrentes.

* Creacionales: Singleton, Factory, Builder
* Estructurales: Adapter, Decorator, Facade
* Comportamiento: Strategy, Observer, Command, Iterator

# Práctica competitiva y resolución de problemas
Aquí se mide todo lo anterior.

* LeetCode (empezar con Easy → Medium → Hard)
* HackerRank para Java específico
* Codeforces para competencia real
* Estrategia: no memorizar soluciones, entender patrones

# Nivel Arquitectura
Para pensar en sistemas, no solo en funciones.

* Principios de diseño de sistemas
* Clean Architecture
* Arquitectura hexagonal
* APIs REST bien diseñadas
* Bases de datos: SQL y conceptos NoSQL
* Introducción a microservicios

---
3. Modelos de Datos y Representación en Memoria - “Las estructuras de datos no viven en el aire: viven en la RAM.”

   * Temas esenciales:
     * Variables y referencias en Java:
       * Diferencia entre valor y referencia (Stack vs Heap).

   * Arrays en memoria:
     * Indexación, contigüidad, coste de redimensionar (System.arraycopy).

   * Objetos y estructuras compuestas:
     * Cómo un objeto anidado se representa (punteros, offsets).

   * Concepto de puntero y null:
     * Aunque Java no tiene punteros explícitos, entenderlo es clave para listas y árboles.

   * 📘 Objetivo: poder visualizar cómo se almacenan tus estructuras en memoria.
   * 🛠 Práctica: dibuja cómo se vería en memoria una lista enlazada simple de 3 nodos.

4. Pensamiento Algorítmico - “Algoritmia no es memorizar soluciones, es aprender a diseñarlas.”
   * Temas esenciales:
     * Descomposición de problemas (Divide & Conquer).

   * Reconocimiento de patrones:
     * Buscar, ordenar, combinar, recorrer, dividir, optimizar.

   * Uso de invariantes:
     * Propiedades que siempre se cumplen (clave para demostrar corrección).

   * Análisis de trade-offs:
     * Tiempo vs memoria, simplicidad vs rendimiento.

   * 📘 Objetivo: aprender a “ver” un algoritmo antes de escribirlo.
   * 🛠 Práctica: analiza cómo encontrar el elemento máximo en una lista — y cómo optimizarlo.

7. Herramientas y entorno técnico - “No solo se trata de lógica, sino también de medir, depurar y visualizar.”
   * Temas esenciales:
     * Uso del depurador (debugger) en tu IDE: observar estructuras dinámicas.

     * Herramientas de profiling y medición de tiempo.

     * JUnit para validar comportamiento y complejidad esperada.

     * Uso de diagramas (flujo, memoria, árboles).

Paradigma	Descripción	Ejemplo clásico
Divide & Conquer	Divide el problema, resuelve y combina	MergeSort, QuickSort
Greedy	Elige siempre la mejor opción local	Dijkstra, Huffman
Dynamic Programming	Divide y memoriza resultados	Fibonacci, Knapsack
Backtracking	Explora todas las soluciones posibles con poda	N-Reinas, Sudoku
Brute Force	Prueba todas las combinaciones posibles	Permutaciones
Recursión	Define el problema en términos de sí mismo	Factorial, Fibonacci
Iterativo	Usa bucles en lugar de recursión	Búsqueda lineal


---
(1) Direccionamiento
Cada celda tiene una dirección única.

Una estructura de datos básicamente hace esto:

Arrays → apuntan al inicio del bloque

Listas → cada nodo guarda un puntero a otro

Árboles → nodos con punteros izquierdo/derecho

Hash tables → punteros a buckets

(2) Layout de datos
Clave para rendimiento:

Contiguo (arrays) → MUY rápido en lectura secuencial.

Disperso (linked list) → lento para recorrer, pobre localidad.

(3) Caché
La CPU siempre busca primero en caché.

Si no está → cache miss → el programa se vuelve más lento.

(4) Asignación
Java usa:

Stack frame para variables locales.

Heap allocation via "bump pointer" (muy rápido).

Free/compactación por GC.