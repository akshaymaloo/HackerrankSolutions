package org.akshay.hackerrank;

import java.util.Scanner;

/**
 * Created by aksh7576 on 3/24/15.
 */

// https://www.hackerrank.com/challenges/superman-celebrates-diwali
public class SupermanCelebratesDiwali {
  /**
   * Find the max number of people superman can save
   * @param buildingLayout building vs people layout
   * @param building current building
   * @param floor current floor
   * @param i floors superman looses when he jumps across buildings
   * @param peopleSaved no of people superman has saved
   * @return
   */
  private static int calculateMaxPeopleSaved(final int[][] buildingLayout, int building, int floor, final int i, int peopleSaved) {
    if(floor <= 0 || building < 0 || building >= buildingLayout.length) return peopleSaved;

    peopleSaved += buildingLayout[building][floor];

    int jumpDown = calculateMaxPeopleSaved(buildingLayout, building, floor-1, i, peopleSaved);
    int maxJumpBuilding = Integer.MIN_VALUE;
    for (int j = 0; j < buildingLayout.length; j++) {
      if(j == building) continue;
      int jumpBuilding = calculateMaxPeopleSaved(buildingLayout, j, floor-i, i, peopleSaved);
      if(jumpBuilding > maxJumpBuilding) maxJumpBuilding = jumpBuilding;
    }

    return max(jumpDown, maxJumpBuilding, 0);
  }

  /**
   * Find Max
   * @param x
   * @param y
   * @param z
   * @return
   */
  private static int max(int x, int y, int z) {
    return Math.max(x, Math.max(y, z));
  }

  public static void main(String[] args) {
    // Read inputs
    Scanner in = new Scanner(System.in);
    final int n = in.nextInt(), h = in.nextInt(), i = in.nextInt();
    int[][] buildingLayout = new int[n][h+1];
    for (int j = 0; j < n; j++) {
      int u = in.nextInt();
      for (int k = 0; k < u; k++) {
        buildingLayout[j][in.nextInt()]++;
      }
    }

//    for (int j = 0; j < n; j++) {
//      for (int k = 0; k < h+1; k++) {
//        System.out.print(buildingLayout[j][k] + " ");
//      }
//      System.out.println();
//    }

    // Find the max number of people superman can save
    int maxPeopleSaved = Integer.MIN_VALUE;
    for (int j = 0; j < buildingLayout.length; j++) {
      int peopleSaved = calculateMaxPeopleSaved(buildingLayout, j, h, i, 0);
      if(peopleSaved > maxPeopleSaved) maxPeopleSaved = peopleSaved;
    }
    System.out.println(maxPeopleSaved);
  }
}
