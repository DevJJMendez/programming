# Duck Typing
Duck Typing es un principio de tipado dinámico donde el tipo de un objeto es determinado por su comportamiento en lugar de su herencia o declaración explícita.

*"Si camina como un pato y grazna como un pato, entonces probablemente sea un pato."*

* En Python, no importa la clase de un objeto, sino qué métodos y atributos tiene.

* Esto permite escribir código más flexible y reutilizable, pero también puede introducir errores si no se maneja con cuidado.

## Ejemplo Básico de Duck Typing
```python
class Pato:
    def hacer_sonido(self):
        return "Cuac cuac"

class Perro:
    def hacer_sonido(self):
        return "Guau guau"

def hacer_sonido(animal):
    return animal.hacer_sonido()  # No importa la clase, solo que tenga el método

pato = Pato()
perro = Perro()

print(hacer_sonido(pato))  # "Cuac cuac"
print(hacer_sonido(perro))  # "Guau guau"
```
* No nos importa si pato es una instancia de `Pato` o `Perro`.
* Lo único que importa es que tiene un método `hacer_sonido()`.

## Ventajas de Duck Typing ✅
* Código más flexible: No dependemos de una jerarquía de clases rígida.
* Menos acoplamiento: Se enfoca en el comportamiento, no en el tipo de objeto.
* Código más conciso: Evita chequeos innecesarios de tipos.

## Problemas y Cómo Manejar Duck Typing ⚠️
❌ Error cuando un objeto no implementa el método esperado
```python
class Gato:
    pass  # No tiene hacer_sonido()

gato = Gato()
print(hacer_sonido(gato))  # AttributeError: 'Gato' object has no attribute 'hacer_sonido'
```
**Solución con `hasattr()` ->** Antes de llamar un método, podemos verificar si existe.
```python
def hacer_sonido(animal):
    if hasattr(animal, "hacer_sonido"):
        return animal.hacer_sonido()
    raise TypeError("El objeto no tiene el método hacer_sonido")

print(hacer_sonido(pato))  # "Cuac cuac"
# print(hacer_sonido(gato))  # TypeError
```

## Alternativa: Protocolos (typing.Protocol) 📜
Desde Python 3.8, se puede usar `Protocol` para definir interfaces de comportamiento sin herencia explícita.

Ejemplo con `Protocol`
```python
from typing import Protocol

class Sonido(Protocol):
    def hacer_sonido(self) -> str: ...

class Pato:
    def hacer_sonido(self):
        return "Cuac cuac"

class Perro:
    def hacer_sonido(self):
        return "Guau guau"

def emitir_sonido(animal: Sonido) -> str:
    return animal.hacer_sonido()

print(emitir_sonido(Pato()))  # "Cuac cuac"
print(emitir_sonido(Perro()))  # "Guau guau"
```
* Se verifica en herramientas como `mypy` sin necesidad de `isinstance()`.
* No obliga a heredar de una clase base.