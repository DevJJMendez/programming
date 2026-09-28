# Estructura de Directorios 
## Estructura de Directorios Inicial
```lua
my-project/
├── node_modules/
├── public/
│   ├── favicon.ico
│   └── index.html
├── src/
│   ├── assets/
│   ├── components/
│   ├── views/
│   ├── App.vue
│   └── main.js
├── .gitignore
├── babel.config.js
├── package.json
├── README.md
├── vue.config.js
└── yarn.lock / package-lock.json
```

## Descripción de los Directorios y Archivos
1. `node_modules/`
   * Contiene todas las dependencias instaladas a través de `npm` o `yarn`.

   * No lo edites manualmente; se genera automáticamente al instalar paquetes.

2. `public/`
   * Este directorio contiene archivos estáticos que no serán procesados por Webpack.

   * Ideal para imágenes, fuentes y otros archivos que no necesitan ser transformados.
   
   * **Archivos principales**:
     * `index.html`: Es la plantilla principal de tu aplicación. Vue CLI inyectará automáticamente los scripts generados por Webpack.
     
     * `favicon.ico`: Icono que aparece en la pestaña del navegador.

3. `src/`: Este es el núcleo del proyecto donde reside tu código fuente.

   * Subdirectorios y archivos:
     
     * `assets/`: Contiene recursos como imágenes, estilos (CSS/SCSS), y fuentes que serán procesados por Webpack.
     
     * `components/`: Aquí se encuentran los componentes reutilizables
     
     * `views/`: Contiene las vistas principales de tu aplicación. Estas son las páginas a las que se accede a través de rutas.
     
4. `App.vue`
   * Es el componente raíz de tu aplicación. Todos los demás componentes se renderizan dentro de este archivo.

   * Normalmente, contiene la estructura base del layout.

5. `main.js`
   * Punto de entrada principal de tu aplicación.

   * Aquí se inicializa la aplicación, se importa `Vue`, los plugins (como `Vue Router` o `Vuex`) y se monta en el DOM.
```js
import { createApp } from "vue";
import App from "./App.vue";

createApp(App).mount("#app");
```

## Archivos Configuración
1. `package.json`: Contiene información del proyecto, dependencias y scripts definidos por el usuario.
```json
{
  "scripts": {
    "serve": "vue-cli-service serve",
    "build": "vue-cli-service build",
    "lint": "vue-cli-service lint"
  }
}
```

2. `babel.config.js`: Configuración para Babel, que se usa para transpilar código JavaScript moderno a versiones compatibles con navegadores antiguos.

3. `vue.config.js`: Archivo opcional para personalizar configuraciones de Webpack y otras opciones específicas de Vue CLI.
```json
module.exports = {
  devServer: {
    proxy: "http://localhost:4000",
  },
};
```

4. .gitignore: Lista de archivos y directorios que no deben ser incluidos en el repositorio de Git.

5. `README.md`: Documentación del proyecto, generalmente para el repositorio de GitHub.

# Estructura Escalable para Aplicaciones Grandes
En proyectos grandes, es importante organizar el código para que sea fácil de mantener. Una estructura recomendada es:
```lua
my-project/
├── public/
├── src/
│   ├── api/
│   ├── assets/
│   │   ├── images/
│   │   └── styles/
│   ├── components/
│   │   ├── common/
│   │   └── layout/
│   ├── composables/
│   ├── directives/
│   ├── router/
│   │   └── index.js
│   ├── store/
│   │   └── index.js
│   ├── utils/
│   ├── views/
│   ├── App.vue
│   └── main.js
├── .env
└── vue.config.js
```
## Descripción de Nuevos Directorios
1. `api/`: Archivos para gestionar las llamadas a la API.
```js
import axios from "axios";

export const fetchProducts = () => axios.get("/api/products");
```

2. `composables/`: Hooks reutilizables usando la API de Composition en Vue 3.
```js
import { ref } from "vue";

export function useCounter() {
  const count = ref(0);
  const increment = () => count.value++;
  return { count, increment };
}
```

3. `directives/`: Directivas personalizadas como `v-focus`.

4. `router/`: Configuración de rutas usando `Vue Route`r.
```js
import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";

const routes = [{ path: "/", name: "Home", component: Home }];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
```

5. `store/`: Gestión del estado global de la aplicación usando **`Vuex`** o **`Pinia`**.

6. `utils/`: Funciones utilitarias reutilizables.

## Buenas Prácticas
* **Organiza los Componentes**: Usa carpetas como common para componentes compartidos y layout para layouts específicos.

* **Usa Nombres Descriptivos**: Nombres consistentes y claros para archivos y directorios.

* **Mantén los Archivos Pequeños**: Divide el código en múltiples archivos si es necesario.

* **Usa Linters y Formateadores**: Configura ESLint y Prettier para mantener un código consistente.

* **Utiliza Variables de Entorno**: Usa archivos `.env` para configurar URLs o claves de API
```json
VUE_APP_API_URL=http://api.example.com
```