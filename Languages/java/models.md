🔹 HabitStatus
```text
HabitStatus
- ACTIVE
- PAUSED
- ARCHIVED
```

Analizando los modelos que tenemos y la jerarquia de relaciones:

User
```text
- userId
- timezone
- preferences
```
Habit
```text
- habitId
- userId
- name
- description
- intent
- frequencyRule
- goal
- status
- createdAt
- archivedAt?
```
HabitExecution 
```text
HabitExecution
- executionId
- habitId
- executedAt
- executionDate (normalizada por timezone)
- source (manual, auto, integration)
- notes?
```
HabitSchedule (opcional pero potente)
```text
HabitSchedule
- scheduleId
- habitId
- recurrenceRule
- startDate
- endDate?
```
HabitStreak (⚠️ derivado, no persistente)
```text
HabitStreak
- currentStreak
- longestStreak
- brokenAt?
```
Perfecto entonces nuestros Value Objects serian:
Value Objects
🔹 HabitName
```text
HabitName
- value
- rules:
  - not empty
  - max length
```
🔹 HabitIntent
```text
HabitIntent
- description
- motivationLevel?
```
🔹 FrequencyRule (CRÍTICO 🔥)
```text
FrequencyRule
- type: DAILY | WEEKLY | CUSTOM
- timesPerPeriod
- daysOfWeek?
```
🔹 Goal
Define qué es “éxito”.
```text
Goal
- target
- unit (times, minutes, pages)
```

🔹 Timezone
```text
Timezone
- zoneId (IANA)
```
🔹 ExecutionDate
```text
ExecutionDate
- localDate
- derived from executedAt + timezone
```
HabitId y UserID

Por lo que entiendí estos configuran reglas (y no comportamientos cierto?), entonces necesito que me hagas los casos de de uso de cada uno (yo me encargare de codear a modo de aprendizaje)

ademas enseñame la estructura de HabitId y UserID


# Entidades principales (Core Domain)
🧠 1. User (Agregado raíz externo)
Aunque no es el core conceptual, todo cuelga del usuario.
```bash
User
- userId
- timezone
- preferences
```
Nota: El User NO debería tener lógica de hábitos dentro.
Eso vive en el agregado Habit.

2. Habit (AGREGADO RAÍZ 🔥)
Esta es la entidad más importante del sistema.
```bash
Habit
- habitId
- userId
- name
- description
- intent
- frequencyRule
- goal
- status
- createdAt
- archivedAt?
```
Responsabilidades:
Define qué significa “cumplir”

Define cuándo debería ejecutarse

Protege sus invariantes

👉 Todo lo que afecte al hábito pasa por él.

3. HabitExecution (Entidad hija)
Representa un hecho histórico.
```bash
HabitExecution
- executionId
- habitId
- executedAt
- executionDate (normalizada por timezone)
- source (manual, auto, integration)
- notes?
```
Importante:
Es append-only

No se edita (o se versiona)

Vive bajo el agregado Habit (conceptualmente)

4. HabitSchedule (opcional pero potente)
Si queremos escalar bien:
```bash
HabitSchedule
- scheduleId
- habitId
- recurrenceRule
- startDate
- endDate?
```
Esto permite:

Cambiar reglas sin romper historia

Versionar frecuencias

5. HabitStreak (⚠️ derivado, no persistente)
Conceptual, no necesariamente entidad persistida:
```bash
HabitStreak
- currentStreak
- longestStreak
- brokenAt?
```
Vive como Domain Projection o Read Model.

# Value Objects (aquí vive la magia ✨)
Los Value Objects eliminan bugs antes de que existan.

🔹 HabitName
```bash
HabitName
- value
- rules:
  - not empty
  - max length
```
🔹 HabitIntent
Define el “para qué” del hábito.
```bash
HabitIntent
- description
- motivationLevel?
```
Ayuda a:

Recordatorios

Insights

Personalización

🔹 FrequencyRule (CRÍTICO 🔥)
```bash
FrequencyRule
- type: DAILY | WEEKLY | CUSTOM
- timesPerPeriod
- daysOfWeek?
```
Ejemplos:

Diario

3 veces por semana

Lunes, miércoles, viernes

👉 Este VO define gran parte de la complejidad del sistema.

🔹 Goal
Define qué es “éxito”.
```bash
Goal
- target
- unit (times, minutes, pages)
```
Ejemplo:

Leer 20 minutos

Meditar 1 vez

Beber 2 litros

🔹 Timezone
```bash
Timezone
- zoneId (IANA)
```
Evita:

Bugs de “ayer / hoy”

Streaks rotos injustamente

🔹 ExecutionDate
```bash
ExecutionDate
- localDate
- derived from executedAt + timezone
```
No confundir con timestamp.

🔹 HabitStatus
```bash
HabitStatus
- ACTIVE
- PAUSED
- ARCHIVED
```
Reglas:

ARCHIVED → no permite ejecuciones

PAUSED → no rompe streaks

# Entidades Supporting (para el unicornio 🦄)
🔔 Notification
```bash
Notification
- schedule
- channel
- messageTemplate
```
🎮 Achievement / Badge
```bash
Achievement
- type
- unlockedAt
```

📊 HabitInsight
Read-model avanzado:
* Best day
* Worst day
* Success rate
* Consistency score

# 6️⃣ Agregados y límites (CLAVE)
```bash
User
 └── Habit (Aggregate Root)
      ├── HabitExecution
      ├── HabitSchedule
      └── FrequencyRule (VO)
```
Regla -> Nunca se crea una ejecución sin pasar por el Habit

Esto protege:
* Estados inválidos
* Reglas rotas
* Datos corruptos

# 7️⃣ Decisiones de diseño senior (importantes)
✔️ Ejecuciones separadas de hábitos
✔️ Frecuencia como Value Object
✔️ Métricas derivadas
✔️ Timezone explícito
✔️ Historial inmutable

Todo esto:
* Escala
* Se testea fácil
* Permite features futuras sin refactor masivo

# 🧩 Supporting Domains
Usuarios

Notificaciones

Gamificación

Integraciones

Analytics

Nos enfocaremos primero en el Core Domain.