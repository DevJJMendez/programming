# `grid-area`
grid-area es una propiedad que define un área específica dentro de un contenedor de grid para un grid item (elemento de grid). Se puede utilizar para posicionar el elemento de manera rápida y eficiente, sin tener que usar propiedades como `grid-row` o `grid-column` por separado.

## ¿Para qué sirve grid-area?
grid-area se utiliza para asignar a un grid item una ubicación específica dentro del contenedor de grid, ya sea por nombre de área o por coordenadas de filas y columnas. Facilita la asignación de posiciones y áreas complejas dentro de un grid, haciendo que el layout sea más flexible y fácil de leer

## ¿Qué resuelve grid-area?
grid-area resuelve varios problemas comunes en el diseño de layouts complejos:

* Posicionamiento simplificado: Permite asignar un área específica dentro del grid con solo una línea de código, sin necesidad de definir por separado las posiciones de fila y columna.

* Layouts más legibles: Si se usan nombres de área, el código es más legible, ya que puedes ver claramente qué elementos van en qué lugar dentro del grid.

* Reducción de código redundante: Si se usan áreas nombradas, puedes evitar la repetición de valores y hacerlo todo en un solo lugar.

* Flexibilidad y control: Permite mayor control sobre la disposición de los elementos dentro de un contenedor, haciendo que las áreas puedan ser fácilmente adaptables o reordenadas.

## ¿Cómo lo resuelve?
grid-area puede trabajar de dos maneras:

* Usando coordenadas: Definir las posiciones de la fila de inicio, la fila de fin, la columna de inicio y la columna de fin.

* Usando nombres de área: Asignar un nombre de área que se haya definido previamente en la propiedad grid-template-areas.

## Sintaxis de grid-area
```css
grid-area: <fila-inicio> / <columna-inicio> / <fila-fin> / <columna-fin>;
```
* **`<fila-inicio>`**: La fila en la que el elemento debe comenzar.

* **`<columna-inicio>`**: La columna en la que el elemento debe comenzar.

* **`<fila-fin>`**: La fila en la que el elemento debe terminar.

* **`<columna-fin>`**: La columna en la que el elemento debe terminar.

También puedes usar grid-area con nombres de áreas en lugar de coordenadas, si tienes áreas definidas:
```css
grid-area: <nombre-area>;
```

## Ejemplo con coordenadas
```css
.grid-container {
  display: grid;
  grid-template-columns: 100px 200px 100px;
  grid-template-rows: 100px 100px;
}

.item {
  grid-area: 1 / 1 / 2 / 3;
}
```
**En este ejemplo:**
* El grid container tiene 3 columnas y 2 filas.

* El item comienza en la primera fila (1), en la primera columna (1), y termina en la segunda fila (2) y tercera columna (3). Esto coloca el elemento en el área que abarca las filas 1-2 y las columnas 1-3, ocupando toda la primera fila y las dos primeras columnas.

## Ejemplo con nombres de áreas
```css
.grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "header header header" "sidebar main main" "footer footer footer";
}

.header {
  grid-area: header;
}

.sidebar {
  grid-area: sidebar;
}

.main {
  grid-area: main;
}

.footer {
  grid-area: footer;
}
```
En este ejemplo:

* La propiedad grid-template-areas define un layout con 3 áreas nombradas: header, sidebar, main, y footer.

* Los elementos .header, .sidebar, .main, y .footer se colocan en las áreas correspondientes usando grid-area.

## Uso de grid-area para crear un layout simple
```css
.grid-container {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: auto;
  grid-template-areas: "header header" "sidebar main" "footer footer";
}

.header {
  grid-area: header;
}

.sidebar {
  grid-area: sidebar;
}

.main {
  grid-area: main;
}

.footer {
  grid-area: footer;
}
```
En este layout:
* El grid tiene 2 columnas (una de 1fr y otra de 3fr) y filas automáticas.

* Usamos grid-template-areas para definir áreas para el header, sidebar, main, y footer.

* La propiedad grid-area en los items coloca los elementos dentro de las áreas que definimos en grid-template-areas.

## Buenas prácticas al usar grid-area
``* Usa nombres de áreas siempre que sea posible: Esto hace que tu código sea más legible y más fácil de mantener.

* Evita el uso excesivo de coordenadas: Si el diseño es complejo, las coordenadas pueden ser difíciles de mantener, especialmente cuando se modifican. Prefiere usar grid-template-areas cuando sea posible.

* Usa grid-area en combinación con grid-template-areas: Para mantener un control más claro sobre tu layout, usa grid-template-areas para definir las áreas y luego usa grid-area para asignar los elementos.

* Desarrolla layouts fluidos: Combina grid-area con unidades flexibles (como fr, auto o minmax()) para crear layouts que se adapten bien a distintos tamaños de pantalla.

---
---

# grid-template-areas
Es una propiedad de CSS Grid que define visualmente la estructura del grid usando nombres de áreas, lo que facilita la asignación de cada elemento a su lugar en la cuadrícula.

## Sintaxis básica
```css
.grid-container {
  display: grid;
  grid-template-areas:
    "header header"
    "sidebar main"
    "footer footer";
}
```
Esto define una cuadrícula de 3 filas y 2 columnas:
```css
┌────────┬────────┐
│ header │ header │
├────────┼────────┤
│sidebar │  main  │
├────────┼────────┤
│ footer │ footer │
└────────┴────────┘
```

## Paso a paso para usarla
1. Define el grid container
```css
.grid-container {
  display: grid;
  grid-template-columns: 200px 1fr;
  grid-template-rows: 60px 1fr 40px;
  grid-template-areas:
    "header header"
    "sidebar main"
    "footer footer";
}
```

2. Asigna las áreas en los elementos hijos
```css
.header {
  grid-area: header;
}
.sidebar {
  grid-area: sidebar;
}
.main {
  grid-area: main;
}
.footer {
  grid-area: footer;
}
```

## Reglas y buenas prácticas
* Los nombres deben coincidir exactamente entre grid-template-areas y grid-area.
* Puedes usar "." para indicar espacios vacíos (no asignados).
* Todas las líneas deben tener la misma cantidad de columnas.
* Es ideal para layouts semánticos, escalables y legibles.

### Ejemplo completo
```html
<div class="layout">
  <header class="header">Header</header>
  <aside class="sidebar">Sidebar</aside>
  <main class="main">Main content</main>
  <footer class="footer">Footer</footer>
</div>
```
```css
.layout {
  display: grid;
  grid-template-columns: 250px 1fr;
  grid-template-rows: 60px 1fr 40px;
  grid-template-areas:
    "header header"
    "sidebar main"
    "footer footer";
  height: 100vh;
}

.header  { grid-area: header; background: #333; color: white; }
.sidebar { grid-area: sidebar; background: #eee; }
.main    { grid-area: main; background: white; }
.footer  { grid-area: footer; background: #333; color: white; }
```

## Ventajas de grid-template-areas
￼
| Ventaja                 | Por qué importa                              |
| ----------------------- | -------------------------------------------- |
| Muy legible             | Se entiende el layout de un vistazo.         |
| Fácil de reorganizar    | Solo cambias la plantilla, no el HTML.       |
| Ideal para responsive   | Puedes redefinir las áreas en media queries. |
| Mejora el mantenimiento | Especialmente en proyectos grandes.          |