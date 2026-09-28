# ¿Estado de la aplicación?
El estado representa **los datos actuales que afectan lo que se muestra y cómo se comporta la UI** en un momento dado.

Es todo lo que puede cambiar dinámicamente mientras el usuario interactúa con la app.

En palabras simples: **el estado es “la memoria viva” de tu app.**

## Ejemplos de estado
* Valor de un input de búsqueda
* Si un modal está abierto o cerrado
* Lista de productos obtenidos de una API
* Usuario autenticado (o no)
* Número de ítems en un carrito
* Tema (claro/oscuro)
* Filtro aplicado en una tabla
* Estado de carga (loading, error, success)

## ¿Para qué sirve el estado?
* Controla lo que se renderiza
* Conecta la UI con los datos
* Hace que React “reaccione” a los cambios
* Permite re-renderizar la vista automáticamente cuando cambian los datos

## ¿Qué problema resuelve?
Sin un sistema de estado, tendrías que:
* Usar variables globale
* Manipular directamente el DO
* Sincronizar manualmente la vista con los datos

Todo esto te lleva a código:
* Frágil
* Inmantenible
* Propenso a bugs

## ¿Qué tipos de estado existen?
### 1. Estado local (Local State)
Es el más común y se gestiona dentro de un componente individual.

Se maneja con useState, useReducer, useEffect
```tsx
const [count, setCount] = useState(0);
```

### 2. Estado global (Global State)
Necesita ser compartido entre múltiples componentes.

📌 Se maneja con contextos (useContext), o librerías como Redux, Zustand, Jotai...

Ejemplo: el usuario autenticado debe estar disponible en toda la app.

### 3. Estado derivado o computado
No es almacenado directamente, sino calculado a partir de otros estados.

📌 Se maneja con funciones o useMemo
```tsx
const total = carrito.reduce((acc, item) => acc + item.precio, 0);
```

### 4. Estado persistente
Se guarda en localStorage, sessionStorage, indexedDB o backends.

📌 Permite recordar datos después de recargar la página

### 5. Estado remoto
Datos que vienen de APIs externas (servidores, servicios, etc.)

📌 Se obtiene con fetch, axios, SWR, React Query, etc.
```tsx
const [productos, setProductos] = useState([]);

useEffect(() => {
  fetch("/api/productos").then(res => res.json()).then(setProductos);
}, []);
```

## Cómo React maneja el estado?
1. Te da hooks como useState, useReducer, useContext

2. Te permite declarar tu estado dentro de componentes

3. Cada vez que el estado cambia → React vuelve a renderizar el componente

4. La UI se sincroniza automáticamente con los nuevos datos

## Ciclo del estado en React
1. Se declara el estado inicial → useState

2. El usuario interactúa (click, input, scroll…)

3. El estado cambia con setState

4. React re-renderiza el componente

5. La UI se actualiza automáticamente

## Mentalidad profesional
Un buen desarrollador React:

* Separa el estado local y el global
* Evita levantar estado innecesario
* Usa props para pasar estado, y callbacks para modificarlo
* No abusa del estado global (solo cuando es necesario)
* Evita que la UI dependa de muchos estados dispersos

## ¿Cómo decidir dónde poner un estado?
Usá esta tabla mental:

| ¿Quién lo necesita?         | ¿Dónde va el estado?                   |
| --------------------------- | -------------------------------------- |
| Solo un componente          | `useState` en ese componente           |
| Varios componentes hermanos | Estado en el padre                     |
| Toda la app                 | Context o store (Redux, Zustand)       |
| Viene de backend            | useEffect + fetch, o librería de datos |