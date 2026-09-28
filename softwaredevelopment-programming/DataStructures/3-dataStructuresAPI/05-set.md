# `Set`
La interfaz Set en Java es una colección que no permite elementos duplicados. Es parte del paquete java.util y extiende la interfaz Collection. Las implementaciones de Set son ampliamente utilizadas cuando se necesita almacenar elementos únicos y garantizar que no haya duplicados.

## ¿Qué es la interfaz Set?
La interfaz Set representa un conjunto (similar a los conjuntos en matemáticas) que no permite duplicados. Esto significa que cuando agregas un elemento a un Set, si ese elemento ya existe en la colección, la operación de adición simplemente no tendrá efecto. Los Set no están indexados como las listas, lo que significa que no puedes acceder a elementos por su posición; en su lugar, solo puedes iterar a través de ellos.

## ¿Para qué sirve la interfaz Set?
La interfaz Set es útil para:

1. **Almacenar elementos únicos**: Permite asegurar que no haya duplicados en la colección, lo cual es ideal para casos como:

   * Almacenar una lista de usuarios únicos.

   * Gestionar un conjunto de valores únicos (por ejemplo, nombres de productos únicos).

   * Crear colecciones sin elementos repetidos para algoritmos de búsqueda.

2. **Operaciones matemáticas de conjuntos**: Puedes usar un Set para realizar operaciones comunes de conjuntos, como:

   * Unión: Combinar elementos de dos conjuntos.

   * Intersección: Encontrar elementos comunes entre dos conjuntos.

   * Diferencia: Encontrar elementos que están en un conjunto pero no en otro.

## ¿Qué resuelve la interfaz Set?
La interfaz Set resuelve varios problemas que enfrentan los desarrolladores al manejar colecciones de datos:

1. **Eliminación de duplicados**: Si necesitas asegurarte de que tu colección no contenga elementos repetidos, Set te ayudará a hacerlo sin necesidad de implementar lógica adicional para verificar duplicados.

2. **Eficiencia en la búsqueda y eliminación**: Algunas implementaciones de Set (como HashSet) proporcionan operaciones de búsqueda y eliminación muy eficientes (tiempo constante en promedio).

3. **Fácil manejo de colecciones únicas**: Cuando necesitas garantizar la unicidad de los elementos y trabajar con operaciones matemáticas de conjuntos, Set es la opción natural.

## ¿Cómo lo resuelve la interfaz Set?
La interfaz Set se implementa a través de varias clases concretas que tienen sus propias características y ventajas. Aquí están las principales implementaciones:

1. `HashSet`

2. `LinkedHashSet`

3. `TreeSet`