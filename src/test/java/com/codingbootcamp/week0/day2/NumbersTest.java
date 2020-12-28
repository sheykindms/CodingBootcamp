package com.codingbootcamp.week0.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NumbersTest {
  @Test
  void testSort() {
    var input = new int[]{3, 8, -1, 5, 0};
    var expected = new int[]{-1, 0, 3, 5, 8};

    Numbers.sort(input);

    assertArrayEquals(expected, input);
  }

  @Test
  void testSortWithNull() {
    try {
      Numbers.sort(null);
      fail();
    } catch (NullPointerException e) {
    }
  }
}
