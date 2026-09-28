# Paradigma Orientado a Objetos
El paradigma orientado a objetos es una forma de modelar software donde el mundo del problema se representa como entidades que tienen estado y comportamiento, que se comunican entre sí enviándose mensajes.

La idea central viene de una observación simple:
```
El mundo real está compuesto de objetos.
Un perro tiene características (color, tamaño, raza)
y comportamientos (ladrar, correr, comer).

¿Por qué el software no debería modelarse igual?
```
OOP nació como respuesta a ese problema. En lugar de pensar en funciones y datos por separado, piensas en entidades completas que encapsulan ambos.
```
ANTES (Procedimental):
  datos  ←→  funciones
  separados, cualquiera puede tocar cualquier cosa

DESPUÉS (OOP):
  objeto = datos + funciones que operan sobre esos datos
  encapsulados, protegidos, con responsabilidad clara
```

## ¿Qué resuelve?
Tres problemas fundamentales del software a gran escala:
```
1. COMPLEJIDAD
   Un sistema de 500,000 líneas es imposible de entender completo.
   OOP permite dividirlo en piezas comprensibles individualmente.

2. MANTENIBILIDAD
   El código cambia. Siempre.
   OOP permite cambiar una parte sin romper el resto.

3. REUTILIZACIÓN
   No reinventar la rueda.
   OOP permite construir sobre lo que ya existe.
```

## La metáfora fundamental
Antes de los conceptos técnicos, graba esta imagen:
```
Un objeto es como una cápsula:

┌─────────────────────────────────┐
│           OBJETO                │
│                                 │
│  ┌─────────────────────────┐    │
│  │       ESTADO            │    │
│  │  (datos / atributos)    │    │
│  └─────────────────────────┘    │
│                                 │
│  ┌─────────────────────────┐    │
│  │    COMPORTAMIENTO       │    │
│  │  (métodos / mensajes)   │    │
│  └─────────────────────────┘    │
│                                 │
│  El exterior NO puede tocar     │
│  el estado directamente.        │
│  Solo puede enviar mensajes.    │
└─────────────────────────────────┘
```
El mundo exterior solo interactúa con el objeto a través de su interfaz pública. Lo que hay adentro es asunto del objeto.

## Clase vs Objeto — el concepto más importante
Esta distinción es el punto de partida de todo OOP:

```
CLASE:   el plano, el molde, la plantilla
         define QUÉ ES y QUÉ PUEDE HACER un tipo de entidad
         existe en tiempo de compilación

OBJETO:  una instancia concreta de esa clase
         existe en tiempo de ejecución
         tiene valores específicos en su estado
```
La analogía más clara:
```
Clase   =  plano arquitectónico de una casa
Objeto  =  la casa física construida a partir del plano

Del mismo plano puedes construir 1000 casas distintas.
Cada casa tiene su propia dirección, color, dueño.
Pero todas comparten la misma estructura definida en el plano.
```
Representación universal (agnóstica al lenguaje):
```
┌─────────────────────────────────────────┐
│              CLASE: Perro               │
├─────────────────────────────────────────┤
│  ATRIBUTOS:                             │
│  - nombre  : texto                      │
│  - raza    : texto                      │
│  - edad    : número                     │
│  - energia : número                     │
├─────────────────────────────────────────┤
│  COMPORTAMIENTOS:                       │
│  + ladrar()                             │
│  + correr(distancia)                    │
│  + comer(comida)                        │
│  + obtenerNombre() → texto              │
└─────────────────────────────────────────┘

Instancias (objetos):
  perro1: {nombre="Firulais", raza="Labrador", edad=3, energia=80}
  perro2: {nombre="Rex",      raza="Pastor",   edad=5, energia=60}
  perro3: {nombre="Luna",     raza="Beagle",   edad=1, energia=95}
```

