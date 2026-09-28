# Generar PDF con DomPDF

DomPDF es una biblioteca de PHP que te permite generar archivos PDF a partir de contenido HTML y CSS. Esto es especialmente útil en entornos web donde necesitas generar informes, facturas u otros documentos en formato PDF de manera dinámica.

- Generación de PDF desde HTML/CSS: DomPDF permite convertir fácilmente contenido HTML y CSS en un archivo PDF. Puedes usar etiquetas HTML y estilos CSS para diseñar el documento de la manera que desees.

- Soporte para CSS3 y algunas características de HTML5: DomPDF tiene soporte para muchas características de CSS3, lo que te brinda cierta flexibilidad en el diseño. Sin embargo, es importante tener en cuenta que no todas las características avanzadas de CSS3 o HTML5 pueden ser completamente compatibles.

- Configuración y personalización: Puedes configurar y personalizar la generación de PDF según tus necesidades. DomPDF proporciona opciones para establecer el tamaño de página, la orientación, márgenes y otras configuraciones.

- Manejo de imágenes y enlaces: La librería es capaz de manejar imágenes y enlaces dentro del contenido HTML, permitiendo que estos elementos se incluyan en el PDF generado.

- Licencia: DomPDF está bajo una licencia LGPL, lo que significa que puedes utilizarla en proyectos de código abierto o comerciales.

---

## Uso

- Instalación: La forma más común de instalar DomPDF es a través de Composer. Asegúrate de tener Composer instalado en tu proyecto.

```bash
composer require barryvdh/laravel-dompdf
```

- Configuración (en caso de estar usando Laravel):

Si estás utilizando Laravel, normalmente instalarías la versión específica para Laravel de DomPDF. Después de instalarlo, publica la configuración:

```bash
php artisan vendor:publish --provider="Barryvdh\DomPDF\ServiceProvider"
```

---

Ejemplo:

```php
class PdfController extends Controller
{
    public function index()
    {
        // Cargara el contenido del html a un pdf
        $pdf = Pdf::loadView('pdf.example');

        return $pdf->download('my-example.pdf');
    }
}

```
