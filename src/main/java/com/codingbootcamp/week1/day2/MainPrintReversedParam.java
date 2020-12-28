package com.codingbootcamp.week1.day2;

/**
 * Program that prints all the input arguments in reversed order.
 * If executed with input arguments:
 * "arg2" "arg2" "arg3"
 * It will print on the screen:
 * "arg3 arg2 arg1\n"
 * <p>
 * if there are no arguments passed in the input it should print:
 * "Please specify at least one argument!\n"
 */
public class MainPrintReversedParam {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.print("Please specify at least one argument!\n");
    }
    for (int i = args.length - 1; i >= 0; i--) {
      System.out.print(args[i]);
      if (i == 0) {
        System.out.print('\n');
      } else {
        System.out.print(" ");
      }
    }
  }
}
