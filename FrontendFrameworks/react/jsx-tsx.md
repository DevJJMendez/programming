# JSX
JSX (JavaScript XML) es una extensión de sintaxis de JavaScript que permite escribir código similar a HTML dentro de archivos de JavaScript o TypeScript.

```jsx
const App = () => {
  return <h1>¡Hola, mundo!</h1>;
};
```
Este código parece HTML, pero en realidad es JavaScript con una sintaxis especial que React transforma en código JavaScript puro antes de ejecutarlo.

## ¿Para qué sirve JSX?
JSX hace que sea más fácil y legible definir la UI de una aplicación en React.

Sin JSX, tendríamos que usar código JavaScript puro para manipular el DOM, lo que sería más complicado y difícil de mantener.

📌 Sin JSX (Usando React.createElement)
```jsx
const App = () => {
  return React.createElement("h1", null, "¡Hola, mundo!");
};
```
Con JSX (Código más limpio y legible)
```jsx
const App = () => {
  return <h1>¡Hola, mundo!</h1>;
};
```
* JSX permite escribir código más intuitivo y declarativo
* Hace que el código sea más fácil de leer y escribir
* Permite componer interfaces de usuario de manera más eficiente

## ¿Qué problema resuelve JSX?
JSX resuelve el problema de separación entre la UI y la lógica en el desarrollo de aplicaciones en JavaScript.

Antes de React, se seguía la idea de separar HTML, CSS y JavaScript en archivos distintos. Sin embargo, en aplicaciones modernas, separar la UI de la lógica a menudo genera complejidad innecesaria y problemas de mantenimiento.

📌 Ejemplo tradicional (HTML + JS separados)
```html
<!-- index.html -->
<button id="btn">Haz clic</button>

<script>
  document.getElementById("btn").addEventListener("click", () => {
    alert("Botón clickeado");
  });
</script>
```
Con JSX (UI y lógica en un solo lugar)
```jsx
const Button = () => {
  return <button onClick={() => alert("Botón clickeado")}>Haz clic</button>;
};
```
* JSX permite escribir código más modular y reutilizable
* La UI y la lógica de los componentes están unificadas en un solo archivo
* Facilita el mantenimiento y escalabilidad de la aplicación

## ¿Cómo funciona JSX internamente?
JSX no es código ejecutable por el navegador. Antes de que React lo ejecute, Babel lo convierte en JavaScript puro usando React.createElement().

```jsx
const App = () => {
  return <h1>Hola, mundo</h1>;
};
```
Cómo Babel lo transforma
```jsx
const App = () => {
  return React.createElement("h1", null, "Hola, mundo");
};
```
Cómo React lo convierte en un nodo del DOM
```html
<h1>Hola, mundo</h1>
```
* JSX solo es una capa sintáctica, pero debajo sigue siendo JavaScript puro
* Babel transpila JSX a código compatible con el navegador

# Reglas y Características de JSX
## 1. Un solo elemento padre por componente

Esto da error:
```jsx
const App = () => {
  return (
    <h1>Título</h1>
    <p>Descripción</p>
  );
};
```
Solución: Usar un div o un Fragment (`<>`...`</>`)
```jsx
const App = () => {
  return (
    <>
      <h1>Título</h1>
      <p>Descripción</p>
    </>
  );
};
```

## 2. Incrustar expresiones JavaScript en JSX
Puedes usar `{}` para incluir valores o expresiones de JavaScript en JSX.

Ejemplo:
```jsx
const nombre = "Juan";
const edad = 25;

const Usuario = () => {
  return <p>Hola, mi nombre es {nombre} y tengo {edad} años.</p>;
};
```
* Puedes hacer cálculos dentro de {}
* No puedes usar sentencias como if o for directamente.

# TSX
TSX (TypeScript + JSX) es una extensión de archivo usada en React que combina:

TypeScript: Añade tipado estático a JavaScript.

JSX: Sintaxis similar a HTML dentro de JavaScript.

