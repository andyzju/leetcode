package com.alating.alo.leetcode.array;

import java.util.HashMap;

public class TwoSum {

    /**
     * 最笨的办法，用o(n2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {

        int list[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    list[0]=i;
                    list[1]=j;
                }
            }
        }
        return list;
    }

    /**
     * 以空间换时间
     *
     * 在遍历的过程中，从之前的遍历结果进行排除，之前遍历记录map中
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        int list[]=new int[2];

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                list[0]=map.get(target-nums[i]);
                list[1]=i;
            }
            map.put(nums[i],i);
        }

        return list;

    }


    public static void main(String args[]){
        System.out.println(new TwoSum().twoSum1(new int[]{3,2,1,5,6,4},5));
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},6));
    }
}
