# Bajar imagenes
```bash
docker image pull ubuntu
```
Se utiliza para descargar una imagen de Docker desde un registro de imágenes, como Docker Hub, hacia el sistema local. Este comando es útil cuando deseas obtener una imagen específica para usarla posteriormente en la creación de contenedores.

- **Uso de nombres de imágenes**: Debes proporcionar el nombre completo de la imagen que deseas descargar, que normalmente sigue el formato nombre_de_usuario/nombre_de_la_imagen:etiqueta.

- **Versiones específicas**: Es buena práctica especificar la etiqueta de versión de la imagen para asegurarte de obtener una versión específica. Si no se especifica una etiqueta, Docker descargará la última versión etiquetada como "latest".

```bash
docker image pull ubuntu:20.04
```

**Uso**
- Preparación para la ejecución de contenedores: Antes de ejecutar un contenedor basado en una imagen, es necesario asegurarse de que la imagen esté disponible localmente.

- Actualización de imágenes: Si deseas actualizar una imagen existente en tu sistema con una nueva versión, puedes usar docker image pull para descargar la última versión desde el registro de imágenes.

- Uso en scripts y automatización: En scripts de automatización de despliegue o configuración, es común utilizar docker image pull para garantizar que las imágenes necesarias estén presentes antes de crear y ejecutar contenedores.

**SHA256**
SHA256, o Secure Hash Algorithm 256-bit, es un algoritmo de función hash criptográfica. En el contexto de Docker y la tecnología de contenedores, SHA256 se utiliza para generar una huella digital única (checksum) para cada capa de una imagen Docker.

- **¿Por qué se usa SHA256 en Docker?**: Verificación de integridad: Cada capa de una imagen Docker tiene un hash SHA256 único asociado. Cuando se descarga una imagen o se construye a partir de un Dockerfile, Docker calcula el hash SHA256 para cada capa. Esto permite verificar la integridad de la imagen: si alguna capa se corrompe o se modifica, su hash SHA256 cambiará, lo que indica que la imagen ya no es válida.

- **Funcionamiento básico**: Cuando se descarga una imagen usando docker image pull, Docker obtiene la imagen y todas sus capas desde el registro. Para cada capa, se calcula el hash SHA256 y se compara con el hash almacenado en el registro para asegurar que la capa no haya sido alterada durante la transferencia.

- **Seguridad y garantía de integridad**: Al usar SHA256, Docker garantiza que las imágenes no hayan sido modificadas de manera inadvertida o maliciosa durante su transferencia o almacenamiento. Esto proporciona una capa adicional de seguridad y garantiza que las imágenes que se utilizan son exactamente las mismas que fueron creadas y probadas.

# Subir imagenes
```bash
docker push
```
Se utiliza en Docker para subir (o "empujar") una imagen local a un registro de Docker, como Docker Hub. Este comando es útil cuando deseas compartir tus imágenes personalizadas con otros desarrolladores o equipos, o cuando necesitas almacenar tus imágenes en un registro remoto para su posterior uso en otros entornos.

## funcionamiento de docker push
- Subir una imagen: El comando docker push toma una imagen local y la carga en un registro remoto de Docker. Esto permite que la imagen esté disponible para otros usuarios que tengan acceso al mismo registro.

```bash
docker push nombre_de_la_imagen[:tag]
```

- `nombre_de_la_imagen`: Es el nombre de la imagen que deseas subir.

- `[:tag]`: Opcionalmente, puedes especificar un tag para la imagen que estás subiendo. Si no se especifica un tag, se subirá la versión por defecto (normalmente "latest").
  - **Ejemplo**
```bash
docker push usuario/nombre_de_la_imagen:latest
```
Este comando subiría la imagen local con el nombre nombre_de_la_imagen y el tag tag al registro de Docker Hub, bajo el usuario especificado.

## Utilidad de docker push

- Compartir imágenes: Esencialmente, docker push te permite compartir tus imágenes personalizadas con otros desarrolladores o equipos. Esto es útil cuando trabajas en un proyecto en equipo y necesitas que todos tengan acceso a la misma imagen.
  
- Despliegue en diferentes entornos: Al subir una imagen a un registro de Docker, puedes acceder a ella desde cualquier lugar donde tengas conexión a Internet. Esto es útil para desplegar la misma imagen en diferentes servidores o en la nube.

