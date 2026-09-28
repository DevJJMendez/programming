# `Document`
La clase document en JavaScript representa el objeto raíz del DOM (Document Object Model) y es esencial para cualquier manipulación de contenido en una página web. Esta clase permite acceder a los elementos y nodos del DOM, escuchar eventos y modificar contenido, estilos, atributos y estructura. Prácticamente todo lo que involucra interactuar con la página y su contenido pasa a través del objeto document.

## ¿Qué es document?
document es un objeto global de JavaScript que representa el árbol del DOM. Contiene todas las propiedades y métodos necesarios para acceder y manipular los elementos de la página web en tiempo de ejecución.

## ¿Para qué sirve document?
El objeto document es el punto de entrada para la interacción con el DOM en JavaScript. Sirve para:

Acceder a elementos: Buscar elementos por sus atributos, etiquetas, clases, etc.
Modificar el contenido: Cambiar texto, HTML, estilos y atributos.
Gestionar la estructura: Crear, eliminar y mover elementos en el DOM.
Escuchar eventos: Detectar interacciones del usuario, como clics o desplazamientos.

## ¿Qué resuelve document?
document permite resolver la interactividad dinámica en las páginas web. Es la herramienta que permite a JavaScript comunicarse y modificar la estructura del HTML y CSS en el navegador, permitiendo crear experiencias interactivas, responder a acciones del usuario y construir aplicaciones web completas.

## ¿Cómo lo resuelve?
document proporciona una serie de métodos y propiedades que permiten seleccionar, manipular y escuchar eventos en el DOM. Al acceder a los nodos y elementos del árbol del DOM, JavaScript puede hacer cambios en tiempo real, lo que se refleja de inmediato en la interfaz visual de la página.

## Métodos Principales de document
### 1. Acceso a Elementos
document.getElementById(id): Selecciona un elemento único por su id.
```js
const titulo = document.getElementById("titulo-principal");
```
document.getElementsByClassName(className): Selecciona todos los elementos que tengan una clase específica.
```js
const botones = document.getElementsByClassName("boton");
```
document.getElementsByTagName(tagName): Selecciona todos los elementos de un tipo específico (por ejemplo, <div>, <p>, etc.).
```js
const parrafos = document.getElementsByTagName("p");
```
document.querySelector(selector): Selecciona el primer elemento que coincide con un selector CSS.
```js
const primerBoton = document.querySelector(".boton");
```
document.querySelectorAll(selector): Selecciona todos los elementos que coinciden con un selector CSS.
```js
const todosLosEnlaces = document.querySelectorAll("a");
```

### 2. Manipulación de Contenido
* document.createElement(tagName): Crea un nuevo elemento HTML, pero no lo agrega automáticamente al DOM.
```js
const nuevoDiv = document.createElement("div");
```
element.innerHTML: Permite obtener o establecer el contenido HTML de un elemento.
```js
nuevoDiv.innerHTML = "<strong>Contenido dinámico</strong>";
```
element.textContent: Permite obtener o establecer solo el texto dentro de un elemento, ignorando el HTML.
```js
nuevoDiv.textContent = "Texto sin formato HTML";
```

### 3. Manipulación de Atributos y Estilos
* element.setAttribute(name, value): Establece el valor de un atributo en un elemento.
```js
nuevoDiv.setAttribute("id", "mi-nuevo-div");
```
element.getAttribute(name): Obtiene el valor de un atributo específico.
```js
const idDiv = nuevoDiv.getAttribute("id");
```