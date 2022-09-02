package com.alating.alo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
public class MergeArray {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int left=intervals[0][0];
        int right=intervals[0][1];

        List<int[]> res=new ArrayList<int[]>();

        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0] > right){
                res.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }else{
                right=Math.max(right,intervals[i][1]);
            }
        }
        res.add(new int[]{left,right});

        return res.toArray(new int[0][]);

    }


    public int[][] mergeArray(int [][] intervals){

        Arrays.sort(intervals,(a,b)-> b[0]-a[0]);

        int left=intervals[0][0];
        int right=intervals[0][1];
        List<int[]> res=new ArrayList<int[]>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>right){
                res.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }else{
                right=Math.max(intervals[i][1],right);
            }
        }
        res.add(new int[]{left,right});

        return res.toArray(new int[0][]);
    }

    public static void main(String args[]){

        int [][] res= new MergeArray().mergeArray(new int[][]{{1,3},{8,10},{2,6},{15,18}});

        System.out.println(res);
    }
}
