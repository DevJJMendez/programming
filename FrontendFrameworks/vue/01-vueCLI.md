# Instalación
**Instalación global:**
```bash
npm install -g @vue/cli
```

**Verificar instalación:**
```bash
vue --version
```

**Instalación de una versión específica:** Si necesitas instalar una versión específica de la CLI de Vue, puedes hacerlo especificando la versión al ejecutar el comando de instalación.
```bash
npm install -g @vue/cli@4.5.13
```

# VUE CLI
Vue CLI (Command Line Interface) es una herramienta oficial para inicializar, desarrollar, y construir proyectos basados en Vue.js. Está diseñada para ofrecer una experiencia optimizada al configurar proyectos Vue sin necesidad de preocuparte por configuraciones complicadas de Webpack u otros empaquetadores.

Vue CLI es modular, extensible y compatible con complementos, lo que permite personalizar proyectos de forma sencilla.

## ¿Para qué sirve Vue CLI?
Vue CLI simplifica el ciclo de vida del desarrollo de aplicaciones Vue.js:

* **Inicializar Proyectos**: Crear nuevos proyectos con configuraciones predefinidas o personalizadas.

* **Configurar Herramientas de Desarrollo**: Configurar herramientas como **`Babel`**, **`ESLint`**, **`TypeScript`**, **`PWA`**, **`Vuex`**, **`Vue Router`**, y más.

* **Construcción para Producción**: Crear versiones optimizadas del proyecto listas para ser desplegadas.

* **Soporte Modular**: Extender proyectos mediante plugins oficiales o personalizados.

* **Servidor de Desarrollo**: Proporcionar un servidor local para desarrollo con **Hot Module Replacement (HMR)**.

## ¿Qué resuelve Vue CLI?
* **Configuración Inicial Compleja**: Configurar manualmente un proyecto con **`Webpack`**, **`Babel`**, **`ESLint`**, etc., puede ser tedioso. Vue CLI automatiza estas configuraciones.

* **Modularidad**: Permite agregar características mediante plugins, eliminando la necesidad de configuraciones desde cero.

* **Desempeño en Producción**: Genera archivos optimizados con técnicas avanzadas como **`tree-shaking`**, minificación y división de código.

* **Flexibilidad**: Proporciona configuraciones predeterminadas que pueden ser personalizadas a través de un archivo de configuración (`vue.config.js`).

* **Experiencia del Desarrollador**: Incluye herramientas integradas como un servidor de desarrollo rápido, HMR, y soporte para depuración.

## ¿Cómo lo resuelve?
1. Generador de Proyectos: Un asistente interactivo te guía en la creación de proyectos, seleccionando las características necesarias.
```bash
vue create my-project
```

2. **Configuración Avanzada**: Puedes usar configuraciones predeterminadas o personalizar completamente el proyecto.

3. **Sistema de Plugins**: Plugins oficiales para herramientas como Babel, TypeScript, PWA, etc., y soporte para plugins de terceros.
```bash
vue add router
vue add vuex
```

4. **`CLI Service`**: Ofrece comandos para desarrollo, pruebas y construcción
```bash
npm run serve   # Ejecuta el servidor de desarrollo
npm run build   # Construye el proyecto para producción
npm run lint    # Revisa el código con linters configurados
```

5. **Hot Module Replacement (HMR)**: Actualiza los cambios en el navegador sin recargar la página

# Plugins
Plugins como Vue Router, Vuex o TypeScript se pueden agregar fácilmente:

**Router (Vue Router)**
```bash
vue add router
```

**CSS Pre-processors**: Para agregar un preprocesador de CSS (Sass, Less o Stylus) a tu proyecto, ejecuta el siguiente comando y selecciona el preprocesador deseado cuando se te solicite:
```bash
vue add style-resources-loader
```

**Linter / Formatter:** Para agregar un linter y un formateador de código a tu proyecto, puedes ejecutar los siguientes comandos para instalar ESLint y Prettier, y luego configurarlos:
```bash
vue add @vue/cli-plugin-eslint
vue add @vue/cli-plugin-eslint
```

**Unit Testing:** Para agregar soporte para pruebas unitarias en tu proyecto, ejecuta el siguiente comando:
```bash
vue add @vue/cli-plugin-unit-jest
```

* **E2E Testing:** Para agregar soporte para pruebas E2E en tu proyecto, ejecuta el siguiente comando:
```bash
vue add @vue/cli-plugin-e2e-cypress
```

# Herramientas para Producción
Vue CLI incluye herramientas avanzadas como:

* **`Tree Shaking`**: Elimina código no utilizado.

* **Minificación**: Reduce el tamaño de los archivos.

* **División de Código**: Divide el código en múltiples archivos para mejorar el rendimiento.