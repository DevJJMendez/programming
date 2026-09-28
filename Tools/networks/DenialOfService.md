# Denial Of Service
DoS (Denial of Service) es un tipo de ataque cuyo objetivo es interrumpir el funcionamiento normal de un sistema, red o servicio para que deje de estar disponible para usuarios legítimos.

*Un ataque DoS satura el objetivo con tráfico malicioso o explota vulnerabilidades, provocando caídas, lentitud o fallos.*

## ¿Cómo funciona un DoS?
Un atacante envía una gran cantidad de solicitudes falsas o maliciosas hacia un sistema, consumiendo:

CPU

RAM

Disco

Conexiones de red

Recursos de una API o servicio

Al agotarse los recursos, el sistema no puede responder a usuarios reales.

## ¿Qué resuelve (el atacante)?
Desde el punto de vista del atacante, un DoS puede:

Interrumpir servicios críticos (por venganza o chantaje).

Causar pérdidas económicas.

Afectar la reputación de una empresa.

Facilitar otros ataques (como intrusiones mientras los sistemas están caídos).

## Tipos de ataques DoS
🔹 1. Flooding
Saturar el ancho de banda o los recursos con tráfico excesivo:

UDP Flood

ICMP Flood (Ping of Death)

HTTP Flood

🔹 2. Explotación de vulnerabilidades
Abusar de errores en la lógica de negocio o del sistema:

Envío de peticiones mal formadas.

Bypass de validaciones.

🔹 3. Slowloris
Mantiene muchas conexiones abiertas y lentas, saturando el servidor sin mucho tráfico.

## Diferencia entre DoS y DDoS
￼
Característica	DoS	DDoS
Fuente	Un solo equipo atacante	Muchos equipos (botnet)
Alcance	Limitado	Mucho más potente y peligroso
Detección	Más sencilla	Difícil por múltiples orígenes
📌 DDoS (Distributed Denial of Service) es una versión más avanzada y distribuida del ataque DoS, más común hoy en día.

## ¿Cómo se mitiga un DoS?
￼
Estrategia	Descripción
🔒 Firewalls y WAFs	Bloquean tráfico malicioso y patrones anómalos.
🧱 Rate Limiting	Limita la cantidad de peticiones por IP o usuario.
🧠 Análisis de tráfico	Detecta patrones sospechosos en tiempo real.
🔄 Autoscaling	Permite a sistemas elásticos adaptarse al tráfico (en cloud, por ejemplo).
🌍 CDNs (Cloudflare, Akamai)	Absorben el tráfico antes de llegar al servidor.
🎯 CAPTCHA	Detiene bots automatizados en puntos críticos de acceso.

## Ejemplo real de DoS
Supongamos que tienes una API de login sin límite de peticiones. Un atacante podría hacer 1 millón de peticiones por segundo con credenciales inválidas, haciendo que:

El servidor colapse por exceso de CPU.

La base de datos se sature.

Los usuarios reales no puedan autenticarse.