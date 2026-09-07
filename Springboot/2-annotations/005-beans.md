# `@Bean`
se utiliza para indicar que un método produce un **bean** que debe ser gestionado por el contenedor de Spring. Los métodos anotados con `@Bean` se suelen definir dentro de una clase de configuración (`@Configuration`).

**Características Clave**

1. **Definición de Beans**: Un método anotado con @Bean define un bean, y el retorno de este método se registra como un bean en el contexto de la aplicación Spring.

2. **Singleton por Defecto**: Por defecto, los beans son singleton, lo que significa que el contenedor de Spring crea una única instancia del bean y la reutiliza.

3. **Configuración de Dependencias**: Los métodos @Bean pueden tener argumentos que serán satisfechos automáticamente por el contenedor de Spring, permitiendo inyectar dependencias en el bean.

**Ejemplo de Uso**
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public MyRepository myRepository() {
        return new MyRepositoryImpl();
    }
}
```
**En este ejemplo:**

* La clase `AppConfig` está anotada con `@Configuration`, indicando que es una clase de configuración.

* Los métodos `myService` y `myRepository` están anotados con `@Bean`, lo que indica que devuelven objetos que deben ser gestionados por el contenedor de Spring como **beans**.

## Inyección de Dependencias

Los métodos `@Bean` pueden tener parámetros que serán inyectados por Spring. Esto se llama **`method injection`**.

```java
@Bean
public MyService myService(MyRepository myRepository) {
    return new MyServiceImpl(myRepository);
}
```
En este caso, `myRepository` se inyecta automáticamente en el método `myService` porque Spring sabe cómo gestionar `MyRepository` y proporcionar una instancia de este **bean**.

## Inicialización y Destrucción

Puedes especificar métodos de inicialización y destrucción para los beans.
```java
@Bean(name="service", initMethod = "init", destroyMethod = "cleanup")
public MyService myService() {
    return new MyServiceImpl();
}
```

## `@Autowired`
se utiliza para realizar inyección de dependencias automática en Spring. Permite inyectar **Beans** en otros **Beans**, eliminando la necesidad de configuraciones manuales.

**Características Clave**
* **Inyección Automática**: Permite la inyección automática de **Beans** sin necesidad de configuraciones explícitas.

* **Por Tipo**: La inyección se realiza por tipo (`type`).

* **Opcionalidad**: Puedes especificar que una dependencia es opcional usando `required = false`.

**Ejemplo de Uso**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Autowired
    private MyRepository myRepository;

    // Métodos de negocio

    public void performService() {
        myRepository.doSomething();
    }
}
```
En este ejemplo:
* La anotación `@Autowired` en el campo `myRepository` le dice a Spring que inyecte automáticamente una instancia de `MyRepository` en `MyService`.

**Inyección por Constructor y Setter**

Además de la inyección en campos, `@Autowired` puede utilizarse en constructores y métodos setter.

**Inyección por Constructor**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    // Métodos de negocio
}
```
**Inyección por Setter**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    private MyRepository myRepository;

    @Autowired
    public void setMyRepository(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    // Métodos de negocio
}
```
**Inyección Opcional**

Puedes hacer que la inyección sea opcional usando `required = false` en `@Autowired`.
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Autowired(required = false)
    private MyRepository myRepository;

    // Métodos de negocio
}
```

## `@Qualifier`
se utiliza para especificar el **Bean** exacto que debe inyectarse cuando hay más de un **Bean** del mismo tipo disponible en el contexto de Spring. Ayuda a evitar conflictos al indicar explícitamente cuál bean debe ser utilizado.

**Características Clave**
* **Desambiguación**: Se utiliza para desambiguar la inyección de dependencias cuando existen múltiples **Beans** del mismo tipo.

* **Uso en Conjunción con `@Autowired`**: Generalmente se usa junto con `@Autowired` para especificar el **Bean** a inyectar.

**Ejemplo**, Supongamos que tienes dos implementaciones de una interfaz `Service`.
```java
import org.springframework.stereotype.Component;

