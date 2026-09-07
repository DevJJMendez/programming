## ¿Framework o Plataforma?
Angular se considera tanto un framework como una plataforma de desarrollo web. Esta dualidad surge debido a la amplitud y la naturaleza integral de Angular en el ecosistema de desarrollo de aplicaciones. Vamos a desglosar ambos conceptos y cómo se aplican a Angular.

## Angular como Framework:
Un framework en el desarrollo de software es una estructura o conjunto de herramientas que facilita la creación de aplicaciones. Un framework ofrece:

* **Estructura predefinida**: Angular proporciona una arquitectura bien definida basada en componentes, módulos y servicios, lo que te permite seguir patrones establecidos para desarrollar aplicaciones escalables.

* **Herramientas de desarrollo**: Angular ofrece herramientas integradas como el enrutador (para navegación entre vistas), herramientas para realizar pruebas, y directivas (para manipulación del DOM).

* **Automatización**: Angular gestiona muchas tareas comunes de desarrollo, como la inyección de dependencias, el enlace de datos (data binding) y el manejo del ciclo de vida de los componentes.

En este sentido, Angular actúa como un framework porque:

1. **Proporciona una arquitectura estructurada**: Angular organiza el código en módulos, componentes, servicios y otros elementos que permiten la creación de aplicaciones web bien estructuradas.

2. **Ofrece un conjunto de herramientas específicas**: Angular tiene su propio motor de plantillas (`ng-template`), un poderoso sistema de inyección de dependencias, manejo de formularios, comunicación con servidores (`HTTPClient`) y más.

3. **Desarrollo modular y reutilizable**: Te permite crear componentes y servicios modulares y reutilizables.

## Angular como Plataforma:
Angular también puede considerarse una plataforma de desarrollo debido a la cantidad de soluciones integradas y el ecosistema que ofrece para crear aplicaciones web completas. Esto va más allá de un framework, ya que cubre todo el ciclo de vida de desarrollo de una aplicación, desde el desarrollo hasta la implementación y optimización. Aquí algunas razones por las que es considerado una plataforma:

1. **CLI (Command Line Interface)**: Angular CLI es una herramienta fundamental que permite generar proyectos, componentes, servicios, pruebas, y manejar la compilación, pruebas y servidores de desarrollo. La CLI ayuda a automatizar y acelerar el proceso de desarrollo.

Ejemplo de comandos de la CLI:

   * `ng new my-app`: Crea una nueva aplicación.

   * `ng generate component my-component`: Genera un nuevo componente.

   * `ng build`: Compila la aplicación para producción.

   * `ng serve`: Sirve la aplicación en un servidor de desarrollo local.

1. **Soporte para testing**: Angular incluye herramientas integradas para pruebas unitarias y de integración como **Karma** y **Jasmine**, permitiendo que los desarrolladores implementen pruebas automatizadas fácilmente.

2. **Sistema de módulos**: Angular organiza el código en módulos (`NgModules`), lo que facilita la gestión de dependencias y la carga eficiente de partes de la aplicación (**lazy loading**). Esto permite que aplicaciones grandes sean divididas en partes más pequeñas y manejables.

3. **Desarrollo multiplataforma**: Aunque Angular se usa principalmente para aplicaciones web, puede ser utilizado para desarrollar aplicaciones móviles (con **Ionic** o **NativeScript**), aplicaciones de escritorio (con **Electron**) y aplicaciones progresivas (**PWA, Progressive Web Apps**). Esto lo convierte en una solución flexible para múltiples plataformas.

4. **Angular Universal**: Permite realizar el renderizado en servidor (**SSR**), mejorando el rendimiento y SEO de las aplicaciones web.

5. **Soporte continuo**: Angular es mantenido y actualizado constantemente por Google, lo que asegura que esté siempre alineado con las mejores prácticas del desarrollo web moderno. Las actualizaciones semestrales proporcionan nuevas funcionalidades, mejoras en el rendimiento y actualizaciones de seguridad.

## standalone
En Angular 17, la arquitectura **standalone** es una evolución importante en la forma en que las aplicaciones se estructuran. Los componentes, directivas y otros elementos se pueden crear de manera **standalone** (independiente), lo que significa que ya no dependen de los tradicionales **NgModules** para funcionar.

### ¿Qué es standalone en Angular?
Un componente o servicio standalone es aquel que no necesita ser declarado en un módulo (NgModule) para ser utilizado en una aplicación. Esto simplifica la estructura del proyecto y hace que el desarrollo sea más directo, especialmente en proyectos más pequeños o medianos.

Antes de Angular 14 (cuando se introdujo el concepto de standalone), cada componente, directiva o servicio tenía que ser declarado en un **NgModule** para que Angular lo reconociera. Ahora, en **Angular 17**, con la posibilidad de crear componentes standalone por defecto, ya no es necesario declararlos en un módulo, haciendo que el código sea más claro y modular.

### Principales características de standalone:
1. **Componentes independientes**:

   * Los componentes **standalone** pueden funcionar por sí solos sin necesidad de estar declarados en un **NgModule**. Esto significa que cada componente puede ser autocontenido y gestionar sus propias dependencias.

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
      * En este ejemplo, el componente **StandaloneComponent** es independiente, y se declara la propiedad `standalone: true`. Además, cualquier dependencia que este componente necesite, como otros módulos o directivas, se incluye en el array imports.

