package com.codingbootcamp.week1.day2;

import java.util.Arrays;

/**
 * Program that prints all the input arguments in reversed order.
 * If executed with input arguments:
 * "c" "a" "z" "y"
 * It will print on the screen:
 * "a c y z\n"
 * <p>
 * if there are no arguments passed in the input it should print:
 * "Please specify at least one argument!\n"
 */
public class MainPrintSortedParam {

  public static void main(String[] args) {
    Arrays.sort(args);
    MainPrintParam.main(args);
  }
}
