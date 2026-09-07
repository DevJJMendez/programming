# **ModelMapper**
****ModelMapper**** es una biblioteca Java que facilita el mapeo de objetos de un tipo a otro, de manera sencilla y flexible. Es una herramienta que se utiliza principalmente para convertir **entidades de dominio** en **DTOs (Data Transfer Objects)** y viceversa, lo cual es muy útil en aplicaciones que manejan diferentes representaciones de datos entre capas (por ejemplo, entre la capa de persistencia y la capa de presentación).

## ¿Qué es **ModelMapper**?
****ModelMapper**** es una biblioteca que permite hacer mapeos de objetos de manera automática entre diferentes clases, usando convenciones o configuraciones personalizadas. En otras palabras, te ayuda a transformar un objeto de una clase (por ejemplo, una entidad de base de datos) en otro tipo de objeto (como un DTO), sin tener que escribir código de mapeo manualmente.

****ModelMapper**** es útil en arquitecturas de software como MVC, Clean Architecture, Microservicios, entre otras, donde los objetos de dominio (entidades) se transfieren a través de diferentes capas, y a menudo se necesita una representación diferente de los datos (DTOs).

## ¿Para qué sirve **ModelMapper**?
* **Convertir entre clases de objetos**: Sirve para convertir entre clases que pueden tener diferentes estructuras, lo que es útil cuando las representaciones de los datos en el dominio y los DTOs no son iguales.

* **Automatizar el mapeo de objetos**: Evita escribir código repetitivo para transformar manualmente las propiedades de un objeto en otro, ahorrando tiempo y reduciendo la posibilidad de cometer errores.

* **Mejorar la mantenibilidad**: Facilita la evolución de la aplicación, ya que puedes modificar las clases de dominio sin tener que cambiar cada parte del código que realice el mapeo manualmente.

* **Facilitar la interoperabilidad**: En sistemas con múltiples capas, como una API RESTful, ****ModelMapper**** ayuda a mapear las respuestas de la API de manera eficiente.

* **Soporte para mapeos complejos**: Permite hacer mapeos más complejos, como copiar propiedades con nombres diferentes, manejar colecciones, objetos anidados, etc.

## ¿Cuáles son sus características?
****ModelMapper**** tiene varias características destacadas que lo hacen útil en el desarrollo de aplicaciones:

* **Automatización del mapeo**:
  * ****ModelMapper**** puede mapear automáticamente los campos de objetos si tienen nombres coincidentes. Por ejemplo, si tienes un objeto `UserEntity` con un campo `name` y un `DTO` `UserDTO` con un campo `name`, ****ModelMapper**** lo hará sin configuración adicional.

* **Configuraciones personalizadas**:
  * ****ModelMapper**** permite definir reglas de mapeo personalizadas para casos donde los nombres de los campos no coinciden o cuando deseas aplicar lógica adicional en el mapeo.

  * **Ejemplo**: Si tienes un campo `firstName` en la clase de origen y `name` en el DTO de destino, puedes configurarlo explícitamente.

* **Soporte para mapeo de colecciones**:
  * ****ModelMapper**** también soporta la conversión de colecciones de objetos (listas, conjuntos) de manera sencilla.

* **Conversión de objetos anidados**:
  * ****ModelMapper**** puede manejar objetos anidados dentro de otros objetos. Si tienes una clase de dominio con una referencia a otra clase como propiedad, ****ModelMapper**** puede mapear ambas clases, sin necesidad de configurar cada propiedad manualmente.

* **Desempeño eficiente**:
  * Aunque ****ModelMapper**** realiza una conversión automática, se optimiza para que el rendimiento no se vea afectado, especialmente cuando mapeas muchos objetos a la vez.

* **Fácil integración**:
  * ****ModelMapper**** es fácil de integrar con cualquier aplicación Java. Se puede usar en aplicaciones de Spring, sistemas basados en REST, microservicios, entre otros.

## ¿Qué resuelve **ModelMapper**?
****ModelMapper**** resuelve varios problemas comunes cuando se trabaja con mapeo de datos entre diferentes capas o entre sistemas externos:

* **Reducción de código repetitivo**:
  * Sin ****ModelMapper****, tendrías que escribir mucho código repetitivo para copiar propiedades entre objetos manualmente. ****ModelMapper**** automatiza este proceso, lo que reduce significativamente el esfuerzo de desarrollo.

* **Incompatibilidad entre clases**:
  * Cuando las clases de dominio y los DTOs tienen campos con nombres diferentes, ****ModelMapper**** resuelve esta incompatibilidad permitiéndote configurar fácilmente cómo deben mapearse estos campos.

* **Manejo de objetos complejos**:
  * **ModelMapper** es capaz de manejar objetos anidados o colecciones de objetos sin necesidad de escribir código complicado para recorrer estas estructuras de manera manual.

* **Escalabilidad del mapeo**:
  * En aplicaciones grandes, el mapeo de objetos puede volverse engorroso si se hace manualmente. ****ModelMapper**** permite mantener el código limpio y escalable, facilitando los cambios y manteniendo el código fácil de entender.

