## Funciones
Una función en **C** es un bloque de código con un **nombre** que puede ser llamado desde cualquier parte del programa. Las funciones permiten agrupar un conjunto de instrucciones que realizan una tarea específica y pueden recibir **datos como entrada (parámetros)** y devolver un **valor como salida**.

En **C**, cada programa tiene al menos una función, llamada `main()`, que es el punto de entrada del programa.

### ¿Para qué se usan?
Las funciones se utilizan para:

1. **Organizar** el código dividiéndolo en módulos más pequeños y manejables.

2. **Reutilizar código**: Una función puede ser llamada varias veces en un programa, evitando la duplicación de código.

3. **Facilitar el mantenimiento**: Al tener el código organizado en funciones, es más fácil localizar y corregir errores.

4. **Abstraer la complejidad**: Las funciones permiten ocultar la complejidad de ciertas operaciones, haciendo el código más comprensible.

### ¿Qué resuelven?
Las funciones resuelven varios problemas comunes en la programación:

1. **Modularidad**: Permiten dividir un programa grande en módulos más pequeños, haciendo que el código sea más fácil de entender y gestionar.

2. **Reutilización de código**: Evitan la repetición de bloques de código, facilitando la reutilización en diferentes partes del programa.

3. **Mantenibilidad**: El código modular es más fácil de mantener, probar y depurar.

4. **Abstracción**: Facilitan la creación de una interfaz clara y ocultan la complejidad del funcionamiento interno.

### ¿Cómo lo resuelven?
1. Definición de una función: Se define una función con un nombre, tipo de retorno, y parámetros opcionales.

**Sintaxis**
```c
tipo_de_retorno nombre_funcion(tipo_parametro1 nombre_parametro1, tipo_parametro2 nombre_parametro2, ...) {
    // Cuerpo de la función
    return valor; // Si es necesario devolver un valor
}
```
**Ejemplo**
```c
int sumar(int a, int b) {
    return a + b;
}
```

2. Llamada a una función: Una vez definida, se puede "llamar" a la función desde cualquier parte del programa, pasando los parámetros si es necesario.

**Sintaxis**
```c
nombre_funcion(argumento1, argumento2, ...);

```
**Ejemplo**
```c
int resultado = sumar(3, 5); // Llama a la función sumar() y almacena el resultado
```

3. Parámetros y retorno:

Las funciones pueden recibir parámetros para operar sobre ellos y opcionalmente devolver un valor utilizando return.
Si una función no devuelve ningún valor, se utiliza el tipo void como tipo de retorno.

4. Modularización: Puedes dividir un programa en múltiples funciones, donde cada una se encarga de una tarea específica, lo que facilita la legibilidad y organización.

### ¿Cuándo se usan?
Las funciones se utilizan en los siguientes casos:

1. **Cuando una operación se repite**: Si una tarea se realiza varias veces, es mejor encapsularla en una función y llamarla cuando sea necesario.

2. **Para organizar código**: En programas grandes, usar funciones ayuda a mantener el código organizado y fácil de seguir.

3. **Para simplificar la lógica**: Dividir la lógica compleja en funciones más pequeñas hace que el programa sea más claro y fácil de entender.

4. **Para mejorar la legibilidad y mantenimiento**: Al encapsular tareas específicas en funciones, es más fácil hacer cambios o corregir errores en áreas específicas del código sin afectar al resto del programa.

## Tipos de funciones
1. **Funciones sin parámetros y sin retorno**: Realizan una acción, pero no devuelven un valor y no reciben parámetros.
    ```c
    void imprimirMensaje() {
        printf("Este es un mensaje.\n");
    }
    ```

2. **Funciones con parámetros y sin retorno**: Reciben datos como entrada, pero no devuelven un valor.
    ```c
    void imprimirNumero(int num) {
        printf("El número es: %d\n", num);
    }
    ```

3. **Funciones sin parámetros y con retorno**: No reciben datos, pero devuelven un valor.
    ```c
    int obtenerNumero() {
        return 42;
    }
    ```

4. **Funciones con parámetros y con retorno**: Reciben datos y devuelven un valor.
    ```c
    int multiplicar(int a, int b) {
        return a * b;
    }
    ```

## ¿Qué son los argumentos?
Los argumentos son los valores reales que se pasan a una función cuando esta es llamada. Estos valores son utilizados por la función para realizar su tarea. Los argumentos se corresponden con los parámetros definidos en la función.

**Ejemplo**
```c
int sumar(int a, int b) {
    return a + b;
}

int main() {
    int resultado = sumar(3, 5); // 3 y 5 son los argumentos
    printf("Resultado: %d\n", resultado);
    return 0;
}
```
En este caso, los números 3 y 5 son los argumentos que se pasan a la función `sumar` cuando se llama desde `main`.

## ¿Qué son los parámetros?
Los parámetros son las variables que se definen en la declaración de una función y que actúan como "contenedores" para los valores que se pasan (es decir, los argumentos). Los parámetros permiten a la función procesar los datos proporcionados durante su invocación.

**Ejemplo**
```c
int sumar(int a, int b) {
    return a + b; // 'a' y 'b' son los parámetros
}
```
Aquí, `a` y `b` son los parámetros de la función `sumar`, que reciben los valores pasados como argumentos cuando la función es llamada.

## ¿Qué es el return statement?
El return statement en C se utiliza para devolver un valor desde una función al bloque de código que la llamó. Finaliza la ejecución de la función y envía el valor de retorno a la llamada de la función.

* En funciones que tienen un tipo de retorno (como `int`, `float`, etc.), el return se utiliza para devolver un valor del mismo tipo.

* Si la función tiene un tipo de retorno `void`, no se necesita un `return` con valor, pero se puede usar solo `return;` para terminar la función.

**Ejemplo**
```c
int sumar(int a, int b) {
    return a + b; // Devuelve la suma de 'a' y 'b'
}

void imprimirMensaje() {
    printf("Hola!\n");
    return; // No devuelve ningún valor, solo finaliza la ejecución
}
```

### Tipos de retorno y su uso
El tipo de retorno de una función es el tipo de dato que la función devolverá cuando se complete. Si una función no devuelve nada, su tipo de retorno es `void`.

1. **`void`**: No devuelve ningún valor. Se usa cuando la función realiza una tarea pero no necesita devolver un resultado.
    ```c
    void saludar() {
        printf("Hola!\n");
    }
    ```

2. **`int`**: Devuelve un valor de tipo entero (int).
    ```c
    int obtenerEdad() {
        return 25; // Devuelve un entero
    }
    ```

3. **`float`**/**`double`**: Devuelve un valor de tipo punto flotante (float o double).
    ```c
    float obtenerPromedio(float a, float b) {
        return (a + b) / 2;
    }
    ```

4. **`char`**: Devuelve un valor de tipo carácter (char).
    ```c
    char obtenerLetra() {
        return 'A'; // Devuelve un carácter
    }
    ```

5. **`Punteros`**: Una función también puede devolver un puntero (por ejemplo, un puntero a un array o una estructura).
    ```c
    int* obtenerArray() {
        static int array[5] = {1, 2, 3, 4, 5};
        return array; // Devuelve un puntero al array
    }
    ```
