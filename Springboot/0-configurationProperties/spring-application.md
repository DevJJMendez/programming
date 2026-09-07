# `spring.application`
La configuración de spring.application en Spring Boot permite controlar diversos aspectos de la aplicación en su totalidad. Este conjunto de configuraciones es fundamental para definir cómo la aplicación se identifica, carga, y administra en el entorno de ejecución, permitiendo personalizar detalles importantes, como el nombre de la aplicación, su perfil activo, y su comportamiento general.

## Configuraciones Principales de spring.application
1. spring.application.name
   * ¿Qué es? Define el nombre de la aplicación, útil para identificarla en entornos distribuidos o en sistemas de monitoreo, registros, y mensajería.

   * ¿Para qué sirve? Se utiliza principalmente para asignar un nombre identificador a la aplicación, lo cual es especialmente útil en aplicaciones con múltiples instancias o microservicios.
```properties
spring.application.name=mi-aplicacion
```

2. `spring.application.instance-id`
   * ¿Qué es? Especifica un identificador único para cada instancia de la aplicación.
   
   * ¿Para qué sirve? Es útil en entornos de microservicios donde múltiples instancias de la misma aplicación están en ejecución, ayudando a diferenciar una instancia de otra.
```properties
spring.application.instance-id=instance-01
```

3. `spring.application.admin.enabled`
   * ¿Qué es? Habilita o deshabilita la capacidad de administrar la aplicación mediante JMX (Java Management Extensions).

   * ¿Para qué sirve? Cuando está habilitado (true), permite a los administradores monitorear y gestionar la aplicación en tiempo real.
```properties
spring.application.admin.enabled=true
```

4. `spring.application.admin.jmx-name`
   * ¿Qué es? Define el nombre JMX con el cual la aplicación estará registrada cuando spring.application.admin.enabled esté activo.

   * ¿Para qué sirve? Especifica un identificador JMX para monitorear la aplicación a través de herramientas de administración como JConsole o VisualVM.
```properties
spring.application.admin.jmx-name=com.example.miapp:type=Admin
```

5. `spring.application.index`
   * ¿Qué es? Define un índice numérico único para la aplicación en entornos con varias instancias.

   * ¿Para qué sirve? Es útil para diferenciar instancias cuando se ejecutan en un clúster o múltiples contenedores.
```properties
spring.application.index=1
```

6. `spring.application.lazy-initialization`
   * ¿Qué es? Configura la inicialización perezosa (lazy initialization) para los beans en Spring Boot.

   * ¿Para qué sirve? Habilitar la inicialización perezosa (true) puede mejorar el tiempo de arranque de la aplicación al cargar los beans solo cuando se necesitan.
```properties
spring.application.lazy-initialization=true
```

## Configuraciones Relacionadas con Perfiles y Entornos
1. `spring.profiles.active`
   * ¿Qué es? Permite especificar el perfil o perfiles activos de la aplicación.

   * ¿Para qué sirve? Ayuda a gestionar la configuración para diferentes entornos, como dev, test, y prod.
```properties
spring.profiles.active=dev
```

2. `spring.profiles.include`
   * ¿Qué es? Incluye perfiles adicionales que deben cargarse junto con el perfil activo.

   * ¿Para qué sirve? Permite cargar múltiples perfiles al mismo tiempo, ideal para combinaciones específicas de entornos.
```properties
spring.profiles.include=qa,common
```

## Configuración de Inicio y Orden de Carga
* `spring.main.banner-mode`
  * ¿Qué es? Controla la visualización del banner de arranque de Spring Boot.
  
  * Valores posibles:
    * `console`: Muestra el banner en la consola.
    
    * `log`: Muestra el banner en los registros.

    * `off`: Desactiva el banner.

* `spring.main.web-application-type`
  * ¿Qué es? Define el tipo de aplicación web que se está ejecutando.

  * Valores posibles:
    * `servlet`: Indica que es una aplicación web estándar.

    * `reactive`: Especifica que es una aplicación reactiva.

    * `none`: No es una aplicación web.

* `spring.main.allow-bean-definition-overriding`
  * ¿Qué es? Permite la sobreescritura de definiciones de beans en el contexto de Spring.

  * ¿Para qué sirve? Útil en entornos de desarrollo y prueba donde se necesita redefinir beans.
```properties
spring.main.allow-bean-definition-overriding=true
```

* `spring.main.sources`
  * ¿Qué es? Especifica las clases de configuración que deben inicializarse al arrancar la aplicación.

  * ¿Para qué sirve? Permite definir la configuración de arranque de la aplicación.
```properties
spring.main.sources=com.example.MyConfig
```

## Configuración para el Monitoreo y la Administración
* `spring.main.log-startup-info`
  * ¿Qué es? Controla si se debe registrar información de inicio detallada.

  * ¿Para qué sirve? Es útil para depuración, ya que registra el tiempo de inicialización de cada bean.
```properties
spring.main.log-startup-info=true
```

# Resumen Completo de Configuraciones
```properties
# Identidad y administración de la aplicación
spring.application.name=mi-aplicacion
spring.application.instance-id=instancia-01
spring.application.admin.enabled=true
spring.application.admin.jmx-name=com.example.miapp:type=Admin
spring.application.index=1
spring.application.lazy-initialization=true

# Configuración de perfiles
spring.profiles.active=prod
spring.profiles.include=qa,common

# Configuración de inicio y tipo de aplicación
spring.main.banner-mode=log
spring.main.web-application-type=servlet
spring.main.lazy-initialization=true
spring.main.allow-bean-definition-overriding=true
spring.main.sources=com.example.config.MyConfig
spring.main.log-startup-info=true
```