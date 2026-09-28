# Funciones
Las funciones en Python permiten organizar el código, reutilizar lógica y mejorar la mantenibilidad. Son bloques de código que se ejecutan cuando se llaman, y pueden recibir argumentos y devolver resultados.

## Definir una Función
Se usa la palabra clave `def`:
```python
def nombre_funcion(parametros):
    # Código de la función
    return resultado
``` 
Ejemplo básico:
```python
def saludar(nombre):
    return f"Hola, {nombre}!"

print(saludar("JJ"))
```
Salida:
```bash
Hola, JJ!
```

## Llamar a una Función
Para ejecutar una función, simplemente la invocamos con su nombre y argumentos:
```python
def sumar(a, b):
    return a + b

resultado = sumar(5, 3)
print(resultado)

# 8
```

## Parámetros y Argumentos
* Parámetros: Variables dentro de la definición de la función.

* Argumentos: Valores reales pasados a la función.

```python
def multiplicar(x, y):  # x e y son parámetros
    return x * y

print(multiplicar(4, 5))  # 4 y 5 son argumentos
```

## Tipos de Parámetros en Python
Python permite diferentes formas de pasar parámetros:

### 1. Argumentos Posicionales (Orden Importa)
```python
def dividir(a, b):
    return a / b

print(dividir(10, 2))  # 10 es 'a', 2 es 'b'

# 5.0
```

### Argumentos con Nombre (Keyword Arguments)
Podemos pasar argumentos por nombre, sin importar el orden:

```python
def presentar(nombre, edad):
    print(f"Nombre: {nombre}, Edad: {edad}")

presentar(edad=30, nombre="Juan")

# Nombre: Juan, Edad: 30
```

### Parámetros con Valor por Defecto
Si no se pasa un valor, se usa el predeterminado.

```python
def saludar(nombre="Invitado"):
    return f"Hola, {nombre}!"

print(saludar())  # Usa "Invitado"
print(saludar("JJ"))

# Hola, Invitado!
# Hola, JJ!
```

## Número Variable de Argumentos (*args)
Permite recibir cualquier cantidad de argumentos posicionales.

```python
def sumar_todo(*numeros):
    return sum(numeros)

print(sumar_todo(1, 2, 3, 4, 5))  # 1+2+3+4+5 = 15

# 15
```

## Número Variable de Argumentos con Nombre (**kwargs)
Recibe cualquier cantidad de argumentos con nombre.

```python
def mostrar_info(**datos):
    for clave, valor in datos.items():
        print(f"{clave}: {valor}")

mostrar_info(nombre="JJ", edad=25, ciudad="Madrid")

#
# nombre: JJ
# edad: 25
# ciudad: Madrid
#
```

## Retorno de Valores (return)
Las funciones pueden devolver valores usando return:

```python
def cuadrado(n):
    return n ** 2

print(cuadrado(4))  # 16
```
Si no usamos `return`, la función devuelve `None` por defecto.

## Funciones Anónimas (lambda)
Son funciones pequeñas de una sola línea.

```python
doble = lambda x: x * 2
print(doble(5))

# 10
```
Ejemplo con múltiples parámetros:
```python
suma = lambda a, b: a + b
print(suma(3, 7))

# 10
```
Se usan con funciones como `map()`, `filter()` y `sorted()`.

### `map()`, `filter()`, y `reduce()`
* **`map()`**: Aplica una función a cada elemento de una colección.
```python
numeros = [1, 2, 3, 4]
dobles = list(map(lambda x: x * 2, numeros))
print(dobles)

# [2, 4, 6, 8]
```

* **`filter()`**: Filtra elementos según una condición.
```python
numeros = [1, 2, 3, 4, 5]
pares = list(filter(lambda x: x % 2 == 0, numeros))
print(pares)

# [2, 4]
```

* **`reduce()`**: Aplica una función acumulativa a los elementos de una colección.
```python
from functools import reduce

numeros = [1, 2, 3, 4]
suma_total = reduce(lambda a, b: a + b, numeros)
print(suma_total)

# 10
```

# Funciones Anidadas
Las funciones pueden estar dentro de otras.

```python
def exterior():
    print("Función exterior")

    def interior():
        print("Función interior")

    interior()

exterior()

# Función exterior
# Función interior
```

## Funciones como Objetos de Primera Clase
Las funciones pueden ser pasadas como argumentos.

```python
def saludo():
    return "Hola"

def ejecutar_funcion(func):
    print(func())

ejecutar_funcion(saludo)

# Hola
```

## Decoradores (Funciones que Modifican Otras Funciones)
Un decorador toma una función y extiende su funcionalidad sin modificarla.

```python
def decorador(func):
    def envoltura():
        print("Antes de llamar la función")
        func()
        print("Después de llamar la función")
    return envoltura

@decorador
def mensaje():
    print("Hola, soy una función decorada!")

mensaje()

# Antes de llamar la función
# Hola, soy una función decorada!
# Después de llamar la función
```