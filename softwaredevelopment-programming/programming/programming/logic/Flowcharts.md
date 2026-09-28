# Diagramas de Flujo
Una representación visual y gráfica de un proceso, algoritmo o flujo lógico usando símbolos estandarizados conectados por flechas.

Son el puente entre el pensamiento humano y el código. Antes de escribir una sola línea, un diagrama de flujo te permite ver el problema completo.

```
Los diagramas de flujo son herramientas esenciales para visualizar procesos, haciéndolos más fáciles de entender, analizar y mejorar. Utilizan símbolos estandarizados para representar acciones, decisiones, datos y más, proporcionando una imagen clara de cómo fluyen las tareas y operaciones de principio a fin. Ya sea en desarrollo de software, operaciones de negocio, educación o ingeniería, los diagramas de flujo ayudan a agilizar la comunicación y respaldan una mejor toma de decisiones.
```
## ¿Qué resuelven?
**El problema de la ambigüedad en el diseño.**

Cuando tienes un problema complejo, escribir código directamente genera errores de lógica difíciles de detectar. Un diagrama de flujo te obliga a pensar el flujo completo antes de implementar.
```
Sin diagrama:   Piensas mientras codeas → errores de lógica → refactoring costoso
Con diagrama:   Piensas antes de codear → lógica clara → implementación directa
```

## ¿Cómo lo resuelven?
Traduciendo la lógica a símbolos visuales universales que cualquier persona, independientemente del lenguaje de programación, puede leer y entender.

### Simbología
Símbolos estándar:
```
┌─────────────────────────────────────────────────────┐
│  SÍMBOLO          FORMA            USO               │
├─────────────────────────────────────────────────────┤
│  Terminal         Óvalo/Cápsula    Inicio y Fin      │
│  Proceso          Rectángulo       Operación/acción  │
│  Decisión         Rombo            Condición (si/no) │
│  E/S de datos     Paralelogramo    Input / Output    │
│  Conector         Círculo          Unir flujos       │
│  Flujo            Flecha           Dirección         │
│  Subproceso       Rectángulo +     Llamada a proceso │
│                   líneas laterales separado          │
└─────────────────────────────────────────────────────┘
```
* **Flecha**: El primer símbolo que se muestra es la flecha, un símbolo de **conexión** utilizado para indicar un enlace entre dos símbolos y la dirección del flujo.

![arrow](../assets/flowcharts-arrow.avif)

Las flechas en los diagramas de flujo juegan un papel crucial: muestran la dirección del flujo, guiando al lector a través del proceso de un paso al siguiente. Piénsalas como el "tejido conectivo" entre diferentes símbolos o acciones. Sin flechas, un diagrama de flujo sería solo una colección de cuadros sin una secuencia clara.

* **Terminación**: Se refiere al **inicio** o **fin** de un proceso. Se representa con un símbolo especial: un óvalo (o a veces un rectángulo redondeado), a menudo etiquetado con palabras como "**Inicio**", "**Fin**" o "**Salida**".

* **Proceso**: Un proceso representa una tarea, acción u operación específica que necesita realizarse. Es uno de los elementos más comunes en los diagramas de flujo y se muestra típicamente como un rectángulo.

En resumen, los símbolos de proceso son el "caballo de batalla" de un diagrama de flujo. Mapean lo que realmente se hace en cada paso, ayudando a que los flujos de trabajo complejos sean fáciles de entender y analizar.

* **Decisión**: Representa un punto donde se debe tomar una elección, típicamente una pregunta de **sí/no** o **verdadero/falso**. Se simboliza con una forma de diamante.

En esencia, los puntos de decisión son lo que hace que los diagramas de flujo sean dinámicos. Añaden lógica y permiten caminos alternativos, facilitando modelar procesos del mundo real que dependen de condiciones o reglas.

* **Retraso**: Representa un pausa o período de espera en un proceso. Se utiliza cuando el flujo de trabajo debe detenerse temporalmente, ya sea para esperar que se cumpla una condición, que expire un temporizador o que se complete una acción externa. El símbolo parece un semicírculo en forma de "D", con el lado plano a la izquierda.

Ejemplos de símbolo de Retraso:
* “Esperar entrada del usuario”
* “Pausar 10 segundos”
* “Esperar hasta recibir aprobación”

Se utiliza comúnmente en sistemas automatizados, flujos de trabajo de usuario o cualquier proceso que no sea instantáneo.

