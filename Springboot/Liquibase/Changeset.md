# Changeset
Un ChangeSet en Liquibase es la unidad mínima de cambio que define una acción específica a aplicar en la base de datos. Representa una operación atómica (como crear tablas, agregar columnas o insertar datos) que Liquibase ejecuta de forma secuencial y registra en su historial.

Cada ChangeSet tiene un identificador único y metadatos asociados que permiten a Liquibase saber si un cambio ya fue aplicado o no.

## ¿Para qué sirven los ChangeSets?
Los ChangeSets sirven para:

* Aplicar cambios atómicos a la base de datos de manera ordenada.
* Evitar duplicados: Liquibase registra los ChangeSets aplicados en la tabla DATABASECHANGELOG.
* Garantizar la integridad del esquema de la base de datos al aplicar los cambios en un orden específico.
* Definir instrucciones de reversión (rollback) en caso de errores.
* Facilitar la colaboración entre desarrolladores al versionar los cambios en la base de datos.
* Sincronizar bases de datos entre distintos entornos (desarrollo, pruebas, producción).

## ¿Cuál es su estructura?
Un ChangeSet tiene una estructura definida y consta de las siguientes partes:

1. Metadatos del ChangeSet:
* id: Identificador único del cambio (obligatorio).
* author: Autor del cambio (obligatorio).
* runOnChange: Si true, el ChangeSet se ejecutará nuevamente si se modifica (opcional).
* runAlways: Si true, el ChangeSet se ejecutará cada vez que se ejecute Liquibase (opcional).
* context: Contexto en el que debe ejecutarse el ChangeSet (por ejemplo, dev, prod).

2. Operación de cambio: Acciones concretas que se aplicarán a la base de datos (como createTable, addColumn, insert, sql, etc.).

3. Rollback (opcional): Instrucciones para deshacer el cambio en caso de error.

Ejemplo de un ChangeSet en XML
```xml
<changeSet id="1" author="devjjmendez">
    <!-- Crear una tabla llamada 'users' -->
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

    <!-- Rollback para eliminar la tabla -->
    <rollback>
        <dropTable tableName="users"/>
    </rollback>
</changeSet>
```

## ¿Qué resuelven los ChangeSets?
Los ChangeSets resuelven problemas comunes en la gestión de bases de datos, como:

1. Falta de versionado: Documentan los cambios aplicados con un historial estructurado.
2. Inconsistencia entre entornos: Aseguran que los mismos cambios se apliquen de manera ordenada y secuencial en todos los entornos.
3. Aplicación duplicada de cambios: Evitan la reejecución de cambios aplicados, gracias a la tabla DATABASECHANGELOG.
4. Dificultad en el rollback: Permiten definir instrucciones para revertir cambios específicos.
5. Problemas de colaboración: Facilitan el trabajo en equipo al versionar los cambios en un sistema de control de versiones como Git.

## ¿Cómo lo resuelven?
Liquibase utiliza ChangeSets como base para ejecutar cambios en la base de datos de manera ordenada y segura. Lo hace de la siguiente forma:

Identificación de ChangeSets no aplicados:

Al ejecutar Liquibase, consulta la tabla DATABASECHANGELOG para verificar qué ChangeSets ya se aplicaron.

Solo aplica los ChangeSets que no están registrados en esta tabla.

Ejecución secuencial:

Liquibase aplica los ChangeSets en el orden en que aparecen en el archivo ChangeLog.

Registro en la tabla DATABASECHANGELOG:

Después de ejecutar un ChangeSet, Liquibase guarda su:

ID.

Autor.

Nombre del archivo ChangeLog.

Fecha de ejecución.

Hash MD5 para detectar cambios.

Rollback:

Si se define una sección de rollback en un ChangeSet, Liquibase puede revertir ese cambio.

## Ejemplo de ChangeSets en Diferentes Formatos
Formato YAML
```yaml
databaseChangeLog:
  - changeSet:
      id: "1"
      author: "devjjmendez"
      changes:
        - createTable:
            tableName: "users"
            columns:
              - column:
                  name: "id"
                  type: "int"
                  autoIncrement: true
                  constraints:
                    primaryKey: true
                    nullable: false
              - column:
                  name: "username"
                  type: "varchar(255)"
                  constraints:
                    nullable: false
                    unique: true
              - column:
                  name: "email"
                  type: "varchar(255)"
                  constraints:
                    nullable: false
      rollback:
        - dropTable:
            tableName: "users"
```
Formato JSON
```json
{
  "databaseChangeLog": [
    {
      "changeSet": {
        "id": "1",
        "author": "devjjmendez",
        "changes": [
          {
            "createTable": {
              "tableName": "users",
              "columns": [
                {
                  "name": "id",
                  "type": "int",
                  "autoIncrement": true,
                  "constraints": {
                    "primaryKey": true,
                    "nullable": false
                  }
                },
                {
                  "name": "username",
                  "type": "varchar(255)",
                  "constraints": {
                    "nullable": false,
                    "unique": true
                  }
                },
                {
                  "name": "email",
                  "type": "varchar(255)",
                  "constraints": {
                    "nullable": false
                  }
                }
              ]
            }
          }
        ],
        "rollback": [
          {
            "dropTable": {
              "tableName": "users"
            }
          }
        ]
      }
    }
  ]
}
```

