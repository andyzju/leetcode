package com.alating.alo.leetcode.array;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
 *
 * 寻找旋转排序数组中的最小值
 */
public class FindMin {

    /**
     * 单调栈的问题
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {

        if(nums==null && nums.length==0){
            return 0;
        }

        Stack<Integer> stack= new Stack<Integer>();

        stack.push(nums[0]);
        for(int i=1;i<nums.length;i++){

            // 非空栈，后面的比前面的大，则
            if(!stack.isEmpty() && nums[i]>stack.peek()){
                stack.push(nums[i]);
            }else if(!stack.isEmpty() && nums[i]<stack.peek()){
                return nums[i];
            }
        }

        if(stack.size()==nums.length){
            return nums[0];
        }

        return -1;
    }


    public int findMin(int[] nums) {

        if(nums==null && nums.length==0){
            return 0;
        }

       int i=0;
        while(i<nums.length-1){
            if(nums[i]<nums[i+1]){
                i++;
            }else{
                break;
            }
        }

        if(i==nums.length-1){
            return nums[0];
        }else{
            return nums[i+1];
        }
    }

    public static void main(String args[]){

        new FindMin().findMin(new int[]{4,5,6,7,0,1,2});
    }

}