* **Datos**: Se utiliza para representar información que se almacena o recupera, típicamente de un archivo, base de datos u otro medio de almacenamiento. Generalmente se dibuja como un rectángulo inclinado (un paralelogramo) o un cilindro si se refiere específicamente a una base de datos.

Hay algunas variaciones:

* Datos de Entrada/Salida (paralelogramo) – A menudo se superpone con el símbolo de E/S y muestra datos que entran o salen.
* Datos Almacenados (rectángulo abierto, también conocido como "almacenamiento de datos") – Representa datos en reposo, como un archivo o documento.
* Base de Datos (cilindro) – Se utiliza específicamente para mostrar almacenamiento en una base de datos estructurada.

El símbolo de Datos aporta contexto sobre qué información se maneja en el proceso. Ayuda a los espectadores a entender dónde reside la información, cómo se utiliza y cuándo se mueve, lo cual es especialmente útil en software, flujos de trabajo de negocio o canalizaciones de datos.

* **Documento**: El símbolo de Documento representa un documento único generado, recibido o utilizado en un proceso. Parece un rectángulo con un borde inferior ondulado (curvado), asemejándose a una hoja de papel.

Este símbolo de diagrama de flujo es especialmente útil en procesos de negocio, flujos de trabajo legales o sistemas donde el papeleo (digital o físico) juega un papel. Ayuda a aclarar qué documentos están involucrados en qué pasos, haciendo que tu diagrama de flujo sea más completo e informativo.

* **Varios documentos**: Indica que hay varios documentos. En realidad, es un caso especial del elemento Documento.

* **Subrutina o proceso predeterminado**: Representa un proceso o función nombrada que se define en otro lugar, como una tarea reutilizable o un procedimiento llamado. Se muestra como un rectángulo con barras verticales dobles en cada lado.

Este símbolo ayuda a descomponer flujos de trabajo complejos en piezas manejables. Es perfecto para sistemas grandes, donde ciertos pasos se manejan mejor en su propio diagrama de flujo separado pero necesitan ser referenciados desde el principal. Mantiene tus diagramas ordenados y fáciles de seguir.

* **Preparación**: El símbolo de Preparación representa un paso de configuración o inicialización, algo que debe hacerse antes de que el proceso principal pueda comenzar o continuar. Se dibuja como un hexágono, a veces referido como un símbolo de "configuración".

El símbolo de Preparación en el diagrama de flujo ayuda a aclarar que se necesita una configuración específica antes de que el flujo de trabajo pueda proceder. Hace que tu diagrama de flujo sea más preciso, especialmente cuando se muestran procesos técnicos o cualquier cosa con una fase de inicialización clara.

* **Entrada manual**: representa un paso donde un usuario introduce datos manualmente en el sistema, como escribir en un teclado o completar un formulario. Se dibuja como un rectángulo con un borde superior inclinado (inclinándose hacia arriba de izquierda a derecha).

Este símbolo de diagrama de flujo ayuda a distinguir entre pasos del sistema automatizados y aquellos que dependen de un operador humano. Es especialmente importante para identificar cuellos de botella, posibles errores o pasos que podrían automatizarse en iniciativas de mejora de procesos.

* Bucle manual: representa un proceso repetitivo que se realiza manualmente hasta que se cumple una cierta condición. Se muestra típicamente como un hexágono con dos muescas hacia adentro en los lados izquierdo y derecho (como una "H" alargada).

Este símbolo de diagrama de flujo ayuda a aclarar cuándo la repetición no es automatizada, depende de la intervención humana. Esto es especialmente útil en procesos de operaciones o control de calidad, facilitando la identificación de áreas donde pueden ocurrir bucles que requieren mucho trabajo.

* **Límite de bucle**: representa el punto final o límite de un bucle, define cuántas veces debe ejecutarse un bucle o cuándo debe detenerse. Se utiliza para controlar la repetición en un proceso y es especialmente relevante en diagramas de flujo técnicos o de programación. El símbolo es un hexágono, similar en forma al símbolo de Preparación, pero se utiliza específicamente para señalar la condición o límite del bucle.

El símbolo de Límite de Bucle es crucial para mostrar dónde se detiene una acción repetida. Ayuda a visualizar la repetición controlada, dando claridad sobre cuánto tiempo corre un bucle, ya sea basado en un contador, una condición o un estado de finalización.

