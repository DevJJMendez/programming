# `span`
La propiedad span en CSS Grid se utiliza para especificar cuántas filas o columnas debe abarcar un grid item (elemento de grid) dentro de un grid container. Es un concepto muy útil para diseñar layouts dinámicos, ya que te permite hacer que un elemento ocupe varias celdas dentro del contenedor de grid sin tener que definir coordenadas exactas para cada fila o columna.

## ¿Qué es la propiedad span?
span es un valor que se utiliza dentro de las propiedades grid-column o grid-row para indicar el número de líneas (filas o columnas) que un grid item debe ocupar. La palabra clave span le dice al navegador que el elemento debe "expandirse" o "abrazar" varias líneas del grid, ya sea en columnas o filas.

## ¿Para qué sirve span?
* Distribución flexible: Permite a los elementos de grid ocupar más de una fila o columna sin la necesidad de especificar sus posiciones exactas.

* Layouts más fáciles de manejar: Facilita el diseño de layouts más complejos sin necesidad de manejar manualmente las coordenadas de filas y columnas.

* Control de tamaño: Permite ajustar el tamaño de los grid items para que se ajusten de manera eficiente a la estructura del grid, mejorando la distribución y la accesibilidad.

## ¿Qué resuelve span?
span resuelve varios problemas comunes relacionados con el diseño de layouts en CSS Grid:

* Ajuste dinámico: Los elementos pueden ocupar más de una fila o columna, lo que permite una mayor flexibilidad en la disposición de los elementos sin necesidad de modificar completamente el diseño del grid.

* Simplicidad: Permite que un grid item abarque múltiples filas o columnas sin tener que escribir posiciones específicas para su inicio y fin.

* Reducción de código: Al usar span, puedes reducir la necesidad de especificar coordenadas de inicio y fin de filas o columnas, haciendo que tu código sea más limpio y fácil de leer.

* Ajustar tamaño sin complicación: En lugar de establecer posiciones exactas de inicio y fin, span permite que el elemento ocupe el número de celdas necesarias.

* Mayor flexibilidad en el diseño: Los elementos pueden abarcar múltiples columnas o filas sin tener que saber su posición exacta en el grid.

* Simplificación del código: Al usar span, el código es más compacto y fácil de mantener. No necesitas hacer cálculos complicados ni especificar los valores de las líneas de manera manual.

## ¿Cómo lo resuelve?
El uso de span se puede aplicar dentro de las propiedades grid-column o grid-row para indicar que un grid item debe ocupar varias columnas o filas.

### Sintaxis
* Colums
```css
grid-column: span <número>;
```
* Rows
```css
grid-row: span <número>;
```

## Ejemplo con grid-column: span:
```css
.grid-container {
  display: grid;
  grid-template-columns: 100px 200px 100px;
}

.item {
  grid-column: span 2;
}
```
**En este ejemplo:**
* El grid container tiene tres columnas de 100px, 200px y 100px respectivamente.

* El item se extiende a través de 2 columnas (de la primera columna a la segunda columna), es decir, ocupa la primera y segunda columna, abarcando 2 celdas.