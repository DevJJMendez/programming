# Proxy
Un Proxy (o Forward Proxy) es un intermediario entre un cliente y un servidor. Es un servidor que recibe las solicitudes del cliente y las reenvía al servidor destino, ocultando así la identidad real del cliente.

*✅ Es el cliente quien conoce al proxy, pero el servidor final no conoce al cliente real.*

## ¿Cuál es su estructura?
```bash
[ Cliente ] --> [ Proxy ] --> [ Internet / Servidor objetivo ]
```
El proxy puede ser una aplicación o hardware ubicado en:

La red local del cliente (LAN).

En una infraestructura empresarial.

En un proveedor externo.

## ¿Qué resuelve?
Un forward proxy ayuda a resolver los siguientes problemas:

Privacidad y anonimato del cliente

La IP pública que ve el servidor final es la del proxy, no la del cliente real.

Control de acceso y filtrado

Permite bloquear ciertos sitios o restringir qué URLs puede visitar un cliente.

Caché de contenido

Mejora el rendimiento al cachear páginas web (útil en redes empresariales o educativas).

Auditoría y monitoreo

Se puede registrar qué sitios se visitan desde la red de una organización.

Bypass de restricciones geográficas

Útil para acceder a servicios bloqueados por país.

## ¿Cómo lo resuelve?
El proxy intercepta las solicitudes HTTP(S) o cualquier otro protocolo (DNS, FTP, etc.) y actúa en nombre del cliente:

El cliente hace una solicitud al proxy, no directamente al servidor final.

El proxy analiza, filtra o transforma la solicitud (según configuración).

El proxy reenvía la solicitud al servidor objetivo.

El servidor responde al proxy.

El proxy devuelve la respuesta al cliente.

## Ejemplo práctico
Usuario en una empresa escribe https://www.youtube.com en el navegador.

La solicitud va al proxy de la empresa.

El proxy detecta que youtube.com está bloqueado por políticas.

El proxy deniega la solicitud con un error 403 o página de advertencia.

El servidor de YouTube ni siquiera se entera de la solicitud.

## Tecnologías comunes de Proxy
￼
Herramienta	Tipo	Características destacadas
Squid	Forward	Muy usado en empresas para filtrado y cache
HAProxy	Reverse	Enrutamiento y balanceo de carga
Nginx	Ambos	Web server y proxy versátil
TinyProxy	Forward	Ligero y fácil de configurar

## Diferencia entre Forward Proxy y Reverse Proxy
￼
Característica	Forward Proxy	Reverse Proxy
Lo usa el cliente	✅ Sí	❌
Lo usa el servidor	❌	✅ Sí
Oculta al	Cliente	Servidor
Uso común	Acceso a Internet controlado	Balanceo de carga, caché, SSL offload

# Reverse Proxy
Un reverse proxy es un servidor intermedio que recibe las solicitudes de los clientes (como navegadores web o aplicaciones móviles) y las redirige a uno o más servidores backend. Luego, el reverse proxy recibe la respuesta del backend y se la devuelve al cliente, como si fuera el servidor original.

A diferencia de un proxy tradicional (forward proxy) que actúa como intermediario entre un cliente y el exterior, el reverse proxy actúa como intermediario entre el cliente y un servidor interno (o varios).

## estructura
```bash
[Cliente] ---> [Reverse Proxy] ---> [Servidor Backend 1]
                                 ---> [Servidor Backend 2]
                                 ---> [Servidor Backend N]
```
Componentes típicos:
* TLS termination (finaliza la conexión HTTPS)
* Load Balancing (balanceo de carga)
* Cache
* Seguridad (filtrado de IPs, WAF, rate-limiting, autenticación)
* Reescritura de URLs
* Reglas de enrutamiento (por dominio, path, headers, etc.)

## ¿Qué resuelve?
* Escalabilidad horizontal: balancea la carga entre múltiples instancias backend.
* Seguridad: oculta los servidores backend del mundo exterior.
* Performance: permite caching de respuestas comunes (mejora tiempos de respuesta).
* Manejo centralizado de TLS/SSL: se encarga del cifrado HTTPS, simplificando los backends.
* Simplificación del cliente: todos los clientes solo ven un endpoint, sin preocuparse por los servidores internos.
* Failover y Alta disponibilidad: puede detectar caídas y redirigir el tráfico a servidores sanos.
* Soporte para Microservicios y APIs: enruta tráfico basado en paths o subdominios.

## ¿Cómo lo resuelve?
Ejemplo de funcionamiento paso a paso:
🔗 Un cliente hace una solicitud a https://api.miempresa.com/usuarios.

🌐 El reverse proxy (por ejemplo, NGINX, HAProxy o Traefik):

Verifica si tiene esa ruta cacheada.

Si no, decide a qué backend enviar la solicitud (ej: usuarios-service).

🔁 La respuesta del backend vuelve al reverse proxy.

📤 El reverse proxy devuelve la respuesta al cliente como si fuera el servidor real.

## Tecnologías comunes
NGINX: Altamente eficiente, ideal para reverse proxy, TLS termination y load balancing.

HAProxy: Excelente en entornos con alta carga. Muy usado en bancos y sistemas críticos.

Traefik: Popular en entornos de Docker y Kubernetes, auto-configurable vía etiquetas/annotations.

Apache HTTP Server: También se puede usar como reverse proxy.

Cloud-based: Cloudflare, AWS API Gateway, Azure Front Door, etc.

## Casos de uso reales
🏪 Ecommerce
Un reverse proxy puede enrutar /productos a un microservicio de catálogo, /carrito a uno de compras, y /pago a un servicio de pasarela de pagos, todo desde el mismo dominio.

🧰 CI/CD + Kubernetes
Traefik o NGINX como reverse proxy dinámico que actualiza rutas automáticamente cuando se despliegan nuevos servicios en un cluster.

📊 APIs públicas
Una API pública puede usar un reverse proxy para:

Limitar peticiones (rate limiting).

Autenticar con JWT.

Reescribir paths.

Proteger los backends internos.

## Ventajas clave
Ventaja	Explicación
Centraliza el acceso	Un solo punto de entrada para múltiples servicios.
Escalabilidad	Puede distribuir carga a múltiples backends.
Caché y compresión	Mejora el rendimiento.
TLS Termination	Simplifica manejo de HTTPS.
Filtrado y autenticación	Implementación de firewalls de aplicaciones (WAF).
Compatibilidad con microservicios	Ideal para arquitecturas distribuidas.

## Buenas prácticas
Siempre usar HTTPS en el reverse proxy.

Configurar límites de solicitud (rate limiting) para evitar abusos.

Usar headers seguros como:

X-Forwarded-For

X-Real-IP

X-Forwarded-Proto

Si usas NGINX, optimiza parámetros como worker_processes, keepalive_timeout, etc.

Utiliza health checks para determinar si un backend está disponible.