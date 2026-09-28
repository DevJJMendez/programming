## Concatenacion
En PHP, hay varias formas de concatenar cadenas, es decir, unir múltiples cadenas de texto en una sola.

### Operador de Punto `.`:
El operador de punto `.` se utiliza para concatenar cadenas en PHP. Puedes usarlo para unir cadenas de texto, variables y constantes.

```php
<?php>
  $nombre = "Juan";
  $apellido = "Pérez";

  $nombreCompleto = $nombre . " " . $apellido;
?>
```
### Asignación con Punto `.=`:

El operador de asignación con punto `.=` te permite agregar una cadena a una variable existente. Es útil cuando deseas construir una cadena gradualmente.

```php
<?php>
  $saludo = "Hola, ";
  $nombre = "Juan";
  $saludo .= $nombre; // $saludo ahora es "Hola, Juan"
?>
```

### Comillas Dobles `""`:
Si utilizas comillas dobles para delimitar una cadena, PHP permite la interpolación de variables directamente en la cadena. Esto significa que puedes incluir variables dentro de la cadena sin necesidad de usar el operador de punto.

```php
<?php>
  $nombre = "Juan";
  $saludo = "Hola, $nombre";
?>
```

### `sprintf`
se utiliza en PHP para formatear cadenas de texto, permitiéndote crear cadenas con marcadores de posición que luego puedes reemplazar con valores específicos.

Sintaxis:
```php
<?php>
  sprintf(formato, valor1, valor2, ...);
?>
```
- **formato**: Es una cadena que especifica el formato de la cadena de salida y puede contener marcadores de posición.

- **valor1**, **valor2**, ...: Son los valores que reemplazarán los marcadores de posición en el formato.

Puedes proporcionar uno o más valores para reemplazar los marcadores de posición en el orden en que aparecen en el formato.

Ejemplo:

```php
<?php>
  $nombre = "Juan";
  $edad = 30;
  $saludo = sprintf("Hola, mi nombre es %s y tengo %d años.", $nombre, $edad);
?>
```
Marcadores de posición comunes en sprintf:

- %s: Se utiliza para representar una cadena (string).

- %d o %i: Se utilizan para representar números enteros (int).

- %f: Se utiliza para representar números de punto flotante (float).

- %c: Se utiliza para representar un carácter (char).

- %b: Se utiliza para representar números binarios.

- %x y %X: Se utilizan para representar números hexadecimales.