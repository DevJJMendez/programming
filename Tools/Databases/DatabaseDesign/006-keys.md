# Llaves

las llaves son elementos clave que se utilizan para identificar de manera única registros individuales en una tabla y establecer relaciones entre tablas. Hay varios tipos de llaves que desempeñan roles diferentes en la estructura y la integridad de una base de datos. Aquí te presento los tipos de llaves más comunes:

- Clave Primaria (Primary Key - PK):

  - La clave primaria es un campo o combinación de campos que identifica de manera única cada registro en una tabla.
  - Garantiza la unicidad de los registros y previene la inserción de duplicados.
  - Suele estar definida como NOT NULL (no puede tener valores nulos) y debe ser única para cada registro.
  - Ejemplo: en una tabla de empleados, el ID de empleado podría ser la clave primaria.

- Clave Foránea (Foreign Key - FK):
  
  - La clave foránea es un campo o combinación de campos que establece una relación entre dos tablas.
  - El valor de la clave foránea en una tabla hace referencia al valor de la clave primaria en otra tabla.
  - Se utiliza para mantener la integridad referencial y establecer las relaciones entre tablas.
  - Ejemplo: en una tabla de pedidos, la clave foránea podría ser el ID del cliente que hace referencia al ID de cliente en la tabla de clientes.
  
- Clave Candidata (Candidate Key):
  - Una clave candidata es un conjunto de uno o más campos que podrían ser utilizados como clave primaria.
  - Cumple con la propiedad de unicidad, es decir, no permite valores duplicados.
  - Aunque solo uno de los candidatos se convierte en la clave primaria, los otros se denominan claves candidatas.
  - Ejemplo: en una tabla de productos, tanto el código de producto como el nombre podrían ser claves candidatas.

- Clave Alternativa (Alternate Key):
  - La clave alternativa es un término a veces utilizado para referirse a las claves candidatas que no se eligen como clave primaria.
  - Aunque no se utilizan como clave primaria, siguen siendo útiles para identificar de manera única registros en la tabla.
  - Ejemplo: si el código de producto no se elige como clave primaria en la tabla de productos, se convierte en una clave alternativa.

- Clave Compuesta (Composite Key):
  
  - Una clave compuesta es una combinación de dos o más campos que se utiliza como clave primaria.
  - Permite identificar de manera única registros combinando los valores de varios campos.
  - Ejemplo: en una tabla de pedidos, la clave compuesta podría ser la combinación del ID de pedido y el ID de producto para identificar un pedido específico de un producto específico.

- Clave única (Unique Key):

  En una base de datos es un atributo o conjunto de atributos que garantiza que los valores en esa columna o combinación de columnas sean únicos en toda la tabla. Es similar a una clave primaria en el sentido de que asegura la unicidad de los registros, pero a diferencia de la clave primaria, una tabla puede tener múltiples claves únicas.

  Aquí hay algunas características importantes de las claves únicas:
  
  - Unicidad: La clave única garantiza que no puede haber dos registros en la tabla con el mismo valor en la columna o combinación de columnas definida como clave única. Esto evita la duplicación de datos y garantiza la integridad de los registros.
  - Nullabilidad: A diferencia de la clave primaria, una clave única puede permitir valores nulos en la columna o combinación de columnas definida como clave única. Sin embargo, si se permite un valor nulo, solo puede haber un registro con ese valor nulo en la tabla.
  - Índice implícito: Las claves únicas suelen tener un índice implícito creado automáticamente por el sistema de gestión de bases de datos (SGBD) para mejorar el rendimiento de las consultas que involucran búsquedas por los valores de la clave única.
  - Utilidad en restricciones: Las claves únicas también se utilizan a menudo para establecer restricciones de integridad de datos, como las restricciones de clave única (Unique Constraint), que garantizan que no se puedan insertar registros con valores duplicados en la columna o combinación de columnas definida como clave única.