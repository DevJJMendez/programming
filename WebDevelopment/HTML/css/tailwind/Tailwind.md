# Tailwind
TailwindCSS es un framework CSS de utilidad primero (utility-first CSS framework).
En vez de escribir reglas CSS tradicionales como .btn { padding: 1rem; background-color: blue; }, Tailwind te da clases ya listas que aplican esos estilos directamente en tu HTML, por ejemplo:

```html
<button class="p-4 bg-blue-500">Click me</button>
```
**Cada clase equivale a una pequeña regla CSS.**

## ¿Para qué sirve TailwindCSS?
* Diseñar interfaces web de forma rápida, consistente y escalable.
* Acelerar el desarrollo frontend al no tener que salir del HTML para diseñar.
* Hacer responsive design rápidamente (tiene utilidades móviles integradas).
* Prototipar y productizar una interfaz sin fricciones.

## ¿Qué problema resuelve?
Tailwind soluciona varios problemas clásicos del frontend:

| Problema clásico          | Cómo Tailwind ayuda                                                             |
| ------------------------- | ------------------------------------------------------------------------------- |
| CSS espagueti             | No escribes reglas personalizadas sueltas. Usas clases atómicas.                |
| Inconsistencia de diseño  | Usa un sistema de diseño (spacing, colores, tamaños predefinidos).              |
| Iterar UI es lento        | Cambias clases directamente en el HTML sin buscar en archivos CSS.              |
| CSS que crece sin control | Tailwind usa PurgeCSS para eliminar clases no usadas y mantener el CSS liviano. |
| Responsivo tedioso        | Tailwind tiene breakpoints mobile-first ya integrados (sm:, md:, lg:, etc.).    |

## ¿Cómo lo resuelve?
Tailwind te ofrece:

* Clases de utilidad pequeñas que haces "componer" para construir cualquier UI.
* Sistema de configuración (`tailwind.config.js`) para personalizar tu propio sistema de diseño.
* Plugins para extender funcionalidades (forms, typography, animations, etc.).
* **Purge** automático en producción para optimizar tu CSS final.

Un botón clásico hecho a mano:
```css
.btn {
  padding: 1rem;
  background-color: #3b82f6;
  color: white;
  border-radius: 0.5rem;
  font-weight: 600;
}
```
Con Tailwind, sería:
```html
<button class="px-4 py-2 bg-blue-500 text-white rounded-lg font-semibold">
  Click me
</button>
```

# `tailwind.config.js`
Es el archivo de configuración principal de Tailwind.
Aquí es donde defines:

* El sistema de diseño de tu proyecto.
* Los colores, tamaños, breakpoints personalizados.
* Las extensiones y plugins que Tailwind debe usar.
* Qué archivos analizar para eliminar clases no usadas (PurgeCSS).

**En resumen: *Tailwind trabaja para ti solo si lo configuras de acuerdo a TU proyecto*.**

## Estructura
```js
// tailwind.config.js
module.exports = {
  content: [],
  theme: {
    extend: {},
  },
  plugins: [],
}
```

| Sección | ¿Qué hace?                                                                                        | Ejemplo práctico                               |
| ------- | ------------------------------------------------------------------------------------------------- | ---------------------------------------------- |
| content | Define los archivos donde Tailwind buscará clases usadas.                                         | `"./src/**/*.html", "./src/**/*.jsx"`          |
| theme   | Define el sistema de diseño (colores, tipografías, tamaños).                                      | **colors, spacing, screens, fontFamily, etc.** |
| extend  | Permite agregar o sobrescribir el sistema de diseño sin perder las clases originales de Tailwind. | `extend: { colors: { primary: '#1E40AF' } }`   |
| plugins | Agrega nuevas utilidades o comportamientos extra usando plugins oficiales o personalizados.       | `require('@tailwindcss/forms')`                |

Ejemplo:
```js
// tailwind.config.js
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",  // analiza todos los archivos JS/TS/React
  ],
  theme: {
    screens: {   // Breakpoints responsivos
      sm: "640px",
      md: "768px",
      lg: "1024px",
      xl: "1280px",
    },
    extend: {
      colors: {   // Colores personalizados
        primary: "#1D4ED8",   // azul
        secondary: "#9333EA", // morado
        danger: "#DC2626",    // rojo
      },
      fontFamily: {   // Familias tipográficas
        sans: ["Inter", "sans-serif"],
        title: ["Poppins", "sans-serif"],
      },
      spacing: {  // Espaciamiento personalizado
        '72': '18rem',
        '84': '21rem',
        '96': '24rem',
      },
      borderRadius: { // Border radius personalizado
        'xl': '1rem',
        '2xl': '2rem',
      },
      zIndex: {  // Z-index personalizados
        '60': '60',
        '70': '70',
      },
    },
  },
  plugins: [
    require('@tailwindcss/forms'),  // Plugin para estilizar formularios
    require('@tailwindcss/typography'), // Plugin para contenido tipo blog
  ],
}
```

* **`Content` es crítico**:
  * Si no pones bien las rutas en content, Tailwind no generará las clases que necesitas en producción.
  * Es la parte que activa el PurgeCSS interno.

* **`Theme` vs `Extend`**:
  * theme: defines TODO desde cero (más avanzado y más riesgoso).
  * extend: agrega cambios SIN romper Tailwind default (recomendado el 90% de las veces).

* **`Screens` son breakpoints**:
  * Tailwind es mobile-first.
  * Empiezas con el estilo base, y luego sobreescribes con sm:, md:, lg:, xl:, etc.

* **Plugins oficiales y personalizados**:
  * Tailwind tiene plugins para forms, typography, aspect-ratio, line-clamp, etc.
  * También puedes escribir tus propios plugins para reglas específicas de tu proyecto.

* **Puedes personalizar TODO**:
  * Paleta de colores.
  * Espaciados.
  * Fonts.
  * Sombras.
  * Opacidades.
  * Bordes.

---
[](UtilityClasses.md)
[](flexbox.md)
[](grid.md)