# `GROUP BY`
El comando **GROUP BY** en SQL se utiliza para agrupar filas que tienen valores idénticos en una o más columnas, permitiendo aplicar funciones agregadas a cada grupo de resultados. Es fundamental en consultas que requieren un análisis agregado de datos, ya que facilita la agrupación de registros y la aplicación de cálculos como `COUNT()`, `SUM()`, `AVG()`, `MIN()`, `MAX()` entre otros.

## Conceptos clave
1. **Agrupación de Datos**: El propósito principal de **GROUP BY** es organizar los datos en grupos basados en los valores de una o más columnas.

2. **Funciones Agregadas**: A menudo se usa en combinación con funciones como **SUM()**, **COUNT()**, **AVG()**, **MAX()**, **MIN()** para realizar cálculos en cada grupo. Estas funciones operan sobre el conjunto de valores de cada grupo.

3. **Sintaxis**

```sql
SELECT columna1, columna2, AGG_FUNC(columna3)
FROM tabla
GROUP BY columna1, columna2;
```
En esta consulta, los resultados se agrupan según los valores de **columna1** y **columna2**, y la función agregada (**AGG_FUNC**) se aplica a cada grupo.

## ¿Para qué se utiliza?
* **Agrupación de datos similares**: **GROUP BY** se utiliza para dividir un conjunto de datos en grupos según valores compartidos en una o más columnas.

* **Realizar análisis y cálculos**: Es útil cuando necesitas realizar cálculos sobre cada grupo, por ejemplo, contar cuántos elementos hay en cada categoría, sumar totales, promediar valores, etc.

* **Generación de informes**: Permite generar informes consolidados, por ejemplo, reportes de ventas por categoría, número de empleados por departamento, ingresos totales por región, entre otros.

## ¿Qué problemas resuelve?
1. **Agregación por categoría o grupos**: Permite realizar cálculos que se aplican a subconjuntos de datos agrupados, en lugar de hacerlo sobre el conjunto completo. Ejemplo: calcular el total de ventas por cliente o el número de empleados en cada departamento.

2. **Evitar la repetición de cálculos manuales**: Automatiza la operación de agrupar datos y calcular totales, promedios u otros valores agregados, lo cual sería mucho más complejo y propenso a errores si se intentara hacer manualmente.

3. **Análisis de datos en grandes tablas**: Agrupar datos en grandes conjuntos de registros facilita obtener información útil de manera más eficiente y rápida, lo que ayuda en análisis de negocios o en reportes financieros.

## ¿Cómo lo resuelve?
**GROUP BY** organiza las filas de una tabla en grupos, basándose en los valores de una o más columnas. A continuación, se aplican funciones agregadas a cada grupo. Cada grupo representa un conjunto de filas que comparte el mismo valor (o conjunto de valores) en las columnas indicadas.

## Ejemplo básico
Supongamos que tienes una tabla de ventas (**ventas**), con las siguientes columnas: `id_venta`, `id_cliente`, `monto`, y `fecha`.

```sql
SELECT id_cliente, SUM(monto)
FROM ventas
GROUP BY id_cliente;
```
* **Explicación**: Agrupa las ventas por `id_cliente` y calcula la suma total `SUM()` del monto para cada cliente.

* **Resultado**: Cada fila del resultado representará un cliente, con su respectivo total de compras.

## Ejemplo detallado:
Si tienes una tabla llamada empleados con las columnas `departamento`, `salario`, y `nombre`, y deseas saber cuál es el salario promedio por `departamento`:

```sql
SELECT departamento, AVG(salario) AS salario_promedio
FROM empleados
GROUP BY departamento;
```
* **Explicación**: Agrupa a los empleados por el departamento en el que trabajan, y calcula el salario promedio de cada grupo usando AVG(salario).

* **Resultado**: Para cada departamento, verás el salario promedio.

## Consideraciones importantes
1. **Columnas en SELECT**: Todas las columnas en el **SELECT** que no estén siendo utilizadas por funciones agregadas deben aparecer en la cláusula **GROUP BY**. Esto asegura que los datos se agrupen correctamente.

```sql
SELECT columna1, AGG_FUNC(columna2)
FROM tabla
GROUP BY columna1;
```
Si no lo haces, se producirá un error o resultados inconsistentes.

2. **Usar múltiples columnas**: Puedes agrupar por múltiples columnas para obtener resultados más específicos. Por ejemplo, si deseas calcular el total de ventas por cliente y por producto, la consulta sería:

```sql
SELECT id_cliente, id_producto, SUM(monto)
FROM ventas
GROUP BY id_cliente, id_producto;
```
**Resultado**: Tendrás una fila por cada combinación de cliente y producto, mostrando el total de ventas para cada cliente en cada producto.

3. **Ordenamiento**: Puedes usar **ORDER BY** junto con **GROUP BY** para ordenar los resultados finales:

```sql
SELECT id_cliente, SUM(monto) AS total_compras
FROM ventas
GROUP BY id_cliente
ORDER BY total_compras DESC;
```
Esto ordenará a los clientes por el monto total de sus compras en orden descendente.