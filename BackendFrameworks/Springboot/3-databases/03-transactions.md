# Transacciones
Las transacciones son un concepto fundamental en Hibernate, ya que garantizan que un conjunto de operaciones sobre la base de datos se realicen de manera atómica, consistente, aislada y duradera (propiedades **ACID**). En el contexto de Hibernate, una transacción agrupa múltiples operaciones en una única unidad de trabajo, asegurando que todas se completen correctamente o, en caso de fallo, ninguna se aplique.

## Características de las Transacciones en Hibernate
1. **Atomicidad**: Todas las operaciones dentro de una transacción deben completarse con éxito; de lo contrario, la transacción no se confirma, y todos los cambios realizados durante la transacción se revierten.

2. **Consistencia**: Una transacción debe llevar la base de datos de un estado consistente a otro estado consistente. Esto implica que las reglas de integridad de la base de datos no se deben violar.

3. **Aislamiento**: Las transacciones concurrentes deben estar aisladas entre sí, lo que significa que una transacción en curso no debe afectar a otra transacción.

4. **Durabilidad**: Una vez que una transacción se confirma (commit), sus cambios se hacen permanentes, incluso si ocurre un fallo del sistema inmediatamente después.

## Transacciones en Hibernate
En Hibernate, las transacciones se manejan a través de la API de transacciones proporcionada por el framework. Hibernate puede gestionar las transacciones de dos maneras principales: transacciones manejadas por el propio Hibernate (a través de la Session) y transacciones gestionadas por el contenedor en entornos como JEE (a través de JTA, Java Transaction API).

**Transacciones manejadas por Hibernate**

Este es el caso más común en aplicaciones standalone o aplicaciones que no utilizan un contenedor de aplicaciones.

**Iniciar y manejar una transacción**

Para iniciar una transacción en Hibernate, se sigue normalmente el siguiente patrón:

1. **Iniciar una Session**: Se abre una Session desde la `SessionFactory`.

2. **Iniciar una transacción**: Se crea una instancia de Transaction llamando al método `beginTransaction()`.

3. **Realizar operaciones de persistencia**: Se realizan las operaciones CRUD (Create, Read, Update, Delete) necesarias.

4. **Confirmar la transacción:** Si todas las operaciones se realizan correctamente, se confirma la transacción con `commit()`.

5. **Manejar excepciones y reversiones**: En caso de error, se revierte la transacción con `rollback()`.

6. **Cerrar la Session**: Finalmente, se cierra la Session para liberar recursos.

**Ejemplo**
```java
Session session = null;
Transaction transaction = null;

try {
    session = sessionFactory.openSession(); // 1. Abrir sesión
    transaction = session.beginTransaction(); // 2. Iniciar transacción

    Empleado empleado = new Empleado("Juan", 45000.0);
    session.save(empleado); // 3. Operaciones de persistencia

    transaction.commit(); // 4. Confirmar transacción
} catch (Exception e) {
    if (transaction != null) {
        transaction.rollback(); // 5. Revertir transacción en caso de error
    }
    e.printStackTrace();
} finally {
    if (session != null) {
        session.close(); // 6. Cerrar la sesión
    }
}
```

## Transacciones Declarativas (Spring)
En aplicaciones basadas en Spring, el manejo de transacciones se simplifica mediante anotaciones y la configuración declarativa. Spring Framework permite gestionar transacciones de manera automática mediante la anotación `@Transactional`.

```java
@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional
    public void crearEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
        // Todas las operaciones aquí dentro estarán bajo la misma transacción
    }
}
```

## Manejo de Transacciones en Ambientes JEE
En ambientes JEE, las transacciones se gestionan generalmente a través de JTA (Java Transaction API), lo que permite manejar transacciones distribuidas y gestionadas por el contenedor de aplicaciones. En este contexto, Hibernate se integra con JTA para manejar transacciones que pueden involucrar múltiples recursos, como bases de datos y sistemas de mensajería.

## Propagación de Transacciones
Cuando se trabaja con transacciones, es importante entender cómo se propagan entre diferentes métodos y clases:

1. **REQUIRED**: Si una transacción existe, se une a ella; de lo contrario, inicia una nueva. Este es el comportamiento predeterminado.

