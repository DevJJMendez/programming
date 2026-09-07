Las meta-etiquetas en HTML son etiquetas especiales dentro del elemento <head> de una página que proporcionan a los motores de búsqueda y navegadores información sobre el contenido, estructura y características de la página. Estas etiquetas no son visibles para el usuario en la interfaz, pero juegan un papel fundamental en el SEO, ayudando a los motores de búsqueda a comprender mejor la página y a mejorar su posicionamiento.

## Principales meta-etiquetas y su propósito en SEO
1. **`<title>`**

   * Función: Define el título de la página, que aparece en la pestaña del navegador y como el título del enlace en los resultados de búsqueda.

   * Propósito SEO: Es uno de los factores de SEO más importantes; el título es la primera impresión que los motores de búsqueda y los usuarios obtienen de la página.

   * Buenas prácticas:
     * Mantenerlo entre 50-60 caracteres.

     * Incluir palabras clave relevantes.

     * Crear títulos atractivos que inviten al usuario a hacer clic.

```html
<title>Curso de HTML y CSS - Aprende Diseño Web Efectivo</title>
```

2. **`<meta name="description">`**

   * Función: Proporciona una descripción breve de la página, que suele aparecer en los resultados de búsqueda debajo del título.

   * Propósito SEO: Ayuda a mejorar la tasa de clics (CTR) y proporciona un resumen del contenido para los usuarios.

   * Buenas prácticas:
     * Limitar la longitud a 150-160 caracteres.

     * Incluir palabras clave de manera natural.

     * Escribir una descripción persuasiva y relevante para el contenido de la página.

```html
<meta name="description" content="Aprende HTML y CSS para crear sitios web optimizados y visualmente atractivos.">
```

3. **`<meta name="keywords">` (obsoleto)**

   * Función: Incluía una lista de palabras clave relevantes para la página.

   * Propósito SEO: Originalmente, ayudaba a los motores de búsqueda a comprender el tema de la página.

   * Estado actual: Los motores de búsqueda modernos ignoran esta etiqueta debido a abusos (keyword stuffing). No es relevante para SEO actual.

```html
<meta name="keywords" content="HTML, CSS, diseño web, SEO">
```

4. `<meta name="robots">`

   * Función: Indica a los motores de búsqueda cómo indexar o seguir (crawl) la página.

   * Propósito SEO: Controla el comportamiento de los motores de búsqueda, permitiendo, bloqueando o limitando la indexación de la página.

   * Opciones comunes:
     * `index/noindex`: Para permitir o bloquear la indexación de la página.

     * `follow/nofollow`: Indica si los motores deben seguir los enlaces de la página.

     * `noarchive`: Impide que los motores de búsqueda almacenen una copia en caché de la página.

```html
<meta name="robots" content="index, nofollow">
```

5. **`<meta property="og:title">` y Open Graph (OG)**

   * Función: Las etiquetas OG son utilizadas principalmente por redes sociales para mostrar información específica al compartir una página.

   * Propósito SEO: Mejoran la apariencia de los enlaces en redes sociales, lo cual puede aumentar el CTR y la interacción.

   * Principales etiquetas OG:

     * `og:title`: El título que aparecerá en redes sociales.

     * `og:description`: La descripción que aparecerá en redes.

     * `og:image`: La imagen asociada al enlace.

     * `og:url`: La URL canónica de la página.

```html
<meta property="og:title" content="Aprende HTML y CSS">
<meta property="og:description" content="Curso completo para aprender diseño web con HTML y CSS.">
<meta property="og:image" content="https://tusitio.com/imagen.jpg">
<meta property="og:url" content="https://tusitio.com/curso-html-css">
```

6. **`<meta name="viewport">`**

   * Función: Controla el ancho y la escala de la página en dispositivos móviles.

   * Propósito SEO: Es esencial para un diseño responsive, asegurando que la página se vea bien en dispositivos móviles.

   * Buenas prácticas:
     * Definir el ancho del viewport como device-width para que la página se ajuste al tamaño de la pantalla.

     * Establecer la escala inicial para evitar zoom automático.

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

7. **`<link rel="canonical">`**

   * Función: Especifica la URL canónica de una página, ayudando a evitar el contenido duplicado.

   * Propósito SEO: Indica a los motores de búsqueda cuál es la versión principal de una página, consolidando el valor de SEO en una URL específica.

   * Buenas prácticas:
     * Usar esta etiqueta en caso de contenido duplicado o muy similar en varias páginas.

```html
<link rel="canonical" href="https://tusitio.com/pagina-principal">
```

8. **`<meta charset="UTF-8">`**

   * Función: Define la codificación de caracteres de la página.

   * Propósito SEO: Aunque no tiene impacto directo en SEO, garantiza que los caracteres se muestren correctamente, lo cual mejora la experiencia del usuario y evita problemas de interpretación de caracteres.

```html
<meta charset="UTF-8">
```

9. **`<meta http-equiv="refresh">` (cautela en su uso)**

   * Función: Realiza redireccionamientos o recarga automática de la página.

   * Propósito SEO: Puede usarse para redireccionar temporalmente, aunque no es ideal y debe utilizarse con precaución, ya que Google puede considerar redirecciones no adecuadas como manipulaciones.

```html
<meta http-equiv="refresh" content="5; url=https://tusitio.com/otra-pagina">
```

10. **`<meta name="author">`**

    * Función: Define el autor del contenido de la página.

    * Propósito SEO: Es informativa y no afecta el ranking, pero puede ser útil en sistemas de gestión de contenido y contribuye a la transparencia del sitio.

```html
<meta name="author" content="Juan Pérez">
```