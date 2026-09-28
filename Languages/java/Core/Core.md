change current version: `sudo update-alternatives --config java`

```bash
.java
  ↓ (javac)
.class   ← bytecode
  ↓ (ClassLoader)
JVM
  ↓
CPU / OS
```
**Java no es “interpretado” ni “compilado” → es híbrido.**

```text
Java is considered a hybrid language because it combines both compilation and interpretation in its execution model.

Compilation Phase: Java source code (.java files) is first compiled by the javac compiler into an intermediate form called bytecode (.class files). This bytecode is platform-independent and not directly executable by hardware.

Interpretation and JIT Compilation: The bytecode is then executed by the Java Virtual Machine (JVM). Initially, the JVM interprets the bytecode line by line. However, modern JVMs use Just-In-Time (JIT) compilation, which identifies frequently executed code (hot spots) and compiles it into native machine code at runtime for improved performance.

This dual approach—compiling to bytecode upfront and interpreting or JIT-compiling at runtime—makes Java a hybrid language. ￼ It achieves platform independence (via bytecode) while maintaining high performance (via JIT compilation).

Key takeaway: Java is not purely compiled or interpreted—it's a hybrid, leveraging both models to balance portability and efficiency. 
```

# 1. COMPILACIÓN EN JAVA (`javac`)
* **¿Qué hace realmente javac?** -> javac **NO** crea ejecutables nativos.
  * Hace esto:
    * Analiza sintaxis
    * Verifica tipos
    * Aplica reglas del lenguaje
    * Genera bytecode independiente del sistema

  * Salida:
```bash
Main.class
```

* **Fases internas del compilador (simplificado)**
```text
.java
 ├── Parsing (AST)
 ├── Análisis semántico
 ├── Type checking
 ├── Bytecode generation
 └── .class
```
Si fallas aquí:
* Errores de compilación
* Nunca llegas a la **JVM**

* **Qué contiene un `.class`**
  * Un archivo .class tiene:
    * Constant Pool
    * Bytecode (instrucciones JVM)
    * Metadata de clases
    * Firmas de métodos
    * Información de campos

  * No hay lógica del **OS** aquí.

# 2. EL BYTECODE (EL CONTRATO DE JAVA)
* El bytecode es:
  * Portátil
  * Verificable
  * Seguro

* Ejemplo conceptual:
```text
aload_0
invokevirtual
return
```
No depende de:
* Linux
* Windows
* macOS

# 3. EJECUCIÓN: JVM (JAVA VIRTUAL MACHINE)
La JVM es el runtime real.

* Componentes principales de la JVM
```bash
┌────────────────────┐
│   Class Loader     │
├────────────────────┤
│   Runtime Data     │
│   Areas            │
├────────────────────┤
│ Execution Engine   │
├────────────────────┤
│   GC               │
└────────────────────┘
```

# 4. CLASS LOADING (MUY IMPORTANTE)
Antes de ejecutar, Java carga clases.

* Tipos de ClassLoader
```bash
Bootstrap   → java.lang.*
Extension   → libs estándar
Application → tu código
```
* Regla de oro: Parent delegation model -> Si el padre tiene la clase → se usa esa.

* Errores clásicos aquí:
  * ClassNotFoundException
  * NoClassDefFoundError

  * No son lo mismo.

# 5. RUNTIME DATA AREAS (MEMORIA JVM)
* Stack (por hilo)
  * Frames de métodos
  * Variables locales
  * Referencias

  * Muy rápido, muy limitado.

* Heap (global)
  * Objetos
  * Garbage Collected

  * Errores:
```bash
OutOfMemoryError
```

* Method Area / Metaspace
  * Información de clases
  * Constantes
  * Métodos

* PC Register
  * Instrucción actual

# 6. EXECUTION ENGINE
* Intérprete
  * Ejecuta bytecode línea por línea
  * Arranque rápido
  * Más lento

* JIT Compiler (LA MAGIA REAL)
  * Detecta código “hot”
  * Lo compila a código nativo
  * Optimiza en runtime

  * Java sí se vuelve nativo, pero dinámicamente.

* Optimizaciones reales
  * Inlining
  * Escape analysis
  * Dead code elimination

  * Por eso Java puede ser muy rápido.

# 7. GARBAGE COLLECTOR (GC)
* Qué hace
  * Libera memoria automáticamente
  * Rastrea objetos vivos
  * Elimina objetos muertos

* Conceptos clave
  * Young Generation
  * Old Generation
  * Stop-the-world

  * No es “gratis”, pero evita bugs brutales.

# WORKFLOW REAL COMPLETO
```text
1. Escribes código (.java)
2. javac → bytecode (.class)
3. java → JVM arranca
4. ClassLoader carga clases
5. Verificación de bytecode
6. Ejecución (Interpreter / JIT)
7. GC limpia memoria
```

