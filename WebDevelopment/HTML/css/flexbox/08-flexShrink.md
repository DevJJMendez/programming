# `flex-shrink`
La propiedad flex-shrink en CSS es una parte esencial de Flexbox que controla cómo los elementos dentro de un contenedor flexible se reducen cuando no hay suficiente espacio en el eje principal (horizontal en la mayoría de los casos). Esta propiedad es particularmente útil para garantizar que los elementos se ajusten al espacio del contenedor sin que se desborden, manteniendo así la estructura y la estética del diseño.

## ¿Qué es flex-shrink?
flex-shrink es una propiedad CSS que define la proporción en la cual un elemento puede reducir su tamaño si el espacio dentro de un contenedor flexible se vuelve insuficiente. El valor de flex-shrink representa una proporción numérica que determina qué tan agresivamente se reducirá el tamaño de un elemento en relación con los demás.

## Valores de flex-shrink
![flex shrink](images/flexShrink.png)

El valor de flex-shrink es un número no negativo (predeterminado en 1), y sus efectos varían según el valor en comparación con otros elementos. Estos son algunos valores comunes:

* 0: El elemento no se reducirá si el contenedor se queda sin espacio; en su lugar, puede provocar un desbordamiento.

* 1 o mayor: El elemento se reducirá proporcionalmente al espacio insuficiente.

Por ejemplo, si un elemento tiene flex-shrink: 2 y otro flex-shrink: 1, el primero se reducirá al doble de velocidad que el segundo cuando el espacio en el contenedor no sea suficiente.

## ¿Para qué sirve?
flex-shrink permite crear layouts adaptativos en los que los elementos se reducen de manera proporcional cuando el tamaño de pantalla o del contenedor es menor. Esto evita problemas de desbordamiento y permite que el diseño mantenga su estructura y funcionalidad sin requerir desplazamientos horizontales.

## ¿Qué problema resuelve?
Cuando el espacio de un contenedor es limitado, sin flex-shrink los elementos pueden desbordarse o solaparse, lo que afecta la claridad y el diseño del contenido. flex-shrink resuelve este problema al controlar cómo se contraen los elementos, permitiendo que cada uno reduzca su tamaño proporcionalmente y mantenga la legibilidad.

## ¿Cómo lo resuelve?
La propiedad flex-shrink resuelve este problema asignando una "proporción de contracción" a cada elemento dentro del contenedor. En un contenedor donde el espacio es insuficiente, los elementos con un valor flex-shrink mayor se reducirán más que aquellos con un valor menor, permitiendo una reducción equilibrada y controlada.

## Ejemplo Básico de flex-shrink
```html
<div class="contenedor">
  <div class="elemento">Elemento 1</div>
  <div class="elemento">Elemento 2</div>
  <div class="elemento">Elemento 3</div>
</div>
```
```css
.contenedor {
  display: flex;
  width: 400px;
  gap: 10px;
  background-color: lightgray;
}

.elemento {
  background-color: lightcoral;
  width: 200px;
  flex-shrink: 1;
}
```
En este ejemplo, cada elemento tiene un valor de flex-shrink: 1. Si el ancho del contenedor es menor que la suma de los anchos de los elementos, cada elemento se reducirá en la misma proporción.
