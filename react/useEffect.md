# useEffect
useEffect es un hook que permite ejecutar efectos secundarios (side effects) en componentes funcionales de React.

React es declarativo y reactivo, pero a veces necesitamos:

* Ejecutar lógica al montar/desmontar el componente
* Escuchar cambios de props/estado
* Llamar APIs, suscribirse, modificar el DOM

Ahí entra useEffect.

## ¿Qué son efectos secundarios?
Son operaciones que afectan algo fuera del componente:

* Fetch de datos (fetch, axios, etc.)
* Manipular localStorage o cookies
* Suscripciones (sockets, listeners)
* Timers (setTimeout, setInterval)
* Interacciones con APIs externas

## ¿Cuál es su estructura?
```tsx
useEffect(() => {
  // Código del efecto

  return () => {
    // Limpieza del efecto (opcional)
  };
}, [dependencias]);
```
Partes:
✅ Función anónima (callback principal)

🔁 Función de limpieza (opcional, para cancelar timers, suscripciones, etc.)

📌 Array de dependencias: determina cuándo se ejecuta el efecto

## ¿Para qué sirve?
| Uso común          | Ejemplo                                    |
| ------------------ | ------------------------------------------ |
| Peticiones HTTP    | fetch, axios, getData()                    |
| Subscripciones     | websocket, eventListener, interval         |
| DOM manual         | document.title = ..., window.scrollTo(...) |
| Reacción a cambios | props, state                               |

## ¿Qué resuelve?
Antes teníamos los métodos del ciclo de vida en clases:

* componentDidMount
* componentDidUpdate
* componentWillUnmount

Ahora todo eso se hace con useEffect, en funciones, de forma declarativa y centralizada.

## ¿Cómo funciona?
React ejecuta el efecto:

1. Después del render (nunca durante)
2. Según el array de dependencias
3. Limpia el efecto anterior antes de ejecutar el nuevo (si hay return)

## Ejemplos comunes
✅ Ejecutar solo una vez (componente montado)
```tsx
useEffect(() => {
  console.log("Componente montado");
}, []); // Array vacío = solo al montar
```

✅ Ejecutar cuando cambian dependencias
```tsx
useEffect(() => {
  console.log("Valor cambió:", count);
}, [count]);
```

✅ Petición a API al cargar
```tsx
useEffect(() => {
  const fetchData = async () => {
    const res = await fetch("/api/productos");
    const data = await res.json();
    setProductos(data);
  };

  fetchData();
}, []);
```

✅ Limpieza de efectos (unmount, prevenir fugas de memoria)
```tsx
useEffect(() => {
  const timer = setInterval(() => {
    console.log("Tick...");
  }, 1000);

  return () => {
    clearInterval(timer); // Limpieza
    console.log("Componente desmontado");
  };
}, []);
```

## Importancia del array de dependencias
| Dependencias | Comportamiento                               |
| ------------ | -------------------------------------------- |
| [] (vacío)   | Solo al montar                               |
| [valor]      | Al montar y cuando cambia ese valor          |
| sin array    | Se ejecuta en cada render (⚠️ No recomendado) |

## Mentalidad de senior: ¿cuándo usar useEffect?
Usalo solo cuando el efecto no puede resolverse con renderizado puro.

✅ Llamadas a APIs
✅ Temporizadores / listeners
✅ Interacción con el navegador (scroll, title, focus)
❌ No para calcular valores → usá useMemo o funciones
❌ No para actualizar estado en cada render innecesariamente

### Reactividad en acción
```tsx
useEffect(() => {
  if (userId) {
    fetch(`/api/user/${userId}`)
      .then((res) => res.json())
      .then((data) => setUser(data));
  }
}, [userId]); // Se vuelve a ejecutar cuando cambia el userId
```

## Buenas prácticas
✅ Mantené los efectos puros y predecibles
✅ Encapsulá lógica en funciones dentro del efecto
✅ Siempre tipá correctamente si usás TypeScript
✅ No bloquees el render, usá funciones async dentro
✅ Evitá que el efecto se vuelva a disparar por referencias nuevas (usa useCallback, useMemo si es necesario)

## Errores comunes
🚫 Poner una función async directamente en useEffect
```tsx
// ❌ Esto rompe
useEffect(async () => {
  await fetchData();
}, []);
```
✅ Hacelo así:
```tsx
useEffect(() => {
  const fetchData = async () => {
    await ...
  };
  fetchData();
}, []);
```