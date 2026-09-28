package interfaces.consumer;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(98, 88, 78, 68, 58, 48, 38, 28, 18);
        Consumer<Integer> integerConsumer = (Integer param) -> {
            System.out.println(param + 2);
        };
        numbers.forEach(integerConsumer);
    }
}
