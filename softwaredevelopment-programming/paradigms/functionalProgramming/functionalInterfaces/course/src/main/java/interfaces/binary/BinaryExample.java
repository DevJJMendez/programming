package interfaces.binary;

import java.util.function.BinaryOperator;

public class BinaryExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (numberOne, numberTwo) -> {
            return numberOne + numberTwo;
        };
        int result = binaryOperator.apply(10, 10);
        System.out.println(result);
    }
}
