#dotnet
# `dotnet new`
El comando `dotnet new` es una herramienta proporcionada por la **.NET CLI** que permite crear nuevos proyectos, soluciones y archivos basados en plantillas predefinidas. Es el punto de partida para iniciar cualquier desarrollo en **.NET**, ya que genera la estructura básica necesaria para comenzar a trabajar.

### ¿Para qué sirve?
* **Crear proyectos de distintos tipos**: Como aplicaciones de consola, APIs, bibliotecas de clases, aplicaciones web, aplicaciones Blazor, entre otros.

* **Establecer configuraciones iniciales**: Agregar configuraciones como nombres de namespaces, frameworks objetivo, y dependencias básicas.

* **Proveer flexibilidad**: Ofrecer plantillas para diferentes tecnologías de .NET, adaptadas según el propósito del desarrollo.

### ¿Qué resuelve?
* **Evita comenzar desde cero**: Genera automáticamente los archivos básicos y estructura del proyecto, como carpetas (`Program.cs`, `Startup.cs`, etc.) y configuraciones (`.csproj`).

* **Consistencia en los proyectos**: Asegura que todos los proyectos sigan una estructura estándar, facilitando la colaboración en equipo.

* **Productividad**: Reduce el tiempo necesario para configurar manualmente un proyecto al proporcionarte plantillas listas para usar.

* **Compatibilidad con herramientas**: Garantiza que los proyectos creados con el comando sean compatibles con los entornos de desarrollo y herramientas de .NET.

### ¿Cómo lo resuelve?
* **Uso de plantillas predefinidas**: El comando utiliza un conjunto de plantillas integradas que se adaptan a diferentes tipos de proyectos.

* **Configuración basada en parámetros**: Puedes personalizar el proyecto utilizando parámetros como el nombre, el framework objetivo, y más.

* **Extensibilidad**: Permite agregar o crear tus propias plantillas para necesidades específicas del equipo o del proyecto.

### Sintaxis básica
```bash
dotnet new [TEMPLATE] [OPTIONS]
```
* `TEMPLATE`: Es el tipo de proyecto que deseas crear.

* `OPTIONS`: Parámetros adicionales para personalizar el proyecto.

Plantillas disponibles: Para listar todas las plantillas disponibles:
```bash
dotnet new list
```
Ejemplo de salida:
```bash
Template Name                  Short Name      Language      Tags
-------------------------------------------------------------------
Console App                   console         [C#],F#,VB   Common/Console
Class Library                 classlib        [C#],F#,VB   Common/Library
Web API                       webapi          [C#]         Web/WebAPI
ASP.NET Core Web App          webapp          [C#]         Web/MVC
...
```

### Ejemplos prácticos
* **Crear una aplicación de consola**
```bash
dotnet new console -n MiAppDeConsola
```
  * Esto crea un proyecto con:
    * Archivo `Program.cs` con una aplicación de consola básica.

    * Archivo `.csproj` configurado para compilar una aplicación de consola.

* **Crear una API RESTful**
```bash
dotnet new webapi -n MiApi
```
  * Esto genera:
    * Estructura de un proyecto **API**.

    * Configuración para controladores y rutas en **ASP.NET Core**.

### Personalización con opciones
Puedes usar parámetros adicionales para personalizar los proyectos:

* `--framework`: Selecciona el framework objetivo
```bash
dotnet new console --framework net6.0
```

