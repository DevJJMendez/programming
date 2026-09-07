## Spring MVC
Spring MVC (Model-View-Controller) es un marco dentro del ecosistema de Spring que se utiliza para construir aplicaciones web siguiendo el patrón de diseño MVC. Este patrón separa la lógica de negocio, la presentación y la navegación de la aplicación en tres componentes principales: Modelo, Vista y Controlador.

## Estructura de Spring MVC
1. **Modelo (Model)**:

   - **Responsabilidad**: El modelo contiene los datos de la aplicación y la lógica de negocio. Es responsable de procesar los datos que provienen de la base de datos o de otros servicios y proporcionar esa información al controlador.

   - **Componentes**: Las clases de modelo son **POJOs (Plain Old Java Objects)** que representan los datos de la aplicación. Además, pueden incluir servicios y repositorios que interactúan con la base de datos.

2. **Vista (View)**:

   - **Responsabilidad**: La vista es responsable de renderizar la interfaz de usuario basada en los datos proporcionados por el modelo. Las vistas se generan utilizando motores de plantillas como **Thymeleaf**, **JSP**, **FreeMarker**, entre otros.

   - **Componentes**: Archivos **HTML**, **JSP**, o **Thymeleaf**, que se encargan de mostrar la información al usuario final.

3. **Controlador (Controller)**:

   - **Responsabilidad**: El controlador maneja las solicitudes **HTTP** del cliente (navegador), invoca los métodos del modelo necesarios para procesar la solicitud y selecciona la vista adecuada para la respuesta.

   - **Componentes**: Clases Java anotadas con `@Controller`, `@RestController`, o `@RequestMapping` que definen los puntos finales (endpoints) de la aplicación.

### Flujo de Spring MVC
1. **Solicitud HTTP Entrante**:

   - El usuario realiza una solicitud a la aplicación web a través de una URL específica. Esta solicitud HTTP es capturada por el DispatcherServlet, que es el front controller en Spring MVC.

2. **DispatcherServlet**:

   - El DispatcherServlet actúa como el controlador principal que recibe todas las solicitudes entrantes. Es el responsable de delegar las solicitudes a los controladores específicos y de gestionar el flujo de la aplicación.

3. **Manejo de la Solicitud**:

   - El DispatcherServlet consulta el `HandlerMapping` para encontrar el controlador adecuado para manejar la solicitud. El `HandlerMapping` utiliza la información de las anotaciones en los controladores (@RequestMapping, por ejemplo) para determinar qué método debe ser llamado.

4. **Invocación del Controlador**:

   - El método del controlador correspondiente es invocado. Este método procesa la solicitud, interactúa con el modelo (por ejemplo, llamando a servicios o repositorios), y prepara los datos necesarios para la vista.

5. **Seleccionar una Vista**:

   - Una vez que el controlador ha procesado la solicitud, devuelve el nombre de la vista que debe ser renderizada. Este nombre de vista es resuelto por el ViewResolver, que localiza la plantilla correspondiente (por ejemplo, un archivo Thymeleaf) para renderizar la respuesta.

6. **Renderización de la Vista**:

   - El `ViewResolver` selecciona la vista adecuada, y esta vista se renderiza utilizando los datos proporcionados por el controlador. El resultado es una página HTML completa que se enviará al navegador del cliente.

7. **Respuesta HTTP Saliente**:

   - Finalmente, la vista renderizada se convierte en la respuesta HTTP, que es enviada de vuelta al cliente (navegador). El usuario ve la página web generada en su navegador.

## Binding Request Params
El **"Binding Request Parameters" o "Vinculación de Parámetros de Solicitud"** en Spring MVC es el proceso mediante el cual los parámetros enviados en una solicitud HTTP (ya sea a través de la URL en una solicitud GET o en el cuerpo de una solicitud POST) se asignan automáticamente a los argumentos de un controlador o a los campos de un objeto en una aplicación Spring.

1. **Request Parameters**:

   - Son los datos que el cliente envía al servidor como parte de una solicitud HTTP. En una solicitud GET, se envían como parte de la URL después del símbolo `?` (por ejemplo, `/buscar?nombre=Juan`). En una solicitud POST, los parámetros suelen estar en el cuerpo de la solicitud.

2. **Binding**:

   - Se refiere al proceso de convertir los parámetros de solicitud en tipos de datos que pueden ser manejados por un controlador. Esto puede incluir tipos simples como String, int, o boolean, así como objetos más complejos.

