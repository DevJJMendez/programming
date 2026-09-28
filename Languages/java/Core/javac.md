#core
# Javac
**javac** es el compilador de Java, una herramienta clave en el ciclo de desarrollo de cualquier aplicación escrita en este lenguaje. Se encarga de transformar el código fuente escrito en archivos `.java` en bytecode que se almacena en archivos `.class`. Este bytecode es independiente de la plataforma, lo que permite que las aplicaciones Java se ejecuten en cualquier sistema que cuente con una **Java Virtual Machine (JVM)**.

## ¿Qué es javac?
javac es el compilador oficial del lenguaje Java, que convierte el código fuente de Java en **bytecode**. Este bytecode es luego ejecutado por la JVM, lo que hace que **javac** sea un componente esencial para compilar y ejecutar aplicaciones Java.

Cuando ejecutas un comando como:
```bash
javac MiClase.java
```
el compilador javac genera un archivo `MiClase.class`, que contiene el bytecode necesario para que la JVM ejecute el programa.

## ¿Qué resuelve javac?
javac resuelve varios problemas fundamentales en el proceso de desarrollo:

1. **Portabilidad**: Al compilar el código fuente en bytecode, el mismo programa Java puede ejecutarse en cualquier sistema operativo o arquitectura de hardware, siempre que haya una JVM disponible. Esto elimina la necesidad de recompilar el programa para diferentes plataformas.

2. **Detección de errores en tiempo de compilación**: **javac** realiza una serie de verificaciones durante la compilación para garantizar que el código fuente no tenga errores sintácticos ni violaciones de tipos. Por ejemplo, verifica que las variables sean del tipo correcto, que los métodos existan, que las declaraciones de clases estén bien formadas, entre otras comprobaciones.

3. **Generación de bytecode eficiente**: El compilador no solo convierte el código fuente a bytecode, sino que lo optimiza para que la JVM pueda ejecutarlo eficientemente, mejorando el rendimiento en tiempo de ejecución.

## ¿Cómo funciona javac?
El proceso de compilación de javac implica varios pasos que transforman el código fuente en bytecode listo para ser ejecutado por la JVM. Estos son los pasos principales:

1. **Análisis léxico**: El compilador descompone el código fuente en sus partes fundamentales (**tokens**), identificando palabras clave, identificadores, operadores, y otros elementos básicos del lenguaje.

2. **Análisis sintáctico**: **javac** organiza estos tokens en estructuras lógicas según las reglas gramaticales de Java, como declaraciones de clases, métodos y expresiones.

3. **Análisis semántico**: Aquí, el compilador verifica la corrección del código, como asegurarse de que las variables estén declaradas antes de usarse, que los tipos de datos coincidan y que se respeten las reglas de accesibilidad de clases y métodos.

4. **Generación de bytecode**: Finalmente, el código fuente se transforma en bytecode, que es una representación más compacta y eficiente del programa.

## Ejemplo básico del uso de javac
Supongamos que tienes un archivo Java llamado `HolaMundo.java` con el siguiente código:

```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hola, mundo!");
    }
}
```
Para compilar este archivo utilizando **javac**, debes ejecutar el siguiente comando en la línea de comandos:

```bash
javac HolaMundo.java
```
Este comando generará un archivo llamado `HolaMundo.class`, que contiene el bytecode necesario para ejecutar el programa en cualquier sistema con una JVM instalada.

Para ejecutarlo, se utiliza el comando:
```bash
java HolaMundo
```

## Parámetros y opciones comunes de `javac`
* **Compilar múltiples archivos**: Puedes compilar varios archivos `.java` a la vez con:

  ```bash
  javac Archivo1.java Archivo2.java
  ```

* **Especificar directorio de salida**: Puedes decirle a **javac** que coloque los archivos .class en un directorio específico con la opción `-d`:

  ```bash
  javac -d bin MiClase.java
  ```
  Esto creará el archivo compilado en el directorio `bin`.

* **Agregar dependencias al classpath**: Si tu código depende de librerías externas, puedes incluirlas en el classpath con la opción `-classpath` o `-cp`:

  ```bash
  javac -classpath lib/mi-libreria.jar MiClase.java
  ```

* **Mostrar advertencias**: El compilador puede mostrar advertencias adicionales sobre posibles problemas en el código usando el flag `-Xlint`:

  ```bash
  javac -Xlint MiClase.java
  ```

* **Especificar la versión de la JVM**: Puedes usar la opción `-source` para decirle al compilador que use una versión específica de Java, útil para asegurar compatibilidad:

  ```bash
  javac -source 1.8 MiClase.java
  ```

* **Compilar con depuración**: Para incluir información de depuración (como nombres de variables locales y números de línea) en los archivos `.class`, puedes usar el flag `-g`:

  ```bash
  javac -g MiClase.java
  ```