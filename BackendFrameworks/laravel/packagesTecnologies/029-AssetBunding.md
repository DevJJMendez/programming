# Asset Bunding

Asset Bundling se refiere a la práctica de combinar varios recursos, como archivos CSS, JavaScript y otros activos, en un solo archivo o paquete para mejorar el rendimiento de una aplicación web.

## Puntos claves:

- **Reducción de solicitudes HTTP**: Al combinar varios archivos en un solo paquete, se reduce la cantidad de solicitudes HTTP necesarias para cargar una página web. Esto puede mejorar significativamente el tiempo de carga de la página, ya que cada solicitud HTTP implica cierta latencia.

- **Minificación y compresión**: Antes de empaquetar los activos, es común aplicar técnicas como minificación y compresión para reducir el tamaño de los archivos. La minificación elimina espacios en blanco y caracteres no esenciales, mientras que la compresión utiliza algoritmos para reducir el tamaño del archivo.

- **Manejo de dependencias**: Asset Bundling puede ayudar a gestionar las dependencias entre archivos. Por ejemplo, si tu aplicación utiliza varios archivos JavaScript y CSS, agruparlos correctamente puede asegurar que se carguen en el orden adecuado, evitando problemas de dependencias.

- **Versionamiento**: Al utilizar técnicas de versionamiento en los nombres de los archivos, puedes asegurar que los usuarios obtengan la última versión del paquete de activos, incluso si han almacenado en caché versiones anteriores.

En el caso específico de Laravel, el framework proporciona herramientas como Laravel Mix, que facilita la compilación y bundling de activos. Laravel Mix utiliza Webpack bajo el capó para manejar estas tareas y proporciona una sintaxis simple y clara en el archivo `webpack.mix.js `para definir tus activos y configuraciones de bundling.

---

Utilizamos este comando para instalar las dependencias de nodeJs y asi poder utilizar Vite

```bash
npm install
```

Configuracion del archivo `vite.config.js`

```js
import { defineConfig } from "vite";
import laravel from "laravel-vite-plugin";

export default defineConfig({
  plugins: [
    laravel({
      // estos son los archivos que utilizaremos para los estilos,animaciones etc. de las vistas.
      input: ["resources/css/app.css", "resources/js/app.js"],
      refresh: true,
    }),
  ],
});
```

Si es una Single Page Aplication (SPA) hacemos esto:

```js
import { defineConfig } from "vite";
import laravel from "laravel-vite-plugin";

export default defineConfig({
  plugins: [
    laravel({
      input: ["resources/js/app.js"],
      refresh: true,
    }),
  ],
});
```

En el `app.js` importamos el contenido **CSS**

```js
import "./bootstrap";
import "../css/app.css";
```

---

En las vistas importaremos los recursos con directiva **Vite**

```php
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>AssetBunding</title>
    @vite(['resources/css/app.css', 'resources/js/app.js'])
</head>
```

Para que esto funcione debemos ejecutar este comando:

```bash
npm run dev
```

Todo esto es para un entorno de desarrollo, si queremos usarlo en produccion usamos el comando:

```bash
npm run build
```

Esto creara los archivos optimizados de css y js en el directorio `public\build\assets`
