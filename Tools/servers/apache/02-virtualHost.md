# Virtual Host

Los Virtual Hosts (o hosts virtuales) en Apache son una característica que permite a un solo servidor web Apache alojar múltiples sitios web en la misma máquina física. Esto significa que puedes tener varios sitios web con diferentes nombres de dominio o direcciones IP alojados en el mismo servidor.

Cada Virtual Host tiene su propia configuración independiente, lo que permite personalizar la forma en que se sirven los archivos y se manejan las solicitudes para cada sitio web. Esto es útil para alojar varios sitios web en un solo servidor y administrarlos de manera más eficiente.

Hay dos tipos principales de Virtual Hosts en Apache:

- **Virtual Hosts basados en direcciones IP**: En este tipo de Virtual Host, cada sitio web está asociado con una dirección IP diferente en el servidor. Esto significa que cada sitio web tiene su propia dirección IP y Apache utiliza esta información para dirigir las solicitudes entrantes al sitio web correcto.

- **Virtual Hosts basados en nombres de dominio**: Este tipo de Virtual Host permite alojar múltiples sitios web en una única dirección IP. Apache utiliza el nombre de dominio proporcionado en la solicitud HTTP para determinar qué sitio web debe servir. Esto se logra configurando el servidor Apache para escuchar en el puerto 80 (HTTP) y luego utilizando la directiva ServerName para especificar el nombre de dominio para cada sitio web.