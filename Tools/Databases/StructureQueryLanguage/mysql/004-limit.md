# `LIMIT` 
**LIMIT** es una cláusula de SQL que se utiliza para restringir el número de filas que devuelve una consulta. Es muy útil cuando deseas obtener solo una parte de los resultados, en lugar de todos los registros. Esta cláusula es soportada por muchos sistemas de bases de datos, como MySQL, PostgreSQL, SQLite, entre otros.

## ¿Qué es LIMIT?
**LIMIT** es una cláusula que permite controlar cuántos registros se deben devolver en el resultado de una consulta SQL. Se utiliza para limitar la cantidad de filas en una consulta, lo que puede mejorar el rendimiento al evitar la carga innecesaria de datos.

## ¿Para qué se utiliza?
1. **Optimización**:

   * Cuando tienes grandes volúmenes de datos, devolver todas las filas puede consumir muchos recursos. **LIMIT** reduce el procesamiento innecesario al devolver solo el número deseado de filas.

2. **Paginación de resultados**:

   * En aplicaciones web o móviles, es común que los resultados se muestren en "páginas" para no abrumar al usuario. La cláusula **LIMIT** junto con **OFFSET** ayuda a realizar la paginación dividiendo los datos en fragmentos pequeños.

3. **Mostrar los primeros resultados**:

   * Si solo te interesa ver los primeros registros de una consulta, por ejemplo, los primeros 10 productos más caros, puedes hacerlo con **LIMIT**.

## ¿Qué problemas resuelve?
* **Gestión de grandes conjuntos de datos**: Evita que una consulta devuelva miles o millones de registros innecesarios. Esto es útil tanto para mejorar el rendimiento como para hacer más manejables los datos.

* **Optimización de recursos**: Ayuda a reducir el consumo de memoria y el tiempo de procesamiento en el servidor, ya que evita el procesamiento completo de todos los registros.

* **Paginar resultados**: Resuelve el problema de manejar grandes conjuntos de datos en interfaces de usuario, donde el usuario solo necesita ver una pequeña porción de los datos en cada momento.

## ¿Cómo lo resuelve?
**LIMIT** restringe el número de filas devueltas por la consulta al número especificado. Es ideal cuando se necesita una muestra o cuando los resultados se deben dividir en secciones más pequeñas.

**Sintaxis**
```sql
SELECT columna1, columna2, ...
FROM tabla
LIMIT número_filas;
```
* **número_filas**: Especifica el número máximo de registros que quieres devolver.

## Ejemplos de uso
1. Devolver los primeros `N` registros:

  ```sql
  SELECT nombre, precio
  FROM productos
  LIMIT 5;
  ```
  Esto devolverá solo los primeros 5 productos de la tabla. Si la tabla tiene 100 productos, solo se mostrará una pequeña porción.

2. **Uso con `ORDER BY`**: Normalmente, se combina con ORDER BY para obtener, por ejemplo, los productos más baratos o caros.

  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY precio DESC
  LIMIT 3;
  ```
  Este ejemplo devolverá los 3 productos más caros (al ordenar el precio en orden descendente).

3. **Uso de `OFFSET` para paginación**: Cuando necesitas dividir los resultados en páginas, se utiliza el parámetro **OFFSET** junto con **LIMIT**. **OFFSET** especifica desde qué fila comenzar a devolver los resultados.

  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY precio DESC
  LIMIT 5 OFFSET 10;
  ```
  Esto devuelve 5 productos, **comenzando desde la fila número 11**. En otras palabras, **omitirás los primeros 10 registros y mostrarás los siguientes 5**.

