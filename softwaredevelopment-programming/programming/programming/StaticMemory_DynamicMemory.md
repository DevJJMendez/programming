# Memoria Estática (Static Memory)
La memoria estática se refiere al tipo de memoria que se asigna en tiempo de compilación. Las variables estáticas se almacenan en esta memoria y su duración es todo el tiempo de ejecución del programa. Esto significa que la memoria para estas variables se asigna una sola vez y no se libera hasta que el programa finaliza.

**Características:**
* **Asignación en tiempo de compilación**: La memoria estática se asigna antes de que el programa comience a ejecutarse.

* **Duración larga**: La memoria reservada para las variables estáticas persiste durante todo el ciclo de vida del programa.

* **Almacenamiento fijo**: Las variables estáticas ocupan la misma cantidad de memoria durante la ejecución y **no se modifica en tiempo de ejecución.**.

# Memoria Dinámica (Dynamic Memory)
La memoria dinámica se refiere a la memoria que se asigna durante la ejecución del programa (tiempo de ejecución). A diferencia de la memoria estática, el tamaño de la memoria asignada puede variar en tiempo de ejecución, según sea necesario. La memoria dinámica generalmente se gestiona en la **heap**.

**Características:**
* **Asignación en tiempo de ejecución**: Se asigna y libera según las necesidades del programa.

* **Control del programador**: En lenguajes como C o C++, es responsabilidad del programador liberar la memoria después de usarla (con free o delete).

* **Flexibilidad**: Permite la asignación de grandes cantidades de memoria de manera flexible en función de las necesidades del programa.