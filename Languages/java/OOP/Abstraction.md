#OOP
# Abstracción
La abstracción es un principio del Paradigma Orientado a Objetos que se refiere a la capacidad de representar conceptos complejos de manera simplificada, enfocándose solo en los detalles esenciales y ocultando los innecesarios. En el contexto del desarrollo de software, la abstracción implica crear modelos que capturan los aspectos importantes de una entidad o proceso, mientras ocultan los detalles internos que no son relevantes para el uso general.

En términos más simples, la abstracción te permite diseñar una visión general de un sistema o componente, exponiendo solo lo que se necesita para interactuar con él y ocultando los detalles de su implementación interna.

## ¿Para qué sirve?
La abstracción sirve para:

1. **Reducir la complejidad**: Al centrarse solo en los aspectos importantes, los desarrolladores pueden entender y trabajar con componentes sin tener que conocer todos los detalles internos.

2. **Facilitar la reutilización**: Al crear modelos abstractos, los componentes pueden ser diseñados para ser reutilizables en diferentes contextos.

3. **Permitir la extensibilidad**: Las clases abstractas e interfaces permiten a los desarrolladores extender el comportamiento sin modificar el código existente, facilitando la adición de nuevas funcionalidades.

4. **Crear diseños más claros y mantenibles**: La abstracción ayuda a separar los conceptos de alto nivel de los detalles específicos, lo que hace que el código sea más fácil de leer y mantener.

## ¿Qué resuelve?
La abstracción resuelve varios problemas en el diseño de software, como:

1. **Complejidad excesiva**: En sistemas complejos, puede ser difícil entender cómo interactúan todos los componentes si cada uno de ellos expone demasiados detalles. La abstracción ayuda a simplificar la interacción entre los componentes, exponiendo solo los métodos y atributos necesarios.

2. **Dificultad para cambiar la implementación**: Si los detalles de implementación están expuestos, cualquier cambio en la lógica interna puede afectar a múltiples partes del sistema. La abstracción oculta estos detalles, permitiendo que los cambios se realicen sin afectar a otros componentes.

3. **Falta de consistencia**: Sin una abstracción adecuada, diferentes partes del código podrían implementar la misma funcionalidad de diferentes maneras. La abstracción permite definir contratos claros (a través de interfaces y clases abstractas) para garantizar que todos los componentes sigan el mismo comportamiento.

4. **Dificultad para extender funcionalidades**: Sin abstracción, añadir nuevas funcionalidades puede requerir modificar partes significativas del código existente. Con una abstracción bien diseñada, se pueden añadir nuevos comportamientos mediante la extensión de clases o la implementación de interfaces, sin alterar el código base.

## ¿Cómo lo resuelve?
1. **Mediante `clases abstractas` e `interfaces`**: Las clases abstractas y interfaces son herramientas clave para la abstracción en POO. Permiten definir comportamientos generales sin especificar cómo se implementan. Las clases concretas pueden luego extender estas clases abstractas o implementar las interfaces, proporcionando su propia versión de los métodos.

Ejemplo:
```java
public interface PaymentMethod {
    void processPayment(double amount);
}

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Lógica específica para procesar el pago con tarjeta de crédito
        System.out.println("Processing credit card payment of $" + amount);
    }
}

public class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Lógica específica para procesar el pago con PayPal
        System.out.println("Processing PayPal payment of $" + amount);
    }
}
```
En este ejemplo, la interfaz `PaymentMethod` define un método `processPayment` que representa el concepto general de procesar pagos. Las clases `CreditCardPayment` y `PayPalPayment` implementan esta interfaz con sus propias lógicas específicas. Esto permite que el sistema trabaje con cualquier tipo de PaymentMethod sin preocuparse por los detalles de implementación.

2. **Ocultando la implementación interna**: La abstracción separa la interfaz (qué hace un objeto) de la implementación (cómo lo hace). Esto permite que los desarrolladores cambien o mejoren la implementación sin afectar a otros componentes que usan la clase o interfaz.

   * **Ejemplo**: Supongamos que en el futuro, PayPalPayment necesita autenticar al usuario antes de procesar el pago. Podrías cambiar la implementación interna del método processPayment sin necesidad de modificar ninguna otra parte del código que usa PayPalPayment, siempre y cuando la interfaz siga siendo la misma.

3. **Creando contratos claros**: Las interfaces y clases abstractas actúan como contratos que las clases concretas deben cumplir. Esto garantiza consistencia y facilita la colaboración entre diferentes partes del equipo de desarrollo.

   * **Ejemplo**: Si tienes una interfaz `NotificationService` con un método `sendNotification`, puedes estar seguro de que cualquier clase que implemente esta interfaz (`EmailNotification`, `SMSNotification`, etc.) proporcionará una forma de enviar notificaciones, aunque las implementaciones específicas sean diferentes.

4. **Simplificando la interacción entre componentes**: La abstracción permite a los desarrolladores trabajar con componentes a un nivel más alto sin tener que preocuparse por los detalles internos. Esto hace que el código sea más fácil de entender y de trabajar.

   * **Ejemplo**: En lugar de preocuparse por cómo se procesa un pago en específico, una clase `Order` podría simplemente llamar al método `processPayment` de una instancia de `PaymentMethod`, y dejar que el objeto específico (tarjeta de crédito, PayPal, etc.) se encargue del resto.

**Conclusión**: La abstracción es fundamental para diseñar sistemas modulares, reutilizables y mantenibles. Al centrarse en lo que hace un componente, en lugar de cómo lo hace, se reduce la complejidad y se mejora la flexibilidad del sistema. Esto facilita el mantenimiento, la extensión y la comprensión del software a lo largo de su ciclo de vida.