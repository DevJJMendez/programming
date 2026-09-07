# Display
display es una propiedad de CSS que controla el modelo de visualización de un elemento, es decir, la forma en que se representa en la interfaz del navegador. Al usar display, puedes definir si un elemento es tratado como un bloque, un elemento en línea, un contenedor de grilla, un contenedor de flexbox, entre otros.

## ¿Para qué sirve display?
display sirve para:

* Controlar la disposición y alineación de los elementos en la interfaz.

* Modificar la estructura y diseño de layouts en una página web.

* Optimizar el espacio mediante la adaptación de elementos en diferentes modelos, como grillas y flexboxes.

* Controlar la interacción entre elementos contiguos: por ejemplo, haciendo que ciertos elementos ocupen una línea completa o se alineen uno tras otro.

## ¿Qué resuelve display?
display resuelve la necesidad de organizar y controlar cómo los elementos ocupan el espacio y se relacionan entre sí en una interfaz. Dependiendo del valor de display, un elemento puede comportarse como un bloque completo, una línea en medio del texto, o como un contenedor flexible, lo que ayuda a resolver problemas como:

* Alinear elementos: por ejemplo, colocar elementos uno al lado del otro o hacer que ocupen una línea completa.

* Construir layouts complejos sin necesidad de anidar muchos elementos.

* Mejorar la legibilidad y la organización visual al adaptar la visualización de los elementos a diferentes necesidades.

## ¿Cómo lo resuelve?
La propiedad display permite cambiar entre varios tipos de visualización. Al aplicar un valor específico de display, el navegador organiza el contenido y calcula el espacio de manera acorde. A continuación, se explican algunos de los valores principales de display y cómo afectan el comportamiento de los elementos.

## Valores principales de display
1. **`display: block`;**

   * Hace que el elemento se comporte como un bloque, ocupando toda la anchura disponible.

   * Empieza en una nueva línea y empuja cualquier contenido adyacente hacia abajo.

   * Ejemplo: `<div>`, `<h1>`, `<p>` son elementos que por defecto usan `display: block`.

```css
.block {
    display: block;
    width: 100%;
    background-color: lightblue;
}
```

2. **`display: inline;`**

   * Hace que el elemento se comporte como un elemento en línea, ocupando solo el ancho de su contenido.

   * No inicia en una nueva línea y permite que otros elementos se dispongan en la misma línea.

   * Ejemplo: `<span>`, `<a>`, `<strong>` son elementos que por defecto usan `display: inline`.

```css
.inline {
    display: inline;
    background-color: lightcoral;
}
```

3. **`display: inline-block;`**
   
   * Combina las propiedades de inline y block.

   * Permite que el elemento esté en línea con otros, pero permite establecerle un tamaño (width y height).

   * Muy útil para crear botones o mini-cards que se ajustan dentro de un contenedor pero permiten personalización de dimensiones.

```css
.inline-block {
    display: inline-block;
    width: 150px;
    height: 100px;
    background-color: lightgreen;
}
```

4. **`display: flex;`**

   * Hace que el elemento se comporte como un contenedor de Flexbox.

   * Los elementos hijos se organizan en una fila o columna flexible y adaptativa.

   * Simplifica la alineación horizontal, vertical y el ajuste automático de espacio entre elementos.

```css
.flex-container {
    display: flex;
    gap: 10px;
    background-color: lightyellow;
}
.flex-item {
    background-color: lightpink;
    padding: 20px;
}
```

5. **`display: grid;`**

   * Convierte el elemento en un contenedor de grilla CSS.

   * Facilita la creación de layouts complejos con filas y columnas definidas.

   * Permite un control detallado del posicionamiento de elementos en un espacio bidimensional.

```css
.grid-container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 10px;
    background-color: lavender;
}
.grid-item {
    background-color: lightsteelblue;
    padding: 20px;
}
```

6. **`display: none;`**

   * Oculta el elemento, sin ocupar espacio en el flujo del documento.

   * Útil para contenido condicional que debe mostrarse solo en ciertos contextos, como menús desplegables.

```css
.hidden {
    display: none;
}
```

## Ventajas de display
* **Control sobre el flujo del contenido**: puedes hacer que los elementos se alineen en línea, en bloque, o se comporten como contenedores flexibles o de grilla.

* Facilidad para construir layouts complejos con **`flex`** y **`grid`**, que simplifican mucho el trabajo de organizar el contenido.

* **Optimización visual y responsiva**: controlando cómo los elementos ocupan espacio y se relacionan, display ayuda a adaptar los layouts a diferentes tamaños de pantalla.