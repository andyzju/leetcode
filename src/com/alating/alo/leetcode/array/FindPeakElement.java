package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/find-peak-element/
 *
 * 寻找峰值
 *
 * 其实是利用类似二分法进行逼近
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        if(nums==null || nums.length==0){
            return -1;
        }

        int l=0;
        int r=nums.length-1;

        while(l<r){

            int mid=(l+r)/2;

            if(nums[mid]>nums[mid+1] && (mid==0 || nums[mid]>nums[mid-1])){
                return mid;
            }else if(nums[mid]<nums[mid+1]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;

    }

}
