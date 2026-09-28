# `String`
La clase String en JavaScript representa una cadena de caracteres y es utilizada para trabajar con texto. Este tipo de datos es fundamental en cualquier lenguaje de programación, ya que permite almacenar, manipular y analizar texto en diversas formas. En JavaScript, las cadenas son inmutables, lo que significa que una vez creada una cadena, su contenido no puede cambiar directamente; en su lugar, cualquier manipulación crea una nueva cadena.

## ¿Qué es String?
String es un tipo de dato y una clase en JavaScript que encapsula las cadenas de caracteres, proporcionando métodos y propiedades útiles para manejar texto. Las cadenas pueden ser creadas usando comillas simples ('texto'), comillas dobles ("texto") o comillas invertidas (`texto`), que habilitan el uso de templates literals.

## ¿Para qué sirve String?
String sirve para:

Almacenar texto en una aplicación.
Manipular texto, como concatenar, dividir, buscar y modificar caracteres o palabras dentro de una cadena.
Formatear información al presentar datos en una página web o interfaz de usuario.
Validar y analizar texto en funciones como validación de entradas del usuario.

## ¿Qué resuelve String?
String facilita la manipulación y gestión de texto, algo esencial en el desarrollo de software, sobre todo en interfaces de usuario y validación de datos. Proporciona un conjunto de métodos que permite manipular cadenas sin tener que escribir implementaciones complejas para tareas comunes como búsqueda, reemplazo, conversión de mayúsculas a minúsculas, etc.

## ¿Cómo lo resuelve?
La clase String resuelve la manipulación de texto mediante métodos incorporados que permiten:

Buscar y extraer información específica en cadenas.
Formatear y modificar el contenido textual.
Comparar y analizar texto en condiciones lógicas.

Estos métodos están optimizados para manejar texto de forma eficiente y, al ser inmutables, aseguran que las cadenas originales no cambien, lo que es útil en ciertas arquitecturas de software.

## Métodos Principales de String
### Concatenación
* concat(): Une dos o más cadenas y devuelve una nueva cadena
```js
const saludo = "Hola";
const nombre = "Juan";
const mensaje = saludo.concat(" ", nombre); // "Hola Juan"
```

### Búsqueda y Obtención de Subcadenas
charAt(index): Devuelve el carácter en la posición especificada.
```js
const palabra = "JavaScript";
const letra = palabra.charAt(3); // "a"
```
indexOf(substring): Encuentra el índice de la primera aparición de una subcadena.
```js
const frase = "Aprender JavaScript";
const posicion = frase.indexOf("JavaScript"); // 9
```
lastIndexOf(substring): Encuentra el índice de la última aparición de una subcadena.
```js
const posicionFinal = frase.lastIndexOf("JavaScript");
```
slice(start, end): Extrae una porción de la cadena sin modificar la original.
```js
const parte = frase.slice(9, 19); // "JavaScript"
```
substring(start, end): Similar a slice pero no acepta valores negativos.
```js
const parte2 = frase.substring(9, 19); // "JavaScript"
```

### Manipulación y Transformación
toUpperCase() y toLowerCase(): Convierte la cadena a mayúsculas o minúsculas.
```js
const grito = frase.toUpperCase(); // "APRENDER JAVASCRIPT"
```
trim(): Elimina los espacios en blanco al principio y al final de la cadena.
```js
const entrada = "   hola   ";
const limpio = entrada.trim(); // "hola"
```
replace(substring, newSubstring): Reemplaza la primera coincidencia de una subcadena.
```js
const nuevaFrase = frase.replace("JavaScript", "TypeScript"); // "Aprender TypeScript"
```
repeat(count): Repite la cadena el número especificado de veces.
```js
const eco = "¡Hola! ".repeat(3); // "¡Hola! ¡Hola! ¡Hola!"
```

### Comparación y Verificación
includes(substring): Verifica si una subcadena está presente.
```js
const existe = frase.includes("JavaScript"); // true
```
startsWith(substring) y endsWith(substring): Verifica si una cadena comienza o termina con una subcadena.
```js
const comienza = frase.startsWith("Aprender"); // true
```
localeCompare(otherString): Compara dos cadenas para orden alfabético según el idioma.
```js
const orden = "a".localeCompare("b"); // -1
```

### División de Cadenas
split(separator): Divide la cadena en un arreglo de subcadenas.
```js
const palabras = frase.split(" "); // ["Aprender", "JavaScript"]
```