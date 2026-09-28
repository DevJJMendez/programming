## EC2 Auto Scaling
EC2 Auto Scaling es un servicio de Amazon Web Services (AWS) que permite ajustar automáticamente el número de instancias EC2 (Amazon Elastic Compute Cloud) en función de las necesidades actuales de la aplicación. Esto garantiza que se tenga el número correcto de instancias EC2 para manejar la carga de trabajo, mejorando la eficiencia y reduciendo costos.

### Características Principales de EC2 Auto Scaling:
1. **Escalabilidad Automática**:

   * EC2 Auto Scaling ajusta automáticamente la cantidad de instancias EC2 en función de la demanda real. Esto significa que puedes aumentar el número de instancias cuando la demanda es alta y reducirlo cuando la demanda disminuye, lo que optimiza el uso de recursos y costos.

2. **Alta Disponibilidad**:

   * EC2 Auto Scaling garantiza que siempre haya un número mínimo de instancias en ejecución para cumplir con los requisitos de la aplicación. En caso de fallos en una instancia, Auto Scaling puede lanzar una nueva para reemplazar la instancia fallida, asegurando así la alta disponibilidad de la aplicación.

3. **Balanceo de Carga Dinámico**:

   * Cuando se utiliza en combinación con **Elastic Load Balancing (ELB)**, EC2 Auto Scaling distribuye el tráfico de manera equilibrada entre las instancias, asegurando que ninguna instancia esté sobrecargada.

4. **Estrategias de Escalado**:

   * **Escalado Basado en la Demanda**: Permite escalar las instancias en función de métricas específicas como el uso de CPU, memoria, tráfico de red, etc.

   * **Escalado Programado**: Permite escalar el número de instancias en momentos específicos del día o de la semana, lo cual es útil si conoces de antemano cuándo aumentará o disminuirá la carga de trabajo.

   * **Escalado Predictivo**: Utiliza aprendizaje automático para predecir patrones de tráfico y ajusta el tamaño del grupo de instancias antes de que ocurra el cambio en la carga de trabajo.

5. **Configuraciones de Auto Scaling**:

   * **Launch Configuration / Launch Templates**: Especifican la configuración de las instancias que Auto Scaling lanzará. Esto incluye detalles como el tipo de instancia, la Amazon Machine Image (AMI), los Security Groups, los volúmenes de almacenamiento, etc.

   * **Auto Scaling Groups**: Define un grupo de instancias EC2 que se gestionan conjuntamente, especificando el número mínimo, máximo y deseado de instancias.

6. **Optimización de Costos**:

   * Al permitir que la infraestructura se ajuste automáticamente a la carga, EC2 Auto Scaling ayuda a evitar tanto el aprovisionamiento excesivo (y los costos asociados) como la falta de recursos (que podría afectar el rendimiento).

### Ejemplo Práctico:
Imagina que gestionas una aplicación de comercio electrónico que experimenta picos de tráfico durante eventos especiales, como el Black Friday. Con EC2 Auto Scaling, puedes configurar tu aplicación para que aumente automáticamente el número de instancias durante estos picos de tráfico. Después del evento, cuando el tráfico disminuye, Auto Scaling reduce el número de instancias para ahorrar costos.

### Componentes Clave de EC2 Auto Scaling:
1. **Auto Scaling Group (ASG)**:

   * Define el conjunto de instancias que EC2 Auto Scaling administra. Incluye configuraciones como el número mínimo, máximo y deseado de instancias, así como las políticas de escalado.

2. **Launch Configuration / Launch Template**:

   * Define la plantilla con la configuración de las instancias que se lanzarán. Esto incluye la AMI, tipo de instancia, volúmenes de almacenamiento, y más. Los Launch Templates son una versión mejorada de los Launch Configurations, con más flexibilidad y opciones.

3. **Scaling Policies**:

   * Las políticas de escalado determinan cómo y cuándo EC2 Auto Scaling debe ajustar el número de instancias. Pueden basarse en reglas específicas, como el promedio de CPU en todas las instancias, o en horarios predefinidos.

4. **CloudWatch Alarms**:

   * AWS CloudWatch se utiliza para monitorizar métricas y crear alarmas que activen políticas de escalado. Por ejemplo, puedes crear una alarma para que se dispare cuando el uso promedio de CPU supere un cierto umbral, desencadenando un aumento en el número de instancias.

### Escenarios Comunes de Uso:
1. **Aplicaciones Web Dinámicas**: Auto Scaling es ideal para aplicaciones que tienen variabilidad en el tráfico web, permitiendo un ajuste dinámico en tiempo real.

2. **Procesamiento por Lotes**: En aplicaciones que realizan procesamiento por lotes de datos (como procesamiento de videos o análisis de datos), Auto Scaling puede lanzar instancias adicionales durante los picos de procesamiento.

3. **Recuperación de Desastres**: Si una región de AWS experimenta una interrupción, EC2 Auto Scaling puede lanzar instancias en otra región, asegurando la continuidad del servicio.

