# Manejo de Excepciones

El manejo de excepciones en PHP es fundamental para controlar y gestionar situaciones excepcionales o errores que pueden ocurrir durante la ejecución de un programa. Las excepciones permiten escribir un código más robusto al manejar errores de manera controlada en lugar de interrumpir abruptamente la ejecución del programa. 

---

# Qué es una excepción?

Una excepción en PHP es un objeto que representa un error o una situación excepcional. Se lanza cuando ocurre algo inesperado durante la ejecución del código.

## Palabras clave relacionadas con excepciones:

- `try`: Define un bloque de código donde se pueden producir excepciones.

- `catch`: Captura y maneja las excepciones lanzadas dentro de un bloque `try`.

- `throw`: Lanza explícitamente una excepción.

---

# Estructura básica para manejar excepciones:

```php
try {

    // Bloque de código donde se pueden producir excepciones
    // código que puede lanzar una excepción

} catch (TipoDeExcepcion $excepcion) {

    // Bloque de código para manejar la excepción
    // código para manejar la excepción capturada

} finally {

    // Opcional: Bloque de código que siempre se ejecutará,
    // incluso si no se captura ninguna excepción

}
```

### Ejemplo de manejo de excepciones:

```php
function dividir($dividendo, $divisor) {

    if ($divisor == 0) {
        throw new Exception("Error: división por cero");
    }
    return $dividendo / $divisor;
}

try {

    $resultado = dividir(10, 0);
    echo "El resultado es: " . $resultado;

} catch (Exception $excepcion) {

    echo "Se produjo una excepción: " . $excepcion->getMessage();

} finally {

    echo " Esto se ejecuta siempre, independientemente de si se captura una excepción o no.";
}
```

En este ejemplo:

- La función `dividir()` intenta dividir dos números y lanza una excepción si el divisor es cero.

- El bloque `try` intenta ejecutar dividir(10, 0).

- Si se lanza una excepción, se captura en el bloque catch y se maneja mostrando el mensaje de la excepción.

- El bloque `finally` se ejecuta siempre, independientemente de si se captura una excepción o no.

El manejo de excepciones ayuda a controlar situaciones inesperadas y a mantener la estabilidad del programa al permitir gestionar los errores de manera más controlada y estructurada.