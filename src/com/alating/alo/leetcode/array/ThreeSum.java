package com.alating.alo.leetcode.array;


import java.util.*;

/**
 * https://leetcode.cn/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if(nums==null || nums.length<3){
            return new LinkedList<>();
        }

        Set<List<Integer>> lists = new HashSet<>();

        // 先排序
        Arrays.sort(nums); // 先排序

        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
            }
        }

        List<List<Integer>> res=new ArrayList<List<Integer>>();

        res.addAll(lists);
        return res;
    }

    public static void main(String args[]){

        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
