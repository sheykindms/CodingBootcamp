package com.codingbootcamp.week1.day2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StdString implements Iterable<Character> {

  protected final char[] base;

  /**
   * Constructor that creates string from the specified char array.
   *
   * @param base char array to use as a string base
   */
  public StdString(char[] base) {
    this.base = base;
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
   * @param stdString to copy from.
   */
  public StdString(StdString stdString) {
    this.base = stdString.base.clone();
  }

  /**
   * Returns amount of characters in the string. For example for the string "cat" it should return 3
   *
   * @return amount of characters in the string.
   */
  public int length() {
    return this.base.length;
  }

  /**
   * Creates new class StdString that includes both strings in it. For example, if
   * there is a string "cat" and another string "dog", append method should return
   * a new string with the value "catdog".
   *
   * @param that another string that should be appended to this string
   * @return new StdString that includes new value
   * @throws NullPointerException
   */
  public StdString append(StdString that) {
    char[] arr = new char[that.toCharArray().length + this.base.length];
    System.arraycopy(this.base, 0, arr, 0, this.base.length);
    System.arraycopy(that.toCharArray(), 0, arr, this.toCharArray().length, that.toCharArray().length);
    return new StdString(arr);
  }

  /**
   * Returns value of the string in a form of char array.
   *
   * @return value of the string in a form of char array.
   */
  public char[] toCharArray() {
    return new StdString(this).base;
  }

  /**
   * Returns character from the specific index of the string. Examples
   * "cat", 0 => 'c'
   * "dog", 2 => 'g'
   *
   * @param index of the character that needs to be retured
   * @return character
   * @throws IndexOutOfBoundsException
   */
  public char charAt(int index) {
    return this.base[index];
  }

  /**
   * Finds first index of a specific character in the string, or -1 if character not found.
   * For example:
   * "cat", 'a' => 0
   * "asdef23q4asdfasdf", 'd' => 2
   * "dog", 'q' => -1
   *
   * @param target character to search for
   * @return index of the character or -1
   */
  public int indexOf(char target) {
    for (int i = 0; i < this.base.length; i++) {
      if (this.base[i] == target) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Equals that follows all best practices and compares all characters in the
   * current string with the characters in the other string.
   *
   * @param otherObj to compare with
   * @return true or false
   */
  @Override
  public boolean equals(final Object otherObj) {
    if (otherObj == null || otherObj.getClass() != this.getClass()) {
      return false;
    }
    StdString stdString = (StdString) otherObj;
    return Arrays.equals(stdString.base, this.base);
  }

  /**
   * Hash code is calculated by summing all the int representation of each
   * character in the string. Zero length string should return 0.
   *
   * @return hash of the string
   */
  @Override
  public int hashCode() {
    int hash = 0;
    for (char c : this) {
      hash += c;
    }
    return hash;
  }

  /**
   * Converts StdString to java.lang.String. This is the only place where it is
   * allowed to use java.lang.String.
   *
   * @return java.lang.String representation of this string
   */
  @Override
  public String toString() {
    return new String(this.base);
  }

  /**
   * Create Character iterator. No specific requirements, classic Java iterator.
   *
   * @return
   */
  @Override
  public Iterator<Character> iterator() {

    return new Iterator<>() {
      int i = 0;

      @Override
      public boolean hasNext() {
        return i < base.length;
      }

      @Override
      public Character next() {
        if (hasNext()) {
          return base[i++];
        }
        throw new NoSuchElementException();
      }
    };
  }

  @Override
  public void forEach(final Consumer<? super Character> action) {
    for (char ch : this) {
      action.accept(ch);
    }
  }

}
