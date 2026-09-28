# Data Control Language
Es una parte del lenguaje SQL enfocada en la gestión de los permisos y los controles de acceso a los datos dentro de una base de datos. **DCL** garantiza que solo los usuarios autorizados puedan realizar operaciones específicas sobre la base de datos, como leer, modificar o eliminar datos, así como crear o eliminar objetos.

## ¿Para qué se utiliza?
**DCL** se utiliza para controlar el acceso a la base de datos, garantizando que los usuarios solo puedan realizar las acciones que se les permiten. A través de **DCL**, un administrador de base de datos (DBA) puede otorgar o revocar permisos a usuarios y roles, lo que garantiza la seguridad y confidencialidad de los datos.

## ¿Qué resuelve?
**DCL** resuelve el problema de la seguridad y control de acceso en una base de datos. Con **DCL**, los administradores pueden garantizar que solo los usuarios con los permisos adecuados puedan realizar acciones críticas en la base de datos, protegiendo así la integridad, confidencialidad y disponibilidad de los datos.

## ¿Cómo lo resuelve?
**DCL** lo resuelve mediante dos comandos SQL principales:

1. **`GRANT`**: Otorgar permisos específicos a usuarios o roles para que puedan realizar determinadas operaciones en la base de datos.

   * **Ejemplo**: Otorgar permisos a un usuario llamado **usuario1** para que pueda consultar (`SELECT`) los datos de una tabla llamada *clientes*:

```sql
GRANT SELECT ON clientes TO 'usuario1';
```

2. **`REVOKE`**: Revocar permisos previamente otorgados a un usuario o rol, impidiéndoles realizar ciertas acciones sobre la base de datos.

   * **Ejemplo**: Revocar el permiso de consulta (`SELECT`) a **usuario1** sobre la tabla *clientes*:

```sql
REVOKE SELECT ON clientes FROM 'usuario1';
```

## ¿Cómo resuelve **DCL** el control de acceso?
* **Asignación de permisos granulares**: Con **`GRANT`**, los administradores pueden definir qué operaciones específicas (por ejemplo, `SELECT`, `INSERT`, UP`D`ATE, `DELETE`) puede realizar un usuario o un rol sobre tablas, vistas, o incluso columnas específicas. Esto permite un control detallado sobre qué información puede ser accedida y modificada por cada usuario.

* **Revocación de permisos cuando sea necesario**: A medida que los requisitos de seguridad cambian, los administradores pueden usar **`REVOKE`** para quitar permisos a los usuarios o roles que ya no necesitan acceso, garantizando que el acceso a los datos permanezca controlado y seguro.

* **Permisos sobre diferentes niveles**: Los permisos pueden otorgarse no solo a nivel de tablas, sino también a **nivel de bases de datos completas, vistas, procedimientos almacenados y columnas específicas**. Esto permite gestionar la seguridad de manera flexible y adaptativa según las necesidades de la organización.

## Casos comunes de uso de **DCL**:
* **Gestión de roles y usuarios**: **DCL** permite la creación de roles específicos (por ejemplo, "*administradores*", "*usuarios de consulta*") que agrupan permisos, facilitando la gestión de acceso.

* **Protección de datos sensibles**: Se pueden restringir ciertos usuarios a tener solo acceso de lectura a datos sensibles, como información financiera o datos personales, evitando que los modifiquen.

* **Auditoría y control**: Al limitar quién puede realizar ciertas acciones, **DCL** ayuda a auditar y rastrear el uso de la base de datos, asegurando que solo los usuarios autorizados manipulen información crítica.

## Lista de permisos
* **`SELECT`**: Permite al usuario consultar datos en una o más tablas (ejecutar consultas `SELECT`).

  * Ejemplo: `GRANT SELECT ON db_name.table_name TO 'user';`

* **`INSERT`**: Permite al usuario insertar nuevos registros en una tabla.

  * Ejemplo: `GRANT INSERT ON db_name.table_name TO 'user';`

* **`UPDATE`**: Permite al usuario modificar datos existentes en una tabla.

  * Ejemplo: `GRANT UPDATE ON db_name.table_name TO 'user';`

* **`DELETE`**: Permite al usuario eliminar registros en una tabla.

  * Ejemplo: `GRANT DELETE ON db_name.table_name TO 'user';`

* **`CREATE`**: Permite al usuario crear nuevas bases de datos, tablas, vistas, o índices.

  * Ejemplo: `GRANT CREATE ON db_name.* TO 'user';`

* **`DROP`**: Permite al usuario eliminar bases de datos o tablas.

  * Ejemplo: `GRANT DROP ON db_name.* TO 'user';`