### Consideraciones de Uso:
* **Diseño de Aplicación**: Para aprovechar al máximo Auto Scaling, tu aplicación debe ser capaz de escalar horizontalmente, es decir, agregar más instancias debe ser una solución viable para manejar mayor carga.

* **Tiempo de Arranque de Instancias**: Dependiendo del tipo de instancia y la configuración de la AMI, el tiempo que tarda en arrancar una nueva instancia puede variar. Es importante considerar esto al definir las políticas de escalado.

* **Costos**: Si bien Auto Scaling optimiza el uso de recursos, debes monitorear cuidadosamente las métricas y las políticas de escalado para evitar costos inesperados debido a un aumento en el número de instancias.

## Auto Scaling Group
Un Auto Scaling Group (ASG) en AWS es un conjunto de instancias de Amazon EC2 que se gestionan automáticamente para mantener la disponibilidad y escalabilidad de una aplicación. Los Auto Scaling Groups se encargan de lanzar o terminar instancias EC2 en función de las políticas de escalado definidas por el usuario, permitiendo ajustar dinámicamente la capacidad de cómputo en respuesta a la demanda de la aplicación.

### Componentes Clave de un Auto Scaling Group
1. **Launch Configuration** o **Launch Template**:

   * Define la configuración de las instancias EC2 que se lanzarán dentro del Auto Scaling Group. Esto incluye detalles como la AMI (Amazon Machine Image), el tipo de instancia, los grupos de seguridad, y más.

2. **Capacity Settings**:

   * **Desired Capacity**: El número deseado de instancias EC2 que deben estar ejecutándose en el grupo. Es el número de instancias que se intenta mantener en funcionamiento.

   * **Minimum Capacity**: El número mínimo de instancias que deben estar ejecutándose en el grupo en todo momento.

   * **Maximum Capacity**: El número máximo de instancias que pueden estar ejecutándose en el grupo.

3. **Scaling Policies**:

   * **Target Tracking**: Escala automáticamente para mantener una métrica de destino, como el uso de CPU o el tráfico de red.

   * **Step Scaling**: Escala en pasos, añadiendo o eliminando un número específico de instancias en función de umbrales de alarmas de CloudWatch.

   * **Scheduled Scaling**: Escala automáticamente en base a un cronograma predefinido, como aumentar la capacidad durante las horas pico.

4. **Health Checks**:

   * **EC2 Health Check**: Verifica si las instancias EC2 están en buen estado. Si una instancia falla en una comprobación de salud, se terminará y se reemplazará por una nueva.

   * **ELB Health Check**: Si el ASG está asociado con un balanceador de carga (ELB), también puede realizar comprobaciones de salud a nivel de aplicación.

5. **Availability Zones**:

   * Un Auto Scaling Group puede abarcar múltiples zonas de disponibilidad dentro de una región para asegurar alta disponibilidad. Esto permite que las instancias se distribuyan entre diferentes zonas de disponibilidad, lo que mejora la resiliencia ante fallas.

6. **Load Balancing**:

   * Los Auto Scaling Groups a menudo se configuran para trabajar con balanceadores de carga (como ELB o ALB) para distribuir el tráfico entrante entre las instancias. Esto asegura que el tráfico se maneje de manera eficiente y que las instancias adicionales reciban tráfico automáticamente cuando son escaladas.

### Ventajas de Usar Auto Scaling Groups
1. **Escalabilidad Automática**:

   * Los Auto Scaling Groups ajustan automáticamente la capacidad de tu aplicación en función de la demanda. Esto significa que puedes manejar picos de tráfico sin intervención manual y reducir costos durante periodos de baja demanda.

2. **Alta Disponibilidad**:

   * Al distribuir instancias EC2 en múltiples zonas de disponibilidad, los ASG aseguran que tu aplicación siga funcionando incluso si una zona de disponibilidad falla.

3. **Gestión de Costos**:

   * Los ASG permiten optimizar los costos al escalar instancias según sea necesario, evitando tener recursos infrautilizados.

4. **Resiliencia Mejorada**:

   * Si una instancia EC2 falla, el Auto Scaling Group la reemplazará automáticamente con una nueva, mejorando la resiliencia de la aplicación.

5. **Optimización del Rendimiento**:

   * Los ASG pueden monitorear métricas de rendimiento como el uso de CPU o la latencia, y ajustar la capacidad para asegurar que la aplicación mantenga un rendimiento óptimo.

### Configuración Básica de un Auto Scaling Group
1. **Crear un Launch Configuration o Launch Template**:

   * Define todos los parámetros necesarios para lanzar instancias EC2. Esto incluye la AMI, el tipo de instancia, grupos de seguridad, etc.

2. **Definir las Políticas de Escalado**:

   * Especifica cuándo y cómo debe escalar el Auto Scaling Group. Esto puede basarse en el uso de CPU, tráfico de red, o incluso un cronograma específico.

3. **Seleccionar Zonas de Disponibilidad**:

   * Especifica en qué zonas de disponibilidad dentro de la región AWS deseas lanzar las instancias EC2.

4. **Configurar Health Checks**:

   * Decide cómo se determinará si una instancia está sana y debe seguir en funcionamiento o si debe ser reemplazada.

