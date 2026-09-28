# File Transfer Protocol
FTP (File Transfer Protocol) es un protocolo de red estándar que permite la transferencia de archivos entre un cliente y un servidor a través de una red TCP/IP, como Internet o una intranet.

*Su propósito es claro: subir, descargar, renombrar, mover y borrar archivos en un servidor remoto.*

## ¿Cuál es su estructura?
FTP se basa en una arquitectura cliente-servidor, usando típicamente dos puertos:

￼
Tipo de conexión	Puerto	Descripción
Control	21	Para comandos (login, cambiar directorio, etc.)
Datos	20 o dinámico	Para la transferencia real de archivos

FTP puede funcionar en dos modos de conexión:
Modo Activo
Cliente abre un puerto dinámico.

Servidor conecta al cliente desde el puerto 20.

🛡️ Modo Pasivo
Cliente se conecta al puerto 21 (control) y a un puerto aleatorio del servidor (datos).

🔒 Recomendado cuando hay firewalls/NAT.

## ¿Qué resuelve?
Permite la transferencia de archivos entre diferentes sistemas (Windows ↔ Linux, etc.).

Facilita la automatización de cargas y descargas masivas.

Útil para mantener y actualizar sitios web (especialmente hosting compartido).

## ¿Cómo lo resuelve?
FTP utiliza comandos simples como:

￼
Comando	Acción
USER	Inicia sesión con nombre de usuario
PASS	Proporciona contraseña
LIST	Lista archivos del directorio
RETR	Descarga archivo
STOR	Sube archivo
DELE	Elimina archivo
Todo esto se ejecuta mediante texto plano (a menos que se use una variante segura).

## Problemas de seguridad (FTP clásico)
FTP NO cifra ni los comandos ni los datos:

❌ Usuario y contraseña en texto plano.

❌ Contenido del archivo visible para terceros (sniffers).

❌ Vulnerable a ataques como MITM, spoofing, hijacking.

## Alternativas seguras
￼
Protocolo	Descripción
FTPS	FTP sobre TLS/SSL
SFTP (SSH File Transfer Protocol)	Funciona sobre SSH (puerto 22) — totalmente cifrado. ¡No es FTP!
SCP	Transferencia segura rápida vía SSH
HTTPS/REST	Muchas APIs modernas usan HTTP seguro para transferencia

## Cómo usar FTP?
🔧 Cliente gráfico (GUI)
FileZilla

Cyberduck

WinSCP

🖥️ Cliente en terminal (CLI)
```bash
ftp ftp.servidor.com
```
Luego:
```bash
login: usuario
Password: ****
ftp> ls
ftp> cd /carpeta
ftp> get archivo.txt
ftp> put subir.txt
ftp> bye
```

## Buenas prácticas
Usa SFTP o FTPS en producción.

Desactiva login anónimo.

Limita los usuarios a sus home directories (chroot).

Usa puertos no estándar si estás detrás de un firewall.

Automatiza con scripts o herramientas como lftp o curl.