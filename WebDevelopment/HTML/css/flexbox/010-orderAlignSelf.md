# `order`
La propiedad order permite especificar el orden visual de los elementos dentro de un contenedor flex. Esta propiedad asigna un valor numérico a cada elemento, indicando la posición en la que deben aparecer, independientemente de su orden en el HTML.

## ¿Para qué sirve?
order se utiliza para reorganizar visualmente los elementos de un contenedor flex sin cambiar la estructura HTML. Esto permite disponer los elementos según las necesidades de diseño, especialmente útil en layouts adaptables o en aplicaciones donde el orden de los elementos pueda variar entre dispositivos.

## ¿Qué problema resuelve?
Normalmente, el orden de los elementos en HTML determina el orden en el que aparecen en la pantalla. Esto puede ser limitante, ya que reorganizar el contenido en HTML afecta la estructura y accesibilidad. order permite cambiar el orden visual sin modificar el HTML, manteniendo una estructura accesible y permitiendo ajustes en el layout en diferentes resoluciones o dispositivos.

## ¿Cómo lo resuelve?
Asignando valores numéricos a order, donde:

* Un número menor se coloca antes en la fila o columna flexible.

* Un número mayor se coloca después.

El valor predeterminado es order: 0. Los valores negativos, como order: -1, colocan el elemento antes que otros con valor order: 0.

Ejemplo
```html
<div class="contenedor">
  <div class="elemento" style="order: 2;">Elemento 1</div>
  <div class="elemento" style="order: -1;">Elemento 2</div>
  <div class="elemento" style="order: 1;">Elemento 3</div>
</div>
```
En este caso, Elemento 2 aparecerá primero, luego Elemento 3, y Elemento 1 al final, a pesar del orden en HTML.

# `align-self`
La propiedad align-self controla la alineación de un elemento individual dentro de un contenedor flex. Es una propiedad individual que sobrescribe el valor de align-items solo para el elemento específico.

## ¿Para qué sirve?
align-self permite personalizar la alineación vertical (o transversal en Flexbox) de un elemento dentro de un contenedor flexible, útil cuando un elemento necesita un alineamiento diferente del resto. Esto es común en layouts con elementos destacados o desiguales en su contenido.

## ¿Qué problema resuelve?
align-items alinea todos los elementos en un contenedor de manera uniforme. Sin embargo, si un solo elemento requiere una alineación diferente, align-items no lo puede hacer. align-self resuelve esto permitiendo la personalización de alineación en un solo elemento sin afectar al resto, proporcionando mayor control y flexibilidad al diseño.

## ¿Cómo lo resuelve?
align-self acepta los mismos valores que align-items, permitiendo variar el alineamiento de un elemento sin afectar el de los otros.

## Valores comunes de align-self:
* auto: Hereda el valor de align-items en el contenedor (valor predeterminado).

* flex-start: Alinea el elemento al inicio del eje transversal.

* flex-end: Alinea el elemento al final del eje transversal.

* center: Centra el elemento en el eje transversal.

* baseline: Alinea el elemento según su línea de base de texto.

* stretch: Estira el elemento para llenar el contenedor (si no tiene un tamaño fijo).

Ejemplo
```html
<div class="contenedor">
  <div class="elemento">Elemento 1</div>
  <div class="elemento" style="align-self: flex-start;">Elemento 2</div>
  <div class="elemento">Elemento 3</div>
</div>
```
Aquí, Elemento 2 se alinea al inicio del eje transversal mientras los otros elementos siguen el alineamiento especificado en align-items.

## Combinación de order y align-self
En muchos casos, order y align-self pueden combinarse para crear diseños complejos y adaptables. Por ejemplo, en un diseño de galería donde algunos elementos deben destacarse por su posición y alineación.

Ejemplo
```html
<div class="galeria">
  <div class="foto" style="order: 2; align-self: flex-start;">Foto 1</div>
  <div class="foto" style="order: -1; align-self: center;">Foto 2</div>
  <div class="foto" style="order: 1; align-self: flex-end;">Foto 3</div>
</div>
```
En este ejemplo:

* Foto 2 aparece primero y se centra verticalmente.

* Foto 3 aparece después de Foto 2 y se alinea al final.

* Foto 1 aparece al final y se alinea al inicio.