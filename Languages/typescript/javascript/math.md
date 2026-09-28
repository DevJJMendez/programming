# `Math`
La clase Math en JavaScript es una colección de propiedades y métodos estáticos que permiten realizar cálculos matemáticos comunes, como operaciones aritméticas, trigonométricas, exponenciales y de redondeo. Math facilita la implementación de lógica matemática compleja y la resolución de problemas sin necesidad de implementar funciones matemáticas desde cero.

¿Qué es Math?
Math es un objeto estático en JavaScript que no se instancia; en su lugar, puedes acceder a sus métodos y propiedades directamente a través de Math. Proporciona una amplia gama de métodos para realizar cálculos matemáticos comunes que van desde lo básico, como redondeo, hasta funciones avanzadas como trigonometría, logaritmos y potencias.

¿Para qué sirve Math?
La clase Math sirve para:

Realizar operaciones matemáticas complejas de forma simple y directa.
Manipular números con precisión en operaciones que involucran redondeo, truncamiento y generación de números aleatorios.
Optimizar cálculos comunes en operaciones con potencias, raíces cuadradas, logaritmos y trigonometría.
Facilitar cálculos estadísticos y de álgebra necesarios para aplicaciones científicas y de ingeniería.
¿Qué resuelve Math?
Math resuelve la necesidad de cálculos matemáticos comunes en aplicaciones, evitando que los desarrolladores deban implementar funciones matemáticas de bajo nivel manualmente. Esto incluye cálculos de raíz cuadrada, generación de números aleatorios, conversiones de ángulos y operaciones estadísticas.

¿Cómo lo resuelve?
Math utiliza métodos predefinidos optimizados y con precisión consistente en todas las implementaciones de JavaScript, lo que garantiza un comportamiento estándar y resultados consistentes sin importar el entorno de ejecución. Su API ofrece métodos directos para casi todas las operaciones matemáticas necesarias en aplicaciones modernas.

## Métodos y Propiedades Principales de Math
Propiedades de Math
Math.PI: La constante PI (~3.14159).
Math.E: La constante de Euler (~2.718).
Math.LN2: Logaritmo natural de 2 (~0.693).
Math.LN10: Logaritmo natural de 10 (~2.302).
Math.SQRT2: Raíz cuadrada de 2 (~1.414).
Math.SQRT1_2: Raíz cuadrada de 1/2 (~0.707)

### Métodos de Math
1. Redondeo y Truncado

Math.round(x): Redondea al entero más cercano.

Math.floor(x): Redondea hacia abajo al entero más próximo.

Math.ceil(x): Redondea hacia arriba al entero más próximo.

Math.trunc(x): Elimina los decimales, devolviendo solo la parte entera.
```js
Math.round(4.5);    // 5
Math.floor(4.7);    // 4
Math.ceil(4.2);     // 5
Math.trunc(4.9);    // 4
```

Mínimo y Máximo

Math.min(a, b, ...n): Devuelve el valor más bajo de los argumentos.

Math.max(a, b, ...n): Devuelve el valor más alto de los argumentos.
```js
Math.min(5, 3, 9);  // 3
Math.max(5, 3, 9);  // 9
```

Potencia y Raíz

Math.pow(base, exponent): Calcula la potencia de un número (base^exponente).

Math.sqrt(x): Devuelve la raíz cuadrada.

Math.cbrt(x): Devuelve la raíz cúbica.
```js
Math.pow(2, 3);     // 8
Math.sqrt(16);      // 4
Math.cbrt(27);      // 3
```

Valor Absoluto

Math.abs(x): Devuelve el valor absoluto de un número.
```js
Math.abs(-10);      // 10
```

Exponenciales y Logaritmos

Math.exp(x): Devuelve el exponencial de x (e^x).

Math.log(x): Devuelve el logaritmo natural (base e) de x.

Math.log10(x): Logaritmo base 10 de x.

Math.log2(x): Logaritmo base 2 de x.
```js
Math.exp(1);        // 2.718 (aproximadamente)
Math.log(Math.E);   // 1
Math.log10(100);    // 2
```

Trigonometría

Math.sin(x), Math.cos(x), Math.tan(x): Funciones trigonométricas básicas.

Math.asin(x), Math.acos(x), Math.atan(x): Funciones trigonométricas inversas.

Math.atan2(y, x): Devuelve el ángulo desde el origen hasta el punto (x, y).
```js
Math.sin(Math.PI / 2);   // 1
Math.cos(0);             // 1
Math.atan2(1, 1);        // 0.785 (π/4 radianes)
```

Generación de Números Aleatorios

Math.random(): Devuelve un número pseudoaleatorio entre 0 (inclusive) y 1 (exclusivo).
```js
Math.random();           // Ejemplo: 0.2345
```
Para obtener un número aleatorio en un rango específico, puedes combinar Math.random() con otros métodos:
```js
// Número aleatorio entre 0 y 10
Math.floor(Math.random() * 11);
```