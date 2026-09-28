# Template: ASP.NET Core Web App
El template ASP.NET Core Web App es una plantilla diseñada para construir aplicaciones web tradicionales utilizando el patrón MVC (Model-View-Controller) o páginas Razor. Este tipo de proyectos es ideal para aplicaciones con contenido dinámico y una experiencia de usuario basada en HTML renderizado en el servidor.

## ¿Qué es el template ASP.NET Core Web App?
1. Propósito: Crear aplicaciones web con una interfaz gráfica dinámica, donde el servidor renderiza las vistas HTML y las envía al navegador.

2. Patrón:
   * Soporta el patrón MVC (Model-View-Controller), separando lógica, datos y presentación.

   * También soporta Razor Pages, un modelo basado en páginas más directo.

3. Uso común:
   * Desarrollar aplicaciones web empresariales y públicas.

   * Crear sistemas de administración, blogs, portales y más.

4. Comando para generar el proyecto:
```bash
dotnet new webapp -n MiProyectoWebApp
```

## ¿Qué incluye el template ASP.NET Core Web App?
El template genera una aplicación básica configurada con:

* Controladores y vistas (si se usa MVC) o Páginas Razor (por defecto).

* Bootstrap: Para proporcionar un diseño responsivo preconfigurado.

* Razor: Motor de plantillas para generar vistas dinámicas.

* Configuración básica para autenticación y autorización (puede ser añadida posteriormente).

## Estructura del proyecto generado
Al crear un proyecto con el template ASP.NET Core Web App, la estructura generada se verá así:
```bash
MiProyectoWebApp/
├── Areas/ (opcional, para MVC con áreas)
├── Pages/
│   ├── Shared/
│   │   ├── _Layout.cshtml
│   │   └── _ValidationScriptsPartial.cshtml
│   ├── Error.cshtml
│   └── Index.cshtml
├── Properties/
│   └── launchSettings.json
├── wwwroot/
│   ├── css/
│   ├── js/
│   └── lib/
├── appsettings.Development.json
├── appsettings.json
├── MiProyectoWebApp.csproj
└── Program.cs
```
### Descripción de la estructura
1. `Pages/`
   * Carpeta que contiene las páginas Razor (estructura por defecto).

   * `Index.cshtml`: Página de inicio de la aplicación.
     * Contiene código Razor y HTML.

   * `Error.cshtml`: Página que se muestra en caso de errores en la aplicación.

   * `Shared/`: Contiene componentes compartidos, como `_Layout.cshtml`.
     * `_Layout.cshtml`: Archivo principal de diseño que define la estructura HTML común, como encabezado y pie de página.

     * `_ValidationScriptsPartial.cshtml`: Scripts para la validación de formularios.

2. `wwwroot/`
   * Carpeta para recursos estáticos como CSS, JavaScript, imágenes y fuentes.

   * Subcarpetas típicas:
     * `css/`: Archivos de estilos (por ejemplo, Bootstrap).

     * `js/`: Scripts JavaScript personalizados.

     * `lib/`: Librerías externas, como Bootstrap o jQuery.

3. **`Properties/launchSettings.json`**: Archivo de configuración para depuración. Define perfiles de ejecución, como puertos y entornos.

4. **`appsettings.json` y `appsettings.Development.json`**
   * Archivos para la configuración de la aplicación:
     * `appsettings.json`: Configuración general.

     * `appsettings.Development.json`: Configuración específica para el entorno de desarrollo.

5. `Program.cs`
   * Punto de entrada de la aplicación, donde se configuran servicios y middlewares.

   * Código típico generado:
```c#
var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddRazorPages();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapRazorPages();

app.Run();
```

6. `MiProyectoWebApp.csproj`
   * Archivo del proyecto que contiene las configuraciones necesarias para compilar y ejecutar la aplicación.

   * Ejemplo
```xml
<Project Sdk="Microsoft.NET.Sdk.Web">
  <PropertyGroup>
    <TargetFramework>net7.0</TargetFramework>
    <Nullable>enable</Nullable>
    <ImplicitUsings>enable</ImplicitUsings>
  </PropertyGroup>
</Project>
```

