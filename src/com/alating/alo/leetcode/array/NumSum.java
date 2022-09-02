package com.alating.alo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://juejin.cn/post/7114258819961585694
 *
 * 采用动态规划实现
 *
 * 和 金币是一样的逻辑
 */
public class NumSum {

    public int getNum(int nums[],int target){

        if(nums==null || nums.length==0){
            return 0;
        }

        if(target==0){
            return 1;
        }

        int dp[]= new int [target+1];

        dp[0]=1;

        // 不考虑顺序的解法
//        for(int coin:nums){
//            for(int i=coin;i<=target;i++){

//                dp[i]+=dp[i-coin];

//            }
//        }

        // 考虑顺序的解法
        for(int i=1;i<=target;i++)
            for(int coin:nums){
            {
                if(i>=coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[target];

    }


    public static void main(String args[]){

        int nums[]=new int[]{1,2,3};

        System.out.println(new NumSum().getNum(nums,4));
    }
}
