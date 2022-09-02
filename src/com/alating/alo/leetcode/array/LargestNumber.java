package com.alating.alo.leetcode.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.cn/problems/largest-number/
 *
 *
 */
public class LargestNumber {

    /**
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {

        int n=nums.length;
        if(nums==null || nums.length==0){
            return null;
        }

        Integer[] numArr=new Integer[n];

        for(int i=0;i<nums.length;i++){
            numArr[i]=nums[i];
        }

        Arrays.sort(numArr,(x,y)->{
            long sx=10,sy=10;

            // sx代表x如果放在后面后需要的乘机数
            while(sx<=x){
                sx*=10;
            }

            while (sy<=y){
                sy*=10;
            }

            return (int)((y*sx+x) - (x*sy+y));
        });

        if(numArr[0]==0){
            return "0";
        }

        StringBuffer ret=new StringBuffer();
        for(int num:numArr){
            ret.append(num);
        }

        return ret.toString();

    }


    public static void main(String args[]){

        System.out.println(new LargestNumber().largestNumber(new int[]{10,22,40}));
    }
}
