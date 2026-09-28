# `.gitignore`
El archivo **.gitignore** es una parte fundamental en la gestión de repositorios en **Git**. Su principal función es decirle a **Git** qué archivos o directorios debe ignorar, es decir, que no deben ser rastreados ni versionados. Esto es especialmente útil para evitar incluir archivos innecesarios o que pueden cambiar entre entornos, como archivos de configuración locales, dependencias de terceros o archivos temporales.

## ¿Qué es el archivo .gitignore?
* El archivo **.gitignore** es un archivo de texto simple que contiene patrones de nombres de archivos y directorios que **Git** debe ignorar.

* Los archivos y directorios especificados en **.gitignore** no se agregarán al área de preparación (staging area) ni al historial de **Git**, aunque existan en tu directorio de trabajo.

* Cada repositorio puede tener su propio archivo **.gitignore** personalizado, y puede colocarse en el nivel raíz del proyecto o en cualquier subdirectorio.

## ¿Por qué es importante?
Existen varios tipos de archivos que generalmente no deberían ser versionados:

* Archivos binarios como compilaciones o ejecutables.

* Archivos de configuración del entorno que varían de un desarrollador a otro (por ejemplo, archivos de entorno local como **.env**).

* Dependencias generadas automáticamente (por ejemplo, **node_modules** en proyectos de Node.js).

* Archivos temporales como logs, cachés, y archivos de compilación intermedios.

## Estructura
```bash
# Ignorar el directorio node_modules/
node_modules/

# Ignorar archivos de entorno
.env

# Ignorar logs
*.log

# Ignorar archivos temporales del sistema operativo
*.swp
```
## Sintaxis
La sintaxis de .gitignore es simple pero poderosa. Aquí están las reglas más importantes:

* **Ignorar un archivo específico**: Para ignorar un archivo específico, solo escribe su nombre o ruta:

  ```plaintext
  # Ignorar un archivo llamado secret.txt
  secret.txt
  ```

* **Ignorar un directorio completo**: Para ignorar todo un directorio, añade una barra `/` al final:

  ```plaintext
  # Ignorar la carpeta build/
  build/
  ```

* **Ignorar todos los archivos de un tipo**: Para ignorar todos los archivos de un cierto tipo o con una extensión específica, usa el carácter `*` (comodín):

  ```plaintext
  # Ignorar todos los archivos .log
  *.log

  # Ignorar todos los archivos .tmp en cualquier lugar
  *.tmp
  ```

* **Ignorar archivos en un subdirectorio específico**: Para ignorar un tipo de archivo solo en un subdirectorio específico, usa la ruta completa:

  ```plaintext
  # Ignorar todos los archivos .txt solo en el directorio docs/
  docs/*.txt
  ```

* **Excluir archivos previamente ignorados**: Si necesitas ignorar un conjunto de archivos, pero hacer excepciones, puedes usar el carácter `!`

  ```plaintext
  # Ignorar todos los archivos .log excepto debug.log
  *.log
  !debug.log
  ```

* **Ignorar archivos dentro de subdirectorios**: Para ignorar todos los archivos con un patrón dentro de cualquier subdirectorio, usa `**`:

  ```plaintext
  # Ignorar todos los archivos .log en cualquier subdirectorio
  **/*.log
  ```

* **Ignorar carpetas ocultas**: Para ignorar todas las carpetas ocultas (las que empiezan con un punto):

  ```plaintext
  # Ignorar todas las carpetas ocultas
  .*
  ```