# Clases
Una clase es un concepto fundamental en el Paradigma Orientado a Objetos (POO). Es una estructura que define un molde o plantilla para crear objetos. Dentro de una clase se especifican las propiedades (atributos o campos) y comportamientos (métodos o funciones) que tendrán los objetos que se creen a partir de ella.

Una clase actúa como una abstracción que describe las características y funcionalidades de un concepto real o lógico. Por ejemplo, una clase Cliente puede representar a un cliente en un sistema de ventas, definiendo atributos como nombre, email, dirección, y métodos como `registrarCompra()`, `actualizarDatos()`.

## ¿Para Qué Sirve una Clase?
1. **Agrupar datos y comportamientos**: Permite encapsular atributos y métodos que están relacionados entre sí. Por ejemplo, en una clase CuentaBancaria, todos los datos como el saldo y el número de cuenta, y comportamientos como depositar y retirar, se agrupan en un solo lugar.

2. **Facilitar la creación de objetos**: Al definir una clase, se puede crear múltiples instancias (objetos) que comparten la misma estructura y comportamiento, pero tienen datos específicos propios.

3. **Definir la estructura del software**: Las clases permiten organizar el código de forma modular, facilitando el mantenimiento y la extensibilidad del software. Cada clase tiene una responsabilidad clara, lo que sigue el principio de Responsabilidad Única (S de SOLID).

## ¿Qué Resuelve una Clase?
1. **Reutilización del código**: Las clases permiten definir una estructura de datos y comportamiento que se puede reutilizar para crear múltiples instancias. En lugar de duplicar código, se puede definir una clase una vez y crear varios objetos a partir de ella.

2. **Organización del código**: En aplicaciones grandes, el código puede volverse complejo y difícil de manejar. Las clases ayudan a organizar el código en módulos lógicos que reflejan entidades del mundo real, lo que hace que el software sea más comprensible.

3. **Encapsulamiento**: Las clases proporcionan una forma de agrupar atributos y métodos, protegiendo los datos y exponiendo solo lo que es necesario a través de métodos públicos. Esto reduce la complejidad y el riesgo de errores.

## ¿Cómo lo Resuelve?
Las clases resuelven estos problemas a través de:

1. **Definición de atributos y métodos**: Los atributos representan el estado de un objeto y los métodos definen su comportamiento. Por ejemplo:

```java
public class Cliente {
    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public void actualizarEmail(String nuevoEmail) {
        this.email = nuevoEmail;
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
```
Aquí, la clase `Cliente` tiene atributos `nombre` y `email`, y métodos para actualizar el `email` y obtener el `nombre`.

2. **Instanciación de objetos**: Una vez definida una clase, se pueden crear múltiples objetos a partir de ella:
   
```java
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan Perez", "juan@example.com");
        Cliente cliente2 = new Cliente("Maria Gomez", "maria@example.com");

        System.out.println(cliente1.obtenerNombre()); // Output: Juan Perez
        cliente2.actualizarEmail("mariagomez@example.com");
    }
}
```