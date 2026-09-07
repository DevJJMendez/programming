# HyperText Markup Language
HTML (HyperText Markup Language) es el lenguaje de marcado estándar para crear páginas web. Fue desarrollado para estructurar y organizar el contenido que se muestra en un navegador web, proporcionando una base sobre la que se pueden construir diseños y aplicaciones. HTML no es un lenguaje de programación, sino un lenguaje de marcado que define la estructura de un documento web mediante etiquetas (tags).

## ¿Para qué sirve HTML?
HTML sirve para estructurar y organizar el contenido de una página web, permitiendo al navegador saber cómo mostrar los diferentes elementos de la página. Esto incluye textos, imágenes, enlaces, formularios y multimedia, y también ayuda a definir la jerarquía de la información. HTML es esencial para la accesibilidad, la indexación en motores de búsqueda, y es fundamental para una buena experiencia de usuario.

## ¿Qué problema resuelve HTML?
HTML resuelve el problema de comunicar de manera estructurada el contenido de un sitio web al navegador y, en consecuencia, al usuario. Antes de HTML, no había un estándar universal para organizar y presentar la información en la web. Esto dificultaba la creación de sitios web accesibles y estructurados de forma coherente.

**HTML facilita:**
* La interoperabilidad entre diferentes navegadores y dispositivos.

* La accesibilidad de los contenidos para personas con discapacidades, a través de etiquetas y atributos específicos que permiten el uso de lectores de pantalla.

* La indexación y visibilidad en motores de búsqueda (SEO), dado que los buscadores comprenden mejor el contenido bien estructurado.

## ¿Cómo resuelve HTML estos problemas?
HTML usa una estructura de etiquetas que organizan el contenido en distintos tipos de bloques o elementos. Cada etiqueta de HTML tiene un propósito y una función específica, permitiendo al navegador comprender cómo debe mostrar cada parte del contenido. Algunos ejemplos de cómo HTML resuelve estos problemas incluyen:

* **Etiquetas estructurales** (`<header>`, `<nav>`, `<main>`, `<footer>`, `<section>`, <article>): Estas etiquetas permiten estructurar el contenido, dándole sentido a cada sección de la página.

* **Etiquetas de contenido** (`<h1>` a `<h6>`, `<p>`, `<ul>`, `<ol>`, `<li>`): Estas etiquetas indican qué tipo de contenido se presenta y su jerarquía, permitiendo a los usuarios y motores de búsqueda comprender la importancia y la organización de la información.

* **Etiquetas interactivas y multimedia** (`<a>`, `<img>`, `<video>`, `<audio>`, `<form>`): Permiten agregar contenido interactivo, como enlaces, imágenes y formularios, además de contenido multimedia, mejorando la experiencia del usuario.

* **Atributos** (como `alt` en `<img>`, `title`, `id`, `class`): Estos atributos brindan información adicional sobre los elementos, mejorando la accesibilidad, el SEO y el control de estilos.

## Estructura básica de HTML
Un documento HTML se estructura en diferentes secciones para asegurar que esté completo y bien organizado. Una estructura básica es así:

```html
<!DOCTYPE html> 
<html lang="es"> <!-- Inicio del documento -->
<head>
  <meta charset="UTF-8"> <!-- Codificación de caracteres -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Escalabilidad en dispositivos móviles -->
  <title>Mi Página Web</title> <!-- Título del documento -->
</head>
<body>
  <header>
    <!-- Contenido del encabezado como el logo y menú de navegación -->
  </header>
  
  <main>
    <!-- Contenido principal de la página -->
  </main>
  
  <footer>
    <!-- Información del pie de página, como contactos y redes sociales -->
  </footer>
</body>
</html>
```
Cada sección de este código cumple una función esencial:
* `DOCTYPE` declara el tipo de documento.

* `html` indica que el documento está en HTML5 y define el idioma.

* `head` contiene metadatos, como el título de la página, la codificación de caracteres y el viewport.

* `body` es donde se coloca el contenido visible de la página, estructurado en encabezado, contenido principal y pie de página.

## Buenas Prácticas con HTML
Para que tu HTML sea claro, accesible y fácil de mantener, considera las siguientes buenas prácticas:

1. **Usa etiquetas semánticas**: Utilizar etiquetas como `<section>`, `<article>`, `<header>`, etc., ayuda a definir claramente el propósito de cada parte de la página, mejorando tanto la accesibilidad como el SEO.

2. **Mantén el HTML limpio y bien organizado**: Evita redundancias y usa etiquetas de manera apropiada. No uses una etiqueta solo por su efecto visual.

3. **Optimiza el rendimiento**: Utiliza atributos como **`loading="lazy"`** en imágenes para retrasar la carga de imágenes no visibles en la pantalla inicial.

4. **Escribe HTML accesible**: Usa atributos alt en imágenes y etiquetas label en formularios para mejorar la experiencia de usuarios con discapacidades.

5. **Mantén una jerarquía de encabezados lógica**: Usa `<h1>` solo una vez en la página y úsalo para el título principal. Luego, organiza subtemas en `<h2>`, `<h3>`, etc., sin saltarte niveles.