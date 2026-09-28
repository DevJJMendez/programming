# Objetos
En JavaScript, un objeto es una estructura de datos fundamental que permite agrupar información en la forma de pares clave-valor. Estos son esenciales para modelar datos de manera estructurada, lo que hace a los objetos versátiles y altamente adaptables en la programación orientada a objetos en JavaScript.

## ¿Qué es un Objeto en JavaScript?
Un objeto es una colección de datos y funcionalidades organizados en pares de clave-valor. Cada clave se asocia con un valor específico, que puede ser un dato simple (como un número o cadena) o una función (también conocida como método).

```js
const persona = {
    nombre: "Juan",
    edad: 30,
    saludar: function() {
        console.log(`Hola, me llamo ${this.nombre} y tengo ${this.edad} años.`);
    }
};
```
En este ejemplo, `persona` es un objeto con dos propiedades **(`nombre` y `edad`)** y un método **(`saludar`)**. Los objetos permiten agrupar y manipular datos relacionados de forma coherente.

## ¿Para qué sirve?
Los objetos sirven para:

* **Modelar datos complejos**: Representan entidades del mundo real (como usuarios, productos, cuentas) con atributos y comportamientos.

* **Agrupar datos relacionados**: Facilitan la organización y agrupación de variables y funciones en una sola estructura.

* **Desarrollar aplicaciones orientadas a objetos (OOP)**: Permiten definir clases, herencia y métodos para crear estructuras más escalables y reutilizables.

## ¿Qué resuelve?
Los objetos resuelven varios problemas importantes en programación:

1. **Organización de datos complejos**: En lugar de múltiples variables sueltas, los datos se agrupan bajo una sola estructura.

2. **Modularidad y reutilización**: Los objetos facilitan la reutilización de estructuras de datos y comportamientos, permitiendo desarrollar aplicaciones más modulares.

3. **Encapsulación**: Ocultan detalles internos mientras exponen solo las funcionalidades necesarias.

## ¿Cómo lo resuelve?
Los objetos en JavaScript resuelven estos problemas al proporcionar:


1. **Propiedades y métodos encapsulados**: Cada objeto puede contener tanto datos como funciones, permitiendo la encapsulación y simplificación del acceso.

2. **Prototipos**: JavaScript utiliza un sistema basado en prototipos en lugar de una jerarquía de clases clásica. Cada objeto puede heredar propiedades y métodos de otro objeto, creando una cadena de prototipos.

3. **Constructoras y clases**: Con la introducción de class en ES6, se pueden crear "plantillas" para construir objetos con propiedades y métodos específicos, mejorando la reutilización y escalabilidad.

## Estructura y Creación de Objetos
Existen varias formas de crear objetos en JavaScript, cada una con su propia utilidad:

1. **Objeto Literal**: La forma más simple de crear un objeto usando llaves `{}`.
```js
const coche = {
    marca: "Toyota",
    modelo: "Corolla",
    encender: function() {
        console.log("El coche está encendido.");
    }
};
```

2. **Constructor de Objetos**: Utilizando la función `Object()`.
```js
const libro = new Object();
libro.titulo = "1984";
libro.autor = "George Orwell";
```

3. **Funciones Constructoras**: Son funciones que crean y configuran un objeto. Por convención, se nombran con una letra inicial mayúscula.
```js
function Persona(nombre, edad) {
    this.nombre = nombre;
    this.edad = edad;
}

const persona1 = new Persona("Ana", 25);
```

4. **Clases (ES6)**: Las clases son una manera más clara y concisa de crear objetos en JavaScript, proporcionando una sintaxis similar a otros lenguajes orientados a objetos.

```js
class Animal {
    constructor(nombre, especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    emitirSonido() {
        console.log(`${this.nombre} hace un sonido.`);
    }
}

const perro = new Animal("Fido", "Perro");
```

5. **`Object.create()`**: Crea un nuevo objeto usando un objeto existente como prototipo, útil para establecer herencia.
```js
const prototipoAnimal = {
    hacerSonido: function() {
        console.log("Sonido de animal");
    }
};

const gato = Object.create(prototipoAnimal);
gato.hacerSonido(); // "Sonido de animal"
```

## Propiedades y Métodos
* **Propiedades**: Son los datos que forman parte del objeto. En el ejemplo de persona, nombre y edad son propiedades.

* **Métodos**: Son funciones que forman parte del objeto y permiten interactuar con sus datos. saludar en el objeto persona es un método.

```js
const robot = {
    nombre: "RX-78",
    hablar: function() {
        console.log("Beep boop");
    }
};

robot.hablar(); // "Beep boop"
```

## Clases y Prototipos en Objetos
Las clases en JavaScript crean objetos basados en prototipos. Cada instancia de una clase hereda de la clase principal y comparte métodos, gracias a los prototipos.

1. **Herencia Prototípica**: Permite que un objeto herede propiedades y métodos de otro. Esto permite la reutilización de métodos entre diferentes objetos.
```js
function Vehiculo(marca) {
    this.marca = marca;
}

Vehiculo.prototype.conducir = function() {
    console.log(`Conduciendo un ${this.marca}`);
};

const coche = new Vehiculo("Ford");
coche.conducir(); // "Conduciendo un Ford"
```

2. **Clases y Extends (ES6)**: Permiten herencia de forma más explícita, donde una clase hija puede heredar propiedades y métodos de una clase padre.
```js
class Vehiculo {
    constructor(marca) {
        this.marca = marca;
    }
    conducir() {
        console.log(`Conduciendo un ${this.marca}`);
    }
}

class Coche extends Vehiculo {
    constructor(marca, modelo) {
        super(marca);
        this.modelo = modelo;
    }
}

const miCoche = new Coche("Toyota", "Corolla");
miCoche.conducir(); // "Conduciendo un Toyota"
```