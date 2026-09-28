# World Wide Web
La World Wide Web (WWW) es un sistema de distribución de información basado en hipertexto, que funciona sobre Internet. Es lo que permite acceder a páginas web desde tu navegador, utilizando protocolos como HTTP y HTTPS.

**Recuérdalo siempre**: *la Web es un servicio que vive sobre la infraestructura de Internet, así como el correo o el FTP*.

##  ¿Cuál es su estructura?
Podemos dividir la estructura de la Web en tres grandes componentes:

### 1. Cliente web (User Agent)
* Navegadores (Chrome, Firefox, Safari, etc.)
* Aplicaciones móviles/web (con WebView o HTTP client)
* Curl, Postman, etc.

**Solicitan recursos usando HTTP/HTTPS.**

### 2. Servidor web
* Servidores que procesan las peticiones y devuelven respuestas.
  * Ej: Apache, Nginx, Node.js, Spring Boot, Django, etc.

**Sirven archivos estáticos o generan contenido dinámico (HTML, JSON, etc.)**

### 3. Recursos y documentos
* Documentos HTML, CSS, JS, imágenes, videos, PDF, JSON, etc.

**Enlaces entre documentos → hipervínculos (hyperlinks)**

## ¿Qué problema resuelve la Web?
Antes de la Web, compartir información digital era difícil, manual y técnico. La Web resolvió eso permitiendo:

* Acceso universal a documentos y apps
* Acceso desde múltiples dispositivos y sistemas
* Distribución de contenido de manera descentralizada
* Modelo cliente-servidor simple de implementar y escalar

## ¿Cómo lo resuelve?
### 1. Modelo cliente-servidor
* Cliente (navegador) solicita recursos.

* Servidor los devuelve usando HTTP o HTTPS.

### 2. Protocolos web
* HTTP: define cómo se comunican cliente y servidor.
* HTTPS: HTTP + cifrado TLS (seguridad).
* URI/URL: identifica recursos.
* HTML: estructura de los documentos.
* CSS: estilo visual.
* JavaScript: comportamiento/interactividad.
* JSON: para APIs.

### 3. Navegador como motor
* Interpreta HTML, CSS y JS.
* Crea el DOM (Document Object Model).
* Renderiza visualmente la web.
* Gestiona sesiones, cookies, almacenamiento local.

### 4. Hipervínculos
* Conectan recursos entre sí. -> **Le dan a la Web su "forma de red" (web de documentos enlazados).**

## Estructura técnica de una petición web
Cuando visitas https://www.ejemplo.com:

1. Tu navegador hace una petición DNS para resolver el dominio a una IP.
2. Abre una conexión TCP (y negocia TLS si es HTTPS).
3. Envía una petición HTTP GET al servidor.
4. El servidor responde con un HTML.
5. El navegador descarga los recursos referenciados (CSS, JS, imágenes).
6. Renderiza la página para ti.

