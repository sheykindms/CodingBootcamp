package com.codingbootcamp.week1.day3;


import com.codingbootcamp.week1.day0.StringUtils;

import java.util.Arrays;

public class StdString extends com.codingbootcamp.week1.day2.StdString {

  /**
   * Constructor that creates string from the specified char array.
   *
   * @param base char array to use as a string base
   */
  public StdString(char[] base) {
    super(base);
  }

  /**
   * Constructor that creates empty string with length 0.
   */
  public StdString() {
    this(new char[0]);
  }

  /**
   * Constructor that creates a copy of the string. New String should have
   * exactly same characters as the original one.
   *
   * @param that to copy from.
   */
  public StdString(StdString that) {
    super(that);
  }

  /**
   * Creates a copy of the string with all ascii characters in lower case. Example
   * "CaT12" => "cat12"
   * "   asdT2" => "   asdt2"
   *
   * @return new string with all the characters lowercase
   * @throws IllegalArgumentException if one of characters is not ascii
   */
  public StdString toAsciiLowerCase() {
    return new StdString(StringUtils.makeLowercase(this.toCharArray()).toString().toCharArray());
  }

  /**
   * Creates a copy of the string with all ascii characters in upper case. Example
   * "CaT12" => "CAT12"
   * "   asdT2" => "   ASDT2"
   *
   * @return new string with all the characters uppercase
   * @throws IllegalArgumentException if one of characters is not ascii
   */
  public StdString toAsciiUpperCase() {
    return new StdString(StringUtils.makeUppercase(this.toCharArray()).toString().toCharArray());
  }

  /**
   * return new string that contains all the characters of this string
   * from the specific range [from; to). From is inclusive, to is exclusive.
   * Example:
   * "ased 79s", 1 5 => "sed "
   * "cat-dog-123", 2, 3 => "t"
   *
   * @param from inclusive index
   * @param to   exclusive index
   * @return substring
   * @throws IndexOutOfBoundsException if index is incorrect
   * @throws IllegalArgumentException  if from >= to
   */
  public StdString subString(int from, int to) {
    return new StdString(Arrays.copyOfRange(this.toCharArray(), from, to));
  }

  /**
   * creates new string that includes all characters from this string and all
   * characters in all the input strings. Example:
   * "thisStr", "thatStr123", "thatStr222" => "thisStrthatStr123thatStr222"
   *
   * @param that strings to add
   * @return new string that combines all strings together
   * @throws NullPointerException if input is null
   */
  public StdString concat(StdString... that) {
    int olen = that.length;
    if (olen == 0) {
      return this;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(this.toString());
    for (StdString characters : that) {
      if (characters == null) {
        throw new NullPointerException();
      }
      sb.append(characters);
    }
    return new StdString(sb.toString().toCharArray());
  }

  /**
   * Split one string on array of substrings, based on separator. Example:
   * "cat trim dog", ' ' => "cat", "trim" "dog"
   * "one!str !two    ! three", '!' => "one", "str ", "two    ", " three"
   * "cat dog   ", ' ' => "cat", "dog", "", ""
   * "cat dog   ", '!' => "cat dog   "
   *
   * @param separator to use for splitting the string
   * @return array of strings
   */
  public StdString[] split(char separator) {
    String[] strings = this.toString().split(separator + "");
    StdString[] stdStrings = new StdString[strings.length];
    for (int i = 0; i < strings.length; i++) {
      stdStrings[i] = new StdString(strings[i].toCharArray());
    }
    return stdStrings;
  }

  /**
   * Removes all the whitespaces at the beginning and at the end of the string
   * and returns result in a new string. For example:
   * "  hi    " => "hi"
   * "hi" => "hi"
   * "    1      2" => "1      2"
   * " " => ""
   *
   * @return new string without whitespaces
   */
  public StdString trim() {
    if (this.toCharArray().length == 0) {
      return new StdString(new char[0]);
    }
    char[] arr = this.toCharArray();
    int start = 0;
    while (arr[start] == ' ') {
      start++;
    }
    int end = arr.length - 1;
    while (arr[end] == ' ') {
      end--;
    }
    return new StdString(arr).subString(start, ++end);
  }

  /**
   * removes all cases of a specified character in a string and returns
   * new string without it. Example:
   * "new,1,2,3" ',' => "new123"
   * "  1  2 ", ' ' => "12"
   * "asdf123", '!' => "asdf123"
   *
   * @param toRemove character to search for
   * @return new string without specified character
   */
  public StdString removeCharacter(char toRemove) {
    char[] arr = this.toCharArray();
    int counter = 0;

    for (char c : arr) {
      if (toRemove == c) {
        counter++;
      }
    }
    int newArrLength = arr.length - counter;
    int index = 0;
    char[] res = new char[newArrLength];
    for (char c : arr) {
      if (toRemove != c) {
        res[index++] = c;
      }
    }
    return new StdString(res);
  }
}
