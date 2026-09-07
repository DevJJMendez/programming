#core
# Java Runtime Environment
El Java Runtime Environment (JRE) es el entorno de ejecución que permite que las aplicaciones Java se ejecuten en una computadora. Proporciona todo lo necesario para ejecutar un programa Java compilado (en bytecode), incluyendo la Java Virtual Machine (JVM) y bibliotecas de clases fundamentales. A diferencia del Java Development Kit (JDK), que está diseñado para el desarrollo de software, el JRE está orientado únicamente a la ejecución de aplicaciones.

## ¿Qué es el JRE?
El JRE es un conjunto de software que permite ejecutar programas escritos en Java. No incluye las herramientas de desarrollo como el compilador (javac) o depuradores que están presentes en el JDK, ya que está diseñado solo para el tiempo de ejecución.

## Componentes del JRE:
1. **Java Virtual Machine (JVM)**: La **JVM** es el componente más importante del JRE, ya que es el encargado de ejecutar el bytecode compilado. Transforma el bytecode en instrucciones específicas de la máquina (ya sea a nivel de sistema operativo o hardware).

2. **Bibliotecas de clases**: El JRE incluye las bibliotecas de clases necesarias para que las aplicaciones Java puedan funcionar. Estas bibliotecas incluyen clases para manejar colecciones, concurrencia, entrada/salida (I/O), redes, gráficos, entre otros.

3. **Archivos de soporte y configuración**: Incluye archivos de configuración y propiedades que permiten gestionar las funcionalidades del entorno de ejecución, como el manejo de seguridad y permisos.

## ¿Para qué sirve el JRE?
El JRE tiene el propósito fundamental de permitir que las aplicaciones Java se ejecuten en cualquier máquina. A través de la JVM, el bytecode Java se puede ejecutar de manera independiente de la plataforma subyacente, lo que hace que las aplicaciones Java sean altamente portables. Esto significa que un programa Java puede ejecutarse en Windows, Linux, macOS y otros sistemas operativos sin necesidad de modificar el código fuente.

## ¿Qué resuelve el JRE?
1. **Portabilidad multiplataforma**: El JRE es responsable de la portabilidad de Java. Al utilizar bytecode y la JVM, cualquier aplicación desarrollada en Java puede ejecutarse en diferentes plataformas sin necesidad de recompilar el código. Esto se logra mediante la JVM, que interpreta el bytecode en tiempo de ejecución.

2. **Abstracción del hardware y el sistema operativo**: El JRE, y en particular la JVM, abstrae los detalles específicos del hardware y del sistema operativo, permitiendo que el mismo bytecode funcione en cualquier dispositivo que tenga un JRE compatible instalado.

3. **Manejo de la memoria**: El JRE también gestiona aspectos cruciales del entorno de ejecución, como la asignación y recolección de memoria. Esto incluye el Garbage Collector (GC), que se encarga de liberar memoria no utilizada automáticamente, evitando fugas de memoria y facilitando la gestión eficiente de los recursos.

4. **Seguridad**: El JRE incluye mecanismos de seguridad para garantizar que las aplicaciones Java se ejecuten en un entorno controlado y seguro. El modelo de seguridad de Java es especialmente útil en entornos como navegadores web, donde las aplicaciones pueden descargarse y ejecutarse de forma remota. El JRE puede imponer restricciones sobre lo que puede hacer una aplicación (como acceder a los archivos del sistema) mediante el uso de un modelo de permisos basado en políticas.

## ¿Cómo lo resuelve el JRE?
1. **Ejecución del bytecode en la JVM**: El **JRE** carga las clases compiladas (bytecode) y las ejecuta en la **JVM**. Este proceso es transparente para el usuario, quien solo necesita instalar el JRE en su sistema para que las aplicaciones Java puedan correr.

2. **Bibliotecas estándar**: Las aplicaciones Java suelen depender de bibliotecas estándar para realizar operaciones comunes (como manejar archivos, conectarse a redes o realizar cálculos matemáticos). El JRE proporciona estas bibliotecas, por lo que no es necesario que los desarrolladores incluyan todo en su código.

3. **Interoperabilidad con el sistema operativo**: El JRE actúa como un intermediario entre la aplicación Java y el sistema operativo, lo que permite que el bytecode interactúe con el sistema de archivos, las redes y otros recursos, mientras asegura que la aplicación se ejecute de manera consistente sin importar la plataforma.

## Diferencias entre JDK y JRE
1. **JDK (Java Development Kit)** es para desarrollo de software y contiene el JRE más herramientas de desarrollo como el compilador javac, el depurador jdb, y otras utilidades.

2. **JRE (Java Runtime Environment)** es solo para ejecutar aplicaciones Java. Contiene la JVM y las bibliotecas necesarias para ejecutar código Java precompilado.