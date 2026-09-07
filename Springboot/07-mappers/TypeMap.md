# `TypeMap`
Es una configuración específica que define cómo mapear un objeto de origen a un objeto de destino. A diferencia del mapeo automático, el `TypeMap` permite personalizar las reglas y lógica para transformar las propiedades entre los objetos.

## ¿Qué es?
Un `TypeMap` es una clase en **ModelMapper** que representa un conjunto de reglas que dictan cómo convertir un tipo de origen a un tipo de destino.

Definición técnica: `TypeMap<S, D>` es una configuración explícita que define el mapeo entre una clase fuente S y una clase destino `D`.

## ¿Para qué sirve?
Sirve para configurar y personalizar el mapeo entre dos clases. Esto incluye:

* Establecer reglas específicas para mapear propiedades.

* Ignorar ciertas propiedades del origen o destino.

* Personalizar transformaciones en propiedades complejas.

* Definir conversiones avanzadas que no se pueden manejar con el mapeo automático.

## ¿Qué resuelve?
El TypeMap resuelve problemas de:

* **Incompatibilidad de nombres de propiedades**: Cuando los nombres de las propiedades en la clase fuente y destino no coinciden.

  * Ejemplo: `firstName` en la clase fuente y `first_name` en la clase destino.

* **Transformaciones específicas**: Cuando necesitas modificar datos en el proceso de mapeo, como concatenar propiedades, convertir formatos de fecha o realizar cálculos.

* **Ignorar propiedades irrelevantes**: Permite excluir propiedades que no deben ser mapeadas.

* **Mapeo de estructuras complejas**: Ayuda a mapear objetos anidados o listas con lógica personalizada.

## ¿Cómo lo resuelve?
El TypeMap permite configurar reglas detalladas para el mapeo utilizando métodos como:

* `addMappings()`: Define configuraciones personalizadas para el mapeo.

* `setPropertyCondition()`: Aplica condiciones que deben cumplirse antes de mapear una propiedad.

* `setPostConverter()`: Permite definir lógica de transformación después del mapeo.

* `setPreConverter()`: Define lógica de transformación antes del mapeo.

## Características principales
* **Configuración explícita**: Puedes definir exactamente cómo mapear cada propiedad.

* **Compatibilidad con propiedades complejas**: Soporta estructuras anidadas, listas y conversiones complejas.

* **Integración con `PropertyMap`**: Facilita la personalización del mapeo usando una clase dedicada.

* **Eventos pre y post-conversión**: Permite realizar operaciones adicionales antes o después del mapeo.

* **Reutilizable**: Un `TypeMap` puede ser usado múltiples veces para realizar mapeos consistentes.

## Principales métodos de TypeMap
**Creación y configuración:**
* `addMappings(PropertyMap<S, D> propertyMap)`: Añade configuraciones personalizadas de mapeo.

* `setPropertyCondition(Condition<?, ?> condition)`: Aplica una condición para mapear una propiedad.

* `setPreConverter(Converter<S, D> preConverter)`: Establece un convertidor que se ejecuta antes del mapeo.

* `setPostConverter(Converter<S, D> postConverter)`: Establece un convertidor que se ejecuta después del mapeo.

**Obtención de configuraciones:**
* `getMappings()`: Obtiene todas las reglas configuradas en el TypeMap.

* `getCondition()`: Obtiene la condición aplicada al TypeMap.

* `getPreConverter()`: Obtiene el convertidor definido antes del mapeo.

* `getPostConverter()`: Obtiene el convertidor definido después del mapeo.

**Validación y uso:**
* `map(S source)`: Realiza el mapeo del objeto fuente al objeto destino.

* `validate()`: Valida que todas las configuraciones y mapeos sean válidos.

## Ejemplo práctico
**Escenario**

Tienes una clase de entidad `UserEntity` y necesitas mapearla a un **DTO** `UserDTO`. Además, quieres concatenar el nombre y el apellido en un solo campo `fullName`.

```java
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.PropertyMap;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // Crear un TypeMap para personalizar el mapeo
        TypeMap<UserEntity, UserDTO> typeMap = modelMapper.createTypeMap(UserEntity.class, UserDTO.class);

        // Configurar el mapeo personalizado
        typeMap.addMappings(new PropertyMap<UserEntity, UserDTO>() {
            @Override
            protected void configure() {
                // Concatenar el nombre y el apellido
                map().setFullName(source.getFirstName() + " " + source.getLastName());

                // Ignorar la propiedad email
                skip(destination.getEmail());
            }
        });

        // Crear un objeto de ejemplo
        UserEntity userEntity = new UserEntity("John", "Doe", "john.doe@example.com");

        // Mapear el objeto
        UserDTO userDTO = typeMap.map(userEntity);

        // Imprimir el resultado
        System.out.println("Full Name: " + userDTO.getFullName()); // Output: Full Name: John Doe
        System.out.println("Email: " + userDTO.getEmail());       // Output: Email: null
    }
}

// Clases de ejemplo
class UserEntity {
    private String firstName;
    private String lastName;
    private String email;

    public UserEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
}

class UserDTO {
    private String fullName;
    private String email;

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```