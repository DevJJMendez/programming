### Seeders
Los Seeders en Laravel son clases que se utilizan para poblar las tablas de la base de datos con datos de prueba o datos iniciales. Esto es especialmente útil para el desarrollo y las pruebas, ya que permiten crear un conjunto de datos consistente y conocido que puede ser utilizado en diferentes entornos.

### Creación de Seeders
Para crear un Seeder, se usa el comando `make:seeder` de **Artisan**. 
```bash
php artisan make:seeder UsersSeeder
```
Esto generará una clase de Seeder en el directorio `database/seeders`.

### Estructura de un Seeder
Un Seeder básico se verá así:
```php
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;

class UserSeeder extends Seeder
{
    public function run()
    {
        // Métodos de creación de datos
        DB::table('users')->insert([
            'name' => Str::random(10),
            'email' => Str::random(10).'@example.com',
            'password' => Hash::make('password'),
        ]);
        User::create([
            'name' => Str::random(10),
            'email' => Str::random(10).'@example.com',
            'password' => Hash::make('password'),
        ])
    }
}
```
### DatabaseSeeder
Laravel crea automáticamente un Seeder principal llamado `DatabaseSeeder` que se encuentra en `database/seeders/DatabaseSeeder.php`. Este Seeder se utiliza para llamar a otros Seeders. Un ejemplo de cómo se ve este archivo:
```php
use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    public function run()
    {
        $this->call([
            UserSeeder::class,
            // Otros Seeders...
        ]);
    }
}
```
Al agregar el Seeder `UserSeeder` a la llamada `$this->call`, aseguras que se ejecute cuando se ejecute DatabaseSeeder.

#### Ejecutando Seeders
Para ejecutar los Seeders, se utiliza el comando `db:seed` de **Artisan**:
```bash
php artisan db:seed
```
Esto ejecutará todos los Seeders registrados en `DatabaseSeeder`.

### Seeders con Factories
Una práctica común es utilizar Factories en combinación con Seeders para generar **grandes cantidades de datos** de prueba. Las Factories definen cómo deben generarse los datos para un modelo. Un ejemplo de uso de Factories en un Seeder:

Primero, crea una **Factory** si no tienes una:
```php
php artisan make:factory UserFactory --model=User
```
Esto creará la Factory en `database/factories/UserFactory.php`:
```php
use App\Models\User;
use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Str;

class UserFactory extends Factory
{
    protected $model = User::class;

    public function definition()
    {
        return [
            'name' => $this->faker->name,
            'email' => $this->faker->unique()->safeEmail,
            'email_verified_at' => now(),
            'password' => Hash::make('password'),
            'remember_token' => Str::random(10),
        ];
    }
}
```
Luego, utiliza esta Factory en tu Seeder:
```php
use Illuminate\Database\Seeder;
use App\Models\User;

class UserSeeder extends Seeder
{
    public function run()
    {
        User::factory()->count(50)->create();
    }
}
```
Este Seeder creará 50 usuarios usando la Factory definida.

### Ejecución de Seeders en Conjunto
A veces, puede ser útil ejecutar Seeders junto con migraciones para asegurar que la base de datos esté en un estado conocido con datos iniciales. Esto se puede hacer con el comando `migrate:fresh --seed`:
```bash
php artisan migrate:fresh --seed
```
Este comando primero borrará todas las tablas y migrará las migraciones, luego ejecutará los Seeders.

## Faker
La clase Faker en Laravel es una biblioteca de PHP utilizada para generar datos de prueba falsos. Es una herramienta muy útil para poblar bases de datos con datos realistas en tus pruebas y en el desarrollo. Faker ofrece una amplia variedad de métodos para generar datos que simulan información del mundo real.

Faker está incluido en Laravel por defecto, por lo que no necesitas instalarlo por separado. Para usarlo en tus Factories, simplemente utiliza la propiedad `$faker` proporcionada por Laravel:
```php
use Faker\Generator as Faker;

class UserFactory extends Factory
{
    public function definition()
    {
        return [
            'name' => $this->faker->name,
            'email' => $this->faker->unique()->safeEmail,
            'password' => bcrypt('password'),
        ];
    }
}
```

**Principales Métodos de Faker**

1. **Generación de Nombre y Apellidos**
    ```php
    $faker->name;          // Genera un nombre completo.
    $faker->firstName;    // Genera un primer nombre.
    $faker->lastName;     // Genera un apellido.
    $faker->title;        // Genera un título (e.g., "Mr.", "Ms.", "Dr.").

    $faker->name();       // Ejemplo: "John Doe"
    $faker->firstName();  // Ejemplo: "John"
    $faker->lastName();   // Ejemplo: "Doe"
    $faker->title();      // Ejemplo: "Mr."
    ```
