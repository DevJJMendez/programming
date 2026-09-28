# Lazy Loading

es una técnica de optimización que retrasa la carga de recursos hasta que son realmente necesarios. En el contexto de Vue, esto se refiere a la carga diferida de componentes o rutas, lo que puede mejorar significativamente el rendimiento de las aplicaciones grandes al reducir el tiempo de carga inicial.

## Lazy Loading de Rutas

**Vue Router** soporta el **lazy loading** de rutas de manera nativa. Esto se hace utilizando la función dinámica `import()`, que devuelve una promesa. Cuando una ruta se accede por primera vez, el componente asociado se carga.

**Ejemplo Básico de Lazy Loading de Rutas**

`router/index.js`
```typescript
import { createRouter, createWebHistory } from 'vue-router';

const Home = () => import(/* webpackChunkName: "home" */ '../views/Home.vue');
const About = () => import(/* webpackChunkName: "about" */ '../views/About.vue');
const User = () => import(/* webpackChunkName: "user" */ '../views/User.vue');
const Product = () => import(/* webpackChunkName: "product" */ '../views/Product.vue');

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
  },
  {
    path: '/users',
    name: 'User',
    component: User
  },
  {
    path: '/products',
    name: 'Product',
    component: Product
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
```

## Lazy Loading de Componentes

Además de las rutas, también puedes cargar componentes de manera diferida. Esto es útil cuando tienes componentes que solo se necesitan en ciertos momentos y no deben cargarse con la vista principal.

**Ejemplo Básico de Lazy Loading de Componentes**

`ParentComponent.vue`
```typescript
<template>
  <div>
    <h1>Parent Component</h1>
    <button @click="loadChild">Load Child Component</button>
    <ChildComponent v-if="showChild" />
  </div>
</template>

<script>
import { defineAsyncComponent } from 'vue';

export default {
  data() {
    return {
      showChild: false
    };
  },
  components: {
    ChildComponent: defineAsyncComponent(() => import('./ChildComponent.vue'))
  },
  methods: {
    loadChild() {
      this.showChild = true;
    }
  }
};
</script>
```

## Beneficios del Lazy Loading

- **Reducción del Tiempo de Carga Inicial**: Solo se cargan los componentes y vistas necesarios inicialmente, reduciendo el tiempo de carga.
  
- **Optimización de Recursos**: Carga diferida de recursos pesados hasta que realmente se necesitan.
  
- **Mejor Experiencia de Usuario**: Reduce el tiempo de espera para los usuarios, proporcionando una experiencia más fluida.