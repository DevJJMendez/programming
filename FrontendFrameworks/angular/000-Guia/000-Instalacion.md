# ¿Qué es Angular?

Angular es un framework de desarrollo para construir aplicaciones web de una sola página (SPA). Fue desarrollado por Google y se utiliza para crear aplicaciones web dinámicas y escalables. Angular ofrece un conjunto de herramientas y bibliotecas que facilitan el desarrollo de aplicaciones complejas.

# Instalación

Para instalar Angular, necesitarás Node.js y NPM (Node Package Manager) instalados en tu sistema.

- Instalar Angular CLI (Command Line Interface):

  Abre tu terminal o línea de comandos.
  Ejecuta el siguiente comando para instalar Angular CLI de forma **global** en tu sistema:

  ```bash
  npm install -g @angular/cli
  ```

  - Instalar una version especifica:
    ```bash
      npm install -g @angular/cli@11.0.0
    ```
  - Instalar en un proyecto local:

    - Inicializa un nuevo proyecto con npm:

      Ejecuta el siguiente comando para inicializar un nuevo proyecto npm en tu directorio:

      ```bash
        npm init -y
      ```

    - Instala Angular CLI como una dependencia de desarrollo:

      Ejecuta el siguiente comando para instalar Angular CLI como una dependencia de desarrollo en tu proyecto:

      ```bash
        npm install --save-dev @angular/cli
      ```

    - Verifica la instalación de Angular CLI:

      Puedes verificar que Angular CLI se haya instalado correctamente ejecutando el siguiente comando:

      ```bash
        npx ng --version
      ```

      El comando` npx ng` te permite ejecutar Angular CLI sin necesidad de instalarlo globalmente.

- Verificar la instalación:

  Puedes verificar que Angular CLI se ha instalado correctamente ejecutando el siguiente comando:

  ```bash
  ng --version
  ```

# Creacion de un proyecto

```bash
ng new nombre-del-proyecto
```

- Inicia el servidor de desarrollo:

Puedes iniciar un servidor de desarrollo para tu proyecto con el siguiente comando:

```bash
ng serve
```
