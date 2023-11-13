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

        if(nums==null || nums.length==0){
            return null;
        }

        int n= nums.length;

        Integer[] numArr = new Integer[n];

        for(int i=0;i<n;i++){
            numArr[i]=nums[i];
        }

        Arrays.sort(numArr, (x,y) ->{

            long sx=10,sy=10;
            while (sx <= x) {
                sx *= 10;
            }

            while(sy<=y){
                sy*=10;
            }

            return (int) (-((x*sy+y)-(y*sx+x)));
        });

        if (numArr[0] == 0) {
            return "0";
        }

        StringBuffer res=new StringBuffer();

        for(int num:numArr){
            res.append(num);
        }

        return res.toString();


    }


    public static void main(String args[]){

        System.out.println(new LargestNumber().largestNumber(new int[]{10,22,40}));
    }
}
