package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 *
 * 乘积最大子数组
 */
public class MaxProduct {

    /**
     * 最大乘积子数组
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int maxF[]=new int[nums.length];
        int minF[]=new int[nums.length];

        System.arraycopy(nums,0,maxF,0,nums.length);
        System.arraycopy(nums,0,minF,0,nums.length);

        //以i结束的数据
        for(int i=1;i<nums.length;i++){
            maxF[i]=Math.max(Math.max(maxF[i-1]*nums[i],nums[i]),minF[i-1]*nums[i]);
            minF[i]=Math.min(Math.min(minF[i-1]*nums[i],nums[i] ),maxF[i-1]*nums[i]);
        }

        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            max=Math.max(max,maxF[i]);
        }

        return max;
    }


    public static void main(String args[]){
        System.out.println(new MaxProduct().maxProduct(new int[]{2,3,-2,4}));
    }
}
