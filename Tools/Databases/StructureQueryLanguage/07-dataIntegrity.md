# Integridad de Datos
La integridad de datos se refiere a la precisión, coherencia y fiabilidad de los datos almacenados en una base de datos a lo largo de su ciclo de vida. Mantener la integridad de los datos es esencial para garantizar que la información en una base de datos esté libre de corrupción y errores, y que sea consistente entre las diversas interacciones con el sistema.

## Tipos de Integridad de Datos
Existen varios tipos de integridad de datos que se utilizan para asegurar que los datos sean correctos y válidos:

### Integridad de Entidad (Entity Integrity)
**¿Qué es?**: La integridad de entidad asegura que cada fila o registro en una tabla sea único, lo que se garantiza mediante el uso de claves primarias.

**¿Para qué se utiliza?**: Se utiliza para garantizar que no haya registros duplicados en una tabla y que cada fila sea identificable de manera única.

**¿Qué resuelve?**: Evita la duplicación de datos y asegura que cada registro tenga un identificador único.

**¿Cómo se implementa?**: Mediante el uso de claves primarias (**`PRIMARY KEY`**), que no permiten valores nulos ni duplicados. Por ejemplo, en una tabla de `usuarios`, la columna `user_id` debe ser única para cada usuario:
```sql
CREATE TABLE usuarios (
  user_id INT PRIMARY KEY,
  nombre VARCHAR(100),
  email VARCHAR(100)
);
```

### Integridad Referencial (Referential Integrity)
**¿Qué es?**: La integridad referencial asegura que las relaciones entre las tablas se mantengan correctamente, lo cual se gestiona a través de las claves foráneas.

**¿Para qué se utiliza?**: Se utiliza para asegurar que los valores de una columna que hacen referencia a otra tabla coincidan con los valores existentes en esa tabla relacionada.

**¿Qué resuelve?**: Previene que haya registros "huérfanos" o relaciones rotas entre tablas. Por ejemplo, no debería existir un pedido asociado a un cliente que no existe.

**¿Cómo se implementa?**: Utilizando claves foráneas (`FOREIGN KEY`) que aseguran que un valor en una tabla coincida con un valor en otra tabla relacionada:
```sql
CREATE TABLE pedidos (
  pedido_id INT PRIMARY KEY,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES usuarios(user_id)
);
```

### Integridad de Dominio (Domain Integrity)
**¿Qué es?**: La integridad de dominio asegura que los valores de una columna caigan dentro de un rango de valores permisibles, como tipos de datos, formatos o restricciones específicas.

**¿Para qué se utiliza?**: Se utiliza para asegurar que los valores de una columna sean válidos y adecuados para el tipo de datos de esa columna.

**¿Qué resuelve?**: Previene la inserción de datos inválidos o fuera del rango esperado, como intentar almacenar texto en una columna que debe contener números.

**¿Cómo se implementa?**: Se implementa mediante el uso de tipos de datos adecuados (`INTEGER`, `VARCHAR`, `DATE`, etc.), y mediante restricciones (`CHECK`, `NOT NULL`, `UNIQUE`):
```sql
CREATE TABLE productos (
  producto_id INT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  precio DECIMAL(10, 2) CHECK (precio > 0)
);
```

### Integridad de Usuario (User-Defined Integrity)
**¿Qué es?**: La integridad definida por el usuario permite a los administradores de bases de datos crear reglas personalizadas que no están cubiertas por las otras formas de integridad.

**¿Para qué se utiliza?**: Se utiliza cuando las reglas de negocio específicas requieren restricciones adicionales que no se pueden expresar mediante claves o tipos de datos estándar.

**¿Qué resuelve?**: Resuelve la necesidad de aplicar reglas de negocio que son únicas para una aplicación o dominio específico, como que una columna deba tener un valor en función de otro valor.

**¿Cómo se implementa?**: Mediante triggers o procedimientos almacenados que validen datos de acuerdo con reglas complejas:
```sql
CREATE TRIGGER validar_stock
BEFORE INSERT ON pedidos
FOR EACH ROW
BEGIN
  IF NEW.cantidad > (SELECT stock FROM productos WHERE producto_id = NEW.producto_id) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Stock insuficiente';
  END IF;
END;
```

## ¿Para qué se utiliza la Integridad de Datos?
La integridad de datos se utiliza para garantizar que los datos en la base de datos sean:

* **Precisos**: Los valores almacenados deben reflejar correctamente la realidad o los requisitos del sistema.

* **Coherentes**: Los datos deben cumplir con las reglas definidas para que no se introduzcan inconsistencias.

* **Confiables**: Los usuarios deben poder confiar en que los datos almacenados son válidos y utilizables.

## ¿Qué resuelve?
La integridad de datos resuelve problemas que pueden surgir debido a:

* Errores humanos durante la inserción o actualización de datos.

* Concurrencia en las transacciones, donde múltiples usuarios pueden estar manipulando los mismos datos al mismo tiempo.

* Datos corruptos o no válidos que pueden llevar a decisiones incorrectas o resultados inexactos.

## ¿Cómo se resuelve la Integridad de Datos?
La integridad de datos se mantiene utilizando las siguientes herramientas y técnicas:

* **Claves Primarias y Foráneas**: Aseguran la unicidad y las relaciones entre tablas.

* **Restricciones (`Constraints`)**: Como `NOT NULL`, `CHECK`, `UNIQUE` para limitar los valores de las columnas a un dominio válido.

* **Transacciones `ACID`**: Aseguran que los cambios realizados en una base de datos sigan las reglas de atomicidad, consistencia, aislamiento y durabilidad.

* **Triggers y Procedimientos Almacenados**: Para reglas complejas o personalizadas de validación de datos.

* **Niveles de Aislamiento**: Aseguran que las transacciones concurrentes no introduzcan inconsistencias en los datos.