# useState
useState es un hook de React que te permite declarar y manejar estado local dentro de un componente funcional.

Antes necesitábamos clases para esto (this.state), pero ahora puedes tener estado en componentes totalmente funcionales.

## Estructura de useState
```tsx
const [estado, setEstado] = useState(valorInicial);
```
* estado ->	El valor actual del estado
* setEstado ->	Función para actualizar ese estado
* useState ->	Hook que crea el estado
* valorInicial ->	Valor inicial que tendrá el estado

## ¿Para qué sirve?
* Te permite que un componente:
* Recuerde valores entre renders
* Se actualice dinámicamente al cambiar el estado
* Dispare re-renderizados cuando el estado cambia

## ¿Qué problema resuelve?
Antes de los hooks:

Solo podías manejar estado en componentes de clase

El código era más verboso, difícil de testear y reutilizar

useState: ✅ Elimina la necesidad de clases
✅ Permite estado en componentes funcionales
✅ Mejora legibilidad y separación de responsabilidades

## ¿Cómo lo resuelve?
Ejemplo básico 👇
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
```
Aquí:
* count = 0 al principio
* Al hacer clic, setCount actualiza el estado
* React re-renderiza el componente con el nuevo valor

## Tipos de datos que puedes usar
useState puede manejar cualquier tipo de dato: numbers, strings, arrays, functions, etc.
```tsx
const [age, setAge] = useState(25);
const [name, setName] = useState("JJ");

const [user, setUser] = useState({ name: "", age: 0 });
setUser((prev) => ({ ...prev, name: "Juan" }));

const [tasks, setTasks] = useState<string[]>([]);
```

## Tips y buenas prácticas
1. Evita modificar el estado directamente ❌
```tsx
// ❌ No hagas esto
user.name = "Ana";


// ✅ Haz esto
setUser({ ...user, name: "Ana" });
```

2. Usa funciones cuando dependas del valor anterior ✅
```tsx
setCount((prevCount) => prevCount + 1);
```

3. Tipa correctamente con TypeScript
```tsx
const [name, setName] = useState<string>("");
const [todos, setTodos] = useState<Array<Todo>>([]);
```

## ¿Cuándo React re-renderiza?
👉 Cada vez que llamas a setState, React:

* Actualiza internamente el valor
* Vuelve a renderizar el componente
* Vuelve a evaluar el JSX (pero no recarga el DOM completo)

## Mental Model (cómo pensarlo)
* El valor de useState se mantiene entre renders
* Cada cambio en el estado crea una nueva "versión" del componente
* Esto hace que el UI se mantenga sincronizado con los datos

## Casos de uso comunes
| Caso                      | Estado               |
| ------------------------- | -------------------- |
| Inputs controlados        | useState("")         |
| Mostrar/ocultar elementos | useState(true/false) |
| Contador, pasos           | useState(0)          |
| Gestión de formularios    | useState({})         |
| Checkboxes dinámicos      | useState([])         |
