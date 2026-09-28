# Scope
El **scope** en Angular se refiere al alcance o contexto en el que los componentes, servicios, y otras entidades de Angular existen y son accesibles.

Aunque el término scope fue un concepto clave en AngularJS, en Angular moderno (Angular 2+), se implementa mediante otras mecánicas como la inyección de dependencias, encapsulación de módulos y componentes, y contextos de plantillas.

El scope en Angular puede dividirse en varios niveles, como el scope de aplicación, módulo, componente, y servicio. Cada uno tiene un alcance específico en términos de dónde y cómo pueden ser utilizados los objetos definidos dentro de ellos.

## ¿Qué es el Scope en Angular?
El scope en Angular se refiere al alcance o visibilidad de las variables, servicios, directivas y otros elementos dentro de una aplicación Angular. Esto incluye:

* Scope de Componentes: Controla qué variables, propiedades o métodos son accesibles en la plantilla asociada.

* Scope de Servicios: Define en qué nivel del árbol de módulos o componentes un servicio es accesible.

* Scope de Directivas: Determina dónde una directiva puede aplicarse y qué datos puede manipular.

Angular utiliza el concepto de encapsulación y jerarquías para determinar el alcance.

## ¿Para qué sirve el Scope?
* Organización del código: Facilita la separación y organización de la lógica de negocio, interfaz y datos compartidos.

* Control de accesibilidad: Limita qué datos son accesibles desde diferentes partes de la aplicación, promoviendo la seguridad y la modularidad.

* Reutilización y encapsulación: Permite crear componentes reutilizables con su propio contexto aislado, evitando conflictos con otras partes del sistema.

* Gestión de dependencias: Controla cómo y dónde se comparten los servicios dentro de la aplicación.

## ¿Qué resuelve el Scope en Angular?
* Confusión en la compartición de datos: Resuelve problemas de acceso no controlado a datos o propiedades entre componentes y módulos.

* Falta de modularidad: Ayuda a dividir la aplicación en piezas independientes que tienen un alcance definido.

* Problemas de colisión: Al encapsular datos dentro de componentes o servicios, evita conflictos con otras partes de la aplicación.

* Dependencias mal gestionadas: El scope facilita el control de la jerarquía de inyección de dependencias para garantizar que los servicios sean accesibles solo en los niveles requeridos.

## ¿Cómo lo resuelve?
* S**cope en Componentes**, Cada componente en Angular tiene su propio contexto de plantilla, lo que significa que las variables y métodos definidos en el componente son accesibles solo en su respectiva plantilla HTML.

Ejemplo:
```ts
@Component({
  selector: 'app-hello',
  template: `<h1>{{ message }}</h1>`
})
export class HelloComponent {
  message: string = 'Hola desde el componente!';
}
```
Aquí, `message` es accesible solo dentro de la plantilla de `HelloComponent`.

* **Scope en Servicios**, Los servicios tienen un alcance definido por su proveedor, que puede estar a nivel de módulo, componente o aplicación. Esto se controla mediante el atributo providedIn o registrando el servicio en los `providers`.

Ejemplo: Servicio con alcance global (nivel aplicación):
```ts
@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  getValue(): string {
    return 'Disponible en toda la aplicación';
  }
}
```
Ejemplo: Servicio con alcance local (nivel componente):
```ts
@Component({
  selector: 'app-local',
  providers: [LocalService],
  template: `<h1>{{ localData }}</h1>`
})
export class LocalComponent {
  localData: string;
  constructor(private localService: LocalService) {
    this.localData = localService.getValue();
  }
}
```
En este caso, LocalService solo es accesible dentro de `LocalComponent`.

* **Scope en Módulos**, Los módulos controlan qué componentes, directivas y pipes son accesibles en otras partes de la aplicación a través de las propiedades `declarations`, `imports` y `exports`.

Ejemplo
```ts
@NgModule({
  declarations: [MyComponent], // Solo accesible dentro del módulo
  exports: [MyComponent]       // Disponible en otros módulos que lo importen
})
export class SharedModule {}
```

* **Scope en Directivas**, Las directivas tienen un alcance que define en qué elementos pueden aplicarse y qué datos pueden manipular.

Ejemplo: Directiva personalizada
```ts
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  @Input() appHighlight: string = '';

  constructor(private el: ElementRef) {}

  ngOnInit() {
    this.el.nativeElement.style.backgroundColor = this.appHighlight;
  }
}
```
Esta directiva solo es aplicable a elementos HTML que utilicen el selector `[appHighlight]`.

## Jerarquía de Componentes y Scope
La estructura jerárquica de Angular también define el alcance de las dependencias. Los servicios proporcionados en un módulo o componente están disponibles para sus hijos, pero no para sus padres o hermanos, a menos que estén definidos globalmente.

```ts
@Component({
  selector: 'app-parent',
  providers: [ParentService],
  template: `<app-child></app-child>`
})
export class ParentComponent {}

@Component({
  selector: 'app-child',
  template: `<p>Acceso al servicio del padre</p>`
})
export class ChildComponent {
  constructor(private parentService: ParentService) {}
}
```
En este caso, `ParentService` está disponible en `ParentComponent` y `ChildComponent`, pero no fuera de ellos.