* **Datos almacenados**: representa información que se guarda para uso posterior, como archivos, documentos, registros o entradas de base de datos. Se muestra como un rectángulo abierto (como un rectángulo con el lado derecho curvado hacia adentro), a menudo referido como el símbolo de almacenamiento de datos o archivo de datos.

Este símbolo de diagrama de flujo ayuda a aclarar dónde se guarda o de dónde se recupera la información, especialmente en procesos que involucran documentación, registros o almacenamiento persistente. Es un elemento clave para mostrar cómo fluye la información a través de los sistemas y cómo se gestiona a lo largo del tiempo.

* **Conector**: se utiliza para enlazar diferentes partes de un diagrama de flujo, especialmente cuando el diagrama es demasiado grande para caber en una página o cuando las líneas se cruzarían y harían el diagrama desordenado. Se representa por un pequeño círculo con una etiqueta dentro.

Los Conectores mantienen tus diagramas de flujo limpios, legibles y bien organizados. Son esenciales cuando se trata de diagramas grandes o de varias páginas, ayudando a los usuarios a seguir el flujo sin perderse en un laberinto de flechas.

* **Conector a otra página**: El símbolo de Conector Fuera de Página se utiliza para mostrar que el flujo continúa en una página o sección diferente del diagrama de flujo. Tiene forma de pentágono (a veces llamado forma de "home plate") y generalmente contiene una etiqueta o ID de referencia para ayudar a emparejarlo con el símbolo correspondiente en la otra página.

Este símbolo de diagrama de flujo es esencial para navegar por diagramas de flujo grandes. Ayuda a los usuarios a saltar sin problemas entre partes de un proceso sin confusión, manteniendo la lógica visual limpia y organizada, incluso a través de múltiples páginas.

### Reglas fundamentales
```
1. Todo diagrama tiene UN solo inicio y al menos UN fin
2. Las flechas indican dirección del flujo, nunca se cruzan sin conector
3. Todo rombo (decisión) tiene exactamente DOS salidas: Sí y No
4. El flujo va de arriba hacia abajo y de izquierda a derecha
5. Cada símbolo tiene un propósito específico, no los mezcles
```

### Estructuras de control en diagramas
Todo código que escribirás en Java se puede representar con estas cuatro estructuras:

1. **Secuencia** -> Los pasos se ejecutan uno tras otro, sin condiciones:
```
   ┌─────────┐
   │  INICIO │
   └────┬────┘
        │
   ┌────▼────┐
   │ Paso 1  │
   └────┬────┘
        │
   ┌────▼────┐
   │ Paso 2  │
   └────┬────┘
        │
   ┌────▼────┐
   │  FIN    │
   └─────────┘
```
En Java:
```java
int a = 5;       // Paso 1
int b = a * 2;   // Paso 2
System.out.println(b);  // Paso 3
```

2. Decisión (if / if-else) -> El flujo se divide según una condición:
```
        ┌─────────┐
        │  INICIO │
        └────┬────┘
             │
        ┌────▼─────┐
        │ ¿edad>=18│
        └──┬────┬──┘
          Sí    No
          │      │
    ┌─────▼──┐ ┌─▼──────┐
    │ Acceso │ │Denegado│
    └─────┬──┘ └──┬─────┘
          │       │
          └───┬───┘
         ┌────▼────┐
         │   FIN   │
         └─────────┘
```
En Java:
```java
if (edad >= 18) {
    System.out.println("Acceso permitido");
} else {
    System.out.println("Acceso denegado");
}
```

3. **Iteración (while / for)** -> El flujo regresa hacia atrás mientras la condición sea verdadera:
```
        ┌─────────┐
        │  INICIO │
        └────┬────┘
             │
        ┌────▼─────┐
   ┌───►│ ¿i < 5?  │
   │    └──┬────┬──┘
   │      Sí    No
   │      │      │
   │  ┌───▼───┐  │
   │  │i = i+1│  │
   │  └───┬───┘  │
   └───────┘      │
               ┌──▼───┐
               │ FIN  │
               └──────┘
```
En Java:
```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

4. **Iteración con do-while** -> La condición se evalúa al final, el cuerpo ejecuta al menos una vez:
```
        ┌─────────┐
        │  INICIO │
        └────┬────┘
             │
        ┌────▼────┐
   ┌───►│ Proceso │
   │    └────┬────┘
   │         │
   │    ┌────▼─────┐
   │    │¿condición│
   │    └──┬────┬──┘
   │      Sí    No
   └───────┘    │
             ┌──▼───┐
             │ FIN  │
             └──────┘
