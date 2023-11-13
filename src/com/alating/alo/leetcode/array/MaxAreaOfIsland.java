package com.alating.alo.leetcode.array;


/**
 * https://leetcode.cn/problems/max-area-of-island/
 *
 * 岛屿的最大面积
 */
public class MaxAreaOfIsland {


    /**
     * 获取面积信息
     * @param grid
     * @param x
     * @param y
     * @return
     */
    private int getArea(int[][] grid, int x,int y){
        int m=grid.length;
        int n=grid[0].length;
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]!=1){
            return 0;
        }

        if(grid[x][y]==2){ // 访问过标记
            return 0;
        }

        int sum=1;
        grid[x][y]=2;
        sum += getArea(grid,x-1,y);
        sum += getArea(grid,x+1,y);
        sum += getArea(grid,x,y-1);
        sum += getArea(grid,x,y+1);

        return sum;

    }

    /**
     *  通过递归方式判断
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {

        if(grid==null || grid.length==0 ){
            return 0;
        }

        int m=grid.length;
        int n=grid[0].length;

        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area=getArea(grid,i,j);
                    max=Math.max(max,area);
                }
            }
        }

        return max;

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