## Los cuatro pilares
OOP tiene cuatro conceptos fundamentales. No son opcionales ni decorativos. Son la razón por la que el paradigma funciona.
```
┌─────────────────────────────────────────────────────┐
│                   OOP                               │
│                                                     │
│  ┌───────────────┐      ┌──────────────────────┐    │
│  │ ENCAPSULACIÓN │      │      HERENCIA        │    │
│  │               │      │                      │    │
│  │ Protege el    │      │  Reutiliza y extiende│    │
│  │ estado interno│      │  comportamiento      │    │
│  └───────────────┘      └──────────────────────┘    │
│                                                     │
│  ┌───────────────┐      ┌──────────────────────┐    │
│  │  ABSTRACCIÓN  │      │    POLIMORFISMO      │    │
│  │               │      │                      │    │
│  │ Oculta la     │      │  Misma interfaz,     │    │
│  │ complejidad   │      │  distinto comportami.│    │
│  └───────────────┘      └──────────────────────┘    │
└─────────────────────────────────────────────────────┘
```
### Pilar 1 — Encapsulación
**¿Qué es?** -> Empaquetar datos y comportamiento juntos, y controlar el acceso desde el exterior.
```
Sin encapsulación:
  cualquiera puede modificar cualquier dato
  → el estado se puede corromper desde cualquier lugar
  → imposible razonar sobre el sistema

Con encapsulación:
  el objeto controla cómo se modifica su estado
  → el estado solo cambia de formas válidas
  → el objeto garantiza su propia integridad
```
La representación en diagrama:
```
EXTERIOR

                        │ mensaje: depositarDinero(500)
                        │
┌───────────────────────▼─────────────────────────────┐
│                   CuentaBancaria                     │
│                                                      │
│  ╔════════════════════════════════════╗              │
│  ║  PRIVADO (inaccesible al exterior) ║              │
│  ║                                    ║              │
│  ║  saldo        = 1000               ║              │
│  ║  numeroCuenta = "001-234-567"      ║              │
│  ║  historial    = [...]              ║              │
│  ╚════════════════════════════════════╝              │
│                                                      │
│  PÚBLICO (interfaz del objeto):                      │
│  + depositar(monto)                                  │
│  + retirar(monto) → exito/fallo                      │
│  + obtenerSaldo() → número                           │
└──────────────────────────────────────────────────────┘
```
Por qué importa — ejemplo concreto:
```
Sin encapsulación — el estado puede corromperse:
  cuenta.saldo = -99999    ← nadie impide esto
  cuenta.saldo = "hola"    ← ni esto (en lenguajes dinámicos)

Con encapsulación — el objeto valida:
  cuenta.retirar(99999)
  → el método verifica: ¿hay suficiente saldo?
  → si no: retorna error, saldo no cambia
  → el objeto NUNCA llega a un estado inválido
```
Niveles de acceso (agnóstico al lenguaje):
```
PRIVADO:    solo el propio objeto puede acceder
            máxima protección, implementación interna

PROTEGIDO:  el objeto y sus descendientes (herencia)
            útil para comportamiento que subclases necesitan

PÚBLICO:    cualquiera puede acceder
            la interfaz que el mundo exterior ve

PAQUETE:    objetos del mismo módulo/paquete
            colaboración interna del módulo
```
La regla de oro de la encapsulación:
```
Haz todo lo más privado posible.
Expón solo lo que el exterior NECESITA.
Nunca expongas el estado directamente.
Controla el acceso a través de métodos.
```

### Pilar 2 — Abstracción
**¿Qué es?** -> Mostrar solo lo relevante y ocultar la complejidad de implementación. Trabajar con conceptos de alto nivel sin necesitar saber cómo funcionan por dentro.
```
Abstraer = simplificar la realidad para lo que importa en este contexto
```
La analogía perfecta:
```
Cuando manejas un auto:
  Interfaz que ves:   volante, pedales, palanca de cambios
  Lo que no ves:      motor de combustión, transmisión,
                      sistema hidráulico, computadora del auto

Puedes manejar perfectamente sin entender la ingeniería interna.
La abstracción te da una interfaz simple sobre una complejidad enorme.
```
En OOP — dos mecanismos:
1. Clases Abstractas:
```
Una clase abstracta define un concepto parcialmente implementado.
No puede instanciarse directamente.
Establece un contrato que las subclases deben completar.

┌──────────────────────────────────────┐
│         <<abstracta>>                │
│              Figura                  │
├──────────────────────────────────────┤
│  + color: texto                      │
│  + posicion: coordenada              │
├──────────────────────────────────────┤
│  + mover(dx, dy)      ← implementado │
│  + calcularArea() *   ← abstracto    │
│  + dibujar()      *   ← abstracto    │
└──────────────────────────────────────┘
         △              △
         │              │
  ┌──────┴───┐    ┌──────┴──────┐
  │  Circulo │    │  Rectangulo │
  │          │    │             │
  │area=πr²  │    │area=base*h  │
  │dibujar() │    │dibujar()    │
  └──────────┘    └─────────────┘
```

