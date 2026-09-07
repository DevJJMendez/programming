
Garbage Collector

Hablemos de [Route("api/[controller]")]

¿que es?
¿para que sirve?
¿que parametros recibe?

Enseñame todo lo que debo saber 
¿que resuelve?
¿como lo resuelve?



¿que es?
Hablemos de los controladores

¿cual es su estructura?
¿configuraciónes?
¿buenas practicas?
Enseñame todo lo que debo saber 

¿para que sirve?
¿que resuelve?
¿como lo resuelve?


¿cuales son?
¿cuales son sus tipos?

Hablemos de los Delegates en C#

¿que son?
¿para que sirven?
¿que resuelven?
¿como lo resuelven?

Enseñame todo lo que debo saber

---
---
1. ASP.NET es la principal tecnología que ofrece .NET para desarrollar aplicaciones web. Tiene varias variantes para diferentes enfoques de desarrollo:

   * ASP.NET MVC (Model-View-Controller):
     * Para construir aplicaciones web basadas en patrones MVC.

     * Permite separar la lógica de negocio, la presentación y los datos.

     * Ideal para aplicaciones que requieren una fuerte separación de responsabilidades.

   * ASP.NET Web API:
     * Diseñado para construir servicios HTTP y RESTful.

     * Ideal para integrar con Angular en el frontend.

   * ASP.NET Web Forms:
     * Tecnología más antigua que utiliza un modelo de desarrollo orientado a eventos.

     * Menos relevante para aplicaciones modernas, pero todavía utilizado en proyectos heredados.

   * ASP.NET Core:
     * La evolución multiplataforma, más eficiente y moderna para desarrollar aplicaciones web.

     * Compatible con Windows, Linux y macOS.

     * Soporte nativo para aplicaciones RESTful, SPA (Single Page Applications, como Angular), y aplicaciones Razor Pages.

   * Blazor:
     * Un framework moderno de .NET para construir aplicaciones web interactivas utilizando C# en lugar de JavaScript.

     * Opciones:
       * Blazor Server: Ejecuta la lógica en el servidor.

       * Blazor WebAssembly: Ejecuta la lógica en el navegador, similar a Angular.


2. Servicios clave para aplicaciones web en .NET
   * SignalR:
     * Permite implementar comunicación en tiempo real (WebSockets).

     * Ideal para aplicaciones como chats, actualizaciones en vivo, notificaciones en tiempo real.

   * gRPC:
     * Un framework moderno para comunicación eficiente entre servicios.

     * Alternativa ligera a REST para microservicios.

     * Soporta streaming bidireccional.

   * Entity Framework Core:
     * ORM (Object Relational Mapping) para trabajar con bases de datos relacionales (como SQL Server).

     * Simplifica las operaciones CRUD y el modelado de datos.

   * Minimal APIs:
     * Introducido en versiones recientes de .NET.

     * Permite construir APIs HTTP rápidamente con menos configuración y código, ideal para servicios RESTful.

   * Identity Framework:
     * Un sistema completo para gestionar autenticación y autorización en aplicaciones web.

     * Soporte para cuentas locales, redes sociales y autenticación basada en tokens (JWT).

   * OWIN (Open Web Interface for .NET):
     * Permite construir middleware flexible y reutilizable en aplicaciones web.

## Evolución de .NET: .NET Framework vs .NET Core vs .NET unificado
1. .NET Framework
Lanzado en 2002, es la plataforma clásica para desarrollar aplicaciones Windows.
Soporta tecnologías como:
ASP.NET Web Forms.
WCF (Windows Communication Foundation).
ASP.NET MVC/Web API.
Limitaciones:
Solo funciona en Windows.
No se actualiza activamente para nuevos proyectos (mantiene soporte para proyectos existentes).
Uso recomendado:

