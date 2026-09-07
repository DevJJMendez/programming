## Spring Data Rest
Es un proyecto dentro del ecosistema de Spring que se encarga de exponer automáticamente repositorios de Spring Data como servicios RESTful. Esto significa que, sin necesidad de escribir código específico para manejar las solicitudes HTTP, Spring Data REST puede generar automáticamente un API REST basado en las entidades y repositorios que hayas definido.

Spring Data REST se integra con Spring Data JPA (u otros módulos de Spring Data) para proporcionar una manera sencilla de exponer las operaciones CRUD de las entidades como servicios REST. A través de anotaciones y configuraciones mínimas, puedes tener un API REST completo en funcionamiento.

### Características Principales
* **Exposición Automática de Repositorios**: Spring Data REST detecta tus repositorios y automáticamente los expone como recursos RESTful.

* **HATEOAS**: Las respuestas del API incluyen enlaces (Hypermedia As The Engine Of Application State), lo que facilita la navegación entre recursos.

* **Soporte para Paginación y Ordenación**: Integrado directamente en los endpoints REST, lo que permite manejar grandes conjuntos de datos de manera eficiente.

* **Control de Proyección y Expansión**: Permite definir vistas personalizadas de las entidades a través de las llamadas proyecciones y excerpts.

* **Validación y Gestión de Eventos**: Integración con Spring Data para la validación de datos y gestión de eventos del ciclo de vida de la entidad.

### Configuración Básica

* **Dependencias**

Para usar Spring Data REST en un proyecto Spring Boot, necesitas incluir la dependencia de `spring-boot-starter-data-rest` en tu `pom.xml` (para proyectos Maven):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```
O en tu archivo `build.gradle` (para proyectos Gradle):
```groovy
implementation 'org.springframework.boot:spring-boot-starter-data-rest'
```

* Exposición de Repositorios

Supongamos que tienes un repositorio de entidad `Producto` como este:

```java
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
```
Spring Data REST automáticamente expondrá un endpoint REST en la URL `/productos`. Si accedes a `http://localhost:8080/productos`, verás una lista de productos en formato JSON.

### Operaciones REST Expuestas
* **GET `/productos`**: Recupera todos los productos.

* **GET `/productos/{id}`**: Recupera un producto específico por su ID.

* **POST `/productos`**: Crea un nuevo producto.

* **PUT `/productos/{id}`**: Actualiza un producto existente.

* **PATCH `/productos/{id}`**: Actualiza parcialmente un producto existente.

* **DELETE `/productos/{id}`**: Elimina un producto específico.

### HATEOAS y Navegación de Recursos
Spring Data REST añade automáticamente enlaces HATEOAS en las respuestas JSON. Estos enlaces permiten navegar entre diferentes recursos relacionados.

Ejemplo de una respuesta para `GET /productos`:
```json
{
  "_embedded": {
    "productos": [
      {
        "nombre": "Laptop",
        "precio": 1000,
        "_links": {
          "self": {
            "href": "http://localhost:8080/productos/1"
          },
          "producto": {
            "href": "http://localhost:8080/productos/1"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/productos"
    },
    "profile": {
      "href": "http://localhost:8080/profile/productos"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 1,
    "totalPages": 1,
    "number": 0
  }
}
```

### Proyecciones y Excerpts
Spring Data REST permite definir proyecciones para personalizar qué campos de las entidades se devuelven en las respuestas.

```java
@Projection(name = "nombreYPrecio", types = { Producto.class })
public interface NombreYPrecioProjection {
    String getNombre();
    BigDecimal getPrecio();
}
```
Al utilizar esta proyección, puedes recuperar solo el nombre y precio de los productos:
```http
GET /productos?projection=nombreYPrecio
```

### Personalización
Aunque Spring Data REST expone automáticamente los repositorios, puedes personalizar varios aspectos:

1. **Control de Exposición**: Puedes controlar qué repositorios se exponen y cuáles no utilizando la anotación `@RepositoryRestResource`.

    ```java
    @RepositoryRestResource(path = "productos", collectionResourceRel = "productos")
    public interface ProductoRepository extends JpaRepository<Producto, Long> {
    }
    ```

2. Configuración de CORS: Si necesitas habilitar CORS, puedes hacerlo de manera global o específica para los repositorios.

    ```java
    @CrossOrigin(origins = "http://domain.com")
    public interface ProductoRepository extends JpaRepository<Producto, Long> {
    }
    ```

3. Eventos: Spring Data REST proporciona eventos de ciclo de vida como `BeforeCreateEvent`, `AfterCreateEvent`, etc., que puedes interceptar para añadir lógica adicional.

    ```java
    @Component
    public class ProductoEventHandler {

        @HandleBeforeCreate
        public void handleProductoCreate(Producto producto) {
            // lógica personalizada antes de crear el producto
        }
    }
    ```

