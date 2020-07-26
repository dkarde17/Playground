import java.io.InputStream;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0
 * <p>
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines.
 * The first line consists of N the number of items.
 * The second line consists of W, the maximum capacity of the knapsack.
 * In the next line are N space separated positive integers denoting the values of the N items,
 * and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.
 * <p>
 * Output:
 * For each testcase, in a new line, print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 1000
 * 1 ≤ W ≤ 1000
 * 1 ≤ wt[i] ≤ 1000
 * 1 ≤ v[i] ≤ 1000
 * <p>
 * Example:
 * Input:
 * 2
 * 3
 * 4
 * 1 2 3
 * 4 5 1
 * 3
 * 3
 * 1 2 3
 * 4 5 6
 * Output:
 * 3
 * 0
 * Explanation:
 * Test Case 1: With W = 4, you can either choose the 0th item or the 2nd item. Thus, the maximum value you can generate is the max of val[0] and val[2], which is equal to 3.
 * Test Case 2: With W = 3, there is no item you can choose from the given list as all the items have weight greater than W. Thus, the maximum value you can generate is 0.
 */
public class ZeroOneKnapsack {

    public static void main(String[] args) {
        InputStream testInput = ZeroOneKnapsack.class.getClassLoader().getResourceAsStream("testInput");
        Scanner scanner = new Scanner(testInput);
        int t = scanner.nextInt();//number of testcases
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();//number of elements
            int w = scanner.nextInt(); //capacity of knapsack
            int[] val = new int[n];
            int[] wt = new int[n];
            for (int j = 0; j < n; j++)
                val[j] = scanner.nextInt();
            for (int j = 0; j < n; j++)
                wt[j] = scanner.nextInt();

            //using recursion
            int ans = findMaxValForWRecursion(n, w, val, wt);
            System.out.println("recursion = " + ans);

            //using memoization with recursion
            int[][] memoizationTable = new int[n + 1][w + 1];
            for (int j = 0; j <= n; j++)
                for (int k = 0; k <= w; k++)
                    memoizationTable[j][k] = -1;
            int ans1 = findMaxValForWMemoized(n, w, val, wt, memoizationTable);
            System.out.println("memoized = " + ans1);

            //using bottom up dp tabular method
            int[][] bottomUpDPTable = new int[n + 1][w + 1]; //bottomUpDPTable[i][j] represents the max value for i items and j capacity
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= w; k++) {
                    if (wt[j - 1] <= k)
                        bottomUpDPTable[j][k] = Math.max(val[n - 1] + bottomUpDPTable[j - 1][k - wt[n - 1]], bottomUpDPTable[j - 1][k]);
                    else bottomUpDPTable[j][k] = bottomUpDPTable[j - 1][k];
                }
            }
            int ans2 = bottomUpDPTable[n][w];
            System.out.println("bottom up DP = " + ans2);
        }
    }

    private static int findMaxValForWRecursion(int n, int w, int[] val, int[] wt) {
        if (n == 0 || w == 0)
            return 0;
        if (wt[n - 1] <= w)
            return Math.max(val[n - 1] + findMaxValForWRecursion(n - 1, w - wt[n - 1], val, wt), findMaxValForWRecursion(n - 1, w, val, wt));
        else return findMaxValForWRecursion(n - 1, w, val, wt);
    }

    private static int findMaxValForWMemoized(int n, int w, int[] val, int[] wt, int[][] memoizationTable) {
        if (n == 0 || w == 0)
            return 0;
        if (memoizationTable[n][w] == -1) {
            if (wt[n - 1] <= w)
                memoizationTable[n][w] = Math.max(val[n - 1] + findMaxValForWMemoized(n - 1, w - wt[n - 1], val, wt, memoizationTable),
                        findMaxValForWMemoized(n - 1, w, val, wt, memoizationTable));
            else memoizationTable[n][w] = findMaxValForWRecursion(n - 1, w, val, wt);
        }
        return memoizationTable[n][w];
    }
}
