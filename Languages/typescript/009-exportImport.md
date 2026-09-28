En TypeScript (y JavaScript moderno), los imports y exports permiten modularizar el código, dividiéndolo en diferentes archivos para mantenerlo más organizado y reutilizable. Esto se basa en el sistema de módulos de ECMAScript (ES6), que TypeScript también implementa y extiende con algunas características propias.

## Exports en TypeScript
Los exports permiten que las funciones, variables, clases, interfaces, y otros elementos de un archivo estén disponibles para ser usados en otros archivos. Hay dos tipos principales de exportación en TypeScript: exportaciones nombradas y exportaciones por defecto.

### **Exportaciones Nombradas (Named Exports)**
Las exportaciones nombradas permiten exportar varios elementos desde un archivo, y cada elemento debe ser importado explícitamente por su nombre.

**Ejemplo**
```ts
// archivo: matematicas.ts

export function sumar(a: number, b: number): number {
    return a + b;
}

export function restar(a: number, b: number): number {
    return a - b;
}

export const PI = 3.1416;
```
En este caso, estamos exportando las funciones sumar, restar, y la constante PI. Cada una de ellas puede ser importada individualmente en otro archivo.

Para usar estas funciones o variables exportadas en otro archivo, debes importarlas de manera explícita.
```ts
// archivo: app.ts

import { sumar, restar, PI } from './matematicas';

console.log(sumar(5, 10));  // 15
console.log(PI);            // 3.1416
```
* Puedes importar múltiples exportaciones de un mismo módulo.

* El nombre de las funciones o constantes que importas debe coincidir con el nombre exacto de la exportación.

**Importar Todas las Exportaciones de un Módulo**: Puedes usar el operador `*` para importar todas las exportaciones de un archivo como un objeto
```ts
// archivo: app.ts

import * as math from './matematicas';

console.log(math.sumar(5, 10));  // 15
console.log(math.PI);            // 3.1416
```
En este caso, todas las exportaciones de matematicas.ts están agrupadas bajo el nombre `math`.

### Exportación por Defecto (Default Export)
Una exportación por defecto es cuando exportas un solo valor como predeterminado desde un módulo. Solo puede haber una exportación por defecto por archivo.

**Ejemplo**
```ts
// archivo: geometria.ts

export default function areaCirculo(radio: number): number {
    return Math.PI * radio * radio;
}
```
En este caso, `areaCirculo` es la función que se exporta como el valor predeterminado de este archivo.

Para importar una exportación por defecto, no es necesario usar el nombre exacto de la función o variable. Puedes darle cualquier nombre.
```ts
// archivo: app.ts

import calcularArea from './geometria';

console.log(calcularArea(5));  // 78.53981633974483
```
En este caso, hemos importado la función `areaCirculo` como `calcularArea`.

### Consideraciones
1. **Path Relativo** vs **Path Absoluto**: Asegúrate de que los paths (rutas) a los archivos que importas sean correctos. Puedes usar rutas relativas (`./`, `../`) o absolutas según la estructura de tu proyecto.

2. **Archivos `.ts` y `.tsx`**: En TypeScript, no necesitas incluir la extensión .ts o .tsx al importar módulos. TypeScript la detecta automáticamente.

3. **Compatibilidad con `Node.js`**: Si bien TypeScript sigue el estándar de módulos ECMAScript, también puedes usar el sistema de módulos de Node.js (CommonJS) en TypeScript.