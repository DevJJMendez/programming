# Transport Layer Security
TLS es un protocolo criptográfico diseñado para brindar comunicación segura a través de redes como Internet. Protege los datos durante su transmisión, asegurándose de que no sean interceptados, modificados ni falsificados.

⚠️ Aunque mucha gente sigue hablando de "SSL", lo que realmente se usa hoy es TLS, principalmente TLS 1.2 y TLS 1.3.

## Historia rápida
￼
Protocolo	Año	Notas clave
SSL 2.0	1995	Vulnerabilidades severas
SSL 3.0	1996	Mejoras, pero hoy es considerado inseguro
TLS 1.0	1999	Sustituye a SSL
TLS 1.2	2008	Estándar por muchos años
TLS 1.3	2018	Más seguro, rápido y eficiente

## ¿Qué resuelve TLS?
TLS protege contra los principales ataques y debilidades de la comunicación sin cifrado:

￼
Problema	Cómo lo resuelve TLS
Interceptación de tráfico	Cifrado con claves simétricas
Suplantación de identidad	Certificados digitales (PKI)
Modificación de datos	Firmas digitales, hash HMAC
Ataques de repetición	Nonces, identificadores de sesión
Downgrade attacks	TLS 1.3 bloquea negociación de versiones viejas

## ¿Cómo funciona TLS? (Handshake TLS simplificado)
Negociación:

El cliente (navegador) dice: “Hola, quiero usar TLS y estos algoritmos de cifrado”.

El servidor responde con su certificado digital (firmado por una CA) y el algoritmo acordado.

Intercambio de claves:

TLS usa intercambio de claves asimétrico (como Diffie-Hellman) para generar una clave simétrica segura.

Cifrado:

Desde ese punto, la conexión se cifra usando criptografía simétrica (más rápida).

Mensajes autenticados:

TLS agrega MACs (HMAC) para garantizar integridad.

## ¿Qué hace especial a TLS 1.3?
🔐 Solo usa algoritmos seguros (adiós a los antiguos inseguros).

⚡ Reduce el handshake a 1 round trip (mucho más rápido).

🎯 Encripta más metadatos (por ejemplo, los certificados).

🛡️ Mejora contra ataques como downgrade, replay y MITM.

✅ Es el estándar recomendado para nuevas implementaciones.

## Componentes clave de TLS
￼
Componente	Función
Certificados X.509	Identifican al servidor (o cliente) y validan su identidad
Cifrado simétrico	Protege los datos transmitidos
Cifrado asimétrico	Protege el intercambio de claves
HMAC / MAC	Verifica que los datos no se alteren en tránsito
Protocolos	TLS opera sobre TCP (y sobre HTTP para HTTPS)

## ¿Dónde se usa TLS?
Navegadores → HTTPS (https://)

Correos seguros → SMTPS, IMAPS, POP3S

VPNs → OpenVPN, WireGuard

APIs RESTful → HTTPS obligatorio

Bases de datos → MySQL con --ssl, PostgreSQL con sslmode=require

Comunicación entre microservicios → mTLS (TLS mutuo)

## Herramientas útiles para verificar TLS
openssl s_client -connect dominio.com:443

nmap --script ssl-cert,ssl-enum-ciphers -p 443 dominio.com

https://www.ssllabs.com/ssltest/

Navegadores modernos → ver el certificado en el candado del navegador

## Buenas prácticas con TLS
✅ Usa TLS 1.3

❌ Desactiva TLS 1.0, 1.1 y SSL

🔁 Renueva certificados antes de expirar

📦 Usa certificados gratuitos como Let’s Encrypt

💥 Usa HSTS para forzar HTTPS

🧾 Configura redirecciones HTTP → HTTPS

🔐 Considera TLS mutuo (mTLS) para microservicios internos

## Diferencias clave entre SSL y TLS
￼
Característica	SSL	TLS
Estado actual	Obsoleto	Estándar actual
Última versión	SSL 3.0	TLS 1.3
Seguridad	Vulnerable	Muy segura
Compatibilidad	Viejos navegadores	Todos los modernos