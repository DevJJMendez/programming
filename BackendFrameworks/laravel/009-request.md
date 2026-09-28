### Requests

En Laravel, las solicitudes HTTP (requests) juegan un papel crucial en la construcción de aplicaciones web. Laravel proporciona herramientas poderosas para manejar y validar solicitudes de manera efectiva. Vamos a explorar cómo trabajar con las solicitudes en Laravel, incluyendo validación, inyección de dependencias, y formularios.

### Solicitudes HTTP en Laravel

1. **Obteniendo Datos de la Solicitud**
   
Puedes obtener datos de una solicitud HTTP utilizando el objeto Request. Laravel inyecta automáticamente una instancia de `Illuminate\Http\Request` en tus controladores, middleware, y otros lugares donde necesites acceder a los datos de la solicitud.
```php
namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function store(Request $request)
    {
        $name = $request->input('name');
        $email = $request->input('email');

        // O directamente:
        $allData = $request->all();
    }
}
```
2. **Validación de Solicitudes**
   
Laravel proporciona una forma sencilla y robusta de validar solicitudes entrantes utilizando el método `validate` en el controlador o creando un **FormRequest**.
```php
public function store(Request $request)
{
    $validatedData = $request->validate([
        'name' => 'required|max:255',
        'email' => 'required|email|unique:users',
        'password' => 'required|min:8',
    ]);

    // Si la validación pasa, se ejecuta el siguiente código
}
```

### Form Request

En Laravel, las Form Requests son una herramienta poderosa y conveniente para la validación de solicitudes HTTP entrantes. Las Form Requests encapsulan la lógica de validación y autorización, haciéndola reutilizable y más organizada.

1. **Creación**

**Reglas de convención**
- CamelCase
- Nombre de la acción o metodo: `Store`, `Update`, etc.
- Nombre del modelo.
- Finalizar con la palabra **Request**
```bash
php artisan make:request StoreUSerRequest
```
Esto generará un archivo en app/Http/Requests llamado `StoreUserRequest.php`.

2. **Estructura de una Form Request**: El archivo generado se verá así:
```php
namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class StoreUserRequest extends FormRequest
{
    // Determina si el usuario está autorizado para hacer esta solicitud
    public function authorize()
    {
        return true;
    }

    // Reglas de validación para esta solicitud
    public function rules()
    {
        return [
            'name' => 'required|max:255',
            'email' => 'required|email|unique:users',
            'password' => 'required|min:8',
        ];
    }
}
```
3. **Autorización**: El método `authorize` determina si el usuario está autorizado para hacer esta solicitud. Puedes agregar lógica para verificar permisos o roles del usuario actual.
```php
public function authorize()
{
    return auth()->user()->isAdmin(); // Ejemplo de autorización basada en roles
}
```
4. Reglas de Validación: El método `rules` define las reglas de validación para los datos de la solicitud. Puedes utilizar todas las reglas de validación disponibles en Laravel.
```php
public function rules()
{
    return [
        'name' => 'required|max:255',
        'email' => 'required|email|unique:users',
        'password' => 'required|min:8|confirmed',
    ];
}
```
5. **Mensajes de Error Personalizados**: Puedes personalizar los mensajes de error agregando el método messages a la **Form Request**.
```php
public function messages()
{
    return [
        'name.required' => 'El nombre es obligatorio.',
        'email.required' => 'El correo electrónico es obligatorio.',
        'email.email' => 'Debe ser una dirección de correo electrónico válida.',
        'password.required' => 'La contraseña es obligatoria.',
        'password.confirmed' => 'Las contraseñas no coinciden.',
    ];
}
```
Para retornar estos mensaje de error podemos usar la directiva `@error()`
```php
@error('name')
    <div class="alert alert-danger">{{ $message }}</div>
@enderror
```
6. **Usando Form Requests en Controladores**: Para usar la Form Request en un controlador, simplemente injéctala en el método del controlador. Laravel automáticamente ejecutará la validación antes de que el código del controlador se ejecute.
```php
namespace App\Http\Controllers;

use App\Http\Requests\StoreUserRequest;

class UserController extends Controller
{
    public function store(StoreUserRequest $request)
    {
        // El $request ya está validado
        $validated = $request->validated();

        // Crear el usuario
        User::create($validated);

        return redirect()->route('users.index')->with('success', 'Usuario creado exitosamente.');
    }
}
```

### Método `only()`

En Laravel, la clase Request proporciona varios métodos útiles para manejar y manipular los datos de las solicitudes entrantes. Entre ellos, los métodos `only` y `except` son muy útiles para obtener subconjuntos específicos de los datos de la solicitud. 

**Método only**: El método **only** se utiliza para obtener solo los campos especificados de la solicitud. Devuelve un array con los valores de los campos indicados.
```php
$request->only(['field1', 'field2']);
```
**Ejemplo de Uso:** Supongamos que tienes una solicitud con los siguientes datos:
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "secret",
    "age": 30
}
```
Y quieres obtener solo los campos **name** y **email**.
```php
use Illuminate\Http\Request;

public function store(Request $request)
{
    $data = $request->only(['name', 'email']);
    // $data contendrá ['name' => 'John Doe', 'email' => 'john@example.com']
}
```
Este método es útil cuando quieres trabajar solo con un subconjunto de los datos de la solicitud, por ejemplo, cuando necesitas pasar solo ciertos campos a un modelo o a una función.

### Método `except()`
El método **except** se utiliza para obtener todos los campos de la solicitud, excepto los especificados. Devuelve un array con los valores de los campos que no están en la lista proporcionada.
```php
$request->except(['field1', 'field2']);
```
**ejemplo**
```php
use Illuminate\Http\Request;

public function store(Request $request)
{
    $data = $request->except(['password']);
    // $data contendrá ['name' => 'John Doe', 'email' => 'john@example.com', 'age' => 30]
}
```
Este método es útil cuando quieres excluir ciertos campos sensibles o innecesarios antes de procesar los datos.