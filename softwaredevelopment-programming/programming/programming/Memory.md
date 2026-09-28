#memory
#programming
# Memoria
La memoria es el **espacio donde vive tu programa mientras se ejecuta**. No el disco duro donde guardas archivos, sino el espacio activo donde el procesador coloca los datos que está usando en este momento.

Sin memoria, no hay ejecución. Un programa que no tiene dónde guardar sus variables, llamadas y objetos simplemente no puede correr.

```
La memoria es el componente del sistema encargado de almacenar datos e instrucciones que la CPU necesita para ejecutar un programa.
```

**A nivel técnico:**
* Es un conjunto de celdas direccionables.
* Cada celda tiene un tamaño fijo (generalmente **1 byte**).
* Todas las estructuras de datos terminan siendo una combinación de **bytes**.
* La CPU accede a estas celdas por **direcciones**.

```
La memoria en computación es un componente fundamental que permite almacenar y recuperar datos e instrucciones que usa el procesador para ejecutar programas. Es un recurso esencial para cualquier sistema informático, ya que sin ella no se podrían ejecutar aplicaciones, operar sistemas o manipular información.*

En términos generales, la memoria es un dispositivo o sistema que almacena información de manera temporal o permanente. Dependiendo de su tipo, puede ser volátil o no volátil.
```

## ¿Para qué sirve?
La memoria permite:
* Guardar variables temporales
* Guardar estructuras de datos completas
* Mantener el estado de una aplicación
* Almacenar instrucciones del programa
* Intercambiar información entre la CPU y otros componentes.

**Sin memoria no puedes ejecutar nada. La CPU solo calcula; necesita datos de los que operar, y esos datos viven en algún tipo de memoria.**

## ¿Qué problemas resuelve?
Sin memoria, los sistemas informáticos serían ineficientes o directamente inoperantes. Resuelve problemas como:

* **Almacenamiento y recuperación de datos**: Permite que los datos sean guardados y accedidos de manera eficiente, sin depender de procesos lentos como el acceso a discos mecánicos.

* **Velocidad de procesamiento**: La RAM y la caché reducen el tiempo de espera del procesador al ofrecer acceso rápido a datos y programas.

* **Gestión de múltiples procesos**: El sistema operativo usa la memoria para manejar la ejecución simultánea de múltiples aplicaciones sin conflictos.

* **Persistencia de datos**: La memoria secundaria y terciaria garantizan que los datos se conserven tras apagar el sistema.

## Estructura de la memoria dentro de un programa
Cuando un programa se ejecuta, su memoria se divide en secciones:
```bash
+---------------------------+
| Código / Text segment     | -> instrucciones del programa
+---------------------------+
| Datos globales            | -> variables globales/estáticas
+---------------------------+
| Heap                      | -> memoria dinámica (new)
+---------------------------+
| Stack                     | -> llamadas a funciones, variables locales
+---------------------------+
```

## Características esenciales de la memoria
Las más importantes para algoritimia y estructuras de datos:

1. **Velocidad**
   * Qué tan rápido la CPU puede leer/escribir.
   * Caché → extremadamente rápida
   * RAM → rápido
   * Disco/SSD → lento
   * Nube / remoto → muy lento

2. **Volatilidad**
   * La RAM se borra al apagar el equipo.
   * Un SSD/HDD no.
   * Esto define qué estructuras pueden vivir durante cuánto tiempo.

3. **Direccionalidad**
   * La memoria se accede por direcciones:
```txt
0x00FF1230 → valor
0x00FF1234 → valor
```
Las estructuras de datos dependen de cómo están distribuidos esos valores.

4. **Localidad (fundamental)**
   * Existen dos tipos:
     * **Localidad espacial**: si accedes a `a[i]`, probablemente accedas a `a[i+1]`.
     * **Localidad temporal**: si accedes a una variable hoy, probablemente la uses en próximos ciclos.

   * Toda estructura eficiente explota la localidad para entrar en caché.

5. **Jerarquía**
   * La memoria es una pirámide: a más velocidad → menos capacidad.

   * La jerarquía clásica:
```bash
CPU registers       (nanoseg)
L1 cache            (~0.5-1 ns)
L2 cache            (~3-5 ns)
L3 cache            (~10-20 ns)
RAM                 (~50-100 ns)
SSD                 (~100,000 ns)
HDD                 (~5,000,000 ns)
Red (Internet)      (10,000,000+ ns)
```
Una operación que “parece” **`O(1)`** puede ser 10000 veces más lenta si causa un cache miss.

## Administración de memoria en sistemas operativos
Los sistemas operativos usan mecanismos como:

* **Paginación**: Divide la memoria en bloques de tamaño fijo llamados "páginas" para optimizar el uso.

* **Segmentación**: Divide la memoria en segmentos de diferentes tamaños para mejorar la eficiencia.

* **Swapping**: Mueve procesos entre la RAM y el disco para evitar bloqueos cuando la memoria es insuficiente.

## Memoria Heap
La memoria heap es una región de la memoria que se utiliza para la asignación dinámica. Cuando creas objetos o estructuras de datos que necesitan durar más allá del ámbito de una función o método (por ejemplo, objetos en Java o C++), estos se almacenan en la heap. La asignación de memoria en el heap se gestiona de manera dinámica y el programador, o el garbage collector en lenguajes como Java, se encarga de liberar la memoria cuando ya no es necesaria.

**Características:**
* **Asignación dinámica**: La memoria heap se usa para objetos o estructuras de datos que se crean durante la ejecución del programa.

* **Acceso más lento**: El acceso a los datos en la heap es generalmente más lento que en la memoria stack.

* **Desfragmentación**: El uso intensivo de la heap puede generar fragmentación de memoria, donde la memoria disponible no está contigua, lo que puede dificultar futuras asignaciones.

## Memoria Stack
La memoria stack es una región de memoria utilizada para el manejo de variables locales y el control de flujo del programa (como las llamadas a funciones). Cada vez que se llama a una función o método, se crea un "frame" en la stack para almacenar sus variables locales, parámetros y dirección de retorno. Cuando la función termina, ese frame se elimina automáticamente de la stack, liberando la memoria ocupada por las variables locales.

**Características:**
* **Asignación automática**: La memoria stack se maneja automáticamente. Cuando una función se llama, se asigna espacio para las variables locales en la stack, y cuando la función termina, ese espacio se libera.

* **Acceso rápido**: El acceso a las variables en la stack es muy rápido, ya que sigue un principio LIFO (Last In, First Out).

* **Tamaño limitado**: La memoria stack tiene un tamaño limitado, por lo que asignaciones grandes o una recursión excesiva pueden causar un stack overflow.

---
[](Heap.md)
[](Stack.md)