# Reactive Extensions for Javascript
RxJS (Reactive Extensions for JavaScript) es una biblioteca para trabajar con programación reactiva utilizando observables. Facilita la gestión de flujos de datos asíncronos o eventos en aplicaciones. Es ampliamente utilizada en Angular para manejar datos, eventos, y realizar operaciones sobre ellos de manera eficiente y declarativa.

## ¿Para qué sirve?
RxJS se utiliza para:

* Manejo de datos asíncronos: Procesar datos provenientes de fuentes como API, eventos de usuario, o flujos de datos en tiempo real.

* Transformaciones y combinaciones de datos: RxJS permite transformar datos (map, filter) y combinarlos (merge, zip).

* Gestión de eventos complejos: Manejar interacciones de usuario, temporizadores, y eventos múltiples.

* Control de flujo de datos: Controlar el momento en que los datos se emiten (debounce, throttle, etc.).

## ¿Qué resuelve?
RxJS resuelve problemas relacionados con:

* Callback Hell: Cuando se anidan múltiples callbacks, el código se vuelve ilegible.

* Gestión de promesas complejas: Promesas encadenadas pueden ser difíciles de manejar y depurar.

* Eventos concurrentes: La sincronización de múltiples fuentes de eventos puede ser complicada sin herramientas adecuadas.

* Manejo de errores: Proporciona un enfoque uniforme para capturar y manejar errores en flujos de datos.

## ¿Cómo lo resuelve?
* Observables: Representan flujos de datos que pueden ser observados y reaccionados por suscriptores.

* Operadores: Transforman, filtran, o combinan datos emitidos por observables. Ejemplo: map, filter, merge.

* Suscripciones: Escuchan los cambios de los observables y ejecutan acciones cuando hay nuevos valores.

* Schedulers: Permiten controlar en qué contexto (hilo de ejecución) se ejecutan las operaciones.

* Manejo centralizado de errores: Utiliza operadores como catchError para manejar errores de forma declarativa.

## Conceptos clave de RxJS
1. [`Observables`](09-OBSERVABLES.md)

2. `Suscription`

3. [`Operadores`](09.2.0-operators.md)

4. Subject

5. Multicasting