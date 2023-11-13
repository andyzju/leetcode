package com.alating.alo.leetcode.array;

import java.util.*;

/**
 * https://leetcode.cn/problems/diagonal-traverse/solution/by-inix-omrp/
 *
 * 蛇形遍历
 *
 * 1.  每一层实际上的坐标加起来的值是固定的
 * 2。 通过map记录
 */
public class FindDiagonalOrder {


    /**
     * 对角线遍历
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {

        if(mat==null){
            return null;
        }

        int m=mat.length;
        int n=mat[0].length;

        int ret[]=new int[m*n];

        HashMap<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();

        // 先遍历，记录到数组中
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i+j;
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }

        int idx=0;

        for(Integer key:map.keySet()){
            if(key%2==0){
                Collections.reverse(map.get(key));// 运用map的数组进行逆序
            }

            List<Integer> res=map.get(key);

            for(Integer ele:res){
                ret[idx++]=ele;
            }
        }

        return ret;

    }


    public static void main(String args[]){

        System.out.println(new FindDiagonalOrder().findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));

    }

}
