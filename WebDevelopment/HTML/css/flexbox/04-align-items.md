# `align-items`
La propiedad align-items es una propiedad de CSS Flexbox que se utiliza para alinear los elementos hijos a lo largo del eje transversal (el eje perpendicular al eje principal) dentro de un contenedor flexible. El eje transversal es vertical si el eje principal es horizontal (por defecto) y horizontal si el eje principal es vertical.

## ¿Qué es align-items?
align-items es una propiedad de alineación en CSS utilizada para controlar la alineación de los elementos hijos dentro de un contenedor flex en el eje transversal. Cuando se utiliza Flexbox, los elementos flexibles se colocan en un contenedor con la propiedad display: flex, y align-items permite ajustar cómo se distribuyen y alinean los elementos hijos dentro de este contenedor.

## ¿Para qué sirve align-items?
La propiedad align-items permite a los diseñadores y desarrolladores web controlar la alineación vertical (cuando el eje principal es horizontal) o la alineación horizontal (cuando el eje principal es vertical) de los elementos dentro de un contenedor de tipo Flex. Es útil cuando se quiere tener un control preciso sobre la alineación de los elementos dentro del contenedor y no solo alinear los elementos al principio o al final.

## ¿Qué resuelve align-items?
La propiedad align-items resuelve varios problemas de alineación y distribución de los elementos dentro de un contenedor flex:

* Alineación precisa: Sin la propiedad align-items, los elementos hijos de un contenedor flex se alinean de acuerdo con el comportamiento predeterminado de flexbox, pero align-items te permite alinear estos elementos de manera específica según tus necesidades.

* Control sobre la distribución vertical u horizontal: Cuando tienes varios elementos en un contenedor, puedes usar align-items para asegurarte de que se alineen correctamente a lo largo del eje transversal, ya sea vertical u horizontalmente.

* Alineación de elementos con diferentes tamaños: Si los elementos hijos tienen diferentes tamaños, align-items permite decidir cómo deben alinearse estos elementos para que se vean consistentes en el contenedor.

## ¿Cómo lo resuelve?
La propiedad align-items toma los siguientes valores:

**Valores de align-items**
![align items](images/alignItems.png)

1. **`stretch` (valor por defecto)**:

   * Descripción: Los elementos se estiran para llenar el contenedor en el eje transversal. Esto hará que los elementos ocupen toda la altura (si el eje principal es horizontal) o todo el ancho (si el eje principal es vertical) del contenedor.

   * ¿Qué resuelve?: Si no se especifica un tamaño fijo para los elementos hijos, stretch asegura que los elementos ocupen todo el espacio disponible en el eje transversal.

```css
.container {
    display: flex;
    align-items: stretch;
}
```

2. **`flex-start`**:

   * Descripción: Alinea los elementos hijos al principio del contenedor (en el inicio del eje transversal). Si el eje principal es horizontal, los elementos se alinean en la parte superior del contenedor. Si el eje principal es vertical, se alinean a la izquierda.

   * ¿Qué resuelve?: Asegura que todos los elementos se alineen en el inicio del eje transversal, lo que es útil cuando se desea que todos los elementos empiecen desde el borde superior (o izquierdo) del contenedor.

```css
.container {
    display: flex;
    align-items: flex-start;
}
```

3. **`flex-end`**:

   * Descripción: Alinea los elementos hijos al final del contenedor (en el final del eje transversal). Si el eje principal es horizontal, los elementos se alinean en la parte inferior del contenedor. Si el eje principal es vertical, se alinean a la derecha.

   * ¿Qué resuelve?: Permite que los elementos se alineen al final del contenedor, útil cuando se desea que los elementos estén alineados en la parte inferior (o derecha) del contenedor.

```css
.container {
    display: flex;
    align-items: flex-end;
}
```

4. **`center`**:

   * Descripción: Alinea los elementos hijos en el centro del contenedor, a lo largo del eje transversal. Si el eje principal es horizontal, los elementos se centran verticalmente en el contenedor. Si el eje principal es vertical, se centran horizontalmente.

   * ¿Qué resuelve?: Asegura que los elementos se distribuyan equitativamente en el centro del contenedor, tanto en el eje vertical como horizontal.

```css
.container {
    display: flex;
    align-items: center;
}
```

5. **`baseline`**:

   * Descripción: Alinea los elementos hijos en función de sus líneas base de texto. Esto significa que los elementos se alinearán con respecto a la línea base del texto de su contenido. Si un elemento no tiene contenido textual, se alinea con el siguiente elemento que tenga texto.

   * ¿Qué resuelve?: Es útil cuando tienes una mezcla de elementos con texto (por ejemplo, imágenes y párrafos), y deseas que el texto de todos los elementos esté alineado en la misma línea base.

```css
.container {
    display: flex;
    align-items: baseline;
}
```