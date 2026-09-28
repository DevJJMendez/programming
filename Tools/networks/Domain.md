# Domain
Un dominio es un nombre único que identifica un recurso en Internet, como un sitio web, un servidor de correo o una API.

***Es la dirección legible por humanos que usamos para acceder a servicios en la red, en lugar de tener que memorizar direcciones IP.***

Por ejemplo:

* Dominio: google.com
* IP: 142.250.190.14

Ambos apuntan al mismo servidor, pero el dominio es mucho más fácil de recordar.

## Estructura de un dominio
Ejemplo: `www.ejemplo.com`
| Parte             | Significado                                            |
| ----------------- | ------------------------------------------------------ |
| `www`             | Subdominio (puede ser cualquier cosa: api, mail, etc.) |
| `ejemplo`         | Dominio de segundo nivel (SLD)                         |
| `com`             | Dominio de nivel superior (TLD)                        |
| `.` (punto final) | Raíz DNS, implícita                                    |

## ¿Qué resuelve un dominio?
* Asocia un nombre legible a una IP
* Permite acceder a recursos sin conocer la infraestructura
* Facilita branding (nombre de empresa, producto, etc.)
* Delegación de zonas DNS (puedes controlar subdominios)

## ¿Cómo funciona?
1. Compras un dominio en un registrador (ej. Namecheap, Google Domains, GoDaddy)
2. Configuras registros DNS para que apunten a los servicios (web, correo, APIs, etc.)
3. Los navegadores y servicios usan DNS para traducir el nombre a IP y conectarse

## Ejemplo práctico
Imagina que registras:
miempresa.com

Puedes usarlo así:
| Dominio                | Uso                            |
| ---------------------- | ------------------------------ |
| miempresa.com          | Página principal               |
| www.miempresa.com      | Redirección o página principal |
| api.miempresa.com      | Servidor backend o REST API    |
| mail.miempresa.com     | Servidor de correo             |
| clientes.miempresa.com | Portal para clientes           |
| cdn.miempresa.com      | Entrega de archivos estáticos  |
Cada uno puede apuntar a servidores distintos, regiones distintas o proveedores distintos (ej. Cloudflare, Vercel, Netlify, AWS, etc.)

# Domain Levels
La estructura de un dominio es jerárquica y se compone de niveles separados por puntos (.). Cada nivel representa un nodo en la estructura de nombres del DNS.

Ejemplo:
```bash
www.ejemplo.com
```
Se puede dividir así:
| Nivel                  | Parte                | Descripción                                                       |
| ---------------------- | -------------------- | ----------------------------------------------------------------- |
| Nivel raíz (implícito) | `.`                  | Punto final del sistema DNS, rara vez lo ves, pero está implícito |
| Primer nivel (TLD)     | `com`                | Top-Level Domain                                                  |
| Segundo nivel (SLD)    | `ejemplo`            | Nombre que tú registras                                           |
| Tercer nivel           | `www`                | Subdominio (puede ser www, api, blog, etc.)                       |
| Cuarto nivel y más     | `v1.api.ejemplo.com` | Puedes tener tantos niveles como quieras                          |

##  Tipos de niveles explicados
### Nivel raíz (`.`)
* Es el nivel más alto del DNS.
* Representado por un punto (`.`), aunque usualmente no lo escribimos.
* Ejemplo completo de dominio absoluto: `www.ejemplo.com`.

### Nivel de dominio superior (TLD)
* Aparece después del último punto.
  * Ejemplos: .com, .org, .net, .gov, .edu, .io, .dev, etc.

* Lo gestiona una autoridad global, como la ICANN.
* Existen TLDs genéricos (gTLD) y geográficos (ccTLD, como .es, .mx, .cl).

###  Dominio de segundo nivel (SLD)
* El nombre real que compras.
* Está directamente antes del TLD.
  * Ejemplo: en `google.com`, el SLD es google.

### Subdominios (tercer nivel o más)
* Se añaden a la izquierda del SLD para organizar diferentes servicios.
* Puedes crear infinitos subdominios si tienes control del DNS.

* Ejemplos comunes:
  * www – Sitio web principal
  * api – Backend o microservicio
  * blog – Blog separado
  * cdn, mail, dev, test, admin, etc.

## Ejemplo jerárquico completo
```bash
v1.api.backend.miempresa.com.
| |   |       |          | 
| |   |       |          +-- TLD (nivel 1)
| |   |       +------------- SLD (nivel 2)
| |   +---------------------- Subdominio (nivel 3)
| +-------------------------- Subdominio (nivel 4)
+---------------------------- Subdominio (nivel 5)
```

## ¿Qué resuelve cada nivel?
| Nivel       | ¿Qué resuelve?                                                      |
| ----------- | ------------------------------------------------------------------- |
| TLD         | Segmenta dominios globales (.com, .net, etc.) o por país (.co, .ar) |
| SLD         | Identifica el dominio único que se compra y administra              |
| Subdominios | Permiten dividir servicios o entornos sin registrar nuevos dominios |