# `justify-content`
La propiedad justify-content en CSS se usa para alinear los elementos dentro de un contenedor flexible, es decir, se utiliza con Flexbox y CSS Grid. En términos sencillos, controla cómo se distribuyen los elementos hijos dentro de un contenedor en relación con el eje principal, ya sea horizontal o vertical, dependiendo de la dirección de la fila o columna del contenedor.

## ¿Para qué sirve justify-content?
Su función principal es alinear los elementos dentro de un contenedor flexible (un contenedor con display: flex o display: grid), ajustando la distribución de estos elementos a lo largo del eje principal (por defecto, el eje horizontal para flex-direction: row, o el eje vertical para flex-direction: column).

Esto es útil cuando quieres tener un control más preciso sobre la distribución del espacio disponible entre los elementos dentro de un contenedor. Dependiendo de su valor, justify-content puede resolver diversos escenarios de alineación como alinear elementos al inicio, al final, centrarlos, distribuirlos de manera uniforme, entre otros.

## ¿Qué resuelve justify-content?
justify-content resuelve problemas relacionados con la distribución del espacio en el eje principal dentro de un contenedor flexible. Esto es especialmente útil cuando:

* El espacio entre los elementos debe ser ajustado o distribuido de manera uniforme.

* Los elementos deben alinearse de una manera específica dentro de su contenedor.

* Se necesita control total sobre la alineación en layouts con múltiples elementos.

**Algunos de los problemas comunes que resuelve:**

* Distribuir espacio sobrante: Cuando el contenedor tiene más espacio del que los elementos necesitan, justify-content puede distribuir ese espacio sobrante de manera que los elementos estén distribuidos uniformemente o alineados según se desee.

* Centrar elementos: A menudo se requiere centrar los elementos dentro de un contenedor sin tener que calcular márgenes manualmente.

* Alineación específica: Permite alinear los elementos al principio o al final del contenedor, según sea necesario.

## ¿Cómo lo resuelve?
justify-content lo resuelve ajustando la distribución del espacio entre los elementos a lo largo del eje principal. Dependiendo de su valor, actúa de distintas maneras:

### Valores de justify-content y sus efectos

![justify content](images/justifyContent.png)

1. **`flex-start` (valor predeterminado)**

   * Qué hace: Alinea los elementos al principio del contenedor, es decir, al inicio del eje principal.

   * Uso común: Es el comportamiento por defecto y se utiliza cuando no se necesita ninguna alineación especial.

```css
.container {
  display: flex;
  justify-content: flex-start; /* Alinea los elementos al inicio del contenedor */
}
```

2. **`flex-end`**

   * Qué hace: Alinea los elementos al final del contenedor, es decir, al final del eje principal.

   * Uso común: Usado cuando se quiere que los elementos se alineen en el extremo opuesto al valor flex-start.

```css
.container {
  display: flex;
  justify-content: flex-end; /* Alinea los elementos al final del contenedor */
}
```

3. **`center`**


   * Qué hace: Centra los elementos dentro del contenedor a lo largo del eje principal.

   * Uso común: Se usa cuando se desea distribuir el espacio sobrante de manera equitativa en ambos lados de los elementos, logrando un centrado perfecto.

```css
.container {
  display: flex;
  justify-content: center; /* Centra los elementos en el contenedor */
}
```

4. **`space-between`**

   * Qué hace: Distribuye los elementos de manera que el primer elemento esté alineado al inicio del contenedor y el último al final, con el mismo espacio entre los elementos.

   * Uso común: Ideal para cuando deseas distribuir los elementos uniformemente, pero sin dejar espacio extra al principio o al final.

```css
.container {
  display: flex;
  justify-content: space-between; /* Distribuye los elementos con espacio entre ellos */
}
```

5. **`space-around`**

   * Qué hace: Distribuye los elementos de manera que haya un espacio igual entre los elementos, pero también un espacio igual antes del primer elemento y después del último.

   * Uso común: Se usa cuando se necesita que los elementos tengan un espacio uniforme, pero también un espacio extra antes y después de ellos.

```css
.container {
  display: flex;
  justify-content: space-around; /* Distribuye los elementos con espacio alrededor */
}
```

6. **`space-evenly`**

   * Qué hace: Distribuye los elementos de manera que el espacio entre cada par de elementos sea igual, incluyendo el espacio antes del primer elemento y después del último.

   * Uso común: Ideal para una distribución muy equilibrada y uniforme de los elementos.

```css
.container {
  display: flex;
  justify-content: space-evenly; /* Distribuye los elementos con espacio igual entre todos */
}
```