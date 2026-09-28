# Hypertext
El hipertexto es un sistema de organización de información que permite enlazar diferentes bloques de texto o documentos entre sí, mediante enlaces o "hipervínculos".

En otras palabras: el hipertexto permite que el lector salte de una parte de un documento a otra parte, o incluso a otro documento, con solo hacer clic en un enlace.

## Origen
El término fue acuñado por Ted Nelson en los años 60.

Fue llevado a la práctica en la World Wide Web por Tim Berners-Lee en los 90, usando el protocolo HTTP y el lenguaje HTML.

## ¿Cómo se ve el hipertexto en la web?
Cuando visitas una página web y ves enlaces como este:
```html
<a href="https://openai.com">Visita OpenAI</a>
```
Ese es un hipervínculo, una unidad del hipertexto.

## ¿Qué resuelve?
El hipertexto resuelve:

La navegación no lineal del conocimiento.

Facilita la exploración de información interrelacionada sin necesidad de seguir un orden fijo.

Permite referenciar fuentes, ampliar conceptos, o enlazar documentos relacionados.

## Estructura del Hipertexto
Nodos de información: cada nodo es una unidad de contenido (texto, página, documento).

Enlaces (hipervínculos): conectan los nodos entre sí.

Anclas o puntos de entrada: permiten saltar a una sección específica.

En el contexto web, estos nodos suelen estar representados por páginas HTML, y los enlaces por las etiquetas `<a>`.

## Ejemplo Práctico
```html
<p>Aprende más sobre <a href="https://developer.mozilla.org/">desarrollo web</a>.</p>
```
Esto permite al lector navegar hacia otro recurso directamente, sin necesidad de buscarlo manualmente.

## ¿Cómo lo resuelve?
El navegador interpreta el HTML, encuentra el hipervínculo y permite al usuario hacer clic. Luego hace una petición HTTP al servidor indicado en el href y renderiza el nuevo contenido.

## Tipos de enlaces
Internos: enlazan secciones dentro del mismo documento.

Relativos: apuntan a rutas dentro del mismo sitio.

Absolutos: apuntan a sitios externos.

Anclas: saltan a una sección específica (#seccion).

## Hipertexto vs. Hipermedia
￼
Concepto	Contenido principal
Hipertexto	Solo texto con enlaces
Hipermedia	Incluye texto, imágenes, audio, video, etc.
La Web de hoy en día es hipermedia, pero nació como puro hipertexto.

# Hyperlink
Un hipervínculo (o enlace o link) es un elemento interactivo que permite al usuario navegar de un documento a otro o a una parte diferente del mismo documento.

Es el mecanismo técnico que hace realidad el concepto de hipertexto en la web.

Cuando haces clic en un enlace, el navegador realiza una acción, como:

Cargar otra página web.

Saltar a otra sección dentro de la misma página.

Iniciar una descarga.

Ejecutar una acción en una app web.

## ¿Dónde se usa?
En la web, los hipervínculos son implementados principalmente mediante HTML, usando la etiqueta:
```html
<a href="https://openai.com">Ir a OpenAI</a>
```

## Estructura de un Hipervínculo (en HTML)
```html
<a href="URL" target="_blank" rel="noopener noreferrer">Texto o contenido clickeable</a>
```
Atributos comunes:
href: define la dirección a la que apunta el enlace.

target: controla cómo se abre el enlace (_blank para nueva pestaña).

rel: define la relación entre la página actual y la URL (usado por seguridad y SEO).

title: texto emergente cuando pasas el mouse.

## Tipos de Hipervínculos
￼
Tipo	Ejemplo	Uso
Absoluto	https://midominio.com/page	Enlaces externos o rutas completas
Relativo	/productos o ../acerca.html	Dentro del mismo sitio o estructura de archivos local
Ancla interna	#contacto	Navegar a una sección específica del mismo documento
Correo electrónico	mailto:soporte@ejemplo.com	Abre cliente de correo para enviar email
Teléfono	tel:+123456789	Llama al número desde dispositivos móviles
JavaScript	javascript:void(0)	Ejecuta código JS (usado con eventos o para cancelar acciones por defecto)

## ¿Qué resuelve?
Permite la navegación entre recursos.

Facilita la organización no lineal de la información.

Conecta datos, páginas y funcionalidades.

Permite acciones como descargar archivos, enviar formularios, iniciar procesos, etc.

⚙️ ¿Cómo lo resuelve?
Cuando haces clic en un hipervínculo:

El navegador lee el href.

Realiza una petición HTTP al recurso especificado (si es una URL).

Carga la respuesta (una nueva página, un archivo, etc.).

Si es una ancla (#id), simplemente hace scroll hasta el elemento con ese ID.

💡 Buenas Prácticas
Usa enlaces semánticos y descriptivos (no pongas "haz clic aquí").

Agrega title si el propósito no es evidente.

Usa target="_blank" solo cuando sea necesario (por usabilidad y seguridad).

Valida y actualiza tus enlaces regularmente para evitar errores 404.

🧠 Diferencia entre Hipervínculo y URL
￼
Concepto	Descripción
URL	Es la dirección del recurso (Uniform Resource Locator)
Hipervínculo	Es el elemento clickeable que usa esa URL para redireccionar al usuario