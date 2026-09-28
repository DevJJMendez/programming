# Anotaciones de Configuración General
Estas anotaciones configuran el comportamiento general de la aplicación y su punto de inicio.

## `@SpringBootApplication`
Es una combinación de varias anotaciones y se utiliza para marcar la clase principal de una aplicación Spring Boot. Está compuesta por las siguientes anotaciones clave:

* `@SpringBootConfiguration`: Es una especialización de `@Configuration`, que indica que la clase anotada es una clase de configuración de Spring. Permite definir beans mediante métodos anotados con `@Bean`.

* `@EnableAutoConfiguration`: Esta anotación le dice a Spring Boot que comience a agregar **beans** basados en configuraciones que detecta en el **classpath**. Intenta configurar automáticamente tu aplicación en función de las dependencias que hayas incluido. Por ejemplo, si tienes una base de datos H2 en el classpath, intentará configurar una base de datos en memoria automáticamente.

* `@ComponentScan`: Esta anotación le dice a Spring que busque otros componentes, configuraciones y servicios en el paquete actual y sus subpaquetes. Esto permite encontrar **controladores**, **servicios** y **otros componentes** anotados con `@Component`, `@Service`, `@Repository`, etc.

* `@Bean`: Define un **Bean** en el contexto de la aplicación, permitiendo que Spring gestione la instancia de la clase especificada.

**Ejemplo**
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```
**En este ejemplo:**
* `@SpringBootApplication` se coloca en la clase principal de la aplicación.

* `SpringApplication.run(MySpringBootApplication.class, args)` se utiliza para iniciar la aplicación Spring Boot.

**Beneficios**
1. **Conveniencia**: Al combinar varias anotaciones en una sola, reduce la cantidad de anotaciones necesarias en la clase principal de tu aplicación.

2. **Configuración Automática**: Facilita la configuración de la aplicación al proporcionar configuraciones predeterminadas basadas en las dependencias presentes en el classpath.

3. **Escaneo de Componentes**: Simplifica la detección de beans y otros componentes en tu aplicación sin necesidad de especificar explícitamente los paquetes a escanear.

## `@Configuration`
se utiliza en Spring para indicar que una clase define uno o más métodos `@Bean`. Estas clases se utilizan como configuraciones fuente para el contenedor de Spring.

**Características Clave**
1. **Declaración de Beans**: Una clase anotada con @Configuration puede declarar uno o más métodos @Bean, que se encargarán de crear y configurar instancias de objetos gestionados por el contenedor de Spring.

2. **Equivalente a XML**: Las clases `@Configuration` son el equivalente en Java a los archivos de configuración XML tradicionales de Spring.

3. **Singleton por Defecto**: Los beans definidos en una clase @Configuration son singleton por defecto, lo que significa que se crea una sola instancia de cada bean y se reutiliza a lo largo del contenedor de Spring.

**Ejemplo**
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

* Los métodos `myService` y `myRepository` están anotados con `@Bean`, lo que indica que devuelven objetos que deben ser gestionados por el contenedor de Spring como beans.

**Beneficios**
1. **Configuración Tipada**: Al usar Java para configurar beans, se obtiene la verificación de tipos en tiempo de compilación y soporte completo del IDE, lo que puede ayudar a detectar errores de configuración más fácilmente que con configuraciones basadas en XML.

2. **Refactorización más Sencilla**: Las configuraciones basadas en Java son más fáciles de refactorizar que las basadas en XML, ya que se benefician de las capacidades del lenguaje y las herramientas de desarrollo.

3. **Modularidad**: Puedes dividir la configuración en múltiples clases de configuración para una mejor modularización y organización del código.

**Integración con otras Anotaciones** 
* `@ComponentScan`: Puedes combinar `@Configuration` con `@ComponentScan` para especificar paquetes a escanear en busca de otros **componentes**, **servicios** y **beans**.
    ```java
    @Configuration
    @ComponentScan(basePackages = "com.example.myapp")
    public class AppConfig {
        // ...
    }
    ```

* `@Import`: Si tienes múltiples clases de configuración, puedes importar una en otra usando `@Import`.
    ```java
    @Configuration
    @Import(AnotherConfig.class)
    public class AppConfig {
        // ...
    }
    ```

* `@PropertySource`: Para cargar propiedades desde un archivo de propiedades.
    ```java
    @Configuration
    @PropertySource("classpath:application.properties")
    public class AppConfig {
        // ...
    }
    ```

**Buenas Prácticas**
* **Mantén la Configuración Simple**: Evita poner lógica de negocio en las clases de configuración. Su propósito principal debe ser la definición de beans y la configuración del contenedor de Spring.

* **Usa Perfiles**: Utiliza perfiles (`@Profile`) para definir diferentes configuraciones para distintos entornos (**desarrollo**, **test**, **producción**).
1. **Conveniencia**: Al combinar varias anotaciones en una sola, reduce la cantidad de anotaciones necesarias en la clase principal de tu aplicación.

2. **Configuración Automática**: Facilita la configuración de la aplicación al proporcionar configuraciones predeterminadas basadas en las dependencias presentes en el classpath.

3. **Escaneo de Componentes**: Simplifica la detección de beans y otros componentes en tu aplicación sin necesidad de especificar explícitamente los paquetes a escanear.

**Personalización**

Puedes personalizar el comportamiento de `@SpringBootApplication` si es necesario. Por ejemplo, si deseas excluir ciertas configuraciones automáticas, puedes usar:

```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MySpringBootApplication {
    // ...
}
```
Esto excluye la configuración automática del `datasource`.

## `@Profile`
se utiliza para activar **Beans** en función del perfil activo del entorno. Esto es muy útil cuando necesitas definir diferentes configuraciones o **Beans** para distintos entornos, como desarrollo, pruebas y producción.

**Características Clave**
1. **Condicionalidad**: Permite activar o desactivar **Beans** y configuraciones en función del perfil activo.

2. **Facilita la Configuración para Múltiples Entornos**: Puedes tener diferentes configuraciones para **desarrollo**, **pruebas**, **producción**, etc.

3. **Aplicación en Clases y Métodos**: Se puede aplicar tanto a clases como a métodos que definan **Beans**.

**Ejemplo de Uso**

* **Configuración de Perfiles** Primero, necesitas definir los perfiles en tu configuración. Puedes hacerlo en el archivo `application.properties` o a través de variables de entorno.

`application.properties`
```java
spring.profiles.active=dev
```
**Variables de Entorno**
```bash
export SPRING_PROFILES_ACTIVE=dev
```
* Puedes usar `@Profile` en clases para condicionar la creación de todos los beans dentro de esa clase.
```java
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevService implements MyService {
    @Override
    public void performService() {
        System.out.println("Running in Development Mode");
    }
}
```
```java
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdService implements MyService {
    @Override
    public void performService() {
        System.out.println("Running in Production Mode");
    }
}
```
**Uso de `@Profile` en Métodos**: También puedes usar @Profile en métodos dentro de una clase de configuración.
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public MyService devService() {
        return new DevService();
    }

    @Bean
    @Profile("prod")
    public MyService prodService() {
        return new ProdService();
    }
}
```
**Activación de Múltiples Perfiles**: Puedes activar múltiples perfiles separándolos con comas.
```java
spring.profiles.active=dev,logging
```
Uso de `@Profile` con Múltiples Perfiles: Puedes especificar múltiples perfiles en `@Profile`.
```java
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "test"})
public class DevTestService implements MyService {
    @Override
    public void performService() {
        System.out.println("Running in Development or Test Mode");
    }
}
```
**Perfiles Negativos**: Puedes excluir un bean de ciertos perfiles usando `!`.
```java
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class NonProdService implements MyService {
    @Override
    public void performService() {
        System.out.println("Running in Non-Production Mode");
    }
}
```

