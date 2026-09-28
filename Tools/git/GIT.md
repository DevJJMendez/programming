# GIT
Es un **sistema de control de versiones distribuido**, creado por Linus Torvalds en 2005. Permite a los desarrolladores rastrear los cambios en su código fuente, coordinar el trabajo en equipo y gestionar las diferentes versiones de un proyecto.

## ¿Para qué sirve?
Se utiliza para gestionar los cambios en archivos a lo largo del tiempo. Su propósito principal es permitir que varios desarrolladores trabajen en un proyecto sin perder el historial de cambios y sin conflictos entre versiones. 

Con **Git** puedes:

1. **Registrar el historial**: Guardar versiones de los archivos y retroceder en el tiempo para recuperar versiones anteriores.

2. **Trabajar en equipo**: Varios desarrolladores pueden trabajar en diferentes partes del código simultáneamente.

3. **Fusionar cambios**: Combinar el trabajo de varios desarrolladores sin perder cambios.

4. **Resolver conflictos**: **Git** detecta si dos desarrolladores modifican la misma parte de un archivo y permite resolver esas diferencias.

## ¿Qué problemas resuelve?
* **Conflictos en el trabajo en equipo**: Antes de **Git**, colaborar en un mismo proyecto era propenso a errores, ya que no había un mecanismo claro para fusionar cambios. **Git** resuelve esto mediante ramas y la fusión automática de código.

* **Perdida de historial**: **Git** permite mantener un registro detallado de todos los cambios realizados en un proyecto, evitando la pérdida de información y permitiendo a los desarrolladores ver la evolución del código.

* **Desarrollo paralelo**: Facilita la creación de ramas, lo que permite que diferentes desarrolladores trabajen en características independientes sin interferir entre ellos.

## ¿Cómo lo resuelve?
1. **Snapshots, no diferencias**: **Git** guarda el estado completo de los archivos en cada confirmación (`commit`), en lugar de solo guardar las diferencias entre versiones.

2. **Distribución**: Cada desarrollador tiene una copia completa del repositorio en su máquina local. Esto significa que el historial está disponible sin necesidad de conectarse a un servidor remoto.

3. **Branching**: **Git** permite la creación de ramas fácilmente, lo que facilita el desarrollo de nuevas funcionalidades de manera independiente. Estas ramas se pueden fusionar más adelante.

4. **Sistema de fusión**: Cuando dos ramas tienen cambios en la misma parte de un archivo, **Git** permite fusionarlas automáticamente o a través de la intervención manual si hay conflictos.

---
# Version Control System
Un sistema de control de versiones (Version Control System, VCS) es una herramienta que permite a los desarrolladores rastrear los cambios en los archivos de un proyecto a lo largo del tiempo. Es particularmente útil en el desarrollo de software, donde múltiples personas pueden trabajar en un mismo código o donde se necesita volver a versiones anteriores. Algunas de las principales funciones de un VCS son:

* **Guardar el historial de cambios**: El sistema registra cada cambio realizado en el código (o en cualquier archivo) a través de un "`commit`". Esto permite ver qué se cambió, cuándo y quién lo cambió.

* **Recuperar versiones anteriores**: Si ocurre algún problema con el código actual, puedes volver a una versión anterior sin perder las modificaciones previas.

* **Colaboración**: Facilita el trabajo en equipo, permitiendo que varios desarrolladores trabajen simultáneamente en diferentes partes del proyecto, sin interferencias directas.

* **Seguimiento de cambios en paralelo**: Los VCS permiten que los desarrolladores trabajen en ramas independientes (`branches`) sin afectar la versión principal del proyecto. Luego, esas ramas pueden ser combinadas o fusionadas.

## Tipos de Sistemas de Control de Versiones
1. **Local**: El control de versiones se maneja en una única máquina. Por ejemplo, un desarrollador puede usar un software que guarda versiones del archivo en su disco duro.

2. **Centralizado (CVCS)**: Hay un único servidor que contiene todas las versiones del proyecto, y los desarrolladores trabajan conectándose a ese servidor. Ejemplos incluyen **Subversion (SVN)** y **CVS**.

3. **Distribuido (DVCS)**: En estos sistemas, cada desarrollador tiene una copia completa del repositorio en su máquina. Esto significa que todos los desarrolladores pueden trabajar de forma independiente, y no es necesario estar siempre conectado a un servidor central. Git es un ejemplo de DVCS.

# ¿Qué es un Sistema Distribuido?
Un sistema distribuido es aquel en el que los datos, las operaciones o ambos están distribuidos a través de diferentes nodos o máquinas en lugar de residir en un solo lugar centralizado. En el contexto de Git, se refiere a que cada desarrollador tiene una copia completa del repositorio, incluyendo el historial y las versiones del proyecto. Esto ofrece varias ventajas:

1. **Independencia**: No necesitas estar conectado a un servidor central para trabajar. Puedes hacer commits, crear ramas y revisar el historial sin estar en línea. El repositorio local contiene toda la información necesaria.

2. **Colaboración descentralizada**: Los desarrolladores pueden compartir cambios directamente entre sus máquinas sin necesidad de un servidor central. Aunque, en la práctica, se suele usar una plataforma centralizada (como GitHub) para coordinar los cambios entre todos.

3. **Resiliencia**: Dado que cada copia local es completa, si el servidor central falla, el proyecto no se pierde, ya que cualquier desarrollador tiene una copia completa que se puede restaurar.

4. **Mejor rendimiento**: Las operaciones que no requieren comunicación con un servidor (como hacer commits o consultar el historial) son muy rápidas, ya que todo ocurre de manera local.