# QUÉ PASA CUANDO EJECUTAS `java Main`
```bash
java -cp out com.example.Main
```
Internamente:
1. Arranca JVM
2. Busca Main.class en classpath
3. Carga la clase
4. Busca public static void main
5. Ejecuta
6. JVM vive hasta que no haya threads activos

# Ant
Apache Ant es una herramienta de automatización de construcción de software desarrollada por Apache Software Foundation. Es uno de los primeros sistemas de construcción utilizados en el desarrollo de aplicaciones Java y sigue siendo ampliamente utilizado para construir, probar y desplegar aplicaciones.

## Características Clave de Ant:

- **Basado en XML**:

Ant utiliza archivos de configuración basados en XML llamados build.xml para definir las tareas y dependencias del proyecto. Esto proporciona una forma estructurada y legible de especificar cómo debe construirse el proyecto.

- **Tareas**:

Ant define tareas (tasks) que son unidades de trabajo individuales, como compilar código fuente, copiar archivos, ejecutar pruebas, y generar JARs. Ant tiene muchas tareas incorporadas y permite la creación de tareas personalizadas.

- **Independiente del Lenguaje**:

Aunque es más conocido por su uso en proyectos Java, Ant es independiente del lenguaje y se puede utilizar para automatizar la construcción de proyectos en otros lenguajes.

- **Flexibilidad y Extensibilidad**:

Ant es muy flexible y se puede extender mediante la creación de tareas personalizadas en Java. Puedes definir tus propias tareas para realizar acciones específicas que no están cubiertas por las tareas predeterminadas.

- **Portabilidad**:

Ant es una herramienta multiplataforma que se puede ejecutar en cualquier sistema operativo que tenga una JVM instalada.

## ¿Qué es Java with Ant?
Java with Ant se refiere a utilizar Ant como herramienta de construcción para desarrollar aplicaciones Java. Esto incluye la compilación del código fuente, ejecución de pruebas unitarias, empaquetado de archivos JAR, y despliegue de la aplicación, todo gestionado a través de scripts de construcción `build.xml`.

### Ejemplo Básico de un Proyecto Java con Ant

- **Estructura del Proyecto**:

Una estructura de proyecto típica usando Ant puede ser la siguiente:

```bash
my-app
├── build.xml
├── src
│   └── main
│       └── java
├── lib
└── build
```

- **Archivo build.xml Básico**:

Un archivo `build.xml` básico podría verse así:

```xml
<project name="my-app" default="compile" basedir=".">
    <description>
        Proyecto de ejemplo utilizando Apache Ant
    </description>

    <!-- Propiedades -->
    <property name="src.dir" location="src/main/java"/>
    <property name="build.dir" location="build"/>
    <property name="lib.dir" location="lib"/>

    <!-- Crear directorios -->
    <target name="init">
        <mkdir dir="${build.dir}"/>
    </target>

    <!-- Compilar el código fuente -->
    <target name="compile" depends="init">
        <javac srcdir="${src.dir}" destdir="${build.dir}">
            <classpath>
                <fileset dir="${lib.dir}" includes="**/*.jar"/>
            </classpath>
        </javac>
    </target>

    <!-- Limpiar el directorio de construcción -->
    <target name="clean">
        <delete dir="${build.dir}"/>
    </target>
</project>
```

- **Comandos Básicos de Ant**:
  - Compilar el Proyecto: `ant compile`
  - Limpiar el Proyecto: `ant clean`
  - Ejecutar una Tarea Específica: `ant` `[nombre-de-la-tarea]`

## Comparación entre Ant, Maven y Gradle:

- **Configuración y Declaración**:
  - **Ant** utiliza XML para definir tareas de construcción de manera imperativa. Esto puede resultar en scripts más largos y detallados.
  - **Maven** utiliza XML pero sigue un enfoque declarativo, definiendo el qué más que el cómo.
  - **Gradle** usa un DSL basado en Groovy o Kotlin, permitiendo configuraciones concisas y flexibles.

- **Gestión de Dependencias**:
  - **Ant** no tiene una gestión de dependencias incorporada por defecto. Generalmente, se utiliza junto con Ivy para este propósito.
  - **Maven** tiene una gestión de dependencias robusta y centralizada en el archivo `pom.xml`
  - **Gradle** incluye una potente gestión de dependencias integrada directamente en el script de construcción.

-  **Ciclo de Vida del Proyecto**:
   -  **Ant** no define un ciclo de vida del proyecto preestablecido; los desarrolladores tienen que definir explícitamente todas las tareas y su orden.
   -  **Maven** define un ciclo de vida estándar (e.g., `compile`, `test`, `package`) que facilita la construcción de proyectos.
   -  **Gradle** también define un ciclo de vida de construcción, pero con mayor flexibilidad y soporte para construcciones incrementales.

