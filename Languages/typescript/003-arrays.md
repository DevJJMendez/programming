## Arrays
En TypeScript, puedes definir arreglos de varias maneras.

1. **Usando Notación de Corchetes `[]`**:

    ```ts
    let numeros: number[] = [1, 2, 3, 4];
    let nombres: string[] = ['Juan', 'Ana', 'Luis'];
    ```

2. Usando el Tipo `Array<T>`

    ```ts
    let numeros: Array<number> = [1, 2, 3, 4];
    let nombres: Array<string> = ['Juan', 'Ana', 'Luis'];
    ```

## Readonly
En TypeScript, el tipo `Readonly` y su versión de arreglo `ReadonlyArray` se utilizan para crear estructuras de datos que no deben ser modificadas una vez que se han creado. Esto es útil para garantizar la inmutabilidad de los datos, protegiendo contra modificaciones accidentales o no deseadas.

`Readonly<T>` es un tipo genérico que convierte todas las propiedades de un tipo `T` en propiedades de solo lectura. Esto significa que una vez que un objeto ha sido creado con un tipo `Readonly`, no se pueden modificar sus propiedades.

```ts
interface Persona {
    nombre: string;
    edad: number;
}

const persona: Readonly<Persona> = {
    nombre: 'Juan',
    edad: 30
};

// Esto es válido
console.log(persona.nombre); // 'Juan'

// Esto produce un error
persona.nombre = 'Ana'; // Error: Cannot assign to 'nombre' because it is a read-only property
```

## ReadonlyArray
`ReadonlyArray<T>` es una versión inmutable del tipo `Array<T>`. Las instancias de ReadonlyArray no permiten modificaciones como agregar, eliminar o cambiar elementos una vez que han sido creadas.

```ts
const numeros: ReadonlyArray<number> = [1, 2, 3, 4, 5];

// Esto es válido
console.log(numeros[0]); // 1

// Esto produce errores
numeros.push(6); // Error: Property 'push' does not exist on type 'readonly number[]'
numeros[0] = 10; // Error: Index signature in type 'readonly number[]' only permits reading property
```

### Uso de Readonly en Objetos y Arreglos
1. **Objetos**:

   * La utilidad de `Readonly` en objetos es asegurarse de que el estado del objeto no cambie después de su creación. Esto es útil en patrones como la programación funcional y en situaciones donde deseas asegurarte de que un objeto no sea alterado accidentalmente.

      ```ts
      const config: Readonly<{ apiUrl: string; timeout: number }> = {
          apiUrl: 'https://api.example.com',
          timeout: 5000
      };

      // Esto es válido
      console.log(config.apiUrl); // 'https://api.example.com'

      // Esto produce un error
      config.apiUrl = 'https://api.newexample.com'; // Error: Cannot assign to 'apiUrl' because it is a read-only property
      ```

2. **Arreglos**:

   * Al usar `ReadonlyArray`, se evita modificar el contenido del arreglo. Esto es especialmente útil cuando trabajas con datos que no deberían cambiar una vez que han sido establecidos, como listas de configuraciones o datos provenientes de una API.

      ```ts
      const colores: ReadonlyArray<string> = ['rojo', 'verde', 'azul'];

      // Esto es válido
      console.log(colores[1]); // 'verde'

      // Esto produce errores
      colores.push('amarillo'); // Error: Property 'push' does not exist on type 'readonly string[]'
      colores[1] = 'morado'; // Error: Index signature in type 'readonly string[]' only permits reading property
      ```