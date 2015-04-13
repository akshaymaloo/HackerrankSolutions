package org.akshay.hackerrank;

import java.util.Scanner;

/**
 * Created by aksh7576 on 3/24/15.
 */

// https://www.hackerrank.com/challenges/superman-celebrates-diwali
public class SupermanCelebratesDiwali {
//  /**
//   * Find the max number of people superman can save
//   * @param buildingLayout building vs people layout
//   * @param building current building
//   * @param floor current floor
//   * @param heightLost floors superman looses when he jumps across buildings
//   * @param peopleSaved no of people superman has saved
//   * @return
//   */
//  private static int calculateMaxPeopleSaved(final int[][] buildingLayout, int building, int floor, final int heightLost, int[][] maxPeopleSaved, int peopleSaved) {
//    if(floor <= 0 || building < 0 || building >= buildingLayout.length) return 0;
//    if(maxPeopleSaved[building][floor] != 0) return maxPeopleSaved[building][floor]; // Use cache
//
//    int jumpDown = calculateMaxPeopleSaved(buildingLayout, building, floor-1, heightLost, maxPeopleSaved, peopleSaved);
//    int maxJumpBuilding = Integer.MIN_VALUE;
//    for (int j = 0; j < buildingLayout.length; j++) {
//      if(j == building) continue;
//      int jumpBuilding = calculateMaxPeopleSaved(buildingLayout, j, floor-heightLost, heightLost, maxPeopleSaved, peopleSaved);
//      if(jumpBuilding > maxJumpBuilding) maxJumpBuilding = jumpBuilding;
//    }
//
//    peopleSaved += buildingLayout[building][floor];
//    maxPeopleSaved[building][floor] = max(jumpDown + peopleSaved, maxJumpBuilding + peopleSaved, 0);
//    return maxPeopleSaved[building][floor];
//  }

  /**
   * Find max element in a column.
   * @param inputArray
   * @param column
   * @return
   */
  private static int findMaxInColumn(int[][] inputArray, int column) {
    if(column < 0) return 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < inputArray.length; i++) {
      if(inputArray[i][column] > max)
        max = inputArray[i][column];
    }
    return max;
  }

  public static void main(String[] args) {
    // Read inputs
    Scanner in = new Scanner(System.in);
    final int n = in.nextInt(), h = in.nextInt(), i = in.nextInt();
    int[][] buildingLayout = new int[n][h + 1];
    for (int j = 0; j < n; j++) {
      int u = in.nextInt();
      for (int k = 0; k < u; k++) {
        buildingLayout[j][in.nextInt()]++;
      }
    }

    // Find the max number of people superman can save
    for (int j = 1; j <= h; j++) { // floor
      for (int k = 0; k < n; k++) { // building
        // From each floor there are two possibilities
        buildingLayout[k][j] = Math.max(
            buildingLayout[k][j] + findMaxInColumn(buildingLayout, j - i),  // 1. Jump, if superman jumps he looses height
            buildingLayout[k][j] + buildingLayout[k][j - 1]);               // 2. Go down 1 floor
      }
    }

//    // Display
//    System.out.println();
//    for (int j = 0; j < buildingLayout.length; j++) {
//      for (int k = 0; k < buildingLayout[0].length; k++) {
//        System.out.print(buildingLayout[j][k] + " ");
//      }
//      System.out.println();
//    }
//    //
//    System.out.println();
    System.out.println(findMaxInColumn(buildingLayout, h));
  }
}
