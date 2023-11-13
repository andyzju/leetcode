package com.alating.alo.leetcode.array;

public class MaxWork {

    public int work(int []nums){
        if(nums==null){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        return work(nums,0,nums.length-1);
    }


    public int work(int [] nums,int start,int end){


        if(start==end){
            return nums[start];
        }

        if(start+1==end){
            return Math.max(nums[start],nums[end]);
        }

        if(start+2==end){
            return Math.max(nums[start]+ nums[end],nums[start+1]);
        }

        int max= Math.max(nums[start]+ work(nums,start+2,end),work(nums,start+1,end));

        return max;
    }

    /**
     *
     * @param nums
     * @return
     */
    public int maxWork(int nums[]){

        if(nums==null){
            return 0;
        }

        int dp[]=new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1] );

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }

    public static void main(String args[]){

        System.out.println(new MaxWork().work(new int[]{2,1,4,5,3,1,1,3}));

        System.out.println(new MaxWork().work(new int[]{2,1,4,5,1,2}));


        System.out.println(new MaxWork().maxWork(new int[]{2,1,4,5,3,1,1,3}));

        System.out.println(new MaxWork().maxWork(new int[]{2,1,4,5,1,2}));
    }

}
