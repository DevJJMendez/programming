# Lombok
Lombok es una librería para Java que permite simplificar el código eliminando la necesidad de escribir muchos métodos repetitivos, como getters, setters, toString, hashCode, equals, entre otros. Es una solución para reducir el código "boilerplate" (código repetitivo) y mejorar la legibilidad de tu aplicación.

## ¿Para qué sirve Lombok?

Lombok automatiza la generación de métodos comunes en las clases de Java, lo que reduce considerablemente la cantidad de código que tienes que escribir y mantener. Esto hace que el código sea más limpio, conciso y fácil de mantener.

Por ejemplo, cuando trabajas con objetos de datos (POJOs - Plain Old Java Objects), en lugar de escribir manualmente todos los getters, setters, toString, hashCode, y equals, Lombok genera estos métodos automáticamente en tiempo de compilación a través de anotaciones.

## Características de Lombok
Reducción de código repetitivo: La mayor ventaja de Lombok es la eliminación de código repetitivo. Usando anotaciones, puedes generar automáticamente los métodos que normalmente tendrías que escribir manualmente.

Compatibilidad con IDEs: Lombok está soportado por los principales entornos de desarrollo (como IntelliJ IDEA, Eclipse, VSCode, etc.), lo que te permite trabajar con él sin problemas.

Generación de métodos en tiempo de compilación: Lombok usa un compilador en tiempo de compilación para generar el código necesario, por lo que no afecta el rendimiento en tiempo de ejecución.

Interacción con herramientas estándar de Java: Puedes usar Lombok junto con otras herramientas como Maven o Gradle sin que interfiera con el flujo de construcción del proyecto.

Anotaciones personalizables: Lombok ofrece una amplia gama de anotaciones para generar diferentes tipos de métodos según lo que necesites.

## Anotaciones más comunes de Lombok
1. **`@Getter` / `@Setter`**:
   * `@Getter`: Genera automáticamente el método `get` para todos los campos de la clase.

   * `@Setter`: Genera automáticamente el método `set` para todos los campos de la clase.
```java
@Getter @Setter
public class Persona {
    private String nombre;
    private int edad;
}
```

2. **`@ToString`**: Genera un método `toString()` que incluye todos los campos de la clase, facilitando la visualización de los datos del objeto.
```java
@ToString
public class Persona {
    private String nombre;
    private int edad;
}
```

3. **`@EqualsAndHashCode`**: Genera automáticamente los métodos `equals()` y `hashCode()` basados en todos los campos de la clase, lo cual es útil para la comparación de objetos y operaciones con colecciones.
```java
@EqualsAndHashCode
public class Persona {
    private String nombre;
    private int edad;
}
```

4. **`@NoArgsConstructor` / `@AllArgsConstructor`**:
   * `@NoArgsConstructor`: Genera un constructor sin parámetros.

   * `@AllArgsConstructor`: Genera un constructor con todos los parámetros.
```java
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private String nombre;
    private int edad;
}
```

5. **`@Data`**: Esta anotación es una combinación de las anotaciones `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, y `@RequiredArgsConstructor`, por lo que es útil cuando quieres todos estos métodos generados automáticamente.
```java
@Data
public class Persona {
    private String nombre;
    private int edad;
}
```

6. **`@Value`**: Similar a `@Data`, pero para clases inmutables. Genera un constructor con todos los parámetros, **`getters`**, **`toString`**, **`hashCode`**, y `equals`, pero los campos son finales (`final`).
```java
@Value
public class Persona {
    private String nombre;
    private int edad;
}
```

7. **`@Builder`**: Genera un patrón de diseño `Builder` para tu clase, lo que permite la creación de objetos de manera fluida y legible.
```java
@Builder
public class Persona {
    private String nombre;
    private int edad;
}