2. **Generación de Correos Electrónicos y Teléfonos**
    ```php
    $faker->email;        // Genera un correo electrónico.
    $faker->unique()->safeEmail; // Genera un correo único y seguro.
    $faker->phoneNumber;  // Genera un número de teléfono.
    $faker->cellPhoneNumber; // Genera un número de teléfono móvil.

    $faker->email();            // Ejemplo: "john.doe@example.com"
    $faker->unique()->safeEmail(); // Ejemplo: "jane.doe@example.com"
    $faker->phoneNumber();     // Ejemplo: "(555) 555-5555"
    $faker->cellPhoneNumber(); // Ejemplo: "+1 (555) 555-5555"
    ```

3. **Generación de Direcciones**
    ```php
    $faker->address;        // Genera una dirección.
    $faker->city;           // Genera una ciudad.
    $faker->state;          // Genera un estado o provincia.
    $faker->postcode;       // Genera un código postal.
    $faker->country;        // Genera un país.

    $faker->address();      // Ejemplo: "123 Main St, Anytown, CA 12345"
    $faker->city();         // Ejemplo: "Anytown"
    $faker->state();        // Ejemplo: "CA"
    $faker->postcode();     // Ejemplo: "12345"
    $faker->country();      // Ejemplo: "United States"
    ```

4. **Generación de Fechas y Horarios**
    ```php
    $faker->date;          // Genera una fecha.
    $faker->dateTime;     // Genera una fecha y hora.
    $faker->dateTimeBetween($startDate = '-1 year', $endDate = 'now', $timezone = null); // Genera una fecha entre dos fechas.

    $faker->date();       // Ejemplo: "2024-07-15"
    $faker->dateTime();  // Ejemplo: "2024-07-15 10:00:00"
    $faker->dateTimeBetween('-1 year', 'now'); // Ejemplo: "2023-08-10 14:23:15"
    ```

5. **Generación de Textos y Parrafos**
    ```php
    $faker->text;          // Genera un texto de un párrafo.
    $faker->paragraph;    // Genera un párrafo.
    $faker->sentence;     // Genera una oración.

    $faker->text();       // Ejemplo: "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    $faker->paragraph(); // Ejemplo: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vehicula, elit eget dapibus."
    $faker->sentence();  // Ejemplo: "Lorem ipsum dolor sit amet."
    ```

6. **Generación de Datos Aleatorios**
    ```php
    $faker->randomNumber; // Genera un número aleatorio.
    $faker->randomElement($array); // Elige un elemento aleatorio de un array.
    $faker->boolean;     // Genera un valor booleano aleatorio.
    $faker->word;        // Genera una palabra aleatoria.
    $faker->uuid;        // Genera un UUID único.

    $faker->randomNumber(); // Ejemplo: 123456
    $faker->randomElement(['apple', 'banana', 'cherry']); // Ejemplo: "banana"
    $faker->boolean();     // Ejemplo: true o false
    $faker->word();        // Ejemplo: "example"
    $faker->uuid();        // Ejemplo: "e2a2c4fc-8cf4-4ccf-8230-c6f52d3be74e"
    ```

7. **Generación de Imágenes y Avatares**
    ```php
    $faker->imageUrl;  // Genera una URL de imagen.
    $faker->image;     // Genera una imagen de prueba en el disco.

    $faker->imageUrl(); // Ejemplo: "https://via.placeholder.com/150"
    $faker->image(storage_path('app/public'), 640, 480, null, false); // Crea una imagen en el disco.
    ```

8. **Generación de Datos de Texto en Otros Idiomas**
    ```php
    $faker->locale;     // Establece el idioma para los datos.
    $faker->text($maxNbChars = 200, $indexSize = 1); // Texto en el idioma definido.

    $faker->locale = 'es_ES'; // Cambiar el idioma a español.
    $faker->text(); // Ejemplo: "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    ```

**Ejemplo de uso**
```php
use Faker\Generator as Faker;

class UserFactory extends Factory
{
    public function definition()
    {
        return [
            'name' => $this->faker->name,
            'email' => $this->faker->unique()->safeEmail,
            'email_verified_at' => now(),
            'password' => $this->faker->password, // Usar un password aleatorio
            'remember_token' => Str::random(10),
            'phone_number' => $this->faker->phoneNumber,
            'address' => $this->faker->address,
            'profile_picture' => $this->faker->imageUrl(640, 480, 'people'),
        ];
    }
}
```