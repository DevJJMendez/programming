PENDING: **RXJS**, HYDRATION
## Fundamentos de Angular (Básico)
* Introducción a Angular:
  * ¿Qué es Angular y cómo funciona?

  * Ventajas frente a otros frameworks.

* Configuración del Entorno de Desarrollo:
  * Instalación de Node.js, Angular CLI y TypeScript.

  * Creación de un proyecto Angular.

* Estructura del Proyecto Angular:
  * Archivos clave: `angular.json`, `package.json`, `main.ts`.

  * Organización de carpetas.

* **Fundamentos de TypeScript**:
  * Tipos de datos.

  * Interfaces, Clases y **Decoradores**.

  * Modificadores de acceso (`public`, `private`, etc.).

* Componentes en Angular:
  * Creación de componentes con Angular CLI.

  * Decorador `@Component`.

  * Ciclo de vida de un componente (`ngOnInit`, `ngOnDestroy`, etc.).

* Templates y Data Binding:
  * Interpolación `{{ }}`.

  * Property Binding `([property]="value")`.

  * Event Binding `((event)="handler()")`.

  * Two-way Binding con `[(ngModel)]`.

* Directivas:
  * Directivas estructurales `(*ngIf, *ngFor)`.

  * Directivas de atributo `([ngClass], [ngStyle])`.

* Módulos en Angular:
  * Uso de `NgModule`.

  * Módulo raíz (`AppModule`).

  * Importar y exportar otros módulos.

## Intermedio (Desarrollo de Aplicaciones Reales)
* Servicios y Dependencias:
  * Crear y usar servicios.

  * Inyección de dependencias con `@Injectable`.

* Routing y Navegación:
  * Configuración de rutas con `RouterModule`.

  * Parámetros en las rutas `(route.params)`.

  * **`Guards (CanActivate, CanDeactivate)`**.

* Comunicación entre Componentes:
  * Entrada y salida de datos con `@Input` y `@Output`.

  * Uso de servicios compartidos para comunicación.

* Formularios en Angular:
  * Formularios Template-driven.

  * Formularios Reactivos.

  * Validaciones (personalizadas y predefinidas).

* Peticiones HTTP:
  * Uso de `HttpClient` para consumir APIs REST.

  * Interceptores HTTP.

  * Manejo de errores HTTP.

* Pipes:
  * Pipes predefinidos (date, uppercase, etc.).

  * Creación de pipes personalizados.

## Avanzado (Temas para Aplicaciones Escalables y Robustas)
* Lazy Loading:
  * Dividir la aplicación en módulos cargados bajo demanda.

* Optimización de Desempeño:
  * Uso de `ChangeDetectionStrategy`.
  
  * Optimización de DOM con trackBy en `*ngFor`.
  
* Gestión del Estado:
  * Servicios personalizados para manejar estado.
  
  * Introducción a `NgRx` (Redux para Angular).
  
* Testing en Angular:
  * Pruebas unitarias con Jasmine y Karma.
  
  * Pruebas de integración y end-to-end con Protractor o Cypress.

* Internacionalización (i18n):
  * Configuración de Angular para soportar múltiples idiomas.
  
* Animaciones en Angular:
  * Uso de `@angular/animations` para crear transiciones y animaciones.