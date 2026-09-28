#OOP
# Programación Orientada a Objetos
El Paradigma Orientado a Objetos (POO) es un modelo de programación que se basa en la creación de **objetos** para representar entidades del mundo real o conceptos abstractos. Estos objetos son instancias de **clases**, las cuales definen **atributos** (datos) y **métodos** (comportamientos o funciones). El POO organiza el software en piezas modulares y reutilizables que interactúan entre sí a través de mensajes.

## Principios fundamentales de la POO
Los pilares que sustentan la POO son cuatro:

1. **Encapsulación**: Protege los datos internos de un objeto, permitiendo el acceso solo a través de métodos públicos. Esto evita modificaciones no autorizadas y mejora la seguridad del código. 

2. **Abstracción**: Oculta los detalles complejos y expone solo las características esenciales. Permite centrarse en lo relevante, simplificando el diseño y el uso de objetos. 

3. **Herencia**: Permite que una clase (hija) herede atributos y métodos de otra clase (padre), promoviendo la reutilización del código y la creación de jerarquías lógicas (por ejemplo, un Empleado hereda de Persona). 

4. **Polimorfismo**: Facilita que un mismo método se comporte de forma distinta según el objeto que lo invoque. Esto aumenta la flexibilidad del código, permitiendo tratar objetos de distintas clases de manera uniforme. 

## ¿Para qué sirve?
El POO se utiliza para:

1. **Modelar sistemas complejos**: Permite crear estructuras de software que simulan de manera natural y comprensible las entidades y comportamientos del mundo real.

2. **Mejorar la reutilización de código**: Gracias al uso de clases y objetos, es posible crear módulos reutilizables que pueden emplearse en diferentes partes de una aplicación o en otros proyectos.

3. **Facilitar el mantenimiento y la escalabilidad**: Al organizar el software en objetos bien definidos, es más fácil modificar, extender y mantener el sistema sin introducir errores en otras partes del código.

4. **Promover el diseño modular**: Divide el sistema en componentes autónomos que interactúan de forma controlada, lo que simplifica el desarrollo y las pruebas.

## ¿Qué resuelve?
El POO aborda varios problemas comunes en el desarrollo de software, tales como:

1. **Complejidad y mantenimiento del código**: Los sistemas grandes y complejos se vuelven difíciles de mantener si están estructurados de forma monolítica. El POO ayuda a descomponer estos sistemas en piezas manejables y modulares.

2. **Reutilización de código**: Sin estructuras adecuadas, el código tiende a repetirse, lo que genera redundancia. Con el POO, se pueden reutilizar clases y objetos, evitando duplicaciones.

3. **Flexibilidad y extensibilidad**: Añadir nuevas funcionalidades a sistemas rígidos puede causar problemas. El POO facilita la extensión de funcionalidades sin romper el código existente.

4. **Acoplamiento fuerte entre componentes**: Un código acoplado dificulta las modificaciones y pruebas. El POO promueve la creación de objetos que interactúan de manera controlada, reduciendo el acoplamiento.

## ¿Cómo lo resuelve?
1. **Encapsulamiento**: Protege los datos internos de los objetos y expone solo lo necesario a través de métodos públicos. Esto mantiene la integridad de los datos y reduce el riesgo de cambios accidentales.

   * **Ejemplo**: En un sistema de pagos, una clase `PaymentProcessor` puede encapsular la lógica para procesar pagos y exponer solo métodos como `processPayment()`, ocultando los detalles internos de validación y cálculo.

2. **Abstracción**: Permite crear modelos simplificados del mundo real que ocultan detalles complejos. Se definen interfaces que describen comportamientos sin revelar cómo están implementados.

   * **Ejemplo**: Una interfaz `NotificationService` puede definir un método `sendNotification()`. Clases concretas como `EmailService` o `SMSService` implementan ese método de diferentes maneras.

3. **Herencia**: Permite que las clases hijas hereden atributos y métodos de una clase padre, facilitando la reutilización y extensión del código.

   * **Ejemplo**: En un sistema de recursos humanos, se puede tener una clase `Employee` con propiedades comunes (nombre, ID) y subclases como `Manager` o `Intern`, que heredan de `Employee` y agregan comportamientos específicos.

4. **Polimorfismo**: Permite que los objetos se comporten de diferentes maneras según su tipo real. Esto facilita el uso de interfaces y permite cambiar implementaciones sin modificar el código que las usa.

   * **Ejemplo**: Una función que recibe un `NotificationService` puede trabajar con `EmailService`, `SMSService` o cualquier otro servicio que implemente esa interfaz, sin necesidad de conocer los detalles de implementación.

---

[](Encapsulation.md)
[](Abstraction.md)
[](Inheritance.md)
[](Polymorphism.md)