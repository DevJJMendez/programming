# Estado Persistente
Es cualquier dato de la app que sobrevive entre sesiones, recargas o navegación gracias a que se almacena fuera del runtime de React, típicamente en:

* localStorage
* sessionStorage
* Cookies
* IndexedDB
* Backend/API (pero eso ya es remoto)

React por sí solo no persiste el estado. Si cerrás la pestaña, useState() se reinicia.

## ¿Para qué sirve?
* Guardar preferencias del usuario (tema, idioma)
* Recordar usuarios logueados (token de sesión)
* Mantener carritos de compra
* Guardar progreso de formularios
* Recordar configuraciones personalizadas

## ¿Cómo se implementa?
Podés usar la Web Storage API (nativa del navegador) o usar hooks reutilizables.

Ejemplo con `localStorage` manual
```tsx
function usePersistedState<T>(key: string, initial: T) {
  const [state, setState] = useState<T>(() => {
    const stored = localStorage.getItem(key);
    return stored ? JSON.parse(stored) : initial;
  });

  useEffect(() => {
    localStorage.setItem(key, JSON.stringify(state));
  }, [key, state]);

  return [state, setState] as const;
}
```
Uso:
```tsx
const [tema, setTema] = usePersistedState<'light' | 'dark'>("tema", "light");
```
Ahora, si el usuario cambia de tema y recarga, el valor se mantiene.