# HAVING
El **HAVING** en SQL es una cláusula utilizada para filtrar los resultados de grupos que se crean con la cláusula **GROUP BY**. Se utiliza cuando quieres aplicar condiciones a los resultados después de haber agregado y agrupado los datos, a diferencia de **WHERE**, que se usa para filtrar antes de la agregación.

## Conceptos clave
1. **Filtrado de grupos**: Mientras que **WHERE** filtra filas antes de la agrupación, **HAVING** filtra los grupos generados por **GROUP BY**. Esto permite aplicar condiciones a los resultados agregados, como la suma, el promedio, el conteo, etc.

2. **Usado con funciones agregadas**: **HAVING** se usa principalmente junto con funciones agregadas como **SUM()**, **COUNT()**, **AVG()**, **MIN()**, **MAX()**, lo que permite filtrar grupos basados en el resultado de estas funciones.

**Sintaxis**
```sql
SELECT columna1, AGG_FUNC(columna2)
FROM tabla
GROUP BY columna1
HAVING AGG_FUNC(columna2) condition;
```
* **AGG_FUNC**: Es la función agregada que se aplica al grupo, como **SUM()**, **COUNT()**, **AVG()**, etc.

* **condition**: Es la condición que debe cumplir el resultado de la función agregada.

## ¿Para qué se utiliza?
* **Filtrar grupos de datos**: Después de aplicar un **GROUP BY**, puedes usar **HAVING** para filtrar esos grupos basándote en condiciones como sumar, contar o promediar valores agregados.

* **Generación de reportes detallados**: **HAVING** es útil para refinar informes y análisis de datos al excluir grupos que no cumplan ciertos criterios, por ejemplo, departamentos con un número de empleados inferior a un valor específico o productos con ventas superiores a cierto umbral.

## ¿Qué resuelve?
1. **Filtrar datos agregados**: **HAVING** permite establecer criterios en los datos después de la agrupación, cosa que **WHERE** no puede hacer, ya que **WHERE** se aplica antes de que ocurra la agregación.

2. **Controlar el resultado final de grupos**: Si necesitas excluir ciertos grupos de los resultados (por ejemplo, excluir grupos que tienen un valor de agregación inferior a un límite), **HAVING** te permite hacerlo.

## ¿Cómo lo resuelve?
**HAVING** aplica una condición a cada grupo generado por **GROUP BY**. Después de que se aplican las funciones agregadas a los grupos, la cláusula **HAVING** evalúa las condiciones definidas. Solo los grupos que cumplan con esa condición se devuelven como resultado.

## Ejemplo básico
Supongamos que tienes una tabla de `empleados` con las columnas **departamento**, **salario**, y **nombre**. Quieres obtener los **departamentos** que tienen un salario promedio mayor a 50,000:

```sql
SELECT departamento, AVG(salario) AS salario_promedio
FROM empleados
GROUP BY departamento
HAVING AVG(salario) > 50000;
```
* **Explicación**: Primero se agrupan los empleados por departamento usando **GROUP BY**. Luego, se calcula el salario promedio por departamento con **AVG(salario)**. Finalmente, **HAVING** filtra los grupos y muestra solo aquellos con un salario promedio superior a 50,000.

## Consideraciones importantes
* **Optimización**: Al aplicar filtros en las consultas, es recomendable usar **WHERE** cuando sea posible, ya que es más eficiente que HAVING. Esto se debe a que **WHERE** filtra los datos antes de la agregación, lo que reduce el número de filas que se procesan posteriormente.

* **Indexación**: El uso de índices en las columnas mencionadas en la cláusula **WHERE** y **GROUP BY** puede mejorar el rendimiento de la consulta.

* **Funciones agregadas**: **HAVING** permite usar funciones agregadas, mientras que WHERE no.