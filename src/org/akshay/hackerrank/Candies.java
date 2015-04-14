package org.akshay.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aksh7576 on 4/14/15.
 */

//Problem: https://www.hackerrank.com/challenges/candies
public class Candies {
  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    final int n = sc.nextInt();
    int[] ratingArray = new int[n];
    for (int i = 0; i < n; i++) {
      ratingArray[i] = sc.nextInt();
    }
    System.out.println(calculateNoOfCandies(ratingArray));
  }

  /**
   * Calculate the min number of candis required.
   *
   * @param ratingArray
   * @return
   */
  private static int calculateNoOfCandies(int[] ratingArray) {
    int[] right = new int[ratingArray.length];
    int[] left = new int[ratingArray.length];
    Arrays.fill(right, 1);
    Arrays.fill(left, 1);

    for (int i = 1; i < ratingArray.length; i++) {
      if (ratingArray[i] > ratingArray[i - 1])
        right[i] = right[i - 1] + 1;
    }

    for (int i = ratingArray.length - 2; i >= 0; i--) {
      if (ratingArray[i] > ratingArray[i + 1])
        left[i] = left[i + 1] + 1;
    }

    int candies = 0;
    for (int i = 0; i < ratingArray.length; i++) {
      candies += Math.max(right[i], left[i]);
    }

    return candies;
  }
}
