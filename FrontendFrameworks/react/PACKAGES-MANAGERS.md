# PNPM (Performant Node Package Manager)
Es un package manager para Node.js que instala dependencias de forma determinista, rápida y eficiente en disco, sin romper el modelo de resolución de módulos de Node.

* **No es “npm pero más rápido”.**
* Es un **rediseño del almacenamiento** y linking de dependencias.

## PNPM es:
* Compatible con `package.json`
* Compatible con `node_modules`
* Compatible con el ecosistema Node
* Incompatible con malas prácticas (y eso es una virtud).

## ¿Qué problema existe realmente?
Antes de PNPM, todos los package managers tenían estos problemas:

1. **Problema 1: Duplicación absurda**
   * Cada proyecto:
```bash
node_modules/react
node_modules/lodash
node_modules/express
# 100 proyectos = 100 copias iguales.
```

2. **Problema 2: node_modules gigantesco**
   * Millones de archivos
   * Profundidad absurda
   * Lento para:
     * `npm install`
     * Docker builds
     * CI/CD
     * **Watchers (fs events)**

3. **Problema 3: Dependencias “fantasma”**
```ts
import foo from 'foo'
```
Funciona aunque NO esté en `package.json` - ¿Por qué? Porque está hoisted por otra dependencia.
* Bugs ocultos
* Builds que fallan en producción
* Migraciones dolorosas

4. **Problema 4: No determinismo real**
   * Dos máquinas:
     * Mismo repo
     * Mismo lockfile
     * Diferente resultado

## ¿Cómo lo resuelve PNPM? (la idea central)
PNPM usa 3 conceptos clave:

1. Content-addressable store

2. Hard links / symlinks

3. node_modules estricto

## Content-addressable store
PNPM guarda TODAS las dependencias en un store global, por defecto:
```bash
~/.pnpm-store/
```
Ejemplo:
```bash
~/.pnpm-store/
└── v3/
    └── files/
        └── 9a/
            └── 1f/
                └── react@18.2.0
```
Clave:
* El path depende del hash del contenido
* Si dos proyectos usan la misma versión → un solo archivo en disco

## Hard links (no copias)
Cuando ejecutas:
```bash
pnpm install
```
**PNPM**:
* NO copia archivos
* Crea hard links desde el store al proyecto

**Resultado**:
* Múltiples proyectos
* Un solo archivo físico en disco

➡️ Instalaciones casi instantáneas

## node_modules estricto
PNPM NO hoistea todo al root como **npm**/**yarn**.

* Cada paquete ve solo lo que declaró explícitamente.
* Si no está en `package.json`:
```bash
❌ Cannot find module
```
Esto:
* Previene bugs
* Fuerza diseño correcto
* Hace builds más confiables

## ¿Cómo es la estructura de PNPM?
node_modules con PNPM
```bash
node_modules/
├── .pnpm/
│   ├── react@18.2.0/
│   │   └── node_modules/
│   │       └── react/
│   ├── lodash@4.17.21/
│   └── express@4.18.2/
│
├── react -> .pnpm/react@18.2.0/node_modules/react
├── lodash -> .pnpm/lodash@4.17.21/node_modules/lodash
└── express -> .pnpm/express@4.18.2/node_modules/express
```
* `.pnpm/` contiene versiones reales
* El root tiene **symlinks**

Node resuelve módulos sin romper compatibilidad

➡️ Node cree que es normal
➡️ PNPM controla la realidad