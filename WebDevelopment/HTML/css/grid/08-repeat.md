# `repeat()`
La función repeat() permite especificar un número de repeticiones de una unidad de medida (como px, %, fr, etc.) para crear filas o columnas con patrones repetidos dentro de una cuadrícula. Su estructura básica es:

```css
repeat(<numero de repeticiones>, <valor>)
```
Ejemplo básico:
```css
grid-template-columns: repeat(3, 100px);
```
Este ejemplo crea tres columnas de 100 píxeles cada una, es decir, el equivalente a 100px 100px 100px.

## ¿Para qué sirve?
repeat() es especialmente útil cuando:

* Queremos simplificar el código: En lugar de escribir cada unidad individualmente, puedes definirla una vez y repetirla.

* Definir layouts dinámicos: Combina repeat() con la unidad fr o auto para un diseño más flexible y adaptable.

* Mejorar la legibilidad del código CSS: Ayuda a reducir la redundancia y hacer que el diseño sea más fácil de leer y mantener.

## ¿Qué problemas resuelve?
Antes de repeat(), era necesario especificar cada fila o columna individualmente. Esto hacía que el código se volviera extenso y difícil de gestionar en layouts grandes. repeat() reduce esta redundancia y hace que el diseño de la cuadrícula sea más fácil de modificar y escalar.

## ¿Cómo lo resuelve?
CSS Grid resuelve este problema de repetición con repeat() al permitir que el diseñador especifique solo una vez el patrón deseado y el número de repeticiones. Esto reduce el riesgo de errores en los patrones de diseño y facilita la personalización y mantenimiento del código.

## Ejemplos de uso
* **Repetición fija**
```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(4, 100px); /* Crea 4 columnas de 100px */
    grid-template-rows: repeat(3, 50px);     /* Crea 3 filas de 50px */
}
```
Este código crea una cuadrícula de 4 columnas y 3 filas, con columnas de 100 píxeles y filas de 50 píxeles.

* **Repetición flexible usando `fr`**, La unidad fr permite dividir el espacio restante en partes proporcionales:
```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(3, 1fr); /* 3 columnas de igual tamaño */
}
```
Aquí, cada columna ocupará una parte igual del espacio disponible.

## Combinación de repeat() con valores no repetidos
Puedes combinar repeat() con otros valores para un layout más flexible:

```css
.grid-container {
    display: grid;
    grid-template-columns: 200px repeat(2, 1fr) 100px;
}
```
**En este caso:**

* La cuadrícula comienza con una columna fija de 200 píxeles.

* Luego, tiene dos columnas que ocupan una fracción del espacio disponible (1fr cada una).

* Finalmente, una columna fija de 100 píxeles.

## Uso avanzado con auto-fill y auto-fit
* **`auto-fill`**: Llena el contenedor de cuadrícula con tantas columnas como sea posible, aunque estén vacías.

* **`auto-fit`**: Similar a auto-fill, pero hace que las columnas se ajusten al contenido si no hay suficiente contenido para llenar el espacio.

```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(100px, 1fr));
}
```
Este código ajusta el número de columnas en función del ancho del contenedor:

* Cada columna tiene un ancho mínimo de 100 píxeles y crece hasta ocupar una fracción (1fr) si hay espacio adicional.

* Esto permite que la cuadrícula sea responsive.