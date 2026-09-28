## Observers
Los Observers en Laravel son clases que permiten agrupar el manejo de eventos del ciclo de vida de un modelo. Los Observers facilitan la gestión de múltiples eventos de un modelo en un solo lugar, promoviendo la organización y la reutilización del código.

**¿Para qué sirven?**

Los Observers son útiles cuando tienes varias acciones que necesitas realizar en respuesta a diferentes eventos del ciclo de vida de un modelo, como la creación, actualización o eliminación de registros. Usar Observers ayuda a mantener tu código más limpio y organizado.

**Creación de un Observer**: Puedes crear un Observer usando el comando Artisan:
```bash
php artisan make:observer UserObserver --model=User
```
Este comando creará un archivo `UserObserver.php` en el directorio `app/Observers`.

## Estructura
Un Observer contiene métodos que corresponden a los eventos del ciclo de vida del modelo. Aquí tienes un ejemplo de un Observer para el modelo User:
```php
namespace App\Observers;

use App\Models\User;

class UserObserver
{
    public function creating(User $user)
    {
        // Lógica antes de crear un usuario
    }

    public function created(User $user)
    {
        // Lógica después de crear un usuario
    }

    public function updating(User $user)
    {
        // Lógica antes de actualizar un usuario
    }

    public function updated(User $user)
    {
        // Lógica después de actualizar un usuario
    }

    public function deleting(User $user)
    {
        // Lógica antes de eliminar un usuario
    }

    public function deleted(User $user)
    {
        // Lógica después de eliminar un usuario
    }

    public function restoring(User $user)
    {
        // Lógica antes de restaurar un usuario
    }

    public function restored(User $user)
    {
        // Lógica después de restaurar un usuario
    }
}
```

## Registro
Para que Laravel sepa que debe utilizar un Observer para un modelo específico, necesitas registrarlo en el método `boot` del `EventServiceProvider`:
```php
namespace App\Providers;

use Illuminate\Support\ServiceProvider;
use App\Models\User;
use App\Observers\UserObserver;

class EventServiceProvider extends ServiceProvider
{
    public function boot()
    {
        User::observe(UserObserver::class);
    }
}
```

## Ejemplo
Vamos a ver un ejemplo completo de cómo implementar un Observer para el modelo User que ejecuta ciertas acciones antes y después de crear, actualizar y eliminar usuarios.

- `UserObserver.php`
```php
namespace App\Observers;

use App\Models\User;
use Illuminate\Support\Facades\Log;

class UserObserver
{
    public function creating(User $user)
    {
        Log::info('Creando usuario: ' . $user->name);
    }

    public function created(User $user)
    {
        Log::info('Usuario creado: ' . $user->name);
    }

    public function updating(User $user)
    {
        Log::info('Actualizando usuario: ' . $user->name);
    }

    public function updated(User $user)
    {
        Log::info('Usuario actualizado: ' . $user->name);
    }

    public function deleting(User $user)
    {
        Log::info('Eliminando usuario: ' . $user->name);
    }

    public function deleted(User $user)
    {
        Log::info('Usuario eliminado: ' . $user->name);
    }

    public function restoring(User $user)
    {
        Log::info('Restaurando usuario: ' . $user->name);
    }

    public function restored(User $user)
    {
        Log::info('Usuario restaurado: ' . $user->name);
    }
}
```
**Ventajas de usar Observers**
* **Organización**: Mantiene la lógica relacionada con eventos de modelo en un solo lugar.
* **Reutilización**: Puedes reutilizar los Observers en diferentes partes de tu aplicación.
* **Mantenimiento**: Facilita el mantenimiento y la escalabilidad de tu código.

## Observers vs Listeners
tanto los Listeners como los Observers en Laravel se utilizan para manejar eventos, pero hay diferencias clave en su propósito y uso que los distinguen. Vamos a explorar estas diferencias:

**Listeners**
* **Propósito**
  * Los Listeners se utilizan para manejar eventos genéricos que pueden ocurrir en cualquier parte de la aplicación. Estos eventos no están necesariamente ligados a un modelo específico.
  
  * Se enfocan en tareas que responden a eventos globales en la aplicación.

* **Uso**
  * Generalmente se crean para eventos personalizados o eventos del sistema que no están directamente relacionados con el ciclo de vida de un modelo.

  * Puedes tener múltiples listeners para un solo evento, lo que permite ejecutar varias acciones en respuesta a un mismo evento.

* **Ejemplo**
  * Un listener que envía un correo electrónico cuando se dispara un evento de orden enviada (OrderShipped):
    ```php
    namespace App\Listeners;

    use App\Events\OrderShipped;
    use Illuminate\Support\Facades\Mail;
    use App\Mail\OrderShippedMail;

    class SendShipmentNotification
    {
        public function handle(OrderShipped $event)
        {
            Mail::to($event->order->user)->send(new OrderShippedMail($event->order));
        }
    }
    ```

**Observers**
  * Propósito
Los Observers están específicamente diseñados para observar y manejar los eventos del ciclo de vida de un **modelo**.
  
  * Se enfocan en la lógica relacionada con las operaciones de **CRUD** de un modelo específico.

* **Uso**
  * Se crean para manejar eventos del ciclo de vida de un modelo, como creating, updating, deleting, etc.

  * Un Observer puede gestionar varios eventos del ciclo de vida de un modelo en una sola clase, proporcionando una forma organizada de manejar esta lógica.