![periodic table of the elements](image/elementstable.png)

# Etiquetas
Las etiquetas en HTML son marcas que envuelven el contenido dentro de un documento HTML, y le indican al navegador cómo debe mostrar cada fragmento de ese contenido. Cada etiqueta generalmente consta de una etiqueta de apertura y una etiqueta de cierre (con una barra inclinada, /), y el contenido se coloca entre ellas. Algunas etiquetas son auto-cerradas y no requieren una etiqueta de cierre explícita.

Ejemplo de etiqueta de apertura y cierre:
```html
<p>Este es un párrafo de texto.</p>
```
Ejemplo de una etiqueta auto-cerrada
```html
<img src="imagen.jpg" alt="Descripción de la imagen">
```

## ¿Cuáles son los tipos de etiquetas en HTML?
Existen varios tipos de etiquetas en HTML, y cada una tiene un propósito específico. Podemos clasificarlas en las siguientes categorías:

### 1. **Etiquetas estructurales**
Estas etiquetas ayudan a organizar la estructura general de la página y están diseñadas para dividir el contenido en secciones significativas.

Ejemplos:
* `<header>`: Sección superior de la página, usualmente incluye el logotipo y la navegación.

* `<nav>`: Indica un bloque de navegación con enlaces a otras partes del sitio.

* `<main>`: Contiene el contenido principal de la página.

* `<section>`: Representa una sección genérica de contenido, como un bloque de texto o imágenes.

* `<article>`: Contenido que puede existir de forma independiente, como un artículo de blog.

* `<footer>`: Pie de página con información adicional, como enlaces a políticas de privacidad.

### 2. **Etiquetas de contenido de texto**
Estas etiquetas sirven para dar formato y estructura al texto dentro del contenido.

Ejemplos:
* `<h1>` a `<h6>`: Encabezados que ayudan a jerarquizar el contenido (por ejemplo, `<h1>` es el título principal).

* `<p>`: Representa un párrafo de texto.

* `<strong>` y `<em>`: Aplican énfasis en texto (por ejemplo, `<strong>` para texto en negrita y `<em>` para texto en cursiva).

* `<blockquote>`: Cita en bloque de otra fuente.

### 3. **Etiquetas de lista**
Las etiquetas de lista ayudan a organizar los elementos en forma de lista.

Ejemplos:
* `<ul>`: Lista desordenada (sin números).

* `<ol>`: Lista ordenada (numerada).

* `<li>`: Representa un elemento dentro de una lista.


### 4. **Etiquetas multimedia e interactivas**
Estas etiquetas permiten agregar contenido multimedia e interactivo, como imágenes, videos y formularios.

Ejemplos:
* `<img>`: Inserta una imagen en la página.

* `<video>`: Agrega un video que se puede reproducir.

* `<audio>`: Inserta un archivo de audio.

* `<a>`: Enlace que lleva a otra página o sección.

* `<form>`, `<input>`, `<button>`: Crean formularios y entradas interactivas para el usuario.

### 5. **Etiquetas de metadatos**
Estas etiquetas proporcionan información sobre el documento HTML al navegador y a los motores de búsqueda. No son visibles para el usuario.

Ejemplos:
* `<title>`: Define el título que se muestra en la pestaña del navegador.

* `<meta`>: Proporciona metadatos sobre el contenido, como la descripción o palabras clave.

* `<link>`: Vincula recursos externos como hojas de estilo (CSS) o iconos.

* `<style>`: Define estilos CSS en línea (mejor para pequeños ajustes, ya que se recomienda usar CSS externos).

## ¿Para qué sirven las etiquetas en HTML?
Las etiquetas de HTML sirven para dar sentido, estructura y formato al contenido web, indicando qué tipo de información está en cada sección. También permiten agregar funcionalidad y estilos a la página al integrarse con CSS y JavaScript.

## ¿Qué problemas resuelven las etiquetas en HTML?
Las etiquetas de HTML resuelven problemas de:

* **Estructuración**: Permiten organizar el contenido en bloques lógicos que tienen sentido tanto para los usuarios como para los motores de búsqueda.

* **Accesibilidad**: Las etiquetas semánticas mejoran la accesibilidad, ayudando a los lectores de pantalla a interpretar el contenido.

* **SEO (Search Engine Optimization)**: Facilitan la indexación de la página por parte de los motores de búsqueda, mejorando su visibilidad en internet.

* **Interactividad y Multimedia**: Permiten incorporar enlaces, imágenes, videos y formularios, enriqueciendo la experiencia del usuario.

## ¿Cómo resuelven estos problemas?
Las etiquetas HTML resuelven estos problemas mediante un sistema de marcado semántico. Aquí hay un desglose de cómo lo logran:

* **Organización Semántica**
  * Las etiquetas como `<header>`, `<footer>`, `<section>`, `<article>` y otras etiquetas estructurales, definen el significado de cada bloque de contenido. Esto ayuda a los navegadores y motores de búsqueda a comprender mejor el propósito de cada sección.

* **Accesibilidad Mejorada**
  * A través de etiquetas bien seleccionadas y atributos como alt en `<img>`o label en `<input>`, HTML facilita el uso de tecnología de asistencia, como lectores de pantalla, para mejorar la accesibilidad de la página.

* **Optimización para Motores de Búsqueda**
  * Las etiquetas semánticas, junto con las etiquetas de metadatos (como `<title>` y `<meta>`), ayudan a los motores de búsqueda a entender de qué trata la página y a catalogarla adecuadamente, mejorando así su visibilidad.

* **Multimedia e Interactividad**
  * HTML permite la integración de contenido multimedia mediante etiquetas como `<img>`, `<audio>`, y `<video>`. Para la interactividad, HTML usa etiquetas como `<a>` para enlaces y `<form>` para formularios, mejorando la experiencia del usuario al permitirle realizar acciones como navegar entre páginas y enviar información.

## Buenas prácticas con etiquetas en HTML
* **Usa etiquetas semánticas** siempre que sea posible. Por ejemplo, utiliza `<article>` en lugar de un simple `<div>` cuando el contenido tiene sentido propio.

* **Escribe un HTML accesible**: Usa **`aria-labels`** y atributos descriptivos cuando sea necesario, especialmente en contenido interactivo y formularios.

* **Optimiza imágenes y videos**: Usa etiquetas alt y especifica dimensiones para las imágenes, y usa loading="lazy" para mejorar la velocidad de carga.

* **Jerarquía de encabezados**: Usa encabezados en el orden adecuado (`<h1>` a `<h6>`) sin saltar niveles para mantener una estructura clara.

* **Agrupación lógica de contenido**: Agrupa elementos relacionados en contenedores lógicos (como `<section>`, `<article>` `<nav>`), lo cual facilita la lectura y el mantenimiento del código.
