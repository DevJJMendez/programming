## Interceptors y Listeners
En Hibernate, Interceptors y Listeners son mecanismos que permiten personalizar el comportamiento del framework durante el ciclo de vida de las entidades. Ambos proporcionan maneras de intervenir en las operaciones de Hibernate para realizar tareas específicas, como la auditoría, la modificación de datos, o la implementación de lógica de negocio adicional. A continuación, exploraremos cada uno en detalle.

### Interceptors en Hibernate
Interceptors en Hibernate son una forma de interceptar y modificar el comportamiento de Hibernate en tiempo de ejecución. Puedes usar interceptores para realizar tareas como auditoría, logging, validación, y modificación de datos antes de que se persistan en la base de datos.

### ¿Qué es un Interceptor?
Un interceptor es una clase que implementa la interfaz `Interceptor` de Hibernate. Permite interceptar varias etapas del ciclo de vida de las entidades, desde su carga hasta su eliminación. Puedes sobrescribir métodos específicos para alterar el comportamiento de Hibernate según tus necesidades.

**Implementación de un Interceptor**
Para usar un interceptor, debes implementar la interfaz `Interceptor` y sobrescribir los métodos que necesites.

```java
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class CustomInterceptor extends EmptyInterceptor {

    @Override
    public void onDelete(Object object, Object id, Class<?> entityClass) {
        // Lógica personalizada cuando una entidad es eliminada
        System.out.println("Entidad eliminada: " + object);
    }

    @Override
    public void onFlushDirty(Object entity, Object id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        // Lógica personalizada cuando una entidad es modificada
        System.out.println("Entidad modificada: " + entity);
    }

    @Override
    public void onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
        // Lógica personalizada cuando una entidad es guardada
        System.out.println("Entidad guardada: " + entity);
    }
}
```
**Configuración del Interceptor**
Para aplicar un interceptor a tu sesión de Hibernate, debes configurarlo en el archivo de configuración `hibernate.cfg.xml` o a través de la configuración programática.

Ejemplo en `hibernate.cfg.xml`:
```xml
<hibernate-configuration>
    <!-- Otras configuraciones -->
    <property name="hibernate.ejb.interceptor">com.example.CustomInterceptor</property>
</hibernate-configuration>
```

**Configuración programática:**
```java
Configuration configuration = new Configuration();
configuration.setInterceptor(new CustomInterceptor());
SessionFactory sessionFactory = configuration.buildSessionFactory();
```

### Listeners en Hibernate
Listeners en Hibernate permiten escuchar y reaccionar a eventos específicos durante el ciclo de vida de las entidades. Hibernate proporciona varios tipos de listeners para diferentes tipos de eventos.

**Tipos de Listeners**
1. **Entity Listeners**:

   * Escuchan eventos relacionados con el ciclo de vida de una entidad, como la inserción, actualización y eliminación de entidades.

2. **Session Listeners**:

   * Escuchan eventos relacionados con el ciclo de vida de una sesión de Hibernate, como la apertura y cierre de sesiones.

**Implementación de Listeners**
Para implementar un listener de entidad, debes crear una clase que contenga métodos anotados con las anotaciones correspondientes, como `@PostPersist`, `@PreUpdate`, etc.

**Ejemplo**
```java
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

public class ProductListener {

    @PostPersist
    public void postPersist(Product product) {
        System.out.println("Producto guardado: " + product);
    }

    @PostUpdate
    public void postUpdate(Product product) {
        System.out.println("Producto actualizado: " + product);
    }

    @PostRemove
    public void postRemove(Product product) {
        System.out.println("Producto eliminado: " + product);
    }
}
```
**Configuración del Listener:**
Debes registrar el listener en la entidad utilizando la anotación `@EntityListeners`.
```java
import javax.persistence.EntityListeners;

@Entity
@EntityListeners(ProductListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Getters y Setters
}
```

### Diferencias entre Interceptors y Listeners
1. **Interceptors**:

   * Interceptan llamadas y operaciones en la sesión de Hibernate.

   * Pueden modificar los datos y el comportamiento de la sesión.
   
   * Se aplican globalmente a todas las sesiones de Hibernate.

2. **Listeners**:

   * Escuchan eventos específicos relacionados con las entidades o sesiones.

   * Permiten ejecutar lógica adicional cuando ocurren eventos como guardado, actualización o eliminación.

   * Se aplican a entidades específicas y no modifican el comportamiento global de la sesión.

### Casos de Uso Comunes
1. **Auditoría**:

   * Puedes usar interceptores o listeners para registrar cambios en las entidades y mantener un historial de modificaciones.

   * Validación:

       * Validar los datos antes de que sean persistidos en la base de datos.

   * Modificación de Datos:

     * Realizar ajustes en los datos antes de que sean guardados o después de que sean cargados.

   * Logging:

     * Registrar información sobre las operaciones realizadas en las entidades.
