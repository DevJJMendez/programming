* `SELECT`: Se utiliza para seleccionar campos ó datos de la base de datos y retornar su información.
  
    ```sql
    SELECT * FROM users;

    SELECT name,last_name,age FROM users;

    SELECT name as user_name FROM users;
    ```

* `SELECT DISTINCT`: Se utiliza para seleccionar **valores únicos** de una columna o combinación de columnas en una consulta. En otras palabras, **elimina duplicados** de los resultados de una consulta, devolviendo solo valores distintos.

    ```sql
    SELECT DISTINCT age FROM users;
    ```

* `LIMIT`: Se utiliza para limitar el número de filas que se devuelven como resultado de una consulta.

    ```sql
    SELECT
        `name` AS user_name, age AS user_age
    FROM
        users
    LIMIT 100;
    ```