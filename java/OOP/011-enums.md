# Enums
Un `enum` (enumeración) en Java es un tipo de dato especial que representa un conjunto fijo de constantes conocidas como valores enumerados. Estos valores son inmutables, lo que significa que no cambian durante la ejecución del programa.

En Java, los `enum` son tipos que se comportan como clases con valores predefinidos. Cada uno de esos valores se trata como una instancia única de esa clase.

## ¿Para Qué Sirven?
1. **Definir Conjuntos de Valores Constantes**: Permiten declarar un conjunto de valores predefinidos y bien conocidos, como días de la semana, meses del año, estados de un pedido (pendiente, enviado, entregado), etc.

2. **Facilitar la Lectura y Mantenimiento del Código**: Mejoran la legibilidad y el mantenimiento del código al evitar el uso de valores "mágicos" como cadenas o enteros para representar estados específicos. Con `enum`, el código es más intuitivo y claro.

3. **Seguridad en el Código**: Proveen seguridad al limitar el rango de valores posibles. Solo se pueden usar los valores definidos dentro del `enum`, reduciendo el riesgo de errores por valores inesperados.

## ¿Qué Problema Resuelven?
1. **Problema: Uso de Valores Mágicos**: En lugar de usar cadenas como **"PENDING"**, **"APPROVED"** o enteros como **1**, **2**, usar un `enum` hace que el código sea más claro, ya que el propósito de los valores está explícito en el código. Además, evita errores tipográficos al usar constantes.

2. **Problema: Posibilidad de Errores en Comparaciones**: Al usar cadenas o números, es fácil cometer errores comparando valores, ya que las cadenas son propensas a errores tipográficos, y los números pueden ser difíciles de interpretar. Un `enum` garantiza que los valores utilizados sean válidos.

## ¿Cómo Lo Resuelven?
1. **Definiendo Valores Enumerados**: Los `enum` te permiten definir un conjunto limitado de valores. Esto elimina el riesgo de usar valores incorrectos en el código, ya que el compilador asegura que solo se usen los valores definidos.

2. **Uso de Métodos de Instancia y Atributos**: Además de los valores constantes, los `enum` pueden contener métodos y atributos, lo que les da más flexibilidad. Esto permite, por ejemplo, asociar datos adicionales con cada valor del enum y proporcionar métodos para trabajar con esos datos.

**Ejemplo básico**
```java
public enum EstadoPedido {
    PENDIENTE, 
    PROCESANDO, 
    ENVIADO, 
    ENTREGADO
}
```
**Uso**:
```java
public class Pedido {
    private String id;
    private EstadoPedido estado;

    public Pedido(String id) {
        this.id = id;
        this.estado = EstadoPedido.PENDIENTE; // Establece un estado inicial
    }

    public void procesar() {
        if (estado == EstadoPedido.PENDIENTE) {
            estado = EstadoPedido.PROCESANDO;
        }
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Estado: " + estado;
    }
}

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("A001");
        System.out.println(pedido); // Salida: Pedido ID: A001, Estado: PENDIENTE
        pedido.procesar();
        System.out.println(pedido); // Salida: Pedido ID: A001, Estado: PROCESANDO
    }
}
```
## Ejemplo con Métodos y Atributos
Los enum también pueden tener métodos y atributos, lo que permite asociar más información con cada constante.

```java
public enum EstadoPedido {
    PENDIENTE("Esperando aprobación"), 
    PROCESANDO("Pedido en proceso"), 
    ENVIADO("Pedido enviado al cliente"), 
    ENTREGADO("Pedido entregado al cliente");

    private String descripcion;

    // Constructor para asignar la descripción a cada estado
    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para obtener la descripción
    public String getDescripcion() {
        return descripcion;
    }
}

// Uso:
public class Main {
    public static void main(String[] args) {
        for (EstadoPedido estado : EstadoPedido.values()) {
            System.out.println(estado + ": " + estado.getDescripcion());
        }
    }
}
```
Salida
```plaintext
PENDIENTE: Esperando aprobación
PROCESANDO: Pedido en proceso
ENVIADO: Pedido enviado al cliente
ENTREGADO: Pedido entregado al cliente
```

## Métodos Útiles en los Enums
1. `values()`:

   * Devuelve un array con todos los valores del enum.

   * Útil para iterar sobre todos los valores posibles.

2. `valueOf(String name)`:

   * Convierte una cadena en el valor correspondiente del enum.

   * Lanza una excepción si la cadena no coincide exactamente con un valor del enum.

3. `ordinal()`:

   * Devuelve la posición del valor enum en la declaración. La numeración empieza en 0.

   * Útil para operaciones de clasificación o lógica basada en el orden.