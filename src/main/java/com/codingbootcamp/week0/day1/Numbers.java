package com.codingbootcamp.week0.day1;

public class Numbers {

  /**
   * Generates an array of ten integers
   *
   * @return array of integers from 0 to 9 including
   */
  public static int[] generateNumbers() {
    int[] numbers = new int[10];
    for (int i = 0; i < 10; i++) {
      numbers[i] = i;
    }
    return numbers;
  }

  /**
   * Checks if number is negative
   *
   * @param number to check if negative
   * @return true if number is negative
   */
  public static boolean isNegative(int number) {
    return number < 0;
  }

  /**
   * Generates an array of all unique combinations of
   * numbers where amount of digits == 3
   * For example:
   * "012", "013", ... "019", "023", ... "789"
   *
   * @return array of Strings
   */
  public static String[] generateTriplets() {
    StringBuilder uniqueElements = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k < 10; k++) {
          if (i < j && j < k) {
            uniqueElements.append(i).append(j).append(k).append(",");
          }
        }
      }
    }
    return uniqueElements.toString().split(",");
  }

  /**
   * Generates an array of all unique combinations.
   * For example:
   * "00 01", "00 02", "00 03" ... "98 99"
   *
   * @return array of Strings
   */
  public static String[] generateTuples() {
    StringBuilder uniqueElements = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (i < j) {
          uniqueElements.append(String.format("%02d %02d", i, j)).append(",");
        }
      }
    }
    return uniqueElements.toString().split(",");
  }

  /**
   * Generates and array of all unique numbers
   * For example:
   * "01", "02", "03" ... "78", "89"
   *
   * @param amount of digits in number
   * @return
   */
  public static String[] generateTuples(int amount) {
    StringBuilder uniqueElements = new StringBuilder();
    String[] array;
    if (isNegative(amount)) {
      throw new IllegalArgumentException();
    } else if (amount == 0) {
      return new String[0];
    } else {
      int pow = (int) Math.pow(10, amount);
      for (int i = 0; i < pow; i++) {
        String str = new String(convertToString(i));
        int iteration = 0;
        while (str.length() < amount) {
          if (iteration > 1) {
            break;
          }
          str = String.format("0%s", str);
          iteration++;
        }
        //Проверяем на наличие одинаковых цифр в числе
        char[] chars = str.toCharArray();
        boolean flag = false;
        for (int j = 0; j < chars.length; j++) {
          for (int k = j + 1; k < chars.length; k++) {
            if (chars[j] == chars[k]) {
              flag = true;
              break;
            }
          }
        }
        if (flag) {
          continue;
        }
        uniqueElements.append(str).append(",");
      }
      //Создаём массив строк для фильтрации
      String[] arr = uniqueElements.toString().split(",");
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == null) {
          continue;
        }
        char[] chars = arr[i].toCharArray();
        for (int j = i + 1; j < arr.length; j++) {
          int counter = 0;
          if (arr[j] == null) {
            continue;
          }
          char[] chars2 = arr[j].toCharArray();
          //Проверяем на наличие "зеркальных" чисел
          for (int k = chars2.length - 1; k >= 0; k--) {
            for (int l = 0; l < chars2.length; l++) {
              if (chars[l] == chars2[k]) {
                counter++;
                break;
              }
            }
          }
          if (counter == amount) {
            arr[j] = null;
          }
        }
      }
      //Считаем нуллы
      int numberOfNulls = countNulls(arr);
      //Создаем массив, который будем заполнять
      array = new String[arr.length - numberOfNulls];
      int index = 0;
      for (String s : arr) {
        if (s != null) {
          array[index++] = s;
        }
      }
    }
    System.out.println(array.length);
    return array;
  }

  //Вспомогательный метод
  private static int countNulls(String[] arr) {
    int nullCounter = 0;
    for (String s : arr) {
      if (s == null) {
        nullCounter++;
      }
    }
    return nullCounter;
  }

  /**
   * Converts integer number to an array of characters
   *
   * @param number to convert
   * @return array of characters
   */
  public static char[] convertToString(int number) {
    long num = number;
    long numberLength = (long) (Math.log10(Math.abs(num)) + 1);
    char[] digits;
    if (num == 0) {
      digits = new char[]{'0'};
    } else if (num < 0) {
      num = Math.abs(num);
      digits = new char[(int) ++numberLength];
      for (int i = digits.length - 1; i > 0; i--) {
        digits[i] = (char) (48 + num % 10);
        num /= 10;
      }
      digits[0] = '-';
    } else {
      digits = new char[(int) numberLength];
      for (int i = digits.length - 1; i >= 0; i--) {
        digits[i] = (char) (48 + num % 10);
        num /= 10;
      }
    }
    return digits;
  }
}