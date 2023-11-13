package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 *
 * 选择排序的方式进行
 */
public class FindKthLargest {


    /**
     * 采用类似选择排序的逻辑
     * 利用冒泡排序的逻辑
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        if(nums==null||nums.length==0|| k>nums.length){
            return -1;
        }

        for(int i=0;i<k;i++){

            for(int j=i+1;j<nums.length;j++){

                if(nums[j]>=nums[i]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        return nums[k-1];

    }

    public static void main(String args[]){
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
