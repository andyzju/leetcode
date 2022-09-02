package com.alating.alo.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 *
 *
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        if(nums==null || nums.length<3 ){
            return 0;
        }

        int min=Integer.MAX_VALUE;
        int minSum= Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            int left=i+1;
            int right=nums.length-1;

            // 有相同元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while(left<right) {

                int tempSum = nums[i] + nums[left] + nums[right];
                int check = Math.abs(tempSum - target);

                if(check==0){
                    return target;
                }else if (check < min) {
                    min = check;
                    minSum = tempSum;
                } else if (tempSum < target) {
                    left++;
                } else if (tempSum > target) {
                    right--;
                }
            }

        }

        return minSum;

    }

    public static void main(String args[]){

        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4},1));

        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0,0,0},1));
    }
}
