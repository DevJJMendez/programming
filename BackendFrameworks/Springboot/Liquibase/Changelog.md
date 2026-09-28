# Changelog
El ChangeLog es un archivo principal en Liquibase que contiene una secuencia ordenada de cambios (llamados changeSets) que se aplican a una base de datos. Es el núcleo del funcionamiento de Liquibase y actúa como un registro estructurado de modificaciones en el esquema de la base de datos.

## ¿Para qué sirve el ChangeLog?
El ChangeLog sirve para:

* Documentar y versionar los cambios en la base de datos.
* Automatizar la aplicación de cambios mediante una secuencia ordenada.
* Garantizar la consistencia en diferentes entornos (desarrollo, pruebas, producción).
* Facilitar la reversión de cambios si ocurre un problema.
* Sincronizar el esquema de la base de datos con los cambios realizados en el código de la aplicación.

En resumen, el ChangeLog centraliza la gestión de cambios en la base de datos y permite el seguimiento de su historial.

## ¿Cuál es su estructura?
Un archivo ChangeLog puede estar en XML, YAML, JSON o SQL. La estructura básica contiene:

* Encabezado: Declaración del esquema y versión del archivo.
* changeSets: Unidades atómicas de cambio aplicadas a la base de datos.
* Metadatos: Información adicional como id, author, fecha, etc.

Ejemplo de un ChangeLog en XML
```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
        http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">

    <!-- ChangeSet 1: Crear tabla -->
    <changeSet id="1" author="devjjmendez">
        <createTable tableName="users">
            <column name="id" type="int" autoIncrement="true">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="username" type="varchar(255)">
                <constraints unique="true" nullable="false"/>
            </column>
            <column name="email" type="varchar(255)">
                <constraints nullable="false"/>
            </column>
        </createTable>
    </changeSet>

    <!-- ChangeSet 2: Insertar datos iniciales -->
    <changeSet id="2" author="devjjmendez">
        <insert tableName="users">
            <column name="username" value="admin"/>
            <column name="email" value="admin@example.com"/>
        </insert>
    </changeSet>

</databaseChangeLog>
```
### Partes del archivo:
1. Encabezado del archivo:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog" ...>
```

2. changeSet: Unidad mínima de cambio. Contiene:

* id: Identificador único del cambio.
* author: Nombre del autor.
* Operaciones como createTable, insert, addColumn, etc.

3. Operaciones soportadas:

* Crear tablas (createTable).
* Insertar datos (insert).
* Modificar columnas (addColumn, dropColumn).
* Agregar índices o restricciones (addIndex, addForeignKeyConstraint).
* Ejecutar SQL nativo (sql).

## ¿Qué resuelve el ChangeLog?
El archivo ChangeLog resuelve problemas comunes en la gestión de bases de datos:

1. Falta de control de versiones: Proporciona una secuencia clara y ordenada de cambios aplicados en la base de datos.
2. Inconsistencias entre entornos: Asegura que los cambios se aplican de manera consistente en todos los entornos (dev, QA, producción).
3. Dificultad para revertir cambios: Permite definir instrucciones de reversión con el comando rollback.
4. Colaboración en equipo: Facilita el trabajo colaborativo al documentar los cambios de manera centralizada.
5. Historial de cambios: Proporciona trazabilidad y un registro detallado de las modificaciones realizadas.

## ¿Cómo lo resuelve?
Liquibase, mediante el ChangeLog, aplica los cambios secuencialmente y registra el estado de la base de datos en una tabla especial llamada DATABASECHANGELOG.

Mecanismo de Aplicación:
Lectura del ChangeLog: Liquibase analiza el archivo ChangeLog.

Verificación de cambios aplicados: Consulta la tabla DATABASECHANGELOG para identificar los cambios pendientes.

Aplicación de changeSets: Ejecuta los cambios que no se han aplicado.

Registro del historial: Agrega los cambios aplicados a la tabla DATABASECHANGELOG para evitar duplicados.

Tabla DATABASECHANGELOG:
| ID  | AUTHOR      | DATEEXECUTED     | MD5SUM   |
| --- | ----------- | ---------------- | -------- |
| 1   | devjjmendez | 2024-09-27 10:00 | abcd1234 |
| 2   | devjjmendez | 2024-09-27 10:15 | efgh5678 |

## Tipos de ChangeLog
1. Archivo principal: Es el archivo de entrada principal que contiene una lista de archivos secundarios.
```xml
<databaseChangeLog>
    <include file="db/changelog/001-create-table.xml"/>
    <include file="db/changelog/002-insert-data.xml"/>
</databaseChangeLog>
```

2. Archivos secundarios: Archivos con cambios específicos.

3. ChangeLog jerárquico: Permite dividir los cambios en múltiples archivos más pequeños y organizados.

## Buenas Prácticas con el ChangeLog
Cambios pequeños y atómicos: Define un solo cambio por changeSet.

Uso de identificadores únicos: Asegúrate de que cada id sea único.

División del ChangeLog: Divide el archivo en múltiples archivos más pequeños y organizados.

Ejemplo:

001-create-tables.xml

002-insert-initial-data.xml

Evita modificar changeSets aplicados: Una vez que se aplica un changeSet, no lo modifiques.

Rollback explícito: Define instrucciones de rollback cuando sea necesario.
```xml
<changeSet id="3" author="devjjmendez">
    <addColumn tableName="users">
        <column name="created_at" type="timestamp"/>
    </addColumn>
    <rollback>
        <dropColumn tableName="users" columnName="created_at"/>
    </rollback>
</changeSet>
```

Versiona el ChangeLog: Utiliza Git para mantener el historial de cambios.