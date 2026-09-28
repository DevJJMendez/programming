package streams;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(22, 34, 11, 7, 12, 95, 122, 63, 23, 4);
        List<String> nameList = Arrays.asList("alicia", "alicia", "juana", "pedro", "marcos", "andres");

        numberList.stream()
                .filter((Integer number) -> number % 2 == 0)
                .peek((Integer number) -> {
                    System.out.println("Filtrado: " + number);
                })
                .map((Integer number) -> {
                    return number * number;
                })
                .peek((Integer number) -> {
                    System.out.println("Mapeado: " + number);
                })
                .forEach((Integer number) -> {
                    System.out.println(number);
                });
    }
}
