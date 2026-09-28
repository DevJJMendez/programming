# 1. Fundamentos Matemáticos (la base de todo)
La computación es matemática aplicada, necesitas manejar:

* Lógica matemática y proposicional
  * Tablas de verdad, conectores lógicos, cuantificadores.

* Teoría de conjuntos y relaciones

* Álgebra booleana

* Matemáticas discretas
  * Combinatoria, permutaciones, grafos, árboles.

* Probabilidad y estadística básica (para algoritmos probabilísticos, IA, etc).

* Álgebra lineal (vectores, matrices, transformaciones).

* Cálculo (derivadas, límites, optimización — más útil en ML/IA).

# 2. Fundamentos de Computación
Aquí se estudia qué es una computadora y cómo funciona internamente:

* Arquitectura de computadoras
  * CPU, memoria, buses, registros, instrucciones.

* Sistemas numéricos (binario, octal, hexadecimal).

* Representación de datos (enteros, flotantes, caracteres, cadenas).

* Compiladores e intérpretes (visión general).

* Organización de sistemas operativos
  * Procesos, hilos, concurrencia, memoria, sistemas de archivos.

# 3. Algoritmos y Estructuras de Datos (core del dev crack)
* Complejidad computacional
  * Notación Big O, Ω, Θ.

* Algoritmos clásicos
  * Búsqueda (lineal, binaria).
  * Ordenamiento (merge sort, quicksort, heapsort).

* Estructuras de datos
  * Arrays, listas, pilas, colas.
  * Árboles (binarios, AVL, B-Trees).
  * Grafos (BFS, DFS, Dijkstra, A*).
  * Hash Tables.

* Programación dinámica
  * Memoization, tabulación.

* Algoritmos de grafos avanzados
  * Floyd-Warshall, Kruskal, Prim.

# 4. Paradigmas de Programación
Dominar varios paradigmas te da flexibilidad mental:

* Imperativo y Procedural (C, Java básico).

* Orientado a Objetos (OOP)
  * Encapsulación, herencia, polimorfismo, abstracción.

* Funcional (Lambda, recursión, inmutabilidad, streams en Java).

* Concurrente y Paralelo (threads, async, promesas, actores).

* Lógico (Prolog como base).

# 5. Ingeniería de Software
Ya no solo se trata de código, sino de sistemas mantenibles:

* Clean Code (Robert C. Martin).

* Principios SOLID.

* Patrones de diseño (GoF).

* Arquitectura de software
  * Monolitos vs microservicios.
  * Arquitectura hexagonal, limpia, en capas.

* Metodologías ágiles (Scrum, Kanban).

* Testing (unitario, integración, TDD, BDD).

# 6. Sistemas y Redes
Una base sólida en sistemas distribuidos:

* Redes de computadoras
  * Modelo OSI, TCP/IP.

  * Protocolos (HTTP, DNS, FTP, SSH).

* Concurrencia y sincronización.

* Sistemas distribuidos
  * Consistencia, disponibilidad, partición (CAP theorem).

* Algoritmos distribuidos (consenso, líderes).

# 7. Campos Avanzados
Una vez dominada la base, puedes especializarte:

* Inteligencia Artificial y Machine Learning.

* Seguridad informática y criptografía.

* Compiladores e intérpretes.

* Teoría de autómatas y lenguajes formales (gramáticas, regex, Turing machines).

* Optimización de algoritmos (metaheurísticas, NP-completo).


---

Arquitectura de computadoras
1. ¿Qué es la Arquitectura de Computadoras?
Es la rama de la computación que estudia el diseño, organización y funcionamiento de los componentes internos de un computador y cómo estos interactúan para ejecutar instrucciones.

👉 En pocas palabras:
La arquitectura define qué hace una computadora (su modelo lógico),
la organización describe cómo lo implementa físicamente (circuitos, buses, memoria, etc.).

