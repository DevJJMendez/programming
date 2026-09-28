# WHERE
Se utiliza en SQL para filtrar filas específicas de una tabla en función de una condición o conjunto de condiciones. Es una parte fundamental de las consultas SQL y permite seleccionar solo las filas que cumplan con ciertos criterios.

# Operadores de comparacion
Los operadores de comparación son símbolos o palabras clave utilizadas en programación y en bases de datos **para comparar dos valores y determinar la relación entre ellos**. Estos operadores son fundamentales para realizar evaluaciones lógicas y tomar decisiones condicionales en el flujo de un programa o en la ejecución de consultas en una base de datos.

![operadoresComparacion](/images/003-operators.png)

- **Igual a** `=`: Este operador se utiliza para verificar si dos valores son iguales.
  ```sql
  SELECT 
    `name` AS user_name
  FROM
      users
  WHERE
      age = 18;
  ```
  Esta sentencia retornara el nombre de los usuarios que tengan la edad igual a 18.

- **Diferente de** `!=` o `<>`: Estos operadores se utilizan para verificar si dos valores no son iguales.
  ```sql
  SELECT 
      `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age != 18;
  ```

- **Mayor que** `>`: Se utiliza para verificar si un valor es mayor que otro.
  ```sql
  SELECT 
    `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age > 18;
  ```
- **Menor que** `<`: Se utiliza para verificar si un valor es menor que otro.
  ```sql
  SELECT 
    `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age < 18;
  ```
- **Mayor o igual que** `>=`: Se utiliza para verificar si un valor es mayor o igual que otro.
  ```sql
  SELECT 
    `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age >= 18;
  ```
- **Menor o igual que** `<=`: Se utiliza para verificar si un valor es menor o igual que otro.
  ```sql
  SELECT 
    `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age <= 18;
  ```
* `BETWEEN`: Se utiliza para evaluar si un valor está dentro de un rango especificado. En otras palabras, determina si un valor se encuentra entre dos valores límites dados, incluyendo esos límites.

  ```sql
  SELECT 
      `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age BETWEEN 20 AND 30;
  ```

# Operadores Logicos
Los operadores lógicos son símbolos o palabras clave utilizadas en programación y en bases de datos para realizar operaciones lógicas entre dos o más condiciones o expresiones booleanas. Estos operadores permiten combinar o modificar el resultado de las evaluaciones lógicas, lo que es fundamental para el control del flujo de un programa o para la ejecución de consultas condicionales en una base de datos.

- **AND**:
  El operador **AND** se utiliza para evaluar si dos condiciones son verdaderas al mismo tiempo. Devuelve verdadero si ambas condiciones son verdaderas; de lo contrario, devuelve falso.
  ```sql
  SELECT 
    `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age > 18 AND `name` = 'misty boyle';
  ```

- **OR**:
  El operador **OR** se utiliza para evaluar si al menos una de las dos condiciones es verdadera. Devuelve verdadero si alguna de las condiciones es verdadera; de lo contrario, devuelve falso.
  ```sql
  SELECT 
    `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      age > 18 OR `name` = 'misty boyle';
  ```

- **NOT**:
  El operador **NOT** se utiliza para invertir el resultado de una condición. Devuelve verdadero si la condición es falsa, y falso si la condición es verdadera.
  ```sql
  SELECT 
    `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      NOT age = 18;
  ```

# Combinar Operadores
Para usar diferentes operadores en una sentencia SQL debemos usar parentesis.

  ```sql
  SELECT 
      `name` AS user_name, age AS user_age
  FROM
      users
  WHERE
      (age >= 18 AND age <= 20)
          AND NOT age = 50;
  ```

# Evaluacion de Cortocircuito
En muchos sistemas de gestión de bases de datos, la evaluación de condiciones puede tener un comportamiento de cortocircuito. Esto significa que, en una expresión compuesta con **AND**, si la primera condición es **falsa**, **la segunda no se evaluará** porque ya se sabe que la expresión completa será falsa.

```sql
SELECT 
    `name` AS user_name, age AS user_age
FROM
    users
WHERE
    name = 'usuario_que_no_existe' AND age = 50;
```