2. Interfaces:
```
Una interfaz define solo el contrato — QUÉ puede hacer,
sin ningún detalle de CÓMO lo hace.
Es abstracción pura.

┌──────────────────────────────────┐
│         <<interfaz>>             │
│           Pagable                │
├──────────────────────────────────┤
│  + procesarPago(monto) → bool    │
│  + reembolsar(monto)   → bool    │
│  + obtenerEstado()     → estado  │
└──────────────────────────────────┘
         △         △         △
         │         │         │
  ┌──────┴─┐  ┌────┴───┐  ┌──┴────────┐
  │Tarjeta │  │Transfer│  │Criptomoneda
  │Credito │  │Bancaria│  │           │
  └────────┘  └────────┘  └───────────┘
```
La diferencia clave:
```
Clase abstracta:
  → "Soy un tipo de cosa con comportamiento parcial"
  → Comparte implementación entre subclases
  → Herencia de implementación

Interfaz:
  → "Soy capaz de hacer estas cosas"
  → Define capacidades sin implementación
  → Herencia de tipo / contrato
```
Por qué importa:
```
Sin abstracción:
  Para usar una base de datos, debes entender
  el protocolo TCP, el formato de los paquetes,
  el lenguaje binario del motor...

Con abstracción:
  repositorio.guardar(usuario)
  ← no importa si es PostgreSQL, MySQL, MongoDB
  ← no importa el protocolo de red
  ← no importa el formato interno
  Solo importa el contrato: guardar() guarda
```

### Pilar 3 — Herencia
**¿Qué es?** -> Un mecanismo donde una clase obtiene el estado y comportamiento de otra, pudiendo extenderlo o modificarlo.
```
Clase padre (superclase) → define comportamiento base
Clase hija (subclase)    → hereda todo y puede agregar o cambiar
```
Representación visual:
```
┌─────────────────────────────┐
│          Animal             │  ← Superclase
├─────────────────────────────┤
│  nombre: texto              │
│  edad:   número             │
├─────────────────────────────┤
│  + comer()                  │
│  + dormir()                 │
│  + respirar()               │
│  + hacerSonido() *          │  ← abstracto
└─────────────────────────────┘
              △
    ┌─────────┼──────────┐
    │         │          │
┌───┴───┐ ┌──┴────┐ ┌───┴────┐
│ Perro │ │  Gato │ │  Ave   │
├───────┤ ├───────┤ ├────────┤
│       │ │       │ │volar() │  ← agrega comportamiento
├───────┤ ├───────┤ ├────────┤
│sonido │ │sonido │ │sonido  │  ← sobreescribe
│="Guau"│ │="Miau"│ │="Pío"  │
└───────┘ └───────┘ └────────┘
```
La regla IS-A:
```
La herencia es válida cuando la relación es "ES UN":

Perro    IS-A Animal     ✅  tiene sentido heredar
Gato     IS-A Animal     ✅  tiene sentido heredar
Auto     IS-A Animal     ❌  no tiene sentido

Si la relación no es IS-A,
la herencia está mal aplicada.
```
Tipos de herencia:
```
SIMPLE:
  Una clase hereda de exactamente una superclase
  Java, C# lo implementan así para clases

  Animal → Perro

MÚLTIPLE:
  Una clase hereda de varias superclases simultáneamente
  C++ lo permite, Java no (para clases)
  Java permite herencia múltiple de INTERFACES

  Trabajador + Estudiante → EstudianteTrabajador

EN NIVELES (cadena):
  Animal → Mamifero → Canino → Perro
  Cada nivel agrega especialización

JERÁRQUICA:
  Una superclase con múltiples subclases directas
  Animal → {Perro, Gato, Ave, Pez}
```
El problema de la herencia mal usada:
```
Herencia para REUTILIZAR código (sin relación IS-A):

  clase Stack hereda de ArrayList
  porque "quiero reutilizar el add() y get()"

  PROBLEMA:
  Stack hereda todos los métodos de ArrayList:
  add(index, element) → ¡rompe la semántica del stack!
  remove(index)       → ¡rompe la semántica del stack!
  set(index, element) → ¡rompe la semántica del stack!

La herencia modela RELACIONES, no reutilización.
Para reutilizar código sin relación IS-A: usa COMPOSICIÓN.
```
Herencia vs Composición:
```
HERENCIA:    "ES UN"
  Perro ES UN Animal → herencia ✅

COMPOSICIÓN: "TIENE UN"
  Auto TIENE UN Motor → composición ✅

┌──────────────────────┐
│         Auto         │
├──────────────────────┤
│  motor: Motor        │  ← composición
│  llantas: Llanta[]   │  ← composición
│  volante: Volante    │  ← composición
└──────────────────────┘

Regla de oro:
"Prefiere composición sobre herencia"
La herencia crea acoplamiento fuerte.
La composición es más flexible y mantenible.
```