### ¿Cuándo Usar Spring Data REST?
* **Prototipos Rápidos**: Si necesitas construir rápidamente un API REST para un prototipo o un MVP, Spring Data REST es una excelente opción.

* **Aplicaciones Simples o Internas**: Para aplicaciones sencillas o APIs internas donde no necesitas un control muy fino sobre cada endpoint, Spring Data REST puede ahorrarte mucho tiempo.

* **Exposición Automática de Repositorios**: Cuando tienes repositorios que deben ser expuestos de manera estandarizada y sin necesidad de lógica de negocio adicional.

### ¿Cuándo No Usar Spring Data REST?
* **APIs Públicas y Complejas**: Si tu API tiene requisitos muy específicos en cuanto a la estructura de los endpoints, seguridad, o lógica de negocio personalizada, es mejor crear tus propios controladores REST.

* **Control Granular de Lógica de Negocio**: Si necesitas lógica de negocio compleja o validaciones específicas, es mejor no depender de la exposición automática y crear tu propia capa de servicio y controladores.

## `@RepositoryRestResource`
La anotación `@RepositoryRestResource` se utiliza en Spring Data REST para personalizar la exportación de repositorios como recursos RESTful. Por defecto, Spring Data REST expone automáticamente todos los repositorios que encuentra en la aplicación como servicios REST. La anotación `@RepositoryRestResource` te permite controlar aspectos como el nombre del recurso, el path de acceso, y si el repositorio debe ser expuesto o no.

### Uso Básico de @RepositoryRestResource
Supongamos que tienes una entidad llamada `Producto` y un repositorio correspondiente llamado `ProductoRepository`. Podrías personalizar la exposición de este repositorio utilizando `@RepositoryRestResource`.

```java
@RepositoryRestResource(collectionResourceRel = "productos", path = "items")
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Métodos personalizados
}
```
En este ejemplo:

* `collectionResourceRel`: Especifica el nombre del recurso en plural que se utilizará en la representación JSON y en las rutas HATEOAS. En este caso, "productos".

* `path`: Define el path en la URL donde se expondrá el recurso. En este caso, `/items` en lugar del predeterminado `/productos`.

### Opciones de Configuración en @RepositoryRestResource

* `exported`: Puedes utilizar `exported = false` para evitar que un repositorio sea expuesto como un recurso REST.

    ```java
    @RepositoryRestResource(exported = false)
    public interface ProductoRepository extends JpaRepository<Producto, Long> {
        // Métodos personalizados
    }
    ```
    Esto es útil cuando deseas mantener un repositorio solo para uso interno, sin exponerlo a través de la API REST.

* `itemResourceRel`: Permite personalizar el nombre del recurso en singular cuando se representa una entidad individual.

    ```java
    @RepositoryRestResource(collectionResourceRel = "productos", itemResourceRel = "producto", path = "items")
    public interface ProductoRepository extends JpaRepository<Producto, Long> {
        // Métodos personalizados
    }
    ```

## Nomenclaturas
Spring Data REST automáticamente genera nombres para las rutas basándose en las clases de entidad. Por ejemplo, si tienes una entidad `Producto`, el nombre del recurso será `productos` (en plural) de forma predeterminada. Esto se hace agregando una "`s`" al final del nombre de la entidad.

## HATEOAS
**HATEOAS (Hypermedia As The Engine Of Application State)** es un principio dentro de la arquitectura REST que dicta cómo un cliente interactúa con un servicio RESTful. Según este principio, un cliente debería interactuar con un servidor RESTful completamente a través de hipervínculos proporcionados de manera dinámica por las respuestas del servidor. Esto significa que el cliente no necesita conocer la estructura de la API o los endpoints por adelantado; en su lugar, sigue los enlaces proporcionados por el servidor para descubrir y realizar acciones.

HATEOAS es uno de los componentes clave del estilo arquitectónico REST (Representational State Transfer). En una API REST que sigue HATEOAS, las respuestas no solo contienen los datos solicitados, sino también enlaces a recursos relacionados o acciones adicionales que se pueden realizar.

### Ejemplo Simple
Supongamos que tienes un API para gestionar productos en una tienda en línea. Una respuesta típica de HATEOAS podría verse así:

```json
{
    "id": 1,
    "nombre": "Laptop",
    "precio": 1000,
    "_links": {
        "self": {
            "href": "http://api.tienda.com/productos/1"
        },
        "comprar": {
            "href": "http://api.tienda.com/productos/1/comprar"
        },
        "categoría": {
            "href": "http://api.tienda.com/categorías/2"
        }
    }
}
```
En este ejemplo:

* `"self"`: Enlace al recurso actual (el producto en cuestión).

* `"comprar"`: Enlace a una acción relacionada, como comprar el producto.

* `"categoría"`: Enlace a la categoría a la que pertenece el producto.
