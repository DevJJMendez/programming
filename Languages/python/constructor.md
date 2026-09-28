# Constructor
* Un constructor en Python es un método especial que se ejecuta automáticamente al crear un objeto de una clase.

* Se usa para inicializar atributos y realizar configuraciones necesarias.

* En Python, el constructor se define con el método especial `__init__`.

## Estructura
```python
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre  # Atributo de instancia
        self.edad = edad

persona1 = Persona("JJ", 25)
print(persona1.nombre)  # "JJ"
print(persona1.edad)    # 25
```
* `__init__` es llamado automáticamente al instanciar **`Persona("JJ", 25)`**.

* `self` hace referencia a la instancia creada.

* Se pueden inicializar múltiples atributos.

## ¿Qué Problema Resuelve?
Sin constructor, tendríamos que asignar atributos manualmente
```python
class Persona:
    pass

persona1 = Persona()
persona1.nombre = "JJ"
persona1.edad = 25
```
* Esto es tedioso y propenso a errores.
* El constructor `__init__` automatiza esta inicialización.

## Tipos de Constructores
### Constructor por Defecto (`__init__`)
Si no definimos un constructor, Python genera uno vacío.
```python
class Ejemplo:
    def __init__(self):
        print("Constructor ejecutado")

obj = Ejemplo()
```
El constructor se ejecuta automáticamente.

### Constructor con Argumentos
Podemos definir valores personalizados al crear objetos.
```python
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

persona1 = Persona("JJ", 25)
print(persona1.nombre)  # "JJ"
```
Se pasa `nombre` y `edad` al instanciar.

### Constructor con Valores por Defecto
Si no se proporciona un valor, se usa el predeterminado.
```python
class Persona:
    def __init__(self, nombre="Anónimo", edad=18):
        self.nombre = nombre
        self.edad = edad

persona1 = Persona()
print(persona1.nombre)  # "Anónimo"
```
Hace que los argumentos sean opcionales.

### Constructor con Argumentos Variables (`*args`, `**kwargs`)
Permite recibir un número indefinido de argumentos.
```python
class Persona:
    def __init__(self, *args, **kwargs):
        self.nombre = kwargs.get("nombre", "Anónimo")
        self.edad = kwargs.get("edad", 18)

persona1 = Persona(nombre="JJ", edad=25)
print(persona1.nombre)  # "JJ"
```
Más flexibilidad en la creación de objetos.

### Constructor de Clase (`@classmethod`)
Se usa para crear instancias de forma alternativa.
```python
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    @classmethod
    def desde_cadena(cls, cadena):
        nombre, edad = cadena.split("-")
        return cls(nombre, int(edad))

persona1 = Persona.desde_cadena("JJ-25")
print(persona1.nombre)  # "JJ"
```
`@classmethod` usa `cls` en vez de `self` para crear objetos.

### Constructor Privado (__new__)
`__new__` se ejecuta antes de `__init__` y controla la creación de la instancia.
```python
class Singleton:
    _instancia = None

    def __new__(cls):
        if cls._instancia is None:
            cls._instancia = super().__new__(cls)
        return cls._instancia

    def __init__(self):
        print("Ejecutando __init__")

obj1 = Singleton()
obj2 = Singleton()
print(obj1 is obj2)  # True
```
Útil para implementar patrones como **`Singleton`**.

# `self`
* `self` es el primer parámetro de los métodos de instancia en una clase en Python.

* Representa la instancia actual del objeto creado a partir de la clase.

* Permite acceder y modificar atributos y métodos de la instancia.

## ¿Para qué sirve self?
* Permite diferenciar entre atributos y métodos de instancia de las variables locales.

* Se usa para acceder a los datos únicos de cada objeto dentro de la clase.

* Hace posible la encapsulación, asegurando que cada instancia tenga su propio estado.

##  ¿Qué problema resuelve self?
* Sin `self`, no podríamos almacenar datos específicos por instancia.

* Ejemplo sin `self` (Incorrecto)
```python
class Persona:
    def __init__(nombre, edad):  # Falta self
        nombre = nombre  # No almacena nada
        edad = edad      # No almacena nada

persona1 = Persona("JJ", 25)
print(persona1.nombre)  # ERROR
```
Python no sabe que `nombre` y `edad` pertenecen a la instancia.

Solución usando `self`
```python
class Persona:
    def __init__(self, nombre, edad):  # Ahora self está presente
        self.nombre = nombre  # Se almacena en la instancia
        self.edad = edad

persona1 = Persona("JJ", 25)
print(persona1.nombre)  # "JJ"
```
`self.nombre` es una propiedad de la instancia, y no una variable local.

## ¿Cómo lo resuelve self?
Cuando creamos un objeto, Python asigna el objeto creado a self dentro de los métodos de instancia.
```python
class Persona:
    def __init__(self, nombre):  # self es el objeto creado
        self.nombre = nombre  # Guarda el dato en la instancia

persona1 = Persona("JJ")  # Se crea un objeto y "self" apunta a él
persona2 = Persona("Ana")  # Se crea otro objeto con sus propios datos

print(persona1.nombre)  # "JJ"
print(persona2.nombre)  # "Ana"
```
`persona1` y `persona2` son instancias independientes con sus propios datos.

## `self` en Métodos de Instancia
`self` es obligatorio en todos los métodos de instancia.
```python
class Ejemplo:
    def mensaje(self):
        return "Hola desde un método de instancia"

obj = Ejemplo()
print(obj.mensaje())  # "Hola desde un método de instancia"
```
Sin `self`, el método no podrá ser llamado por instancias.

## `self` en Métodos de Clase y Métodos Estáticos
`@classmethod` usa `cls` en lugar de `self`
```python
class Ejemplo:
    @classmethod
    def metodo_de_clase(cls):
        print("Método de clase")

Ejemplo.metodo_de_clase()
```
`cls` representa la clase en sí, no una instancia.

## `@staticmethod` no usa `self`
```python
class Ejemplo:
    @staticmethod
    def metodo_estatico():
        print("Método estático sin self")

Ejemplo.metodo_estatico()
```
No accede a datos de la instancia ni de la clase.