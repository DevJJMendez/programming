# `minmax()`
La función minmax() en CSS es una herramienta poderosa de CSS Grid que permite definir un rango de tamaño para filas o columnas, estableciendo un mínimo y un máximo. Esto asegura que un elemento no sea menor que el tamaño mínimo especificado, pero que pueda crecer hasta el tamaño máximo, logrando un layout más controlado y flexible.

## ¿Qué es minmax()?
minmax() es una función que se usa en las propiedades grid-template-columns y grid-template-rows. Define un rango de tamaño para una fila o columna en el cual el navegador ajustará el tamaño según el espacio disponible. La función toma dos valores: el primero es el tamaño mínimo, y el segundo es el tamaño máximo.

## ¿Para qué sirve?
minmax() permite mantener un diseño adaptable en diferentes situaciones:

* Puedes garantizar que una columna o fila nunca sea más pequeña de lo necesario para su contenido, pero que tampoco ocupe más espacio del que le corresponde.

* Proporciona flexibilidad en diseños adaptativos, asegurando que los elementos ocupen el espacio necesario sin desbordarse ni perder proporción en pantallas de distintos tamaños.

## ¿Qué problema resuelve?
Antes de minmax(), había limitaciones para controlar el tamaño de elementos en un grid. No era sencillo:

* Evitar que las columnas se volvieran demasiado pequeñas y perdieran legibilidad.

* Asegurar que las columnas o filas no crecieran demasiado y distorsionaran el layout.

minmax() resuelve este problema proporcionando control sobre los límites mínimos y máximos del tamaño de un elemento. Esto permite diseñar interfaces que se adaptan mejor a contenidos dinámicos y que se ven bien en múltiples dispositivos.

## ¿Cómo lo resuelve?
minmax() resuelve este problema ajustando dinámicamente el tamaño dentro de los límites que establezcas. Si hay suficiente espacio, el tamaño del elemento aumentará hasta el límite máximo; si no hay suficiente espacio, se mantendrá en el tamaño mínimo o en algún punto intermedio.

## Ejemplos y Usos de minmax()
* Ejemplo básico de minmax()
```css
.grid-container {
    display: grid;
    grid-template-columns: minmax(200px, 1fr) 1fr;
}
```
En este ejemplo:
  * La primera columna tiene un mínimo de 200px. Si el espacio disponible es suficiente, crecerá hasta ocupar 1 fracción (1fr) del espacio.

  * La segunda columna ocupará otra fracción del espacio restante (1fr).

Esto asegura que la primera columna nunca será más pequeña que 200px, incluso si se reduce el tamaño del viewport.

* Usando minmax() con auto y fr
```css
.grid-container {
    display: grid;
    grid-template-columns: minmax(100px, auto) 1fr;
}
```
Aquí:
  * La primera columna tiene un tamaño mínimo de 100px, pero puede crecer automáticamente (auto) para ajustarse al contenido si es necesario.

  * La segunda columna ocupa el resto del espacio disponible con 1fr.

Este patrón es útil en layouts donde deseas un tamaño mínimo, pero que el contenido controle el tamaño máximo de la columna.

* Combinación de minmax() con repeat()
```css
.grid-container {
    display: grid;
    grid-template-columns: repeat(3, minmax(150px, 1fr));
}
```
En este caso:
* Se crean tres columnas. Cada una tiene un tamaño mínimo de 150px y puede crecer hasta ocupar una fracción (1fr) del espacio.

* Esta combinación permite distribuir el espacio entre las tres columnas manteniendo un mínimo razonable.

Es ideal cuando tienes un layout con múltiples columnas que necesitan ser del mismo ancho y adaptarse automáticamente al tamaño disponible.

## Buenas prácticas al usar minmax()
* Establece el tamaño mínimo adecuado: Un mínimo demasiado pequeño puede hacer que los elementos pierdan legibilidad; un mínimo demasiado grande puede afectar la adaptabilidad en dispositivos pequeños.

* Combina minmax() con auto-fill o auto-fit: Estos valores en repeat() permiten layouts fluidos que llenan el contenedor de manera dinámica, perfecto para layouts responsivos.

* Evita establecer tamaños máximos muy grandes: Aunque minmax() ofrece flexibilidad, si el valor máximo es demasiado alto, puede afectar la distribución general del espacio en el grid.

* Usa minmax() en diseños con contenido dinámico: Esto asegura que los elementos con contenido variable puedan expandirse o contraerse de acuerdo al contenido y al espacio disponible, brindando una experiencia visual más equilibrada.