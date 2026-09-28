# Aggregate Functions
Las Aggregate Functions en SQL son funciones que permiten realizar cálculos sobre un conjunto de valores y devolver un solo valor. Son útiles para obtener resúmenes de datos y analizar grandes volúmenes de información. Las funciones más comunes son `MIN()`, `MAX()`, `COUNT()`, `SUM()` y `AVG()`.

## `MIN()`
* **¿Qué es?**: **MIN()** devuelve el valor más pequeño de una columna específica.

* **¿Para qué se utiliza?**: Se utiliza para encontrar el valor mínimo en un conjunto de datos. Es útil en análisis donde necesitas identificar el valor más bajo, como el precio más bajo de un producto, la menor edad de un grupo de personas, etc.

* **Ejemplo**:

  ```sql
  SELECT MIN(salary) FROM employees;
  ```
  Esto devolverá el salario más bajo de todos los empleados.

## `MAX()`
* **¿Qué es?**: **MAX()** devuelve el valor más grande de una columna específica.

* **¿Para qué se utiliza?**: Se utiliza para encontrar el valor máximo en un conjunto de datos, como el precio más alto, la mayor edad, etc.

* **Ejemplo**

  ```sql
  SELECT MAX(salary) FROM employees;
  ```
  Esto devolverá el salario más alto entre todos los empleados.

## `COUNT()`
* **¿Qué es?**: **COUNT()** devuelve el número de filas que coinciden con una condición, o el número total de filas si no se especifica ninguna condición.

* **¿Para qué se utiliza?**: Es muy útil para contar el número de registros en una tabla o aquellos que cumplen con una condición específica. No considera valores NULL.

* **Ejemplo**

  ```sql
  SELECT COUNT(*) FROM employees;
  ```
  Esto devolverá el número total de empleados en la tabla.

  * Si deseas contar solo empleados que tengan un salario, puedes usar:

    ```sql
    SELECT COUNT(salary) FROM employees;
    ```
    Esto devolvera el número de empleados que tengan un salario

## `SUM()`
* **¿Qué es?**: **SUM()** calcula la suma total de una columna numérica.

* **¿Para qué se utiliza?**: Es útil para calcular el total de valores, como el total de ventas, el total de salarios pagados, etc.

* **Ejemplo**

  ```sql
  SELECT SUM(salary) FROM employees;
  ```
  Esto devolverá la suma total de los salarios de todos los empleados.

## `AVG()`
* **¿Qué es?**: **AVG()** devuelve el valor promedio de una columna numérica.

* **¿Para qué se utiliza?**: Se usa para calcular el promedio de un conjunto de valores, como el salario promedio, el precio promedio, etc.

* **Ejemplo**

  ```sql
  SELECT AVG(salary) FROM employees;
  ```
  Esto devolverá el salario promedio de todos los empleados.

# Usando `GROUP BY` con Funciones Agregadas
Las funciones agregadas son más poderosas cuando se utilizan junto con la cláusula GROUP BY. Esto permite realizar cálculos sobre subconjuntos de datos agrupados por una o más columnas.

* Ejemplo

  ```sql
  SELECT department_id, AVG(salary)
  FROM employees
  GROUP BY department_id;
  ```
  Esto devolverá el salario promedio de cada departamento.