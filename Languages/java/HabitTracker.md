

* Habit (AGREGADO RAÍZ 🔥)
Esta es la entidad más importante del sistema.
```bash
Habit
- habitId # Long
- userId # Long
- name # String
- description # String
- intent # String
- frequencyRule # relation-entity???
- goal # relation-entity???
- status # Enum
- createdAt # date
- archivedAt? # date
```
Dominio resultante:
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

Explicame el objetivo de cada campo y el tipo de dato adecuado para cada uno (en especial la fechas para hacerlo de forma optima)
---

# Regla de oro:
Primero comportamiento, luego persistencia, luego API.

entendido, iniciaremos en habits/domain haciendo lo siguiente:

```bash
├── habits
│   ├── domain
│   │   ├── Habit 
│   │   ├── HabitExecution
│   │   ├── FrequencyRule
│   │   └── HabitStatus
```

---

# Entender el dominio (Domain-first)
Antes de hablar de frameworks, hablaremos de:

* Qué es un hábito
* Qué significa trackear
* Qué reglas de negocio existen
* Qué problemas reales resolvemos
* Aquí aplicaremos DDD ligero (táctico, no pesado).

# Definir requerimientos (claros y reales)
Separaremos:
* Requerimientos funcionales
* Requerimientos no funcionales (performance, escalabilidad, seguridad)
* Esto evita:
* Endpoints mal diseñados
* Lógica duplicada
* Reescrituras innecesarias

# Diseñar la arquitectura (agnóstica)
Antes de Spring / Node / cualquier cosa:
* Capas
* Responsabilidades
* Flujo de dependencias
* Límites claros
* Usaremos conceptos como:
* Hexagonal / Clean Architecture
* Use Cases / Application Services
* Domain Model
* Ports & Adapters

# Modelar el dominio
Diseñaremos:
* Entidades
* Value Objects
* Agregados
* Reglas de negocio
* Aquí es donde vive la lógica importante, no en los controllers.

# API & Persistencia (después)
Solo cuando el core esté claro:
* REST endpoints
* DTOs
* Repositorios
* Mapeos
* Framework = detalle de implementación.

# Buenas prácticas reales
A lo largo del proceso hablaremos de:
* Errores comunes en backend
* Antipatrones
* Trade-offs reales
* Cómo escalar sin romper todo

# Filosofía clave (importante que la tengas clara)
El backend no es CRUD + controllers.
Es modelo + reglas + casos de uso, con el framework trabajando para ti, no al revés.

Si haces esto bien:
* Cambiar de framework no duele
* Agregar features es barato
* Testear es natural
* El código se explica solo

# 1. Principios antes de modelar (muy importante)
Antes de listar entidades, fijemos reglas de oro:

* El dominio manda, no la base de datos
* Las entidades existen porque tienen identidad y reglas
* Los Value Objects existen para proteger invariantes
* Nada de “Dios objects”
* Las métricas se derivan, no se persisten

# 2. Core Domain vs Supporting Domains
🎯 Core Domain (lo que hace único al producto)
Hábitos

* Reglas de recurrencia
* Ejecuciones
* Consistencia / progreso