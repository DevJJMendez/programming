# Angular Routing
El Angular Routing es un mecanismo en Angular que permite gestionar la navegación entre diferentes vistas o páginas dentro de una aplicación de una sola página (Single Page Application, SPA). Este sistema de enrutamiento permite cargar y mostrar componentes específicos según la URL solicitada, manteniendo la experiencia fluida característica de las aplicaciones modernas.

## ¿Qué es Angular Routing?
El Angular Router es un módulo que proporciona herramientas para configurar rutas, gestionar navegaciones y manipular la URL del navegador sin recargar la página. Utiliza el sistema de rutas para asociar una URL a un componente o conjunto de componentes.

**Características principales:**
* Soporte para rutas dinámicas y estáticas.

* Administración del estado del navegador (historial, URL).

* Parámetros de ruta y de consulta.

* Guardias de ruta para controlar accesos.

* Lazy loading (carga diferida) para optimizar el rendimiento.

## ¿Para qué sirve Angular Routing?
Angular Routing se utiliza para:

* Navegación entre vistas: Permite a los usuarios moverse entre diferentes componentes de la aplicación de manera fluida, simulando una experiencia multi-página en una SPA.

* Gestión de URLs: Asocia URLs específicas a componentes o vistas para proporcionar una experiencia de navegación coherente.

* Carga eficiente de recursos: Con la carga diferida (lazy loading), solo se cargan los módulos necesarios según la ruta solicitada, mejorando el rendimiento.

* Control de acceso: Los guardias de ruta permiten restringir el acceso a ciertas rutas según condiciones específicas (como autenticación).

* Sincronización con el navegador: Mantiene la URL del navegador actualizada, permitiendo el uso del historial y facilitando el acceso directo mediante enlaces.

## ¿Qué problemas resuelve Angular Routing?
* Gestión manual de la navegación: Antes del routing, la navegación entre vistas requería la manipulación manual del DOM y eventos complejos.

* Recarga completa de la página: Evita la recarga completa del navegador al cambiar de vistas, proporcionando una experiencia más fluida.

* Desorganización de componentes: Ayuda a estructurar la aplicación en módulos y vistas bien definidos.

* Ineficiencia en la carga de recursos: Implementa carga diferida para cargar solo los módulos necesarios en el momento adecuado.

* Falta de control de acceso: Proporciona herramientas como guardias de rutas para gestionar la seguridad y las restricciones de navegación.

## ¿Cómo lo resuelve?
* **Configuración del módulo de enrutamiento**, Angular utiliza el módulo [RouterModule](06.0-routerModule.md) para definir y gestionar las rutas de la aplicación. La configuración básica requiere definir un arreglo de rutas y asociarlas a componentes.