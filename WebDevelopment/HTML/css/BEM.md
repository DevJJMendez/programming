# BEM
es una metodología para estructurar y nombrar clases en CSS, especialmente útil cuando desarrollas interfaces escalables, mantenibles y organizadas.

## ¿Qué es BEM?
BEM significa:

Block (Bloque)

Element (Elemento)

Modifier (Modificador)

Es una metodología de nomenclatura de clases CSS que busca hacer el código predecible, estructurado, reutilizable y fácil de mantener

##  ¿Cuál es el propósito de BEM?
Evitar conflictos entre estilos (colisiones de clases)

Hacer el CSS más modular y reutilizable

Facilitar la lectura del código HTML y CSS

Favorecer la colaboración en equipos grandes

Hacer posible aplicar estilos a componentes de manera aislada

## Estructura de BEM
La estructura de las clases sigue esta forma:
```css
bloque__elemento--modificador
```
1. Bloque (block)
Es la unidad independiente y reutilizable de la interfaz.
```html
<div class="card">...</div>
```
```css
.card {
  border: 1px solid #ccc;
}
```

2. Elemento (block__element)
Es una parte del bloque que depende del bloque.
```html
<div class="card">
  <h2 class="card__title">Título</h2>
  <p class="card__text">Contenido</p>
</div>
```
```css
.card__title {
  font-weight: bold;
}
```

3. Modificador (block--modifier o block__element--modifier)
Es una variación de apariencia o comportamiento del bloque o del elemento.
```html
<div class="card card--featured">
  <h2 class="card__title card__title--highlighted">Título</h2>
</div>
```
```css
.card--featured {
  border-color: gold;
}

.card__title--highlighted {
  color: red;
}
```

## Ejemplo completo
```html
<article class="product-card product-card--promo">
  <h2 class="product-card__title">Zapatos deportivos</h2>
  <p class="product-card__price product-card__price--discounted">$49.99</p>
</article>
```
```css
.product-card { /* bloque base */ }
.product-card--promo { /* modificador del bloque */ }

.product-card__title { /* elemento */ }
.product-card__price--discounted { /* modificador del elemento */ }
```

##  Buenas prácticas con BEM
Recomendación	Descripción
✅ Sin anidamientos profundos	BEM favorece clases planas, no necesita div div div
✅ Escribe clases completas	Evita usar selectores como .card h2, mejor .card__title
✅ Usa guiones bajos dobles y dobles guiones	__ para elementos, -- para modificadores
✅ Cada clase debe ser clara y autosuficiente	Puedes leer .button__icon--large y entenderlo sin contexto
✅ Evita usar etiquetas en el selector	No escribas div.card__title

## Errores comunes
❌ .card .title → rompe la modularidad

❌ .title--red → no se sabe a qué bloque pertenece

❌ #card .title → innecesario, BEM no usa IDs

❌ .card_title → usa __, no _

## ¿Cuándo usar BEM?
Ideal para proyectos componentizados (como en React, Vue, Angular, etc.)

En equipos grandes con múltiples desarrolladores

Si estás usando arquitecturas CSS como ITCSS o SMACSS

En sitios que requieran escalabilidad y mantenimiento a largo plazo

