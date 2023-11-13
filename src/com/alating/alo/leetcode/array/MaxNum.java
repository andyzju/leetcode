package com.alating.alo.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/circle/discuss/246WFU/
 */
public class MaxNum {

    public int findMaxNum(int []nums, int n){

        // 进行处理, 转换成数组
        char[] chars= String.valueOf(n).toCharArray();

        int[] arr = new int[chars.length];

        for(int i=0;i<arr.length;i++){
            arr[i]=chars[i]-'0';
        }


        // nums进行排序
        Arrays.sort(nums);

        // 数据结果
        StringBuffer sb=new StringBuffer();
        int j=0;
        for(int i=0;i<arr.length;i++){

            int num=arr[i];
            while(j<nums.length){
                if(j==nums.length-1 && num>nums[j]){
                    int size= chars.length -sb.length();
                    for(int k=0;k<size;k++){
                        sb.append(nums[nums.length-1]);
                    }
                    return Integer.parseInt(sb.toString());
                }

                if(nums[j]==num){
                    sb.append(num);
                    j=0;
                    break;
                }else if(nums[j]<num){
                    j++;
                } else{  // nums[j]>num 代表当前数字，比num位置的要大
                    while(j>=0 && nums[j]>num){
                        j--;  // 回溯
                    }

                    int size=0;

                    if(j<0){
                        sb=new StringBuffer();
                        size=chars.length-1;
                    }else{
                        sb.append(nums[j]);
                        size=chars.length-sb.length();
                    }

                    for(int k=0;k<size;k++){
                        sb.append(nums[nums.length-1]);
                    }

                    return Integer.parseInt(sb.toString());
                }
            }

        }

        return Integer.parseInt(sb.toString());

    }

    public static void main(String args[]){
        System.out.println(new MaxNum().findMaxNum(new int[]{1,2,4,9},2533));
    }
}
