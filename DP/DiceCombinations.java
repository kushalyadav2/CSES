// package DP;

import java.util.*;

public class DiceCombinations {
    static final int mod = 1000000007;
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=6; j++){
                dp[i] += (i-j) < 0 ? 0 : dp[i-j];
                dp[i] %= mod;
            }
        }

        System.out.println(dp[n]);
    }

    // public static int solve(int n, int[] dp){
    //     if(n==0) return 1;
    //     if(n < 0) return 0;

    //     if(dp[n] != -1) return dp[n];

    //     int ans = 0;
    //     for(int i=1; i<=6; i++){
    //         ans = (ans + solve(n-i,dp)) % mod;
    //     }

    //     return dp[n] = ans;
    // }
}
