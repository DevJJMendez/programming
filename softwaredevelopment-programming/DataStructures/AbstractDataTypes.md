# Abstract Data Type
Un Tipo de Dato Abstracto (TDA) es un **modelo matemático de una estructura de datos** que define qué operaciones se pueden realizar sobre él, pero no especifica su implementación interna.

**Ejemplo del mundo real:**
* **Un cajero automático**: sabes que puedes **retirar dinero**, **depositar**, **consultar saldo**, pero no necesitas conocer la implementación interna.

* **Una lista de tareas**: puedes **agregar**, **eliminar** y **consultar tareas**, pero no importa cómo estén organizadas internamente.

**Ejemplo en programación:**
* Una **pila (`stack`)** permite `push` (insertar) y `pop` (eliminar).

* Una **cola (`queue`)** permite `enqueue` (agregar) y `dequeue` (eliminar).

El TDA **define el comportamiento**, pero **no cómo se implementa internamente**.

## ¿Para qué sirven los TDA?
Los TDA permiten abstraer la complejidad de las estructuras de datos y proporcionar una interfaz clara para manipular datos.

1. **Mejor organización del código**: Separa la lógica de negocio de la implementación.

2. **Facilita la reutilización del código**: Puedes cambiar la implementación sin afectar el código que lo usa.

3. **Mejora la mantenibilidad**: Al trabajar con abstracciones, los cambios internos no afectan al resto del sistema.

4. **Aumenta la seguridad del código**: Al ocultar la implementación, evita que otras partes del código lo modifiquen directamente.

5. **Promueve el uso de principios SOLID y Clean Code**: Reduce acoplamiento y favorece el diseño modular.

## ¿Qué problemas resuelven los TDA?
1. **Organización y estructura del código**: Al encapsular operaciones en un TDA, el código es más limpio y estructurado.

2. **Independencia de implementación**: Puedes cambiar la estructura de datos sin afectar el código que la usa.

3. **Seguridad y control de acceso a los datos**: Al exponer solo operaciones controladas, evitas errores y modificaciones accidentales.

4. **Reducción de duplicación de código**: Puedes usar el mismo TDA en diferentes partes del programa sin reescribir código.

5. **Facilidad en la prueba y depuración**: Se pueden probar los TDA como módulos independientes.

## ¿Cómo lo resuelven?
Los TDA resuelven estos problemas proporcionando una interfaz clara que define las operaciones sin exponer la implementación interna.

**Ejemplo de un TDA en la vida real**: Un Banco ofrece operaciones como depositar, retirar, consultar saldo, pero no revela cómo gestiona internamente las cuentas.

### Ejemplos de TDA
1. `Stack`

2. `Queue`

3. `LinkedList`

4. `Map`

5. `Set`

# Modelo Matematico
Cuando hablamos de "modelo matemático" en el contexto de los Tipos de Datos Abstractos (TDA), nos referimos a una representación formal y abstracta de una estructura de datos basada en matemáticas y lógica, sin importar su implementación en un lenguaje de programación específico.

**Un modelo matemático define:**
1. El conjunto de datos que forman la estructura.

2. Las operaciones permitidas sobre esos datos.

3. Las propiedades o axiomas que esas operaciones deben cumplir.

### Ejemplo 1: Modelo matemático de una Pila (Stack)
Una pila es un TDA que sigue la regla LIFO (Last In, First Out), es decir, el último elemento que entra es el primero que sale.

📌 Definición matemática de una pila

Conjunto de datos: Un conjunto ordenado de elementos S = {s1, s2, ..., sn}.
Operaciones permitidas:
push(x): Agrega el elemento x en la cima de la pila.
pop(): Elimina y devuelve el elemento en la cima de la pila.
top(): Devuelve el elemento en la cima sin eliminarlo.
isEmpty(): Retorna true si la pila está vacía, false en caso contrario.
📌 Propiedades (axiomas) de una pila

pop(push(S, x)) = S → Si agregamos un elemento x y luego lo sacamos, la pila queda como antes.
top(push(S, x)) = x → Si agregamos un elemento x, es el nuevo top de la pila.
isEmpty(S) = true si y solo si S no tiene elementos.
Aquí, vemos que no se define cómo se implementa la pila, solo qué operaciones permite y cómo deben comportarse.

### Ejemplo 2: Modelo matemático de una Cola (Queue)
Una cola sigue la regla FIFO (First In, First Out), es decir, el primer elemento que entra es el primero que sale.

📌 Definición matemática de una cola

Conjunto de datos: Un conjunto ordenado de elementos Q = {q1, q2, ..., qn}.
Operaciones permitidas:
enqueue(x): Agrega el elemento x al final de la cola.
dequeue(): Elimina y devuelve el primer elemento de la cola.
front(): Devuelve el primer elemento sin eliminarlo.
isEmpty(): Retorna true si la cola está vacía, false en caso contrario.
📌 Propiedades (axiomas) de una cola

dequeue(enqueue(Q, x)) = Q si Q estaba vacío → Si agregamos x y lo quitamos, la cola queda igual.
front(enqueue(Q, x)) = q1 si Q no estaba vacío → El primer elemento siempre es el más antiguo.
isEmpty(Q) = true si y solo si Q no tiene elementos.
De nuevo, no decimos cómo implementar la cola (con listas, arreglos, etc.), sino cómo debe comportarse.

## ¿Por qué usamos modelos matemáticos en los TDA?
* Independencia de implementación → No importa si la pila o cola se implementa con listas, arreglos o estructuras complejas, el comportamiento debe cumplir las mismas reglas.

* Claridad y precisión → Al definir un TDA matemáticamente, evitamos ambigüedades y errores de diseño.

* Facilidad para demostrar propiedades → Con modelos formales, podemos probar teóricamente que un TDA cumple ciertas características antes de programarlo.

* Aplicación en la verificación formal → En sistemas críticos (bancos, aviación, seguridad), los modelos matemáticos ayudan a validar que un algoritmo funciona correctamente sin necesidad de ejecutarlo.