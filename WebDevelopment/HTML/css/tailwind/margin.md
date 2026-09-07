# Margin
Así como el padding maneja el espacio interno, el margin en Tailwind maneja el espacio externo entre elementos.

**Entender bien margin es clave para que tus interfaces respiren y sean visualmente ordenadas.**

Margin = Espacio externo que un elemento deja hacia fuera, separándose de otros elementos.

Visualmente:
```css
[ Margin ][ Border ][ Padding ][ Content ][ Padding ][ Border ][ Margin ]
```
Resumen:
* Margin: espacio fuera del borde (separación entre elementos).
* Padding: espacio dentro del borde (separación entre contenido y borde).

Tailwind usa utilidades muy similares al padding, solo cambiando la `m`:

| Clase base | Significado                            |
| ---------- | -------------------------------------- |
| m          | Margin en todos los lados              |
| mt         | Margin en top (arriba)                 |
| mr         | Margin en right (derecha)              |
| mb         | Margin en bottom (abajo)               |
| ml         | Margin en left (izquierda)             |
| mx         | Margin en ejes X (izquierda + derecha) |
| my         | Margin en ejes Y (arriba + abajo)      |

Valores:

| Clase | Valor en rem | Valor en px |
| ----- | ------------ | ----------- |
| m-0   | 0rem         | 0px         |
| m-1   | 0.25rem      | 4px         |
| m-2   | 0.5rem       | 8px         |
| m-4   | 1rem         | 16px        |
| m-8   | 2rem         | 32px        |

Tailwind también permite márgenes negativos:

| Clase | ¿Qué hace?                   |
| ----- | ---------------------------- |
| -m-2  | Margin negativo de -0.5rem   |
| -mt-4 | Margin-top negativo de -1rem |

Sirven para:
* Superponer elementos.
* Ajustes finos de layout.
* Corregir desplazamientos.

**Pero ojo: usar márgenes negativos requiere justificación. No es algo que pongas a la ligera.**

Margin automático (auto) -> Tailwind permite margin auto para centrar elementos:
```html
<div class="mx-auto w-64 bg-blue-200">
  Centrado horizontalmente
</div>
```
* mx-auto: margin left/right automáticos ➔ se centra horizontalmente en su contenedor.

* Usos típicos:
  * Centrar imágenes.
  * Centrar botones.
  * Centrar contenedores pequeños.
## Buenas prácticas para usar margin
* Usa margin para separación externa, nunca para "empujar" contenido interno.

* Utiliza my- o mx- para layouts consistentes.
  * Ejemplo: separación vertical entre cards = my-6.

* Prefiere la escala de Tailwind.
  * Usa arbitrarios m-[13px] solo cuando sea realmente necesario.

* Negative margin solo cuando necesitas overlaps o ajustes de precisión.

* Ordena las clases:
  * Coloca spacing (m-, p-) primero en el orden de clases para mantener tu HTML limpio.

* Reutiliza patrones de margin.
  * Ejemplo: todos los títulos mb-4, todos los párrafos mb-6.