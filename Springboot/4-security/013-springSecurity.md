# Spring Security
Spring Security es un marco de seguridad altamente personalizable y extensible para aplicaciones basadas en Java, que proporciona autenticación, autorización y otras características de seguridad. Es fundamental en la construcción de aplicaciones seguras, permitiendo la protección de URLs, la definición de roles y usuarios, la gestión de sesiones, entre otros.

### 1. Conceptos Básicos de Spring Security
* **Autenticación**: Verificación de la identidad del usuario. Implica la comprobación de las credenciales proporcionadas (como usuario y contraseña).

* **Autorización**: Control de acceso basado en roles y privilegios. Determina qué recursos o acciones están disponibles para el usuario autenticado.

### 2. Definición de Usuarios y Roles
En Spring Security, los usuarios y roles se pueden definir de diferentes maneras, dependiendo de las necesidades de la aplicación. Algunas formas comunes incluyen:

* **En Memoria (In-Memory Authentication)**: Para aplicaciones pequeñas o prototipos, puedes definir usuarios y roles directamente en la configuración de Spring Security.

    ```java
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
        }
    }
    ```
    * `@EnableWebSecurity`: Activa la configuración de seguridad.

    * `AuthenticationManagerBuilder`: Utilizado para configurar la autenticación de usuarios. Aquí, estamos configurando usuarios en memoria con contraseñas y roles asignados.

*  **Autenticación Basada en JDBC**: En una aplicación real, normalmente se almacenan usuarios y roles en una base de datos. Spring Security proporciona soporte para esto a través de JDBC.

    ```java
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username=?");
        }
    }
    ```
    * `dataSource`: Configura la conexión a la base de datos.

    * `usersByUsernameQuery`: Consulta SQL para cargar el usuario.

    * `authoritiesByUsernameQuery`: Consulta SQL para cargar los roles del usuario.

* **Protección de URLs Basadas en Roles**: Spring Security te permite definir qué URLs son accesibles para ciertos roles y cuáles no. Esto se configura en el método `configure(HttpSecurity http)` de la clase de configuración de seguridad.

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasRole("USER")
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().permitAll();
    }
}
```
* `antMatchers("/admin/**").hasRole("ADMIN")`: Restringe el acceso a URLs que comienzan con `/admin/` solo a usuarios con el rol "ADMIN".

* `antMatchers("/user/**").hasRole("USER")`: Restringe el acceso a URLs que comienzan con `/user/` solo a usuarios con el rol "USER".

* `permitAll()`: Permite el acceso sin autenticación.

* `anyRequest().authenticated()`: Requiere autenticación para cualquier otra solicitud.

## `WebSecurityConfigurerAdapter`
Era una clase de conveniencia en Spring Security que permitía personalizar la configuración de seguridad web de una aplicación. Aunque era muy utilizada en versiones anteriores de Spring Security, desde **Spring Security 5.0** y en especial con la llegada de **Spring Security 5.7**, se desaconseja su uso y se ha marcado como obsoleta. En su lugar, se recomienda usar la clase `SecurityFilterChain` junto con la anotación `@Configuration`.

`WebSecurityConfigurerAdapter` era una clase abstracta que proporcionaba métodos para configurar los detalles de seguridad de una aplicación web, como la autenticación, la autorización y otras características de seguridad.

**Ejemplo de Configuración con `WebSecurityConfigurerAdapter`**
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configuración de usuarios en memoria
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}password")  // {noop} indica que no se debe codificar la contraseña
            .roles("USER")
            .and()
            .withUser("admin")
            .password("{noop}admin")
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasRole("USER")
            .antMatchers("/").permitAll()
            .and()
            .formLogin()
            .and()
            .logout().permitAll();
    }
}
```
### Desventajas y Deprecación
Spring Security está evolucionando hacia un modelo más moderno y más flexible. Algunas de las razones por las que `WebSecurityConfigurerAdapter` ha sido desaprobada incluyen:

* **Acoplamiento Fuerte**: `WebSecurityConfigurerAdapter` mezclaba la configuración de la autenticación y la autorización, lo que a veces hacía que el código fuera difícil de mantener y de extender.

