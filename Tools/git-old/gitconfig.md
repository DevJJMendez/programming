#fundamentals
# Config
La configuración de Git es esencial para personalizar su comportamiento y adaptarlo a tus necesidades de desarrollo. Git permite configurar desde opciones básicas como el nombre del usuario y el correo electrónico, hasta ajustes más avanzados como reglas de fusión y exclusión de archivos.

## Archivos de Configuración de Git
Git almacena su configuración en tres ubicaciones:

1. **A nivel del sistema (`/etc/gitconfig`)**:

   * Afecta a todos los usuarios del sistema.

   * Se configura con el siguiente comando (requiere permisos de superusuario):

```bash
git config --system
```

2. **A nivel del usuario (`~/.gitconfig` o `~/.config/git/config`)**:

   * Configura Git solo para el usuario actual.

   * Usualmente es donde se colocan configuraciones comunes a todos los repositorios del usuario.

   * Se configura con el siguiente comando:

```bash
git config --global
```

3. **A nivel del repositorio (`.git/config` dentro del repositorio)**:

   * Se aplica solo al repositorio específico en el que se está trabajando.

   * Se configura sin ninguna opción de nivel:

```bash
git config
```
Git utiliza los tres niveles de configuración de manera jerárquica, donde la configuración del repositorio tiene prioridad sobre la del usuario, y la del usuario tiene prioridad sobre la del sistema.

## Comandos Básicos para Configurar Git
1. **Configurar el nombre de usuario y correo electrónico**: Git utiliza esta información para etiquetar tus commits. Configurar estos valores es lo mínimo requerido para que Git funcione correctamente:

```bash
git config --global user.name 'userName'
git config --global user.email 'userEmail@gmail.com'
```

2. Comprobar la configuración actual Puedes ver todas las configuraciones activas usando:
```bash
gif config --list
```

3. Editar la configuración directamente Puedes abrir y editar el archivo de configuración global con:
```bash
git config --global --edit
```
Esto abrirá el archivo `~/.gitconfig` en tu editor de texto configurado.