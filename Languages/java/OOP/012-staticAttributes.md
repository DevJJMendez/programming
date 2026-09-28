# Atributos Estáticos
Los atributos estáticos (también conocidos como variables de clase) son aquellos que pertenecen a la clase en sí misma, en lugar de pertenecer a las instancias (objetos) de la clase. Esto significa que un atributo estático es compartido por todas las instancias de la clase, y existe independientemente de que se creen o no objetos de esa clase.

En Java, los atributos estáticos se declaran usando la palabra clave `static`.

## ¿Para Qué Sirven?
1. **Compartir Información Común Entre Todas las Instancias**: Los atributos estáticos permiten almacenar información que debe ser compartida y consistente en todas las instancias de una clase. Por ejemplo, contar cuántas instancias se han creado de una clase.

2. **Acceder a Información Sin Necesidad de Instancias**: Como pertenecen a la clase, los atributos estáticos pueden ser accedidos directamente a través de la clase misma, sin necesidad de crear objetos. Esto es útil para información que no cambia o que debe ser compartida globalmente.

## ¿Qué Problema Resuelven?
1. **Problema: Necesidad de Información Compartida**: Si cada objeto tuviera su propia copia de una variable (por ejemplo, un contador de objetos), el valor de esa variable no se sincronizaría correctamente entre objetos diferentes. Los atributos estáticos resuelven este problema al mantener una única copia compartida de la variable.

2. **Problema: Necesidad de Acceso Global**: En ocasiones, se necesita que un valor o comportamiento esté disponible globalmente en toda la aplicación, sin necesidad de instanciar objetos cada vez. Los atributos estáticos permiten acceder a estos valores directamente a través de la clase.

## ¿Cómo Lo Resuelven?
1. **Consistencia y Sincronización**: Al tener un solo valor compartido por todas las instancias, los atributos estáticos aseguran que todas las operaciones se realicen sobre el mismo valor, evitando inconsistencias.

2. **Acceso Global**: Se puede acceder a los atributos estáticos usando el nombre de la clase, lo que proporciona un acceso sencillo y directo sin tener que crear una instancia. Por ejemplo, `Clase.atributoEstatico.`

**Ejemplo básico**
```java
public class ConfiguracionSistema {
    // Atributo estático
    public static String nombreSistema = "MiAplicacion";

    // Método estático
    public static void mostrarNombreSistema() {
        System.out.println("Nombre del sistema: " + nombreSistema);
    }
}

// Uso en el programa principal
public class Main {
    public static void main(String[] args) {
        // Acceso al atributo estático directamente desde la clase
        System.out.println(ConfiguracionSistema.nombreSistema);

        // Modificación del atributo estático
        ConfiguracionSistema.nombreSistema = "NuevaAplicacion";
        ConfiguracionSistema.mostrarNombreSistema(); // Salida: Nombre del sistema: NuevaAplicacion
    }
}
```

## Ejemplo Real: Contador de Instancias
Un ejemplo común del uso de atributos estáticos es llevar la cuenta del número de instancias creadas de una clase.

```java
public class Usuario {
    private static int contadorUsuarios = 0; // Atributo estático para contar instancias
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
        contadorUsuarios++; // Incrementar cada vez que se crea un nuevo objeto
    }

    public static int getContadorUsuarios() {
        return contadorUsuarios;
    }
}

// Uso:
public class Main {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Juan");
        Usuario u2 = new Usuario("Ana");

        // Acceso al atributo estático para saber cuántos objetos se han creado
        System.out.println("Total de usuarios creados: " + Usuario.getContadorUsuarios()); // Salida: 2
    }
}
```

## Detalles Importantes
1. **Inicialización de Atributos Estáticos**:

   * Los atributos estáticos pueden ser inicializados al momento de la declaración o dentro de un bloque estático.

   * **Bloque estático**: Se ejecuta una vez cuando la clase es cargada en la memoria.

```java
public class Configuracion {
    public static String version;
    
    static {
        version = "1.0.0"; // Inicialización estática
    }
}
```

2. **Acceso y Modificación**: Se puede acceder y modificar los atributos estáticos directamente a través del nombre de la clase (`Clase.atributo`). Sin embargo, pueden ser accesibles desde instancias, pero esto no es una buena práctica porque puede llevar a confusión.

3. **Visibilidad (Modificadores de Acceso)**: Los atributos estáticos pueden tener modificadores de acceso como `public`, `private`, `protected`. Por lo general, se hacen private y se exponen a través de métodos estáticos **`getters`** y **`setters`** para mantener el control.

## Beneficios de Usar Atributos Estáticos
1. **Reducción de Consumo de Memoria**: Solo hay una copia del atributo, independientemente del número de objetos, lo que reduce el uso de memoria cuando se necesita mantener datos comunes.

2. **Acceso Directo**: Acceder a los atributos estáticos es sencillo y no requiere la creación de objetos, lo cual puede ser útil para constantes o configuraciones globales.

3. **Datos Comunes Consistentes**: Perfecto para información que debe ser consistente a través de múltiples instancias, como configuraciones globales, contadores, o cachés compartidos.

## Consideraciones al Usar Atributos Estáticos
1. **Evitar el Uso Excesivo**: Aunque los atributos estáticos son útiles, un uso excesivo puede llevar a problemas de mantenimiento y diseño, ya que pueden introducir dependencias globales no deseadas. Esto va en contra de principios de diseño como SOLID.

2. **Problemas en Entornos Multihilo**: Los atributos estáticos compartidos por varias instancias pueden ser un problema en aplicaciones multihilo si no se gestionan correctamente, pudiendo dar lugar a condiciones de carrera. En estos casos, es esencial asegurar la sincronización o usar técnicas de concurrencia apropiadas.

3. **Mejor Práctica: Usar para Constantes y Estados Compartidos**: Es recomendable usar atributos estáticos para valores constantes (final) y estados compartidos que realmente deban ser accesibles globalmente.