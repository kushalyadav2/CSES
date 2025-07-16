// package DP;

import java.util.*;

public class GridPathsI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for(int i=0; i<n; i++){
            String s = sc.next();
            grid[i] = s.toCharArray();
        }

        int dp[][] = new int[n][n];
        for(int d[] : dp)
            Arrays.fill(d, -1);

        System.out.println(solve(0, 0, grid, dp));
    }

    public static int solve(int i, int j, char[][] grid, int[][] dp){
        if(i>=grid.length || j>=grid.length || grid[i][j] == '*') return 0;
        if(i==grid.length-1 && j==grid.length-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int a = solve(i+1, j, grid, dp);
        int b = solve(i, j+1, grid, dp);

        return a+b;
    }
}
