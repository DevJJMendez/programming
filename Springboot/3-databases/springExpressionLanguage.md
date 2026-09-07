# Spring Expression Language
Spring Expression Language (SpEL) es un lenguaje de expresiones potente que forma parte del framework Spring, diseñado para evaluar y manipular valores en tiempo de ejecución. SpEL es utilizado en varios componentes de Spring para configurar y expresar condiciones lógicas, acceder a datos y modificar propiedades de objetos de manera dinámica, permitiendo una alta flexibilidad en las aplicaciones.

## ¿Qué es SpEL?
SpEL es un lenguaje de expresiones que permite evaluar expresiones y realizar operaciones en tiempo de ejecución dentro de un contexto de Spring. A diferencia de otros lenguajes de expresión (como el OGNL o el lenguaje de expresiones de JSP), SpEL está integrado completamente en Spring, y está optimizado para funcionar en aplicaciones basadas en este framework.

## ¿Para qué sirve SpEL?
SpEL se utiliza para:

* Configurar valores y propiedades de beans: Puedes inyectar valores dinámicos en propiedades de beans, como fórmulas y cálculos.

* Expresar condiciones y lógica de control: Útil en anotaciones como @PreAuthorize para aplicar control de acceso.

* Acceder y manipular propiedades de objetos: Facilita el acceso a atributos y métodos de objetos Java en tiempo de ejecución.

* Evaluar expresiones complejas en configuraciones: Como expresiones de transformación de datos o de condiciones.

## ¿Qué resuelve?
SpEL permite:

* Configuración dinámica: Los valores que pueden cambiar en tiempo de ejecución, como datos de propiedades externas o cálculos basados en contexto, pueden ser manejados de forma flexible sin necesidad de recompilar el código.

* Facilidad de uso de datos en contexto: Simplifica el acceso a datos del entorno, como valores de propiedades del sistema o variables de sesión, y permite manipular estos datos directamente en anotaciones o configuraciones.

* Condiciones y control de acceso: En aplicaciones de Spring Security, permite expresar reglas de autorización y acceso en código de manera declarativa.

## ¿Cómo lo resuelve?
SpEL resuelve estas necesidades mediante su integración en la infraestructura de Spring, lo cual permite que se utilice en casi cualquier lugar de configuración y en anotaciones. SpEL es evaluado en tiempo de ejecución, accediendo a variables y datos que permiten construir expresiones flexibles. Además, es compatible con operadores, funciones y expresiones avanzadas, lo cual lo hace extremadamente versátil.

## Principales Características de SpEL
* Expresiones de valores literales: Soporta valores literales de texto, booleanos, numéricos, fechas, etc.

* Expresiones matemáticas y lógicas: Permite realizar cálculos, evaluaciones y operaciones de comparación (+, -, >, <, &&, ||, etc.).

* Expresiones de colección: Trabaja con listas, mapas y arrays de manera dinámica.

* Acceso a métodos y propiedades: Permite invocar métodos y acceder a propiedades de objetos.

* Variables y funciones: Permite declarar variables locales y utilizar funciones personalizadas.

## Ejemplo Completo: Usos Comunes de SpEL en Spring
* **Inyección de valores con `@Value`**, SpEL permite inyectar valores en propiedades de beans mediante la anotación @Value. A continuación, un ejemplo donde @Value usa una expresión para calcular el valor:
```java
@Value("#{2 + 2}")
private int resultado; // Inyecta el valor 4 en 'resultado'
```
También se puede usar SpEL para extraer valores de application.properties:
```java
@Value("#{systemProperties['user.name']}")
private String userName; // Inyecta el nombre de usuario del sistema
```

* **Uso en `@PreAuthorize`**, En Spring Security, SpEL es clave para expresar condiciones de seguridad en anotaciones como @PreAuthorize:
```java
@PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
public void metodoProtegido(Long userId) {
    // Solo accesible si el usuario es administrador o su ID coincide con el 'userId'
}
```

* **Manipulación de Colecciones**, SpEL es capaz de trabajar con colecciones, permitiendo filtrar, mapear y operar sobre listas y mapas. En el siguiente ejemplo, se filtran elementos de una lista:
```java
@Value("#{miLista.?[precio > 100]}")
private List<Producto> productosCaros; // Solo productos cuyo precio es mayor a 100
```

* **Expresiones Condicionales**, SpEL permite utilizar expresiones condicionales mediante operadores ternarios y operadores de comparación. Esto es útil para configurar valores dinámicos basados en condiciones:
```java
@Value("#{systemProperties['os.name'] == 'Windows 10' ? 'ruta/windows' : 'ruta/otros'}")
private String ruta; // Asigna una ruta dependiendo del sistema operativo
```