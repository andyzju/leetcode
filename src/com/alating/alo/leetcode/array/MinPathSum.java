package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 *
 * 一看就是动态规划，但是是比较简单的动态规划
 *
 * 这一题必须自己完整的解答出来
 */
public class MinPathSum {


    private void visitGrid(int[][] grid,int m,int n,int dp[][]){

        // 初始化
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        // 除了第一行、第一列的赋值
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min((dp[i-1][j]+grid[i][j]),(dp[i][j-1]+grid[i][j]));
            }
        }
    }
    public int minPathSum(int[][] grid) {

        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }

        int m=grid.length;
        int n=grid[0].length;

        int dp[][]=new int[m][n];

        visitGrid(grid,m,n,dp);

        return dp[m-1][n-1];

    }

    public static void main(String args[]){

        int [][] grid=new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(new MinPathSum().minPathSum(grid));
    }
}