* `--language`: Especifica el lenguaje (C#, F#, VB)
```bash
dotnet new console --language F#
```

* `--output`: Define el directorio de salida.
```bash
dotnet new console -o MiDirectorio
```

### Templates
1. **Console App**
   * Nombre: `console`
   * Propósito: Crear una aplicación de consola básica.
   * Uso común: Aplicaciones que se ejecutan desde la terminal para tareas como scripts, pruebas rápidas, y herramientas CLI.

   * Comando básico:
```bash
dotnet new console -n MiAppConsola
```
   * Opciones:
     * `--framework`: Define el framework objetivo (ejemplo: net7.0).

     * `--language`: Define el lenguaje (C#, F#, VB).

1. Nombre: classlib
   * Propósito: Crear una biblioteca de clases reutilizable.
   * Uso común: Componentes compartidos como lógica de negocio, utilidades o bibliotecas para otros proyectos.

   * Comando básico:
```bash
dotnet new classlib -n MiBiblioteca
```
Opciones:
* `--framework`: Define el framework objetivo.

1. Web API
   * Nombre: webapi
   * Propósito: Crear una API RESTful utilizando ASP.NET Core.
   * Uso común: Desarrollo de servicios backend que proporcionan endpoints para aplicaciones cliente.

   * Comando básico
```bash
dotnet new webapi -n MiApi
```
Opciones:
* `--no-https`: Desactiva HTTPS.

* `--auth`: Define la autenticación (None, Individual, MicrosoftAccount, etc.).

* `--use-minimal-apis`: Utiliza Minimal APIs.

4. ASP.NET Core Web App (MVC)
   * Nombre: mvc
   * Propósito: Crear una aplicación web MVC (Model-View-Controller).
   * Uso común: Aplicaciones web que necesitan controladores y vistas estructuradas.

   * Comando básico
```bash
dotnet new mvc -n MiWebAppMVC
```
Opciones:
* --auth: Define el método de autenticación.

* --use-local-db: Configura el uso de una base de datos local.

5. ASP.NET Core Web App (Razor Pages)
   * Nombre: webapp
   * Propósito: Crear una aplicación web basada en Razor Pages (más simple que MVC).
   * Uso común: Aplicaciones web ligeras con páginas estructuradas.

   * Comando básico
```bash
dotnet new webapp -n MiWebApp
```
Opciones:
* --auth: Configura la autenticación.

* --framework: Define el framework objetivo.

6. Blazor Server
Nombre: blazorserver
Propósito: Crear una aplicación Blazor que renderiza en el servidor.
Uso común: Aplicaciones interactivas con un backend en tiempo real.
Comando básico:
```bash
dotnet new blazorserver -n MiBlazorServer
```

7. Blazor WebAssembly
Nombre: blazorwasm
Propósito: Crear una aplicación Blazor que se ejecuta en el navegador.
Uso común: Aplicaciones SPA (Single Page Application).
Comando básico:
```bash
dotnet new blazorwasm -n MiBlazorWasm
```
Opciones:
--hosted: Configura el proyecto para incluir un backend ASP.NET Core.
--auth: Configura la autenticación.

8. Worker Service
Nombre: worker
Propósito: Crear un servicio en segundo plano para realizar tareas recurrentes o de larga duración.
Uso común: Automatización de procesos y servicios de backend.
Comando básico
```bash
dotnet new worker -n MiServicio
```

9. Unit Test Project
Nombre: mstest, xunit, nunit
Propósito: Crear un proyecto para pruebas unitarias con el framework correspondiente.
Uso común: Implementar y ejecutar pruebas para garantizar la calidad del código.
Comando básico:
```bash
dotnet new xunit -n MiPruebas
```

10. Global JSON
Nombre: globaljson
Propósito: Crear un archivo para especificar la versión del SDK de .NET a usar.
Uso común: Controlar la versión del SDK en proyectos específicos.
Comando básico
```bash
dotnet new globaljson --sdk-version 7.0.100
```

11. Solution File
Nombre: sln
Propósito: Crear un archivo de solución para agrupar múltiples proyectos.
Uso común: Organización de proyectos grandes o con múltiples dependencias.
Comando básico
```bash
dotnet new sln -n MiSolucion
```

### Opciones generales para todas las plantillas
* --output (o -o): Define el directorio donde se generará el proyecto.
```bash
dotnet new console -o MiDirectorio
```
* --framework: Especifica la versión del framework objetivo.
```bash
dotnet new console --framework net7.0
```

### Extensibilidad
* **Instalar nuevas plantillas**: Puedes agregar plantillas adicionales creadas por la comunidad o personalizadas:
  * Buscar plantillas en NuGet:
```bash
dotnet new search [TEMPLATE_NAME]
```
  * Instalar plantillas personalizadas:
```bash
dotnet new install [PACKAGE_ID]
```

* Crear tus propias plantillas: Puedes desarrollar tus propias plantillas para estandarizar proyectos dentro de tu equipo:
  * Crear una estructura básica de proyecto
  * Configurar un archivo de plantilla
  * Publicar o compartir con el comando `dotnet new install`.