## Variables de entorno
Son una característica importante que facilita la configuración y ejecución de solicitudes de API en diferentes entornos, como **desarrollo**, **pruebas** y **producción**.

Son valores dinámicos que se pueden utilizar en las solicitudes y scripts dentro de una colección. Permiten definir valores una vez y usarlos en múltiples solicitudes dentro de una colección.

Son útiles para mantener valores que pueden cambiar según el entorno, como URLs de API, claves de autenticación, tokens de acceso, entre otros.

## Características y Funcionalidades:

- **Scope (Ámbito)**: Las variables de entorno tienen un ámbito específico en el que están disponibles:

  - **Global**: Se pueden acceder desde cualquier parte de Postman.
  
  - **Colección**: Están disponibles solo dentro de la colección en la que se definen.
  
  - **Entorno (Environment)**: Están disponibles solo en el entorno (environment) en el que se definen.

## Definición y Uso:

- Se definen en el administrador de variables de Postman y se utilizan en las **solicitudes**, **pre-scripts** y **post-scripts**.

- Las variables se pueden utilizar en cualquier lugar donde se use la sintaxis `{{nombre_de_variable}}`.

## Modificación Dinámica:

- Las variables de entorno pueden ser modificadas dinámicamente durante la ejecución de las pruebas, lo que facilita la automatización y la flexibilidad.

## Ejemplo de Uso de Variables de Entorno:

Supongamos que estamos trabajando con una API de ejemplo con diferentes URLs para los entornos de desarrollo y producción:

- **Variables de Entorno**:

  - base_url: https://api.example.com (en entorno de producción)
  - base_url: https://dev.api.example.com (en entorno de desarrollo)

- **Solicitudes en una Colección**:

  - **GET `{{base_url}}/usuarios`**: Esta solicitud utilizará la variable base_url correspondiente al entorno actual.
  
  - **POST `{{base_url}}/usuarios`**: Esta solicitud también utilizará la variable base_url para la URL de la API.