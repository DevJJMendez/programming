# Etiquetas Estructurales
Las etiquetas estructurales en HTML son fundamentales para organizar y dividir el contenido de una página web en secciones significativas. Ayudan a dar estructura y contexto al contenido, tanto para los navegadores como para los usuarios y los motores de búsqueda.

## ¿Qué son las etiquetas estructurales?
Las etiquetas estructurales son etiquetas semánticas que definen el propósito de diferentes secciones de la página. A diferencia de etiquetas genéricas como `<div>`, las etiquetas estructurales transmiten un significado específico sobre el tipo de contenido que contienen. Esto mejora la accesibilidad, la organización y facilita la indexación para los motores de búsqueda.

## ¿Cuáles son los tipos de etiquetas estructurales en HTML?
1. **`<header>`**: Representa la cabecera de una página o sección, que normalmente contiene el logotipo, el menú de navegación, el título, o enlaces relevantes. Puede estar en el cuerpo principal de la página o en cualquier sección.

2. **`<nav>`**: Define una sección de navegación con enlaces que permiten desplazarse a otras partes de la página o sitio. Esto es útil para separar claramente el menú de navegación del resto del contenido.

3. **`<main>`**; Contiene el contenido principal de la página, que es único y específico para esa página. Solo debería haber un `<main>` por página, ya que representa el núcleo del contenido que los usuarios buscan.

4. **`<section>`**: Representa una sección temática dentro de la página. Se usa para dividir el contenido en bloques organizados según su contexto o tema, y se puede usar varias veces en una página.

5. **`<article>`**: Indica contenido independiente y autocontenido, como un artículo de blog, una publicación, un comentario, o una noticia. Cada `<article>` debe tener sentido por sí mismo si se separa del resto del contenido.

6. **`<aside>`**: Define contenido secundario relacionado con el contenido principal, como una barra lateral con enlaces, anuncios o biografía del autor. No es esencial para entender el contenido principal, pero proporciona contexto adicional.

7. **`<footer>`**: Representa el pie de página de una sección o de toda la página. Normalmente incluye información como enlaces de contacto, derechos de autor, enlaces legales o información adicional.

## ¿Para qué sirven las etiquetas estructurales?
Las etiquetas estructurales sirven para organizar el contenido en bloques lógicos y semánticos, proporcionando contexto sobre el propósito de cada sección. Esto no solo hace que el código HTML sea más comprensible para otros desarrolladores, sino que también facilita el trabajo de los motores de búsqueda y mejora la accesibilidad para lectores de pantalla y otras tecnologías de asistencia.

## ¿Qué problemas resuelven las etiquetas estructurales?
Estas etiquetas resuelven problemas de:

1. **Organización del contenido**: Ayudan a crear una jerarquía clara y lógica en la página, haciendo que el contenido esté bien estructurado y sea fácil de leer tanto para las personas como para las máquinas.

2. **Accesibilidad**: Facilitan la navegación para los usuarios con discapacidades, ya que los lectores de pantalla pueden identificar las diferentes secciones de la página y ofrecer una mejor experiencia de usuario.

3. **SEO (Search Engine Optimization)**: Las etiquetas semánticas facilitan a los motores de búsqueda la interpretación y el indexado de la página, ya que cada sección tiene un propósito claro y específico.

4. **Mantenimiento**: Al dividir el contenido en bloques bien definidos, el código HTML se vuelve más legible y fácil de mantener.

## ¿Cómo resuelven estos problemas?
1. **Mediante Semántica Claramente Definida**: Al usar etiquetas como `<header>`, `<footer>`, `<main>`, etc., los navegadores y motores de búsqueda comprenden la estructura y el contenido de la página. Esto ayuda a que el sitio sea más accesible y a que el contenido esté bien jerarquizado.

2. **Mejora de la Navegación y la Accesibilidad**: Los lectores de pantalla y otras tecnologías de asistencia pueden identificar y saltar rápidamente a las secciones importantes de una página, como la cabecera, el menú de navegación o el contenido principal, mejorando la experiencia de usuario.

3. **Indexación Eficiente para SEO**: Los motores de búsqueda priorizan contenido bien estructurado y semántico, lo que ayuda a que las páginas se posicionen mejor en los resultados de búsqueda.

4. **Facilitación de Buenas Prácticas de Mantenimiento**: Una estructura clara permite que otros desarrolladores o el propio autor del código puedan leer, entender y actualizar el contenido de forma más sencilla, lo cual es clave en proyectos grandes o colaborativos.

## Ejemplo Práctico de Uso de Etiquetas Estructurales
A continuación, un ejemplo que muestra cómo las etiquetas estructurales organizan una página de manera coherente:

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo de Etiquetas Estructurales</title>
</head>
<body>
    <!-- Cabecera -->
    <header>
        <h1>Mi Sitio Web</h1>
        <nav>
            <ul>
                <li><a href="#inicio">Inicio</a></li>
                <li><a href="#nosotros">Nosotros</a></li>
                <li><a href="#servicios">Servicios</a></li>
                <li><a href="#contacto">Contacto</a></li>
            </ul>
        </nav>
    </header>

    <!-- Contenido principal -->
    <main>
        <!-- Sección principal -->
        <section id="inicio">
            <h2>Bienvenido a Nuestro Sitio</h2>
            <p>Este es el contenido principal donde presentamos nuestros servicios.</p>
        </section>

        <!-- Artículo específico -->
        <article>
            <h3>Artículo sobre nuestras novedades</h3>
            <p>Este es un artículo independiente con información específica.</p>
        </article>

        <!-- Barra lateral con contenido adicional -->
        <aside>
            <h4>Noticias Recientes</h4>
            <p>Contenido adicional como noticias o anuncios.</p>
        </aside>
    </main>

    <!-- Pie de página -->
    <footer>
        <p>&copy; 2024 Mi Sitio Web. Todos los derechos reservados.</p>
        <p><a href="privacidad.html">Política de Privacidad</a> | <a href="terminos.html">Términos de Servicio</a></p>
    </footer>
</body>
</html>
```