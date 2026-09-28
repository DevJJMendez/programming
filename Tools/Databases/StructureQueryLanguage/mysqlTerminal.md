# Acceder al Servidor MySQL
Para acceder a MySQL desde la terminal, usa el siguiente comando:
```bash
sudo mysql -u root -p
```
Aquí `-u root` especifica que te estás conectando como el usuario **root**, y `-p` pedirá tu contraseña.

## Salir del cliente MySQL
```bash
EXIT;
```

## Comandos Básicos de MySQL
1. **Mostrar Bases de Datos:** Para listar todas las bases de datos en tu servidor MySQL:
    ```bash
    SHOW DATABASES;
    ```

2. **Crear una Nueva Base de Datos:** Puedes crear una nueva base de datos con:
    ```bash
    CREATE DATABASE nombre_de_la_base_de_datos;
    ```

3. **Seleccionar una Base de Datos:** Para trabajar con una base de datos específica, selecciónala:
    ```bash
    USE nombre_de_la_base_de_datos;
    ```

4. **Mostrar Tablas:** Después de seleccionar una base de datos, puedes ver todas las tablas que contiene:
    ```bash
    SHOW TABLES;
    ```

5. **Mostrar la Estructura de una Tabla:** Para ver la estructura de una tabla, incluyendo los tipos de datos y las restricciones:
    ```bash
    DESCRIBE nombre_de_la_tabla;

    DESC nombre_de_la_tabla;
    ```

6. **Renombrar una Tabla**: Para cambiar el nombre de una tabla:
    ```bash
    RENAME TABLE nombre_viejo TO nombre_nuevo;
    ```

7. **Consultar el Tamaño de una Tabla**
    ```bash
    SELECT table_name AS 'Tabla', 
    ROUND((data_length + index_length) / 1024 / 1024, 2) AS 'Tamaño (MB)' 
    FROM information_schema.TABLES 
    WHERE table_schema = 'nombre_de_la_base_de_datos'
    AND table_name = 'nombre_de_la_tabla';
    ```
8. **Tamaño Total de la Base de Datos**
    ```bash
    SELECT table_schema AS 'Base de Datos', 
    SUM(data_length + index_length) / 1024 / 1024 AS 'Tamaño (MB)' 
    FROM information_schema.TABLES 
    GROUP BY table_schema;
    ```