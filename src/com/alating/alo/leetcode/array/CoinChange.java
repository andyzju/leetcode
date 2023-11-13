package com.alating.alo.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/
 *
 * 零钱兑换
 *
 * 动态规划
 */
public class CoinChange {


    public int coinChange(int[] coins, int amount) {

        if(coins==null || coins.length==0 || amount==0){
            return 0;
        }


        int dp[]=new int[amount+1];

        // 初始化
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for(int i=1;i<=amount;i++){

            for(int coin:coins){

                if(i>=coin){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];

    }

    public static void main(String agrs[]){

        System.out.println(new CoinChange().coinChange(new int[]{7},0));
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5},11));
        System.out.println(new CoinChange().coinChange(new int[]{2},3));
    }
}
