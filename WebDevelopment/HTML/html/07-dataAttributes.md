# Data Attributes
Los data attributes en HTML son atributos personalizados que permiten almacenar datos adicionales en los elementos HTML sin afectar su semántica ni su estructura visual. Son muy útiles cuando se necesita información extra para manipulaciones con JavaScript, sin que esta sea visible en el contenido de la página.

## ¿Qué es un data attribute?
Un data attribute es un atributo especial de HTML que permite almacenar datos personalizados en cualquier elemento HTML. Cada data attribute comienza con el prefijo data- seguido de un nombre que describe el contenido del atributo. El valor de este atributo se define directamente en el HTML, lo que permite asociar datos con elementos sin agregar clases o identificadores específicos solo para este propósito.

Ejemplo básico:
```html
<div data-id="123" data-role="admin">Contenido del usuario</div>
```
En el ejemplo, data-id y data-role son data attributes que almacenan información extra que puede ser utilizada, por ejemplo, en JavaScript.

## ¿Para qué sirve un data attribute?
Los data attributes se utilizan principalmente para almacenar información de forma no intrusiva que luego puede ser accedida mediante JavaScript. Esto es útil en situaciones como:

* Almacenar el estado o detalles de un elemento (como ID, rol, o cualquier otra propiedad).

* Manejar interacciones del usuario (como datos que cambian según el clic en un botón o secciones que se deben ocultar/mostrar).

* Gestionar configuraciones específicas de un elemento sin afectar su estructura.

## ¿Qué problemas resuelve?
Los data attributes resuelven varias necesidades y problemas de los desarrolladores:

* Almacenamiento de datos personalizado sin modificar la estructura: Permiten añadir información a los elementos sin cambiar su apariencia o semántica.

* Evitar clases o ID innecesarios: En lugar de usar clases para almacenar valores de datos (lo que puede ser confuso), los data attributes permiten mantener una estructura clara.

* Fácil manipulación con JavaScript: Los data attributes son accesibles desde JavaScript mediante métodos estándar, lo que permite una interacción sencilla entre el HTML y la lógica de frontend.

* Separación de datos y contenido: Los data attributes ayudan a mantener la estructura de datos separada de los datos visuales, haciendo el código más limpio y manteniendo la semántica.

## ¿Cómo resuelven estos problemas?
Los data attributes, al ser compatibles con el HTML estándar, permiten que los desarrolladores:

* Agreguen datos directamente en el HTML de manera limpia, permitiendo que el código sea fácil de leer y de modificar.

* Accedan a los datos rápidamente con JavaScript, usando propiedades específicas como dataset, lo que facilita la manipulación en el DOM.

* No interrumpan la semántica ni el diseño de la página. Al estar enfocados solo en datos, no influyen en el estilo o funcionalidad visual del elemento.

## ¿Cómo utilizar data attributes?
Para definir un data attribute, el nombre debe empezar con `data-` seguido de un nombre específico que describa el dato. Ejemplo:
```html
<!-- HTML con data attributes -->
<button data-product-id="456" data-price="39.99">Comprar</button>
```

## Acceder a data attributes en JavaScript
Para manipular estos atributos con JavaScript, utilizamos la propiedad dataset, que contiene todos los data attributes de un elemento:
```js
// Seleccionar el botón en el DOM
const boton = document.querySelector('button');

// Acceder a los data attributes
const productId = boton.dataset.productId; // "456"
const price = boton.dataset.price; // "39.99"

// Modificar un data attribute
boton.dataset.price = "29.99"; // Cambia el precio en el DOM
```
Al usar dataset, el nombre del data attribute se convierte en una propiedad de JavaScript en notación camelCase. Por ejemplo, data-product-id en HTML se accede como dataset.productId.

### Ejemplo completo
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ejemplo de Data Attributes</title>
  <script>
    document.addEventListener("DOMContentLoaded", () => {
      const boton = document.querySelector("button");

      // Acceder a los data attributes
      const productId = boton.dataset.productId;
      const price = boton.dataset.price;

      // Mostrar los datos en consola
      console.log("ID del Producto:", productId);
      console.log("Precio:", price);

      // Cambiar el precio
      boton.dataset.price = "29.99";
      console.log("Nuevo Precio:", boton.dataset.price);
    });
  </script>
</head>
<body>

  <!-- Botón con data attributes -->
  <button data-product-id="456" data-price="39.99">Comprar</button>

</body>
</html>
```

## Buenas prácticas al usar data attributes
* Usar nombres descriptivos: Los nombres de los data attributes deben describir claramente el tipo de dato que almacenan.

* Evitar sobrecargar elementos con demasiados atributos: Aunque son útiles, agregar demasiados data attributes puede hacer el HTML confuso. Mantén solo los necesarios.

* No almacenar datos sensibles: Los data attributes son visibles en el HTML y accesibles desde el navegador, por lo que no deben usarse para almacenar datos sensibles o privados.