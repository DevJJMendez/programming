# Pipes
Los Pipes en Angular son una característica poderosa que permite transformar datos directamente en la plantilla (HTML). Son muy útiles cuando necesitas mostrar los datos en un formato específico sin alterar el modelo de datos subyacente en tu componente.

Un Pipe es una clase en Angular que implementa la interfaz **PipeTransform**. Esta clase toma un valor, lo transforma y devuelve un nuevo valor. Se utilizan en las plantillas de Angular para modificar la forma en que se presentan los datos, como dar formato a fechas, monedas, textos y otros tipos de datos.

## Sintaxis
La sintaxis básica para usar un Pipe en Angular es con el carácter |, seguido del nombre del Pipe:
```html
{{ valor | nombreDelPipe }}
```
**Ejemplo**
```html
<p>{{ nombre | uppercase }}</p>
```
Este código toma el valor de nombre y lo convierte a mayúsculas usando el pipe uppercase.

## Pipes Integrados en Angular
Angular proporciona varios pipes integrados para realizar transformaciones comunes:
1. **DatePipe**: Formatea las fechas.
   * Ejemplo: `{{ fecha | date:'short' }}`

2. **UppercasePipe y LowercasePipe**: Convierten el texto a mayúsculas o minúsculas.
   * Ejemplo: `{{ texto | uppercase }}`

3. **CurrencyPipe**: Da formato a los valores monetarios.
   * Ejemplo: `{{ precio | currency:'USD' }}`

4. **DecimalPipe**: Formatea números decimales.
   * Ejemplo: `{{ valor | number:'1.2-2' }}`

5. **PercentPipe**: Convierte números a formato porcentual.
   * Ejemplo: `{{ ratio | percent:'1.2-2' }}`

6. **JsonPipe**: Convierte un objeto en un formato JSON.
   * Ejemplo: `{{ objeto | json }}`

7. SlicePipe: Extrae una porción de un array o cadena.
   * Ejemplo: `{{ lista | slice:1:3 }}`

## Pipes Personalizados
Puedes crear tus propios pipes personalizados si los integrados no satisfacen tus necesidades. Un pipe personalizado te permite encapsular lógica de transformación específica que puede ser reutilizada en toda tu aplicación.

1. **Creación**, Genera un pipe usando la Angular CLI
```bash
ng generate pipe nombreDelPipe
```

2. **Implementa el pipe**:
```ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'miPipe'
})
export class MiPipe implements PipeTransform {
  transform(value: any, ...args: any[]): any {
    // Lógica de transformación
    return `Valor transformado: ${value}`;
  }
}
```

3. **Uso**

```html
<p>{{ 'Hola Mundo' | miPipe }}</p>
```

**Ejemplo**
```ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'invertirTexto'
})
export class InvertirTextoPipe implements PipeTransform {
  transform(value: string): string {
    return value.split('').reverse().join('');
  }
}
```
En este ejemplo, el pipe invertirTexto toma un string, lo invierte y lo muestra en la plantilla:
```html
<p>{{ 'Angular' | invertirTexto }}</p> <!-- Resultado: ragnuA -->
```

## Pipes Puros vs. Impuros
* **Pipes Puros**: Estos pipes se ejecutan solo cuando su entrada cambia. Son más eficientes, y casi todos los pipes en Angular son puros por defecto.

```ts
@Pipe({
  name: 'miPipePuro',
  pure: true
})
```

* **Pipes Impuros**: Se ejecutan en cada ciclo de detección de cambios. Son útiles cuando el valor de entrada cambia frecuentemente, pero deben usarse con cuidado debido a su impacto en el rendimiento.

```ts
@Pipe({
  name: 'miPipeImPuro',
  pure: false
})
```

## Uso de Parámetros en Pipes
Puedes pasar parámetros a un pipe para controlar cómo realiza la transformación.

```html
<p>{{ precio | currency:'EUR':'symbol':'1.2-2' }}</p>
```
En este caso, el pipe currency recibe varios parámetros que controlan la moneda, el símbolo y el formato decimal.