# Estructuración de Microservicios en un Monorepo
Usar Monorepos, significa que todos los microservicios comparten un solo repositorio, pero siguen siendo independientes en su ejecución y despliegue.

**Ventajas del Monorepo en Microservicios:**
* Facilita el mantenimiento y gestión del código.

* Promueve la reutilización de código y bibliotecas comunes.

* Evita la duplicación de configuración en múltiples repositorios.

* Simplifica el control de versiones y dependencias.

## Organización del Proyecto en Monorepo
En un Monorepo, cada microservicio es un módulo independiente dentro de un proyecto Maven multi-módulo.

```bash
microservices-monorepo/
│── pom.xml                      # Pom raíz del Monorepo
│── common/                       # Código compartido entre microservicios
│   ├── pom.xml                   # Módulo común con DTOs, utilidades, etc.
│── services/
│   ├── user-service/              # Microservicio de usuarios
│   │   ├── pom.xml                # Configuración de este microservicio
│   ├── order-service/             # Microservicio de órdenes
│   │   ├── pom.xml
│   ├── payment-service/           # Microservicio de pagos
│   │   ├── pom.xml
│── gateway-service/               # API Gateway (Spring Cloud Gateway)
│   ├── pom.xml
│── config-server/                 # Spring Cloud Config Server
│   ├── pom.xml
│── eureka-server/                 # Service Discovery (Eureka)
│   ├── pom.xml
```
Cada módulo tiene su propio `pom.xml`, pero todos heredan configuraciones comunes desde un pom raíz.

## Configuración del pom.xml Principal (Padre)
El archivo `pom.xml` en la raíz del proyecto define la configuración global y la gestión de dependencias.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.empresa</groupId>
    <artifactId>microservices-monorepo</artifactId>
    <version>1.0.0</version>
    <packaging>pom</packaging>

    <modules>
        <module>common</module>
        <module>services/user-service</module>
        <module>services/order-service</module>
        <module>services/payment-service</module>
        <module>gateway-service</module>
        <module>config-server</module>
        <module>eureka-server</module>
    </modules>

    <dependencyManagement>
        <dependencies>
            <!-- Spring Boot BOM para unificar versiones -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>3.2.0</version>
                <scope>import</scope>
                <type>pom</type>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <properties>
        <java.version>17</java.version>
        <spring-boot.version>3.2.0</spring-boot.version>
    </properties>

    <build>
        <pluginManagement>
            <plugins>
                <!-- Plugin para compilar con Java 17 -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.1</version>
                    <configuration>
                        <source>${java.version}</source>
                        <target>${java.version}</target>
                    </configuration>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>
```
* Define los módulos del Monorepo.
* Centraliza la versión de Spring Boot para evitar conflictos entre microservicios.
* Configura Maven para usar Java 17.

## Definición del Proyecto
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
```
* modelVersion: Define la versión del modelo POM que usa Maven (4.0.0 es la más común).
* Namespaces (xmlns): Indican que este POM sigue el esquema XML de Maven.

## Identificación del Proyecto
```xml
    <groupId>com.empresa</groupId>
    <artifactId>microservices-monorepo</artifactId>
    <version>1.0.0</version>
    <packaging>pom</packaging>
```
* groupId: Define el identificador de la organización o empresa.
* artifactId: Nombre del proyecto (en este caso, el monorepo).
* version: Versión del proyecto padre.
* packaging: Al ser un proyecto padre, el tipo de empaquetado es pom (no genera JAR ni WAR, solo gestiona módulos).
  * En Maven, la etiqueta <packaging> define cómo se debe empaquetar el proyecto. Algunos valores comunes son:
    * jar → Para aplicaciones o bibliotecas empaquetadas en un archivo .jar.
    * war → Para aplicaciones web desplegables en servidores como Tomcat.
    * pom → Para proyectos padre o de gestión de dependencias.
  
  * Cuando usamos <packaging>pom</packaging>, significa que el proyecto NO generará un artefacto ejecutable como un .jar o .war.
  
  * Su función principal es actuar como un "proyecto padre" que gestiona módulos y dependencias comunes para otros subproyectos.


## Módulos del Monorepo
```xml
    <modules>
        <module>common</module>
        <module>services/user-service</module>
        <module>services/order-service</module>
        <module>services/payment-service</module>
        <module>gateway-service</module>
        <module>config-server</module>
        <module>eureka-server</module>
    </modules>
```
* Cada <module> representa un subproyecto dentro del monorepo.
* Estos módulos corresponden a microservicios o componentes compartidos:

  * common: Librería de utilidades compartidas.
  * user-service, order-service, payment-service: Microservicios específicos.
  * gateway-service: API Gateway (basado en Spring Cloud Gateway).
  * config-server: Servidor centralizado de configuración (Spring Cloud Config).
  * eureka-server: Servidor de descubrimiento de servicios (Eureka de Netflix).

