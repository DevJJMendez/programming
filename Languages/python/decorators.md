# Decoradores
* Un decorador en Python es una función que **modifica el comportamiento de otra función sin cambiar su código**.

* Se usa el símbolo `@decorador` antes de la función que queremos modificar.

* Son muy utilizados para logging, validaciones, caching, autorización, etc.

## Ejemplo
```python
def decorador(funcion):
    def envoltura():
        print("Ejecutando antes de la función...")
        funcion()
        print("Ejecutando después de la función...")
    return envoltura

def saludo():
    print("¡Hola, mundo!")

saludo = decorador(saludo)  # Decoramos manualmente
saludo()
```
`decorador(saludo)` modifica la función `saludo()` sin cambiar su código.

### Ejemplo con `@decorador` (Forma Pythonica)
```python
def decorador(funcion):
    def envoltura():
        print("Ejecutando antes de la función...")
        funcion()
        print("Ejecutando después de la función...")
    return envoltura

@decorador  # Aplicamos el decorador a la función
def saludo():
    print("¡Hola, mundo!")

saludo()
```
Ahora `saludo()` está decorada automáticamente.

## Decoradores con Argumentos
Decoradores que aceptan argumentos en la función decorada
```python
def decorador(funcion):
    def envoltura(*args, **kwargs):
        print("Ejecutando antes...")
        resultado = funcion(*args, **kwargs)
        print("Ejecutando después...")
        return resultado
    return envoltura

@decorador
def sumar(a, b):
    return a + b

print(sumar(5, 10))  # Ejecuta el decorador y retorna 15
```
Se usan `*args` y `**kwargs` para aceptar cualquier argumento.

## Decoradores con Parámetros
Cuando el decorador mismo necesita argumentos
```python
def repetir(n):
    def decorador(funcion):
        def envoltura(*args, **kwargs):
            for _ in range(n):
                funcion(*args, **kwargs)
        return envoltura
    return decorador

@repetir(3)  # Llamará 3 veces a la función
def saludo():
    print("¡Hola, mundo!")

saludo()
```
`@repetir(3)` permite definir cuántas veces ejecutar la función.

## Decoradores en Clases (Métodos y `staticmethod`)
Decorando métodos de clase
```python
def decorador_metodo(funcion):
    def envoltura(self):
        print("Antes del método")
        funcion(self)
        print("Después del método")
    return envoltura

class Ejemplo:
    @decorador_metodo
    def metodo(self):
        print("Método ejecutado")

obj = Ejemplo()
obj.metodo()
```
Se pasa `self` automáticamente en métodos de clase.

### Decorando `@staticmethod`
```python
class Ejemplo:
    @staticmethod
    def mensaje():
        print("Este es un método estático")

Ejemplo.mensaje()
```
No recibe `self` ni `cls`, porque no depende de una instancia.

## Decoradores en la Librería Estándar
Python ya tiene varios decoradores útiles

* `@staticmethod` → Método sin acceso a self.

* `@classmethod` → Método que recibe la clase cls.

* `@property` → Convierte métodos en atributos.

* `@functools.lru_cache` → Cachea resultados de funciones.

* `@functools.wraps` → Mantiene el `__name__` y `__doc__` en decoradores.

Ejemplo con `@property`
```python
class Persona:
    def __init__(self, nombre):
        self._nombre = nombre

    @property
    def nombre(self):
        return self._nombre

persona = Persona("JJ")
print(persona.nombre)  # "JJ"
```
Ahora `nombre` parece un atributo, pero realmente es un método.