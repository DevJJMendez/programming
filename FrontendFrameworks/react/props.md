# Props
*Los props son uno de los conceptos más fundamentales en React. Son clave para la comunicación entre componentes y el manejo de datos dinámicos en una aplicación.*

✅ Props (propiedades) son datos que un componente padre envía a un componente hijo.
✅ Son de solo lectura (inmutables). Un componente NO puede modificar sus propias props.
✅ Permiten crear componentes reutilizables y dinámicos.

📌 Ejemplo de un Componente con Props
```tsx
// Componente Hijo
interface GreetingProps {
  name: string;
}

const Greeting = ({ name }: GreetingProps) => {
  return <h2>Hola, {name}</h2>;
};

// Componente Padre
const App = () => {
  return <Greeting name="Juan" />;
};

```
* App es el padre
* Greeting es el hijo
* App le pasa la prop name="Juan" al hijo
* Greeting recibe y usa esa prop

✅ Resultado en pantalla:
```html
<h1>¡Hola, Juan!</h1>
```

### ¿Y si el hijo necesita avisarle algo al padre?
React no permite enviar props del hijo al padre directamente (porque los datos bajan, no suben).

👉 Para comunicar algo del hijo al padre, el padre pasa una función como prop al hijo.

Ejemplo: Hijo le avisa al Padre (callback)
```tsx
// Hijo
interface ButtonProps {
  onClick: () => void;
}

const Button = ({ onClick }: ButtonProps) => {
  return <button onClick={onClick}>Haz clic</button>;
};

// Padre
const App = () => {
  const handleClick = () => {
    alert("¡El hijo ejecutó esto!");
  };

  return <Button onClick={handleClick} />;
};
```
* App pasa la función handleClick como prop
* Button (hijo) invoca esa función al hacer clic
* El hijo no necesita saber qué hace la función, solo la ejecuta

### Caso real: lista de usuarios
```tsx
// UserItem.tsx
interface UserItemProps {
  name: string;
  onSelect: (name: string) => void;
}

const UserItem = ({ name, onSelect }: UserItemProps) => {
  return <li onClick={() => onSelect(name)}>{name}</li>;
};

// App.tsx
const App = () => {
  const handleUserSelect = (userName: string) => {
    console.log("Usuario seleccionado:", userName);
  };

  return (
    <ul>
      <UserItem name="Ana" onSelect={handleUserSelect} />
      <UserItem name="Carlos" onSelect={handleUserSelect} />
    </ul>
  );
};
```
* Aquí se da comunicación en ambas direcciones:
* App (padre) pasa props
* UserItem (hijo) devuelve datos usando un callback

## ¿Cuál es la estructura de los Props?
Los props en React tienen una estructura basada en un objeto con clave-valor.
📌 Ejemplo de la estructura interna de props:
```tsx
const Greeting = (props: { name: string; age: number }) => {
  console.log(props); // { name: "Juan", age: 25 }
  return (
    <div>
      <h1>¡Hola, {props.name}!</h1>
      <p>Edad: {props.age}</p>
    </div>
  );
};

const App = () => {
  return <Greeting name="Juan" age={25} />;
};
```
🔹 Props se pasan como atributos HTML, pero internamente son un objeto.
🔹 Se pueden pasar strings, números, booleanos, arrays, objetos y funciones.

## ¿Para qué sirven los Props?
| Uso                            | Ejemplo                                                    |
| ------------------------------ | ---------------------------------------------------------- |
| Personalizar componentes       | Pasar datos dinámicos (<Button text="Click" />)            |
| Comunicación entre componentes | Enviar datos del padre al hijo (<Profile user={user} />)   |
| Reutilización                  | Crear un solo componente que funcione con diferentes datos |
| Renderizado dinámico           | Mostrar contenido basado en variables                      |

📌 Ejemplo: Personalización con Props
```tsx
const Button = ({ text }: { text: string }) => {
  return <button>{text}</button>;
};

const App = () => {
  return (
    <>
      <Button text="Aceptar" />
      <Button text="Cancelar" />
    </>
  );
};
```
Se reutiliza el mismo componente Button, cambiando solo el texto.

## ¿Qué problemas resuelven los Props?
| Problema                    | Solución con Props                                 |
| --------------------------- | -------------------------------------------------- |
| Repetición de código        | Un solo componente con diferentes datos            |
| Acoplamiento de componentes | Separar lógica y presentación                      |
| Datos dinámicos             | Renderizar contenido basado en variables           |
| Comunicación de datos       | Permitir que un padre pase información a sus hijos |

📌 Ejemplo: Sin props (código repetido)
```tsx
const ButtonAccept = () => <button>Aceptar</button>;
const ButtonCancel = () => <button>Cancelar</button>;

const App = () => {
  return (
    <>
      <ButtonAccept />
      <ButtonCancel />
    </>
  );
};
```
❌ Problema: Cada botón es un componente separado, lo que no es escalable.

📌 Ejemplo: Con props (reutilización)
```tsx
const Button = ({ text }: { text: string }) => {
  return <button>{text}</button>;
};

const App = () => {
  return (
    <>
      <Button text="Aceptar" />
      <Button text="Cancelar" />
    </>
  );
};
```

## ¿Cómo resuelven los Props estos problemas?
Los props permiten:
✅ Separar la lógica de la presentación.
✅ Crear componentes dinámicos sin duplicar código.
✅ Facilitar el mantenimiento y la escalabilidad de la aplicación.

