package Lists;

public class LinkedListExample {

}

class Node {
  int data; // Campo que guarda el valor del nodo.
  Node next; // Referencia al siguiente Node en la lista. Es null si este nodo es el ultimo.

  // Constructor Node(int data) — crea la instancia y asigna el valor data. next
  // queda en null por defecto.
  Node(int data) {
    this.data = data;
  }
}

class LinkedList {
  // Node head; — referencia al primer nodo de la lista. Si la lista está vacía,
  // head == null.
  protected Node head;
  protected Node tail;
  int size = 0;

  // void insertFront(int value) — método que inserta un nuevo nodo al inicio de
  // la lista (operación O(1)).
  void insertFront(int value) {
    Node node = new Node(value);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head = node;
    }
    size++;
  }

  void ShowDataList() {
    Node temporalSlot = head;
    while (temporalSlot != null) {
      System.out.println("[" + temporalSlot.data + "]--->");
      temporalSlot = temporalSlot.next;
    }
    System.out.println("null");
  }
}