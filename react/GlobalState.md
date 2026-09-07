# Estado Global
Es el estado que se comparte entre múltiples componentes de la aplicación, sin importar cuán lejos estén en el árbol de componentes.

A diferencia del estado local (`useState`), que solo vive dentro de un componente, el estado global vive en un **contexto** o **`store`** accesible desde distintos puntos de la app.

## ¿Para qué sirve?
* Compartir datos entre componentes no relacionados directamente (sin necesidad de pasarlos por props)

* Manejar cosas centrales y globales, como:
  * Autenticación
  * Usuario actual
  * Tema (dark/light)
  * Carrito de compras
  * Notificaciones
  * Lenguaje (i18n)
  * Permisos / roles
  * Datos de una API que deben reutilizarse

## ¿Qué problema resuelve?
Sin estado global:

* Tenés que elevar el estado al ancestro común más alto ("prop drilling")
* Se vuelve difícil de mantener
* No podés compartir lógica de forma eficiente

**El estado global es como un "punto único de verdad" que los componentes consultan o modifican.**

## ¿Cómo lo maneja React?
React nativamente ofrece el [Context API](ContextAPI.md) para crear un estado global liviano.

## Escenarios ideales para estado global
* El dato lo necesita más de un componente no relacionado
* Se accede desde distintas rutas
* Es costoso de recalcular y se necesita en múltiples vistas
* Tiene impacto en la UI general

## Cuándo NO usar estado global
* Si el dato lo usa solo un componente
* Si solo tenés que pasarlo 1 o 2 niveles con props
* Si no se comparte entre muchas partes de la app

Usá el estado global con intención y no por defecto.

## Herramientas para estado global en React
| Herramienta           | Descripción                            | Ideal para                               |
| --------------------- | -------------------------------------- | ---------------------------------------- |
| useContext + useState | Solución nativa y simple               | Apps pequeñas o medianas                 |
| Redux                 | Store centralizado, acciones, reducers | Apps grandes, complejas, colaborativas   |
| Zustand               | Store ligero, sin boilerplate          | Apps modernas, rendimiento, ergonomía    |
| Recoil, Jotai         | Alternativas reactivas y más simples   | Apps de alto rendimiento o más reactivas |
| React Query / SWR     | Estado remoto (API caching, fetch)     | Datos que vienen de APIs                 |

## Mentalidad de un developer senior
Un buen manejo de estado global:

* Centraliza lo necesario, no todo
* Mantiene las reglas de negocio cerca del estado
* Usa stores legibles y organizados
* Separa claramente lo que es estado local, global, y derivado

