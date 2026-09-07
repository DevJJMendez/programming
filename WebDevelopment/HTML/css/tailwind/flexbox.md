# Flexbox
TailwindCSS ofrece clases utilitarias que te permiten trabajar con Flexbox de manera sencilla y rápida.

1. Activar el contenedor flex
   * Primero, para usar Flexbox, necesitas hacer que el contenedor sea un contenedor flex:

     * flex: Define un contenedor flex.

     * inline-flex: Define un contenedor flex en línea, lo que significa que el contenedor no romperá el flujo normal del documento (funciona como un display: inline-flex).

   * Ejemplo:
```html
<div class="flex">
  <!-- Elementos flexibles aquí -->
</div>
```

2. Dirección del eje principal (flex-direction)
   * El eje principal es el eje a lo largo del cual los elementos flexibles se distribuyen. Flexbox tiene dos direcciones principales:

     * flex-row: Elementos en una fila (por defecto).

     * flex-col: Elementos en una columna.

   * Ejemplo:
```html
<div class="flex flex-row">
  <!-- Elementos en fila -->
</div>

<div class="flex flex-col">
  <!-- Elementos en columna -->
</div>
```

3. Alineación de los elementos en el eje principal (justify-content)
   * Controla cómo los elementos se distribuyen a lo largo del eje principal (horizontal para flex-row o vertical para flex-col).
     * justify-start: Alineación al inicio (por defecto).
     * justify-center: Centrado.
     * justify-end: Alineación al final.
     * justify-between: Distribuye los elementos con espacio entre ellos.
     * justify-around: Distribuye los elementos con espacio alrededor de ellos.
     * justify-evenly: Distribuye los elementos con espacio uniforme entre ellos.

  * Ejemplo:
```html
<div class="flex justify-center">
  <!-- Elementos centrados -->
</div>

<div class="flex justify-between">
  <!-- Elementos distribuidos con espacio entre ellos -->
</div>
```

1. Alineación en el eje transversal (align-items)
   * Controla la alineación de los elementos en el eje transversal (opuesto al eje principal):
     * items-start: Alineación al inicio del contenedor.
     * items-center: Alineación al centro.
     * items-end: Alineación al final.
     * items-baseline: Alineación por la línea base del texto.
     * items-stretch: Estira los elementos para que ocupen todo el espacio disponible (por defecto).

   * Ejemplo:
```html
<div class="flex items-center">
  <!-- Elementos alineados verticalmente al centro -->
</div>

<div class="flex items-end">
  <!-- Elementos alineados al final -->
</div>
```

1. Alineación de elementos en el eje transversal (para un solo elemento) (align-self)
   * Alinea un solo elemento dentro del contenedor flex sin afectar a los demás:
     * self-auto: Alineación automática (por defecto).
     * self-start: Alineación al inicio del contenedor.
     * self-center: Alineación al centro del contenedor.
     * self-end: Alineación al final del contenedor.
     * self-stretch: Estira el elemento para que ocupe todo el espacio disponible.

   * Ejemplo:
```html
<div class="flex">
  <div class="self-center">Elemento centrado</div>
  <div>Otro elemento</div>
</div>
```

1. Flex Wrap (envolver elementos)
   * Si los elementos no caben en una sola línea (en una fila o columna), puedes hacer que se envuelvan en el contenedor flex:

     * flex-wrap: Permite que los elementos se envuelvan.
     * flex-nowrap: Evita que los elementos se envuelvan (por defecto).
     * flex-wrap-reverse: Los elementos se envuelven, pero en orden inverso.

   * Ejemplo:
```html
<div class="flex flex-wrap">
  <!-- Elementos que se envuelven en múltiples líneas -->
</div>
```

7. Orden de los elementos (order)
   * Controla el orden visual de los elementos dentro del contenedor flex. Por defecto, todos los elementos tienen el valor order-0.

     * order-1, order-2, ...: Define el orden visual de los elementos.

   * Ejemplo:
```html
<div class="flex">
  <div class="order-2">Elemento 2</div>
  <div class="order-1">Elemento 1</div>
</div>
```

8. Flex Grow, Shrink y Basis
   * flex-grow: Define qué tanto un elemento puede crecer en relación con los demás. Valor por defecto: 0.
   * flex-shrink: Define qué tanto un elemento puede reducirse en relación con los demás. Valor por defecto: 1.
   * flex-basis: Define el tamaño inicial del elemento antes de aplicar el grow o shrink.
   * flex-1: El elemento puede crecer para llenar el espacio disponible.
   * flex-auto: El elemento se ajusta a su tamaño basado en su contenido.
   * flex-initial: El elemento no crece ni se reduce.
   * flex-none: El elemento no crece ni se reduce (tamaño fijo).

   * Ejemplo:
```html
<div class="flex">
  <div class="flex-1">Este elemento crece</div>
  <div class="flex-none">Este elemento no crece</div>
</div>
```

9. Gap (espacio entre elementos)
   * Controla el espacio entre los elementos dentro de un contenedor flex.
     * gap-2, gap-4, gap-8, ...: Define el espacio entre los elementos en el contenedor flex.

   * Ejemplo:
```html
<div class="flex gap-4">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
</div>
```

## Buenas prácticas con Flexbox
* Usa flex-row por defecto: Es el comportamiento más común para organizar elementos en una fila.
* Usa flex-col cuando el diseño lo requiera, como en una barra lateral vertical o en dispositivos móviles.
* Aprovecha justify-between y justify-center para distribuir elementos de manera eficiente.
* Utiliza gap en lugar de márgenes manuales para crear espacio entre los elementos, especialmente en layouts flexibles.
* Piensa siempre en la responsividad: Las clases flex-wrap y flex-col son excelentes para adaptarse a pantallas pequeñas.