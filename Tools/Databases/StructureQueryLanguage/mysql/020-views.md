# Views
Una View (vista) es una tabla virtual basada en el resultado de una consulta SQL. No almacena los datos directamente, sino que muestra los datos de las tablas subyacentes en tiempo de ejecución.

* No almacena datos físicamente, sino que actúa como una "ventana" a los datos.

* Se comporta como una tabla normal (puede ser consultada con SELECT).

* Puede incluir una combinación de varias tablas, aplicar filtros y agregar cálculos.

## ¿Para qué sirven las Views?
Las vistas tienen múltiples usos, algunos de los más importantes son:

* Simplificación de consultas: Permiten encapsular consultas SQL complejas en una estructura reutilizable y fácil de consultar.

* Seguridad y control de acceso: Pueden restringir el acceso a ciertas columnas o filas sin modificar la tabla original.

* Independencia de datos: Facilitan cambios en la estructura de las tablas subyacentes sin afectar a los usuarios finales.

* Eficiencia y optimización: Mejoran el rendimiento en algunas situaciones, especialmente si están materializadas.

* Facilidad de mantenimiento: Evitan la duplicación de código SQL complejo en diferentes partes de una aplicación.

## ¿Qué problemas resuelven las Views?
* Reducen la repetición de código SQL: En lugar de escribir la misma consulta compleja varias veces, se puede encapsular en una vista.

* Protegen la información sensible: Se pueden crear vistas que excluyan datos confidenciales, evitando el acceso directo a las tablas.

* Facilitan el análisis de datos: Permiten a los analistas de datos trabajar con información preprocesada sin afectar la base de datos.

* Permiten un mejor diseño modular: Se pueden usar en capas de abstracción dentro de arquitecturas de software.

## ¿Cómo se implementan las Views en SQL?
### 1. Creación de una Vista (`CREATE VIEW`)
```sql
CREATE VIEW nombre_vista AS
SELECT columnas
FROM tabla
WHERE condiciones;
```

**Ejemplo**: Supongamos que tenemos la siguiente tabla:
```sql
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    Position VARCHAR(50),
    Salary DECIMAL(10,2)
);
```
Si queremos una vista con **solo los empleados que ganan más de `$3000`**, podemos hacer:
```sql
CREATE VIEW HighSalaryEmployees AS
SELECT EmployeeID, Name, Position, Salary
FROM Employees
WHERE Salary > 3000;
```
Ahora, cuando consultemos la vista, veremos solo los empleados con salario alto:
```sql
SELECT * FROM HighSalaryEmployees;
```

### Actualización de una Vista (`ALTER VIEW`)
Si necesitamos modificar una vista, podemos usar ALTER VIEW:
```sql
ALTER VIEW HighSalaryEmployees AS
SELECT EmployeeID, Name, Position, Salary
FROM Employees
WHERE Salary > 5000;
```

### Eliminación de una Vista (`DROP VIEW`)
Si ya no necesitamos una vista, podemos eliminarla con:
```sql
DROP VIEW HighSalaryEmployees;
```

# Tipos de Views en SQL
Existen dos tipos principales de vistas en SQL:

## 1. Vistas Simples (Simple Views)
* Basadas en una sola tabla.

* Son consultables y pueden permitir modificaciones en la tabla subyacente si cumplen ciertos criterios.

* Ejemplo:
```sql
CREATE VIEW EmployeeNames AS
SELECT EmployeeID, Name
FROM Employees;
```

##  Vistas Complejas (Complex Views)
* Pueden incluir múltiples tablas (JOINs), funciones agregadas (SUM(), AVG()), GROUP BY, etc.

* Generalmente no permiten modificaciones en los datos.

* Ejemplo con JOIN:
```sql
CREATE VIEW OrderDetails AS
SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
```

# ¿Se pueden modificar los datos de una Vista?
Sí, pero con restricciones. Una vista puede ser actualizable si:

* Está basada en una sola tabla.

* No usa DISTINCT, GROUP BY, HAVING, UNION o funciones agregadas.

* Incluye todas las claves primarias necesarias.

Ejemplo: Insertar un nuevo empleado a través de una vista
```sql
INSERT INTO HighSalaryEmployees (EmployeeID, Name, Position, Salary) 
VALUES (4, 'Carlos Gómez', 'Gerente', 5500);
```
Esto funcionará si la vista no tiene restricciones que lo impidan.
* No se puede modificar una vista si:

* Contiene JOIN, GROUP BY, HAVING, funciones agregadas (SUM, AVG, etc.).

* No incluye todas las claves primarias necesarias.

# Vistas Materializadas (Materialized Views)
Algunos sistemas de bases de datos (como Oracle, PostgreSQL) permiten vistas materializadas, que almacenan los datos físicamente en lugar de calcularlos cada vez.

**Ejemplo en `PostgreSQL`:**
```sql
CREATE MATERIALIZED VIEW SalesSummary AS
SELECT ProductID, SUM(Quantity) AS TotalSales
FROM Sales
GROUP BY ProductID;
```
Para actualizar los datos almacenados:
```sql
REFRESH MATERIALIZED VIEW SalesSummary;
```
* Ventaja: Mejora el rendimiento en consultas frecuentes.
* Desventaja: Requiere actualización manual (REFRESH MATERIALIZED VIEW).

# Casos de Uso
Las Views (vistas) en SQL se utilizan en múltiples escenarios para mejorar la seguridad, el rendimiento y la organización de datos en una base de datos. 

## 1. Seguridad y Control de Acceso
* Caso de Uso: Restricción de Acceso a Datos Sensibles

