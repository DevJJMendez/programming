# Simple Object Access Protocol
SOAP (Simple Object Access Protocol) es un protocolo de mensajería diseñado para permitir la comunicación entre aplicaciones a través de redes, usualmente usando HTTP y XML.

Fue creado por Microsoft, IBM y otros en los 2000, y es uno de los estándares más antiguos de servicios web.

🔹 Características clave:
Basado en XML.

Extensibilidad: se puede extender mediante headers.

Neutralidad: se puede usar con HTTP, SMTP, TCP, etc.

Independiente del lenguaje y del sistema operativo.

Compatible con WSDL para describir el servicio.

## Estructura de un mensaje SOAP
Un mensaje SOAP está contenido en un archivo XML con una estructura estándar. Aquí te muestro su esqueleto:
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Header>
    <!-- Información opcional como seguridad, control de transacción -->
  </soap:Header>
  <soap:Body>
    <!-- Mensaje del servicio, por ejemplo una petición o respuesta -->
  </soap:Body>
</soap:Envelope>
```
Componentes principales:
Componente	Descripción
Envelope	Elemento raíz. Define el inicio y fin del mensaje SOAP.
Header	(Opcional) Contiene metadatos como autenticación, seguridad, transacciones, etc.
Body	Contiene el contenido principal de la solicitud o respuesta.
Fault	Subcomponente del body. Proporciona detalles sobre errores SOAP.

## ¿Qué resuelve?
🎯 Problemas que resuelve SOAP:
✅ Comunicación entre aplicaciones heterogéneas.

✅ Interoperabilidad: entre Java, .NET, Python, etc.

✅ Estandarización: tiene especificaciones rígidas (XML, WSDL, WS-Security).

✅ Mensajería segura y confiable: gracias a WS-* (WS-Security, WS-ReliableMessaging...).

✅ Mensajería asincrónica (incluso sobre SMTP o JMS)

## ¿Cómo lo resuelve?
SOAP utiliza:

📦 XML para estructurar los datos.

🔐 WS- estándares* para manejar seguridad, transacciones, fiabilidad.

🌍 WSDL para publicar y consumir servicios:

Describe las operaciones disponibles.

Define los tipos de datos esperados.

📡 Protocolos de transporte como:

HTTP / HTTPS (más común).

SMTP.

TCP.

JMS (Java Messaging Service).

## Ejemplo de mensaje SOAP (Petición)
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <getProductDetails xmlns="http://ejemplo.com/tienda">
      <productId>12345</productId>
    </getProductDetails>
  </soap:Body>
</soap:Envelope>
```

## WSDL: Web Services Description Language
SOAP se apoya mucho en WSDL para definir:

Elemento	Rol
types	Define los tipos de datos que usa el servicio.
message	Define los mensajes que se envían o reciben.
portType	Agrupa operaciones relacionadas (como métodos de una clase).
binding	Define el protocolo y formato usado (HTTP, SOAP 1.1, etc.).
service	Define la dirección donde está disponible el servicio.

Ejemplo: https://api.empresa.com/ws/servicio?wsdl

## SOAP vs REST (comparativa rápida)
Característica	SOAP	REST
Formato de datos	Solo XML	JSON, XML, YAML, etc.
Estándares	Estricto (WSDL, WS-Security, etc.)	Más flexible
Transmisión	HTTP, SMTP, etc.	Solo HTTP
Performance	Más pesado	Más rápido
Uso típico	Entornos empresariales, B2B	Web pública, microservicios
Seguridad	WS-Security	OAuth, HTTPS

## ¿Cuándo usar SOAP?
SOAP sigue siendo ideal para:

Servicios de banca, salud, seguros (altos requisitos de seguridad y confiabilidad).

Sistemas legados.

Ambientes enteramente controlados por la empresa.

Aplicaciones con transacciones complejas y requisitos de ACID.

## Ventajas y Desventajas
✅ Ventajas:
Muy estructurado.

Extensible.

Interoperable.

Seguro y confiable.

❌ Desventajas:
Verboso.

Complejo de implementar.

Menor rendimiento comparado con REST/JSON.

# Web Services Description Language.
Es un lenguaje basado en XML utilizado para describir servicios web: qué hacen, dónde están, cómo comunicarse con ellos, y qué formato tienen sus mensajes.

