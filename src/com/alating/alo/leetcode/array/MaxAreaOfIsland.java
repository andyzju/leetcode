package com.alating.alo.leetcode.array;


/**
 * https://leetcode.cn/problems/max-area-of-island/
 *
 * 岛屿的最大面积
 */
public class MaxAreaOfIsland {

    /**
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {

        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }

        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];

        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }

    public int dfs(int [][]grid, int x,int y){

        if(x<0|| y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!=1){
            return 0;
        }

        // 如果不设置这个，那么会被后续 上下 左右 计算的时候反复重复计算；
        grid[x][y] = 0;
        int sum=1;

        sum+=dfs(grid,x-1,y);
        sum+=dfs(grid,x+1,y);
        sum+=dfs(grid,x,y-1);
        sum+=dfs(grid,x,y+1);

        return sum;
    }

    public static void main(String args[]){
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }
}
