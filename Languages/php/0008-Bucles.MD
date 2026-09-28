# Bucles

Los bucles en PHP son estructuras que te permiten ejecutar un bloque de código repetidamente mientras se cumple una condición específica. PHP admite varios tipos de bucles que te ayudan a automatizar tareas repetitivas. 

---

- Bucle For

Un bucle for te permite especificar una inicialización, una condición y una expresión de incremento en una sola línea. Es útil cuando sabes cuántas iteraciones necesitas.

```php
for ($i = 0; $i < 5; $i++) {
    echo "Iteración $i";
}
```

- Bucle Foreach

El bucle foreach se utiliza para recorrer elementos de un array o colección. Es especialmente útil para trabajar con arrays asociativos.

```php
$colores = ["rojo", "verde", "azul"];
foreach ($colores as $color) {
    echo "Color: $color";
}
```

- Bucle For Each Key-Value

Puedes utilizar foreach para recorrer arrays asociativos y obtener tanto la clave como el valor de cada elemento.

```php
$persona = ["nombre" => "Juan", "edad" => 30];
foreach ($persona as $clave => $valor) {
    echo "$clave: $valor<br>";
}
```
---

- Bucle While: Un bucle while ejecuta un bloque de código mientras una condición sea verdadera. La condición se verifica antes de cada iteración.

```php
$contador = 0;
while ($contador < 5) {
    echo "Iteración $contador<br>";
    $contador++;
}
```

- Bucle Do-While

Un bucle do-while es similar al bucle while, pero garantiza que el bloque de código se ejecute al menos una vez antes de verificar la condición.

```php
$contador = 0;
do {
    echo "Iteración $contador<br>";
    $contador++;
} while ($contador < 5);
```

- Bucle Break

El bucle break te permite salir de un bucle antes de que se cumpla la condición de finalización. Es útil cuando deseas terminar un bucle antes de completar todas las iteraciones.

```php
$contador = 0;
while (true) {
    echo "Iteración $contador<br>";
    $contador++;
    if ($contador >= 3) {
        break;
    }
}
```

- Bucle Continue

El bucle continue se utiliza para omitir la iteración actual y pasar a la siguiente. Es útil cuando deseas saltar una iteración en función de una condición.

```php
for ($i = 0; $i < 5; $i++) {
    if ($i == 2) {
        continue;
    }
    echo "Iteración $i<br>";
}
```

---

Los bucles son fundamentales en la programación, ya que te permiten repetir tareas de manera eficiente y procesar datos de forma repetitiva. La elección del bucle adecuado depende de la tarea que estés realizando y de las condiciones de salida específicas que necesites.