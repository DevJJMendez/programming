# Branchs
Las **ramas**, o **branches**, son un concepto fundamental en Git que permite gestionar y desarrollar múltiples líneas de trabajo simultáneamente dentro de un proyecto. Una rama **es simplemente un puntero móvil** a un commit específico en el historial de Git, lo que te permite desarrollar nuevas características, corregir errores o experimentar, sin afectar el historial principal del proyecto.

Una rama en Git **no es una copia de archivos**. Una rama es literalmente un puntero de 41 bytes que apunta a un commit. Nada más.

## ¿Qué es una rama (branch) en Git?
Una rama en Git es una **referencia a una línea de desarrollo que apunta a un commit específico**. **Git** comienza con una rama principal por defecto llamada `main` (o `master` en versiones más antiguas), que es el puntero al commit más reciente en esa rama. Sin embargo, puedes crear ramas adicionales para trabajar en diferentes tareas o características sin interferir con el desarrollo principal.

Cada vez que haces un commit en una rama, Git actualiza ese puntero para que apunte al nuevo commit, manteniendo un historial separado por cada rama.

## ¿Para qué sirven las ramas en Git?
Las ramas permiten un flujo de trabajo más flexible y organizado al permitirte:

* **Desarrollar características aisladas**: Puedes crear una rama para trabajar en una nueva funcionalidad o característica sin afectar el código estable en la rama principal.

* **Corregir errores o hacer experimentos**: Si necesitas solucionar un bug o experimentar con nuevas ideas, puedes hacerlo en una rama separada.

* **Colaborar en equipo**: Cada desarrollador puede trabajar en su propia rama, lo que evita conflictos entre los cambios de diferentes personas.

* **Gestión de versiones**: Las ramas son fundamentales para gestionar diferentes versiones del software, como versiones de desarrollo, preproducción o producción.

## ¿Qué problemas resuelven las ramas?
Las ramas en Git resuelven varios problemas relacionados con el desarrollo de software:

* **Colisión de cambios**: En un entorno colaborativo, varios desarrolladores pueden trabajar en la misma base de código sin interferir unos con otros, gracias a que cada uno tiene su propia rama.

* **Riesgo de inestabilidad**: Al aislar desarrollos en ramas, no corres el riesgo de que los cambios inestables se fusionen inmediatamente en el código de producción.

* **Historial claro**: Las ramas permiten mantener un historial limpio y organizado, ya que los cambios relacionados con características específicas se pueden rastrear en su propia línea de tiempo.

* **Trabajo en paralelo**: Puedes avanzar en diferentes partes del proyecto al mismo tiempo sin bloquear el desarrollo de otras características.

## ¿Cómo lo resuelven las ramas?
Las ramas en Git resuelven estos problemas mediante la creación de líneas de desarrollo completamente separadas. Cada rama es como un "snapshot" del proyecto en un momento dado, que puede evolucionar independientemente del resto del proyecto hasta que decidas combinarla (mergearla) con otra rama.

Por ejemplo:

* **Desarrollo de una característica nueva**: Creas una nueva rama (`git branch featureX`) y trabajas en ella. Los cambios que hagas en esta rama no afectarán a la rama principal (main) hasta que los fusiones (`merge`).

* **Corrección de un bug crítico**: Si encuentras un bug en producción, puedes crear una rama a partir de la versión de producción (`git checkout -b hotfixX`) y aplicar la corrección, mientras otros desarrolladores continúan trabajando en sus ramas

## Flujo de trabajo con ramas en Git
* **Crear una nueva rama**:

  ```bash
  git branch <branch-name>
  ```
* Esto creará una nueva rama basada en el commit actual. Sin embargo, no te cambiará a esa nueva rama automáticamente. Para moverte a la rama recién creada, debes hacer lo siguiente:

  ```bash
  git checkout <branch-name>
  ```

* **Ver todas las ramas**:
  
  ```bash
  git branch
  ```

* **Eliminar una rama**: Despues de que hayas fucionado los cambios y ya no necesites la rama, puedes eliminarla;

  ```bash
  git branch -d <branch-name>
  ```
  Si la rama no ha sido fusionada y aún quieres eliminarla, usa `-D` en lugar de `-d`:

  ```bash
  git branch -D <branch-name>
  ```

## Tipos comunes de ramas en Git
En un flujo de trabajo típico, estas son las ramas más comunes que encontrarás:

* **`main` o `master`**: La rama principal donde reside el código estable y listo para producción.

* **Ramas de características**: Ramas que se crean para desarrollar una nueva funcionalidad. Normalmente se crean desde `main` o `develop` y luego se combinan cuando están listas.

* **Ramas de hotfix**: Son ramas que se crean para corregir errores críticos en producción. Se crean directamente desde la rama de producción.

* **Ramas de desarrollo (develop)**: En algunos flujos de trabajo (como GitFlow), hay una rama principal de desarrollo que contiene el código que aún no está listo para producción.

## Flujos de trabajo (workflows) con ramas
Dependiendo del equipo o proyecto, los flujos de trabajo de Git pueden variar. Algunos de los flujos más comunes incluyen:

* **GitFlow**: es un flujo de trabajo muy estructurado que usa varias ramas de largo plazo para gestionar diferentes etapas del desarrollo (por ejemplo, `main`, `develop`, `feature`, `release`, `hotfix`).

* **GitHub Flow**: es un flujo de trabajo más simple y ágil que solo usa la rama principal (`main`) y ramas de características (feature branches). Una vez que la característica está lista, se fusiona en main a través de un pull request.

