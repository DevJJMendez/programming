# Custom Command

Los comandos personalizados (Custom Commands) en Laravel son scripts de línea de comandos que puedes crear y ejecutar para realizar tareas específicas dentro de tu aplicación Laravel. Estos comandos personalizados son útiles para automatizar tareas recurrentes, realizar operaciones de mantenimiento, o ejecutar procesos específicos que no están cubiertos por los comandos integrados de Laravel.

- Crear un Comando:

Puedes generar un nuevo comando personalizado utilizando el comando Artisan make:command. Por ejemplo:

```bash
php artisan make:command miComando
```

Esto generará un nuevo archivo en la carpeta `app/Console/Commands`.

- Estructura:

```php
<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;

class CustomCommand extends Command
{
    protected $signature = 'custom:command';
    //  Esta es la cadena que se utiliza para invocar el comando desde la línea de comandos.


    protected $description = 'Descripción del comando';
    // Proporciona una breve descripción del comando. Esta descripción se mostrará cuando ejecutes php artisan list o php artisan help.

    public function handle()
    {
        // Aquí es donde colocas la lógica principal del comando. Todo lo que quieras que haga el comando debe estar dentro de este método.
        $this->info('Comando ejecutado con éxito.');
        return Command::SUCCESS;
    }
}

```
