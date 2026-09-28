## AWS Free Tier
AWS Free Tier es una oferta que permite a los nuevos clientes de AWS explorar y probar los servicios de AWS de forma gratuita hasta ciertos límites durante un período específico. AWS Free Tier incluye tres tipos de ofertas: 12 meses gratuitos, siempre gratuitos y pruebas gratuitas a corto plazo. Estas ofertas proporcionan acceso a una amplia gama de servicios para que los usuarios puedan experimentar con AWS sin incurrir en costos.

### Tipos de Ofertas de AWS Free Tier
1. 12 Meses Gratuitos: Estos beneficios están disponibles durante los primeros 12 meses a partir de la fecha de registro de una nueva cuenta de AWS.

2. Siempre Gratuitos: Estos beneficios están disponibles de forma continua para todos los clientes de AWS, independientemente de cuándo se registraron.

3. Pruebas Gratuitas: Estas son ofertas a corto plazo que permiten a los clientes probar ciertos servicios de AWS por un período limitado.

### Servicios Incluidos en AWS Free Tier

#### Computación
- **`Amazon EC2` (Elastic Compute Cloud)**
  * Oferta: 750 horas de instancias t2.micro o t3.micro por mes durante 12 meses.
  
  * Casos de Uso: Hospedaje de aplicaciones web, entornos de desarrollo y pruebas.

- `AWS Lambda`
  * Oferta: 1 millón de solicitudes gratuitas por mes y 400,000 GB-segundos de tiempo de cómputo por mes.

  * Casos de Uso: Computación sin servidor, automatización de tareas, procesamiento de eventos en tiempo real.

#### Almacenamiento
- **`Amazon S3` (Simple Storage Service)**
  * Oferta: 5 GB de almacenamiento estándar, 20,000 solicitudes GET y 2,000 solicitudes PUT por mes durante 12 meses.

  * Casos de Uso: Almacenamiento y respaldo de datos, archivado, distribución de contenido.

- **`Amazon EBS` (Elastic Block Store)**
  * Oferta: 30 GB de almacenamiento en volumen de uso general (SSD) o magnético, además de 2 millones de E/S y 1 GB de snapshot por mes durante 12 meses.

  * Casos de Uso: Almacenamiento persistente para instancias EC2, aplicaciones que requieren almacenamiento de bloques.

- **`Amazon EFS` (Elastic File System)**
  * Oferta: 5 GB de almacenamiento de clase EFS Standard por mes.

  * Casos de Uso: Almacenamiento compartido para instancias EC2, aplicaciones web, big data.

#### Bases de Datos
- **`Amazon RDS` (Relational Database Service)**
  * Oferta: 750 horas de instancias db.t2.micro o db.t3.micro por mes durante 12 meses para bases de datos MySQL, PostgreSQL, MariaDB, Oracle BYOL, y SQL Server.

  * Casos de Uso: Bases de datos relacionales para aplicaciones, análisis de datos.

- **`Amazon DynamoDB`**
  * Oferta: 25 GB de almacenamiento de tablas, 25 unidades de capacidad de lectura y 25 unidades de capacidad de escritura por mes.

  * Casos de Uso: Aplicaciones de baja latencia y alta escalabilidad, IoT, juegos.

#### Redes
- **`Amazon VPC` (Virtual Private Cloud)**
  * Oferta: Creación de VPCs, subredes, tablas de rutas y gateways por defecto, sin costo adicional.

  * Casos de Uso: Configuración de redes privadas virtuales, control de acceso a recursos, extensión de redes on-premises a la nube.

#### Análisis y Big Data
- **`Amazon Redshift`**
  * Oferta: 750 horas de instancias dc2.large por mes durante 2 meses y 5 GB de almacenamiento de snapshots.

  * Casos de Uso: Almacén de datos para análisis a gran escala, inteligencia empresarial.

- **`Amazon CloudWatch`**
  * Oferta: 10 métricas personalizadas, 10 alarmas y 1,000,000 de solicitudes de API por mes.

  * Casos de Uso: Monitoreo de recursos de AWS, gestión de logs, alertas de rendimiento.

#### Machine Learning
- **`Amazon SageMaker`**
  * Oferta: 250 horas de instancias t2.medium para notebooks, 50 horas de instancias m4.xlarge para procesamiento o entrenamiento, y 125 horas de instancias m4.xlarge para hosting por mes durante 2 meses.

  * Casos de Uso: Desarrollo, entrenamiento e implementación de modelos de machine learning.

#### IoT
- **`AWS IoT Core`**
  * Oferta: 250,000 mensajes publicados o entregados por mes y 500 conexiones activas por mes durante 12 meses.

  * Casos de Uso: Conexión y gestión de dispositivos IoT, procesamiento de datos de dispositivos.

## Servicios Siempre Gratuitos
- **`Amazon SNS` (Simple Notification Service)**
  * Oferta: 1 millón de publicaciones o entregas de mensajes por mes.

  * Casos de Uso: Envío de notificaciones móviles, alertas, mensajería entre servicios.

- **`Amazon CloudFront`**
  * Oferta: 1 TB de transferencia de datos, 10,000,000 de solicitudes HTTP y HTTPS, y 2,000,000 de solicitudes de invalidación por mes durante 12 meses.

  * Casos de Uso: Distribución rápida de contenido estático y dinámico, transmisión de video, APIs.

- **`AWS CodePipeline`**
  * Oferta: 1 acción de pipeline activa por mes.

  * Casos de Uso: Automatización de despliegue de aplicaciones, integración continua y entrega continua (CI/CD).

## Consideraciones Importantes
* Límites de Uso: Es importante monitorear el uso para asegurarse de no superar los límites gratuitos y evitar costos inesperados.

* Período de Validez: Algunos beneficios del Free Tier son válidos solo por los primeros 12 meses, mientras que otros son siempre gratuitos.

* Registro Requerido: Se necesita una cuenta de AWS y un método de pago válido para acceder al Free Tier, aunque no se cobrarán cargos dentro de los límites gratuitos.