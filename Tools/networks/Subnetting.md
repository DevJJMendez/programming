# Subnetting
Subnetting es el proceso de dividir una red IP grande en subredes más pequeñas, llamadas subnets. La principal razón para realizar el subnetting es mejorar la eficiencia y el uso de los recursos en una red, facilitando la administración de las direcciones IP y aumentando la seguridad al aislar ciertas partes de una red.

Cuando trabajas con una red IP, esta tiene un rango de direcciones IP que puedes asignar a dispositivos (como servidores, routers, estaciones de trabajo, etc.). Sin embargo, asignar todas esas direcciones en una única red podría generar problemas, como el desperdicio de direcciones IP o la saturación de la red con tráfico innecesario. El subnetting permite organizar mejor esos recursos dividiendo la red en segmentos más pequeños y más manejables.

## Conceptos Clave del Subnetting
Dirección IP: Una dirección IP es un identificador único que se asigna a cada dispositivo en una red. Las direcciones IP se dividen en clases (A, B, C) y cada clase tiene diferentes rangos de direcciones y tamaños de red. Las direcciones IP pueden ser públicas o privadas.

Máscara de Subred (Subnet Mask): La máscara de subred se utiliza para dividir una red IP en subredes más pequeñas. Indica qué parte de la dirección IP corresponde a la red y qué parte corresponde al host (dispositivo). Por ejemplo:

Máscara de subred estándar: 255.255.255.0, que se traduce en 24 bits dedicados a la red y 8 bits a los hosts.

Dirección de Red: Es la primera dirección de una subred y se utiliza para identificar la propia red. No se puede asignar a un dispositivo. Se obtiene con la AND lógica entre la dirección IP y la máscara de subred.

Dirección de Broadcast: Es la última dirección de una subred y se usa para enviar datos a todos los dispositivos dentro de esa subred. Esta dirección se obtiene con la AND lógica entre la dirección de la red y la inversa de la máscara de subred.

Rango de Hosts: Son las direcciones IP disponibles en una subred para asignar a los dispositivos. Este rango excluye la dirección de red y la dirección de broadcast.

## Cómo Funciona el Subnetting
Cuando haces subnetting, estás dividiendo el espacio de direcciones IP de una red en segmentos más pequeños para distribuirlas más eficientemente. Para lograr esto, tomas prestados bits de la parte de host de la dirección IP para crear subredes.

Ejemplo:
Imaginemos que tienes la red 192.168.1.0/24, lo que significa que hay 256 direcciones disponibles (desde 192.168.1.0 hasta 192.168.1.255), con una máscara de subred 255.255.255.0.

Si deseamos dividir esta red en dos subredes, hacemos lo siguiente:
Tomamos prestados 1 bit de la parte de host para crear subredes.

Esto nos deja con una máscara de subred de 255.255.255.128, lo que da como resultado dos subredes.

Las nuevas subredes serían:

Subred 1: 192.168.1.0/25 con direcciones de host de 192.168.1.1 a 192.168.1.126 y una dirección de broadcast de 192.168.1.127.

Subred 2: 192.168.1.128/25 con direcciones de host de 192.168.1.129 a 192.168.1.254 y una dirección de broadcast de 192.168.1.255.

Fórmula Básica para Subnetting:
Número de Subredes = 2𝑛 , donde n es el número de bits que tomamos prestados de la parte de host.

Número de Hosts por Subred = 2ℎ−2, donde h es el número de bits restantes en la parte de host (el 2 es por la dirección de red y la dirección de broadcast que no se pueden usar como direcciones de host).

## Ventajas del Subnetting
Optimización del uso de direcciones IP:

El subnetting permite utilizar de manera más eficiente las direcciones IP disponibles, evitando el desperdicio de direcciones.

Mejor organización de la red:

Al dividir una red grande en subredes más pequeñas, se facilita la administración y se mejora el rendimiento de la red.

Aislamiento y seguridad:

El subnetting ayuda a aislar diferentes partes de la red, lo que puede mejorar la seguridad y el control de acceso entre subredes.

Reducción de tráfico:

Las subredes limitan la cantidad de tráfico dentro de cada subred, ya que las comunicaciones dentro de una subred no requieren enviar tráfico a través de routers.

## Herramientas para Subnetting
Existen diversas herramientas que pueden facilitar el proceso de subnetting y ayudar a realizar los cálculos sin errores:

Calculadoras de Subnetting:

Herramientas en línea que permiten realizar los cálculos de subnetting, proporcionando rápidamente subredes, direcciones de red, direcciones de hosts y direcciones de broadcast.

Tablas de Subnetting:

Muchas veces se usan tablas que incluyen subredes comunes y su rango de direcciones.