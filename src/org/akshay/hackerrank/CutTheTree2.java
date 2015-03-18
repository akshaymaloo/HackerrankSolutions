package org.akshay.hackerrank;

import java.util.Scanner;

/**
 * Created by aksh7576 on 2/27/15.
 */

// https://www.hackerrank.com/challenges/cut-the-tree
public class CutTheTree2 {
  /**
   * Main function.
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    // read the vertex values
    int[] values = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = in.nextInt();
    }
    // read the tree edges
    int[][] treeEdgeMatrix = new int[n-1][2];
    for (int i = 0; i < n-1; i++) {
      for (int j = 0; j < 2; j++) {
        treeEdgeMatrix[i][j] = in.nextInt();
      }
    }
    // find Tree_diff
    int minTreeDiff = Integer.MAX_VALUE;
    for (int i = 0; i < n-1; i++) {
      int treeDiff = findTreeDiff(treeEdgeMatrix, values, i);
      if(treeDiff < minTreeDiff) minTreeDiff = treeDiff;
    }
    System.out.println(minTreeDiff);
  }

  /**
   * Get sum of tree vertices
   * Note: Assuming tree edge list is in sorted order
   * @param treeEdgeMatrix
   * @param values
   * @param index
   * @return
   */
  private static int findTreeDiff(int[][] treeEdgeMatrix, int[] values, int index) {
    int vertex1 = treeEdgeMatrix[index][0];
    int vertex2 = treeEdgeMatrix[index][1];
    for (int i = 0; i < treeEdgeMatrix[0].length; i++) {
      System.out.println();
    }

    return Integer.MAX_VALUE;
  }
}