2. **REQUIRES_NEW**: Siempre inicia una nueva transacción, suspendiendo cualquier transacción existente.

3. **MANDATORY**: Requiere que ya exista una transacción; si no hay ninguna, lanza una excepción.

4. **SUPPORTS**: Si una transacción existe, se une a ella; si no, continúa sin una transacción.

5. **NOT_SUPPORTED**: Ejecuta el método sin una transacción, suspendiendo cualquier transacción existente.

6. **NEVER**: Lanza una excepción si hay una transacción en curso.

7. **NESTED**: Ejecuta el método dentro de una transacción anidada si una transacción ya existe.

## Transacciones y Concurrencia
Hibernate también permite gestionar diferentes niveles de aislamiento para manejar problemas de concurrencia, como las lecturas sucias, lecturas no repetibles y las escrituras fantasma:

* **READ_UNCOMMITTED**: Permite lecturas de datos no confirmados (lecturas sucias).

* **READ_COMMITTED**: Solo permite leer datos confirmados.

* **REPEATABLE_READ**: Garantiza que los datos leídos no cambiarán dentro de la transacción.

* **SERIALIZABLE**: El nivel más alto de aislamiento, previene todas las formas de concurrencia.

## `Transaction`
La clase Transaction se utiliza para demarcar el inicio y el final de una transacción. Esta clase permite controlar la transacción, es decir, definir cuándo comienza, se confirma (**commit**) o se revierte (**rollback**) una transacción.

* Funcionalidades Clave de Transaction:

  * `beginTransaction()`: Inicia una nueva transacción.

  * `commit()`: Confirma todas las operaciones realizadas en la transacción actual.

  * `rollback()`: Revierte todas las operaciones realizadas en la transacción actual si ocurre algún error.

* **Patrones de Uso**:

  * **Transacción Controlada por Aplicación**: Es el patrón más común en aplicaciones standalone, donde se controla explícitamente el inicio y final de la transacción.

  * **Transacción Declarativa**: Común en aplicaciones Spring, donde las transacciones se gestionan mediante anotaciones como `@Transactional`.

**Ejemplo**
```java
Session session = sessionFactory.openSession(); // 1. Abrir sesión
Transaction transaction = null;

try {
    transaction = session.beginTransaction(); // 2. Iniciar transacción

    Empleado empleado = new Empleado("Ana", 50000.0);
    session.save(empleado); // 3. Persistir entidad

    transaction.commit(); // 4. Confirmar la transacción
} catch (Exception e) {
    if (transaction != null) {
        transaction.rollback(); // 5. Revertir la transacción en caso de error
    }
    e.printStackTrace();
} finally {
    session.close(); // 6. Cerrar la sesión
}
```

## Transacciones Declarativas
Las transacciones declarativas son un enfoque común en aplicaciones Java, especialmente cuando se utiliza el framework Spring, para manejar transacciones sin necesidad de escribir explícitamente el código para iniciar, confirmar o revertir transacciones. En lugar de manejar las transacciones de forma programática (con código explícito), se utilizan anotaciones o configuraciones declarativas para que el contenedor o el framework gestione las transacciones de manera automática.

## Ventajas de las Transacciones Declarativas
1. **Simplicidad**: Reducen la complejidad del código, ya que eliminan la necesidad de manejar transacciones explícitamente en el código de la aplicación.

2. **Mantenibilidad**: Las transacciones declarativas mejoran la mantenibilidad del código, ya que separan las preocupaciones de la lógica de negocio y el manejo de transacciones.

3. **Flexibilidad**: Permiten cambiar la gestión de transacciones sin modificar la lógica de negocio. Solo es necesario ajustar la configuración o las anotaciones.

4. **Integración con Spring**: Spring ofrece un soporte robusto para transacciones declarativas a través de la anotación `@Transactional` y la configuración a nivel de XML o Java.

### Anotación `@Transactional`
La anotación `@Transactional` es la forma más común de manejar transacciones declarativas en Spring. Al aplicarla a una clase o método, Spring automáticamente se encarga de iniciar, confirmar o revertir la transacción según sea necesario.

**Ejemplo**
```java
@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional
    public void crearEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
        // Todas las operaciones aquí dentro están bajo la misma transacción
    }
}
```

