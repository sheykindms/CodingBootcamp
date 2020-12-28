package com.codingbootcamp.week0.day2;

import com.codingbootcamp.misc.Writer;

public class StringTools {

  /**
   * Prints an array of characters using Writer interface
   *
   * @param target to be printed
   * @param writer to be used as a printer
   */
  public static void println(Character[] target, Writer writer) {
    if (writer == null) {
      throw new NullPointerException();
    } else if (target == null || target.length == 0) {
      return;
    }
    for (Character character : target) {
      writer.write(character);
    }
    writer.write('\n');
  }

  /**
   * Reverses the string
   *
   * @param target to reverse
   * @return reversed String
   */
  public static String reverse(String target) {
    StringBuilder reversed = new StringBuilder();
    for (int i = target.length() - 1; i >= 0; i--) {
      reversed.append(target.charAt(i));
    }
    return reversed.toString();
  }

  /**
   * Converts target string to integer number
   *
   * @param target to convert
   * @return integer number
   */
  public static int toInt(String target) {
    char[] ints;
    int result = 0;
    if (target == null || target.equals("")) {
      throw new IllegalArgumentException();
    } else if (target.charAt(0) != '-') {
      ints = target.toCharArray();

      for (char anInt : ints) {
        int dig = (int) anInt - 48;
        if ((dig < 0) || (dig > 9)) {
          throw new IllegalArgumentException();
        }
        result *= 10;
        result += dig;
      }
    } else {
      ints = target.toCharArray();

      for (char anInt : ints) {
        if (anInt == '-') {
          continue;
        }
        int digit = (int) anInt - 48;
        if ((digit < 0) || (digit > 9)) {
          throw new IllegalArgumentException();
        }
        result *= 10;
        result += digit;
      }
      result = ~result + 1;
    }
    return result;
  }
}