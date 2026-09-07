#dotnet
## `dotnet test`
El comando dotnet test es una herramienta esencial dentro del entorno de desarrollo .NET, utilizada para ejecutar pruebas automatizadas en los proyectos de software. Este comando es parte de la CLI (Command Line Interface) de .NET y se usa principalmente para ejecutar pruebas unitarias o de integración definidas en los proyectos de prueba. Te proporciona la capacidad de verificar el comportamiento de tu aplicación a medida que la desarrollas, asegurando que el código funcione correctamente.

## ¿Qué es el comando dotnet test?
El comando dotnet test es un comando de la interfaz de línea de comandos de .NET que ejecuta las pruebas dentro de un proyecto de pruebas. Las pruebas pueden estar en cualquier framework de prueba compatible con .NET, como xUnit, NUnit o MSTest.

Este comando localiza y ejecuta todas las pruebas unitarias definidas en los proyectos de prueba y devuelve los resultados en la consola. Los resultados incluyen información sobre las pruebas que pasaron, fallaron y cualquier mensaje de error relacionado.

## ¿Para qué sirve el comando dotnet test?
Ejecutar pruebas automatizadas: Ejecuta pruebas unitarias y de integración para verificar que tu código funcione correctamente.

Verificar el comportamiento de la aplicación: Permite comprobar que los cambios en el código no introduzcan errores o problemas inesperados.

Generar un informe de resultados: El comando genera un informe detallado de las pruebas que se han ejecutado, lo que incluye las pruebas pasadas, las fallidas, y los detalles sobre los errores o excepciones ocurridas.

Integración continua: Es ampliamente utilizado en los entornos de integración continua (CI) y entrega continua (CD), donde se ejecutan pruebas automáticamente con cada cambio en el código.

## ¿Qué resuelve el comando dotnet test?
Asegura la calidad del código: Al ejecutar pruebas automatizadas, ayuda a verificar que los cambios en el código no rompan funcionalidades ya existentes, lo que mejora la calidad del código y la confiabilidad del sistema.

Reduce errores humanos: La automatización de pruebas permite detectar errores que podrían ser pasados por alto en pruebas manuales, y facilita la ejecución de pruebas en cada etapa del desarrollo.

Proporciona retroalimentación rápida: Al ejecutar las pruebas, el desarrollador recibe retroalimentación instantánea sobre si el código que ha escrito sigue funcionando como se espera. Esto ayuda a detectar errores en una fase temprana del ciclo de vida del desarrollo.

Mejora el mantenimiento del código: Permite tener un conjunto de pruebas que aseguran que futuras modificaciones no afecten el comportamiento de funcionalidades previas. Facilita la refactorización y el mantenimiento del código sin temor a romper algo sin querer.

Fomenta la práctica de Test-Driven Development (TDD): dotnet test es una herramienta importante si estás utilizando el enfoque de desarrollo dirigido por pruebas (TDD), donde escribes primero las pruebas y luego el código para pasarlas.

## ¿Cómo resuelve dotnet test?
El comando dotnet test resuelve la ejecución de las pruebas de las siguientes maneras:

Descubrimiento de pruebas: El comando escanea los proyectos de prueba y detecta las pruebas definidas, incluso si están distribuidas en varios archivos o carpetas. Esto es posible gracias a los marcos de prueba, como xUnit, NUnit, o MSTest, que permiten que el comando dotnet test reconozca y ejecute las pruebas automáticamente.

Ejecución de las pruebas: Una vez que las pruebas son descubiertas, el comando las ejecuta en el entorno de prueba, que puede incluir la inicialización de recursos, la ejecución de las pruebas y la verificación de los resultados.

Informe de resultados: Después de la ejecución de las pruebas, dotnet test genera un informe que se muestra en la consola o que se puede guardar en un archivo de salida. El informe incluye:

Pruebas pasadas: Aquellas que se ejecutaron correctamente.
Pruebas fallidas: Aquellas que no pasaron, junto con los mensajes de error y detalles.
Pruebas omitidas: Aquellas que fueron deshabilitadas o que no se ejecutaron por alguna razón.
Retorno del código de salida: dotnet test retorna un código de salida que indica el estado general de las pruebas. Por ejemplo:

Código de salida 0: Todas las pruebas pasaron.
Código de salida 1: Algunas pruebas fallaron.
Código de salida 2: Hubo un error en la ejecución de las pruebas (por ejemplo, problemas con el entorno).
Soporte de opciones y filtros: El comando permite varios parámetros y opciones, como ejecutar pruebas específicas, filtrar las pruebas, especificar la configuración de compilación (Debug/Release), y más.

## Cómo usar dotnet test
El comando básico se utiliza de la siguiente manera:
```bash
dotnet test
```
Este comando ejecuta todas las pruebas dentro del proyecto actual o los proyectos especificados.

Opciones y parámetros comunes
Ejecutar pruebas de un proyecto específico:

Si tienes múltiples proyectos, puedes especificar uno con el siguiente comando:
```bash
dotnet test MiProyecto.Tests
```

Especificar la configuración de compilación (por ejemplo, Debug o Release):
```bash
dotnet test --configuration Release
```

Filtrar las pruebas:
Puedes usar el parámetro --filter para ejecutar un conjunto específico de pruebas, basado en su nombre, categoría, etc. Ejemplo para ejecutar pruebas con un nombre que contenga "Validar":
```bash
dotnet test --filter "DisplayName~Validar"
```

Mostrar más detalles:
Para ver más detalles sobre las pruebas y el proceso, puedes usar el parámetro --verbosity:
```bash
dotnet test --verbosity detailed
```

Guardar los resultados en un archivo:
Puedes guardar los resultados en un archivo de formato XML o TRX utilizando la opción --logger:
```bash
dotnet test --logger "trx;LogFileName=resultado_pruebas.trx"
```

## Ejemplo práctico de uso
Imagina que tienes un proyecto llamado MiProyecto.Tests, con un archivo de prueba que contiene varias pruebas unitarias. Para ejecutar todas las pruebas de ese proyecto, simplemente ejecutas:
```bash
dotnet test MiProyecto.Tests
```
El comando buscará las pruebas en ese proyecto, las ejecutará y mostrará los resultados en la consola. Si alguna prueba falla, se mostrará el mensaje de error correspondiente.

Si solo quieres ejecutar pruebas de un método específico, puedes utilizar el filtro --filter:
```bash
dotnet test --filter "DisplayName~TestMetodoImportante"
```
Este comando solo ejecutará las pruebas cuyo nombre de visualización contenga TestMetodoImportante.