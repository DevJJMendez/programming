## Declarar variables
En PHP, puedes declarar variables y constantes de varias formas.

- Usando el símbolo del signo de dólar `$`: Para declarar una variable, simplemente precede el nombre de la variable con el símbolo de dólar `$`. 

**Por ejemplo**:

```php
<?php>
    $miVariable = "Hola, soy una variable.";
?>
```

### Declaración de tipo (a partir de PHP 7.0)
A partir de PHP 7.0, puedes declarar variables con tipos específicos utilizando una sintaxis que incluye el tipo de dato deseado. 

**Sintaxis**:

```php
<?php>
    $nombreVariable : tipo = valor;
?>

<?php>
    $edad : int = 25;
    $nombre : string = "Juan";
    $esVerdadero : bool = true;
?>
```

Esto ayuda a que el código sea más legible y también proporciona cierta verificación estática del tipo de datos durante el desarrollo.

Es importante tener en cuenta que a partir de PHP 7.4, puedes declarar variables sin asignar un valor inicial y el tipo se deducirá automáticamente:

```php
<?php>
    $numero; // La variable $numero se declara sin asignar un valor inicial.
    $numero = 42; // Luego puedes asignar un valor a la variable.
?>
```
**Sin embargo, es una buena práctica asignar un valor inicial siempre que sea posible para evitar errores.**