# Schedule

Las tareas programadas, también conocidas como "schedule" en Laravel, permiten ejecutar comandos de Artisan en intervalos regulares. Laravel proporciona una forma elegante de definir y gestionar estas tareas programadas mediante el uso del componente `Illuminate\Console\Scheduling\Schedule`.

## Crear tareas programadas

- Metodo `schedule()`

Dentro de la clase Kernel, encontrarás el método `schedule()`. Este método es donde defines todas tus tareas programadas.

```php
protected function schedule(Schedule $schedule)
{
    $schedule->command('make:order', ['user_id' => 66, 'amount' => 2666])->everyMinute();
    $schedule->command('make:order', ['user_id' => 66, 'amount' => 2666])->everyFiveMinutes();
}
```

- Frecuencias predefinidas: Laravel proporciona métodos convenientes para definir tareas programadas con frecuencias comunes.

```php
$schedule->command()->cron('20 11 15 1') //  3:20 dia:15 mes:enero - (minutos, horas, días del mes, meses, días de la semana)
$schedule->command()->cron('20 11 * *') // 3:20 todos los dias, todos los meses

$schedule->command()->everyMinute()
$schedule->command()->hourly();
$schedule->command()->daily()
$schedule->command()->dailyAt('3:00')
$schedule->command()->weekly()
$schedule->command()->weeklyOn(1, '8:00')  // (Ejecutar todos los lunes a las 8:00 AM)
$schedule->command()->monthly()
$schedule->command()->monthlyOn(15, '12:00')  // (Ejecutar el día 15 de cada mes a las 12:00 PM)
```

**Metodos adicionales**

```php
$schedule->command('custom:command')->hours(1, 5, 9); // Ejecutar en Horas Específicas del Día -(Ejecutar cada 1, 5 y 9 horas)

$schedule->command('custom:command')->days(1, 15); // Ejecutar en Días Específicos del Mes - (Ejecutar el día 1 y 15 de cada mes)

$schedule->command('custom:command')->weekdays(); // Ejecutar Solo en Fines de Semana

$schedule->command('custom:command')->daysOfWeek(2, 4); // Ejecutar Solo en Días Específicos de la Semana - (Ejecutar los martes y jueves)

$schedule->command('custom:command')->unlessDaysOfWeek(1, 7); // Ejecutar Solo en Días No Específicos de la Semana - (No ejecutar los lunes y domingos)
```
