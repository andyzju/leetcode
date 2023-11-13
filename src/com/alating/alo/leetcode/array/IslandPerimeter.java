package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/island-perimeter/solution/dao-yu-de-zhou-chang-by-leetcode-solution/
 *
 * 岛屿的长度
 */
public class IslandPerimeter {


    private static int dx[]={-1,0,1,0};  // 上，左 下右
    private static int dy[]={0,-1,0,1};  // 上 左下右

    /**
     *
     * @param x
     * @param y
     * @param grid
     * @param m
     * @param n
     * @return
     */
    private  int dfs(int x,int y,int grid[][],int m,int n){

        /**
         * 边届或者海洋
         */
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]==0){
            return 1;
        }

        if(grid[x][y]==2){
            return 0;
        }

        int ret=0;
        grid[x][y]=2;

        for(int i=0;i<4;i++){
            int tx=x+dx[i];
            int ty=y+dy[i];

            ret+=dfs(tx,ty,grid,m,n);
        }

        return ret;
    }
    /**
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans+=dfs(i,j,grid,m,n);
                }
            }

        }

        return ans;
    }


    public int islandPerimeter2(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]==1){

                    int cnt=0;
                    for(int k=0;k<4;k++){
                        int tx=i+dx[k];
                        int ty=j+dy[k];

                        if(tx<0 || tx>=n || ty<0 || ty>=m || grid[tx][ty]==0){
                            cnt+=1;
                        }
                    }
                    ans+=cnt;
                }
            }

        }
        return ans;
    }
}