4. **Paginación en conjunto con aplicaciones web**: Imagina que tienes una interfaz web que muestra 10 productos por página. Si el usuario está en la primera página, puedes ejecutar:

  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY nombre
  LIMIT 10 OFFSET 0;
  ```
  Para la segunda página:
  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY nombre
  LIMIT 10 OFFSET 10;
  ```
  Para la tercera página:
  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY nombre
  LIMIT 10 OFFSET 20;
  ```
  Este patrón permite la navegación por páginas de datos.

## Consideraciones importantes:
1. **Rendimiento**: Aunque **LIMIT** mejora el rendimiento al reducir la cantidad de datos que devuelve la consulta, las filas se siguen procesando **antes de aplicar la limitación**. Para mejorar aún más el rendimiento, es recomendable tener **índices** en las columnas que se utilizan para ordenar los resultados.

2. **Combinación con `ORDER BY`**: Sin un **ORDER BY**, los resultados devueltos con **LIMIT** pueden ser arbitrarios, ya que SQL no garantiza un orden específico. Siempre que uses **LIMIT**, es recomendable que también especifiques el orden de los registros con **ORDER BY**.

3. **Compatibilidad**: La sintaxis de **LIMIT** puede variar ligeramente entre los sistemas de bases de datos. Por ejemplo:

   * En Oracle, se utiliza la cláusula **FETCH** en lugar de **LIMIT**.

   * En SQL Server, se utiliza **TOP** en lugar de **LIMIT**.

   * PostgreSQL, MySQL y SQLite soportan **LIMIT** de manera nativa.

4. **Rango de datos devueltos**: **LIMIT** no garantiza que los datos devueltos representen un subconjunto aleatorio o completo. Si estás usando **LIMIT** en consultas analíticas, debes ser consciente de que no verás todos los resultados y podría haber sesgos en los datos.

# `OFFSET`
En SQL, **OFFSET** es una cláusula que se utiliza para saltar un número determinado de filas en los resultados de una consulta antes de empezar a devolver los resultados. Se suele usar en conjunto con **LIMIT** para implementar paginación, es decir, mostrar un subconjunto de los resultados en diferentes páginas o secciones.

## ¿Para qué se utiliza OFFSET?
* **Paginación**: Es muy útil en sistemas donde necesitas mostrar grandes conjuntos de datos en pequeñas porciones (páginas) y debes navegar a través de ellas. Por ejemplo, en un ecommerce, cuando tienes miles de productos, usas **OFFSET** junto con **LIMIT** para mostrar 20 productos por página y navegar entre las diferentes páginas.

* **Saltos controlados en los resultados**: Permite ignorar un número específico de filas antes de comenzar a devolver los resultados. Esto es útil cuando solo te interesa mostrar o trabajar con datos a partir de una cierta fila.

## Sintaxis
```sql
SELECT column1, column2
FROM table_name
LIMIT cantidad_filas OFFSET filas_a_saltar;
```
* **LIMIT** define cuántas filas devolver después de saltar las filas especificadas por **OFFSET**.

* **OFFSET** especifica cuántas filas omitir desde el principio del resultado.

## Ejemplo de uso:
Imagina que tienes una tabla llamada users con 10,000 registros. Quieres mostrar los registros en bloques de 100, y estás interesado en la tercera "página" de resultados (los usuarios 201-300).

```sql
SELECT first_name, last_name, age
FROM users
LIMIT 100 OFFSET 200;
```
* **LIMIT** 100: Indica que se quieren devolver 100 filas.

* **OFFSET** 200: Indica que se deben saltar las primeras 200 filas y empezar a devolver resultados desde la fila 201 en adelante.

## Consideraciones de rendimiento:
Aunque OFFSET es útil para paginación, también tiene algunas limitaciones de rendimiento a tener en cuenta:

* **Paginaciones profundas**: A medida que el valor de **OFFSET** crece, el rendimiento de la consulta puede degradarse. Esto se debe a que MySQL debe leer y descartar todas las filas hasta llegar al **OFFSET**. Por ejemplo, si usas **OFFSET** 10,000, MySQL debe recorrer esas 10,000 filas, incluso si solo necesitas las siguientes 50.

  * En estos casos, el rendimiento puede sufrir porque, aunque solo devuelve un pequeño subconjunto de datos, el motor de la base de datos todavía está leyendo muchas filas no necesarias.

* Alternativas al **OFFSET**:

  * **Marcadores basados en índices**: En lugar de usar **OFFSET**, podrías usar un marcador de posición que aproveche los índices para determinar dónde empezar la consulta. Este enfoque es mucho más eficiente para grandes conjuntos de datos.