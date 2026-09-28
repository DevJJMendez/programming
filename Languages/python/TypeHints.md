# Type Hints
* Type Hints en Python permiten anotar los tipos de datos en variables, parámetros y valores de retorno.

* Python sigue siendo dinámicamente tipado, pero los Type Hints ayudan a detectar errores antes de ejecutar el código.

* Se introdujeron en Python 3.5 y han mejorado en versiones posteriores.

## Beneficios de Usar Type Hints 🎯
* Mejor legibilidad del código.

* Facilita el mantenimiento en proyectos grandes.

* Mejor soporte en editores como PyCharm, VS Code.

* Detecta errores temprano usando herramientas como `mypy`.

## Cómo Usar Type Hints ✍️
Ejemplo básico de anotaciones de tipos en funciones
```python
def suma(a: int, b: int) -> int:
    return a + b
```
* `a: int, b: int` indica que los parámetros deben ser enteros.
* `-> int` indica que la función retorna un entero.

### Variables con Type Hints
```python
edad: int = 25
nombre: str = "JJ"
precio: float = 19.99
activo: bool = True
```

## Type Hints en Listas, Diccionarios y Tuplas
### Colecciones con list, dict, tuple
```python
from typing import List, Dict, Tuple

nombres: List[str] = ["Alice", "Bob", "Charlie"]
edades: Dict[str, int] = {"Alice": 30, "Bob": 25}
coordenadas: Tuple[float, float] = (10.5, -20.3)
```
* List[str] → Lista de cadenas.
* Dict[str, int] → Diccionario donde las claves son str y los valores int.
* Tuple[float, float] → Tupla de dos float.

Desde Python 3.9 se pueden usar los tipos nativos directamente
```python
nombres: list[str] = ["Alice", "Bob"]
edades: dict[str, int] = {"Alice": 30, "Bob": 25}
```

## Type Hints en Clases y Objetos
```python
class Persona:
    def __init__(self, nombre: str, edad: int):
        self.nombre: str = nombre
        self.edad: int = edad

    def saludo(self) -> str:
        return f"Hola, soy {self.nombre}"

p: Persona = Persona("JJ", 25)
print(p.saludo())  # "Hola, soy JJ"
```
* Se anotan los atributos dentro del constructor.
* Se usa Persona como tipo de variable.

## Optional y Union para Tipos Múltiples
* Cuando una variable puede ser `None`
```python
from typing import Optional

def obtener_nombre(id: int) -> Optional[str]:
    if id == 1:
        return "Alice"
    return None
```
Optional[str] equivale a Union[str, None].

* Cuando una variable puede tener varios tipos
```python
from typing import Union

numero: Union[int, float] = 3.5
```
Union[int, float] indica que numero puede ser int o float.

## Type Hints en Funciones con Callable
Para indicar que un argumento es una función
```python
from typing import Callable

def operar(a: int, b: int, funcion: Callable[[int, int], int]) -> int:
    return funcion(a, b)

def sumar(x: int, y: int) -> int:
    return x + y

print(operar(3, 5, sumar))  # 8
```
Callable[[int, int], int] indica que el argumento es una función que recibe dos int y retorna un int.

## Type Hints en Generadores (Generator) 🔄
Para funciones que generan valores en un yield
```python
from typing import Generator

def contar(n: int) -> Generator[int, None, None]:
    for i in range(n):
        yield i
```
Generator[int, None, None] indica que yield devuelve int.

## Type Hints con Self en Métodos (Python 3.11) 🏗️
* Antes de Python 3.11, se usaba 'Clase' como string para retornar una instancia de la misma clase
```python
from typing import Type

class Persona:
    def crear_persona(cls: Type["Persona"]) -> "Persona":
        return cls()
```
* Desde Python 3.11 se usa Self
```python
from typing import Self

class Persona:
    def copiar(self) -> Self:
        return self
```
Self representa una instancia de la misma clase.