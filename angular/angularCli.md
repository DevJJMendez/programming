## Angular CLI Commands
Angular CLI es una herramienta poderosa para generar, construir y administrar proyectos Angular de manera eficiente.

1. `ng new`: Crea un nuevo proyecto Angular.

    ```bash
    ng new <project-name>
    ```
    **Opciones**:
    * `--directory` o `-d`: Especifica el directorio donde se creará el proyecto.
    
    * `--style`: Establece el preprocesador CSS (por defecto es CSS). Opciones: **css**, **scss**, **sass**, **less**.
    
    * `--routing`: Añade un archivo de enrutamiento.
    
    * `--skip-tests`: No genera archivos de pruebas.
    
    * `--strict`: Habilita el modo estricto para TypeScript.
    
    * `--standalone`: Crea el proyecto con componentes standalone (a partir de Angular 17).

2. `ng serve`: Inicia un servidor de desarrollo que recarga automáticamente la aplicación cuando hay cambios en los archivos.

      ```bash
      ng serve
      ```
      **Opciones**
      * `--port`: Especifica el puerto (por defecto es 4200).

      * `--host`: Especifica la dirección del host.

      * `--open` o `-o`: Abre automáticamente el navegador.

      * `--ssl`: Sirve la aplicación a través de HTTPS.

3. `ng build`: Compila el proyecto para producción y crea los archivos en la carpeta `dist/`.

      ```bash
      ng build
      ```
      **Opciones**

      * `--prod`: Realiza una compilación optimizada para producción (alias de --configuration=production).

      * `--configuration`: Establece una configuración específica (por defecto: production, development).

      * `--base-href`: Establece la URL base para todas las rutas de la aplicación.

      * `--aot`: Compilación ahead-of-time (precompilación).

      * `--output-path`: Especifica el directorio donde se guardarán los archivos de salida.

4. `ng test`: Ejecuta las pruebas unitarias utilizando Karma como motor de pruebas.

      ```ts
      ng test
      ```
      **Opciones**
      * `--watch`: Vuelve a ejecutar las pruebas cuando cambian los archivos.

      * `--browsers`: Define el navegador a usar (por ejemplo, Chrome, Firefox).

      * `--code-coverage`: Genera un informe de cobertura de código.

5. `ng generate` (o `ng g`): Genera nuevos elementos como **componentes**, **servicios**, **módulos**, etc.

      ```bash
      ng generate <schematic> <name>
      ```
      **Elementos comunes a generar**
      * **component**: `ng generate component <name>`

      * **module**: `ng generate module <name>`

      * **service**: `ng generate service <name>`

      * **directive**: `ng generate directive <name>`

      * **pipe**: `ng generate pipe <name>`

      **Opciones**
      * `--dry-run`: Simula el comando sin realizar ningún cambio.

      * `--skip-import`: No añade la declaración del componente en el módulo.

      * `--inline-style`: Incluir el CSS directamente en el archivo `.ts`.

      * `--inline-template`: Incluir la plantilla HTML directamente en el archivo `.ts`.

6. `ng add`: Añade y configura bibliotecas de terceros en tu proyecto (como **Angular Material**, **PWA**, etc.).

      ```bash
      ng add <package>

      ng add @angular/material
      ```

7. `ng update`: Actualiza las dependencias del proyecto a versiones más recientes de Angular o bibliotecas de terceros.

      ```bash
      ng update <package>
      ```
      **Opciones**
      * `--all`: Actualiza todas las dependencias a sus versiones más recientes.

      * `--force`: Fuerza la actualización incluso si hay conflictos.

      * `--from`: Especifica la versión de la que estás actualizando.

      * `--to`: Especifica la versión a la que deseas actualizar.

8. `ng lint`: Ejecuta el linter (generalmente ESLint) para verificar la calidad del código.

      ```bash
      ng lint
      ```
      **Opciones**
      * `--fix`: Corrige automaticamente los problemas detectados por el linter.

9. `ng e2e`: Ejecuta pruebas end-to-end (E2E) utilizando una herramienta como **Protractor** o **Cypress**.

      ```ts
      ng e2e
      ```
      **Opciones**
      * `--prod`: Ejecuta las pruebas en un entorno de producción.

      * `--dev-server-target`: Define el servidor que se usará para las pruebas.

10. `ng doc`: Abre la documentación oficial de Angular en el navegador.

      ```bash
      ng doc <keyword>

      ng doc component
      ```

11. `ng xi18n`: Extrae el contenido que se puede traducir (i18n) de la aplicación a un archivo de mensajes.

      ```bash
      ng xi18n
      ```
      **Opciones**
      * `--output-path`: Establece el directorio donde se guardará el archivo de salida de i18n.

      * `--format`: Define el formato del archivo de traducción (xlf, xlf2, xliff, etc.).

12. `ng version`: Muestra la versión de Angular CLI y Angular que está siendo utilizada en el proyecto.

      ```bash
      ng version
      ```

13. `ng config`: Gestiona las configuraciones de Angular CLI, que se guardan en el archivo `angular.json`.

      ```bash
      ng config <key> <value>

      ng config cli.defaultCollection @angular/material
      ```

14. `ng analytics`: Gestiona el uso de la analítica para Angular CLI.

      ```bash
      ng analytics <on|off|prompt|ci|info>
      ```
      * `ng analytics on`: Habilita la recolección de datos de uso.

      * `ng analytics off`: Deshabilita la recolección de datos de uso.

15. `ng deploy`: Despliega la aplicación en una plataforma de hosting.

      ```bash
      ng deploy
      ```
      Este comando depende de la configuración de una plataforma de despliegue, como Firebase o Netlify.

16. `ng extract-i18n`: Extrae las cadenas traducibles de tu aplicación Angular a un archivo de mensajes.

      ```bash
      ng extract-i18n
      ```

17. `ng cache`: Gestiona el sistema de caché para la Angular CLI.

      ```bash
      ng cache <action>
      ```
      **Opciones:**
      * `ng cache enable`: Habilita el sistema de caché.

      * `ng cache disable`: Deshabilita el sistema de caché.

      * `ng cache clean`: Limpia la caché.