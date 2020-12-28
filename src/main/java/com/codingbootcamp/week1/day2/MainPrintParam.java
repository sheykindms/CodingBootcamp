package com.codingbootcamp.week1.day2;

/**
 * Program that prints all the input arguments.
 * If executed with input arguments:
 * "arg2" "arg2" "arg3"
 * It will print on the screen:
 * "arg1 arg2 arg3\n"
 * <p>
 * if there are no arguments passed in the input it should print:
 * "Please specify at least one argument!\n"
 */
public class MainPrintParam {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.print("Please specify at least one argument!\n");
    }
    for (int i = 0; i < args.length; i++) {
      System.out.print(args[i]);
      if (i == args.length - 1) {
        System.out.print('\n');
      } else {
        System.out.print(" ");
      }
    }
  }
}