- Backup y almacenamiento: Almacenar tus imágenes en un registro remoto como Docker Hub también sirve como una forma de hacer backup de tus imágenes. Si pierdes tus imágenes locales, siempre puedes volver a descargarlas desde el registro.

### **Consideraciones importantes:**
- **Autenticación**: Para poder subir imágenes a un registro remoto, normalmente necesitas estar autenticado. En el caso de Docker Hub, debes iniciar sesión usando docker login antes de poder ejecutar docker push.
  
- **Nombre de la imagen**: El nombre de la imagen que subes debe seguir el formato **usuario/nombre_de_la_imagen:tag**. Esto es importante para organizar y compartir imágenes de manera efectiva en el registro.

# Inspeccionar imagenes
```bash
docker image inspect python
```
Se utiliza para obtener información detallada sobre una o varias imágenes. Al ejecutar este comando, Docker proporciona un JSON con una gran cantidad de detalles sobre la imagen, incluyendo metadatos, configuración, capas, variables de entorno, comandos, y más.

## **Funcionamiento**
- información detallada: Este comando proporciona una vista detallada de una o varias imágenes. Puedes inspeccionar una sola imagen o varias al mismo tiempo.
  - Este comando devolvería una salida JSON detallada con información sobre la imagen oficial de Ubuntu.

### **Información**

- **ID de la imagen**: El identificador único de la imagen.

- **Metadatos**: Fecha de creación, tamaño de la imagen, autor, etc.

- **Configuración**: Configuración de la imagen, como comandos de inicio, variables de entorno, directorio de trabajo, etc.

- **Capas**: Lista de todas las capas que componen la imagen, con su tamaño y hash SHA256.

- **Historial**: Historial de comandos y acciones que se ejecutaron para crear la imagen.

- **Variables de entorno**: Las variables de entorno definidas en la imagen.

- **Etiquetas**: Etiquetas de la imagen, como versión, nombre del autor, etc.

**Utilidad**

- **Diagnóstico y depuración**: Es útil para diagnosticar problemas o entender cómo se construyó una imagen. Puedes ver la configuración exacta, capas, comandos, y más.

- **Obtención de metadatos**: Si necesitas obtener información específica sobre una imagen, como su tamaño, autor, etiquetas, etc., docker image inspect te proporciona estos detalles.

- **Integración con scripts**: Puedes usar la salida JSON de docker image inspect en scripts o herramientas para automatizar tareas relacionadas con imágenes.

### Ejemplo de salida
La salida de docker image inspect es un JSON extenso que puede ser difícil de leer en su totalidad. Aquí hay un ejemplo simplificado:
```json
[
    {
        "Id": "sha256:12345...",
        "RepoTags": ["ubuntu:latest"],
        "Config": {
            "Cmd": ["bash"],
            "Entrypoint": null,
            "Env": ["PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"]
        },
        "Layers": ["sha256:67890...", "sha256:54321...", ...],
        "Size": 123456789,
        "Os": "linux",
        ...
    }
]
```

# Listar Imagenes Descargadas
```bash
docker image ls
```
```bash
REPOSITORY   TAG       IMAGE ID       CREATED       SIZE
node         latest    c3978d05bc68   8 days ago    1.1GB
python       latest    ae29c48b7429   6 weeks ago   1.02GB
```

# Eliminar una Imagen
```bash
docker image rm python
```

# Buscar una Imagen en Docker Hub
```bash
docker search nombre_de_la_imagen

# ejemplo:
docker search nginx
```

# Construir una Imagen
Construye una nueva imagen a partir de un archivo `Dockerfile` en el directorio actual.

```bash
docker image build -t nombre_de_la_imagen

# ejemplo:
docker image build -t my_app
```

# Cambiar el nombre de una Imagen
```bash
docker image tag nombre_actual nuevo_nombre

# ejemplo:
docker image ubuntu:latest myubuntu:latest
```

# Mostrar Historial de una Imagen
Muestra el historial de una imagen, incluyendo los comandos utilizados para construir la imagen.
```bash
docker image history nombre_de_la_imagen

# ejemplo
docker image history ubuntu
```

# Eliminar Todas las Imagenes
Elimina todas las imágenes que no están asociadas a ningún contenedor.
```bash
docker image prune
```

# Guardar una Imagen
Guarda una imagen en un archivo `tar` para poder transferirla o importarla en otro sistema.
```bash
docker image save -o nombre_de_archivo.tar nombre_de_la_imagen

# ejemplo:
docker image save -o mi_aplicacion.tar mi_aplicacion
```