#frameworks
# .NET CORE
Es una plataforma de desarrollo de código abierto y multiplataforma diseñada por Microsoft. Es una versión modular y ligera de **.NET Framework**, creada para desarrollar aplicaciones modernas, portables y de alto rendimiento que puedan ejecutarse en **Windows**, **Linux**, **macOS** y otros sistemas operativos.

Fue lanzado como una alternativa más flexible y eficiente que el **.NET Framework** tradicional. Desde **.NET 5**, Microsoft unificó **.NET Framework** y **.NET Core** en una única plataforma llamada **.NET 5+**, pero el término **.NET Core** todavía se utiliza para referirse a las versiones previas y los conceptos centrales.

## ¿Para qué sirve?
.NET Core se utiliza para desarrollar una amplia variedad de aplicaciones modernas y escalables:

* **Aplicaciones Web y APIs REST**: Con ASP.NET Core, puedes construir sitios web dinámicos, APIs RESTful y aplicaciones en tiempo real (usando SignalR).

* **Aplicaciones de consola**: Perfecto para herramientas CLI, servicios de backend y scripts que necesiten ejecutarse en diferentes sistemas operativos.

* **Aplicaciones de escritorio multiplataforma**: Usando MAUI o WinForms/WPF (en Windows), puedes crear interfaces gráficas.

* **Microservicios**: Ideal para arquitecturas basadas en microservicios gracias a su capacidad para ser ejecutado en contenedores Docker.

* **Aplicaciones en la nube**: Totalmente compatible con los principales proveedores de nube, como Microsoft Azure, AWS y Google Cloud.

* **Aplicaciones IoT**: Compatible con dispositivos integrados y escenarios de Internet de las Cosas (IoT).

* **Big Data e Inteligencia Artificial**: Con bibliotecas como ML.NET, puedes construir modelos de aprendizaje automático.

## ¿Qué problemas resuelve?
.NET Core fue diseñado para resolver varias limitaciones del .NET Framework tradicional:

* **Multiplataforma**: A diferencia de .NET Framework, que solo funciona en Windows, .NET Core permite ejecutar aplicaciones en Windows, macOS y Linux, facilitando el desarrollo y despliegue en diversos entornos.

* **Rendimiento y escalabilidad**: Es más ligero y rápido que .NET Framework, ofreciendo un rendimiento competitivo para aplicaciones de alto tráfico, como APIs y servicios en la nube.

* **Flexibilidad y modularidad**: Utiliza un modelo de paquetes basado en NuGet, lo que significa que solo cargas las librerías necesarias, reduciendo el tamaño de las aplicaciones.

* **Despliegue independiente del sistema**: Soporta Self-contained deployments: puedes distribuir tu aplicación con todas las dependencias incluidas, sin necesidad de instalar .NET Core en el sistema operativo de destino.

* **Compatibilidad con contenedores y DevOps**: Está optimizado para ejecutarse en Docker y para integrarse con flujos de trabajo de integración y despliegue continuo (CI/CD).

* **Ecosistema Open Source**: Al ser código abierto, tiene una comunidad activa que mejora continuamente la plataforma, asegurando su evolución y sostenibilidad.
Soporte para arquitecturas modernas: Diseñado para trabajar con arquitecturas basadas en microservicios, eventos, programación reactiva y otras tendencias actuales.

## ¿Cómo lo resuelve?
.NET Core resuelve estos problemas utilizando varias características clave:

1. **Multiplataforma**: Las aplicaciones escritas en .NET Core pueden ejecutarse en cualquier sistema operativo compatible sin necesidad de cambios en el código. Esto se logra mediante un runtime (CoreCLR) optimizado para cada plataforma.

2. **Rendimiento optimizado**:
   * El runtime utiliza una técnica de compilación Just-In-Time (JIT) y Ahead-of-Time (AOT) que mejora la velocidad de ejecución.
   * Incluye un garbage collector eficiente para la gestión de memoria.

3. **Modularidad**: Las aplicaciones .NET Core usan un modelo de paquetes de NuGet para incluir solo las dependencias necesarias, minimizando el tamaño del archivo final.

4. **Despliegue independiente**: Puedes optar por un despliegue Self-contained, lo que significa que la aplicación se distribuye con todas sus dependencias (incluido el runtime), eliminando problemas de compatibilidad en el sistema operativo de destino.

5. **Compatibilidad con contenedores**: Ofrece imágenes oficiales de Docker para crear y ejecutar aplicaciones en contenedores de manera eficiente, lo que lo hace ideal para arquitecturas de microservicios.

6. **Ecosistema y herramientas**:
   * **Visual Studio y CLI**: Herramientas como Visual Studio y el CLI de .NET facilitan el desarrollo y la gestión de proyectos.
   
   * **ASP.NET Core**: Framework para construir aplicaciones web modernas y servicios RESTful.
   
   * **Entity Framework Core**: Un ORM (Object Relational Mapper) que facilita el acceso a bases de datos.