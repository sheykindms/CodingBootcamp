package com.codingbootcamp.week2.day1;

/**
 * Same as TextPrinter, however in this case program expect 2 arguments:
 * 1. test
 * 2. character to use to draw a box
 * <p>
 * For example, for the input:
 * "text", "?"
 * <p>
 * the program should print:
 * ????????
 * ? test ?
 * ????????
 */
public class TextPrinter2 {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.printf("Please provide 2 input argument, current amount: %d\n", args.length);
      return;
    }
    char symbol = args[0].charAt(0);
    String text = " " + args[1] + " ";
    int frameWidth = text.length() + 2;
    int frameHeight = 3;
    for (int row = 0; row < frameHeight; row++) {
      for (int column = 0; column < frameWidth; column++) {
        if (row == 1 && column == 1) {
          System.out.print(text);
          column += text.length() - 1;
        } else {
          System.out.print(symbol);
        }
      }
      System.out.print('\n');
    }
  }
}