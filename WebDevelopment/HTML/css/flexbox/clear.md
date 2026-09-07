# `clear`
La propiedad clear en CSS es una propiedad utilizada para controlar cómo los elementos se comportan con respecto a los elementos flotantes (es decir, aquellos elementos que tienen la propiedad float activada). Se usa principalmente para "detener" el flujo de los elementos flotantes y garantizar que los elementos siguientes no queden alrededor de ellos, sino que se alineen debajo de ellos.

¿Qué es clear?
La propiedad clear se utiliza para especificar en qué dirección un elemento puede flotar o no flotar. Su función principal es hacer que un elemento se "limpie" de los elementos flotantes previos y se mueva hacia abajo, debajo de los elementos flotantes, en lugar de quedar a su lado.

¿Para qué sirve clear?
Evitar que los elementos fluyan alrededor de los flotantes: Cuando un elemento tiene flotantes alrededor, puedes usar clear para asegurarte de que un elemento no se superponga ni quede al lado de estos elementos flotantes. En lugar de eso, se "limpia" y se mueve hacia abajo, en el flujo normal del documento.

Controlar el flujo del diseño: En diseños complejos donde se usan flotantes (por ejemplo, para crear columnas), clear puede garantizar que un elemento se posicione de forma correcta debajo de los flotantes previos.

Controlar el contenedor de los elementos flotantes: Al utilizar clear en un elemento dentro de un contenedor, se puede evitar que el contenedor se colapse debido al uso de float dentro de él.

¿Qué resuelve clear?
La propiedad clear resuelve varios problemas relacionados con el uso de la propiedad float:

Evitar la superposición de elementos: Si un elemento flotante está al lado de otros elementos, estos pueden alinearse a su alrededor, pero puede que no se comporten como se espera. clear asegura que el siguiente elemento no se ubique al lado de un flotante, sino debajo de él.

Colapso del contenedor flotante: Cuando se utilizan flotantes, el contenedor que los incluye puede colapsar y no reconocer la altura de los elementos flotantes. El uso de clear en un elemento después de los flotantes garantiza que el contenedor se expanda correctamente.

Mejora el control en layouts complejos: Al crear múltiples columnas o elementos flotantes en una página, clear proporciona un control adicional para alinear los elementos que siguen a los flotantes.

## ¿Cómo lo resuelve?
La propiedad clear se aplica principalmente a los elementos que vienen después de los elementos flotantes. Al usar clear, se garantiza que un elemento se coloque debajo de los elementos flotantes, no a su lado.

Valores de clear
none (valor por defecto): El valor por defecto de clear es none, lo que significa que no se aplican restricciones al elemento siguiente. Los elementos flotantes pueden alinearse junto a este elemento sin ningún problema.

left: Hace que el elemento se ubique debajo de los elementos flotantes a la izquierda. Es decir, el elemento se "limpia" de los flotantes que están a la izquierda de su contenedor y se mueve hacia abajo, para no quedar a su lado.
```css
.clear-left {
    clear: left;
}
```
right: Hace que el elemento se ubique debajo de los elementos flotantes a la derecha. El elemento no se alineará a la derecha de los elementos flotantes, sino debajo de los flotantes que están a la derecha.
```css
.clear-right {
    clear: right;
}
```
both: Hace que el elemento se ubique debajo de cualquier flotante, ya sea a la izquierda o a la derecha. Es útil cuando un elemento tiene flotantes a ambos lados y quieres que se alinee debajo de ellos.
```css
.clear-both {
    clear: both;
}
```