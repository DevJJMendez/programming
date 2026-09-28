# Estado Local
El estado local es el que vive y se gestiona dentro de un componente específico.

Es privado, no es compartido con otros componentes (a menos que lo propagues).

**Es donde guardás valores que cambian con la interacción del usuario o el ciclo de vida del componente.**

## ¿Para qué sirve?
El estado local sirve para:

* Controlar inputs (controlled components)
* Mostrar/ocultar cosas (modales, menús)
* Guardar datos momentáneos
* Controlar animaciones o UI temporales
* Llevar el control de formularios
* Controlar botones, tabs, sliders, checkboxes, etc.

## ¿Cómo se define?
React nos da el hook [useState()](useState.md) para esto.

## Buenas prácticas con estado local
* Usá múltiples useState para separar responsabilidades
* Mantené el estado lo más cerca posible del componente que lo necesita
* No abuses de objetos muy grandes en un solo useState
* Si el estado es complejo, evaluá usar useReducer

## Mentalidad de senior
Un buen uso del estado local:

* Haz tu componente independiente y testable
* Reduce la complejidad global
* Mejora la legibilidad y mantenimiento
* Es la base para construir componentes reutilizables