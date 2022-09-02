package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/rotate-image/
 *
 * 旋转图像
 *
 *  先上下调换，再对角线调换
 */
public class RotateMatrix {


    /**
     * 每一列先上下反转
     *
     * 然后进行对角线交换
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return;
        }

        int n=matrix.length;

        /**
         * 先上下对换
         */
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){

                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][j];
                matrix[n-1-i][j]=temp;

            }
        }

        /**
         *  注意一些细节，不要反复反转
         *
         *  再对角线
         */
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){

                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
}
