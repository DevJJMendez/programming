# `float`
La propiedad float en CSS es una de las propiedades más antiguas utilizadas para el diseño de páginas web, especialmente para controlar la alineación de elementos dentro de un contenedor. Aunque su uso ha disminuido con la llegada de nuevas propiedades como flexbox y grid, sigue siendo relevante en muchos contextos.

## ¿Qué es float?
La propiedad float permite que un elemento "flote" a la izquierda o a la derecha dentro de su contenedor, lo que hace que los elementos posteriores puedan rodearlo, en lugar de estar debajo de él.

En resumen, float mueve un elemento hacia la izquierda o la derecha de su contenedor y permite que los elementos contiguos fluyan alrededor de él.

## ¿Para qué sirve float?
* Alineación de contenido: Se usa para alinear un bloque de contenido hacia la izquierda o hacia la derecha dentro de su contenedor.

* Diseño de columnas: Tradicionalmente, float se usaba para crear diseños de múltiples columnas, haciendo que los elementos flotaran uno al lado del otro.

* Rodear elementos: Permite que el texto o los elementos fluyan alrededor de imágenes o cualquier otro bloque flotante.

## ¿Qué resuelve float?
float resuelve el problema de alinear o ajustar elementos dentro de un contenedor de forma horizontal sin necesidad de usar posicionamiento absoluto o márgenes complicados. Es útil especialmente cuando se quiere crear diseños donde los elementos se alinean en una fila y los demás elementos pueden fluir alrededor de ellos, como es el caso de las imágenes y los textos en artículos o blogs.

Antes de la introducción de flexbox y grid, el uso de float era una de las formas más comunes de crear layouts de múltiples columnas.

## ¿Cómo lo resuelve?
float puede tomar tres valores principales:

1. **`left`**: Hace que el elemento flote hacia la izquierda dentro de su contenedor. Los elementos posteriores (como texto o imágenes) fluirán alrededor de él, a la derecha.
```css
.float-left {
    float: left;
}
```

2. **`right`**: Hace que el elemento flote hacia la derecha. Los elementos posteriores fluirán alrededor de él, a la izquierda.
```css
.float-right {
    float: right;
}
```

3. **`none`**: Este es el valor por defecto. Significa que el elemento no flota y se comporta de manera normal, es decir, se apila debajo de los elementos previos.
```css
.no-float {
    float: none;
}
```

## El comportamiento de los elementos flotantes
Cuando un elemento se aplica float, el contenido posterior en el flujo normal de la página "fluirá" alrededor del elemento flotante. Sin embargo, un problema común es que el contenedor del elemento flotante colapsa y no reconoce que hay elementos flotantes dentro de él, lo que puede hacer que su altura desaparezca, afectando el diseño.

## Solución al colapso del contenedor flotante
Para solucionar este problema, se puede usar el clearfix. Esto se logra aplicando una técnica CSS en el contenedor que hace que "reconozca" la altura de los elementos flotantes. La manera común de hacerlo es añadir un elemento vacío con la clase clearfix al final del contenedor:
```css
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
```
Y en HTML:
```html
<div class="container clearfix">
    <img src="image.jpg" class="float-left" alt="Imagen flotante">
    <p>Texto que fluye alrededor de la imagen...</p>
</div>
```