```

* **Ejemplos completos — algoritmo real**
1. **Problema:** Leer un número, determinar si es positivo, negativo o cero, e imprimir el resultado:
```
         ┌──────────────┐
         │    INICIO    │
         └──────┬───────┘
                │
         ┌──────▼───────┐
         │  Leer número │ ◄── Paralelogramo (input)
         └──────┬───────┘
                │
         ┌──────▼───────┐
         │  ¿numero > 0?│ ◄── Rombo (decisión)
         └──┬────────┬──┘
           Sí        No
           │          │
    ┌──────▼──┐  ┌────▼──────────┐
    │Positivo │  │ ¿numero == 0? │
    └──────┬──┘  └──┬─────────┬──┘
           │       Sí          No
           │        │           │
           │  ┌─────▼──┐  ┌────▼────┐
           │  │  Cero  │  │Negativo │
           │  └─────┬──┘  └────┬────┘
           │        │           │
           └────────┼───────────┘
                    │
             ┌──────▼───────┐
             │  Imprimir    │ ◄── Paralelogramo (output)
             │  resultado   │
             └──────┬───────┘
                    │
             ┌──────▼───────┐
             │     FIN      │
             └──────────────┘
```
En Java:
```java
Scanner scanner = new Scanner(System.in);
int numero = scanner.nextInt();

if (numero > 0) {
    System.out.println("Positivo");
} else if (numero == 0) {
    System.out.println("Cero");
} else {
    System.out.println("Negativo");
}
```

2. **Diagrama con bucle completo — sumar números** -> **Problema:** Sumar los números del 1 al N ingresado por el usuario.
```
      ┌─────────────┐
      │    INICIO   │
      └──────┬──────┘
             │
      ┌──────▼──────┐
      │   Leer N    │
      └──────┬──────┘
             │
      ┌──────▼──────┐
      │  suma = 0   │
      │  i = 1      │
      └──────┬──────┘
             │
      ┌──────▼──────┐
 ┌───►│  ¿i <= N?   │
 │    └──┬───────┬──┘
 │      Sí       No
 │      │         │
 │  ┌───▼──────┐  │
 │  │suma+=i   │  │
 │  │i++       │  │
 │  └───┬──────┘  │
 └───────┘         │
              ┌────▼──────┐
              │Imprimir   │
              │suma       │
              └────┬──────┘
                   │
              ┌────▼──────┐
              │    FIN    │
              └───────────┘
```
En Java:
```java
Scanner scanner = new Scanner(System.in);
int n = scanner.nextInt();
int suma = 0;

for (int i = 1; i <= n; i++) {
    suma += i;
}

System.out.println("Suma: " + suma);
```

### Errores comunes
❌ Error 1 — Flechas sin dirección clara
   El flujo debe ser siempre legible de arriba a abajo.
   Si hay bucles, la flecha de retorno va por la izquierda.

❌ Error 2 — Rombos con más de dos salidas
   Un rombo es una pregunta de Sí/No.
   Si necesitas más de dos casos, encadena rombos.

❌ Error 3 — Mezclar símbolos
   Un proceso en un paralelogramo o
   una decisión en un rectángulo rompe el estándar.

❌ Error 4 — Diagramas sin fin
   Todo proceso termina. Si tu diagrama no tiene
   un óvalo de FIN, algo está mal.

❌ Error 5 — Demasiado detalle o demasiado poco
   Nivel de abstracción incorrecto.
   Un diagrama no es pseudocódigo línea por línea,
   pero tampoco es tan general que no dice nada.


### Niveles de abstracción
Un mismo algoritmo puede diagramarse a diferentes niveles:
* Alto nivel:      "Autenticar usuario"  →  una sola caja
* Nivel medio:     Verificar email → Verificar contraseña → Generar token
* Bajo nivel:      Cada operación matemática y comparación detallada

Regla práctica:
* Para comunicar con el equipo   →  alto nivel
* Para diseñar el algoritmo      →  nivel medio
* Para depurar lógica compleja   →  bajo nivel

### Diagrama → Código — el proceso correcto
```
Problema
   │
   ▼
Identifica entradas y salidas
   │
   ▼
Dibuja el flujo principal (camino feliz)
   │
   ▼
Agrega condiciones y casos borde
   │
   ▼
Agrega bucles si hay repetición
   │
   ▼
Verifica que todo camino llega a un FIN
   │
   ▼
Traduce a código
```