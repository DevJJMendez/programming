# Services
Un Service en Angular es una clase que contiene lógica y funcionalidades reutilizables, diseñadas para ser compartidas entre múltiples componentes. Se utiliza para implementar funcionalidades como manejo de datos, llamadas a APIs, almacenamiento en caché, entre otros.

Los servicios en Angular son esenciales en la arquitectura porque:

* Permiten separar la lógica de negocio del componente.

* Fomentan el principio de responsabilidad única.

* Facilitan la reutilización de código y la modularidad.

## ¿Para qué sirven?
* Compartir datos entre componentes: Mantener estados compartidos entre diferentes partes de la aplicación.

* Centralizar lógica de negocio: Mover operaciones complejas desde los componentes hacia una clase dedicada.

* Interactuar con APIs externas: Realizar peticiones HTTP para obtener o enviar datos.

* Gestionar estados o configuraciones globales: Por ejemplo, manejar autenticación o configuraciones del sistema.

* Facilitar pruebas unitarias: Los servicios son más fáciles de probar por separado.

## ¿Qué problemas resuelven?
* Evitan duplicación de lógica: Sin servicios, las operaciones comunes (como llamadas a APIs) podrían replicarse en múltiples componentes.

* Separación de responsabilidades: Los servicios permiten que los componentes se enfoquen solo en la presentación y la interacción con el usuario.

* Facilitan la escalabilidad: Una aplicación modular y desacoplada es más fácil de mantener y ampliar.

* Promueven el uso de patrones de diseño: Implementan el patrón **Dependency Injection** para inyectar dependencias de manera eficiente.

## ¿Cómo lo resuelven?
Los servicios resuelven estos problemas al proporcionar:

* Un punto único de lógica compartida: Toda la lógica centralizada en una clase reutilizable.

* Gestión eficiente de dependencias: Usando el mecanismo de Dependency Injection de Angular para inyectar servicios donde se necesiten.

* Configuración de ámbito de inyección: Puedes definir un servicio a nivel global (singleton) o a nivel de módulo/componente.

## Creación y Uso de un Servicio en Angular
* **Crear un Servicio**, Usando el CLI de Angular, puedes generar un servicio con el siguiente comando:
```bash
ng generate service my-service
```
**Esto genera dos archivos:**
  * `my-service.service.ts` (implementación del servicio).

  * `my-service.service.spec.ts` (pruebas del servicio).

* Implementar el Servicio
```ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root', // Hace que este servicio sea un singleton y esté disponible en toda la app
})
export class MyService {
  private data: string[] = [];

  constructor() {}

  addData(item: string) {
    this.data.push(item);
  }

  getData(): string[] {
    return this.data;
  }
}
```

* **Usar el Servicio en un Componente**, Inyectar el servicio en el constructor:
```ts
import { Component } from '@angular/core';
import { MyService } from './my-service.service';

@Component({
  selector: 'app-my-component',
  template: `
    <button (click)="addItem()">Agregar</button>
    <ul>
      <li *ngFor="let item of items">{{ item }}</li>
    </ul>
  `,
})
export class MyComponent {
  items: string[] = [];

  constructor(private myService: MyService) {}

  addItem() {
    this.myService.addData('Nuevo Item');
    this.items = this.myService.getData();
  }
}
```
**Angular automáticamente gestiona la inyección del servicio gracias a `@Injectable` y el sistema de `Dependency Injection`.**