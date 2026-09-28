# `peek(Consumer<T> action)`
Es una operación intermedia en la API de Streams de Java que se utiliza principalmente para realizar acciones en los elementos del Stream mientras se mantienen en el flujo. Es especialmente útil para propósitos de depuración y para observar el contenido del Stream sin modificarlo.

## ¿Qué es?
* `peek()` permite registrar o inspeccionar los elementos de un Stream en su camino a través del pipeline de procesamiento, sin afectar el flujo de datos.

* Es una operación intermedia y perezosa, lo que significa que solo se ejecuta cuando se llama a una operación terminal (como `collect()` o `forEach()`).

## ¿Para Qué Sirve?
1. **Depuración**: Es ideal para insertar puntos de depuración y ver cómo se transforman los datos a lo largo del flujo del Stream.

2. **Monitoreo**: Permite inspeccionar valores y realizar acciones adicionales (como imprimir) sin modificar los elementos del Stream.

3. **Preprocesamiento sin modificación**: Se pueden ejecutar acciones auxiliares, como el registro de logs, antes de que los datos continúen su procesamiento.

## ¿Qué Resuelve?
1. **Depuración en pipelines complejos**: Cuando se trabaja con operaciones de Stream complejas, puede ser difícil seguir el flujo de datos. `peek()` permite ver el estado de los elementos en cada paso, facilitando la identificación de errores.

2. **Monitoreo de transformaciones**: Permite observar qué elementos se procesan y cómo se comportan en el Stream, útil para ajustar el comportamiento del pipeline sin alterar los datos.

## ¿Cómo Funciona?
* **Sintaxis básica**:
```java
Stream<T> peekedStream = originalStream.peek(action);
```
Donde `action` es una instancia de `Consumer<T>` que representa la acción que se desea ejecutar (por ejemplo, imprimir los elementos del Stream).

## Ejemplos de Uso:
1. **Depurar Transformaciones en el Stream**: Supongamos que tenemos una lista de números y queremos depurar cómo se están procesando:
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> resultado = numeros.stream()
                                         .filter(n -> n % 2 == 0) // Filtrar números pares
                                         .peek(n -> System.out.println("Filtrado: " + n)) // Depurar salida
                                         .map(n -> n * n) // Elevar al cuadrado
                                         .peek(n -> System.out.println("Mapeado: " + n)) // Depurar salida
                                         .collect(Collectors.toList());

        System.out.println("Resultado final: " + resultado);
    }
}
```
**Salida**
```plaintext
Filtrado: 2
Mapeado: 4
Filtrado: 4
Mapeado: 16
Filtrado: 6
Mapeado: 36
Resultado final: [4, 16, 36]
```
**Explicación**:

* `peek(n -> System.out.println("Filtrado: " + n))` muestra qué elementos pasan el filtro.

* `peek(n -> System.out.println("Mapeado: " + n))` muestra el resultado después de la transformación en `map()`.

## Consideraciones Importantes:
1. **`peek()` es Perezoso**: Al ser una operación intermedia, `peek()` no se ejecutará hasta que se invoque una operación terminal. Esto es clave para entender su comportamiento, ya que si no hay una operación terminal, la acción de `peek()` no se realizará.

2. **No Modificar el Estado**: Aunque técnicamente se pueden modificar los elementos dentro de `peek()`, esto no es recomendado, ya que `peek()` se diseñó para propósitos de inspección. Si se necesita transformar elementos, es mejor usar `map()`.

3. **Utilidad en Debugging**: Aunque no se usa en producción para modificar elementos, es muy útil para depurar y verificar el flujo de datos.