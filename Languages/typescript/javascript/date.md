# `Date`
La clase Date en JavaScript representa una fecha y hora y se utiliza para trabajar con datos temporales, como realizar cálculos de fechas, registrar tiempos, y mostrar fechas formateadas. Date es una de las clases más usadas para aplicaciones que requieren seguimiento de tiempo, ya sea para fechas de creación, vencimiento, intervalos de tiempo, etc.

## ¿Qué es Date?
Date es una clase nativa de JavaScript que permite trabajar con fechas y horas. Cuando se crea un objeto Date, representa un punto en el tiempo basado en milisegundos desde la Época Unix (es decir, el 1 de enero de 1970 a las 00:00:00 UTC). JavaScript permite crear, manipular y extraer información sobre la fecha y hora a través de Date.

## ¿Para qué sirve Date?
Date permite:

Obtener y manipular fechas y horas para registros de tiempo y acciones basadas en fecha.
Realizar cálculos de tiempo: por ejemplo, determinar la diferencia entre dos fechas.
Convertir y mostrar fechas en diferentes formatos, considerando la localización.
Automatizar tareas basadas en tiempo, como mostrar la fecha actual en una página o calcular edades.

## ¿Qué resuelve Date?
La clase Date resuelve la necesidad de trabajar con datos temporales de una manera estandarizada, proporcionando métodos que ayudan a manejar las diferentes partes de la fecha (año, mes, día, hora, minutos, segundos, etc.) de manera consistente y fácil de entender.

## ¿Cómo lo resuelve?
Date ofrece una serie de métodos para crear, manipular y formatear fechas. Estos métodos permiten extraer y modificar componentes específicos (como el día o el mes), realizar cálculos de intervalos de tiempo y formatear fechas en una forma adecuada para mostrar a los usuarios.

## Métodos Principales de Date
### Creación de Fechas
new Date(): Crea una fecha con la fecha y hora actuales.
```js
const ahora = new Date();
```
new Date(milliseconds): Crea una fecha a partir de milisegundos desde la Época Unix.
```js
const fecha1970 = new Date(0); // 1 de enero de 1970, 00:00:00 UTC
```
new Date(year, month, day, hours, minutes, seconds, milliseconds): Crea una fecha especificando año, mes (0-11), día, hora, minutos, segundos y milisegundos.
```js
const fechaPersonalizada = new Date(2024, 10, 4, 14, 30, 0); // 4 de noviembre de 2024, 14:30
```

### Métodos para Obtener Componentes de la Fecha
getFullYear(): Devuelve el año completo.
```js
const año = ahora.getFullYear();
```
getMonth(): Devuelve el mes (0 para enero, 11 para diciembre).
```js
const mes = ahora.getMonth();
```
getDate(): Devuelve el día del mes.
```js
const dia = ahora.getDate();
```
getDay(): Devuelve el día de la semana (0 para domingo, 6 para sábado).
```js
const diaSemana = ahora.getDay();
```
getHours(), getMinutes(), getSeconds(), getMilliseconds(): Devuelven la hora, minutos, segundos y milisegundos.
```ja
const horas = ahora.getHours();
const minutos = ahora.getMinutes();
```

### Métodos para Modificar Componentes de la Fecha
setFullYear(year): Establece el año de la fecha.
```js
ahora.setFullYear(2025);
```
setMonth(month): Establece el mes de la fecha (0-11).
```js
ahora.setMonth(10); // Noviembre
```
setDate(day): Establece el día del mes.
```js
ahora.setDate(15);
```
setHours(hours), setMinutes(minutes), setSeconds(seconds), setMilliseconds(milliseconds): Establecen la hora, minutos, segundos y milisegundos respectivamente.

### Métodos para Formateo de Fechas
toDateString(): Devuelve solo la fecha en formato legible (por ejemplo, "Mon Nov 04 2024").
```js
const fechaLegible = ahora.toDateString();
```
toTimeString(): Devuelve solo la hora en formato legible.
```js
const horaLegible = ahora.toTimeString();
```
toISOString(): Devuelve la fecha en formato ISO (por ejemplo, "2024-11-04T14:30:00.000Z").
```js
const fechaISO = ahora.toISOString();
```
toLocaleDateString(locale, options): Devuelve la fecha formateada para una localización específica (por ejemplo, "es-ES" para español).
```js
const fechaLocal = ahora.toLocaleDateString("es-ES", { year: 'numeric', month: 'long', day: 'numeric' });
```

### Cálculo de Diferencias entre Fechas
getTime(): Devuelve el número de milisegundos desde la Época Unix. Útil para calcular diferencias.
```js
const otraFecha = new Date("2024-12-04");
const diferencia = otraFecha.getTime() - ahora.getTime();
const diasDiferencia = diferencia / (1000 * 60 * 60 * 24); // Conversión a días
```