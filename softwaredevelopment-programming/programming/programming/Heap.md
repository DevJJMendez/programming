#memory
# Stack
Una región de memoria **grande, dinámica y compartida** entre todos los threads de la JVM. No tiene estructura LIFO ni ningún orden predefinido. Es el espacio donde viven todos los objetos durante su tiempo de vida.

A diferencia del stack que es administrado automáticamente frame por frame, el heap requiere un administrador activo: el **Garbage Collector**.

## Estructura interna del Heap
El heap en Java no es un bloque uniforme. Está dividido en **generaciones** basadas en la edad de los objetos:

**Eden Space** -> Donde nacen todos los objetos. Cuando haces `new Person()`, el objeto aparece aquí primero.

**Survivor Spaces (S0 y S1)** -> Objetos que sobrevivieron al menos un ciclo de GC pasan aquí. Siempre uno está activo y el otro vacío.

**Old Generation (Tenured)** -> Objetos de larga vida. Configurables por edad (cuántos ciclos de GC sobrevivieron).

## Ciclo de vida de un objeto en el Heap
```
NACIMIENTO:
new Person("Carlos")
        │
        ▼
   Eden Space
   ┌──────────┐
   │ Person   │
   │ "Carlos" │
   └──────────┘

PRIMER GC (Minor GC):
Si el objeto sobrevive → se mueve a Survivor S0
        │
        ▼
   Survivor S0
   ┌──────────┐
   │ Person   │  age=1
   │ "Carlos" │
   └──────────┘

SUCESIVOS GC:
age=2 → S1
age=3 → S0
age=4 → S1

age=15 (threshold) → Old Generation

MUERTE:
Nadie referencia al objeto
Garbage Collector lo elimina
Memoria liberada
```

## Referencias y el Heap en detalle
```java
public class Main {
    public static void main(String[] args) {

        // Caso 1: referencia simple
        Person p1 = new Person("Ana");

        // Caso 2: dos referencias al mismo objeto
        Person p2 = p1;

        // Caso 3: nuevo objeto independiente
        Person p3 = new Person("Luis");

        // Caso 4: referencia nula
        Person p4 = null;

        // Caso 5: objeto sin referencia (inmediatamente elegible para GC)
        new Person("Ghost");
    }
}
```
```
        STACK                          HEAP
━━━━━━━━━━━━━━━━━━━━       ━━━━━━━━━━━━━━━━━━━━━━━━━━━
│ Frame: main()    │       │                          │
│                  │       │  ┌────────────────────┐  │
│ p1 ──────────────┼───────┼─►│ Person{nombre=Ana} │  │
│                  │       │  └────────────────────┘  │
│ p2 ──────────────┼───────┼──────────────────►(mismo)│
│                  │       │                          │
│ p3 ──────────────┼───────┼─►┌─────────────────────┐│
│                  │       │  │ Person{nombre=Luis}  ││
│ p4 = null        │       │  └─────────────────────┘│
│ (no apunta nada) │       │                          │
│                  │       │  ┌─────────────────────┐ │
│                  │       │  │ Person{nombre=Ghost} │ │
│                  │       │  │ ← nadie apunta aquí  │ │
│                  │       │  │ → elegible para GC   │ │
━━━━━━━━━━━━━━━━━━━━       └─────────────────────────┘
```

---

## El Garbage Collector en profundidad

### Algoritmos principales:

**Mark and Sweep (base de todo)**
```
FASE MARK:   GC recorre todas las referencias activas
             y marca cada objeto alcanzable

FASE SWEEP:  GC recorre el heap completo
             y elimina todo objeto no marcado

PROBLEMA:    deja fragmentación en el heap
```

**Mark, Sweep and Compact**
```
FASE MARK:   igual que antes
FASE SWEEP:  elimina no alcanzables
FASE COMPACT: mueve objetos supervivientes juntos
              elimina la fragmentación
              actualiza todas las referencias
```

**Generational GC (lo que usa Java)**
```
HIPÓTESIS: la mayoría de objetos mueren jóvenes

Minor GC → limpia solo Young Generation (rápido, frecuente)
Major GC → limpia Old Generation (lento, poco frecuente)
Full GC  → limpia todo el heap (muy lento, evitar)
```

### Tipos de GC en Java:
```
Serial GC        →  un solo thread, apps pequeñas
Parallel GC      →  múltiples threads, default hasta Java 8
G1 GC            →  default desde Java 9, balance latencia/throughput
ZGC              →  pausas ultra bajas (<1ms), Java 15+
Shenandoah       →  similar a ZGC, OpenJDK
```

