# `git stash`
El comando git stash es una herramienta muy útil en Git que permite almacenar temporalmente los cambios no committeados (modificaciones y archivos nuevos) en un área de almacenamiento (stash) sin tener que hacer un commit. Esto es ideal para situaciones en las que necesitas cambiar de contexto o de rama rápidamente sin perder el trabajo actual que no está listo para ser committeado.

## ¿Qué es git stash y para qué sirve?
git stash guarda el estado actual de tu área de trabajo y tu índice (stage area), y luego limpia el área de trabajo, dejándola como si hubieras hecho un git reset --hard. Los cambios se guardan en una pila especial, llamada "stash", de donde puedes recuperarlos más tarde para seguir trabajando.

## ¿Cuándo usar git stash?
* **Interrupciones inesperadas**: Estás trabajando en una funcionalidad, pero necesitas cambiar a otra rama para arreglar un error urgente. Puedes usar git stash para guardar tus cambios actuales, cambiar de rama, hacer lo que necesitas, y luego volver para recuperar tu trabajo.

* **Cambio de contexto temporal**: Quieres hacer pruebas en otra parte del código sin perder lo que has modificado.

* **Limpieza rápida del área de trabajo**: Para ver cómo se comporta el código sin tus cambios actuales.

## Uso básico de git stash
1. **Guardar cambios actuales**:
```bash
git stash
```
Esto guarda todos los cambios que no han sido committeados (archivos modificados y nuevos) y limpia tu área de trabajo.

2. **Listar stashes guardados**:
```bash
git stash list
```
Muestra una lista de todos los stashes guardados, con identificadores únicos y un breve mensaje de descripción.

**Ejemplo de salida:**
```bash
stash@{0}: WIP on main: 123abc4 Añadiendo función de autenticación
stash@{1}: WIP on feature/nueva-feature: 567def8 Corrigiendo errores menores
```

3. **Aplicar el stash más reciente:**
```bash
git stash apply
```
Esto recupera los cambios guardados en el último stash sin eliminar el stash de la pila.

4. Aplicar y eliminar el stash más reciente:
```bash
git stash pop
```
Recupera los cambios del último stash y luego elimina ese stash de la pila. Es una forma conveniente de limpiar los stashes que ya no necesitas.

5. Aplicar un stash específico:
```bash
git stash apply stash@{2}
```
Si tienes múltiples stashes, puedes aplicar uno específico usando su identificador (ej. stash@{2}).

6. Eliminar un stash específico:
```bash
git stash drop stash@{2}
```

7. Eliminar todos los stashes:
```bash
git stash clear
```

## Opciones avanzadas
1. **Guardar cambios incluyendo archivos no seguidos**: Por defecto, git stash no guarda archivos no seguidos (archivos que no han sido añadidos con git add). Para incluirlos, usa la opción -u o --include-untracked:
```bash
git stash -u
```
Esto guardará todos los cambios, incluyendo los archivos que Git aún no está rastreando.

2. **Nombrar un stash**: Puedes darle un mensaje descriptivo a un stash para saber exactamente qué cambios contiene:
```bash
git stash save "Añadiendo pruebas para el módulo de usuarios"
```
Al usar git stash list, verás el mensaje que agregaste, lo cual facilita identificar para qué era ese stash.

3. **Crear un branch a partir de un stash**: Si deseas continuar tu trabajo en una rama separada sin aplicarlo en la actual, puedes crear una nueva rama directamente desde el stash:
```bash
git stash branch mi-nueva-rama
```
Esto crea una nueva rama llamada mi-nueva-rama, aplica el stash y elimina el stash de la pila.

## ¿Qué resuelve git stash?
* **Cambio rápido de contexto**: Puedes cambiar de rama, hacer pruebas o arreglar problemas urgentes sin perder tus cambios actuales.

* **Evita commits innecesarios**: A veces tus cambios no están listos para ser committeados, pero necesitas limpiar tu área de trabajo temporalmente. Con git stash, puedes hacerlo sin dejar un historial de commits incompletos.

* **Facilita el manejo de múltiples tareas**: Si estás trabajando en múltiples funcionalidades o arreglos de errores, puedes usar git stash para mantener tu trabajo organizado y volver a él cuando sea necesario.