## ¿Cómo funciona el template ASP.NET Core Web App?
* Razor Pages: Este es el modelo principal del template, con páginas compuestas por un archivo .cshtml (HTML con código Razor) y un archivo .cshtml.cs (código del backend para manejar eventos y lógica).

* Diseño compartido:
  * Se utiliza _Layout.cshtml para definir el diseño base de la aplicación (encabezado, menús, pie de página).

  * Las páginas individuales se renderizan dentro de este diseño.

* Recursos estáticos: CSS, JS y otros recursos están disponibles en la carpeta wwwroot.

* Middlewares: Maneja las solicitudes y respuestas HTTP mediante middlewares preconfigurados, como UseStaticFiles() y UseRouting().

## Características principales
* Integración con Bootstrap: La plantilla incluye Bootstrap para proporcionar una interfaz visual limpia y responsiva desde el inicio.

* Razor Pages: Simplicidad en el desarrollo al combinar lógica y presentación en una sola página.

* Modularidad: Los servicios como Razor Pages y archivos estáticos se configuran y pueden ampliarse fácilmente.

* Extensibilidad: Puedes migrar de Razor Pages a MVC si tu proyecto requiere una separación más estricta entre modelos, vistas y controladores.

## ¿Cómo ejecutar y probar la aplicación?
Ejecutar el proyecto:
```bash
dotnet run
```
La aplicación estará disponible en:
HTTP: http://localhost:5000
HTTPS: https://localhost:5001
Probar en el navegador:

Abre http://localhost:5000 o https://localhost:5001 para ver la página principal generada.
Editar páginas Razor:

Modifica archivos en Pages/ para cambiar el contenido dinámico de las vistas.

## Extensiones posibles
1. Agregar autenticación:
   * Para agregar soporte de identidad y autenticación:
```bash
dotnet add package Microsoft.AspNetCore.Identity.EntityFrameworkCore
```

2. Agregar controladores y vistas (MVC):
   * Migrar a MVC es sencillo:
     * Agrega servicios MVC en Program.cs:
```c#
builder.Services.AddControllersWithViews();
```
Configura las rutas de controladores:
```c#
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");
```

3. Conectar a una base de datos:
   * Instalar Entity Framework Core
```bash
dotnet add package Microsoft.EntityFrameworkCore.SqlServer
```

4. Configurar diseño avanzado: Personaliza `_Layout.cshtml` y usa componentes Razor compartidos.

# Template: ASP.NET Core Web App (Model-View-Controller)
El template ASP.NET Core Web App (Model-View-Controller) es una plantilla diseñada para construir aplicaciones web utilizando el patrón MVC (Model-View-Controller). Este patrón separa la lógica de la aplicación, la presentación y la interacción con los datos, permitiendo un desarrollo más organizado, mantenible y escalable.

## ¿Qué es este template?
* Propósito: Crear aplicaciones web dinámicas con una arquitectura robusta basada en MVC.

* Patrón:
  * Model: Representa los datos de la aplicación y la lógica de negocio.

  * View: Muestra la interfaz de usuario (HTML, Razor, CSS, etc.).

  * Controller: Maneja la lógica de la aplicación y coordina la interacción entre el modelo y las vistas.

* Uso común:
  * Aplicaciones que requieren separación clara de responsabilidades.

  * Sistemas empresariales, eCommerce, aplicaciones de gestión, etc.

* Comando para generar el proyecto:
```bash
dotnet new mvc -n MiProyectoMVC
```

## Características principales
* Estructura preconfigurada para MVC.

* Integración con Razor para vistas dinámicas.

* Configuración inicial para recursos estáticos como CSS y JavaScript.

* Soporte para enrutamiento y middlewares configurados.

## Estructura del proyecto generado
Cuando creas un proyecto con el template ASP.NET Core Web App (MVC), obtendrás la siguiente estructura de directorios:
```bash
MiProyectoMVC/
├── Controllers/
│   └── HomeController.cs
├── Models/
├── Views/
│   ├── Home/
│   │   ├── Index.cshtml
│   │   ├── About.cshtml
│   │   └── Contact.cshtml
│   ├── Shared/
│   │   ├── _Layout.cshtml
│   │   └── _ValidationScriptsPartial.cshtml
├── wwwroot/
│   ├── css/
│   │   └── site.css
│   ├── js/
│   │   └── site.js
│   └── lib/
├── Properties/
│   └── launchSettings.json
├── appsettings.Development.json
├── appsettings.json
├── MiProyectoMVC.csproj
└── Program.cs
```
### Descripción de la estructura
1. `Controllers/`
   * Contiene las clases de controladores, que manejan la lógica de la aplicación.

   * Ejemplo: `HomeController.cs`
