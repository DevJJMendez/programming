# Redes
Una Red de computadoras es un conjunto de dispositivos (computadoras, servidores, routers, switches, etc.) interconectados entre sí con el objetivo de compartir información, recursos y servicios.

**En palabras simples**: *Una red permite que varios dispositivos "hablen entre sí" para intercambiar datos*.

## Tipos de redes según su alcance
* **`LAN` (Local Area Network)** → Red de oficina o casa.

* **`WAN` (Wide Area Network)** → Red de gran escala como Internet.

* **`MAN` (Metropolitan Area Network)** → Red en ciudades o campus.

* **`WLAN` (Wireless LAN)** → Redes Wi-Fi.

* **`SDN` (Software Defined Network)** → Redes definidas por software para mayor control y automatización.

**Ejemplo**:
* Una empresa usa `LAN` para conectar computadoras en una oficina.

* Una tienda en línea usa una `WAN` para ofrecer servicios a nivel mundial.

## ¿Para qué sirven las redes?
* **Comunicación**: Permiten la conexión entre dispositivos.

* **Compartir recursos**: Servidores, impresoras, bases de datos.

* **Acceso a internet**: Para navegación y servicios en la nube.

* **Seguridad**: Control de acceso y monitoreo de tráfico.

* **Escalabilidad**: Facilitan el crecimiento de sistemas sin afectar el rendimiento.

Ejemplo:
* Si trabajas en DevOps, necesitas redes para conectar contenedores en Docker o gestionar servidores en AWS, Azure o GCP.

## Estructura de una Red
###  1. Dispositivos finales (Hosts)
* Computadoras, laptops, celulares, servidores, IoT.
* Tienen dirección IP.
* Funcionan como clientes o servidores.

###  2. Dispositivos de red
* **Switch**: conecta dispositivos dentro de una red local (LAN).
* **Router**: conecta redes diferentes entre sí (ej. tu LAN con Internet).
* **Access Point**: extiende una red de forma inalámbrica (Wi-Fi).
* **Firewall**: controla el tráfico y protege la red.

###  3. Medios de transmisión
* Cables (UTP, fibra óptica) o inalámbrico (WiFi, Bluetooth).
* Son el "camino" físico para transmitir datos.

###  4. Protocolos
* Conjuntos de reglas que definen cómo se comunican los dispositivos.
* Ej: TCP/IP, HTTP, FTP, SMTP, DNS, DHCP.

###  5. Servicios
* DNS (traducción de nombres a IPs)
* DHCP (asignación automática de IPs)
* NAT, VPN, proxy, etc.


## ¿Qué resuelven las redes?
* Intercambio de datos
* Acceso a servicios compartidos (servidores, Internet)
* Trabajo colaborativo
* Computación distribuida
* Escalabilidad de sistemas
* Conectividad entre sistemas, personas y servicios

##  ¿Cómo lo resuelve una red?
### 1. Direccionamiento (IP)
* Cada dispositivo tiene una dirección IP única en su red. Es como su "DNI".
* Ej: `192.168.0.15` (**IPv4**)
* Sirve para enviar datos de un punto a otro.

### 2. Modelos de Red
#### Modelo OSI (Open Systems Interconnection) (7 capas)
Un estándar para entender cómo fluye la información en la red, dividido en 7 capas:
| Capa | Nombre          | Ejemplo                    |
| ---- | --------------- | -------------------------- |
| 7    | Aplicación      | HTTP, FTP, DNS             |
| 6    | Presentación    | Codificación, encriptación |
| 5    | Sesión          | Gestión de sesión, sockets |
| 4    | Transporte      | TCP, UDP                   |
| 3    | Red             | IP, ICMP, rutas            |
| 2    | Enlace de datos | MAC, Ethernet, ARP         |
| 1    | Física          | Cables, señales, hardware  |

Como ingeniero, debes conocer especialmente la capa 3, 4 y 7.

#### Modelo TCP/IP (4 capas) → Más práctico y usado en Internet.

---
[](InternetProtocol.md)