# Modelos de Red
Los Modelos de Red son esquemas teóricos o arquitecturas que describen cómo se comunican los dispositivos a través de una red. Su propósito es:

* Establecer estándares para que diferentes fabricantes y tecnologías puedan interoperar.
* Descomponer la comunicación en capas o niveles con responsabilidades bien definidas.
* Facilitar el diseño, desarrollo, troubleshooting y documentación de redes y aplicaciones distribuidas.

## ¿Cuáles son los principales Modelos de Red?
Existen 2 modelos fundamentales:

[OSI](OpenSystemInterconnection.md)
[TCP/IP](TransmissionControlProtocol)

## ¿Qué resuelven?
Ambos modelos resuelven problemas de interoperabilidad, estandarización y confiabilidad en las comunicaciones de red.

Resuelven:
* ¿Cómo se codifican, encapsulan y envían los datos
* ¿Cómo se asegura que los datos lleguen al destino correctamente
* ¿Cómo diferentes sistemas pueden hablar entre sí sin depender del fabricante
* ¿Cómo se puede dividir responsabilidad

## ¿Cómo lo resuelven?
### Dividiendo la comunicación en capas
Cada capa:
* Tiene una función específica
* Solo se comunica con la capa superior e inferior
* Usa protocolos específicos para cumplir su misión.
* Encapsula la información de la capa superior.
  * Encapsulación: Cuando una aplicación envía datos, estos se van envolviendo en "paquetes", "segmentos" o "tramas" según la capa.

### Desencapsulación
Cuando los datos llegan al receptor, se va haciendo el proceso inverso, quitando cada capa hasta que el mensaje llega a la aplicación.

## Ejemplo real de cómo se usan
Supón que estás en una aplicación web y haces una petición a:

```bash
https://openai.com/api
```
1. Capa de Aplicación: Usas HTTP sobre TLS para enviar un request.
2. Capa de Transporte: Se usa TCP para segmentar y controlar la conexión.
3. Capa de Red: Se agrega la IP de destino.
4. Capa de Enlace: Se envía sobre Ethernet o WiFi.
5. Capa Física: Bits viajan por cable de red o aire (WiFi).
6. En el servidor se desencapsula todo hasta que el backend recibe la solicitud.