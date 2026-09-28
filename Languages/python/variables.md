# Variables
Las variables en Python son nombres que apuntan a objetos en memoria. Son dinámicas y tipadas en tiempo de ejecución.

## Declaración y Asignación de Variables
* No necesitan declaración previa.

* No se define un tipo de dato explícitamente.

* Se asignan con `=`.

Ejemplo:
```python
nombre = "JJ"
edad = 25
precio = 19.99
activo = True
```
Python infiera el tipo de dato automáticamente.

## Tipos de Variables en Python
Tipos primitivos más usados
| Tipo  | Descripción      |
| ----- | ---------------- |
| int   | Enteros          |
| float | Decimal          |
| str   | Cadenas de texto |
| bool  | Booleanos        |

Ejemplo
```python
x = 42         # int
y = 3.14       # float
mensaje = "Hola"  # str
bandera = False   # bool
```
Python es dinámicamente tipado, lo que significa que el tipo de una variable puede cambiar en tiempo de ejecución:
```python
dato = 10
dato = "Texto"  # Cambia de int a str sin problemas
```

## Tipado Dinámico vs Tipado Estático
Python no obliga a declarar tipos, pero se puede usar type hints (sugerencias de tipo).
```python
def sumar(a: int, b: int) -> int:
    return a + b
```
*type hints* no son obligatorios, pero ayudan a la legibilidad.

## Ámbito y Ciclo de Vida de las Variables
Python usa ámbitos de variables para definir su visibilidad en diferentes partes del código.

### Tipos de ámbitos:
* **Local**: Dentro de una función.

* **Global**: Disponible en todo el script.

* **Nonlocal**: Variable en una función anidada.

* **Built-in**: Palabras clave de Python.
```python
x = 100  # Variable global

def mi_funcion():
    x = 50  # Variable local
    print(x)  # 50

mi_funcion()
print(x)  # 100 (la variable global no cambió)
```
Una variable local no afecta la variable global.

### `global` y `nonlocal`
Para modificar variables globales dentro de funciones:
```python
contador = 0

def incrementar():
    global contador
    contador += 1
```
Para modificar variables en funciones anidadas (`nonlocal`):
```python
def externa():
    x = 10
    def interna():
        nonlocal x
        x += 5
    interna()
    print(x)  # 15
```

## Variables Mutables vs Inmutables
📌 En Python, algunos tipos de datos pueden cambiar su contenido (mutables) y otros no (inmutables).

### Tipos inmutables (NO se pueden modificar):
`int, float, bool, str, tuple`

### Tipos mutables (SÍ se pueden modificar):
`list, dict, set`

Ejemplo de variable inmutable (`str`):
```python
nombre = "Juan"
nombre[0] = "P"  # ❌ ERROR: los strings son inmutables
```
Ejemplo de variable mutable (`list`):
```python
numeros = [1, 2, 3]
numeros.append(4)  # ✅ Se modifica sin problema
```
**¿Por qué importa?** Si pasas una variable mutable a una función, se puede modificar fuera de la función.
```python
def modificar_lista(lista):
    lista.append(99)

mi_lista = [1, 2, 3]
modificar_lista(mi_lista)
print(mi_lista)  # [1, 2, 3, 99] (Se modificó fuera de la función)
```

## Variables con Valores por Defecto (None)
Si una variable no tiene valor inicial, se puede asignar `None` (equivalente a `null` en otros lenguajes).
```python
respuesta = None

if respuesta is None:
    print("No hay respuesta aún")
```
Se usa `is None` en vez de `== None` porque `None` es un **singleton**.

## Variables en una Línea (`Unpacking`)
```python
a, b, c = 1, 2, 3
print(a, b, c)  # 1 2 3
```
También funciona con listas y tuplas:
```python
numeros = [10, 20, 30]
x, y, z = numeros
print(x, y, z)  # 10 20 30
```
`_` se usa cuando un valor no es relevante:
```python
_, edad, _ = ["JJ", 25, "Developer"]
print(edad)  # 25
```

## `del` (Eliminar Variables)
Puedes eliminar una variable con `del`:
```python
x = 10
del x
print(x)  # ❌ ERROR: x no está definida
```
También funciona con elementos de listas:
```python
lista = [1, 2, 3]
del lista[0]  # Borra el primer elemento
```

## Variables y globals() / locals()
* `globals()` → Muestra las variables globales.

* `locals()` → Muestra las variables locales en una función.
```python
x = 10

def funcion():
    y = 5
    print(locals())  # {'y': 5}

print(globals())  # {'x': 10, ...}
```