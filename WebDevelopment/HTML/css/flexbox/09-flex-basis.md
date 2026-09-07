# `flex-basis`
La propiedad flex-basis en CSS es clave en el sistema de diseño flexible de Flexbox. Define el tamaño inicial de un elemento flexible, antes de aplicar el crecimiento o reducción mediante flex-grow y flex-shrink. Esto ayuda a establecer una base para que los elementos se organicen de manera predecible y adaptable en diferentes tamaños de pantalla o contenedor.

![flex basis](images/flexBasis.png)

## ¿Qué es flex-basis?
flex-basis es una propiedad de Flexbox que establece el tamaño inicial de un elemento dentro de un contenedor flexible. Este tamaño puede definirse en cualquier unidad de medida CSS (como px, %, em, rem), y permite que los elementos tengan un tamaño inicial independiente de su contenido o de la configuración de width y height.

## ¿Para qué sirve?
La propiedad flex-basis define cómo se distribuye el espacio dentro de un contenedor flexible. Sirve como el tamaño base de los elementos, estableciendo una referencia clara sobre cómo deben mostrarse antes de que entren en juego flex-grow o flex-shrink para ajustes según el espacio disponible en el contenedor. Esto permite a los desarrolladores crear layouts en los que algunos elementos pueden tener un tamaño mínimo o ideal específico, mientras que otros se ajustan de manera proporcional.

## ¿Qué problema resuelve?
Sin flex-basis, los elementos dentro de un contenedor flexible podrían no tener una referencia clara de tamaño y dependerían únicamente de width, height, flex-grow y flex-shrink, lo que puede generar comportamientos inconsistentes en el layout. flex-basis resuelve este problema proporcionando un tamaño inicial específico para cada elemento flexible, logrando que el layout sea más controlable y adaptable.

## ¿Cómo lo resuelve?
flex-basis establece el tamaño inicial de cada elemento antes de que los valores de flex-grow y flex-shrink actúen. Esto significa que el navegador primero asigna el tamaño flex-basis y luego ajusta el crecimiento o reducción del elemento según el espacio del contenedor y las propiedades flexibles configuradas.

## Ejemplo Básico de flex-basis
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
  gap: 10px;
  width: 100%;
  background-color: lightgray;
}

.elemento {
  flex-basis: 100px;
  background-color: lightcoral;
}
```
En este caso, cada .elemento tendrá una base inicial de 100 píxeles. Esto asegura que, en un contenedor flexible, cada elemento comience con una anchura de 100 píxeles, sin importar el contenido.