# Estructuración de Microservicios en un Multirepos
En un enfoque Multirepo (Multiple Repositories), cada microservicio tiene su propio repositorio de código independiente, en lugar de estar agrupados en un solo repositorio como en un Monorepo.

## Características del Multirepo
✔ Independencia total: Cada microservicio puede evolucionar y escalar de forma separada.
✔ Menor complejidad en el repositorio: No hay un solo repositorio gigante con múltiples módulos.
✔ Control de versiones individual: Cada microservicio tiene su propio pom.xml y versionamiento independiente.
✔ Ciclo de despliegue autónomo: No es necesario desplegar todo el sistema al modificar un solo servicio.

## Estructura de un Proyecto con Multirepos
Si tenemos 3 microservicios en una arquitectura distribuida, la estructura en GitHub/GitLab se vería así:
```xml
📦 user-service (Repositorio Git individual)
 ┣ 📂 src/main/java/com/empresa/users
 ┣ 📄 pom.xml
 ┗ 📄 Dockerfile
📦 order-service (Repositorio Git individual)
 ┣ 📂 src/main/java/com/empresa/orders
 ┣ 📄 pom.xml
 ┗ 📄 Dockerfile
📦 payment-service (Repositorio Git individual)
 ┣ 📂 src/main/java/com/empresa/payments
 ┣ 📄 pom.xml
 ┗ 📄 Dockerfile
📦 gateway-service (Repositorio Git individual)
 ┣ 📂 src/main/java/com/empresa/gateway
 ┣ 📄 pom.xml
 ┗ 📄 Dockerfile
📦 config-server (Repositorio Git individual)
 ┣ 📂 src/main/java/com/empresa/config
 ┣ 📄 pom.xml
 ┗ 📄 Dockerfile
📦 eureka-server (Repositorio Git individual)
 ┣ 📂 src/main/java/com/empresa/discovery
 ┣ 📄 pom.xml
 ┗ 📄 Dockerfile
```
Cada microservicio tiene su propio pom.xml, su propia configuración, y es tratado como un proyecto separado.

## Configuración del pom.xml en Multirepo
En Multirepo, cada microservicio tiene su propio pom.xml independiente y no hereda de un pom.xml padre global.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.empresa</groupId>
    <artifactId>user-service</artifactId>
    <version>1.0.0</version>

    <!-- Se usa spring-boot-starter-parent como base -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
    </parent>

    <!-- dependencies -->

    <properties>
        <java.version>17</java.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
Cada microservicio tiene su propia configuración y su propio spring-boot-starter-parent.

## Ventajas
✔ Mayor independencia: Equipos pueden trabajar en diferentes microservicios sin afectarse entre sí.
✔ Escalabilidad: Cada microservicio tiene su propio ciclo de vida y CI/CD.
✔ Menos conflictos en Git: Al tener repositorios separados, se evita el conflicto de código en un repositorio grande.
✔ Versionamiento y despliegue autónomo: Puedes liberar una nueva versión de un servicio sin tocar los demás.

##  Desventajas
❌ Complejidad en la gestión: Se necesitan herramientas adicionales para manejar múltiples repositorios.
❌ Dificultad en la coordinación: Cuando hay cambios en la comunicación entre microservicios, puede ser difícil mantener la compatibilidad.
❌ Más carga en la infraestructura: Cada repositorio necesita su propio pipeline CI/CD y configuración.