## Imprimir datos

### `echo`
La función `echo` se utiliza para imprimir datos en pantalla.
    
Puedes usarlo para mostrar texto, variables y expresiones.

**Ejemplo**:
```php
<?php>
    echo "Hola, soy un texto.";

    $nombre = "Juan";
    echo "Mi nombre es " . $nombre;
?>
```

### `print`
Similar a echo, la función `print` se usa para imprimir datos en pantalla. 

A diferencia de `echo`, `print` solo puede imprimir una cadena y siempre devuelve 1.

Ejemplo:

```php
<?php>
    print "Hola, soy un texto.";
?>
```

### `printf`
La función `printf` se utiliza para formatear e imprimir datos con formato específico. 

Puedes especificar marcadores de posición y valores para imprimir con un formato particular.

**Ejemplo**:
```php
<?php>
    $numero = 42;
    printf("El número es %d", $numero);
?>
```

### `print_r`
La función `print_r` se utiliza para mostrar información sobre una variable, especialmente útil para ver el contenido de arrays y objetos de manera legible.

Ejemplo:

```php
<?php>
    $miArray = array("manzana", "banana", "cereza");
    print_r($miArray);
?>
```

### `var_dump` 
La función `var_dump` se utiliza para obtener información detallada sobre una variable, incluyendo su tipo y longitud, lo que es especialmente útil para depuración.

**Ejemplo**:
```php
<?php>
    $numero = 42;
    var_dump($numero);
?>
```

### `die` o `exit`

Puedes usar `die` o `exit` para imprimir un mensaje y terminar la ejecución del script.

Esto es útil para detener el script en caso de error o para mostrar mensajes de error personalizados.

**Ejemplo**:
```php
<?php>
    $error = "Hubo un error en el script.";
    die($error);
?>
    ```