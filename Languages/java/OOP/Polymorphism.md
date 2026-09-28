#OOP
# Polimorfismo
El polimorfismo es uno de los principios fundamentales de la programación orientada a objetos (OOP) y permite que un objeto pueda adoptar múltiples formas. Conceptualmente, significa que una misma acción (método) puede tener diferentes comportamientos dependiendo del contexto en el que se utilice. En Java, y en otros lenguajes orientados a objetos, se implementa a través de la sobrecarga de métodos (polimorfismo en tiempo de compilación) y la sobrescritura de métodos (polimorfismo en tiempo de ejecución).

## ¿Para Qué Sirve el Polimorfismo?
1. **Flexibilidad en el Código**: El polimorfismo permite escribir código que es flexible y fácil de extender. Esto se logra mediante el uso de clases y métodos que se pueden redefinir o comportar de manera diferente según el contexto o el tipo de objeto.

2. **Abstracción en los Procesos**: Facilita la abstracción, permitiendo que se trabaje con interfaces o clases abstractas sin preocuparse por los detalles específicos de cada implementación. Esto es útil en sistemas grandes y escalables, donde se manejan objetos complejos con múltiples comportamientos.

## ¿Qué Problema Resuelve el Polimorfismo?
1. **Problema de Rigidez en el Código**: Sin polimorfismo, cada vez que se necesita un comportamiento específico, sería necesario verificar el tipo de cada objeto y escribir código personalizado para cada tipo, lo que se vuelve poco escalable y difícil de mantener.

2. **Reducción de Condicionales**: El polimorfismo elimina la necesidad de escribir múltiples condicionales (if o switch) para diferenciar el comportamiento entre tipos de objetos. En su lugar, el mismo método invocado en diferentes instancias de objetos puede ejecutar comportamientos específicos sin agregar complejidad innecesaria.

## ¿Cómo Resuelve Estos Problemas?
1. **Sobrecarga de Métodos**: Permite que métodos en una misma clase compartan el mismo nombre pero con distintos parámetros. Esto se conoce como polimorfismo en tiempo de compilación y se usa cuando queremos que un método ejecute acciones ligeramente diferentes dependiendo del tipo y número de argumentos recibidos.

**Ejemplo de sobrecarga:**
```java
public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public double sumar(double a, double b) {
        return a + b;
    }
}
```

2. **Sobrescritura de Métodos**: Cuando una subclase redefine un método de su clase padre para darle un comportamiento específico, se habla de polimorfismo en tiempo de ejecución. Esto permite que las subclases implementen su propia versión de un método, cumpliendo con la firma del método en la clase padre, pero adaptando el comportamiento.

**Ejemplo de sobrescritura:**
```java
public class Animal {
    public void hacerSonido() {
        System.out.println("Sonido genérico de animal");
    }
}

public class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Ladrido");
    }
}

public class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Maullido");
    }
}
```
En este ejemplo, `Perro` y `Gato` sobrescriben el método `hacerSonido()` de `Animal`, permitiendo que cada subclase tenga su propio comportamiento.

## Ventajas del Polimorfismo
1. **Código Modular y Extensible**: Con el polimorfismo, el código se puede estructurar de manera modular, donde cada clase se centra en su propio comportamiento, lo que facilita la adición de nuevas funcionalidades sin alterar el código existente.

2. **Reutilización de Código**: La sobrescritura de métodos permite que las subclases reutilicen la estructura de la clase base, añadiendo o modificando solo el comportamiento necesario.

3. **Mantenimiento Simplificado**: Al reducir la cantidad de código condicional para verificar tipos, el mantenimiento es más sencillo y menos propenso a errores.

## Ejemplo de Uso del Polimorfismo en la Vida Real
Imaginemos una aplicación de pagos en la que se procesan diferentes métodos de pago: tarjeta de crédito, PayPal y criptomonedas. Con el polimorfismo, podemos definir una clase base `Pago` con un método `procesar()`. Cada tipo de pago puede sobrescribir el método `procesar()` para definir su propio flujo de procesamiento.

```java
public abstract class Pago {
    public abstract void procesar();
}

public class TarjetaCredito extends Pago {
    @Override
    public void procesar() {
        System.out.println("Procesando pago con tarjeta de crédito");
    }
}

public class PayPal extends Pago {
    @Override
    public void procesar() {
        System.out.println("Procesando pago con PayPal");
    }
}

public class Criptomoneda extends Pago {
    @Override
    public void procesar() {
        System.out.println("Procesando pago con criptomoneda");
    }
}
```
En el código cliente, podríamos procesar cualquier tipo de pago sin preocuparnos por su implementación específica:
```java
public class ProcesadorPagos {
    public void procesarPago(Pago pago) {
        pago.procesar(); // El tipo específico de `Pago` ejecutará su propia versión de `procesar()`
    }
}
```