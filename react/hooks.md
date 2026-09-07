# Hooks
Los Hooks son funciones especiales de React que te permiten usar estado, ciclos de vida, referencias, contexto, y más en componentes funcionales (sin clases).

👉 Antes (con clases):
```tsx
class App extends React.Component {
  state = { count: 0 };
  render() {
    return <button onClick={() => this.setState({ count: this.state.count + 1 })}>{this.state.count}</button>;
  }
}
```
Ahora (con Hooks):
```tsx
const App = () => {
  const [count, setCount] = useState(0);
  return <button onClick={() => setCount(count + 1)}>{count}</button>;
};
```

## ¿Para qué sirven?
| Necesidad                               | Hook que lo resuelve |
| --------------------------------------- | -------------------- |
| Estado local                            | useState             |
| Lógica al montar/actualizar/desmontar   | useEffect            |
| Referencias (DOM, valores persistentes) | useRef               |
| Compartir lógica reutilizable           | Custom Hooks         |
| Estado complejo                         | useReducer           |
| Contexto global                         | useContext           |

## ¿Qué resuelven?
Antes de los Hooks, necesitábamos:

* Componentes de clase (más complejos)
* HOCs (High Order Components)
* Render props (boilerplate)
* Poca reutilización de lógica

🔥 Los Hooks eliminan esas limitaciones, permitiendo lógica reutilizable sin clases, manteniendo todo funcional, limpio y modular.

## Reglas de los Hooks
* Solo en la raíz del componente (no dentro de condicionales, bucles o funciones anidadas)
* Solo en funciones React (componentes o custom hooks)
* Usa siempre el prefijo use en tus custom hooks

## Mental Model: Cómo pensarlos como senior
* Hooks modelan el ciclo de vida de forma funcional
* Promueven composición de lógica (en lugar de herencia)
* Ayudan a mantener componentes pequeños y declarativos
* Separan vista de lógica sin necesidad de clases

## Buenas prácticas
✅ Usa useEffect solo para efectos secundarios (no lógica de negocio)
✅ Extrae lógica a custom hooks cuando veas duplicación
✅ Memoiza funciones que pasas como props si hay renders innecesarios
✅ Organiza Hooks siempre arriba del return (convención)