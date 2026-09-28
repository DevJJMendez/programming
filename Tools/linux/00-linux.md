# Linux
Es un sistema operativo de código abierto y gratuito que se basa en el núcleo Linux. Fue desarrollado por Linus Torvalds en la década de 1990 y ha experimentado un crecimiento significativo desde entonces. Una de las características distintivas de Linux es su naturaleza modular y su capacidad para adaptarse a una amplia gama de usos, desde servidores de alta gama hasta dispositivos móviles y sistemas integrados.

En términos más técnicos, Linux es un kernel, es decir, la parte central del sistema operativo que se encarga de la gestión de recursos del hardware y proporciona servicios para que los programas se ejecuten. Sin embargo, cuando hablamos de "Linux", nos referimos generalmente a un sistema operativo completo que incluye no solo el kernel, sino también una gran cantidad de software de sistema y aplicaciones desarrolladas por la comunidad de código abierto.

## Estructura
la estructura de directorios sigue un estándar establecido llamado Filesystem Hierarchy Standard (FHS), que define la organización de los archivos en el sistema de archivos. Aquí tienes una descripción de los directorios más importantes en Ubuntu:

- `/ (root)`: Este es el directorio principal del sistema de archivos y contiene todos los demás archivos y directorios. Es similar al directorio `C:\` en Windows.

- `/bin`: Aquí se almacenan los archivos binarios (programas ejecutables) esenciales para el funcionamiento del sistema. Por ejemplo, comandos como ls, cp, mv, etc., se encuentran aquí.

- `/boot`: Contiene los archivos necesarios para el arranque del sistema, incluidos los archivos de configuración del gestor de arranque (como GRUB) y los núcleos del sistema (kernel).
  
- `/dev`: Contiene archivos de dispositivos, que representan hardware y dispositivos del sistema, como discos duros, particiones, terminales y dispositivos de entrada/salida.
  
- `/etc`: Aquí se encuentran los archivos de configuración del sistema y de los programas instalados. Puedes encontrar archivos de configuración para el sistema, servicios de red, usuarios, entre otros.
  
- `/home`: Este es el directorio base para los directorios de usuario personal. Cada usuario tiene su propio subdirectorio dentro de /home donde se almacenan sus archivos personales y configuraciones.
  
- `/lib` y `/lib64`: Contienen bibliotecas compartidas esenciales para los programas del sistema. La carpeta /lib64 está presente en sistemas de 64 bits.

- `/media` y `/mnt`: Estos directorios se utilizan para montar dispositivos externos, como discos USB o unidades de CD/DVD.

- `/opt`: Es utilizado para la instalación de software adicional que no es parte del sistema operativo principal. Los programas instalados aquí suelen tener su propio directorio dentro de /opt.
  
- `/proc` y `/sys`: Estos directorios contienen información sobre procesos en ejecución (/proc) y configuración del kernel (/sys). Son sistemas de archivos virtuales y no contienen archivos en disco.
  
- `/srv`: Aquí se almacenan datos de servicios específicos del sistema.

- `/tmp`: Es un directorio utilizado para almacenar archivos temporales. El contenido de este directorio se borra automáticamente cuando se reinicia el sistema.

- `/usr`: Contiene archivos y directorios relacionados con aplicaciones y recursos de usuario, incluyendo programas instalados, bibliotecas compartidas, archivos de cabecera y documentación.
  
- `/var`: Contiene archivos variables que cambian con el tiempo durante el uso del sistema, como registros de sistema, archivos de bases de datos y correo electrónico.

## SHELL
Es una interfaz de línea de comandos que te permite interactuar con el sistema operativo mediante la introducción de comandos. Es una poderosa herramienta que te brinda un control total sobre el sistema, permitiéndote realizar una variedad de tareas, desde administrar archivos y directorios hasta configurar servicios de red y automatizar tareas.

La shell más comúnmente utilizada en Ubuntu es la **`bash (Bourne Again Shell)`**, aunque también hay otras opciones disponibles, como **`zsh (Z Shell)`** y **`fish (Friendly Interactive Shell)`**. La shell bash ofrece numerosas características útiles, como la expansión de comandos, el autocompletado de rutas y comandos, y la capacidad de utilizar scripts para automatizar tareas repetitivas.

Aquí hay algunos conceptos básicos sobre la shell que te ayudarán a empezar:

- **Prompt**: Es el símbolo que aparece en la línea de comandos y que indica que la shell está lista para recibir un comando. Por lo general, incluye información como el nombre del usuario, el nombre del equipo y el directorio actual.

- **Comandos**: Son instrucciones que le dices a la shell que realice una tarea específica. Pueden ser programas integrados en el sistema operativo o programas externos ubicados en algún lugar del sistema de archivos.

- **Argumentos**: Son opciones o parámetros que se pasan a un comando para modificar su comportamiento o especificar qué acciones debe realizar. Los argumentos se proporcionan después del nombre del comando y a menudo están separados por espacios.

- **Redirecciones**: Permiten cambiar la forma en que la entrada y salida estándar de los comandos se manejan en la shell. Por ejemplo, puedes redirigir la salida de un comando a un archivo en lugar de mostrarla en la pantalla.

- **Pipes**: Permiten enviar la salida de un comando como entrada a otro comando. Esto es útil para realizar operaciones complejas combinando múltiples comandos.

- **Variables** de entorno: Son variables utilizadas por el sistema operativo o por aplicaciones para almacenar información importante, como las rutas de búsqueda de archivos o las preferencias del usuario.

comando -opciones argumentos
```bash
ls -a /home/user
```

## pwd / print working directory / (imprimir directorio de trabajo)
Su función es mostrar el directorio actual en el que te encuentras trabajando en la estructura de directorios del sistema de archivos.

```bash
pwd

/home/usuario
```