// Uso
Persona persona = Persona.builder().nombre("Juan").edad(25).build();
```

## ¿Qué resuelve Lombok?
* **Reduce la verbosidad**: La principal ventaja es que reduce la cantidad de código repetitivo (boilerplate), como `getters`, `setters`, `toString`, `equals`, `hashCode`, y `constructors`.

* **Mejora la mantenibilidad**: Al eliminar código repetitivo, hace que el código sea más fácil de leer y mantener. No tienes que preocuparte por mantener métodos como getters y setters al agregar nuevos campos.

* **Optimiza el tiempo de desarrollo**: Ahorra tiempo al no tener que escribir manualmente métodos comunes, lo que mejora la productividad del equipo.

* **Facilita el trabajo con `POJOs`**: Las clases que son solo contenedores de datos, conocidas como POJOs, pueden beneficiarse enormemente de Lombok, ya que elimina toda la codificación repetitiva asociada con estos objetos.

## ¿Cómo lo resuelve Lombok?
Lombok resuelve estos problemas utilizando un procesador de anotaciones que se ejecuta en **tiempo de compilación**. 

Cuando el compilador de Java encuentra una anotación de **Lombok** en una clase, genera el código correspondiente (por ejemplo, `getters`, `setters`, `toString`, etc.) en el código bytecode, que es lo que se compila y se ejecuta en la JVM.

Esto significa que el código generado por Lombok nunca aparece directamente en tu código fuente, pero el compilador lo genera automáticamente cuando compilas el proyecto, lo que resulta en un código más limpio y sin repeticiones.

## Integración con el entorno de desarrollo (IDE)
Para usar Lombok en tu proyecto, debes añadirlo como dependencia en tu archivo pom.xml (para Maven) o build.gradle (para Gradle). Además, asegúrate de tener los plugins necesarios en tu IDE para que Lombok funcione correctamente.

Ejemplo de dependencia Maven:
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>
```

# Problemas entre Lombok y JPA
Lombok puede causar ciertos problemas de compatibilidad con algunas bibliotecas, como JPA (Java Persistence API), MapStruct, o en escenarios donde el manejo de la carga de datos (lazy loading) en Hibernate (u otros ORM) no se comporta como se espera. 

## Problemas Comunes de Lombok con JPA y Hibernate (Lazy Fetching)
Cuando trabajas con JPA y Hibernate, puedes encontrarte con situaciones donde las asociaciones entre entidades tienen configurada la estrategia de carga lazy. Esto significa que los datos relacionados se cargan bajo demanda, no cuando se recupera la entidad principal. Sin embargo, Lombok puede interferir con esto de las siguientes formas:

### 1. Problemas con @Getter y @Setter cuando la relación es `lazy`:
Cuando usas Lombok con `@Getter` y `@Setter` en entidades JPA, Lombok generará automáticamente los métodos de acceso (`getters` y `setters`) incluso para las propiedades que están configuradas para carga perezosa (`fetch = FetchType.LAZY`).

La estrategia `lazy` significa que los datos de la relación no se cargan hasta que se accede a ellos explícitamente, lo cual en algunas situaciones podría dar lugar a un error de **`LazyInitializationException`** si intentas acceder a las relaciones después de que la sesión de Hibernate se haya cerrado (por ejemplo, en un contexto transaccional donde la sesión ya ha terminado).

Ejemplo de problema:
```java
@Entity
@Data // Lombok genera getter/setter
public class Cliente {
    @OneToMany(fetch = FetchType.LAZY)
    private List<Orden> ordenes;
}
```
Aquí, el getter generado por Lombok puede intentar acceder a la relación **`ordenes`**, lo que podría intentar cargar la lista fuera del contexto de una sesión activa de Hibernate, lo que da lugar a una **`LazyInitializationException`**.

**Solución**: Evitar `@Getter` y `@Setter` automáticos en relaciones `lazy` (Basicamente evitar usar la anotación `@Data`): **Para solucionar este problema, puedes evitar el uso de Lombok en los campos relacionados con la carga perezosa o utilizar el acceso a los datos solo dentro de una sesión activa.**

También puedes optar por usar la anotación `@Access(AccessType.PROPERTY)` para acceder a las relaciones de manera controlada.

Alternativa recomendada:
```java
@Entity
@Data // Lombok genera getter/setter
public class Cliente {
    @OneToMany(fetch = FetchType.LAZY)
    @Access(AccessType.FIELD) // Usar el acceso directo
    private List<Orden> ordenes;

    // Puede usar otros métodos de acceso en lugar de @Getter y @Setter
}
```

