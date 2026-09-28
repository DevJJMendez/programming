# Internet
El Internet es una infraestructura global de redes interconectadas, que permite la comunicación y el intercambio de datos entre dispositivos en todo el mundo, utilizando protocolos estandarizados, principalmente **TCP/IP**.

*Importante: Internet no es lo mismo que la Web. La Web es un servicio que viaja por Internet.*

## Estructura del Internet
### Modelo jerárquico por capas y entidades
1. Dispositivos finales (Hosts):
   * PCs, smartphones, servidores, IoT...
   * Tienen IP pública o privada.

2. Redes de acceso (ISP Tier-3):
   * Proveen el acceso al usuario final.
   * Ej: Movistar, Claro, Comcast, etc.

3. Backbones (ISP Tier-1 y Tier-2):
   * Redes de alta capacidad que transportan grandes cantidades de datos.
   * Tier-1 no paga a nadie por tránsito, tiene acuerdos con otros Tier-1.

4. IXP (Internet Exchange Points): Lugares físicos donde **ISPs** intercambian tráfico directamente para evitar pasar por Tier-1 y mejorar latencia.

5. Servidores (DNS, Web, Mail, etc.): Brindan servicios sobre Internet.

6. Routers, switches y firewalls: Encaminan, segmentan, aseguran y gestionan el tráfico.

## ¿Qué problema resuelve el Internet?
Necesidad: Conectar computadoras y dispositivos en diferentes lugares del mundo para que intercambien información de forma:

* Estandarizada
* Escalable
* Confiable
* Autónoma (sin un dueño único)
* Distribuida

## ¿Cómo lo resuelve?
A través de:
1. Protocolos de comunicación El conjunto más importante es TCP/IP
   * IP: direccionamiento y enrutamiento
   * TCP/UDP: transmisión
   * HTTP/HTTPS, DNS, FTP, SMTP, etc.: protocolos de aplicación

2. Direccionamiento IP
   * Cada dispositivo tiene una dirección única (IPv4 o IPv6).
   * IPs privadas ↔ IPs públicas (vía NAT)

3. Sistema de nombres de dominio (DNS): Traduce nombres como google.com a IPs como 142.250.64.78.

4. Encaminamiento (Routing): Los routers calculan la mejor ruta para enviar paquetes desde origen a destino.

5. Redundancia y tolerancia a fallos: Múltiples caminos posibles → Internet no se cae completamente si un enlace falla.

---

[](WorldWideWeb.md)
[](Networks.md)