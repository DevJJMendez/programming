### Expresiones Regulares

Las expresiones regulares (también conocidas como regex o regexp) son una herramienta poderosa para trabajar con cadenas de texto. Permiten buscar, editar y manipular texto basándose en patrones definidos. En Java, las expresiones regulares están soportadas a través del paquete `java.util.regex`.

### Conceptos Básicos

**Sintaxis de Expresiones Regulares**

Las expresiones regulares se construyen utilizando una combinación de caracteres literales y metacaracteres. Aquí hay algunos conceptos clave:

- **Caracteres Literales**: Representan exactamente el carácter especificado. Ejemplo: a, b, 1, A.
- **Metacaracteres**: Tienen un significado especial y se utilizan para definir patrones complejos. Ejemplo: 
  - `.` (cualquier carácter) 
  - `*` (cero o más repeticiones) 
  - `+` (una o más repeticiones) 
  - `?` (cero o una repetición)
  - `[]` (conjunto de caracteres)
  - `^` (inicio de la línea)
  - `$` (fin de la línea)
  - `|` (alternativa)
  - `\` (escape de metacaracteres).

**Ejemplos Comunes de Patrones**
- `a.*b`: Encuentra una 'a' seguida de cualquier número de caracteres y luego una 'b'.
- `[0-9]+`: Encuentra una o más cifras.
- `^abc`: Encuentra 'abc' al principio de una línea.
- `abc$`: Encuentra 'abc' al final de una línea.
- `[A-Za-z]`: Encuentra cualquier letra mayúscula o minúscula.
- `\d{3}`: Encuentra exactamente tres dígitos.

### Uso de Expresiones Regulares en Java

En Java, las expresiones regulares se utilizan principalmente a través de las clases `Pattern` y `Matcher` del paquete `java.util.regex`.

**Clase Pattern** La clase Pattern representa una expresión regular compilada.

**Clase Matcher** La clase Matcher se utiliza para realizar operaciones de coincidencia sobre una cadena de texto utilizando una expresión regular.

Ejemplo
```java
import java.util.regex.*;

public class RegexExample {
    public static void main(String[] args) {
        // Definir el patrón de la expresión regular
        String patternString = "\\d+"; // Encuentra uno o más dígitos
        Pattern pattern = Pattern.compile(patternString);
        
        // Definir la cadena de texto a buscar
        String text = "El número de teléfono es 123456 y el código postal es 78910.";
        
        // Crear un Matcher
        Matcher matcher = pattern.matcher(text);
        
        // Encontrar coincidencias
        while (matcher.find()) {
            System.out.println("Encontrado: " + matcher.group());
        }
    }
}
```

**Métodos Comunes de Matcher**
- `find()`: Encuentra la siguiente subsecuencia de la entrada que coincide con el patrón.
- `group()`: Devuelve la subsecuencia de la entrada que coincide con el patrón.
- `matches()`: Verifica si toda la cadena de entrada coincide con el patrón.
- `start()`: Devuelve la posición inicial de la coincidencia.
- `end()`: Devuelve la posición final de la coincidencia.

**Métodos Comunes de Pattern**
- `compile(String regex)`: Compila una expresión regular en un patrón.
- `matcher(CharSequence input)`: Crea un Matcher que buscará coincidencias en la entrada especificada.

**Reemplazo de Texto**: También puedes usar expresiones regulares para reemplazar partes de una cadena de texto utilizando el método replaceAll de la clase String o Matcher.
```java
public class RegexReplaceExample {
    public static void main(String[] args) {
        String text = "La fecha es 2024-07-03.";
        String patternString = "\\d{4}-\\d{2}-\\d{2}"; // Encuentra fechas en formato yyyy-MM-dd
        
        // Reemplazar la fecha por otra cadena
        String newText = text.replaceAll(patternString, "YYYY-MM-DD");
        System.out.println("Texto reemplazado: " + newText);
    }
}
```

### Buenas Prácticas
- **Legibilidad**: Escribe expresiones regulares que sean fáciles de entender. Utiliza comentarios y divide las expresiones complejas en partes más pequeñas si es necesario.
- **Documentación**: Documenta las expresiones regulares complejas para que otros desarrolladores puedan entender su propósito.
- **Eficiencia**: Evita expresiones regulares innecesariamente complejas que pueden afectar el rendimiento. Usa herramientas de prueba de expresiones regulares para optimizar tus patrones.