# File Storage

En el directorio `storage` tendremos todos los ficheros que estaremos almacenando en nuestro sistema.

- en `storage\app\public` es donde almacenaremos todos los ficheros que luego podran ser accedidos en nuestro sistema.

- en el directorio `public` es donde podremos vincular los elementos que tenemos en el `storage\app\public` para que puedan ser accedidos.

- en el directorio `config\app.php\filesystems.php` contiene la configuracion sobre como nuestra app laravel debe almacenar los diferentes ficheros en el sistema. Por defecto guardara los ficheros en local:

```php
<?php

return [

    /*
    |--------------------------------------------------------------------------
    | Default Filesystem Disk
    |--------------------------------------------------------------------------
    |
    | Here you may specify the default filesystem disk that should be used
    | by the framework. The "local" disk, as well as a variety of cloud
    | based disks are available to your application. Just store away!
    |
    */

    'default' => env('FILESYSTEM_DISK', 'local'),

    /*
    |--------------------------------------------------------------------------
    | Filesystem Disks
    |--------------------------------------------------------------------------
    |
    | Here you may configure as many filesystem "disks" as you wish, and you
    | may even configure multiple disks of the same driver. Defaults have
    | been set up for each driver as an example of the required values.
    |
    | Supported Drivers: "local", "ftp", "sftp", "s3"
    |
    */

// Indica donde se deben guardar los ficheros en local, en este caso app\public
    'disks' => [

        'local' => [
            'driver' => 'local',
            'root' => storage_path('app'),
            'throw' => false,
        ],
        'public' => [
            'driver' => 'local',
            'root' => storage_path('app/public'),
            'url' => env('APP_URL').'/storage',
            'visibility' => 'public',
            'throw' => false,
        ],



        /*
    |--------------------------------------------------------------------------
    | Symbolic Links
    |--------------------------------------------------------------------------
    |
    | Here you may configure the symbolic links that will be created when the
    | `storage:link` Artisan command is executed. The array keys should be
    | the locations of the links and the values should be their targets.
    |
    */

// Estos links permitiran enlazar el directorio public con storage\app\public
    'links' => [
        public_path('storage') => storage_path('app/public'),
    ],
];
```

Por buenas practicas en nuestro archivo `.env` debemos extraer todas la modificaciones de entorno, es decir no realizaremos los cambios directamente en el archivo `filesystems.php` en vez de esto, los cambios los haremos en la variables de entorno contenidas en `.env`

```php

// FILESYSTEM_DISK es la variable de entorno que esta en .env el cual contiene la configuracion.
  'default' => env('FILESYSTEM_DISK', 'local'),
```

en el archivo `.env` estableremos cual sistema usaremos para el almacenamiento.

```php
FILESYSTEM_DISK="local"
FILESYSTEM_DISK="ftp"
FILESYSTEM_DISK="s3"
```
