# React
React es una biblioteca de JavaScript para construir interfaces de usuario interactivas y reutilizables. Fue creada por Facebook (Meta) y se lanzó en 2013. React es declarativo, basado en componentes y usa un Virtual DOM para mejorar el rendimiento.

## ¿Para qué sirve React?
Sirve para construir interfaces de usuario eficientes y escalables en aplicaciones web y móviles. Se usa en el desarrollo de Single Page Applications (SPA) y, con herramientas como React Native, también en el desarrollo de aplicaciones móviles.

## ¿Qué problemas resuelve React?
1. **Manipulación ineficiente del DOM**
   * Antes de React, modificar el DOM directamente era lento y costoso en rendimiento.

   * React usa un Virtual DOM, que minimiza actualizaciones innecesarias.

2. **Código difícil de mantener**
   * Antes, los proyectos grandes con jQuery o Vanilla JS se volvían difíciles de mantener.

   * React introduce componentes reutilizables, mejorando la organización del código.

3. **Dificultad para manejar el estado de la UI**: React usa un estado centralizado en los componentes y puede combinarse con bibliotecas como **`Redux`**, **`Zustand`** o **`React Context.`**

## ¿Cómo lo resuelve React?
* **`Virtual DOM`**: React no modifica el **`DOM`** real directamente. En su lugar:
  1. Mantiene una copia en memoria llamada **`Virtual DOM`**.
  
  2. Cuando el estado cambia, React compara el nuevo `Virtual DOM` con el anterior (reconciliación).
  
  3. Solo actualiza las partes necesarias del DOM real. *Esto mejora el rendimiento y evita renderizados innecesarios.*

* **Componentes reutilizables**: React se basa en componentes, que son funciones o clases que retornan **`JSX`**.
Ejemplo de un componente funcional:

```tsx
import React from 'react';

const Button = ({ text }: { text: string }) => {
  return <button>{text}</button>;
};

export default Button;
```
Cada componente encapsula lógica y estilos, lo que permite reutilizarlos fácilmente.

* **`One-way Data Binding` (Flujo de datos unidireccional)**: El estado fluye de padre a hijo, evitando inconsistencias en la UI.
```tsx
const App = () => {
  const [count, setCount] = React.useState(0);

  return <Counter count={count} onIncrement={() => setCount(count + 1)} />;
};

const Counter = ({ count, onIncrement }: { count: number; onIncrement: () => void }) => {
  return (
    <div>
      <p>Contador: {count}</p>
      <button onClick={onIncrement}>Incrementar</button>
    </div>
  );
};
```
La UI siempre refleja el estado más reciente.


# Crear APP
## 1. Usando create-react-app (CRA) [OBSOLETO PARA NUEVOS PROYECTOS]
`create-react-app` era la forma más popular de iniciar un proyecto en React, pero ha quedado obsoleto porque no es tan flexible y no soporta bien las nuevas features de React como Server Components.

Para crear un proyecto con CRA (aún funcional, pero no recomendado):
```bash
npx create-react-app mi-app
cd mi-app
npm start
```
* Fácil de usar
* Configuración lista con Webpack, Babel y ESLint
* No soporta Server Components
* No es fácilmente personalizable

📌 Alternativa moderna: Vite o Next.js

## 2. Usando Vite (Recomendada para SPAs)
Vite es una herramienta de construcción ultrarrápida para proyectos modernos en React, soporta TypeScript y es más eficiente que CRA.

📌 Para crear un proyecto con Vite:
```bash
# Con JavaScript
npm create vite@latest mi-app --template react

# Con TypeScript
npm create vite@latest mi-app --template react-ts

cd mi-app
npm install
npm run dev
```
* Rápido y ligero
* HMR (Hot Module Replacement) instantáneo
* Soporta TypeScript nativamente
* Más personalizable que CRA

Usa Vite si estás construyendo una SPA sin necesidad de Server Components.

## 3. Usando Next.js (Recomendada para SSR, SSG y Server Components)
Next.js es el framework más recomendado para aplicaciones React modernas. Soporta:

SSR (Server-Side Rendering)

SSG (Static Site Generation)

Server Components

