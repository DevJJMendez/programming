# `.csproj`
El archivo .csproj es un archivo crucial en el ecosistema de .NET que describe el proyecto y sus configuraciones para el proceso de compilación, restauración de dependencias, y ejecución. Es fundamental para el sistema de construcción de .NET y ayuda a configurar el comportamiento del proyecto a lo largo de su ciclo de vida.

## ¿Qué es el archivo .csproj?
El archivo .csproj (C# Project File) es un archivo de configuración basado en XML que contiene información sobre un proyecto de C# o F# dentro de .NET. El archivo .csproj define cómo debe ser construido el proyecto, qué dependencias se requieren, qué archivos forman parte del proyecto y otras configuraciones importantes para el proceso de compilación y ejecución. Este archivo es leído y utilizado por herramientas como el SDK de .NET y Visual Studio para gestionar y construir el proyecto.

## ¿Para qué sirve el archivo .csproj?
* Definir las dependencias del proyecto: El archivo .csproj incluye las referencias a las bibliotecas y paquetes NuGet que el proyecto necesita.

* Configurar la compilación: Se define el tipo de compilación (Debug o Release), las versiones de las dependencias, las plataformas de destino, etc.

* Incluir/excluir archivos: Especifica qué archivos deben ser incluidos en la compilación y cuáles deben ser ignorados.

* Configurar propiedades del proyecto: Puedes configurar configuraciones de la aplicación, versiones de .NET, y otras opciones de compilación o ejecución.

* Especificar el marco de trabajo (framework): Define la versión de .NET o el marco de trabajo (por ejemplo, net5.0, net6.0, netcoreapp3.1).

## ¿Qué resuelve el archivo .csproj?
* Facilita la gestión de dependencias: A través de la inclusión de paquetes NuGet y referencias a otros proyectos, el archivo .csproj automatiza la resolución de dependencias y permite la gestión eficiente de bibliotecas externas.

* Organiza el proceso de construcción: Define las configuraciones necesarias para la construcción de la aplicación, gestionando aspectos como las plataformas de destino, los compiladores utilizados, y las configuraciones de optimización.

* Configuración centralizada: Centraliza las configuraciones del proyecto (como el marco de trabajo, las propiedades del compilador y los parámetros de ejecución), evitando que estas configuraciones se tengan que repetir en cada archivo individual del proyecto.

* Multiplataforma: Permite que el proyecto sea compilado en diferentes plataformas (Windows, Linux, macOS) sin necesidad de modificar el archivo de configuración, ya que el SDK de .NET maneja las configuraciones específicas de cada plataforma.

* Escalabilidad y flexibilidad: Al estar basado en un formato estándar y bien definido (XML), los archivos .csproj pueden ser fácilmente versionados y compartidos entre equipos de desarrollo, integrándose bien con sistemas de control de versiones.

## ¿Cómo lo resuelve?
* Estructuración del proyecto: El archivo .csproj organiza la información relacionada con la compilación y ejecución, desde las dependencias de NuGet hasta las configuraciones específicas de plataforma y compilador.

* Resolución de dependencias: A través de la inclusión de elementos **<PackageReference>** y **<ProjectReference>**, el archivo .csproj gestiona las dependencias del proyecto, asegurando que se descarguen automáticamente las bibliotecas necesarias durante el proceso de construcción.

* Configuración de la compilación: Utilizando etiquetas como **<OutputType>**, **<TargetFramework>**, y **<Configuration>**, el archivo .csproj gestiona cómo debe ser compilado y ejecutado el proyecto (por ejemplo, qué marco de trabajo usar o en qué configuración de compilación).

* Incluir/excluir archivos automáticamente: A través de patrones de inclusiones y exclusiones de archivos, el archivo .csproj gestiona automáticamente los archivos fuente, como las clases, recursos, y archivos de configuración.

* Compatibilidad con plataformas cruzadas: Se adapta a diferentes plataformas y versiones del marco de trabajo, lo que permite crear aplicaciones que puedan ejecutarse en distintos sistemas operativos.

## Estructura de un archivo .csproj
```xml
<Project Sdk="Microsoft.NET.Sdk">

  <PropertyGroup>
    <!-- Configuración general del proyecto -->
    <TargetFramework>net6.0</TargetFramework>   <!-- Marco de trabajo -->
    <OutputType>Exe</OutputType>                 <!-- Tipo de salida (Ejecutable o Biblioteca) -->
    <RootNamespace>MiAplicacion</RootNamespace>   <!-- Espacio de nombres raíz -->
  </PropertyGroup>

  <ItemGroup>
    <!-- NuGet Packege -->
    <PackageReference Include="Newtonsoft.Json" Version="13.0.1" />
    <!-- Dependencias del proyecto -->
    <PackageReference Include="Newtonsoft.Json" Version="13.0.1" />
  </ItemGroup>
  
  <!-- Incluir/excluir archivos de código -->
  <ItemGroup>
    <Compile Include="Program.cs" />
    <Compile Include="Funciones.cs" />
  </ItemGroup>

  <ItemGroup>
    <None Include="appsettings.json" />
  </ItemGroup>

  <!-- Referencia a otro proyecto -->
  <ItemGroup>
  <ProjectReference Include="..\MiBiblioteca\MiBiblioteca.csproj" />
  </ItemGroup>

</Project>
```
### Explicación de las principales secciones:
1. **`<Project Sdk="Microsoft.NET.Sdk">`**: Define el SDK que se utiliza para la compilación. En este caso, el SDK de .NET estándar para aplicaciones de consola, bibliotecas o aplicaciones web. Este atributo es importante para proyectos en .NET Core y versiones más recientes de .NET.

2. **`<PropertyGroup>`**: Contiene las propiedades de configuración que definen aspectos clave del proyecto, como:
   * `<TargetFramework>`: Especifica el marco de trabajo (por ejemplo, net6.0, netcoreapp3.1, net5.0).

   * `<OutputType>`: Define el tipo de salida: Exe (ejecutable) o Library (biblioteca).

   * `<RootNamespace>`: Define el espacio de nombres raíz utilizado en el proyecto.

3. **`<ItemGroup>`**: Contiene las referencias a los elementos del proyecto, como:
   * `<PackageReference>`: Define los paquetes NuGet que el proyecto usa. En este caso, el paquete Newtonsoft.Json con la versión 13.0.1.

## ¿Cómo se utiliza el archivo .csproj?
* Creación de un nuevo proyecto: Cuando ejecutas dotnet new console -n MiProyecto, se crea un archivo .csproj con las configuraciones predeterminadas del proyecto.

* Edición manual: Puedes abrir y modificar el archivo .csproj directamente en un editor de texto o IDE para agregar nuevas dependencias, cambiar configuraciones o ajustar el marco de trabajo.

* Restauración de dependencias: Cuando ejecutas dotnet restore, el archivo .csproj se utiliza para descargar todas las dependencias necesarias (paquetes NuGet, proyectos referenciados, etc.).

* Compilación: Cuando ejecutas dotnet build, el archivo .csproj se utiliza para compilar el proyecto con las configuraciones definidas dentro de él.