3. **Model Attribute Binding**:

   - En Spring MVC, es común vincular parámetros de solicitud directamente a un objeto de modelo (un POJO), donde Spring automáticamente poblará los campos del objeto con los valores de los parámetros de solicitud que coincidan.

### Binding en Controladores
1. **Binding a Parámetros Simples**

   - Cuando los parámetros de solicitud son tipos de datos simples, como String, int, boolean, etc., puedes capturarlos directamente como argumentos en los métodos del controlador utilizando la anotación `@RequestParam`.

     ```java
     @Controller
     public class EjemploController {

        @GetMapping("/saludar")
        public String saludar(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre, Model model) {
           model.addAttribute("mensaje", "Hola, " + nombre + "!");
           return "saludo";
        }
     }
     ```

     - El parámetro de solicitud nombre se vincula al argumento nombre del método saludar.

     - `@RequestParam` toma el parámetro de la solicitud y lo asigna al argumento del método.

     - Si no se proporciona el parámetro nombre, se usa el valor predeterminado "Mundo".

2. **Binding a Objetos (Model Binding)**

   - Spring MVC permite vincular automáticamente los parámetros de solicitud a los campos de un objeto. Esto es particularmente útil cuando tienes formularios con múltiples campos.

     ```java
     public class Usuario {
        private String nombre;
        private int edad;
        // Getters y setters
     }

     @Controller
     public class UsuarioController {

        @PostMapping("/crearUsuario")
        public String crearUsuario(@ModelAttribute Usuario usuario, Model model) {
           // El objeto usuario ya está poblado con los datos de la solicitud
           model.addAttribute("usuario", usuario);
           return "usuarioDetalles";
        }
     }
     ```

     - El formulario HTML envía datos con los nombres nombre y edad.

     - Spring automáticamente vincula estos datos al objeto Usuario, populando sus campos nombre y edad.

     - La anotación `@ModelAttribute` indica a Spring que debe buscar en la solicitud los parámetros con nombres coincidentes y asignarlos a los campos del objeto.

3. **Binding a Colecciones**: También puedes vincular parámetros de solicitud a colecciones como listas o mapas.

```java
@Controller
public class ListaController {

    @PostMapping("/procesarLista")
    public String procesarLista(@RequestParam List<String> items, Model model) {
        model.addAttribute("items", items);
        return "listaDetalles";
    }
}
```

- Los parámetros de solicitud con el mismo nombre (items) se vinculan a una `List<String>`.

- Si la solicitud incluye `items=valor1&items=valor2`, la lista items contendrá `["valor1", "valor2"]`.

### Personalización del Binding
Spring MVC permite personalizar el proceso de binding en varias formas:

1. **Conversion Service**:

   - Si necesitas convertir datos de un tipo a otro durante el binding (por ejemplo, de String a Date), puedes usar un `ConversionService` que te permita definir conversores personalizados.

2. **Property Editors**:

   - Los PropertyEditor se utilizan para transformar datos de un formato (como una cadena) a un tipo específico. Aunque menos común en nuevas aplicaciones (reemplazados por los convertidores de `ConversionService`), siguen siendo una opción válida.

3. **Validation**:

   - Después de que Spring vincula los parámetros a un objeto, puedes validar el objeto usando la anotación `@Valid` junto con un BindingResult para capturar los errores.

     ```java
     @PostMapping("/crearUsuario")
     public String crearUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
           return "formularioUsuario";
        }
        // Guardar usuario en la base de datos
        return "usuarioDetalles";
     }
     ```

     - `@Valid` activa la validación de Usuario.

     - `BindingResult` captura cualquier error de validación.

## @RequestParam

La anotación @RequestParam en Spring MVC se utiliza para vincular los parámetros de una solicitud HTTP directamente a los argumentos de un método en un controlador. Esto es especialmente útil cuando deseas extraer parámetros de consulta, parámetros de formulario, o incluso datos enviados en la URL en solicitudes **GET** o **POST**.

```java
@GetMapping("/buscar")
public String buscar(@RequestParam("query") String query, Model model) {
    model.addAttribute("resultado", servicioDeBusqueda.buscar(query));
    return "resultados";
}
```

- El método buscar está mapeado a una URL como `/buscar`.

- El parámetro de la URL query (por ejemplo, `/buscar?query=spring`) se vincula al argumento query del método.

- El valor de query se pasa al servicio de búsqueda, y luego se agrega al modelo para renderizar la vista.

### Atributos de @RequestParam

