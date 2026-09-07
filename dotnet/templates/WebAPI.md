# Template: ASP.NET Core Web API
El template ASP.NET Core Web API es una plantilla diseñada para crear aplicaciones que exponen servicios RESTful basados en HTTP. Es ideal para desarrollar APIs que interactúan con clientes como aplicaciones web, móviles, u otros sistemas. Este template incluye las configuraciones básicas necesarias para trabajar con controladores, servicios y rutas de API.

## ¿Qué es el template ASP.NET Core Web API?
* Propósito: Crear aplicaciones de backend que expongan endpoints HTTP para consumo por otros sistemas o clientes.

* Uso común:
  * Construir servicios RESTful para aplicaciones web y móviles.

  * Proporcionar una capa de datos para aplicaciones cliente-servidor.

  * Implementar microservicios.

* Framework utilizado: ASP.NET Core.

* Comando para generar el proyecto:
```bash
dotnet new webapi -n MiProyectoWebAPI
```

## ¿Qué incluye el template ASP.NET Core Web API?
El proyecto generado con esta plantilla incluye:

* Un conjunto preconfigurado de middlewares.

* Un controlador de ejemplo para probar la API.

* Configuración de Swagger/OpenAPI para documentar y probar la API.

## Estructura del proyecto generado
Cuando creas un proyecto con el template ASP.NET Core Web API, obtendrás una estructura de directorios como esta:

```bash
MiProyectoWebAPI/
├── Controllers/
│   └── WeatherForecastController.cs
├── Properties/
│   └── launchSettings.json
├── appsettings.Development.json
├── appsettings.json
├── MiProyectoWebAPI.csproj
├── Program.cs
└── WeatherForecast.cs
```
### Descripción de la estructura
1. `Controllers/`
   * Contiene los controladores de la aplicación. Los controladores manejan las solicitudes HTTP y definen los endpoints de la API.

   * Ejemplo: `WeatherForecastController.cs`
     * Este es un controlador de ejemplo que implementa un endpoint básico para obtener datos de clima ficticios.

     * Código generado por defecto:
```c#
using Microsoft.AspNetCore.Mvc;

[ApiController]
[Route("[controller]")]
public class WeatherForecastController : ControllerBase
{
    private static readonly string[] Summaries = new[]
    {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    private readonly ILogger<WeatherForecastController> _logger;

    public WeatherForecastController(ILogger<WeatherForecastController> logger)
    {
        _logger = logger;
    }

    [HttpGet(Name = "GetWeatherForecast")]
    public IEnumerable<WeatherForecast> Get()
    {
        return Enumerable.Range(1, 5).Select(index => new WeatherForecast
        {
            Date = DateTime.Now.AddDays(index),
            TemperatureC = Random.Shared.Next(-20, 55),
            Summary = Summaries[Random.Shared.Next(Summaries.Length)]
        })
        .ToArray();
    }
}
```

2. `WeatherForecast.cs`
   * Un modelo de ejemplo para representar datos que la API devuelve.

   * Código generado:
```c#
public class WeatherForecast
{
    public DateTime Date { get; set; }
    public int TemperatureC { get; set; }
    public string? Summary { get; set; }

    public int TemperatureF => 32 + (int)(TemperatureC / 0.5556);
}
```

3. **`Properties/launchSettings.json`**
   * Contiene configuraciones para depuración y perfiles de inicio.

   * Define cómo se ejecutará el proyecto durante el desarrollo (por ejemplo, en `http://localhost:5000` o `https://localhost:5001`).

4. **`appsettings.json` y `appsettings.Development.json`**
   * Archivos de configuración para la aplicación.
     * `appsettings.json`: Contiene configuraciones generales.

     * `appsettings.Development.json`: Contiene configuraciones específicas del entorno de desarrollo.

5. `Program.cs`
   * Punto de entrada de la aplicación.

   * Configura el servidor web, middlewares y servicios.

   * Código por defecto:
```c#
var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
```

6. `MiProyectoWebAPI.csproj`
   * Archivo del proyecto que contiene la configuración necesaria para compilar y ejecutar la aplicación.
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

## Características principales del template Web API
* Controladores: Incluye una configuración inicial para trabajar con controladores RESTful utilizando atributos como `[ApiController]` y `[Route]`.

* Swagger/OpenAPI:
  * Proporciona soporte para documentar y probar tus endpoints directamente desde un navegador.
  * Swagger se activa automáticamente en el entorno de desarrollo.

* Inyección de dependencias: Configura servicios y middlewares de manera modular utilizando el patrón de diseño Dependency Injection.

* Extensibilidad: Permite agregar autenticación, autorización, middlewares personalizados y configuraciones avanzadas para APIs más robustas.

## Cómo probar el template Web API
1. Ejecutar el proyecto:
```bash
dotnet run
```

* Por defecto, la API estará disponible en:
  * HTTP: http://localhost:5000

  * HTTPS: https://localhost:5001

2. Probar con Swagger: Abre el navegador en https://localhost:5001/swagger para ver la documentación y probar los endpoints.

3. Probar con herramientas externas: Usa herramientas como Postman, Insomnia, o cURL para interactuar con los endpoints.

## Extensiones posibles
1. Agregar nuevos controladores: Crear un archivo en la carpeta `/Controllers` y definir nuevos endpoints.

2. Conectar a una base de datos:
   * Instalar y configurar Entity Framework Core:
```bash
dotnet add package Microsoft.EntityFrameworkCore.SqlServer
dotnet add package Microsoft.EntityFrameworkCore.Tools
```

3. Autenticación y autorización: Integrar mecanismos de autenticación como JWT o Identity.

4. Middleware personalizado: Agregar middlewares para manejar logging, errores globales o validaciones.