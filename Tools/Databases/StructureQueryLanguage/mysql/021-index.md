# Index
Un índice (Index) en SQL es una estructura especial de datos que mejora la velocidad de las operaciones de búsqueda en una tabla. Funciona de manera similar a un índice en un libro: en lugar de leer página por página, puedes ir directamente a la página deseada.

**Ejemplo**: Sin un índice, buscar un registro en una tabla es como buscar una palabra en un libro leyendo cada página. Con un índice, es como buscar la palabra en el índice del libro y saltar directamente a la página correcta.

## ¿Para qué sirven los Índices?
Los índices en SQL se usan para:

* Acelerar búsquedas y consultas en grandes volúmenes de datos.
* Optimizar la ejecución de joins entre tablas relacionadas.
* Asegurar la unicidad de ciertos valores con índices únicos.
* Mejorar la eficiencia en la búsqueda de rangos, como fechas o valores numéricos.

**Sin embargo, los índices tienen un costo:**
* Ocupan más espacio en disco.
* Hacen que las operaciones de INSERT, UPDATE y DELETE sean más lentas porque el índice debe actualizarse.

##  ¿Qué problemas resuelven los Índices?
### 1. Mejoran el rendimiento de las búsquedas
* Problema: Buscar un usuario en una tabla con millones de registros es lento porque debe recorrer toda la tabla.
* Solución: Crear un índice en la columna email para acelerar la búsqueda.
```sql
CREATE INDEX idx_users_email ON Users (email);
```
Ahora, una consulta como esta será mucho más rápida:
```sql
SELECT * FROM Users WHERE email = 'usuario@email.com';
```

### 2. Optimizan los JOIN entre tablas
* Problema: Al hacer un JOIN entre tablas grandes, la base de datos revisa todos los registros.
* Solución: Crear índices en las claves foráneas para acelerar las uniones.
```sql
CREATE INDEX idx_orders_customer ON Orders (CustomerID);
```
Esto hará que esta consulta sea mucho más rápida:
```sql
SELECT Customers.Name, Orders.TotalAmount 
FROM Customers
JOIN Orders ON Customers.CustomerID = Orders.CustomerID;
```

### 3. Aseguran Unicidad de Valores
* Problema: Se necesita evitar que dos usuarios tengan el mismo correo electrónico.
* Solución: Crear un índice único (UNIQUE INDEX).
```sql
CREATE UNIQUE INDEX idx_unique_email ON Users (email);
```
Ahora, si intentamos insertar dos usuarios con el mismo correo, la base de datos lo rechazará.
```sql
INSERT INTO Users (UserID, email) VALUES (1, 'user@email.com'); -- OK
INSERT INTO Users (UserID, email) VALUES (2, 'user@email.com'); -- ERROR: Violación de índice único
```

### 4. Mejoran consultas con ORDER BY y GROUP BY
* Problema: Ordenar registros con ORDER BY en una tabla grande es muy lento.
* Solución: Crear un índice en la columna usada en ORDER BY.
```sql
CREATE INDEX idx_users_lastname ON Users (LastName);
```
Ahora, esta consulta será más rápida:
```sql
SELECT * FROM Users ORDER BY LastName;
```

### 5. Optimizan la búsqueda por rangos
* Problema: Se necesitan buscar ventas dentro de un rango de fechas en una tabla enorme.
* Solución: Crear un índice en la columna OrderDate.
```sql
CREATE INDEX idx_orders_date ON Orders (OrderDate);
```
Ahora, la búsqueda será más rápida:
```sql
SELECT * FROM Orders WHERE OrderDate BETWEEN '2024-01-01' AND '2024-12-31';
```

# Tipos de Índices en SQL
## 1. Índice Normal (B-TREE)
Es el más común y se usa para acelerar búsquedas y ordenaciones.
```sql
CREATE INDEX idx_users_name ON Users (Name);
```

## 2. Índice Único (UNIQUE INDEX)
Asegura que no haya valores duplicados en la columna.
```sql
CREATE UNIQUE INDEX idx_unique_email ON Users (email);
```

## 3. Índice Compuesto (Multi-Columna)
Se usa cuando se realizan búsquedas con múltiples columnas.
```sql
CREATE INDEX idx_users_name_email ON Users (Name, Email);
```
Usado en consultas como:
```sql
SELECT * FROM Users WHERE Name = 'Juan' AND Email = 'juan@email.com';
```
**IMPORTANTE**: El índice solo se usa si las consultas incluyen la primera columna del índice.

No se usará el índice en esta consulta:
```sql
SELECT * FROM Users WHERE Email = 'juan@email.com';
```

## 4. Índice de Texto Completo (FULLTEXT INDEX)
Se usa en búsquedas de texto en columnas grandes (TEXT, VARCHAR).
```sql
CREATE FULLTEXT INDEX idx_users_bio ON Users (Bio);
```
Permite hacer búsquedas eficientes:
```sql
SELECT * FROM Users WHERE MATCH(Bio) AGAINST ('developer');
```

## 5. Índices Clusterizados y No-Clusterizados
* Un índice clusterizado almacena los datos físicamente en el orden del índice.
* Un índice no-clusterizado almacena los datos en otro lugar y el índice solo contiene referencias.