* **`ALTER`**: Permite al usuario modificar la estructura de una tabla (agregar o eliminar columnas, cambiar tipos de datos, etc.).

  * Ejemplo: `GRANT ALTER ON db_name.table_name TO 'user';`

* **`INDEX`**: Permite al usuario crear y eliminar índices en las tablas.

  * Ejemplo: `GRANT INDEX ON db_name.table_name TO 'user';`

* **`CREATE VIEW`**: Permite al usuario crear vistas.

  * Ejemplo: `GRANT CREATE VIEW ON db_name.* TO 'user';`

* **`SHOW VIEW`**: Permite al usuario ver el código SQL de las vistas.

  * Ejemplo: `GRANT SHOW VIEW ON db_name.* TO 'user';`

* **`CREATE ROUTINE`**: Permite al usuario crear procedimientos almacenados y funciones.

  * Ejemplo: `GRANT CREATE ROUTINE ON db_name.* TO 'user';`

* **`ALTER ROUTINE`**: Permite modificar o eliminar procedimientos almacenados y funciones.

  * Ejemplo: `GRANT ALTER ROUTINE ON db_name.* TO 'user';`

* **`EXECUTE`**: Permite al usuario ejecutar procedimientos almacenados o funciones.

  * Ejemplo: `GRANT EXECUTE ON db_name.* TO 'user';`

* **`GRANT OPTION`**: Permite al usuario otorgar a otros usuarios los mismos privilegios que tiene.

  * Ejemplo: `GRANT GRANT OPTION ON db_name.* TO 'user';`

* **`LOCK TABLES`**: Permite al usuario bloquear tablas para evitar que otros usuarios las modifiquen mientras el usuario trabaja en ellas.

  * Ejemplo: `GRANT LOCK TABLES ON db_name.* TO 'user';`

* **`REFERENCES`**: Permite al usuario crear claves foráneas.

  * Ejemplo: `GRANT REFERENCES ON db_name.table_name TO 'user';`

* **`FILE`**: Permite al usuario leer y escribir archivos en el servidor (usado, por ejemplo, para operaciones de importación/exportación de datos).

  * Ejemplo: `GRANT FILE ON *.* TO 'user';`

* **`RELOAD`**: Permite al usuario recargar tablas o volcar la caché del servidor MySQL.

  * Ejemplo: `GRANT RELOAD ON *.* TO 'user';`

* **`SHUTDOWN`**: Permite al usuario apagar el servidor MySQL.

  * Ejemplo: `GRANT SHUTDOWN ON *.* TO 'user';`

* **`SUPER`**: Otorga privilegios administrativos avanzados, como la capacidad de cancelar consultas, cambiar variables globales, o detener el servidor.

  * Ejemplo: `GRANT SUPER ON *.* TO 'user';`

* **`PROCESS`**: Permite ver información sobre los procesos que se están ejecutando en el servidor MySQL.

  * Ejemplo: `GRANT PROCESS ON *.* TO 'user';`

* **`REPLICATION SLAVE`**: Permite al usuario configurar el servidor como un esclavo para replicación.

  * Ejemplo: `GRANT REPLICATION SLAVE ON *.* TO 'user';`

* **`REPLICATION CLIENT`**: Permite al usuario consultar el estado de los servidores maestros y esclavos.

  * Ejemplo: `GRANT REPLICATION CLIENT ON *.* TO 'user';`

* **`SHOW DATABASES`**: Permite al usuario ver la lista de bases de datos en el servidor.

  * Ejemplo: `GRANT SHOW DATABASES ON *.* TO 'user';`

* **`CREATE USER`**: Permite crear nuevas cuentas de usuario en MySQL.

  * Ejemplo: `GRANT CREATE USER ON *.* TO 'user';`

* **`EVENT`**: Permite al usuario crear, modificar y eliminar eventos programados.

  * Ejemplo: `GRANT EVENT ON db_name.* TO 'user';`

* **`TRIGGER`**: Permite crear y eliminar disparadores (triggers) en tablas.

  * Ejemplo: `GRANT TRIGGER ON db_name.table_name TO 'user';`

## Permisos por nivel
* **A nivel de tabla**: Puedes otorgar permisos sobre tablas específicas dentro de una base de datos.

* A **nivel de base de datos**: Permisos otorgados a una base de datos completa.

* **A nivel global**: Permisos que se aplican a todas las bases de datos del servidor.

## Ejemplo de combinación de permisos
Puedes otorgar múltiples permisos a la vez con una sola instrucción GRANT:
```sql
GRANT SELECT, INSERT, UPDATE ON db_name.* TO 'user';
```

## Revocar permisos
Para eliminar permisos otorgados, se usa el comando REVOKE:
```sql
REVOKE INSERT, UPDATE ON db_name.* FROM 'user';
```