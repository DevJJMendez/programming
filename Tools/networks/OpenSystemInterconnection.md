# Open Systems Interconnection
El Modelo OSI es un marco teórico creado por la ISO (Organización Internacional de Normalización) que se utiliza para entender y diseñar redes de comunicaciones. OSI significa Open Systems Interconnection. Este modelo divide las tareas de comunicación de red en 7 capas. Cada capa tiene un conjunto específico de responsabilidades, lo que facilita la resolución de problemas y el diseño de redes.

El propósito principal del Modelo OSI es estandarizar la forma en que los diferentes componentes de una red interactúan, de manera que los dispositivos y tecnologías de diferentes fabricantes puedan trabajar juntos.

## Estructura
El Modelo OSI tiene 7 capas, organizadas de la capa más cercana al usuario final a la más cercana al hardware físico.

### Capa 7 - Aplicación (Application Layer)
* Función principal: Interacción directa con el usuario y las aplicaciones.
* Protocolos comunes: HTTP, FTP, SMTP, DNS, POP3, IMAP.
* Responsabilidad: Facilitar la interacción con las aplicaciones del usuario y proporcionar servicios de red como correo electrónico, navegación web, etc.

**Ejemplo: Cuando usas un navegador web (como Chrome), la capa de Aplicación es la que utiliza HTTP para enviar una solicitud a un servidor web.**

### Capa 6 - Presentación (Presentation Layer)
* Función principal: Traducir, cifrar y comprimir los datos para que puedan ser comprendidos por la capa de Aplicación.
* Protocolos comunes: SSL/TLS (cifrado), JPEG, GIF, MPEG (compresión de datos).
* Responsabilidad: Asegurar que los datos lleguen a la aplicación en el formato correcto (codificación, cifrado, compresión).

**Ejemplo: Si estás visitando un sitio web con HTTPS, la capa de Presentación manejará el cifrado de los datos entre el servidor y tu navegador.**

### Capa 5 - Sesión (Session Layer)
* Función principal: Mantener, gestionar y terminar sesiones de comunicación entre aplicaciones.
* Protocolos comunes: RPC, NetBIOS, SMB, PPTP.
* Responsabilidad: Establecer, mantener y finalizar sesiones entre las aplicaciones. Asegurar que no haya pérdidas de datos durante las sesiones y que las conexiones estén sincronizadas.

**Ejemplo: En una llamada de Skype, la capa de Sesión mantiene la "sesión de comunicación" activa entre los dos dispositivos durante la llamada.**

### Capa 4 - Transporte (Transport Layer)
* Función principal: Proporcionar transferencia confiable de datos entre dos dispositivos.
* Protocolos comunes: TCP (Transmission Control Protocol), UDP (User Datagram Protocol).
* Responsabilidad: Garantizar que los datos lleguen de manera completa y correcta. TCP realiza la segmentación de los datos y controla la confiabilidad de la transmisión. UDP no tiene control de errores y es más rápido.

**Ejemplo: Cuando descargas un archivo desde Internet, TCP se encarga de dividir el archivo en segmentos, asegurándose de que se reensamblen correctamente en el destino.**

### Capa 3 - Red (Network Layer)
* Función principal: Encargarse del enrutamiento de los datos entre redes y la asignación de direcciones.
* Protocolos comunes: IP (Internet Protocol), ICMP, IPsec.
* Responsabilidad: Encargarse de la dirección lógica (dirección IP) y el enrutamiento de los paquetes de datos desde el origen hasta el destino a través de diferentes redes.

**Ejemplo: Cuando haces una petición HTTP, el protocolo IP se encarga de enviar los paquetes a la dirección IP correcta, navegando por diferentes enrutadores.**

### Capa 2 - Enlace de Datos (Data Link Layer)
* Función principal: Controlar el acceso al medio de transmisión físico y gestionar los errores de la capa física.
* Protocolos comunes: Ethernet, Wi-Fi, PPP (Point-to-Point Protocol), ARP.
* Responsabilidad: Organizar los datos en tramas y asegurarse de que los errores de transmisión sean corregidos. También se ocupa de la asignación de direcciones físicas (MAC).

**Ejemplo: Cuando te conectas a una red Wi-Fi, esta capa gestiona la conexión y la transmisión de datos dentro de la red local, asegurándose de que los datos sean enviados correctamente.**

### apa 1 - Física (Physical Layer)
* Función principal: Transferir los bits a través de un medio físico (cable, fibra, radio).
* Protocolos comunes: Ethernet (en cuanto a cableado), Wi-Fi (radiofrecuencia), fibra óptica, cables coaxiales.
* Responsabilidad: Convertir los datos en señales físicas y enviarlas a través de medios como cables o ondas de radio.

**Ejemplo: En la capa física, los bits de tu correo electrónico o página web se convierten en señales eléctricas o electromagnéticas que viajan por cables o aire.**

## ¿Qué resuelve el Modelo OSI?
El Modelo OSI resuelve principalmente:

1. Interoperabilidad: Permite que dispositivos y aplicaciones de diferentes fabricantes trabajen juntos, utilizando protocolos estandarizados para la comunicación.

2. Estandarización: Ofrece un marco común que facilita la comunicación y resolución de problemas entre redes y tecnologías.

3. Modularidad: Divide las tareas de comunicación en capas bien definidas, lo que facilita la implementación, mantenimiento y resolución de problemas en cada capa.

4. Desarrollo y mantenimiento de redes: Facilita el diseño, implementación y diagnóstico de redes al proporcionar un esquema claro de cómo interactúan los componentes.

## ¿Cómo lo resuelve?
El Modelo OSI resuelve estos problemas dividiendo las funciones de la comunicación en capas. Cada capa tiene una responsabilidad clara y un conjunto de protocolos, y se comunica únicamente con la capa superior e inferior. Esto significa que si ocurre un problema en una capa, puedes aislarlo y solucionarlo sin afectar a las demás.

Ejemplo:
Cuando haces una solicitud HTTP en tu navegador, cada capa de OSI tiene un papel que desempeñar:

1. Aplicación: El navegador crea la solicitud HTTP.

2. Presentación: Los datos pueden ser cifrados antes de ser enviados.

3. Sesión: Mantiene la sesión abierta para la comunicación continua.

4. Transporte: Asegura que los datos lleguen sin errores.

5. Red: Determina la mejor ruta para enviar los datos.

6. Enlace de Datos: Formatea los datos en tramas para que puedan ser enviados a través de la red física.

7. Física: Envía los datos a través de cables o señales inalámbricas.