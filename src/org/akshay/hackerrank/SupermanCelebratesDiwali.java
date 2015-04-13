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
   * @param heightLost floors superman looses when he jumps across buildings
   * @param peopleSaved no of people superman has saved
   * @return
   */
  private static int calculateMaxPeopleSaved(final int[][] buildingLayout, int building, int floor, final int heightLost, int[][] maxPeopleSaved, int peopleSaved) {
    if(floor <= 0 || building < 0 || building >= buildingLayout.length) return 0;
    if(maxPeopleSaved[building][floor] != 0) return maxPeopleSaved[building][floor]; // Use cache

    int jumpDown = calculateMaxPeopleSaved(buildingLayout, building, floor-1, heightLost, maxPeopleSaved, peopleSaved);
    int maxJumpBuilding = Integer.MIN_VALUE;
    for (int j = 0; j < buildingLayout.length; j++) {
      if(j == building) continue;
      int jumpBuilding = calculateMaxPeopleSaved(buildingLayout, j, floor-heightLost, heightLost, maxPeopleSaved, peopleSaved);
      if(jumpBuilding > maxJumpBuilding) maxJumpBuilding = jumpBuilding;
    }

    peopleSaved += buildingLayout[building][floor];
    maxPeopleSaved[building][floor] = max(jumpDown + peopleSaved, maxJumpBuilding + peopleSaved, 0);
    return maxPeopleSaved[building][floor];
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

    // Find the max number of people superman can save
    long startTime = System.currentTimeMillis();
    int[][] maxPeopleSaved = new int[n][h+1]; // Cache
    int maxPeopleSavedValue = Integer.MIN_VALUE;
    for (int j = 0; j < n; j++) {
      int tempMaxPeopleSavedValue = calculateMaxPeopleSaved(buildingLayout, j, h, i, maxPeopleSaved, 0);
      if(tempMaxPeopleSavedValue > maxPeopleSavedValue) maxPeopleSavedValue = tempMaxPeopleSavedValue;
    }

//    // Display
//    System.out.println();
//    for (int j = 0; j < maxPeopleSaved.length; j++) {
//      for (int k = 0; k < maxPeopleSaved[0].length; k++) {
//        System.out.print(maxPeopleSaved[j][k] + " ");
//      }
//      System.out.println();
//    }
//    //
//    System.out.println();
    System.out.println(maxPeopleSavedValue);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println(elapsedTime);
  }
}
