# GraphQL
GraphQL es un lenguaje de consulta y entorno de ejecución para APIs, desarrollado originalmente por Facebook en 2012 y liberado en 2015 como open source.

Es una alternativa moderna a REST para permitir a los clientes consultar exactamente los datos que necesitan y nada más.

## ¿Para qué sirve GraphQL?
Sirve para:

✅ Hacer APIs más flexibles y eficientes.
✅ Permitir que los clientes pidan datos personalizados en una sola solicitud.
✅ Reducir overfetching (traer más datos de los necesarios) y underfetching (necesitar varias llamadas para obtener toda la información).
✅ Mejorar la experiencia del consumidor de la API (especialmente para frontend, móviles, etc).

## ¿Qué resuelve?
￼
Problema en REST	Cómo lo resuelve GraphQL
Overfetching (traer más datos de los necesarios)	El cliente define qué campos específicos quiere.
Underfetching (necesitar múltiples requests)	Puede traer múltiples recursos en una sola petición.
APIs rígidas y difíciles de evolucionar	Con un esquema flexible, evolucionas sin romper clientes.
Versionamiento de API	No necesitas versionar tradicionalmente (los cambios son evolutivos y gestionados).
Ineficiencia en redes lentas (móviles)	Minimiza datos transmitidos; solo lo que pides.

## Estructura y Componentes de GraphQL
Una API GraphQL típica tiene estos componentes:

￼
Componente	Descripción
Schema	Define los tipos de datos y las operaciones disponibles (consultas, mutaciones, suscripciones).
Query	Una solicitud de solo lectura para obtener datos.
Mutation	Una solicitud para modificar datos (crear, actualizar, eliminar).
Subscription	Para recibir datos en tiempo real (por ejemplo, notificaciones de cambios).
Resolver	Funciones que resuelven las operaciones definidas en el esquema conectándose a bases de datos, servicios, etc.
Type System	Tipos de datos como String, Int, Boolean, Object, List, Enum, Input, etc.

## ¿Cómo funciona?
1. El cliente hace una consulta a la API GraphQL especificando exactamente los datos que necesita.
Ejemplo de consulta (Query):
```graphql
{
  user(id: "123") {
    name
    email
    posts {
      title
    }
  }
}
```
2. El servidor GraphQL procesa esa consulta, ejecuta resolvers específicos y devuelve solo los datos solicitados.
Ejemplo de respuesta (JSON):
```json
{
  "data": {
    "user": {
      "name": "JJ",
      "email": "jj@example.com",
      "posts": [
        { "title": "Introducción a GraphQL" }
      ]
    }
  }
}
```

## Conceptos clave que debes dominar
￼
Concepto	Explicación
Strongly Typed Schema	GraphQL es fuertemente tipado. Cada dato tiene un tipo definido en el schema.
Introspection	GraphQL permite al cliente preguntar por la estructura de la API dinámicamente.
Self-documenting	La API se documenta sola gracias al esquema y la introspección.
Single Endpoint	A diferencia de REST, GraphQL trabaja sobre un solo endpoint (por ejemplo, /graphql).
Batching y Caching	Se puede optimizar aún más combinando múltiples consultas en una sola, y aplicando técnicas de cacheo como Apollo Client o Relay.

## Ventajas de usar GraphQL
✅ Consulta personalizada: Tú decides qué datos necesitas.
✅ Un solo request: Puedes traer información de múltiples fuentes en una sola llamada.
✅ Sin overfetching/underfetching: Solo traes lo que usas.
✅ Más eficiente en móviles y redes lentas.
✅ Evolución fácil: Agregar nuevos campos no rompe clientes existentes.
✅ Excelente soporte de herramientas: GraphiQL, Apollo, Relay, Hasura, etc.

🧱 Desventajas y desafíos
⚠️ Complejidad inicial: Diseñar bien el esquema y los resolvers no es trivial.
⚠️ Problemas de N+1 Queries: Si no manejas correctamente los resolvers, puedes causar múltiples llamadas a DB. (Solución: usar herramientas como DataLoader).
⚠️ Seguridad: Debes validar consultas y controlar el acceso a campos (Authorization profunda).
⚠️ Caching complejo: Cachear respuestas en GraphQL es menos trivial que en REST (aunque Apollo ayuda mucho).

## Ejemplo de un esquema simple
```go
type User {
  id: ID!
  name: String!
  email: String!
  posts: [Post!]!
}

type Post {
  id: ID!
  title: String!
  content: String
  author: User!
}

type Query {
  user(id: ID!): User
  users: [User!]!
}

type Mutation {
  createUser(name: String!, email: String!): User!
}
```
En este esquema:

Puedes consultar un usuario (user(id: ID!): User).

Puedes listar todos los usuarios (users).

Puedes crear un nuevo usuario (createUser).

## Buenas prácticas en GraphQL
￼
Buenas prácticas	Explicación
Diseña el schema pensando en el consumidor	Que sea intuitivo y útil.
Controla la profundidad de las consultas	Limita queries muy anidadas para evitar ataques de rendimiento.
Usa paginación	En listas grandes (posts, users, etc.).
Implementa autorización a nivel de campo	No todos deben poder ver/modificar todo.
Agrega validaciones de input	No confíes en los datos que llegan.
Optimiza resolvers con batching	Evita consultas N+1 a base de datos.

## ¿Dónde se usa GraphQL?
Facebook (obvio, ellos lo crearon).

GitHub API v4 (es totalmente GraphQL).

Shopify, Pinterest, Twitter (internamente).

Netflix, Airbnb, Trello, PayPal.

Muchos proyectos modernos que buscan eficiencia en comunicación cliente-servidor