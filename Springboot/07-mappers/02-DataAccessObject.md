# Data Access Object
El patrón Data Access Object (DAO) es un patrón de diseño estructural que proporciona una abstracción para acceder a una base de datos u otro sistema de almacenamiento. La idea principal es encapsular las operaciones de acceso a datos, como consultas, inserciones, actualizaciones y eliminaciones, en una capa independiente del resto de la aplicación.

## ¿Para qué sirve el patrón DAO?
El DAO sirve para:

* **Centralizar el acceso a los datos**: Todo el código relacionado con la interacción con la base de datos queda en un único lugar.

* **Separar responsabilidades**: Permite que la lógica de negocio no dependa directamente de la capa de persistencia.

* **Facilitar cambios en la base de datos**: Si el esquema o el sistema de almacenamiento cambia, solo es necesario modificar los DAOs.

* **Promover reutilización**: Las operaciones comunes sobre las entidades (por ejemplo, CRUD) pueden ser reutilizadas.

## Características del patrón DAO
* **Encapsulamiento**: Las operaciones relacionadas con la base de datos están aisladas en una clase específica.

* **Abstracción**: Oculta los detalles de implementación del acceso a datos a las capas superiores.

* **Independencia**: Cambiar el backend de datos no afecta al resto de la aplicación siempre que el DAO mantenga su contrato (interfaz pública).

* **Interfaz definida**: Generalmente se definen métodos claros y específicos para cada operación necesaria (por ejemplo, `findById`, `save`, `delete`).

* **Modularidad**: Ayuda a mantener un código más modular y fácil de entender.

## ¿Qué problema resuelve el patrón DAO?
El patrón DAO resuelve los siguientes problemas comunes:

* **Acoplamiento entre lógica de negocio y persistencia**: Sin DAO, la lógica de negocio estaría entremezclada con consultas a la base de datos, dificultando el mantenimiento y las pruebas.

* **Dificultad para realizar cambios en la capa de persistencia**: Si se cambia el motor de base de datos o la tecnología de persistencia, sería necesario modificar la lógica en múltiples lugares del código.

* **Falta de claridad y reutilización**: Las operaciones de acceso a datos suelen ser repetitivas y difíciles de mantener si no están centralizadas.

## ¿Cómo resuelve estos problemas?
* **Separando la lógica de negocio de la persistencia**: El DAO actúa como una capa intermediaria entre la lógica de negocio y la base de datos.

* **Abstrayendo los detalles técnicos de la persistencia**: Oculta detalles como las consultas SQL o las configuraciones específicas de un ORM.

* **Proporcionando una interfaz uniforme**: Facilita que las capas superiores interactúen con los datos sin preocuparse por cómo están almacenados.

## Estructura general del DAO
### **Interfaz del DAO**
   * Define el contrato para las operaciones de acceso a datos.
   
   * Contiene métodos abstractos que describen las acciones que se pueden realizar con la entidad específica.
   
   * Garantiza la flexibilidad al permitir diferentes implementaciones del acceso a datos (por ejemplo, utilizando diferentes ORMs o bases de datos).
```java
public interface EmployeeDao {
    Employee findById(Long id);
    List<Employee> findAll();
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(Long id);
}
```
* **Proposito**:
  * Facilita el desacoplamiento entre la lógica de negocio y la implementación concreta del acceso a datos.

  * Hace que las pruebas sean más sencillas al permitir el uso de mocks o stubs.

###  **Implementación del DAO**
   * Implementa la lógica específica para interactuar con la base de datos u otro sistema de almacenamiento.
   
   * Contiene los detalles técnicos del acceso a datos, como consultas SQL o uso de APIs de ORM como JPA.
   
   * Sigue los métodos definidos en la interfaz.
```java
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}
```
* **Propósito**:
  * Centraliza y encapsula el acceso a datos.

  * Oculta los detalles de implementación para las capas superiores.

### **Cliente del DAO (por lo general, un servicio)**

```java
@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee getEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public void createEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    public void deleteEmployee(Long id) {
        employeeDao.deleteById(id);
    }
}
```

## Ventajas del patrón DAO
* **Reducción del acoplamiento**: Las capas superiores no dependen de los detalles de la base de datos.

* **Reutilización**: Las operaciones comunes pueden ser reutilizadas en diferentes partes de la aplicación.

* **Facilidad de pruebas**: Al ser una capa independiente, puedes probarla con mocks o bases de datos en memoria.

* **Mantenibilidad**: Los cambios en la lógica de acceso a datos no afectan a la lógica de negocio.

## Desventajas del patrón DAO
* **Código repetitivo**: Sin un **ORM**, puedes terminar escribiendo mucho código similar (como consultas SQL manuales).

* **Sobrecarga adicional**: Puede parecer un paso adicional si la aplicación es pequeña.

* **No escala bien para arquitecturas modernas**: En arquitecturas como **Microservicios** o **Hexagonal Architecture**, los DAOs se complementan con otras capas como **Repositorios**.