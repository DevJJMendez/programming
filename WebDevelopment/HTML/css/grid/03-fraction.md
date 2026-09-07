# `fraction`
La unidad fr (abreviatura de "fraction" o "fracción") en CSS Grid Layout representa una fracción del espacio disponible en un contenedor de cuadrícula. Es una unidad relativa diseñada específicamente para distribuir el espacio libre entre columnas o filas de manera flexible.

## ¿Qué es fr?
La unidad fr es una medida flexible que distribuye el espacio disponible dentro de un contenedor de cuadrícula (grid container). Cada fr representa una fracción de este espacio, por lo que su tamaño depende del espacio total y del número de fracciones que se definan.

Por ejemplo, en el código grid-template-columns: 1fr 2fr;, la primera columna ocupará una fracción del espacio disponible, mientras que la segunda columna ocupará dos fracciones. Esto hace que la segunda columna sea el doble de ancha que la primera.

## ¿Para qué sirve?
fr permite crear layouts flexibles y adaptables, ya que distribuye automáticamente el espacio entre los elementos de la cuadrícula. Esto hace que sea ideal para crear interfaces responsivas y adaptadas al contenedor, ya que el tamaño de las filas y columnas con unidades fr se ajustará según el espacio disponible.

## ¿Qué problemas resuelve?
Antes de fr, crear columnas y filas flexibles solía requerir técnicas complejas o la combinación de unidades relativas como porcentajes o flexibles como auto. Esto era difícil de manejar en layouts de cuadrícula y podía hacer que la distribución de espacio resultara en elementos no alineados o inconsistentes en su tamaño. La unidad fr simplifica este proceso al asignar el espacio automáticamente de manera proporcional.

## ¿Cómo lo resuelve?
CSS Grid resuelve el problema de distribución proporcional mediante fr, que asigna el espacio libre en el contenedor después de definir cualquier tamaño fijo. Esto significa que puedes mezclar unidades de fr con tamaños fijos (como px, %, o auto), y CSS Grid adaptará automáticamente el tamaño de cada fracción fr para llenar el espacio restante.

## Ejemplos de uso
* **Uso básico**
```css
.grid-container {
    display: grid;
    grid-template-columns: 1fr 2fr; /* Primera columna = 1 fracción, Segunda columna = 2 fracciones */
}
```
**En este caso:**
* Primera columna: Ocupa 1 fracción del espacio disponible.

* Segunda columna: Ocupa 2 fracciones, es decir, el doble del espacio de la primera columna.


* **Combinación con tamaños fijos**
```css
.grid-container {
    display: grid;
    grid-template-columns: 200px 1fr 2fr;
}
```
**Aquí:**
* La primera columna tiene un tamaño fijo de 200 píxeles.

* La segunda y tercera columna usan fr y se dividen el espacio restante (1 fracción y 2 fracciones, respectivamente).

* Distribución igualitaria de columnas
```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(3, 1fr); /* Tres columnas de igual tamaño */
}
```
En este caso, repeat(3, 1fr) crea tres columnas que se dividen el espacio restante de manera igualitaria. Esto es especialmente útil para layouts donde necesitas que varias columnas tengan el mismo tamaño.

## Ejemplo de uso avanzado con auto y fr
La combinación de auto y fr permite crear layouts donde algunos elementos se ajustan automáticamente a su contenido, mientras que otros ocupan el espacio restante:

```css
.grid-container {
    display: grid;
    grid-template-columns: auto 1fr 1fr;
}
```
Aquí:
* La primera columna se ajusta automáticamente al tamaño de su contenido (auto).

* La segunda y tercera columnas dividen el espacio restante en partes iguales (1fr cada una).

## Uso responsivo con fr y minmax()
La función minmax() combinada con fr permite establecer un tamaño mínimo y máximo para cada columna o fila, lo cual es ideal para layouts responsivos.

```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
}
```
En este código:
* Cada columna tendrá un mínimo de 150 píxeles y, si hay espacio disponible, crecerá hasta ocupar una fracción (1fr) del espacio libre.

* La función auto-fill ajusta automáticamente el número de columnas según el tamaño del contenedor, haciendo que el layout sea adaptable a diferentes tamaños de pantalla.

## Buenas prácticas al usar fr
* Usa fr para layouts flexibles y adaptables: Esta unidad es ideal cuando necesitas dividir el espacio de manera proporcional y no quieres especificar tamaños fijos para cada columna o fila.

* Combina fr con auto y tamaños fijos para layouts complejos: Esto permite que ciertos elementos se ajusten a su contenido, mientras que otros ocupan el espacio restante proporcionalmente.

* Usa minmax() junto a fr para layouts responsivos: Esta combinación asegura que tus columnas o filas tengan un tamaño mínimo para evitar que se vuelvan demasiado pequeñas en pantallas pequeñas.

* Evita usar fr si necesitas tamaños específicos: Si algún elemento requiere un tamaño exacto, es mejor usar píxeles (px), porcentaje (%) o unidades absolutas.