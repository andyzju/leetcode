package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 *
 * 最长重复子数组
 *
 *
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * 编辑距离
 */
public class FindLength {

    public int findLength(int[] nums1, int[] nums2) {

        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
            return 0;
        }

        int m=nums1.length;
        int n=nums2.length;

        int dp[][]=new int[m+1][n+1];
        int max=0;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){

                dp[i][j]=nums1[i]==nums2[j]?dp[i+1][j+1]+1:0;
                max=Math.max(max,dp[i][j]);
            }
        }


        return max;

    }

    public int findLength2(int[] nums1, int[] nums2){

        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
            return 0;
        }

        int m= nums1.length;
        int n=nums2.length;

        int dp[][]=new int[m+1][n+1];

        int max=0;

        for(int i=1;i<=m;i++){

            for(int j=1;j<=n;j++){
                dp[i][j]=nums1[i-1]==nums2[j-1]?dp[i-1][j-1]+1:0;
                max=Math.max(max,dp[i][j]);
            }
        }

        return max;
    }



    public static void main(String args[]){

        System.out.println(new FindLength().findLength2(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));

        System.out.println(new FindLength().findLength2(new int[]{0,0,0,0,1},new int[]{1,0,0,0,0}));
    }

}
