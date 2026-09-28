# Serveless
Serverless no significa que no haya servidores, sino que no tienes que administrarlos tú.
Es un modelo de computación en la nube donde:

No aprovisionas servidores.

No gestionas infraestructura.

Solo escribes funciones o servicios que se ejecutan en respuesta a eventos.

📌 Tú escribes el código de negocio, el proveedor cloud se encarga del resto (infraestructura, escalado, disponibilidad, etc.).

## ¿Cuál es su estructura?
Una solución serverless típica está compuesta por:

Funciones (ej. AWS Lambda, Azure Functions, Google Cloud Functions)

Eventos (HTTP requests, colas, cambios en base de datos, cron jobs)

Recursos cloud gestionados:

API Gateway

S3 (almacenamiento)

DynamoDB (NoSQL)

Cola de mensajes (SQS, Pub/Sub)

📦 Estas funciones se activan solo cuando ocurre un evento y corren en contenedores efímeros.

## ¿Qué resuelve?
￼
Problema tradicional	Solución Serverless
Gestión y mantenimiento de servidores	💡 El proveedor se encarga
Escalado manual	📈 Autoescalado automático por evento
Pago por servidor 24/7	💰 Pagas solo por tiempo de ejecución
Complejidad de despliegue	🚀 Despliegues rápidos y sencillos

## ¿Cómo lo resuelve?
Event-driven execution: Las funciones se disparan en respuesta a eventos.

Auto scaling: Cada ejecución es independiente; se escalan de forma masiva sin intervención manual.

Billing granular: Pagas por ejecución y duración, no por uptime.

Sin estado: Cada función debe ser stateless, ideal para aplicaciones distribuidas.

## Ejemplo real (E-commerce)
Cuando un usuario realiza una compra:

🛒 POST /orders → dispara una función serverless

📦 La función guarda la orden en una base de datos (DynamoDB)

📧 Luego emite un evento que dispara otra función que envía un email

📊 Otro evento genera un log o dashboard

Todo esto sin levantar un solo servidor web ni backend tradicional.

## ¿Dónde se usa Serverless?
APIs REST/GraphQL con AWS Lambda + API Gateway

Procesamiento de datos (ETL, IoT, streams)

Automatización (cron jobs, alertas)

Backend móvil/web (con autenticación + almacenamiento)

Procesamiento multimedia (resizer de imágenes, análisis de video)

## Ventajas
Ventaja	Detalle
💸 Bajo costo	Pagas solo por lo que usas
⚙️ Mantenimiento mínimo	No admin, no patches
📈 Alta escalabilidad	Autoescalado sin esfuerzo
🚀 Rápido desarrollo	Te enfocas solo en la lógica
🧪 Ideal para prototipos y MVPs	Despliegues en minutos

## Desventajas
￼
Desventaja	Explicación
⌛ Latencia inicial (cold start)	El arranque puede tardar si la función no está en caliente
❌ Stateless only	Difícil mantener contexto entre ejecuciones
📊 Límite de ejecución	Las funciones tienen tiempo limitado (ej. 15 min en AWS)
🔍 Debug complejo	Depurar en producción puede ser difícil
📦 Vendor lock-in	Altamente acoplado a la nube del proveedor

## ¿Y la seguridad?
Roles y políticas IAM para funciones (principio de mínimo privilegio)

Protección contra invocaciones no autorizadas vía API Gateway + Auth

Monitorización con CloudWatch, Azure Monitor, etc.

## Conclusión
El modelo serverless es ideal para arquitecturas modernas:

Escalables

Rentables

Event-driven

Desacopladas

Te permite enfocarte en resolver problemas de negocio, no en gestionar infraestructura.