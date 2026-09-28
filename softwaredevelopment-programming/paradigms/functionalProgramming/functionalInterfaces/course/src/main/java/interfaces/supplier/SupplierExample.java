package interfaces.supplier;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
        int newRandomNumber = randomNumber.get();
        System.out.println(newRandomNumber);
    }
}
