package com.codingbootcamp.week1.day0;

public class StringUtils {

  private static final int DIFF = 32;

  /**
   * Defines if the provided character is uppercase according to ASCII table
   *
   * @param ch to check
   * @return true if the character is uppercase
   */
  public static boolean isAsciiUppercase(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    return ch >= 'A' && ch <= 'Z';
  }

  /**
   * Defines if the provided character is lowercase according to ASCII table
   *
   * @param ch to check
   * @return true if the character is lowercase
   */
  public static boolean isAsciiLowercase(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    return ch >= 'a' && ch <= 'z';
  }

  /**
   * Defines if the provided character is numeric according to ASCII table
   *
   * @param ch to check
   * @return true if the character is numeric
   */
  public static boolean isAsciiNumeric(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    return ch >= '0' && ch <= '9';
  }

  /**
   * Defines if the provided character is alphabetic according to ASCII table
   *
   * @param ch to check
   * @return true if the character is alphabetic
   */
  public static boolean isAsciiAlphabetic(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
    return ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z';
  }

  /**
   * Converts the provided character into uppercase
   *
   * @param ch to be converted
   * @return character in uppercase
   */
  public static char toAsciiUppercase(char ch) {
    return isAsciiUppercase(ch) || !isAsciiAlphabetic(ch) ? ch : (char) ((int) ch - DIFF);
  }

  /**
   * Converts the provided character into lowercase
   *
   * @param ch to be converted
   * @return character in lowercase
   */
  public static char toAsciiLowercase(char ch) {
    return isAsciiLowercase(ch) || !isAsciiAlphabetic(ch) ? ch : (char) ((int) ch + DIFF);
  }

  /**
   * Converts the provided input array of characters into the
   * StringBuilder object of uppercased characters
   *
   * @param input array to be converted into uppercase
   * @return StringBuilder object of uppercased characters
   */
  public static StringBuilder makeUppercase(char[] input) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      if (isAsciiAlphabetic(input[i]) && !isAsciiUppercase(input[i])) {
        input[i] = toAsciiUppercase(input[i]);
      }
    }
    return stringBuilder.append(input);
  }

  /**
   * Converts the provided input array of characters into the
   * StringBuilder object of lowercased characters
   *
   * @param input array to be converted into lowercase
   * @return StringBuilder object of lowercased characters
   */
  public static StringBuilder makeLowercase(char[] input) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      if (isAsciiAlphabetic(input[i]) && !isAsciiLowercase(input[i])) {
        input[i] = toAsciiLowercase(input[i]);
      }
    }
    return stringBuilder.append(input);
  }

  /**
   * Converts the provided input array of characters into the
   * StringBuilder object of camelcased characters
   *
   * @param input to be transformed into camelcase
   * @return StringBuilder object of camelcased characters
   */
  public static StringBuilder makeCamel(char[] input) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      if (isAsciiAlphabetic(input[i]) && i % 2 != 0) {
        input[i] = toAsciiUppercase(input[i]);
      } else if (isAsciiAlphabetic(input[i])) {
        input[i] = toAsciiLowercase(input[i]);
      }
    }
    return stringBuilder.append(input);
  }

  /**
   * Defines if the provided array is either alphabetical or numerical
   *
   * @param input to be checked
   * @return true if the provided array is either alphabetical or numerical
   */
  public static boolean isStringAlphaNumerical(char[] input) {
    for (char c : input) {
      if (!isAsciiAlphabetic(c) && !isAsciiNumeric(c) && c != ' ') {
        return false;
      }
    }
    return true;
  }

  /**
   * Merges two-dimensional array of characters into a one-dimensional array
   *
   * @param input array to be merged
   * @return one-dimensional array of characters
   */
  public static char[] concatStrings(char[][] input) {
    StringBuilder accum = new StringBuilder();
    for (char[] chars : input) {
      for (char ch : chars) {
        if (ch <= 255) {
          accum.append(ch);
        }
      }
    }
    return accum.toString().toCharArray();
  }

  /**
   * Converts the provided array of characters to an integer value
   *
   * @param input array to be converted
   * @return integer value according to input value
   */
  public static int toInt(char[] input) {
    int accumulator = 0;
    int offset = 0;
    if (input[0] == '-') {
      offset = 1;
    }
    int rank = pow(10, input.length - 1 - offset);
    for (int i = offset; i < input.length; i++) {
      if (isAsciiNumeric(input[i])) {
        accumulator += rank * (input[i] - 48);
        rank /= 10;
      } else {
        throw new NumberFormatException();
      }
    }
    return input[0] == '-' ? -accumulator : accumulator;
  }

  private static int pow(int base, int pow) {
    int accum = base;
    for (int i = 1; i < pow; i++) {
      accum *= base;
    }
    return accum;
  }
}