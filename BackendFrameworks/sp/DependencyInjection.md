# Dependency Injection
Dependency Injection (DI) es una técnica de diseño mediante la cual un objeto recibe desde el exterior las dependencias que necesita para realizar su trabajo, en lugar de crearlas por sí mismo.

* ¿Qué es una dependencia?
Supongamos:
```java
public class OrderService(){
  private PaymentService paymentService;
}
```
`OrderService` necesita `PaymentService` para poder procesar un pedido.

Por lo tanto:
```
OrderService
      │
      │ necesita
      ↓
PaymentService
```
Podemos decir: `PaymentService` es una dependencia de `OrderService`.

Formalmente:
```
OrderService → PaymentService
```
La flecha significa: "OrderService depende de PaymentService."

