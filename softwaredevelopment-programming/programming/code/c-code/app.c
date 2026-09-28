#include <stdio.h>
int main()
{
  int a = 10;
  int *p = a; // Declaración de un puntero
  // p = &a; // El puntero "p" almacena la dirección de "a"

  printf("Valor de a: %d\n", a);             // Muestra el valor de "a"
  printf("Dirección de a: %p\n", &a);        // Muestra la dirección de "a"
  printf("Valor del puntero p: %p\n", p);    // Muestra el valor almacenado en "p" (dirección de "a")
  printf("Valor al que apunta p: %d\n", *p); // Muestra el valor al que apunta "p" (valor de "a")
  return 0;
}