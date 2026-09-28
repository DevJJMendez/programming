# Internet Protocol version 6
Pv6 (Internet Protocol version 6) es la sexta versión del Protocolo de Internet, diseñado para reemplazar a IPv4. Proporciona una cantidad casi infinita de direcciones IP únicas (`2¹²⁸`) y resuelve muchas limitaciones del protocolo anterior.

***Es la columna vertebral del Internet del futuro, preparada para IoT, cloud, movilidad, y más.***

## ¿Qué resuelve?
IPv6 soluciona varios problemas de IPv4:
| Problema en IPv4                | Solución en IPv6                                  |
| ------------------------------- | ------------------------------------------------- |
| Agotamiento de direcciones      | Espacio de direcciones de 128 bits                |
| NAT necesario                   | Cada dispositivo puede tener IP pública           |
| Configuración manual o por DHCP | Soporte para autoconfiguración automática (SLAAC) |
| Seguridad opcional              | IPSec obligatorio en IPv6                         |
| Encabezado complejo             | Encabezado más simple y eficiente                 |

## Estructura de IPv6
### Longitud: 128 bits (4 veces más que IPv4)
Una dirección IPv6 se representa en 8 grupos de 4 dígitos hexadecimales (16 bits cada uno), separados por `:`.
```bash
Ejemplo: 2001:0db8:85a3:0000:0000:8a2e:0370:7334
```

### Reglas de notación simplificada
1. Se pueden omitir ceros iniciales de cada bloque:
```bash
2001:db8:85a3:0:0:8a2e:370:7334
```

2. Se puede usar `::` para representar uno o más grupos de ceros consecutivos, una sola vez por dirección:
```bash
2001:db8:85a3::8a2e:370:7334
```

## Tipos de direcciones IPv6
| Tipo                       | Prefijo   | Uso                                   |
| -------------------------- | --------- | ------------------------------------- |
| Unicast global             | 2000::/3  | IP pública única                      |
| Link-local                 | fe80::/10 | Comunicación local (por interfaz)     |
| Multicast                  | ff00::/8  | Comunicación a múltiples dispositivos |
| Loopback                   | ::1       | Equivalente a 127.0.0.1               |
| Unspecified                | ::        | Sin dirección asignada aún            |
| Unique Local Address (ULA) | fc00::/7  | Similar a las IP privadas en IPv4     |

## ¿Cómo lo resuelve?
### 1. Autoconfiguración (SLAAC)
El host genera su IP automáticamente basado en el prefijo de red y su interfaz de red.

No necesita DHCP (aunque puede coexistir).
```bash
ping6 fe80::1%eth0
```

### 2. Encabezado simplificado
IPv6 tiene un encabezado más limpio y eficiente que IPv4:

| Campo               | Descripción                            |
| ------------------- | -------------------------------------- |
| Version             | 6                                      |
| Traffic Class       | Calidad de servicio                    |
| Flow Label          | Agrupación de paquetes                 |
| Payload Length      | Longitud de datos                      |
| Next Header         | Protocolo siguiente (TCP, UDP, ICMPv6) |
| Hop Limit           | TTL (equivalente)                      |
| Source Address      | Dirección IP de origen                 |
| Destination Address | Dirección IP destino                   |

### 3. Seguridad nativa
* IPSec es obligatorio: permite cifrado, autenticación y control de integridad a nivel de red.
* Mejora la seguridad de extremo a extremo sin depender completamente de capas superiores.

### 4. Eliminación de NAT
* Cada dispositivo puede tener una IP pública única.
* Esto permite una conectividad directa, más rápida y segura, y simplifica el enrutamiento.

### 5. Mejor soporte para movilidad e IoT
* IPv6 está diseñado para miles de millones de dispositivos conectados (IoT).
* Cambiar de red no requiere perder la conexión (Mobile IPv6).

## Transición de IPv4 a IPv6
Muchos sistemas aún funcionan con IPv4. Las técnicas de transición incluyen:

| Técnica     | Función                               |
| ----------- | ------------------------------------- |
| Dual Stack  | Soporte de IPv4 e IPv6 simultáneo     |
| Tunneling   | Encapusla tráfico IPv6 dentro de IPv4 |
| NAT64/DNS64 | Traducción entre IPv4 e IPv6          |