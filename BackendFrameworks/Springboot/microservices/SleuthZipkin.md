# Spring Cloud Sleuth + Zipkin: Trazabilidad y Monitoreo en Microservicios
En una arquitectura de microservicios, las peticiones viajan a través de múltiples servicios, lo que dificulta la trazabilidad de las solicitudes y la detección de errores. Aquí es donde entran Spring Cloud Sleuth y Zipkin.

## ¿Qué es Spring Cloud Sleuth?
Spring Cloud Sleuth es una librería de trazabilidad para Spring Boot que:

* Genera identificadores únicos (traceId y spanId) para cada solicitud.
* Asocia logs de diferentes microservicios, creando un rastro completo de la solicitud.
* Se integra con herramientas como Zipkin, Jaeger y ELK para visualizar trazas.

## ¿Qué es Zipkin?
Zipkin es una herramienta de monitoreo y trazabilidad distribuida que:

* Recibe y almacena trazas enviadas por Sleuth.
* Muestra gráficos detallados de cómo viajan las solicitudes entre microservicios.
* Ayuda a identificar cuellos de botella y fallos en la arquitectura.

## ¿Qué problema resuelve Sleuth + Zipkin?
**Problema en microservicios sin trazabilidad**
* No sabemos qué microservicio falló cuando hay un error.
* Es difícil seguir el flujo de una petición en la red de servicios.
* No podemos detectar latencias y cuellos de botella.

**Sleuth + Zipkin lo solucionan**
* Asignan traceId a cada solicitud y spanId a cada operación interna.
* Permiten rastrear solicitudes entre múltiples microservicios.
* Nos ayudan a entender la latencia y tiempos de respuesta en la arquitectura.

## Instalación y Configuración de Sleuth + Zipkin
1. Agregar dependencias en pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
* spring-cloud-starter-sleuth → Genera trazas de solicitudes.
* spring-cloud-starter-zipkin → Envía trazas a Zipkin para visualización.

2. Configurar Zipkin en application.yml
```yaml
spring:
  zipkin:
    base-url: http://localhost:9411  # Dirección de Zipkin Server
  sleuth:
    sampler:
      probability: 1.0  # Envía el 100% de las trazas (usar 0.1 en producción)
```
* base-url → Especifica dónde está corriendo Zipkin.
* sampler.probability → Controla qué porcentaje de solicitudes serán trazadas.

3. Ejecutar Zipkin (Opciones disponibles)

Opción 1: Correr Zipkin con Docker
```bash
docker run -d -p 9411:9411 openzipkin/zipkin
```

Opción 2: Descargar y ejecutar manualmente
```bash
wget -O zipkin.jar https://zipkin.io/zipkin-server-2.23.2-exec.jar
java -jar zipkin.jar
```
Ahora Zipkin estará disponible en http://localhost:9411

## Ver las Trazas en Zipkin
Cuando ejecutamos nuestros microservicios con Sleuth y Zipkin:

1️⃣ Hacemos una petición HTTP a nuestros servicios.
2️⃣ Sleuth genera traceId y spanId automáticamente.
3️⃣ Zipkin recoge la información y la muestra en su interfaz web.

Ejemplo de trazas en los logs de Spring Boot:
```bash
2025-02-19 12:00:00 [INFO] [traceId=abcd1234, spanId=efgh5678] OrderService - Procesando orden #1234
```
* traceId=abcd1234 → Identifica la solicitud en toda la arquitectura.
* spanId=efgh5678 → Identifica una operación específica dentro del servicio.

## Uso en Código: Propagar Trazas entre Microservicios

Ejemplo con FeignClient. Podemos propagar las trazas automáticamente con Feign:
```java
@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {
    @GetMapping("/payments/{orderId}")
    PaymentResponse getPaymentDetails(@PathVariable("orderId") Long orderId);
}
```
Feign automáticamente propaga traceId y spanId en las llamadas HTTP.

## Uso en Código: Agregar Información Personalizada en las Trazas
Podemos personalizar las trazas en nuestros logs.

📌 Ejemplo con Tracer para agregar metadatos:
```java
@Autowired
private Tracer tracer;

public void procesarOrden(Long orderId) {
    Span newSpan = tracer.nextSpan().name("ProcesarOrden").start();
    try (SpanInScope ws = tracer.withSpanInScope(newSpan)) {
        log.info("Procesando orden con ID: {}", orderId);
    } finally {
        newSpan.end();
    }
}
```
Ahora podemos rastrear eventos específicos dentro de un servicio.

## Visualización en Zipkin
Podemos inspeccionar cada traza en http://localhost:9411:

1️⃣ Ir a la pestaña "Find Traces".
2️⃣ Buscar por traceId.
3️⃣ Ver el flujo de la solicitud entre microservicios.

📌 Ejemplo de trazabilidad en Zipkin:
```bash
UserService  ----->  OrderService  ----->  PaymentService
(traceId=abcd1234)       (traceId=abcd1234)       (traceId=abcd1234)
```
Podemos ver los tiempos de cada microservicio y detectar problemas.

## Integración con ELK (Elasticsearch, Logstash, Kibana)
Podemos enviar trazas a Elasticsearch para análisis avanzados.

📌 Ejemplo de configuración para ELK:
```yaml
logging:
  pattern:
    level: "[${spring.application.name}, traceId=%X{traceId:-}, spanId=%X{spanId:-}] %5p"
```
Ahora los logs incluirán traceId y spanId en Kibana.