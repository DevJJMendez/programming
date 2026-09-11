# Spring Container
El Spring Container es el componente de Spring responsable de crear, configurar, ensamblar y administrar los objetos que forman nuestra aplicación.

A esos objetos que están bajo el control del contenedor los llamamos: **Spring Beans**

Una forma sencilla de visualizarlo:
```
                 SPRING CONTAINER
                       │
        ┌──────────────┼──────────────┐
        ↓              ↓              ↓
      Bean           Bean            Bean
   Controller       Service       Repository
        │              │              │
        └──────────────┼──────────────┘
                       ↓
                 Dependencias
```
Por tanto, cuando escuches: "**Spring Container**"

piensa: "El componente que administra el conjunto de objetos que Spring conoce y sus relaciones."

### Pero cuidado: Container ≠ Application
Esta distinción es importante.

Tu aplicación puede tener cientos de clases:
```
Order
Product
Customer
OrderService
ProductService
PaymentService
...
```
Pero no todas son necesariamente Spring Beans.

El container administra aquellos objetos que han sido registrados/configurados en él.

Por ejemplo:
```java
@Service
public class OrderService(){}
```
Spring puede registrar OrderService como Bean.

Mientras que:
```java
public class Order(){}
```
puede ser simplemente un objeto Java normal, dependiendo de cómo esté configurada tu aplicación.