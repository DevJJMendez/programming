# Simple Mail Transfer Protocol
SMTP (Simple Mail Transfer Protocol) es un protocolo de red utilizado para enviar correos electrónicos desde un cliente hacia un servidor o entre servidores de correo.

*Su función principal: transmitir emails salientes, no recibirlos.*

Para la recepción se usan protocolos como IMAP o POP3.

## ¿Cómo funciona?
SMTP trabaja en base a una arquitectura cliente-servidor sobre el puerto 25 (por defecto), aunque también puede usar:

587 para envío autenticado con STARTTLS

465 para SMTP seguro (SMTPS)

## Flujo típico
Un cliente de correo (MUA) (como Thunderbird o Gmail) genera un email.

Se conecta al servidor SMTP (MSA) del proveedor.

El MSA valida y retransmite el mensaje al servidor SMTP del destinatario (MTA).

El MTA entrega el mensaje al servidor de entrada del destinatario (MDA).

El destinatario descarga el correo vía IMAP/POP3.

## ¿Cuál es su estructura?
Un mensaje SMTP tiene:

📬 Comandos SMTP básicos
￼
Comando	Propósito
HELO / EHLO	Iniciar conversación con el servidor
MAIL FROM:	Indica el remitente del email
RCPT TO:	Indica el destinatario
DATA	Inicia la entrada del contenido del correo
QUIT	Termina la sesión

## Cuerpo del mensaje
Dentro del DATA va el mensaje en sí, incluyendo:

Headers (From, To, Subject, Date, etc.)

Body (texto plano, HTML o ambos)

Adjuntos (codificados en MIME/Base64)

## ¿Qué resuelve?
Permite la entrega confiable de emails entre distintos servidores.

Soporta múltiples destinatarios, reintentos y rutas intermedias.

Es estándar y ampliamente adoptado por proveedores y empresas.

## Problemas clásicos y soluciones
￼
Problema	Solución recomendada
❌ Texto plano (sin cifrado)	Usar STARTTLS o SMTPS (TLS/SSL)
❌ SPAM	Configurar SPF, DKIM y DMARC
❌ Spoofing (suplantación)	Validar dominio con DKIM y SPF
❌ Relay abierto (correo no autorizado)	Restringir IPs, usar autenticación obligatoria

## Autenticación y Seguridad
SMTP por sí solo no tiene autenticación ni cifrado, pero en la práctica se usa con:

AUTH LOGIN, AUTH PLAIN, AUTH CRAM-MD5 para autenticación.

STARTTLS o SMTPS (465) para cifrado.

## Buenas prácticas para servidores SMTP
Activar STARTTLS / TLS obligatorio.

Autenticación obligatoria para usuarios externos.

Configurar SPF, DKIM y DMARC en DNS.

Implementar rate-limiting y límites de tamaño de mensaje.

Logs auditables para trazabilidad de correos.

## Conceptos relacionados
MUA (Mail User Agent): cliente del usuario (ej: Outlook).

MSA (Mail Submission Agent): primer servidor SMTP que recibe el email.

MTA (Mail Transfer Agent): reenvía entre servidores SMTP.

MDA (Mail Delivery Agent): entrega el correo al buzón final.

IMAP/POP3: protocolos para recibir correo.