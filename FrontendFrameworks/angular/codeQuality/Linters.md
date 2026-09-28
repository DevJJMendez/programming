## Modo Estricto de Angular
El Modo Estricto de Angular es una configuración opcional que se introdujo a partir de Angular 10, diseñada para mejorar la calidad y consistencia del código en los proyectos de Angular. Al habilitar el modo estricto, se activan un conjunto de ajustes y configuraciones adicionales tanto en TypeScript como en el propio framework de Angular, lo que ayuda a prevenir errores comunes y a fomentar mejores prácticas de desarrollo.

### Beneficios del Modo Estricto:
1. **Detección temprana de errores**: Al ser más estricto con las reglas de TypeScript y Angular, el modo estricto ayuda a identificar posibles problemas en el código antes de tiempo.

2. **Mejoras en el rendimiento**: El código que cumple con las reglas del modo estricto tiende a ser más predecible y optimizable.

3. **Mayor consistencia**: Fomenta el uso de patrones y prácticas recomendadas en el desarrollo con Angular, lo que puede resultar en un código más consistente y fácil de mantener.

4. **Mejora en la seguridad**: Al ser más riguroso con los tipos y las asunciones en el código, se reduce la posibilidad de errores que puedan llevar a vulnerabilidades o comportamientos inesperados.

### ¿Qué incluye el Modo Estricto?
El modo estricto incluye varias configuraciones que afectan tanto a Angular como a TypeScript:

1. **Strict Mode de TypeScript**: Activa el modo estricto de TypeScript (strict), que incluye:

   * `noImplicitAny`: Prohíbe el uso implícito del tipo any.

   * `strictNullChecks`: Hace que los valores null y undefined se traten de manera más rigurosa.

   * `strictFunctionTypes`: Refuerza las reglas de tipado para funciones.

   * `strictPropertyInitialization`: Obliga a inicializar las propiedades en las clases antes de su uso.

   * Otros ajustes adicionales de TypeScript.

2. **Requerimientos adicionales en el código de Angular**:

   * Checks estrictos de templates: Verifica con mayor precisión los tipos utilizados en las plantillas Angular.

   * Strict Input Checking: Obliga a que los `@Input` de los componentes sean verificados con tipos más estrictos.

   * Consistencia en las inyecciones: Exige que las dependencias inyectadas sean tipadas con mayor precisión.
## Linters
Un Linter es una herramienta que analiza el código fuente para encontrar errores de programación, errores de estilo, convenciones no seguidas, y otros problemas potenciales. Los Linters son especialmente útiles en el desarrollo de software porque ayudan a mantener un código limpio, consistente y libre de errores comunes.

### Beneficios de usar un Linter:
1. **Consistencia**: Asegura que todo el equipo siga las mismas reglas de estilo de código, lo que facilita la lectura y el mantenimiento.

2. **Detección temprana de errores**: Ayuda a encontrar errores potenciales antes de que se conviertan en problemas más grandes.

3. **Mejora de la calidad del código**: Promueve las mejores prácticas de codificación y puede ayudar a identificar partes del código que pueden ser refactorizadas.

4. **Ahorro de tiempo**: Automatiza la revisión del estilo de código, permitiendo a los desarrolladores concentrarse en problemas más complejos.

### Ejemplos de Linters comunes:
* **ESLint**: Muy popular en el ecosistema de JavaScript/TypeScript, incluido Angular.

* **TSLint**: Era el Linter específico para TypeScript, pero ha sido descontinuado en favor de ESLint.

* **Stylelint**: Para la revisión de estilos CSS.

## ESLint
ESLint es una herramienta de análisis estático que ayuda a identificar patrones problemáticos en el código JavaScript y TypeScript, y también puede aplicarse a otros lenguajes basados en el ecosistema de JavaScript. ESLint es altamente configurable, lo que te permite ajustar las reglas de acuerdo con las necesidades de tu proyecto.

### Características principales de ESLint:
* **Reglas configurables**: Puedes habilitar o deshabilitar reglas específicas y establecer su severidad (error, advertencia, etc.).

* **Extensible**: Puedes usar configuraciones predefinidas, como las que ofrecen los estándares de codificación de Airbnb, Google, o las recomendaciones de ESLint.

* **Integración con editores**: Se puede integrar fácilmente con editores de texto como VS Code, permitiendo la detección de problemas en tiempo real.

* **Soporte para TypeScript**: Mediante el uso de plugins, ESLint puede analizar código TypeScript.

* **Autocorrección**: ESLint puede intentar corregir automáticamente algunos de los problemas encontrados.

