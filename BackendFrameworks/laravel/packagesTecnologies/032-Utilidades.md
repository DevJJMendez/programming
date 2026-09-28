# Paginacion

La paginación es una técnica utilizada en desarrollo web para dividir grandes conjuntos de datos en páginas más pequeñas y manejables. Esto mejora la experiencia del usuario, ya que no tiene que cargar todos los datos a la vez, especialmente útil cuando se trata de listas extensas de resultados.

En el contexto de Laravel, el framework PHP, la paginación se facilita mediante el uso del Eloquent ORM y las funcionalidades integradas del framework.

Ejemplo:

```php
class UserController extends Controller
{
    public function index()
    {
        $users = User::paginate(20);
        return view('welcome', compact('users'));
    }
}
```

En la vista:

```php
<ul class="list-group">
        @forelse ($users as $user)
        <li class="list-group-item">Id: {{$user->id}}</li>
        <li class="list-group-item">Name: {{$user->name}}</li>
        <li class="list-group-item">Email: {{$user->email}}</li>
        <br>
        @empty
        <li class="list-group-item">No data found</li>
        @endforelse
      </ul>
      {{ $users->links() }}
```

---

Personalizar la Apariencia de los Enlaces:
Puedes personalizar la apariencia de los enlaces de paginación utilizando las vistas predeterminadas o creando tus propias vistas.

Para personalizar las vistas predeterminadas, puedes ejecutar el siguiente comando:

```bash
php artisan vendor:publish --tag=laravel-pagination
```

Esto copiará las vistas de paginación a tu directorio `resources/views/vendor/pagination`.

---

# Paginacion mediante API

```php
class UserController extends Controller
{
    public function index()
    {
        return User::paginate(20);
    }
}
```

---

# Buscando registros con un buscador

Este ejemplo buscara el usuario con el nombre

```php
// Ruta
Route::get('/search', [UserController::class, 'search'])->name('search');
Route::post('/search', [UserController::class, 'searchUser'])->name('search-users');

// Controlador
public function search()
    {
        return view('search');
    }
    public function searchUser(Request $request)
    {
        $users = User::where('name', $request->name)->get();
        return view('welcome', compact('users'));
    }
// Vista POST
<form method="POST" action="{{ route('search-users') }}">
        @csrf
        <div class="mb-3">
          <input type="text" name="name" class="form-control"  aria-describedby="emailHelp" placeholder="Search users">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
      </form>
// Vista con resultados
<ul class="list-group">
        @forelse ($users as $user)
        <li class="list-group-item">Id: {{$user->id}}</li>
        <li class="list-group-item">Name: {{$user->name}}</li>
        <li class="list-group-item">Email: {{$user->email}}</li>
        <br>
        @empty
        <li class="list-group-item">No data found</li>
        @endforelse
      </ul>
```

- Usando **LIKE**

```php
public function searchUser(Request $request)
    {
        $users = User::where('name', 'LIKE', '%' . $request->name . '%')->get();
        return view('welcome', compact('users'));
    }
```

los comodines **%** se utilizan junto con la cláusula **LIKE** para realizar búsquedas de patrones en una columna de texto. Los comodines % representan cualquier conjunto de caracteres (cero o más caracteres) en una cadena.

- Búsqueda de Cadenas que Comienzan con un Patrón:

```php
SELECT * FROM users WHERE name LIKE 'John%';
```

Esta consulta recuperará todas las filas de la tabla users donde el nombre comienza con "John".

- Búsqueda de Cadenas que Terminan con un Patrón:

```php
SELECT * FROM users WHERE email LIKE '%example.com';
```

Esta consulta recuperará todas las filas de la tabla users donde el correo electrónico termina con "example.com".

- Búsqueda de Cadenas que Contienen un Patrón en Cualquier Lugar:

```php
SELECT * FROM users WHERE address LIKE '%Street%';
```

Esta consulta recuperará todas las filas de la tabla users donde la dirección contiene la palabra "Street" en cualquier lugar de la cadena.

- Búsqueda de Cadenas que Coinciden con un Patrón Específico:

```php
SELECT * FROM users WHERE username LIKE 'user%name';
```

Esta consulta recuperará todas las filas de la tabla users donde el nombre de usuario comienza con "user" y termina con "name".
