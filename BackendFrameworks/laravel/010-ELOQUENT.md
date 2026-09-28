### Eloquent
Eloquent es el ORM (Object-Relational Mapping) oficial de Laravel. Proporciona una forma sencilla y expresiva de interactuar con la base de datos. Eloquent convierte las tablas de la base de datos en modelos de PHP que puedes manipular como objetos, lo que hace que trabajar con bases de datos sea mucho más intuitivo y menos propenso a errores que usar consultas SQL en bruto.

### Características Principales de Eloquent
- **Modelos**: Cada tabla de la base de datos tiene un modelo correspondiente que se utiliza para interactuar con esa tabla. Los modelos Eloquent permiten realizar operaciones **CRUD (Crear, Leer, Actualizar, Eliminar)** de manera fácil y segura.

- **Relaciones**: Eloquent facilita la definición de relaciones entre tablas (**uno a uno**, **uno a muchos**, **muchos a muchos**, etc.). Estas relaciones se pueden usar para recuperar datos relacionados sin necesidad de escribir consultas SQL complejas.

- **Consultas Dinámicas**: Permite construir consultas de manera programática utilizando métodos encadenados, lo que hace que las consultas sean más legibles y mantenibles.

- **Mutadores y Accesores**: Permiten modificar el valor de un atributo antes de guardarlo en la base de datos (mutadores) o después de recuperarlo (accesores).

- **Scopes**: Permiten definir partes reutilizables de consultas que se pueden aplicar a los modelos Eloquent.

- **Eventos y Observadores**: Proporcionan una forma de engancharse en el ciclo de vida de un modelo para ejecutar código en respuesta a ciertos eventos (creación, actualización, eliminación, etc.)

### Relaciones
Eloquent proporciona métodos para definir relaciones entre modelos. Las relaciones comunes son `hasOne`, `hasMany`, `belongsTo`, `belongsToMany`, etc. Estos métodos permiten definir la relación entre dos modelos, facilitando el acceso a datos relacionados.

