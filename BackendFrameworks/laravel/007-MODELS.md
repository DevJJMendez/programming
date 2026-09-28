### Modelos

los modelos representan la capa de la aplicación que se encarga de interactuar con la base de datos. Son clases PHP que se utilizan para acceder y gestionar los datos almacenados en la base de datos. Proporcionan una interfaz para realizar operaciones de lectura, escritura, actualización y eliminación de datos en la base de datos.

### Carateristicas

- **Representación de tablas de la base de datos**: Cada modelo se asocia con una tabla específica en la base de datos. Por ejemplo, si tienes una tabla users, podrías tener un modelo llamado User que represente y maneje los datos de esa tabla.

- **Interacción con la base de datos**: Los modelos ofrecen métodos para realizar operaciones de base de datos, como insertar registros, actualizar datos, eliminar registros y realizar consultas complejas utilizando el ORM (Mapeo Objeto-Relacional) incorporado en Laravel, como Eloquent.

- **Relaciones entre tablas**: Los modelos permiten definir y trabajar con relaciones entre diferentes tablas de la base de datos, como relaciones uno a uno, uno a muchos y muchos a muchos, utilizando métodos proporcionados por Eloquent, lo que simplifica la manipulación de datos relacionados.

- **Validación y lógica de negocio**: Los modelos también pueden incluir lógica de validación para garantizar la integridad de los datos antes de ser almacenados en la base de datos. Esto se puede hacer utilizando las reglas de validación proporcionadas por Laravel.

- **Abstracción de la base de datos**: Los modelos actúan como una capa de abstracción entre la lógica de la aplicación y la base de datos subyacente. Esto permite que la lógica de la aplicación no esté acoplada directamente a la estructura de la base de datos, lo que facilita la mantenibilidad y la evolución de la aplicación a medida que cambian los requisitos.

### Creación

**Convencion de nombre al crear modelos:**

- Primera letra en **mayuscula**
- Nombre en **singular**

```bash
php artisan make:model Flight
```

- **Opciones**
```bash
# Modelo y Migración
php artisan make:model Flight --migration
php artisan make:model Flight -m

php artisan make:model Flight --factory
php artisan make:model Flight -f
 
# Generate a model and a FlightSeeder class...
php artisan make:model Flight --seed
php artisan make:model Flight -s
 
# Generate a model and a FlightController class...
php artisan make:model Flight --controller
php artisan make:model Flight -c
 
# Generate a model, FlightController resource class, and form request classes...
php artisan make:model Flight --controller --resource --requests
php artisan make:model Flight -crR
 
# Generate a model and a FlightPolicy class...
php artisan make:model Flight --policy
 
# Generate a model and a migration, factory, seeder, and controller...
php artisan make:model Flight -mfsc
 
# Shortcut to generate a model, migration, factory, seeder, policy, controller, and form requests...
php artisan make:model Flight --all
 
# Generate a pivot model...
php artisan make:model Member --pivot
php artisan make:model Member -p
```


### Propiedades

estos campos son propiedades que se utilizan principalmente en los modelos Eloquent para definir el comportamiento y las características de los modelos en relación con la base de datos y la manipulación de datos.

- **`$table`**: Este campo se utiliza para especificar el nombre de la tabla de la base de datos asociada con el modelo. Si el nombre de la tabla no sigue la convención de nombres predeterminada (nombre del modelo en minúsculas y plural), puedes especificarlo explícitamente aquí.

```php
protected $table = 'mi_tabla';
```

- **`$fillable`**: Este campo se utiliza para especificar qué columnas se pueden llenar con datos utilizando la asignación en masa (mass assignment). Específicamente, permite definir qué campos pueden ser asignados en un create() o update() utilizando la propiedad **`create()`** o **`update()`** del modelo.

```php
protected $fillable = ['campo1', 'campo2'];
```

- **`$guarded`**: A diferencia de **`$fillable`**, `$guarded` especifica qué campos NO se pueden asignar en masa, lo que significa que estos campos están protegidos de la asignación en masa y no se pueden establecer con `create()` o `update()`.

```php
protected $guarded = ['campo3', 'campo4'];
```

- **`$casts`**: Esta propiedad permite especificar las conversiones de tipo de datos para atributos específicos del modelo. Por ejemplo, si un campo de la base de datos es un JSON, puedes castearlo a un array automáticamente cuando se accede a través del modelo.

```php
protected $casts = [
    'campo_json' => 'array',
    'campo_booleano' => 'boolean',
];
```

- **`$hidden`**: Se utiliza para especificar los atributos del modelo que no se deben incluir en las respuestas JSON al acceder al modelo. Es útil para ocultar información sensible.

```php
protected $hidden = ['campo_secreto', 'password'];
```

- **`$primaryKey`**: Utilizado para especificar el nombre de la columna de clave primaria si es diferente de id.

```php
protected $primaryKey = 'codigo';
```

- **`keyType`** = Se utiliza cuando la llave primaria del modelo no es de tipo **Integer**:
```php
protected $keyType = 'string';
```

- **`$timestamps`**: Se utiliza para indicar si el modelo debería tener habilitados los campos created_at y updated_at. Por defecto, se establece en true para registrar la fecha y hora de creación y actualización de los registros.

```php
public $timestamps = false; // Deshabilitar timestamps
```

- Personalizar los **timestamps**:
```php
class Flight extends Model
{
    const CREATED_AT = 'creation_date';
    const UPDATED_AT = 'updated_date';
}
```

- **`$incrementing`**: Indica si la clave primaria es autoincremental. Si la clave primaria no es autoincremental o es una cadena, se puede establecer en false.

```php
public $incrementing = false; // Si la clave primaria no es autoincremental
```

- **`$connection`**: Define la conexión de base de datos utilizada por el modelo. Es útil si tienes múltiples conexiones de bases de datos configuradas.

```php
protected $connection = 'conexion_personalizada';
```

- **`$dateFormat`**: Utilizado para definir el formato de fecha predeterminado para las columnas created_at y updated_at.

```php
protected $dateFormat = 'Y-m-d H:i:s';
```

- **`$perPage`**: Establece la cantidad predeterminada de elementos por página al usar paginación.

```php
protected $perPage = 10; // Establece 10 elementos por página
```