5. **Configurar el Balanceo de Carga**:

   * Si estás utilizando un balanceador de carga, asócialo con el Auto Scaling Group para distribuir el tráfico entrante de manera equitativa entre las instancias.

## Scale the size of your Auto Scaling Group
"Scale the size of your Auto Scaling Group" se refiere al proceso de ajustar el número de instancias EC2 dentro de un Auto Scaling Group (ASG) en AWS. Este ajuste puede ser en términos de escalar hacia arriba (aumentar el número de instancias) o escalar hacia abajo (reducir el número de instancias) en función de las necesidades de la aplicación.

### Tipos de Escalamiento en Auto Scaling Groups
1. **Manual Scaling**:

   * Este tipo de escalado implica que un administrador ajusta manualmente el tamaño del Auto Scaling Group. Esto se hace a través de la consola de AWS, la CLI, o usando las APIs de AWS para modificar la capacidad deseada del grupo.

2. **Dynamic Scaling**:

   * **Target Tracking Scaling**: Escala automáticamente el **ASG** para mantener una métrica de destino, como el uso de CPU o la latencia promedio. Por ejemplo, si configuras un Target Tracking Policy para mantener el uso de CPU en el 50%, el **ASG** ajustará el número de instancias para cumplir con este objetivo.

   * **Step Scaling**: Escala en pasos predefinidos basados en umbrales de alarmas. Por ejemplo, podrías configurar una política que agregue dos instancias si el uso de CPU supera el 70% durante más de 5 minutos, y que retire una instancia si el uso de CPU cae por debajo del 40%.

   * **Scheduled Scaling**: Permite escalar el grupo según un cronograma definido. Por ejemplo, podrías programar que el **ASG** aumente el número de instancias durante las horas pico de tráfico y lo reduzca durante las horas de baja actividad.

3. **Predictive Scaling**:

   * Utiliza machine learning para predecir las demandas futuras de tu aplicación y escalar proactivamente el tamaño del Auto Scaling Group antes de que se produzcan picos de tráfico. Esto es útil para aplicaciones con patrones de tráfico predecibles, como una tienda en línea que ve un aumento en el tráfico cada viernes por la noche.

### ¿Cómo Escalar el Tamaño de un Auto Scaling Group?
1. **Manual Scaling**

   * Puedes ajustar el número deseado de instancias directamente desde la consola de AWS o mediante la CLI.

   * Ejemplo en la CLI
   ```bash
   aws autoscaling set-desired-capacity --auto-scaling-group-name my-asg --desired-capacity 5
   ```
   Aquí, `my-asg` es el nombre de tu Auto Scaling Group, y 5 es el nuevo tamaño deseado del grupo.

1. **Configuración de Target Tracking Scaling**
   * En la consola de AWS, puedes crear una política de escalado de Target Tracking.

   * Especifica la métrica que deseas monitorear (por ejemplo, uso de CPU) y el valor objetivo (por ejemplo, 50% de uso de CPU).

   * El Auto Scaling Group se ajustará automáticamente para mantener esa métrica cerca del objetivo.

2. **Configuración de Step Scaling**
   * Define múltiples umbrales y las acciones asociadas para cada uno.

   * Por ejemplo:
     * Si el uso de CPU supera el 75%, agrega 2 instancias.

     * Si el uso de CPU cae por debajo del 30%, elimina 1 instancia.

3. **Configuración de Scheduled Scaling**
   * Establece un cronograma para aumentar o reducir el tamaño del grupo.

   * Por ejemplo, escala hacia arriba durante las horas de oficina (9 AM a 5 PM) y escala hacia abajo durante la noche.

### Ventajas del Escalado en Auto Scaling Groups
1. **Optimización de Costos**:

   * Solo pagas por los recursos que realmente necesitas en cualquier momento, lo que ayuda a reducir costos innecesarios.

2. **Mejora en la Disponibilidad**:

   * Al escalar hacia arriba durante los picos de demanda, aseguras que tu aplicación sigue siendo accesible y rápida para los usuarios.

3. **Resiliencia Automática**:

   * Si una instancia falla, el Auto Scaling Group puede reemplazarla automáticamente, mejorando la resiliencia general de la aplicación.

4. **Respuesta Dinámica**:

   * Tu infraestructura puede responder automáticamente a cambios repentinos en la carga, sin necesidad de intervención manual.

### Consideraciones al Escalar un Auto Scaling Group
* **Métricas Adecuadas**: Asegúrate de seleccionar las métricas correctas para tus políticas de escalado. Métricas como el uso de CPU, el tráfico de red o la latencia son comunes, pero pueden variar según la aplicación.

* **Tiempos de Arranque**: Considera el tiempo que tarda en arrancar una nueva instancia EC2 cuando configures políticas de escalado. Esto puede afectar la velocidad a la que puedes responder a aumentos repentinos de demanda.

* **Ciclos de Escalado**: Evita los ciclos de escalado donde las instancias se inician y se terminan repetidamente en un corto período de tiempo. Esto puede aumentar los costos y reducir la eficiencia.