### Modelos de Despliegue

En AWS y en el entorno de cloud computing en general, los modelos de despliegue se refieren a las distintas formas en que las aplicaciones y servicios se pueden implementar y gestionar. Los principales modelos de despliegue incluyen la nube pública, la nube privada, la nube híbrida y el edge computing. Cada uno de estos modelos tiene sus propias características, beneficios y casos de uso específicos.

### On-Premises o Privada

En el modelo de nube privada, los recursos informáticos son utilizados exclusivamente por una sola organización. Una nube privada puede estar alojada en el centro de datos de la organización o en un proveedor externo. Este modelo ofrece mayor control, seguridad y personalización.

- **Características**
  * Recursos dedicados a una sola organización.
  * Alto grado de control y personalización.
  * Puede estar alojada on-premises o en un centro de datos externo.
- **Beneficios**
  * Mayor seguridad y cumplimiento regulatorio.
  * Control total sobre la infraestructura.
  * Mejor rendimiento para aplicaciones críticas.
- **Casos de Uso**
  * Organizaciones con estrictos requisitos de seguridad y cumplimiento.
  * Aplicaciones de misión crítica.
  * Entornos de desarrollo y prueba internos.
  
### Cloud o Pública

En el modelo de nube pública, los recursos informáticos como servidores, almacenamiento y aplicaciones son propiedad y están operados por un proveedor de servicios en la nube, como AWS, y se comparten con múltiples clientes a través de Internet. Los servicios de nube pública proporcionan una alta escalabilidad, flexibilidad y un modelo de pago por uso.

- **Características**:
  * Recursos compartidos entre múltiples organizaciones.
  * Escalabilidad y elasticidad casi ilimitadas.
  * Modelo de pago por uso.
  * Administración y mantenimiento a cargo del proveedor del servicio.
- **Beneficios**:
  * Reducción de costos operativos y de capital.
  * Implementación rápida de nuevos servicios.
  * Alta disponibilidad y recuperación ante desastres.
- **Casos de Uso**:
  * Aplicaciones web y móviles.
  * Almacenamiento y respaldo de datos.
  * Análisis de Big Data.
  * Desarrollo y pruebas de software.


### Hibrido

El modelo de nube híbrida combina la infraestructura de nube pública y privada, permitiendo que los datos y aplicaciones se compartan entre ellas. Esto ofrece la flexibilidad de usar la nube pública para cargas de trabajo no críticas y la nube privada para aplicaciones sensibles.

- **Características**
  * Combina recursos de nube pública y privada.
  * Permite la portabilidad de datos y aplicaciones entre diferentes entornos.
- **Beneficios**
  * Optimización de costos y recursos.
  * Flexibilidad para escalar según las necesidades.
  * Mejora de la continuidad del negocio y la recuperación ante desastres.
- **Casos de Uso**:
  * Migración gradual de aplicaciones y datos a la nube.
  * Gestión de picos de demanda temporales.
  * Integración de aplicaciones locales y basadas en la nube.

### Edge Computing

El edge computing lleva los recursos de computación y almacenamiento más cerca de donde se generan los datos, minimizando la latencia y mejorando el rendimiento. Este modelo es ideal para aplicaciones que requieren procesamiento en tiempo real y ancho de banda limitado.

- **Características**
  * Computación y almacenamiento ubicados cerca de los dispositivos y usuarios finales.
  * Reducción de la latencia y mayor velocidad de procesamiento.
- **Beneficios**
  * Mejora del rendimiento para aplicaciones críticas en tiempo real.
  * Reducción del ancho de banda y costos de transmisión de datos.
  * Mayor seguridad al procesar datos localmente.
- **Casos de Uso**:
  * Internet de las cosas (IoT).
  * Aplicaciones de realidad aumentada y virtual.
  * Análisis de datos en tiempo real.

### Servicios de AWS para Modelos de Despliegue

- **AWS Outposts**: Proporciona servicios de AWS, infraestructura y modelos operativos en sus instalaciones, extendiendo la nube pública a un entorno on-premises para crear una nube híbrida.

- **AWS Wavelength**: Integra los servicios de AWS en el borde de las redes 5G para minimizar la latencia y habilitar aplicaciones de baja latencia.

- **Amazon VPC (Virtual Private Cloud)**: Permite crear una red privada virtual en la nube de AWS, ofreciendo control sobre el entorno de red, incluidos la selección de la IP, las subredes y las configuraciones de seguridad.

- **AWS Direct Connect**: Establece una conexión de red dedicada entre las instalaciones locales y AWS, mejorando la seguridad y el rendimiento para aplicaciones de nube híbrida.

### Estrategias de Implementación

1. **Lift and Shift**: Migrar aplicaciones existentes a la nube con poca o ninguna modificación.
2. **Refactorización**: Modificar significativamente la arquitectura de la aplicación para aprovechar al máximo los servicios nativos de la nube.
2. **Replataformización**: Hacer algunas optimizaciones sin cambiar la arquitectura principal de la aplicación.
4. **Modernización**: Adoptar nuevas tecnologías y arquitecturas como microservicios, contenedores y serverless para aplicaciones nuevas o existentes.


# 7 AWS Regions & Zonas de disponibilidad - Alta Disponibilidad ¿como funciona?

- Disaster Recovery
- Low Latency For End Users
- Data Sovereingnty
 
# Arquitectura Multi Region

# 8 - Formas de Interactuar con AWS: AWS Managent Console, AWS CLI (Comand Line Interface), AWS SDK

# 9 Manejo de los Servicios de AWS 