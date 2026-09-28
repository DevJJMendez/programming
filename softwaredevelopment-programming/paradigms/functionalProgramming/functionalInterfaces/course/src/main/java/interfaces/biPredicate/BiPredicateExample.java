package interfaces.biPredicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, Integer> isLengthEqual = (String string, Integer lenght) -> string.length() == lenght;
        System.out.println(isLengthEqual.test("jhaminton", 7));
        System.out.println(isLengthEqual.test("jhaminton", 9));
    }
}
