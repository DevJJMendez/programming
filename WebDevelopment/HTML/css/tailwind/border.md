# Border
El border es el límite visible de un elemento.
Sirve para:

* Separar visualmente componentes.
* Resaltar inputs, tarjetas, botones.
* Crear jerarquía en la interfaz.
* Definir zonas de contenido.

Visualmente:
```css
[ Border ]
    [ Padding ]
        [ Content ]
```

Tailwind trabaja el border con utilidades pequeñas y específicas:

| Categoría      | ¿Qué hace?                               | Ejemplo                                    |
| -------------- | ---------------------------------------- | ------------------------------------------ |
| Activar border | Agrega un borde delgado (1px)            | `border`                                   |
| Color          | Define el color del borde                | border-gray-300                            |
| Grosor         | Cambia el grosor del borde               | border-2, border-4                         |
| Lados          | específicos	Aplica borde solo en un lado | border-t, border-b, border-l, border-r     |
| Estilo         | Cambia el tipo de línea                  | border-dashed, border-dotted, border-solid |
| Radio          | Bordes redondeados (curva)               | rounded, rounded-md, rounded-lg            |

1. Activar el border
```html
<div class="border">
  Contenedor con borde básico
</div>
```
Por defecto:
* `1p`
* `solid`
* Color gris claro (`border-gray-200`).

2. Cambiar el grosor del borde -> Tailwind tiene varias opciones:

| Clase    | ¿Qué hace? |
| -------- | ---------- |
| border   | 1px        |
| border-2 | 2px        |
| border-4 | 4px        |
| border-8 | 8px        |
```html
<div class="border-4 border-blue-500">
  Borde azul grueso (4px)
</div>
```

3. Borde en lados específicos -> Puedes aplicar bordes en un solo lado:

| Clase    | Lado afectado |
| -------- | ------------- |
| border-t | Top           |
| border-b | Bottom        |
| border-l | Left          |
| border-r | Right         |

```html
<div class="border-t-2 border-blue-600">
  Solo borde superior, 2px azul
</div>
```

4. Estilos de borde (línea) -> Tailwind soporta cambiar el tipo de línea:

| Clase         | Estilo                   |
| ------------- | ------------------------ |
| border-solid  | Línea continua (default) |
| border-dashed | Línea discontinua        |
| border-dotted | Línea punteada           |
| border-none   | Sin borde                |

```html
<div class="border-2 border-dashed border-gray-400">
  Borde gris discontínuo
</div>
```

5. Bordes redondeados (Border Radius) -> Redondear bordes es muy usado en botones, tarjetas, inputs, etc.

| Clase                                | ¿Qué hace?                       |
| ------------------------------------ | -------------------------------- |
| rounded-none                         | Sin redondeado                   |
| rounded-sm                           | Redondeo pequeño                 |
| rounded                              | Redondeo base                    |
| rounded-md                           | Redondeo medio                   |
| rounded-lg                           | Redondeo grande                  |
| rounded-xl, rounded-2xl, rounded-3xl | Redondeos grandes                |
| rounded-full                         | Borde 100% redondeado (círculos) |

## Buenas prácticas
* Utiliza bordes sutiles para separar contenido, no para "cargar" visualmente.

* No combines muchos colores fuertes de borde. -> (Ejemplo: no pongas border-red-600 en un contenedor normal).

* Redondea solo cuando tiene sentido semántico.
  * Botones = redondeados
  * Tarjetas = ligeramente redondeadas
  * Layouts grandes = cuadrados normalmente.

* No abuses de border-dashed o border-dotted, a menos que sea un elemento decorativo o muy específico (como un proceso en un flujo).

* Siempre define bien el grosor del borde cuando quieras diferenciar importancia.
  * (Ej: border-2 para elementos principales, border básico para contenedores secundarios).