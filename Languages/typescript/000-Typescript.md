## Typescript
TypeScript es un superset de JavaScript desarrollado por Microsoft que añade características de tipado estático al lenguaje. Se transpila a JavaScript, lo que significa que el código TypeScript se convierte en código JavaScript que puede ejecutarse en cualquier entorno que soporte JavaScript (navegadores, servidores, etc.).

### ¿Que soluciona TypeScript?
1. **Tipado Estático**:

   * TypeScript permite definir tipos para variables, parámetros de funciones, y valores de retorno. Esto ayuda a detectar errores en tiempo de compilación en lugar de en tiempo de ejecución, proporcionando mayor robustez y seguridad en el código.

2. **Interoperabilidad con JavaScript**:

   * TypeScript se puede integrar en proyectos JavaScript existentes sin problemas, ya que es completamente compatible con el código JavaScript. Puedes migrar gradualmente un proyecto JavaScript a TypeScript.

3. **Características Modernas de JavaScript**:

   * TypeScript incluye características avanzadas de JavaScript que pueden no estar disponibles en todos los entornos de ejecución de JavaScript, como clases, interfaces, y módulos. Esto te permite usar características modernas mientras mantienes la compatibilidad con versiones anteriores.

## Tipado Estatico
El tipado estático es un sistema de tipos en el que los tipos de las variables, parámetros de funciones, y valores de retorno se determinan en tiempo de compilación, antes de que el código se ejecute. Este tipo de sistema permite al compilador realizar verificaciones y detectar errores de tipo durante la compilación, lo que ayuda a asegurar la corrección del código antes de que se ejecute.

### Características del Tipado Estático:
1. **Verificación en Tiempo de Compilación**:

   * Los errores relacionados con los tipos se detectan durante la fase de compilación, lo que ayuda a identificar problemas antes de que el código se ejecute. Esto reduce la posibilidad de errores en tiempo de ejecución.

2. **Definición Explícita de Tipos**:

   * Los tipos de datos de variables, parámetros de funciones y valores de retorno deben definirse explícitamente. Esto proporciona una documentación más clara y precisa sobre el uso esperado de las variables y funciones.

3. **Seguridad de Tipos**:

   * El tipado estático garantiza que las operaciones se realicen con tipos de datos compatibles. Por ejemplo, no podrás realizar operaciones matemáticas en una cadena de texto sin convertirla primero a un tipo numérico.

4. **Optimización**:

   * Al conocer los tipos en tiempo de compilación, los compiladores pueden realizar optimizaciones adicionales en el código para mejorar el rendimiento.

5. **Mejoras en la Experiencia del Desarrollador**:

   * Las herramientas de desarrollo, como los editores y los IDEs, pueden proporcionar autocompletado, refactorización y documentación más precisos, basados en la información de tipos.

### Ejemplo de Tipado Estático:
En TypeScript, un lenguaje con tipado estático, puedes definir tipos explícitos para las variables y funciones:

```typescript
let nombre: string = 'Juan'; // 'nombre' es una variable de tipo string
let edad: number = 30; // 'edad' es una variable de tipo number

function saludar(persona: string): string {
    return `Hola, ${persona}`;
}

let saludo = saludar(nombre); // Correcto
let saludoIncorrecto = saludar(edad); // Error: 'edad' no es de tipo string
```
## Shape
En TypeScript, el término "Shape" se refiere a la estructura de un objeto, es decir, las propiedades que tiene un objeto y los tipos de datos asociados a esas propiedades. Aunque "shape" no es un tipo o una característica oficial del lenguaje, es un término comúnmente usado en la comunidad para describir cómo se definen y utilizan las interfaces y los tipos en TypeScript para describir la forma de los objetos.

### Cómo Definir la Forma (Shape) de un Objeto en TypeScript
En TypeScript, puedes definir la forma de un objeto utilizando interfaces o tipos. Ambos enfoques permiten describir la estructura y los tipos de los valores dentro de un objeto.

### **Usando Interfaces**
Las interfaces en TypeScript permiten definir una forma estructurada para los objetos. Puedes especificar qué propiedades debe tener el objeto y los tipos de esas propiedades.

```typescript
interface Persona {
    nombre: string;
    edad: number;
    direccion?: string; // propiedad opcional
}

let juan: Persona = {
    nombre: 'Juan',
    edad: 30,
    // direccion es opcional
};
```
En este ejemplo, la interfaz Persona define que un objeto de tipo Persona debe tener las propiedades nombre y edad, y que direccion es opcional.

#### **Usando Types**
Los Types también pueden usarse para definir la forma de un objeto. Los Types en TypeScript son más flexibles que las interfaces y pueden utilizarse para crear tipos complejos combinando otros tipos.

```typescript
type Persona = {
    nombre: string;
    edad: number;
    direccion?: string; // propiedad opcional
};

let juan: Persona = {
    nombre: 'Juan',
    edad: 30,
    // direccion es opcional
};
```
### Extensión y Composición
Tanto las interfaces como los tipos permiten extender y componer formas. Puedes crear una nueva interfaz o tipo basado en una existente, agregando o modificando propiedades.

`Interface`
```typescript
interface Persona {
    nombre: string;
    edad: number;
}

interface Empleado extends Persona {
    puesto: string;
}

let empleado: Empleado = {
    nombre: 'Ana',
    edad: 28,
    puesto: 'Desarrolladora'
};
```

`Types`
```typescript
type Persona = {
    nombre: string;
    edad: number;
};

type Empleado = Persona & {
    puesto: string;
};

let empleado: Empleado = {
    nombre: 'Ana',
    edad: 28,
    puesto: 'Desarrolladora'
};
```