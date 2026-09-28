# Domain Name System
Es un sistema jerárquico y distribuido que traduce nombres de dominio legibles por humanos (como `google.com`) en direcciones **IP** (como `142.250.190.14`) que las máquinas pueden entender.

DNS es el "directorio telefónico de Internet", resolviendo nombres a IPs.

## ¿Cuál es su estructura?
DNS tiene una estructura jerárquica e invertida, con varios niveles:
```bash
                  .
                 ┌┴┐
              Root (.)
             /   |   \
         com   org   net
         /       \
     google     wikipedia
       |
     www
```
### Niveles jerárquicos:
1. **Root (`.`)**
   * Punto invisible al final de cada dominio (`www.google.com`.)
   * Tiene información de todos los **`TLD` (Top-Level Domains)**

2. **TLD (Top-Level Domain)**
   * Ejemplos: `.com`, `.org`, `.net`, `.edu`, `.io`, `.gov`, etc.

3. **SLD (Second-Level Domain)**
   * Ejemplo: google en `google.com`

4. **Subdominios**
   * Ejemplo: `www` en `www.google.com`, o `api.miapp.com`

## Componentes principales de DNS
| Componente            | Rol                                                             |
| --------------------- | --------------------------------------------------------------- |
| Cliente DNS           | Programa que solicita resolución (navegador, sistema operativo) |
| Servidor Recursivo    | Pregunta por ti a otros servidores                              |
| Servidor Root         | Redirige a servidores TLD                                       |
| Servidor TLD          | Redirige al servidor autoritativo                               |
| Servidor autoritativo | Responde con la IP real del dominio                             |

## ¿Qué resuelve DNS?
* Traducción de nombres a IPs
* Separación de lógica de nombres de la infraestructura (flexibilidad)
* Redirección de servicios por subdominios (api., mail., cdn.)
* Delegación de autoridad y escalabilidad
* Balanceo de carga y redundancia (via múltiples A/AAAA records)

## ¿Cómo lo resuelve?
### Proceso de resolución DNS
1. Tú escribes `www.google.com` en el navegador.

2. El **cliente DNS** consulta al resolver recursivo (generalmente tu ISP o 8.8.8.8 de Google).

3. Si el resolver no tiene la respuesta en caché:
   * Pregunta a un Root Server: ¿quién conoce `.com`?
   * `Root` responde con el servidor TLD `.com`

4. Pregunta al **TLD Server**: ¿quién conoce `google.com`?

5. **TLD** responde con el servidor autoritativo de `google.com`

6. El autoritativo responde con la IP (ej. `142.250.190.14`)

7. El navegador se conecta a esa IP

**Este proceso dura milisegundos y suele almacenarse en caché para acelerar el acceso.**

## Tipos de registros DNS
| Tipo  | Propósito                                               | Ejemplo                                              |
| ----- | ------------------------------------------------------- | ---------------------------------------------------- |
| A     | Nombre → IPv4                                           | **`www`** → `93.184.216.34`                          |
| AAAA  | Nombre → IPv6                                           | **api** → `2606:2800:220:1:248:1893:25c8:1946`       |
| CNAME | Alias hacia otro dominio                                | `blog` → `pages.github.io`                           |
| MX    | Correo (Mail eXchanger)                                 | `@` → `mail.miempresa.com`                           |
| TXT   | Texto arbitrario (SPF, DKIM, verificación Google, etc.) | `"v=spf1 include:mailgun.org"`                       |
| NS    | Nameservers autoritativos del dominio                   | `ns1.digitalocean.com`                               |
| PTR   | IP → nombre (resolución inversa)                        | `14.234.125.192.in-addr.arpa` → `mail.miempresa.com` |
| SRV   | Servicios como VoIP, LDAP, etc.                         | `_sip._tcp`                                          |