### Pilar 4 — Polimorfismo
¿Qué es?
La capacidad de que objetos de distintos tipos respondan al mismo mensaje de maneras diferentes y apropiadas para cada uno.

Del griego: polys (muchos) + morphe (forma). Muchas formas.
```
El mismo mensaje → comportamientos distintos según el receptor
```
La analogía:
```
Mensaje: "habla"

→ enviado a un Perro:    "Guau"
→ enviado a un Gato:     "Miau"
→ enviado a un Pájaro:   "Pío"
→ enviado a una Persona: "Hola"

Mismo mensaje.
Cuatro comportamientos distintos.
El emisor del mensaje no necesita saber qué tipo es el receptor.
```
Tipos de polimorfismo:
1. Polimorfismo de subtipos (el más importante):
```
┌─────────────────────────────────────────────────────┐
│                                                     │
│  procesarPago(metodoPago)                           │
│           │                                         │
│     ¿qué tipo es metodoPago?                        │
│           │                                         │
│      no importa                                     │
│           │                                         │
│  metodoPago.procesar(monto)  ← mismo mensaje        │
│           │                                         │
│     cada objeto sabe cómo procesarse                │
│                                                     │
└─────────────────────────────────────────────────────┘

Tarjeta.procesar()       → verifica fondos, cobra
Transferencia.procesar() → valida cuenta, transfiere
Cripto.procesar()        → verifica wallet, transfiere en blockchain
```
Polimorfismo paramétrico (Genéricos):
```
Contenedor<T>:
  el mismo código funciona para cualquier tipo T

Contenedor<Número> → guarda números
Contenedor<Texto>  → guarda textos
Contenedor<Perro>  → guarda perros

El código de Contenedor es idéntico en los tres casos.
T es el parámetro de tipo.
```
Sobrecarga (Ad-hoc polymorphism):
```
calcularArea(radio)           → área del círculo
calcularArea(base, altura)    → área del rectángulo
calcularArea(lado)            → área del cuadrado

Mismo nombre, distintos parámetros.
El compilador elige cuál llamar según los argumentos.
```
El poder real del polimorfismo:
```
Sin polimorfismo:
  si (tipo == "TarjetaCredito") procesarTarjeta()
  si (tipo == "Transferencia")  procesarTransferencia()
  si (tipo == "Cripto")         procesarCripto()
  → cada nuevo método de pago requiere modificar este código

Con polimorfismo:
  metodoPago.procesar()
  → agregar un nuevo método de pago NO requiere tocar este código
  → solo creas una nueva clase que implementa la interfaz
  → el código existente funciona sin cambios

Esto es el Principio Abierto/Cerrado (SOLID) en acción.
```

### Mensajes — la comunicación entre objetos
En OOP los objetos no se llaman directamente. Se envían mensajes. Esta distinción filosófica es importante.
```
NO:   "ejecuta el método calcularDescuento de carrito"
SÍ:   "envía el mensaje calcularDescuento a carrito"

La diferencia: el receptor decide cómo responder al mensaje.
El emisor no sabe ni le importa cómo se implementa.
```
```
emisor                 receptor
┌─────────────────┐   mensaje   ┌─────────────────┐
│    Checkout     │────────────►│     Carrito     │
│                 │ calcular    │                 │
│                 │ Total()     │ sabe cómo       │
│                 │             │ calcularlo      │
│  recibe         │◄────────────│                 │
│  el resultado   │   150.00    │                 │
└─────────────────┘             └─────────────────┘
```

## Relaciones entre objetos
Los objetos no existen aislados. Se relacionan de distintas formas:

