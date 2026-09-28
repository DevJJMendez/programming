#SQL
# Data Definition Language
Es un subconjunto del lenguaje SQL utilizado para definir y modificar la estructura de la base de datos y sus objetos, como tablas, índices, vistas, procedimientos almacenados, y más. **DDL** permite crear, alterar y eliminar la estructura de una base de datos, enfocándose en cómo se organiza y almacena la información, pero no en los datos en sí.

## ¿Para qué se utiliza?
**DDL** se usa para realizar tareas relacionadas con la definición y mantenimiento de los esquemas de la base de datos. Las operaciones más comunes de **DDL** son:

* **Crear tablas y otros objetos**: Definir la estructura de las tablas, vistas, índices, y restricciones.

* **Modificar estructuras existentes**: Cambiar la estructura de tablas u otros objetos sin perder datos.

* **Eliminar estructuras**: Borrar tablas, vistas, índices y otros objetos cuando ya no se necesitan.

## ¿Qué resuelve?
**DDL** resuelve el problema de cómo organizar y estructurar los datos dentro de la base de datos. Proporciona las herramientas necesarias para definir el esquema, especificar qué tipos de datos serán almacenados y establecer relaciones entre diferentes entidades. En esencia, **DDL** organiza la forma en que los datos serán manejados y consultados por las aplicaciones.

## ¿Cómo lo resuelve?
A través de comandos SQL específicos, **DDL** permite a los administradores y desarrolladores controlar la estructura de la base de datos:

1. **`CREATE`**: Crea nuevos objetos en la base de datos:

```sql
CREATE DATABASE Users;

-- creará la base de datos solo si no existe previamente.
CREATE DATABASE IF NOT EXISTS Users;
  
CREATE TABLE users (
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(50),
   email VARCHAR(100),
);
```

2. **`ALTER`**: Permite realizar modificaciones en la estructura de la base de datos existente. Puedes **agregar**, **modificar** o **eliminar columnas**, **índices**, **restricciones**, entre otros.

```sql
-- Agrega la columna al final
ALTER TABLE Users
ADD COLUMN Job Varchar(30);

-- Agrega la columna despues de la columna especificada
ALTER TABLE Users
ADD COLUMN Salary FLOAT AFTER Job;

-- columna debe ubicarse al principio de la tabla.
ALTER TABLE Users
ADD COLUMN UUID SMALLINT FIRST;

-- Modificar el tipo de dato de una columna
ALTER TABLE Users
MODIFY COLUMN Age CHAR(3);

-- ELiminar un columna
ALTER TABLE Users
DROP COLUMN Job;

-- Renombrar una columna
ALTER TABLE Users
CHANGE Name UserName VARCHAR(20);

-- Agregar o eliminar una restriccion de clave externa
ALTER TABLE Users
ADD FOREIGN KEY (CountryID) REFERENCES Countrys(CountryID);

-- Elimina
ALTER TABLE Users
DROP FOREIGN KEY CountryID;
```

3. **`DROP`**: Elimina objetos de la base de datos, como tablas, vistas o índices. Es importante tener cuidado al usar **`DROP`**, ya que **elimina permanentemente el objeto y todos los datos asociados**.

```sql
DROP DATABASE Users;
DROP TABLE Users;
```

4. **`TRUNCATE`**: Elimina todos los registros de una tabla, pero mantiene la estructura de la tabla para futuros datos.
```sql
TRUNCATE TABLE Users;
```