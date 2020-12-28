package com.codingbootcamp.week2.day1;

/**
 * The program droving boxes on the screen, like this:
 * <p>
 * #----#
 * -    -
 * -    -
 * #----#
 * <p>
 * The program takes four input arguments:
 * 1. width of the box
 * 2. height of the box
 * 3. character for the walls
 * 4. character for the corners
 * <p>
 * So in order to get exactly the same box as shown in the example one should
 * pass the following arguments:
 * 6 4 - #
 * <p>
 * if amount of the arguments is not 4 the program should prinet:
 * Please provide 4 input arguments, current amount: %d\n
 * <p>
 * with the current amount of arguments.
 * <p>
 * In case of any illegal arguments the program should throw IllegalArgumentException
 */
public class BoxGenerator {

  public static void main(String[] args) {
    if (args.length != 4) {
      System.out.printf("Please provide 4 input arguments, current amount: %d\n", args.length);
      return;
    }
    int frameWidth = Integer.parseInt(args[0]);
    int frameHeight = Integer.parseInt(args[1]);
    char wall = args[2].charAt(0);
    char corner = args[3].charAt(0);
    if (frameWidth < 0 || frameHeight < 0 || args[2].length() > 1 || args[3].length() > 1) {
      throw new IllegalArgumentException();
    }
    if (frameWidth == 0 || frameHeight == 0) {
      return;
    }
    for (int row = 0; row < frameHeight; row++) {
      for (int column = 0; column < frameWidth; column++) {
        if (row == 0 && column == 0
            || row == 0 && column == frameWidth - 1
            || row == frameHeight - 1 && column == 0
            || row == frameHeight - 1 && column == frameWidth - 1) {
          System.out.print(corner);
        } else if (row == 0
            || row == frameHeight - 1
            || column == 0
            || column == frameWidth - 1) {
          System.out.print(wall);
        } else {
          System.out.print(' ');
        }
      }
      System.out.print('\n');
    }
  }
}
