package com.codingbootcamp.week0.day1;

public class Alphabet {

  private static final int ALPHABET_LENGTH = 26;

  /**
   * Generates alphabet
   *
   * @return array of alphabetical characters
   */
  public static char[] generateAlphabet() {
    int firstAsciiChar = 97;
    char[] alphabet = new char[ALPHABET_LENGTH];
    for (int i = 0; i < ALPHABET_LENGTH; i++) {
      alphabet[i] = (char) firstAsciiChar++;
    }
    return alphabet;
  }

  /**
   * Generates reversed alphabet
   *
   * @return reversed array of alphabetical characters
   */
  public static char[] generateReversedAlphabet() {
    int firstAsciiChar = 122;
    char[] alphabet = new char[ALPHABET_LENGTH];
    for (int i = 0; i < ALPHABET_LENGTH; i++) {
      alphabet[i] = (char) firstAsciiChar--;
    }
    return alphabet;
  }
}
