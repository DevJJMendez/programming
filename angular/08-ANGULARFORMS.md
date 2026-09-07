# Angular Forms
Angular Forms es un módulo en Angular que permite construir y gestionar formularios interactivos en aplicaciones web. Ofrece herramientas para manejar datos, validaciones y eventos relacionados con formularios, proporcionando una integración robusta entre el front-end y el back-end.

Angular Forms está compuesto por dos enfoques principales:

* **Template-driven Forms**: Formularios basados en plantillas HTML.

* **Reactive Forms**: Formularios basados en programación reactiva (RxJS).

## ¿Para qué sirve Angular Forms?
* Creación de formularios interactivos: Formularios simples y complejos con controles como input, select, checkbox, entre otros.

* Gestión de estados: Detectar cambios en los datos de los formularios.

* Identificar estados como válido, inválido, pristine (sin cambios) o dirty (modificado).

* Validaciones: Implementar validaciones tanto nativas (como campos obligatorios) como personalizadas.

* Sincronización de datos: Actualizar automáticamente los datos del modelo en el componente y en la vista (two-way binding).

* Envío y procesamiento de datos: Preparar y enviar datos al servidor para su almacenamiento o procesamiento.

## ¿Qué resuelve Angular Forms?
* Gestión de datos: Simplifica la manipulación y el seguimiento de datos introducidos por los usuarios.

* Validaciones robustas: Permite definir y manejar validaciones de forma declarativa o programática.

* Escalabilidad: Facilita la creación de formularios complejos y reutilizables en aplicaciones grandes.

* Sincronización bidireccional: Simplifica la actualización de datos entre el modelo y la vista.

* Mantenimiento: Ofrece una estructura clara para gestionar formularios, reduciendo la complejidad del código.

## ¿Cómo lo resuelve Angular Forms?
Componentes clave:

1. FormControl: Representa un control individual del formulario, como un campo de entrada.

2. FormGroup: Agrupa varios FormControl en una estructura lógica para manejar formularios complejos.

3. FormArray: Administra una lista de controles dinámicos (útil para listas de entradas o formularios repetitivos).

4. Directivas:

   * ngModel (para Template-driven Forms): Vincula datos del modelo a controles individuales.

   * formControlName, formGroup (para Reactive Forms): Proveen una estructura declarativa para formularios reactivos.

5. Validadores:

   * Validadores integrados como required, minLength, maxLength, etc.

   * Validadores personalizados que definen reglas específicas.
# Estados
Los estados en Angular Forms son indicadores que representan el estado actual de los controles, grupos o formularios dentro de una aplicación. Estos estados reflejan características como si el control ha sido modificado, tocado, validado, entre otros.

Los estados permiten a los desarrolladores realizar un seguimiento del estado de los formularios para gestionar su comportamiento, mostrar mensajes de validación y activar o desactivar elementos de la interfaz de usuario.

## Cuáles son los estados en Angular Forms?
En Angular Forms, un control o formulario puede tener los siguientes estados clave:

1. **Estados básicos**:
   * **`Pristine`**:
     * El control no ha sido modificado por el usuario.

     * Representa el estado inicial del control.

   * **`Dirty`**: 
      * El control ha sido modificado por el usuario.

      * Indica que el valor del control ha cambiado al menos una vez.

   * **`Untouched`**:
      * El control no ha sido tocado por el usuario.

      * Ocurre cuando el usuario aún no ha interactuado con el control.

   * **`Touched`**:
      * El control ha sido tocado por el usuario.
   
      * Indica que el control ha perdido el foco tras la interacción.

2. **Estados de validación**:
   * **`Valid`**: El control cumple con todas las reglas de validación especificadas.

   * **`Invalid`**: El control no cumple con las reglas de validación.

   * **`Pending`**: El control está evaluando las validaciones asíncronas (por ejemplo, comprobaciones de datos en un servidor).

   * **`Disabled`**: El control está deshabilitado y no participa en las validaciones ni en el envío de datos.

## ¿Para qué sirven los estados?
* Gestión de la interfaz de usuario:
  * Mostrar mensajes de error o validación según el estado del control.

  * Habilitar o deshabilitar botones según si el formulario es válido.

* Seguimiento de cambios:
  * Detectar si un usuario ha modificado un formulario para decidir si se deben guardar los cambios.

* Validación dinámica:
  * Aplicar reglas de validación y estilos CSS en tiempo real.

* Experiencia del usuario:
  * Proporcionar retroalimentación visual basada en el estado del formulario, como bordes rojos en campos inválidos.

## ¿Qué resuelven los estados?
Los estados resuelven los siguientes problemas comunes al trabajar con formularios:

* Falta de retroalimentación al usuario: Proporcionan información visual clara sobre el estado de cada campo.

* Complejidad en la validación: Facilitan la validación en tiempo real al exponer estados como valid e invalid.

* Gestión de datos sucios: Permiten determinar si un formulario ha sido modificado (dirty) para evitar envíos innecesarios de datos sin cambios.

* Validación condicional: Posibilitan activar o desactivar validaciones basándose en el estado del control.

## ¿Cómo lo resuelven?
### Interacción con los estados en código:
* **Acceder a los estados**, Puedes obtener el estado de un control, grupo o formulario utilizando propiedades como:
```ts
formControl.pristine;  // true si el control no ha sido modificado
formControl.dirty;     // true si el control ha sido modificado
formControl.touched;   // true si el control ha sido tocado
formControl.valid;     // true si el control es válido
```

### Eemplo práctico:
```html
<form [formGroup]="form">
  <label for="email">Email:</label>
  <input id="email" formControlName="email" />
  <div *ngIf="emailControl.invalid && emailControl.touched">
    El email no es válido.
  </div>
</form>
```
```ts
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-states',
  templateUrl: './form-states.component.html',
})
export class FormStatesComponent {
  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
    });
  }

  get emailControl() {
    return this.form.get('email')!;
  }
}
```
```css
input.ng-touched.ng-invalid {
  border: 1px solid red;
}
input.ng-touched.ng-valid {
  border: 1px solid green;
}
```

### Estados en validaciones dinámicas
Los estados son útiles para cambiar la lógica de validación de forma dinámica. Por ejemplo:
```ts
if (control.touched && control.invalid) {
  console.log('El control es inválido y ha sido tocado');
}
if (control.pristine) {
  console.log('El control aún no ha sido modificado');
}
```

## Buenas prácticas al usar estados
* Usa estados para retroalimentación visual: Aplica estilos CSS dinámicos según los estados (`ng-touched`, `ng-invalid`, etc.).

* Valida en tiempo real: Detecta cambios en el formulario y actúa en consecuencia.

* Evita envíos innecesarios: Asegúrate de enviar datos solo si el formulario está en un estado `dirty`.

* Desactiva elementos según estados: Deshabilita botones de envío si el formulario está `invalid` o `pristine`.