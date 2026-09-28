# LocalStorage
LocalStorage es una API de almacenamiento del lado del cliente, proporcionada por los navegadores web modernos, que permite guardar datos clave-valor de manera persistente, es decir, que los datos no se eliminan al cerrar el navegador.

🔐 No se envía al servidor en cada petición (como sí lo hacen las cookies).

## ¿Cuál es su estructura?
LocalStorage está basado en un objeto de tipo Storage, accesible desde window.localStorage.

Características principales:

Capacidad: ~5MB por dominio.

Formato de datos: Solo se almacenan strings.

Persistencia: Los datos permanecen hasta que el usuario o el script los borra.

Alcance: Disponible para todas las pestañas del mismo dominio.

## Métodos principales:
```js
// Guardar
localStorage.setItem("clave", "valor");

// Leer
const valor = localStorage.getItem("clave");

// Eliminar un valor
localStorage.removeItem("clave");

// Limpiar todo
localStorage.clear();

// Obtener el número de claves
localStorage.length;

// Obtener el nombre de una clave por índice
localStorage.key(0);
```

## ¿Qué resuelve?
LocalStorage resuelve la necesidad de almacenar datos persistentes en el cliente, sin requerir una base de datos ni comunicación constante con el servidor.

Ejemplos comunes:

Guardar el estado de inicio de sesión (token JWT).

Recordar preferencias del usuario (tema oscuro, idioma).

Almacenar caché local para mejorar rendimiento.

Formularios parcialmente completados.

## Consideraciones de seguridad y buenas prácticas
❌ No almacenar información sensible (tokens, contraseñas, datos personales).

❗ Está sujeto a vulnerabilidades XSS si no validas y sanitizas el código del lado cliente.

✅ Úsalo para almacenar datos no críticos o temporales que mejoran la UX.

# SessionStorage
SessionStorage es una API de almacenamiento del lado del cliente que permite guardar datos clave-valor en el navegador solo durante la sesión actual.

📌 Los datos desaparecen al cerrar la pestaña o ventana del navegador.
📌 Está diseñado para almacenar datos temporalmente y no se comparte entre pestañas.

## ¿Cuál es su estructura?
SessionStorage está disponible mediante window.sessionStorage y comparte una interfaz similar a localStorage:
```js
// Guardar datos
sessionStorage.setItem("usuario", "JJ");

// Obtener datos
const user = sessionStorage.getItem("usuario");

// Eliminar un ítem
sessionStorage.removeItem("usuario");

// Borrar todo
sessionStorage.clear();
```

## ¿Qué resuelve?
Resuelve la necesidad de almacenar datos temporales por sesión del navegador, sin usar cookies ni afectar otras pestañas.

Usos comunes:

Datos temporales durante una sesión de usuario.

Formularios multistep (wizard) que no necesitan persistencia.

Filtros aplicados en una búsqueda que se reinician al cerrar la pestaña.

## Diferencias clave con localStorage:
￼
Característica	localStorage	sessionStorage
Persistencia	Permanente (hasta que se borre)	Temporal (hasta cerrar la pestaña)
Alcance	Todas las pestañas del mismo dominio	Solo la pestaña actual
Capacidad (aprox)	~5MB	~5MB
Compartido entre tabs	✅ Sí	❌ No

## Consideraciones importantes
⚠️ No almacenes información sensible (como contraseñas o tokens) sin cifrado.

❗ Vulnerable a ataques XSS si tu app no está protegida.

💡 Ideal para datos que no deben sobrevivir al cierre de la pestaña.