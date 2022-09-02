package com.alating.alo.leetcode.array;

/**
 *  https://leetcode.cn/problems/minimum-size-subarray-sum/
 *
 *  长度最小的子数组
 */
public class MinSubArrayLen {


    /**
     *
     * @param target
     * @param nums
     * @return
     */
//    public int minSubArrayLen(int target, int[] nums) {
//
//       int n=nums.length;
//
//       if(nums==null || n==0 || target==0){
//           return 0;
//       }
//
//       int max=Integer.MAX_VALUE;
//
//       int start=0,end=0;
//       int sum=0;
//
//       while (end<n){
//
//           sum+=nums[end];
//
//           while(sum>=target){
//               // 如果大于target了，尝试整体左移动，
//               // 右边不动，左移试试
//               max=Math.min(end-start+1,max);
//               sum-=nums[start];
//               start++;
//           }
//           end++;
//       }
//       return  max == Integer.MAX_VALUE ? 0 : max;
//    }


    /**
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        int n=nums.length;
        if(nums==null || n==0){
            return 0;
        }

        int max=Integer.MAX_VALUE;

        int start=0,end=0;
        int sum=0;

        // 先确定start
        while(end<n){

            sum+=nums[end];

            // 确定end情况下
            while (sum>=target){
                max=Math.min(end-start+1,max);
                sum=sum-nums[start];
                start++;
            }
            end++;
        }

        return max == Integer.MAX_VALUE?0:max;
    }


    public static void main(String args[]){

        //System.out.println("=="+new MinSubArrayLen().minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));

        System.out.println("=="+new MinSubArrayLen().minSubArrayLen(4,new int[]{1,1,1,1,1,1,1,1}));
    }
}
