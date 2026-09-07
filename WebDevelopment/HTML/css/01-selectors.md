# Selectores
Los selectores en CSS son reglas que definen a qué elementos HTML se deben aplicar ciertos estilos. Actúan como "identificadores" de los elementos que queremos afectar en nuestra página, ya que CSS no se aplica a todo de manera indiscriminada: selecciona elementos específicos a través de estos selectores.

## ¿Cuáles son los tipos de selectores?
CSS ofrece varios tipos de selectores para abarcar diferentes casos de uso y aplicar estilos de manera flexible y precisa. A continuación, explico los principales tipos y subtipos de selectores:

### 1. **Selectores básicos**, Estos son los tipos más simples y comunes de selectores:

* Selector de tipo (**elemento**): Aplica estilos a todos los elementos de un tipo específico.
```css
p {
  color: blue;
}
```

* **Selector de clase (`.nombre-clase`)**: Selecciona elementos que tienen una clase específica. Las clases se pueden aplicar a múltiples elementos.
```css
.pageNavbar {
  font-weight: bold;
}
```

* **Selector de ID (`#nombre-id`)**: Selecciona un único elemento que tiene un ID específico. Los ID deben ser únicos dentro de una página HTML.
```css
#header {
  background-color: lightgray;
}
```

* **Selector universal (`*`)**: Selecciona todos los elementos de la página.
```css
* {
  margin: 0;
  padding: 0;
}
```

### 2. Selectores de atributo
Permiten seleccionar elementos en función de sus atributos y valores. Son útiles para apuntar a elementos de manera específica, como formularios o enlaces.

* **Selector de atributo simple (`[atributo]`)**: Selecciona todos los elementos que tienen un atributo específico.
```css
[type="text"] {
  border: 1px solid black;
}
```

* **Selector de atributo con valor específico (`[atributo="valor"]`)**: Selecciona elementos con un atributo y valor específicos.
```css
input[type="radio"] {
  background-color: yellow;
}
```

### 3. Selectores de pseudo-clases
Permiten aplicar estilos a elementos en estados específicos o según su posición en el DOM. Son esenciales para mejorar la interactividad y la navegación de un sitio web.

* **Pseudo-clase de interacción**: Aplica estilos según el estado del usuario al interactuar con el elemento.

  * `:hover`: Cuando el usuario pasa el mouse sobre el elemento.

  * `:focus`: Cuando el elemento es enfocado, por ejemplo, en un campo de texto.

  * `:active`: Cuando el elemento está siendo "activado", por ejemplo, al hacer clic en un enlace o botón.

```css
a:hover {
  color: red;
}
```

* **Pseudo-clase estructural**: Selecciona elementos en función de su posición dentro del árbol DOM.

  * `:first-child`: Selecciona el primer hijo de un contenedor.

  * `:last-child`: Selecciona el último hijo de un contenedor.

  * `:nth-child(n)`: Selecciona el enésimo hijo de un contenedor.

```css
p:first-child {
  font-style: italic;
}
```

### 4. Selectores de pseudo-elementos
Permiten seleccionar y aplicar estilos a una parte específica de un elemento. Los pseudo-elementos suelen utilizarse para agregar efectos visuales.

* `::before` y `::after`: Insertan contenido antes o después del contenido real de un elemento.
```css
p::before {
  content: "🌟 ";
}
```
* `::first-line` y `::first-letter`: Aplica estilos solo a la primera línea o primera letra de un elemento.
```css
p::first-letter {
  font-size: 2em;
}
```

### 5. Selectores de combinadores
Permiten seleccionar elementos en relación con otros elementos. Los combinadores permiten tener mayor control en la aplicación de estilos cuando se trabaja con estructuras HTML más complejas.

* **Combinador descendiente (`elemento1` `elemento2`)**: Selecciona los elementos `elemento2` que están dentro de `elemento1`.
```css
div p {
  color: green;
}
```

* **Combinador hijo directo (`elemento1 > elemento2`)**: Selecciona los elementos `elemento2` que son hijos directos de `elemento1`.
```css
ul > li {
  list-style-type: none;
}
```

* **Combinador de adyacente (`elemento1 + elemento2`)**: Selecciona el `elemento2` que está justo después de `elemento1`.
```css
h1 + p {
  margin-top: 0;
}
```

* **Combinador general de hermanos (`elemento1 ~ elemento2`)**: Selecciona todos los elementos elemento2 que son hermanos de elemento1 (comparten el mismo contenedor).
```css
h2 ~ p {
  color: gray;
}
```

## ¿Para qué sirven los selectores?
Los selectores sirven para:

* **Aplicar estilos de manera precisa**: Permiten controlar qué elementos reciben cada estilo, lo que ayuda a construir diseños bien definidos y coherentes.

* **Controlar la estructura visual**: La correcta aplicación de estilos a diferentes niveles de elementos y en base a atributos específicos permite construir interfaces web limpias y organizadas.

* **Respetar principios de CSS como la cascada**: Definen una jerarquía de estilos, permitiendo que los estilos específicos tengan prioridad sobre los generales cuando es necesario.

## ¿Qué resuelven?
CSS resuelve el problema de controlar la apariencia de un sitio web de forma estructurada. Sin los selectores, aplicar estilos de manera específica y organizada sería prácticamente imposible. Los selectores permiten:

* Evitar redundancias en el código.

* Simplificar el mantenimiento de los estilos.

* Permitir personalización basada en la posición y el estado de los elementos, mejorando la accesibilidad y experiencia de usuario.

## ¿Cómo lo resuelven?
Lo resuelven mediante la cascada y la especificidad:

* **Cascada**: La cascada determina el orden en el cual se aplican los estilos de diferentes selectores, desde los más generales hasta los más específicos.

* **Especificidad**: Cada selector tiene un "peso" en base a su tipo (ID, clase, tipo de elemento). Cuando dos selectores apuntan al mismo elemento, el que tiene mayor especificidad gana y su estilo se aplicará.

Ejemplo de especificidad
```css
div p { color: blue; } /* Menor especificidad */
p.mi-clase { color: red; } /* Mayor especificidad */

<p class="mi-clase">Este texto será rojo</p>
```