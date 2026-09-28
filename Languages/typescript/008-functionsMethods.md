En TypeScript, functions y methods son componentes fundamentales para estructurar el comportamiento de las aplicaciones. Aunque son similares en muchos aspectos, existen diferencias clave entre ambos conceptos.

## Functions
Una función es un bloque de código reutilizable que puede **recibir argumentos y devolver un valor.** En TypeScript, se utilizan para encapsular lógica, y el sistema de tipado de TypeScript permite definir con precisión los tipos de entrada y salida.

**Definición**
```ts
function suma(a: number, b: number): number {
    return a + b;
}

console.log(suma(5, 3)); // 8
```

* `a` y `b` son los parámetros de la función, ambos de tipo number.

* `: number` después del paréntesis indica que la función devolverá un valor de tipo `number`.

### Arrow Functions
Las arrow functions son una forma concisa de definir funciones, y tienen la ventaja de que el contexto de this se maneja de manera diferente, lo que puede ser útil en situaciones como `callbacks` o métodos de clase.

```ts
const multiplicar = (a: number, b: number): number => a * b;

console.log(multiplicar(4, 2)); // 8
```
La sintaxis de la arrow function es más compacta, y es especialmente útil cuando la función es corta.

### Tipos de Parámetros en Funciones

* **Parámetros Opcionales**: Puedes definir parámetros opcionales utilizando el operador `?`. Si un parámetro es opcional, no es necesario que se pase un valor, pero si lo haces, debe cumplir con el tipo especificado.

    ```ts
    function saludar(nombre: string, saludo?: string): string {
        return saludo ? `${saludo}, ${nombre}` : `Hola, ${nombre}`;
    }

    console.log(saludar('Juan'));               // "Hola, Juan"
    console.log(saludar('Juan', 'Buenos días')); // "Buenos días, Juan"
    ```

* **Parámetros Predeterminados (Default Parameters)**: También puedes proporcionar un valor predeterminado para los parámetros, lo que se utilizará si no se proporciona un valor durante la llamada a la función.

    ```ts
    function elevarAlCuadrado(numero: number = 2): number {
        return numero * numero;
    }

    console.log(elevarAlCuadrado());  // 4
    console.log(elevarAlCuadrado(5)); // 25
    ```
    En este ejemplo, si no se proporciona un valor para el parámetro numero, la función usará el valor 2.

* **Parámetros Rest**: Los parámetros rest permiten que una función acepte un número indefinido de argumentos como una matriz.

    ```ts
    function sumarTodos(...numeros: number[]): number {
        return numeros.reduce((total, numero) => total + numero, 0);
    }

    console.log(sumarTodos(1, 2, 3, 4)); // 10
    ```
    El operador `...` convierte los argumentos en un arreglo que puede ser manipulado dentro de la función.

* **Funciones de Tipo**: En TypeScript, puedes usar tipos o interfaces para describir la estructura de una función. Esto es útil cuando deseas tipar una función que será pasada como argumento o almacenada en una variable.

    ```ts
    type Operacion = (a: number, b: number) => number;

    const suma: Operacion = (a, b) => a + b;
    const resta: Operacion = (a, b) => a - b;

    console.log(suma(4, 2));  // 6
    console.log(resta(4, 2)); // 2
    ```
    Aquí definimos un tipo Operacion, que especifica que cualquier función de este tipo debe recibir dos parámetros de tipo `number` y devolver un `number`.

## Methods
Un método es una función que está definida dentro de un objeto o una clase. Es una función asociada con un **contexto** (generalmente un **objeto** o una instancia de **clase**) y típicamente usa `this` para acceder a las propiedades de su contexto.

```ts
const calculadora = {
    suma(a: number, b: number): number {
        return a + b;
    },
    resta(a: number, b: number): number {
        return a - b;
    }
};

console.log(calculadora.suma(5, 3)); // 8
console.log(calculadora.resta(5, 3)); // 2
```
En este ejemplo, `suma` y `resta` son métodos definidos dentro del objeto `calculadora`.

* **Métodos en Clases**: Los métodos son muy comunes en las clases, donde definen el comportamiento de las instancias.

    ```ts
    class Persona {
        nombre: string;

        constructor(nombre: string) {
            this.nombre = nombre;
        }

        saludar(): string {
            return `Hola, soy ${this.nombre}`;
        }
    }

    const persona = new Persona('Carlos');
    console.log(persona.saludar()); // "Hola, soy Carlos"
    ```
    En este caso, `saludar` es un método de la clase `Persona`. Utiliza `this` para acceder a la propiedad nombre de la instancia.

## Sobrecarga de Funciones
TypeScript admite sobrecarga de funciones, lo que significa que puedes declarar varias versiones de una función con diferentes firmas, aunque todas se implementan en un solo cuerpo de función.

```ts
function combinar(a: string, b: string): string;
function combinar(a: number, b: number): number;
function combinar(a: any, b: any): any {
    return a + b;
}

console.log(combinar(5, 10)); // 15
console.log(combinar('Hola, ', 'mundo')); // "Hola, mundo"
```
Aquí, `combinar` tiene dos firmas: una que acepta números y otra que acepta cadenas, y la implementación final maneja ambos casos.