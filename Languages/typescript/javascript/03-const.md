# `const`
Es una palabra clave que declara una variable con alcance de bloque y que no permite la reasignación de su valor. Una vez que la variable ha sido asignada, no se puede cambiar a otro valor.

## ¿Para qué sirve?
const se utiliza para declarar constantes, es decir, valores que no deben cambiar durante la ejecución del programa. Es útil cuando deseas asegurarte de que el valor de la variable no será accidentalmente modificado en otro lugar del código, lo cual puede ser crucial para la integridad de ciertos datos.

**Ejemplo**
```js
const PI = 3.14159;
console.log(PI); // 3.14159
PI = 3; // Error: Assignment to constant variable
```

## ¿Qué resuelve?
const ayuda a resolver problemas comunes asociados con la modificación no intencionada de variables, especialmente en el caso de valores críticos que deben permanecer estables en el programa, como configuraciones, parámetros constantes o valores matemáticos.

Además, const también:

1. Refuerza la inmutabilidad en variables que deben permanecer constantes, evitando errores al querer asignarles un nuevo valor.

2. Mejora la legibilidad y el mantenimiento del código al dejar claro que la variable no debe ser cambiada, comunicando mejor las intenciones del programador.

## ¿Cómo lo resuelve?
1. **Alcance de bloque**: Al igual que `let`, const está limitada al bloque en el que fue declarada, lo que significa que no afecta a otros bloques o funciones, ayudando a mantener el código más seguro y organizado.

```js
if (true) {
    const saludo = "Hola";
    console.log(saludo); // "Hola"
}
console.log(saludo); // Error: saludo is not defined
```

2. **Asignación única y protección contra reasignación**: Con const, una variable solo puede ser inicializada una vez. Si intentamos reasignarla, JavaScript lanzará un error, manteniendo la inmutabilidad de esa variable.

```js
const nombre = "Juan";
nombre = "Ana"; // Error: Assignment to constant variable
```

3. **Inmutabilidad parcial en objetos y arreglos**: Aunque `const` no permite reasignación, si la variable es un objeto o arreglo, su contenido puede cambiar, ya que `const` protege la referencia al objeto pero no sus propiedades o elementos.

```js
const persona = { nombre: "Juan", edad: 30 };
persona.edad = 31; // Esto es válido, solo cambia una propiedad
console.log(persona); // { nombre: "Juan", edad: 31 }

persona = {}; // Error: Assignment to constant variable
```
En este caso, persona siempre apuntará al mismo objeto, pero el contenido del objeto puede modificarse.