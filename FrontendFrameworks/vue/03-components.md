# Componentes
Un componente en Vue es una unidad reutilizable que encapsula lógica, estructura y estilo. Se representa como un archivo `.vue` que sigue la arquitectura de **Single File Components (SFC)**, donde cada parte del componente se define en una sección separada (`<template>`, `<script>` y `<style>`).

## Estructura Básica de un Componente en Vue
```ts
<template>
  <div class="example-component">
    <h1>{{ title }}</h1>
    <button @click="handleClick">Click me</button>
  </div>
</template>

<script>
export default {
  name: "ExampleComponent", // Nombre del componente
  props: {
    title: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      count: 0, // Estado local
    };
  },
  methods: {
    handleClick() {
      this.count++;
      console.log(`Button clicked! Count: ${this.count}`);
    },
  },
};
</script>

<style scoped>
.example-component {
  font-family: Arial, sans-serif;
}

button {
  background-color: #42b983;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
}

button:hover {
  background-color: #2c8c6b;
}
</style>
```
## `<template>`
* Aquí defines el HTML del componente.

* Todo el código debe estar envuelto en un único nodo raíz.

* Puedes usar expresiones como `{{ variable }}` para interpolación de datos.

## `<script>`
Contiene la lógica del componente. Aquí defines:
  * `name`: El nombre del componente.

  * `props`: Recibe datos desde el componente padre.

  * `data`: Declara variables reactivas locales.

  * `methods`: Define funciones del componente.

  * **Ciclo de vida**: Métodos como `mounted`, `created`, etc.

```ts
<script>
export default {
  name: "ExampleComponent",
  props: {
    title: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    handleClick() {
      this.count++;
    },
  },
};
</script>
```

## `<style>`
  * Define los estilos del componente.

  * Puedes usar la etiqueta scoped para limitar los estilos al componente actual.

  * También puedes usar preprocesadores como SCSS o Less.

## Buenas Prácticas para Componentes
* **Divide y vencerás**: Mantén los componentes pequeños y especializados en una sola tarea.

* **Usa nombres descriptivos**: Usa nombres consistentes como `UserCard.vue`, `ProductList.vue`, etc.

* **Estilos limitados al componente**: Usa `scoped` para evitar conflictos de estilos globales.

* **Organiza los directorios**: Agrupa los componentes reutilizables en carpetas como `components/common/`.

* **`Prop Types` y Validaciones**: Define tipos y validaciones para las `props`:
```ts
props: {
  title: {
    type: String,
    required: true,
  },
},
```