## Memory Leak — cuando el GC no puede ayudarte
El GC solo elimina objetos sin referencias. Si mantienes referencias innecesarias, el objeto nunca muere:
```java
// MEMORY LEAK CLÁSICO — cache que nunca se limpia
public class Cache {
    private static Map<String, byte[]> cache = new HashMap<>();

    public static void guardar(String key, byte[] datos) {
        cache.put(key, datos);   // los datos nunca se eliminan
    }
    // No hay método para limpiar
    // cache crece indefinidamente
    // OutOfMemoryError eventualmente 💥
}


// SOLUCIÓN — usar WeakReference o WeakHashMap
private static Map<String, WeakReference<byte[]>> cache = new WeakHashMap<>();
// El GC puede eliminar los valores si la memoria escasea
```
Otro memory leak clásico:
```java
// LISTENER no removido
public class EventManager {
    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener l) {
        listeners.add(l);
    }

    // ❌ No hay removeListener()
    // Cada listener agregado vive para siempre
    // aunque el objeto que lo registró ya no exista
}

// SOLUCIÓN
public void removeListener(EventListener l) {
    listeners.remove(l);
}
```

---

## Objetos en el Heap — anatomía completa

Cada objeto en el heap no solo contiene sus campos. Tiene una cabecera interna:
```
┌──────────────────────────────────────┐
│           OBJECT HEADER              │
│  ┌────────────────────────────────┐  │
│  │ Mark Word (8 bytes)            │  │
│  │ - hashCode                     │  │
│  │ - GC age (generational)        │  │
│  │ - lock state (synchronized)    │  │
│  └────────────────────────────────┘  │
│  ┌────────────────────────────────┐  │
│  │ Class Pointer (4-8 bytes)      │  │
│  │ - referencia a su Class en     │  │
│  │   Metaspace                    │  │
│  └────────────────────────────────┘  │
├──────────────────────────────────────┤
│           INSTANCE DATA              │
│  campo1, campo2, campo3...           │
├──────────────────────────────────────┤
│           PADDING                    │
│  bytes de relleno para alinear       │
│  a múltiplos de 8 bytes              │
└──────────────────────────────────────┘
```
Por eso un objeto vacío en Java no pesa 0 bytes, pesa 16 bytes solo de cabecera.

# Stack + Heap juntos — ejemplo exhaustivo
```java
public class Banco {

    private String nombre;          // campo de instancia → HEAP
    private double saldo;           // campo de instancia → HEAP

    public Banco(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo  = saldo;
    }

    public double calcularInteres(double tasa) {
        double interes = saldo * tasa;      // variable local → STACK
        double total   = saldo + interes;   // variable local → STACK
        return total;
    }

    public static void main(String[] args) {
        Banco cuenta = new Banco("Ahorro", 1000.0);
        double resultado = cuenta.calcularInteres(0.05);
        System.out.println(resultado);
    }
}
```

Estado completo de la memoria durante `calcularInteres()`:
```
          STACK                              HEAP
━━━━━━━━━━━━━━━━━━━━━━━━━      ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
│ Frame: calcularInteres() │    │                            │
│  this ───────────────────┼────┼──►┌────────────────────┐  │
│  tasa = 0.05             │    │   │ Banco              │  │
│  interes = 50.0          │    │   │ nombre ────────────┼──┼──►"Ahorro"
│  total = 1050.0          │    │   │ saldo = 1000.0     │  │   (String Pool)
├──────────────────────────┤    │   └────────────────────┘  │
│ Frame: main()            │    │                            │
│  args ───────────────────┼────┼──► String[]{}             │
│  cuenta ─────────────────┼────┼──► (mismo objeto Banco)   │
│  resultado = ?           │    │                            │
━━━━━━━━━━━━━━━━━━━━━━━━━━━    ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

## Configuración de memoria en JVM
```
# Tamaño del Stack por thread
java -Xss512k MiPrograma     # 512 KB por thread
java -Xss2m  MiPrograma      # 2 MB por thread

# Tamaño del Heap
java -Xms256m MiPrograma     # heap inicial: 256 MB
java -Xmx1g   MiPrograma     # heap máximo:  1 GB

# Configuración típica para producción
java -Xms512m -Xmx2g -Xss1m MiPrograma
```

---

## Resumen comparativo final
```
┌────────────────────┬──────────────────────┬────────────────────────┐
│                    │       STACK          │        HEAP            │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Estructura         │ LIFO, frames         │ Generaciones           │
│                    │ contiguos            │ (Eden, Survivor, Old)  │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Qué almacena       │ Frames de métodos    │ Todos los objetos      │
│                    │ Variables locales    │ Variables de instancia │
│                    │ Referencias          │ Arrays, Strings        │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Administración     │ JVM automático       │ Garbage Collector      │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Tamaño             │ Pequeño (KB-MB)      │ Grande (MB-GB)         │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Velocidad          │ O(1), muy rápido     │ Más lento              │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Vida del dato      │ Dura el método       │ Dura mientras haya     │
│                    │                      │ referencias            │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Compartido         │ No (1 por thread)    │ Sí (todos los threads) │
├────────────────────┼──────────────────────┼────────────────────────┤
│ Error típico       │ StackOverflowError   │ OutOfMemoryError       │
└────────────────────┴──────────────────────┴────────────────────────┘
```
