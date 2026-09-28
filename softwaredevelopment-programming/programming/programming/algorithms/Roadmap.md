Comencemos por Complejidad temporal y Espacial

¿Puedo alguien 'no-matematico' dominar estos conceptos?

¿Como?

# Roadmap Profesional para Dominar Algoritmia
## Fase 0 — Fundamentos de pensamiento algorítmico
* Conceptos que debes dominar:
  * Complejidad temporal y espacial
  * Notación Big O
  * Análisis de loops y recursión
  * Tradeoffs tiempo vs memoria

## Fase 1 — Patrones básicos de arrays y hashing
* Patrones a dominar:
  * HashMap / Counting
    * Problemas típicos:
      * two sum
      * duplicates
      * frequency
      * anagramas
      * Idea fundamental:
```
resolver en O(n)
usando un mapa para recordar información previa
```

* Two Pointers -> Muy común en arrays ordenados.
  * Patrones:
    * mover dos índices
    * converger o divergir

* Sliding Window
  * Problemas de:
    * substring
    * longest sequence
    * subarray
    * Idea mental:
```
expandir ventana
si rompe regla → contraer
```

## Fase 2 — Recursion y Backtracking
Aquí aprendes a explorar espacios de soluciones.

Problemas típicos:
* permutations
* subsets
* combinaciones
* sudoku
* Patrón mental:
```
choose
explore
unchoose
```
Pseudo patrón:
```
backtrack(path):
    if solution:
        save
        return

    for option in choices:
        path.add(option)
        backtrack(path)
        path.remove(option)
```

## Fase 3 — Estructuras de datos críticas
Debes dominarlas internamente.

Stack
Patrón:

evaluar expresiones

validaciones

monotonic stack

Queue / BFS
Usado para:

niveles

distancia mínima

grafos

Heap / Priority Queue
Problemas típicos:

top k

streaming

median

## Fase 4 — Árboles y grafos
Esto aparece muchísimo.

DFS
Recorrer profundidad.

BFS
Para distancias mínimas.

Grafos
Debes dominar:

BFS

DFS

Topological sort

Union Find

## Fase 5 — Dynamic Programming
Duración: 4 semanas

Esto separa juniors de seniors.

Debes entender:

subproblemas

memoization

tabulation

## Fase 6 — Patrones avanzados
Binary Search sobre respuesta

Greedy
Elegir localmente óptimo.

Union Find
Para grafos dinámicos.

## Los 12 patrones que dominan el 80% de entrevistas
Memoriza los patrones, no los ejercicios.

Hashing

Two pointers

Sliding window

Binary search

Stack

Heap

BFS

DFS

Backtracking

Dynamic Programming

Greedy

Union Find