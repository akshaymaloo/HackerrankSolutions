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
  private static long max(long x, long y, long z) {
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
  private static long maximumProfitRecursive(int[] priceArray, int shares, int price, long profit, int currentIndex) {
    if (currentIndex >= priceArray.length) return profit;

    return max(
        maximumProfitRecursive(priceArray, shares, price, profit, currentIndex + 1), // do nothing
        (shares == 0 || profit < 0) ? 0 : maximumProfitRecursive(priceArray, 0, 0, profit + ((shares * priceArray[currentIndex]) - price), currentIndex), // sell
        maximumProfitRecursive(priceArray, shares + 1, price + priceArray[currentIndex], profit, currentIndex + 1) // buy
    );
  }

  /**
   * Find max profit.
   * @param priceArray
   * @return
   */
  private static long maximumProfit(int[] priceArray) {
    long futureStockPrice = 0, profit = 0;
    for (int i = priceArray.length - 1; i >= 0; --i) {
      futureStockPrice = max(futureStockPrice, priceArray[i], 0);
      profit += (futureStockPrice - priceArray[i]);
    }
    return profit;
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
      //System.out.println(maximumProfitRecursive(priceArray, 0, 0, 0, 0));
      System.out.println(maximumProfit(priceArray));
    }
  }
}
