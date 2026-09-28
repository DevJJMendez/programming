# `ORDER BY`
**ORDER BY** es una cláusula de SQL que se utiliza para ordenar el conjunto de resultados de una consulta según uno o más campos (columnas). Esta cláusula permite especificar el criterio de ordenación, ya sea de forma ascendente o descendente, y es especialmente útil para organizar la presentación de datos de manera lógica o significativa.

## ¿Qué es ORDER BY?
La cláusula **ORDER BY** en SQL se emplea para ordenar los registros obtenidos de una consulta en una base de datos, según el valor de una o más columnas. El orden puede ser:

* **Ascendente** (por defecto): de menor a mayor (A-Z, 0-9).

* **Descendente**: de mayor a menor (Z-A, 9-0).

## ¿Para qué se utiliza?
Se utiliza para:

1. **Organizar los resultados de las consultas**:

   * Facilita la visualización de los datos, al ordenar los registros de manera coherente, por ejemplo, por fechas, nombres, o cualquier otra columna relevante.

2. **Mejorar la presentación de los datos**:

   * Al permitir al usuario ordenar los resultados, estos se muestran de manera más comprensible o útil, como en un listado de productos ordenados por precio.

3. **Aumentar la legibilidad y análisis**:

   * En conjunto con otras cláusulas como **`LIMIT`** o **`OFFSET`**, se pueden ordenar grandes volúmenes de datos y mostrar solo los más relevantes (ej., los 10 productos más caros).

## ¿Qué problemas resuelve?
**ORDER BY** resuelve la necesidad de estructurar los resultados de una consulta de manera ordenada y lógica. En muchas aplicaciones, es crucial que los datos no aparezcan en un orden arbitrario. Por ejemplo:

1. **Datos desordenados**:

   * **Problema**: Si ejecutas una consulta sin ordenar los datos, los resultados pueden mostrarse de manera aleatoria o sin ningún patrón claro.

   * **Solución**: **ORDER BY** asegura que los resultados estén organizados según los criterios especificados.

2. **Filtrado en un rango ordenado**:

   * **Problema**: En ciertas ocasiones, necesitas mostrar los resultados en orden para aplicar otros criterios, como mostrar los valores más altos o más bajos.

   * **Solución**: Con **ORDER BY**, puedes ordenar los resultados y luego aplicar restricciones como `LIMIT` para ver los registros más relevantes.

## ¿Cómo lo resuelve?
**ORDER BY** organiza los registros en la base de datos de acuerdo a las reglas que establezcas (por una o varias columnas y en un orden específico), garantizando que los resultados sean más fáciles de leer y procesar.

**Sintaxis básica**
```sql
SELECT columna1, columna2, ...
FROM tabla
ORDER BY columna1 [ASC | DESC], columna2 [ASC | DESC], ...;
```
* `ASC`: Orden ascendente (por defecto).

* `DESC`: Orden descendente.

## Ejemplos de uso

1. **Ordenación básica por una columna**:
  
  ```
  SELECT nombre, precio
  FROM productos
  ORDER BY precio ASC;
  ```
  Esto ordenará los productos de menor a mayor precio. Como el orden ascendente es el predeterminado, podrías omitir `ASC`.

2. **Orden descendente**:

  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY precio DESC;
  ```
  En este caso, los productos se ordenan de mayor a menor precio.

3. **Ordenar por varias columnas**:

  ```sql
  SELECT nombre, precio, fecha_publicacion
  FROM productos
  ORDER BY precio ASC, fecha_publicacion DESC;
  ```
  Aquí, primero se ordenan los productos por **precio** de manera ascendente. Si dos productos tienen el mismo precio, se ordenan por **fecha_publicación** de manera descendente (del más reciente al más antiguo).

4. Ordenar por columnas no incluidas en el `SELECT`

  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY categoria ASC, precio DESC;
  ```
  Aunque la columna categoria no se muestra en los resultados, la consulta ordenará primero por la categoría y luego por el precio en orden descendente.

5. **Uso de expresiones en `ORDER BY`**: Puedes usar expresiones en la cláusula **ORDER BY**, no necesariamente solo columnas.

  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY precio * 1.1 DESC;
  ```
  Aquí, los productos se ordenarán según el precio multiplicado por un factor del 1.1 (incremento del 10%).

6. **Uso de alias en `ORDER BY`**: Es posible utilizar alias definidos en la consulta en la cláusula **ORDER BY**.

  ```sql
  SELECT nombre, precio, precio * 1.15 AS precio_con_impuesto
  FROM productos
  ORDER BY precio_con_impuesto DESC;
  ```
  Aquí, los productos se ordenan en función del alias `precio_con_impuesto`.

7. **Ordenar con `NULL`**: En muchas bases de datos, los valores **NULL** se ordenan al principio o al final por defecto, dependiendo de si usas **ASC** o **DESC**. Sin embargo, en algunos DBMS, puedes controlar explícitamente el orden de los valores **NULL**:

  ```sql
  SELECT nombre, precio
  FROM productos
  ORDER BY precio ASC NULLS LAST;
  ```
  Este comando asegura que los valores **NULL** aparecerán al final de los resultados.

## Consideraciones importantes
1. **Rendimiento**: El uso de **ORDER BY** puede ser costoso en términos de rendimiento, especialmente en grandes conjuntos de datos, ya que implica que el DBMS ordene los resultados antes de devolverlos. Usar índices en las columnas que se ordenan puede mejorar el rendimiento considerablemente.

2. **Comportamiento no determinado**: Si no especificas una columna para ordenar, los resultados pueden no estar en ningún orden predecible. Dependerá del motor de la base de datos o del orden físico de almacenamiento.

3. **`ORDER BY` y `GROUP BY`**: Si usas ambas cláusulas en una consulta, **ORDER BY** generalmente viene después de **GROUP BY**. Esto permite ordenar los grupos agregados.

4. **Compatibilidad de Bases de Datos**: Aunque el uso de **ORDER BY** es estándar, algunos motores de bases de datos como **MySQL** o **PostgreSQL** pueden tener comportamientos ligeramente diferentes en cuanto a cómo manejan los valores nulos o ciertos tipos de datos.