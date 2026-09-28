# Clases Abstractas
Las clases abstractas en Python se usan para definir una estructura base para otras clases. Son útiles cuando queremos asegurarnos de que ciertas clases tengan métodos específicos, pero sin definir su implementación.

**Se implementan con `ABC` (Abstract Base Class) del módulo `abc`.**

## ¿Qué es una Clase Abstracta? 🤔
📌 Es una clase que no se puede instanciar y que puede contener métodos abstractos (sin implementación).

Ejemplo de clase abstracta:
```python
from abc import ABC, abstractmethod

class Animal(ABC):  # 🔹 Esta es una clase abstracta
    @abstractmethod
    def hacer_sonido(self):
        pass  # ❌ No tiene implementación

class Perro(Animal):
    def hacer_sonido(self):
        return "Guau!"

# animal = Animal()  # ❌ ERROR: No se puede instanciar
perro = Perro()
print(perro.hacer_sonido())  # "Guau!"
```
**Reglas clave:**
* No se puede instanciar `Animal()`.
* Cualquier clase hija debe implementar `hacer_sonido()`.

## Métodos Abstractos y Concretos 🏗️
Una clase abstracta puede tener métodos normales (concretos) además de los abstractos.
```python
class Figura(ABC):
    @abstractmethod
    def area(self):
        pass

    def descripcion(self):
        return "Soy una figura geométrica"

class Circulo(Figura):
    def __init__(self, radio):
        self.radio = radio

    def area(self):
        return 3.14 * self.radio ** 2

circulo = Circulo(5)
print(circulo.area())  # 78.5
print(circulo.descripcion())  # "Soy una figura geométrica"
```
* `area()` es abstracto, debe ser implementado en Circulo.
* `descripcion()` es un método normal, accesible por las clases hijas.

## Métodos Estáticos y de Clase en Clases Abstractas 📌
Podemos usar `@staticmethod` y @`classmethod` en métodos abstractos.
```python
class Logger(ABC):
    @staticmethod
    @abstractmethod
    def log(mensaje):
        pass

class ConsoleLogger(Logger):
    @staticmethod
    def log(mensaje):
        print(f"[LOG]: {mensaje}")

ConsoleLogger.log("Mensaje de prueba")  # "[LOG]: Mensaje de prueba"
```
Se puede llamar a ConsoleLogger.log() sin instanciar la clase.

## Clases Abstractas con Propiedades 🏠
Se pueden definir propiedades abstractas usando @property en una clase abstracta.
```python
class Persona(ABC):
    @property
    @abstractmethod
    def nombre(self):
        pass

class Usuario(Persona):
    def __init__(self, nombre):
        self._nombre = nombre

    @property
    def nombre(self):
        return self._nombre

usuario = Usuario("JJ")
print(usuario.nombre)  # "JJ"
```

## Verificando si una Clase es Subclase de una Clase Abstracta
```python
print(issubclass(Perro, Animal))  # True
print(issubclass(Circulo, Figura))  # True
print(issubclass(Animal, Figura))  # False
```
`issubclass(Hija, Base)` verifica si una clase hereda de otra.