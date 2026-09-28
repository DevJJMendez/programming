#SQL
# Structure Query Language
Es un **lenguaje declarativo** estándar diseñado para interactuar con bases de datos relacionales. 

SQL permite a los usuarios crear, manipular, consultar y gestionar datos dentro de sistemas de gestión de bases de datos (DBMS) como MySQL, PostgreSQL, Oracle, entre otros.

**Declarativo significa: Tú dices QUÉ quieres, no CÓMO hacerlo.**

## ¿Qué es SQL?
SQL es un lenguaje específico de dominio que facilita la comunicación entre aplicaciones y bases de datos relacionales, permitiendo la ejecución de varias operaciones como:

* Definir estructuras de datos (tablas, índices, vistas, etc.).

* Manipular datos (insertar, actualizar, eliminar, consultar).

* Controlar acceso y permisos.

* Gestionar transacciones y asegurarse de que las operaciones en la base de datos sean fiables y consistentes.

## ¿Para qué se utiliza SQL?
SQL se utiliza principalmente para las siguientes tareas:

1. **Definición de Esquemas**: Mediante el **DDL (Data Definition Language)**, SQL define las estructuras de datos dentro de una base de datos, como tablas y sus relaciones.

2. **Manipulación de Datos**: Mediante el **DML (Data Manipulation Language)**, SQL permite insertar, modificar, eliminar y consultar datos almacenados en una base de datos.

3. **Control de Acceso**: Mediante el **DCL (Data Control Language)**, se gestionan los permisos y la seguridad de los datos.

4. **Control de Transacciones**: Mediante el **TCL (Transaction Control Language)**, se controlan las transacciones para garantizar la consistencia de los datos.

## ¿Qué problemas resuelve SQL?
SQL resuelve los siguientes problemas clave en la gestión de bases de datos:

1. **Acceso Eficiente a los Datos**: SQL facilita el acceso a grandes cantidades de datos almacenados en bases de datos relacionales a través de consultas que permiten buscar, ordenar, filtrar, agrupar y unir información de múltiples tablas de manera eficiente.

**¿Cómo lo resuelve?**: Utiliza comandos como `SELECT`, `JOIN`, `ORDER BY`, `GROUP BY`, `WHERE`, etc., que permiten al usuario obtener información específica de grandes conjuntos de datos. 

**Por ejemplo**, si quieres consultar la lista de clientes en una base de datos:
```sql
SELECT nombre, email FROM clientes WHERE ciudad = 'Madrid';
```

2. **Manipulación de Datos**: SQL permite modificar los datos almacenados sin afectar la estructura de la base de datos, lo que facilita el mantenimiento de la información actualizada y correcta.

**¿Cómo lo resuelve?**: Utiliza comandos como `INSERT`, `UPDATE` y `DELETE` para modificar los datos existentes. 

**Por ejemplo**, para actualizar el email de un cliente:
```sql
UPDATE clientes SET email = 'nuevoemail@example.com' WHERE cliente_id = 1;
```

3. **Definición y Mantenimiento de Esquemas**: SQL permite a los desarrolladores y administradores de bases de datos definir y gestionar la estructura de las tablas, índices y relaciones.

**¿Cómo lo resuelve?**: Mediante comandos de `DDL`, como `CREATE TABLE`, `ALTER TABLE`, y `DROP TABLE`, que permiten definir la estructura de las tablas y sus relaciones. **Por ejemplo**:
```sql
CREATE TABLE pedidos (
  pedido_id INT PRIMARY KEY,
  fecha DATE,
  cliente_id INT,
  FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);
```

4. **Control de Seguridad y Permisos**: SQL gestiona los permisos de acceso a los datos y operaciones para diferentes usuarios, manteniendo la seguridad en la base de datos.

**¿Cómo lo resuelve?**: Mediante `DCL`, SQL utiliza comandos como `GRANT` y `REVOKE` para otorgar o revocar permisos de acceso a ciertos usuarios:
```sql
GRANT SELECT ON pedidos TO usuario1;
REVOKE INSERT ON clientes FROM usuario2;
```

5. **Control de Transacciones**: SQL garantiza la consistencia y durabilidad de los datos durante las transacciones, lo que es crucial en sistemas donde se manejan muchas operaciones concurrentes, como en sistemas bancarios o de ecommerce.

**¿Cómo lo resuelve?**: Utiliza `TCL` (`COMMIT`, `ROLLBACK`) para manejar transacciones, asegurando que las operaciones se completen correctamente o que se reviertan si hay un error. Por ejemplo:
```sql
START TRANSACTION;
INSERT INTO pedidos (cliente_id, total) VALUES (1, 100.50);
COMMIT;
```

## ¿Cómo resuelve estos problemas SQL?
1. **Estructuración y Definición de Datos**: SQL resuelve la necesidad de organizar datos de manera estructurada mediante la creación de tablas relacionales. Cada tabla tiene una estructura fija definida por columnas, lo que asegura que los datos se almacenen de manera coherente y eficiente.

**Ejemplo de creación de tabla**:
```sql
CREATE TABLE empleados (
  id INT PRIMARY KEY,
  nombre VARCHAR(100),
  puesto VARCHAR(50),
  salario DECIMAL(10, 2)
);
```

2. **Consultas y Manipulación de Datos**: La capacidad de SQL para realizar consultas complejas sobre grandes conjuntos de datos resuelve el problema de extraer información útil de manera eficiente. SQL permite filtrar, ordenar, agrupar y hacer cálculos sobre los datos en las tablas.

**Ejemplo de consulta avanzada**:
```sql
SELECT departamento, AVG(salario) AS salario_promedio
FROM empleados
GROUP BY departamento
HAVING AVG(salario) > 50000;
```

3. **Seguridad y Control de Acceso**: SQL resuelve los problemas de seguridad al definir roles y permisos de acceso que restringen lo que ciertos usuarios pueden hacer en la base de datos. Esto es fundamental en entornos multiusuario, donde se necesita proteger los datos.

4. **Manejo de Transacciones**: SQL garantiza que los conjuntos de operaciones, como las transacciones, se ejecuten correctamente mediante el uso de los comandos de control de transacciones. Esto asegura que los datos se mantengan consistentes incluso si ocurre un error o falla.

**Ejemplo de transacción con rollback**:
```sql
START TRANSACTION;
UPDATE cuentas SET balance = balance - 100 WHERE id = 1;
UPDATE cuentas SET balance = balance + 100 WHERE id = 2;
-- Si hay un error
ROLLBACK;
-- Si todo es exitoso
COMMIT;
```

---

[](Data_Definition_Language.md)
[](Data_Manipulation_Language.md)