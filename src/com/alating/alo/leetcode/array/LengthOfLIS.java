package com.alating.alo.leetcode.array;

public class LengthOfLIS {

    /**
     * 核心思路
     *
     * 以每个数为终止，
     * 向前进行回溯求值
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int len=nums.length;

        int dp[]=new int[len];
        dp[0]=1;

        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen=Math.max(dp[i],maxLen);
        }

        return maxLen;
    }


    public int lengthOfLIS2(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int len=nums.length;

        int dp[]=new int[len];

        dp[0]=1;
        int maxLen=0;

        for(int i=0;i<len;i++){

            for(int j=0;j<i;j++){

                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

            maxLen=Math.max(dp[i],maxLen);

        }

        return maxLen;

    }


    public static void main(String args[]){

        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));

        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{1,9,2,5,3,7,10,8,19}));
    }
}
