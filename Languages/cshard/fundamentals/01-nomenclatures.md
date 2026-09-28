# Reglas de nomenclatura
## Clases, Interfaces, Métodos, Propiedades y Eventos
1. Clases: Se usan Pascal Case, donde la primera letra de cada palabra está en mayúsculas.
   * Ejemplo: CustomerManager, ProductService, EmployeeDetails

2. Interfaces: También utilizan Pascal Case, pero comúnmente se les agrega una "I" al principio para indicar que son interfaces.
   * Ejemplo: IUserRepository, IProductService, IOrderProcessor

3. Métodos: Los métodos se nombran en Pascal Case, igual que las clases.
   * Ejemplo: GetUserData(), CalculatePrice(), SendEmail()

4. Propiedades: Las propiedades siguen Pascal Case, al igual que las clases y métodos.
   * Ejemplo: FirstName, LastName, OrderTotal

5. Eventos: Los eventos se nombran en Pascal Case y suelen usar un verbo o una acción para describir el evento.
   * Ejemplo: OrderCompleted, FileUploaded, DataReceived

## Variables y Campos
1. Variables locales: Las variables dentro de un método o bloque de código se nombran usando camelCase, donde la primera letra es minúscula y las siguientes palabras comienzan con mayúscula.
   * Ejemplo: userName, totalAmount, productList

2. Campos: Los campos de clase, especialmente los que son privados, se nombran con camelCase, pero se puede agregar un guion bajo al principio para diferenciarlos.
   * Ejemplo: _userName, _totalAmount

3. Constantes
Las constantes se nombran en UPPERCASE, usando guiones bajos para separar las palabras.
   * Ejemplo: MAX_VALUE, DEFAULT_TIMEOUT

## Enumeraciones
Las enumeraciones usan Pascal Case para su nombre, y los valores de la enumeración se nombran con UPPERCASE.
```c#
enum PaymentStatus
{
    Pending,
    Completed,
    Failed
}
```

## Parámetros
Los parámetros de los métodos se nombran usando camelCase, similar a las variables locales.
   * Ejemplo: int numberOfItems, string filePath

## Nombres de Espacios de Nombres (Namespaces)
Los espacios de nombres deben usar Pascal Case y reflejar una jerarquía lógica basada en el proyecto.
   * Ejemplo: MyCompany.MyProduct.Services, Acme.Finance.Reports

## Convenciones Específicas para .NET
* Archivos: El nombre de los archivos debe coincidir con el nombre de la clase o el tipo principal dentro del archivo. Esto facilita la navegación y el mantenimiento del código.
  * Ejemplo: Si tienes una clase llamada OrderService, el archivo debería llamarse OrderService.cs.

* Clases de Estilo y Diseño: En .NET, las clases que son de estilo y diseño o que implementan patrones de diseño deben seguir las convenciones comunes, como Factory, Singleton, Observer, etc.

  * Ejemplo: Si tienes una clase que implementa un patrón Singleton, se puede llamar LoggerSingleton.

*  Métodos Asíncronos: Cuando se crean métodos que devuelven un Task (o Task<T>), se debe agregar el sufijo Async al nombre del método, para seguir una convención clara que indique que el método es asíncrono.
   * Ejemplo: GetUserDataAsync(), SaveOrderAsync()

## Convenciones para Elementos en .NET Framework
* ventos
En .NET, es común nombrar los eventos con el sufijo "Event", aunque este no es obligatorio en C#, es una buena práctica seguir esta convención. Además, los eventos a menudo se acompañan de un delegado que define su firma.
  * Ejemplo: OrderPlacedEvent, UserLoginEvent

* Métodos y Propiedades de Acceso a Datos
Cuando trabajas con ORMs (como Entity Framework) o accesos a datos, es común que los métodos o propiedades sigan convenciones que reflejan la acción o el estado que representan.
  * Ejemplo: Métodos como SaveChanges(), Delete(), GetById(), etc.

## Buenas Prácticas Adicionales
No usar abreviaciones: Aunque algunas abreviaturas son comunes, como ID para "identificador", es mejor evitar abreviaciones arbitrarias en los nombres.

Correcto: CustomerName, InvoiceTotal
Incorrecto: CustNm, InvTtl
Usar nombres descriptivos: Asegúrate de que el nombre de las variables, métodos y clases sea auto-descriptivo. El nombre debe indicar el propósito del elemento.

Correcto: CalculateInvoiceTotal(), GetUserDetails()
Incorrecto: Calculate(), GetDetails()
Evitar los nombres ambiguos: Asegúrate de que el nombre no sea ambiguo y que refleje el propósito real del elemento.

Correcto: CustomerOrderProcessor, EmailSender
Incorrecto: Handler, Manager
Uso de los comentarios: Si el nombre no puede describir completamente la funcionalidad, usa comentarios breves para describir el propósito y comportamiento del código.

Preferir la claridad sobre la brevedad: Si bien el nombre de una variable o método debe ser conciso, también debe ser claro en su significado. Evita nombres excesivamente cortos o vagos.

## Reglas de Nombres Comunes de .NET y C#
Métodos: Usar verbos que describan la acción que realizan, por ejemplo: Get, Set, Create, Update, Delete.
Propiedades: Utilizar sustantivos, por ejemplo: FirstName, OrderAmount, IsCompleted.
Eventos: Usar el sufijo Event o un nombre basado en la acción del evento, por ejemplo: DataChangedEvent, UserLoggedInEvent.
Clases y Tipos: Usar sustantivos en plural o singular según el caso, por ejemplo: Customer, OrderList, InvoiceService.

## Recomendaciones para el Uso de Convenciones en Proyectos Grandes
Usar prefijos lógicos: En proyectos grandes, el uso de prefijos puede ayudar a categorizar ciertos tipos de clases o servicios. Por ejemplo, prefijos como I para interfaces, E para eventos, M para modelos, etc.

Estandarizar el estilo en el equipo: Es importante acordar las convenciones de nomenclatura dentro de un equipo de desarrollo para evitar confusión y garantizar la coherencia.