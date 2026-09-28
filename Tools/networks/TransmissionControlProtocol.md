# Transmission Control Protocol
El Modelo TCP (Transmission Control Protocol) es uno de los modelos fundamentales para la comunicación de datos a través de redes. Es parte de la suite TCP/IP, que es el conjunto de protocolos que utiliza Internet para la transmisión de datos entre computadoras y dispositivos.

El protocolo TCP en particular es responsable de garantizar que los datos se transmitan de manera confiable, es decir, se aseguran de que los paquetes de datos lleguen completos y en el orden correcto.

El Modelo TCP se basa en el Modelo OSI, pero es más específico y está orientado a la transmisión en redes modernas, como Internet.

## ¿Cuál es su estructura?
El Modelo TCP se basa principalmente en 4 capas. A diferencia del Modelo OSI, que tiene 7 capas, el Modelo TCP/IP tiene una estructura más simplificada:

### 1. Capa de Aplicación (Application Layer):
* Responsabilidad: Interactúa con las aplicaciones de usuario, como navegadores web, clientes de correo electrónico, etc.
* Protocolos: HTTP, FTP, SMTP, POP3, DNS, etc.

**Esta capa maneja la interacción directa con las aplicaciones y se encarga de las tareas que el usuario necesita realizar, como navegar por la web o enviar correos electrónicos.**

### Capa de Transporte (Transport Layer):
* Responsabilidad: Proporciona la entrega confiable de los datos entre los dispositivos de la red.
* Protocolos: TCP, UDP.

**La capa de transporte maneja cómo se dividen los datos en "segmentos" y se aseguran de que lleguen de manera correcta y sin pérdidas. Si el protocolo utilizado es TCP, se encargará de la confiabilidad en la transmisión.**

### 3. Capa de Internet (Internet Layer):
* Responsabilidad: Dirige los paquetes de datos a través de la red, eligiendo las mejores rutas.
* Protocolos: IP, ICMP.

**Esta capa se encarga del enrutamiento de los datos y el manejo de las direcciones de red. Utiliza el protocolo IP (Internet Protocol) para enrutar los paquetes hacia su destino.**

### Capa de Acceso a la Red (Network Access Layer):
* Responsabilidad: Controla la forma en que los datos son enviados a través del hardware de red, ya sea por cable o de forma inalámbrica.
* Protocolos: Ethernet, Wi-Fi, ARP.

**Esta capa está asociada con la transmisión física de los datos, y es responsable de cómo los bits viajan por la red, ya sea a través de cables de red o señales inalámbricas.**

## ¿Qué resuelve el Modelo TCP?
El Modelo TCP resuelve problemas clave relacionados con la fiabilidad de la comunicación de datos en redes:

1. Fiabilidad en la entrega de datos: TCP asegura que los datos enviados lleguen correctamente al destino, sin errores y en el orden adecuado.

2. Control de flujo: Evita que el receptor se vea sobrecargado con más datos de los que puede procesar.

3. Control de congestión: Regula la cantidad de datos enviados para evitar la congestión de la red.

4. Reconocimiento y reenvío: Si un paquete no llega o se recibe con error, TCP solicita su reenvío y espera un reconocimiento (ACK).

5. Conexiones confiables: A diferencia de otros protocolos como UDP, TCP establece una conexión confiable entre el emisor y el receptor antes de empezar a transmitir datos (a través de un proceso llamado handshake o apretón de manos).

## ¿Cómo resuelve TCP estos problemas?
### 1. Establecimiento de la Conexión (Three-Way Handshake):
TCP establece una conexión confiable mediante un proceso llamado Three-Way Handshake. Durante este proceso, el servidor y el cliente se comunican para asegurarse de que ambos pueden intercambiar datos correctamente.

**Proceso:**
1. SYN: El cliente envía una solicitud de conexión (SYN).
2. SYN-ACK: El servidor responde con un SYN-ACK (confirmación de la solicitud).
3. ACK: El cliente confirma el establecimiento de la conexión con un ACK.

Tras este proceso, ambos dispositivos están listos para intercambiar datos.

### 2. Segmentación y Numeración de Secuencia:
* Los datos son divididos en segmentos, y cada segmento recibe un número de secuencia único.
* Esto permite que, en caso de pérdida de datos, TCP pueda volver a transmitir los segmentos faltantes y asegurarse de que los datos lleguen de forma completa y en el orden correcto.

### 3. Confirmaciones (ACKs):
* Cuando un segmento llega correctamente a su destino, el receptor envía un acknowledgment (ACK) para confirmarlo.
* Si el emisor no recibe el ACK dentro de un tiempo determinado, vuelve a enviar el segmento.

### 4. Control de flujo:
* Ventana deslizante (Sliding Window): TCP utiliza un mecanismo de ventana deslizante para gestionar la cantidad de datos que pueden ser enviados antes de esperar un reconocimiento. Esto asegura que el receptor no se vea sobrecargado.

### 5. Control de congestión:
* TCP utiliza algoritmos como Slow Start, Congestion Avoidance, Fast Retransmit, y Fast Recovery para evitar la congestión en la red y adaptarse dinámicamente a las condiciones de la red.

### 6. Terminación de la Conexión:
* Una vez que la transmisión de datos se ha completado, TCP termina la conexión mediante un proceso de terminación en cuatro pasos:
  1. FIN: Un dispositivo indica que ha terminado de enviar datos.
  
  2. ACK: El otro dispositivo confirma la recepción del FIN.
  
  3. FIN: El segundo dispositivo también indica que ha terminado.
  
  4. ACK: El primer dispositivo confirma la terminación de la conexión.

## ¿Por qué es importante el Modelo TCP?
El Modelo TCP es esencial para garantizar que las aplicaciones y servicios que dependen de redes, como la navegación web, el correo electrónico o la transferencia de archivos, puedan funcionar de manera confiable. Es una pieza fundamental de la suite de protocolos TCP/IP y de Internet en general.

Algunas razones clave por las que TCP es importante:
* Confiabilidad: Sin TCP, no podríamos garantizar que los datos lleguen correctamente a su destino.
* Seguridad: Con el control de flujo y el control de congestión, TCP asegura que las redes no se sobrecarguen ni se caigan.
* Escalabilidad: TCP permite que grandes cantidades de datos se transmitan de manera eficiente y confiable en redes grandes como Internet.