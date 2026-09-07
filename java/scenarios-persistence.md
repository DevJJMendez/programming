# “escenario de dominio”, “ejemplo concreto” o “domain walkthrough”.
## Escenario: Usuario real usando el Habit Tracker
* Contexto inicial
* Usuario
```text
User
- userId: U-123
- timezone: America/Bogota
```
Este detalle de timezone va a afectar todo lo demás.

### 1. El usuario crea un hábito
**Intención del usuario -> “Quiero leer de forma constante para mejorar mis conocimientos técnicos.”**

Dominio resultante
```text
Habit
- habitId: H-001
- userId: U-123
- name: "Leer libros técnicos"
- intent: "Mejorar mis habilidades como ingeniero"
- frequencyRule:
    type: WEEKLY
    timesPerPeriod: 4
- goal:
    target: 30
    unit: MINUTES
- status: ACTIVE
- createdAt: 2026-01-01T09:15:00-05:00
```
Observaciones de diseño (importantes):
* El hábito no sabe cuándo fue ejecutado
* Solo define expectativas
* No existe ningún streak todavía

### 2. Día 1: Primera ejecución
* 2026-01-01 (Bogotá)
* 21:30

El usuario lee 40 minutos y registra la ejecución.
```text
HabitExecution
- executionId: E-001
- habitId: H-001
- executedAt: 2026-01-01T21:30:00-05:00
- executionDate: 2026-01-01
- source: MANUAL
- notes: "Capítulo sobre Clean Architecture"
```
Qué pasó a nivel dominio -> El hábito valida:
* Está `ACTIVE`
* La fecha no es futura
* Se agrega una ejecución al historial
* 👉 No se actualiza ningún campo de streak
Eso se calcula.

### 3. Día 2: Segunda ejecución (otro día)
* 2026-01-02
* 22:10
```text
HabitExecution
- executionId: E-002
- habitId: H-001
- executedAt: 2026-01-02T22:10:00-05:00
- executionDate: 2026-01-02
```

### 4. Día 3: No hay ejecución
2026-01-03

Nada ocurre. -> Esto NO rompe nada automáticamente porque la frecuencia es semanal, no diaria.

👉 Aquí se ve por qué no asumimos ejecución diaria.

### 5. Día 4: Doble ejecución en el mismo día
* 2026-01-04
* 07:00 y 22:00
```text
HabitExecution
- executionId: E-003
- executionDate: 2026-01-04

HabitExecution
- executionId: E-004
- executionDate: 2026-01-04
```
Decisión de negocio:
* Ambas ejecuciones son válidas
* Pero para métricas:
* Puede contar como 1 día cumplido
* O como 2 sesiones
* 👉 Eso es lógica de proyección, no del core.


### 6. Fin de semana: análisis de progreso
Datos crudos (fuente de verdad)
```text
Executions:
- 01/01
- 02/01
- 04/01 (x2)
```
Frecuencia esperada
```text
4 veces por semana
```
Proyección de progreso (derivada)
```text
Week 1:
- Expected: 4
- Actual: 4
- Success: ✅
```
Nada de esto se guarda en la tabla de hábitos.

### 7. Cambio de regla (caso crítico)
2026-01-10

**El usuario decide -> “Ahora quiero leer todos los días”**

Nueva `FrequencyRule`
```text
FrequencyRule
- type: DAILY
- timesPerPeriod: 1
```
¿Qué pasa con el historial?
* No se borra
* No se recalcula hacia atrás
* Aplica solo hacia adelante

Esto es clave para:
* Métricas honestas
* Evitar reescritura histórica

### 8. Pausa del hábito
2026-01-15
```text
HabitStatus: PAUSED
```
Durante pausa:
* No se esperan ejecuciones
* No se rompe streak
* No se permiten check-ins

### 9. Reactivación
2026-01-20
```text
HabitStatus: ACTIVE
```
La continuidad depende de reglas:
* ¿Se mantiene el streak?
* ¿Se reinicia?
* 👉 Regla explícita de negocio, no efecto colateral.

