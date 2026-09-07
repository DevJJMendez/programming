# Liquibase
Liquibase es una herramienta de control de versiones de bases de datos que permite gestionar y automatizar los cambios en el esquema de la base de datos a lo largo del ciclo de vida de un proyecto. Facilita la aplicación incremental y ordenada de modificaciones a la base de datos, utilizando archivos descriptivos y controlados.

## ¿Para qué sirve Liquibase?
Liquibase sirve para:

* Gestionar cambios en la base de datos de forma segura y controlada.
* Mantener sincronizadas las bases de datos entre diferentes entornos (desarrollo, pruebas, producción, etc.).
* Automatizar la actualización de esquemas y datos de manera reproducible.
* Evitar inconsistencias al aplicar cambios manualmente.
* Proporcionar versionado de la base de datos, permitiendo la trazabilidad de cada cambio.
* Facilitar la colaboración entre desarrolladores y equipos.

## ¿Qué problemas resuelve?
* Desorden en los cambios del esquema: Sin Liquibase, los cambios manuales en la base de datos pueden ser difíciles de rastrear, especialmente en equipos grandes.

* Conflictos entre entornos: Asegura que los cambios se aplican en el orden correcto y de manera consistente entre desarrollo, QA, y producción.

* Historial y reversión de cambios: Permite ver quién realizó qué cambios y en qué momento, además de revertir a una versión anterior en caso de problemas.

* Implementaciones manuales: Elimina la necesidad de scripts SQL manuales desorganizados.

## ¿Cómo lo resuelve?
Liquibase resuelve estos problemas mediante el uso de archivos de configuración y cambio, llamados changelogs, que describen los cambios en el esquema de la base de datos en un formato estructurado y legible.

* Control de versiones: Cada cambio (o "changeSet") tiene un identificador único.

* Formatos de changelog: Liquibase soporta múltiples formatos para definir los cambios:
  * XML (changelog.xml)
  * YAML (changelog.yaml)
  * JSON (changelog.json)
  * SQL (changelog.sql)

* Automatización: Permite ejecutar los cambios automáticamente en cualquier entorno.

* Gestión del historial: Liquibase mantiene un registro de los cambios aplicados usando una tabla llamada DATABASECHANGELOG.

## Componentes Principales de Liquibase
### 1. ChangeLog
Es el archivo principal que contiene los cambios a aplicar en la base de datos. Cada cambio se define en bloques llamados changeSets.

Ejemplo de un archivo XML de changelog:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
    xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
        http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.8.xsd">

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

</databaseChangeLog>
```
* id: Identificador único para el cambio.
* author: Nombre del autor.
* changeSet: Bloque de cambio que se aplicará una sola vez.

### 2. Liquibase Commands
Liquibase provee una serie de comandos básicos para gestionar la base de datos:
| Comando           | Descripción                                            |
| ----------------- | ------------------------------------------------------ |
| update            | Aplica todos los cambios pendientes en el changelog.   |
| status            | Muestra los cambios pendientes por ejecutar.           |
| rollback          | Revierte la base de datos a un estado anterior.        |
| validate          | Verifica que los changeSets sean correctos.            |
| changelogSync     | Marca los changeSets como ejecutados, sin aplicarlos.  |
| generateChangeLog | Genera un changelog desde una base de datos existente. |

### 3. DATABASECHANGELOG
Liquibase crea una tabla especial en la base de datos llamada DATABASECHANGELOG, que registra cada cambio aplicado, con información como:

ID del cambio

Autor

Fecha de aplicación

Hash del cambio

Ejemplo de la tabla DATABASECHANGELOG:
| ID  | AUTHOR      | DATEEXECUTED     | MD5SUM   |
| --- | ----------- | ---------------- | -------- |
| 1   | devjjmendez | 2024-09-27 10:00 | abcd1234 |
| 2   | devjjmendez | 2024-09-27 10:15 | efgh5678 |

## Uso de Liquibase en Spring Boot
En Spring Boot, Liquibase se integra fácilmente con el archivo de configuración application.properties o application.yml.

Configuración en application.properties:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/codecake
spring.datasource.username=devjjmendez
spring.datasource.password=9020

# Configuración de Liquibase
spring.liquibase.change-log=classpath:db/changelog/changelog.xml
```
Configuración en application.yml:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/codecake
    username: devjjmendez
    password: 9020
  liquibase:
    change-log: classpath:db/changelog/changelog.xml
```
La propiedad change-log apunta al archivo principal de changelog.

## Flujo de Trabajo con Liquibase
1. Crear un nuevo archivo changelog (XML, YAML, JSON o SQL).

2. Agregar cambios dentro de changeSets.

3. Ejecutar el comando update o iniciar la aplicación Spring Boot (Liquibase se ejecuta automáticamente).

4. Liquibase aplica los cambios y los registra en la tabla DATABASECHANGELOG.

5. Validar el estado de la base de datos con el comando status.

### Buenas Prácticas con Liquibase
* Un cambio por changeSet: Cada cambio pequeño debe ser atómico.

* Naming convention: Utiliza nombres claros para archivos y changeSets.

* Ejemplo: 001_create_users_table.xml, 002_add_email_column.yaml

* Versiona los archivos changelog en Git para rastrear cambios.

* Usa rollback en desarrollo: Define sentencias rollback para facilitar reversiones.
