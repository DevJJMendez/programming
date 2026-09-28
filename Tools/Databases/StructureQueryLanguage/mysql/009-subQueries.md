# Subconsultas
Las subconsultas, también conocidas como **subqueries** o **inner queries**, son consultas anidadas dentro de otra consulta SQL. Se ejecutan antes de la consulta principal y sus resultados se utilizan como entrada para esa consulta principal. Las subconsultas pueden aparecer en la cláusula `SELECT`, `FROM`, `WHERE`, `HAVING`, o incluso en la cláusula `JOIN` de una consulta SQL.

## ¿Para qué se utilizan las subconsultas?
Las subconsultas se utilizan para realizar consultas más complejas, donde una consulta sola no puede resolver el problema. Son útiles cuando se necesita:

* Filtrar datos basados en los resultados de otra consulta.

* Comparar un valor con un conjunto de resultados.

* Obtener valores calculados o agregados dentro de una consulta más grande.

* Dividir una tarea compleja en partes más manejables que se resuelven en pasos sucesivos.

## ¿Qué resuelven las subconsultas?
1. **Modularidad en consultas complejas**: Permiten estructurar consultas de forma más modular, evitando la repetición de código y mejorando la legibilidad.

2. **Consultas jerárquicas**: Permiten realizar una consulta basada en los resultados de otra, lo cual es útil cuando se requiere información jerárquica o dependiente de varios niveles de datos.

3. **Consultas dependientes de agregados**: Las subconsultas pueden calcular valores agregados (como `SUM`, `AVG`, `MAX`, `MIN`) que luego se pueden comparar con otras columnas o tablas.

## ¿Cómo resuelven las subconsultas estos problemas?
* **Anidando consultas**: Las subconsultas permiten ejecutar primero una consulta que resuelve parte del problema y luego pasar ese resultado a una consulta de nivel superior.

* **Filtrando datos**: Las subconsultas pueden devolver un conjunto de valores específicos para usar en la consulta principal, lo que permite filtrar los resultados de forma más eficiente.

* **Operaciones condicionales complejas**: Permiten realizar operaciones complejas como cálculos, agregados o comparaciones que no se pueden resolver directamente en la consulta principal.

## Tipos de subconsultas
1. **Subconsultas Escalares (Scalar Subqueries)**

   * Devuelven un único valor (una sola fila y columna).

   * Se pueden utilizar en cualquier lugar donde se permita un valor simple (por ejemplo, en la cláusula `SELECT` o `WHERE`).

   * **Ejemplo**
    
    ```sql
    SELECT first_name, last_name
    FROM employees
    WHERE salary > (SELECT AVG(salary) FROM employees);
    ```
    En este caso, la subconsulta devuelve un valor agregado (el salario promedio), y la consulta principal filtra a los empleados cuyo salario es mayor al promedio.

2. **Subconsultas de Múltiples Filas (Multiple-Row Subqueries)**

   * Devuelven más de una fila, generalmente con una sola columna.

   * Se utilizan en combinación con operadores como `IN`, `ANY`, `ALL`.
   
   * **Ejemplo**

    ```sql
    SELECT first_name, last_name
    FROM employees
    WHERE department_id IN (SELECT department_id FROM departments WHERE location = 'New York');
    ```
    Aquí, la subconsulta selecciona todos los `department_id` de `departamentos` ubicados en **Nueva York**, y la consulta principal selecciona a los empleados que pertenecen a esos departamentos.

3. **Subconsultas de Múltiples Columnas (Multiple-Column Subqueries)**

   * Devuelven más de una columna y se pueden usar en la cláusula IN o en comparaciones.

   * **Ejemplo**:

    ```sql
    SELECT employee_id, first_name, last_name
    FROM employees
    WHERE (department_id, job_id) IN (SELECT department_id, job_id FROM job_history WHERE employee_id = 101);
    ```
  
4. **Subconsultas Correlacionadas (Correlated Subqueries)**

   * Dependen de la consulta principal para cada fila. Es decir, cada vez que se evalúa una fila en la consulta principal, la subconsulta se vuelve a ejecutar.

   * Son más complejas y a menudo más lentas, pero útiles en casos donde los datos son interdependientes.

   * **Ejemplo**:

    ```sql
    SELECT e.first_name, e.last_name
    FROM employees e
    WHERE e.salary > (SELECT AVG(salary) FROM employees WHERE department_id = e.department_id);
    ```
    Aquí, la subconsulta se correlaciona con la consulta principal, ya que filtra los empleados cuyo salario es mayor que el promedio de su propio departamento.

## Cláusulas comunes donde se utilizan subconsultas
1. En la cláusula `WHERE`

   * La subconsulta se utiliza para devolver un valor o un conjunto de valores que sirven para filtrar los resultados de la consulta principal.

   * **Ejemplo**
    
    ```sql
    SELECT first_name, last_name
    FROM employees
    WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'IT');
    ```

2. **En la cláusula `FROM`**:

   * La subconsulta actúa como una tabla temporal para la consulta principal.

   * **Ejemplo**:

    ```sql
    SELECT avg_salary.department_id, avg_salary.avg_salary
    FROM (SELECT department_id, AVG(salary) AS avg_salary FROM employees GROUP BY department_id) avg_salary
    WHERE avg_salary.avg_salary > 5000;
    ```

3. 
## ¿Cuándo utilizar subconsultas?
1. **Cuando necesitas resultados complejos**: Las subconsultas son útiles cuando necesitas realizar cálculos o filtrados que involucran varias capas de datos.

2. **Cuando los JOIN no son adecuados**: A veces, una subconsulta puede ser más legible o fácil de implementar que un JOIN complejo, especialmente cuando se filtran datos con condiciones específicas.

3. **Cuando quieres dividir una consulta compleja**: Las subconsultas permiten simplificar consultas complejas dividiéndolas en pasos lógicos más pequeños.

## Ventajas de las subconsultas:
* **Modularidad**: Rompen consultas complejas en partes más manejables.

* **Legibilidad**: A veces, las subconsultas son más fáciles de leer que consultas con múltiples `JOIN`.

* **Flexibilidad**: Se pueden usar en varias partes de una consulta SQL, como en `SELECT`, `FROM`, `WHERE`, y más.

## Desventajas de las subconsultas:
* **Rendimiento**: En algunos casos, las subconsultas pueden ser menos eficientes que los JOIN o que las consultas reescritas de manera diferente, especialmente las subconsultas correlacionadas que se ejecutan repetidamente.

* **Complejidad**: Aunque pueden simplificar algunas tareas, en situaciones muy anidadas, las subconsultas pueden volverse difíciles de mantener y depurar.