- **Flexibilidad**:
  - **Ant** es muy flexible y permite una personalización detallada de cada paso de la construcción.
  - **Maven** es más rígido debido a su estructura de ciclo de vida estándar.
  - **Gradle** combina flexibilidad con facilidad de uso, permitiendo construcciones complejas y personalizadas con una sintaxis más simple.

## Conclusion
Ant es una herramienta poderosa y flexible para la automatización de construcciones que sigue siendo relevante, especialmente en proyectos que requieren configuraciones personalizadas. Utilizar Java with Ant permite una gran flexibilidad en cómo se construye, prueba y despliega el software. Sin embargo, para proyectos más grandes y con necesidades más complejas de gestión de dependencias, herramientas como Maven y Gradle pueden ofrecer beneficios adicionales en términos de simplificación y eficiencia.

# Gradle
Gradle es una herramienta de automatización de construcción de proyectos que se utiliza principalmente en el desarrollo de software. Gradle se destaca por su flexibilidad y capacidad para manejar proyectos grandes y complejos con una construcción eficiente y rápida. Es compatible con proyectos Java, pero también soporta otros lenguajes de programación y puede gestionar varios tipos de proyectos de manera simultánea.

## Características Clave de Gradle:

- **DSL Basado en Groovy/Kotlin**:

Gradle utiliza un **Domain-Specific Language (DSL)** basado en Groovy y Kotlin, lo que permite una sintaxis más concisa y expresiva para definir las tareas de construcción y configuraciones del proyecto.

- **Gestión de Dependencias**:

Gradle maneja automáticamente las dependencias del proyecto, descargándolas y configurándolas desde repositorios remotos como Maven Central o JCenter.

- **Flexibilidad y Extensibilidad**:

Gradle es altamente configurable y extensible. Puedes personalizar y ampliar su comportamiento utilizando plugins y scripts personalizados.

- **Construcción Incremental**:

Gradle realiza construcciones incrementales, recompilando solo lo que ha cambiado desde la última construcción, lo que mejora significativamente la velocidad de construcción.

- **Soporte Nativo para Multi-Proyecto**:

Gradle facilita la gestión de construcciones de múltiples proyectos, permitiendo la configuración y el manejo de dependencias entre subproyectos de manera eficiente.

- **Integración con Herramientas de CI/CD**:

Gradle se integra fácilmente con herramientas de integración continua y despliegue continuo (CI/CD) como Jenkins, Travis CI, y CircleCI.

## ¿Qué es Java with Gradle?

**Java with Gradle** se refiere a utilizar Gradle como la herramienta de construcción y gestión de proyectos para desarrollar aplicaciones Java. Gradle proporciona una experiencia más flexible y rápida en comparación con otras herramientas como Maven.

### Ejemplo Básico de un Proyecto Java con Gradle

- **Configuración del Proyecto**:
 
Para empezar con un proyecto Java utilizando Gradle, necesitas crear algunos archivos de configuración clave, principalmente `build.gradle`.

- **Estructura del Proyecto**:

La estructura típica de un proyecto Java con Gradle es la siguiente:

```bash
my-app
├── build.gradle
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── java
        └── resources
```

- **Archivo build.gradle Básico**:

Un archivo `build.gradle` básico para un proyecto Java puede ser:

