# Dockerfile
Un Dockerfile es un archivo de texto que contiene una serie de instrucciones para construir una imagen Docker personalizada. Es el corazón de la construcción de imágenes en Docker, permitiendo automatizar y estandarizar el proceso de creación de imágenes para aplicaciones y servicios.

El Dockerfile define el entorno y los pasos necesarios para construir una imagen Docker. Incluye instrucciones para instalar paquetes, copiar archivos, configurar variables de entorno y definir el comportamiento predeterminado del contenedor cuando se ejecuta.

### Estructura
El Dockerfile sigue una estructura de instrucciones específicas, cada una de las cuales tiene un propósito particular. 

1. `FROM` Define la imagen base a partir de la cual se construye la nueva imagen
```bash
FROM python:3.9
```

1. `RUN` Ejecuta comandos en el contenedor durante el proceso de construcción. Se usa para instalar paquetes y realizar configuraciones.

```bash
RUN pip install --no-cache-dir -r requirements.txt
```

1. `COPY` Copia archivos y directorios desde el **host** al sistema de archivos.

```bash
COPY . /app
```

1. `ADD` Similar a `COPY`, pero también puede extraer archivos de archivos **tar** y descargar archivos desde URLs.

```bash
ADD https://example.com/file.tar.gz /app/
```

1. `WORKDIR` Define el directorio de trabajo para las siguientes instrucciones `RUN`, `CMD`, `ENTRYPOINT`, `COPY` y `ADD`.

```bash
WORKDIR /app
```

1. `CMD` Define el comando que se ejecutará por defecto cuando se inicie un contenedor a partir de la imagen. **Solo puede haber una instrucción CMD en un Dockerfile**.

```bash
CMD ["python", "app.py"]
```

1. `ENTRYPOINT` Define el comando que se ejecutará como el proceso principal del contenedor. Puede ser combinado con `CMD` para proporcionar argumentos predeterminados.

```bash
ENTRYPOINT ["python"]
CMD ["app.py"]
```

1. `ENV` Establece variables de entorno en el contenedor.

```bash
ENV APP_ENV=production
```

1. `EXPOSE` Documenta qué puertos serán expuestos por el contenedor. No publica puertos, solo sirve como documentación.

```bash
EXPOSE 80
```

2.  `VOLUME`:

    * Crea un punto de montaje para un volumen en el contenedor.

    ```bash
    VOLUME ["/data"]
    ```

3.  `USER` Define el usuario que se utilizará para ejecutar el contenedor.

```bash
USER appuser
```

1.  `ARG` Define variables que se pueden usar durante la construcción de la imagen y que pueden ser reemplazadas en tiempo de construcción.

```bash
ARG APP_VERSION=1.0
```

1.  `LABEL` Añade metadatos a la imagen en forma de pares clave-valor.
    
```bash
LABEL maintainer="example@example.com"
```

## Ejemplo
```Dockerfile
# Utilizar una imagen base oficial de Python
FROM python:3.9

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo de requisitos y el código fuente al contenedor
COPY requirements.txt /app/
COPY . /app/

# Instalar las dependencias de la aplicación
RUN pip install --no-cache-dir -r requirements.txt

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 5000

# Definir la variable de entorno
ENV FLASK_APP=app.py

# Establecer el comando predeterminado para ejecutar la aplicación
CMD ["flask", "run", "--host=0.0.0.0"]
```
* **Construcción de la Imagen**
```bash
docker build -t mi_imagen .
```

## ENTRYPOINT
En Docker, el ENTRYPOINT es una instrucción en un Dockerfile que define el comando que se ejecutará como el proceso principal cuando se inicie un contenedor a partir de una imagen. Es fundamental para establecer el comportamiento predeterminado del contenedor y asegurarse de que el contenedor ejecute un comando específico al iniciarse.

**Propósito**: Define el comando principal del contenedor. Cuando se inicia un contenedor, el ENTRYPOINT se ejecuta como el proceso **PID 1** dentro del contenedor, que es el proceso principal y el que debe mantenerse en ejecución para que el contenedor esté activo.

**Comportamiento**: ENTRYPOINT se configura para asegurar que un comando o script específico se ejecute cuando se inicie el contenedor. Esto es útil para aplicaciones que deben ejecutarse continuamente, como servidores web o bases de datos.

### Estructura de ENTRYPOINT
El ENTRYPOINT puede ser especificado en dos formas diferentes: forma de exec y forma de shell.

1. **Forma de Exec**

La forma de exec es la forma recomendada y más segura. En esta forma, ENTRYPOINT recibe una lista JSON de argumentos, que se pasan directamente al proceso sin pasar por el shell. Esto evita problemas relacionados con el procesamiento de comandos por el shell.

Sintaxis:
```Dockerfile
ENTRYPOINT ["executable", "param1", "param2"]
```
Ejemplo

```Dockerfile
ENTRYPOINT ["python", "app.py"]
```
En este ejemplo:

* `python` es el comando que se ejecutará.
* `app.py` es el argumento que se pasará al comando python.

2.  Forma de Shell

En la forma de shell, ENTRYPOINT se especifica como una cadena de texto que se ejecuta en un shell (`/bin/sh -c`), lo que permite utilizar características del shell como tuberías y redirecciones. Sin embargo, esta forma es menos recomendada porque el comando se ejecuta a través del shell, lo que puede afectar el manejo de señales y la forma en que se ejecuta el proceso.

Sintaxis
```Dockerfile
ENTRYPOINT executable param1 param2
```
Ejemplo
```Dockerfile
ENTRYPOINT python app.py
```

**Combinación con CMD**
* ENTRYPOINT define el comando principal del contenedor.

* CMD proporciona argumentos predeterminados al comando definido en ENTRYPOINT.
Si ambos están presentes en el Dockerfile, ENTRYPOINT se ejecutará con los argumentos proporcionados por CMD.

Ejemplo
```Dockerfile
ENTRYPOINT ["python"]
CMD ["app.py"]
```
En este caso:

* ENTRYPOINT especifica que python es el comando principal.

* CMD proporciona `app.py` como argumento al comando python.

Esto significa que cuando el contenedor se inicia, el comando completo que se ejecutará será `python app.py`.


## Registrar Imagen
Registrar una imagen en Docker Hub implica varios pasos, desde construir la imagen en tu máquina local hasta subirla a tu repositorio en Docker Hub.

* Subir imagen
```bash
docker push nombre_usuario/nombre_imagen:tag
```

Ejemplo
```bash
docker push myusername/myapp:latest
```

## Docker Tag
Para asignar una etiqueta (tag) a una imagen Docker, utilizas el comando docker tag. Las etiquetas son útiles para versionar imágenes y para organizar y identificar las imágenes en un registro de Docker, como Docker Hub.

```bash
docker tag [ID_IMAGEN_O_NOMBRE] [NOMBRE_IMAGEN:ETIQUETA]
```
* `ID_IMAGEN_O_NOMBRE`: El ID de la imagen o el nombre de la imagen con la etiqueta actual.

* `NOMBRE_IMAGEN:ETIQUETA`: El nombre de la imagen y la etiqueta que deseas asignar.

**Ejemplo**

```bash
docker tag abc123 mi_imagen:v1.0
```