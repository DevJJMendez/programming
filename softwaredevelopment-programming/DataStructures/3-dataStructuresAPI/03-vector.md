# `Vector`
La clase Vector en Java es una implementación de una lista dinámica que forma parte del paquete java.util. Es similar a ArrayList pero con algunas diferencias clave, especialmente en cuanto a sincronización y manejo de concurrencia. Un Vector es una colección que puede crecer o reducir su tamaño dinámicamente, y almacena sus elementos en un array interno.

## ¿Qué es la clase Vector?
Vector es una clase que implementa la interfaz List y permite almacenar elementos de forma secuencial. A diferencia de los arrays tradicionales, un Vector puede redimensionarse automáticamente cuando se agregan o eliminan elementos. Esto significa que no necesitas preocuparte por el tamaño inicial del Vector, ya que crecerá según sea necesario.

Un aspecto importante del Vector es que es seguro para la concurrencia, lo que significa que todos sus métodos están sincronizados y pueden ser utilizados en entornos donde múltiples hilos acceden a la misma colección de datos.

## ¿Para qué sirve la clase Vector?
La clase Vector se utiliza cuando necesitas:

1. Almacenar elementos de forma dinámica sin especificar un tamaño fijo.

2. Manipular colecciones de datos que pueden crecer o reducirse a medida que se agregan o eliminan elementos.

3. Asegurar que la colección sea segura para la concurrencia sin necesidad de sincronizar manualmente el acceso. Esto es especialmente útil en entornos multi-hilo.

## ¿Qué resuelve la clase Vector?
Vector resuelve varios problemas comunes que aparecen al usar estructuras de datos más simples:

1. **Limitaciones de arrays estáticos**: En un array tradicional, debes definir el tamaño desde el principio y no puedes cambiarlo. Vector elimina esta limitación permitiendo que el array crezca automáticamente.

2. **Problemas de sincronización en entornos multi-hilo**: Dado que los métodos de Vector son sincronizados, evita problemas de concurrencia donde múltiples hilos intentan acceder y modificar la colección al mismo tiempo.

## ¿Cómo lo resuelve la clase Vector?
1. **Redimensionamiento automático**: Internamente, Vector utiliza un array dinámico. Cuando el array interno se llena, Vector crea un nuevo array con una capacidad mayor (generalmente, el doble del tamaño actual) y copia los elementos al nuevo array. Esto permite agregar elementos de manera eficiente sin necesidad de preocuparse por la capacidad inicial.

2. **Sincronización**: Todos los métodos de Vector están sincronizados, lo que significa que se bloquean automáticamente cuando múltiples hilos intentan acceder a ellos al mismo tiempo. Esto asegura que solo un hilo pueda acceder a un método a la vez, evitando condiciones de carrera y otros problemas de concurrencia.

## Métodos importantes de la clase Vector
1. **Crear un `Vector`**
```java
Vector<String> fruits = new Vector<>();
```

2. **Agregar elementos (`add`)**
```java
fruits.add("Apple");
fruits.add("Banana");
```

3. **Insertar en una posición específica**
```java
fruits.add(1, "Orange"); // Inserta "Orange" en el índice 1
```

4. **Acceder a elementos (`get`)**
```java
String fruit = fruits.get(0); // Devuelve "Apple"
```

5. **Modificar elementos (`set`)**
```java
fruits.set(0, "Pineapple"); // Cambia "Apple" a "Pineapple"
```

6. **Capacidad y manejo de tamaño (`capacity`, `ensureCapacity`)**
```java
int capacity = fruits.capacity(); // Devuelve la capacidad actual del `Vector`

fruits.ensureCapacity(20); // Asegura que el `Vector` tenga al menos una capacidad de 20
```

7. **Otros métodos: `size`, `contains`, `toArray`**

## Ventajas del uso de Vector
1. **Sincronización automática**: Todos los métodos están sincronizados, lo que significa que puedes usar Vector en aplicaciones multi-hilo sin preocuparte por problemas de concurrencia.

2. **Redimensionamiento dinámico**: No necesitas especificar el tamaño inicial; Vector crecerá automáticamente cuando se necesite más espacio.

3. **Interfaz List**: Al implementar la interfaz List, Vector puede ser utilizado en cualquier contexto donde se espera una lista, proporcionando flexibilidad para cambiar entre implementaciones como ArrayList o LinkedList.


## Desventajas del uso de Vector
1. **Rendimiento más lento debido a la sincronización**: Debido a que todos los métodos están sincronizados, Vector puede ser más lento que ArrayList en aplicaciones de un solo hilo, donde la sincronización no es necesaria.

2. **Redimensionamiento costoso**: Aunque el Vector se redimensiona automáticamente, esta operación puede ser costosa si se realiza con frecuencia. Esto puede llevar a problemas de rendimiento si se agregan muchos elementos a la vez.
