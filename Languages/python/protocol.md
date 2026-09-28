# Protocol
Permite escribir interfaces explícitas.

Protocol es una clase base abstracta introducida en typing (desde Python 3.8) que permite definir interfaces estructurales.

📌 En vez de verificar el tipo real de un objeto, verifica si implementa ciertos métodos o atributos, es decir, si “se comporta como” lo que necesita.

➡️ ¡Esto es Duck Typing con esteroides, pero con chequeo estático!

"If it looks like a duck and quacks like a duck, it’s a duck" 🦆
Con Protocol, el type checker puede comprobar eso sin necesidad de herencia.

## ¿Cómo se usa?
```python
from typing import Protocol

class Describible(Protocol):
    def describe(self) -> str:
        ...
```
Esto define un protocolo: cualquier objeto que tenga un método describe() que devuelva str es válido.

## Ejemplo de uso
```python
class Persona:
    def describe(self) -> str:
        return "Soy una persona"

class Robot:
    def describe(self) -> str:
        return "Soy un robot"

def imprimir_descripcion(obj: Describible):
    print(obj.describe())

imprimir_descripcion(Persona())  # ✅
imprimir_descripcion(Robot())    # ✅
```
Ambas clases funcionan aunque no heredan explícitamente de Describible, porque cumplen con su contrato.

## Qué resuelve?
❌ Problema:
Python es dinámico, lo cual da mucha libertad… pero también pocos controles en tiempo de desarrollo.

✅ Protocol:
Permite que herramientas como mypy o Pyright validen que tu código cumple con las interfaces.

Te da seguridad de que tus objetos cumplen con los contratos requeridos.

Potencia el diseño orientado a interfaces sin necesidad de herencia formal.

## Protocols con atributos
```python
class Usuario(Protocol):
    nombre: str

class Admin:
    nombre = "Admin User"

def saludar(u: Usuario):
    print(f"Hola, {u.nombre}")

saludar(Admin())  # ✅ Funciona porque tiene el atributo `nombre`
```