# Métodos
En programación orientada a objetos (POO), un método es una función que está definida dentro de una clase. Los métodos representan **comportamientos** o **acciones** que los objetos de esa clase pueden realizar. Un método puede ser usado para modificar el estado de un objeto, realizar cálculos, procesar datos o simplemente ejecutar una acción específica.

**Ejemplo Conceptual**: Imagina una clase llamada `Cliente` en un sistema de **ecommerce**. Un cliente puede realizar acciones como **"hacer una compra"**, **"actualizar su información personal"**, **"ver el historial de pedidos"**, etc. Estas acciones se implementan como métodos en la clase `Cliente`.

## ¿Para Qué Sirven los Métodos?
1. **Definir Comportamiento de los Objetos**: Los métodos permiten definir qué acciones puede llevar a cabo un objeto. Por ejemplo, un objeto de tipo CuentaBancaria podría tener métodos como depositar, retirar, consultarSaldo, etc.

2. **Encapsular Lógica y Reutilización de Código**: Los métodos encapsulan lógica que se puede reutilizar en distintas partes del programa, evitando la duplicación de código. Por ejemplo, si necesitas calcular el impuesto sobre las ventas, puedes definir un método que realice ese cálculo y llamarlo desde diferentes partes del programa.

3. **Interactuar con los Atributos del Objeto**: Los métodos pueden acceder y modificar los atributos de un objeto, permitiendo que el objeto cambie su estado de manera controlada.

## ¿Qué Problemas Resuelven los Métodos?
1. **Modularidad**: Al dividir el comportamiento de una clase en métodos más pequeños y específicos, el código se vuelve más modular. Esto significa que cada método tiene una responsabilidad clara, lo que facilita su comprensión, mantenimiento y reutilización.

2. **Reutilización y Mantenibilidad**: Si cierta lógica se necesita en varios lugares, puedes encapsularla en un método y llamarlo donde sea necesario. Esto mejora la reutilización y facilita el mantenimiento, ya que los cambios solo deben hacerse en un lugar.

3. **Abstracción**: Los métodos ayudan a ocultar los detalles internos de cómo se implementa una acción. Cuando llamas a un método, no necesitas saber cómo funciona internamente, solo necesitas saber qué hace. Esto permite trabajar con abstracciones y reduce la complejidad.

## ¿Cómo Resuelven Estos Problemas?
1. **Dividiendo el Código en Unidades más Pequeñas y Específicas**: Los métodos ayudan a dividir el código en unidades más pequeñas, cada una con una responsabilidad específica. Esto hace que el código sea más limpio y fácil de leer.

2. **Facilitando la Modificación del Comportamiento**: Si necesitas cambiar la lógica de una acción, puedes hacerlo directamente en el método correspondiente, sin tener que buscar en todo el código. Esto hace que el sistema sea más fácil de mantener.

3. **Interacción Controlada con el Estado del Objeto**: Los métodos proporcionan formas seguras y controladas de modificar los atributos del objeto. Por ejemplo, en lugar de cambiar directamente un atributo, se puede usar un método que incluya validaciones o reglas de negocio.

## Tipos de Métodos en Java
1. **Métodos de Instancia**: Estos métodos se llaman sobre una instancia específica de una clase. Pueden acceder y modificar los atributos de esa instancia.

```java
public class Empleado {
    private String nombre;
    private double salario;

    public void incrementarSalario(double porcentaje) {
        salario += salario * (porcentaje / 100);
    }
}
```

2. **Métodos Estáticos**: Se llaman a nivel de clase y no requieren una instancia para ser usados. Los métodos estáticos no pueden acceder directamente a los atributos de instancia.

```java
public class Utilidades {
    public static double calcularDescuento(double precio, double porcentaje) {
        return precio - (precio * (porcentaje / 100));
    }
}
```
`calcularDescuento` es un método estático que se puede llamar sin crear un objeto `Utilidades: Utilidades.calcularDescuento(100, 10);`

3. **Métodos Privados**: Se utilizan dentro de la clase y no son accesibles desde fuera. Sirven para encapsular lógica que solo debe ser visible dentro de la clase.

```java
public class Procesador {
    public void procesar() {
        if (validar()) {
            ejecutarProceso();
        }
    }

    private boolean validar() {
        // lógica de validación
        return true;
    }

    private void ejecutarProceso() {
        // lógica del proceso
    }
}
```

4. **Métodos Final**: No pueden ser sobreescritos por clases que hereden de la clase donde están definidos.

```java
public class Configuracion {
    public final void cargarConfiguracion() {
        // Lógica para cargar la configuración
    }
}
```

## Conclusión
Los métodos son fundamentales en la programación orientada a objetos, ya que definen el comportamiento de los objetos y permiten la modularidad, reutilización y mantenibilidad del código. Ayudan a encapsular la lógica, facilitan la interacción con los atributos de los objetos y permiten que el código sea más limpio y legible.

Es importante seguir buenas prácticas, como dar nombres claros y específicos a los métodos, mantener su responsabilidad limitada (haciendo una sola cosa) y usar métodos privados para encapsular detalles internos que no deben ser accesibles desde fuera de la clase.