```c#
public class HomeController : Controller
{
    public IActionResult Index()
    {
        return View();
    }
}
```
* Acciones: Métodos dentro de los controladores que procesan solicitudes y devuelven vistas o datos.

2. `Models/`
   * Contiene las clases que representan el modelo de datos de la aplicación.

   * Responsabilidad: Encapsular la lógica de negocio y trabajar con datos.

   * Ejemplo: Clases para manejar datos de una base de datos o validación de formularios.

3. `Views/`
   * Carpeta que contiene las vistas de la aplicación.

   * Subcarpetas típicas:
     * Home/: Contiene vistas relacionadas con el controlador HomeController.

       * Index.cshtml: Vista principal de la página de inicio.

       * About.cshtml y Contact.cshtml: Ejemplo de páginas secundarias.

     * Shared/: Contiene vistas compartidas, como:
       * _Layout.cshtml: Archivo de diseño principal que define la estructura HTML común (encabezado, menú, pie de página).

       * _ValidationScriptsPartial.cshtml: Scripts para la validación de formularios.

4. `wwwroot/` Carpeta para recursos estáticos como CSS, JavaScript, imágenes y bibliotecas externas.

5. Properties/launchSettings.json
   * Configuración para ejecutar el proyecto en entornos de desarrollo.

   * Define:
     * Puertos HTTP/HTTPS.

     * Perfiles de entorno.

6. **`appsettings.json` y `appsettings.Development.json`**
   * Configuración de la aplicación:
     * appsettings.json: Configuración global.

     * appsettings.Development.json: Configuración específica para desarrollo.

7. `Program.cs`
   * Punto de entrada de la aplicación.

   * Configura servicios y middlewares, por ejemplo
```c#
var builder = WebApplication.CreateBuilder(args);

// Agrega servicios al contenedor.
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Configura el pipeline de solicitudes HTTP.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
```

8. `MiProyectoMVC.csproj`: Archivo que contiene la configuración del proyecto
```xml
<Project Sdk="Microsoft.NET.Sdk.Web">
  <PropertyGroup>
    <TargetFramework>net7.0</TargetFramework>
    <Nullable>enable</Nullable>
    <ImplicitUsings>enable</ImplicitUsings>
  </PropertyGroup>
</Project>
```

## ¿Cómo funciona el template ASP.NET Core Web App?
1. Razor Pages: Este es el modelo principal del template, con páginas compuestas por un archivo .cshtml (HTML con código Razor) y un archivo .cshtml.cs (código del backend para manejar eventos y lógica).

* Diseño compartido:
  * Se utiliza _Layout.cshtml para definir el diseño base de la aplicación (encabezado, menús, pie de página). 
  * Las páginas individuales se renderizan dentro de este diseño.

* Recursos estáticos: CSS, JS y otros recursos están disponibles en la carpeta wwwroot.

* Middlewares: Maneja las solicitudes y respuestas HTTP mediante middlewares preconfigurados, como UseStaticFiles() y UseRouting().

## Características del template MVC
* Patrón MVC bien definido: Facilita la separación de responsabilidades.

* Poder de Razor: Permite la integración de HTML con C# para crear vistas dinámicas.

* Enrutamiento configurable: Define rutas fácilmente en el archivo Program.cs.

* Personalización: Modifica _Layout.cshtml para cambiar la apariencia global.

* Escalabilidad: Soporte para modularidad con controladores y vistas adicionales.

## Ejecutar y probar el proyecto
Ejecuta el proyecto:
```bash
dotnet run
```

2. Navega a la URL:
   * HTTP: http://localhost:5000

   * HTTPS: https://localhost:5001

3. Prueba los endpoints:
   * La ruta predeterminada es /Home/Index.
