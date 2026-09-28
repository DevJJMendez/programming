# Vistas
En Laravel, las vistas son una parte fundamental del patrón de arquitectura MVC (Modelo-Vista-Controlador). Las vistas son responsables de la presentación de datos al usuario y actúan como la capa de interfaz de usuario de la aplicación.

## Conceptos Básicos de las Vistas en Laravel

1. **Ubicación de las Vistas**: Las vistas en Laravel se almacenan en el directorio `resources/views`. Cada archivo de vista es un archivo Blade (`.blade.php`), el motor de plantillas de Laravel.

2. Creación de una Vista: Puedes crear una vista creando un archivo Blade en el directorio `resources/views`. Por ejemplo, puedes crear una vista llamada `welcome.blade.php`, tambien se pueden crear vistas usando el comando:
```bash
php artisan make:view welcome
```

### Optimizar Vistas
```bash
php artisan view:cache
php artisan view:clear
```