* **Falta de Flexibilidad**: Al tener que extender una clase abstracta, se limitaba la posibilidad de componer configuraciones de seguridad más modulares y reutilizables.

## `SecurityFilterChain`
Es una interfaz clave en Spring Security que define la configuración de la seguridad web para una aplicación. Cada `SecurityFilterChain` representa una cadena de filtros de seguridad que procesan solicitudes HTTP en una aplicación. Estos filtros pueden manejar tareas como la autenticación, la autorización, la protección CSRF, y más.

### Conceptos Clave
1. **Cadena de Filtros (Filter Chain)**:

   * Una `SecurityFilterChain` consiste en una serie de filtros que se aplican a las solicitudes entrantes en el orden en que están configurados.

   * Los filtros manejan tareas de seguridad como la verificación de credenciales, la aplicación de políticas de autorización, y la gestión de sesiones.

2. **Configuración Declarativa**:

   * En lugar de extender una clase base como `WebSecurityConfigurerAdapter`, la configuración de seguridad se define a través de uno o más beans de tipo `SecurityFilterChain`.

   * Esto permite una configuración modular, en la cual puedes tener diferentes cadenas de filtros para diferentes conjuntos de rutas dentro de tu aplicación.

3. **Ejecución Condicional**:

   * Cada `SecurityFilterChain` puede configurarse para aplicarse solo a ciertas rutas o patrones de URL, lo que permite un control granular sobre cómo se maneja la seguridad en diferentes partes de la aplicación.

### Ejemplo de Configuración con `SecurityFilterChain`
```java
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/").permitAll()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .logout()
                .permitAll();

        return http.build();
    }
}
```
1. **Bean de `SecurityFilterChain`**:

   * Este bean define la configuración de seguridad para la aplicación. Se utiliza `HttpSecurity` para configurar las políticas de autorización y autenticación.
   
   * `authorizeRequests()` se usa para especificar qué roles pueden acceder a qué rutas.

   * `formLogin()` habilita el formulario de inicio de sesión predeterminado de Spring Security.

2. **Aplicación a Rutas Específicas**:

   * La configuración permite que solo los usuarios con el rol "**ADMIN**" accedan a las rutas bajo `/admin/**`, mientras que las rutas bajo `/user/**` son accesibles solo para usuarios con el rol "**USER**".

   * La ruta raíz (`/`) está abierta a todos los usuarios.

### ¿Por Qué Usar `SecurityFilterChain`?
* **Modularidad**: Permite definir múltiples SecurityFilterChain beans si necesitas diferentes configuraciones de seguridad para diferentes partes de tu aplicación.

* **Flexibilidad**: Ofrece un control más granular sobre la seguridad de tu aplicación, evitando la necesidad de extender clases base.

* **Compatibilidad**: Es el enfoque recomendado en las versiones más recientes de Spring Security, alineado con las mejores prácticas modernas.

### `antMatchers / requestMatchers`
son métodos utilizados en Spring Security para definir las rutas o patrones de URL a los que se aplicarán reglas de seguridad. Ambos métodos permiten especificar qué solicitudes deben ser protegidas o tratadas de una manera particular, pero lo hacen de manera diferente en términos de cómo se definen los patrones de URL.

1. **`antMatchers`**

   * Es un método en Spring Security que utiliza patrones de estilo Ant para especificar rutas. Estos patrones son simples y efectivos para la mayoría de los casos comunes.
   
   * **Sintaxis de Ant**:
   
     * `?`  Coincide con un solo carácter.
   
     * `*`  Coincide con cero o más caracteres dentro de un segmento de ruta.
   
     * `**`  Coincide con cero o más directorios en la ruta.
   
   * **Ejemplos**
     
     * `/admin/*`: Coincide con cualquier ruta bajo `/admin/`, como `/admin/home` o `/admin/user`.
     
     * `/admin/**`: Coincide con cualquier ruta bajo `/admin/` y todos sus subdirectorios, como `/admin/home`, `/admin/user/settings`, etc.
  
        ```java
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated();
        ```
