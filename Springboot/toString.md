¿Qué es el método toString()?
El método toString() es un método heredado de la clase base java.lang.Object. Su función principal es proporcionar una representación en forma de cadena de un objeto. Esta representación es útil para depurar, registrar información, o simplemente imprimir los datos contenidos en un objeto.

Por defecto, el método toString() genera una cadena que incluye:

El nombre de la clase.
El símbolo @.
El valor hexadecimal del código hash del objeto.
Por ejemplo, si no se sobrescribe el método, un objeto se representará como:
```java
com.example.MyClass@1a2b3c
```

¿Qué parámetros recibe?
El método toString() no recibe parámetros. Su firma es:
```java
public String toString()
```

¿Para qué sirve?
El propósito del método toString() es proporcionar una descripción comprensible de un objeto. Esto es particularmente útil cuando:

Se imprime un objeto directamente en consola (por ejemplo, usando System.out.println()).
Se necesita un registro legible de los datos de un objeto.
Se desea depurar el estado de un objeto en tiempo de ejecución.
Al sobrescribir toString(), puedes personalizar la descripción de tus objetos para que sea más significativa y útil.

¿Qué problemas resuelve?
Mejora la legibilidad: En lugar de mostrar la representación predeterminada de un objeto (por ejemplo, com.example.MyClass@1a2b3c), puedes mostrar los datos relevantes de la clase.
Facilita la depuración: Al mostrar los valores internos del objeto, puedes inspeccionar rápidamente su estado.
Evita confusión: Especialmente cuando trabajas con colecciones de objetos (como listas o mapas), sobrescribir toString() te ayuda a entender qué contienen realmente.

¿Cómo lo resuelve?
El método toString() se sobrescribe en las clases definidas por el usuario. Al hacerlo, defines cómo debe representarse un objeto como una cadena.

Por ejemplo:
```java
public class Category {
    private Long id;
    private String name;
    private String description;

    // Constructor, getters y setters

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
```
Ahora, si creas un objeto Category e intentas imprimirlo, obtendrás algo como:
```bash
Category{id=1, name='Electronics', description='Gadgets and devices'}
```
En lugar de:
```bash
com.example.Category@1a2b3c
```

¿Cuándo es recomendable sobrescribir toString()?
Cuando quieres describir claramente el estado de un objeto.
Si el objeto es utilizado en colecciones (listas, mapas, etc.), y quieres que su contenido sea comprensible al imprimirlo.
Para facilitar la depuración.
Cuando estás creando clases de dominio o modelos (como entidades en una base de datos).

Buenas prácticas para sobrescribir toString()
Incluye información relevante: Solo muestra datos importantes para identificar el estado del objeto.
No incluyas información sensible: Como contraseñas o datos privados.
Usa herramientas automáticas: IDEs como IntelliJ IDEA o Eclipse pueden generar automáticamente un método toString().
Mantén el formato limpio y legible.
Usa librerías de utilidades si es necesario: Por ejemplo, la clase ToStringBuilder de Apache Commons Lang facilita la creación de representaciones de cadenas.

Ejemplo con ToStringBuilder:
```java
@Override
public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
}
```

# equals()
El método equals() es un método definido en la clase base java.lang.Object. Se utiliza para comparar si dos objetos son lógicamente equivalentes. Por defecto, la implementación de equals() en Object compara si las referencias de los dos objetos son iguales (es decir, si ambos apuntan al mismo objeto en memoria).

Firma del método:
```java
public boolean equals(Object obj)
```

¿Qué parámetros recibe?
El método equals() recibe un único parámetro:
Object obj: El objeto con el cual deseas comparar el objeto actual.

¿Para qué sirve?
El método equals() sirve para determinar si dos instancias de una clase son lógicamente iguales. Esto es útil cuando trabajas con datos que tienen la misma identidad conceptual pero no necesariamente la misma ubicación en memoria.

Por ejemplo:

Comparar dos instancias de una clase Person para verificar si representan a la misma persona.
Comparar claves en un HashMap, ya que el método equals() es utilizado internamente por estructuras de datos como mapas o conjuntos para encontrar objetos equivalentes.

¿Qué problemas resuelve?
Identificar igualdad lógica, no solo referencial: Por defecto, == en Java verifica si dos referencias apuntan al mismo objeto en memoria. Si quieres determinar si dos objetos tienen el mismo contenido o estado lógico, necesitas sobrescribir el método equals().

Garantizar consistencia en colecciones: Estructuras como HashSet y HashMap dependen de una implementación adecuada de equals() para almacenar y recuperar elementos correctamente.

Evitar errores al trabajar con objetos personalizados: Si no sobrescribes equals() en tus clases, las comparaciones podrían no funcionar como esperas cuando comparas el estado lógico de los objetos.

