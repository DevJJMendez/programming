# google Remote Procedure Call.
Es un framework de comunicación remota de alto rendimiento, de código abierto, desarrollado por Google.

gRPC permite que dos aplicaciones (cliente y servidor) hablen de manera eficiente usando protocolos rápidos como HTTP/2 y serializando datos con Protocol Buffers (protobuf).

## ¿Cuál es su estructura o componentes principales?
Cuando construyes con gRPC, debes entender:

￼
Componente	Descripción
Protocol Buffers (.proto)	Esquema de contrato donde defines los servicios, métodos y tipos de datos.
Cliente gRPC	Consume métodos remotos como si fueran funciones locales.
Servidor gRPC	Expone métodos para ser invocados remotamente.
Canal (Channel)	Es el túnel de comunicación segura entre cliente y servidor.
Stub	Código generado automáticamente que abstrae las llamadas remotas (cliente-servidor).

Diagrama simple:
```bash
Cliente gRPC -----> Canal (HTTP/2) -----> Servidor gRPC
```
El cliente invoca métodos en el stub, y el stub traduce las llamadas en tráfico HTTP/2.

## ¿Qué resuelve gRPC?
Antes de gRPC:

Las APIs REST pueden ser lentas para comunicación interna entre microservicios (por peso de HTTP/1.1 y JSON).

Para sistemas en alta concurrencia (millones de requests por segundo), REST tradicional no es suficientemente rápido.

Para streaming de datos, REST no es eficiente.

gRPC resuelve:
✅ Alta eficiencia en redes (gracias a HTTP/2 + Protobuf).
✅ Bajo consumo de ancho de banda.
✅ Comunicación bi-direccional (streaming en ambos sentidos).
✅ Interfaces fuertemente tipadas (gracias a .proto).
✅ Interoperabilidad entre lenguajes (genera código en C++, Go, Java, Python, C#, etc.).

## ¿Cómo lo resuelve?
Usa HTTP/2, que permite multiplexar múltiples requests/responses en una sola conexión TCP.

Usa Protocol Buffers, que son más ligeros y rápidos que JSON o XML.

Define servicios y mensajes en archivos .proto, que luego son compilados para generar stubs cliente y servidor en múltiples lenguajes.

Soporta streaming:

Unary RPC: Petición y respuesta simples (como REST).

Server Streaming RPC: El servidor envía múltiples respuestas.

Client Streaming RPC: El cliente envía múltiples peticiones.

Bidirectional Streaming RPC: Ambos transmiten datos simultáneamente (ideal para chat, IoT, etc).

## Ejemplo sencillo de gRPC
Definir el servicio en .proto
```proto
syntax = "proto3";

service Greeter {
  rpc SayHello (HelloRequest) returns (HelloReply);
}

message HelloRequest {
  string name = 1;
}

message HelloReply {
  string message = 1;
}
```
Aquí defines:

Servicio: Greeter

Método: SayHello

Entrada: HelloRequest

Salida: HelloReply

2. Generar código (stub)
Usas el compilador protoc para generar:
Código del servidor.

Código del cliente.

3. Implementar el servidor
```java
public class GreeterService extends GreeterGrpc.GreeterImplBase {
  @Override
  public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder().setMessage("Hola, " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
```
4. Implementar el cliente
```java
GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName("JJ").build());
System.out.println(reply.getMessage());
```

## Ventajas de gRPC
✅ Muy rápido (10x más rápido que REST en muchos casos).
✅ Interoperable entre lenguajes de programación.
✅ Streaming nativo con HTTP/2.
✅ Contratos estrictos (documentación automática).
✅ Ideal para microservicios internos de alta demanda.

## Desventajas de gRPC
⚠️ No tan "humano legible" como REST (JSON es más fácil de inspeccionar que Protobuf).
⚠️ Necesitas herramientas para debuggear mensajes protobuf.
⚠️ No es ideal para sistemas públicos donde los consumidores esperan REST (navegadores).
⚠️ Si no se configura correctamente, HTTP/2 puede introducir complejidades extra.

## Casos de uso ideales para gRPC
Comunicación entre microservicios en backend.

Aplicaciones móviles que necesitan optimizar ancho de banda.

Sistemas de streaming en tiempo real (chats, videojuegos, IoT).

Comunicación entre plataformas heterogéneas (Java <-> Python <-> Go).