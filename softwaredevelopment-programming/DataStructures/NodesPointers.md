# Nodos y Punteros
Los nodos y punteros son elementos clave en estructuras de datos como listas enlazadas, árboles y grafos. Permiten organizar y manipular datos en memoria de manera eficiente.

## ¿Qué son los Nodos y Punteros?
### Nodo
Un nodo es una estructura que contiene un dato y una o más referencias (punteros) a otros nodos. Es la unidad básica de muchas estructuras de datos.

### Puntero:
Un puntero es una variable especial que almacena la dirección de memoria de otro objeto o nodo. Permite conectar estructuras de datos dinámicas sin necesidad de memoria contigua.

Ejemplo visual de un Nodo con Puntero:
```rust
|  Data  | Pointer  |
  [  10  |   *---->] -----> [  20  |   *---->] -----> NULL
```
Aquí cada nodo apunta al siguiente usando un puntero.

## ¿Para qué sirven los Nodos y Punteros?
* Permiten construir estructuras de datos dinámicas como listas enlazadas, árboles y grafos.

* Ayudan a administrar memoria de forma eficiente y sin desperdicios.

* Facilitan la conexión y navegación entre elementos sin necesidad de índices fijos.

* Se usan en programación orientada a objetos (POO) para crear estructuras complejas.

**Casos de uso en la vida real**:
* Sistemas de archivos (exploradores de carpetas) usan estructuras basadas en nodos.

* Árboles de decisión en inteligencia artificial.

* Bases de datos usan árboles y listas enlazadas internamente.

* Compiladores almacenan el código fuente en estructuras como árboles sintácticos.

## ¿Cuál es su estructura?
Un nodo generalmente tiene las siguientes partes:

1️⃣ Dato: Contiene la información almacenada en el nodo.

2️⃣ Puntero: Referencia a otro nodo o estructura en memoria.

Ejemplo en una lista enlazada simple:
```yaml
Node:
| data | pointer |

memory example:
[  5  | * ] → [ 10 | * ] → [ 15 | NULL ]
```

Ejemplo en un árbol binario:
```css
      [ 10 ]
     /     \
  [ 5 ]   [ 15 ]
```
Aquí cada nodo tiene dos punteros: izquierdo y derecho.

### ¿Qué problemas resuelven los Nodos y Punteros?
* Eficiencia en memoria: No requieren espacio contiguo como los arrays.

* Flexibilidad: Permiten modificar estructuras de datos dinámicamente.

* Acceso rápido a datos relacionados: Como en árboles y grafos.

* Gestión eficiente de memoria: Evitan el desperdicio en estructuras dinámicas.