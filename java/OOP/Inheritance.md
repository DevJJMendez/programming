#OOP
# Herencia
La herencia es un principio fundamental del Paradigma Orientado a Objetos que permite crear nuevas clases a partir de clases existentes. Una clase nueva, llamada clase hija o subclase, hereda atributos y métodos de otra clase, llamada clase padre o superclase. Esto permite que la subclase reutilice el código de la superclase, mientras puede añadir nuevos comportamientos o modificar los existentes.

La herencia es una forma de establecer relaciones de tipo "es-un" (is-a) entre clases, lo que significa que la subclase es una forma especializada de la superclase. Por ejemplo, si tienes una clase Employee, puedes crear una subclase Manager que herede todas las características de Employee pero añada atributos o comportamientos específicos para un gerente.

## ¿Para qué sirve?
La herencia sirve para:

1. **Reutilización de código**: Permite que las subclases reutilicen atributos y métodos de las superclases, lo que evita la duplicación de código y mejora la eficiencia del desarrollo.

2. **Facilitar la extensión y la evolución del software**: Las subclases pueden extender o modificar el comportamiento de las superclases sin alterar el código original, lo que facilita la adición de nuevas funcionalidades.

3. **Modelar relaciones jerárquicas**: Se utiliza para definir jerarquías en las que las subclases representan tipos más específicos de las superclases, ayudando a organizar y estructurar el código de manera lógica y coherente.

4. **Polimorfismo**: La herencia facilita el polimorfismo, que permite tratar objetos de diferentes subclases como si fueran instancias de su superclase, simplificando el manejo de diferentes tipos de objetos en el código.

## ¿Qué resuelve?
La herencia resuelve varios problemas en el diseño de software, como:

1. **Duplicación de código**: Sin herencia, tendrías que repetir los mismos atributos y métodos en múltiples clases, lo que hace que el código sea más difícil de mantener y propenso a errores. La herencia permite reutilizar el código común en una superclase.

2. **Rigidez para añadir nuevas funcionalidades**: En sistemas grandes, añadir nuevas características puede requerir muchos cambios si no se ha estructurado bien el código. Con la herencia, puedes añadir o modificar comportamientos en subclases sin afectar el código existente.

3. **Dificultad para manejar diferentes tipos de objetos**: Si necesitas trabajar con diferentes tipos de objetos que comparten comportamientos similares, la herencia facilita la manipulación de estos objetos al permitir que todos hereden de una misma superclase.

## ¿Cómo lo resuelve?
1. **Compartiendo código común a través de la superclase**: Los atributos y métodos definidos en la superclase están disponibles automáticamente para todas las subclases, lo que significa que puedes escribir el código común una sola vez y reutilizarlo en diferentes subclases.

Ejemplo:
```java
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + " is working.");
    }

    public double getSalary() {
        return salary;
    }
}

public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    public void conductMeeting() {
        System.out.println("Conducting a meeting with " + teamSize + " team members.");
    }
}
```
En este ejemplo, la clase `Manager` hereda de `Employee`, lo que significa que puede usar los atributos `name` y `salary`, así como los métodos `work()` y `getSalary()` sin necesidad de reescribirlos. Además, `Manager` puede añadir su propio comportamiento (`conductMeeting()`).

2. **Permitiendo la especialización de clases**: Las subclases pueden añadir nuevos atributos o métodos, o sobrescribir los métodos de la superclase para adaptar o extender el comportamiento.

   * **Ejemplo**: La clase Manager en el ejemplo anterior puede tener su propio método `conductMeeting()`, que no existe en la superclase Employee. También puede sobrescribir el método `work()` si se desea cambiar cómo los gerentes trabajan en comparación con otros empleados.

3. **Facilitando el polimorfismo**: La herencia permite usar un tipo base para referirse a objetos de las subclases. Esto hace que el código sea más flexible y extensible porque puedes tratar diferentes tipos de objetos de manera uniforme.