2. ¿Para qué sirve?
Para entender cómo el software se traduce en operaciones físicas sobre el hardware.

Para diseñar computadores más rápidos, eficientes y confiables.

Para optimizar el uso de recursos (CPU, memoria, almacenamiento, red).

Para tomar decisiones de rendimiento en desarrollo de software y sistemas.


3. ¿Qué resuelve?
La arquitectura responde a preguntas como:

¿Cómo se representa y procesa la información (binario, instrucciones)?

¿Cómo se ejecutan los programas (ciclo de instrucción)?

¿Cómo se organizan los componentes (CPU, memoria, E/S)?

¿Cómo mejorar el rendimiento (pipelining, cachés, paralelismo)?

¿Cómo lo resuelve? (Componentes principales)
🔹 1. Modelo de von Neumann (clásico)
Toda computadora moderna sigue este modelo (con variantes):

Unidad de Control (UC): interpreta y coordina instrucciones.

Unidad Aritmético-Lógica (ALU): realiza operaciones matemáticas y lógicas.

Memoria principal: almacena datos e instrucciones.

Dispositivos de entrada/salida: comunicación con el exterior.

Bus de datos, direcciones y control: líneas de comunicación internas.

👉 Clave: programa almacenado en memoria, lo que permite computadoras programables.

2. Representación de la información
Sistema binario (0 y 1).

Codificación: enteros, flotantes, caracteres (ASCII, Unicode), imágenes, sonido.

3. Ciclo de instrucción (Fetch–Decode–Execute)
Fetch: la UC trae la instrucción desde memoria.

Decode: se interpreta la instrucción.

Execute: la ALU/CPU ejecuta la operación.

Store: se guarda el resultado si aplica.

4. Jerarquía de memoria
Registros (más rápidos, dentro del CPU).

Caché (L1, L2, L3).

RAM (memoria principal).

Almacenamiento secundario (SSD, HDD).

Memoria terciaria (backup, almacenamiento en cinta, nube).

👉 Principio: entre más rápida → menor capacidad y más costosa.

5. Paralelismo y optimización
Pipelining: ejecución en etapas solapadas.

Multiprocesadores y multinúcleo.

Paralelismo a nivel de instrucciones (ILP).

Paralelismo a nivel de datos (SIMD, GPU).
---
5. Fundamentos clave a dominar en Arquitectura de Computadoras
Sistemas numéricos y representación de datos (binario, octal, hexadecimal, punto flotante).

Álgebra booleana y circuitos lógicos (AND, OR, NOT, flip-flops, registros).

Organización de la CPU (UC, ALU, registros, buses).

Ciclo de instrucción y set de instrucciones (ISA: Instruction Set Architecture).

Jerarquía y gestión de memoria (RAM, cachés, virtual memory).

Entrada y salida (E/S mapeada, interrupciones, controladores).

Paralelismo y arquitecturas modernas (multinúcleo, RISC vs CISC, GPU).

Rendimiento (CPI, MIPS, throughput, latencia).

6. Aplicaciones prácticas para un ingeniero de software
Optimización de código: entender qué operaciones son costosas a nivel CPU/memoria.

Diseño de sistemas eficientes: bases de datos, sistemas distribuidos, cloud.

Seguridad informática: vulnerabilidades a nivel hardware (ej: Meltdown, Spectre).

Machine Learning/IA: aprovechar GPU y arquitecturas paralelas.

[767, 789, 170, 178, 280, 78, 109, 65, 579, 22,63, 928, 344, 659, 31, 140, 892, 219, 155, 379, 211, 487, 528, 40, 191, 573, 254, 289, 363, 531,179,197,971,917,791,719,500,652]

["zthyg", "weutv", "bccli", "oudge", "lxbvk", "yvzad", "ktejy", "bimsn", "ijarn", "dhdnr"]

[21.82, 7.69, 83.15, 86.19, 3.67, 49.53, 20.2, 89.51, 28.51, 81.7]
