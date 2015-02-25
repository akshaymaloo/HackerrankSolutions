package org.akshay.hackerrank;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aksh7576 on 2/25/15.
 */

// https://www.hackerrank.com/challenges/lonely-integer
public class LonelyInteger {

  public static void main(String[] args) {
    int N = 0, output = 0;

    // Configure Input Stream
    Scanner in = new Scanner(System.in);
    // Read N
    N = in.nextInt();

    List<Integer> test = new LinkedList<Integer>();

    // Read the entire input list .. XOR to find the odd one out
    for (int j = 0; j < N; j++) {
      output = output ^ in.nextInt();
    }

    System.out.println(output);
  }
}
