# Sintaxis
Python usa indentación obligatoria en lugar de llaves `{}` o palabras clave como **`begin`** y **`end`** para definir bloques de código.

## Legibilidad y Simplicidad
Python sigue el principio **"Legibilidad es lo más importante"** (expresado en *The Zen of Python* con `import this`).

* La indentación obliga a los programadores a escribir código limpio y estructurado.
* Evita código desordenado con llaves mal alineadas o anidadas caóticamente.

Ejemplo en Python (con indentación):
```python
def saludar(nombre):
    if nombre:
        print(f"Hola, {nombre}!")
    else:
        print("Hola, mundo!")
```
Python **elimina el ruido visual**, haciendo el código más limpio y fácil de leer.

## Python es Minimalista y Explicito
El diseño de Python sigue la filosofía de:

* ***"Debe haber una —y preferiblemente solo una— manera obvia de hacerlo."***

Al hacer que la indentación sea obligatoria, Python:
* Refuerza la legibilidad y consistencia.
* Previene errores comunes de estructuración.
* Simplifica la sintaxis, reduciendo caracteres innecesarios.