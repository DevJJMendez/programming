# Operadores Aritmeticos

Los operadores aritméticos son herramientas que permiten realizar operaciones matemáticas en valores numéricos. Estos operadores te permiten realizar tareas como sumar, restar, multiplicar, dividir y realizar otras operaciones relacionadas con números. 

---

- Suma

```php
$resultado = 5 + 3;
```

---

- Resta

```php
$resultado = 10 - 4;
```

---

- Multiplicación

```php
$resultado = 6 * 7;
```

---

- División

```php
$resultado = 12 / 3;
```

---

- Módulo

El operador de módulo devuelve el residuo de la división de un valor por otro. Es útil para verificar si un número es par o impar o para realizar cálculos relacionados con ciclos. 

```php
$residuo = 10 % 3;
```

---

- Operador de Incremento

El operador de incremento se utiliza para aumentar el valor de una variable en 1. Puede usarse antes (prefijo) o después (postfijo) de la variable.

```php
$numero = 5;
$numero++; // $numero ahora es 6
```

- Operador de decremento

El operador de Decremento se utiliza para disminuir el valor de una variable en 1. Al igual que el operador de incremento, puede ser prefijo o postfijo. 

```php
$numero = 8;
$numero--; // $numero ahora es 7
```

---

- Operadores de Potenciación

A partir de PHP 5.6, se introdujo el operador de potenciación para calcular exponentes.

```php
$resultado = 2 ** 3; // $resultado contendrá 8 (2 elevado a la 3)
```
---

Estos operadores aritméticos te permiten realizar una variedad de cálculos matemáticos en PHP. Puedes combinarlos y usar paréntesis para controlar el orden de las operaciones si es necesario. Por ejemplo:

```php
$expresion = (4 + 2) * 3 / 2; // $expresion contendrá 9
```