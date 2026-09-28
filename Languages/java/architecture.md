# Arquitectura:
```bash
habit-tracker
│
├── users
│   ├── User
│   ├── UserRepository
│   └── UserService
│
├── habits
│   ├── domain
│   │   ├── Habit
│   │   ├── HabitExecution
│   │   ├── FrequencyRule
│   │   └── HabitStatus
│   │
│   ├── application
│   │   ├── CreateHabitService
│   │   ├── RecordHabitExecutionService
│   │   └── PauseHabitService
│   │
│   ├── infrastructure
│   │   ├── HabitRepositoryImpl
│   │   └── JpaEntities / ORM
│   │
│   └── api
│       └── HabitController
│
└── common
    ├── Timezone
    ├── DomainException
    └── Clock
```