### 10. Archivado del hábito
2026-02-01
```text
HabitStatus: ARCHIVED
archivedAt: 2026-02-01
```
* No acepta nuevas ejecuciones
* El historial sigue disponible
* Aparece en estadísticas históricas

#### Qué aprendimos del simulacro
Interacciones clave:
* Habit controla la creación de ejecuciones
* HabitExecution es un hecho inmutable
* FrequencyRule gobierna expectativas
* El tiempo y la zona horaria son parte del dominio
* Las métricas emergen de los datos, no se guardan

# PERSISTENCIA -> BASE DE DATOS
1. `users`
```sql
users
------
id (PK)
timezone
created_at
```
2. `habits` (Aggregate Root)
```sql
habits
-------
id (PK)
user_id (FK)
name
intent
status
created_at
archived_at
```
**Decisiones**:
* `status` es un enum (ACTIVE, PAUSED, ARCHIVED)
* Nada de métricas aquí
* No hay frecuencia directamente

3. `habit_schedules` (reglas versionadas)
```sql
habit_schedules
---------------
id (PK)
habit_id (FK)
frequency_type      -- DAILY | WEEKLY | CUSTOM
times_per_period
days_of_week        -- array o jsonb
start_date
end_date
```
Por qué así:
* Permite cambiar reglas sin tocar historia
* Facilita queries temporales
* Escala bien para analytics

4. `habit_executions` (eventos históricos)
```sql
habit_executions
----------------
id (PK)
habit_id (FK)
executed_at          -- timestamp with tz
execution_date       -- date (normalized)
source
notes
```
CLAVE:
* execution_date no se calcula en query
* Se guarda para:
* Performance
* Queries simples
* Evitar bugs de timezone

5. Value Objects vs columnas
| Value Object  | Persistencia                     |
| ------------- | -------------------------------- |
| HabitName     | habits.name                      |
| HabitIntent   | habits.intent                    |
| FrequencyRule | habit_schedules.*                |
| Goal          | tabla o JSON (según complejidad) |
| Timezone      | users.timezone                   |
| ExecutionDate | habit_executions.execution_date  |
￼
👉 El VO vive en código, no en la DB.

Qué NO se persiste (a propósito)
❌ NO guardar:
```text
current_streak
longest_streak
completion_rate
success_percentage
```
Se calculan vía:

Queries

Read models

Proyecciones

Esto te ahorra:

Inconsistencias

Migraciones dolorosas

Bugs invisibles

# Ejemplo real de datos persistidos
habits
```text
id: H-001
user_id: U-123
name: "Leer libros técnicos"
intent: "Mejorar habilidades"
status: ACTIVE
created_at: 2026-01-01
```
habit_schedules
```text
id: S-001
habit_id: H-001
frequency_type: WEEKLY
times_per_period: 4
start_date: 2026-01-01
end_date: NULL
```
habit_executions
```text
E-001 | H-001 | 2026-01-01T21:30 | 2026-01-01
E-002 | H-001 | 2026-01-02T22:10 | 2026-01-02
E-003 | H-001 | 2026-01-04T07:00 | 2026-01-04
E-004 | H-001 | 2026-01-04T22:00 | 2026-01-04
```
Índices (performance real)
Un unicornio no sobrevive sin índices bien pensados.
```sql
CREATE INDEX idx_habit_exec_habit_date
ON habit_executions (habit_id, execution_date);

CREATE INDEX idx_habit_exec_date
ON habit_executions (execution_date);

CREATE INDEX idx_habit_schedule_active
ON habit_schedules (habit_id)
WHERE end_date IS NULL;
```
Read models (opcional pero poderoso)
Para dashboards rápidos:
```text
habit_progress_view
-------------------
habit_id
period_start
period_end
expected_count
actual_count
success
```
Esto:

NO es fuente de verdad

Se puede reconstruir

Se puede borrar sin miedo

Antipatrones comunes (alerta 🚨)
❌ habits.completed_today
❌ habits.streak
❌ habits.last_completed_at
❌ lógica de negocio en SQL triggers

Todos estos:

Rompen el dominio

Generan bugs silenciosos

No escalan