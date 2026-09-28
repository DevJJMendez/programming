# Estado Derivado
Es un valor que no se guarda directamente en el estado, sino que se calcula (deriva) a partir de otros estados existentes.

En otras palabras:
**Es un dato que se puede obtener a partir de otro estado, por lo tanto, no necesita guardarse.**

## ¿Para qué sirve?
* Evita duplicar datos en el estado
* Simplifica la lógica
* Evita inconsistencias
* Hace que tu código sea más predecible, limpio y fácil de mantener

## ¿Para qué sirve?
* Evita duplicar datos en el estado
* Simplifica la lógica
* Evita inconsistencias
* Hace que tu código sea más predecible, limpio y fácil de mantener

## ¿Qué problema resuelve?
Supongamos que tenés:
```tsx
const [productos, setProductos] = useState([...]);
const [total, setTotal] = useState(0); // ❌
```
Estás guardando el total, pero en realidad podés calcularlo:
```tsx
const total = productos.reduce((acc, p) => acc + p.precio, 0); // ✅
```
Si dejás el total como estado, necesitás sincronizarlo cada vez que cambian los productos… y eso es innecesario y frágil.

## ¿Cómo se maneja el estado derivado en React?
Con funciones directamente en el render o con hooks como [useMemo](useMemo.md) (cuando es costoso calcularlo).

### Opción 1: Cálculo directo
```tsx
const productosFiltrados = productos.filter(p => p.stock > 0);
```
Cada vez que productos cambia, este valor se recalcula.

### Opción 2: useMemo (para optimización)
```tsx
const productosFiltrados = useMemo(() => {
  return productos.filter(p => p.stock > 0);
}, [productos]);
```
Esto evita recalcular el valor si productos no cambia, ideal cuando el cálculo es costoso.

## Estructura típica de estado derivado
```tsx
const [items, setItems] = useState([...]);

const total = useMemo(() => {
  return items.reduce((sum, item) => sum + item.precio, 0);
}, [items]);
```

## Casos comunes de estado derivado
* Totales (suma de montos, cantidad de ítems)
* Filtros (productos activos, usuarios inactivos)
* Contadores (número de tareas completadas)
* Formatos (fecha formateada, uppercase, etc.)
* Mapas (nombre completo, rutas generadas, etc.)

## Qué evitar
❌ Guardar en el estado cosas que podés derivar fácilmente

Ejemplo:
```tsx
// No hagas esto
const [productos, setProductos] = useState([]);
const [productosDisponibles, setProductosDisponibles] = useState([]); ❌

useEffect(() => {
  setProductosDisponibles(productos.filter(p => p.stock > 0));
}, [productos]);
```
Mejor:
```tsx
const productosDisponibles = useMemo(() => {
  return productos.filter(p => p.stock > 0);
}, [productos]);
```

## Mentalidad de developer senior
Un senior:

* Minimiza el estado → Solo guarda lo estrictamente necesario
* Deriva lo que puede derivar
* Sabe que más estado `≠` mejor
* Usa useMemo con intención (no por reflejo)
* Delega al render funciones puras cuando es simple