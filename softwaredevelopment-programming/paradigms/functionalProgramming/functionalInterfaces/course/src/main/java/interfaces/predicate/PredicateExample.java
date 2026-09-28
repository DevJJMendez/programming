package interfaces.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isNumberGreater = (number) -> number > 10;
        System.out.println(isNumberGreater.test(2));
        System.out.println(isNumberGreater.test(11));
    }
}
