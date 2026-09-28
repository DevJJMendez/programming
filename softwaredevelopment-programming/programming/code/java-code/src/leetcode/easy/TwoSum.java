package leetcode.easy;

class Solution {
  public static void main(String[] args) {
    int[] numbers = { 9, 33, 44, 55, 2, 3, 77, 88, 120, 11 };
    int arrayLenght = numbers.length;
    for (int i = 0; i < arrayLenght; ++i) {
      System.out.println(numbers[i]);
    }
    // twoSum(numbers, 5);
  }

  // brute force solution
  // public static int[] twoSum(int[] numbers, int target) {
  // int arrayLenght = numbers.length;
  // for (int i = 0; i < arrayLenght; i++) {
  // for (int j = 0; j < arrayLenght; j++) {
  // if (numbers[i] + numbers[j] == target)
  // return new int[] { i, j };
  // }
  // }
  // return new int[] {};
  // }
}