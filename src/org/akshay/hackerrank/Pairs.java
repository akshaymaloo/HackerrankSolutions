package org.akshay.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aksh7576 on 2/25/15.
 */

// https://www.hackerrank.com/challenges/pairs
public class Pairs {

// Solution 1, using a hashmap

//  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt(), k = in.nextInt();
//    HashMap<Integer, Integer> integerHashMap = new HashMap<Integer, Integer>();
//    for (int i = 0; i < n; i++) integerHashMap.put(in.nextInt(), 0);
//    System.out.println(pairs(k, integerHashMap));
//  }
//
//  /**
//   * calculate number of pairs whose difference is k
//   * @param k
//   * @param integerHashMap
//   * @return
//   */
//  private static int pairs(int k, HashMap<Integer, Integer> integerHashMap) {
//    int count = 0;
//    Set<Integer> integerSet = integerHashMap.keySet();
//    for (Integer value1 : integerSet) {
//      if(integerHashMap.containsKey(value1+k)) count++;
//    }
//    return count;
//  }

// Solution 2, using a sorted array

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), k = in.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) x[i] = in.nextInt();
    Arrays.sort(x);
    System.out.println(pairs(k, x));
  }

  /**
   * calculate number of pairs whose difference is k
   * @param k
   * @param x
   * @return
   */
  private static int pairs(int k, int[] x) {
    int count = 0;
    for (int i = 0; i < x.length; i++) {
      for (int j = i + 1; j < x.length; j++) {
        if((x[i] - x[j]) == k || (x[i] - x[j]) == k*-1) {
          count++;
          break;
        }
      }
    }

    return count;
  }
}
