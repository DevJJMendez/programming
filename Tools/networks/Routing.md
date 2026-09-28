# Routing
Routing (enrutamiento) en el contexto de redes, desarrollo web y aplicaciones se refiere al proceso de determinar cómo las solicitudes (requests) de los usuarios se manejan, se distribuyen y se dirigen hacia el destino correcto dentro de un sistema o red.

En aplicaciones web, específicamente, el routing se refiere a la forma en que las URL (Uniform Resource Locator) se asignan a controladores o funciones en el servidor para manejar y responder a las solicitudes de los clientes. El enrutamiento es fundamental para construir aplicaciones web y APIs, ya que permite que el servidor sepa qué acción tomar en respuesta a una solicitud de un cliente.

## ¿Cómo Funciona el Routing en una Aplicación Web?
En una aplicación web, el enrutamiento consiste en asignar diferentes rutas o URL a diferentes funciones o controladores en el servidor. Estas funciones o controladores son los encargados de procesar la solicitud y devolver la respuesta correspondiente. A nivel básico, el proceso de routing se realiza mediante los siguientes pasos:

Solicitud de un Cliente: Un usuario hace una solicitud, típicamente a través de un navegador web o una aplicación móvil, utilizando una URL. Ejemplo: https://miapp.com/usuarios.

Determinación de la Ruta: El servidor verifica la URL solicitada y consulta su conjunto de reglas de enrutamiento para determinar qué función o controlador debe manejar la solicitud.

Procesamiento de la Solicitud: Una vez que se ha identificado la ruta correspondiente, el servidor ejecuta la función asociada. Esta función puede realizar diferentes operaciones, como acceder a una base de datos, realizar cálculos o preparar datos para su visualización.

Respuesta del Servidor: Después de procesar la solicitud, el servidor responde al cliente con los datos o el contenido requerido, como una página HTML, un archivo JSON, una imagen, etc.

## Tipos de Routing
Dependiendo del contexto en el que se utilice, existen diferentes tipos de enrutamiento. Los más comunes son:

Routing del Lado del Servidor (Server-Side Routing):

En este enfoque, el enrutamiento se realiza en el servidor.

El servidor recibe la solicitud del cliente, determina cuál de las rutas debe ejecutarse y devuelve la respuesta al cliente.

El servidor mantiene el control completo sobre el flujo de datos y las acciones asociadas a cada ruta.

Ejemplo: Frameworks como Express en Node.js o Django en Python utilizan routing del lado del servidor.

Routing del Lado del Cliente (Client-Side Routing):

Este tipo de enrutamiento se utiliza en aplicaciones Single Page Applications (SPA).

En lugar de hacer una nueva solicitud al servidor para cada cambio de página, el enrutamiento se maneja completamente en el cliente mediante JavaScript.

El cliente (navegador) se encarga de manejar la URL y mostrar el contenido sin recargar toda la página.

Ejemplo: Frameworks como React con React Router o Vue.js con Vue Router son ejemplos de routing del lado del cliente.

Routing Híbrido:

Algunas aplicaciones modernas utilizan un enfoque híbrido, donde el enrutamiento se maneja tanto en el servidor como en el cliente, dependiendo de la situación.

Los servidores envían las primeras respuestas, pero el cliente se encarga del enrutamiento cuando se navega dentro de la misma aplicación.

Ejemplo: Next.js en el ecosistema de React usa enrutamiento híbrido, combinando SSR (Server-Side Rendering) y CSR (Client-Side Routing).

## Estructura de un Sistema de Routing
Un sistema de routing típico, ya sea del lado del servidor o del lado del cliente, sigue una estructura en la que cada ruta está asociada a una URL específica y un manejador o controlador que se ejecuta cuando esa ruta es alcanzada.

1. Patrones de Ruta
Las rutas pueden ser simples o complejas. Los patrones de ruta pueden incluir:

Rutas Estáticas: Las rutas fijas que coinciden exactamente con la URL solicitada.

Rutas Dinámicas: Las rutas que incluyen parámetros variables (por ejemplo, una ruta de producto que depende de un ID).

Rutas Anidadas: Rutas dentro de otras rutas, utilizadas en aplicaciones más complejas.

Ejemplo de rutas dinámicas:
```js
// Ruta en Express para obtener detalles de un usuario por ID
app.get('/usuarios/:id', (req, res) => {
  const userId = req.params.id;
  res.send(`Detalles del usuario con ID ${userId}`);
});
```
Métodos HTTP
Las rutas pueden estar asociadas con diferentes métodos HTTP. Cada método puede realizar una operación diferente en una URL:

GET: Solicitar datos del servidor (recuperar).

POST: Enviar datos al servidor (crear o actualizar).

PUT: Actualizar recursos existentes.

DELETE: Eliminar recursos.

Ejemplo de ruta con un método HTTP:
```js
// Ruta que maneja una solicitud GET
app.get('/productos', (req, res) => {
  res.json({ message: "Lista de productos" });
});

// Ruta que maneja una solicitud POST
app.post('/productos', (req, res) => {
  const nuevoProducto = req.body;
  res.json({ message: "Producto creado", producto: nuevoProducto });
});
```

## Buenas Prácticas de Routing
Usar Rutas Claras y Semánticas: Asegúrate de que las rutas sean intuitivas y fáciles de entender. Usa nombres descriptivos como /usuarios, /productos, etc., en lugar de rutas crípticas.

Manejo de Errores 404: Siempre maneja las rutas no encontradas con una respuesta 404 para asegurarte de que el cliente reciba una respuesta apropiada cuando acceda a una URL incorrecta.

Evitar la Lógica Compleja en las Rutas: Las rutas deben ser responsables solo de enrutarlas a la lógica apropiada. Evita poner demasiada lógica directamente en las rutas.

Protección de Rutas con Autenticación: Asegúrate de que las rutas sensibles estén protegidas y solo accesibles para usuarios autenticados (por ejemplo, rutas de administración).