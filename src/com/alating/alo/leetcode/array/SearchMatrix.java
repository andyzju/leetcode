package com.alating.alo.leetcode.array;

/**
 *
 */
public class SearchMatrix {

    /**
     * https://leetcode.cn/problems/search-a-2d-matrix-ii/
     *
     * 搜索二维矩阵 II
     * @param matrix
     * @param target
     * @return
     *
     * 从最右边的列，右上角开始搜索合适
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }

        int m=matrix.length;
        int n=matrix[0].length;

        int i=0;
        // 这个是关键
        int j=n-1;

        while(i<m && j>=0){

            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }
        }
        return false;
    }


}
