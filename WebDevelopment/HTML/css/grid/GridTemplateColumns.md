# `grid-template-columns`
La propiedad **grid-template-columns** es una de las propiedades clave en CSS Grid. Se usa para definir la estructura de las columnas dentro de un Grid Container, especificando la cantidad de columnas, así como su tamaño.

## ¿Qué es grid-template-columns?
grid-template-columns es una propiedad CSS que permite definir el número, tamaño, y disposición de las columnas en un Grid Container. Esta propiedad convierte el contenedor en una cuadrícula de columnas con tamaños específicos, en las cuales se organizan los elementos internos (Grid Items).

## ¿Para qué sirve grid-template-columns?
grid-template-columns sirve para:

* Definir la estructura y disposición de las columnas en una cuadrícula.

* Controlar el ancho de cada columna, lo que permite ajustar el layout sin cambiar la posición de los elementos manualmente.

* Crear layouts complejos y organizados sin necesidad de flotantes, posicionamiento absoluto, o configuraciones CSS complicadas.

En otras palabras, esta propiedad permite crear columnas y organizarlas de manera que el diseño de la página sea claro, adaptado, y fácil de mantener.

## ¿Qué problema resuelve grid-template-columns?
**grid-template-columns** resuelve varios problemas de diseño, incluyendo:

* Distribución inconsistente de columnas: Antes de CSS Grid, crear una cuadrícula de columnas iguales o distribuidas proporcionalmente era complicado. grid-template-columns simplifica esta tarea.

* Creación de layouts responsivos: Permite crear layouts que se adaptan a diferentes tamaños de pantalla.

* Control sobre el ancho de cada columna: Proporciona flexibilidad para asignar diferentes tamaños a cada columna, ajustándolas con unidades flexibles o fijas.

## ¿Cómo resuelve grid-template-columns estos problemas?
grid-template-columns resuelve estos problemas al permitir el uso de unidades flexibles y configuraciones de repetición para definir las columnas de manera adaptable. Algunas opciones incluyen:

* **Unidades fraccionadas (`fr`)**: Distribuyen el espacio de manera proporcional.

* **Unidades fijas (`px`, `%`)**: Controlan el tamaño fijo de las columnas.

* **Función `repeat()`**: Permite definir un patrón de columnas repetidas, simplificando el código y haciéndolo más legible.

* **Función `minmax()`**: Permite que una columna tenga un tamaño mínimo y máximo, adaptándose al espacio disponible.

## Conceptos clave y ejemplos de uso de grid-template-columns
### Definir columnas con valores fijos
Puedes definir columnas con anchos específicos, como `px`, `%`, `em`, etc.
```css
.grid-container {
    display: grid;
    grid-template-columns: 100px 200px 100px;
}
```
Este código crea un contenedor de cuadrícula con tres columnas: la primera de `100px`, la segunda de `200px` y la tercera de `100px`.

### Usar fr para columnas flexibles
`fr` es una unidad especial en CSS Grid que representa una fracción del espacio disponible. Es útil para crear columnas que ocupen todo el espacio restante.
```css
.grid-container {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
}
```
En este caso:
* La primera y tercera columna ocuparán el **`25%`** cada una (1 fracción).

* La segunda columna ocupará el **`50%`** (2 fracciones).

### Repetir columnas con repeat()
La función `repeat()` permite crear un patrón de columnas repetido, simplificando el código cuando necesitas varias columnas con el mismo tamaño.
```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
}
```
Aquí se crean tres columnas iguales, cada una ocupando una fracción (1fr) del espacio disponible.

### Uso de minmax() para tamaño adaptable
`minmax()` define un tamaño mínimo y máximo para cada columna, permitiendo que se adapten al espacio disponible.
```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(3, minmax(100px, 1fr));
}
```
En este caso, cada columna tendrá un tamaño mínimo de 100px y podrá crecer hasta una fracción (1fr) del espacio disponible.

### Unidades mixtas en grid-template-columns
Es posible combinar unidades fijas y flexibles en una misma declaración, lo cual es útil cuando necesitas algunas columnas de tamaño fijo y otras que ocupen el espacio restante.
```css
.grid-container {
    display: grid;
    grid-template-columns: 200px 1fr 2fr;
}
```
Aquí:
* La primera columna tiene un ancho fijo de 200px.

* La segunda y tercera columnas ocupan el resto del espacio, con la tercera ocupando el doble que la segunda.

## Buenas prácticas al usar grid-template-columns
* **Usa unidades `fr` para diseño flexible**: Esta unidad es ideal para hacer columnas que se adapten al tamaño del contenedor.

* **Combina `repeat()` y `minmax()` para lograr flexibilidad en el layout**: Estas funciones permiten crear configuraciones más eficientes y fáciles de mantener.

* **Aplica `grid-template-columns` junto con media queries**: Esta práctica permite adaptar el layout a diferentes resoluciones.

* **Utiliza un diseño progresivo**: Comienza con una columna en dispositivos móviles y aumenta el número de columnas en pantallas más grandes.