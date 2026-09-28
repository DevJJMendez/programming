# Rutas con parametros

Las rutas con parámetros son una característica poderosa que te permite definir rutas dinámicas que pueden aceptar valores variables como parte de la URL. Estos parámetros pueden ser utilizados para pasar información específica entre diferentes componentes de la aplicación.

- Definición de la Ruta con Parámetros:

  Para definir una ruta con parámetros en Angular, puedes incluir un segmento de la ruta precedido por dos puntos (:) seguido por el nombre del parámetro en la definición de la ruta.

  ```ts
  const routes: Routes = [{ path: "detalle/:id", component: DetalleComponent }];
  ```

  En este ejemplo, :id es el parámetro de la ruta que puede contener un valor dinámico.

- Acceso a los Parámetros en el Componente:

  Para acceder a los parámetros de la ruta en el componente asociado, puedes utilizar el servicio `ActivatedRoute` proporcionado por Angular. Este servicio proporciona acceso a la información de la ruta actual, incluidos los parámetros de la ruta.

  ```ts
  import { Component, OnInit } from "@angular/core";
  import { ActivatedRoute } from "@angular/router";

  @Component({
    selector: "app-detalle",
    templateUrl: "./detalle.component.html",
    styleUrls: ["./detalle.component.css"],
  })
  export class DetalleComponent implements OnInit {
    constructor(private route: ActivatedRoute) {}

    ngOnInit(): void {
      this.route.paramMap.subscribe((params) => {
        const id = params.get("id");
        console.log("ID:", id);
      });
    }
  }
  ```

  En este ejemplo, `ActivatedRoute` se inyecta en el constructor del componente y se utiliza para suscribirse a los cambios en los parámetros de la ruta. Puedes acceder a los parámetros de la ruta utilizando el método `paramMap` y luego llamando a `get('nombreDelParametro')` para obtener el valor del parámetro específico.

- Navegación con Parámetros:

  Para navegar a una ruta con parámetros desde otro componente o enlace HTML, puedes utilizar el método `navigate()` del servicio Router y proporcionar los parámetros necesarios en el array de argumentos.

  ```ts
  import { Router } from '@angular/router';

  constructor(private router: Router) { }

  irADetalle(id: string) {
    this.router.navigate(['/detalle', id]);
  }
  ```

  En este ejemplo, `irADetalle()` es un método que navega a la ruta /detalle y pasa el parámetro id.
