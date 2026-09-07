# Grid
En Tailwind, al igual que con Flexbox, puedes aplicar clases utilitarias directamente a los elementos para controlar el comportamiento del contenedor y los elementos dentro de él.

1. Activar el contenedor Grid
   * Para activar un contenedor grid, debes usar la clase grid en el contenedor.
     * grid: Define un contenedor como grid.
     * inline-grid: Define un contenedor grid en línea.

   * Ejemplo:
```html
<div class="grid">
  <!-- Elementos aquí -->
</div>
```

2. Número de columnas (grid-template-columns)
   * Puedes definir el número de columnas dentro del contenedor grid usando las clases de Tailwind para crear una rejilla de columnas.
     * grid-cols-{n}: Define el número de columnas que tendrá tu contenedor.

   * Ejemplo:
```html
<div class="grid grid-cols-3">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
</div>
```

3. Fracciones y unidades con Grid
   * TailwindCSS te permite usar el sistema de fracciones para dividir el espacio de manera proporcional:
     * grid-cols-1: 1 columna (toda la fila).
     * grid-cols-2: 2 columnas (la mitad).
     * grid-cols-3: 3 columnas.
     * grid-cols-4: 4 columnas, etc.

   * Ejemplo con fracciones:
```html
<div class="grid grid-cols-3 gap-4">
  <div class="col-span-1">Elemento 1</div>
  <div class="col-span-2">Elemento 2 (ocupa 2 columnas)</div>
  <div class="col-span-1">Elemento 3</div>
</div>
```

4. Definir filas (grid-template-rows)
   * De manera similar a las columnas, también puedes definir cuántas filas tendrá tu grid usando las clases:
     * grid-rows-{n}: Define el número de filas.

  * Ejemplo:
```html
<div class="grid grid-rows-3">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
</div>
```

5. Ajustar el espacio entre los elementos en la cuadrícula (gap)
   * La propiedad gap se utiliza para definir el espacio entre las filas y las columnas en el grid.
     * gap-{size}: Define el espacio entre los elementos del grid (por ejemplo: gap-4, gap-8).

   * Ejemplo:
```html
<div class="grid grid-cols-3 gap-4">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
</div>
```

6. Tamaño automático de las columnas o filas
   * Puedes usar unidades automáticas para que las filas y columnas se ajusten al contenido:
     * grid-cols-auto: Las columnas se ajustan automáticamente según el contenido.
     * grid-rows-auto: Las filas se ajustan automáticamente según el contenido.

   * Ejemplo:
```html
<div class="grid grid-cols-auto gap-4">
  <div>Elemento 1</div>
  <div>Elemento 2 (de tamaño variable)</div>
</div>
```

7. Ajustar el tamaño de las columnas con fr (fracciones)
   * La unidad fr se usa para repartir el espacio disponible de manera proporcional.
     * grid-cols-{fr}: Por ejemplo, grid-cols-3fr repartirá el espacio en 3 fracciones.
     * grid-cols-1fr 2fr: Define una columna que ocupe una fracción y otra que ocupe dos fracciones del espacio disponible.

   * Ejemplo:
```html
<div class="grid grid-cols-[1fr_2fr] gap-4">
  <div>Elemento 1 (1fr)</div>
  <div>Elemento 2 (2fr)</div>
</div>
```

8. Alineación de los elementos dentro de Grid
   * Puedes alinear los elementos dentro de la cuadrícula tanto en el eje horizontal (columnas) como en el eje vertical (filas).
     * justify-items-{start | center | end}: Alinea los elementos en el eje horizontal (dentro de sus columnas).
   * align-items-{start | center | end}: Alinea los elementos en el eje vertical (dentro de sus filas).
   * justify-content-{start | center | end | between | around | evenly}: Alinea el contenido del grid.
   * align-content-{start | center | end | stretch}: Alinea las filas del grid.

   * Ejemplo:
```html
<div class="grid grid-cols-3 justify-items-center gap-4">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
</div>
```

9. Colspan y Rowspan
   * Puedes hacer que los elementos ocupen más de una fila o columna utilizando las clases col-span y row-span.
     * col-span-{n}: Define cuántas columnas debe ocupar un elemento.
     * row-span-{n}: Define cuántas filas debe ocupar un elemento.

   * Ejemplo:
```html
<div class="grid grid-cols-3 gap-4">
  <div class="col-span-2">Elemento que ocupa 2 columnas</div>
  <div>Elemento en la tercera columna</div>
</div>
```

10. Configuración responsiva con Grid: Al igual que con Flexbox, Tailwind hace que trabajar con layouts responsivos sea muy fácil. Puedes usar breakpoints para modificar la cantidad de columnas o el comportamiento del grid dependiendo del tamaño de la pantalla.

    * Ejemplo de grid responsivo:
```html
<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
  <div>Elemento 4</div>
</div>
```
* grid-cols-1: Una columna en pantallas pequeñas.
* md:grid-cols-2: Dos columnas en pantallas medianas (>=768px).
* lg:grid-cols-4: Cuatro columnas en pantallas grandes (>=1024px).

correo
jira
