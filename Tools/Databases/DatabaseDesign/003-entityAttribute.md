# Entidades
Una entidad representa un objeto o concepto del mundo real que se desea modelar en la base de datos.

**Ejemplo**

En una base de datos de una tienda en línea, las entidades podrían ser:
  - Cliente
  - Producto
  - Pedido

# Atributos

Los atributos son las propiedades o características de una entidad que permiten describirla y distinguirla de otras entidades.

**Ejemplo**

En la entidad **Cliente**, los atributos podrían ser:
- "ID"
- "Nombre"
- "Email"
- "Teléfono"

## Relación entre Entidades y Atributos:

- Cada entidad tiene un conjunto de atributos que la describen y definen sus propiedades.
- Los atributos pueden ser simples (un solo valor) o compuestos (varios valores que se agrupan, como una dirección que incluye calle, ciudad y país).
- Además, cada entidad suele tener un atributo que actúa como clave primaria, es decir, un atributo único que identifica de manera exclusiva a cada instancia de esa entidad.

## Tipos de Entidades

- **Entidades Fuertes**:
  
  - También conocidas como entidades principales, son aquellas que existen de manera independiente y tienen una existencia propia en el modelo de datos.
  - **Por ejemplo**, en un sistema de gestión de biblioteca, la entidad "**Libro**" sería una entidad fuerte, ya que puede existir por sí sola sin depender de otras entidades.
  
- **Entidades Débiles**:
  
  - Son entidades que dependen de una entidad fuerte para existir, es decir, no pueden existir de manera independiente.
  - Para identificar una entidad débil, se utiliza una clave parcial que incluye la clave primaria de la entidad fuerte a la que está asociada.
  - **Por ejemplo**, en un sistema de reservas de hotel, la entidad "**Habitación**" podría ser una entidad débil si depende de la entidad fuerte "**Hotel**" para existir, y su clave parcial podría ser el número de habitación.

- **Entidades Asociativas**:
  - Son entidades que se utilizan para representar relaciones entre otras entidades.
  - No tienen atributos propios más allá de sus claves primarias, que son claves foráneas de las entidades que relaciona.
  - Por ejemplo, en un sistema de gestión de matrículas en una universidad, la entidad "**Matrícula**" podría ser una entidad asociativa que relaciona las entidades "**Estudiante**" y "**Curso**".
  
- **Entidades Independientes**:
  - Son entidades que no tienen relaciones con otras entidades en el modelo de datos.
  - Pueden ser tanto entidades fuertes como débiles, pero su característica principal es que no participan en relaciones con otras entidades.
  - **Por ejemplo**, una entidad que almacena información de configuración de un sistema podría ser una entidad independiente.