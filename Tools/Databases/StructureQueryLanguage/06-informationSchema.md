# Identificar los usuarios
* **Ver los usuarios creados**: Puedes listar todos los usuarios existentes en el servidor MySQL consultando la tabla mysql.user. Esta tabla contiene los usuarios y su información de autenticación.

```sql
SELECT User, Host FROM mysql.user;

/* `User`: El nombre de usuario. */

/* `Host`: El host desde el cual el usuario tiene acceso (puede ser una dirección IP o % para acceso desde cualquier host). */
```

# Ver permisos de los usuarios
* **Ver permisos globales de un usuario**: Puedes usar el comando `SHOW GRANTS` para ver los permisos que tiene un usuario específico. Por ejemplo, para ver los permisos de un usuario llamado **usuario1**:

```sql
SHOW GRANTS FOR 'usuario1'@'localhost';
```
Esto te devolverá una lista de todos los permisos que ese usuario tiene asignados, ya sea a nivel global, de base de datos o de tabla.

Si el usuario se conecta desde cualquier host (`%`), usa:
```sql
SHOW GRANTS FOR 'usuario1'@'%';
```

* **Consultar permisos sobre una base de datos o tabla específica**: Si deseas saber qué usuarios tienen permisos sobre una base de datos o una tabla específica, puedes consultar las tablas del sistema `information_schema`:

Para ver los permisos sobre una base de datos específica:
```sql
SELECT * FROM information_schema.SCHEMA_PRIVILEGES WHERE TABLE_SCHEMA = 'nombre_de_la_base';
```

Para ver los permisos sobre una tabla específica:
```sql
SELECT * FROM information_schema.TABLE_PRIVILEGES WHERE TABLE_NAME = 'nombre_de_la_tabla' AND TABLE_SCHEMA = 'nombre_de_la_base';
```

# Tablas útiles en MySQL para ver permisos
1. **`mysql.user`**: Contiene la lista de todos los usuarios del servidor y algunos permisos globales.
```sql
SELECT * FROM mysql.user;
```

2. **`information_schema.USER_PRIVILEGES`**: Contiene información sobre los privilegios globales asignados a los usuarios.
```sql
SELECT * FROM information_schema.USER_PRIVILEGES;
```

3. `information_schema.SCHEMA_PRIVILEGES`: Contiene privilegios asignados a usuarios específicos sobre bases de datos.

4. `information_schema.TABLE_PRIVILEGES`: Contiene información sobre los privilegios asignados a usuarios sobre tablas específicas.

5. `information_schema.COLUMN_PRIVILEGES`: Contiene información sobre privilegios a nivel de columna.
```sql
SELECT * FROM information_schema.COLUMN_PRIVILEGES WHERE TABLE_NAME = 'nombre_de_la_tabla';
```