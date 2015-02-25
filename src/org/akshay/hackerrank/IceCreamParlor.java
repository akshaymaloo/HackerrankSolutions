package org.akshay.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aksh7576 on 2/20/15.
 */

// https://www.hackerrank.com/challenges/icecream-parlor
public class IceCreamParlor {

  public static void main(String[] args) {
    int T = 0, M = 0, N = 0;

    // Configure Input Stream
    Scanner in = new Scanner(System.in);
    // Read T
    T = in.nextInt();

    for (int i = 0; i < T; i++) {
      // Read M and N
      M = in.nextInt();
      N = in.nextInt();

      // Read the entire input list
      List<Integer> input = new ArrayList(N);
      for (int j = 0; j < N; j++) {
        input.add(in.nextInt());
      }

      // Find index that equals the sum
      for (int j = 0; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          if((input.get(j) + input.get(k)) == M) {
            System.out.println((j+1) + " " + (k+1));
            break;
          }
        }
      }
    }
  }
}
