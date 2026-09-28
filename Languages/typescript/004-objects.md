## Creación de Objetos
En TypeScript, puedes crear objetos de la misma manera que en JavaScript, pero con la capacidad adicional de definir tipos y restricciones para las propiedades del objeto.

```ts
// Definición de un objeto simple
const persona = {
    nombre: 'Juan',
    edad: 30
};

// Acceso a propiedades
console.log(persona.nombre); // 'Juan'
console.log(persona.edad); // 30

const car: { type: string, model: string, year: number } = {
  type: "Toyota",
  model: "Corolla",
  year: 2009
};
```

##  Tipos de Objetos
Puedes definir el tipo de un objeto usando interfaces o tipos, lo que proporciona una estructura clara y asegura que los objetos cumplan con un formato específico.

### Interfaces
Las interfaces en TypeScript son una forma de definir la estructura de un objeto. Puedes especificar qué propiedades debe tener un objeto y los tipos de esas propiedades.

```ts
interface Persona {
    nombre: string;
    edad: number;
    direccion?: string; // Propiedad opcional
}

const persona: Persona = {
    nombre: 'Juan',
    edad: 30
};

// Esto también es válido
const otraPersona: Persona = {
    nombre: 'Ana',
    edad: 25,
    direccion: 'Calle Falsa 123'
};
```

### Types
Los `Types` en TypeScript también se pueden usar para definir la estructura de objetos. Los tipos son más flexibles que las interfaces y pueden combinar otros tipos, crear uniones, y más.

```ts
type Persona = {
    nombre: string;
    edad: number;
    direccion?: string; // Propiedad opcional
};

const persona: Persona = {
    nombre: 'Juan',
    edad: 30
};

// Esto también es válido
const otraPersona: Persona = {
    nombre: 'Ana',
    edad: 25,
    direccion: 'Calle Falsa 123'
};
```

## Propiedades Opcionales
En TypeScript, puedes definir propiedades opcionales usando el signo `?` después del nombre de la propiedad. Esto indica que la propiedad no es obligatoria.

```ts
interface Persona {
    nombre: string;
    edad: number;
    direccion?: string; // Opcional
}

const persona1: Persona = {
    nombre: 'Juan',
    edad: 30
};

const persona2: Persona = {
    nombre: 'Ana',
    edad: 25,
    direccion: 'Calle Falsa 123'
};
```

## Propiedades de solo lectura
Puedes hacer que las propiedades de un objeto sean de solo lectura usando `readonly`. Esto asegura que las propiedades no se puedan modificar después de la inicialización.

```ts
interface Persona {
    readonly nombre: string;
    readonly edad: number;
}

const persona: Persona = {
    nombre: 'Juan',
    edad: 30
};

// Esto produce errores
persona.nombre = 'Ana'; // Error: Cannot assign to 'nombre' because it is a read-only property
persona.edad = 35; // Error: Cannot assign to 'edad' because it is a read-only property
```
## Tipos Anidados
Puedes tener tipos anidados en tus objetos. Esto te permite definir estructuras más complejas y organizadas.

```ts
interface Direccion {
    calle: string;
    ciudad: string;
    codigoPostal: string;
}

interface Persona {
    nombre: string;
    edad: number;
    direccion: Direccion;
}

const persona: Persona = {
    nombre: 'Juan',
    edad: 30,
    direccion: {
        calle: 'Calle Falsa 123',
        ciudad: 'Ciudad',
        codigoPostal: '12345'
    }
};
```

## Métodos en Objetos
Puedes incluir métodos dentro de las interfaces y tipos para agregar comportamiento a tus objetos.

```ts
interface Persona {
    nombre: string;
    edad: number;
    saludar(): void;
}

const persona: Persona = {
    nombre: 'Juan',
    edad: 30,
    saludar() {
        console.log(`Hola, mi nombre es ${this.nombre}`);
    }
};

persona.saludar(); // 'Hola, mi nombre es Juan'
```

## Índices de Tipos
Puedes definir propiedades dinámicas en un objeto usando índices de tipo. Esto te permite tener propiedades cuyo nombre no se conoce de antemano.

```ts
interface Perfil {
    [key: string]: string; // Las claves deben ser de tipo string y los valores también deben ser de tipo string
}

const perfil: Perfil = {
    nombre: 'Juan',
    ocupacion: 'Desarrollador'
};

// Esto es válido
perfil['edad'] = '30'; // También es válido
```

## Record y Partial
TypeScript proporciona tipos utilitarios como Record y Partial que son útiles para trabajar con objetos.

`Record<K, T>`: Crea un tipo de objeto que tiene claves del tipo `K` y valores del tipo `T`.

```ts
type Idioma = 'es' | 'en' | 'fr';
type Traducciones = Record<Idioma, string>;

const traducciones: Traducciones = {
    es: 'Hola',
    en: 'Hello',
    fr: 'Bonjour'
};
```
`Partial<T>`: Crea un tipo basado en T con todas sus propiedades opcionales.

```ts
interface Persona {
    nombre: string;
    edad: number;
}

const actualizarPersona = (persona: Persona, cambios: Partial<Persona>) => {
    return { ...persona, ...cambios };
};

const juan: Persona = { nombre: 'Juan', edad: 30 };
const juanActualizado = actualizarPersona(juan, { edad: 31 });
```