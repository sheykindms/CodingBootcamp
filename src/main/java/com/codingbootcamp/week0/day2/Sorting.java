package com.codingbootcamp.week0.day2;

import java.util.Comparator;

public class Sorting {

  /**
   * Sorts an array of objects using comparator in ascending order
   *
   * @param target     is an array to sort
   * @param comparator to compare elements in array
   */
  public static <T> void sort(T[] target, Comparator<T> comparator) {
    if (comparator == null) {
      throw new NullPointerException();
    }
    for (int i = 0; i < target.length - 1; i++) {
      for (int j = i + 1; j < target.length; j++) {
        if (comparator.compare(target[i], target[j]) > 0) {
          T buff = target[i];
          target[i] = target[j];
          target[j] = buff;
        }
      }
    }
  }

  /**
   * Sorts an array of objects using comparator in descending order
   *
   * @param target     is an array to sort
   * @param comparator to compare elements in array
   */
  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
    if (comparator == null) {
      throw new NullPointerException();
    }
    for (int i = 0; i < target.length - 1; i++) {
      for (int j = i + 1; j < target.length; j++) {
        if (comparator.compare(target[i], target[j]) < 0) {
          T buff = target[i];
          target[i] = target[j];
          target[j] = buff;
        }
      }
    }
  }
}
