# Directivas de pre-procesador
Las directivas del preprocesador en `C` son instrucciones que se ejecutan antes de que el código sea compilado por el compilador. El preprocesador de **C** procesa estas directivas y realiza tareas como la inclusión de archivos, sustitución de macros, y gestión de condiciones de compilación. No son parte del lenguaje **C** en sí, pero forman una etapa crucial antes de la compilación real del código.

## ¿Qué son las directivas del preprocesador?
* Son comandos que empiezan con el carácter `#`.
* Se procesan antes de la compilación.
* No generan código directamente; más bien, modifican el código fuente antes de que lo vea el compilador.

## ¿Para qué sirven?
Las directivas del preprocesador realizan tareas repetitivas y comunes en los programas, como:

* Incluir otros archivos de código.
* Definir constantes o macros que pueden ser reutilizadas.
* Definir compilación condicional (compilar o excluir bloques de código dependiendo de ciertas condiciones).

* Evitar la inclusión múltiple de archivos de cabecera.

## Principales directivas del preprocesador
1. `#include`

   * **Función**: Incluye archivos de cabecera en el código.
   
   * **Sintaxis**
     * Archivos del sistema `#include <nombreArchivo>`
     
     * Archivos locales `#include "nombreDelArchivo"`
   
   *  **Propósito**: Esto inserta el contenido de otro archivo en el código fuente. Los archivos de cabecera suelen tener declaraciones de funciones, macros, y estructuras.

   * **Ejemplo**
    ```c
    #include <stdio.h> // archivo estándar del sistema

    #include "mi_archivo.h" // archivo local del proyecto
    ```

2. `#define`
   
   * **Función**: Definir constantes o macros.
   
   * **Sintaxis**:
    ```c
    #define NOMBRE valor

    #define MACRO(parametro) (operación con parametro)
    ```
   
   * **Propósito**: Define símbolos que serán sustituidos en el código por el preprocesador. Esto es útil para evitar "hardcodear" valores y reutilizar constantes.
   
   * **Ejemplo**
    ```c
    #define PI 3.1416

    #define CUADRADO(x) ((x) * (x)) // define una macro con un parametro
    ```

3. `#undef`

   * **Función**: Eliminar una definición previa de una macro.
   
   * **Sintaxis**: `#undef NOMBRE`
   
   * **Propósito**: Útil cuando deseas redefinir una macro o eliminar su definición.

   * **Ejemplo**
    ```c
    #define TEMP 30

    #undef TEMP  // Se elimina la definición de TEMP
    ```

4. `#ifdef`, `#ifndef`, `#if`, `#else`, `#elif`, `#endif`:

   * **Propósito**: Permiten incluir o excluir partes del código dependiendo de ciertas condiciones o definiciones.
     
     * `#ifdef`: Compila el bloque si una macro está definida.

     * `#ifndef`: Compila el bloque si una macro no está definida.

     * `#if`: Compila el bloque si una expresión booleana es verdadera.

     * `#else` y `#elif`: Proporcionan una alternativa a la condición anterior.

     * `#endif`: Marca el final del bloque condicional.

   * **Ejemplo**
    ```c
    #define DEBUG

    #ifdef DEBUG
    printf("Modo de depuración activado\n");
    #else
    printf("Modo de depuración desactivado\n");
    #endif
    ```

5. `#pragma`:

   * **Función**: Instrucciones específicas del compilador.

   * **Propósito**: Se utiliza para dar directivas específicas al compilador, que pueden variar según el compilador utilizado. Generalmente se usa para control avanzado del compilador.

   * **Ejemplo**
    ```c
    #pragma once  // Evita la inclusión múltiple de un archivo (similar a #ifndef)
    ```

6. `#error` y `#warning`:

   * **Función**: Generan errores o advertencias en la fase de preprocesamiento.

   * **Propósito**: Se usan para interrumpir el proceso de compilación o advertir de posibles problemas si ciertas condiciones no se cumplen.

   * **Ejemplo**
    ```c
    #ifndef VERSION
    #error "Se requiere definir VERSION"
    #endif
    ```

7. `#line`:

   * **Función**: Cambiar el número de línea y el nombre de archivo reportados por el compilador.

   * **Propósito**: Cambia el número de línea en los mensajes de error o advertencia para facilitar el depurado.

   * **Ejemplo**
    ```c
    #line 100 "archivo.c"
    ```

8. `#include guard` (protección contra múltiples inclusiones):

   * **Función**: Evitar la inclusión múltiple de un archivo de cabecera.

   * **Sintaxis**: Se utilizan #ifndef, #define y #endif para lograr esto.

   * **Propósito**: Evita que un archivo de cabecera sea incluido más de una vez, lo que puede generar errores de redefinición.

   * **Ejemplo**
    ```c
    #ifndef MI_ARCHIVO_H
    #define MI_ARCHIVO_H

    // Contenido del archivo

    #endif  // Fin de la protección
    ```

## ¿Qué resuelven las directivas del preprocesador?
* **Modularidad**: Facilitan la inclusión de archivos externos que contienen declaraciones reutilizables, como funciones y macros.

* **Evitan errores de redefinición**: Gracias a las protecciones contra múltiples inclusiones (`#ifndef`, `#define`, `#endif`).

* **Control de compilación**: Permiten compilar solo ciertas partes del código, dependiendo de las condiciones definidas, lo que es útil para manejar diferentes versiones de un programa (como versiones de depuración y producción).

* **Optimización del código**: Mediante el uso de macros y la compilación condicional, puedes reducir el código repetido o innecesario.

## ¿Cuándo se usan?
* **En la modularización del código**: Se utilizan para incluir funciones y variables que están declaradas en otros archivos (#include).

* **Para definir constantes y macros reutilizables**: Evitas la repetición de valores o bloques de código comunes en todo el proyecto (#define).

* **En compilación condicional**: Para compilar solo ciertas partes del código dependiendo de definiciones previas o configuraciones (#ifdef, #ifndef).

* **En casos avanzados**: Cuando necesitas optimizaciones específicas del compilador o personalizaciones (#pragma).