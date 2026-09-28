#SQL
# Data Manipulation Language
Es una parte fundamental de SQL que se utiliza para interactuar directamente con los datos almacenados en una base de datos. A diferencia de DDL (que define la estructura de la base de datos), **DML** se enfoca en la manipulación y gestión de los datos dentro de esas estructuras.

## ¿Para qué se utiliza?
**DML** se utiliza para realizar operaciones sobre los datos contenidos en las tablas de la base de datos. Estas operaciones incluyen:

* **Insertar datos**: Agregar nuevos registros o filas a una tabla.

* **Actualizar datos**: Modificar los datos existentes en una o varias filas de una tabla.

* **Eliminar datos**: Borrar datos específicos de una tabla.

* **Consultar datos**: Recuperar y filtrar datos almacenados en las tablas.

## ¿Qué resuelve?
**DML** resuelve el problema de cómo gestionar y acceder a los datos almacenados en una base de datos. Con **DML**, los usuarios pueden realizar consultas, añadir nueva información, modificarla o eliminarla de manera eficiente. Es el conjunto de herramientas que permite interactuar dinámicamente con los datos.

## ¿Cómo lo resuelve?
**DML** lo resuelve mediante comandos SQL que permiten la manipulación directa de los datos dentro de la base de datos. Los comandos más comunes del **DML** son:

1. **`INSERT`**: Insertar nuevos datos en una tabla.

```sql
INSERT INTO clientes (nombre, correo, fecha_registro) 
VALUES ('Juan Perez', 'juanperez@email.com', '2024-09-20');
```

2. **`UPDATE`**: Modificar datos existentes en una tabla.

```sql
UPDATE clientes 
SET correo = 'nuevoemail@email.com' 
WHERE id = 1;
```

3. **`DELETE`**: Eliminar uno o varios registros de una tabla.
    
```sql
DELETE FROM clientes 
WHERE id = 1;
```

4. **`SELECT`**: Recuperar y consultar datos desde una tabla o conjunto de tablas.
    
```sql
SELECT * FROM clientes;
```

## ¿Cómo lo resuelve **DML** en la práctica?
* **Inserción de nuevos datos**: Utilizando el comando `INSERT`, **DML** permite la adición de nuevos registros a las tablas. Esto es esencial para que una base de datos crezca y almacene nueva información.

* **Actualización de datos**: Mediante el comando `UPDATE`, se pueden modificar campos específicos sin afectar el resto del registro o la tabla. Es útil cuando hay errores o cambios en la información.

* **Eliminación de datos**: Con `DELETE`, **DML** ofrece una manera precisa de eliminar registros sin eliminar la estructura de la tabla. Además, se puede utilizar un filtro (WHERE) para asegurarse de que solo se eliminen registros específicos.

* **Consulta de datos**: `SELECT` es probablemente el comando más utilizado de ****DML****, ya que permite acceder a la información de las tablas. Es crucial para analizar, filtrar y trabajar con los datos almacenados.