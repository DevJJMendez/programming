# Metodos Estáticos
Los métodos estáticos son métodos que pertenecen a la clase en sí misma en lugar de a las instancias (objetos) de la clase. Esto significa que un método estático puede ser llamado sin necesidad de crear un objeto de la clase. En Java, los métodos estáticos se declaran usando la palabra clave `static`.

## ¿Para Qué Sirven?
1. **Ejecutar Comportamientos Comunes Sin Crear Objetos**: Los métodos estáticos permiten ejecutar acciones que no dependen de los datos específicos de un objeto. Por ejemplo, operaciones matemáticas, validaciones generales, o tareas utilitarias.

2. **Acceder y Manipular Atributos Estáticos**: Los métodos estáticos pueden ser usados para acceder o modificar atributos estáticos de la clase, proporcionando una forma de gestionar estados compartidos.

## ¿Qué Problema Resuelven?
1. **Problema: Necesidad de Comportamientos Comunes sin Instanciar Objetos**: En ocasiones, se requiere realizar operaciones que son independientes de los datos de cualquier instancia particular. Crear instancias solo para acceder a esos métodos sería ineficiente. Los métodos estáticos permiten que tales operaciones sean accesibles directamente.

2. **Problema: Organización de Código Reutilizable y Modular**: Los métodos estáticos pueden agrupar funcionalidades comunes (por ejemplo, operaciones matemáticas) en clases de utilidad, facilitando la reutilización del código sin necesidad de crear múltiples objetos.

## ¿Cómo Lo Resuelven?
1. **Llamada Directa a Través de la Clase**: Los métodos estáticos pueden ser llamados directamente usando el nombre de la clase (`Clase.metodoEstatico()`), haciendo que el acceso a esas funciones sea rápido y directo.

2. **Ejecución de Operaciones que No Dependan de Datos de Instancia**: Como los métodos estáticos no dependen de atributos no estáticos, pueden ejecutarse sin la necesidad de información específica de un objeto, permitiendo que realicen tareas generales sin instanciar clases.

**Ejemplo básico de Métodos Estáticos**
```java
public class Calculadora {
    // Método estático para sumar dos números
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Método estático para restar dos números
    public static int restar(int a, int b) {
        return a - b;
    }
}

// Uso en el programa principal
public class Main {
    public static void main(String[] args) {
        // Llamar a métodos estáticos sin crear un objeto de la clase Calculadora
        int resultadoSuma = Calculadora.sumar(5, 3);
        int resultadoResta = Calculadora.restar(10, 4);

        System.out.println("Suma: " + resultadoSuma);   // Salida: Suma: 8
        System.out.println("Resta: " + resultadoResta); // Salida: Resta: 6
    }
}
```

## Detalles Importantes Sobre Métodos Estáticos
1. **No Pueden Acceder a Atributos No Estáticos Directamente**:

   * Los métodos estáticos no pueden acceder directamente a atributos o métodos no estáticos de la clase. Esto es porque los atributos y métodos no estáticos pertenecen a instancias, y un método estático no tiene información sobre ninguna instancia en particular.

   * Para acceder a atributos o métodos no estáticos, primero se debe crear una instancia de la clase.

2. **No Se Pueden Sobrescribir (`Override`)**:

   * Los métodos estáticos no se pueden sobrescribir en subclases. Aunque puedes declarar un método estático con el mismo nombre en una subclase, esto se conoce como ocultación (hiding), no sobrescritura.

3. **Pueden Ser Usados Como Puntos de Entrada en Aplicaciones**:

   * El método `main` en Java es un método estático, y sirve como el punto de entrada para todas las aplicaciones Java. Es estático porque debe ser ejecutado sin instanciar la clase.

## Diferencias con Métodos No Estáticos
1. **Contexto de Ejecución**: Un método estático no tiene un `this`, porque no está vinculado a una instancia en particular. Los métodos no estáticos sí tienen acceso a `this`, lo que les permite manipular los atributos de la instancia específica.

2. **Flexibilidad**: Los métodos no estáticos pueden acceder tanto a atributos no estáticos como a atributos estáticos, mientras que los métodos estáticos solo pueden acceder a otros atributos o métodos estáticos.

## Beneficios de Usar Métodos Estáticos
1. **Mejor Organización y Reutilización del Código**:

   * Los métodos estáticos permiten agrupar funcionalidades generales y reutilizables en clases de utilidad. Esto mejora la modularidad del código.

2. **Reducción del Consumo de Memoria**:

   * Como los métodos estáticos no requieren crear instancias para ser usados, ayudan a reducir el consumo de memoria y mejorar el rendimiento en operaciones que se ejecutan repetidamente.

3. **Acceso Sencillo y Conveniente**:

   * No necesitas instanciar objetos para usar métodos estáticos, lo que facilita su uso en diversos contextos, como la realización de cálculos o la ejecución de validaciones.