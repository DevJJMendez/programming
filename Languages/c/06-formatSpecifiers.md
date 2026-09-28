## Format Specifiers
Los format specifiers en C son códigos especiales utilizados dentro de las funciones de entrada/salida, como `printf()` y `scanf()`, para indicar el tipo de dato que se va a imprimir o leer. Estos especificadores ayudan a determinar cómo se debe interpretar y mostrar el contenido de las variables en formato de texto.

Cuando utilizas una función como `printf()` o `scanf()`, el **format specifier** le indica al compilador cómo formatear o interpretar los datos según el tipo que has declarado. Los especificadores de formato comienzan con el carácter de porcentaje `%` seguido de una **letra o secuencia** que define el tipo de dato.

### ¿Qué resuelven los Format Specifiers?
* **Interpretación correcta de los datos**: Aseguran que el programa sepa cómo procesar un dato (entero, flotante, carácter, etc.).

* **Formateo del output**: Permiten personalizar la presentación de datos en la salida (por ejemplo, controlar el número de decimales en un número flotante).

* **Eficiencia y flexibilidad**: Ofrecen una forma estándar de manejar diferentes tipos de datos sin necesidad de tener múltiples versiones de funciones como `printf()` o `scanf()`.

### Principales Format Specifiers en **C**
| Formato | Tipo de Dato                    | Ejemplo de uso             |
| ------- | ------------------------------- | -------------------------- |
| `%d`    | Entero con signo (int)          | `printf("%d", 42);`        |
| `%i`    | Entero con signo (int)          | `printf("%i", -10);`       |
| `%u`    | Entero sin signo (unsigned int) | `printf("%u", 250);`       |
| `%f`    | Flotante (float, double)        | `printf("%f", 3.14);`      |
| `%lf`   | Doble precisión (double)        | `printf("%lf", 3.14159);`  |
| `%c`    | Carácter (char)                 | `printf("%c", 'A');`       |
| `%s`    | Cadena de caracteres (char*)    | `printf("%s", "Hola");`    |
| `%p`    | Puntero (void*)                 | `printf("%p", &variable);` |
| `%x`    | Entero hexadecimal              | `printf("%x", 255);`       |
| `%o`    | Entero octal                    | `printf("%o", 255);`       |
| `%%`    | Carácter de porcentaje          | `printf("%%");`            |

### ¿Cómo resuelven los problemas?
* **Interacción con el usuario**: Los format specifiers permiten que los programas reciban datos del usuario (`scanf()`) y los muestren de manera legible (`printf()`), lo que es crucial para aplicaciones interactivas.

* **Versatilidad**: El uso de especificadores permite manejar diferentes tipos de datos dentro de una misma función, proporcionando una manera flexible de trabajar con múltiples variables de diferentes tipos en una sola línea de código.

* **Control de formato**: Al formatear la salida, puedes controlar aspectos como la alineación, el número de dígitos después del punto decimal o la presentación en sistemas numéricos como hexadecimal o octal.

### ¿Cómo se utilizan?
1. En `printf()` para imprimir datos
  ```c
  int age = 23;
  print("im $d years old", age);
  ```

2. En `scanf()` para leer datos:
  ```c
  int age;
  scanf("%d", &age);  // %d lee un entero desde la entrada
  ```

3. Formateo de flotantes:
  ```c
  float precio = 3.50;
  printf("El precio es %.2f\n", precio);  // %.2f imprime 2 decimales
  ```

4. Imprimir caracteres y cadenas:
  ```c
  char letra = 'A';
  char nombre[] = "Carlos";
  printf("Letra: %c, Nombre: %s\n", letra, nombre);  // %c para caracteres, %s para cadenas
  ```

### Personalización con los Format Specifiers
Los format specifiers pueden modificarse para cambiar el formato de la salida de diversas formas:

1. **Número de decimales para flotantes:**
   * `%f` imprime un número flotante.
   
   * `%.2f` imprime un número flotante con 2 decimales.
   
   * `%.5f` imprime un número flotante con 5 decimales.

   * **Ejemplo**
```c
float pi = 3.14159;
printf("Valor de Pi: %.2f\n", pi);  // Imprime "3.14"
```

2. **Longitud mínima de campo**:

   * `%5d` asegura que el número entero tenga un ancho mínimo de 5 caracteres, rellenando con espacios a la izquierda si es necesario.

   * **Ejemplo**
```c
printf("Numero: %5d\n", 42);  // Salida: "   42"
```

3. **Alineación de campos**:

   * `%5s` alinea la cadena a la derecha.

   * `%-5s` alinea la cadena a la izquierda

   * **Ejemplo**
```c
printf("%-5s es genial\n", "C");  // Salida: "C     es genial"
```

4. Formato hexadecimal y octal:

   * `%x` para imprimir en hexadecimal.

   * `%o` para imprimir en octal.

   * **Ejemplo**
```c
int num = 255;
printf("Hexadecimal: %x\n", num);  // Salida: "ff"
printf("Octal: %o\n", num);        // Salida: "377"
```

### Casos de uso y cuándo utilizarlos
1. **Cuando necesitas mostrar datos en la consola**: Los **format specifiers** se utilizan en casi todos los programas que requieren mostrar información de manera legible.

2. **Cuando recibes datos del usuario**: `scanf()` los utiliza para interpretar correctamente la entrada del usuario según el tipo de dato esperado.

3. **Cuando necesitas formatear la salida**: Para mostrar datos numéricos con decimales controlados, o para presentar datos en un formato específico como hexadecimal o octal.

4. **Cuando manipulas punteros**: Se utilizan para mostrar direcciones de memoria (%p), lo cual es útil para la depuración y manejo de punteros en C.