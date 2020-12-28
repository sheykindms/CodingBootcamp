package com.codingbootcamp.week2.day0;

import com.codingbootcamp.week0.day2.StringTools;

/**
 * Program that is capable of performing simple mathematical operation. Program
 * expects three input arguments. If amount of arguments is not equal to 3 the
 * program should print the following string:
 * "Please provide 3 input arguments, example: 2 + 3"
 * <p>
 * Arguments to the program should be:
 * 1. integer
 * 2. math operation, can be "+", "-", "/", "*", "%"
 * 3. integer
 * <p>
 * program should do specified math operation and print result in the following
 * format:
 * result: %s\n
 * <p>
 * for example:
 * <p>
 * 3 + 2
 * result: 5
 * <p>
 * -5 + -10
 * result: -15
 * <p>
 * asfdasd + 2
 * IllegalArgumentException
 */
public class Calculator {

  public static void main(String[] args) {

    if (args.length != 3) {
      System.out.print("Please provide 3 input arguments, example: 2 + 3\n");
      return;
    }
    int n1;
    int n2;
    try {
      n1 = StringTools.toInt(args[0]);
      n2 = StringTools.toInt(args[2]);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
    switch (args[1]) {
      case "+":
        resultPrinter(n1 + n2);
        break;
      case "-":
        resultPrinter(n1 - n2);
        break;
      case "*":
        resultPrinter(n1 * n2);
        break;
      case "/":
        resultPrinter(n1 / n2);
        break;
      case "%":
        resultPrinter(n1 % n2);
        break;
      default:
        System.out.println("Please provide the correct operator!");
    }
  }

  private static void resultPrinter(int result) {
    System.out.print("result: " + result + '\n');
  }
}