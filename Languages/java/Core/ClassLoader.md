#core
# Class Loader
El ClassLoader es un componente esencial de la Java Virtual Machine (JVM) que se encarga de cargar las clases en tiempo de ejecución. En Java, las clases no se cargan todas al inicio del programa; en lugar de eso, el ClassLoader se encarga de cargar las clases dinámicamente cuando son necesarias. Esto proporciona flexibilidad y permite que el código Java se ejecute en diferentes entornos sin que las clases tengan que estar compiladas específicamente para cada entorno.

## ¿Para qué sirve el ClassLoader?
El ClassLoader sirve para:

1. **Cargar clases Java en tiempo de ejecución**: Permite que la JVM encuentre y cargue clases solo cuando realmente se necesitan, optimizando el uso de recursos.

2. **Aislar clases**: Diferentes aplicaciones pueden usar distintas versiones de la misma clase sin conflictos, gracias a los diferentes espacios de nombres que manejan los ClassLoaders.

3. **Extender las capacidades de Java:** Puedes crear tus propios ClassLoaders para cargar clases de diferentes fuentes (como archivos .jar, bases de datos o incluso a través de la red).

4. **Implementar características de seguridad**: Los ClassLoaders verifican las clases y sus permisos antes de cargarlas, ayudando a mantener la seguridad de la aplicación.

## Tipos de ClassLoaders en Java
Java define tres tipos principales de ClassLoaders:

1. **Bootstrap ClassLoader**:

   * Es el ClassLoader base que se utiliza para cargar las clases fundamentales de Java, como las de `java.lang`, `java.util`, etc.

   * Se implementa en código nativo y se inicia cuando la JVM se carga. Carga las clases del directorio jre/lib o de un JDK específico.

   * No es accesible directamente desde el código Java.

2. **Extension ClassLoader**:

   * Carga las clases adicionales que extienden las funcionalidades del JDK, generalmente desde el directorio jre/lib/ext o cualquier ruta definida en la variable de sistema `java.ext.dirs`.

   * También conocido como el Platform ClassLoader en versiones más recientes de Java.

3. **Application ClassLoader (o System ClassLoader)**:

   * Es el ClassLoader por defecto que carga las clases de la aplicación que se encuentran en el classpath (especificado por el parámetro -cp o -classpath al ejecutar la aplicación).

   * Carga las clases definidas por el usuario y las librerías externas (por ejemplo, archivos `.jar`).

## Jerarquía de ClassLoaders
Java utiliza una estructura de delegación jerárquica para cargar las clases, conocida como el Modelo de Delegación de ClassLoaders:

1. **Delegación hacia arriba**: Cuando un ClassLoader recibe una solicitud para cargar una clase, primero pasa la solicitud a su ClassLoader padre.

2. **Carga solo si no está disponible**: Solo si el ClassLoader padre no encuentra la clase solicitada, el ClassLoader hijo intenta cargar la clase por sí mismo.

3. **Beneficio**: Esta jerarquía asegura que las clases centrales del JDK (como java.lang.String) siempre sean cargadas por el Bootstrap ClassLoader, previniendo conflictos y garantizando la integridad del entorno de ejecución.

## Flujo de Trabajo del ClassLoader
1. El usuario o la aplicación solicita la carga de una clase (por ejemplo, MyClass).

2. El Application ClassLoader recibe la solicitud y la delega al Extension ClassLoader.

3. El Extension ClassLoader, a su vez, delega la solicitud al Bootstrap ClassLoader.

4. Si el Bootstrap ClassLoader no encuentra la clase, devuelve el control al Extension ClassLoader, y si tampoco la encuentra, se devuelve al Application ClassLoader.

5. Si ninguno de los ClassLoaders puede encontrar la clase, se lanza una ClassNotFoundException. Si el Application ClassLoader la encuentra, la carga en la memoria y la ejecuta.