```groovy
plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'junit:junit:4.12'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

- **Archivo settings.gradle**:

El archivo `settings.gradle` puede ser tan simple como:

  ```groovy
  rootProject.name = 'my-app'
  ```

## Comandos Básicos de Gradle:

- **Compilar el proyecto**:
  ```bash
  gradle build
  ```
- **Ejecutar pruebas**
  ```bash
  gradle test
  ```
- **Limpiar el proyecto**
  ```bash
  gradle clean
  ```
- **Generar JAR**
  ```bash
  gradle jar
  ```
## Comparación entre Gradle y Maven:

- **DSL** vs **XML**:
  - **Gradle** usa DSL basado en Groovy o Kotlin, ofreciendo una sintaxis más flexible y menos verbosa.
  - **Maven** utiliza XML para sus archivos de configuración, lo cual puede ser más verboso y rígido.

- **Flexibilidad**:
  - **Gradle** es más flexible y personalizable, permitiendo una mayor personalización de las tareas de construcción.
  - **Maven** sigue un ciclo de vida estándar y es menos flexible en comparación.

-  **Construcción Incremental**:
   -  **Gradle** soporta construcciones incrementales y compilaciones paralelas, lo que puede reducir significativamente el tiempo de construcción.
   -  **Maven** no tiene una construcción incremental tan avanzada y puede ser más lento para proyectos grandes.

-  **Configuración Inicial**:
   -  **Maven** tiene una configuración inicial más sencilla y una estructura de proyecto estándar.
   -  **Gradle** puede requerir una curva de aprendizaje más pronunciada debido a su flexibilidad.
  
## Conclusión
Gradle es una herramienta poderosa y flexible para la construcción y gestión de proyectos, especialmente adecuada para proyectos grandes y complejos. Utilizar Java with Gradle te permitirá aprovechar estas características para desarrollar aplicaciones Java de manera eficiente, rápida y escalable. La capacidad de Gradle para manejar construcciones incrementales, su integración con diversas herramientas y su DSL intuitivo lo hacen una opción robusta para desarrolladores Java modernos.

# Maven
Maven es una herramienta de gestión y comprensión de proyectos desarrollada por Apache. Se utiliza principalmente en proyectos Java para automatizar el proceso de construcción, gestionar dependencias y proporcionar un conjunto estándar de prácticas para el ciclo de vida del proyecto. Maven se basa en el concepto de un modelo de proyecto y una serie de plugins que se encargan de la construcción, compilación, prueba, empaquetado y despliegue del proyecto.

## Características Clave de Maven:

- **Gestión de Dependencias**:

Maven simplifica la gestión de las bibliotecas y dependencias que tu proyecto necesita. Al definir las dependencias en un archivo `pom.xml`, Maven se encarga de descargarlas y configurarlas automáticamente desde repositorios remotos.

- **Modelo de Proyecto Estándar (POM)**:

El archivo `pom.xml` (**Project Object Model**) es el corazón de un proyecto Maven. Define el proyecto, sus dependencias, configuración de plugins, y otra información relevante.

- **Ciclo de Vida del Proyecto**:

Maven define un ciclo de vida estándar que incluye fases como **validate**, **compile**, **test**, **package**, **verify**, **install**, y **deploy**. Esto estandariza cómo se construyen y despliegan los proyectos.

- **Plugins y Extensibilidad**:

Maven utiliza un sistema de plugins para realizar varias tareas. Hay plugins para compilación, pruebas, generación de documentación, empaquetado, y más. Los desarrolladores pueden escribir sus propios plugins para extender la funcionalidad de Maven.

- **Consistencia y Repetibilidad**:

Al estandarizar la estructura del proyecto y el proceso de construcción, Maven garantiza que los proyectos se construyan de manera consistente en diferentes entornos.

## ¿Qué es Java with Maven?

**Java with Maven** se refiere a utilizar Maven como herramienta de gestión de proyectos para desarrollar aplicaciones Java. Este enfoque ofrece varios beneficios clave:

- **Gestión Simplificada de Dependencias**:

Añadir dependencias externas se simplifica enormemente mediante el uso del archivo `pom.xml`. Por ejemplo, para añadir la biblioteca de Google Guava, solo necesitas agregar la siguiente sección en tu `pom.xml`:

```xml
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.0.1-jre</version>
</dependency>
```

- **Estructura de Proyecto Estándar**:

Maven impone una estructura de proyecto estándar, lo que facilita la comprensión y el mantenimiento de los proyectos. La estructura típica de un proyecto Maven es:

```bash
my-app
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── java
        └── resources
```

- **Construcción y Ciclo de Vida Automatizados**:

Maven automatiza el ciclo de vida de construcción del proyecto. Por ejemplo, puedes compilar tu proyecto con el comando `mvn compile`, empaquetarlo en un archivo JAR con `mvn package`, o ejecutar las pruebas con `mvn test`.

- **Integración con Herramientas de CI/CD**:

Maven se integra fácilmente con herramientas de integración continua y despliegue continuo (CI/CD) como Jenkins, Bamboo, y GitLab CI, facilitando la automatización del proceso de construcción y despliegue.

## Ejemplo Básico de un Proyecto Java con Maven

- **Creación del Proyecto**:

Puedes crear un nuevo proyecto Maven ejecutando:

```bash
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

- **Archivo pom.xml Inicial**:

Un archivo `pom.xml` básico para un proyecto Java podría verse así:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.mycompany.app</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

- **Compilación y Ejecución**:
  - Compilar el proyecto: `mvn compile`
  - Ejecutar las pruebas: `mvn test`
  - Empaquetar el proyecto: `mvn package`

## Conclusión
Maven es una herramienta poderosa para la gestión de proyectos Java que simplifica y estandariza muchos aspectos del desarrollo, desde la gestión de dependencias hasta el ciclo de vida de construcción y despliegue. Aprender a utilizar Maven efectivamente te permitirá desarrollar aplicaciones Java de manera más eficiente y mantenible.