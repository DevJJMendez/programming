# Secure Sockets Layer
SSL es un protocolo criptográfico que proporciona comunicación segura sobre una red como Internet. Su objetivo principal es proteger la confidencialidad, integridad y autenticidad de los datos transmitidos entre dos partes (por ejemplo, navegador y servidor web).

*📌 SSL fue reemplazado oficialmente por TLS, pero muchas personas aún usan el término "SSL" para referirse a los certificados TLS.*

## ¿Qué resuelve SSL?
SSL/TLS resuelve varios problemas clave en la comunicación en redes inseguras como Internet:

Problema	Cómo lo resuelve SSL/TLS
Interceptación de datos	Cifra la comunicación con criptografía simétrica
Suplantación de identidad	Autentica con certificados digitales (PKI)
Alteración de datos	Usa resúmenes (hashes) para detectar cambios
Confianza del servidor	Usa CA (Autoridades Certificadoras) para validar

## ¿Cómo funciona SSL/TLS?
Handshake SSL/TLS:

El cliente se conecta al servidor y solicita una conexión segura (HTTPS).

El servidor responde con su certificado digital.

El cliente verifica que el certificado es válido y fue emitido por una CA confiable.

Se negocia un algoritmo de cifrado y se generan claves compartidas.

Una vez autenticado, comienza la comunicación cifrada.

Comunicación cifrada:

A partir de ese punto, todos los datos se cifran con una clave simétrica (más rápido).

El contenido está protegido contra sniffing, modificación y suplantación.

## Certificados SSL (TLS)
Los certificados digitales (comúnmente conocidos como "certificados SSL") son archivos que:

Identifican a una entidad (sitio web, organización)

Están firmados digitalmente por una CA (Certificate Authority)

Contienen:

Nombre de dominio

Fecha de expiración

Clave pública

Firma de la CA

## Tipos de certificados:
￼
Tipo	Nivel de validación	Uso típico
DV (Domain Validation)	Valida que controlas el dominio	Sitios personales, blogs
OV (Organization Validation)	Valida identidad de empresa	Sitios corporativos
EV (Extended Validation)	Validación estricta, barra verde	Bancos, e-commerce
Wildcard	Cubre todos los subdominios	*.tusitio.com
Multidominio (SAN)	Varios dominios con 1 certificado	apps grandes, SaaS

##  ¿Cómo se instala un certificado SSL?
Generas un CSR (Certificate Signing Request).

Envías el CSR a una CA (como Let's Encrypt, DigiCert, Sectigo).

La CA te envía el certificado.

Lo instalas en tu servidor web (Apache, Nginx, etc).

Configuras tu servidor para servir HTTPS.

En plataformas como Cloudflare, AWS ACM, o Firebase Hosting, esto es aún más fácil.

## HTTPS ≠ HTTP
￼
Característica	HTTP	HTTPS (con SSL/TLS)
Puerto	80	443
Cifrado	❌ No	✅ Sí
Certificado	❌ No necesita	✅ Obligatorio
SEO / Seguridad	❌ Penalizado	✅ Recomendado por Google

## Cómo saber si un sitio tiene SSL?
🔒 Candado en la barra del navegador

Usar herramientas como:

curl -v https://dominio.com

openssl s_client -connect dominio.com:443

https://www.ssllabs.com/ssltest

## Mejores prácticas con SSL/TLS
Usa TLS 1.3 (TLS 1.0 y 1.1 están obsoletos)

No uses certificados autofirmados en producción

Renueva los certificados antes de que expiren

Usa HSTS para forzar HTTPS

Configura redirects de HTTP → HTTPS

Activa Perfect Forward Secrecy (PFS) si tu servidor lo permite

## SSL/TLS en entornos cloud
AWS: ACM (AWS Certificate Manager)

Azure: Azure App Services SSL bindings

GCP: Managed certificates en AppEngine o Load Balancer

Docker / Kubernetes: usar Ingress + cert-manager con Let's Encrypt