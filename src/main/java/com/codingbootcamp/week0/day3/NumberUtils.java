package com.codingbootcamp.week0.day3;

public class NumberUtils {

  /**
   * Calculates factorial of the number iteratively
   *
   * @param number to calculate its factorial
   * @return integer number
   */
  public static int factorialNormal(int number) {
    if (number < 0) {
      throw new IllegalArgumentException();
    }
    if (number == 0) {
      return 0;
    }
    int factorial = 1;
    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }
    return factorial;
  }

  /**
   * Calculates factorial of the number recursively
   *
   * @param number to calculate its factorial
   * @return integer number
   */
  public static int factorialRecursive(int number) {
    if (number < 0) {
      throw new IllegalArgumentException();
    }
    return number == 1 ? number : number * factorialRecursive(number - 1);
  }

  /**
   * Performs the operation of raising a number to a power iteratively
   *
   * @param base  the number itself
   * @param power the power for the number
   * @return calculated integer number
   */
  public static int powerNormal(int base, int power) {
    if (power < 0) {
      throw new IllegalArgumentException();
    }
    int result = base;
    for (int i = 1; i < power; i++) {
      result *= base;
    }
    return power == 0 ? 1 : result;
  }

  /**
   * Performs the operation of raising a number to a power recursively
   *
   * @param base  the number itself
   * @param power the power for the number
   * @return calculated integer number
   */
  public static int powerRecursive(int base, int power) {
    if (power < 0) {
      throw new IllegalArgumentException();
    }
    if (power == 0) {
      return 1;
    }
    return power == 1 ? base : base * powerRecursive(base, power - 1);
  }

  /**
   * Calculates the value of Fibonacci number by its index recursively
   *
   * @param index of number in a fib row
   * @return Fibonacci integer number
   */
  public static int fibRecursive(int index) {
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    return index < 2 ? index : fibRecursive(index - 1) + fibRecursive(index - 2);
  }

  /**
   * Creates an array of Fibonacci numbers recursively
   *
   * @param length of array of fibonacci numbers
   * @return Fibonacci array of integer numbers
   */
  public static int[] fibSequence(int length) {
    if (length < 0) {
      throw new IllegalArgumentException();
    }
    if (length == 0) {
      return new int[length];
    }
    int[] fibs = new int[length];
    fibs[0] = 1;
    fibs[1] = 1;
    for (int i = 2; i < length; i++) {
      fibs[i] = fibs[i - 1] + fibs[i - 2];
    }
    return fibs;
  }

  /**
   * Calculates the square root of a number, or returns -1 if there is no root
   *
   * @param target to calculate the square root
   * @return integer number
   */
  public static int sqrt(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    for (int i = 1; i < target; i++) {
      if (i * i == target) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Defines if the target number is prime or not
   *
   * @param target number to check if prime
   * @return true if target is prime
   */
  public static boolean isPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    int dividers = 0;
    for (int i = 1; i <= target; i++) {
      if (target % i == 0) {
        dividers++;
      }
    }
    return dividers == 2;
  }

  /**
   * Finds the next prime number after the provided number
   *
   * @param target number to start from
   * @return next prime integer number
   */
  public static int nextPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    for (int i = 2; i < target; i++) {
      if (target % i == 0) {
        target++;
        i = 2;
      }
    }
    return target;
  }
}
