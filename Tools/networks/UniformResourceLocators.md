# Uniform Resource Locator
Una URL (Uniform Resource Locator) es una dirección que identifica un recurso en Internet, permitiendo a los navegadores y clientes acceder a documentos, imágenes, APIs, servidores, etc.

***Es como la dirección de una casa en una ciudad digital: te dice dónde está algo y cómo llegar.***

## Estructura de una URL
```bash
https://usuario:password@subdominio.dominio.com:8080/ruta/recurso?clave=valor#seccion
```
| Componente               | Ejemplo             | Función                                                                                        |
| ------------------------ | ------------------- | ---------------------------------------------------------------------------------------------- |
| Protocolo                | `https://`          | Indica cómo comunicarse (HTTP, HTTPS, FTP, etc.)                                               |
| Autenticación (opcional) | `usuario:password@` | En algunos casos, se usa para autenticar usuarios (no recomendado en producción por seguridad) |
| Subdominio               | `subdominio.`       | Parte del dominio, puede representar servicios (api., blog.)                                   |
| Dominio                  | `dominio.com`       | Dirección principal del recurso                                                                |
| Puerto (opcional)        | `:8080   `          | El puerto por el que se accede al recurso (80 HTTP, 443 HTTPS, 3306 MySQL...)                  |
| Ruta                     | `/ruta/recurso`     | Directorio específico del recurso                                                              |
| Query string             | `?clave=valor`      | Parámetros que se envían al recurso                                                            |
| Fragmento (hash)         | `#seccion`          | Apunta a una parte específica del recurso (en HTML, por ejemplo, una sección de la página)     |

## ¿Qué resuelve?
| Problema                          | Solución mediante la URL                             |
| --------------------------------- | ---------------------------------------------------- |
| Identificar un recurso en la red  | La URL es la forma única y universal de apuntar a él |
| Acceder a contenido distribuido   | Encapsula todo lo necesario para llegar al recurso   |
| Pasar parámetros al servidor      | Mediante la query string (`?id=45`)                  |
| Apuntar a recursos dentro de otro | Mediante `#fragmento` (por ejemplo, un div en HTML)  |

## ¿Cómo lo resuelve?
El navegador interpreta la URL:

1. Resuelve el dominio (DNS):
* dominio.com se convierte en una IP.

2. Establece conexión al puerto:
   * 80 para HTTP o 443 para HTTPS (a menos que especifiques otro).

3. Envía una petición:
   * Por ejemplo, una petición GET /ruta/recurso.

4. Recibe la respuesta:
   * Un HTML, JSON, imagen, archivo, etc.

5. Interpreta fragmentos o parámetros:
   * Navega al #seccion del HTML o maneja ?id=3 en un backend o frontend SPA.