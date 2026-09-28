# Secure Shell
SSH (Secure Shell) es un protocolo de red utilizado para acceder y administrar sistemas de manera remota de forma segura. Se utiliza principalmente para iniciar sesión en servidores y ejecutar comandos de manera remota, pero también se usa para transferir archivos de manera segura entre máquinas a través de redes no confiables, como Internet.

SSH cifra toda la comunicación entre el cliente y el servidor, lo que lo convierte en una alternativa segura a protocolos antiguos como Telnet y FTP. SSH se utiliza ampliamente en administración de servidores, desarrollo de software, transferencia de archivos, y en muchos sistemas de automatización y configuración.

## Características de SSH
Cifrado de extremo a extremo:

Toda la comunicación entre el cliente y el servidor está cifrada, lo que protege los datos durante la transmisión, como contraseñas y comandos.

Autenticación mediante clave pública:

SSH permite la autenticación tanto mediante contraseñas como mediante un par de claves criptográficas (clave pública y clave privada). Esta autenticación con claves es mucho más segura que usar contraseñas.

Integridad de los datos:

SSH garantiza que los datos no sean modificados o corrompidos mientras se transmiten, usando técnicas de verificación de integridad.

Túneles SSH (SSH Tunneling):

SSH puede ser utilizado para crear "túneles" que permiten redirigir tráfico de una máquina a otra de manera segura, incluso a través de redes inseguras.

Acceso remoto:

SSH es ideal para administradores de sistemas que necesitan conectarse a servidores remotos para gestionar el sistema, realizar mantenimiento, o ejecutar comandos.

Transferencia segura de archivos:

SSH permite transferir archivos de manera segura utilizando protocolos como SCP (Secure Copy Protocol) y SFTP (SSH File Transfer Protocol), que están basados en SSH.

## Cómo funciona SSH
Establecimiento de la conexión:

Cuando un cliente SSH quiere conectarse a un servidor, ambos realizan un proceso de "handshake" (apretón de manos) para asegurarse de que la conexión es segura.

El servidor y el cliente intercambian claves públicas y se verifican mutuamente para asegurarse de que están conectando con el servidor correcto (prevención de ataques de intermediarios).

Autenticación:

Una vez que la conexión segura se ha establecido, el cliente y el servidor pueden autenticar la identidad del cliente. Esto puede ocurrir de dos maneras:

Autenticación por contraseña: El cliente introduce una contraseña en el servidor.

Autenticación por clave pública: El cliente se autentica usando un par de claves criptográficas, donde la clave privada está en el cliente y la clave pública está almacenada en el servidor.

Cifrado de sesión:

Toda la comunicación posterior entre el cliente y el servidor está cifrada usando un algoritmo de cifrado simétrico. Esto asegura que incluso si un atacante intercepta el tráfico, no pueda leer ni modificar los datos.

Sesión segura:

Después de la autenticación y el establecimiento de la conexión segura, el cliente puede ejecutar comandos en el servidor de manera remota, transferir archivos o crear túneles SSH según sea necesario.

## Comandos básicos de SSH
Conectarse a un servidor remoto:
```bash
ssh user@server
```
Donde `user` es el nombre de usuario en el servidor remoto y `server` es la dirección IP o el nombre de dominio del servidor.

2. Usar una clave privada específica para la autenticación:
```bash
ssh -i /ruta/a/clave_privada usuario@servidor
```

3. Ejecutar un comando remoto:
```bash
ssh usuario@servidor 'comando'
```
Este comando ejecutará comando en el servidor remoto sin abrir una sesión interactiva.

4. Transferir archivos con SCP:
```bash
scp archivo usuario@servidor:/ruta/destino
```
Esto transfiere el archivo archivo del cliente al servidor.


5. Transferir archivos con SFTP:
```bash
sftp usuario@servidor
```
Esto abre una sesión de transferencia de archivos interactiva, donde puedes usar comandos como put y get para subir y bajar archivos.

6. Redirigir puertos (Túneles SSH):
```bash
ssh -L puerto_local:servidor_destino:puerto_remoto usuario@servidor
```
Este comando crea un túnel SSH para redirigir el tráfico desde un puerto local hacia un puerto remoto a través del servidor SSH.

## Autenticación por Clave Pública y Privada
Uno de los aspectos más importantes de SSH es su capacidad para usar un sistema de autenticación mediante claves criptográficas. Este sistema se compone de dos claves:

Clave pública:

Es la clave que se comparte con el servidor. Se coloca en un archivo especial (~/.ssh/authorized_keys en el servidor) y no se debe compartir con nadie más.

Clave privada:

Es la clave que se mantiene en el cliente y nunca se debe compartir. Es la clave utilizada para descifrar los mensajes cifrados con la clave pública correspondiente.

Generación de claves:
Para generar un par de claves, puedes usar el siguiente comando en un sistema Linux o macOS:
```bash
ssh-keygen
```
Esto generará una clave privada y una clave pública. La clave privada se guardará en ~/.ssh/id_rsa (por defecto) y la clave pública en ~/.ssh/id_rsa.pub.

Cargar la clave pública al servidor:
Una vez que tienes las claves generadas, puedes transferir la clave pública al servidor usando el siguiente comando:
```bash
ssh-copy-id usuario@servidor
```
Esto copiará la clave pública a la ubicación correcta en el servidor, permitiendo que te autentiques sin usar una contraseña.

## Túneles SSH
Los túneles SSH permiten redirigir el tráfico de un puerto en tu máquina local hacia un puerto en una máquina remota a través de un servidor SSH. Esto es útil en casos donde quieres acceder a recursos internos (por ejemplo, bases de datos, aplicaciones web) que no están accesibles desde tu red local, pero están disponibles en la red interna del servidor SSH.

Túnel local:
```bash
ssh -L puerto_local:destino_remoto:puerto_remoto usuario@servidor
```
Esto redirige el tráfico desde puerto_local en tu máquina local al puerto_remoto en el servidor de destino, a través del servidor SSH.

Túnel remoto:
```bash
ssh -R puerto_remoto:destino_local:puerto_local usuario@servidor
```
Este comando hace lo contrario: redirige el tráfico desde el servidor remoto hacia tu máquina local.

## Ventajas de SSH
Seguridad:

SSH cifra todo el tráfico, lo que previene que los atacantes puedan interceptar o manipular los datos que se están transmitiendo.

Autenticación fuerte:

La autenticación mediante claves es más segura que la autenticación mediante contraseñas.

Facilidad de uso:

SSH es simple de usar y no requiere configuraciones complicadas para tareas comunes como iniciar sesión de manera remota o transferir archivos.

Flexibilidad:

SSH no solo permite iniciar sesión de forma remota, sino que también soporta transferencias de archivos seguras, redirección de puertos y otras características avanzadas.

## Desventajas de SSH
Acceso no autorizado si no se configura correctamente:

Si no se gestionan bien las claves o las configuraciones de seguridad del servidor, un atacante podría ganar acceso al sistema.

Dependencia de la clave privada:

Si alguien obtiene acceso a la clave privada, podría acceder a las máquinas y servicios sin restricciones.

Complicaciones en la administración de claves:

Gestionar múltiples claves y permisos de acceso puede ser complicado, especialmente en entornos grandes o con múltiples usuarios.

## Conclusión
SSH es una herramienta poderosa y fundamental para la administración remota de servidores y la transferencia segura de datos. Gracias a su robusto sistema de cifrado y autenticación, SSH proporciona un entorno seguro para interactuar con sistemas remotos y es ampliamente utilizado en la administración de sistemas, desarrollo de software y automatización.