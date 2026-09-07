#dotnet
# `dotnet build`
El comando dotnet build es una de las herramientas fundamentales dentro del ecosistema de .NET. Se utiliza para compilar un proyecto, es decir, transformar el código fuente escrito en C# (u otros lenguajes soportados) en un ensamblado ejecutable o una biblioteca que pueda ser ejecutada o referenciada por otras aplicaciones.

### ¿Qué es dotnet build?
El comando dotnet build es una operación de la CLI (Interfaz de Línea de Comandos) de .NET que compila el código fuente de un proyecto en archivos binarios (como DLL o EXE) de acuerdo con las configuraciones de compilación especificadas en el archivo del proyecto .csproj. Es uno de los comandos más utilizados durante el ciclo de desarrollo de aplicaciones .NET, y se puede usar con proyectos de aplicaciones de consola, aplicaciones web, bibliotecas, etc.

### ¿Para qué sirve dotnet build?
* Compilación del código fuente: Convierte el código fuente (C# o F#) en un ensamblado que puede ejecutarse o ser referenciado por otros proyectos.

* Generación de archivos de salida: Produce los archivos de salida (por ejemplo, DLLs, EXEs) en una carpeta bin/ dentro del directorio del proyecto.

* Validación del código: Ejecuta una serie de verificaciones para asegurarse de que el código es válido (sin errores de sintaxis, dependencias no resueltas, etc.).

* Optimización: Si se configura con los parámetros adecuados, puede realizar una compilación optimizada para producción.

* Dependencias: Durante el proceso de compilación, descarga las dependencias necesarias desde NuGet y otros paquetes de dependencias del proyecto.

* Configuración de diferentes entornos: Permite compilar para diferentes entornos, como "Debug" o "Release", lo cual es útil para pruebas o producción.

### ¿Qué resuelve dotnet build?
* Compilación automática y sencilla: Automatiza el proceso de convertir el código fuente en un archivo ejecutable o biblioteca sin necesidad de herramientas de compilación externas como Visual Studio.

* Consistencia en el proceso de construcción: Asegura que todos los desarrolladores y sistemas de CI/CD utilicen la misma configuración para compilar el código.

* Gestión de dependencias: Durante la construcción, maneja la descarga e integración de las dependencias de NuGet necesarias para el proyecto.

* Soporte para proyectos multidimensionales: Es capaz de manejar proyectos que contienen múltiples dependencias, referencias a otros proyectos, y configuraciones complejas.

* Optimización para diferentes entornos: Permite la compilación en diferentes configuraciones (Debug o Release) dependiendo de los requisitos de la etapa del ciclo de vida del software.

### ¿Cómo lo resuelve dotnet build?
* Compilación del proyecto: Cuando se ejecuta el comando, .NET lee el archivo .csproj del proyecto, resuelve las dependencias necesarias y luego compila el código fuente en un formato adecuado para el entorno de destino.

* Generación de archivos binarios: Dependiendo de la configuración del proyecto, el comando genera los archivos binarios (.dll para bibliotecas o .exe para aplicaciones ejecutables) en la carpeta bin/ del directorio del proyecto.

* Manejo de dependencias: Durante la compilación, el sistema descarga e integra automáticamente cualquier dependencia o paquete NuGet listado en el archivo .csproj.

* Configuración de entornos: La compilación se puede realizar en diferentes configuraciones, como Debug o Release, a través de los parámetros del comando.

* Soporte para plataformas cruzadas: El proceso de compilación se adapta automáticamente según la plataforma (Windows, Linux, macOS) y el marco de destino (por ejemplo, netcoreapp3.1, net5.0, net7.0).

### Sintaxis
```bash
dotnet build
```
Parámetros comunes de dotnet build
-c <configuration>: Especifica la configuración de la compilación. Las configuraciones más comunes son Debug (por defecto) y Release.
```bash
dotnet build -c Release
```

-o <output-path>: Define la ubicación del directorio de salida donde se colocarán los archivos compilados (por defecto es ./bin).
```bash
dotnet build -o ./salida
```

--no-restore: Evita restaurar las dependencias antes de la compilación. Esto es útil si ya has restaurado las dependencias previamente y solo deseas compilar el código.
```bash
dotnet build --no-restore
```

-v <verbosity>: Establece el nivel de detalle en los mensajes de salida. Los valores pueden ser quiet, minimal, normal, detailed o diagnostic.
```bash
dotnet build -v detailed
```

--restore: Este parámetro hace que se ejecute la restauración de dependencias automáticamente antes de la compilación.
```bash
dotnet build --restore
```

### Flujo de trabajo básico con dotnet build
* Inicialización: Puedes crear un proyecto desde cero con dotnet new (por ejemplo, dotnet new console -n MiAplicacion).

* Restauración de dependencias: Antes de compilar, asegúrate de restaurar las dependencias con dotnet restore, o bien, puedes usar dotnet build --restore para restaurarlas y compilarlas en un solo paso.

* Compilación del proyecto: Usa dotnet build para compilar el proyecto.

* Verificación de errores: Si la compilación tiene errores, el comando mostrará los detalles en la consola para que puedas corregirlos.

* Resultados de la compilación: Los archivos generados estarán en la carpeta bin/ dentro del directorio del proyecto. Si usaste la configuración Release, los archivos estarán en bin/Release/.

## ¿Cuándo usar dotnet build?
* Ciclo de desarrollo diario: Cada vez que realices cambios en tu código y quieras verificar que todo se compila correctamente.

* Prepara para la prueba o el despliegue: Al compilar en la configuración Release, puedes generar los archivos listos para producción.

* En CI/CD: Es parte fundamental de los procesos de integración continua y entrega continua, donde los proyectos se compilan automáticamente en servidores de construcción.