## Uso de @Transactional en Diferentes Niveles
1. **A nivel de método**: Se aplica la anotación directamente sobre un método, indicando que dicho método debe ejecutarse dentro de una transacción.

    ```java
    @Transactional
    public void actualizarEmpleado(Empleado empleado) {
        // Lógica de negocio que se ejecuta dentro de una transacción
    }
    ```

2. **A nivel de clase**: Al aplicar `@Transactional` a nivel de clase, todos los métodos de la clase se ejecutan dentro de una transacción.

    ```java
    @Service
    @Transactional
    public class EmpleadoService {
        // Todos los métodos aquí dentro serán transaccionales
    }
    ```

## Atributos Comunes de @Transactional
La anotación `@Transactional` tiene varios atributos que permiten personalizar el comportamiento de la transacción:

1. **propagation**: Define cómo se debe propagar la transacción actual a los métodos llamados dentro de la misma transacción. Las opciones más comunes son:

   * **REQUIRED**: Es el valor por defecto. Usa la transacción actual si existe, o inicia una nueva si no hay ninguna.

   * **REQUIRES_NEW**: Siempre inicia una nueva transacción, suspendiendo la existente.

   * **MANDATORY**: Exige que ya exista una transacción; si no, lanza una excepción.

   * **SUPPORTS**: Usa la transacción actual si existe, o ejecuta sin transacción si no hay ninguna.

   * **NOT_SUPPORTED**: Ejecuta sin transacción, suspendiendo cualquier transacción actual.

   * **NEVER**: Lanza una excepción si hay una transacción activa.

   * **NESTED**: Ejecuta el método dentro de una transacción anidada si ya existe una transacción.

2. **isolation**: Define el nivel de aislamiento de la transacción, que afecta a cómo las operaciones concurrentes son vistas y manejadas:

   * **DEFAULT**: Usa el nivel de aislamiento predeterminado de la base de datos.

   * **READ_UNCOMMITTED**: Permite leer datos no confirmados (lecturas sucias).

   * **READ_COMMITTED**: Permite leer solo datos confirmados.

   * **REPEATABLE_READ**: Garantiza que los datos leídos no cambiarán dentro de la transacción.

   * **SERIALIZABLE**: Nivel de aislamiento más alto, previene todas las formas de problemas de concurrencia.

3. **timeout**: Especifica el tiempo máximo (en segundos) que la transacción debe durar antes de ser abortada automáticamente.

    ```java
    @Transactional(timeout = 5) // Abortar si la transacción toma más de 5 segundos
    ```

4. **readOnly**: Indica si la transacción es solo de lectura, optimizando las operaciones para escenarios en los que no se requiere modificación de datos.

    ```java
    @Transactional(readOnly = true)
    public List<Empleado> obtenerTodosLosEmpleados() {
        // Operación de solo lectura
    }
    ```

5. **rollbackFor**: Especifica las excepciones para las cuales la transacción debe ser revertida.

    ```java
    @Transactional(rollbackFor = Exception.class)
    public void realizarOperacion() throws Exception {
        // Si ocurre cualquier excepción, se revierte la transacción
    }
    ```

6. **noRollbackFor**: Especifica las excepciones para las cuales la transacción no debe ser revertida.

    ```java
    @Transactional(noRollbackFor = {SomeSpecificException.class})
    public void realizarOperacion() {
        // No se revierte la transacción si ocurre SomeSpecificException
    }
    ```

## Configuración de Transacciones Declarativas
Además de la anotación @Transactional, las transacciones declarativas se pueden configurar a través de XML o archivos de configuración Java en Spring.

* **Configuración en XML**:

    ```xml
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="*" propagation="REQUIRED"/>
            <tx:method name="get*" readOnly="true"/>
            <tx:method name="find*" readOnly="true"/>
        </tx:attributes>
    </tx:advice>

    <aop:config>
        <aop:pointcut id="servicePointcut" expression="execution(* com.miapp.service.*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="servicePointcut"/>
    </aop:config>
    ```

* **Configuración en Java**:

    ```java
    @Configuration
    @EnableTransactionManagement
    public class TransactionConfig {

        @Bean
        public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
            return new JpaTransactionManager(emf);
        }
    }
    ```