### 2. Uso de `@EqualsAndHashCode` con JPA:
El problema con `@EqualsAndHashCode` de Lombok también surge cuando se tiene una relación bidireccional en una entidad JPA. Por ejemplo, si tienes una relación `OneToMany` y `ManyToOne` entre dos entidades, y Lombok genera `equals()` y `hashCode()` automáticamente, podría caer en un ciclo infinito de llamadas recursivas entre las entidades.

Ejemplo de problema:
```java
@Entity
@EqualsAndHashCode
public class Cliente {
    @OneToMany(mappedBy = "cliente")
    private List<Orden> ordenes;
}

@Entity
public class Orden {
    @ManyToOne
    private Cliente cliente;
}
```
En este caso, `equals()` y `hashCode()` se generan en ambas clases y podrían entrar en un ciclo infinito si no se gestionan adecuadamente las relaciones bidireccionales.

**Solución**: Puedes evitar el uso de `@EqualsAndHashCode` y manejar la comparación de objetos manualmente, o bien, utilizar una estrategia personalizada para las relaciones bidireccionales.

**Tambien podemos excluir los campos que no queremos cargar directamente**
```java
@Entity
@EqualsAndHashCode(exclude = {"cliente"})
public class Cliente {
    @OneToMany(mappedBy = "cliente")
    private List<Orden> ordenes;
}

@Entity
public class Orden {
    @ManyToOne
    private Cliente cliente;
}
```

## Problemas entre Lombok y MapStruct
### 1. MapStruct y Lombok generan el mismo código:
`MapStruct` genera los métodos de mapeo (como `toDTO()` o `toEntity()`) durante la compilación, mientras que Lombok genera métodos de acceso (`getters` y `setters`), `constructors`, etc.

El problema puede surgir si usas Lombok para generar `getters` y `setters` en campos que MapStruct también necesita mapear, ya que MapStruct no tiene acceso a la versión generada por Lombok en el tiempo de compilación.

**Solución**: Para resolver este problema, puedes usar la anotación `@Mapping` en MapStruct para indicar explícitamente cómo se deben mapear los campos, o asegurarte de que las anotaciones de Lombok no interfieran con la generación de código de MapStruct.
```java
@Mapper
public interface ClienteMapper {
    @Mapping(source = "nombre", target = "fullName")
    ClienteDTO clienteToClienteDTO(Cliente cliente);
}
```
Si tienes problemas con los getters generados por Lombok, también puedes usar el `@Accessors` de Lombok para configurar el comportamiento de los getters y setters.

### 2. Compatibilidad con `@Builder`:
Si usas Lombok para generar un `@Builder` y MapStruct intenta usar ese constructor, puede haber algunos problemas de mapeo si las propiedades no están alineadas correctamente.

**Solución**: Utiliza una configuración adecuada de constructores personalizados o métodos `@Builder` de MapStruct para trabajar con los constructores generados por Lombok.

## ¿Cómo evitar estos problemas?
* Desactiva ciertas anotaciones de Lombok cuando estés trabajando con relaciones JPA o MapStruct. Evitar el uso de @Getter, @Setter, @EqualsAndHashCode, @ToString en campos que puedan estar involucrados en relaciones lazy o que deban ser mapeados por MapStruct.

* Controlar las relaciones: En el caso de relaciones de JPA que utilicen lazy fetching, es mejor evitar el uso de Lombok en esos campos, o bien acceder a esas relaciones solo dentro del contexto de una sesión activa de Hibernate.

* Usar @Mapping explícito en MapStruct: Si estás usando MapStruct, asegúrate de usar anotaciones como @Mapping para mapear de forma explícita los campos entre clases.

* Construcción manual de métodos equals() y hashCode(): Si tienes relaciones bidireccionales, es mejor implementar estos métodos manualmente para evitar ciclos infinitos.