📌 Ejemplo con Props de Diferentes Tipos
```tsx
interface CardProps {
  title: string;
  content: string;
  isFeatured: boolean;
}

const Card = ({ title, content, isFeatured }: CardProps) => {
  return (
    <div style={{ border: isFeatured ? "2px solid gold" : "1px solid gray" }}>
      <h2>{title}</h2>
      <p>{content}</p>
    </div>
  );
};

const App = () => {
  return (
    <>
      <Card title="React" content="Biblioteca para UI" isFeatured={true} />
      <Card title="Vue" content="Framework progresivo" isFeatured={false} />
    </>
  );
};
```
Los props title, content e isFeatured hacen que el mismo componente Card se vea diferente dependiendo de los datos que recibe.

## Props con Valores por Defecto (defaultProps)
A veces, queremos que un prop tenga un valor por defecto si el padre no lo proporciona.

📌 Ejemplo con valores por defecto en TypeScript:
```tsx
interface UserProps {
  name?: string; // Propiedad opcional
}

const User = ({ name = "Invitado" }: UserProps) => {
  return <h1>Bienvenido, {name}</h1>;
};

const App = () => {
  return (
    <>
      <User name="Juan" />
      <User /> {/* Se usará el valor por defecto "Invitado" */}
    </>
  );
};
```
Si name no se pasa, se usa "Invitado".

## Props como Funciones (Callbacks)
Los props también pueden ser funciones para comunicar un hijo con su padre.

📌 Ejemplo: Botón que envía datos al padre
```tsx
const Button = ({ onClick }: { onClick: () => void }) => {
  return <button onClick={onClick}>Click</button>;
};

const App = () => {
  const handleClick = () => {
    alert("¡Botón presionado!");
  };

  return <Button onClick={handleClick} />;
};
```
Button ejecuta onClick, enviando una señal al padre.

# Mejores Prácticas con Props
✔ Usar destructuración en los parámetros
📌 En lugar de:
```tsx
const Card = (props: { title: string; content: string }) => {
  return <h1>{props.title}</h1>;
};
```
Usar destructuración:
```tsx
const Card = ({ title, content }: { title: string; content: string }) => {
  return <h1>{title}</h1>;
};
```
✔ Usar TypeScript para tipar props
✔ Evitar props innecesarios
✔ Usar valores por defecto en props opcionales
✔ Mantener los componentes simples y reutilizables

# Interfaces
*El uso de interfaces en TypeScript para tipar los props en React es una de las mejores prácticas para crear aplicaciones robustas, seguras y legibles.*

Una interface es una forma de definir la forma de un objeto, es decir, qué propiedades debe tener, qué tipo son, si son opcionales, etc.

## ¿Por qué usar interfaces para los props en React?
| Beneficio     | ¿Por qué es importante?                        |
| ------------- | ---------------------------------------------- |
| Tipado fuerte | Detectas errores en tiempo de compilación.     |
| Legibilidad   | Es más claro qué espera el componente.         |
| Escalabilidad | Ideal cuando los props crecen o se reutilizan. |

## Sintaxis básica: Usando interface para props
```tsx
interface GreetingProps {
  name: string;
  age: number;
}

const Greeting = ({ name, age }: GreetingProps) => {
  return (
    <div>
      <h1>Hola, {name}</h1>
      <p>Edad: {age}</p>
    </div>
  );
};

// Uso
<Greeting name="Juan" age={25} />;
```
Así le decimos a TypeScript: "Este componente requiere name como string y age como number."

## Props opcionales con interfaces
Puedes marcar una propiedad como opcional con `?`.
```tsx
interface CardProps {
  title: string;
  description?: string; // Opcional
}

const Card = ({ title, description = "Sin descripción" }: CardProps) => {
  return (
    <div>
      <h2>{title}</h2>
      <p>{description}</p>
    </div>
  );
};
```
Si no pasas description, usará el valor por defecto "Sin descripción".

##  Props complejos (arrays, objetos, funciones)
🟠 Objetos como props:
```tsx
interface User {
  name: string;
  age: number;
}

interface ProfileProps {
  user: User;
}

const Profile = ({ user }: ProfileProps) => {
  return <h1>{user.name} - {user.age} años</h1>;
};
```
🟠 Funciones como props (callbacks):
```tsx
interface ButtonProps {
  onClick: () => void;
}

const Button = ({ onClick }: ButtonProps) => {
  return <button onClick={onClick}>Click</button>;
};
```

## ¿Dónde declarar la interface?
🧠 Regla de oro: declara las interfaces justo arriba del componente que las usa (o en un archivo types.ts si vas a reutilizarlas mucho).

## Buenas prácticas
✅ Usa interface en lugar de type si vas a extender o reutilizar.
✅ Tipa funciones bien (con sus parámetros y tipo de retorno).
✅ Prefiere interface si estás trabajando en componentes public-facing (más predecibles).
✅ Agrupa las interfaces en un archivo types.ts si varios componentes las comparten.

## Ejemplo completo y limpio
```tsx
// Card.tsx
interface CardProps {
  title: string;
  content: string;
  onClick: () => void;
  isFeatured?: boolean;
}

export const Card = ({ title, content, onClick, isFeatured = false }: CardProps) => {
  return (
    <div onClick={onClick} style={{ border: isFeatured ? "2px solid gold" : "1px solid gray" }}>
      <h2>{title}</h2>
      <p>{content}</p>
    </div>
  );
};
```
```tsx
// App.tsx
import { Card } from "./Card";

const App = () => {
  return (
    <Card
      title="React"
      content="Biblioteca para construir interfaces"
      onClick={() => console.log("Click!")}
      isFeatured
    />
  );
};
```
### Recuerda:
interface Props { ... } = contrato que el componente espera cumplir.

TypeScript te protege del error humano (como olvidar una prop o pasar el tipo incorrecto).

Si tus props son dinámicos, complejos o numerosos: usa interfaces, siempre.