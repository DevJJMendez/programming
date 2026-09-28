# `UNION`
El operador **UNION** en SQL es utilizado para combinar los resultados de dos o más sentencias **SELECT** en un solo conjunto de resultados. Este operador se encarga de unir los conjuntos de datos de diferentes consultas en uno solo, eliminando duplicados, a menos que se utilice explícitamente el operador **UNION ALL**, que conserva los duplicados.

## Conceptos Clave:
* **Combinación de Resultados**: **UNION** toma dos o más consultas **SELECT** y combina sus resultados en un solo conjunto. Por ejemplo, si tienes dos tablas y deseas mostrar todas las filas de ambas, puedes utilizar UNION.

* **Eliminación de Duplicados**: Por defecto, **UNION** elimina cualquier fila duplicada entre los resultados combinados de las consultas. Si deseas mantener los duplicados, puedes usar **UNION ALL**.

* **Condiciones para Usar UNION**:

  * Las consultas que se combinan deben tener el mismo número de columnas en sus resultados.

  * Las columnas correspondientes de ambas consultas deben tener tipos de datos compatibles.

  * El orden en que las columnas aparecen debe ser el mismo.

* **Estructura de la Sintaxis**:

```sql
SELECT columna1, columna2, ...
FROM tabla1
UNION
SELECT columna1, columna2, ...
FROM tabla2;
```
Si quieres incluir duplicados:
```sql
SELECT columna1, columna2, ...
FROM tabla1
UNION ALL
SELECT columna1, columna2, ...
FROM tabla2;
```

## ¿Para qué se utiliza?
El operador UNION se utiliza cuando deseas combinar filas de diferentes consultas en un solo conjunto de resultados, especialmente cuando estas consultas devuelven resultados similares, pero desde diferentes fuentes o bajo diferentes condiciones.

## ¿Qué problemas resuelve?
1. **Combinar Resultados de Varias Tablas**: Si tienes datos distribuidos en varias tablas que no están directamente relacionadas, pero necesitas obtener una vista unificada, UNION es una solución eficiente. Ejemplo:

   * **Escenario en un sistema de eCommerce**: Una tienda tiene diferentes tablas para las ventas en línea y las ventas en tiendas físicas. Si quieres hacer un reporte global de todas las ventas, puedes utilizar UNION para combinarlas:

```sql
SELECT order_id, customer_name, total_price, 'Online' as source
FROM online_sales
UNION
SELECT order_id, customer_name, total_price, 'In-store' as source
FROM store_sales;
```
En este caso, UNION te da un informe combinado de todas las ventas, ya sean en línea o en tiendas físicas.

2. Evitar Duplicación: Si deseas combinar los resultados de varias consultas, pero sin mostrar duplicados, UNION te permite lograr esto automáticamente sin la necesidad de agregar cláusulas adicionales como DISTINCT.

3. Unificación de Consultas con Diferentes Filtros: Cuando necesitas obtener resultados que cumplen con diferentes criterios y quieres que se muestren todos en un mismo conjunto, UNION es ideal. Por ejemplo, si quieres obtener todos los clientes que han hecho compras este mes, tanto de productos electrónicos como de ropa, puedes hacer algo como:

```sql
SELECT customer_id, purchase_date
FROM electronics_sales
WHERE purchase_date >= '2024-10-01'
UNION
SELECT customer_id, purchase_date
FROM clothing_sales
WHERE purchase_date >= '2024-10-01';
```

## ¿Cómo lo resuelve?
* **Procesamiento Interno**: El sistema de bases de datos ejecuta las consultas SELECT por separado, luego toma los resultados y los combina en un solo conjunto. Si utilizas UNION (sin ALL), el sistema también revisa y elimina los duplicados.

* **Manejo de Duplicados**: Si hay filas que son idénticas en todas las columnas que se están combinando, estas serán removidas, lo que hace a UNION útil en casos donde solo quieres filas únicas en el conjunto de resultados final.