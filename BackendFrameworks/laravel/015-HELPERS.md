## Helpers
Los Helpers en Laravel son funciones globales que puedes usar en cualquier parte de tu aplicación. Laravel proporciona una serie de helpers predeterminados que facilitan tareas comunes, como trabajar con arreglos, rutas, URLs, y más. Además, puedes **crear tus propios helpers personalizados** para encapsular lógica repetitiva.

**Helpers Predeterminados**: Laravel incluye muchos helpers predeterminados. Aquí hay algunos ejemplos de los más comunes:

- **Array Helpers**:
  * `array_get()`: Obtiene un valor de un arreglo usando una notación de "punto".
  * `array_has()`: Verifica si un arreglo tiene una clave específica usando notación de "punto".
  * `array_pluck()`: Obtiene un arreglo de valores de una clave específica.

- **Path Helpers**:
  * `base_path()`: Obtiene la ruta base del proyecto.
  * `app_path()`: Obtiene la ruta del directorio app.
  * `config_path()`: Obtiene la ruta del directorio config.

- **URL/Route Helpers**:
  * `route()`: Genera una URL para una ruta nombrada.
  * `url()`: Obtiene la URL completa de una ruta.
  * `action()`: Obtiene la URL para una acción de controlador.

- **Miscellaneous Helpers**:
  * `env()`: Obtiene el valor de una variable de entorno.
  * `abort()`: Genera una excepción HTTP con un código de estado específico.
  * `dd()`: Hace un dump de la variable y termina la ejecución del script.
  * `csrf_token()`: Obtiene el token CSRF para formularios.

**Ejemplo de Uso de Helpers Predeterminados**
```php
// Uso de un helper de URL
$url = url('/home');

// Uso de un helper de array
$value = array_get($array, 'key');

// Uso de un helper misceláneo
dd($variable);
```

## Creación de Helpers Personalizados
Puedes definir tus propios helpers personalizados para encapsular lógica común.

1. **Crear el Archivo de Helpers**: Crea un archivo para tus helpers. Por convención, puedes colocarlo en el directorio `app/Helpers`.
```php
// app/Helpers/helpers.php
if (! function_exists('example_helper')) {
    function example_helper($param)
    {
        return "El parámetro es: " . $param;
    }
}
```
2. **Registrar los Helpers**: Para que Laravel cargue tus helpers personalizados, necesitas incluir el archivo de helpers en el archivo `composer.json` o cargarlo en el `AppServiceProvider`.

   - `composer.json`
   ```json
   "autoload": {
       "files": [
           "app/Helpers/helpers.php"
       ]
   }
   ```
   Luego, ejecuta el comando **`composer dump-autoload`** para actualizar el autoload.

   - **Usando `AppServiceProvider`**: Alternativamente, puedes cargar el archivo de helpers en el método boot del `AppServiceProvider`:
   ```php
   // app/Providers/AppServiceProvider.php
   public function boot()
   {
       require_once app_path('Helpers/helpers.php');
   }
   ```
3. **Usar el Helper Personalizado**: Ahora puedes usar tu helper personalizado en cualquier parte de tu aplicación.
```php
$result = example_helper('Hola, mundo!');
echo $result; // Output: El parámetro es: Hola, mundo!
```

**Ventajas de Usar Helpers**
* **Reutilización**: Encapsulan lógica común en una función que puedes reutilizar en múltiples lugares.
* **Legibilidad**: Ayudan a hacer tu código más legible y organizado.
* **Conveniencia**: Simplifican tareas comunes con una sintaxis más concisa