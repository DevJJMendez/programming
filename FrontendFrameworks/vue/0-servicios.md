# Servicios

Los servicios en Vue.js son una manera de manejar la lógica de negocio y el estado compartido de una manera modular y reutilizable. Aunque Vue.js no proporciona una estructura de servicio predefinida como Angular, los servicios pueden crearse utilizando diversas técnicas y patrones, como módulos de Vuex, plugins, o simplemente archivos JavaScript separados.

## ¿Qué son los Servicios?

En términos simples, los servicios son módulos o componentes no visuales que encapsulan lógica de negocio, llamadas a API, y gestión de estado. Esto permite mantener el código más organizado, limpio y fácil de mantener.

## Estructura de carpetas

La estructura de directorios al usar servicios en una aplicación Vue.js puede variar según las preferencias del equipo y las convenciones del proyecto. Sin embargo, hay algunas prácticas recomendadas que pueden ayudar a mantener el código organizado y modular.

```bash
├── node_modules/
├── public/
│   ├── index.html
│   └── ...
├── src/
│   ├── assets/
│   │   └── ...
│   ├── components/
│   │   ├── ExampleComponent.vue
│   │   └── ...
│   ├── services/
│   │   ├── apiService.js
│   │   └── ...
│   ├── store/
│   │   ├── modules/
│   │   │   ├── posts.js
│   │   │   └── ...
│   │   └── index.js
│   ├── views/
│   │   ├── HomeView.vue
│   │   └── ...
│   ├── App.vue
│   ├── main.js
│   └── router/
│       ├── index.js
│       └── ...
├── babel.config.js
├── package.json
└── README.md
```
## Estructura de un servicio

Un servicio generalmente es un archivo JavaScript (o TypeScript) que **exporta** funciones o clases. Estos servicios pueden ser **importados** y utilizados en componentes Vue.

**Ejemplo de un Servicio**

`apiService.js`
```js
import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'https://api.example.com',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
});

export default {
  getPosts() {
    return apiClient.get('/posts');
  },
  getPost(id) {
    return apiClient.get(`/posts/${id}`);
  },
  createPost(data) {
    return apiClient.post('/posts', data);
  },
  updatePost(id, data) {
    return apiClient.put(`/posts/${id}`, data);
  },
  deletePost(id) {
    return apiClient.delete(`/posts/${id}`);
  }
};
```
En este ejemplo, `apiService.js` es un servicio que encapsula varias llamadas a una API REST.

## ¿Para qué sirven los Servicios?

- **Separación de Preocupaciones**: Mantener la lógica de negocio separada de los componentes de la interfaz de usuario.
- **Reutilización**: Facilitar la reutilización de código entre diferentes componentes.
- **Testabilidad**: Hacer que el código sea más fácil de probar al aislar la lógica de negocio.
- **Mantenimiento**: Facilitar el mantenimiento y la escalabilidad del código.

## ¿Cuándo usar Servicios?

- **Llamadas a API**: Encapsular la lógica de las llamadas a API en servicios.
- **Lógica de Negocio Compleja**: Mover la lógica compleja fuera de los componentes.
- **Estado Compartido**: Gestionar el estado compartido entre múltiples componentes.
- **Operaciones Asíncronas**: Manejar operaciones asíncronas, como la carga de datos, de una manera centralizada.