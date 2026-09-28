## Snippets
Los Snippets en Postman son pequeños fragmentos de código predefinidos que te ayudan a escribir scripts de manera rápida y eficiente, ya sea en Pre-request o en Tests (Post-request). Estos Snippets son particularmente útiles para automatizar tareas comunes y realizar validaciones sin necesidad de escribir todo el código desde cero. Postman proporciona una serie de Snippets que puedes personalizar según tus necesidades.

### ¿Dónde encontrar los Snippets en Postman?
1. **Pre-request Script**: Cuando escribes scripts que se ejecutan antes de que se envíe la solicitud, puedes utilizar Snippets para automatizar la configuración de variables, generar datos, y más.

2. **Tests (Post-request Script)**: Los Snippets en esta sección son útiles para automatizar la validación de respuestas, la extracción de datos de las respuestas HTTP y la definición de condiciones de éxito o fallo.

En ambas secciones, encontrarás una lista de Snippets en el lado derecho del editor de scripts de Postman.

### Principales Snippets en Postman
1. **Status code: Code is 200**

   * Este Snippet valida si el código de estado HTTP de la respuesta es 200 (OK), lo que indica que la solicitud fue exitosa.

      ```js
      pm.test("El código de estado es 200", function () {
          pm.response.to.have.status(200);
      });
      ```

2. **Response body: Contains string**

   * Este Snippet verifica si la respuesta contiene una cadena de texto específica, útil para validar la presencia de información clave en el cuerpo de la respuesta.

      ```js
      pm.test("El cuerpo de la respuesta contiene la cadena 'success'", function () {
          pm.expect(pm.response.text()).to.include("success");
      });
      ```

3. **Response body: JSON value check**

   * Este Snippet es ideal para validar si un valor JSON en la respuesta coincide con un valor esperado. Muy útil para verificar respuestas en formato JSON.

      ```js
      pm.test("El valor de 'name' es correcto", function () {
          var jsonData = pm.response.json();
          pm.expect(jsonData.name).to.eql("John Doe");
      });
      ```

4. **Response time is less than 200ms**

   * Este Snippet verifica si el tiempo de respuesta de la solicitud es menor a un valor específico, lo que te permite controlar el rendimiento de tus APIs.

      ```js
      pm.test("El tiempo de respuesta es menor a 200ms", function () {
          pm.expect(pm.response.responseTime).to.be.below(200);
      });
      ```

5. **Set an environment variable**

   * Este Snippet establece una variable de entorno basada en la respuesta recibida, lo que te permite reutilizar datos en futuras solicitudes.

      ```js
      var jsonData = pm.response.json();
      pm.environment.set("user_id", jsonData.id);
      ```

6. **Set a global variable**

   * Este Snippet es similar al anterior, pero establece una variable global en lugar de una variable de entorno.

      ```js
      var jsonData = pm.response.json();
      pm.globals.set("auth_token", jsonData.token);
      ```

7. **Clear an environment variable**

   * Este Snippet te permite limpiar (eliminar) una variable de entorno cuando ya no la necesites.

      ```js
      pm.environment.unset("user_id");
      ```

8. **Clear a global variable**

   * Similar al anterior, pero para variables globales.

      ```js
      pm.globals.unset("auth_token");
      ```

9. Console log

   * Este Snippet te permite imprimir mensajes en la consola de Postman, lo que es útil para depurar valores de variables y respuestas.

      ```js
      console.log("Este es el valor de user_id: " + pm.environment.get("user_id"));
      ```

10. **Check for a successful POST request**

    * Este Snippet valida si una solicitud POST se realizó con éxito al verificar si el código de estado es 201 (Created).

      ```js
      pm.test("El código de estado es 201 (Created)", function () {
          pm.response.to.have.status(201);
      });
      ```

11. Content-Type is present

    * Este Snippet verifica si el encabezado **Content-Type** está presente en la respuesta, lo que es útil para asegurar que el tipo de contenido de la respuesta es correcto.

      ```js
      pm.test("Content-Type está presente", function () {
          pm.response.to.have.header("Content-Type");
      });
      ```

12. Response body: Is equal to a string

    * Este Snippet verifica si el cuerpo de la respuesta es exactamente igual a una cadena específica.

      ```js
      pm.test("El cuerpo de la respuesta es exactamente igual a 'success'", function () {
          pm.expect(pm.response.text()).to.eql("success");
      });
      ```

13. **Save Response**

    * Este Snippet guarda la respuesta completa en una variable de entorno o global, para que puedas usarla posteriormente.

      ```js
      var responseText = pm.response.text();
      pm.environment.set("lastResponse", responseText);
      ```

### ¿Cómo usar los Snippets en Postman?
1. **Seleccionar un Snippet**: Cuando estés en la sección de Pre-request o Tests, verás la lista de Snippets a la derecha del editor de scripts.

2. **Clic en el Snippet**: Al hacer clic en cualquier Snippet, Postman automáticamente copiará el código predefinido en tu editor.

3. **Personalizar el Snippet**: Una vez que el Snippet esté en tu editor, puedes personalizarlo según tus necesidades. Por ejemplo, puedes cambiar los valores esperados, los nombres de las variables, o agregar lógica adicional.

4. **Ejecutar la solicitud**: Al ejecutar la solicitud, el script del Snippet se ejecutará automáticamente, ya sea antes (Pre-request) o después (Tests) de que la solicitud se envíe.

### Ventajas de Usar Snippets en Postman
1. **Ahorro de tiempo**: No es necesario escribir todo el código manualmente. Los Snippets te permiten realizar tareas comunes con solo un clic.

2. **Facilidad de uso**: Son fáciles de implementar y personalizar, lo que reduce la curva de aprendizaje.

3. **Depuración rápida**: Muchos Snippets incluyen validaciones y salidas de consola que son útiles para depurar problemas en las solicitudes.

4. **Estándar de calidad**: Los Snippets garantizan que estás utilizando las mejores prácticas al validar respuestas o gestionar variables, lo que mejora la consistencia y la calidad de tus pruebas.