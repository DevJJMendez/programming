# Componentes
Los Componentes son la base de React. Son unidades reutilizables de código que encapsulan la lógica y la UI de una parte de la aplicación.

* Son funciones o clases que devuelven elementos de JSX (HTML en JavaScript).

* Se combinan para construir interfaces de usuario complejas de forma modular.

* Pueden tener estado, lógica y manejar eventos.

Ejemplo de un componente básico en React:
```tsx
const Greeting = () => {
  return <h1>¡Hola, bienvenido a React!</h1>;
};

export default Greeting;
```
**¿Qué hace este código?**
* Define un componente llamado `Greeting`.
* Retorna un `h1` con un saludo.
* Puede ser reutilizado en cualquier parte de la aplicación.


## ¿Cuáles son los Tipos de Componentes en React?
Existen dos tipos principales de componentes en React:

### Componentes Funcionales (`Function Components`) - (Recomendados)
* Son simples funciones de JavaScript que retornan JSX.
* Se recomienda usarlos en todas las aplicaciones modernas.
* Pueden manejar estado con useState y efectos con useEffect.

Ejemplo de un Componente Funcional:
```tsx
const Button = () => {
  return <button>Click me</button>;
};

export default Button;
```

### Componentes de Clase (Class Components) - (Obsoletos en React moderno)
* Usaban `this.state` y `this.setState()` para manejar el estado.
* Se utilizaban antes de los Hooks (`useState`, `useEffect`).
* No se recomienda usarlos en proyectos nuevos.

Ejemplo de un Componente de Clase:
```tsx
import React, { Component } from "react";

class Button extends Component {
  render() {
    return <button>Click me</button>;
  }
}

export default Button;
```

### ¿Cuándo usar cada tipo?
| Tipo de Componente | Ventajas                                                     | Desventajas                |
| ------------------ | ------------------------------------------------------------ | -------------------------- |
| Funcionales        | Más simples, mejor rendimiento, menos código, soportan Hooks | Ninguna                    |
| De Clase           | Soportan ciclo de vida (pero obsoletos)                      | Verbosos, menos eficientes |
En React moderno, siempre usa componentes funcionales con Hooks.

## Estructura de un Componente en React
Un componente en React típicamente tiene:
✅ Imports: Importación de React y otras dependencias.
✅ Definición del Componente: Declaración de la función.
✅ JSX (Renderizado): El HTML dentro del return().
✅ Exportación: Permite reutilizar el componente en otros archivos.

📌 Ejemplo de estructura de un componente bien organizado:
```tsx
import React from "react";

const Welcome = () => {
  return (
    <div>
      <h1>¡Bienvenido!</h1>
      <p>Este es un componente en React.</p>
    </div>
  );
};

export default Welcome;
```
¿Qué sucede aquí?
🔹 Se importa React.
🔹 Se define el componente Welcome.
🔹 Retorna JSX (div, h1, p).
🔹 Se exporta para ser usado en otros archivos.

## ¿Para qué sirven los Componentes?
✅ Reutilización: Evitan código duplicado.
✅ Mantenimiento: Separan la lógica en piezas pequeñas.
✅ Escalabilidad: Permiten construir grandes aplicaciones de forma modular.
✅ Eficiencia: React optimiza el renderizado con el Virtual DOM.

Ejemplo de reutilización de un componente Button:
```tsx
const Button = ({ text }) => {
  return <button>{text}</button>;
};

// Uso del componente varias veces en la app
const App = () => {
  return (
    <div>
      <Button text="Enviar" />
      <Button text="Cancelar" />
    </div>
  );
};
```
Qué resuelve esto?
🔹 Evita escribir <button> varias veces.
🔹 Solo cambiamos text, pero la estructura es la misma.
🔹 Si el diseño del botón cambia, solo lo modificamos en Button.tsx.

##  Props: Comunicación entre Componentes
✅ Las "Props" (propiedades) permiten pasar datos entre componentes.
✅ Son inmutables: No se pueden modificar dentro del componente hijo.
✅ Se pasan como atributos en JSX.

📌 Ejemplo de Props en acción:
```tsx
const Welcome = ({ name }) => {
  return <h1>¡Hola, {name}!</h1>;
};

// Uso del componente con diferentes props
const App = () => {
  return (
    <div>
      <Welcome name="Juan" />
      <Welcome name="Ana" />
    </div>
  );
};
```
¿Qué hace esto?
🔹 Welcome recibe name y lo usa en el JSX.
🔹 App lo llama con distintos valores ("Juan", "Ana").

## Estado: Componentes Dinámicos con useState
✅ Los componentes pueden tener estado para manejar cambios dinámicos.
✅ useState permite que React re-renderice el componente cuando cambia el estado.

📌 Ejemplo de un Contador con useState:
```tsx
import { useState } from "react";

const Counter = () => {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>Contador: {count}</p>
      <button onClick={() => setCount(count + 1)}>Incrementar</button>
    </div>
  );
};

export default Counter;
```
¿Qué sucede aquí?
🔹 useState(0) inicializa count en 0.
🔹 setCount(count + 1) actualiza el estado al hacer clic en el botón.
🔹 React detecta el cambio y re-renderiza el componente.

## Ciclo de Vida con useEffect (Efectos Secundarios)
✅ useEffect ejecuta código cuando el componente se monta, actualiza o desmonta.
✅ Útil para llamadas a API, suscripciones, etc.

📌 Ejemplo: Fetch de datos cuando el componente se monta
```tsx
import { useState, useEffect } from "react";

const Users = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(response => response.json())
      .then(data => setUsers(data));
  }, []); // [] significa que solo se ejecuta al montar el componente

  return (
    <ul>
      {users.map(user => (
        <li key={user.id}>{user.name}</li>
      ))}
    </ul>
  );
};

export default Users;
```
¿Qué sucede aquí?
🔹 useEffect ejecuta fetch() al montar el componente.
🔹 setUsers(data) actualiza el estado con los usuarios.
🔹 React re-renderiza la lista con los datos obtenidos