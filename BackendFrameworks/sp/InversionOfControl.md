# Inversion Of Control
Es un principio de diseño en el que una clase deja de tener el control directo sobre la creación y gestión de las dependencias que necesita.

Dicho de forma sencilla: IoC significa que tu código deja de controlar directamente ciertos aspectos de la ejecución y ese control pasa a estar en manos de un componente externo.

En Spring, ese componente externo es principalmente el contenedor de Spring (spring container).

### Antes de Spring
Imaginemos una aplicación sencilla:
```java
public class OrderService(){
  private final PaymentService paymentService;

  public OrderService(){
    this.paymentService = new PaymentService();
  }
}
```
Aquí `OrderService` está haciendo dos cosas:
```
OrderService
     │
     ├── 1. Implementa lógica de negocio
     │
     └── 2. Decide cómo crear PaymentService
```
Es decir, `OrderService` controla la creación de su dependencia.

Podemos representarlo así:
```
OrderService
      │
      │ "Yo necesito PaymentService"
      │
      └──────► new PaymentService()
```
La clase dice: "Yo sé qué dependencia necesito y yo mismo voy a crearla."

### ¿Qué cambia con IoC?
Con Spring podemos tener:
```java
public class OrderService(){
  private final PaymentService paymentService;

  public OrderService(PaymentService paymentService){
    this.paymentService = paymentService;
  }
}
```
Ahora `OrderService` ya no crea `PaymentService`.

Simplemente declara: "Para funcionar necesito un `PaymentService`."

Y alguien externo se encarga de proporcionárselo.

Conceptualmente:
```
                 Spring Container
                       │
             crea y administra
                       │
          ┌────────────┴────────────┐
          ↓                         ↓
   PaymentService              OrderService
          │                         │
          └──────────────►──────────┘
                    dependencia
```
Aquí ocurre la inversión de control.

Antes:
```
OrderService
      │
      └── controla → creación de PaymentService
```
Después:
```
Spring
  │
  ├── crea PaymentService
  └── crea OrderService
          │
          └── recibe PaymentService
```
El control sobre la creación y composición de objetos pasó de nuestras clases al contenedor.

## 