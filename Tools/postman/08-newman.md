## Newman
Newman es una herramienta de línea de comandos que permite ejecutar colecciones de Postman fuera del entorno gráfico de la aplicación, facilitando la automatización de pruebas de API y la integración continua (CI/CD). Es especialmente útil para equipos que desean automatizar sus flujos de pruebas API, ejecutar las colecciones como parte de un pipeline de integración continua, o ejecutar pruebas en entornos sin interfaz gráfica, como servidores o contenedores Docker.

### Características principales de Newman
1. **Ejecución de colecciones de Postman:**

   * Newman puede ejecutar cualquier colección exportada desde Postman, así como las variables de entorno y archivos de datos asociados. Esto te permite ejecutar tus pruebas API de forma automatizada desde un script o pipeline CI/CD.

2. **Soporte para informes detallados:**

   * Después de ejecutar una colección, Newman genera informes detallados que incluyen los resultados de cada solicitud, como el estado, los encabezados, el cuerpo de respuesta, el código de estado HTTP, y cualquier validación o prueba definida en la colección.

   * También soporta la generación de informes en varios formatos como JSON, HTML, JUnit, entre otros, lo que facilita la integración con herramientas de monitoreo o dashboards.

3. **Integración con CI/CD:**

   * Newman se puede integrar fácilmente en pipelines de CI/CD, permitiendo ejecutar pruebas API automáticas en cada fase del ciclo de desarrollo (por ejemplo, Jenkins, GitLab CI, Travis CI, CircleCI).

   * Esto ayuda a asegurar que las APIs están funcionando correctamente después de cada cambio en el código o despliegue.

4. **Compatibilidad con variables de entorno y datos:**

   * Al igual que Postman, Newman permite usar variables de entorno y archivos de datos para realizar pruebas dinámicas, como ejecutar la misma colección con diferentes valores de entrada.

5. **Extensible y personalizable:**

   * Newman ofrece opciones de personalización, como especificar el número de iteraciones, la salida de registros en formatos personalizados, y la ejecución de scripts en puntos específicos.

   * También es posible personalizar el comportamiento de la ejecución de las colecciones a través de parámetros adicionales en la línea de comandos.

### ¿Cómo instalar Newman?
Newman se instala fácilmente utilizando el gestor de paquetes de Node.js (npm). A continuación, se detallan los pasos:

```bash
npm install -g newman
```
Esto instalará Newman globalmente en tu sistema, lo que te permitirá usar el comando newman desde cualquier ubicación.

### ¿Cómo ejecutar una colección con Newman?
Una vez que hayas instalado Newman, puedes ejecutar colecciones de Postman de la siguiente manera:

1. **Exporta una colección desde Postman.**

   * En Postman, selecciona la colección que deseas exportar y haz clic en "Exportar". Esto generará un archivo JSON con los detalles de la colección.

2. **Ejecuta la colección usando Newman con el siguiente comando:**

    ```bash
    newman run path/to/collection.json
    ```
    Donde `path/to/collection.json` es la ruta al archivo JSON exportado de la colección.

### Opciones comunes en Newman
* **Especificar un archivo de entorno**: Si deseas ejecutar una colección con un archivo de variables de entorno, puedes agregar el parámetro `-e`:

    ```bash
    newman run path/to/collection.json -e path/to/environment.json
    ```

* **Iterar sobre una colección varias veces**: Para ejecutar una colección varias veces (por ejemplo, para pruebas de carga), puedes usar el parámetro `--iteration-count`:

    ```bash
    newman run path/to/collection.json --iteration-count 5
    ```

* **Especificar un archivo de datos**: Si tienes un archivo de datos con varias filas de valores de entrada para tus pruebas, puedes especificarlo con el parámetro `-d`:

    ```bash
    newman run path/to/collection.json -d path/to/data.json
    ```

* **Generar informes en HTML**: Newman también soporta la generación de informes en formato HTML con la opción `--reporters`:

    ```bash
    newman run path/to/collection.json --reporters cli,html --reporter-html-export path/to/report.html
    ```