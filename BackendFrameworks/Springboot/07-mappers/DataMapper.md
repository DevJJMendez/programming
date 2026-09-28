# Mapeo de datos
El mapeo de datos es el proceso de transformar o convertir datos de un formato o estructura a otro, generalmente entre la capa de persistencia (base de datos) y las capas superiores de una aplicación (como la capa de servicio o la capa de presentación). Este proceso es comúnmente necesario cuando trabajas con objetos de dominio y DTOs (Data Transfer Objects), entre otras estructuras de datos.

En resumen, el mapeo de datos implica **convertir los datos** que provienen de una fuente (por ejemplo, una base de datos o una API externa) a un formato adecuado para ser usado en otras capas de la aplicación (por ejemplo, una interfaz de usuario o una API interna).

## ¿Para qué sirve el mapeo de datos?
El mapeo de datos tiene múltiples propósitos y ventajas en el diseño de software:

* **Adaptación de formatos**: Permite adaptar el formato de los datos para que puedan ser entendidos por diferentes partes de la aplicación, especialmente cuando trabajas con sistemas distribuidos o aplicaciones de diferentes capas.

* **Separación de responsabilidades**: Ayuda a separar la lógica de negocio de la lógica de acceso a datos. Por ejemplo, puedes tener una representación de datos simple (DTO) que es utilizada en la capa de presentación, mientras que la lógica de negocio y las entidades del dominio permanecen aisladas.

* **Abstracción del acceso a datos**: Permite abstraer las complejidades de las entidades del dominio, ocultando detalles innecesarios como las relaciones de base de datos o los identificadores internos, presentando solo la información relevante.

* **Optimización del rendimiento**: Facilita la transferencia de datos de manera eficiente, eligiendo solo los atributos necesarios para cada capa o endpoint, evitando el sobrecargado de información.

* **Interoperabilidad entre sistemas**: Si necesitas integrar tu sistema con otros sistemas externos (APIs de terceros, microservicios), el mapeo de datos facilita la conversión entre las representaciones de datos de esos sistemas y las tuyas.

## ¿Cuáles son sus características?
El mapeo de datos tiene varias características que lo hacen un proceso fundamental en el desarrollo de software:

1. **Transformación entre formatos**:
  * Puede ser entre **objetos de dominio** y **DTOs** o entre diferentes tipos de **DTOs** (por ejemplo, un DTO para la base de datos y otro para la API).

  * También puede ser entre estructuras de datos complejas o planas.

2. **Automatización del proceso**:
  * Es posible automatizar el mapeo mediante librerías como `MapStruct`, `ModelMapper` o `Dozer`, las cuales facilitan el trabajo de conversión sin necesidad de escribir el código de mapeo a mano.

3. **Evitar dependencias directas**:
   * Se evita la transferencia directa de las entidades de dominio entre capas (por ejemplo, **base de datos → UI**), lo que aumenta la flexibilidad y mantenibilidad del sistema.

4. **Desacoplamiento de capas**:
   * Se proporciona un mecanismo para desacoplar la capa de persistencia de la capa de presentación o negocio, haciendo que cada capa sea más independiente.

5. **Flexibilidad**:
   * Permite tener representaciones personalizadas de los datos según el contexto o la capa en la que se necesiten (por ejemplo, un **DTO** puede incluir solo un subconjunto de los atributos de la entidad del dominio).

## ¿Qué resuelve el mapeo de datos?
El mapeo de datos resuelve varios problemas que surgen cuando se maneja la transferencia de datos entre capas o entre sistemas:

* **Incompatibilidad entre capas**: Cuando las diferentes capas tienen diferentes representaciones de los mismos datos (por ejemplo, las entidades del dominio tienen relaciones complejas, pero los datos que se pasan a la UI solo deben incluir valores simples).

* **Datos no utilizados**: Evita la exposición innecesaria de datos. Las entidades de dominio pueden contener muchos atributos, pero no todos son necesarios para una operación en particular (por ejemplo, al recuperar solo los nombres de usuario y correos electrónicos de una lista de usuarios).

* **Redundancia y reutilización**: Facilita la reutilización de datos de diferentes fuentes, como bases de datos, archivos `JSON` o `XML`, `APIs` externas, sin tener que ajustar manualmente cada vez que se cambian las fuentes o destinos de datos.

* **Rendimiento**: Optimiza el rendimiento de las aplicaciones al reducir el tráfico de datos innecesarios, asegurando que solo se envíen los datos relevantes.

* **Mantenimiento de la coherencia**: Ayuda a mantener la coherencia entre las distintas representaciones de datos, asegurando que los datos mapeados no se pierdan ni se corrompan en el proceso de conversión.

## ¿Cómo lo resuelve?
El mapeo de datos resuelve los problemas mencionados mediante las siguientes estrategias:

1. **Uso de librerías de mapeo**: Herramientas como `MapStruct`, `ModelMapper`, `Dozer` proporcionan una forma automática de mapear entre diferentes tipos de objetos (por ejemplo, entre entidades y DTOs), sin necesidad de escribir manualmente los métodos de mapeo, lo cual ahorra tiempo y reduce errores.

**Ejemplo con `MapStruct`**:
```java
@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User user);
}
```
Aquí, `MapStruct` genera automáticamente el código para mapear un `User` a un `UserDTO`.

2. **Transformación de objetos complejos**: Cuando se tienen objetos complejos que incluyen relaciones o colecciones (por ejemplo, listas o mapas), el mapeo asegura que las relaciones entre las entidades se manejen correctamente y se trasladen a una forma adecuada para su uso en otras capas.

3. **Manejo de la validación y el filtrado**: Durante el mapeo, puedes filtrar o transformar solo los datos necesarios y validar su consistencia antes de enviarlos a su destino final (por ejemplo, asegurando que solo los datos requeridos por la vista sean enviados al cliente).

4. **Desacoplamiento de las capas de la aplicación**: El mapeo asegura que las distintas capas no dependan directamente unas de otras. La capa de presentación no tiene que preocuparse por las relaciones o detalles internos de las entidades, sino que puede trabajar solo con los DTOs.

5. **Optimización del tráfico de red y almacenamiento**: Al mapear solo los datos necesarios para cada operación, el mapeo de datos reduce la cantidad de datos transferidos entre las capas o entre sistemas. Esto es especialmente útil en aplicaciones distribuidas o cuando se usan servicios RESTful.