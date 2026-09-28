# Internet Protocol address
Una IP (Internet Protocol address) es un identificador único que se asigna a cada dispositivo conectado a una red. Permite que los datos lleguen al destino correcto, como si fuera una dirección postal digital.

***Es como el número de casa de cada dispositivo en la red. Sin IPs, no sabríamos a dónde enviar los datos.***

## Estructura de una IP
Existen dos versiones principales:

* [IPv4](IPv4.md)
* [IPv6](IPv6.md)

## ¿Qué resuelve?
* Identificación única de cada host en la red
* Direccionamiento para el envío y recepción de paquetes
* Permite la interconexión de redes globales (Internet)
* Facilita el enrutamiento y el control de tráfico

***Sin IP, no habría Internet, ni comunicaciones entre apps distribuidas, ni nube.***

## ¿Cómo lo resuelve?
Mediante:

### 1. Direccionamiento IP
* Cada dispositivo se identifica por una IP.
  * Puede ser estática o dinámica (asignada por DHCP).

* La IP identifica dos cosas:
  * Red (Network ID)
  * Host (Host ID)

**Ejemplo: en `192.168.1.15/24`, la red es `192.168.1.0` y el host es `15`.**

### 2. Enrutamiento
Los routers usan **`IPs`** para decidir a dónde mandar cada paquete.

* Cada paquete contiene:
  * IP de origen
  * IP de destino

* El router revisa la tabla de rutas y encamina el paquete.

### 3. Subneteo
Permite dividir una red en subredes para organización, seguridad y eficiencia.

* Ejemplo: red **`192.168.1.0/24`** puede tener `254` hosts
* Subnetting: **`192.168.1.0/26` → `4`** subredes de `64` direcciones cada una

**Muy útil en redes empresariales y cloud (VPC en AWS, Azure).**

## Tipos de IP
| Tipo     | Descripción                                                 | Ejemplo                                 |
| -------- | ----------------------------------------------------------- | --------------------------------------- |
| Pública  | Visible en Internet. Asignada por tu ISP o proveedor cloud. | `187.123.45.90`                         |
| Privada  | Solo visible en tu red local.                               | `192.168.x.x`, `10.x.x.x`, `172.16.x.x` |
| Estática | No cambia. Ideal para servidores.                           | Ej: backend fijo                        |
| Dinámica | Asignada por DHCP, cambia con el tiempo.                    | Ej: laptops, celulares                  |
| Loopback | Direcciones internas (localhost).                           | `127.0.0.1`                             |

## Rango de IPs privadas (para LANs y VPCs)
| Clase | Rango                         |
| ----- | ----------------------------- |
| A     | 10.0.0.0 – 10.255.255.255     |
| B     | 172.16.0.0 – 172.31.255.255   |
| C     | 192.168.0.0 – 192.168.255.255 |
**Estas no son accesibles desde Internet. Se usan con NAT para salir a Internet.**

## Seguridad y IPs
* Puedes usar firewalls para permitir/bloquear IPs específicas.
* Listas blancas: solo ciertos IPs pueden acceder a tus APIs o servidores.
* NAT (Network Address Translation): traduce IPs privadas a públicas para que los dispositivos salgan a Internet.

## Conceptos clave que debes dominar
| Concepto        | ¿Para qué sirve?                                      |
| --------------- | ----------------------------------------------------- |
| CIDR (/24, /16) | Define la cantidad de hosts por red                   |
| DHCP            | Asigna IPs dinámicamente                              |
| NAT             | Traduce IPs privadas a públicas                       |
| DNS             | Traduce nombres de dominio a IPs                      |
| Firewall        | Controla qué IPs pueden acceder a qué servicios       |
| ARP             | Mapea IP ↔ MAC en LAN                                 |
| IP Tables       | Firewall en Linux, puedes bloquear IPs, puertos, etc. |

---
[](DomainNameSystem.md)