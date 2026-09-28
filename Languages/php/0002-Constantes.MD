## Constantes
En **PHP**, puedes declarar constantes de dos maneras principales: 

- utilizando la función **define()**

- utilizando la palabra clave **const** dentro de una clase.

---

### define()
La función **define()** se utiliza para declarar constantes en el ámbito **global**. Debes proporcionar un nombre para la constante y el valor que deseas asignar a esa constante.
```php
<?php>
    define("MI_CONSTANTE", "Este es el valor de mi constante");
?>
```

---

### const
A partir de PHP 5.3, puedes declarar constantes dentro de una clase utilizando la palabra clave **const**. 

Esto permite agrupar constantes relacionadas en una clase.

```php
<?php>
    class MiClase {
    const MI_CONSTANTE = "Este es el valor de mi constante";
}
?>
```
Ten en cuenta que las constantes definidas con **define()** están disponibles en todo el ámbito global, mientras que las definidas con **const** en una clase están limitadas al ámbito de esa clase.