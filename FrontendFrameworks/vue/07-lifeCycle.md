# Life Cycle
El ciclo de vida de un componente en Vue.js describe las diferentes etapas que atraviesa un componente desde su creación hasta su destrucción. Vue proporciona varios hooks del ciclo de vida que permiten ejecutar código en cada una de estas etapas. Estos hooks son muy útiles para inicializar datos, realizar operaciones asíncronas, manipular el DOM, y limpiar recursos.

**Fases del Ciclo de Vida**
* **`Creation`**

* **`Mounting`**

* **`Updating`**

* **`Destruction`**

## hooks
Los hooks en Vue son funciones específicas del ciclo de vida de un componente. Estas funciones permiten ejecutar código en momentos clave del ciclo de vida del componente, como cuando se crea, se monta, se actualiza o se destruye.

Son una parte esencial de Vue porque permiten a los desarrolladores manejar tareas relacionadas con la inicialización, limpieza y actualización de los componentes.

* **`beforeCreate`**

* **`created`**

* **`beforeMount`**

* **`mounted`**

* **`beforeUpdate`**

* **`updated`**

* **`beforeUnmount`**

* **`unmounted`**

## ¿Para qué sirven?
Los hooks permiten a los desarrolladores:

* Ejecutar lógica en momentos específicos del ciclo de vida del componente.

* Configurar dependencias, estados reactivos o listeners.

* Gestionar tareas como solicitudes HTTP, timers, o suscripciones a eventos.

* Asegurar la limpieza de recursos al desmontar un componente.

## ¿Qué resuelven?
* Control del ciclo de vida: Permiten a los desarrolladores ejecutar código en momentos específicos, facilitando la inicialización y limpieza de recursos.

* Modularidad: Separan la lógica en diferentes etapas del ciclo de vida, lo que mejora la organización del código.

* Gestión eficiente de recursos: Evitan fugas de memoria al limpiar listeners, intervalos o recursos cuando un componente se destruye.