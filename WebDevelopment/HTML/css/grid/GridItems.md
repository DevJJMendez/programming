# Grid Items
Los Grid Items son los elementos directos contenidos en un Grid Container. Son los bloques en los que se organiza el contenido cuando trabajamos con CSS Grid, y cada uno de ellos ocupa una o varias "celdas" de la cuadrícula, según cómo configuremos el diseño.

## ¿Qué son los Grid Items?
Los Grid Items son los elementos hijos inmediatos dentro de un contenedor de cuadrícula. Estos elementos pueden ser cualquier tipo de contenido HTML, como **`div`**, **`header`**, **`footer`**, o cualquier otra etiqueta de HTML, y se organizan dentro de la cuadrícula establecida por el Grid Container.

## ¿Para qué sirven los Grid Items?
Los Grid Items sirven para:

* Organizar el contenido dentro del layout de cuadrícula.

* Definir el tamaño y la posición de cada elemento en filas y columnas.

* Controlar cómo se distribuye el contenido tanto en el eje horizontal como en el vertical.

Usando propiedades específicas, puedes hacer que los Grid Items ocupen más de una celda en cualquier dirección, ajusten su tamaño, alineación y orden.

## ¿Qué problema resuelven los Grid Items?
Los Grid Items ayudan a controlar la colocación exacta y el comportamiento de los elementos dentro de un diseño de cuadrícula. Esto era complejo de lograr antes de CSS Grid, donde dependíamos de trucos de posicionamiento, márgenes negativos y combinaciones de flexbox y float. Con Grid, los elementos se pueden posicionar fácilmente sin afectar el flujo del contenido.

## ¿Cómo se controlan los Grid Items?
CSS Grid proporciona diversas propiedades que se aplican directamente en los Grid Items para especificar su posición, tamaño y alineación.

### [grid-column](GridColumns.md) y [grid-row](GridRows.md)
Permiten controlar la posición de un Grid Item en filas y columnas específicas.
```css
.item {
    grid-column: 1 / 3; /* El item ocupa desde la columna 1 hasta la 3 */
    grid-row: 1 / 2;    /* El item ocupa la fila 1 */
}
```
En este ejemplo:
* `grid-column: 1 / 3` hace que el Grid Item abarque desde la columna 1 hasta la columna 3 (2 columnas).

* `grid-row: 1 / 2` hace que el Grid Item ocupe solo la fila 1.

### grid-column-start, grid-column-end, grid-row-start, grid-row-end
Son propiedades más detalladas para definir el inicio y fin de los Grid Items en filas y columnas
```css
.item {
    grid-column-start: 2; /* Comienza en la columna 2 */
    grid-column-end: 4;   /* Termina en la columna 4 */
    grid-row-start: 1;    /* Comienza en la fila 1 */
    grid-row-end: 3;      /* Termina en la fila 3 */
}
```
Estas propiedades son útiles cuando quieres un control específico sobre el inicio y el final de cada Grid Item, especialmente en layouts complejos.

### `justify-self` y `align-self`
Permiten ajustar la alineación horizontal y vertical de un Grid Item en su celda respectiva.
```css
.item {
    justify-self: center; /* Centra el item horizontalmente */
    align-self: end;      /* Alinea el item al final verticalmente */
}
```
* justify-self controla la alineación horizontal del item dentro de su celda (start, end, center, stretch).

* align-self controla la alineación vertical del item dentro de su celda (start, end, center, stretch).

### order
Aunque order es una propiedad más conocida en flexbox, también funciona en CSS Grid para cambiar el orden visual de los elementos sin alterar su posición en el HTML.
```css
.item {
    order: 2; /* El item se mueve al orden visual 2 */
}
```

## Buenas prácticas al usar grid-column
* Definir explícitamente grid-template-columns en el contenedor para evitar comportamientos inesperados.

* Evitar el uso excesivo de grid-column para mantener el diseño simple. Solo usarlo cuando el diseño lo requiere.

* Combinar con otras propiedades como grid-template-rows, grid-row, justify-items, y align-items para maximizar la flexibilidad de CSS Grid.