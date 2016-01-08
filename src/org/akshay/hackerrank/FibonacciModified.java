package org.akshay.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by aksh7576 on 1/8/16.
 */

/*
A series is defined in the following manner:

Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation
Tn+2 = (Tn+1)2 + Tn

Input Format
============
You are given three space separated integers A, B and N on one line.

Input Constraints
0 <= A,B <= 2
3 <= N <= 20

Output Format
============
One integer.
This integer is the Nth term of the given series when the first two terms are A and B respectively.

Note
====
Some output may even exceed the range of 64 bit integer.

Sample Input
0 1 5

Sample Output
5

 */

public class FibonacciModified {
  /**
   * Find the Nth number in the series.
   * Note: Using BigInteger to hold the values.
   *
   * @param a
   * @param b
   * @param level
   * @param N
   */
  public static void fibonacciModified(BigInteger a, BigInteger b, int level, int N) {
    if (level == N) {
      System.out.println(b);
    } else {
      fibonacciModified(b, b.pow(2).add(a), level + 1, N);
    }
  }

  public static void main(String[] args) {
    // Read the input
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int N = sc.nextInt();

    // Calculate the Nth number
    fibonacciModified(BigInteger.valueOf(a), BigInteger.valueOf(b), 2, N);
  }
}