### Instalación y configuración de ESLint en un proyecto Angular
1. **Instalación de ESLint y plugins necesarios**: Primero, si no lo tienes ya, debes instalar ESLint y el plugin de ESLint para Angular. Sigue estos pasos:

    ```bash
    ng add @angular-eslint/schematics
    ```
    Este comando instalará todo lo necesario para integrar ESLint con Angular, incluyendo las dependencias y los esquemas de configuración iniciales.

2. **Configuración de ESLint**: Después de la instalación, debes tener un archivo `.eslintrc.json` en la raíz de tu proyecto. Este archivo contiene la configuración de ESLint. Un archivo típico puede verse así:

    ```json
    {
      "root": true,
      "ignorePatterns": ["projects/**/*"],
      "overrides": [
        {
          "files": ["*.ts"],
          "extends": [
            "plugin:@angular-eslint/recommended",
            "plugin:@typescript-eslint/recommended",
            "plugin:@typescript-eslint/recommended-requiring-type-checking"
          ],
          "parserOptions": {
            "project": ["tsconfig.json"],
            "createDefaultProgram": true
          },
          "rules": {
            "@typescript-eslint/no-unused-vars": ["error", { "argsIgnorePattern": "^_" }],
            "@typescript-eslint/explicit-function-return-type": "off",
            "@typescript-eslint/no-floating-promises": "error"
          }
        },
        {
          "files": ["*.html"],
          "extends": ["plugin:@angular-eslint/template/recommended"],
          "rules": {
            "@angular-eslint/template/no-negated-async": "error"
          }
        }
      ]
    }
    ```

3. **Personalización de reglas**: Puedes personalizar las reglas de ESLint para que se ajusten mejor a tu equipo o proyecto. Por ejemplo, si quieres que ESLint arroje un error cuando encuentre variables no usadas, puedes añadir la siguiente regla:

    ```json
    "rules": {
      "@typescript-eslint/no-unused-vars": "error"
    }
    ```
    Si prefieres que sea solo una advertencia, puedes cambiar "error" por "warn".

4. **Integración con Prettier**: Si también usas Prettier para el formateo del código, puedes integrar ambas herramientas para evitar conflictos. Para ello, instala los siguientes paquetes:

    ```bash
    npm install --save-dev eslint-config-prettier eslint-plugin-prettier
    ```
    Y luego ajusta tu `.eslintrc.json` para incluir Prettier:

    ```json
    "extends": [
      "plugin:@angular-eslint/recommended",
      "plugin:prettier/recommended"
    ],
    "rules": {
      "prettier/prettier": "error"
    }
    ```
    Esto asegura que el código siga las reglas de estilo de Prettier y que ESLint no entre en conflicto con ellas.

5. **Ejecución de ESLint**: Para ejecutar ESLint y verificar tu código, usa el siguiente comando:

    ```bash
    ng lint
    ```
    Esto analizará tu código en busca de problemas según las reglas configuradas.

6. **Autocorrección de errores**: Puedes intentar corregir automáticamente algunos de los errores encontrados con:

    ```bash
    ng lint --fix
    ```

### TSLint to ESLint

```bash
ng g @angular-eslint/schematics:convert-tslint-to-eslint project-name
```
El comando `ng g @angular-eslint/schematics:convert-tslint-to-eslint` es utilizado para migrar un proyecto Angular que originalmente utilizaba **TSLint** como herramienta de análisis estático a **ESLint**, que es la opción recomendada desde Angular 10 en adelante. Dado que TSLint fue descontinuado en favor de ESLint, esta migración es importante para mantener el soporte y aprovechar las nuevas características de ESLint.

El comando ejecuta un esquema de Angular que realiza varias tareas de migración automatizadas, incluyendo:

1. **Instalación de dependencias**:

   * Elimina TSLint y sus dependencias.

   * Instala ESLint y todos los plugins necesarios para integrarlo con Angular y TypeScript, como @typescript-eslint.

2. **Conversión de configuración**:

   * Convierte la configuración de `tslint.json` a un nuevo archivo de configuración `.eslintrc.json` con reglas equivalentes en ESLint.

   * Migra las reglas específicas de Angular y TypeScript, respetando las configuraciones personalizadas que pudieras tener en TSLint.

3. **Actualización del archivo `angular.json`**:

   * Modifica la configuración de la CLI de Angular para usar ESLint en lugar de TSLint para las tareas de linting (ng lint).

