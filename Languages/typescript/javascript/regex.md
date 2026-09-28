# Regex
Las expresiones regulares (regex o regexp) son una herramienta poderosa en programación y manipulación de texto, que permite realizar búsquedas y manipulación de cadenas de manera eficiente y flexible.

¿Qué es una expresión regular?
Una expresión regular es una secuencia de caracteres que forma un patrón de búsqueda. Este patrón puede ser utilizado para realizar operaciones sobre cadenas de texto, como buscar, reemplazar, o validar información. Las expresiones regulares son utilizadas en varios lenguajes de programación, incluido JavaScript, Python, Java, PHP, y muchos otros.

¿Para qué sirve una expresión regular?
Las expresiones regulares son útiles para:

Validación de formatos: Comprobar si un texto cumple con un formato específico (como direcciones de correo electrónico, números de teléfono, códigos postales, etc.).
Búsqueda de patrones: Encontrar cadenas de texto que coincidan con un patrón específico dentro de un texto mayor.
Reemplazo de texto: Sustituir partes de una cadena que coinciden con un patrón dado.
División de cadenas: Dividir un texto en partes basándose en un delimitador que coincida con un patrón.
¿Qué resuelve?
Las expresiones regulares resuelven varios problemas comunes en el manejo de texto, tales como:

Filtrar datos: Permitir o denegar información basada en patrones específicos.
Limpiar datos: Eliminar caracteres no deseados o formatear cadenas de acuerdo a requerimientos.
Extraer información: Recoger datos relevantes de un texto sin procesar, como extraer etiquetas, nombres, o valores de un conjunto de datos.
¿Cómo lo resuelve?
Las expresiones regulares resuelven estos problemas a través de una sintaxis que define un patrón. Este patrón puede incluir caracteres literales, metacaracteres (que tienen significados especiales), y cuantificadores que definen la cantidad de coincidencias que se deben encontrar. Los motores de regex, que son parte de muchos lenguajes de programación, utilizan estos patrones para escanear y manipular cadenas.

## Sintaxis básica de las expresiones regulares
1. Literales: Coinciden exactamente con el texto. Por ejemplo, cat coincide con la palabra "cat".

2. Metacaracteres:

.: Coincide con cualquier carácter excepto saltos de línea.
^: Coincide con el inicio de una cadena.
$: Coincide con el final de una cadena.
*: Coincide con 0 o más repeticiones del carácter anterior.
+: Coincide con 1 o más repeticiones del carácter anterior.
?: Coincide con 0 o 1 repetición del carácter anterior.
\: Escapa un metacaracter, permitiendo usarlo como un carácter literal.

3. Clases de caracteres: Define un conjunto de caracteres. Por ejemplo, [abc] coincide con "a", "b" o "c"; [a-z] coincide con cualquier letra minúscula.

4. Rango: Define un rango de caracteres. Por ejemplo, [0-9] coincide con cualquier dígito.

5. Cuantificadores:

* `{n}`: Coincide exactamente con n repeticiones.

* `{n,}`: Coincide con n o más repeticiones.

* `{n,m}`: Coincide con entre n y m repeticiones.

6. Grupos y alternativas:

`(abc)`: Agrupa un conjunto de patrones.

`a|b`: Coincide con "a" o "b".

## Ejemplos de expresiones regulares
1. Validación de un correo electrónico
Una expresión regular para validar correos electrónicos podría ser:
```regex
^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$
```

* ^ indica el inicio de la cadena.

* [a-zA-Z0-9._%+-]+ coincide con el nombre de usuario.

* @ coincide con el símbolo "@".

* [a-zA-Z0-9.-]+ coincide con el dominio.

* \. escapa el punto.

* [a-zA-Z]{2,} coincide con la extensión del dominio.

* $ indica el final de la cadena.

Búsqueda de números en una cadena
```regex
\d+
```

Reemplazo de texto
Supongamos que queremos reemplazar todas las ocurrencias de "cat" por "dog" en una cadena:
```regex
const str = "The cat sat on the mat. The cat is fat.";
const newStr = str.replace(/cat/g, "dog");
console.log(newStr); // "The dog sat on the mat. The dog is fat."
```

## Métodos comunes en JavaScript para trabajar con expresiones regulares
test(): Comprueba si un patrón se encuentra en una cadena.
```js
const regex = /hello/;
console.log(regex.test("hello world")); // true
```
exec(): Ejecuta una búsqueda para un patrón en una cadena y devuelve el resultado.
```js
const regex = /(\d+)/;
const result = regex.exec("There are 15 apples");
console.log(result); // ["15", "15"]
```
match(): Busca coincidencias en una cadena.
```js
const str = "The rain in Spain stays mainly in the plain.";
const matches = str.match(/ain/g);
console.log(matches); // ["ain", "ain", "ain"]
```
replace(): Reemplaza coincidencias en una cadena.
```js
const str = "The cat sat on the mat.";
const newStr = str.replace(/cat/, "dog");
console.log(newStr); // "The dog sat on the mat."
```
split(): Divide una cadena en partes basadas en un patrón.
```js
const str = "one, two, three, four";
const arr = str.split(/,\s*/);
console.log(arr); // ["one", "two", "three", "four"]
```

## Buenas prácticas
Especificidad: Es mejor ser lo más específico posible con los patrones para evitar coincidencias no deseadas.
Comentar: Las expresiones regulares pueden ser difíciles de leer; añadir comentarios puede ser útil.
Pruebas: Probar las expresiones regulares en un entorno de desarrollo o utilizando herramientas en línea para asegurarse de que funcionan como se espera.