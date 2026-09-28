### Migraciones

las migraciones son una forma de controlar y gestionar la estructura de la base de datos de una manera versionada y consistente.

Las migraciones son archivos de código que contienen instrucciones en lenguaje específico para la base de datos (generalmente SQL o una capa de abstracción de base de datos proporcionada por el framework) para crear, modificar o eliminar tablas y columnas en la base de datos.

- **Control de versiones de la base de datos**: Las migraciones permiten a los desarrolladores mantener un control de versiones sobre la estructura de la base de datos. Cada migración representa un cambio incremental en la base de datos.

- **Facilidad para trabajar en equipo**: Al compartir migraciones con el equipo de desarrollo, cada miembro puede aplicar y revertir los cambios de la base de datos de manera consistente en sus entornos locales.

- **Reversión de cambios**: Las migraciones también permiten revertir los cambios en la estructura de la base de datos. Esto es útil durante el desarrollo para deshacer o modificar cambios en la estructura de la base de datos.

- **Esquema controlado por código**: Las migraciones se escriben utilizando código, lo que facilita su mantenimiento y comprensión. Además, el código de migración se puede almacenar en el control de versiones junto con el código fuente de la aplicación.

- **Consistencia entre entornos**: Al usar migraciones, se asegura que la estructura de la base de datos sea consistente entre los entornos de desarrollo, pruebas y producción.

### Crear una Migración

**Convension de nombres al crear migraciones:**

- comenzar por la palabra **create**
- nombre la tablas en **plural**
- finalizar con **table**
  
```bash
php artisan make:migration create_users_table
```

Esto creará un nuevo archivo de migración en el directorio `database/migrations`.

### Estructura

Al crear una migración, Laravel genera una clase con dos métodos: `up` y `down`.

- **Método `up`**: Define los cambios que se aplicarán a la base de datos (creación de tablas, columnas, índices, etc.).
  
- **Método `down`**: Define cómo revertir los cambios realizados en el método up.

**Ejemplo**
```php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateUsersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->string('email')->unique();
            $table->timestamp('email_verified_at')->nullable();
            $table->string('password');
            $table->rememberToken();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('users');
    }
}
```
### Comandos Utiles

- **Ejecutar todas las migraciones pendientes**:

  ```bash
  php artisan migrate
  ```

- **Ejecutar una sola migracion**:

  ```bash
  php artisan migrate --path=/database/migrations/nombre_de_la_migracion.php
  ```

- **Ver el estado de las migraciones**:

  ```bash
  php artisan migrate:status
  ```

- **Revertir la última migración ejecutada**:

  ```bash
  php artisan migrate:rollback
  ```

- **Revertir todas las migraciones**:

  ```bash
  php artisan migrate:reset
  ```

- **Refrescar la base de datos (revertir y volver a ejecutar todas las migraciones)**

  ```bash
  php artisan migrate:refresh

  php artisan migrate:fresh
  ```
### Modificaciones de Tablas Existentes

Puedes crear migraciones para modificar tablas existentes, añadiendo, modificando o eliminando columnas.

**Ejemplo**
```bash
php artisan make:migration add_profile_photo_at_users_table --table=users
```
```php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class AddProfilePhotoToUsersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::table('users', function (Blueprint $table) {
            $table->string('profile_photo')->nullable()->after('email');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::table('users', function (Blueprint $table) {
            $table->dropColumn('profile_photo');
        });
    }
}
```



### Persistencia de Datos

La persistencia de datos se refiere a la capacidad de almacenar y mantener la información a largo plazo, de modo que los datos persistan más allá de la duración de un programa o de la ejecución de una aplicación. En términos de desarrollo de software, la persistencia de datos se refiere específicamente a la capacidad de conservar los datos incluso después de que se cierre o termine un programa o una aplicación.

En el contexto de las aplicaciones web y de bases de datos, la persistencia de datos implica guardar la información de manera permanente en algún tipo de almacenamiento, como un sistema de archivos, una base de datos, memoria persistente, etc. Esto garantiza que los datos estén disponibles incluso después de apagar o reiniciar un sistema, o después de cerrar y volver a abrir una aplicación.

Existen varios métodos y tecnologías para lograr la persistencia de datos, entre los que se incluyen:

- **Bases de Datos Relacionales y No Relacionales**: Las bases de datos como MySQL, PostgreSQL, MongoDB, entre otras, son utilizadas para almacenar y recuperar datos de manera persistente.

- **Sistemas de Archivos**: Almacenar datos en archivos en el sistema de archivos del servidor, aunque esta técnica es menos común en aplicaciones modernas debido a la falta de capacidad para realizar consultas complejas y gestionar la consistencia de los datos.

- **Memoria Persistente**: Algunos sistemas proporcionan memoria no volátil que permite almacenar datos de manera persistente, como las bases de datos en memoria o el uso de tecnologías como Redis.


