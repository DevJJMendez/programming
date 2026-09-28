# NIVEL 1 — Fundamentos sólidos (Junior DBA)
## Objetivo
* Entender cómo funciona MySQL internamente y escribir SQL correcto y seguro.

* Conocimientos
  * ¿Qué es una base de datos relacional?
  * MySQL vs MariaDB
  * Motores de almacenamiento:
    * InnoDB (OBLIGATORIO dominar)

  * Tipos de datos:
    * INT, BIGINT
    * VARCHAR vs CHAR
    * DATE, DATETIME, TIMESTAMP
    * NULL vs NOT NULL

  * Claves:
    * PRIMARY KEY
    * FOREIGN KEY

  * Normalización (1FN, 2FN, 3FN)
  * Convenciones de nombres (snake_case)


# NIVEL 2 — SQL profesional (Mid-level DBA)
## Objetivo
* Escribir consultas eficientes, legibles y mantenibles.

* Conocimientos
  * SELECT avanzado
  * JOINs:
    * INNER
    * LEFT

  * WHERE vs HAVING
  * ORDER BY + LIMIT

  * Funciones:
    * COUNT, SUM, AVG
    * GROUP BY

  * Subconsultas
    * Alias claros
    * Evitar SELECT *

# NIVEL 3 — Indexación y Performance (DBA real)
## Objetivo
* Entender por qué una consulta es lenta y cómo optimizarla.
* Conocimientos CLAVE
  * Índices:
    * BTREE
    * índices compuestos

  * Cardinalidad
  * Índices vs escrituras
  * EXPLAIN / EXPLAIN ANALYZE
  * Covering indexes
  * Evitar funciones en WHERE
  * N+1 problem

# NIVEL 4 — Modelado avanzado y reglas de negocio
## Objetivo
* Diseñar esquemas robustos, escalables y coherentes.
* Conocimientos
  * Relaciones 1:N y N:M
  * Tablas pivote (project_assignments)
  * Constraints:
    * UNIQUE
    * CHECK (MySQL 8+)

  * Soft deletes
  * Auditoría (created_at, updated_at)
  * Consistencia referencial
  * ON DELETE / ON UPDATE

# NIVEL 5 — Transacciones, concurrencia y seguridad
## Objetivo
* Evitar corrupción de datos en sistemas concurrentes.
* Conocimientos
  * ACID
  * Transacciones:
    * START TRANSACTION
    * COMMIT / ROLLBACK

  * Locks:
    * Row-level locks

  * Isolation levels:
    * READ COMMITTED
    * REPEATABLE READ

  * Deadlocks
  * Usuarios y permisos MySQL
  * SQL Injection (prevención)

# NIVEL 6 — Escalabilidad, alta disponibilidad y DBA Senior
## Objetivo -> Operar MySQL en producción real.
* Conocimientos AVANZADOS
  * Replicación:
    * Master → Replica
  * Read replicas
  * Backups:
      * mysqldump
      * Percona XtraBackup
  * Restore y DRP
  * Monitoreo:
    * Slow Query Log
    * Performance Schema

  * Particionamiento
  * Sharding (conceptual)
  * MySQL en Docker
  * MySQL en AWS (RDS)