2. **Eliminación del NgModule obligatorio**:

   * En versiones anteriores de Angular, los componentes siempre debían ser declarados en un **NgModule**, como en **AppModule**. Ahora con standalone, puedes omitir la necesidad de crear y gestionar módulos para cada conjunto de componentes.

   * Los módulos siguen siendo compatibles y útiles en proyectos grandes para agrupar funcionalidades, pero ahora son opcionales.

3. **Importaciones directas en los componentes**:

   * Con los componentes **standalone**, puedes importar directamente otros módulos o componentes que el componente necesite, sin depender de un módulo externo que los agrupe.

      Ejemplo de importación directa de un componente **standalone** en otro:
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

   * El enrutamiento en aplicaciones **standalone** también se ha simplificado. Puedes definir rutas directamente hacia componentes standalone sin preocuparte por declararlos en un módulo de enrutamiento.

      ```ts
      import { Routes } from '@angular/router';
      import { StandaloneComponent } from './standalone-component';

      const routes: Routes = [
        { path: 'standalone', component: StandaloneComponent },
      ];
      ```

### Ventajas de los componentes standalone:
1. **Modularidad**: Cada componente gestiona sus propias dependencias, lo que facilita el mantenimiento y la reutilización.

2. **Simplicidad**: Elimina la sobrecarga de los módulos en proyectos pequeños o medianos, simplificando la estructura del proyecto.

3. **Inicio más rápido**: Con menos requisitos estructurales (como los **NgModules**), el desarrollo es más ágil y directo, lo que también puede resultar en tiempos de compilación más rápidos en algunos casos.

5. **Optimización del código**: Dado que los componentes **standalone** sólo cargan lo que necesitan, se evita cargar dependencias innecesarias, mejorando la eficiencia y el rendimiento de la aplicación.

6. **Escalabilidad**: Aunque la arquitectura **standalone** simplifica la estructura del proyecto, Angular sigue soportando los módulos. Esto significa que las aplicaciones pueden comenzar con componentes **standalone** y, conforme crecen, pueden beneficiarse de módulos para organizar mejor grandes conjuntos de funcionalidades.

### Uso de standalone en un proyecto Angular:
Cuando generas un nuevo proyecto con Angular 17 utilizando la CLI, por defecto, el proyecto sigue la arquitectura standalone. A continuación te muestro un ejemplo básico de cómo luce el flujo de trabajo en un proyecto standalone:

1. **Creación de un nuevo proyecto:**
    ```bash
    ng new my-standalone-app
    ```
2. **Generación de un nuevo proyecto:**
    ```ts
    ng generate component my-component --standalone
    ```
    Esto generará un componente con la opción standalone habilitada, lo que significa que no se incluirá en un módulo. El archivo del componente generado tendrá la siguiente estructura:
    ```ts
    @Component({
      selector: 'app-my-component',
      standalone: true,
      templateUrl: './my-component.component.html',
      styleUrls: ['./my-component.component.css']
    })
    export class MyComponent { }
    ```

3. **Configuración del enrutamiento**:

   * Ya no necesitas preocuparte por incluir componentes standalone en un módulo. En su lugar, puedes hacer que el enrutamiento apunte directamente a estos componentes standalone en el archivo de configuración de rutas.

4. **Inicio de la aplicación**:

   * El punto de entrada de tu aplicación (en `main.ts`) ahora puede referenciar directamente componentes standalone sin necesidad de pasar por un módulo raíz como **AppModule**.

## Schematics
Los schematics en Angular son un conjunto de herramientas que permiten automatizar la generación y modificación de código en un proyecto Angular. Son parte del sistema de herramientas de Angular CLI y están diseñados para facilitar tareas repetitivas como la creación de componentes, servicios, módulos, entre otros. Además, los schematics permiten realizar modificaciones automatizadas en el código existente, como actualizaciones o migraciones.

### ¿Qué es un schematic?
Un schematic es un conjunto de reglas que define cómo se va a generar o modificar código en un proyecto Angular. Estas reglas están escritas en TypeScript y se ejecutan a través de la Angular CLI. Por ejemplo, cuando usas un comando como `ng generate component`, Angular CLI utiliza un schematic para crear la estructura del componente, sus archivos asociados, y también modifica los archivos existentes (como `app.module.ts`).

### ¿Cómo funcionan los schematics?
Los schematics siguen un proceso definido para manipular el código de un proyecto:

1. **Comando de la CLI**: Se ejecuta un comando en la CLI que invoca un schematic (por ejemplo, ng generate component).

2. **Lectura del código**: El schematic lee el estado actual del código del proyecto.

3. **Aplicación de reglas**: Las reglas definidas en el schematic generan o modifican el código en función de las necesidades (por ejemplo, añadiendo un nuevo componente o actualizando dependencias).

4. **Actualización del proyecto**: Una vez aplicadas las reglas, se actualizan los archivos correspondientes en el proyecto.