### Configuración
```xml
<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.11.0</version>
				<configuration>
					<source>21</source>
					<target>21</target>
					<annotationProcessorPaths>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
							<version>1.18.30</version>
						</path>
						<path>
							<groupId>org.mapstruct</groupId>
							<artifactId>mapstruct-processor</artifactId>
							<version>1.5.5.Final</version>
						</path>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok-mapstruct-binding</artifactId>
							<version>0.2.0</version>
						</path>
					</annotationProcessorPaths>
				</configuration>
</plugin>
```
La configuración que has compartido está diseñada para garantizar que Lombok y MapStruct trabajen juntos de manera fluida durante el proceso de compilación en un proyecto Maven. Analicemos cada parte de esta configuración:

1. Configuración del Plugin maven-compiler-plugin
El maven-compiler-plugin es el encargado de compilar el código Java en un proyecto Maven. En este caso:

<source>21</source> y <target>21</target>: Especifican que el código se compilará usando las características de Java 21 como fuente y destino. Esto asegura compatibilidad con esta versión del lenguaje.
2. <annotationProcessorPaths>
Este bloque define los procesadores de anotaciones que el compilador usará durante la compilación. Es crucial porque tanto Lombok como MapStruct funcionan generando código automáticamente a través de procesadores de anotaciones. Los elementos definidos en este bloque aseguran que ambos procesadores trabajen correctamente.

lombok:

Propósito: Lombok genera automáticamente código (como getters, setters, constructores, etc.) durante la compilación. Esto requiere que el procesador de anotaciones de Lombok esté registrado.
Grupo/Artefacto
```xml
<path>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
</path>
```
Este bloque asegura que Lombok sea reconocido como un procesador de anotaciones válido durante la compilación.

Propósito: MapStruct es un procesador de anotaciones que genera automáticamente el código necesario para realizar transformaciones entre clases (mapeos). El procesador necesita estar registrado para que MapStruct pueda funcionar.
Grupo/Artefacto
```xml
<path>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.5.5.Final</version>
</path>
```

lombok-mapstruct-binding:

Propósito: Este artefacto es el núcleo de la configuración. Su propósito es resolver los conflictos entre Lombok y MapStruct. MapStruct depende de los métodos generados por Lombok (como getters, setters, constructores, etc.) para realizar los mapeos, pero dado que Lombok genera este código durante la compilación y no en el tiempo de escritura, MapStruct podría no encontrar estos métodos a menos que se configure adecuadamente.
Este artefacto es un puente que permite a MapStruct reconocer los métodos generados por Lombok antes de que termine el proceso de compilación.
Grupo/Artefacto
```xml
<path>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok-mapstruct-binding</artifactId>
    <version>0.2.0</version>
</path>
```

Objetivo de la Configuración
La configuración intenta resolver un problema conocido cuando se usan Lombok y MapStruct en un proyecto Maven:

Problema:
MapStruct no puede ver los métodos generados dinámicamente por Lombok (como getters, setters o constructores) porque estos métodos no existen en el código fuente sino que se generan en tiempo de compilación.
Solución:
El procesador lombok-mapstruct-binding asegura que los métodos generados por Lombok sean visibles para MapStruct antes de que este comience a generar el código de los mapeos.

 Beneficios de esta Configuración
Compatibilidad entre Lombok y MapStruct: Permite que MapStruct vea el código generado por Lombok durante el mismo ciclo de compilación.
Simplificación del código: Puedes seguir usando las anotaciones de Lombok (@Getter, @Setter, @Builder, etc.) y las de MapStruct (@Mapper, @Mapping) sin necesidad de implementar manualmente métodos adicionales o escribir configuraciones complejas.
Mejor manejo de dependencias: La inclusión del puente lombok-mapstruct-binding resuelve automáticamente problemas que podrían surgir al combinar ambas bibliotecas.
5. Escenarios en los que es útil
Proyectos donde se usan entidades o DTOs con Lombok (para generar getters, setters, constructores, etc.) y MapStruct para mapeos automáticos entre clases.
Evita tener que escribir manualmente getters/setters en clases mapeadas por MapStruct, manteniendo el código más limpio y centrado en la lógica del negocio.