## Buenas Prácticas con ChangeSets
* Cambios pequeños y atómicos: Un ChangeSet debe contener un solo cambio.
* IDs únicos: Cada ChangeSet debe tener un ID único dentro de un archivo ChangeLog.
* Rollback explícito: Define siempre instrucciones de rollback.
* Evita modificar ChangeSets aplicados: Si necesitas corregir un cambio anterior, crea un nuevo ChangeSet.
* Divide archivos grandes: Usa múltiples archivos ChangeLog para cambios complejos.
* Documentación clara: Usa nombres descriptivos en los IDs y comentarios para indicar qué hace el cambio.

# Relaciones
Liquibase proporciona una forma estándar para agregar claves foráneas.

```xml
<changeSet id="create-foreign-key" author="devjjmendez">
    <addForeignKeyConstraint 
        baseTableName="orders"
        baseColumnNames="customer_id"
        referencedTableName="customers"
        referencedColumnNames="id"
        constraintName="fk_orders_customers"/>
</changeSet>
```
id: Identificador único del ChangeSet.

author: Autor del ChangeSet.

addForeignKeyConstraint: Etiqueta para agregar una clave foránea.

baseTableName: La tabla que contendrá la clave foránea (orders).

baseColumnNames: Columna de la tabla que hace referencia (customer_id).

referencedTableName: Tabla a la que se hace referencia (customers).

referencedColumnNames: Columna de la tabla referenciada (id).

constraintName: Nombre de la restricción.

Ejemplo en formato YAML
```yaml
databaseChangeLog:
  - changeSet:
      id: create-foreign-key
      author: devjjmendez
      changes:
        - addForeignKeyConstraint:
            baseTableName: orders
            baseColumnNames: customer_id
            referencedTableName: customers
            referencedColumnNames: id
            constraintName: fk_orders_customers
```

## Ejemplo en SQL nativo (dentro de un ChangeSet)
Si prefieres usar SQL puro, puedes escribirlo dentro del ChangeSet:
```sql
databaseChangeLog:
  - changeSet:
      id: create-foreign-key-sql
      author: devjjmendez
      sql: |
        ALTER TABLE orders
        ADD CONSTRAINT fk_orders_customers
        FOREIGN KEY (customer_id) REFERENCES customers(id);
```

## ¿Qué resuelve?
Integridad referencial: Garantiza que los valores en la columna referenciada existen en la tabla padre.

Relaciones explícitas: Facilita entender la relación entre tablas.

Evita errores: Por ejemplo, no puedes insertar un customer_id en la tabla orders si no existe en la tabla customers.

# Indices
Se pueden crear índices para mejorar el rendimiento de las consultas de la base de datos. Esto se hace mediante la etiqueta <createIndex> en formato XML, YAML o incluso SQL dentro del ChangeSet.

En un ChangeSet, crear índices es útil para optimizar las consultas a las tablas, especialmente cuando tienes grandes cantidades de datos.

```xml
<changeSet id="create-index" author="devjjmendez">
    <createIndex indexName="idx_customer_email"
                 tableName="customers">
        <column name="email"/>
    </createIndex>
</changeSet>
```
Explicación:

id: Identificador único del ChangeSet.

author: Autor del ChangeSet.

createIndex: Etiqueta para crear un índice.

indexName: Nombre del índice (idx_customer_email).

tableName: Tabla en la que se creará el índice (customers).

<column name="email"/>: Especifica la columna sobre la cual se creará el índice (email).

Formato YAML
```yaml
databaseChangeLog:
  - changeSet:
      id: create-index
      author: devjjmendez
      changes:
        - createIndex:
            indexName: idx_customer_email
            tableName: customers
            columns:
              - name: email
```

Formato SQL
Si prefieres usar SQL puro dentro de un ChangeSet, puedes hacerlo así:
```sql
databaseChangeLog:
  - changeSet:
      id: create-index-sql
      author: devjjmendez
      sql: |
        CREATE INDEX idx_customer_email
        ON customers(email);
```

## Ejemplo más avanzado: Índice compuesto
Si necesitas un índice compuesto en más de una columna, el proceso es similar:

```yaml
databaseChangeLog:
  - changeSet:
      id: create-composite-index
      author: devjjmendez
      changes:
        - createIndex:
            indexName: idx_customer_name_email
            tableName: customers
            columns:
              - name: last_name
              - name: email
```