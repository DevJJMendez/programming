# Grid Container
El Grid Container es un concepto central en CSS Grid que convierte cualquier elemento en un contenedor de cuadrícula, al aplicar **`display: grid`** o **`display: inline-grid`**. Esto transforma los elementos hijos de ese contenedor en **Grid Items** que se pueden organizar y manipular dentro de una cuadrícula definida.

## ¿Qué es el Grid Container?
El Grid Container es el contenedor padre que contiene los elementos que deseas organizar en una cuadrícula. Una vez que a un elemento se le aplica `display: grid`, se convierte en un **Grid Container**, y todos sus hijos directos se convierten en [**Grid Items**](GridItems.md). Este contenedor permite definir tanto la estructura de filas como de columnas en la cuadrícula, la separación entre ellas, y cómo se distribuyen y alinean los elementos dentro de cada área de la cuadrícula.

![grid container](/assets/gridContainer.jpg)

## ¿Para qué sirve el Grid Container?
El Grid Container sirve para establecer y controlar la estructura de la cuadrícula. Con él, puedes definir:

* El número y tamaño de filas y columnas.

* La forma en que los elementos se distribuyen y alinean en cada espacio.

* El espacio entre las filas y columnas.

* Cómo los elementos se adaptan o cambian de posición en diferentes tamaños de pantalla.

Básicamente, el Grid Container es la base para crear layouts complejos y responsivos, manejando todos los elementos internos de forma lógica y organizada.

## ¿Qué problema resuelve el Grid Container?
El Grid Container resuelve problemas que antes requerían soluciones complejas, como:

* Organizar elementos en filas y columnas, especialmente en layouts no simétricos.

* Crear distribuciones responsivas sin necesidad de contenedores adicionales o medias clases CSS.

* Definir diferentes alineaciones y distribuciones dentro de un solo contenedor.

* Separar o espaciar elementos de manera uniforme sin depender de márgenes en cada elemento.

## ¿Cómo lo resuelve el Grid Container?
El Grid Container permite una gran flexibilidad al definir la estructura de la cuadrícula mediante propiedades específicas que configuran el número de filas y columnas, la alineación, y la distribución de los elementos. Algunas de las propiedades clave que actúan directamente en el Grid Container son:

* [**`grid-template-columns`**](/grid/GridTemplateColumns.md) y [**`grid-template-rows`**](/grid/GridTemplateRows.md): Para definir las columnas y filas.

* **`gap`** o **`grid-gap`**: Para establecer espacio entre filas y columnas.

* **`justify-items`** y **`align-items`**: Para alinear los elementos dentro de cada celda de la cuadrícula.

* **`justify-content`** y **`align-content`**: Para alinear el conjunto de la cuadrícula dentro del contenedor.

* **`grid-auto-flow`**: Para controlar el flujo automático de los elementos.