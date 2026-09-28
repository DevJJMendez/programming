# Importar/Exportar

La librería maatwebsite/excel es una herramienta popular en el ecosistema de Laravel para trabajar con hojas de cálculo de Excel. Permite la importación y exportación de datos de manera fácil y eficiente.

- Instalacion

```bash
composer require maatwebsite/excel -W
```

- Configuracion

```php
php artisan vendor:publish --provider="Maatwebsite\Excel\ExcelServiceProvider"
```

Ejemplo:

Creamos en el directorio `app\` una nueva carpeta llamada **imports**.
