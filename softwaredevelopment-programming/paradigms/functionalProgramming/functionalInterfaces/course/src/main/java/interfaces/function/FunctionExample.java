package interfaces.function;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> getLenght = (stringParam) -> stringParam.length();
        String userName = "Jhaminton";
        int userNameLenght = getLenght.apply(userName);
        System.out.println(userNameLenght);
    }
}