* **Trunk-Based Development**: En este flujo de trabajo, los desarrolladores trabajan directamente sobre la rama principal (`main` o `trunk`), realizando commits pequeños y frecuentes. Las ramas de características son menos comunes, y el objetivo es evitar ramas de largo plazo.

# `git switch`
El comando `git switch` fue introducido en Git 2.23 para simplificar el cambio entre ramas, ya que anteriormente, el comando `git checkout` era utilizado tanto para cambiar de ramas como para otras operaciones como restaurar archivos o trabajar en commits específicos. La idea de `git switch` es dividir las responsabilidades de git checkout en comandos más específicos, haciendo que el cambio de ramas sea más intuitivo y menos propenso a errores.

## ¿Qué es `git switch`?
`git switch` es un comando diseñado específicamente para cambiar de una rama a otra o para crear una nueva rama y cambiar a ella. A diferencia de git checkout, no es utilizado para restaurar archivos o para moverse a un commit en modo "detached HEAD". Esto lo hace más simple y fácil de usar en el contexto del trabajo con ramas.

## Sintaxis básica de `git switch`
```bash
git switch [opciones] <nombre_de_la_rama>
```

## Usos principales del comando git switch
* **Cambiar a una rama existente**: El uso más básico de git switch es cambiar a una rama existente en tu repositorio. Si tienes varias ramas en tu proyecto, este comando te permite moverte entre ellas de forma eficiente.
```bash
# Cambiar a la rama 'feature-branch'
git switch feature-branch
```
**Este comando realiza lo siguiente:**
* Mueve el puntero **HEAD** de Git a la rama especificada.

* Actualiza tu directorio de trabajo para reflejar los archivos y el estado del último commit en esa rama.

* **Crear y cambiar a una nueva rama**: Puedes crear una nueva rama y cambiar a ella en un solo comando utilizando la opción `-c`. Esto es útil cuando estás desarrollando una nueva característica o corrigiendo un bug y necesitas comenzar una nueva rama de trabajo.
```bash
# Crear y cambiar a una nueva rama llamada 'new-feature'
git switch -c new-feature
```

* **Volver a la rama anterior**: Si has cambiado de rama y deseas volver rápidamente a la rama anterior, puedes usar `-` (un guion) como alias para el nombre de la rama anterior.
```bash
# Cambiar de vuelta a la última rama en la que estabas
git switch -
```

# `git checkout`
El comando **git checkout** es uno de los comandos más versátiles de Git, ya que permite **moverse entre ramas**, **restaurar archivos** y **commits**, y **explorar el historial de un repositorio**. Con Git `2.23`, el comando `git switch` se introdujo para simplificar la parte de cambio de ramas, pero **git checkout** sigue siendo una herramienta central y flexible en el uso diario de Git.

## ¿Qué es git checkout?
git checkout se utiliza principalmente para tres cosas:

* Cambiar entre ramas de desarrollo.

* Restaurar el contenido de archivos en el área de trabajo (directorio de trabajo).

* Navegar por versiones específicas (**commits**) de tu proyecto.

## Sintaxis
```bash
git checkout <options> <reference>
```
Donde `reference` puede ser un nombre de una rama, un identificador de un **commit**, un **tag**, o un archivo.

## Usos principales del comando `git checkout`
* **Cambiar entre ramas**: El uso más común de git checkout es cambiar de una rama a otra. Al hacerlo, Git actualiza tu directorio de trabajo con los archivos del último commit de la rama seleccionada.

```bash
# Cambiar a una rama llamada "feature-branch"
git checkout feature-branch
```
Esto realiza varias acciones:

  * Git cambia el puntero **`HEAD`** a la rama especificada.

  * Actualiza el directorio de trabajo con el estado del último commit en esa rama.

  * Cualquier cambio no comiteado en tu área de trabajo permanecerá, pero si hay conflictos, Git te pedirá que resuelvas esos conflictos o hagas `commit/stash` antes de cambiar de rama.

* **Crear y cambiar a una nueva rama**: Puedes usar `git checkout -b branch-name` para crear y cambiar a una nueva rama en un solo paso.

* **Volver a un commit anterior (modo "detached HEAD")**: Puedes usar `git checkout` para moverte a un commit específico sin cambiar de rama. Esto coloca a tu repositorio en un estado conocido como "detached HEAD" (cabeza desprendida), donde puedes explorar ese commit, pero no estás en ninguna rama específica.

```bash
# Cambiar a un commit específico usando su hash
git checkout <hash_del_commit>
```
En este modo, cualquier cambio que hagas y confirmes no estará asociado a ninguna rama. Si deseas mantener esos cambios, debes crear una nueva rama:
```bash
git checkout -b nueva-rama
```

*  **Restaurar un archivo específico**: Si cometiste un error en un archivo y deseas restaurarlo a su versión más reciente en la rama, puedes usar git checkout para descartar cambios no comiteados en ese archivo:
```bash
# Restaurar el archivo a la última versión del commit más reciente
git checkout -- nombre_del_archivo
```
Esto reemplaza el archivo en el directorio de trabajo con su versión más reciente en el historial, eliminando los cambios que no se han añadido al área de staging.

* **Restaurar un archivo desde un commit específico**: Si quieres restaurar un archivo desde un commit anterior (sin moverte completamente a ese commit), puedes especificar el archivo y el commit:

```bash
# Restaurar el archivo desde un commit específico
git checkout <hash_del_commit> -- nombre_del_archivo
```
Esto solo afectará a ese archivo específico, y los demás archivos de tu proyecto permanecerán en su estado actual.