Maven construirá estos módulos en el orden en que aparecen.

## Gestión de Dependencias
```xml
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>3.2.0</version>
                <scope>import</scope>
                <type>pom</type>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
* Usa Spring Boot BOM (Bill of Materials) para unificar versiones de dependencias.
* scope="import" y type="pom" permiten que los submódulos hereden la versión de Spring Boot sin especificarla explícitamente.

## Propiedades Globales
```xml
    <properties>
        <java.version>17</java.version>
        <spring-boot.version>3.2.0</spring-boot.version>
    </properties>
```
* Define valores globales reutilizables en los submódulos.
* java.version = 17 → Todos los microservicios usarán Java 17.
* spring-boot.version = 3.2.0 → Para garantizar compatibilidad en todos los módulos.

## Configuración del Build
* `maven-compiler-plugin`
```xml
    <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.1</version>
                    <configuration>
                        <source>${java.version}</source>
                        <target>${java.version}</target>
                    </configuration>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
```
* Configura la versión de Java con la que se compila el código
  * `maven-compiler-plugin`: Asegura que todos los submódulos compilen con Java 17.
  * `<source>` → Especifica la versión del código fuente de Java.
  * `<target>` → Define la versión de bytecode generada.

* Define plugins para la compilación de los submódulos, sin forzarlos a aplicarse (cada módulo decide si los usa).

* `spring-boot-maven-plugin`
```xml
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```
* Gestiona la ejecución y empaquetado de aplicaciones Spring Boot.
  * Permite ejecutar el proyecto con mvn spring-boot:run.
  * Empaqueta la aplicación en un JAR ejecutable con Tomcat embebido.
  * Gestiona dependencias de Spring Boot automáticamente.
  * Se usa para convertir la aplicación en un servicio ejecutable sin necesidad de configurar un servidor externo.

Ambos son complementarios y deberían coexistir en un proyecto Spring Boot:
```xml
<build>
    <pluginManagement>
        <plugins>
            <!-- Configurar compilador con Java 17 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>

            <!-- Habilitar el empaquetado de Spring Boot -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```
Esto garantiza que:
✔ Todos los microservicios se compilen correctamente.
✔ Se puedan ejecutar con mvn spring-boot:run.
✔ Se empaqueten como JAR ejecutables con Tomcat embebido.

## Configuración de un Microservicio (user-service)
Cada microservicio dentro de services/ tiene su propio pom.xml, que hereda las configuraciones del padre.
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.empresa</groupId>
        <artifactId>microservices-monorepo</artifactId>
        <version>1.0.0</version>
    </parent>

    <artifactId>user-service</artifactId>

    <!-- Dependencies -->

    <build>
        <plugins>
            <!-- Spring Boot Plugin -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
* Hereda la configuración del `pom.xml` padre.

* La etiqueta `<parent>` en Maven permite que un proyecto herede configuración de otro proyecto padre. Esto es útil cuando queremos centralizar dependencias, configuraciones y plugins en un solo pom.xml principal, evitando la repetición en cada microservicio.
*  ¿Cómo funciona <parent>?
   * Cuando un pom.xml de un microservicio declara un <parent>, automáticamente:

     * ✔ Hereda propiedades, como versiones de dependencias y configuraciones globales.
     * ✔ Evita duplicación de código, ya que las configuraciones comunes solo se definen una vez.
     * ✔ Facilita la gestión del monorepo, permitiendo actualizaciones centralizadas.

#### `spring-boot-starter-parent`
Esto permite heredar configuraciones predefinidas por Spring Boot, simplificando la gestión del proyecto.
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.0</version> <!-- Se debe definir la versión -->
</parent>
```
El microservicio hereda automáticamente:
✔ Versiones de dependencias comunes (Spring Boot y librerías relacionadas).
✔ Configuraciones estándar de plugins de Maven (como maven-compiler-plugin).
✔ Propiedades globales útiles para Spring Boot (como java.version).
✔ Manejo de perfiles y recursos más sencillo.

## Creación de un Módulo Común (common)
El módulo common es usado por múltiples microservicios para compartir clases DTOs, excepciones y utilidades.
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.empresa</groupId>
        <artifactId>microservices-monorepo</artifactId>
        <version>1.0.0</version>
    </parent>

    <artifactId>common</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>
    </dependencies>
</project>
```
* Define DTOs compartidos.
* Evita duplicar código entre microservicios.