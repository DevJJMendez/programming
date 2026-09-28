# `git commit`
El comando git commit es uno de los más importantes en Git, ya que se encarga de guardar los cambios en el historial del repositorio. Cada commit representa una instantánea (snapshot) del código en un momento específico.

## Sintaxis Básica
```bash
git commit -m "Mensaje descriptivo del cambio"
```
`-m "Mensaje"` → Agrega un mensaje corto y descriptivo del cambio.

Ejemplo:
```bash
git add .
git commit -m "Refactorizada la función de autenticación"
```

## Opciones
1. **Editar el último commit**
```bash
git commit --amend -m "Nuevo mensaje corregido"
```
**Importante: Esto reescribe el commit, así que no lo hagas en commits ya enviados a remoto.**

2. **Commits en varias líneas**. Si necesitas un mensaje más detallado:
```bash
git commit
```
Se abrirá el editor predeterminado (Vim, Nano, etc.) para escribir un mensaje más extenso.
```nano
feat: Implementa autenticación con JWT

- Se agregó soporte para tokens JWT en el backend.
- Se actualizó la documentación de la API.
- Se optimizó la validación de sesiones.
```