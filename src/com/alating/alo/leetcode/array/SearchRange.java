package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {

    /**
     * 这是正常的方法
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }

        int left=0,right=nums.length-1;

        int res[]=new int[2];

        boolean leftHit=false;
        boolean rightHit=false;

        while(left<=right){

            // 准入判断
            if(nums[left]>target){
                return new int[]{-1,-1};
            }else if(nums[left]==target){
                 res[0]=left;
                leftHit=true;
            }else if(nums[left]<target){
                left++;
            }

            if(nums[right]<target){
                return new int[]{-1,-1};
            }else if(nums[right]==target){
                res[1]=right;
                rightHit=true;
            }else if(nums[right]>target){
                right--;
            }

            if(leftHit && rightHit){
                break;
            }
        }

        if(left>right){
            return new int[]{-1,-1};
        }

        return res;
    }



    public static void main(String agr[]){

        System.out.println(new SearchRange().searchRange(new int[]{5,7,7,8,8,10},8));
        System.out.println(new SearchRange().searchRange(new int[]{5,7,7,8,8,10},6));
        System.out.println(new SearchRange().searchRange(new int[]{},0));
    }
}
