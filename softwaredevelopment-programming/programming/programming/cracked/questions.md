Hablemos del paradigma Orientado a Objetos, la idea con este paradigma es hacerlo de forma agnostica; quiero decir sin importar el lenguaje.

¿Que es?
¿Cual es su estructura?
¿Que resuelve?


Enseñame todo lo que debo saber
¿Que son?
¿Cuales son sus tipos?
¿Que resuelven cada uno?

Enseñame todo lo que debo saber
¿Que resuelve?
¿Como lo resuelve?

Enseñame todo lo que debo saber

¿Que son?

¿Cual es su estructura?
¿Que resuelven?

Enseñame todo lo que debo saber


¿Cual es su estructura?

---
```java
public class ConectoresLogicos {
    public static void main(String[] args) {
        boolean p = true;   // "El número es par"
        boolean q = false;  // "El número es mayor que 10"

        // Conectores básicos
        boolean negacion = !p;       // ¬p
        boolean conjuncion = p && q; // p ∧ q
        boolean disyuncion = p || q; // p ∨ q
        boolean xor = p ^ q;         // p ⊕ q
        boolean implicacion = !p || q; // p → q
        boolean equivalencia = (p == q); // p ↔ q

        System.out.println("¬p = " + negacion);
        System.out.println("p ∧ q = " + conjuncion);
        System.out.println("p ∨ q = " + disyuncion);
        System.out.println("p ⊕ q = " + xor);
        System.out.println("p → q = " + implicacion);
        System.out.println("p ↔ q = " + equivalencia);
    }
}
```