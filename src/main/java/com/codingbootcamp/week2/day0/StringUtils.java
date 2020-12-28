package com.codingbootcamp.week2.day0;


import com.codingbootcamp.week0.day2.Sorting;

public class StringUtils extends com.codingbootcamp.week1.day0.StringUtils {

  /**
   * Sorting array in-place according to the lexicographical strings order.
   *
   * @param target array that needs to be sorted
   */
  public static void sortStrings(String[] target) {
    if (target == null) {
      return;
    }
    Sorting.sort(target, String::compareTo);
  }
}
