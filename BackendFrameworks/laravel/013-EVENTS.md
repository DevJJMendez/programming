## Events
Un Event es una clase que representa una acción o situación que ha ocurrido en tu aplicación. Por otro lado, un **Listener** es una clase que "**escucha**" estos eventos y ejecuta una lógica en respuesta.

**Flujo de los Events**
* **Definición del Evento**: Primero, defines un evento.

* **Emisión del Evento**: El evento es disparado en alguna parte de tu aplicación.

* **Definición del Listener**: Luego defines uno o más listeners para el evento.

* **Registro del Listener**: Registras el listener para que escuche el evento.

* **Ejecución del Listener**: Cuando el evento es disparado, los listeners correspondientes se ejecutan.

**Creación de Events y Listeners**: Puedes crear eventos y listeners usando el comando **artisan**:
```bash
php artisan make:event OrderShipped
php artisan make:listener SendShipmentNotification --event=OrderShipped
```
Se generará archivos en las carpetas `app/Events` y `app/Listeners`.

## Event
```php
namespace App\Events;

use App\Models\Order;
use Illuminate\Queue\SerializesModels;
use Illuminate\Foundation\Events\Dispatchable;
use Illuminate\Broadcasting\InteractsWithSockets;
use Illuminate\Contracts\Broadcasting\ShouldBroadcast;

class OrderShipped
{
    use Dispatchable, InteractsWithSockets, SerializesModels;

    public $order;

    public function __construct(Order $order)
    {
        $this->order = $order;
    }
}
```
* `Dispatchable`: Este trait proporciona el método dispatch que se utiliza para disparar (lanzar) el evento. Permite que la clase del evento se utilice de manera similar a una fachada, permitiendo la creación y despacho del evento de manera concisa.

* `InteractsWithSockets`: Este trait proporciona métodos útiles para interactuar con conexiones de sockets. Puede ser útil en aplicaciones que utilizan Laravel Echo y WebSockets.

* `SerializesModels`: Este trait permite que los modelos Eloquent sean serializados y deserializados cuando el evento se transmite a través de la red (por ejemplo, cuando se utiliza Laravel Echo y canales).

* `__construct()`: En el constructor se pueden establecer datos necesarios para el evento.

## Listener
```php
namespace App\Listeners;

use App\Events\OrderShipped;
use Illuminate\Contracts\Queue\ShouldQueue;
use Illuminate\Queue\InteractsWithQueue;
use Illuminate\Support\Facades\Mail;

class SendShipmentNotification
{
    public function __construct(){}

    public function handle(OrderShipped $event)
    {
        Mail::to($event->order->user)->send(new OrderShippedMail($event->order));
    }
}
```
* `__construct()`: En el constructor se pueden establecer configuraciones iniciales necesarias para el listener.

* `handle()`: El método handle es donde se establece la lógica específica que debe ejecutarse cuando el evento asociado al listener es disparado. Toma un parámetro $event, que representa la instancia del evento que fue disparado.


## Registro del Listener
En el archivo `app\Providers\EventServiceProvider.php`, registras tus eventos y listeners:
```php
class EventServiceProvider extends ServiceProvider
{
    protected $listen = [
        OrderShipped::class=> [
          SendShipmentNotification::class,
      ],
    ];

    public function boot(){}

    public function shouldDiscoverEvents(){}
}
```
* `$listen`: Esta propiedad define la relación entre eventos y sus listeners. Cada evento registrado en el sistema tiene asociado uno o más listeners que se ejecutarán cuando se dispare ese evento. La estructura es un array donde las claves son los eventos y los valores son arrays de listeners asociados a ese evento.

* `boot()`: Este método heredado de la clase base ServiceProvider se llama durante el proceso de inicio de la aplicación. Laravel proporciona el método boot para que puedas realizar cualquier configuración adicional relacionada con eventos y listeners. 
  
  Dentro de este método, se llama al método `parent::boot()`, que realiza algunas configuraciones básicas. Luego, puedes agregar lógica personalizada si es necesario.

* `shouldDiscoverEvents()`: se utiliza para indicar si el sistema de descubrimiento automático de eventos debe estar habilitado o deshabilitado. La descubierta automática de eventos permite a Laravel buscar automáticamente eventos y listeners en el directorio `app/Listeners` y `app/Events` de tu aplicación.
  
  Cuando la función `shouldDiscoverEvents()` devuelve true, Laravel intentará automáticamente descubrir eventos y listeners en esos directorios y registrarlos. Esto puede ser útil en aplicaciones más grandes donde mantener manualmente la relación entre eventos y listeners en el **EventServiceProvider** puede ser una tarea tediosa.

## Emisión del Evento
Puedes disparar el evento en cualquier parte de tu aplicación usando el helper `event` o el método `dispatch`:
```php
event(new OrderShipped($order));

// o

OrderShipped::dispatch($order);
```

## Ejemplo
Se creará un evento que registre una **factura** una vez se haya realizado una **orden**

- `Event`
```php
class CreateOrderEvent
{
    use Dispatchable, InteractsWithSockets, SerializesModels;

    public function __construct(public $order){}
}
```

- `Register`
```php
class EventServiceProvider extends ServiceProvider {

    protected $listen = [
            CreateOrderEvent::class => [
                GenerateInvoiceListener::class,
            ],
        ];
}
```

- `Controller`
```php
class OrderController extends Controller
{
    public function create()
    {
        $order = Order::create([
            'user_id' => 10,
            'amount' => 25
        ]);

        CreateOrderEvent::dispatch($order);
        return response()->json("Succesfull");
    }
}
```

- `Listener`
```php
class GenerateInvoiceListener
{
    public function handle(CreateOrderEvent $event)
    {
        Invoice::create([
            'amount' => $event->order->amount,
            'order_id' => $event->order->id
        ]);
    }
}
```

### Ciclo de Vida de un Modelo
Los Model Events son eventos que se disparan durante el ciclo de vida de un modelo en Laravel. 

1. `retrieved`: Después de recuperar un registro de la base de datos.
2. `creating`: Antes de crear un nuevo registro.
3. `created`: Después de crear un nuevo registro.
4. `updating`: Antes de actualizar un registro existente.
5. `updated`: Después de actualizar un registro existente.
6. `saving`: Antes de guardar un registro (tanto en la creación como en la actualización).
7. `saved`: Después de guardar un registro (tanto en la creación como en la actualización).
8. `deleting`: Antes de eliminar un registro.
9. `deleted`: Después de eliminar un registro.
10. `restoring`: Antes de restaurar un registro blandeado.
11. `restored`: Después de restaurar un registro blandeado.