package org.akshay.hackerrank;

import java.util.Scanner;

/**
 * Created by aksh7576 on 2/25/15.
 */

// https://www.hackerrank.com/challenges/count-luck
public class CountLuck {
  final static char EMPTY = '.', TREE = 'X', MARKER = 'M', EXIT = '*', TRAVERSED = '0';

  /**
   * Calculate times hand waived
   *
   * @param forest matrix representing the forest
   * @param x starting position
   * @param y starting position
   * @return
   */
  private int calculateTimesHandWaived(char[][] forest, int x, int y, int timesHandWaived, final int k) {
    // Hurray, we have reached the exit
    if(forest[x][y] == EXIT) {
      System.out.println((k == timesHandWaived) ? "Impressed" : "Oops!");
      //System.out.println(timesHandWaived);
      return timesHandWaived;
    }

    // Calculate and count all possible paths
    int  count = 0;
    if(x-1>=0 && x-1<=forest.length-1) {
      if(forest[x-1][y] == EMPTY || forest[x-1][y] == EXIT) {
        count++;
      }
    }
    if(x+1>=0 && x+1<=forest.length-1) {
      if(forest[x+1][y] == EMPTY || forest[x+1][y] == EXIT) {
        count++;
      }
    }
    if(y-1>=0 && y-1<=forest[0].length-1) {
      if(forest[x][y-1] == EMPTY || forest[x][y-1] == EXIT) {
        count++;
      }
    }
    if(y+1>=0 && y+1<=forest[0].length-1) {
      if(forest[x][y+1] == EMPTY || forest[x][y+1] == EXIT) {
        count++;
      }
    }

    // If multiple paths, use wand
    if(count > 1) timesHandWaived++;
    // Mark position as traversed
    forest[x][y] = TRAVERSED;

    // Recursively move forward if the cell is empty or its the exit
    if(x-1>=0 && x-1<=forest.length-1) {
      if(forest[x-1][y] == EMPTY || forest[x-1][y] == EXIT) {
        calculateTimesHandWaived(forest, x-1, y, timesHandWaived, k);
      }
    }
    if(x+1>=0 && x+1<=forest.length-1) {
      if(forest[x+1][y] == EMPTY || forest[x+1][y] == EXIT) {
        calculateTimesHandWaived(forest, x+1, y, timesHandWaived, k);
      }
    }
    if(y-1>=0 && y-1<=forest[0].length-1) {
      if(forest[x][y-1] == EMPTY || forest[x][y-1] == EXIT) {
        calculateTimesHandWaived(forest, x, y-1, timesHandWaived, k);
      }
    }
    if(y+1>=0 && y+1<=forest[0].length-1) {
      if(forest[x][y+1] == EMPTY || forest[x][y+1] == EXIT) {
        calculateTimesHandWaived(forest, x, y+1, timesHandWaived, k);
      }
    }

    return timesHandWaived;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    // No of test caseds
    for (int i = 0; i < t; i++) {
      int n = in.nextInt(), m = in.nextInt();
      char[][] forest = new char[n][m];
      int markerX = -1, markerY = -1;
      // Read the forest matrix
      for (int j = 0; j < n; j++) {
        String tempMatrixRow = in.next();
        for (int z = 0; z < m; z++) {
          forest[j][z] = tempMatrixRow.charAt(z);
          if (forest[j][z] == MARKER) {
            markerX = j;
            markerY = z;
          }
        }
      }
      // Calculate times hand waived
      int k = in.nextInt();
      int timesHandWaived = new CountLuck().calculateTimesHandWaived(forest, markerX, markerY, 0, k);
    }
  }
}
