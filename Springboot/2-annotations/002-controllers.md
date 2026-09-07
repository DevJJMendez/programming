# MVC Annotations
Las anotaciones de Spring MVC son esenciales para el desarrollo de aplicaciones web en Spring. Cada una tiene un propósito específico y facilita la manipulación de solicitudes HTTP, así como la vinculación de datos entre la capa de presentación y la lógica de negocio.

## `@Controller`
Marca una clase como un controlador de Spring MVC. Se utiliza junto con `@RequestMapping` para definir rutas y manejar solicitudes web.

**Ejemplo**
```java
@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "home"; // Nombre de la vista (por ejemplo, home.jsp)
    }
}
```

## `@RestController`
Es una combinación de dos anotaciones: `@Controller` y `@ResponseBody`. Se utiliza principalmente para simplificar la creación de controladores RESTful. 

Indica que la clase es un controlador en el que cada método de manejo de solicitudes retorna un objeto de dominio en lugar de una vista. Los objetos retornados se serializan directamente en JSON o XML y se escriben en la respuesta HTTP.

Por defecto, los métodos en un `@RestController` retornan datos que se convierten automáticamente a JSON o XML usando las bibliotecas de conversión de mensajes de Spring (Jackson para JSON).



## `@RequestMapping`
Se utiliza para mapear solicitudes HTTP a métodos manejadores en controladores. Puede aplicarse a nivel de clase y/o método. Soporta especificación de rutas, métodos HTTP, parámetros, encabezados, etc.

**Parámetros**
* `value`: Ruta(s) de la solicitud.

* `method`: Método(s) HTTP (GET, POST, etc.).

* `params`: Parámetros de solicitud que deben estar presentes.

* `headers`: Encabezados de solicitud que deben estar presentes.

* `consumes`: Tipo de contenido que el método puede consumir (por ejemplo, "`application/json`").

* `produces`: Tipo de contenido que el método puede producir (por ejemplo, "`application/json`").

**Ejemplo**
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class MyController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello"; // Nombre de la vista
    }
}
```

## `@PathVariable`
Vincula una variable de ruta a un parámetro de método en un controlador. Extrae datos de la URL.

**Parámetros**
* `value`: Nombre de la variable de ruta (opcional si el nombre del parámetro coincide).

* `required`: Indica si el parámetro es obligatorio (por defecto es true).
**Ejemplo**
```java
@Controller
@RequestMapping("/users")
public class UserController {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") String userId) {
        // Lógica para obtener usuario por ID
        return "user";
    }
}
```

## `@RequestParam`
Vincula un parámetro de solicitud HTTP a un parámetro de método en un controlador. Extrae datos de los parámetros de la URL o del cuerpo de la solicitud.

**Parámetros**
* `value`: Nombre del parámetro de solicitud.

* `required`: Indica si el parámetro es obligatorio (por defecto es true).

* `defaultValue`: Valor predeterminado si el parámetro no está presente.

**Ejemplo**
```java
@Controller
@RequestMapping("/search")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String search(@RequestParam("query") String query) {
        // Lógica de búsqueda
        return "results";
    }
}
```

## `@ModelAttribute`
Vincula un atributo de modelo a un parámetro de método o inicializa un modelo. Se utiliza para pre-cargar datos en el modelo antes de que un controlador procese una solicitud.

**Parámetros**
* `value`: Nombre del atributo de modelo (opcional).

**Ejemplo**
```java
@Controller
@RequestMapping("/form")
public class FormController {
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(@ModelAttribute("form") Form form) {
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("form") Form form) {
        // Procesar el formulario
        return "result";
    }
}
```

## `@RequestBody`
Vincula el cuerpo de la solicitud HTTP a un parámetro de método en un controlador. Se utiliza para manejar datos JSON o XML en solicitudes POST o PUT.

**Ejemplo**
```java
@Controller
@RequestMapping("/api")
public class ApiController {
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public Response processData(@RequestBody Request request) {
        // Procesar el cuerpo de la solicitud
        return new Response("Success");
    }
}
```

## `@ResponseBody`
Indica que el valor devuelto de un método debe vincularse directamente al cuerpo de la respuesta HTTP. Se utiliza para devolver datos JSON o XML en respuestas HTTP.

**Ejemplo**
```java
@Controller
@RequestMapping("/api")
public class ApiController {
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public Data getData() {
        return new Data("Example");
    }
}
```

## `@RequestHeader`
Vincula un encabezado de solicitud HTTP a un parámetro de método en un controlador. Extrae datos de los encabezados de la solicitud.

**Parámetros**
* `value`: Nombre del encabezado de solicitud.

* `required`: Indica si el encabezado es obligatorio (por defecto es true).

* `defaultValue`: Valor predeterminado si el encabezado no está presente.


**Ejemplo**
```java
@Controller
@RequestMapping("/headers")
public class HeaderController {
    @RequestMapping(method = RequestMethod.GET)
    public String handleHeaders(@RequestHeader("User-Agent") String userAgent) {
        // Lógica para manejar el encabezado User-Agent
        return "headers";
    }
}
```

## `@ResponseHeader`
Configura encabezados de respuesta HTTP en el método de controlador. Se utiliza para agregar encabezados personalizados en la respuesta HTTP.

**Parámetros**
* `name`: Nombre del encabezado de respuesta.

* `value`: Valor del encabezado de respuesta.

**Ejemplo**
```java
@Controller
@RequestMapping("/response")
public class ResponseHeaderController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> handleResponse() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CustomValue");
        return new ResponseEntity<>("Response with custom header", headers, HttpStatus.OK);
    }
}
```