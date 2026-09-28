# Comunicación entre Componentes
La comunicación entre componentes en Vue.js, y en general en cualquier framework de desarrollo web basado en componentes, se refiere a cómo los diferentes componentes de una aplicación interactúan y comparten información entre sí. En una aplicación típica, los componentes no funcionan de manera aislada; a menudo necesitan comunicarse para compartir datos, desencadenar acciones y coordinar comportamientos.

## Tipos de Comunicación entre Componentes
La comunicación entre componentes puede clasificarse en:
* **Comunicación de Padre a Hijo (Top-Down) / Comunicación Vertical Descendente**: Esta es la forma más directa y común de comunicación. Los datos se pasan del componente padre al hijo mediante **`props`**.

* **Comunicación de Hijo a Padre (Bottom-Up) / Comunicación Vertical Ascendente**: Los componentes hijos pueden enviar datos al componente padre utilizando **`$emit`** *eventos emitidos*.

# Comunicación mediante eventos
La comunicación mediante eventos en Vue.js es una forma de enviar datos o señales desde un componente hijo hacia su componente padre, utilizando el sistema de eventos de Vue. Esto permite a los componentes comunicarse en una dirección opuesta a las Props (de hijo a padre) de manera flexible y desacoplada.

Los eventos son clave para gestionar la interacción entre componentes en aplicaciones dinámicas.

## ¿Cuál es su estructura?
La comunicación mediante eventos consta de tres pasos principales:

1. Emitir un evento desde el componente hijo (emit)
El componente hijo utiliza el método $emit() para emitir un evento.
```ts
this.$emit('nombreDelEvento', datosOpcionales);
```
2. Escuchar el evento en el componente padre (@)
El componente padre escucha el evento con la directiva @ o su equivalente v-on.
```ts
<Hijo @nombreDelEvento="manejarEvento" />
```

3. Manejar el evento en el padre: El evento que se escucha en el padre se vincula a un método que realiza alguna acción.

## ¿Para qué sirve?
La comunicación mediante eventos sirve para:

Comunicación de hijo a padre:
Permite enviar datos desde un componente hijo hacia su padre.

Notificar cambios o acciones:
Los hijos pueden informar a los padres sobre eventos como clics, selecciones o cambios en datos internos.

Desacoplar componentes:
El padre no necesita conocer los detalles internos del hijo, solo escucha eventos relevantes.

## ¿Qué resuelve?
Flujo de datos en dirección inversa:
Las Props permiten comunicar datos del padre al hijo, pero los eventos resuelven la necesidad de comunicar del hijo al padre.

Desacoplamiento:
Facilita el diseño de componentes reutilizables, ya que el hijo no depende de las funciones o propiedades del padre.

Control de flujo:
Los eventos aseguran que el padre decida cómo reaccionar ante los cambios notificados por el hijo.

## ¿Cómo lo resuelve?
Emitir eventos:
El hijo notifica cambios o acciones específicas al padre mediante $emit().

Escuchar eventos:
El padre escucha los eventos que le interesan usando @evento.

Flujo de datos estructurado:
Esto mantiene un flujo claro de comunicación en aplicaciones grandes y asegura la separación de responsabilidades.

## Buenas prácticas al usar eventos
Nombres descriptivos para eventos:
Usa nombres claros y significativos para los eventos. Ejemplo: @actualizarUsuario en lugar de @click.

Documenta los eventos esperados:
Indica qué eventos puede emitir un componente hijo para que otros desarrolladores lo comprendan fácilmente.

Evita acoplamiento innecesario:
Diseña componentes genéricos que emitan eventos en lugar de invocar directamente métodos del padre.

Utiliza defineEmits (Vue 3):
En Vue 3, puedes definir explícitamente qué eventos emitirá un componente para mayor claridad:
```ts
defineEmits(['eventoNombre', 'otroEvento']);
```
Reutiliza componentes:
Usa eventos para mantener la lógica del componente desacoplada y permitir su reutilización.

## Limitaciones de los eventos
Solo funciona para la comunicación directa (hijo → padre):
No puedes comunicarte directamente con un componente nieto o hermano usando eventos. Para esto, puedes usar event buses (no recomendado) o una gestión de estado global como Vuex o Pinia.

Complejidad en aplicaciones grandes:
Si los componentes están profundamente anidados, depender exclusivamente de eventos puede volverse complicado de manejar.