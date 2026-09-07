# Variables
Las variables en CSS permiten definir valores reutilizables y centralizados que pueden aplicarse en diferentes partes de un archivo CSS. Esto facilita la consistencia en el diseño, ya que una variable se puede definir una vez y usar en múltiples lugares, y con un solo cambio en la variable, todos los lugares donde se usa también cambian.

## ¿Qué son las variables en CSS?
Las variables en CSS, también conocidas como Custom Properties, son valores definidos por el usuario que pueden almacenar colores, tamaños, tipografías y otros valores de estilo. Estos valores se declaran usando una sintaxis especial de doble guion (`--nombre-de-variable`).

Ejemplo básico:
```css
:root {
  --color-primario: #3498db;
  --margen-general: 20px;
}

.container {
  background-color: var(--color-primario);
  margin: var(--margen-general);
}
```

## ¿Para qué sirven las variables en CSS?
Sirven para:

* Mantener consistencia: Al definir colores, márgenes, tamaños de fuentes, etc., en una variable, se asegura un estilo consistente en toda la página.

* Facilitar el mantenimiento: Permiten hacer cambios de estilo en un solo lugar (donde se define la variable) en lugar de buscar y modificar cada instancia.

* Mejorar la organización y legibilidad del código: Las variables pueden documentar mejor la intención de un valor, lo que facilita la comprensión del código.

## ¿Qué problemas resuelven las variables en CSS?
* Dificultad de mantenimiento: Antes de las variables, si un color o tamaño se usaba en varias partes de un archivo CSS, cambiarlo implicaba modificar cada lugar donde aparecía. Esto hacía que los archivos CSS fueran difíciles de mantener.

* Consistencia de diseño: Garantizan que los estilos sean homogéneos en todas las páginas de un proyecto.

* Optimización en temas y personalización: Facilitan la implementación de múltiples temas (como modos oscuro y claro), ya que permiten cambiar valores de forma dinámica.

## ¿Cómo resuelven estos problemas?
* Centralización: Al definir las variables en un solo lugar (comúnmente dentro del selector `:root`), es posible cambiar un estilo globalmente sin editar varias partes del archivo.

* Declaración global y reutilización: Los valores pueden reutilizarse en varios selectores, lo que facilita temas como la accesibilidad y el diseño adaptativo.

* Modificación dinámica: Las variables se pueden actualizar con JavaScript para adaptarse a la interacción del usuario, como el cambio entre modo oscuro y claro.

## Cómo Usar Variables en CSS
1. **Declarar Variables**, Las variables se suelen declarar en el selector `:root` para que estén disponibles globalmente en todo el archivo CSS.
```css
:root {
  --color-fondo: #ffffff;
  --color-texto: #333333;
  --padding-base: 1rem;
}
```

2. **Usar Variables**, Para utilizar una variable, se usa la función `var()`, pasando el nombre de la variable como parámetro.
```css
body {
  background-color: var(--color-fondo);
  color: var(--color-texto);
  padding: var(--padding-base);
}
```

3. **Asignar Valores por Defecto**, Dentro de la función `var()`, también se puede definir un valor por defecto que se usará si la variable no está definida.
```css
button {
  background-color: var(--color-boton, #007bff); /* Usa #007bff si --color-boton no está definido */
}
```

4. Modificar Variables con JavaScript, Podemos cambiar valores de las variables en tiempo real usando JavaScript, lo cual es útil para agregar temas de usuario.
```js
document.documentElement.style.setProperty('--color-fondo', '#333333');
```

## Buenas Prácticas al Usar Variables en CSS
* Usar un prefijo común para variables: Es común usar el prefijo -- en variables para evitar confusiones con nombres de propiedades CSS estándar.

* Declarar variables en :root: Para variables globales, usa :root, asegurando que estén disponibles en todo el documento.

* Usar nombres descriptivos: Nombres como --color-primario, --font-size-base, o --padding-horizontal ayudan a que otros desarrolladores comprendan su propósito.

* Separar variables por categorías: Agrupar variables de colores, tamaños y espaciados facilita la organización.

* Evitar variables excesivamente específicas: Mantén las variables generales para que puedan ser reutilizadas en otros componentes o proyectos.