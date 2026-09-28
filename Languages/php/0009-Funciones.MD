# Funciones

Las funciones en PHP son bloques de código reutilizable que realizan una tarea específica. Pueden aceptar datos (parámetros), procesarlos y devolver un resultado. Las funciones son una parte fundamental de la programación modular, ya que te permiten dividir tu código en unidades lógicas más pequeñas y fáciles de mantener. 

---

Sintaxis:

```php
function nombreFuncion($parametro1, $parametro2, ...) {
    // Código que realiza una tarea
    return $resultado; // Opcional: devuelve un valor
}
```

Llamada a una función:

```php
$resultado = nombreFuncion($valor1, $valor2, ...);

// tambien

nombreFuncion($valor1, $valor2, ...);
```
---

Ejemplo:

```php
function suma($a, $b) {
    $resultado = $a + $b;
    return $resultado;
}

$valor1 = 5;
$valor2 = 3;
$suma = suma($valor1, $valor2);
echo "La suma de $valor1 y $valor2 es $suma.";
```