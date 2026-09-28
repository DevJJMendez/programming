# Relación entre DAO y DTO
El DAO es responsable de la interacción directa con la base de datos u otras fuentes de almacenamiento de datos. Se encarga de realizar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en las entidades del dominio y abstrae la complejidad del acceso a los datos.

DTO (Data Transfer Object):
El DTO es un objeto utilizado para transportar datos entre diferentes capas de la aplicación, especialmente en aplicaciones distribuidas o cuando se necesita transferir datos a través de una red (como en APIs REST). Los DTOs no deben contener lógica de negocio, solo datos.

## ¿Cómo se complementan?
Los DAO y DTO se complementan principalmente en la capa de persistencia y en la comunicación entre capas de la aplicación. El DAO interactúa con la base de datos y recupera las entidades del dominio (modelos de base de datos), mientras que el DTO es utilizado para transferir solo los datos necesarios de estas entidades entre las capas, sin exponer la lógica interna ni las entidades completas.

## Flujo típico en un sistema:
Recuperación de datos:
El DAO realiza una consulta a la base de datos para obtener una o varias entidades de dominio (por ejemplo, User, Order).
```java
public User findUserById(int userId) {
    // DAO consulta la base de datos
    return entityManager.find(User.class, userId);
}
```

Transformación a DTO:
Una vez que el DAO recupera los datos, se utiliza un mapeador (puede ser un servicio o una librería como `MapStruct` o `ModelMapper`) para convertir las entidades del dominio a DTOs que solo contienen los datos necesarios para la transferencia.
```java
public UserDTO mapToDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    return dto;
}
```

3. Envío del DTO: El DTO es entonces enviado al cliente, la capa de presentación o cualquier otra capa que necesite esos datos.

## Buenas prácticas para integrar DAO y DTO
Uso adecuado de las responsabilidades:

El DAO se debe limitar exclusivamente a la interacción con la base de datos, es decir, consulta, inserción, actualización y eliminación de datos.
El DTO debe ser utilizado solo para transportar los datos, no debe contener lógica de negocio ni lógica de acceso a datos.
Uso de un Mapper: Utiliza un Mapper o una librería para transformar las entidades a DTOs. Esto ayuda a evitar que la lógica de mapeo quede dispersa en el código, y mantiene la aplicación organizada.

Ejemplo con MapStruct:
```java
@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User user);
}
```

Evitar el uso de entidades del dominio fuera de la capa de persistencia: No debes transferir las entidades del dominio directamente entre capas, ya que estas pueden contener datos sensibles o innecesarios para el cliente (como identificadores o relaciones complejas). Los DTOs actúan como una capa de protección para evitar exponer detalles internos del dominio.

Minimizar la cantidad de datos en los DTOs: Asegúrate de que los DTOs solo contengan los datos que realmente se necesitan. Esto reduce la sobrecarga en la comunicación entre capas y mejora el rendimiento, especialmente en sistemas distribuidos.

Uso de DTOs para validación: Si los datos son enviados desde el cliente, los DTOs pueden incluir anotaciones de validación para garantizar que la información recibida sea válida antes de realizar cualquier procesamiento.
```java
public class UserDTO {
    @NotBlank
    private String username;
    @Email
    private String email;
}
```

Conversión entre DAO y DTO de manera unidireccional: Mantén la conversión de entidades a DTO de forma unidireccional, ya que las entidades del dominio no deben tener conocimiento de los DTOs, ni los DTOs deben tener lógica relacionada con la persistencia.

Evitar el uso de DTOs complejos: Si es posible, evita la creación de DTOs muy complejos que tengan demasiados campos o estructuras anidadas. Esto podría llevar a un mantenimiento difícil y a un acoplamiento excesivo entre las capas.

Optimización en el uso de DTOs en consultas complejas: En consultas complejas que combinan datos de varias tablas, se recomienda utilizar DTOs personalizados para mapear solo los datos relevantes. Por ejemplo, una consulta que devuelva solo un subconjunto de los atributos de las entidades relacionadas, utilizando un DTO como "vista".
```java
@Query("SELECT new com.example.dto.UserDTO(u.username, u.email) FROM User u WHERE u.status = :status")
List<UserDTO> findActiveUsers(@Param("status") String status);
```

Paginación en DTOs: Para operaciones que involucran grandes volúmenes de datos, utiliza DTOs para representar respuestas paginadas o con filtros, garantizando una buena experiencia de usuario y reduciendo la carga en la red.
```java
public class PaginatedResponseDTO<T> {
    private List<T> data;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
}
```