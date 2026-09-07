# `align-content`
La propiedad align-content es una propiedad de CSS Flexbox que se utiliza para controlar la alineación de las líneas de los elementos dentro de un contenedor flexible cuando hay varias líneas de elementos. Esta propiedad es útil cuando se está trabajando con un contenedor flex que tiene múltiples filas (en el caso de flex-wrap: wrap) o columnas (si el contenedor está en modo vertical).

A diferencia de la propiedad align-items, que alinea los elementos dentro de una única línea, align-content maneja la alineación de todo el conjunto de líneas dentro del contenedor.

## ¿Qué es align-content?
align-content es una propiedad CSS que define cómo se distribuyen las líneas de los elementos dentro de un contenedor flex en el eje transversal (el eje perpendicular al eje principal). Esto solo afecta a los contenedores flex que tienen varias líneas de elementos. Si solo tienes una línea de elementos, align-content no tendrá ningún efecto.

## ¿Para qué sirve align-content?
align-content se usa para controlar el espacio entre y alrededor de las filas (en una dirección de flex-wrap: wrap) o columnas (en una dirección de flex-direction: column) de un contenedor flex. Se utiliza cuando el contenedor tiene suficiente espacio para distribuir las filas/columnas en el eje transversal y se quiere tener un control sobre la alineación de estas filas o columnas.

## ¿Qué resuelve align-content?
* Distribución de espacio entre líneas: Si un contenedor tiene varias filas (en el caso de flex-wrap: wrap), align-content ayuda a distribuir el espacio sobrante entre estas filas de manera controlada. Esto permite que el espacio entre las filas sea flexible según tus necesidades.

* Alineación de varias líneas de contenido: Si tienes un contenedor que contiene varios elementos que se dividen en varias líneas, como un contenedor con flex-wrap: wrap, align-content resuelve el problema de alinear todas esas líneas dentro del contenedor.

* Control de la distancia entre las líneas: Esta propiedad te da control total sobre la distancia entre las filas o columnas del contenedor flex cuando hay más de una línea de elementos. Esto es útil cuando quieres distribuir el espacio de manera específica entre los elementos.

## ¿Cómo lo resuelve?
La propiedad align-content toma los siguientes valores:

**Valores de align-content**
![align content](images/alignContent.png)

1. **`flex-start`**:

   * Descripción: Alinea las filas o columnas al inicio del contenedor. Si el eje principal es horizontal, las filas se alinean al principio (parte superior) del contenedor. Si el eje principal es vertical, las filas se alinean a la izquierda.

   * ¿Qué resuelve?: Asegura que las líneas se agrupen al inicio del contenedor, sin dejar espacio al principio.

```css
.container {
    display: flex;
    flex-wrap: wrap;
    align-content: flex-start;
}
```

2. **`flex-end`**:

   * Descripción: Alinea las filas o columnas al final del contenedor. Si el eje principal es horizontal, las filas se alinean en la parte inferior del contenedor. Si el eje principal es vertical, las filas se alinean a la derecha.

   * ¿Qué resuelve?: Coloca las líneas al final del contenedor, sin dejar espacio al final.

```css
.container {
    display: flex;
    flex-wrap: wrap;
    align-content: flex-end;
}
```

3. **`center`**:

   * Descripción: Alinea las filas o columnas en el centro del contenedor, distribuyendo el espacio por igual entre las filas.

   * ¿Qué resuelve?: Centra todas las filas o columnas dentro del contenedor, dejando espacio igual en la parte superior e inferior (o izquierda y derecha si es vertical).

```css
.container {
    display: flex;
    flex-wrap: wrap;
    align-content: center;
}
```

4. **`space-between`**:

   * Descripción: Distribuye las filas o columnas con espacio igual entre ellas, pero no deja espacio antes del primer elemento ni después del último.

   * ¿Qué resuelve?: Distribuye las líneas de forma que el espacio entre las líneas sea igual, sin espacio adicional al principio ni al final.

```css
.container {
    display: flex;
    flex-wrap: wrap;
    align-content: space-between;
}
```

5. **`space-around`**:

   * Descripción: Distribuye las filas o columnas con espacio igual alrededor de ellas. Esto significa que el espacio antes del primer elemento y después del último será la mitad del espacio entre las filas.

   * ¿Qué resuelve?: Da más espacio alrededor de las filas o columnas, proporcionando una distribución visualmente más equilibrada.

```css
.container {
    display: flex;
    flex-wrap: wrap;
    align-content: space-around;
}
```

6. **`space-evenly`**:

   * Descripción: Distribuye las filas o columnas de manera que el espacio entre ellas sea igual, incluyendo el espacio antes de la primera fila y después de la última.

   * ¿Qué resuelve?: Distribuye las líneas de manera uniforme, con el mismo espacio antes de la primera fila/columna y después de la última.

```css
.container {
    display: flex;
    flex-wrap: wrap;
    align-content: space-evenly;
}
```

7. **`stretch` (valor por defecto)**:

   * Descripción: Estira las filas o columnas para llenar todo el espacio disponible a lo largo del eje transversal. Si hay espacio sobrante, las filas se expanden para ocuparlo.

   * ¿Qué resuelve?: Es útil cuando se quiere que las filas o columnas ocupen todo el espacio disponible en el contenedor.

```css
.container {
    display: flex;
    flex-wrap: wrap;
    align-content: stretch;
}
```