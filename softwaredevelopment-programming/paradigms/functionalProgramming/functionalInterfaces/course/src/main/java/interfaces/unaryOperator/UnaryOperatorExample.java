package interfaces.unaryOperator;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = (Integer number) -> {
            return number * number;
        };
        int result = unaryOperator.apply(3);
        System.out.println(result);
    }
}
