# Linked List
Una Simple Linked List (Lista Enlazada Simple) es una estructura de datos dinámica donde los elementos están enlazados entre sí a través de punteros. Se diferencia de los arrays porque no necesita memoria contigua y puede crecer o reducirse según sea necesario.

## ¿Qué es una Simple Linked List?
Una lista enlazada es una colección de nodos donde cada nodo contiene:
1. Un valor (dato).

2. Una referencia (puntero) al siguiente nodo en la lista.

Ejemplo visual
```css
[ 10 | * ] → [ 20 | * ] → [ 30 | NULL ]
```
Cada nodo apunta al siguiente, formando una cadena de nodos conectados.

## ¿Para qué sirven las Listas Enlazadas Simples?
* Almacenar datos dinámicamente, sin necesidad de una cantidad fija de elementos.

* Insertar y eliminar elementos de manera eficiente (`O(1)` al inicio o al final).

* Evitar fragmentación de memoria, ya que los nodos pueden estar dispersos.

* Implementar otras estructuras de datos, como pilas, colas y grafos.

**Casos de uso en la vida real:**
* Historial de navegación en un navegador.

* Reproductores de música con listas de reproducción.

* Gestión de memoria en sistemas operativos.

* Estructuras en bases de datos como índices de búsqueda.

## Implementación
```java
class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    Nodo cabeza;

    // Método para agregar un nodo al inicio
    public void agregarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;  // El nuevo nodo apunta a la antigua cabeza
        cabeza = nuevo;  // La cabeza ahora es el nuevo nodo
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregarAlInicio(10);
        lista.agregarAlInicio(20);
        lista.agregarAlInicio(30);
        lista.imprimirLista();
    }
}
```
Salida esperada
```rust
30 -> 20 -> 10 -> NULL
```
Aquí agregamos elementos al inicio, por lo que el último agregado es el primero en la lista.

### Métodos adicionales en una Simple Linked List
Agregar al final
```java
public void agregarAlFinal(int dato) {
    Nodo nuevo = new Nodo(dato);
    if (cabeza == null) {
        cabeza = nuevo;
        return;
    }
    Nodo temp = cabeza;
    while (temp.siguiente != null) {
        temp = temp.siguiente;
    }
    temp.siguiente = nuevo;
}
```
Complejidad: O(n) (se recorre la lista para encontrar el último nodo).

Buscar un elemento
```java
public boolean buscar(int dato) {
    Nodo temp = cabeza;
    while (temp != null) {
        if (temp.dato == dato) {
            return true;
        }
        temp = temp.siguiente;
    }
    return false;
}
```
Complejidad: O(n) (hay que recorrer toda la lista en el peor caso).

Eliminar un nodo específico
```java
public void eliminar(int dato) {
    if (cabeza == null) return;

    if (cabeza.dato == dato) {
        cabeza = cabeza.siguiente;
        return;
    }

    Nodo temp = cabeza;
    while (temp.siguiente != null && temp.siguiente.dato != dato) {
        temp = temp.siguiente;
    }

    if (temp.siguiente != null) {
        temp.siguiente = temp.siguiente.siguiente;
    }
}
```
Complejidad: O(n) (en el peor caso hay que recorrer toda la lista).