## Generics
Los Generic Types en TypeScript son una característica avanzada que permite escribir funciones, clases e interfaces que pueden funcionar con diferentes tipos de datos mientras mantienen la flexibilidad del tipo. Es decir, los genéricos te permiten crear estructuras de código que son más reutilizables y seguras, ya que puedes definir tipos de datos dinámicos de una manera explícita y clara.

Los genéricos proporcionan una forma de definir plantillas de tipos. Esto permite que puedas usar distintos tipos de datos sin perder las ventajas del tipado fuerte de TypeScript. La principal ventaja es que los tipos son inferidos por el compilador, pero pueden ser definidos explícitamente por el usuario.

**Ejemplo básico de una función sin genéricos**:
```ts
function identidad(arg: any): any {
  return arg;
}
```
En este caso, el tipo de `arg` es `any`, lo que significa que cualquier tipo puede ser pasado, pero el resultado será también de tipo `any`, lo que pierde la información del tipo con el que estás trabajando.

### Usando Genéricos en Funciones
Con los genéricos, puedes crear una función que retenga el tipo del argumento que recibe.

```ts
function identidad<T>(arg: T): T {
  return arg;
}
```
* <T> es un tipo genérico, es decir, un placeholder que se reemplaza con el tipo real cuando la función es llamada.

* `T` en `arg`: `T` indica que el tipo de `arg` será el que el usuario defina al invocar la función.

* El tipo de retorno de la función también será el mismo (`T`), manteniendo la consistencia de tipos.

**Ejemplo de uso**
```ts
let salida1 = identidad<string>("Hola");
let salida2 = identidad<number>(123);

console.log(salida1);  // "Hola"
console.log(salida2);  // 123
```
TypeScript infiere automáticamente los tipos en muchos casos, por lo que no es necesario especificar `<string>` o `<number>` explícitamente si el tipo es obvio.
```ts
let salida3 = identidad("TypeScript");  // inferido como string
```

## Genéricos en Clases
Los genéricos también se pueden utilizar en clases para permitir que trabajen con diferentes tipos de datos.

**Ejemplo**
```ts
class Caja<T> {
  contenido: T;
  
  constructor(contenido: T) {
    this.contenido = contenido;
  }

  obtenerContenido(): T {
    return this.contenido;
  }
}
```
Aquí, la clase `Caja` utiliza un tipo genérico `T`, lo que le permite almacenar cualquier tipo de dato en contenido.

**Uso**
```ts
let cajaDeString = new Caja<string>("Texto");
console.log(cajaDeString.obtenerContenido());  // "Texto"

let cajaDeNumero = new Caja<number>(42);
console.log(cajaDeNumero.obtenerContenido());  // 42
```

## Genéricos en Interfaces
También puedes utilizar genéricos en interfaces para definir estructuras más flexibles.

**Ejemplo**
```ts
interface Par<T, U> {
  primero: T;
  segundo: U;
}

let par: Par<string, number> = {
  primero: "Hola",
  segundo: 42
};

console.log(par);  // { primero: "Hola", segundo: 42 }
```

## Restricciones (Constraints) en Genéricos
A veces, querrás restringir los tipos que pueden ser utilizados en un genérico. Para ello, puedes usar la palabra clave `extends` para limitar los tipos que pueden ser utilizados.

**Ejemplo**
```ts
function longitud<T extends { length: number }>(arg: T): number {
  return arg.length;
}
```
**Ejemplo**
```ts
function longitud<T extends { length: number }>(arg: T): number {
  return arg.length;
}
```
Aquí, `T` debe ser un tipo que tenga una propiedad `length`, como un array o un string.
```ts
console.log(longitud("Hola"));  // 4
console.log(longitud([1, 2, 3]));  // 3
// console.log(longitud(123));  // Error, ya que `number` no tiene `length`
```
