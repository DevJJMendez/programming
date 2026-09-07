Nomenclaturas y Estructuras en Endpoints RESTful
En APIs RESTful, la nomenclatura y estructura de los endpoints debe ser clara, coherente, y seguir principios establecidos para mantener la usabilidad y mantenibilidad. Vamos a analizar las convenciones comunes para los 4 métodos principales (GET, POST, PUT, DELETE) y enfocarnos en los aspectos relacionados con PUT.

Principios Generales para Nomenclaturas en Endpoints
Endpoints como sustantivos:

Los endpoints deben reflejar recursos (entidades) y no acciones.
Por ejemplo, usa /categories en lugar de /getCategories.
Jerarquía lógica:

Las rutas deben reflejar relaciones entre recursos.
Ejemplo:
/categories/{id}/products representa productos de una categoría específica.
Uso de plural en los nombres de los recursos:

Los recursos generalmente se nombran en plural para indicar que son colecciones.
Ejemplo:
/categories para representar una lista de categorías.
Evitar verbos en la URL:

Los verbos ya están representados por el método HTTP (GET, POST, PUT, DELETE). No es necesario duplicar la acción en el endpoint.
Incorrecto: /createCategory
Correcto: /categories
Claridad en las rutas dinámicas:

Usa variables en las rutas para especificar recursos individuales.
Ejemplo:
/categories/{id} para acceder a una categoría específica.

## Métodos HTTP y Nomenclatura de Endpoints
1. GET (Obtener un recurso o colección)
Propósito: Recuperar información de un recurso.
Convención:
Para una colección: /categories
Para un recurso específico: /categories/{id}
Ejemplos:
Obtener todas las categorías: GET /categories
Obtener una categoría por su ID: GET /categories/{id}

2. POST (Crear un nuevo recurso)
Propósito: Crear un nuevo recurso.
Convención:
Usa la ruta de la colección para crear un recurso.
No incluyas un ID en el endpoint, ya que el servidor generalmente genera el ID.
Ejemplo:
Crear una categoría: POST /categories
Datos enviados en el cuerpo:
```json
{
  "name": "Electronics",
  "description": "Devices and gadgets"
}
```

3. PUT (Actualizar un recurso existente o reemplazarlo por completo)
Propósito: Actualizar o reemplazar un recurso existente.
Convención general:
El endpoint debe incluir el identificador del recurso a actualizar.
Ejemplo típico: /categories/{id}
PUT reemplaza todo el recurso. Si deseas actualizar parcialmente, considera usar PATCH.
Diferencias en Estructuración de PUT
Al estructurar endpoints con PUT, hay varias convenciones, dependiendo de cómo se representa el recurso:

PUT en la raíz del recurso con el ID:
Esta es la práctica más común.
```bash
PUT /categories/{id}
```
Actualiza la categoría con el ID especificado.
Ejemplo de datos en el cuerpo:
```json
{
  "name": "New Name",
  "description": "Updated description"
}
```

PUT con el recurso explícito en el endpoint:
Menos común, pero algunas organizaciones lo prefieren por claridad.
```bash
PUT /categories/{id}/category
```
En este caso, el endpoint hace explícito que estamos actualizando el recurso "category" en sí.

Recomendación para PUT:
Usa siempre /resource/{id} (la primera convención) a menos que haya un motivo claro para agregar más contexto. Esto mantiene la API más sencilla y fácil de usar.

4. DELETE (Eliminar un recurso)
Propósito: Eliminar un recurso existente.
Convención:
El endpoint debe incluir el identificador del recurso a eliminar.
Ejemplo:
Eliminar una categoría: DELETE /categories/{id}

## Convenciones Avanzadas
Relaciones entre recursos:

Usa rutas anidadas para recursos dependientes.
Ejemplo:
Obtener productos de una categoría: GET /categories/{id}/products
Crear un producto en una categoría: POST /categories/{id}/products
Acciones específicas en recursos:

Cuando necesitas realizar una acción que no es CRUD, usa subrecursos o rutas bien definidas.
Ejemplo:
Activar una categoría: POST /categories/{id}/activate
Errores comunes al estructurar PUT:

Confundir PUT y PATCH:
PUT reemplaza completamente un recurso.
PATCH actualiza parcialmente un recurso.
No validar entradas: Si el cliente envía un cuerpo incompleto o incorrecto, debes manejar esto adecuadamente.
Endpoints redundantes: Evita agregar rutas innecesarias como /categories/{id}/update.