* **Desacoplamiento entre capas**:
  * Al utilizar ****ModelMapper****, las diferentes capas de la aplicación pueden ser desacopladas correctamente. La capa de persistencia puede usar las entidades del dominio, mientras que la capa de presentación usa los DTOs sin tener que preocuparse por las relaciones internas de las entidades.

## ¿Cómo lo resuelve?
**ModelMapper** resuelve estos problemas utilizando un enfoque flexible y sencillo que permite automatizar el mapeo entre objetos. Así lo hace:

* **Convenciones de nombres automáticas**:
  * **ModelMapper** utiliza convenciones de nombres predeterminadas para mapear las propiedades de objetos con nombres coincidentes de forma automática. Esto significa que si las propiedades en las clases de origen y destino tienen el mismo nombre, **ModelMapper** las mapea directamente.

* **Configuraciones personalizadas**:
  * Si los nombres de las propiedades no coinciden, puedes configurar **ModelMapper** para especificar cómo mapear cada propiedad. Puedes usar `PropertyMap` para hacer configuraciones específicas, o incluso proporcionar lógica compleja usando expresiones Lambda.

* **Transformación de colecciones y objetos anidados**:
  * **ModelMapper** soporta mapeos de colecciones (listas, sets) y objetos anidados. Si tienes una lista de objetos de un tipo y quieres mapearla a otra lista de un tipo diferente, **ModelMapper** lo hará por ti de manera automática.

* **Mapeo condicional y validación**:
  * Puedes aplicar lógicas condicionales para decidir cómo mapear los campos, o incluso realizar validaciones sobre los datos antes de hacer el mapeo.

* **Rendimiento**:
  * **ModelMapper** optimiza internamente el proceso de mapeo utilizando cachés para evitar la repetición del mismo proceso de conversión en el futuro.


## Ejemplo Básico de Uso de **ModelMapper**
1. **Agregar dependencia de **ModelMapper** (Si usas `Maven`)**:
```xml
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.0</version>
</dependency>
```

2. **Configuración y Mapeo Simple**:
```java
import org.modelmapper.**ModelMapper**;

public class UserDTO {
    private String name;
    private String email;
    
    // Getters y Setters
}

public class UserEntity {
    private String name;
    private String email;
    
    // Getters y Setters
}

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        
        // Crear objeto de dominio
        UserEntity userEntity = new UserEntity();
        userEntity.setName("John Doe");
        userEntity.setEmail("john.doe@example.com");
        
        // Convertir a DTO
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        
        System.out.println(userDTO.getName());  // Imprime "John Doe"
        System.out.println(userDTO.getEmail());  // Imprime "john.doe@example.com"
    }
}
```

3. **Configuración avanzada con `PropertyMap`**:
```java
modelMapper.addMappings(new PropertyMap<UserEntity, UserDTO>() {
    protected void configure() {
        map(source.getName(), destination.getName());
        map(source.getEmail(), destination.getEmail());
    }
});
```

## Métodos para configuración general
* **`getConfiguration()`** Obtiene la configuración global de **ModelMapper**, que incluye estrategias de mapeo y correspondencia.
  * Ejemplo:
```java
modelMapper.getConfiguration()
           .setFieldMatchingEnabled(true)
           .setFieldAccessLevel(AccessLevel.PRIVATE);
```

* **`setConfiguration(Configuration configuration)`** Establece una nueva configuración global para el **ModelMapper**.

* **`validate()`** Valida que todas las configuraciones de mapeo registradas sean correctas y no tengan errores.

## Métodos para mapeo de objetos
Estos métodos son usados para realizar las transformaciones entre objetos.

* `<D> D map(Object source, Class<D> destinationType)` Mapea un objeto de origen (`source`) al tipo de destino (`destinationType`).
  * Ejemplo:
```java
UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
```

* `void map(Object source, Object destination)` Mapea un objeto de origen (`source`) en una instancia ya existente del objeto de destino (`destination`).
  * Ejemplo:
```java
modelMapper.map(sourceObject, destinationObject);
```

* `TypeMap<S, D> createTypeMap(Class<S> sourceType, Class<D> destinationType)` Crea un `TypeMap` explícito entre dos tipos. Este `TypeMap` puede personalizarse posteriormente.
  * Ejemplo:
```java
TypeMap<UserEntity, UserDTO> typeMap = modelMapper.createTypeMap(UserEntity.class, UserDTO.class);
```

* `TypeMap<S, D> createTypeMap(Class<S> sourceType, Class<D> destinationType, String typeMapName)` Crea un `TypeMap` con un nombre específico.

* `<S, D> TypeMap<S, D> getTypeMap(Class<S> sourceType, Class<D> destinationType)` Obtiene un `TypeMap` existente entre dos clases si ya fue configurado.

* `<S, D> TypeMap<S, D> getTypeMap(Class<S> sourceType, Class<D> destinationType, String typeMapName)` Obtiene un TypeMap existente basado en el nombre.