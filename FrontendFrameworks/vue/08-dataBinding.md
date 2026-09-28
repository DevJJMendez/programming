# Data Binding
El data binding (enlace de datos) en Vue.js es una funcionalidad que permite sincronizar los datos entre la vista (DOM) y el modelo de datos (JavaScript). Es un mecanismo reactivo que actualiza automáticamente los cambios en la interfaz de usuario cuando el estado de los datos cambia, y viceversa.

Existen dos tipos principales de data binding:
* Unidireccional: Los datos fluyen en una sola dirección (del modelo al DOM).

* Bidireccional: Los datos fluyen en ambas direcciones (del modelo al DOM y del DOM al modelo).

## ¿Para qué sirve el data binding?
El data binding se utiliza para:

* Mostrar datos dinámicos en la interfaz de usuario: Renderizar valores dinámicos provenientes de datos reactivos en el DOM.

* Mantener sincronizada la interfaz con los datos: Si cambian los datos en el modelo, la vista se actualiza automáticamente.

* Capturar datos ingresados por el usuario: En formularios o inputs, el data binding bidireccional permite sincronizar los datos ingresados por el usuario con las variables del modelo.

## ¿Qué resuelve el data binding?
Reduce el código manual para actualizar el DOM:

En lugar de escribir lógica para buscar y actualizar elementos en el DOM, Vue lo gestiona automáticamente.
Sincronización automática de datos:

Resuelve el problema de mantener sincronizados el estado del modelo y la interfaz de usuario, especialmente en aplicaciones dinámicas.
Mayor claridad y simplicidad en la lógica:

Ayuda a separar las preocupaciones entre la lógica de datos y la presentación de la UI.
Mejora la eficiencia del desarrollo:

Automatiza tareas repetitivas relacionadas con la manipulación del DOM.

## ¿Cómo lo resuelve?
Vue.js utiliza una combinación de su sistema reactivo y directivas para implementar el data binding de manera eficiente:

* Reactividad interna:
  * Vue rastrea automáticamente los cambios en los datos mediante propiedades reactivas como `ref()` o `reactive()`.
 
  * Cuando un dato cambia, Vue vuelve a renderizar los componentes afectados.

* Directivas de enlace de datos: Vue utiliza directivas declarativas como `v-bind`, `v-model`, y expresiones mustache `{{ }}` para facilitar el enlace entre datos y la vista.

* Optimización eficiente del DOM: Vue actualiza solo las partes necesarias del DOM en lugar de renderizar toda la interfaz nuevamente.

* Directivas de enlaces de datos:
  * {{ }} (Interpolación de texto o Mustache syntax): Es la forma más sencilla de enlazar datos de un modelo de Vue en el DOM. Permite insertar valores de propiedades reactivas directamente dentro del HTML.

  * v-bind: Se usa para enlazar un atributo o una propiedad de un elemento HTML con una variable del modelo de Vue.

  * v-model: Se usa para crear un enlace bidireccional entre los datos y los elementos del DOM, generalmente con formularios o campos de entrada.

  * v-on: Aunque no es directamente un enlace de datos, se usa para enlazar eventos de la interfaz con métodos de Vue, lo que permite reaccionar ante cambios de datos (por ejemplo, cuando un usuario hace clic en un botón).