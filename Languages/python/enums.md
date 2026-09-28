# Enums
El módulo enum en Python permite definir enumeraciones, que son conjuntos de valores constantes con nombres descriptivos. Son útiles para representar estados, categorías y opciones de forma clara y estructurada.

Un Enum (enumeración) es un conjunto de valores constantes con nombres, lo que ayuda a mejorar la legibilidad y seguridad del código.

Ejemplo sin Enum ❌ (propenso a errores):
```python
ESTADO_ACTIVO = 1
ESTADO_INACTIVO = 2
ESTADO_SUSPENDIDO = 3

estado = 1  # Es difícil saber qué representa este valor
```

Ejemplo con Enum ✅ (más claro y seguro):
```python
from enum import Enum

class Estado(Enum):
    ACTIVO = 1
    INACTIVO = 2
    SUSPENDIDO = 3

estado = Estado.ACTIVO  # Ahora es más entendible
```

## Creando un Enum en Python 🛠️
Ejemplo básico
```python
from enum import Enum

class Color(Enum):
    ROJO = 1
    VERDE = 2
    AZUL = 3

# Acceder a los valores
print(Color.ROJO)        # Color.ROJO
print(Color.ROJO.value)  # 1
print(Color.ROJO.name)   # ROJO
```

## Comparación de Enums 🔍
📌 Las comparaciones deben ser por identidad (is) y no por igualdad (==).

✔ Ejemplo correcto (is) ✅
```python
if estado is Estado.ACTIVO:
    print("El estado es ACTIVO")
```
Ejemplo incorrecto (==)
```python
if estado == Estado.ACTIVO:  # Puede dar problemas en algunos casos
    print("El estado es ACTIVO")
```

## Iterar sobre un Enum 🔄
Puedes recorrer un Enum con un bucle:
```python
for color in Color:
    print(color.name, "=", color.value)

# ROJO = 1
# VERDE = 2
# AZUL = 3
```

## Enum con valores automáticos (auto()) 🔢
📌 Si no quieres asignar valores manualmente, usa auto():
```python
from enum import Enum, auto

class Estado(Enum):
    ACTIVO = auto()
    INACTIVO = auto()
    SUSPENDIDO = auto()

print(Estado.ACTIVO.value)  # 1
print(Estado.INACTIVO.value)  # 2
print(Estado.SUSPENDIDO.value)  # 3
```

## Enums con diferentes tipos de valores 📜
Puedes usar str, int, o tuples en un Enum:
```python
class Rol(Enum):
    ADMIN = "admin"
    USUARIO = "usuario"
    INVITADO = "invitado"

print(Rol.ADMIN.value)  # "admin"
```

## Enums con Métodos Personalizados 
```python
class Estado(Enum):
    ACTIVO = 1
    INACTIVO = 2
    SUSPENDIDO = 3

    def es_activo(self):
        return self is Estado.ACTIVO

print(Estado.ACTIVO.es_activo())  # True
print(Estado.INACTIVO.es_activo())  # False
```

## Enums con Mixins (IntEnum, StrEnum) 🚀
Python ofrece clases base que extienden Enum para que sus valores se comporten como int o str.

📌 IntEnum: Compatible con operaciones matemáticas
```python
from enum import IntEnum

class Prioridad(IntEnum):
    BAJA = 1
    MEDIA = 2
    ALTA = 3

print(Prioridad.ALTA > Prioridad.BAJA)  # True
```
StrEnum: Se comporta como str (Python 3.11+)
```python
from enum import StrEnum

class Estado(StrEnum):
    ACTIVO = "activo"
    INACTIVO = "inactivo"

print(Estado.ACTIVO.lower())  # "activo"
```