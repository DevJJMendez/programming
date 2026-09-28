# MapStruct
MapStruct es un framework de mapeo de objetos para Java que facilita la conversión entre objetos de diferentes tipos (por ejemplo, de una entidad de base de datos a un DTO o entre clases similares) mediante la generación de código a tiempo de compilación. MapStruct genera código fuente optimizado que realiza las conversiones de manera eficiente.

Se diferencia de otras soluciones como ModelMapper en que MapStruct no realiza el mapeo en tiempo de ejecución, sino que lo genera como código fuente en tiempo de compilación, lo que lo hace más rápido en términos de rendimiento.

## ¿Para qué sirve MapStruct?
* **Convertir entre clases de objetos**: Como en el caso de DTOs (Data Transfer Objects) y entidades o clases de dominio, MapStruct te ayuda a realizar esta conversión sin necesidad de escribir código de mapeo manualmente.

* **Automatizar el mapeo de objetos**: Al igual que ModelMapper, MapStruct automatiza el proceso de conversión entre objetos, pero a diferencia de ModelMapper, realiza este proceso en tiempo de compilación en lugar de en tiempo de ejecución.

* **Generar mapeos eficientes**: Al generar código fuente en lugar de usar reflexiones en tiempo de ejecución, MapStruct ofrece un rendimiento superior, especialmente en aplicaciones con grandes cantidades de datos.

* **Mejorar la mantenibilidad**: Facilita el mantenimiento del código al automatizar el mapeo, lo que significa que puedes cambiar la estructura de las clases de dominio sin necesidad de ajustar todos los mapeos manualmente.

* **Crear mapeos personalizados**: Si bien MapStruct automatiza la mayor parte del mapeo, también te permite crear mapeos personalizados para manejar casos donde la estructura de las clases fuente y destino no coincide.

## ¿Cuáles son sus características?
Las características clave de MapStruct son:

* **Generación de código en tiempo de compilación**: MapStruct genera clases de mapeo al momento de la compilación, lo que resulta en un código optimizado que no incurre en los costos de reflexión en tiempo de ejecución.

* **Soporte para mapeos complejos**: Puedes definir mapeos complejos que involucren tipos de datos anidados o personalizados. Además, MapStruct puede manejar colecciones como listas o conjuntos de manera eficiente.

* **Integración con JavaBeans**: MapStruct funciona bien con las convenciones de JavaBeans, lo que significa que puedes aprovechar los métodos getter y setter para realizar las conversiones de las propiedades.

* **Interfaz o clases abstractas para mapeo**: El mapeo se realiza mediante interfaces o clases abstractas, lo que le da flexibilidad y facilidad de integración en aplicaciones existentes sin la necesidad de modificar las clases de dominio.

* **Soporte para mapeos condicionales**: Puedes definir reglas personalizadas para el mapeo, como mapeos condicionales o la conversión de ciertos valores según reglas específicas.

* **Generación de código optimizado**: Al generar código en lugar de utilizar reflexión, el rendimiento es superior y el código resultante es más eficiente.

* **Soporte para mapeos entre tipos primitivos y envolventes**: MapStruct maneja automáticamente las conversiones entre tipos primitivos y sus versiones envolventes (por ejemplo, `int` a `Integer`).

* **Soporte para mapeo de colecciones**: Puedes mapear colecciones, como listas o conjuntos, de manera sencilla, manteniendo la misma estructura o transformándola.

* **Soporte para mapeo de tipos complejos y personalizados**: MapStruct permite la conversión de tipos complejos (como `LocalDate`, `BigDecimal`, etc.) a otros tipos personalizados, como cadenas de texto o números.

## ¿Qué resuelve MapStruct?
MapStruct resuelve los problemas comunes que surgen cuando se necesita mapear objetos entre diferentes capas de la aplicación, como entre la capa de persistencia (entidades) y la capa de presentación (DTOs):

* **Reducción del código repetitivo**: MapStruct automatiza el proceso de mapeo, evitando la necesidad de escribir código repetitivo para copiar los valores de un objeto a otro.

* **Mejora del rendimiento**: Al generar código en tiempo de compilación, MapStruct elimina los costos de reflexión que otras bibliotecas como ModelMapper tienen en tiempo de ejecución, lo que mejora el rendimiento, especialmente cuando se manejan grandes volúmenes de datos.

* **Manejo de mapeos complejos**: MapStruct facilita el mapeo de estructuras complejas y tipos anidados sin tener que escribir todo el código a mano.

* **Desacoplamiento de las capas de la aplicación**: Al usar MapStruct, puedes separar claramente las clases de dominio de las clases de presentación (DTOs) y automatizar la conversión entre ellas, lo que mejora la arquitectura de la aplicación y reduce el acoplamiento.

* **Flexibilidad en la configuración de mapeos**: Aunque MapStruct realiza la mayor parte del trabajo automáticamente, puedes personalizar y configurar reglas de mapeo para casos más complejos donde las convenciones de nombres no coincidan o haya lógica especial a aplicar.

## ¿Cómo lo resuelve?
MapStruct resuelve los problemas de mapeo de objetos utilizando varias estrategias clave:

* **Generación de código en tiempo de compilación**: MapStruct usa procesadores de anotaciones para generar las clases de mapeo durante la compilación. Este enfoque elimina la necesidad de reflexión en tiempo de ejecución, lo que mejora el rendimiento.

* **Uso de interfaces y clases abstractas**: MapStruct trabaja a través de interfaces o clases abstractas que definen las reglas de mapeo entre objetos. El procesador de anotaciones de MapStruct genera las implementaciones concretas de estas interfaces en tiempo de compilación.

* **Mapeo basado en convenciones de nombres**: MapStruct utiliza las convenciones de nombres de JavaBeans para mapear automáticamente las propiedades de las clases de origen y destino, siempre que los nombres de los campos coincidan.

* **Mapeo personalizado mediante métodos**: Si las convenciones de nombres no coinciden o si se necesita lógica personalizada, puedes definir métodos específicos de mapeo en tu interfaz para manejar estos casos.

* **Soporte para mapeo de colecciones y tipos complejos**: MapStruct puede mapear colecciones completas y tipos complejos como `LocalDate`, `BigDecimal`, o cualquier tipo personalizado. Esto se realiza mediante configuraciones explícitas o configuraciones predeterminadas que MapStruct maneja de manera eficiente.

## Ejemplo Básico de Uso de MapStruct
1. Agregar Dependencia de MapStruct (Si usas Maven):
```xml
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.5.5.Final</version>
</dependency>

<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.5.5.Final</version>
    <scope>provided</scope>
</dependency>
```

2. Crear la Interfaz de Mapeo:
```java
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
```

3. Uso de MapStruct:
```java
import org.mapstruct.factory.Mappers;

public class Main {
    public static void main(String[] args) {
        UserMapper mapper = Mappers.getMapper(UserMapper.class);
        
        // Convertir entidad a DTO
        User user = new User("John Doe", "john@example.com");
        UserDTO userDTO = mapper.userToUserDTO(user);
        
        System.out.println(userDTO.getName()); // John Doe
        System.out.println(userDTO.getEmail()); // john@example.com
    }
}
```

4. **Mapeo Complejo y Personalizado**: Si los nombres de los campos no coinciden o si necesitas una lógica especial para el mapeo, puedes crear métodos personalizados.
```java
@Mapper
public interface UserMapper {
    @Mapping(source = "firstName", target = "name")
    UserDTO userToUserDTO(User user);
}
```