# Estructura de carpetas

![](assets/0-laravel-directorio.png)

```bash
/app
    /Console
    /Exceptions
    /Http
        /Controllers
        /Middleware
    /Models
/bootstrap
/config
/database
    /factories
    /migrations
    /seeds
/public
/resources
    /lang
    /views
/routes
/storage
    /app
    /framework
    /logs
/tests
/vendor
/node_modules
```
- **app**: Contiene la lógica de la aplicación, incluyendo modelos, controladores, y otros archivos relacionados con la lógica de negocio.

- **bootstrap**: Contiene los archivos necesarios para inicializar la aplicación y cargar el framework.

- **config**: Almacena archivos de configuración para la aplicación, incluyendo configuraciones de bases de datos, servicios y otros ajustes.

- **database**: Contiene migraciones de base de datos, seeds, y otros archivos relacionados con la base de datos.

- **public**: Este es el directorio raíz de la aplicación y contiene el archivo index.php, así como archivos públicos como imágenes, hojas de estilo y scripts JavaScript.

- **resources**: Aquí se encuentran los archivos no compilados como las vistas, archivos de lenguaje, y archivos de assets (CSS, JavaScript, imágenes) que serán compilados utilizando Laravel Mix.

- **routes**: Contiene archivos de rutas de la aplicación, donde se definen las URL y se relacionan con los controladores o funciones de cierre.

- **storage**: Almacena archivos generados por la aplicación, como archivos de sesiones, caches, logs, y uploads. También incluye subdirectorios para almacenamiento específico como app, framework, y logs.

- **tests**: Contiene archivos de pruebas automatizadas para la aplicación.

- **vendor**: Aquí se encuentran las dependencias de Composer, incluyendo el código fuente de Laravel y otras bibliotecas de terceros.

- **node_modules**: Contiene las dependencias de Node.js utilizadas en el proyecto, especialmente aquellas relacionadas con Laravel Mix.