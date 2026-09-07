# Software Development Kit
El **.NET SDK (Software Development Kit)** es un conjunto de herramientas, bibliotecas y compiladores necesarios para desarrollar aplicaciones en .NET. Es esencial para escribir, compilar, probar y ejecutar aplicaciones en cualquier implementación de .NET (como .NET Core o .NET 5+).

El SDK incluye:
* **CLI de .NET (Command Line Interface)**: Herramientas para trabajar con proyectos desde la línea de comandos.

* **Bibliotecas de desarrollo**: Conjunto de clases y métodos predefinidos como parte del BCL y otras extensiones.

* **Compiladores**: Herramientas para compilar el código fuente (C#, F#, VB.NET) en un formato ejecutable.

* **Plantillas de proyectos**: Estructuras base para comenzar proyectos rápidamente (aplicaciones web, APIs, consolas, bibliotecas, etc.).

## ¿Para qué sirve el .NET SDK?
* **Crear aplicaciones en .NET**: Permite a los desarrolladores escribir, compilar y ejecutar aplicaciones de consola, APIs web, aplicaciones de escritorio, servicios de backend, aplicaciones móviles, y más.

* **Gestión de proyectos**: Con herramientas como la CLI, puedes crear, restaurar dependencias, compilar y publicar aplicaciones fácilmente.

* **Interoperabilidad multiplataforma**: Diseñado para funcionar en sistemas operativos como Windows, Linux (incluido Ubuntu), y macOS.

* **Integración con entornos de desarrollo**: Aunque puede usarse desde la línea de comandos, se integra perfectamente con IDEs como Visual Studio, Visual Studio Code y JetBrains Rider.

## ¿Qué resuelve el .NET SDK?
La necesidad de un entorno de desarrollo unificado: Antes de .NET Core, el desarrollo con .NET estaba fuertemente ligado a Windows. El SDK habilita un entorno de desarrollo multiplataforma.

Gestión de dependencias: Incluye integración con NuGet, el gestor de paquetes de .NET, para facilitar la inclusión de bibliotecas de terceros.

Compilación y ejecución en diferentes sistemas: Resuelve el problema de portabilidad al permitir que las aplicaciones se ejecuten en múltiples plataformas.

Configuración simplificada: Proporciona plantillas y herramientas que reducen la configuración inicial requerida para nuevos proyectos.

## ¿Cómo lo resuelve el .NET SDK?
* Mediante la CLI de .NET: La CLI ofrece comandos para crear y administrar proyectos. Algunos comandos importantes son:
  * dotnet new: Crear un nuevo proyecto.

  * dotnet build: Compilar el proyecto.

  * dotnet run: Ejecutar la aplicación.

  * dotnet test: Ejecutar pruebas unitarias.

  * dotnet publish: Publicar la aplicación para distribución.

* Plantillas predefinidas: El SDK incluye plantillas para crear proyectos de diferentes tipos, por ejemplo:
  * Aplicaciones de consola: dotnet new console.

  * APIs web: dotnet new webapi.

  * Aplicaciones MVC: dotnet new mvc.

* Gestión de dependencias con NuGet: El SDK gestiona automáticamente las dependencias a través de un archivo *.csproj, que especifica los paquetes NuGet necesarios.

* Compiladores integrados: Proporciona compiladores para convertir el código fuente en ensamblados binarios listos para ejecutarse en el runtime de .NET.

* Compatibilidad con múltiples versiones: El SDK soporta múltiples versiones de .NET instaladas en un solo sistema. Puedes especificar qué versión usar en un proyecto a través de un archivo global.json.

## Estructura del .NET SDK
El SDK tiene varios componentes importantes:

CLI de .NET: Herramienta principal para interactuar con el SDK desde la terminal.

Bibliotecas del BCL: Proporcionan acceso a funcionalidades fundamentales como manipulación de cadenas, colecciones, I/O, etc.

Herramientas de compilación: Convierte el código fuente en archivos ejecutables o bibliotecas dinámicas.

Plantillas de proyectos: Ofrecen configuraciones iniciales para diferentes tipos de aplicaciones.

Gestor de paquetes NuGet: Facilita la instalación y actualización de dependencias.