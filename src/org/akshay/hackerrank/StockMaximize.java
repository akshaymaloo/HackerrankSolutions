package org.akshay.hackerrank;

import java.util.Scanner;

/**
 * Created by aksh7576 on 4/6/15.
 */
public class StockMaximize {
  /**
   * Find Max.
   * @param x
   * @param y
   * @param z
   * @return
   */
  private static int max(int x, int y, int z) {
    return Math.max(x, Math.max(y, z));
  }

  /**
   * Find max profit.
   * @param priceArray
   * @param shares
   * @param price
   * @param profit
   * @param currentIndex
   * @return
   */
  private static int maximumProfitRecursive(int[] priceArray, int shares, int price, int profit, int currentIndex) {
    if (currentIndex >= priceArray.length) return profit;

    return max(
        maximumProfitRecursive(priceArray, shares, price, profit, currentIndex + 1), // do nothing
        (shares == 0 || profit < 0) ? 0 : maximumProfitRecursive(priceArray, 0, 0, profit + ((shares * priceArray[currentIndex]) - price), currentIndex), // sell
        maximumProfitRecursive(priceArray, shares + 1, price + priceArray[currentIndex], profit, currentIndex + 1) // buy
    );
  }

  public static void main(String[] args) {
    // Read inputs
    Scanner in = new Scanner(System.in);
    final int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int[] priceArray = new int[n];
      for (int j = 0; j < n; j++) {
        priceArray[j] = in.nextInt();
      }
      System.out.println(maximumProfitRecursive(priceArray, 0, 0, 0, 0));
    }
  }
}