* Asociación — "usa un"
```
La relación más genérica. Un objeto conoce y usa a otro.

┌──────────┐         ┌──────────┐
│ Empleado │────────►│ Empresa  │
└──────────┘  trabaja└──────────┘
               en

El empleado conoce su empresa.
La relación puede existir independientemente.
```
* Agregación — "tiene un" (débil)
```
Una clase contiene referencias a otras,
pero las partes pueden existir sin el todo.

┌──────────┐         ┌──────────┐
│  Equipo  │◇────────│ Jugador  │
└──────────┘  tiene  └──────────┘

Si el Equipo desaparece, los Jugadores siguen existiendo.
```
* Composición — "tiene un" (fuerte)
```
Las partes no pueden existir sin el todo.
El todo es responsable del ciclo de vida de las partes.

┌──────────┐         ┌──────────┐
│   Casa   │◆────────│  Cuarto  │
└──────────┘  compone└──────────┘

Si la Casa desaparece, los Cuartos también desaparecen.
```
* Herencia — "es un"
```
┌──────────┐
│  Animal  │
└──────────┘
      △
      │ es un
┌─────┴────┐
│   Perro  │
└──────────┘
```
* Realización — "se comporta como"
```
Una clase implementa un contrato (interfaz).

┌──────────────┐         ┌──────────┐
│  <<interfaz>>│         │ Pato     │
│   Volador    │◁────────│          │
└──────────────┘implementa└─────────┘
```

# Diseño con objetos — cómo pensar
El proceso para diseñar un sistema OOP:
```
PASO 1: Identificar entidades del dominio
  ¿Qué "cosas" existen en el problema?
  → Usuario, Producto, Carrito, Pedido, Pago

PASO 2: Identificar atributos
  ¿Qué datos describe a cada entidad?
  → Usuario: nombre, email, contraseña, dirección

PASO 3: Identificar comportamientos
  ¿Qué puede hacer cada entidad?
  → Usuario: registrarse, iniciarSesion, actualizarPerfil

PASO 4: Identificar relaciones
  ¿Cómo se relacionan las entidades?
  → Usuario TIENE UN Carrito
  → Carrito TIENE VARIOS Productos
  → Pedido ES-UNA-VERSIÓN-INMUTABLE-DE Carrito

PASO 5: Identificar jerarquías
  ¿Hay entidades que son especializaciones de otras?
  → Pago es abstracto
  → PagoTarjeta, PagoTransferencia son especializaciones
```

## Cohesión y Acoplamiento
Son las métricas de calidad del diseño OOP.
```
COHESIÓN:
  ¿Qué tan relacionadas están las responsabilidades
  dentro de un objeto?

  Alta cohesión ✅:  el objeto tiene una responsabilidad clara
                    todo lo que tiene está relacionado

  Baja cohesión ❌:  el objeto hace cosas no relacionadas
                    es un "objeto Dios" que hace todo

  Regla: cada objeto debe tener UNA razón para cambiar

─────────────────────────────────────────────────────────

ACOPLAMIENTO:
  ¿Qué tanto depende un objeto de los detalles internos
  de otros objetos?

  Bajo acoplamiento ✅:  los objetos se comunican por interfaces
                         un cambio interno no afecta a otros

  Alto acoplamiento ❌:  los objetos dependen de implementaciones
                         un cambio pequeño rompe todo el sistema

  Regla: programa hacia interfaces, no hacia implementaciones
```
```
El objetivo siempre es:
  ALTA COHESIÓN  +  BAJO ACOPLAMIENTO
```
### Los errores más comunes en OOP
```
❌ El objeto Dios:
   Una clase que hace todo.
   500 métodos, responsabilidades mezcladas.
   Viola cohesión.

❌ Herencia para reutilizar código:
   Stack extends ArrayList para "usar" sus métodos.
   Usa composición cuando la relación no es IS-A.

❌ Getters y setters para todo:
   class Persona { setEdad(e) { edad=e } }
   Si cualquiera puede cambiar todo,
   la encapsulación no existe.

❌ Clases anémicas:
   Solo tienen datos y getters/setters.
   El comportamiento está en otra parte (servicios).
   No es OOP, es programación procedimental con clases.

❌ Herencia profunda:
   A → B → C → D → E → F
   Imposible de entender y mantener.
   Máximo 2-3 niveles en la práctica.

❌ Exponer estado interno:
   retornar referencias a colecciones internas
   permite que el exterior corrompa el estado.
   Retorna copias defensivas o vistas inmutables.
```
