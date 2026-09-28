# Vue.js
Vue.js 3 es un framework progresivo de JavaScript utilizado para construir interfaces de usuario (**UI**) y aplicaciones frontend de una sola página (**SPAs**). Es altamente modular y ofrece una curva de aprendizaje suave, lo que lo hace adecuado tanto para principiantes como para expertos.

Se basa en **Componentes Reactivos**, donde cada parte de la **UI** se descompone en bloques reutilizables llamados **componentes**.

## ¿Para qué sirve?
Vue.js 3 te permite construir:

* **Aplicaciones de una sola página (SPAs)**: Apps dinámicas con navegación sin recargas.

* **Interfaces de usuario (UI)**: UIs interactivas y ricas para aplicaciones web.

* **Componentes reutilizables**: Diseñar sistemas modulares para grandes proyectos.

* **Frontend de aplicaciones complejas**: Integración con **APIs** backend para manejar datos.

## ¿Qué resuelve?
* **Complejidad en el manejo de la UI dinámica**: Proporciona reactividad automática: cualquier cambio en los datos actualiza la UI automáticamente.

* **Modularidad y Reutilización**: Facilita la creación de componentes reutilizables, reduciendo la duplicación de código.

* **Manejo del Estado**: Ofrece soluciones como **`Pinia`** o **`Vuex`** para manejar estados globales de la aplicación.

* **Ecosistema Completo**: Incluye herramientas como **`Vue Router`** (para enrutamiento) y **`Vue CLI/Vite`** (para configurar proyectos rápidamente).

* **Rendimiento y Escalabilidad**: Vue.js 3 mejora el rendimiento respecto a su versión anterior mediante el **Composition API**, optimizaciones de renderizado y un tamaño más reducido.

## ¿Cómo lo resuelve?
1. **Reactividad**: Utiliza un sistema reactivo basado en proxies para detectar cambios en los datos y actualizar automáticamente la UI.
```js
import { reactive } from 'vue';

const state = reactive({
  count: 0,
});

function increment() {
  state.count++;
}
```

2. **Componentes**:
   * Cada componente encapsula lógica, estructura y estilo.

   * Uso de **Composition API** o la **Option API** para manejar lógica y estado.
```js
<template>
  <button @click="increment">Clicks: {{ count }}</button>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const count = ref(0);
    const increment = () => count.value++;
    return { count, increment };
  },
};
</script>
```

3. **Composición API**: Introducida en Vue 3, organiza mejor el código en funciones reutilizables.
```js
import { ref, computed } from 'vue';

export default {
  setup() {
    const price = ref(100);
    const quantity = ref(2);
    const total = computed(() => price.value * quantity.value);

    return { price, quantity, total };
  },
};
```

4. **Virtual DOM**: Minimiza actualizaciones innecesarias en el DOM real, mejorando el rendimiento.

5. **Directivas**: Vue usa directivas para manipular DOM directamente (ejemplo: `v-if`, `v-for`, `v-bind`).
```html
<p v-if="isVisible">Visible content</p>
```

6. **Enrutamiento**: Con **`Vue Router`**, puedes manejar rutas en tu aplicación SPA.
```js
import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  { path: '/', component: Home },
  { path: '/about', component: About },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
```