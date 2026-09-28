# Lambdas
Las funciones lambda en Python son funciones anónimas, es decir, funciones sin nombre. Se utilizan para escribir funciones pequeñas y concisas en una sola línea. Son útiles cuando necesitamos funciones simples sin definirlas con `def`.

## Sintaxis
```python
lambda argumentos: expresión
```
* **`argumentos`**: Parámetros de entrada, pueden ser múltiples.

* **`expresión`**: Se evalúa y devuelve el resultado. No se permiten múltiples líneas.

**Ejemplo**
```python
doble = lambda x: x * 2
print(doble(5))

# 10
```

## Diferencias entre lambda y def
Las funciones lambda son funciones de una sola línea, mientras que las funciones definidas con def pueden tener múltiples líneas y estructuras más complejas.

```python
def doble(x):
    return x * 2
print(doble(5))

doble = lambda x: x * 2
print(doble(5))
```
Ambas devuelven 10, pero lambda es más corta.

## Lambdas con Múltiples Argumentos
```python
suma = lambda a, b: a + b
print(suma(3, 7))
# 10

multiplicar = lambda a, b, c: a * b * c
print(multiplicar(2, 3, 4))
# 24
```

## Uso de lambda con Funciones de Orden Superior
Las funciones lambda se usan con funciones como `map()`, `filter()` y `sorted()`. `reduce()`

## lambda con Expresiones Condicionales
Podemos usar `if` en lambda:
```python
par_impar = lambda x: "Par" if x % 2 == 0 else "Impar"
print(par_impar(3))  # Impar
print(par_impar(8))  # Par
```
Mismo ejemplo con `def`:
```python
def par_impar(x):
    return "Par" if x % 2 == 0 else "Impar"
```

## lambda en Diccionarios
Útil cuando queremos una especie de "switch":

```python
operaciones = {
    "suma": lambda a, b: a + b,
    "resta": lambda a, b: a - b,
    "multiplicacion": lambda a, b: a * b
}

print(operaciones["suma"](5, 3))  # 8
print(operaciones["multiplicacion"](4, 2))  # 8
```

## lambda dentro de una Función
Se pueden definir dentro de otras funciones para cálculos rápidos.

```python
def potenciar(n):
    return lambda x: x ** n  # Devuelve una función

doble = potenciar(2)  # Crea una función que eleva al cuadrado
print(doble(5))  # 25
```