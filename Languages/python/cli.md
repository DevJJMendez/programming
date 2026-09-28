# Python CLI
La CLI de Python es la interfaz de línea de comandos desde donde puedes ejecutar scripts, probar código interactivo y gestionar módulos y paquetes.

* Para abrir la CLI de Python en la terminal:
```bash
python3

# en caso de tener varias versiones de Python instaladas
python3.x  # (Ejemplo: python3.10)
```

* Una vez dentro, verás el prompt interactivo:
```bash
Python 3.x.x (default, ...) 
[GCC ...] on Linux  
Type "help", "copyright", "credits" or "license" for more information.  
>>>  
```

* Aquí puedes ejecutar código Python directamente.
```bash
>>> print("Hola, JJ!")  
Hola, JJ!
>>> 2 + 2  
4
```
Para salir de la CLI:
```python
exit()  # O usa Ctrl+D en Linux/macOS
```

## Ejecución de scripts desde la CLI
* Si tienes un script llamado script.py, lo ejecutas con:
```bash
python script.py
```
O con Python 3 explícito:
```bash
python3 script.py
```
Si el script tiene permisos de ejecución en Linux/macOS:
```bash
chmod +x script.py
./script.py  # Si en la primera línea tienes: #!/usr/bin/env python3
```

## Argumentos en la CLI
* Puedes pasar argumentos al script desde la CLI:
```python
python script.py arg1 arg2
```
* Dentro del script, accedes a ellos con `sys.argv`:
```python
import sys

print("Argumentos:", sys.argv)
```
Salida al ejecutarlo con:
```bash
python script.py hola mundo
```
```bash
Argumentos: ['script.py', 'hola', 'mundo']
```

## Opciones y Flags de la CLI
Python tiene varios flags útiles en la CLI:

1. **Modo interactivo y depuración**

| Comando                               | Descripción                                             |
| ------------------------------------- | ------------------------------------------------------- |
| `python -i script.py`                 | Ejecuta el script y deja la sesión interactiva abierta. |
| `python -m pdb script.py`             | Ejecuta el script en el depurador (debugger) integrado. |
| `python -m trace --trace script.py`   | Muestra cada línea ejecutada del script.                |
| `python -m timeit "sum(range(1000))"` | Mide el tiempo de ejecución de un código corto.         |

2. **Inspección y ayuda**

| Comando                        | Descripción                                                       |
| ------------------------------ | ----------------------------------------------------------------- |
| `python -h`                    | Muestra ayuda sobre la CLI.                                       |
| `python -V o python --version` | Muestra la versión instalada de Python.                           |
| `python -c "print(2+2)"`       | Ejecuta código directamente desde la línea de comandos.           |
| `python -m module`             | Ejecuta un módulo como script (ejemplo: `python -m http.server`). |
| `python -m site`               | Muestra rutas de instalación de módulos.                          |

3. **Modos especiales**

| Comando                          | Descripción                                |
| -------------------------------- | ------------------------------------------ |
| `python -m http.server 8000`     | Inicia un servidor HTTP en el puerto 8000. |
| `python -m venv env`             | Crea un entorno virtual llamado env.       |
| `python -m pip install paquete`  | Instala un paquete con pip.                |
| `python -m compileall script.py` | Compila el script a bytecode `.pyc`.       |

## Ejecutar Módulos desde la CLI
Puedes ejecutar módulos estándar directamente:
* **Crear un servidor HTTP local**
```bash
python -m http.server 8080
```
Esto inicia un servidor web en `http://localhost:8080`.

* Lanzar un script en modo debug
```bash
python -m pdb script.py
```
Esto ejecuta el script paso a paso con el depurador.

* Usar el módulo `timeit` para medir rendimiento
```bash
python -m timeit "sum(range(1000))"
```
Esto ejecuta `sum(range(1000))` múltiples veces y muestra el tiempo promedio.

## Python y Entornos Virtuales en la CLI
* Crear un entorno virtual
```bash
python -m venv mi_entorno
```
Esto crea una carpeta mi_entorno/ con un entorno virtual aislado.

* Activar el entorno virtual
```bash
source mi_entorno/bin/activate
```

* Instalar paquetes en el entorno virtual
```bash
pip install requests
```

* Salir del entorno virtual
```bash
deactivate
```

## Ejecutar Código Python sin Archivos
* Puedes ejecutar código corto directamente en la CLI con `-c`:
```bash
python -c "import math; print(math.sqrt(16))"
```
También puedes usar un "aquí documento" en Linux/macOS para ejecutar múltiples líneas:
```bash
python <<EOF
print("Hola desde la CLI!")
for i in range(3):
    print(i)
EOF
```

## Python REPL Mejorado: IPython
Si quieres una CLI más potente, instala y usa IPython:
```bash
pip install ipython
ipython
```
Tiene mejor autocompletado, historial avanzado y colores.

## Python en una Línea: One-Liners
Puedes ejecutar programas completos en una sola línea:

* Imprimir los primeros 10 números pares
```bash
python -c "print([x for x in range(20) if x % 2 == 0])"
```

* Contar líneas en un archivo
```bash
python -c "print(len(open('archivo.txt').readlines()))"
```

* Obtener la IP pública
```bash
python -c "import requests; print(requests.get('https://api64.ipify.org').text)"
```