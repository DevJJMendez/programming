# Middleware
Un Middleware es un componente software reutilizable que se ejecuta entre el cliente y la lógica principal de una aplicación, interceptando solicitudes (requests) y respuestas (responses) para realizar operaciones adicionales sin alterar directamente el core del sistema.

En términos simples:

🗣️ "Es una capa intermedia que puede modificar, validar o enriquecer una petición antes de que llegue al controlador, y/o una respuesta antes de que llegue al cliente."

## ¿Dónde se usa?
Frameworks como:

Express.js (Node.js)

Spring Boot (Java)

Laravel (PHP)

ASP.NET Core

Sistemas distribuidos y arquitecturas microservicio

Gateways, proxies, API Gateways

Middleware de red (para comunicación entre sistemas)

## ¿Qué tareas puede realizar un Middleware?
￼
Tipo de Middleware	Ejemplo de función
🔒 Autenticación	Verificar tokens JWT, sesiones, API Keys
🛂 Autorización	Validar roles y permisos del usuario
📋 Logging	Registrar detalles de cada request (IP, ruta, etc)
🧼 Sanitización	Limpiar inputs para evitar XSS/SQLi
📦 Validación	Validar estructura de datos (JSON, query, body)
⚡ Compresión	Aplicar GZIP, Brotli al response
🧠 Caching	Cachear respuestas de ciertos endpoints
🧭 Routing (en Gateways)	Redirigir el request a otro microservicio
🧾 Headers	Agregar/modificar headers personalizados
📉 Rate Limiting	Limitar la cantidad de peticiones
🔁 Redirección	Redireccionar URLs viejas o control de versiones

## ¿Cómo se estructura un Middleware?
Generalmente sigue esta estructura:
```bash
[Cliente] ---> [Middleware 1] ---> [Middleware 2] ---> [Controlador / lógica de negocio] ---> [Response]
```
Cada middleware:

Puede modificar la petición.

Puede interrumpir la ejecución si detecta un problema (como falta de autenticación).

Puede llamar al siguiente middleware (o no).

## Ejemplo práctico en Express (Node.js)
```js
// Middleware de logging
function logRequest(req, res, next) {
  console.log(`[${req.method}] ${req.url}`);
  next(); // sigue al siguiente middleware
}

// Middleware de autenticación
function authenticate(req, res, next) {
  if (req.headers.authorization === 'Bearer token123') {
    next();
  } else {
    res.status(401).send('Unauthorized');
  }
}

// Aplicación Express
app.use(logRequest);        // Se aplica a todas las rutas
app.use('/api', authenticate); // Solo para rutas que comienzan con /api

app.get('/api/data', (req, res) => {
  res.send('Datos seguros');
});
```

Middleware en Spring Boot (Java)
En Spring, se implementa como Filter:
```java
@Component
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getHeader("Authorization") == null) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            chain.doFilter(request, response); // Pasa al siguiente filtro
        }
    }
}
```

## ¿Qué resuelve?
Modularidad: Permite separar responsabilidades (Single Responsibility Principle).

Reusabilidad: Un middleware puede usarse en múltiples proyectos.

Escalabilidad: Permite extender la funcionalidad sin romper la lógica del core.

Centralización: Evita repetir código de validación, autenticación, logging, etc.

## Buenas prácticas
Los middlewares deben ser pequeños, claros y especializados.

Orden importa: por ejemplo, la autenticación debe venir antes que el acceso a los datos.

No hacer lógica de negocio compleja en middlewares.

Dejar siempre claro cuándo se llama next() (o su equivalente).

No bloquear el flujo con errores no controlados.

## ¿Y en arquitecturas distribuidas?
En microservicios y serverless, se usan middlewares en gateways como:

API Gateway (AWS, Azure, Kong, NGINX)

Service Mesh (Istio, Linkerd) que aplican middlewares de red como:

mTLS

Retry

Timeouts

Observabilidad (Prometheus, Jaeger)

Autenticación OIDC, JWT, etc.