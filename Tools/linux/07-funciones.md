# Funciones
Las funciones en la shell de Linux son bloques de código reutilizables que puedes definir para realizar tareas específicas. A diferencia de los alias, las funciones permiten un mayor nivel de complejidad, incluyendo el uso de parámetros y estructuras de control (como bucles y condicionales). Son extremadamente útiles para automatizar tareas repetitivas o complejas en la terminal.

## Definición de Funciones
Una función en la shell se define utilizando la siguiente sintaxis básica:
```bash
nombre_funcion() {
  # Código de la función
}
```
O alternativamente:
```bash
function nombre_funcion {
  # Código de la función
}
```

## Ejemplo Básico
Aquí hay un ejemplo simple de una función que saluda al usuario:
```bash
saludar() {
  echo "Hola, $1!"
}
```
Para llamar a esta función y pasarle un argumento:
```bash
saludar "Juan"
```
Este comando mostrará:
```bash
Hola, Juan!
```

## Parámetros en Funciones
Las funciones pueden aceptar parámetros que se referencian dentro del cuerpo de la función usando `$1`, `$2`, `$3`, etc., donde `$1` es el primer parámetro, `$2` el segundo, y así sucesivamente.

**Ejemplo**
```bash
suma() {
  resultado=$(($1 + $2))
  echo "La suma de $1 y $2 es: $resultado"
}
```
Para usar la función:
```bash
suma 3 5
```
Salida
```bash
La suma de 3 y 5 es: 8
```

## Retorno de Valores
Por defecto, las funciones en shell no pueden devolver un valor directamente como en otros lenguajes de programación. Sin embargo, puedes usar `echo` para imprimir el resultado y capturarlo utilizando la sustitución de comandos:

```bash
multiplicar() {
  echo $(($1 * $2))
}

resultado=$(multiplicar 4 5)
echo "El resultado es: $resultado"
```
Salida
```bash
El resultado es: 20
```

## Variables Locales
Por defecto, las variables definidas dentro de una función son globales, es decir, están disponibles fuera de la función después de que se ha ejecutado. Si deseas que una variable sea local a la función (es decir, que no afecte el entorno global), puedes usar la palabra clave `local`:

**Ejemplo**
```bash
contar() {
  local contador=0
  while [ $contador -lt $1 ]; do
    echo "Contando: $contador"
    contador=$((contador + 1))
  done
}

contar 5
```
Aquí, la variable contador es `local` a la función `contar` y no afectará ninguna otra variable contador en el entorno global.

## Funciones con Control de Flujo
Puedes utilizar estructuras de control dentro de una función, como if, for, while, etc., para hacer la función más poderosa y flexible.

Ejemplo con `if`
```bash
es_par() {
  if [ $(($1 % 2)) -eq 0 ]; then
    echo "$1 es un número par"
  else
    echo "$1 es un número impar"
  fi
}

es_par 4
```
Salida
```bash
4 es un número par
```

## Funciones dentro de Scripts
Las funciones se pueden definir dentro de scripts Bash para modularizar y organizar mejor el código. Esto es útil cuando un script tiene múltiples tareas que pueden descomponerse en subrutinas.

Ejemplo de Script con Funciones:
```bash
#!/bin/bash

# Función para imprimir el nombre del archivo
imprimir_nombre() {
  echo "El archivo es: $1"
}

# Función para contar líneas en un archivo
contar_lineas() {
  lineas=$(wc -l < "$1")
  echo "El archivo $1 tiene $lineas líneas"
}

# Llamando a las funciones
imprimir_nombre "archivo.txt"
contar_lineas "archivo.txt"
```

## Funciones Reutilizables
Puedes definir funciones reutilizables y cargarlas automáticamente al iniciar una sesión de shell agregándolas a tu archivo de configuración, como ~/.bashrc, ~/.bash_aliases, o ~/.zshrc.

**Ejemplo**:
1. Abre ~/.bashrc o ~/.bash_aliases:
```bash
nano ~/.bashrc
```

2. Añade una función reutilizable:
```bash
decir_hola() {
  echo "Hola, $USER! Bienvenido de nuevo."
}
```

3. Guarda y cierra el archivo, luego recarga el archivo:
```bash
source ~/.bashrc
```
Ahora, la función `decir_hola` estará disponible en todas las sesiones de terminal.

## Funciones vs. Scripts
* Funciones son más adecuadas para comandos repetitivos y pequeñas tareas dentro de la misma sesión de terminal o script.

* Scripts son útiles para tareas más grandes o cuando deseas automatizar procesos que se pueden ejecutar independientemente de una sesión específica.