# Getters and Setters
son métodos que se utilizan en Java (y en otros lenguajes de programación orientados a objetos) para acceder y modificar los valores de los atributos privados de una clase. Estos métodos permiten el control sobre cómo se accede y modifica el estado interno de un objeto, promoviendo la encapsulación y manteniendo la integridad de los datos.

## ¿Qué son los Getters y Setters?

* **Getters**: También llamados métodos de acceso. Son métodos públicos que permiten obtener el valor de un atributo privado de una clase.

* **Setters**: También llamados métodos de modificación. Son métodos públicos que permiten establecer o modificar el valor de un atributo privado de una clase.

## Getters
Un getter es un método que se utiliza para **obtener el valor** de un atributo privado o protegido de una clase. En la programación orientada a objetos, se siguen las buenas prácticas de **encapsulamiento**, lo que significa que los atributos de una clase suelen declararse como `private` para protegerlos del acceso directo desde fuera de la clase. El getter permite acceder a estos atributos de una manera controlada y segura.

**Ejemplo**
```java
public class Empleado {
    private String nombre;
    private double salario;

    // Constructor
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    // Getter para el atributo nombre
    public String getNombre() {
        return nombre;
    }

    // Getter para el atributo salario
    public double getSalario() {
        return salario;
    }
}
```

## ¿Para Qué Sirve un Getter?
1. **Acceso Controlado a Atributos**: Un getter permite acceder al valor de un atributo sin permitir que se modifique directamente. Esto protege el estado interno del objeto y sigue el principio de encapsulamiento.

2. **Aplicar Lógica Adicional al Obtener un Valor**: Un getter puede incluir lógica adicional antes de devolver un valor, como calcular algo sobre la marcha, validar el estado, o incluso registrar accesos para auditoría.

3. **Proveer una Interfaz Consistente**: Los getters proporcionan una interfaz estándar y consistente para obtener los valores de los atributos, lo que facilita la extensión o modificación de la clase sin afectar al resto del código que la utiliza.

## ¿Qué Problemas Resuelve un Getter?
1. **Evita el Acceso Directo a Atributos**: Si los atributos fueran accesibles directamente, el código externo podría modificar el estado de un objeto de forma impredecible, creando posibles errores o comportamientos inesperados. Los getters permiten controlar qué partes del estado del objeto pueden exponerse.

2. **Permite Modificaciones sin Romper el Código Existente**: Al exponer un método en lugar de un atributo directamente, es posible cambiar la implementación interna de la clase sin afectar a las clases que dependen de ella. Esto mejora la mantenibilidad y extensibilidad del código.

3. **Sigue las Buenas Prácticas de Encapsulamiento**: Mantener los atributos privados y usar getters es una buena práctica de diseño en la programación orientada a objetos, lo que ayuda a asegurar que los objetos se comporten de manera predecible y segura.

## ¿Cómo Resuelve Estos Problemas?
1. **Mediante el Uso de Métodos Públicos para Acceder a Atributos Privados**: Al declarar los atributos como `private`, aseguras que solo se puedan modificar o acceder a través de métodos públicos controlados. El getter actúa como una puerta de acceso para obtener el valor del atributo.

**Ejemplo**
```java
Empleado empleado = new Empleado("Carlos", 3000);
System.out.println(empleado.getNombre()); // Carlos
```

2. **Permitiendo Lógica Adicional en el Proceso de Lectura**: Si necesitas realizar alguna operación antes de devolver el valor del atributo, puedes hacerlo en el getter. Por ejemplo, podrías formatear un valor, realizar un cálculo, o validar algún estado antes de devolverlo.

**Ejemplo**
```java
public class Producto {
    private double precio;

    public Producto(double precio) {
        this.precio = precio;
    }

    // Getter con lógica adicional
    public double getPrecioConIVA() {
        return precio * 1.21; // Aplicando IVA del 21%
    }
}

Producto laptop = new Producto(1000);
System.out.println(laptop.getPrecioConIVA()); // 1210.0
```

3. **Facilitando el Mantenimiento del Código**: Imagina que decides cambiar cómo se almacena o se calcula el salario de un empleado en el futuro. Si expusieras el atributo salario directamente, tendrías que cambiar muchas partes del código. Con un getter, puedes cambiar la implementación del método `getSalario()` sin afectar al resto del sistema.

## Consideraciones Adicionales
1. **Nomenclatura**: Por convención, los getters en Java comienzan con `get` seguido del nombre del atributo con la primera letra en mayúscula. Esto forma parte de las naming conventions que ayudan a que el código sea intuitivo y fácil de entender.

2. **Compatibilidad con Librerías y Frameworks**: Muchos frameworks (como Hibernate y Spring) dependen de los getters y setters para funcionar correctamente. Esto se debe a que utilizan `reflexión` para acceder a los atributos de las clases y requieren que los métodos sigan la convención de nombres estándar.

3. **Getters Innecesarios**: En algunos casos, exponer todos los atributos a través de getters puede ser innecesario. Si un atributo no necesita ser accesible desde fuera de la clase, es mejor no crear un getter para él, manteniendo el encapsulamiento y evitando la sobreexposición del estado interno.