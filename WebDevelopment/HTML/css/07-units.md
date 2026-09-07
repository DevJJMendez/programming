# Unidades de Medida
Las unidades de medida en CSS son valores que permiten definir el tamaño, espaciado y posición de los elementos en una página web. Con ellas se controla el ancho, alto, márgenes, padding, fuentes y otros aspectos del diseño, garantizando que la apariencia de la interfaz se adapte de manera óptima a diferentes dispositivos y resoluciones.

## ¿Qué son las unidades de medida en CSS?
Son valores que se utilizan en CSS para especificar dimensiones de elementos. Se aplican a propiedades como width, height, margin, padding, font-size, y más, para controlar el tamaño y disposición de los componentes de una página.

## ¿Cuáles son las unidades de medida en CSS?
Las unidades en CSS se dividen en absolutas y relativas:

1. **Unidades Absolutas**, Estas unidades tienen un tamaño fijo y no cambian según el contexto.
Ejemplos:

* px (píxeles): Unidad más común, equivalente a un píxel en la pantalla.

* cm (centímetros): Basada en la medida real.

* mm (milímetros): Una milésima parte de un metro.

* in (pulgadas): Equivale a 2.54 cm.

* pt (puntos): Equivalente a 1/72 de pulgada, común en impresión.

* pc (picas): Unidad tipográfica (1 pica = 12 puntos).

2. **Unidades Relativas**, Se basan en el tamaño de otros elementos o en el contexto, lo que las hace más flexibles.
Ejemplos:

* **`%`** (porcentaje): Basada en el tamaño del elemento padre.

* **`em`**: Basada en el tamaño de fuente del elemento padre; 1em equivale al tamaño actual de la fuente.

* rem (root em): Basada en el tamaño de fuente del elemento raíz (`<html>`), permitiendo escalabilidad consistente.

* vw (viewport width): 1% del ancho del área visible.

* vh (viewport height): 1% de la altura del área visible.

* vmin y vmax: Basadas en el valor menor o mayor entre vw y vh.

* ch: Basada en el ancho del carácter "0" del elemento, útil para tamaños de texto.

* ex: Basada en la altura de la "x" minúscula, rara vez usada en diseño moderno.

## Buenas Prácticas con Unidades en CSS
* Usar rem para fuentes y px solo para detalles fijos: rem permite escalabilidad, mientras que px es más preciso, ideal para márgenes o bordes pequeños.

* Diseños adaptables con unidades de viewport: Emplear vw y vh en layouts completos para adaptarse a diferentes pantallas.

* Combinar unidades: Usar porcentajes para ancho y rem o em para padding, generando un diseño flexible pero escalable.

* Evitar exceso de px: Usar px en tamaños muy precisos, pero no para layout completo, ya que no responde bien a diferentes resoluciones.

* Usar variables CSS para valores comunes: Facilita la modificación de tamaños desde un solo lugar.
```css
:root {
  --base-font-size: 1rem;
  --padding-main: 2rem;
}

body {
  font-size: var(--base-font-size);
}

.container {
  padding: var(--padding-main);
}
```