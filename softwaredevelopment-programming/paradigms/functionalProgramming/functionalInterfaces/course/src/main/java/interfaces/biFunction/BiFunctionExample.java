package interfaces.biFunction;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (numberOne, numberTwo) ->
                numberOne + numberTwo;
        int result = biFunction.apply(11, 22);
        System.out.println(result);
    }
}
