# Trees
Los árboles (trees) son estructuras de datos jerárquicas que almacenan información de manera organizada, permitiendo operaciones eficientes de búsqueda, inserción y eliminación.

## ¿Qué es un Árbol?
Un árbol es una estructura de datos no lineal compuesta por nodos conectados mediante enlaces (edges).

* Un nodo raíz (root) es el punto de entrada del árbol.

* Cada nodo puede tener hijos (subnodos conectados a él).

* Los nodos sin hijos se llaman hojas (leaf nodes).

Ejemplo de un árbol binario:
```markdown
        10   ← Raíz  
       /  \  
      5    15  
     / \     \  
    2   7     20
```

## ¿Para qué sirven los Árboles?
Los árboles se usan en múltiples aplicaciones, como:

* Estructuras de búsqueda (BST, AVL, Red-Black Tree).

* Representación de jerarquías (Dominios, archivos, XML, JSON).

* Inteligencia Artificial (Árboles de decisión).

* Compiladores (Árboles de sintaxis abstracta).

* Redes y Bases de Datos (B-Trees, Trie).

## Estructura de un Árbol
Un árbol tiene:

* Nodos con valores o datos.

* Enlaces (edges) que conectan nodos.

* Raíz (root) como nodo inicial.

* Altura: Número máximo de niveles.

* Grado: Número de hijos de un nodo.

* Nodos hoja: Nodos sin hijos.

## ¿Qué resuelven los Árboles?
* Búsqueda eficiente (BST reduce la búsqueda de O(n) a O(log n)).

* Optimización de almacenamiento (Trie para almacenar prefijos).

* Priorización de tareas (Heap para scheduling).

* Compresión de datos (Huffman Tree).

## Tipos de Árboles
1. Árbol Binario: Cada nodo tiene como máximo 2 hijos.

1. Árbol Binario de Búsqueda (BST): La izquierda contiene valores menores y la derecha mayores.

1. Árbol AVL: BST auto-balanceado.

1. Árbol Rojo-Negro: BST con balanceo adicional.

1. Heap (Montículo): Árbol completo usado en colas de prioridad.

1. B-Trees: Usados en bases de datos y sistemas de archivos.

## Implementación
Implementación de un Árbol Binario de Búsqueda (BST)
```java
class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierda = this.derecha = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.valor) {
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertarRec(raiz.derecha, valor);
        }

        return raiz;
    }

    public void inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            inOrden(raiz.derecha);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(2);
        arbol.insertar(7);
        arbol.insertar(20);

        System.out.println("Recorrido en orden:");
        arbol.inOrden(arbol.raiz); // Salida: 2 5 7 10 15 20
    }
}

```