En resumen: WSDL es el contrato que define cómo un cliente puede consumir un servicio web SOAP.

## ¿Cuál es su estructura o componentes?
Un archivo WSDL describe un servicio web en varias partes:

￼
Componente	Propósito
Types	Define los tipos de datos usados (usualmente con XML Schema - XSD).
Messages	Define los mensajes que se intercambian (peticiones y respuestas).
PortType	Agrupa operaciones que el servicio ofrece (como una interfaz en programación).
Binding	Define los detalles del protocolo de comunicación (cómo se transmiten los mensajes, por ejemplo, SOAP sobre HTTP).
Service	Define la ubicación del servicio (URL del servidor, por ejemplo).

## Estructura general de un WSDL
```xml
<definitions>
    <types>...</types>
    <message name="RequestMessage">...</message>
    <message name="ResponseMessage">...</message>
    <portType name="ServiceInterface">
        <operation name="OperationName">...</operation>
    </portType>
    <binding name="BindingName" type="ServiceInterface">...</binding>
    <service name="ServiceName">
        <port binding="BindingName" location="http://example.com/endpoint"/>
    </service>
</definitions>
```
¿Qué resuelve?
Antes de WSDL (y SOAP), no había un estándar automático para:

Describir qué operaciones expone un servicio.

Especificar qué datos esperar y en qué formato.

Explicar cómo comunicarse (HTTP, SMTP, etc).

Generar automáticamente clientes o stubs para consumir servicios.

WSDL resuelve:

Descubrimiento automático de servicios.

Interoperabilidad entre sistemas (por ejemplo: un cliente Java y un servidor .NET).

Contratos fuertes entre cliente y servidor (tipado fuerte, como en Java).

## ¿Cómo lo resuelve?
✅ Formaliza la definición de un servicio en un formato estándar XML.
✅ Separa claramente los aspectos de qué hace un servicio (PortType) y cómo se comunica (Binding).
✅ Automatiza la generación de clientes y servidores a partir de WSDL usando herramientas como:

wsimport (Java)

svcutil (C# .NET)

Plugins en SoapUI, Postman, etc.

Ejemplo real: en Java con wsimport puedes generar las clases de cliente de un servicio SOAP con un solo comando apuntando al WSDL.

## Ejemplo sencillo
Servicio web: Conversor de temperatura.

Request: Celsius -> Fahrenheit

Response: Temperatura convertida

WSDL básico:
```xml
<definitions>
  <message name="CelsiusToFahrenheitRequest">
    <part name="celsius" type="xsd:float"/>
  </message>

  <message name="CelsiusToFahrenheitResponse">
    <part name="fahrenheit" type="xsd:float"/>
  </message>

  <portType name="TemperaturePortType">
    <operation name="CelsiusToFahrenheit">
      <input message="tns:CelsiusToFahrenheitRequest"/>
      <output message="tns:CelsiusToFahrenheitResponse"/>
    </operation>
  </portType>

  <binding name="TemperatureBinding" type="tns:TemperaturePortType">
    <soap:binding style="rpc" transport="http://schemas.xmlsoap.org/soap/http"/>
    <operation name="CelsiusToFahrenheit">...</operation>
  </binding>

  <service name="TemperatureService">
    <port binding="tns:TemperatureBinding" location="http://example.com/TemperatureService"/>
  </service>
</definitions>
```
## Ventajas de WSDL
Tipado fuerte y validación de mensajes.

Contratos claros entre cliente y servidor.

Soporte automático en herramientas de desarrollo.

Autodescubrimiento en arquitecturas de servicios (SOA).

⚡ Desventajas de WSDL
Verbosidad alta (mucha estructura XML).

Dificultad de mantenimiento en servicios grandes.

Limitado principalmente a SOAP (no se usa para RESTful APIs modernas).

Requiere que clientes/servidores entiendan SOAP y XML Schema.

## WSDL en el mundo moderno
Aunque hoy RESTful APIs con OpenAPI (Swagger) son más populares para nuevas aplicaciones, WSDL sigue muy presente en:

Integraciones empresariales (ERP, CRM, Banca).

Servicios gubernamentales.

Grandes corporaciones que mantienen arquitecturas SOA.

Si trabajas en sectores financieros, gubernamentales o de salud, WSDL y SOAP siguen siendo habilidades críticas.