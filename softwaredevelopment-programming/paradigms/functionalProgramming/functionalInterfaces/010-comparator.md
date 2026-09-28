# `comparator<>`
`Comparator<>` es una interfaz funcional en Java utilizada para definir un criterio personalizado de ordenación entre objetos de un tipo específico. A diferencia de la interfaz Comparable, que obliga a los objetos a implementar un método de comparación para sí mismos, `Comparator<>` permite definir comparaciones externas y separadas de la clase que se está comparando

## ¿Para qué sirve?
`Comparator<>` es útil cuando:

1. **Ordenación personalizada**: Necesitas comparar objetos de una clase sin modificar dicha clase, o cuando los objetos deben ser ordenados de diferentes maneras según el contexto.

2. **Uso en colecciones**: Se utiliza a menudo junto con estructuras de datos como listas o conjuntos ordenados, para especificar el orden en el que deben almacenarse los elementos.

## ¿Qué resuelve?
`Comparator<>` resuelve la necesidad de flexibilidad en la ordenación de objetos sin forzar la implementación de una lógica de comparación dentro de las propias clases. Esto es especialmente útil cuando:

* Necesitas ordenar una colección de objetos en más de un criterio. Por ejemplo, ordenar una lista de empleados por edad, nombre, o salario.

* No tienes control sobre el código de la clase que estás comparando (por ejemplo, clases en bibliotecas de terceros).

* Deseas mantener una separación de responsabilidades, evitando mezclar la lógica de comparación dentro de las propias clases de los objetos.

## ¿Cómo lo resuelve?
La interfaz `Comparator<>` te permite definir la lógica de comparación en una clase o a través de una lambda. Esta interfaz incluye el método abstracto `compare(T o1, T o2)`, el cual:

* Recibe dos objetos como parámetros y devuelve:
  * Un valor negativo si el primer objeto es menor que el segundo.

  * Cero si los dos objetos son iguales.

  * Un valor positivo si el primer objeto es mayor que el segundo.

## Métodos importantes en Comparator<>
1. `compare(T o1, T o2)`: Es el método principal que compara dos objetos.

```java
Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());
```

2. `reversed()`: Devuelve un comparador que invierte el orden del comparador actual.

```java
Comparator<String> byLengthReversed = byLength.reversed();
```

3. `thenComparing()`: Permite realizar comparaciones secundarias si el criterio principal resulta en igualdad.

```java
Comparator<Employee> byAgeThenName = Comparator.comparing(Employee::getAge)
                                               .thenComparing(Employee::getName);
```

4. `nullsFirst()` / `nullsLast()`: Sirve para manejar comparaciones donde alguno de los valores puede ser `null`. Devuelve un comparador que considera null como menor (o mayor) que cualquier valor no nulo.

```java
Comparator<String> nullsFirstComparator = Comparator.nullsFirst(Comparator.naturalOrder());
```

5. `naturalOrder()` / `reverseOrder()`: Devuelven un comparador que compara objetos usando su orden natural (implementación de `Comparable<>`), o en orden inverso.

```java
Comparator<Integer> natural = Comparator.naturalOrder();
Comparator<Integer> reversed = Comparator.reverseOrder();
```

## Ejemplos
**Ordenar por un solo criterio**: Supongamos que tenemos una clase Empleado y queremos ordenar una lista de empleados por su salario:

```java
import java.util.Comparator;

class Empleado {
    private String nombre;
    private int salario;

    // Constructor, getters y setters

    public int getSalario() {
        return salario;
    }

    public String getNombre() {
        return nombre;
    }
}

Comparator<Empleado> bySalario = (e1, e2) -> Integer.compare(e1.getSalario(), e2.getSalario());
```
Este comparador ordenará una lista de empleados por su salario, de menor a mayor.

**Ordenar por múltiples criterios**: Ahora, si quieres ordenar primero por salario y luego por nombre en caso de que dos empleados tengan el mismo salario:
```java
Comparator<Empleado> bySalarioThenName = Comparator.comparing(Empleado::getSalario)
                                                   .thenComparing(Empleado::getNombre);
```

**Ordenar en orden inverso**: Si deseas ordenar la lista en orden inverso (de mayor a menor):
```java
Comparator<Empleado> bySalarioDesc = Comparator.comparing(Empleado::getSalario).reversed();
```

**Manejo de valores `null`**: Para manejar empleados donde el salario o nombre pueda ser `null`:
```java
Comparator<Empleado> bySalarioNullsFirst = Comparator.nullsFirst(Comparator.comparing(Empleado::getSalario));
```
En este caso, los empleados con salario null se consideran menores que aquellos con un salario no null.

## Ventajas del uso de Comparator<>
* **Flexibilidad**: Puedes definir múltiples criterios de comparación sin modificar las clases de los objetos.

* **Reusabilidad**: Los comparadores pueden ser reutilizados en diferentes lugares de la aplicación.

* **Ordenación dinámica**: Puedes cambiar la lógica de ordenación en tiempo de ejecución, utilizando diferentes comparadores según el contexto.

* **Composición de comparadores**: Con métodos como `thenComparing()`, puedes encadenar comparaciones fácilmente, permitiendo una ordenación más completa y compleja.

## ¿Cuándo usar `Comparator<>` y no `Comparable<>`?
* **Usa `Comparator<>` cuando**:
  * No tienes control sobre la clase que estás comparando.

  * Necesitas múltiples criterios de ordenación.

  * Quieres mantener la lógica de comparación separada de la lógica de la clase.

* **Usa `Comparable<>` si**:
  * El objeto tiene un orden natural y ese orden es el único que se necesita.