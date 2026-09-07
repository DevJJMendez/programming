# Estructura de Directorios Escalable
```bash
/mi-app
 ├── /src              # Código fuente de la aplicación
 │    ├── /assets      # Imágenes, fuentes, estilos globales
 │    ├── /components  # Componentes reutilizables
 │    ├── /pages       # Páginas de la aplicación
 │    ├── /hooks       # Custom Hooks
 │    ├── /context     # Manejo de estado global (Context API)
 │    ├── /store       # Manejo de estado con Redux/Zustand
 │    ├── /services    # Llamadas a APIs externas
 │    ├── /utils       # Funciones auxiliares
 │    ├── /routes      # Configuración de React Router
 │    ├── /config      # Configuraciones globales (ej. variables de entorno)
 │    ├── App.tsx      # Componente raíz
 │    ├── main.tsx     # Punto de entrada (ReactDOM.render)
 ├── /public           # Archivos estáticos (index.html, manifest.json)
 ├── /tests            # Pruebas unitarias y de integración
 ├── package.json      # Dependencias y scripts del proyecto
 ├── tsconfig.json     # Configuración de TypeScript (si se usa)
 ├── .eslintrc.js      # Configuración de ESLint
 ├── .gitignore        # Archivos a ignorar en Git
```
* **`src/`** (Código fuente)
  * **`assets/`** → Contiene imágenes, fuentes y estilos globales.

  * **`components/`** → Componentes reutilizables como botones, inputs, modales, etc.

  * **`pages/`** → Componentes que representan páginas completas (ej: Home, Login, Dashboard).

  * **`hooks/`** → Custom Hooks (useAuth.ts, useFetch.ts, etc.) para encapsular lógica reutilizable.

  * **`context/`** → Para manejar el estado global con Context API.

  * **`store/`** → Si usas Redux o Zustand, aquí van los stores y reducers.

  * **`services/`** → Para hacer llamadas a APIs externas o servicios como Firebase.

  * **`utils/`** → Funciones reutilizables como formateadores, validadores, etc.

  * **`routes/`** → Definición de rutas con React Router.

  * **`config/`** → Configuración de la app (ej. variables de entorno).

* **`public/`** (Archivos estáticos): Contiene archivos que no pasan por Webpack, como `index.html`, `favicon.ico` y `manifest.json`.

* `tests/` (Pruebas): Aquí van las pruebas unitarias e integración, con Jest y React Testing Library.
```bash
/tests
 ├── /components
 │    ├── Button.test.tsx
 ├── /hooks
 │    ├── useFetch.test.ts
```

* `package.json`: Define las dependencias del proyecto y scripts como **`npm start`** o **`npm test`**.

# Nomenclaturas
## 1. Nomenclatura de Archivos y Carpetas
📌 Reglas Generales:
✅ Usa camelCase para carpetas y archivos de utilidades.
✅ Usa PascalCase para archivos de componentes.
✅ Usa kebab-case para archivos de configuración.
✅ No uses espacios ni caracteres especiales.

📌 Ejemplo de estructura correcta:
```bash
/src
 ├── /components
 │    ├── Button.tsx          ✅ (PascalCase para componentes)
 │    ├── Navbar.tsx          ✅ 
 │    ├── UserProfile.tsx     ✅
 │    ├── /shared
 │    │    ├── Modal.tsx      ✅ 
 │    │    ├── Avatar.tsx     ✅
 │    │    ├── index.ts       ✅ (Para exportar componentes del módulo)
 │    │
 ├── /hooks
 │    ├── useAuth.ts          ✅ (camelCase con "use" para hooks)
 │    ├── useFetch.ts         ✅
 │
 ├── /utils
 │    ├── formatDate.ts       ✅ (camelCase para funciones utilitarias)
 │    ├── apiRequest.ts       ✅
 │
 ├── /context
 │    ├── AuthContext.tsx     ✅ (PascalCase para contextos)
 │
 ├── /pages
 │    ├── Home.tsx            ✅ (PascalCase para páginas)
 │    ├── Login.tsx           ✅
 │
 ├── App.tsx                  ✅ (PascalCase)
 ├── index.tsx                ✅ (camelCase, archivo principal)
 ├── styles.css                ✅ (kebab-case para CSS)
 ├── .eslintrc.js              ✅ (kebab-case para archivos de configuración)
```

## 2. Nombres de Componentes
✅ PascalCase (UpperCamelCase) para componentes de React.
✅ Usa nombres descriptivos y significativos.
✅ Evita nombres genéricos como Component.tsx o Item.tsx.
✅ No uses prefijos como My (MyButton.tsx ❌).

📌 Ejemplo Correcto:
```tsx
const UserProfile = () => {
  return <h1>Perfil del Usuario</h1>;
};

export default UserProfile;
```

## 3. Nombres de Hooks Personalizados
✅ Siempre deben comenzar con "use" y seguir camelCase.
✅ El nombre debe indicar qué funcionalidad proporciona el hook.

📌 Ejemplo Correcto:
```tsx
const useAuth = () => { ✅ (Empieza con "use")
  const [user, setUser] = useState(null);
  return { user, setUser };
};
```

## 4. Nombres de Variables y Funciones
✅ Usa camelCase para nombres de variables y funciones.
✅ Usa nombres descriptivos que expliquen su propósito.
✅ Evita abreviaciones innecesarias.

📌 Ejemplo Correcto:
```tsx
const userName = "Juan"; ✅
const getUserProfile = () => {}; ✅
```

## 5. Nombres de Props y Estados en Componentes
✅ Usa camelCase para props y estados.
✅ Usa nombres que describan claramente su propósito.
✅ Evita nombres genéricos como data, value, info.

📌 Ejemplo Correcto:
```tsx
const UserCard = ({ userName, userAge }) => { ✅
  return <h1>{userName} - {userAge} años</h1>;
};
```

## 6. Nombres de Context API y Reducers
✅ PascalCase para nombres de contextos.
✅ Usa camelCase para reducers y funciones dentro de contextos.

📌 Ejemplo Correcto:
```tsx
const AuthContext = createContext(); ✅
const authReducer = (state, action) => {}; ✅
```

##  7. Nombres de Archivos de Estilos
✅ Usa kebab-case para archivos CSS o SCSS.
✅ Usa nombres de archivos relacionados con el componente o módulo.

📌 Ejemplo Correcto:
```bash
/styles
 ├── global.css ✅
 ├── button.css ✅
 ├── navbar.css ✅
```

##  8. Nombres de Tests (Jest, Testing Library)
✅ Usa el mismo nombre del archivo del componente con .test.js o .spec.js.
✅ Usa camelCase en los nombres de los test cases.

📌 Ejemplo Correcto:
```bash
/__tests__
 ├── Button.test.tsx ✅
 ├── Navbar.test.tsx ✅
```