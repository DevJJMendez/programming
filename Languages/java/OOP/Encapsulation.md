#OOP
# Encapsulamiento
Es un principio del Paradigma Orientado a Objetos que consiste en agrupar **datos (atributos)** y **comportamientos (métodos)** relacionados dentro de una misma unidad llamada **clase**. Además, controla el acceso a los datos para que solo se puedan modificar o consultar a través de métodos específicos, llamados métodos de acceso o getters y setters.

En términos simples, el encapsulamiento actúa como una **caja negra**: oculta los detalles internos de cómo funciona un objeto, exponiendo solo lo necesario para interactuar con él.

## ¿Para qué sirve?
El encapsulamiento sirve para:

1. **Proteger la integridad de los datos**: Evita el acceso directo a los atributos, asegurando que solo puedan ser modificados de manera controlada a través de métodos específicos.

2. **Simplificar el uso de las clases**: Al ocultar los detalles internos, los usuarios de una clase no necesitan conocer cómo funciona internamente para utilizarla.

3. **Facilitar el mantenimiento del código**: Al separar la interfaz pública (métodos) de la implementación interna (atributos y métodos privados), se puede modificar la lógica interna sin afectar a los componentes externos que dependen de ella.

4. **Reducir el acoplamiento**: Minimiza las dependencias directas entre diferentes partes del código, lo que hace que el sistema sea más modular y fácil de cambiar.

## ¿Qué resuelve?
El encapsulamiento resuelve varios problemas comunes en el desarrollo de software, como:

1. **Modificaciones accidentales de datos**: Sin encapsulamiento, los atributos de una clase pueden ser alterados desde cualquier lugar del código, lo que puede causar errores inesperados y difíciles de detectar. El encapsulamiento limita el acceso a los datos, evitando que se modifiquen de manera no controlada.

2. **Dificultad para cambiar la implementación interna**: Si el acceso a los datos es directo, cualquier cambio en la estructura interna de la clase afectará a todas las partes del código que interactúan con ella. El encapsulamiento permite cambiar la lógica interna sin romper el código externo que utiliza la clase.

3. **Falta de control sobre cómo se usan los datos**: Sin métodos de acceso específicos, no hay forma de validar los datos antes de asignarlos a los atributos. El encapsulamiento permite definir reglas de validación para asegurar que los datos sean consistentes.

## ¿Cómo lo resuelve?
1. **Ocultando los atributos**: Los atributos de una clase se declaran como `private` o `protected`, lo que impide que se acceda a ellos directamente desde fuera de la clase. Esto asegura que el estado interno de un objeto esté protegido.

**Ejemplo**
```java
public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
    }
}
```
En este ejemplo, el atributo balance es `private`, por lo que solo puede ser accedido a través de los métodos `getBalance`, `deposit`, y `withdraw`, lo que protege la integridad del saldo y permite validaciones antes de modificarlo.

2. **Exponiendo una interfaz pública (métodos)**: Los métodos de la clase sirven como la única forma de interactuar con los atributos internos. Estos métodos pueden incluir reglas de negocio y validaciones para asegurar que el estado del objeto siempre sea válido.

   * **Ejemplo**: En la clase anterior, el método `deposit` verifica que el monto sea mayor que cero antes de añadirlo al `balance`, y el método `withdraw` asegura que no se retire más de lo que hay disponible.

3. **Separando la interfaz de la implementación**: Los usuarios de la clase interactúan solo con la interfaz pública (métodos), y no necesitan saber cómo están implementados los atributos o las reglas internas. Esto facilita la evolución del software. Puedes cambiar la implementación interna sin necesidad de modificar el código que usa la clase.

   * **Ejemplo**: Si decides cambiar la forma en que se almacena el `balance` (quizás en una base de datos en lugar de en memoria), puedes hacerlo sin afectar a ningún otro código que use la clase `BankAccount`, siempre que la interfaz pública no cambie.

**Conclusión**: El encapsulamiento es esencial para la seguridad, mantenibilidad y modularidad del software. Al proteger los datos internos y definir una interfaz controlada para interactuar con ellos, se asegura que los objetos mantengan un estado coherente y que el sistema sea más fácil de entender, modificar y extender.