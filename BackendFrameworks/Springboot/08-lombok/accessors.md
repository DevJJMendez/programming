La anotación @Accessors es una de las anotaciones proporcionadas por Lombok y está diseñada para personalizar cómo se generan los métodos getter y setter en una clase. Esta anotación permite configurar diferentes comportamientos para el acceso y la mutación de los atributos de una clase, proporcionando más flexibilidad y control sobre las convenciones estándar de Java.

## ¿Qué es @Accessors?
@Accessors es una anotación de Lombok que se utiliza para modificar la forma en que se generan los métodos getter y setter de una clase. También puede influir en la generación de otros métodos relacionados con la mutación, como los métodos de estilo builder.

¿Para qué sirve?
Sirve para personalizar el comportamiento de los métodos getter y setter, permitiendo configuraciones como:

Prefijos personalizados para los atributos.
Uso de estilo fluido (fluent) para los métodos setter, que permiten encadenar llamadas.
Cadena de retornos (chain), donde los métodos setter devuelven la propia instancia del objeto.

¿Qué resuelve?
Código repetitivo y personalizado:
Permite generar automáticamente métodos getter y setter que sigan un estilo específico, eliminando la necesidad de escribirlos manualmente.
Compatibilidad con convenciones específicas:
Facilita la integración con frameworks o librerías que requieren un estilo particular de acceso a los atributos.
Mayor fluidez en el diseño de API:
Hace que las clases sean más expresivas y fáciles de usar, especialmente en entornos que favorecen el encadenamiento de métodos (como builders).

¿Cómo lo resuelve?
@Accessors utiliza las propiedades configuradas por el desarrollador para personalizar el comportamiento de Lombok al generar métodos getter y setter.

fluent = true:

Los métodos setter no usan el prefijo set y devuelven la instancia del objeto (útil para encadenamiento de métodos).
chain = true:

Los métodos setter devuelven la propia instancia del objeto, permitiendo encadenar llamadas.
prefix:

Permite eliminar un prefijo de los nombres de las variables (por ejemplo, si los atributos tienen un prefijo como m, this, etc.).

Características de @Accessors
Configuración del estilo fluido (fluent):

Genera métodos getter y setter con nombres iguales al atributo, eliminando los prefijos estándar (get y set).
Soporte para encadenamiento (chain):

Permite que los métodos setter devuelvan la instancia del objeto, facilitando el encadenamiento de métodos en una sola línea.
Compatibilidad con prefijos (prefix):

Facilita el manejo de atributos con prefijos comunes, eliminándolos en los nombres de los métodos generados.
Interoperabilidad con otras anotaciones de Lombok:

Se puede usar junto con anotaciones como @Data, @Getter, @Setter o @Builder.

## Opciones principales de configuración
1. fluent = true
Desactiva los prefijos estándar (get y set).
Los métodos se llaman como el nombre del atributo.

Ejemplo
```java
import lombok.Accessors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Accessors(fluent = true)
public class User {
    private String name;
    private int age;
}
```
Métodos generados:
```java
public class User {
    public String name() {
        return name;
    }
    public User name(String name) {
        this.name = name;
        return this;
    }
    public int age() {
        return age;
    }
    public User age(int age) {
        this.age = age;
        return this;
    }
}
```

2. chain = true
Los métodos setter devuelven la propia instancia del objeto.
```java
import lombok.Accessors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Accessors(chain = true)
public class User {
    private String name;
    private int age;
}
```
Uso:
```java
User user = new User()
                .setName("John")
                .setAge(30);
```

3. prefix
Elimina un prefijo específico en los nombres de los atributos para generar métodos más limpios.
Ejemplo:
```java
import lombok.Accessors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Accessors(prefix = "m")
public class User {
    private String mName;
    private int mAge;
}
```
Métodos generados:
```java
public String getName() {
    return mName;
}
public void setName(String name) {
    this.mName = name;
}
public int getAge() {
    return mAge;
}
public void setAge(int age) {
    this.mAge = age;
}
```

## Ventajas de @Accessors
Reducción de código repetitivo:

Se generan métodos personalizados automáticamente.
Flexibilidad:

Permite adaptar los métodos getter y setter a estilos específicos.
Encadenamiento fluido:

Hace el código más limpio y expresivo en casos como builders.
Compatibilidad con prefijos:

Resuelve problemas con nombres heredados o prefijos no deseados.