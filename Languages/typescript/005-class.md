## Clases
En TypeScript, las clases son una parte fundamental para la programación orientada a objetos. Las clases permiten definir objetos con atributos y comportamientos, encapsulando datos y lógica. Al igual que en otros lenguajes orientados a objetos como Java o C#, las clases en TypeScript pueden tener propiedades (atributos), métodos (funciones) y utilizar características como **herencia**, **polimorfismo** y **encapsulamiento**.

Una clase es un modelo que define las características y el comportamiento de un objeto. Contiene un **constructor**, que es el método que se ejecuta cuando se crea una instancia de la clase. Además, puede tener **propiedades** (variables de clase) y **métodos** (funciones que operan en esas propiedades).

**Sintaxis**
```ts
class Persona {
    // Propiedades de la clase
    nombre: string;
    edad: number;

    // Constructor para inicializar las propiedades
    constructor(nombre: string, edad: number) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método de la clase
    saludar(): void {
        console.log(`Hola, mi nombre es ${this.nombre} y tengo ${this.edad} años.`);
    }
}

// Crear una instancia de la clase
const persona1 = new Persona('Ana', 28);
persona1.saludar(); // "Hola, mi nombre es Ana y tengo 28 años."
```

### Constructor
El constructor es un método especial que se llama automáticamente cuando se crea una nueva instancia de la clase. Se utiliza para inicializar las propiedades de la clase.

```ts
class Coche {
    marca: string;
    modelo: string;

    // Constructor
    constructor(marca: string, modelo: string) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método
    arrancar(): void {
        console.log(`El coche ${this.marca} ${this.modelo} está arrancando.`);
    }
}

const miCoche = new Coche('Toyota', 'Corolla');
miCoche.arrancar(); // "El coche Toyota Corolla está arrancando."
```

### Modificadores de Acceso
Los modificadores de acceso determinan la visibilidad de las propiedades y métodos dentro de una clase. Los modificadores más comunes son:

* `public`: Accesible desde cualquier lugar.

* `protected`: Accesible solo dentro de la clase y las subclases.

* `private`: Accesible solo dentro de la clase donde se define.

```ts
class Persona {
    public nombre: string; // Visible en todas partes
    protected edad: number; // Visible solo dentro de la clase y subclases
    private contrasena: string; // Visible solo dentro de la clase

    constructor(nombre: string, edad: number, contrasena: string) {
        this.nombre = nombre;
        this.edad = edad;
        this.contrasena = contrasena;
    }

    public saludar(): void {
        console.log(`Hola, soy ${this.nombre}.`);
    }

    protected mostrarEdad(): void {
        console.log(`Tengo ${this.edad} años.`);
    }

    private mostrarContrasena(): void {
        console.log(`Mi contraseña es ${this.contrasena}.`);
    }
}

class Empleado extends Persona {
    puesto: string;

    constructor(nombre: string, edad: number, contrasena: string, puesto: string) {
        super(nombre, edad, contrasena);
        this.puesto = puesto;
    }

    mostrarInfo(): void {
        this.saludar(); // Puede acceder a métodos públicos
        this.mostrarEdad(); // Puede acceder a métodos protegidos
        // this.mostrarContrasena(); // Error: No puede acceder a métodos privados
    }
}

const empleado = new Empleado('Ana', 28, 'secreta123', 'Gerente');
empleado.saludar(); // "Hola, soy Ana."
empleado.mostrarInfo();
// "Hola, soy Ana."
// "Tengo 28 años."
```

### Sobrescritura de Métodos (Method Overriding)
Las subclases pueden sobrescribir los métodos de la clase base si necesitan proporcionar una implementación diferente. Esto se hace definiendo un método con el mismo nombre en la subclase.

```ts
class Vehiculo {
    velocidad: number;

    constructor(velocidad: number) {
        this.velocidad = velocidad;
    }

    moverse(): void {
        console.log(`El vehículo se mueve a una velocidad de ${this.velocidad} km/h.`);
    }
}

class Coche extends Vehiculo {
    constructor(velocidad: number) {
        super(velocidad);
    }

    moverse(): void {
        console.log(`El coche se mueve a una velocidad de ${this.velocidad} km/h.`);
    }
}

const coche = new Coche(120);
coche.moverse(); // "El coche se mueve a una velocidad de 120 km/h."
```

###  Clases Abstractas
Las clases abstractas son aquellas que no pueden ser instanciadas directamente. Solo sirven como clase base y se utilizan para definir un comportamiento común que debe ser implementado por las subclases. Para definir una clase abstracta, se utiliza la palabra clave abstract.

Además, las clases abstractas pueden tener métodos abstractos que deben ser implementados por las clases derivadas.

```ts
abstract class Figura {
    abstract calcularArea(): number; // Método abstracto que debe implementarse en subclases

    mostrarArea(): void {
        console.log(`El área es ${this.calcularArea()}`);
    }
}

class Circulo extends Figura {
    radio: number;

    constructor(radio: number) {
        super();
        this.radio = radio;
    }

    calcularArea(): number {
        return Math.PI * this.radio * this.radio;
    }
}

class Cuadrado extends Figura {
    lado: number;

    constructor(lado: number) {
        super();
        this.lado = lado;
    }

    calcularArea(): number {
        return this.lado * this.lado;
    }
}

const circulo = new Circulo(5);
circulo.mostrarArea(); // "El área es 78.53981633974483"

const cuadrado = new Cuadrado(4);
cuadrado.mostrarArea(); // "El área es 16"
```

### Propiedades de Solo Lectura (readonly)
El modificador `readonly` permite definir propiedades que solo pueden ser asignadas una vez, ya sea en la declaración o dentro del constructor.

```ts
class Libro {
    readonly titulo: string;
    readonly autor: string;

    constructor(titulo: string, autor: string) {
        this.titulo = titulo;
        this.autor = autor;
    }
}

const libro = new Libro('1984', 'George Orwell');
// libro.titulo = 'Animal Farm'; // Error: La propiedad es solo lectura
```

### Métodos Estáticos
Los métodos estáticos pertenecen a la clase en sí, no a las instancias de la clase. Esto significa que pueden ser llamados sin necesidad de crear un objeto de la clase.

```ts
class Matematicas {
    static sumar(a: number, b: number): number {
        return a + b;
    }
}

// Se llama al método estático sin crear una instancia
console.log(Matematicas.sumar(5, 3)); // 8
```