# Transpilador
Un transpilador (también llamado source-to-source compiler) es un tipo especial de compilador que traduce código fuente de un lenguaje de alto nivel a otro lenguaje de alto nivel, manteniendo un nivel de abstracción similar.

La distinción clave con un compilador tradicional:
```
COMPILADOR TRADICIONAL:
Java (.java) ──────────────► Bytecode (.class)
C (.c)       ──────────────► Código máquina (.exe)
             alto nivel           bajo nivel
             (abstracto)          (cercano al hardware)

TRANSPILADOR:
TypeScript (.ts) ──────────► JavaScript (.js)
Sass (.scss)     ──────────► CSS (.css)
Kotlin (.kt)     ──────────► JavaScript (.js)
                alto nivel        alto nivel
                (abstracto)       (igualmente abstracto)
```
El nivel de abstracción se **mantiene**. Eso es lo que lo define como transpilador.

## ¿Qué resuelve?
Tres problemas fundamentales:

```
1. COMPATIBILIDAD
   Usar características modernas de un lenguaje
   en entornos que solo soportan versiones antiguas

2. EXPERIENCIA DE DESARROLLO
   Escribir en un lenguaje más expresivo o seguro
   y producir código en el lenguaje que el entorno requiere

3. PORTABILIDAD
   Escribir una vez en un lenguaje
   y ejecutar en múltiples plataformas/entornos
```

## ¿Cómo funciona internamente?
Internamente un transpilador tiene las mismas fases frontales que cualquier compilador. La diferencia está en el back-end: en lugar de generar código de bajo nivel, genera código fuente de otro lenguaje:

```
Código fuente A
      │
      ▼
┌─────────────┐
│    Lexer    │  tokeniza
└──────┬──────┘
       │
       ▼
┌─────────────┐
│   Parser    │  construye AST
└──────┬──────┘
       │
       ▼
┌─────────────┐
│  Análisis   │  verifica tipos,
│  Semántico  │  scopes, etc.
└──────┬──────┘
       │  AST anotado
       ▼
┌─────────────┐
│ Generación  │  ← aquí está la diferencia
│ de código   │    no genera binario
│   fuente B  │    genera código fuente legible
└──────┬──────┘
       │
       ▼
Código fuente B
```
El AST intermedio es el puente. Una vez que tienes el AST del lenguaje A, puedes generar código en cualquier lenguaje B que tenga equivalentes semánticos.

## Ejemplo: TypeScript → JavaScript
El ejemplo más importante del ecosistema moderno.

El problema que resuelve:

JavaScript no tiene tipos. En proyectos grandes esto genera bugs difíciles de detectar:
```js
// JavaScript puro — sin tipos
function calcularDescuento(precio, porcentaje) {
    return precio * porcentaje;   // ¿porcentaje es 0.1 o 10?
                                  // nadie lo sabe hasta que explota
}

calcularDescuento("100", 10);    // "100" * 10 = 1000 — bug silencioso
```
La solución — TypeScript:
```ts
// TypeScript — con tipos
function calcularDescuento(precio: number, porcentaje: number): number {
    return precio * (porcentaje / 100);
}

calcularDescuento("100", 10);
//                ─────
//                ❌ Error en compilación:
//                Argument of type 'string' is not assignable
//                to parameter of type 'number'
```

## Ejemplo: Babel — JavaScript moderno → JavaScript compatible
El problema que resuelve:

Los navegadores no siempre soportan las características más nuevas de JavaScript. Babel permite usar ES2023 y producir código que corre en browsers de 2015.

￼
```js
// JavaScript moderno ES2023 — entrada
const procesarUsuarios = async (ids) => {
    const usuarios = await Promise.all(
        ids.map(async id => {
            const usuario = await fetch(`/api/users/${id}`);
            return usuario.json();
        })
    );

    return usuarios
        .filter(u => u?.activo ?? false)
        .map(({ nombre, email }) => ({ nombre, email }));
};
```
```js
// JavaScript ES5 generado por Babel — salida
"use strict";

function asyncGeneratorStep(gen, resolve, reject, _next, _throw, key, arg) {
    // ...código generado para simular async/await en ES5
}

var procesarUsuarios = function procesarUsuarios(ids) {
    return new Promise(function(resolve, reject) {
        // ...código equivalente sin arrow functions,
        //    sin async/await, sin optional chaining
    });
};
```
* El código ES5 es más largo, más verboso y menos legible.
* Pero corre en cualquier browser.
* Eso es exactamente el trabajo del transpilador.
