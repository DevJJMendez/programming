## redirectTo
La propiedad redirectTo se utiliza para redirigir una ruta a otra ruta especificada. Se utiliza cuando deseas redirigir automáticamente a una ruta diferente cuando se navega a una determinada ruta.

**Ejemplo**
```ts
const routes: Routes = [
  { path: "", redirectTo: "/home", pathMatch: "full" },
  { path: "home", component: HomeComponent },
  { path: "about", component: AboutComponent },
  // Otras rutas
];
```
En este ejemplo, cuando se navega a la ruta raíz (`''`), se redirige automáticamente a la ruta `/home`. La propiedad `pathMatch: 'full'` indica que la coincidencia debe ser exacta para que se aplique la redirección.

## pathMatch
La propiedad pathMatch se utiliza para especificar cómo se debe coincidir una ruta con la URL. Puede tener uno de los siguientes valores:

* `'full'`: Indica que la coincidencia debe ser exacta. La ruta se coincidirá solo si la URL es idéntica a la ruta especificada.

* `'prefix'`: Indica que la coincidencia debe ser parcial. La ruta se coincidirá si la URL comienza con la ruta especificada.

    ```ts
    const routes: Routes = [
      { path: "home", component: HomeComponent },
      { path: "dashboard", component: DashboardComponent },
      { path: "dashboard/:id", component: DashboardDetailComponent },
      { path: "**", redirectTo: "/home", pathMatch: "full" }, // Redirigir a /home para cualquier otra ruta
    ];
    ```
    En este ejemplo, la última ruta con path: `'**'` actúa como una ruta de comodín que coincide con cualquier ruta que no coincida con las rutas anteriores. La propiedad pathMatch: `'full'` asegura que solo se aplique la redirección si la URL coincide exactamente con la ruta especificada.