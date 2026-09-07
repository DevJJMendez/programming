# `grid-row`
La propiedad grid-row en CSS Grid es similar a grid-column, pero en lugar de actuar sobre las columnas, se aplica a las filas de un Grid Container. Permite especificar dónde empieza y termina un elemento en el eje vertical, lo que da control sobre la posición y tamaño de un Grid Item en términos de filas.

## ¿Qué es grid-row?
grid-row es una propiedad abreviada de CSS Grid que define en una sola línea tanto la fila inicial como la fila final que ocupa un Grid Item dentro de la cuadrícula.

## ¿Para qué sirve grid-row?
Esta propiedad se utiliza para:

* Posicionar un Grid Item en el eje vertical de una cuadrícula.

* Establecer la altura de un Grid Item al indicarle cuántas filas debe abarcar.

* Organizar elementos en layouts más complejos, como paneles de control, sistemas de administración, o cualquier diseño que requiera que los elementos se distribuyan en varias filas.

## ¿Qué problema resuelve grid-row?
Antes de CSS Grid, la manipulación de la altura de un elemento o su ubicación vertical era un desafío que requería métodos de manipulación complejos con propiedades como position, float, y clear, o incluso estructuras de HTML adicionales. Con grid-row, CSS Grid permite especificar la ubicación vertical de un elemento con precisión, simplificando el código y mejorando la flexibilidad del diseño.

## ¿Cómo lo resuelve grid-row?
grid-row permite asignar líneas de inicio y fin en el eje de las filas dentro del contenedor de cuadrícula. Esto da un control preciso sobre el tamaño y la posición del elemento en términos de filas.

## Sintaxis de grid-row
```css
.item {
    grid-row: <start> / <end>;
}
```
* `<start>`: Especifica la fila donde comienza el Grid Item.

* `<end>`: Especifica la fila donde termina el Grid Item.

Al igual que grid-column, los valores de grid-row pueden ser números o nombres de líneas.

## Ejemplos de Uso de grid-row
* Ejemplo 1: Posicionar un Elemento en Varias Filas
```css
.item {
    grid-row: 1 / 3; /* El Grid Item ocupa desde la fila 1 hasta la fila 3 */
}
```
En este caso, el Grid Item abarca dos filas (1 y 2).

* Ejemplo 2: Ocupando Todas las Filas Restantes
```css
.item {
    grid-row: 1 / -1; /* El Grid Item ocupa todas las filas restantes */
}
```
Aquí, el item se extiende desde la primera fila hasta la última.

* **Ejemplo 3: Uso de span en grid-row**, Para indicar cuántas filas debe ocupar sin especificar el punto de fin:
```css
.item {
    grid-row: span 2; /* El Grid Item ocupa dos filas desde su inicio */
}
```
El elemento comienza en su posición y se extiende a través de dos filas.