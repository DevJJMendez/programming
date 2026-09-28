# Condicionales

Los condicionales en PHP son estructuras que te permiten tomar decisiones en tu código según ciertas condiciones. PHP admite varias estructuras condicionales que te permiten ejecutar bloques de código si una condición es verdadera y, opcionalmente, ejecutar un bloque alternativo si la condición es falsa.

---

- if

La estructura if te permite ejecutar un bloque de código si una condición es verdadera. Si la condición es falsa, el código dentro del if no se ejecuta. Puedes usar if de forma independiente o en combinación con else o elseif para manejar múltiples casos.

```php
$edad = 25;
if ($edad >= 18) {
    echo "Eres mayor de edad.";
}
```

- if anidado

son una técnica en programación que implica colocar una estructura "if" dentro de otra estructura "if". Esto se utiliza cuando necesitas evaluar múltiples condiciones en un orden específico o cuando deseas manejar diferentes casos de manera más compleja. Los "if" anidados se pueden utilizar con "if-else", "if-elseif-else", o incluso dentro de "switch" en PHP.

```php
$edad = 20;
$tieneCarnet = true;

if ($edad >= 18) {
    echo "Eres mayor de edad.";
    
    if ($tieneCarnet) {
        echo "Tienes un carné de identidad válido.";
    } else {
        echo "No tienes un carné de identidad válido.";
    }
} else {
    echo "Eres menor de edad.";
}
```
---

- if-else

La estructura if-else te permite ejecutar un bloque de código si la condición es verdadera y otro bloque de código si la condición es falsa. Es útil para manejar dos casos alternativos.

```php
$edad = 15;
if ($edad >= 18) {
    echo "Eres mayor de edad.";
} else {
    echo "Eres menor de edad.";
}
```

---

- if-elseif-else

La estructura if-elseif-else te permite manejar múltiples condiciones y casos alternativos. Puedes tener múltiples bloques elseif para evaluar diferentes condiciones antes de llegar al bloque else

```php
$puntuacion = 85;
if ($puntuacion >= 90) {
    echo "Aprobaste con A.";
} elseif ($puntuacion >= 80) {
    echo "Aprobaste con B.";
} elseif ($puntuacion >= 70) {
    echo "Aprobaste con C.";
} else {
    echo "Reprobaste.";
}
```

---

- switch

La estructura switch te permite evaluar una expresión y ejecutar diferentes bloques de código en función del valor de esa expresión. Es útil cuando tienes múltiples casos que deben compararse con el mismo valor.

```php
$dia = "Lunes";
switch ($dia) {
    case "Lunes":
        echo "Hoy es lunes.";
        break;
    case "Martes":
        echo "Hoy es martes.";
        break;
    // Otros casos
    default:
        echo "No sé qué día es.";
}
```
---

Estas estructuras condicionales te permiten controlar el flujo de ejecución de tu código en función de condiciones específicas. Puedes usar operadores de comparación, operadores lógicos y expresiones para definir tus condiciones. Los condicionales son una parte fundamental de la programación y permiten crear lógica flexible en las aplicaciones.