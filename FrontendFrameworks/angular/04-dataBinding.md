# Data Binding
El Data Binding es una característica de Angular que conecta la lógica del componente con su plantilla HTML. Esto permite la sincronización entre los datos del componente y lo que se muestra/interactúa en la interfaz de usuario (UI).

En Angular, el Data Binding puede ser **unidireccional** (de componente a vista o de vista a componente) o **bidireccional** (sincronización en ambas direcciones).

## ¿Para qué sirve?
* Actualizar automáticamente la UI: Reflejar los cambios en los datos del componente directamente en la vista.

* Capturar datos del usuario: Enviar las interacciones del usuario en la UI al componente.

* Mantener la consistencia: Sincronizar datos entre la vista y el componente sin necesidad de manipular directamente el DOM.

* Desacoplar lógica y presentación: Separar la lógica de negocio (en el componente) de la interfaz gráfica.

## ¿Qué problemas resuelve?
* Manipulación manual del DOM: Evita la necesidad de usar APIs nativas o librerías externas (como jQuery) para actualizar la interfaz.

* Inconsistencias en datos: Sincroniza automáticamente los datos entre el componente y la vista, evitando errores de estado desactualizado.

* Código repetitivo: Simplifica la gestión de eventos y actualizaciones de UI con un enfoque declarativo.

## ¿Cómo lo resuelve?
Angular utiliza diferentes formas de Data Binding para conectar los datos entre el componente y la plantilla. Estas son:
1. [Interpolación](04.0-interpolation.md)

2. [Property Binding](04.1-propertyBinding.md)

3. [Two-Way Binding](04.2-twoWayBinding.md)

4. [Event Binding](04.3-eventBinding.md)

##  Buenas prácticas
1. Usa la forma adecuada de Data Binding según el caso:
   * **Interpolación** para mostrar valores simples.

   * **`Property Binding`** para atributos y propiedades dinámicas.

   * **`Event Binding`** para capturar eventos.

   * **`Two-Way Binding`** para formularios o entradas bidireccionales.

2. **Mantén la lógica en el componente**: Evita incluir lógica compleja en las plantillas.

3. **Optimiza el rendimiento**: Angular detecta cambios con `zone.js` y `Change Detection`, por lo que minimiza las operaciones que puedan disparar cambios innecesarios.

3. **Prefiere `ngModel` para formularios simples**: En aplicaciones complejas, considera formularios reactivos para mayor flexibilidad.