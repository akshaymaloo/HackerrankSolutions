package org.akshay.hackerrank;

import com.sun.istack.internal.NotNull;

import java.util.Scanner;

/**
 * Created by aksh7576 on 3/18/15.
 */

//https://www.hackerrank.com/challenges/maxsubarray
public class MaxSubArray {
  /**
   * Find the smallest number in given array
   * @param inputArray
   * @return
   */
  private static int findBiggestNumber(@NotNull int[] inputArray) {
    int biggestNumber = Integer.MIN_VALUE;
    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] > biggestNumber) biggestNumber = inputArray[i];
    }
    return biggestNumber;
  }

  /**
   * Max possible sum of a contiguous sub-array
   * Note: This is an n^2 solution
   * @param inputArray
   * @return
   */
  private static int maxContiguousSum(@NotNull int[] inputArray) {
    int maxContiguous = Integer.MIN_VALUE;
    for (int i = 0; i < inputArray.length; i++) {
      int sum = 0;
      for (int j = i; j < inputArray.length; j++) {
        sum += inputArray[j];
        if(sum > maxContiguous) maxContiguous = sum;
      }
    }
    return maxContiguous;
  }

  /**
   * Max possible sum of a contiguous sub-array
   * Note: This is an O(n) solution
   * @param inputArray
   * @return
   */
  private static int maxContiguousSumLinear(@NotNull int[] inputArray) {
    int maxContiguous = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < inputArray.length; i++) {
        sum += inputArray[i];
        if(sum < 0) sum = 0;
        if(sum > maxContiguous) maxContiguous = sum;
    }
    return maxContiguous;
  }

  /**
   * Main program
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int t = in.nextInt();
    // No of test cases
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int  maxNonContiguous = 0;
      boolean hasPositiveNumber = false;
      int[] inputArray = new int[n];
      for (int j = 0; j < n; j++) {
        inputArray[j] = in.nextInt();
        // Find max sum of non-contiguous sub-array
        if(inputArray[j] >= 0) {
          hasPositiveNumber = true;
          maxNonContiguous+=inputArray[j];
        }
      }

      // Print the output
      // If all numbers are negative we just print the biggest number
      System.out.println((!hasPositiveNumber) ? findBiggestNumber(inputArray) + " " + findBiggestNumber(inputArray)
          : maxContiguousSumLinear(inputArray) + " " + maxNonContiguous);
    }
  }
}