* Problema: En una empresa, los empleados de recursos humanos deben consultar los nombres y cargos de los empleados, pero no deben tener acceso a los salarios.

* Solución: Crear una vista que oculte la columna de salario.
```sql
CREATE VIEW EmployeePublicInfo AS
SELECT EmployeeID, Name, Position
FROM Employees;
```
Ahora los usuarios pueden consultar la vista sin acceder a la información confidencial:
```sql
SELECT * FROM EmployeePublicInfo;
```
Ventaja: Permite ocultar información confidencial sin modificar la estructura de la tabla.

##  2. Simplificación de Consultas Complejas
* Caso de Uso: Reducción de Código SQL Repetitivo

* Problema: Se necesita calcular frecuentemente el total de ventas por cliente en un sistema de facturación, y la consulta es muy larga.

* Solución: Crear una vista con la lógica precalculada.
```sql
CREATE VIEW TotalSalesByCustomer AS
SELECT c.CustomerID, c.CustomerName, SUM(o.TotalAmount) AS TotalSpent
FROM Customers c
JOIN Orders o ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID, c.CustomerName;
```
Ahora, en lugar de escribir la consulta completa cada vez, basta con:
```sql
SELECT * FROM TotalSalesByCustomer WHERE TotalSpent > 1000;
```
Ventaja: Facilita la reutilización de consultas complejas sin repetir código.

## 3. Agregación de Datos en Reportes
* Caso de Uso: Creación de Informes Dinámicos

* Problema: Se requiere generar un informe de ventas mensuales para el equipo de gerencia.

* Solución: Crear una vista con las ventas agrupadas por mes.
```sql
CREATE VIEW MonthlySales AS
SELECT DATE_TRUNC('month', OrderDate) AS Month, SUM(TotalAmount) AS TotalSales
FROM Orders
GROUP BY DATE_TRUNC('month', OrderDate);
```
Ahora, el equipo solo necesita consultar la vista:
```sql
SELECT * FROM MonthlySales;
```
Ventaja: Permite generar reportes sin recalcular datos en cada consulta.

## 4. Abstracción de la Estructura de la Base de Datos
* Caso de Uso: Independencia de los Usuarios frente a Cambios en las Tablas

* Problema: Un sistema cambia su estructura de base de datos, pero no queremos que los usuarios se vean afectados.

* Solución: Crear una vista con la estructura anterior para mantener compatibilidad.

Supongamos que una tabla Employees tenía los siguientes campos:
```sql
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FullName VARCHAR(100),
    Salary DECIMAL(10,2)
);
```
Luego, la empresa decide dividir FullName en FirstName y LastName.
```sql
ALTER TABLE Employees 
ADD COLUMN FirstName VARCHAR(50),
ADD COLUMN LastName VARCHAR(50),
DROP COLUMN FullName;
```
En lugar de actualizar todas las aplicaciones que usaban FullName, se crea una vista para mantener compatibilidad:
```sql
CREATE VIEW OldEmployeeView AS
SELECT EmployeeID, CONCAT(FirstName, ' ', LastName) AS FullName, Salary
FROM Employees;
```
Ventaja: Evita romper sistemas antiguos cuando se realizan cambios en la base de datos.

## 5. Unificación de Datos desde Múltiples Tablas
* Caso de Uso: Normalización y Unión de Tablas Relacionadas

* Problema: En un sistema bancario, las transacciones están divididas en varias tablas (Deposits, Withdrawals, Transfers). Se necesita una vista consolidada de todas las transacciones.

* Solución: Crear una vista que combine los datos de todas las tablas en un solo conjunto de resultados.
```sql
CREATE VIEW AllTransactions AS
SELECT TransactionID, CustomerID, 'Deposit' AS Type, Amount, Date
FROM Deposits
UNION ALL
SELECT TransactionID, CustomerID, 'Withdrawal', Amount, Date
FROM Withdrawals
UNION ALL
SELECT TransactionID, CustomerID, 'Transfer', Amount, Date
FROM Transfers;
```
Ahora, cualquier reporte de transacciones puede acceder a la vista sin preocuparse de las tablas separadas:
```sql
SELECT * FROM AllTransactions WHERE CustomerID = 12345;
```
Ventaja: Unifica datos de varias tablas en una sola fuente.

## 6. Optimización de Consultas con Vistas Materializadas
* Caso de Uso: Mejorar el Rendimiento en Consultas Frecuentes

* Problema: Un e-commerce necesita generar un reporte diario de los productos más vendidos, pero la consulta es muy pesada.

* Solución: Usar una vista materializada (en PostgreSQL, Oracle) para precomputar los resultados.
```sql
CREATE MATERIALIZED VIEW BestSellingProducts AS
SELECT ProductID, COUNT(*) AS Sales
FROM OrderDetails
GROUP BY ProductID
ORDER BY Sales DESC;
```
Para actualizar los datos cada día:
```sql
REFRESH MATERIALIZED VIEW BestSellingProducts;
```
Ventaja: Mejora el rendimiento al almacenar resultados precomputados.

## 7. Auditoría y Control de Cambios
* Caso de Uso: Seguimiento de Modificaciones en Datos

* Problema: Un hospital necesita auditar cambios en la información de pacientes.

* Solución: Crear una vista que solo muestre registros modificados recientemente.
```sql
CREATE VIEW RecentUpdates AS
SELECT PatientID, Name, LastModified
FROM Patients
WHERE LastModified > NOW() - INTERVAL '7 days';
```
Ahora los auditores pueden revisar solo los cambios recientes:
```sql
SELECT * FROM RecentUpdates;
```
Ventaja: Facilita el monitoreo de cambios en la base de datos.