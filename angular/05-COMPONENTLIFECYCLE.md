## Component Life Cycle
El ciclo de vida de un componente en Angular es el conjunto de etapas por las que pasa un componente desde que se crea, se actualiza y finalmente se destruye. Durante estas etapas, Angular proporciona una serie de **hooks** (métodos especiales) que permiten ejecutar código en momentos específicos del ciclo de vida.

## ¿Cuáles son las fases del ciclo de vida?
El ciclo de vida se compone principalmente de tres fases:

1. **Creación**: El componente es inicializado y sus propiedades y dependencias son configuradas.

2. **Actualización**: Angular realiza el cambio o actualización del componente cuando detecta cambios en las propiedades enlazadas.

3. **Destrucción**: El componente es eliminado de la vista y sus recursos son liberados.

## Hooks del ciclo de vida
Angular proporciona hooks de ciclo de vida que puedes implementar en tus componentes para manejar estas fases. Estos hooks pertenecen a la interfaz `OnChanges`, `OnInit`, `OnDestroy`, etc.

## ¿Para qué sirven?
Los hooks del ciclo de vida permiten:

* **Controlar el comportamiento del componente**: Inicializar datos o suscribirse a servicios en el momento adecuado.

* **Optimizar el rendimiento**: Ejecutar lógica solo cuando es necesario, como en la creación o destrucción del componente.

* **Manejar recursos**: Limpiar observables, suscripciones o temporizadores antes de que el componente sea destruido.

## ¿Qué problemas resuelven?
1. **Gestión de estado y datos**: Aseguran que los datos necesarios estén disponibles al inicializar el componente.

2. **Prevención de fugas de memoria**: Proporcionan un lugar adecuado para liberar recursos, como suscripciones o referencias.

3. **Sincronización con la vista**: Permiten realizar acciones una vez que el DOM está completamente cargado o cuando las propiedades cambian.

## ¿Cómo resuelven los problemas?
* **Hooks específicos**: Cada hook está diseñado para abordar necesidades específicas del ciclo de vida, como detectar cambios (**`ngOnChanges`**) o limpiar recursos (**`ngOnDestroy`**).

* **Intervenciones controladas**: Los hooks proporcionan puntos predecibles donde puedes agregar lógica personalizada sin interrumpir el flujo de Angular.

* **Integración con Angular**: Los hooks están profundamente integrados en el motor de detección de cambios y renderizado de Angular.

## Buenas prácticas al usar los hooks
1. **Mantén el código limpio y específico**: Usa cada hook para su propósito específico. Evita lógica innecesaria en hooks como `ngOnInit` o `ngOnChanges`.

2. **Limpia recursos en `ngOnDestroy`**: Siempre libera recursos como observables, temporizadores o suscripciones para evitar fugas de memoria.

3. **Minimiza el uso de `ngDoCheck`**: Evítalo a menos que sea absolutamente necesario, ya que puede impactar el rendimiento.

4. **Usa `ngAfterViewInit` para manipulaciones del DOM**: Este es el momento seguro para interactuar directamente con el DOM del componente.