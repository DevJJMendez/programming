### Reflection
Java Reflection es una característica poderosa del lenguaje Java que permite a los programas inspeccionar y manipular sus propios metadatos en tiempo de ejecución. Con `Reflection`, puedes analizar clases, interfaces, campos y métodos en tiempo de ejecución, sin conocer sus nombres en tiempo de compilación.

### ¿Qué es Java Reflection?
Java Reflection es un conjunto de APIs en el paquete java.lang.reflect que permite realizar las siguientes operaciones:

- **Inspeccionar Clases**: Obtener información sobre las clases, incluyendo sus métodos, campos, constructores, y superclases.
- **Manipular Clases**: Crear instancias de clases, invocar métodos, y acceder y modificar campos.
- **Acceso Dinámico**: Trabajar con clases y objetos de manera dinámica, lo que es útil en casos como frameworks, librerías, y herramientas de desarrollo.

### Principales Clases y Métodos en Reflection

- `Class`: Representa una clase o interfaz en tiempo de ejecución.
    ```java
    Class<?> cls = Class.forName("java.util.ArrayList");
    ```
- `Field`: Representa un campo de una clase.
    ```java
    Field field = cls.getDeclaredField("size");
    field.setAccessible(true);
    ```
- `Method`: Representa un método de una clase.
    ```java
    Method method = cls.getDeclaredMethod("add", Object.class);
    method.setAccessible(true);
    ```
- `Constructor`: Representa un constructor de una clase.
    ```java
    Constructor<?> constructor = cls.getDeclaredConstructor();
    constructor.setAccessible(true);
    ```
### Ejemplos de Uso

1. Obtener Informacion de una Clase:
    ```java
    public class ReflectionExample {
        public static void main(String[] args) throws ClassNotFoundException {
            Class<?> cls = Class.forName("java.util.ArrayList");

            System.out.println("Nombre de la clase: " + cls.getName());
            System.out.println("Nombre del paquete: " + cls.getPackageName());

            System.out.println("Métodos:");
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println(method.getName());
            }

            System.out.println("Campos:");
            for (Field field : cls.getDeclaredFields()) {
                System.out.println(field.getName());
            }
        }
    }
    ```

2. Crear una Instancia de una Clase Dinámicamente:
    ```java
    public class ReflectionExample {
        public static void main(String[] args) throws Exception {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Constructor<?> constructor = cls.getDeclaredConstructor();
            Object instance = constructor.newInstance();

            System.out.println("Instancia creada: " + instance.getClass().getName());
        }
    }
    ```
3. Invocar un Método Dinámicamente:
    ```java
    import java.lang.reflect.Method;
    import java.util.ArrayList;

    public class ReflectionExample {
        public static void main(String[] args) throws Exception {
            Class<?> cls = Class.forName("java.util.ArrayList");
            Constructor<?> constructor = cls.getDeclaredConstructor();
            Object instance = constructor.newInstance();

            Method addMethod = cls.getDeclaredMethod("add", Object.class);
            addMethod.invoke(instance, "Elemento agregado");

            System.out.println("Contenido de la lista: " + instance);
        }
    }
    ```
4. Acceder y Modificar un Campo Privado:
    ```java
    import java.lang.reflect.Field;
    import java.util.ArrayList;

    public class ReflectionExample {
        public static void main(String[] args) throws Exception {
            Class<?> cls = Class.forName("java.util.ArrayList");
            ArrayList<String> list = new ArrayList<>();
            list.add("Elemento 1");

            Field sizeField = cls.getDeclaredField("size");
            sizeField.setAccessible(true);
            int size = (int) sizeField.get(list);

            System.out.println("Tamaño de la lista: " + size);
        }
    }
    ```
### Buenas Prácticas

- **Uso Limitado**: Utiliza Reflection solo cuando sea absolutamente necesario, ya que puede afectar el rendimiento y romper la seguridad de tipo.
- **Manejo de Excepciones**: Reflection puede lanzar muchas excepciones comprobadas como ClassNotFoundException, NoSuchMethodException, IllegalAccessException, etc. Asegúrate de manejarlas adecuadamente.
- **Acceso a Miembros Privados**: El uso de setAccessible(true) para acceder a miembros privados puede violar la encapsulación. Úsalo con precaución.
- **Impacto en el Rendimiento**: Reflection es más lento que las invocaciones de métodos regulares, por lo que su uso excesivo puede impactar negativamente el rendimiento de tu aplicación.