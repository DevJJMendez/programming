# Lazy Loading
El lazy loading (carga diferida) en HTML es una técnica de optimización que permite cargar ciertos recursos de una página web solo cuando estos son necesarios, en lugar de cargarlos al inicio. Esta técnica es particularmente útil para mejorar el rendimiento, ya que reduce el tiempo de carga inicial de una página y ahorra ancho de banda. Esto se aplica principalmente a imágenes y iframes, elementos que pueden impactar significativamente el rendimiento debido a su peso o cantidad.

## ¿Qué es el lazy loading?
Lazy loading es una estrategia de optimización donde ciertos elementos de una página web (como imágenes y iframes) se cargan solo cuando el usuario está a punto de visualizarlos, en lugar de cargarlos de inmediato. En HTML, esto se implementa mediante el atributo loading, introducido en HTML5.

## ¿Cuáles etiquetas soportan lazy loading?
Actualmente, HTML admite lazy loading principalmente en las siguientes etiquetas:

* **`<img>`**: para imágenes.

* **`<iframe>`**: para contenido embebido, como vídeos de YouTube, mapas de Google, etc.

## ¿Para qué sirve el lazy loading?
El lazy loading tiene múltiples beneficios, entre ellos:

* Optimización de rendimiento: Reduce la cantidad de datos cargados inicialmente en la página, mejorando la velocidad de carga y la experiencia del usuario.

* Ahorro de ancho de banda: Solo se cargan los recursos visibles en pantalla, lo que minimiza el consumo de datos, especialmente útil en dispositivos móviles o conexiones lentas.

* Mejora en SEO y Core Web Vitals: Al reducir el tiempo de carga de la página, se mejora el puntaje en métricas de rendimiento, lo cual es importante para la optimización en motores de búsqueda.

## ¿Qué problemas resuelve el lazy loading?
* Largas esperas en la carga inicial: En páginas con muchas imágenes o iframes, cargar todos los recursos al mismo tiempo puede hacer que la página tarde mucho en cargarse completamente.

* Alto consumo de ancho de banda: Cargar elementos que el usuario no verá inmediatamente genera un uso innecesario de datos.

* Mala experiencia de usuario: Los tiempos de carga largos y las páginas pesadas pueden frustrar a los usuarios, especialmente en dispositivos con recursos limitados.

## ¿Cómo resuelve estos problemas?
El atributo loading de HTML, con el valor "lazy", permite a los navegadores decidir cuándo cargar el recurso de acuerdo a su visibilidad en la pantalla.

* loading="lazy": Carga el recurso cuando está a punto de aparecer en la ventana visible del usuario (viewport).

* loading="eager": Indica al navegador que el recurso debe cargarse inmediatamente (este es el comportamiento por defecto de los elementos).

```html
<img src="image.jpg" alt="Descripción de la imagen" loading="lazy">

<iframe src="https://www.youtube.com/embed/xyz" loading="lazy"></iframe>
```
Al usar loading="lazy", el navegador controla la carga de los elementos según el área visible y otros factores, logrando así optimizar el rendimiento sin requerir complejos scripts o herramientas externas.

## Buenas prácticas de lazy loading
* Usar loading="lazy" solo en elementos que realmente necesitan carga diferida: Aplicar lazy loading en todos los elementos sin analizar su impacto puede ser contraproducente, especialmente en elementos clave del contenido que deben cargarse al inicio.

* Optimizar el tamaño de las imágenes y videos: Aunque se use lazy loading, siempre es importante que los recursos multimedia tengan el tamaño y resolución adecuados para mejorar la carga.

* Probar en diferentes navegadores: Aunque la mayoría de los navegadores modernos soportan lazy loading, siempre es bueno verificar la compatibilidad.

* Combinar con otras técnicas de optimización: El lazy loading es solo una de las técnicas de optimización. Usarlo junto con compresión, optimización de imágenes, y carga diferida de JavaScript mejora aún más el rendimiento de la página.