## `@Aspect`
Se utiliza para marcar una clase como un aspecto. Un aspecto es un módulo que encapsula una preocupación transversal (como el logging, la gestión de transacciones, la seguridad, etc.) que afecta a múltiples puntos en una aplicación.

**Funciones y Uso de la Anotación `@Aspect`**
1. **Definición del Aspecto**:

   * La anotación `@Aspect` se aplica a una clase para definirla como un aspecto en Spring **AOP**.

   * Los métodos dentro de esta clase que contienen lógica transversal están anotados con anotaciones como `@Before`, `@After`, `@Around`, etc.

2. **Component Scanning**:

   * La clase anotada con `@Aspect` también debe estar registrada como un **Bean** de Spring. Esto se puede hacer mediante la anotación `@Component` o declarando el bean explícitamente en la configuración.

**Ejemplo Práctico de Uso de `@Aspec`t**
* **Paso 1: Configuración de las Dependencias en `pom.xml`**

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
    ```
* **Paso 2: Definir el Aspecto con `@Aspect` y `@Component`**

    ```java
    package com.example.aspect;

    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;
    import org.springframework.stereotype.Component;

    @Aspect
    @Component
    public class LoggingAspect {

        @Before("execution(* com.example.service.*.*(..))")
        public void logBeforeMethod() {
            System.out.println("Method execution started");
        }
    }
    ```
**En este ejemplo**:

    * `@Aspect` marca la clase LoggingAspect como un aspecto.

    * `@Before` define un **advice** que se ejecuta antes de cualquier método en el paquete `com.example.service`.

* **Paso 3: Crear un Servicio para Demostrar el Aspecto**

    ```java
    package com.example.service;

    import org.springframework.stereotype.Service;

    @Service
    public class UserService {

        public void createUser() {
            System.out.println("Creating a new user");
        }
    }
    ```
* **Paso 4: Configuración de la Aplicación Spring Boot**

```java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }
}
```

* **Paso 5: Ejecución de la Aplicación**

```java
package com.example;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.createUser();
    }
}
```