package com.alating.alo.leetcode.array;


/**
 * https://leetcode.cn/problems/coin-change-2/
 *
 * 零钱兑换 II
 *
 *
 *  比较这个题目，两个题目是类似的，但是变形后的： https://leetcode.cn/problems/combination-sum/
 */
public class CoinChange2 {


    public int change(int amount, int[] coins) {

        if(coins==null || coins.length==0){
            return 0;
        }

        int dp[]=new int[amount+1];
        dp[0]=1;

        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }

        return dp[amount];

    }

    public static void main(String args[]){

        int amount=4;
        int coins[]=new int[]{1,2,3};

        System.out.println(new CoinChange2().change(amount,coins));
    }
}
