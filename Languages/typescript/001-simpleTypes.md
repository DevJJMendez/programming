## Tipos de datos - Variables - Constantes
- **Number**: Para representar valores numéricos, ya sea enteros o de punto flotante.

  ```ts
  let edad: number = 25;
  ```

- **String**: Para representar cadenas de texto.

  ```ts
  let nombre: string = "Juan";
  ```

- **Boolean**: Para representar valores booleanos (true o false).

  ```ts
  let esMayor: boolean = true;
  ```

- **Array**: Para representar arreglos de elementos del mismo tipo.

  ```ts
  let numeros: number[] = [1, 2, 3, 4];
  ```


## Variables y Constantes
Para declarar variables y constantes, utilizamos let y const respectivamente.

```ts
let variable: number = 10;
variable = 20; // Se puede cambiar el valor

const constante: string = "Hola";
```

## Inferencia de Tipos:
TypeScript también tiene inferencia de tipos, lo que significa que no siempre es necesario especificar el tipo de variable explícitamente, ya que el compilador puede deducirlo.

```ts
let edad = 25; // TypeScript infiere que la variable es de tipo number
```

Esto ayuda a reducir la redundancia en el código, pero aún así proporciona la seguridad de tipos durante la compilación.

## Concatenación con String Interpolation
La concatenación de cadenas usando interpolación de strings (o template literals) en TypeScript (y JavaScript) es una manera moderna, legible y eficiente de crear y combinar cadenas de texto. En lugar de utilizar el operador `+` para concatenar cadenas, puedes utilizar los template literals para incrustar expresiones dentro de las cadenas, lo que mejora tanto la legibilidad como la flexibilidad del código.

### ¿Qué son los Template Literals?
Los template literals son cadenas de texto delimitadas por backticks (``) en lugar de comillas simples (') o dobles ("). Esto permite el uso de expresiones incrustadas y multilínea dentro de la cadena.

**Sintaxis**
```ts
`Texto estático ${expresion} más texto estático`
```
Cualquier expresión válida de TypeScript (variables, funciones, operaciones, etc.) puede ser incluida dentro de `${}`.