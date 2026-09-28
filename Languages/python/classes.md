# Clases
Las clases en Python son estructuras fundamentales de la Programación Orientada a Objetos (OOP). Permiten organizar el código en objetos con atributos y métodos, lo que facilita la reutilización y modularidad del software.

Una clase es un molde o plantilla que define los atributos (variables) y comportamientos (métodos) de un objeto.

## Sintaxis Básica
```python
class MiClase:
    pass  # Clase vacía
```

## Creación de Objetos
Para crear una instancia de una clase (un objeto), simplemente llamamos a la clase como si fuera una función:

```python
class Persona:
    def __init__(self, nombre, edad):  # Constructor
        self.nombre = nombre
        self.edad = edad

# Crear objetos
persona1 = Persona("JJ", 25)
persona2 = Persona("Ana", 30)

print(persona1.nombre)  # JJ
print(persona2.edad)    # 30
```
Cada objeto tiene su propio estado almacenado en atributos.

## Atributos en una Clase
Los atributos son variables asociadas a un objeto o a la propia clase.

### Atributos de Instancia
Son únicos para cada objeto y se definen con `self` en el constructor.
```python
class Coche:
    def __init__(self, marca, modelo):
        self.marca = marca  # Atributo de instancia
        self.modelo = modelo

c1 = Coche("Toyota", "Corolla")
c2 = Coche("Honda", "Civic")

print(c1.marca)  # Toyota
print(c2.modelo)  # Civic
```

### Atributos de Clase
Son compartidos por todas las instancias de la clase.
```python
class Coche:
    ruedas = 4  # Atributo de clase

print(Coche.ruedas)  # 4

c1 = Coche()
c2 = Coche()
print(c1.ruedas)  # 4
print(c2.ruedas)  # 4

# Modificar el atributo de clase
Coche.ruedas = 6
print(c1.ruedas)  # 6
print(c2.ruedas)  # 6
```

## Métodos en una Clase
Los métodos son funciones definidas dentro de una clase.

### Métodos de Instancia
Se aplican a una instancia específica y siempre reciben `self` como primer parámetro.
```python
class Persona:
    def __init__(self, nombre):
        self.nombre = nombre

    def saludar(self):
        return f"Hola, soy {self.nombre}."

persona = Persona("JJ")
print(persona.saludar())  # Hola, soy JJ.
```

### Métodos de Clase (`@classmethod`)
Operan sobre la clase en sí y usan `cls` en lugar de `self`.
```python
class Coche:
    ruedas = 4  # Atributo de clase

    @classmethod
    def cambiar_ruedas(cls, cantidad):
        cls.ruedas = cantidad

Coche.cambiar_ruedas(6)
print(Coche.ruedas)  # 6
```

### Métodos Estáticos (@staticmethod)
No dependen de la clase ni de la instancia.
```python
class Calculadora:
    @staticmethod
    def sumar(a, b):
        return a + b

print(Calculadora.sumar(5, 3))  # 8
```

# `@classmethod`
Un método de clase recibe cls como primer argumento, lo que permite acceder o modificar atributos de la clase.

```python
class Configuracion:
    version = "1.0.0"

    @classmethod
    def cambiar_version(cls, nueva_version):
        cls.version = nueva_version

print(Configuracion.version)  # "1.0.0"
Configuracion.cambiar_version("2.0.0")
print(Configuracion.version)  # "2.0.0"
```
* cls.version accede a la variable de clase version.
* Puede modificar atributos de la clase.

Ejemplo práctico: Crear instancias alternativas.
```python
class Usuario:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    @classmethod
    def desde_cadena(cls, cadena):
        nombre, edad = cadena.split(",")
        return cls(nombre, int(edad))

usuario = Usuario.desde_cadena("JJ,25")
print(usuario.nombre, usuario.edad)  # "JJ 25"
```
Se usa para crear instancias de manera flexible.

# `@staticmethod`
Un método estático es una función dentro de una clase, pero no usa self ni cls. Se comporta como una función normal dentro de una clase.

```python
class Utilidad:
    @staticmethod
    def suma(a, b):
        return a + b

print(Utilidad.suma(3, 5))  # 8
```
* No necesita instanciar la clase: Utilidad.suma(3, 5).
* No accede a atributos de la clase.

Ejemplo práctico: Generar un identificador único.
```python
import uuid

class Usuario:
    @staticmethod
    def generar_id():
        return str(uuid.uuid4())

print(Usuario.generar_id())  # "c4a4f1bc-37a9-4df2-9d49-91b1f8466c5a"
```
Se usa para funciones auxiliares que no dependen de la instancia ni de la clase.

