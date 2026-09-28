# Arrays

Los arrays en PHP son estructuras de datos que permiten almacenar múltiples valores en una sola variable. Los arrays pueden contener elementos de diferentes tipos, como números, cadenas, otros arrays y objetos. PHP admite varios tipos de arrays, cada uno con sus propias características y usos específicos. 

Formas de declarar un array en PhP:

**utilizando corchetes []**:
```php
$colores = ["rojo", "verde", "azul"];
$colores[3] = "amarillo"; // Agrega "amarillo" al final del array
```

**utilizando paréntesis ()**:
```php
$colores = array("rojo", "verde", "azul");
$colores[] = "amarillo"; // Agrega "amarillo" al final del array
```

Ambos ejemplos realizan la misma tarea, que es agregar un nuevo valor al final del array. La notación con corchetes [] es más reciente y generalmente se prefiere en código moderno debido a su simplicidad y claridad. Sin embargo, la notación con paréntesis () sigue siendo válida y se utiliza en código más antiguo o cuando se requiere compatibilidad con versiones anteriores de PHP.
---

- Array Indexado: Un array indexado es una lista de valores numerados, donde cada valor se asocia con un índice numérico. Los índices comienzan desde 0 y aumentan en orden. 

    ```php
    <?php
    $usersList = array("Ryan", "Jane", "Joe", "Luke");
    echo $usersList[1];
    ```
    salida por consola:
    ```yaml
    Jane
    ```
---
- Array de Lista: Un array de lista es una forma simplificada de crear un array indexado. Los valores se enumeran entre corchetes sin especificar índices. PHP automáticamente asigna índices numéricos en orden. 

    ```php
    $colores = ["rojo", "verde", "azul"];
    echo $colores[1];
    ```
    salida por consola:
    ```yaml
    Verde
    ```
---

- Array Asociativo: Un array asociativo utiliza claves en lugar de índices numéricos para acceder a los valores. Cada valor se asocia con una clave única. Este tipo de array es útil para representar datos estructurados.

    ```php
    $persona = array("nombre" => "Juan", "edad" => 30, "ciudad" => "Madrid");
    echo $persona["nombre"];
    ```
    salida por consola
    ```yaml
    Juan
    ```
---

- Array Multidimensional: son arrays que contienen otros arrays como elementos. Puedes tener arrays dentro de arrays para representar estructuras de datos más complejas.
    ```php
    $matriz = array(
        array(1, 2, 3),
        array(4, 5, 6), //  array 1 - posición 2
        array(7, 8, 9)
    );
    echo $matriz[1][2];
    ```

    Salida por consola

    ```yaml
    6
    ```
    **OTRO EJEMPLO**

    ```php
    <?php
    $userTasks = array(
        array("Monday", "C#", "ASP", "EF"),
        array("Saturday", "JS", "NODEJS", "MONGODB"),
    );
    echo $userTasks[1][2];
    ```
    Salida por consola:

    ```yaml
    NODEJS
    ```
---
- Array de Rango: Un array de rango se crea usando la función range() y se utiliza para generar una secuencia numérica en un rango específico.

```php
<?php
$userAttempts = range(1, 6);
print_r($userAttempts);
```
salida por consola:
```yaml
Array
(
    [0] => 1                                                        -0  
    [1] => 2
    [2] => 3
    [3] => 4
    [4] => 5
    [5] => 6
)
```

---
- Array de Cadena (string Array): Puedes tratar una cadena como un array de caracteres en PHP. Puedes acceder a caracteres individuales por índice o utilizar funciones para manipular la cadena como un array.
```php
$cadena = "Hola";
echo $cadena[0]; 
```
salida por consola:
```yaml
H
```