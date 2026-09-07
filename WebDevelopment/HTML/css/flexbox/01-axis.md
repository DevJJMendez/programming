![axis](images/flexbox.png)

# Main Axis
El **Main Axis** es el eje sobre el cual se distribuyen los elementos flexibles (**flex items**). Por defecto, el eje principal es horizontal (de izquierda a derecha), pero esto puede cambiar dependiendo de la dirección que definas en el contenedor con la propiedad `flex-direction`.

* **`flex-direction: row` (valor por defecto)**: El **main axis** es horizontal, de izquierda a derecha.

* **`flex-direction: row-reverse`**: El **main axis** sigue siendo horizontal, pero de derecha a izquierda.

* **`flex-direction: column`**: El **main axis** se vuelve vertical, de arriba hacia abajo.

* **`flex-direction: column-reverse`**: El **main axis** es vertical, pero de abajo hacia arriba.

Los elementos en un contenedor flex se distribuyen a lo largo de este eje, y propiedades como `justify-content` permiten controlar cómo se distribuyen en el **main axis**.

# Cross Axis (Eje Cruzado)
El Cross Axis es el eje perpendicular al **Main Axis**. Mientras que el **Main Axis** depende de `flex-direction`, el **Cross Axis** se ajusta automáticamente para ser perpendicular a él:

* Si el **Main Axis** es horizontal (`row` o `row-reverse`), el Cross Axis será vertical.

* Si el **Main Axis** es vertical (`column` o `column-reverse`), el Cross Axis será horizontal.

Las propiedades que operan sobre el Cross Axis son, por ejemplo, `align-items` y `align-content`, que determinan cómo se alinean los elementos en el eje perpendicular.

## Ejemplo Visual de Main Axis y Cross Axis
Imagina un contenedor flex donde `flex-direction` es `row`:

```plaintext
Main Axis (left to right)
----------------------------------------------------
|     Item 1     |     Item 2     |     Item 3     |
----------------------------------------------------
           Cross Axis (top to bottom)
```
Si cambiamos `flex-direction` a `column`:
```plaintext
           Cross Axis (left to right)
           -------------------------
Main Axis |
  (top    |      Item 1
  to      |      Item 2
  bottom) |      Item 3
           -------------------------
```

## Propiedades que Operan en Main Axis y Cross Axis
**En el Main Axis:**
  * `justify-content`: Controla la alineación de los elementos flex a lo largo del Main Axis.

* **En el Cross Axis**:

  * `align-items`: Controla la alineación de los elementos flex en el Cross Axis.

  * `align-content`: Controla la alineación de las filas de los elementos flex en el Cross Axis (cuando hay varias filas de elementos, como al usar flex-wrap: wrap).