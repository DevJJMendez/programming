# Lifting State Up
Es una técnica de React que consiste en mover el estado (useState) desde un componente hijo hacia su componente padre común, para que ese estado pueda ser compartido entre varios componentes hermanos o gestionado de forma centralizada.

## ¿Por qué existe?
React no tiene un sistema de comunicación directa entre hermanos. Entonces, cuando dos o más componentes necesitan compartir información o sincronizarse, lo mejor es "elevar" el estado al ancestro común y distribuirlo a través de props.

## ¿Qué resuelve?
| Problema                                       | ¿Cómo lo resuelve?                                  |
| ---------------------------------------------- | --------------------------------------------------- |
| Componente A y B necesitan compartir estado    | Eleva ese estado al componente padre común          |
| Múltiples hijos deben modificar el mismo valor | Padre gestiona el valor y pasa handlers (callbacks) |
| Evita duplicación de estado entre componentes  | El estado vive en un solo lugar                     |

## Estructura básica del Lifting State Up
```tsx
// Padre
const Parent = () => {
  const [value, setValue] = useState("");

  return (
    <>
      <Input value={value} onChange={setValue} />
      <Display value={value} />
    </>
  );
};

// Hijo que modifica el estado
interface InputProps {
  value: string;
  onChange: (val: string) => void;
}

const Input = ({ value, onChange }: InputProps) => {
  return <input value={value} onChange={(e) => onChange(e.target.value)} />;
};

// Hijo que lee el estado
interface DisplayProps {
  value: string;
}

const Display = ({ value }: DisplayProps) => {
  return <p>Valor: {value}</p>;
};
```
Aquí:
* El estado value vive en el padre.
* Input (hijo) puede modificarlo con onChange.
* Display (hijo) lo lee.
* Ambos comparten el mismo source of truth.

## ¿Cuándo hacer Lifting?
Haz lifting del estado cuando:

✅ Dos o más componentes necesitan leer o modificar el mismo estado
✅ Quieres centralizar la lógica que afecta a varios componentes
✅ El estado necesita sincronizar visualmente varios lugares a la vez

## Caso de uso real: Filtros y lista
```tsx
const App = () => {
  const [search, setSearch] = useState("");

  return (
    <>
      <SearchBar query={search} onChange={setSearch} />
      <UserList query={search} />
    </>
  );
};
```
* SearchBar cambia el valor
* UserList filtra resultados con base en ese valor
* Ambos dependen del mismo estado, por eso se eleva

## Claves técnicas
* El estado se define en el ancestro común más cercano
* Se pasa el valor como prop
* Se pasa el modificador (setState) como callback por props
* Los hijos nunca crean ni duplican el estado