¿Cómo lo resuelve?
El método equals() debe sobrescribirse en las clases definidas por el usuario para proporcionar una comparación lógica personalizada. Al sobrescribirlo, defines qué criterios deben cumplirse para que dos objetos sean considerados equivalentes.

Ejemplo básico:
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica si es la misma referencia
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica la clase
        Person person = (Person) obj; // Realiza un cast seguro
        return age == person.age && Objects.equals(name, person.name); // Compara los campos
    }
}
```
Ahora, dos objetos de la clase Person con el mismo nombre y edad serán considerados iguales:
```java
Person p1 = new Person("Alice", 25);
Person p2 = new Person("Alice", 25);

System.out.println(p1.equals(p2)); // true
```

Reglas importantes al sobrescribir equals()
Reflexiva: Un objeto siempre es igual a sí mismo.
```java
x.equals(x) == true
```
Simétrica: Si x.equals(y) es true, entonces y.equals(x) también debe ser true.

Transitiva: Si x.equals(y) es true y y.equals(z) es true, entonces x.equals(z) también debe ser true.

Consistente: Si no se modifica el estado de los objetos, la comparación debe seguir devolviendo el mismo resultado.

Comparar con null: Un objeto nunca es igual a null. Si x es un objeto no nulo:
```java
x.equals(null) == false
```

Buenas prácticas al sobrescribir equals()
Compara todos los campos relevantes: Solo incluye en la comparación los campos que determinan la identidad lógica del objeto.

Usa la clase Objects para comparar campos: La clase java.util.Objects simplifica las comparaciones y maneja casos de null.

Ejemplo:
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Person person = (Person) obj;
    return age == person.age && Objects.equals(name, person.name);
}
```
Evita incluir campos mutables: Si incluyes campos que pueden cambiar, la comparación podría romperse si el estado del objeto cambia después de haber sido almacenado en una colección.

Sobrescribe también hashCode(): Siempre que sobrescribas equals(), debes sobrescribir también el método hashCode() para garantizar la consistencia en colecciones basadas en hash (como HashMap o HashSet).

# hashCode()
El método hashCode() es un método de la clase base java.lang.Object que devuelve un número entero, conocido como el código hash del objeto. Este número se utiliza principalmente en estructuras de datos basadas en tablas hash, como HashMap, HashSet y HashTable, para ubicar rápidamente los objetos.

Firma del método:
```java
public native int hashCode()
```
El modificador native indica que este método está implementado en código nativo (generalmente en C o C++).

¿Qué parámetros recibe?
El método hashCode() no recibe parámetros. Es un método sin argumentos.

¿Para qué sirve?
El método hashCode() sirve para generar un número entero que representa el código hash de un objeto, lo cual permite:

Optimizar la búsqueda y almacenamiento en estructuras basadas en hash: Colecciones como HashMap o HashSet utilizan el código hash para determinar la ubicación de un objeto dentro de la tabla.

Garantizar consistencia con el método equals():

Si dos objetos son iguales según equals(), deben tener el mismo código hash.
Si dos objetos tienen códigos hash diferentes, son inequívocamente diferentes.

¿Qué problemas resuelve?
Mejorar el rendimiento de estructuras basadas en hash: Las estructuras como HashMap dependen de códigos hash para almacenar y recuperar objetos con eficiencia. Sin un código hash bien definido, estas estructuras serían menos eficientes.

Evitar colisiones innecesarias: Una mala implementación de hashCode() puede generar códigos hash repetidos (colisiones), lo que degrada el rendimiento de las estructuras basadas en hash.

Establecer una regla clara para identificar objetos en estructuras de datos: Evita problemas cuando trabajas con claves personalizadas en mapas o conjuntos.

¿Cómo lo resuelve?
El método hashCode() divide los objetos en "buckets" dentro de estructuras basadas en hash, usando un algoritmo de hashing para generar un entero único (o casi único) basado en los valores internos del objeto.

Al sobrescribir hashCode(), puedes definir cómo se genera este número en función de los campos del objeto que consideres relevantes. Para garantizar consistencia, debes asegurarte de que:

Los objetos iguales según equals() generen el mismo hashCode().
Los objetos diferentes tengan, idealmente, diferentes códigos hash, aunque esto no siempre es obligatorio.

Reglas importantes para hashCode()
Consistencia con equals(): Si x.equals(y) es true, entonces x.hashCode() debe ser igual a y.hashCode().

No es necesario que objetos diferentes tengan códigos hash diferentes: Sin embargo, mientras más únicos sean los códigos hash, mejor será el rendimiento de las estructuras basadas en hash.

Debe ser consistente: Mientras no cambien los valores usados para calcular el hash, el método debe devolver el mismo resultado cada vez que se llame.