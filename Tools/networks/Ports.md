# Puertos
En el contexto de redes, un puerto es un número lógico que actúa como un punto final para la comunicación dentro de un dispositivo. Se utiliza para identificar servicios específicos que se ejecutan en un sistema.

Analogia rápida:
Imagina una computadora como un edificio (IP) y cada servicio como una oficina dentro (puerto). La IP te dice a qué edificio ir, y el puerto a qué oficina tocar la puerta.

## ¿Cuál es su estructura?
Un puerto es un número entero de 16 bits, lo que permite valores desde 0 hasta 65535.

Se dividen en tres rangos:
| Rango         | Nombre                                   | Usos comunes                               |
| ------------- | ---------------------------------------- | ------------------------------------------ |
| 0 – 1023      | Puertos bien conocidos (well-known)      | HTTP (80), HTTPS (443), SSH (22), FTP (21) |
| 1024 – 49151  | Puertos registrados (registered)         | Usados por aplicaciones específicas        |
| 49152 – 65535 | Puertos dinámicos o privados (ephemeral) | Asignados temporalmente por el sistema     |

##  ¿Qué resuelve?
Multiplexación de servicios: Permite que una misma máquina (misma IP) ofrezca múltiples servicios simultáneamente (por ejemplo: HTTP en 80, SSH en 22).

Dirección precisa: Facilita que las peticiones de red se dirijan exactamente al servicio correcto.

## ¿Cómo lo resuelve?
Cada protocolo de red (como TCP o UDP) usa los puertos para identificar los procesos que deben recibir los datos.

Cuando haces una petición como:
```bash
https://miapp.com:443
```
Estás accediendo a la IP del servidor a través del puerto 443, que es el puerto por defecto del protocolo HTTPS (SSL/TLS sobre HTTP).

## Puertos más comunes y su propósito
| Puerto | Protocolo/Servicio | Descripción                            |
| ------ | ------------------ | -------------------------------------- |
| 20     | FTP (Data)         | Transferencia de archivos (datos)      |
| 21     | FTP (Control)      | Control de sesiones FTP                |
| 22     | SSH                | Acceso remoto seguro a través de shell |
| 23     | Telnet             | Acceso remoto inseguro (obsoleto)      |
| 25     | SMTP               | Envío de correo electrónico            |
| 53     | DNS                | Resolución de nombres                  |
| 80     | HTTP               | Navegación web sin cifrado             |
| 110    | POP3               | Recepción de correos                   |
| 143    | IMAP               | Gestión de correos                     |
| 443    | HTTPS              | Navegación web segura (cifrada)        |
| 3306   | MySQL              | Conexión a base de datos MySQL         |
| 5432   | PostgreSQL         | Conexión a base de datos PostgreSQL    |
| 6379   | Redis              | Conexión a base de datos en memoria    |
| 27017  | MongoDB            | Conexión a base de datos NoSQL MongoDB |

## ¿Cómo se usan los puertos en la práctica?
🧪 Ejemplo Backend API (Express.js en Node.js):
```js
const express = require("express");
const app = express();

app.get("/", (req, res) => {
  res.send("Hello World");
});

app.listen(3000, () => {
  console.log("Servidor corriendo en el puerto 3000");
});
```
Aquí estás sirviendo tu app en el puerto 3000. Si visitas http://localhost:3000, accedes a tu aplicación.

## Seguridad y puertos
Firewalls: Puedes configurar reglas para permitir o bloquear tráfico en puertos específicos.

Escaneos de puertos: Herramientas como nmap permiten detectar puertos abiertos y vulnerabilidades.

Buen diseño de redes: Solo expón los puertos necesarios y mantén los otros cerrados o protegidos.

## ¿Dónde se ven en el día a día?
Navegar por la web: HTTPS usa el puerto 443.

Deploy de APIs: Muchas APIs corren en 3000, 5000, 8080.

Docker: Mapeas puertos al correr contenedores:
```bash
docker run -p 8080:80 nginx
```
Aquí expones el puerto 80 del contenedor en el 8080 de tu máquina.

## Buenas prácticas como Ingeniero:
Documenta los puertos usados por tus servicios.

Evita puertos "hardcoded" cuando despliegues múltiples entornos.

Usa variables de entorno para configurarlos (PORT=8080).

Escanea y monitorea puertos abiertos en tus servidores.

No expongas puertos sensibles como 22 (SSH) sin protección.

# Mapear Puertos
Mapear puertos es el proceso de redirigir el tráfico entrante desde un puerto específico de una máquina anfitriona (host) hacia un puerto interno de una máquina objetivo (contenedor, VM, servicio, etc.).

*Es como decir: “todo lo que llegue al puerto 8080 del host, envíalo al puerto 80 del contenedor.”*

## ¿Dónde se usa el mapeo de puertos?
Docker

Firewalls y routers (NAT)

Máquinas virtuales

Servicios detrás de proxies o balanceadores

## Ejemplo clásico en Docker
```bash
docker run -p 8080:80 nginx
```
Puerto Host	Puerto Contenedor	Descripción
8080	80	Lo que llegue al puerto 8080 del host, se redirige al 80 del contenedor (nginx).
👉 Aquí se está mapeando el puerto 80 del contenedor Nginx al puerto 8080 del host.

## ¿Qué resuelve?
Permite exponer servicios internos sin cambiar su configuración.

Evita conflictos entre servicios que usan los mismos puertos.

Permite acceder a servicios en contenedores o VMs desde fuera del host.

En routers, permite acceder a servicios de una LAN desde internet (port forwarding).

## ¿Cómo lo resuelve?
Usando reglas de redireccionamiento (NAT) a nivel de sistema operativo, contenedor o router.

La tabla de enrutamiento local gestiona las solicitudes y las redirige al puerto correspondiente.

## Importante: Seguridad
No mapees puertos innecesariamente al exterior (host público).

Usa firewalls para controlar el acceso.

Si mapeas puertos sensibles (ej. 22 SSH), considera usar VPN o whitelists.