# Excepciones
El manejo de excepciones en Python permite capturar y gestionar errores en tiempo de ejecución, evitando que el programa se detenga abruptamente.

Una excepción es un evento que ocurre durante la ejecución del programa y altera su flujo normal. Ejemplo:
```python
print(10 / 0)  # ❌ ZeroDivisionError: division by zero
```

## Capturar Excepciones con try-except 🛑
Podemos usar try-except para manejar el error y evitar que el programa falle.
```python
try:
    print(10 / 0)  # Código que puede fallar
except ZeroDivisionError:
    print("❌ No puedes dividir entre cero.")
```

## Capturar Múltiples Excepciones 🔄
Si un bloque de código puede generar diferentes tipos de errores, puedes capturar cada uno por separado:
```python
try:
    x = int("hola")  # ❌ ValueError
except ValueError:
    print("❌ No se puede convertir a número.")
except ZeroDivisionError:
    print("❌ No puedes dividir entre cero.")
```

## Capturar Excepciones Genéricas 🚨
Si no sabes qué error puede ocurrir, usa Exception:
```python
try:
    x = 1 / 0
except Exception as e:
    print(f"⚠️ Ocurrió un error: {e}")
```

## Usar else con try-except ✅
El bloque else se ejecuta solo si no hubo error.
```python
try:
    resultado = 10 / 2  # No hay error
except ZeroDivisionError:
    print("❌ No puedes dividir entre cero.")
else:
    print(f"✅ Resultado: {resultado}")
```

## Usar finally (Código que siempre se ejecuta) 🔄
El bloque finally se ejecuta haya o no haya error. Se usa para liberar recursos.
```python
try:
    file = open("archivo.txt", "r")
    contenido = file.read()
except FileNotFoundError:
    print("❌ Archivo no encontrado.")
finally:
    print("🔄 Cerrando el archivo...")
    file.close()
```

## Lanzar Excepciones con raise 🚀
Puedes generar errores manualmente con raise:
```python
def dividir(a, b):
    if b == 0:
        raise ValueError("❌ No puedes dividir entre cero.")  # Genera un error
    return a / b

print(dividir(10, 0))

# ValueError: ❌ No puedes dividir entre cero.
```

## Definir Excepciones Personalizadas ⚙️
Puedes crear tus propias excepciones:
```python
class MiError(Exception):
    pass

try:
    raise MiError("❌ Esto es un error personalizado.")
except MiError as e:
    print(e)
```