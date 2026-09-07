# clases utilitarias
Son clases CSS atómicas que aplican una sola responsabilidad visual.
Cada clase es una acción pequeña (un padding, un margen, un color, una alineación...).

**Por ejemplo:**

| Clase       | ¿Qué hace?                          |
| ----------- | ----------------------------------- |
| p-4         | Padding de 1 rem en todos los lados |
| text-center | Centra el texto                     |
| bg-blue-500 | Fondo azul intermedio               |
| rounded-lg  | Bordes redondeados grandes          |
| flex        | Activa display: flex                |

* No combinas reglas como en Bootstrap (btn, btn-primary, etc.). -> Compones comportamientos básicos para construir cualquier cosa.

## Categorías principales de clases utilitarias


| Categoría                 | Ejemplos comunes                                           | Qué resuelven                                   |
| ------------------------- | ---------------------------------------------------------- | ----------------------------------------------- |
| Spacing (margen, padding) | m-4, p-2, px-6, py-8                                       | Separaciones internas y externas                |
| Typography                | text-xl, font-bold, leading-tight, tracking-wide           | Tamaño de letra, grosor, interlineado, tracking |
| Colors                    | bg-red-500, text-gray-700, border-blue-300                 | Colores de fondo, texto y borde                 |
| Layout                    | flex, grid, block, inline-flex, hidden                     | Control del flujo y tipo de display             |
| Flexbox/Grid helpers      | justify-center, items-start, grid-cols-3, gap-6            | Distribución de elementos                       |
| Sizing                    | w-1/2, h-64, max-w-sm, min-h-screen                        | Control de tamaños                              |
| Borders                   | border, border-2, border-gray-300, rounded-full            | Bordes y redondeados                            |
| Effects                   | shadow-lg, hover:shadow-2xl, opacity-50                    | Sombras, opacidad, efectos visuales             |
| Transitions/Animations    | transition, duration-300, ease-in-out                      | Animaciones suaves entre estados                |
| Transforms                | scale-105, rotate-12, translate-x-4                        | Transformaciones 2D                             |
| Positioning               | relative, absolute, top-0, left-4                          | Posiciones relativas y absolutas                |
| Pseudo-classes            | hover:bg-blue-600, focus:outline-none, disabled:opacity-50 | Estados especiales                              |

---
[](padding.md)
[](margin.md)
[](border.md)
[](gap.md)
[](radius.md)