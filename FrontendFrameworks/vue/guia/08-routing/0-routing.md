# Routing

El enrutamiento (routing) en Vue.js se maneja principalmente con **Vue Router**, que es una biblioteca oficial de Vue.js. **Vue Router** permite definir rutas en la aplicación, navegar entre diferentes vistas y gestionar la navegación del usuario.

## Instalación de Vue Router

Primero, asegúrate de tener Vue Router instalado en tu proyecto. Si no lo tienes instalado, puedes hacerlo mediante **npm** o **yarn**:

```bash
npm install vue-router
# o
yarn add vue-router
```

## Uso Básico de Vue Router

- **Configuración Inicial**

Crea un archivo de configuración para las rutas, generalmente llamado `router/index.js`.
```js
// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import About from '../views/About.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
```

- **Integración en el Proyecto**

Importa y usa el router en el archivo principal `main.js` o `main.ts`
```js
// src/main.js
import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

createApp(App).use(router).mount('#app');
```

- **Definición de Vistas**

Crea componentes Vue para las vistas que se mencionaron en las rutas

`Home.vue`
```typescript
<template>
  <div>
    <h1>Home</h1>
    <p>Welcome to the Home Page</p>
  </div>
</template>

<script>
export default {
  name: 'Home'
};
</script>
```

`About.vue`
```typescript
<template>
  <div>
    <h1>About</h1>
    <p>This is the About Page</p>
  </div>
</template>

<script>
export default {
  name: 'About'
};
</script>
```

- Uso de `<router-link>` y `<router-view>`
```typescript
<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link>
      <router-link to="/about">About</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style>
nav a {
  margin: 10px;
}
</style>
```
## Rutas Anidadas

Las rutas anidadas permiten crear rutas dentro de otras rutas, lo que es útil para crear vistas secundarias.
```typescript
import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import About from '../views/About.vue';
import Profile from '../views/Profile.vue';
import Settings from '../views/Settings.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About,
    children: [
      {
        path: 'profile',
        name: 'Profile',
        component: Profile
      },
      {
        path: 'settings',
        name: 'Settings',
        component: Settings
      }
    ]
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
```

## Buenas Prácticas

- **Modularización**: Divide las rutas en módulos separados para mantener el archivo de configuración de rutas limpio y organizado.

- **Uso de Meta Fields**: Utiliza meta para agregar datos adicionales a las rutas, como requiresAuth, title, etc.

- **Gestión de Errores**: Implementa rutas de error y maneja errores de navegación adecuadamente.

Optimización: Usa lazy loading para cargar componentes de manera diferida y mejorar el rendimiento.
- **Guardias de Ruta**: Implementa guardias de ruta para manejar la autenticación y otras verificaciones antes de la navegación.

- **Documentación y Comentarios**: Documenta y comenta las rutas y su propósito para facilitar el mantenimiento.