📌 Ejemplo de índice clusterizado en SQL Server y PostgreSQL:
```sql
CREATE CLUSTERED INDEX idx_orders_date ON Orders (OrderDate);
```

📌 Ejemplo de índice no-clusterizado:
```sql
CREATE NONCLUSTERED INDEX idx_orders_customer ON Orders (CustomerID);
```

## ¿Cuándo NO usar Índices?
* No usar índices en tablas pequeñas: El rendimiento no mejora significativamente.
* No usar índices en columnas con muchos valores repetidos: Como "Género" (M / F).
* No abusar de los índices en tablas con muchas escrituras (INSERT, UPDATE, DELETE): Pueden ralentizar estas operaciones.

## ¿Cómo eliminar un Índice?
Si un índice ya no es útil, se puede eliminar con:
```sql
DROP INDEX idx_users_email;
```

# Casos de uso
Los índices en SQL se utilizan para mejorar el rendimiento de las consultas en bases de datos grandes. Sin embargo, deben aplicarse estratégicamente según el escenario.

## Acelerar búsquedas con WHERE
✅ Caso: Se necesita buscar registros en una tabla grande utilizando una condición en WHERE.
✅ Solución: Crear un índice en la columna utilizada en la búsqueda.

📌 Ejemplo sin índice (lento en grandes volúmenes de datos):
```sql
SELECT * FROM Employees WHERE LastName = 'Gómez';
```
Solución con índice (más rápido):
```sql
CREATE INDEX idx_lastname ON Employees (LastName);
```
Ahora la consulta se ejecutará más rápido.

## Optimizar JOIN entre tablas
✅ Caso: Se realizan consultas que unen tablas grandes con JOIN.
✅ Solución: Crear un índice en las claves foráneas para mejorar el rendimiento del JOIN.

📌 Ejemplo sin índice (SQL escanea toda la tabla):
```sql
SELECT Customers.Name, Orders.TotalAmount 
FROM Customers
JOIN Orders ON Customers.CustomerID = Orders.CustomerID;
```
Solución con índice en la clave foránea (CustomerID en Orders):
```sql
CREATE INDEX idx_orders_customer ON Orders (CustomerID);
```
El JOIN se ejecutará más rápido al no tener que escanear todos los registros.

## Mejorar rendimiento en ORDER BY y GROUP BY
✅ Caso: Ordenar o agrupar grandes volúmenes de datos es lento.
✅ Solución: Crear un índice en la columna usada en ORDER BY o GROUP BY.

📌 Ejemplo de ordenación sin índice:
```sql
SELECT * FROM Employees ORDER BY LastName;
```
Solución con índice:
```sql
CREATE INDEX idx_lastname ON Employees (LastName);
```
Esto evita que la base de datos tenga que ordenar los datos manualmente.

## Búsqueda en rangos de valores (BETWEEN, >=, <=)
✅ Caso: Se necesita encontrar registros dentro de un intervalo de fechas o números.
✅ Solución: Crear un índice en la columna del filtro.

📌 Ejemplo sin índice (SQL escanea todos los registros):
```sql
SELECT * FROM Orders WHERE OrderDate BETWEEN '2024-01-01' AND '2024-12-31';
```
Solución con índice:
```sql
CREATE INDEX idx_orders_date ON Orders (OrderDate);
```
Esto optimiza las búsquedas en rangos de fechas o números.

## Evitar valores duplicados con UNIQUE INDEX
✅ Caso: Se requiere evitar que existan valores duplicados en una columna, como correos electrónicos.
✅ Solución: Usar un UNIQUE INDEX.

📌 Ejemplo:
```sql
CREATE UNIQUE INDEX idx_unique_email ON Users (email);
```
Si intentamos insertar un email repetido, SQL lo rechazará.

## Optimizar búsquedas en múltiples columnas (Multi-Columna)
✅ Caso: Se realizan búsquedas filtrando por varias columnas.
✅ Solución: Crear un índice compuesto (Multi-Columna).

📌 Ejemplo:
```sql
CREATE INDEX idx_users_name_email ON Users (Name, Email);
```
Se usa en consultas como:
```sql
SELECT * FROM Users WHERE Name = 'Juan' AND Email = 'juan@email.com';
```
Importante: Este índice solo se usa si la consulta empieza filtrando por Name.

## Mejorar búsqueda en texto grande (FULLTEXT INDEX)
✅ Caso: Se necesita hacer búsquedas de texto en campos grandes, como descripciones o biografías.
✅ Solución: Usar FULLTEXT INDEX en columnas tipo TEXT o VARCHAR.

📌 Ejemplo:
```sql
CREATE FULLTEXT INDEX idx_users_bio ON Users (Bio);
```
Permite hacer búsquedas eficientes de palabras clave:
```sql
SELECT * FROM Users WHERE MATCH(Bio) AGAINST ('desarrollador');
```
Esto es mucho más eficiente que LIKE '%texto%'.

## Indexar claves primarias (PRIMARY KEY)
✅ Caso: Una tabla necesita una clave primaria para identificar registros de forma única.
✅ Solución: SQL automáticamente crea un índice en PRIMARY KEY.

📌 Ejemplo:
```sql
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    OrderDate DATE NOT NULL
);
```
El índice en OrderID hará que las búsquedas por OrderID sean rápidas.