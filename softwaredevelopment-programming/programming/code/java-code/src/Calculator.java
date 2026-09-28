public class Calculator {
  public static void main(String[] args) {
    int a = 10;
    int b = 20;
    int result = addOperation(a, b);
    System.out.println(result);
  }

  public static int addOperation(int a, int b) {
    int total = a + b;
    return total;
  }
}