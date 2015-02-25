package org.akshay.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aksh7576 on 2/25/15.
 */

// https://www.hackerrank.com/challenges/angry-children
public class MaxMin {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), k = in.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) x[i] = in.nextInt();
    Arrays.sort(x);
    System.out.println(minUnfairness(n, k, x));
  }

  private static int minUnfairness(int n, int k, int[] x) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= n - k; i++) {
      if (x[i + k - 1] - x[i] < min) min = x[i + k - 1] - x[i];
    }
    return min;
  }

//  public static void main(String[] args) {
//    int N = 0, K = 0, unfairness = Integer.MAX_VALUE;
//
//    // Configure Input Stream
//    Scanner in = new Scanner(System.in);
//    // Read N and K
//    N = in.nextInt();
//    K = in.nextInt();
//
//    // Read and sore in an Ordered Queue
//    Queue<Integer> integerQueue = new PriorityQueue<Integer>(N);
//    for (int i = 0; i < N; i++) {
//      integerQueue.add(in.nextInt());
//    }
//
//    // Convert queue into an array for easier comparison
//    int[] integerQueueToArray = new int[integerQueue.size()];
//    for (int i = 0; i < integerQueueToArray.length; i++) {
//      integerQueueToArray[i] = integerQueue.poll();
//    }
//
//    // Find the min unfairness value
//    for (int i = 0; i <= N-K ; i++) {
//      if(((Integer)integerQueueToArray[i+K-1] - (Integer)integerQueueToArray[i]) < unfairness) {
//        unfairness = ((Integer)integerQueueToArray[i+K-1] - (Integer)integerQueueToArray[i]);
//      }
//    }
//
//    System.out.println(unfairness);
//  }
}