### Diferencias entre un Sistema Centralizado y un Sistema Distribuido
* **Centralizado (CVCS)**:

  * Existe un único servidor que contiene el repositorio completo.

  * Los desarrolladores trabajan descargando y enviando los cambios al servidor.

  * Si el servidor falla, se puede perder todo el proyecto o volverse inaccesible hasta que se restaure.

  * Ejemplos: **SVN**, **Perforce**.

* **Distribuido (DVCS)**:

  * Cada desarrollador tiene una copia completa del repositorio, incluyendo su historial.

  * No se depende de un servidor central para la mayoría de las operaciones locales (hacer commits, crear ramas, etc.).

  * **Mayor resiliencia**: si el servidor remoto falla, cualquier desarrollador puede restaurar el proyecto completo desde su copia local.

  * Ejemplos: **Git**, **Mercurial**.

### Ventajas de un Sistema Distribuido como Git
1. **Desconexión**: Puedes trabajar sin conexión a internet o sin acceso a un servidor. Esto es útil en ambientes de trabajo con conectividad intermitente.

2. **Velocidad**: Las operaciones como commits, revisiones de historial y creación de ramas son rápidas, ya que ocurren de manera local.

3. **Flexibilidad en la colaboración**: Los desarrolladores pueden colaborar directamente entre ellos sin un servidor central, haciendo que Git sea altamente adaptable a diferentes flujos de trabajo.

4. **Redundancia y seguridad**: Al haber múltiples copias completas del repositorio, el riesgo de perder el proyecto es muy bajo.

---
# Versionado Numérico Secuencial
El versionado numérico secuencial es un sistema para asignar números de versión a los productos o proyectos de software. A través de esta convención, los desarrolladores y usuarios pueden entender fácilmente el estado de desarrollo, las actualizaciones, y las mejoras realizadas en el software. Las versiones secuenciales siguen un patrón que normalmente consiste en varios niveles de números, como:

* **Mayor**: Cambios significativos o incompatibles con versiones anteriores.

* **Menor**: Nuevas características que son compatibles con versiones anteriores.

* **Parche**: Correcciones de errores o pequeñas mejoras que no cambian las características principales.

## Ejemplo típico de versionado secuencial:
```txt
1.0.0
```
Donde:
* 1: Versión Mayor.
* 0: Versión Menor.
* 0: Parche o revisión.

## Convenciones comunes en el versionado numérico secuencial
1. **Versión Mayor**:

   * Representa cambios importantes en el software, como cambios incompatibles con versiones anteriores.

   * Cuando se cambia el número mayor (por ejemplo, de `1.0.0` a `2.0.0`), se indica que el software ha tenido una modificación significativa que puede requerir ajustes importantes por parte de los usuarios.

   * **Ejemplo**: Cambio de arquitectura del sistema, eliminación de soporte para funciones antiguas.

2. **Versión Menor**:

   * Se incrementa cuando se añaden nuevas características de forma compatible con versiones anteriores.

   * Un cambio en este número indica mejoras y funcionalidades adicionales que no rompen el comportamiento existente.

   * **Ejemplo**: Agregar un nuevo módulo, nuevas APIs.

3. **Parche (Patch)**:

   * Se utiliza para indicar correcciones de errores o pequeñas mejoras sin afectar la funcionalidad global.

   * Este número se incrementa con pequeñas actualizaciones, como arreglos de bugs.

   * **Ejemplo**: Corrección de un fallo en una funcionalidad específica, mejoras de rendimiento menores.

## Ejemplo detallado:
Imaginemos que tienes una versión inicial de tu software 1.0.0:

1. `1.0.0`: Primera versión estable lanzada.

2. `1.0.1`: Se arregla un pequeño error o mejora sin añadir nuevas características.

3. `1.1.0`: Se añade una nueva funcionalidad importante, pero es compatible con la versión anterior.

4. `2.0.0`: Se introducen cambios fundamentales que rompen la compatibilidad con la versión `1.x.x`.

## Versionado numérico secuencial y Git
Cuando trabajas con Git, puedes asignar etiquetas a tus commits para indicar qué versión del software corresponde a ese punto del historial de desarrollo. Esto es útil para identificar versiones específicas y lanzar nuevas versiones de forma clara. Un comando útil es:

```bash
git tag v1.0.0
```
Esto creará una etiqueta (tag) `v1.0.0` en el commit actual, indicando que esa es la versión `1.0.0` del proyecto.

---
# Versionado Semántico (SemVer)
El versionado semántico (SemVer) es un estándar ampliamente utilizado que sigue el patrón secuencial pero con reglas claras. Su formato es:

```txt
MAJOR.MINOR.PATCH
```
Con las siguientes reglas:

1. Incrementa el **MAJOR** cuando introduces cambios incompatibles con la versión anterior.

2. Incrementa el **MINOR** cuando añades funcionalidades nuevas de manera compatible.

3. Incrementa el **PATCH** cuando haces correcciones o mejoras menores sin afectar la compatibilidad.

**Ejemplo de SemVer:**

* `2.0.0`: Cambio mayor, puede ser incompatible con versiones anteriores.

* `2.1.0`: Nuevas funcionalidades añadidas.

* `2.1.1`: Corrección de errores o mejoras menores.

## ¿Cuándo usar versionado numérico secuencial?
1. **Lanzamientos**: Usualmente, se lanza una nueva versión mayor, menor o de parche en los lanzamientos de software público, como versiones de APIs, aplicaciones o librerías.

2. **Desarrollo colaborativo**: Al versionar correctamente, los colaboradores y usuarios tienen una referencia clara de qué cambios esperar y cómo pueden impactar el software.

3. **Mantenimiento y soporte**: Tener un buen control de versiones permite saber a qué versión corresponde un problema o una característica, facilitando su mantenimiento.

---
[](Repository.md)
[](GitInit.md)