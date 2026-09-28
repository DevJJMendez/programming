# Explain
El comando `EXPLAIN` en MySQL es una herramienta poderosa que se utiliza para analizar y entender cómo el motor de la base de datos ejecutará una consulta SQL. Específicamente, te proporciona detalles sobre el plan de ejecución que MySQL usará para recuperar los datos, lo cual es extremadamente útil para optimizar consultas y mejorar el rendimiento.

## ¿Para qué se utiliza?
`EXPLAIN` se utiliza principalmente para:

* Comprender el plan de ejecución de una consulta (`SELECT`, `UPDATE`, `DELETE`).

* Optimizar el rendimiento de las consultas.

* Identificar problemas como falta de índices, escaneos completos de tablas o uso incorrecto de `joins`.

## ¿Qué resuelve?
`EXPLAIN` resuelve problemas relacionados con el rendimiento de las consultas SQL, permitiendo que los desarrolladores y administradores de bases de datos:

* Detecten consultas ineficientes.

* Comprendan cómo se accede a los datos.

* Identifiquen cuellos de botella en el procesamiento de consultas.

## ¿Cómo lo resuelve?
`EXPLAIN` proporciona un desglose de cómo se ejecuta una consulta, revelando detalles como:

* Orden de las tablas que se están escaneando.

* Tipos de join utilizados.

* Índices que se utilizan o se ignoran.

* Cantidad de filas que se estiman procesar.

* Filtrado de las filas y condiciones aplicadas.

## Cómo usar `EXPLAIN`
Para usar `EXPLAIN`, simplemente precede la consulta SQL con el comando:
```sql
EXPLAIN SELECT * FROM productos WHERE precio > 100;
```
Esto generará una tabla con múltiples columnas que describen el plan de ejecución de la consulta.

### Principales columnas de salida de EXPLAIN
1. `id`:

   * Identifica el orden en que se ejecutarán las operaciones.

   * Consultas con múltiples subconsultas o **joins** tendrán diferentes id para cada paso.

2. `select_type`:

   * Describe el tipo de consulta.

   * Puede tener valores como:
     * `SIMPLE`: Consulta simple sin joins ni subconsultas.

     * `PRIMARY`: La consulta principal cuando hay subconsultas.

     * `SUBQUERY`: Subconsulta dentro de la consulta principal.

     * `DERIVED`: Consulta derivada, como una subconsulta en un FROM.

3. `table`:

   * La tabla a la que se está accediendo en cada paso.

4. `type`:

   * El tipo de acceso utilizado para recuperar las filas.

   * Los tipos de acceso se ordenan de mejor a peor en términos de rendimiento:

     * `system`: Tabla de una sola fila, muy eficiente.

     * `const`: Comparación con una constante, muy rápida.

     * `eq_ref`: Comparación con una clave primaria o única.

     * `ref`: Comparación con un índice no único.

     * `range`: Escaneo de un rango de índices.

     * `index`: Escaneo completo del índice.

     * `ALL`: Escaneo completo de la tabla (es el más costoso).

5. `possible_keys`:

   * Los índices que podrían haberse utilizado para la consulta. Si NULL, significa que no se encontraron índices que puedan ser utilizados.

6. `key`:

   * El índice que efectivamente se utilizó para la consulta. Si no se usa ninguno, también mostrará NULL.

7. `key_len`:

   * La longitud de la clave utilizada, lo que da una idea de cuántas columnas del índice fueron realmente utilizadas.

8. `ref`:

   * Muestra qué columnas o constantes se comparan con el índice.

9. `rows`:

   * La cantidad estimada de filas que se procesarán. Esto es solo una estimación y puede ayudar a identificar consultas que leen muchas más filas de las necesarias.

10. `filtered`:

    * Un porcentaje estimado de cuántas filas se eliminarán según las condiciones de filtrado (WHERE).

11. `extra`:

    * Información adicional sobre la ejecución, como:
      * **`Using index`**: MySQL está utilizando solo el índice para satisfacer la consulta, sin acceder a las filas de la tabla.

      * **`Using where`**: MySQL está filtrando las filas con la cláusula `WHERE`.

      * **`Using temporary`**: MySQL está usando una tabla temporal (esto puede ser costoso).

      * **`Using filesort`**: Se está realizando un ordenamiento en disco, lo cual suele ser ineficiente.

## Ejemplo de uso de EXPLAIN
```sql
SELECT nombre, precio FROM productos WHERE categoria_id = 3 AND precio > 100 ORDER BY precio;
```
Al usar EXPLAIN, podrías ver una salida como esta:
```plaintext
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+----------------+
| id | select_type | table     | type  | possible_keys | key     | key_len | ref   | rows | Extra          |
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+----------------+
|  1 | SIMPLE      | productos | range | categoria_idx | precio  | 5       | NULL  | 100  | Using where    |
+----+-------------+-----------+-------+---------------+---------+---------+-------+------+----------------+
```
Análisis del resultado

* id = 1: Indica que esta es la única tabla que se está consultando.

* select_type = SIMPLE: Es una consulta simple sin subconsultas ni joins.

* table = productos: Se está accediendo a la tabla productos.

* type = range: MySQL está usando un rango de valores en el índice (lo que es eficiente).

* possible_keys = categoria_idx: Muestra que el índice categoria_idx es un candidato.

* key = precio: MySQL está utilizando el índice sobre la columna precio.

* rows = 100: Estima que se leerán 100 filas de la tabla.

* Extra = Using where: Se está aplicando un filtro sobre las filas leídas (WHERE).

## ¿Cómo ayuda EXPLAIN a optimizar?
* Escaneo completo de tabla (ALL): Si ves que el tipo de acceso es ALL, significa que MySQL está escaneando toda la tabla. Esto generalmente es ineficiente, y podrías optimizar creando índices en las columnas relevantes.

* Uso de índices: Si ves que MySQL no está utilizando un índice (key = NULL), es posible que necesites crear un índice en la columna que estás consultando para mejorar el rendimiento.

* Filtrado de filas: El porcentaje filtered te permite ver cuántas filas serán eliminadas por el filtro. Si este porcentaje es bajo, podrías reconsiderar cómo estructurar tu consulta para ser más eficiente.