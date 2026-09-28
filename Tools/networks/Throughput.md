# Throughput
Throughput, en español "rendimiento" o "productividad", mide la cantidad de trabajo que un sistema puede procesar en un período de tiempo.

*Es decir: ¿cuántas unidades de algo puede manejar tu sistema por segundo, minuto o hora?*

## ¿Cómo se expresa?
En redes: Megabits por segundo (Mbps).

En APIs: peticiones/segundo.

En bases de datos: transacciones/segundo (TPS).

En colas de mensajes: mensajes procesados por segundo.

En discos/almacenamiento: MB/s o IOPS (input/output operations per second).

## Ejemplos para distintos contextos
Contexto	Ejemplo de Throughput
API Gateway	15,000 requests por segundo
Base de datos (PostgreSQL)	2,000 transacciones por segundo
RabbitMQ (mensajería)	50,000 mensajes por segundo
Disco SSD	500 MB/s de lectura secuencial
Red Ethernet	1 Gbps (Gigabit por segundo)

## ¿Qué resuelve?
El throughput no resuelve directamente un problema, pero te dice qué tan eficiente o escalable es tu solución. Ayuda a responder:

¿Puede mi API manejar tráfico en producción?

¿Mi sistema de colas puede procesar los eventos en tiempo real?

¿Qué tanto debo escalar horizontalmente?

¿Mi base de datos necesita sharding o particionamiento?

## ¿Cómo se mejora el Throughput?
🔧 Depende del contexto, pero aquí tienes varias estrategias generales:

1. Escalabilidad Horizontal
Agregar más nodos/instancias.

Balanceo de carga (Load Balancer).

2. Batching y Bulk Operations
Procesar datos en bloques en lugar de individualmente.

3. Asincronismo
Usar colas (Kafka, RabbitMQ).

Webhooks o eventos para procesos no bloqueantes.

4. Caching
Usar Redis, Memcached para evitar recalcular.

Cachear respuestas en el API Gateway.

5. Optimización de código y recursos
Mejorar consultas SQL.

Compresión de payloads.

Parallelismo y concurrencia controlada.

## Fórmulas clave
Una forma simple de pensar el throughput es:
```bash
Throughput = Unidades procesadas / Tiempo
```
Por ejemplo:
```bash
Throughput = 12,000 requests / 60 segundos = 200 RPS (requests per second)
```

## Throughput vs Latencia
Métrica	¿Qué mide?	Importancia
Latencia	Tiempo que tarda UNA operación	Importante para experiencia UX
Throughput	Cuántas operaciones haces por segundo	Importante para escalabilidad
Un sistema puede tener alta latencia pero alto throughput, o baja latencia pero bajo throughput.

## ¿Cómo se mide?
Puedes usar herramientas según el entorno:

🔍 APIs: Apache JMeter, K6, Artillery, Postman + monitor.

🗄️ DB: pgbench (PostgreSQL), sysbench (MySQL), métricas de Prometheus.

🌐 Redes: iPerf, Netdata.

☁️ Cloud: CloudWatch (AWS), Azure Monitor, Datadog, New Relic.

## Ejemplo real en una arquitectura moderna
Supongamos que tienes un sistema de ecommerce con las siguientes capas:

Frontend (React)

API Gateway (Nginx)

Backend (Spring Boot + Java)

Cola (Kafka)

Base de datos (PostgreSQL)

Para tener un throughput alto, debes:

Optimizar el backend para manejar múltiples requests por segundo.

Tener workers paralelos para consumir Kafka.

Indexar la base de datos y evitar cuellos de botella.

Usar caché para productos populares.

Medir con Prometheus y ajustar donde el throughput caiga.