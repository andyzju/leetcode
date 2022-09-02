package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/house-robber/
 *
 * 打家劫舍
 */
public class MaxRob {

    /**
     * 递归的用法
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int getMaxRob(int nums[],int start,int end){
        if(start==end){
            return nums[start];
        }else if(start+1==end){
            return Math.max(nums[start],nums[end]);
        }else if(start+2==end){
            return Math.max(nums[start]+nums[end],nums[start+1]);
        }else{
            // 如果当前不采用 以及采用当前
            return Math.max(getMaxRob(nums,start+1,end),nums[start] + getMaxRob(nums,start+2,end));
        }
    }

    /**
     * 递归超时了
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        return getMaxRob(nums,0,nums.length-1);

    }


    public int rob(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

       int dp[]=new int[nums.length];

        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        dp[0]=nums[0];
        dp[1]= Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            // 不偷当前和偷当前
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length-1];

    }


    /**
     *
     * @param args
     */
    public static void main(String args[]){

        System.out.println(new MaxRob().rob1(new int[]{2,1,4,5,3,1,1,3}));

        System.out.println(new MaxRob().rob1(new int[]{2,1,4,5,1,2}));


        System.out.println(new MaxRob().rob(new int[]{2,1,4,5,3,1,1,3}));

        System.out.println(new MaxRob().rob(new int[]{2,1,4,5,1,2}));
    }

}