Ejemplo:
```java
public class Company {
    public void assignTask(Employee employee) {
        employee.work();
    }
}

public static void main(String[] args) {
    Employee emp = new Employee("Alice", 3000);
    Manager mgr = new Manager("Bob", 5000, 10);

    Company company = new Company();
    company.assignTask(emp); // Output: Alice is working.
    company.assignTask(mgr); // Output: Bob is working.
}
```
En este caso, el método `assignTask` puede recibir tanto objetos `Employee` como `Manager`, y tratar a ambos como instancias de la clase `Employee`. Esto demuestra el polimorfismo, que es posible gracias a la herencia.

4. **Organizando jerarquías de clases**: La herencia permite que las clases sigan una estructura de jerarquía, lo que facilita la comprensión y la organización del código. Puedes tener clases generales en la parte superior de la jerarquía y clases más especializadas en los niveles inferiores, lo que ayuda a reflejar relaciones del mundo real en el diseño del software.

Ejemplo: Una jerarquía común en una aplicación empresarial podría ser:
```plaintext
Person
├── Employee
│   ├── Developer
│   └── Manager
└── Customer
```
Esta estructura permite que todos los empleados (Developer, Manager) compartan atributos comunes definidos en Employee, que a su vez hereda de Person. Esto facilita la extensión del sistema si en el futuro se desea añadir nuevas clases como Intern, Consultant, etc.

**Conclusión**: La herencia es una herramienta poderosa para la reutilización de código, la organización lógica y la extensibilidad de las aplicaciones. Permite que las subclases utilicen y amplíen el comportamiento de las superclases, facilitando la construcción de sistemas complejos y bien estructurados. Sin embargo, es importante usarla con cuidado para evitar una jerarquía de clases demasiado profunda que pueda hacer que el sistema sea rígido y difícil de mantener.

## Composición vs. Herencia
Aunque la herencia es un pilar del Paradigma Orientado a Objetos (POO), tiene algunas limitaciones que han llevado a muchos desarrolladores a preferir la composición.

**¿Qué es la Composición?**: La composición es un principio de diseño que consiste en crear objetos complejos a partir de la combinación de objetos más simples. En lugar de definir nuevas clases a partir de clases existentes (como en la herencia), en la composición las clases contienen instancias de otras clases como atributos y delegan tareas a estos objetos.

La idea clave es que un objeto se compone de uno o más objetos que actúan como componentes, y el comportamiento general del objeto compuesto se logra a través de la colaboración entre estos componentes.

**¿Para qué sirve la Composición?**
1. **Reutilización de código sin restricciones jerárquicas**: Permite reutilizar código sin necesidad de crear una relación jerárquica estricta (como en la herencia). En lugar de decir que un objeto **"es-un" (is-a)** tipo de otro, la composición permite decir que un objeto **"tiene-un" (has-a)** otro tipo.

2. **Mayor flexibilidad y modularidad**: Permite crear componentes intercambiables y modificar el comportamiento de un objeto compuesto agregando, reemplazando o modificando sus componentes sin afectar su estructura general.

3. **Facilitar el mantenimiento y la extensibilidad**: Como los componentes se pueden modificar sin alterar la estructura del objeto principal, es más fácil hacer cambios y extender funcionalidades.

**¿Qué resuelve?**
1. **Limitaciones de la herencia múltiple**: En lenguajes como Java, una clase solo puede heredar de una única superclase, lo que puede ser una limitación si necesitas combinar comportamientos de múltiples fuentes. La composición no tiene esta restricción, ya que un objeto puede tener referencias a múltiples objetos que le proporcionan diferentes funcionalidades.

2. **Problemas de rigidez en la jerarquía**: Las jerarquías profundas de herencia pueden hacer que el sistema sea más difícil de mantener y extender. Cada cambio en una superclase puede afectar a todas sus subclases, lo que introduce riesgo de errores. La composición permite crear sistemas más modulares que son más fáciles de modificar.

