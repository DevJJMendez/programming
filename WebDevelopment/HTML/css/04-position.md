# Position
La propiedad position en CSS define el método de posicionamiento de un elemento en la página, controlando su relación con otros elementos y con su contenedor principal. En función del valor que le asignemos, position permite ubicar el elemento de distintas maneras, y controlar cómo interactúa con el flujo de la página y con el espacio que ocupa.

## ¿Para qué sirve position?
position permite manejar la ubicación y el flujo de los elementos en una página, tanto en relación con su contenedor como en relación con otros elementos. Esta propiedad es fundamental cuando necesitas elementos en posiciones específicas (como barras de navegación, botones flotantes, o ventanas modales) que no necesariamente siguen el flujo normal de la página. Controla aspectos como si un elemento debe estar siempre visible al hacer scroll o si debe mantenerse dentro de ciertos límites del documento.

## ¿Qué resuelve position?
* Ubicación precisa de elementos: Controla la posición exacta de un elemento en la página.

* Control de solapamiento de elementos: Permite colocar un elemento sobre otros elementos usando las coordenadas y la propiedad z-index.

* Elementos "fijos" en pantalla: Puede hacer que un elemento se mantenga visible cuando se hace scroll, como las cabeceras fijas.

* Posicionamiento dinámico relativo al viewport o a otros elementos: Resuelve necesidades de ubicaciones específicas en la pantalla, como menús que se despliegan en un lugar exacto.

## ¿Cómo lo resuelve?
position ofrece cinco valores principales que funcionan de manera diferente para resolver estas necesidades:

### Valores de position y cómo funcionan
1. **`static` (valor predeterminado)**

   * **Descripción**: Coloca el elemento en su posición natural dentro del flujo de la página. No admite ajustes de posición con `top`, `right`, `bottom` o `left`.

   * **¿Para qué sirve?**: Ideal cuando el elemento no requiere posicionamiento especial, simplemente sigue el flujo normal de la página.

   * **Ejemplo**
```css
.elemento {
  position: static; /* Este es el valor por defecto */
}
```

2. **`relative`**

   * **Descripción**: El elemento se coloca en su posición normal dentro del flujo de la página, pero se puede ajustar usando `top`, `right`, `bottom` o `left`. El espacio original del elemento se conserva, por lo que otros elementos no se reubican.

   * **¿Para qué sirve?**: Es útil para mover ligeramente un elemento sin afectar el flujo de los demás.

   * Ejemplo:
```css
.elemento {
  position: relative;
  top: 10px; /* Mueve el elemento 10px hacia abajo de su posición original */
  left: 5px; /* Mueve el elemento 5px hacia la derecha */
}
```

3. **`absolute`**


   * **Descripción**: El elemento se posiciona de manera absoluta en relación a su contenedor posicionado más cercano (relative, absolute, fixed o sticky). Si no encuentra un contenedor posicionado, se ubica en relación al body.

   * ¿Para qué sirve?: Para sacar un elemento del flujo y ubicarlo en una posición exacta sin afectar el flujo de otros elementos.

   * Ejemplo
```css
.contenedor {
  position: relative; /* Contenedor posicionado */
}

.elemento {
  position: absolute;
  top: 20px; /* Mueve el elemento a 20px del borde superior del contenedor */
  right: 10px; /* Mueve el elemento a 10px del borde derecho */
}
```

4. **`fixed`**

   * **Descripción**: El elemento se posiciona de manera fija en relación con la ventana gráfica del navegador, por lo que no se desplaza al hacer scroll. Admite ajustes con top, right, bottom y left.

   * ¿Para qué sirve?: Ideal para crear elementos que siempre están visibles, como barras de navegación fijas o botones de acción flotantes.

   * Ejemplo
```css
.elemento {
  position: fixed;
  top: 0; /* Fija el elemento en la parte superior de la ventana */
  right: 0; /* Fija el elemento al borde derecho */
}
```

5. **`sticky`**

   * **Descripción**: Combina las propiedades de relative y fixed. El elemento se comporta como relative mientras esté en su contenedor y cambia a fixed cuando el usuario hace scroll hasta que alcanza el valor especificado en top, right, bottom o left.

   * ¿Para qué sirve?: Útil para crear cabeceras o menús que se mantengan visibles al hacer scroll dentro de una sección.

   * Ejemplo
```css
.elemento {
  position: sticky;
  top: 0; /* Se pega al borde superior cuando se hace scroll hasta su posición */
}
```

## Mejores Prácticas con position
* Usa relative cuando el cambio de posición sea menor: Esto permite pequeños ajustes sin afectar el flujo global de la página.

* Usa absolute y fixed con moderación: Si bien permiten un control preciso, pueden hacer que el layout sea menos responsivo si no se utilizan de manera adecuada.

* Aprovecha sticky para navegación interna: Es ideal para mantener visible un elemento en el scroll dentro de una sección.

* No mezcles absolute con static: Si deseas que un elemento absolute se ubique en relación a su contenedor, asegúrate de que el contenedor tenga position diferente a static (como relative).