# Joins
Los JOINS en SQL permiten combinar filas de dos o más tablas en función de una relación lógica entre las columnas. Son esenciales para consultas que requieren datos distribuidos en diferentes tablas dentro de una base de datos relacional.

## ¿Qué son los JOINS?
Los JOINS son operaciones que permiten unir datos de múltiples tablas basadas en condiciones específicas. Esto es útil porque, en bases de datos bien normalizadas, los datos relevantes a menudo se encuentran dispersos en diferentes tablas. Por ejemplo, si tienes una tabla de empleados y una tabla de departamentos, los JOINS permiten combinar ambas para consultar, por ejemplo, los nombres de los empleados y los nombres de sus respectivos departamentos.

## ¿Para qué se utilizan los JOINS?
Los JOINS se utilizan para:

* Combinar datos de dos o más tablas basadas en una relación lógica (como una clave primaria y una clave externa).

* Relacionar información distribuida para obtener reportes, como listar productos con sus categorías o empleados con sus departamentos.

* Reducir la redundancia evitando duplicar datos, ya que se consulta en diferentes tablas y se extrae la información específica que se necesita.

## ¿Qué problemas resuelven los JOINS?
Los JOINS resuelven el problema de acceder y combinar datos que están distribuidos en varias tablas. Ayudan a evitar la duplicación de datos y permiten trabajar con bases de datos normalizadas sin perder eficiencia a la hora de hacer consultas complejas.

## Tipos de JOINS
* `INNER JOIN`

* `LEFT JOIN`

* `RIGHT JOIN`

* `FULL JOIN`

* `CROSS JOIN`

* `SELF JOIN`

# `INNER JOIN`
