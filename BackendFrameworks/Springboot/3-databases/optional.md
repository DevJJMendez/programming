## `Optional<T>`
es una clase introducida en Java 8 que se utiliza para representar un contenedor que puede o no contener un valor no nulo. Esta clase se utiliza principalmente para evitar la aparición de errores de tipo `NullPointerException` y para hacer que el código sea más explícito y seguro al trabajar con valores que pueden ser opcionalmente nulos.

Es un contenedor genérico que puede contener un valor de tipo `T`, o estar vacío (`Optional.empty()`). En lugar de devolver directamente un valor que podría ser `null`, puedes devolver un `Optional<T>`, que obliga a los consumidores del código a considerar el caso donde el valor podría no estar presente.

### Creación
Existen varias maneras de crear una instancia de `Optional<T>`:

1. `Optional.of(T value)`: Crea un `Optional` que contiene un valor no nulo. Si se pasa un valor `null`, lanza un `NullPointerException`.

    ```java
    Optional<String> optional = Optional.of("Hola");
    ```
2. `Optional.ofNullable(T value)`: Crea un `Optional` que puede contener un valor o estar vacío si el valor es `null`.

    ```java
    Optional<String> optional = Optional.ofNullable(null);  // Optional.empty()
    ```

3. `Optional.empty()`: Crea un `Optional` vacío, que no contiene ningún valor.

    ```java
    Optional<String> optional = Optional.empty();
    ```

### Métodos

* `isPresent()`: Devuelve true si el Optional contiene un valor, o false si está vacío.

    ```java
    if (optional.isPresent()) {
        System.out.println(optional.get());
    }
    ```

* `ifPresent(Consumer<? super T> action)`: Si el Optional contiene un valor, ejecuta la acción proporcionada. Este método es útil para evitar verificaciones manuales con isPresent().

    ```java
    optional.ifPresent(value -> System.out.println(value));
    ```

* `orElse(T other)`: Devuelve el valor contenido si está presente, o devuelve un valor alternativo si el Optional está vacío.

    ```java
    String result = optional.orElse("Valor predeterminado");
    ```

* `orElseGet(Supplier<? extends T> other)`: Similar a orElse, pero el valor alternativo es generado por un Supplier solo si el Optional está vacío.

    ```java
    String result = optional.orElseGet(() -> "Valor generado");
    ```

* `orElseThrow(Supplier<? extends X> exceptionSupplier)`: Devuelve el valor contenido si está presente, o lanza una excepción proporcionada por el Supplier si el Optional está vacío.

    ```java
    String result = optional.orElseThrow(() -> new IllegalArgumentException("No value present"));
    ```

* `get()`: Devuelve el valor contenido, si está presente. Si el Optional está vacío, lanza una NoSuchElementException. Es importante usar este método con precaución y preferiblemente evitarlo.

    ```java
    String value = optional.get();  // Peligroso si optional está vacío
    ```

* `map(Function<? super T, ? extends U> mapper)`: Si el Optional contiene un valor, aplica la función proporcionada al valor y devuelve un nuevo Optional con el resultado. Si está vacío, devuelve un Optional vacío.

    ```java
    Optional<Integer> lengthOptional = optional.map(String::length);
    ```

* `flatMap(Function<? super T, Optional<U>> mapper)`: Similar a map, pero la función proporcionada devuelve un Optional. Si el Optional original está vacío, devuelve un Optional vacío.

    ```java
    Optional<Integer> lengthOptional = optional.flatMap(str -> Optional.of(str.length()));
    ```

* `filter(Predicate<? super T> predicate)`: Si el Optional contiene un valor y el valor cumple con el predicado, devuelve el mismo Optional. Si no cumple, devuelve un Optional vacío.

    ```java
    Optional<String> filteredOptional = optional.filter(value -> value.length() > 5);
    ```

### ¿Cuándo Usarlo?
* **Retorno de Métodos**: Usar `Optional` es útil cuando un método podría no devolver un valor. En lugar de devolver `null`, devolver un `Optional` deja claro a los consumidores del método que podrían no recibir un valor.

* **Evitar `NullPointerException`**: Al utilizar `Optional`, puedes evitar errores de `NullPointerException` porque estás forzado a manejar el caso de un valor ausente explícitamente.

### Buenas Prácticas
* **No Usar `Optional` en Campos**: Evita usar `Optional` en campos de entidades o clases. Es mejor para los valores de retorno de los métodos.

* **No Usar `Optional` para Parámetros**: No es común usar Optional como un tipo de parámetro en métodos, ya que complica la API. Es preferible sobrecargar el método o usar un valor null con manejo adecuado.

* **Usa `Optional` en Métodos Públicos**: Optional es más útil en interfaces públicas para hacer explícito que el valor de retorno puede estar ausente.