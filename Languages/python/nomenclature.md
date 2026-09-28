# Nomenclaturas
## Nomenclatura de Archivos Python (`.py`)
* Usar letras minúsculas y separar palabras con guiones bajos (`_`).

* Evitar caracteres especiales o espacios.

* No usar nombres de módulos estándar de Python (`string.py`, `json.py`, etc.).
```bash
# Correcto
mi_script.py 
gestor_usuarios.py 
procesar_datos.py 

# Incorrecto
Miscript.py   # ❌ No usar mayúsculas
GestorUsuarios.py  # ❌ No usar PascalCase en archivos
procesar-datos.py  # ❌ No usar guiones (-), solo guion bajo (_)
```

## Variables y Constantes
* Usar snake_case (minúsculas con `_`).

* Para constantes, usar **`SCREAMING_SNAKE_CASE`** (todas mayúsculas).

* Evitar nombres de una sola letra (excepto en bucles).

* Los nombres deben ser descriptivos y claros.
```python
nombre_usuario = "JJ"
contador_errores = 0

PI = 3.1416
MAX_INTENTOS = 5
```

## Clases
* Usar **`PascalCase`** (Primera letra de cada palabra en mayúscula).

* No usar guiones bajos `_` entre palabras.
```python
class UsuarioAdmin:
    pass
```

## Métodos y Funciones
* Usar **`snake_case`**.

* Si el método es privado (interno), empezar con `_`.

* Para métodos especiales (`dunder methods`), usar **`__nombre__`**.
```python
def calcular_total():
    pass

def _metodo_privado():
    pass

class Ejemplo:
    def __init__(self):  # Constructor en Python
        pass
```

## Nombres de Estructuras de Datos (Listas, Diccionarios, Tuplas, etc.)
* Usar nombres descriptivos en snake_case.

* Usar plural para estructuras que almacenan múltiples elementos.
```python
usuarios = ["Juan", "María", "Carlos"]  # Lista
edades_por_usuario = {"Juan": 30, "María": 25}  # Diccionario
coordenadas = (10, 20)  # Tupla
```

## Enumeraciones (Enums)
* Usar **`PascalCase`** para la clase.

* Usar **`SCREAMING_SNAKE_CASE`** para los valores.
```python
from enum import Enum

class EstadoPedido(Enum):
    PENDIENTE = 1
    EN_PROCESO = 2
    ENTREGADO = 3
```

## Módulos y Paquetes
* Usar minúsculas con `_`.

* No usar `-` ni espacios.
```python
miproyecto/
├── modelos/
│   ├── usuario.py
│   ├── producto.py
│   └── __init__.py
├── utils/
│   ├── calculadora.py
│   └── validaciones.py
└── main.py
```

##  Parámetros de Función y Argumentos
* Usar `snake_case`.

* Evitar nombres genéricos como `x`, `y`, `data`, excepto en casos específicos (como coordenadas).

* Si un parámetro es opcional, usar un valor por defecto.
```python
def procesar_datos(nombre_archivo, modo="lectura"):
    pass
```

## Variables Globales y Constantes
* Usar **`SCREAMING_SNAKE_CASE`**.

* No modificar variables globales dentro de funciones (usar global solo si es estrictamente necesario).
```python
MAX_CONEXIONES = 100
TIEMPO_ESPERA = 30
```

## Prefijos y Convenciones Especiales
| Prefijo/Sufijo | Uso                                                   | Ejemplo               |
| -------------- | ----------------------------------------------------- | --------------------- |
| `_variable`    | Variable privada (convención, no restricción real)    | `_contador_errores`   |
| `__variable`   | Evita colisiones de nombres en clases (name mangling) | `__clave_secreta`     |
| `__dunder__`   | Métodos especiales de Python                          | `__init__`, `__str__` |
| `variable_`    | Evita colisión con palabras clave de Python           | `class_`, `lambda_`   |