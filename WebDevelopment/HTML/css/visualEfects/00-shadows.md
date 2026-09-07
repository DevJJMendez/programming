# `box-shadows`
box-shadow es una propiedad de CSS que permite agregar sombras alrededor de los bordes de un elemento. Estas sombras pueden ser personalizadas en términos de desplazamiento, desenfoque, extensión y color.

## ¿Para qué sirve?
* Estética: Mejora la apariencia visual de los elementos, creando profundidad y realismo en el diseño.

* Enfatizar elementos: Resalta elementos importantes como botones, tarjetas o modales.

* Simular efectos tridimensionales: Da la impresión de que un elemento está elevado o flotando.

## ¿Qué resuelve?
* Falta de profundidad: Resuelve el diseño plano añadiendo capas visuales.

* Enfocar atención: Ayuda a dirigir la atención del usuario hacia elementos clave.

* Diseños dinámicos: Aporta dinamismo y modernidad al diseño web.

## ¿Cómo lo resuelve?
* Permite definir sombras con precisión mediante múltiples parámetros como desplazamiento horizontal, vertical, desenfoque, extensión y color.

* Soporta múltiples sombras para el mismo elemento, apilándolas en orden.

## **Sintaxis**
```css
box-shadow: offset-x offset-y blur-radius spread-radius color;
```
  * offset-x: Desplazamiento horizontal de la sombra. Puede ser positivo (hacia la derecha) o negativo (hacia la izquierda).

  * offset-y: Desplazamiento vertical de la sombra. Puede ser positivo (hacia abajo) o negativo (hacia arriba).

  * blur-radius (opcional): Define cuánto se difumina la sombra. El valor predeterminado es 0 (sin desenfoque).

  * spread-radius (opcional): Define cuánto se expande o contrae la sombra. Valores positivos hacen crecer la sombra; negativos la encogen.

  * color (opcional): Define el color de la sombra. Puede usarse cualquier valor válido de color en CSS.

Valores adicionales
  * inset (opcional): Cambia la sombra de externa a interna, haciéndola aparecer dentro de los bordes del elemento.

## Ejemplos
```css
div {
  box-shadow: 10px 10px 5px gray;
}
```
* Desplazamiento horizontal: 10px.

* Desplazamiento vertical: 10px.

* Desenfoque: 5px.

* Color: gris.

# `text-shadow`
La propiedad text-shadow en CSS es una herramienta utilizada para agregar sombras a los textos. Permite personalizar la apariencia del texto añadiendo efectos de profundidad, contraste o realce mediante sombras.

**Sintaxis**
```css
/* Sintaxis básica */
text-shadow: x-offset y-offset blur-radius color;
```
* Desplazamiento horizontal (x-offset): Define cuánto se mueve la sombra hacia la derecha o izquierda.

* Desplazamiento vertical (y-offset): Establece cuánto se mueve la sombra hacia arriba o abajo.

* Desenfoque (blur-radius) (opcional): Controla la difuminación de la sombra.

* Color (color) (opcional): Especifica el color de la sombra.