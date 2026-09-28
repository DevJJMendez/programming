# Paralelismo
El paralelismo es la capacidad de ejecutar múltiples tareas al mismo tiempo físicamente, aprovechando varios núcleos o procesadores.

🔁 Mientras que la concurrencia permite avanzar múltiples tareas lógicamente al mismo tiempo,
⚙️ el paralelismo las ejecuta realmente en paralelo, utilizando múltiples hilos o procesos en distintos núcleos.

## ¿Cómo está estructurado?
Tipos de paralelismo
| Tipo                                     | Descripción                                                       | Ejemplo                                                     |
| ---------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------- |
| Paralelismo a nivel de datos             | El mismo algoritmo ejecutado sobre distintos fragmentos de datos. | Procesar diferentes partes de una imagen al mismo tiempo.   |
| Paralelismo a nivel de tareas            | Diferentes tareas se ejecutan simultáneamente.                    | Un hilo calcula estadísticas, otro guarda en base de datos. |
| Paralelismo a nivel de instrucción (ILP) | El procesador ejecuta múltiples instrucciones en un solo ciclo.   | Optimización de CPU por arquitectura.                       |

## ¿Qué resuelve?
| Problema                                                | Solución con paralelismo                       |
| ------------------------------------------------------- | ---------------------------------------------- |
| Procesamiento lento de grandes volúmenes de datos       | Divide y ejecuta en múltiples núcleos a la vez |
| Cálculos científicos, Machine Learning, Render 3D       | Multiplica el rendimiento                      |
| Alto tráfico en servicios                               | Distribuye carga entre hilos/procesos          |
| Tareas independientes que pueden correr simultáneamente | Se procesan al mismo tiempo                    |

##  ¿Cómo lo resuelve?
🧵 Ejecución en múltiples hilos (Multithreading)
Cada núcleo de CPU ejecuta un hilo diferente.
```java
ExecutorService pool = Executors.newFixedThreadPool(4);
pool.submit(() -> hacerTarea());
```

Multiprocesamiento (Multiprocessing)
Múltiples procesos separados, útiles para evitar el GIL en Python.
```python
from multiprocessing import Process
Process(target=proceso_pesado).start()
```

SIMD (Single Instruction, Multiple Data)
Una instrucción opera sobre múltiples datos (ej. SSE/AVX en C/C++).

## Ejemplo en la vida real
💡 Imagina que estás procesando una imagen de alta resolución para un filtro:

Con paralelismo de datos, divides la imagen en 8 secciones y aplicas el filtro en paralelo con 8 hilos/hilos de GPU.

Esto reduce el tiempo de procesamiento drásticamente.

## Peligros del paralelismo
Race Conditions: acceso simultáneo a recursos compartidos sin sincronización.

Deadlocks: procesos bloqueados mutuamente.

False Sharing: varios hilos modifican datos cercanos en memoria.

Overhead de sincronización: exceso de locking puede anular beneficios.

Scalability trap: más hilos no siempre implica más rendimiento (ley de Amdahl).

## Buenas prácticas
Minimiza las regiones críticas (locks).

Usa estructuras de datos concurrentes seguras.

Mide la escalabilidad con pruebas de estrés.

Usa profiling (perf, VisualVM, etc.) para detectar cuellos de botella.

Considera el número de núcleos físicos reales.

## Diferencia entre Concurrencia y Paralelismo
| Característica | Concurrencia                            | Paralelismo                                           |
| -------------- | --------------------------------------- | ----------------------------------------------------- |
| Concepto       | Varias tareas progresan al mismo tiempo | Varias tareas se ejecutan físicamente al mismo tiempo |
| Procesadores   | Puede usarse en 1 solo núcleo           | Requiere múltiples núcleos/procesadores               |
| Casos ideales  | I/O, latencia, APIs                     | Cálculo intensivo, procesamiento masivo               |