📌 Ejemplo de un archivo .tsx en React:
```tsx
const Greeting = (props: { name: string }) => {
  return <h1>¡Hola, {props.name}!</h1>;
};

export default Greeting;
```
🔹 props: { name: string } define que name debe ser un string.
🔹 Detecta errores en tiempo de desarrollo, mejorando la seguridad del código.

## 2. ¿Para qué sirve TSX?
✅ Aporta Tipado Estático para evitar errores en tiempo de ejecución.
✅ Mejora la productividad con autocompletado en VS Code.
✅ Facilita el mantenimiento en aplicaciones grandes.
✅ Evita errores comunes en el uso de props, state y eventos.

📌 Ejemplo sin tipado (JavaScript - JSX):
```jsx
const Button = ({ text }) => {
  return <button>{text.toUpperCase()}</button>;
};
```
❌ Problema: Si text es undefined, toUpperCase() fallará en ejecución.

📌 Ejemplo con TypeScript (TSX):
```tsx
const Button = ({ text }: { text: string }) => {
  return <button>{text.toUpperCase()}</button>;
};
```
Error detectado en tiempo de desarrollo si text no es un string.

## ¿Qué problemas resuelve TSX?
| Problema en JSX (JS)     | Solución en TSX (TS)                                         |
| ------------------------ | ------------------------------------------------------------ |
| Errores de tipo en props | TypeScript valida los tipos                                  |
| Falta de autocompletado  | VS Code sugiere nombres de variables                         |
| Falta de documentación   | Los tipos sirven como documentación implícita                |
| Errores en eventos       | TypeScript valida tipos de eventos (onClick, onChange, etc.) |

Ejemplo de error en eventos con JavaScript:
```jsx
const handleClick = (event) => {
  console.log(event.target.value); // ❌ Error si el evento no tiene "value"
};
```
Ejemplo con TypeScript:
```tsx
const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
  console.log(event.currentTarget.innerText);
};
```
Evita errores asegurando que event es un MouseEvent en un button.

## Cómo se usa TSX en una aplicación React
1️⃣ Iniciar un Proyecto React con TypeScript:
```bash
npx create-react-app my-app --template typescript
```
2️⃣ Crear archivos .tsx en lugar de .js o .jsx
3️⃣ Definir tipos para props, state, y eventos

Ejemplo con props en TSX:
```tsx
type UserProps = {
  name: string;
  age: number;
};

const UserCard = ({ name, age }: UserProps) => {
  return (
    <div>
      <h2>{name}</h2>
      <p>Edad: {age}</p>
    </div>
  );
};
```
UserProps asegura que name y age sean del tipo correcto.

## 5. Uso de Tipos en TSX
✅ 1. Tipando Props
📌 Ejemplo con interface:
```tsx
interface ButtonProps {
  text: string;
  onClick: () => void;
}

const Button = ({ text, onClick }: ButtonProps) => {
  return <button onClick={onClick}>{text}</button>;
};
```
Garantiza que text es un string y onClick es una función sin argumentos.

✅ 2. Tipando Estado con useState
📌 Ejemplo: Estado tipado como number:
```tsx
import { useState } from "react";

const Counter = () => {
  const [count, setCount] = useState<number>(0);

  return (
    <div>
      <p>Contador: {count}</p>
      <button onClick={() => setCount(count + 1)}>Incrementar</button>
    </div>
  );
};
```
useState<number>(0) asegura que count siempre será un número.

✅ 3. Tipando Eventos en TSX
📌 Ejemplo: Evento onChange en un input:
```tsx
const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
  console.log(event.target.value);
};

<input type="text" onChange={handleChange} />;
```
Evita errores asegurando que event.target.value existe.

## 6. Inferencia de Tipos en TSX
TypeScript puede inferir tipos automáticamente, reduciendo código innecesario.

📌 Ejemplo con Inferencia de Tipos:
```tsx
const multiplyByTwo = (num: number) => num * 2;
```
📌 No es necesario especificar el tipo de retorno (number), TypeScript lo infiere.

📌 Ejemplo de Estado con Inferencia:
```tsx
const [count, setCount] = useState(0); // TypeScript infiere "number"
```