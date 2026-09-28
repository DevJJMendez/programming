## Inheritance
En TypeScript, la herencia se refiere a la capacidad de una clase de heredar propiedades y métodos de otra clase, lo que facilita la reutilización del código y fomenta una estructura más organizada y escalable. TypeScript utiliza la palabra clave `extends` para implementar la herencia, al igual que JavaScript.

La herencia permite a una clase (subclase o clase hija) heredar características de otra clase (superclase o clase padre). Esto incluye tanto propiedades como métodos de la clase base, lo que significa que la subclase puede acceder a ellos sin necesidad de redefinirlos.

**Sintaxis**
```ts
class Persona {
    nombre: string;
    edad: number;

    constructor(nombre: string, edad: number) {
        this.nombre = nombre;
        this.edad = edad;
    }

    saludar(): void {
        console.log(`Hola, me llamo ${this.nombre} y tengo ${this.edad} años.`);
    }
}

class Empleado extends Persona {
    puesto: string;

    constructor(nombre: string, edad: number, puesto: string) {
        super(nombre, edad); // Llama al constructor de la clase base (Persona)
        this.puesto = puesto;
    }

    trabajar(): void {
        console.log(`${this.nombre} está trabajando como ${this.puesto}.`);
    }
}

const empleado = new Empleado('Juan', 30, 'Desarrollador');
empleado.saludar(); // "Hola, me llamo Juan y tengo 30 años."
empleado.trabajar(); // "Juan está trabajando como Desarrollador."
```

### `super` Llamando al Constructor de la Clase Base
Cuando una clase hija extiende de una clase base, puedes usar super para llamar al constructor y a los métodos de la clase padre. Esto es necesario cuando la clase padre tiene un constructor que inicializa propiedades.

```ts
class Animal {
    nombre: string;

    constructor(nombre: string) {
        this.nombre = nombre;
    }

    hacerSonido(): void {
        console.log(`${this.nombre} hace un sonido.`);
    }
}

class Perro extends Animal {
    constructor(nombre: string) {
        super(nombre); // Llama al constructor de la clase base Animal
    }

    hacerSonido(): void {
        super.hacerSonido(); // Llama al método de la clase base
        console.log(`${this.nombre} ladra.`);
    }
}

const perro = new Perro('Fido');
perro.hacerSonido();
// Resultado:
// "Fido hace un sonido."
// "Fido ladra."
```

### Clases y Herencia con `implements`
En TypeScript, también puedes usar interfaces para definir las formas y comportamientos que las clases deben implementar. Si una clase implementa una interface, debe cumplir con la estructura definida en ella.

```ts
interface Volador {
    volar(): void;
}

class Avion implements Volador {
    volar(): void {
        console.log("El avión está volando.");
    }
}

class Pájaro implements Volador {
    volar(): void {
        console.log("El pájaro está volando.");
    }
}

const avion = new Avion();
avion.volar(); // "El avión está volando."

const pajaro = new Pájaro();
pajaro.volar(); // "El pájaro está volando."
```