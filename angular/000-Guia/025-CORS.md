# CORS

CORS, que significa **Cross-Origin Resource Sharing (Compartir recursos entre diferentes orígenes)**, es un mecanismo de seguridad utilizado por los navegadores web para restringir las solicitudes **HTTP** entre diferentes orígenes, es decir, entre diferentes dominios, protocolos o puertos.

Cuando un navegador realiza una solicitud HTTP a un servidor en un dominio diferente al de la página que se está cargando, se trata de una solicitud entre orígenes **(cross-origin request)**. Por razones de seguridad, los navegadores aplican la política de mismo origen **(same-origin policy)**, que impide que el código JavaScript de una página web realice solicitudes a un servidor en un dominio diferente al de la página que se está cargando, a menos que el servidor en ese otro dominio permita explícitamente las solicitudes desde el dominio de la página.

Es aquí donde entra en juego **CORS**: es un mecanismo que permite a los servidores especificar qué dominios pueden acceder a los recursos del servidor a través de solicitudes HTTP. Esto se logra mediante el uso de encabezados HTTP, como **Access-Control-Allow-Origin**, que el servidor envía en respuesta a las solicitudes del navegador. Si el servidor responde con los encabezados CORS adecuados, el navegador permitirá que el código JavaScript en una página web acceda a los recursos del servidor, incluso si el origen del código JavaScript y el servidor son diferentes.

Por ejemplo, un servidor podría enviar el siguiente encabezado CORS en respuesta a una solicitud:

```bash
Access-Control-Allow-Origin: https://www.ejemplo.com
```

Esto indica que el servidor permite solicitudes desde el dominio https://www.ejemplo.com.

En resumen, CORS es un mecanismo utilizado por los navegadores para permitir que el código JavaScript en una página web acceda a los recursos de un servidor en un dominio diferente, siempre y cuando el servidor permita explícitamente las solicitudes desde ese dominio mediante el uso de encabezados HTTP CORS adecuados. Esto ayuda a proteger la seguridad y la privacidad de los usuarios de Internet al limitar el acceso a los recursos solo a dominios de confianza.
