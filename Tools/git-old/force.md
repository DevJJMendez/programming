# `force`
El argumento --force (o -f) en Git es una opción poderosa y, a la vez, potencialmente peligrosa que se utiliza para sobrescribir cambios en ciertas operaciones. Es fundamental entender cuándo y cómo usarlo correctamente, ya que un mal uso puede causar la pérdida de trabajo para ti y otros colaboradores. Veamos los casos más comunes en los que se usa --force.

## ¿Qué hace --force?
El argumento --force le dice a Git que sobrescriba el historial local o remoto sin hacer preguntas. Es útil cuando Git, por defecto, bloquea una operación para evitar que sobrescribas cambios ya existentes. Al usar --force, esencialmente le estás diciendo a Git que ignore esas restricciones y realice la acción de todos modos.

## Casos comunes de uso de --force
1. **Pushing con --force (git push --force)**: Cuando intentas hacer un push a una rama remota que ha cambiado desde la última vez que hiciste un pull, Git te impedirá hacer un push directo. Esto es para proteger el trabajo de otros colaboradores, ya que podrías sobrescribir los cambios que hicieron. Sin embargo, hay ocasiones en las que deseas sobrescribir la rama remota, y aquí es donde git push --force entra en juego.
```bash
git push --force origin mi-rama
```
**¿Cuándo se usa?**

   * Después de realizar un git rebase. Dado que git rebase reescribe el historial de commits, Git considerará que el historial local es diferente del historial remoto y bloqueará el push. Al usar --force, puedes sobrescribir el historial remoto con el nuevo historial rebaseado.

   * Para corregir un commit que se haya subido por error.

   * **Advertencia**: Usar git push --force sobrescribirá el historial remoto y puede causar problemas a otros colaboradores que ya hayan trabajado con esa rama. Úsalo con precaución y asegúrate de comunicarte con tu equipo antes de hacerlo.

2. **Reseteando con --hard (git reset --hard)**: El comando git reset se utiliza para mover la cabecera (HEAD) a un commit específico. Al usar el argumento --hard, no solo mueve HEAD, sino que también sobrescribe los cambios en tu área de trabajo. Si añades --force, aseguras que cualquier cambio se sobrescriba sin preguntar.
```bash
git reset --hard <commit> --force
```
**¿Cuándo se usa?**

   * Para deshacer cambios locales y asegurarte de que tu área de trabajo coincida exactamente con un commit específico.
   
   * Advertencia: Esta operación puede hacer que pierdas cambios que aún no hayas agregado o committeado. Úsalo con cuidado.

3. **Forzar un checkout (git checkout --force)**: Cuando intentas hacer un git checkout para cambiar a una rama y tienes cambios no guardados en tu área de trabajo, Git puede bloquear la operación si esos cambios entrarían en conflicto con la rama a la que intentas cambiar. Usar --force puede obligar a Git a sobrescribir esos cambios.
```bash
git checkout --force nombre-rama
```
**¿Cuándo se usa?**

   * Cuando sabes que los cambios actuales no son importantes y deseas descartarlos para cambiar a otra rama sin problemas.

   * **Advertencia**: Esto puede hacer que se pierdan los cambios no guardados.

## ¿Cuándo evitar --force?
Dado que --force puede sobrescribir cambios de manera irreversible, hay situaciones en las que es mejor evitar su uso:

* En ramas compartidas o colaborativas: Si estás trabajando en una rama que otros también están usando, hacer un push --force podría sobrescribir sus cambios y causar conflictos.

* Cuando no estás seguro de los cambios: Asegúrate de entender completamente lo que estás sobrescribiendo antes de usar --force.

* Sin comunicación: Si necesitas hacer un push --force, asegúrate de informar a tu equipo para que nadie se vea afectado por el cambio inesperado.

## Alternativa: git push --force-with-lease
Para mitigar algunos de los riesgos de git push --force, existe una alternativa más segura llamada git push --force-with-lease. Esta opción funciona de manera similar, pero con una verificación adicional: antes de sobrescribir la rama remota, se asegura de que nadie más haya añadido nuevos commits desde la última vez que sincronizaste. Si alguien ha añadido commits, Git no permitirá que se sobrescriban esos cambios.

```bash
git push --force-with-lease
```
Ventajas:

* Protección contra la pérdida de trabajo de otros: Si alguien ha hecho un push a la rama desde la última vez que tú la sincronizaste, este comando impedirá que sobrescribas sus cambios.

* Recomendado sobre --force: En la mayoría de los casos, --force-with-lease es una opción más segura que el --force estándar.