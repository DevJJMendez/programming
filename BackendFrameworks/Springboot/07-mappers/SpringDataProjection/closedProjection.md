# Proyección Cerrada / Proyección de Interfaz Cerrada
Las proyecciones cerradas son un tipo de proyección en Spring Data JPA donde se definen interfaces específicas que contienen **únicamente los campos requeridos de una entidad**. Estas proyecciones generan automáticamente los resultados en función de la estructura de la interfaz, seleccionando únicamente los datos explícitamente definidos en ella.

## ¿Para qué sirven?
* Seleccionar datos específicos: Permiten recuperar únicamente los atributos de interés desde la base de datos, ignorando los campos no necesarios.

* Optimización de consultas: Reducen la cantidad de datos transferidos entre la base de datos y la aplicación, lo que mejora el rendimiento, especialmente para grandes conjuntos de datos.

* Desacoplamiento: Proporcionan una forma de representar los datos de manera personalizada sin exponer directamente la estructura de las entidades subyacentes.

## ¿Qué resuelven?
* Carga innecesaria de datos: Evitan recuperar campos o relaciones no requeridas, lo que puede ser costoso en términos de memoria y procesamiento.

* Acoplamiento excesivo: Al usar proyecciones cerradas, puedes evitar exponer directamente las entidades en la capa de presentación o API, protegiendo la lógica interna de tu aplicación.

* Consultas no óptimas: Generan consultas SQL que seleccionan únicamente los campos definidos en la proyección, optimizando el rendimiento.

## ¿Cómo se implementan?
1. **Crear una entidad**, Define una entidad que represente la estructura de los datos almacenados en la base de datos.
```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String department;

    // Getters y setters
}
```

2. **Definir una interfaz para la proyección**, Crea una interfaz que contenga los métodos necesarios para acceder a los campos específicos de la entidad. Los nombres de los métodos deben coincidir con los nombres de los atributos en la entidad.
```java
public interface EmployeeNameProjection {
    String getFirstName();
    String getLastName();
}
```

3. **Implementar el repositorio**, Define un método en el repositorio que utilice la proyección cerrada. Spring Data generará automáticamente la consulta para recuperar únicamente los campos definidos en la interfaz.
```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeNameProjection> findByDepartment(String department);
}
```

4. **Usar la proyección en el código**, Puedes utilizar el método del repositorio para obtener los datos según la proyección.
```java
@Autowired
private EmployeeRepository employeeRepository;

public void printEmployeeNames() {
    List<EmployeeNameProjection> employees = employeeRepository.findByDepartment("HR");
    employees.forEach(employee -> 
        System.out.println(employee.getFirstName() + " " + employee.getLastName())
    );
}
```

**SQL Generado**, Cuando usas proyecciones cerradas, Spring Data JPA genera automáticamente una consulta optimizada que incluye solo los campos definidos en la interfaz. Por ejemplo:

```sql
SELECT e.first_name, e.last_name 
FROM employee e 
WHERE e.department = 'HR';
```
Esto garantiza que la base de datos no transfiera datos innecesarios, optimizando el rendimiento.