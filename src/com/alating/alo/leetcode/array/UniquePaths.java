package com.alating.alo.leetcode.array;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/unique-paths/
 *
 * 不同路径
 */
public class UniquePaths {

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int dp[][]=new int[m][n];

        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }

        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }


    public int uniquePathSec(int m, int n){
        if(m==0 && n==0){
            return 0;
        }
        HashMap<Pair,Integer> map= new HashMap<Pair,Integer>();

        return dfs(map,m-1,n-1);

    }
    class Pair{
        private int i;
        private int j;
        public Pair(int i,int j){
            i=i;
            j=j;
        }
    }
    private int dfs(HashMap<Pair,Integer> map,int i,int j){
        Pair p=new Pair(i,j);
        if(map.containsKey(p)){
            return map.get(p);
        }

        if(i==0 || j==0){
            map.put(p,1);
            return 1;
        }

        map.put(p,dfs(map,i-1,j) + dfs(map,i,j-1));
        return map.get(p);
    }
    public static void main(String args[]){

        System.out.println(new UniquePaths().uniquePaths(3,7));

        System.out.println(new UniquePaths().uniquePathSec(3,7));

        System.out.println(new UniquePaths().uniquePathSec(51,9));
    }
}
