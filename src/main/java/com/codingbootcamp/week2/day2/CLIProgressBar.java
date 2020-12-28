package com.codingbootcamp.week2.day2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * A program that emulates CLI progress bar.
 * It takes at least two arguments:
 * First - total time units, others are number in seconds that progress bar
 * needs to be paused for.
 * <p>
 * For example:
 * 15 1 1 5 7,
 * That means that we have 15 time units and the progress of each unit will be paused for
 * some time. The pause will be chosen randomly based on the second and following arguments.
 * <p>
 * Class is to be compiled and executed as .jar CLI application
 */
public class CLIProgressBar {

  public static void main(String[] args) throws InterruptedException {
    validateInput(args);
    printBar(args);
  }

  private static void validateInput(String[] args) {
    if (args.length < 2) {
      throw new IllegalArgumentException("Please, provide at least 2 numbers");
    }
  }

  private static void printBar(String[] args) throws InterruptedException {
    int time = Integer.parseInt(args[0]);
    int[] pauses = Stream.of(args)
        .filter(x -> !x.equals(" "))
        .skip(1)
        .mapToInt(Integer::parseInt)
        .toArray();
    double maxPause = Arrays.stream(Stream.of(args)
        .filter(x -> !x.equals(" "))
        .skip(1)
        .mapToInt(Integer::parseInt)
        .toArray())
        .max()
        .orElse(1);
    double totalTime = maxPause * time;
    int barLength = 100;
    double step = 100.0 / time;
    double currentPercentage = 0;
    int i = 0;
    while (i <= time) {
      if (i == time) {
        currentPercentage = 100;
      }
      if (currentPercentage < 10) {
        System.out.print("  ");
      } else if (currentPercentage < 100) {
        System.out.print(" ");
      }
      System.out.print(Math.round(currentPercentage) + "% [");

      int k = 0;
      for (; k < currentPercentage; k++) {
        System.out.print("=");
      }
      System.out.print(">");
      currentPercentage += step;

      for (int j = 0; j < barLength - k; j++) {
        System.out.print(" ");
      }

      System.out.print("] " + i + "/" + time + ", ETA: " + getTime(totalTime));
      totalTime -= maxPause;
      if (i < time) {
        System.out.print("\r");
        Thread.sleep(pauses[new Random().nextInt(pauses.length)] * 1000L);
      }
      i++;
    }
  }

  private static String getTime(double totalSecs) {
    int hours = (int) (totalSecs / 3600);
    int minutes = (int) ((totalSecs % 3600) / 60);
    int seconds = (int) (totalSecs % 60);
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}