@Component
public class ServiceA implements Service {
    // Implementación de ServiceA
}

@Component
public class ServiceB implements Service {
    // Implementación de ServiceB
}
```
Puedes usar `@Qualifier` para especificar cuál implementación debe inyectarse.
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private final Service service;

    @Autowired
    public MyBean(@Qualifier("serviceA") Service service) {
        this.service = service;
    }

    // Métodos de negocio
}
```
**En este ejemplo:**
* `@Qualifier("serviceA")` especifica que se debe inyectar la implementación `ServiceA`.

* Especificamos el **Bean ID**, este debe ser igual al nombre del **Bean** pero en **lowerCase**.

## `@Primary`
se utiliza para indicar que un **Bean** es la opción predeterminada cuando hay múltiples candidatos para la inyección. Si no se especifica un `@Qualifier`, Spring inyectará el bean marcado con `@Primary`.

**Características Clave**
* **Bean Predeterminado**: Define un **Bean** como la opción predeterminada entre múltiples beans del mismo tipo.

* **Uso Global**: A diferencia de `@Qualifier`, que se usa en el punto de inyección, `@Primary` se declara en la definición del **Bean**.

**Ejemplo de Uso**
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    public Service serviceA() {
        return new ServiceA();
    }

    @Bean
    @Primary
    public Service serviceB() {
        return new ServiceB();
    }
}
```
**En este ejemplo:**

* `serviceB` está marcado con `@Primary`, por lo que será la implementación predeterminada de `Service` inyectada si no se especifica un `@Qualifier`.

**Combinación de `@Qualifier` y `@Primary`**

Puedes usar `@Primary` para definir un bean predeterminado y `@Qualifier` para situaciones específicas donde necesitas una implementación diferente.
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private final Service defaultService;
    private final Service specificService;

    @Autowired
    public MyBean(Service defaultService, @Qualifier("serviceA") Service specificService) {
        this.defaultService = defaultService;
        this.specificService = specificService;
    }

    // Métodos de negocio
}
```
**En este ejemplo:**

* `defaultService` se inyecta con el bean marcado con `@Primary (serviceB)`.

* `specificService` se inyecta con el bean especificado por `@Qualifier (serviceA)`

## `@Required`
se utiliza para asegurar que una propiedad del **Bean** haya sido configurada mediante la inyección de dependencias. Se aplica a los métodos `setter` de los **Beans**.

**Características Clave**
* **Validación de Propiedades**: Asegura que una propiedad debe ser inyectada antes de que el **Bean** se utilice.

* **Métodos Setter**: Solo se puede aplicar a métodos `setter`.

* **Deprecated**: La anotación `@Required` está marcada como **@Deprecated** a partir de **Spring 5** y no se recomienda para uso en nuevas aplicaciones. En lugar de `@Required`, se recomienda usar la validación de constructor o las anotaciones `@NotNull` de JSR-303 para la validación de propiedades requeridas.

**Ejemplo de Uso**
```java
import org.springframework.beans.factory.annotation.Required;

public class MyBean {

    private String myProperty;

    @Required
    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    public String getMyProperty() {
        return myProperty;
    }
}
```
**En este ejemplo:**

* El método `setMyProperty` está marcado con `@Required`, lo que significa que `myProperty` debe ser inyectado.

* Si `myProperty` no se establece, Spring lanzará una `BeanInitializationException` durante la inicialización del contenedor.

**Configuración de Bean**

Puedes configurar el bean y su propiedad requerida en un archivo de configuración XML o mediante anotaciones en una clase de configuración.

**Configuración `XML`**
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="com.example.MyBean">
        <property name="myProperty" value="Some Value"/>
    </bean>

</beans>
```
**Configuración con Anotaciones**
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setMyProperty("Some Value");
        return myBean;
    }
}
```