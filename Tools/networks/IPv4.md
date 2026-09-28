# Internet Protocol version 4
IPv4 (Internet Protocol version 4) es la cuarta versión del Protocolo de Internet y la más usada actualmente. Permite identificar y ubicar dispositivos en una red usando direcciones de 32 bits.

***Es la “matrícula” única que identifica a cada dispositivo en una red y le permite comunicarse.***

## ¿Qué resuelve?
IPv4 resuelve el problema de:

* Identificar cada host en una red
* Permitir el envío de datos entre dispositivos
* Gestionar el enrutamiento y las redes privadas y públicas

## ¿Cómo lo resuelve?
Mediante:

* Asignación de direcciones IP únicas (estáticas o dinámicas)
* Encabezado IP con información de origen y destino
* Subredes (CIDR) para organizar redes
* Protocolos como ARP, ICMP, NAT y enrutadores para guiar los paquetes

## Estructura de una dirección IPv4
Una dirección IPv4 tiene 4 bloques (llamados octetos) separados por puntos.
```bash
Ejemplo: 192.168.10.25
```
* Cada octeto:
  * Representa 8 bits → 1 byte

  * En total: 32 bits
    * Rango por octeto: 0 - 255
```bash
192.168.10.25 →
→ Binario: 11000000.10101000.00001010.00011001
```
***En informática, un octeto es una unidad de información digital compuesta por ocho bits . Se puede considerar el equivalente digital de un byte, que comúnmente también está compuesto por ocho bits.***

## Tipos de direcciones IPv4
| Tipo      | Ejemplo         | Uso                                  |
| --------- | --------------- | ------------------------------------ |
| Pública   | `8.8.8.8`       | Accesible desde Internet             |
| Privada   | `192.168.1.10`  | LAN, VPC, no accesible públicamente  |
| Loopback  | `127.0.0.1`     | Localhost (tu máquina)               |
| Broadcast | `192.168.1.255` | Mensaje a todos los hosts de una red |
| APIPA     | `169.254.x.x`   | Asignación automática si no hay DHCP |

### Clases de IPv4 (obsoleto pero útil en fundamentos)
| Clase | Rango IP inicial            | Cantidad de hoost | Uso típico         |
| ----- | --------------------------- | ----------------- | ------------------ |
| A     | 1.0.0.0 – 126.0.0.0         | ~16 millones      | Grandes redes      |
| B     | 128.0.0.0 – 191.255.0.0     | 65 mil            | Empresas medianas  |
| C     | 192.0.0.0 – 223.255.255.0   | 254               | Hogar / oficina    |
| D     | 224.0.0.0 – 239.255.255.255 | Multicast         | Streaming, routing |
| E     | 240.0.0.0 – 255.255.255.255 | Reservado         | Experimental       |
**Hoy en día usamos CIDR (Classless Inter-Domain Routing) en lugar de clases.**

## Subneteo y CIDR
CIDR permite dividir redes de forma eficiente:
```bash
192.168.10.0/24 → 256 direcciones (254 válidas para hosts)
192.168.10.0/26 → 64 direcciones
```
**¿Qué indica /24, /26?** -> La cantidad de bits usados para la parte de red

**El resto es para hosts**
```bash
/24 → 255.255.255.0
/26 → 255.255.255.192
```

##  Encabezado IPv4
Cada paquete IP tiene un encabezado con información importante:
| Campo          | Descripción                            |
| -------------- | -------------------------------------- |
| Versión        | 4                                      |
| IHL            | Longitud del encabezado                |
| Total Length   | Tamaño total del paquete               |
| TTL            | Time To Live (número máximo de saltos) |
| Protocol       | TCP/UDP/ICMP                           |
| Source IP      | IP de origen                           |
| Destination IP | IP de destino                          |
| Checksum       | Validación de errores                  |
| Flags          | Fragmentación de paquetes              |
Esto permite que routers, switches y firewalls manejen correctamente el tráfico.

## ¿Qué pasa con seguridad?
IPv4 no incluye cifrado. Se apoya en:

* IPsec (rara vez usado en IPv4)
* Firewalls (iptables, ufw, etc.)
* ACLs (Access Control Lists)
* NAT + DNS
* VPNs para cifrado punto a punto