Proyectos existentes en Windows que no requieran portabilidad.
2. .NET Core
Lanzado en 2016 como una reimplementación multiplataforma y modular de .NET Framework.
Características destacadas:
Compatible con Windows, Linux y macOS.
Soporte para contenedores Docker.
Mejor rendimiento y capacidad de alojamiento en la nube.
Ofrece:
ASP.NET Core.
EF Core.
Integración con Angular, React y Blazor.
Uso recomendado:

Nuevas aplicaciones web, especialmente si la portabilidad es clave.
3. .NET (Unificado)
Lanzado en 2020 (a partir de .NET 5) como la evolución de .NET Core.
Características:
Multiplataforma.
Unifica todas las tecnologías (web, escritorio, nube, IoT, IA).
Compatible con Angular y otros frameworks modernos.
Mejora en Minimal APIs, Blazor, y soporte para microservicios.
Mayor rendimiento en aplicaciones web y soporte nativo para la nube.
Uso recomendado:

Proyectos modernos de cualquier tipo, desde servicios pequeños hasta aplicaciones empresariales.


## Arquitectura de .NET

1. Common Language Runtime (CLR):
El CLR es el núcleo del entorno de ejecución de .NET. Proporciona los servicios que gestionan la ejecución del código, como la recolección de basura (garbage collection), manejo de excepciones y la seguridad. Cualquier código escrito en C# se compila en un lenguaje intermedio conocido como Common Intermediate Language (CIL), que luego es ejecutado por el CLR.

2. Common Type System (CTS):
El CTS define cómo se declaran, usan y gestionan los tipos en el entorno .NET. Permite que diferentes lenguajes (como C#, VB.NET y F#) compartan tipos y datos de manera eficiente, facilitando la interoperabilidad entre lenguajes.

3. Base Class Library (BCL):
La BCL es una colección de clases, interfaces y tipos que proporcionan funcionalidades esenciales como entrada/salida, manejo de archivos, colecciones y conectividad a bases de datos. Es una parte clave de la .NET Class Library, que C# utiliza extensamente para desarrollar aplicaciones robustas.

4. Common Language Infrastructure (CLI):
Especifica un entorno en el que el código escrito en cualquier lenguaje compatible con .NET puede ejecutarse. Es la base que garantiza que el código C# sea portado a diferentes plataformas (como Windows, macOS y Linux) con .NET Core y .NET 6+.

5. Arquitectura Modular y Multi-Plataforma:

.NET Core/.NET 5+: Ofrecen compatibilidad multiplataforma, lo que permite ejecutar aplicaciones en Windows, Linux, y macOS.

Microservicios: Con .NET Core/.NET 6+ puedes desarrollar aplicaciones que usen arquitecturas de microservicios para crear sistemas altamente escalables y desacoplados, distribuidos entre diferentes servicios.

Docker y Kubernetes: Se integran muy bien con .NET para facilitar el despliegue y la gestión de aplicaciones en contenedores, permitiendo escalabilidad horizontal.


Servicios clave para aplicaciones web en .NET

SignalR:

Permite implementar comunicación en tiempo real (WebSockets).

Ideal para aplicaciones como chats, actualizaciones en vivo, notificaciones en tiempo real.

gRPC:

Un framework moderno para comunicación eficiente entre servicios.

Alternativa ligera a REST para microservicios.

Soporta streaming bidireccional.

Entity Framework Core:

ORM (Object Relational Mapping) para trabajar con bases de datos relacionales (como SQL Server).

Simplifica las operaciones CRUD y el modelado de datos.

Minimal APIs:

Introducido en versiones recientes de .NET.

Permite construir APIs HTTP rápidamente con menos configuración y código, ideal para servicios RESTful.

Identity Framework:

Un sistema completo para gestionar autenticación y autorización en aplicaciones web.

Soporte para cuentas locales, redes sociales y autenticación basada en tokens (JWT).

OWIN (Open Web Interface for .NET):

Permite construir middleware flexible y reutilizable en aplicaciones web.