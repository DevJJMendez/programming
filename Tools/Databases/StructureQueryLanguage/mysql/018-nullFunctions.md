# `SQL NULL FUNCTIONS`
En SQL, los valores NULL representan la ausencia de datos. Las funciones de NULL en SQL permiten manejar estos valores y evitar resultados inesperados en consultas.

## ¿Qué es NULL en SQL?
* `NULL` significa **"valor desconocido" o "sin valor"**.

* No es lo mismo que **`0`**, una cadena vacía (**`''`**), o `FALSE`.

* No se puede comparar con `=` ni con `!=`, sino con `IS NULL` o `IS NOT NULL`.

Ejemplo
```sql
SELECT * FROM clientes WHERE direccion IS NULL;
```
Muestra todos los clientes sin dirección.

## Principales funciones para manejar NULL en SQL
1. COALESCE()
   * Devuelve el primer valor NO NULL de una lista de valores.

   * Si todos son NULL, devuelve NULL.
```sql
SELECT COALESCE(NULL, NULL, 'Hola', 'Mundo') AS resultado;
```
Salida
```bash
Hola
```
Uso común: Sustituir NULL por valores predeterminados.

Ejemplo en una tabla:
```sql
SELECT nombre, COALESCE(telefono, 'No disponible') AS telefono
FROM clientes;
```
Si telefono es NULL, devuelve 'No disponible'.

2. IFNULL() (MySQL)
Funciona igual que COALESCE(), pero acepta solo dos parámetros.
```sql
SELECT IFNULL(NULL, 'Valor por defecto') AS resultado;
```
Salida
```bash
Valor por defecto
```
Uso común: Sustituir NULL en una consulta más sencilla.

Ejemplo
```sql
SELECT nombre, IFNULL(email, 'Sin correo') AS email
FROM usuarios;
```

3. NULLIF()
   * Compara dos valores y devuelve NULL si son iguales.

   * Si son diferentes, devuelve el primer valor.
```sql
SELECT NULLIF(5, 5) AS resultado1, NULLIF(5, 3) AS resultado2;
```
Salida
```bash
resultado1	resultado2
NULL	      5
```
Uso común: Evitar divisiones por cero.
```sql
SELECT valor / NULLIF(divisor, 0) AS resultado FROM tabla;
```
Si divisor = 0, evita error dividiendo entre NULL.

4. ISNULL() (SQL Server). Similar a IFNULL(), pero en SQL Server.
```sql
SELECT ISNULL(NULL, 'Por defecto') AS resultado;
```
Salida
```bash
Por defecto
```
Uso común: Reemplazo de NULL en SQL Server.

## Ejemplos prácticos
Ejemplo 1: Usando COALESCE() en un informe de ventas
Si un cliente no tiene número de contacto, mostramos su correo.
```sql
SELECT nombre, COALESCE(telefono, email, 'No disponible') AS contacto
FROM clientes;
```
Si telefono y email son NULL, devuelve 'No disponible'.

Ejemplo 2: Evitar errores con NULLIF() en una división
Queremos calcular el precio promedio por unidad sin errores
```sql
SELECT producto, total_ventas / NULLIF(cantidad, 0) AS precio_unitario
FROM pedidos;
```
Si cantidad = 0, la división da NULL en lugar de error.


Ejemplo 3: Clasificar datos con CASE y IS NULL
Si un cliente no tiene dirección, mostramos 'Sin dirección'.
```sql
SELECT nombre,
       CASE 
           WHEN direccion IS NULL THEN 'Sin dirección'
           ELSE direccion
       END AS direccion_cliente
FROM clientes;
```

## Consideraciones importantes
* NULL no se compara con = → Usar IS NULL o IS NOT NULL

* COALESCE() es más flexible que IFNULL()

* NULLIF() es útil para evitar errores de división por cero

* En consultas con GROUP BY, NULL se trata como un grupo aparte

* En ORDER BY, los NULL pueden ir primero o último según la base de datos