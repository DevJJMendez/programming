## Configuración
Spring Data REST te permite configurar y personalizar varios aspectos a través del archivo `application.properties` (o `application.yml` si usas YAML). Estas configuraciones te permiten modificar cómo se comporta la exposición de repositorios REST, la paginación, los mensajes de error, y otros aspectos clave.

### Configuraciones Principales en application.properties

### 1. **Configuración de Paginación y Ordenación**

Puedes personalizar la paginación predeterminada para los recursos expuestos:

```properties
spring.data.rest.default-page-size=20
spring.data.rest.max-page-size=100
spring.data.rest.page-param-name=page
spring.data.rest.limit-param-name=size
spring.data.rest.sort-param-name=sort
```

* `spring.data.rest.default-page-size`: Establece el tamaño de página predeterminado.

* `spring.data.rest.max-page-size`: Define el tamaño máximo permitido para una página.

* `spring.data.rest.page-param-name`: Cambia el nombre del parámetro de la página en las URL.

* `spring.data.rest.limit-param-name`: Cambia el nombre del parámetro para limitar el número de elementos en una página.

* `spring.data.rest.sort-param-name`: Cambia el nombre del parámetro para ordenar los resultados.

### 2. **Configuración de URI Base**

Puedes definir una URI base para todos los recursos REST expuestos por Spring Data REST:

```properties
spring.data.rest.base-path=/api
```
Esto hará que todos los recursos estén disponibles bajo el prefijo `/api`. Por ejemplo, un repositorio de productos que normalmente estaría en `/productos` ahora estará en `/api/productos`.

### 3. **Configuración de Exposición de Repositorios**

Puedes decidir si ciertos repositorios deben ser expuestos o no:

```properties
spring.data.rest.detection-strategy=default
```
* `all`: Expone todos los repositorios.

* `annotated`: Solo expone repositorios anotados con @RepositoryRestResource.

* `default`: Expone repositorios basados en las reglas predeterminadas.

### 4. **Configuración de Almacén de Eventos**
Spring Data REST dispara eventos durante el ciclo de vida de las entidades (por ejemplo, `BeforeCreateEvent`, `AfterCreateEvent`). Puedes habilitar o deshabilitar la exposición de estos eventos:

```properties
spring.data.rest.return-body-on-create=true
spring.data.rest.return-body-on-update=true
spring.data.rest.return-body-on-delete=false
```
* `spring.data.rest.return-body-on-create`: Si es true, devuelve el cuerpo de la entidad creada en la respuesta a una solicitud POST.

* `spring.data.rest.return-body-on-update`: Si es true, devuelve el cuerpo de la entidad actualizada en la respuesta a una solicitud PUT o PATCH.

* `spring.data.rest.return-body-on-delete`: Si es true, devuelve el cuerpo de la entidad eliminada en la respuesta a una solicitud DELETE.

### 5. Configuración de CORS
Para permitir solicitudes CORS (Cross-Origin Resource Sharing), puedes configurar:

```properties
spring.data.rest.cors.allowed-origins=http://domain1.com,http://domain2.com
spring.data.rest.cors.allowed-methods=GET,POST,PUT,DELETE
spring.data.rest.cors.allowed-headers=*
spring.data.rest.cors.exposed-headers=Location
spring.data.rest.cors.allow-credentials=true
spring.data.rest.cors.max-age=3600
```
* `spring.data.rest.cors.allowed-origins`: Especifica los orígenes permitidos.

* `spring.data.rest.cors.allowed-methods`: Define los métodos HTTP permitidos.

* `spring.data.rest.cors.allowed-headers`: Especifica los encabezados permitidos.

* `spring.data.rest.cors.exposed-headers`: Define los encabezados expuestos.

* `spring.data.rest.cors.allow-credentials`: Permite o deniega el uso de credenciales.

* `spring.data.rest.cors.max-age`: Establece el tiempo en segundos que las respuestas pueden ser almacenadas en caché.

### 6. Configuración de Hypermedia
Spring Data REST utiliza Hypermedia para proporcionar enlaces HATEOAS en las respuestas. Puedes configurar cómo se manejan estos enlaces:

```properties
spring.hateoas.use-hal-as-default-json-media-type=true
```
* `spring.hateoas.use-hal-as-default-json-media-type`: Define si HAL (Hypertext Application Language) debe ser utilizado como el tipo de medio JSON predeterminado.

### 7. Configuración de Propiedades de Exposición
Para personalizar qué propiedades de las entidades se exponen, puedes utilizar:

```properties
spring.data.rest.default-media-type=application/hal+json
spring.data.rest.default-query-max-limit=200
```
* `spring.data.rest.default-media-type`: Cambia el tipo de medio predeterminado para las respuestas.

* `spring.data.rest.default-query-max-limit`: Establece un límite máximo para las consultas.