# `flex-grow`
La propiedad flex-grow en CSS es una de las propiedades clave dentro de Flexbox, que permite controlar cómo los elementos dentro de un contenedor flexible ocupan el espacio disponible en el eje principal. Es especialmente útil para crear layouts que se adapten dinámicamente a diferentes tamaños de pantalla sin la necesidad de definir medidas fijas para los elementos.

## ¿Qué es flex-grow?
flex-grow es una propiedad CSS que define la proporción en la que un elemento puede crecer en el espacio disponible dentro de un contenedor con display: flex. Este espacio disponible es el espacio sobrante en el contenedor después de acomodar todos los elementos flexibles en su tamaño mínimo.

## Valores de flex-grow
![flex grow](images/flexGrow.png)

El valor de flex-grow es un número no negativo que indica la proporción en la que un elemento debería crecer en comparación con otros elementos del contenedor. Puede tomar valores como:

* **`0`**: El elemento no crecerá para ocupar espacio extra (valor predeterminado).

* **`1`** o más: El elemento crecerá para ocupar el espacio disponible, según la proporción especificada.

Por ejemplo, si a un elemento se le asigna flex-grow: 2, y a otro flex-grow: 1, el primer elemento crecerá para ocupar el doble de espacio que el segundo.

## ¿Para qué sirve?
flex-grow permite crear layouts flexibles en los que los elementos se expanden dinámicamente según el espacio disponible. Es útil para diseños que deben ajustarse a diferentes tamaños de pantalla o contenedores, asegurando que los elementos puedan aprovechar el espacio adicional sin necesidad de ajustes específicos para cada pantalla.

## ¿Qué problema resuelve?
flex-grow resuelve el problema de la distribución de espacio sobrante en el contenedor. Sin esta propiedad, los elementos de un contenedor flexible mantienen sus tamaños base o mínimos, dejando potencialmente espacio vacío en el contenedor. flex-grow permite que los elementos utilicen este espacio vacío de manera proporcional.

## ¿Cómo lo resuelve?
La propiedad flex-grow resuelve este problema asignando una "proporción de crecimiento" a cada elemento dentro del contenedor. Si el contenedor tiene espacio adicional después de colocar todos los elementos, este espacio se distribuye entre los elementos en función de sus valores de flex-grow. Cuanto mayor sea el valor de flex-grow, mayor será el espacio que ocupe ese elemento en comparación con otros.