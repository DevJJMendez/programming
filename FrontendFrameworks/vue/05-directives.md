# Directives
Las directivas son atributos especiales que se utilizan en las plantillas de Vue.js para aplicar comportamientos reactivos a los elementos del DOM. Las directivas se reconocen por el prefijo `v-` seguido de un nombre específico que indica el comportamiento que se aplicará al elemento al que se adjunta la directiva.

## Directivas de Flujos de Control
Las directivas de flujos de control en Vue.js son instrucciones específicas que se utilizan en el HTML para manejar el renderizado condicional y la iteración de elementos en los templates. Estas directivas permiten controlar qué elementos se muestran en el DOM y cómo se organizan.

Son fundamentales para manejar dinámicamente la estructura de la interfaz de usuario en función de los datos reactivos.

## ¿Cuáles son las directivas de flujos de control?
En Vue.js, las principales directivas de flujo de control son:

* v-if: Renderizado condicional.

* v-else-if: Condición adicional en el flujo condicional.

* v-else: Caso alternativo cuando ninguna condición previa se cumple.

* v-show: Muestra/oculta elementos según una condición (sin eliminarlos del DOM).

* v-for: Renderizado iterativo para listas o arrays.

## ¿Para qué sirven?
* v-if / v-else-if / v-else:
  * Renderizan elementos condicionalmente según una expresión booleana.

  * Sirven para mostrar u ocultar partes del DOM en función de los datos reactivos.

* v-show: Similar a v-if, pero no elimina el elemento del DOM, solo lo oculta usando CSS (display: none).

* v-for: Permite iterar sobre listas, arrays, objetos o números para renderizar múltiples elementos dinámicamente.

## ¿Qué resuelven?
Controlar qué se renderiza en la interfaz:

Estas directivas permiten que la aplicación sea más dinámica y dependiente del estado de los datos.
Simplificación del flujo condicional:

Resuelven problemas como anidar demasiados condicionales en el template.
Iteración dinámica:

Resuelven la necesidad de generar dinámicamente elementos del DOM basados en datos cambiantes, como listas de tareas o productos.
Optimización del renderizado:

Usar v-show en lugar de v-if puede mejorar el rendimiento cuando la visibilidad de un elemento cambia frecuentemente.

## ¿Cómo lo resuelven?
v-if: Elimina completamente el elemento del DOM si la condición no se cumple, lo que ahorra recursos cuando el elemento no es necesario.
```ts
<template>
  <div>
    <p v-if="isLoggedIn">Bienvenido, usuario.</p>
    <p v-else>No has iniciado sesión.</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isLoggedIn: false,
    };
  },
};
</script>

<template>
  <div>
    <p v-if="role === 'admin'">Eres administrador.</p>
    <p v-else-if="role === 'editor'">Eres editor.</p>
    <p v-else>Eres un invitado.</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      role: 'editor',
    };
  },
};
</script>
```

v-show: Usa CSS display para ocultar el elemento, manteniéndolo en el DOM, lo que es útil si su visibilidad cambia frecuentemente.
```ts
<template>
  <div>
    <p v-show="isVisible">Este texto está visible.</p>
    <button @click="toggleVisibility">Toggle Visibilidad</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isVisible: true,
    };
  },
  methods: {
    toggleVisibility() {
      this.isVisible = !this.isVisible;
    },
  },
};
</script>
```

v-for: Crea dinámicamente múltiples instancias del elemento basado en los datos proporcionados, gestionando automáticamente el estado reactivo.
```ts
<template>
  <ul>
    <li v-for="(item, index) in items" :key="index">
      {{ index + 1 }}. {{ item }}
    </li>
  </ul>
</template>

<script>
export default {
  data() {
    return {
      items: ['Manzana', 'Banana', 'Cereza'],
    };
  },
};
</script>

<template>
  <div>
    <p v-for="(value, key) in user" :key="key">
      {{ key }}: {{ value }}
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        nombre: 'Juan',
        edad: 30,
        email: 'juan@example.com',
      },
    };
  },
};
</script>
```