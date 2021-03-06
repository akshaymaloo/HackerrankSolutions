package org.akshay.hackerrank;

import java.util.Scanner;

/**
 * Created by aksh7576 on 1/7/16.
 */


/*
Problem Statement
=================

Mimmy is managing company X's datacenters. So it is most unfortunate that a power outage took down one of their datacenters. Mimmy called the power supply company and it turns out the outage will not be fixed in the near future. Typically companies have disaster recovery set up for such cases but company X wanted to cut the extra costs. So Mimmy will have to move all the servers from the datacenter to a backup datacenter by hand.

The servers in the datacenter are ordered in line. Mimmy can move either the first or the last server in the line but she can't reach any other server. In one hour Mimmy comes, takes one server to the backup datacenter, sets it up and starts it. Thus every hour Mimmy will "rescue" either the first or the last of the remaining servers. Each server si has an associated downtime cost di - the amount of money that company X will lose every hour that si is down.

Mimmy wants to minimize the costs for company X. She knows all the downtime costs of the servers in the datacenter and she wants to device an optimal way to move them. Help her by writing a program that will find the minimal loss for company X.

Input Format
------------
The first line of the input contains a single integer N(1 <= N <= 1000) - the number of servers in the datacenter Mimmy has to recover. The next line contains N integer numbers di(1 <= di <= 100000)- the downtime costs of the servers in the same order that the servers are placed in the line. The downtime costs are separated by a single space.

Output Format
-------------
Output a single number - the minimal loss for company X, for which Mimmy can move all the servers.

Sample Input
------------
4
5 1 4 3

Sample Output
-------------
27

Explanation
-----------
In the first hour Mimmy will save s1(downtime cost 5), in the second hour she will save s4(d4=3), then she will save the s3(d3=4) and lastly she will save s2(d2=1). The overall cost for the company will be 5 * 1 + 3 * 2 + 4 * 3 + 1 * 4 = 27.
*/

public class DisasterRecovery {
  /**
   * DP solution for the problem.
   * Note: this is not optimised need to reduce computations.
   *
   * @param costArray
   * @param start
   * @param end
   * @param hour
   * @return
   */
  private static long calculateMinCost(int[] costArray, int start, int end, int hour, long[][] calculatedCost) {
    if (start > end)
      return 0;
    if ((start >= 0 && start <= costArray.length && end >= 0 && end <= costArray.length) && calculatedCost[start][end] != 0)
      return calculatedCost[start][end];

    long costStart = (costArray[start] * hour) + calculateMinCost(costArray, start + 1, end, hour + 1, calculatedCost);
    long costEnd = (costArray[end] * hour) + calculateMinCost(costArray, start, end - 1, hour + 1, calculatedCost);

    calculatedCost[start][end] = Math.min(costStart, costEnd);

    return Math.min(costStart, costEnd);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Read no of computers
    int N = sc.nextInt();
    int[] costArray = new int[N];
    // Read the cost
    for (int i = 0; i < N; i++) {
      costArray[i] = sc.nextInt();
    }

    long[][] calculatedCost = new long[N + 1][N + 1];
    System.out.println(calculateMinCost(costArray, 0, N - 1, 1, calculatedCost));
  }
}


/*

Test cases:

4
5 1 4 3
27

9
9 1 5 8 7 1000 2 4 6
4212

22
41 5 13 2 38 22 6 20 7 30 46 10 19 49 40 50 14 37 11 43 12 23
5329
*/