1. **`value` (alias de name)**: Especifica el nombre del parámetro de solicitud que debe vincularse al argumento del método.

   ```java
   @RequestParam("query") String query
   ```

   `value` y `name` son equivalentes, por lo que puedes usar cualquiera de los dos.

2. **`required`**:

   - Indica si el parámetro es obligatorio o no.

   - Si required es `true` (valor predeterminado) y el parámetro no está presente en la solicitud, Spring lanzará una excepción `MissingServletRequestParameterException`.

   - Si required es `false`, el argumento puede ser `null` o usar un valor predeterminado si se proporciona uno.

     ```java
     @RequestParam(value = "page", required = false) Integer page
     ```

3. `defaultValue`: Proporciona un valor predeterminado si el parámetro no está presente en la solicitud. Esto también hace que el parámetro no sea obligatorio.

   ```java
   @RequestParam(value = "page", defaultValue = "0") Integer page
   ```

   Si la solicitud no incluye el parámetro page, entonces page tendrá el valor 0.

#### Ejemplos de Uso

Parámetro Obligatorio:

```java
@GetMapping("/producto")
public String getProducto(@RequestParam("id") Long id, Model model) {
    Producto producto = productoService.obtenerPorId(id);
    model.addAttribute("producto", producto);
    return "productoDetalle";
}
```

## @ModelAttribute
Es una poderosa herramienta que se utiliza para vincular datos a un modelo y pasarlos a una vista, o para prellenar un objeto de modelo con datos provenientes de una solicitud HTTP. Se puede utilizar tanto a nivel de método como de argumento, y su uso es clave para manejar datos de formularios, poblar objetos de modelo, y compartir datos comunes entre múltiples controladores.

1. **Prepara Datos Comunes para las Vistas**:

   - Cuando se usa a nivel de método, `@ModelAttribute` permite agregar datos al Model que estarán disponibles para todas las vistas que se rendericen como resultado de la ejecución del controlador.

2. **Poblar un Objeto de Modelo**:

   - Cuando se usa como argumento de un método en un controlador, `@ModelAttribute` indica que un objeto debe ser poblado con los datos de la solicitud (usualmente datos de un formulario), antes de que se invoque el método del controlador.

### Ejemplos de Uso

1. Usando `@ModelAttribute` a Nivel de Método

   - Cuando se coloca `@ModelAttribute` en un método de un controlador, ese método se ejecutará antes de que cualquier método de controlador anotado con `@RequestMapping` o anotaciones derivadas sea invocado. Esto es útil para configurar datos comunes.

     ```java
     @Controller
     public class ProductoController {

        @ModelAttribute
        public void agregarAtributosComunes(Model model) {
           model.addAttribute("categorias", categoriaService.obtenerTodas());
        }

        @GetMapping("/productos")
        public String listarProductos(Model model) {
           List<Producto> productos = productoService.obtenerTodos();
           model.addAttribute("productos", productos);
           return "listaProductos";
        }
     }
     ```

     - El método `agregarAtributosComunes` se ejecuta antes de `listarProductos`.

     - Añade una lista de categorías al modelo, que estará disponible en cualquier vista renderizada por este controlador.

2. Usando `@ModelAttribute` como Argumento de Método

   - Cuando `@ModelAttribute` se utiliza como argumento de un método en un controlador, Spring MVC automáticamente intenta poblar el objeto anotado con datos provenientes de la solicitud (por ejemplo, de un formulario).

     ```java
     @Controller
     public class UsuarioController {

        @PostMapping("/registrar")
        public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
           usuarioService.registrar(usuario);
           model.addAttribute("usuario", usuario);
           return "usuarioRegistrado";
        }
     }
     ```

     - `@ModelAttribute` Usuario usuario indica que Spring debe crear una instancia de `Usuario` y poblarla con los datos de la solicitud.

     - Si el formulario de registro envía campos como **nombre**, **email**, y **password**, Spring buscará campos coincidentes en la clase `Usuario` y los asignará.

3. **Personalización del Nombre del Atributo del Modelo**

   - Por defecto, Spring agrega el objeto al modelo usando el nombre de la clase en minúsculas como clave. Sin embargo, puedes personalizar el nombre del atributo con el parámetro `value`.

     ```java
     @PostMapping("/registrar")
     public String registrarUsuario(@ModelAttribute("nuevoUsuario") Usuario usuario, Model model) {
        usuarioService.registrar(usuario);
        model.addAttribute("usuario", usuario);
        return "usuarioRegistrado";
     }
     ```

     Aquí, el objeto `Usuario` se agrega al modelo con el nombre "`nuevoUsuario`".
