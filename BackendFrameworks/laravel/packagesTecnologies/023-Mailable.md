# Mailable

En Laravel, Mailables son clases dedicadas a la creación y envío de correos electrónicos. Facilitan la creación de correos electrónicos bien estructurados y permiten enviar mensajes de manera más elegante y sencilla.

## Pasos para usar Mailables en Laravel:

- Generación de un Mailable:

Puedes generar un Mailable usando el siguiente comando Artisan:

```bash
php artisan make:mail NombreDelMailable
```

Esto creará un nuevo archivo en el directorio `app/Mail`.

- Estructura:

```php
use Illuminate\Mail\Mailables\Envelope;
use Illuminate\Mail\Mailables\Content;

class ExampleMail extends Mailable
{
    use Queueable, SerializesModels;

    public function __construct()
    {
        // Constructor, actualmente sin lógica específica
    }

    public function envelope()
    {
        // Retorna una instancia de Envelope para personalizar el sobre del correo
        return new Envelope(
            subject: 'Example Mail', // Asunto del correo
        );
    }

    public function content()
    {
        // Retorna una instancia de Content para definir la vista del correo
        return new Content(
            view: 'view.name', // Nombre de la vista Blade
        );
    }


    public function attachments()
    {
        // Retorna un array de archivos adjuntos (actualmente ninguno)
        return [];
    }
}

```

- `__construct()`: Este es el constructor de la clase. Actualmente, no tiene ninguna lógica específica. En algunos casos, puedes utilizar el constructor para recibir datos que luego se utilizarán en otros métodos de la clase.

- `envelope()`: Este método devuelve una instancia de la clase **Envelope**. El objeto **Envelope** se utiliza para personalizar aspectos del correo, como el asunto. Aquí has establecido el asunto del correo como "_Example Mail_".

  - **subject**: Define el asunto del correo electrónico.

  - **from**: Establece la dirección de correo electrónico del remitente.

  - **to**: Establece la dirección de correo electrónico del destinatario.

  - **cc**: Define las direcciones de correo electrónico que deben recibir copias del correo (CC).

  - **bcc**: Define las direcciones de correo electrónico que deben recibir copias ocultas del correo (BCC).

  - **replyTo**: Establece la dirección de correo electrónico a la que se debe enviar la respuesta al correo.

  - **priority**: Define la prioridad del correo electrónico. Puede ser "high", "normal" o "low".

  - **attachments**: Permite adjuntar archivos al correo electrónico.

```php
use Illuminate\Mail\Mailables\Envelope;

public function envelope()
{
    return new Envelope([
        'subject' => 'Ejemplo de Correo',
        'from' => ['address' => 'correo@dominio.com', 'name' => 'Remitente'],
        'to' => 'destinatario@dominio.com',
        'cc' => ['copiacarbon@dominio.com'],
        'bcc' => ['copiaoculta@dominio.com'],
        'replyTo' => 'responder@dominio.com',
        'priority' => 'high', // o 'normal', 'low'
        // Puedes agregar más configuraciones según tus necesidades
    ]);
}
```

---

- `content()`: Este método devuelve una instancia de la clase Content. El objeto Content se utiliza para definir la vista del correo.

- `attachments()`: Este método devuelve un array de archivos adjuntos. Actualmente, no se están adjuntando archivos.