API Routes

📌 Para crear un proyecto con Next.js:
```bash
# Con JavaScript
npx create-next-app@latest mi-app

# Con TypeScript
npx create-next-app@latest mi-app --ts

cd mi-app
npm run dev
```
* Optimizado para SEO con SSR y SSG
* Soporta Server Components
* Arquitectura híbrida (SSR, SSG, ISR, CSR)
* Mejor performance que una SPA pura
* Manejo de rutas integrado (sin React Router)

Usa Next.js si tu aplicación requiere SEO, Server Components o rendimiento optimizado.

# Versiones de React
## React 16.8 (2019): Introducción de Hooks
Novedades:

Hooks: Incorporación de funciones como useState y useEffect, permitiendo el uso de estado y efectos en componentes funcionales.​

Puntos fuertes:

Simplificación del código y mejor reutilización de lógica entre componentes.​

Diferencias:

Antes de los Hooks, el manejo de estado y efectos requería componentes de clase. Con los Hooks, los componentes funcionales ganaron estas capacidades, promoviendo un código más limpio y modular.​

##  React 17 (2020): Enfoque en Actualización Gradual
Novedades:

No introduce nuevas funcionalidades visibles para desarrolladores.​

Puntos fuertes:

Facilita la actualización gradual de aplicaciones, permitiendo que diferentes versiones de React coexistan en el mismo proyecto.​


Diferencias:

Mientras que versiones anteriores podían presentar desafíos al actualizar, React 17 se centra en hacer las transiciones más suaves sin romper cambios.​

## React 18 (2022): Mejoras en Concurrencia y Nuevos Hooks
Novedades:

Renderizado Concurrente: Optimiza la renderización, permitiendo que React prepare múltiples versiones de la UI en paralelo y mejore la responsividad de las aplicaciones.​

Suspense Mejorado: Facilita la gestión de carga de datos asíncronos, permitiendo mostrar indicadores de carga mientras se obtienen datos.​
OpenWebinars.net

Nuevos Hooks: Introducción de useTransition, useDeferredValue, useId, entre otros, que brindan mayor control sobre el estado y efectos.​
OpenWebinars.net
+1
matiashernandez.dev
+1

Puntos fuertes:

Mejora la experiencia del usuario al hacer las interfaces más rápidas y responsivas.​

Proporciona herramientas más poderosas y flexibles para desarrolladores.​

Diferencias:

A diferencia de React 17, que se centró en la actualización gradual, React 18 introduce mejoras significativas en rendimiento y nuevas APIs.

## React 19 (2024): Innovaciones en Server Components y Manejo de Estado
Novedades:

Server Components: Permite renderizar componentes en el servidor, reduciendo la carga en el cliente y mejorando tiempos de carga y SEO.​
OpenWebinars.net

Suspense para Datos Asíncronos: Expande el soporte de Suspense, facilitando la integración con APIs y fuentes de datos externas.​
OpenWebinars.net
+1
matiashernandez.dev
+1

Nuevos Hooks y Mejoras en el Estado: Incorporación de hooks como useTransition y useDeferredValue para gestionar transiciones de UI y estado de manera más eficiente.​
OpenWebinars.net

Optimización del Manejo del Estado: Introducción de Recoil 1.0, un sistema más intuitivo y flexible para gestionar el estado global de las aplicaciones.​
OpenWebinars.net

Soporte para CSS-in-JS: Mejora en la integración de estilos directamente dentro de los componentes de React utilizando JavaScript.​
OpenWebinars.net

Batching Automático: Agrupa múltiples actualizaciones de estado en un solo ciclo de renderización, mejorando el rendimiento al evitar renders innecesarios.​
OpenWebinars.net

Puntos fuertes:

Mejora significativa en el rendimiento y la experiencia del usuario.​
OpenWebinars.net

Simplificación en la gestión de estado y estilos, reduciendo la necesidad de herramientas externas.​
OpenWebinars.net

Diferencias:

Mientras que React 18 se enfocó en mejoras de concurrencia y nuevos hooks, React 19 introduce capacidades avanzadas como los Server Components y optimizaciones en el manejo del estado y estilos.​