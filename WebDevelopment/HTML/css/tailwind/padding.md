# Padding
Padding = Espacio interno entre el borde de un elemento y su contenido.

* Margen (margin): separa el elemento de otros elementos.
* Padding: separa el contenido del borde de su propio contenedor.

Visualmente:
```css
[ Border ]
    [ Padding ]
        [ Content ]
```

En Tailwind usas clases utilitarias para aplicar padding rápidamente, controlando qué lados y cuánto espacio:

| Clase base | Significado                                           |
| ---------- | ----------------------------------------------------- |
| p          | Padding en todos los lados (top, right, bottom, left) |
| pt         | Padding top                                           |
| pr         | Padding right                                         |
| pb         | Padding bottom                                        |
| pl         | Padding left                                          |
| px         | Padding en ejes X (izquierda + derecha)               |
| py         | Padding en ejes Y (arriba + abajo)                    |

Valores:

| Clase | Valor en rem | Valor en px (base 16px) |
| ----- | ------------ | ----------------------- |
| p-0   | 0rem         | 0px                     |
| p-1   | 0.25rem      | 4px                     |
| p-2   | 0.5rem       | 8px                     |
| p-3   | 0.75rem      | 12px                    |
| p-4   | 1rem         | 16px                    |
| p-5   | 1.25rem      | 20px                    |
| p-6   | 1.5rem       | 24px                    |
| p-8   | 2rem         | 32px                    |
| p-10  | 2.5rem       | 40px                    |
| p-12  | 3rem         | 48px                    |

## Ejemplos prácticos
```html
<!-- 1. Padding en todos los lados -->
<div class="p-4 bg-gray-100">
  Contenido con padding de 1rem (16px) en todos los lados
</div>

<!-- 2. Padding solo arriba -->
<div class="pt-8 bg-gray-200">
  Contenido con padding arriba de 2rem (32px)
</div>

<!-- 3. Padding solo en los ejes X -->
<div class="px-6 bg-gray-300">
  Padding horizontal de 1.5rem (24px) a ambos lados
</div>

<!-- 4. Combinando padding diferente en cada lado -->
<div class="pt-4 pr-2 pb-8 pl-6 bg-gray-400">
  Padding top, right, bottom, left todos distintos
</div>
```

## Responsive Padding
En Tailwind todo es mobile-first.
Puedes cambiar el padding en diferentes breakpoints:

```html
<div class="p-2 md:p-6 lg:p-10 bg-gray-100">
  <!--
    Mobile: padding 8px
    Tablet (>=768px): padding 24px
    Desktop (>=1024px): padding 40px
  -->
  Padding responsivo
</div>
```

## Buenas prácticas para padding
* Usa la escala estándar de Tailwind siempre que puedas: No inventes valores "raros" como `p-[13px]` a menos que sea absolutamente necesario.

* Prefiere px o py para layouts flexibles: Cuando trabajes con diseño de botones, cards, modales, etc.

* Controla el padding por contexto:
  * Ejemplo:
    * Botones → py-2 px-4
    * Tarjetas → p-6
    * Secciones grandes → py-12

* No uses padding para alinear cosas entre elementos externos: Usa margin para separación externa, padding solo para espacio interno.

* Organiza padding de forma predecible en componentes: Consistencia = mejor mantenimiento.

* En componentes complejos, prioriza limpieza: Si ves muchos `pt-`, `pl-`, `pr-`, `pb-`, mejor usa `p-` o `px-`/`py-` para simplificar.