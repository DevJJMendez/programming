# `flex-wrap`
La propiedad flex-wrap en CSS es una de las propiedades fundamentales de Flexbox y permite controlar si los elementos dentro de un contenedor flexible deben permanecer en una sola línea o moverse a varias líneas cuando no hay suficiente espacio para contenerlos en una sola. Esto es especialmente útil para diseños responsivos y adaptables en los que el espacio puede variar según el tamaño de pantalla.

## ¿Qué es flex-wrap?
flex-wrap es una propiedad de CSS que determina si los elementos en un contenedor de tipo flex (display: flex) deben "envolverse" o permanecer en una sola línea cuando el ancho del contenedor es insuficiente para contener todos los elementos.

## Valores de flex-wrap
flex-wrap puede recibir tres valores principales:

* nowrap: Los elementos se colocan en una sola línea, sin importar si el contenedor es más pequeño que el total de los elementos. Este es el valor predeterminado.

* wrap: Los elementos se envuelven en líneas adicionales cuando ya no caben en una sola línea.

* wrap-reverse: Similar a wrap, pero las nuevas líneas se organizan en orden inverso, es decir, las nuevas líneas aparecen en la parte superior del contenedor en lugar de abajo.

## ¿Para qué sirve?
La propiedad flex-wrap sirve para gestionar el comportamiento de los elementos flexibles cuando el espacio en el contenedor es limitado. Facilita la creación de layouts responsivos en los que los elementos pueden moverse a nuevas líneas de manera automática, optimizando el uso del espacio.

## ¿Qué problema resuelve?
flex-wrap resuelve el problema de la organización y adaptabilidad de elementos en un layout cuando el tamaño del contenedor es insuficiente para mantener todos los elementos en una sola línea. Sin flex-wrap, los elementos podrían comprimirse demasiado, comprometiendo la legibilidad y la estética del diseño.

## ¿Cómo lo resuelve?
Lo resuelve permitiendo que los elementos "salten" a la siguiente línea (o a varias líneas) cuando no hay suficiente espacio disponible en la línea principal. Esto permite que el diseño se adapte automáticamente sin necesidad de cambiar el código HTML o CSS adicional para diferentes tamaños de pantalla.