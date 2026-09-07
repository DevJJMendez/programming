#frameworks
# .NET FRAMEWORK
Es una plataforma de desarrollo de software creada por Microsoft en el año 2002. Es un entorno de ejecución para crear, ejecutar y gestionar aplicaciones en Windows.

.NET Framework incluye:

* **Common Language Runtime (CLR)**: El motor que ejecuta aplicaciones .NET y se encarga de tareas como la gestión de memoria, manejo de excepciones y ejecución de código.

* **Framework Class Library (FCL)**: Una colección extensa de bibliotecas que proporciona funcionalidades reutilizables para tareas comunes (por ejemplo, acceso a bases de datos, manipulación de archivos, servicios web, etc.).

**Aunque sigue siendo ampliamente utilizado, el .NET Framework ha sido sustituido en muchos casos por .NET Core y versiones posteriores (.NET 5, .NET 6, etc.) debido a su limitación de operar únicamente en Windows.**

## ¿Para qué sirve?
.NET Framework permite a los desarrolladores crear una amplia variedad de aplicaciones para Windows, incluyendo:

* **Aplicaciones de escritorio**: Windows Forms (WinForms) y Windows Presentation Foundation (WPF) para crear interfaces gráficas de usuario (GUIs).

* **Aplicaciones web**: Usando ASP.NET para construir sitios web dinámicos y servicios web.

* **Servicios Windows**: Aplicaciones en segundo plano que se ejecutan como servicios del sistema operativo.

* **Aplicaciones de red**: Desarrollo de aplicaciones distribuidas o basadas en la red, como WCF (Windows Communication Foundation).

* **Aplicaciones empresariales**: Soluciones escalables para empresas con integración a bases de datos, sistemas de reportes y manejo de grandes volúmenes de datos.

## ¿Qué problemas resuelve?
* **Estandarización del desarrollo en Windows**: Antes de .NET Framework, los desarrolladores usaban múltiples lenguajes y tecnologías (VB, C++, etc.), lo que dificultaba la interoperabilidad. .NET Framework proporciona un entorno uniforme para el desarrollo.

* **Gestión de memoria automática**: Con el Garbage Collector, los desarrolladores no necesitan preocuparse por la asignación y liberación manual de memoria, reduciendo errores como fugas de memoria.

* **Interoperabilidad entre lenguajes**: Permite usar múltiples lenguajes de programación (C#, VB.NET, F#) en un solo proyecto, gracias a que todos se ejecutan sobre el CLR.

* **Desarrollo rápido con bibliotecas listas para usar**: La FCL proporciona una gran cantidad de herramientas y clases que reducen el esfuerzo en tareas comunes, como lectura de archivos, consultas a bases de datos o manejo de eventos.

* **Seguridad**: Proporciona un modelo de seguridad robusto, como el manejo de permisos de aplicaciones y aislamiento de procesos.

## ¿Cómo lo resuelve?
.NET Framework introduce un conjunto de componentes clave que abordan estos problemas:

* **Common Language Runtime (CLR)**: Ejecuta aplicaciones .NET proporcionando gestión de memoria, compilación Just-In-Time (JIT), manejo de excepciones y seguridad.
  * Traduce el código compilado (CIL, Common Intermediate Language) al lenguaje de máquina específico del sistema.

* **Framework Class Library (FCL)**: Ofrece una colección de bibliotecas reutilizables para tareas comunes, como manipulación de cadenas, colecciones, acceso a bases de datos, redes y más.

* **Modelo de desarrollo unificado**: Los desarrolladores usan un único modelo de programación para trabajar en diferentes tipos de aplicaciones (escritorio, web, servicios, etc.).

* **ASP.NET**: Framework para construir aplicaciones web y servicios web SOAP o REST.

* **Integración con herramientas de desarrollo**: Se integra perfectamente con Visual Studio, ofreciendo un entorno completo para diseñar, depurar y probar aplicaciones.

* **Soporte para Windows**: Ofrece acceso nativo a APIs de Windows, como DirectX, GDI+, registro del sistema y más.

## Limitaciones del .NET Framework
* **Dependencia de Windows**: Solo funciona en sistemas operativos Windows, lo que limita su portabilidad.

* **Monolítico y pesado**: No es modular como .NET Core; incluye muchas bibliotecas aunque no se utilicen.

* **Rendimiento limitado**: Comparado con .NET Core, tiene un rendimiento más bajo en aplicaciones de alto tráfico.

* **Despliegue complejo**: Requiere que el sistema operativo tenga instalada una versión específica del runtime de .NET Framework.

* **No soporta nuevas tecnologías modernas**: No está diseñado para arquitecturas basadas en contenedores, microservicios o aplicaciones multiplataforma.