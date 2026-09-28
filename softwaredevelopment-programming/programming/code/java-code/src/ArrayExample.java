public class ArrayExample {
  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.println(matrix[i][j]);
      }
    }
  }
}
// int[] numbers = { 22, 33, 44, 55, 66, 77, 88, 99, 1 };
// int arrayLength = numbers.length; // 9
// for (int i = arrayLength - 1; i >= 0; i--) {
// System.out.println(numbers[i]);
// }