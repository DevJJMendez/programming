# `@PropertySource`
se utiliza para cargar propiedades desde un archivo de propiedades en el contexto de la aplicación Spring. Es particularmente útil para gestionar configuraciones externas que pueden cambiar entre diferentes entornos (**desarrollo**, **test**, **producción**).

**Características Clave**
* **Carga de Propiedades**: Permite cargar un archivo de propiedades y agregar sus valores al entorno de Spring (**Environment**).

* **Configuración Externa**: Facilita la configuración de la aplicación desde archivos externos, manteniendo el código más limpio y flexible.

* **Soporte para Múltiples Archivos**: Puedes usar varias instancias de @PropertySource para cargar múltiples archivos de propiedades.

**Ejemplo de Uso**
* **Archivo de Propiedades** Primero, crea un archivo de propiedades. Por ejemplo, `application.properties`:
```java
app.name=MyApp
app.version=1.0.0
```
* **Clase de Configuración**: Luego, usa `@PropertySource` en una clase de configuración para cargar este archivo de propiedades.
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    // Getters y métodos de configuración

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }
}
```
**En este ejemplo:**
* La anotación `@PropertySource("classpath:application.properties")` carga el archivo de propiedades `application.properties` desde el `classpath`.

* Las propiedades se inyectan en los campos `appName` y `appVersion` usando la anotación `@Value`.

# Acceso a las Propiedades
Puedes acceder a las propiedades cargadas en tus beans mediante la anotación `@Value` o a través del objeto **Environment**.

## `@Value`
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    // Métodos de negocio

    public void printAppInfo() {
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
    }
}
```
**Environment**
```java
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MyBean {

    @Autowired
    private Environment env;

    public void printAppInfo() {
        String appName = env.getProperty("app.name");
        String appVersion = env.getProperty("app.version");
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
    }
}
```

## Múltiples Archivos de Propiedades
Puedes cargar múltiples archivos de propiedades utilizando varias anotaciones `@PropertySource` o una combinación de ellas en una sola anotación.

```java
@Configuration
@PropertySource({"classpath:application.properties", "classpath:another.properties"})
public class AppConfig {
    // ...
}
```
O usando repetición de la anotación:
```java
@Configuration
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:another.properties")
})
public class AppConfig {
    // ...
}
```

## Manejo de Archivos de Propiedades con Perfiles
Puedes combinar `@PropertySource` con perfiles (`@Profile`) para cargar diferentes archivos de propiedades según el entorno.
```java
@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class AppConfig {
    // ...
}
```
En este ejemplo, Spring cargará un archivo de propiedades específico para el perfil activo (por ejemplo, `application-dev.properties` para el perfil **dev**).

## `@Value`
se utiliza para inyectar valores en los campos, métodos o parámetros de constructor de los beans de Spring. Estos valores pueden provenir de archivos de propiedades, variables de entorno, o incluso cadenas literales.

**Características Clave**
* **Inyección de Valores**: Permite inyectar valores directamente desde archivos de propiedades, variables de entorno, etc.

* **Sintaxis**: Utiliza la sintaxis `${}` para referirse a las propiedades.

* **Flexibilidad**: Puede usarse en campos, métodos y parámetros de constructor.

**Ejemplo de Uso**
* Supongamos que tienes un archivo de propiedades `application.properties`:
```java
app.name=MyApp
app.version=1.0.0
```
Puedes inyectar estos valores en un bean de la siguiente manera:
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    // Métodos de negocio

    public void printAppInfo() {
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
    }
}
```
**En este ejemplo:**

* La anotación `@Value("${app.name}")` inyecta el valor de `app.name` en el campo appName.

* La anotación `@Value("${app.version}")` inyecta el valor de `app.version` en el campo `appVersion`.