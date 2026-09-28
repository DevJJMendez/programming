# Guards

Son funciones que permiten controlar el acceso a las rutas, proporcionando una manera de ejecutar lógica antes de la navegación. Los guards pueden utilizarse para diversas tareas, como la autenticación, la autorización, la validación de datos, etc.

## Tipos de Guards

- **Global Guards**
  
  - **beforeEach**
  Se ejecuta antes de cada navegación.
    ```js
    const router = createRouter({
      history: createWebHistory(process.env.BASE_URL),
      routes
    });

    router.beforeEach((to, from, next) => {
      // Lógica de autenticación
      if (to.matched.some(record => record.meta.requiresAuth)) {
        if (!isAuthenticated()) {
          next({ path: '/login', query: { redirect: to.fullPath } });
        } else {
          next();
        }
      } else {
        next();
      }
    });

    function isAuthenticated() {
      // Implementa tu lógica de autenticación
      return false; // O true si el usuario está autenticado
    }

    export default router;
    ```
  - **beforeResolve**
  Se ejecuta justo antes de que la navegación sea confirmada, después de que todos los guards y resoluciones de componentes asíncronos hayan sido resueltos.
    ```js
    router.beforeResolve((to, from, next) => {
      // Lógica adicional antes de confirmar la navegación
      next();
    });
    ```
  - **afterEach**
  Se ejecuta después de cada navegación, pero no interfiere con la navegación misma.
    ```js
    router.afterEach((to, from) => {
      // Lógica después de la navegación, por ejemplo, para el seguimiento de analíticas
    });
    ```
- **Per-route Guards**:
  
  - **beforeEnter**
    Se define directamente en las rutas y se ejecuta antes de entrar en esa ruta específica.
    ```js
    const routes = [
      {
        path: '/dashboard',
        name: 'Dashboard',
        component: Dashboard,
        meta: { requiresAuth: true },
        beforeEnter: (to, from, next) => {
          if (isAuthenticated()) {
            next();
          } else {
            next({ path: '/login' });
          }
        }
      }
    ];
    ```
- **In-component Guards**:
  
  - **beforeRouteEnter**
  Se ejecuta antes de que el componente sea creado. No puede acceder a `this` porque el componente aún no ha sido creado.
    ```js
    <script>
    export default {
      name: 'MyComponent',
      beforeRouteEnter(to, from, next) {
        // Lógica antes de que el componente sea creado
        next(vm => {
          // `vm` es la instancia del componente
          // Lógica que necesita acceso a la instancia del componente
        });
      }
    };
    </script>
    ```
  - **beforeRouteUpdate**
  Se ejecuta cuando el componente ya está creado pero la ruta actualizada reutiliza el mismo componente.
    ```js
    <script>
    export default {
      name: 'MyComponent',
      beforeRouteUpdate(to, from, next) {
        // Lógica cuando la ruta actualizada reutiliza el mismo componente
        next();
      }
    };
    </script>
    ```
  - **beforeRouteLeave**
  Se ejecuta cuando se está por salir de la ruta que utiliza el componente.
    ```js
    <script>
    export default {
      name: 'MyComponent',
      beforeRouteLeave(to, from, next) {
        // Lógica antes de salir de la ruta actual
        next();
      }
    };
    </script>
    ```

## Resumen y Buenas Prácticas

- **Autenticación y Autorización**: Usa beforeEach y beforeEnter para manejar autenticación y autorización.

- **Lógica Asíncrona**: Usa beforeResolve para lógica que depende de resoluciones asíncronas después de otros guards.

- **Limpieza y Analíticas**: Usa afterEach para lógica que no necesita interferir con la navegación, como el seguimiento de analíticas.

- **Comportamiento de Componentes**: Usa guards en componentes (beforeRouteEnter, beforeRouteUpdate, beforeRouteLeave) para manejar lógica específica del ciclo de vida del componente.