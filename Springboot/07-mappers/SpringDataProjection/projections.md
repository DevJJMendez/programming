# Spring Data Projection
Spring Data Projection es una característica que permite definir interfaces o clases personalizadas para extraer datos específicos de una consulta, en lugar de recuperar entidades completas desde una base de datos. Es útil cuando necesitas optimizar el rendimiento de tus consultas al trabajar con grandes cantidades de datos.

## ¿Qué es Spring Data Projection?
Es un mecanismo proporcionado por Spring Data JPA para proyectar (o seleccionar) solo un subconjunto de los datos de una entidad. Con esto, puedes definir cómo se estructuran los datos devueltos por las consultas en lugar de usar las clases de entidad completas.

## ¿Para qué sirve?
* Optimización de consultas: Recuperar solo los datos necesarios reduce el consumo de memoria y mejora el rendimiento.

* Evitar sobrecarga de entidades: Reduce la necesidad de cargar relaciones innecesarias.

* Flexibilidad de datos: Permite crear vistas personalizadas de los datos sin modificar las entidades.

* Desacoplamiento: Las proyecciones separan los datos necesarios para las vistas del diseño interno de las entidades.

## ¿Qué resuelve?
* Carga excesiva de datos: En sistemas con grandes entidades y relaciones, puede ser costoso recuperar todos los datos relacionados.

* Complejidad de los DTOs: Proporciona una manera más sencilla de trabajar con estructuras personalizadas sin necesidad de escribir transformaciones manuales.

* Selección precisa de datos: Permite elegir campos específicos sin afectar la entidad original.

## ¿Cómo lo resuelve?
Spring Data Projections utiliza interfaces y clases para definir estructuras de datos personalizadas. Cuando realizas una consulta, Spring genera dinámicamente los resultados según la estructura especificada. Esto se logra usando **`selects` específicos** en las consultas generadas.

## Tipos de Proyecciones
1. **Proyecciones Cerradas**, Recuperan únicamente los campos explícitamente definidos en la interfaz de proyección.
```java
public interface EmployeeNameProjection {
    String getFirstName();
    String getLastName();
}
```
Consulta generada
```sql
SELECT first_name, last_name FROM employee;
```

2. **Proyecciones Abiertas**, Se utiliza un método **`SpEL` (Spring Expression Language)** para definir campos personalizados.
```java
public interface EmployeeProjection {
    String getFullName();
    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}

public interface EmployeeFullNameProjection {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeFullNameProjection> findByDepartment(String department);
}
```

3. **Clases DTO (proyecciones basadas en clases)**, Puedes usar clases concretas como proyección, pero requieren un constructor que coincida con los datos devueltos por la consulta.
```java
public class EmployeeDTO {
    private final String firstName;
    private final String lastName;

    public EmployeeDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
}
```
Repositorio
```java
@Query("SELECT new com.example.EmployeeDTO(e.firstName, e.lastName) FROM Employee e")
List<EmployeeDTO> findAllEmployees();
```