// package DP;

import java.util.*;

public class MinimizingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int coins[] = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }

        int dp[] = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int t=1; t<=target; t++){
            for(int i=0; i<coins.length; i++){
                if((t-coins[i] >= 0) && (dp[t-coins[i]] != Integer.MAX_VALUE)){
                    dp[t] = Math.min(dp[t], 1+dp[t-coins[i]]);
                }
            }
        }

        int ans = dp[target];
        System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
    }

    // public static int solve(int target, int[] coins, int dp[]){
    //     if(target == 0) return 0;
    //     if(target < 0) return Integer.MAX_VALUE;
    //     if(dp[target] != -1) return dp[target];

    //     int res = Integer.MAX_VALUE;
    //     for(int i=0; i<coins.length; i++){
    //         int sub = solve(target-coins[i], coins, dp);
    //         if(sub != Integer.MAX_VALUE)
    //             res = Math.min(res, 1 + sub);
    //     }

    //     return dp[target] = res;
    // }
}
