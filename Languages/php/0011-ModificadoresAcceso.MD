# Programación Orientada a Objetos

Es un paradigma de programación que se basa en el concepto de "objetos", que pueden contener datos en forma de campos (también conocidos como propiedades o atributos) y código, en forma de procedimientos (también conocidos como métodos).

## Encapsulación

La encapsulación es un principio de la programación orientada a objetos que se refiere a la limitación del acceso a ciertos componentes de un objeto, como propiedades y métodos, desde el exterior de la clase. En PHP, la encapsulación se logra mediante el uso de modificadores de acceso y métodos de acceso, como los métodos getters y setters.

## Modificadores de Acceso
    
Los modificadores de acceso son palabras clave que se utilizanpara controlar el acceso a las propiedades y métodos de una clase. Estos modificadores determinan si una propiedad o método es accesible desde dentro de la propia clase, desde clases herederas (subclases) o desde fuera de la clase.

## Modificadores de acceso

Hay tres modificadores de acceso principales en PHP:
    
- `public`: Los miembros (propiedades y métodos) declarados como públicos son accesibles desde cualquier lugar, tanto desde dentro de la propia clase, como desde clases herederas y desde fuera de la clase. Es el nivel de acceso menos restrictivo.

- `protected`: Los miembros declarados como protegidos son accesibles desde dentro de la propia clase y desde clases herederas, pero no desde fuera de la clase. Este nivel de acceso se utiliza cuando se desea restringir el acceso a clases que heredan de la clase actual.

- `private`: Los miembros declarados como privados son accesibles solo desde dentro de la propia clase. No son accesibles desde clases herederas ni desde fuera de la clase. Este nivel de acceso es el más restrictivo.

Estos modificadores de acceso permiten aplicar el principio de encapsulación en la programación orientada a objetos, donde se busca ocultar la implementación interna de una clase y permitir el acceso controlado a sus miembros.

## Métodos Getters y Setters

Los métodos `getters` y `setters` son métodos públicos utilizados para acceder y modificar propiedades privadas de una clase. Esto permite controlar y validar el acceso a las propiedades, manteniendo la encapsulación.
```php
class Usuario {
    private $nombre;

    public function getNombre() {
        return $this->nombre;
    }

    public function setNombre($nuevoNombre) {
        // Validación o lógica adicional antes de asignar el nuevo nombre
        $this->nombre = $nuevoNombre;
    }
}

$usuario = new Usuario();
$usuario->setNombre("Juan");
echo $usuario->getNombre(); // Imprime: Juan
```

En este ejemplo, la propiedad `$nombre` es privada y no puede ser accedida directamente desde fuera de la clase. En su lugar, se accede a ella a través de los métodos `setNombre()` y `getNombre()`, que permiten establecer y obtener el valor del nombre, respectivamente. Esto proporciona un control adicional sobre la forma en que se manipulan los datos internos de la clase.

La encapsulación en PHP ayuda a garantizar la integridad de los datos y facilita el mantenimiento del código, ya que limita el acceso directo a las propiedades y métodos internos de una clase.