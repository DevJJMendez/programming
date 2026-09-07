# Grid
CSS Grid es un poderoso sistema de diseño bidimensional en CSS que te permite organizar elementos en una cuadrícula flexible y estructurada. Es una herramienta esencial para los desarrolladores frontend, ya que facilita la creación de layouts complejos y responsivos sin depender tanto de hacks o estructuras HTML adicionales.

##  ¿Qué es CSS Grid?
CSS Grid es una especificación de CSS que permite crear layouts basados en una cuadrícula. En esencia, crea una "rejilla" de **filas** y **columnas** en la que puedes colocar y alinear elementos con gran precisión. Grid es diferente de otras técnicas como **Flexbox** porque funciona en dos dimensiones (filas y columnas), mientras que Flexbox se centra en una sola dimensión (fila o columna).

![grid](/assets/grid-example.webp)

##  ¿Para qué sirve CSS Grid?
CSS Grid es ideal para construir layouts complejos que requieren múltiples filas y columnas, como:

* Dashboards

* Galerías de imágenes

* Diseños de tipo revista o periódico

* Formularios avanzados

* Estructuras de sitio web con secciones complejas

## ¿Qué problema resuelve CSS Grid?
Antes de CSS Grid, los desarrolladores dependían de soluciones complejas como `float`, `positioning`, o el uso de **Flexbox** (aunque Flexbox no fue diseñado para grids complejos). Estos métodos requerían muchas líneas de código extra y tenían limitaciones para crear layouts consistentes y ajustables. CSS Grid resuelve estos problemas al proporcionar una forma intuitiva y nativa de CSS para:

* Diseñar y controlar tanto filas como columnas simultáneamente

* Crear layouts sin necesidad de clases auxiliares ni contenedores adicionales

* Permitir diseños responsive fácilmente, adaptando el número de columnas o filas según el tamaño de pantalla.

## ¿Cómo resuelve CSS Grid estos problemas?
CSS Grid define un contenedor principal (llamado **grid container**) y sus elementos internos (**grid items**), en los cuales puedes:

* Establecer el número de filas y columnas con precisión.

* Definir tamaños específicos, proporcionales o automáticos para cada fila o columna.

* Colocar elementos en posiciones específicas de la cuadrícula (p. ej., hacer que ocupen varias columnas o filas).

* Controlar el espacio entre filas y columnas con propiedades como `gap`.

* Usar unidades flexibles y adaptables, como **`fr` (fracciones de espacio)** para crear layouts responsivos.

## Grid Container y Grid Items
Para usar CSS Grid, primero necesitas un grid container. Al aplicar `display: grid` en un contenedor, éste se convierte en un **grid container**, y todos los elementos directos dentro de él se convierten en **grid items**.

```css
.grid-container {
    display: grid;
}
```

### Definir filas y columnas
Las propiedades principales para definir las filas y columnas en CSS Grid son `grid-template-columns` y `grid-template-rows`. Estas propiedades aceptan valores como tamaños fijos (`px`, `%`, `em`, etc.), proporciones (**`fr`**), o `auto`.
```css
.grid-container {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr; /* Tres columnas, de las cuales la segunda es el doble de ancha */
    grid-template-rows: 100px auto 100px; /* Tres filas, la del medio con tamaño automático */
}
```

## Propiedades importantes de CSS Grid
* **`grid-template-columns`** y **`grid-template-rows`**: define el tamaño y número de columnas y filas.

* **`grid-gap` o `gap`**: crea espacio entre filas y columnas.

* **`grid-column` y `grid-row`**: posiciona y hace que un elemento ocupe varias filas o columnas.

* **`grid-area`**: permite nombrar secciones en una cuadrícula y posicionarlas de manera intuitiva.

* **`auto-fill`** y **`auto-fit`**: combinados con `repeat()` permiten crear diseños responsivos que adaptan el número de columnas o filas al tamaño del contenedor.

### Ejemplo de diseño responsive con Grid
Para hacer una cuadrícula de 3 columnas en pantallas grandes que se reduzca a 1 columna en pantallas pequeñas:
```css
.grid-container {
    display: grid;
    gap: 10px;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
}
```

## Buenas prácticas
* Usa **`fr`** en lugar de **`%`** para que las columnas o filas sean proporcionales.

* Define un diseño móvil primero y utiliza minmax para adaptar el layout a pantallas más grandes.

* Evita valores fijos excesivos en `grid-template-columns` y `grid-template-rows` a menos que realmente los necesites, para permitir una cuadrícula más flexible.

* Aprovecha gap para espaciados en lugar de margenes en los elementos para mantener la coherencia.

---
[](GridContainer.md)
![grid-example](../../assets/cssGrid.webp)