3. **Acoplamiento excesivo**: La herencia crea un fuerte acoplamiento entre la subclase y la superclase, lo que significa que cambios en la superclase pueden forzar cambios en todas las subclases. La composición, al separar el comportamiento en componentes individuales, reduce este acoplamiento.

**¿Cómo lo resuelve?**: La composición resuelve estos problemas al permitir que las clases deleguen tareas a otros objetos en lugar de heredar comportamientos de una superclase. De esta manera, se evita la necesidad de crear una relación jerárquica y se puede combinar el comportamiento de múltiples clases de manera flexible.

**Ejemplo: Sistema de Notificaciones**: Imagina que estamos desarrollando un sistema que envía notificaciones a los usuarios, y queremos soportar diferentes métodos de envío: email, SMS, y notificaciones push.

* **Enfoque con Herencia**
```java
public class Notification {
    public void send() {
        // Default sending method
    }
}

public class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending email notification...");
    }
}

public class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS notification...");
    }
}

public class PushNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending push notification...");
    }
}
```
En este ejemplo, si necesitas agregar un nuevo método de **notificación**, tendrías que crear una nueva subclase. Además, si `Notification` tiene algún cambio en su lógica, todas las subclases podrían verse afectadas.

* **Enfoque con Composición**
```java
public interface NotificationSender {
    void send();
}

public class EmailSender implements NotificationSender {
    @Override
    public void send() {
        System.out.println("Sending email notification...");
    }
}

public class SMSSender implements NotificationSender {
    @Override
    public void send() {
        System.out.println("Sending SMS notification...");
    }
}

public class PushSender implements NotificationSender {
    @Override
    public void send() {
        System.out.println("Sending push notification...");
    }
}

public class Notification {
    private NotificationSender sender;

    public Notification(NotificationSender sender) {
        this.sender = sender;
    }

    public void send() {
        sender.send();
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Notification emailNotification = new Notification(new EmailSender());
        Notification smsNotification = new Notification(new SMSSender());

        emailNotification.send(); // Output: Sending email notification...
        smsNotification.send();   // Output: Sending SMS notification...
    }
}
```
**Ventajas del Enfoque de Composición:**
1. **Modularidad**: Puedes intercambiar el comportamiento en tiempo de ejecución simplemente cambiando el objeto NotificationSender. Esto no es posible con la herencia, donde el comportamiento se define en tiempo de compilación.

2. **Facilidad para añadir nuevas funcionalidades**: Si deseas añadir un nuevo tipo de notificación, solo necesitas crear una nueva clase que implemente NotificationSender y no modificar la jerarquía de clases existente.

3. **Desacoplamiento**: El objeto Notification no necesita saber cómo se envía el mensaje; simplemente delega la tarea al NotificationSender. Esto hace que el sistema sea menos propenso a errores cuando se realizan cambios en los detalles de la implementación.

## ¿Por Qué la Composición es Preferible Hoy en Día?
1. **Cumple con el principio SOLID de "Composición sobre herencia"**: El Principio de Sustitución de Liskov (L de SOLID) y el Principio de Segregación de Interfaces (I de SOLID) suelen guiar el uso de composición, ya que permiten crear sistemas más adaptables y fáciles de modificar.

2. **Evita el acoplamiento fuerte**: Con la herencia, las subclases están acopladas estrechamente a las superclases, lo que hace que los cambios en la superclase puedan tener efectos adversos en todas las subclases. La composición reduce este problema al limitar el acoplamiento a través de interfaces bien definidas.

3. **Más alineado con el desarrollo ágil y la necesidad de cambio rápido**: Las aplicaciones modernas suelen requerir cambios rápidos y la integración de nuevas funcionalidades sin afectar el sistema existente. La composición facilita esto al permitir reemplazar o agregar comportamientos dinámicamente.