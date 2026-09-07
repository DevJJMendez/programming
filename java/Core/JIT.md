#core
# Just-In-Time
El compilador **Just-In-Time (JIT)** es un componente clave de la **Java Virtual Machine (JVM)** que se encarga de optimizar la ejecución del bytecode en tiempo de ejecución. El JIT convierte el bytecode en código máquina nativo para la plataforma subyacente, lo que permite que los programas Java se ejecuten más rápido que si solo se interpretara el bytecode.

## ¿Qué es el Compilador Just-In-Time (JIT)?
El **JIT** es un compilador dinámico que convierte fragmentos del bytecode de Java en código máquina nativo, el cual puede ser ejecutado directamente por el procesador de la máquina en la que corre la **JVM**. La diferencia principal entre un compilador tradicional y el **JIT** es que este último no realiza la compilación completa del programa en el momento de la compilación del código fuente, sino que compila partes del **bytecode** justo en el momento en que se necesitan durante la ejecución del programa.

El **JIT** es un punto intermedio entre la interpretación del **bytecode** y la compilación estática tradicional (como en lenguajes como `C` o `C++`). Esta técnica mejora el rendimiento del programa, ya que las partes críticas de la aplicación que se ejecutan repetidamente se compilan a código nativo de forma eficiente.

## ¿Cómo funciona el JIT?
1. **Interpretación inicial**: Cuando se ejecuta una aplicación Java, la JVM inicialmente interpreta el bytecode, lo que significa que lee cada instrucción de bytecode y la ejecuta una por una. Esto es más lento que ejecutar código nativo, pero suficiente para aplicaciones menos intensivas en recursos.

2. **Perfilado de ejecución**: Mientras la JVM interpreta el bytecode, también realiza un análisis de la ejecución, observando qué partes del código se ejecutan más frecuentemente (conocido como profiling). Por ejemplo, los bucles o métodos que se llaman repetidamente son candidatos a ser optimizados.

3. **Compilación de "hot spots"**: El JIT actúa sobre los llamados **hot spots**, es decir, aquellas secciones del código que se ejecutan con mayor frecuencia. El compilador JIT convierte estos **hot spots** en código máquina nativo para el sistema operativo y la arquitectura de hardware específica donde está corriendo la JVM. El código nativo es mucho más rápido de ejecutar que el bytecode interpretado, por lo que la aplicación empieza a ganar rendimiento progresivamente.

3. **Ejecución directa del código nativo**: Después de que el JIT haya compilado los **hot spots**, la JVM deja de interpretar ese bytecode y empieza a ejecutar directamente el código nativo generado, lo que mejora significativamente el rendimiento.

## ¿Qué problema resuelve el JIT?
El JIT resuelve el problema del compromiso entre la portabilidad y el rendimiento en lenguajes como Java. Al ser Java un lenguaje interpretado (gracias a su bytecode), el rendimiento podría ser más bajo en comparación con lenguajes compilados a código nativo, como `C` o `C++`. El JIT aborda esto mediante la compilación dinámica, mejorando el rendimiento de las aplicaciones de Java a niveles cercanos a los de los lenguajes compilados, mientras se mantiene la portabilidad gracias al bytecode.

## Ventajas del Compilador JIT
1. **Mejora del rendimiento**: La principal ventaja del JIT es el aumento significativo en la velocidad de ejecución del código Java. Al compilar las partes más utilizadas del código en código nativo, se reduce drásticamente el tiempo de ejecución.

2. **Optimización en tiempo de ejecución**: El JIT puede realizar optimizaciones que un compilador estático no puede, ya que tiene acceso a información dinámica, como los datos de ejecución y el comportamiento real del programa. Esto permite que el JIT aplique técnicas de optimización avanzadas como la inlining de métodos, eliminación de código muerto y desdoblamiento de bucles.

3. **Eficiencia de recursos**: Al no compilar todo el programa desde el principio, sino solo las partes críticas durante la ejecución, el JIT optimiza el uso de recursos, tanto en tiempo de CPU como en memoria. Esto también significa que no se gasta tiempo en compilar código que podría no ejecutarse.

4. **Escalabilidad**: Gracias a las técnicas de optimización del JIT, las aplicaciones Java pueden ser altamente escalables, ya que el JIT ajusta el rendimiento de la aplicación en función de su comportamiento en tiempo real.

## Tipos de Compilación JIT
El JIT puede aplicar diferentes estrategias de compilación, según la implementación de la JVM:

1. **Compilación Baseline**: Esta es la forma más simple de compilación JIT, donde el bytecode se convierte directamente en código nativo sin aplicar optimizaciones complejas. Esto ocurre rápidamente, pero no resulta en el mejor rendimiento posible.

2. **Compilación de Nivel Óptimo**: El compilador JIT también puede aplicar varias fases de optimización, dependiendo de cuánto se utilicen ciertas partes del código. Cuando un método o bucle se identifica como muy crítico (muy "caliente"), el JIT puede recompilar ese código con optimizaciones más avanzadas.

3. **Tiered Compilation**: Esta es una estrategia que combina tanto la compilación básica como las optimizaciones avanzadas. La JVM comienza con una compilación más rápida y simple, y a medida que el código se sigue ejecutando, el JIT recompila el código utilizando optimizaciones más agresivas. Esta técnica proporciona una buena combinación entre rapidez de inicio y rendimiento a largo plazo.

## Ejemplo práctico de JIT
Imagina que tienes una aplicación que realiza cálculos en un bucle intensivo, por ejemplo:

```java
public class CalculoIntensivo {
    public static void main(String[] args) {
        long resultado = 0;
        for (int i = 0; i < 1_000_000; i++) {
            resultado += calcular(i);
        }
        System.out.println(resultado);
    }

    public static long calcular(int valor) {
        return valor * valor;
    }
}
```
Inicialmente, la JVM comenzará interpretando cada iteración del bucle y llamando repetidamente al método `calcular`. Sin embargo, después de notar que el método `calcular` se llama muchas veces, el JIT recompilará ese método y lo convertirá en código nativo, permitiendo que las futuras invocaciones al método sean mucho más rápidas.