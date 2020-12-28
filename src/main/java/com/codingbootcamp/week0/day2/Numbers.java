package com.codingbootcamp.week0.day2;

public class Numbers {

  /**
   * A bubble sorting algorithm that sorts an array of integers
   *
   * @param target to sort
   */
  public static void sort(int[] target) {
    for (int i = 0; i < target.length - 1; i++) {
      for (int j = i + 1; j < target.length; j++) {
        if (target[j] < target[i]) {
          int buf = target[j];
          target[j] = target[i];
          target[i] = buf;
        }
      }
    }
  }
}