2. **`requestMatchers`**
   
   * Es un método más general que acepta diferentes tipos de `RequestMatcher` como parámetros. Esto permite una mayor flexibilidad, ya que puedes usar patrones Ant, expresiones regulares, rutas de Spring MVC, e incluso crear tus propios `RequestMatcher`.
   
   * **Flexibilidad**: `requestMatchers` puede usar:
   
     * **Ant patterns** (similar a `antMatchers`).
   
     * **Regex patterns** para expresiones regulares.
   
     * **Custom RequestMatcher** que te permite crear reglas más complejas.
        
        ```java
        http
            .authorizeRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated();
        ```

## `HttpSecurity`
es una clase central en Spring Security que proporciona una API fluida para configurar la seguridad web en una aplicación. Se utiliza principalmente para definir las políticas de seguridad, como autenticación, autorización, manejo de sesiones, protección CSRF, y mucho más. Cuando configuras una cadena de filtros de seguridad usando `SecurityFilterChain`, `HttpSecurity` es el objeto que manipulas para definir cómo deseas proteger las rutas y manejar las solicitudes en tu aplicación.

1. **Autenticación y Autorización**:

   * **Autenticación**: Configura cómo los usuarios se autentican en la aplicación, como a través de formularios de inicio de sesión, autenticación básica HTTP, o autenticación basada en tokens.

   * **Autorización**: Define qué usuarios o roles tienen acceso a qué recursos.

2. **Configuración de Filtrado**:

   * `HttpSecurity` te permite agregar filtros específicos para manejar diferentes aspectos de la seguridad, como autenticación, autorización, manejo de errores, etc.

   * Estos filtros se añaden a la cadena de filtros que procesa las solicitudes HTTP.

3. **Protección Contra Ataques**:

   * **CSRF (Cross-Site Request Forgery)**: `HttpSecurity` proporciona métodos para habilitar o deshabilitar la protección CSRF.

   * **CORS (Cross-Origin Resource Sharing)**: Configura políticas para compartir recursos entre dominios.

4. **Gestión de Sesiones**:

   * Configura cómo se gestionan las sesiones de usuario, incluidas las políticas para el manejo de sesiones concurrentes, la creación de nuevas sesiones, y la invalidación de sesiones.


### Ejemplo Básico de HttpSecurity
Aquí tienes un ejemplo básico de cómo se utiliza `HttpSecurity` en la configuración de un `SecurityFilterChain`:

```java
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf().disable(); // Deshabilitando CSRF solo como ejemplo

        return http.build();
    }
}
```
1. `authorizeRequests()`:

   * Configura las reglas de autorización para diferentes rutas de la aplicación.

   * Se definen roles específicos que pueden acceder a ciertas rutas, mientras que otras rutas están abiertas o requieren autenticación.

2. `formLogin()`:

   * Configura el inicio de sesión basado en formularios, especificando la página de inicio de sesión personalizada y permitiendo el acceso a la misma.

3. `logout()`:

   * Configura la funcionalidad de cierre de sesión, permitiendo que cualquier usuario pueda cerrar su sesión.

4. `csrf().disable()`:

   * Deshabilita la protección CSRF. Esto es solo un ejemplo y no se recomienda para aplicaciones en producción, a menos que tengas una razón válida para hacerlo.

### Flujo de Trabajo
* **Configuración**: En el método `securityFilterChain`, el objeto `HttpSecurity` se configura mediante una serie de métodos fluidos que encadenan las configuraciones de seguridad.

* **Aplicación**: Cada configuración aplicada en `HttpSecurity` se traduce en la adición de filtros y reglas a la cadena de filtros de seguridad de la aplicación.

* **Construcción**: Finalmente, `http.build()` se invoca para construir y devolver el `SecurityFilterChain`, que será utilizado por Spring Security para procesar las solicitudes entrantes.

### Métodos Comunes en HttpSecurity
* `authorizeRequests()`: Define reglas de autorización basadas en rutas.

* `formLogin()`: Configura el inicio de sesión a través de un formulario.

* `httpBasic()`: Configura la autenticación básica HTTP.

* `logout()`: Configura la funcionalidad de cierre de sesión.

* `csrf()`: Configura la protección CSRF.

* `sessionManagement()`: Configura el manejo de sesiones.

* `cors()`: Configura las políticas de CORS.