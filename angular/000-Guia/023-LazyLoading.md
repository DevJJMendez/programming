# Lazy Loading

El "Lazy Loading" (carga diferida o carga perezosa) en Angular es una técnica que permite cargar módulos de la aplicación solo cuando son necesarios, en lugar de cargar todos los módulos al inicio de la aplicación. Esto ayuda a reducir el tiempo de carga inicial de la aplicación y mejora el rendimiento general al cargar solo lo que se necesita en un momento dado.

En una aplicación Angular, los módulos se pueden cargar de forma diferida utilizando el sistema de enrutamiento. Cuando se configura correctamente, Angular solo cargará los módulos requeridos cuando el usuario navegue a una ruta específica que los necesite. Esto significa que los módulos que no se utilizan inicialmente no se cargarán hasta que sean necesarios, lo que reduce la carga inicial de la aplicación y mejora la experiencia del usuario.

Para implementar Lazy Loading en Angular, se debe configurar el enrutador para que cargue los módulos de forma diferida. Esto se logra utilizando la función `loadChildren` en la configuración de las rutas del enrutador. Por ejemplo:

  ```php
  const routes: Routes = [
  { path: 'dashboard', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule) },
  { path: 'profile', loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule) },
  // Otras rutas
  ];
  ```
  En este ejemplo, cuando el usuario navega a la ruta /dashboard, el módulo DashboardModule se cargará de forma diferida. Lo mismo ocurre cuando el usuario navega a la ruta /profile, donde se cargará el módulo ProfileModule.
  
Es importante tener en cuenta que el Lazy Loading en Angular puede mejorar significativamente el rendimiento de la aplicación al reducir el tiempo de carga inicial. Sin embargo, debe usarse con moderación y planificarse cuidadosamente para garantizar una experiencia de usuario coherente y sin interrupciones.