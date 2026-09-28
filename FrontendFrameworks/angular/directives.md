# Directivas
Las directivas en Angular son instrucciones que puedes aplicar a elementos del DOM para cambiar su apariencia o comportamiento. Son una de las características fundamentales de Angular y te permiten manipular el DOM de manera declarativa.

Las directivas son un conjunto de instrucciones que extienden el comportamiento de los elementos del DOM. Permiten agregar, modificar o eliminar elementos del DOM, o alterar su comportamiento.

## Tipos de Directivas
En Angular, existen tres tipos principales de directivas:

1. **Directivas de Atributo**: Cambian la apariencia o comportamiento de un elemento, componente o directiva existente.

2. **Directivas Estructurales**: Cambian la estructura del DOM agregando o removiendo elementos del DOM.

3. **Directivas de Componente**: Estas son básicamente componentes de Angular, que son directivas con una plantilla asociada.

## 1. Directivas de Atributo
Las directivas de atributo modifican el comportamiento o la apariencia de un elemento del DOM. Son similares a los atributos de HTML, pero pueden contener lógica más compleja.

* `ngClass`: Aplica o quita clases CSS a un elemento basado en una condición.

```html
<div [ngClass]="{ 'activo': esActivo, 'inactivo': !esActivo }">Contenido</div>
```

* `ngStyle`: Aplica estilos CSS de forma dinámica.

```html
<div [ngStyle]="{ 'color': color, 'font-size': tamaño + 'px' }">Texto Estilizado</div>
```

## Creación de una directiva de atributo personalizada
Puedes crear directivas de atributo personalizadas para encapsular y reutilizar la lógica de manipulación del DOM.

**Ejemplo**: Supongamos que quieres crear una directiva que cambie el color de fondo de un elemento cuando el usuario pase el ratón sobre él.

1. **Genera la directiva**
```bash
ng generate directive Highlight
```

2. Implementa la lógica
```ts
import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})

export class HighlightDirective {
  @Input() defaultColor: string = '';
  @Input('appHighlight') highlightColor: string = '';

constructor(private el: ElementRef) {}

@HostListener('mouseenter') onMouseEnter() {
  this.highlight(this.highlightColor || this.defaultColor || 'yellow');
}

@HostListener('mouseleave') onMouseLeave() {
  this.highlight('');
}

private highlight(color: string) {
  this.el.nativeElement.style.backgroundColor = color;
}
}
```

3. **Uso en la plantilla**

```html
<p [appHighlight]="'lightblue'" [defaultColor]="'gray'">Pasa el ratón sobre mí</p>
```

## Directivas Estructurales
Las directivas estructurales alteran la estructura del DOM, añadiendo o eliminando elementos. Estas directivas siempre usan el prefijo * en la plantilla.

**Ejemplo**
* `*ngIf`: Se utiliza para condicionalmente agregar o quitar elementos del DOM en función de una expresión booleana.

```ts
import { Component, OnInit } from "@angular/core";
@Component({
  selector: "app-person",
  templateUrl: "./person.component.html",
  styleUrls: ["./person.component.css"],
})
export class PersonComponent {
  showNavbar: boolean = false;
}
```

```html
<nav *ngIf="showNavbar; else dontShowNavbar"></nav>
<ng-template #dontShowNavbar>
  <div>
    <span>Navbar is not avaible</span>
  </div>
</ng-template>
```

* `*ngFor`: Se utiliza para iterar sobre una colección y generar elementos del DOM para cada elemento de la colección.

```ts
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-person",
  templateUrl: "./person.component.html",
  styleUrls: ["./person.component.css"],
})
   
export class PersonComponent {
   navbarTitle: string = "Salud Colombia";
   showNavbar: boolean = true;
   usersList: string[] = ["John", "Carla", "Luca", "Pedro"];
 }
```

```html
<div class="container-fluid">
  <ul class="list-group">
    <li *ngFor="let users of usersList" class="list-group-item">
      {{users}}
    </li>
  </ul>
</div>
```

* **let user**: En este caso, let se utiliza para declarar una variable local llamada user que será utilizada dentro del bloque del bucle. Cada iteración del bucle asignará el valor del elemento actual del array a esta variable.

    * **of**: Es una palabra clave que indica la fuente de los datos sobre los cuales se está iterando. En este caso, **usersList** es el array que contiene los datos sobre los cuales se realizará la iteración.

* `*ngSwitch`: Se utiliza para realizar una selección condicional basada en el valor de una expresión.
```ts
// En el archivo del componente TypeScript
import { Component } from "@angular/core";

@Component({
  selector: "app-ejemplo-ngswitch",
  template: `
    <div [ngSwitch]="condicion">
      <div *ngSwitchCase="'caso1'">Contenido para caso1</div>
      <div *ngSwitchCase="'caso2'">Contenido para caso2</div>
      <div *ngSwitchDefault>Contenido por defecto</div>
    </div>
  `,
})
export class EjemploNgSwitchComponent {
  condicion: string = "caso1";
}
```

## Directivas de Atributos

- `ngClass`: Permite aplicar o quitar clases de CSS en función de expresiones condicionales.
```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-ejemplo-ngclass",
  template: `
    <div [ngClass]="{ clase1: condicion1, clase2: condicion2 }">
      Elemento con clases condicionales
    </div>
  `,
})
export class EjemploNgClassComponent {
  condicion1: boolean = true;
  condicion2: boolean = false;
}
```

* `ngStyle`: Permite aplicar o quitar estilos en función de expresiones condicionales.
```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-ejemplo-ngstyle",
  template: `
    <div [ngStyle]="{ color: color, 'font-size': fontSize }">
      Elemento con estilos condicionales
    </div>
  `,
})
export class EjemploNgStyleComponent {
  color: string = "blue";
  fontSize: string = "20px";
}
```

* `ngModel`: Proporciona vinculación bidireccional para elementos de formulario, permitiendo la sincronización entre el modelo del componente y el valor del formulario.
```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-ejemplo-ngmodel",
  template: `
    <input [(ngModel)]="nombre" />
    <p>Hola, {{ nombre }}!</p>
  `,
})
export class EjemploNgModelComponent {
  nombre: string = "";
}
```