## Postman API
Newman puede ejecutarse junto con la Postman API para obtener colecciones, entornos y otros recursos de Postman de manera dinámica sin necesidad de exportarlos manualmente. Esto facilita la integración continua y la automatización de pruebas en tiempo real, ya que puedes gestionar y ejecutar colecciones directamente desde la API de Postman.

### ¿Qué es la API de Postman?
La Postman API es una interfaz RESTful que permite a los usuarios interactuar con el entorno de Postman de manera programática. A través de la API, puedes gestionar tus colecciones, entornos, workspaces, y otros recursos. Utilizando la API junto con Newman, puedes descargar colecciones directamente desde tu espacio de trabajo en Postman y ejecutarlas sin tener que exportarlas manualmente.

### Casos de uso de Newman con la API de Postman
1. **Ejecución automatizada de colecciones**: En lugar de exportar manualmente una colección de Postman y ejecutarla con Newman, puedes utilizar la API de Postman para descargar la colección y luego ejecutarla en un pipeline de CI/CD.

2. **Integración en pipelines CI/CD**: Newman puede integrar automáticamente las últimas versiones de las colecciones almacenadas en Postman usando la API, garantizando que siempre se estén ejecutando las pruebas más recientes.

3. **Uso dinámico de entornos**: Similar al punto anterior, también puedes obtener los entornos directamente desde la API de Postman y usarlos en Newman para automatizar las pruebas en diferentes escenarios.

### Cómo usar Newman con la API de Postman
1. **Paso 1: Obtener la API Key de Postman**: Para acceder a la Postman API, necesitas una API Key:

   * Inicia sesión en tu cuenta de Postman.

   * Dirígete a la sección de "Account Settings".

   * En el menú lateral, selecciona API Keys y genera una nueva clave de API.

   * Guarda la clave de API en un lugar seguro, ya que la utilizarás en las solicitudes para interactuar con la API de Postman.

2. **Paso 2: Obtener la colección de Postman usando la API**

   * Puedes obtener cualquier colección almacenada en tu cuenta de Postman utilizando la Postman API. A continuación, se muestra cómo hacer esto desde la línea de comandos utilizando curl o desde cualquier cliente de API.

   * Obtener una colección: La API de Postman ofrece un endpoint para obtener una colección específica utilizando su ID.

      ```bash
      curl --location --request GET "https://api.getpostman.com/collections/{{collection_uid}}" \
      --header "X-Api-Key: {{postman_api_key}}"
      ```
      Este comando devuelve el contenido de la colección en formato JSON. El collection_uid es el identificador único de la colección que deseas ejecutar, y el postman_api_key es tu clave de API.

3. **Paso 3: Ejecutar la colección en Newman**

   * Una vez que obtengas la colección de la API de Postman, puedes usarla directamente en Newman para ejecutarla. Aquí tienes dos formas de hacerlo: ejecutarla directamente desde la URL de la colección o guardarla localmente y luego ejecutarla.

   * **Opción 1: Ejecutar directamente desde la URL de la API**: Newman te permite ejecutar una colección desde una URL, como la de la API de Postman. Solo necesitas especificar la URL donde resides la colección y tu clave de API:

      ```bash
      newman run https://api.getpostman.com/collections/{{collection_uid}}?apikey={{postman_api_key}}
      ```
      Este comando le indicará a Newman que descargue la colección desde Postman y la ejecute directamente.

   * **Opción 2: Guardar la colección localmente y ejecutarla**: Otra opción es descargar la colección y guardarla en un archivo JSON. Una vez que la tengas guardada, puedes ejecutarla con Newman como lo harías normalmente:

      ```bash
      curl --location --request GET "https://api.getpostman.com/collections/{{collection_uid}}" \
      --header "X-Api-Key: {{postman_api_key}}" > collection.json

      newman run collection.json
      ```

   * **Paso 4: Obtener y usar variables de entorno desde la API**: Si tu colección usa variables de entorno, también puedes obtener el archivo de entorno directamente desde la API de Postman.

      **Obtener el entorno**
      ```bash
      curl --location --request GET "https://api.getpostman.com/environments/{{environment_uid}}" \
      --header "X-Api-Key: {{postman_api_key}}"
      ```
      Este comando descargará el entorno en formato JSON. Para ejecutarlo en Newman, puedes guardarlo en un archivo y luego usarlo en la ejecución.

* Ejecutar Newman con un archivo de entorno

    ```bash
    newman run collection.json -e environment.json
    ```
    O puedes ejecutar Newman directamente desde la URL del entorno de Postman:
    ```bash
    newman run https://api.getpostman.com/collections/{{collection_uid}}?apikey={{postman_api_key}} \
-e https://api.getpostman.com/environments/{{environment_uid}}?apikey={{postman_api_key}}
    ```