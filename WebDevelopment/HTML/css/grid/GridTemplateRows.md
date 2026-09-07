# `grid-template-rows`
La propiedad `grid-template-rows` en CSS Grid es similar a `grid-template-columns`, pero se aplica para definir la estructura de las filas dentro de un contenedor de cuadrícula (**Grid Container**). Con esta propiedad, puedes especificar la cantidad de filas y sus alturas para organizar el diseño de manera efectiva.

##  ¿Qué es grid-template-rows?
grid-template-rows es una propiedad CSS que permite definir el número de filas, su altura y disposición en un contenedor de cuadrícula. Ayuda a estructurar el layout vertical de los elementos hijos dentro del Grid Container.

##  ¿Para qué sirve grid-template-rows?
grid-template-rows es útil para:

* Definir la altura de las filas en un layout de cuadrícula.

* Controlar la disposición vertical de los elementos en el contenedor.

* Crear estructuras de diseño en filas sin necesidad de usar márgenes, paddings o posiciones absolutas.

## ¿Qué problema resuelve grid-template-rows?
grid-template-rows resuelve el problema de control preciso sobre la distribución vertical de los elementos en un contenedor, algo que antes de CSS Grid era difícil de lograr sin utilizar trucos como position: absolute o float. También facilita el diseño de layouts consistentes y adaptables en múltiples resoluciones de pantalla.

Además, permite controlar la altura de cada fila independientemente, lo cual es esencial para crear layouts uniformes o adaptables, que se vean bien en diferentes tamaños de pantalla.

## ¿Cómo lo resuelve grid-template-rows?
grid-template-rows resuelve estos problemas mediante el uso de unidades flexibles y configuraciones que ajustan la altura de las filas según el contenido o el espacio disponible. Aquí algunas opciones comunes:

* Unidades fijas (`px`, `%`): Permiten definir filas con altura específica.

* Unidades flexibles (`fr`): Ajustan la altura en función del espacio disponible en el contenedor.

* Funciones `repeat()` y `minmax()`: Facilitan la repetición de patrones y el ajuste automático de las filas según el tamaño del contenido.

## Conceptos clave y ejemplos de uso de grid-template-rows
### Definir filas con valores fijos
```css
.grid-container {
    display: grid;
    grid-template-rows: 100px 200px 100px;
}
```
Este ejemplo define tres filas:
* La primera fila tiene 100px de altura.

* La segunda fila tiene 200px de altura.

* La tercera fila tiene 100px de altura.

### Usar la unidad fr (fracción) para filas flexibles
La unidad `fr` permite que las filas ocupen espacio proporcionalmente, dependiendo del contenedor y del espacio disponible.

```css
.grid-container {
    display: grid;
    grid-template-rows: 1fr 2fr 1fr;
}
```
Aquí:
* La primera y tercera fila ocupan una fracción (1fr) del espacio vertical.

* La segunda fila ocupa el doble de espacio (2fr).

###  Repetir filas con repeat()
La función repeat() simplifica la creación de filas con un mismo tamaño.
```css
.grid-container {
    display: grid;
    grid-template-rows: repeat(3, 1fr);
}
```
En este caso, el contenedor tendrá tres filas iguales, cada una ocupando una fracción del espacio disponible.

### Uso de minmax() para tamaño adaptable
La función minmax() permite que una fila tenga un tamaño mínimo y máximo, adaptándose al contenido y al espacio del contenedor.
```css
.grid-container {
    display: grid;
    grid-template-rows: minmax(100px, 1fr) 200px minmax(100px, auto);
}
```
Aquí:
* La primera fila tendrá una altura mínima de 100px y crecerá hasta 1fr si hay espacio disponible.

* La segunda fila tendrá 200px de altura fija.

* La tercera fila tendrá una altura mínima de 100px y se ajustará automáticamente en función del contenido.

### Unidades mixtas en grid-template-rows
Es posible combinar unidades fijas y flexibles en una misma declaración para hacer layouts mixtos.
```css
.grid-container {
    display: grid;
    grid-template-rows: 100px 2fr auto;
}
```
En este caso:
* La primera fila tiene una altura fija de 100px.

* La segunda fila ocupa el doble de espacio que una fila de 1fr.

* La tercera fila se adapta automáticamente al contenido.

## Buenas prácticas al usar grid-template-rows
* Usa fr cuando sea posible para crear filas que se adapten al espacio del contenedor.

* Combina repeat() y minmax() para simplificar y hacer más flexible el diseño.

* Aplica grid-template-rows junto con media queries para crear layouts responsivos.

* Usa valores fijos para filas de encabezado o pie de página: Esto permite mantener secciones con un tamaño consistente y mejorar la accesibilidad y la estructura visual.