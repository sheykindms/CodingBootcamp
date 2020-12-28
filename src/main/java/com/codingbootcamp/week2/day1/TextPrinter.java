package com.codingbootcamp.week2.day1;

public class TextPrinter {

  /**
   * The program prints the text from the input argument in a box like this:
   * <p>
   * /#################\
   * # test in the box #
   * \#################/
   * <p>
   * if input argument is an empty string box will look like this:
   * /##\
   * #  #
   * \##/
   * <p>
   * if there is no input argument (or more than one) it is expected from
   * the program to print:
   * Please provide only one input argument, current amount: %d\n
   * <p>
   * with the current amount of input arguments
   *
   * @param args
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.printf("Please provide only one input argument, current amount: %d\n", args.length);
      return;
    }
    String text = " " + args[0] + " ";
    int frameWidth = text.length() + 2;
    int frameHeight = 3;
    for (int row = 0; row < frameHeight; row++) {
      for (int column = 0; column < frameWidth; column++) {
        if (row == 0 && column == 0
            || row == frameHeight - 1 && column == frameWidth - 1) {
          System.out.print('/');
        } else if (row == 0 && column == frameWidth - 1
            || row == frameHeight - 1 && column == 0) {
          System.out.print('\\');
        } else if (row == 0
            || row == frameHeight - 1
            || column == 0
            || column == frameWidth - 1) {
          System.out.print('#');
        } else {
          System.out.print(text);
          column += text.length() - 1;
        }
      }
      System.out.print('\n');
    }
  }
}
