# Eventos
Los eventos en React son objetos que representan interacciones del usuario con la interfaz, como clics, teclas presionadas, movimientos del mouse, envío de formularios, etc.

React implementa un sistema propio de eventos llamado Synthetic Event que normaliza el comportamiento entre navegadores.

## ¿Para qué sirven?
Sirven para detectar e interactuar con acciones del usuario, y ejecutar lógica personalizada en respuesta a:

* Clics de botones
* Entradas en formularios
* Movimiento o enfoque de elementos
* Cambios de estado, scrolls, etc.

🎯 Te permiten convertir tu UI en una aplicación viva y reactiva.

## ¿Qué resuelven?
Antes necesitábamos manipular el DOM directamente con addEventListener o onclick, lo cual era:

* Poco mantenible
* Verboso
* Dificultaba el desacople entre UI y lógica

React abstrae esto con un sistema declarativo y funcional que:

✅ Asocia eventos directamente al JSX
✅ Usa un solo listener global para rendimiento
✅ Normaliza el objeto del evento
✅ Permite manejar lógica fácilmente en componentes

## Tipos de eventos en React
React agrupa los eventos en varias categorías, muy similares a las del DOM pero con nombre en camelCase:

* Mouse ->	onClick, onDoubleClick, onMouseEnter, onMouseLeave, onContextMenu

* Teclado ->	onKeyDown, onKeyUp, onKeyPress

* Formulario ->	onChange, onSubmit, onInput, onFocus, onBlur

* Touch ->	onTouchStart, onTouchMove, onTouchEnd

* Clipboard ->	onCopy, onPaste, onCut

* Drag -> & Drop	onDragStart, onDrop, onDragOver, etc.

* Window ->/UI	onScroll, onResize (normalmente se manejan con window.addEventListener)

## ¿Cómo se usan?
📌 Sintaxis básica
```tsx
const handleClick = () => {
  console.log("¡Clickeado!");
};

return <button onClick={handleClick}>Haz clic</button>;
```
✅ Siempre se pasan referencias a funciones, no invocaciones directas
✅ Los nombres de los eventos usan camelCase, no lowercase como en HTML

* Ejemplo con evento de input
```tsx
const [name, setName] = useState("");

const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
  setName(event.target.value);
};

return <input type="text" value={name} onChange={handleChange} />;
```
Aquí:
* event es un SyntheticEvent
* React se encarga de reutilizarlo y limpiar el DOM
* El valor del input se sincroniza con el estado (useState)

## Objeto SyntheticEvent
React reemplaza el Event nativo del DOM por su propio SyntheticEvent para asegurar que el comportamiento sea consistente entre navegadores.

Puedes acceder a:

* event.target
* event.preventDefault()
* event.stopPropagation()
* event.currentTarget
```tsx
const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
  e.preventDefault();
  console.log("Formulario enviado");
};
```

## Precauciones importantes
1. Nunca ejecutes directamente funciones en el JSX
```tsx
// ❌ Mal
<button onClick={handleClick()}>Click</button>

// ✅ Bien
<button onClick={handleClick}>Click</button>
```

2. Siempre tipa correctamente el evento en TypeScript
```tsx
const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => { ... }
```

3. Evita lógica compleja dentro del handler: Extrae a funciones si es necesario.

## Mentalidad de Senior
En React, los eventos no son solo funciones que se disparan. Son parte del flujo declarativo y reactivo del componente.

* Mantén los handlers puros y enfocados
* Extrae lógica a funciones o hooks personalizados
* No manipules el DOM directamente (usa refs si es necesario)
* Usa el estado (useState) para reflejar los cambios de eventos

## Buenas prácticas
✅ Nombra los handlers con prefijos: handle, on
✅ Evita anidar lógica directamente en JSX
✅ Usa tipos específicos en TypeScript
✅ Limpia listeners externos (como en useEffect) si agregas eventos globales