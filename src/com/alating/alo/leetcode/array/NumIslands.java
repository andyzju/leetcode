package com.alating.alo.leetcode.array;


/**
 * https://leetcode.cn/problems/number-of-islands/
 *
 * 岛屿的数量
 */
public class NumIslands {

    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int m=grid.length;
        int n=grid[0].length;
        int nums=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    ++nums;
                    dfs(grid,i,j);
                }
            }
        }

        return nums;

    }


    private void dfs(char[][] grid, int x,int y){

        int m=grid.length;
        int n=grid[0].length;

        // 递归的退出机制， 这些条件下则不可再递归了
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]=='0'){
            return;
        }

        if(grid[x][y]==2){
            return;
        }

        grid[x][y]='2';  // 访问过的置为0
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }
}
