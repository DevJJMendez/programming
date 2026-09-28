package interfaces.biConsumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> PrintNameAndAge = (String name, Integer age) -> {
            System.out.println("User name: " + name + ", Edad: " + age);
        };
        PrintNameAndAge.accept("Jhaminton", 23);
    }
}