4. **Compatibilidad y ajustes**:

   * Ajusta el código para asegurar la compatibilidad con ESLint. Esto incluye posibles modificaciones en los comentarios de supresión de errores (`// tslint:disable-next-line` a // `eslint-disable-next-line`).

## .prettierrc
El archivo .prettierrc es un archivo de configuración para Prettier, una herramienta de formateo de código que aplica un conjunto coherente de reglas de estilo de código a tus archivos, asegurando que todo el código siga un formato uniforme. Prettier es conocido por su capacidad de "opinionated formatting", lo que significa que toma decisiones automáticas sobre el formato del código para que los desarrolladores no tengan que preocuparse por detalles menores de estilo.

### Formatos de .prettierrc
El archivo .prettierrc puede estar en varios formatos, incluyendo:

* **JSON** (`.prettierrc` o `.prettierrc.json`)

* **YAML** (`.prettierrc.yaml` o `.prettierrc.yml`)

* **JavaScript** (`.prettierrc.js`)

* **TOML** (`.prettierrc.toml`)

### Ejemplo de configuración en .prettierrc
A continuación, se presenta un ejemplo típico de configuración en formato JSON:

```json
{
  "printWidth": 80,
  "tabWidth": 2,
  "useTabs": false,
  "semi": true,
  "singleQuote": true,
  "trailingComma": "es5",
  "bracketSpacing": true,
  "arrowParens": "avoid",
  "endOfLine": "lf"
}
```
**Explicación de las opciones más comunes:**

* **printWidth**: Especifica la longitud máxima de una línea de código. Si el código excede esta longitud, Prettier lo dividirá en varias líneas. El valor por defecto es 80 caracteres.

* **tabWidth**: Define el número de espacios por tabulación. Por defecto, son 2 espacios.

* **useTabs**: Indica si se deben usar tabulaciones (true) o espacios (false). Por defecto, Prettier usa espacios.

* **semi**: Determina si se deben usar punto y coma al final de cada declaración (true) o no (false). El valor por defecto es true.

* **singleQuote**: Define si Prettier debe usar comillas simples (true) en lugar de comillas dobles (false). El valor por defecto es false.

* **trailingComma**: Establece si se deben añadir comas al final de objetos, arreglos y parámetros de funciones en las situaciones siguientes:

* **"none"**: No se agregan comas finales.

* **"es5**": Se añaden comas finales donde sea válido en ES5 (por ejemplo, en objetos y arreglos).

* **"all"**: Se añaden comas finales en todas partes donde es posible (incluyendo funciones).

* **bracketSpacing**: Controla si Prettier debe añadir espacios entre corchetes en literales de objetos. Por ejemplo:

  * `true: { foo: bar }`
  
  * `false: {foo: bar}`

* **arrowParens**: Especifica si se deben incluir paréntesis alrededor de los parámetros de funciones flecha.

  * "always": Siempre incluye paréntesis. Ejemplo: (x) => x
  * "avoid": Los omite cuando hay un solo parámetro. Ejemplo: x => x

* **endOfLine**: Define el tipo de final de línea a usar. Las opciones son:

  * "lf": Line feed (LF, \n). Este es el estándar en sistemas Unix.
  
  * "crlf": Carriage return + line feed (CRLF, \r\n). Este es el estándar en sistemas Windows.
  
  * "cr": Carriage return (CR, \r).
  
  * "auto": Mantiene el final de línea existente.

### Ejemplo avanzado de .prettierrc con integración en un proyecto Angular:
Si estás trabajando en un proyecto Angular y has configurado Prettier junto con ESLint, tu archivo .prettierrc podría verse así:

```json
{
  "printWidth": 100,
  "tabWidth": 2,
  "useTabs": false,
  "semi": true,
  "singleQuote": true,
  "trailingComma": "all",
  "bracketSpacing": true,
  "arrowParens": "avoid",
  "endOfLine": "auto",
  "overrides": [
    {
      "files": "*.component.html",
      "options": {
        "parser": "angular"
      }
    },
    {
      "files": "*.component.ts",
      "options": {
        "parser": "typescript"
      }
    }
  ]
}
```

## .prettierignore
El archivo `.prettierignore` se utiliza para especificar qué archivos o directorios deben ser ignorados por Prettier durante el formateo de código. Funciona de manera similar a .gitignore, donde defines una lista de patrones de archivos que Prettier no debe procesar.

### ¿Cuándo usar un .prettierignore?
El archivo `.prettierignore` es útil en situaciones donde:

* **Archivos generados automáticamente**: No tiene sentido formatear archivos generados por compiladores o herramientas de construcción.

* **Archivos grandes**: Algunos archivos pueden ser demasiado grandes y no beneficiarse del formateo de Prettier, lo que podría afectar el rendimiento.

* **Directrices de proyecto**: Puedes tener ciertos archivos que deben seguir un estilo diferente o no ser formateados en absoluto.

### Ejemplo de un archivo `.prettierignore`
```bash
# Ignorar archivos de construcción
dist/
build/

# Ignorar dependencias
node_modules/

# Ignorar archivos de configuración específicos
*.config.js

# Ignorar archivos de bundle
*.bundle.js

# Ignorar archivos de logs
*.log

# Ignorar carpetas específicas
coverage/
out/
```
**Explicación de las líneas comunes:**

* **dist/** y **build/**: Ignora los directorios de salida de compilación, ya que estos archivos son generados automáticamente y no necesitan ser formateados.

* **node_modules/**: Ignora la carpeta de dependencias de npm, ya que no es necesario formatear código que no es parte de tu proyecto.

* `*.config.js`: Ignora cualquier archivo de configuración con la extensión .config.js. Puedes especificar otros patrones según el nombre o la extensión que prefieras ignorar.

* `*.bundle.js`: Ignora archivos que son el resultado de un proceso de empaquetado (bundling), como los archivos generados por Webpack o Rollup.

* `*.log`: Ignora archivos de registro (logs), que suelen generarse durante la ejecución o pruebas del proyecto.

* **coverage/** y **out/**: Ignora directorios que contienen información de cobertura de pruebas o archivos de salida.

## `.editorconfig`
El archivo `.editorconfig` es un archivo de configuración que ayuda a mantener un estilo de codificación consistente entre diferentes editores y entornos de desarrollo. **EditorConfig** es un estándar que permite definir reglas de formateo para archivos en un proyecto, asegurando que todos los desarrolladores sigan las mismas convenciones de estilo, independientemente del editor que utilicen.

El archivo .editorconfig es un archivo de texto simple que contiene una serie de reglas de formateo que los editores compatibles con EditorConfig pueden leer y aplicar automáticamente. Las reglas en .editorconfig suelen ser utilizadas para configurar aspectos básicos del estilo de código, como la indentación, los finales de línea, el tipo de comillas, etc.

### Ejemplo
```bash
# Indica que se deben aplicar estas configuraciones a todos los archivos
root = true

# Reglas globales para todos los archivos
[*]
charset = utf-8
indent_style = space
indent_size = 2
end_of_line = lf
insert_final_newline = true
trim_trailing_whitespace = true

# Reglas específicas para archivos de Python
[*.py]
indent_size = 4

# Reglas específicas para archivos de Makefile
[Makefile]
indent_style = tab
```
* `root = true`:

  * Indica que este es el archivo .editorconfig raíz. Si existe otro .editorconfig en un directorio superior, será ignorado una vez que se encuentre este archivo con root = true.

* `[*]`:

  * Aplica las reglas definidas a continuación a todos los archivos en el proyecto. Los corchetes ([]) permiten definir secciones específicas para diferentes tipos de archivos.

* `charset = utf-8`:

  * Define el conjunto de caracteres a utilizar. utf-8 es el estándar recomendado para la mayoría de los proyectos.

* `indent_style = space`:

  * Especifica el estilo de indentación a usar. Las opciones son space (espacios) o tab (tabulaciones).

* `indent_size = 2`:

  * Define el número de espacios por nivel de indentación. En el ejemplo, se establece a 2 espacios.

* `end_of_line = lf`:

  * Define el tipo de final de línea a usar. Las opciones son:

  * lf: Line feed (Unix/Linux, macOS)

  * crlf: Carriage return + line feed (Windows)

  * cr: Carriage return (antiguos sistemas Mac)

  * insert_final_newline = true:

    * Especifica si se debe insertar una nueva línea al final de cada archivo.

  * trim_trailing_whitespace = true:

    * Elimina los espacios en blanco al final de cada línea.

## Kusky
Husky es una herramienta que facilita la configuración de ganchos (hooks) de Git para automatizar tareas en tu flujo de trabajo de desarrollo. Estos hooks son scripts que se ejecutan automáticamente en momentos específicos del ciclo de vida de Git, como antes de hacer un **commit** o un **push**, y Husky te permite configurar estos hooks de manera sencilla y eficiente.

### ¿Qué son los Git Hooks?
Los Git Hooks son scripts que Git ejecuta automáticamente en respuesta a ciertos eventos. Algunos de los hooks más comunes incluyen:

* **pre-commit**: Se ejecuta antes de que un commit sea creado.

* **commit-msg**: Se ejecuta después de que el mensaje de commit es creado, pero antes de que se complete el commit.

* **pre-push**: Se ejecuta antes de que un push se realice.

* **pre-rebase**: Se ejecuta antes de que un rebase ocurra.

### ¿Por qué usar Husky?
Aunque Git tiene soporte nativo para hooks, configurarlos manualmente puede ser engorroso y propenso a errores, especialmente en proyectos de equipo donde todos los desarrolladores deben tener los mismos hooks configurados. Husky simplifica este proceso al permitirte definir los hooks directamente en tu proyecto, y al instalar las dependencias, todos los miembros del equipo tendrán los mismos hooks configurados automáticamente.

### Instalación

```bash
npm install husky --save-dev
```
