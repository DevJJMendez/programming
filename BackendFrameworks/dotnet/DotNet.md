# .NET
Es una plataforma de desarrollo **open source**, creada por Microsoft, que permite construir y ejecutar aplicaciones de software para múltiples plataformas como **Windows, macOS, Linux, Android, iOS, Web, IoT** y más. Es una herramienta unificada que proporciona un entorno completo para escribir, compilar, ejecutar y gestionar aplicaciones.

**.NET** incluye:
* **El lenguaje**: Aunque soporta múltiples lenguajes como `C#`, `VB.NET`, y `F#`, **`C#`** es el más utilizado.

* **El runtime**: Common Language Runtime (CLR), que ejecuta el código.

* **La Base Class Library (BCL)**: Una colección de clases reutilizables para manejar tareas comunes (manejo de archivos, seguridad, criptografía, etc.).

* **Herramientas**: Como **Visual Studio/Visual Studio Code** para facilitar el desarrollo.

Desde **.NET Core**, evolucionó a **.NET 5**, **6** y posteriores, una versión unificada que combina características de las versiones anteriores y permite compatibilidad multiplataforma.

## ¿Para qué sirve?
**.NET** se utiliza para desarrollar diferentes tipos de aplicaciones, incluyendo:

* **Aplicaciones Web**: Usando frameworks como **ASP.NET Core**.

* **Aplicaciones de escritorio**: Con tecnologías como **Windows Forms**, **WPF** y **MAUI** (para aplicaciones multiplataforma).

* **APIs y Servicios REST**: Construcción de servicios escalables y backend para otras aplicaciones.

* **Aplicaciones móviles**: A través de **MAUI** o integrando **Xamarin**.

* **Microservicios**: Arquitecturas distribuidas que interactúan mediante **APIs**.

* **Aplicaciones en la nube**: Muy utilizado en **`Azure`**, aprovechando servicios como funciones **serverless** y **contenedores**.

* **Big Data e Inteligencia Artificial**: Usando bibliotecas como **ML.NET**.

* **IoT (Internet de las cosas)**: Con **.NET** para dispositivos integrados.

Es ideal tanto para pequeñas aplicaciones como para grandes sistemas empresariales.

## ¿Qué problemas resuelve?
.NET aborda varios problemas comunes en el desarrollo de software:

* **Interoperabilidad entre lenguajes**: Permite usar múltiples lenguajes en un solo ecosistema (C#, F#, VB.NET) y compartir datos entre ellos sin problemas.

* **Multiplataforma**: Gracias a .NET Core/.NET 5+, las aplicaciones desarrolladas pueden ejecutarse en Windows, macOS y Linux sin necesidad de reescribir el código.

* **Desarrollo eficiente**:
  * Reduce la cantidad de código requerido gracias a la Base Class Library (BCL).
  * Proporciona herramientas potentes como Visual Studio y Visual Studio Code.

* **Escalabilidad y rendimiento**:
  * Es ideal para aplicaciones que necesitan manejar grandes volúmenes de tráfico y datos (por ejemplo, APIs y servicios en la nube).
  * Está optimizado para un alto rendimiento con bibliotecas modernas y un garbage collector eficiente.

* **Seguridad integrada**:
  * Proporciona cifrado, manejo de autenticación y autorización, y buenas prácticas para el desarrollo seguro.

* **Flexibilidad para arquitecturas modernas**:
  * Es compatible con microservicios y contenedores como Docker.
  * Proporciona soporte integrado para la inyección de dependencias, patrones de diseño y modularidad.

* **Mantenimiento y actualización**:
  * Es una plataforma madura con un ecosistema fuerte y constante evolución (actualizaciones frecuentes).
  * Mantiene la compatibilidad con versiones anteriores (al menos en gran medida).

## ¿Cómo lo resuelve?
.NET utiliza diferentes componentes clave para resolver estos problemas:

1. **Common Language Runtime (CLR)**:
   * Proporciona ejecución gestionada del código.
   * Garantiza que el código sea seguro (type-safe) y eficiente en el uso de memoria gracias al garbage collector.

2. **Base Class Library (BCL)**:
   * Reduce la complejidad del desarrollo con librerías predefinidas para tareas comunes: manejo de archivos, conectividad a bases de datos, encriptación, etc.

3. **Multiplataforma con .NET Core/.NET 5+**:
   * Permite escribir una vez y ejecutar en cualquier lugar.
   * Compatible con tecnologías modernas como Docker y Kubernetes.

4. **Soporte para arquitecturas modernas**:
   * Inyección de dependencias: Ayuda a desacoplar componentes.
   * Programación asíncrona: Hace que las aplicaciones sean no bloqueantes, mejorando la experiencia del usuario.

5. **Interoperabilidad**: Permite la integración con tecnologías nativas de cada sistema operativo y otras plataformas.

6. **Frameworks especializados**:
  * ASP.NET Core: Para aplicaciones web y APIs.
  * Entity Framework Core: Simplifica el manejo de bases de datos con programación orientada a objetos (ORM).
  * ML.NET: Para aplicaciones de machine learning.

7. **Ecosistema de herramientas**:
  * Visual Studio: Un IDE poderoso con soporte para debugging, pruebas unitarias, integración continua y más.
  * CLI de .NET: Herramientas de línea de comandos para la creación, construcción y despliegue de aplicaciones.

---
[](EvolutionCycle.md)
[](CommonLanguageRuntime.md)
[](CommonIntermediateLanguage.md)
[](JustInTime.md)
[](GargageCollector.md)
[](CommonTypeSystem.md)
[](SoftwareDevelopmentKit.md)

[](DotNetFramework.md)
[](DotNetCore.md)