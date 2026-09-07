# Flexbox
Flexbox es un modelo de diseño de CSS que permite distribuir el espacio de manera eficiente entre los elementos de un contenedor, incluso cuando el tamaño de esos elementos es desconocido o dinámico.

A través de Flexbox, puedes crear diseños más complejos y flexibles de manera más sencilla y menos propensa a errores en comparación con otros métodos tradicionales de maquetación como los floats o las tablas.

## ¿Para qué sirve Flexbox?
Flexbox sirve para crear layouts que sean flexibles y resilientes ante diferentes tamaños de pantalla, especialmente en el contexto de diseño web responsivo. Con Flexbox, puedes:

* Alinear elementos de manera más fácil en ambas direcciones (vertical y horizontal).

* Distribuir el espacio entre los elementos de manera eficiente.

* Controlar la alineación y el espacio de los elementos de manera que se adapten a distintas resoluciones sin tener que usar márgenes o calcule manualmente el espacio disponible.

## ¿Qué resuelve Flexbox?
Flexbox resuelve muchos de los problemas que enfrentaban los diseñadores web en el pasado, tales como:

* Alineación de elementos: Antes de Flexbox, alinear elementos tanto horizontal como verticalmente podía ser muy complicado y requería trucos con márgenes, position, float, o incluso tablas.

* Distribución del espacio: Con Flexbox puedes distribuir el espacio entre los elementos de forma automática, lo que ayuda a evitar cálculos complejos.

* Layouts adaptativos: Flexbox es una excelente opción para diseños que necesitan ser flexibles en cuanto a sus tamaños de columna y fila, y que deben adaptarse a diferentes dispositivos de manera sencilla.

* Orden de los elementos: Permite cambiar el orden visual de los elementos sin modificar el HTML.

## ¿Cómo lo resuelve?
Flexbox resuelve estos problemas proporcionando un contenedor flexible en el cual los elementos dentro de él (llamados flex items) se pueden alinear y distribuir de manera eficiente a través de una serie de propiedades.

## Principales conceptos y propiedades de Flexbox
### Contenedor Flex (Flex Container)
Primero, debes definir un contenedor flexible usando la propiedad `display: flex;`. Esto transforma el contenedor en un "**flex container**", y todos los elementos dentro de él se convierten en "**flex items**".

```css
.container {
  display: flex;
}
```
**Propiedades del contenedor Flex**
1. **`flex-direction`** Controla la dirección de los flex items dentro del contenedor. Sus valores son:

   * `row` (por defecto): Los items se colocan en fila (de izquierda a derecha).

   * `row-reverse`: Los items se colocan en fila, pero al revés (de derecha a izquierda).

   * `column`: Los items se colocan en columna (de arriba a abajo).

   * `column-reverse`: Los items se colocan en columna, pero al revés (de abajo hacia arriba).

2. **`justify-content`** Define cómo se distribuye el espacio libre entre los items a lo largo del eje principal (eje **`X`** por defecto).

   * `flex-start` (por defecto): Los elementos se alinean al principio.

   * `flex-end`: Los elementos se alinean al final.

   * `center`: Los elementos se centran.

   * `space-between`: Espacio igual entre los elementos, sin espacio al principio o al final.

   * `space-around`: Espacio igual entre los elementos, con espacio extra al principio y al final.

   * `space-evenly`: Espacio igual entre los elementos, incluyendo los bordes del contenedor.

```css
.container {
  justify-content: center; /* Centra los items a lo largo del eje X */
}
```

3. **`align-items`** Alinea los items a lo largo del eje transversal (eje **`Y`** por defecto).

   * `flex-start`: Los elementos se alinean al principio.

   * `flex-end`: Los elementos se alinean al final.

   * `center`: Los elementos se centran.

   * `baseline`: Los elementos se alinean por su línea base.

   * `stretch` (por defecto): Los elementos se estiran para ocupar el espacio disponible.

```css
.container {
  align-items: center; /* Centra los items a lo largo del eje Y */
}
```

4. **`align-content`** Esta propiedad se usa cuando hay varias filas de flex items (es decir, si el contenedor tiene un alto que hace que los items se envuelvan). Controla cómo se distribuye el espacio entre las filas.

   * `flex-start`, `flex-end`, `center`, `space-between`, `space-around`, `stretch`.

```cs
.container {
  align-content: space-between;
}
```

5. **`flex-wrap`** Define si los items deben ajustarse en varias líneas cuando no caben en una sola línea (el comportamiento por defecto es nowrap, es decir, los items no se envuelven).

   * `nowrap` (por defecto): Los items no se envuelven.

   * `wrap`: Los items se envuelven cuando no hay suficiente espacio.

   * `wrap-reverse`: Los items se envuelven, pero en el orden inverso.

```cs
.container {
  flex-wrap: wrap;
}
```

### Propiedades de los Items Flex (Flex Items)
1. **`flex-grow`** Define cuánto debe crecer un item en relación con los otros items dentro del contenedor. Si un item tiene un `flex-grow` mayor que los demás, ocupará más espacio.

   * El valor por defecto es 0 (no crece).

   * Un valor mayor indica que el item debe crecer más para llenar el espacio disponible.

```css
.item {
  flex-grow: 1; /* El item crecerá para ocupar el espacio disponible */
}
```

2. **`flex-shrink`** Define cuánto debe encogerse un item cuando hay menos espacio disponible. Si todos los items tienen el mismo valor de `flex-shrink`, se reducirán proporcionalmente.

   * El valor por defecto es 1 (el item puede encogerse).

```css
.item {
  flex-shrink: 1; /* El item se reducirá si es necesario */
}
```

3. **`flex-basis`** Define el tamaño inicial de un item antes de que se aplique el `flex-grow` o `flex-shrink`. Puede ser un valor en píxeles, porcentaje o auto (por defecto).

   * auto: El tamaño inicial del item es el tamaño de su contenido.

   * Un valor fijo como 100px, 20%, etc.

```css
.item {
  flex-basis: 200px; /* El item tendrá un tamaño inicial de 200px */
}
```

4. **`flex`** Una propiedad abreviada que combina `flex-grow`, `flex-shrink` y `flex-basis`. El valor por defecto es `0 1 auto`, lo que significa que el item no crecerá ni se reducirá a menos que se le indique explícitamente.

```css
.item {
  flex: 1; /* El item ocupará todo el espacio disponible */
}
```

5. **`align-self`** Permite sobrescribir la alineación de un solo item sobre la alineación general del contenedor (`align-items`). Los valores posibles son los mismos que los de `align-items: flex-start`, `flex-end`, `center`, `baseline`, `stretch`.

```css
.item {
  align-self: flex-start; /* Alinea este item al principio */
}
```