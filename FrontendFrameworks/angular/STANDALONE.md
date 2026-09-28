## Standalone
En Angular 17, la arquitectura standalone es una evolución importante en la forma en que las aplicaciones se estructuran. Los componentes, directivas y otros elementos se pueden crear de manera standalone (independiente), lo que significa que ya no dependen de los tradicionales **NgModules** para funcionar.

### ¿Qué es standalone en Angular?
Un componente o servicio standalone es aquel que no necesita ser declarado en un módulo (NgModule) para ser utilizado en una aplicación. Esto simplifica la estructura del proyecto y hace que el desarrollo sea más directo, especialmente en proyectos más pequeños o medianos.

Antes de Angular 14 (cuando se introdujo el concepto de standalone), cada componente, directiva o servicio tenía que ser declarado en un NgModule para que Angular lo reconociera. Ahora, en Angular 17, con la posibilidad de crear componentes standalone por defecto, ya no es necesario declararlos en un módulo, haciendo que el código sea más claro y modular.

### Principales características de standalone:
1. **Componentes independientes**:

   * Los componentes standalone pueden funcionar por sí solos sin necesidad de estar declarados en un NgModule. Esto significa que cada componente puede ser autocontenido y gestionar sus propias dependencias.

**Ejemplo de un componente standalone**
```ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-standalone-component',
  standalone: true,
  imports: [CommonModule],  // Declaras aquí las dependencias necesarias
  template: `<h1>Hello Standalone!</h1>`,
})
export class StandaloneComponent { }
```
En este ejemplo, el componente **StandaloneComponent** es independiente, y se declara la propiedad `standalone: true`. Además, cualquier dependencia que este componente necesite, como otros módulos o directivas, se incluye en el `array imports`.

2. **Eliminación del NgModule obligatorio**:

   * En versiones anteriores de Angular, los componentes siempre debían ser declarados en un NgModule, como en AppModule. Ahora con **standalone**, puedes omitir la necesidad de crear y gestionar módulos para cada conjunto de componentes.

   * Los módulos siguen siendo compatibles y útiles en proyectos grandes para agrupar funcionalidades, pero ahora son opcionales.

3. **Importaciones directas en los componentes**:

   * Con los componentes **standalone**, puedes importar directamente otros módulos o componentes que el componente necesite, sin depender de un módulo externo que los agrupe.

Ejemplo de importación directa de un componente standalone en otro:
```ts
import { StandaloneComponent } from './standalone-component';

@Component({
  selector: 'app-another-component',
  standalone: true,
  imports: [StandaloneComponent],  // Importando otro componente standalone
  template: `<app-standalone-component></app-standalone-component>`,
})
export class AnotherComponent { }
```

4. **Simplificación en el enrutamiento**:

El enrutamiento en aplicaciones standalone también se ha simplificado. Puedes definir rutas directamente hacia componentes standalone sin preocuparte por declararlos en un módulo de enrutamiento.

Ejemplo de configuración de rutas standalone:
```ts
import { Routes } from '@angular/router';
import { StandaloneComponent } from './standalone-component';

const routes: Routes = [
  { path: 'standalone', component: StandaloneComponent },
];
```

## Ventajas de los componentes standalone:
1. **Modularidad**: Cada componente gestiona sus propias dependencias, lo que facilita el mantenimiento y la reutilización.

2. **Simplicidad**: Elimina la sobrecarga de los módulos en proyectos pequeños o medianos, simplificando la estructura del proyecto.

3. **Inicio más rápido**: Con menos requisitos estructurales (como los NgModules), el desarrollo es más ágil y directo, lo que también puede resultar en tiempos de compilación más rápidos en algunos casos.

4. **Optimización del código**: Dado que los componentes standalone sólo cargan lo que necesitan, se evita cargar dependencias innecesarias, mejorando la eficiencia y el rendimiento de la aplicación.

5. **Escalabilidad**: Aunque la arquitectura **standalone** simplifica la estructura del proyecto, Angular sigue soportando los módulos. Esto significa que las aplicaciones pueden comenzar con componentes **standalone** y, conforme crecen, pueden beneficiarse de módulos para organizar mejor grandes conjuntos de funcionalidades.