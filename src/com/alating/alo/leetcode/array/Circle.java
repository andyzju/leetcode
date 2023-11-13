package com.alating.alo.leetcode.array;


/**
 * https://mp.weixin.qq.com/s/NZPaFsFrTybO3K3s7p7EVg
 *
 * - A.动态规划题目
 *
 */
public class Circle {

    /**
     * 回到0点的次数
     * @param n
     * @param k
     * @return
     */
    public int getCircleNum(int n,int k){

        if(n==0 || k==0 ){
            return 0;
        }

        int dp[][]=new int[k+1][n];
        dp[0][0]=1; //  啥也不动，一种方法

        for(int i=1;i<n;i++){  // 不走动，到非0为止，不存在
            dp[0][i]=0;
        }

        /**
         * 到达i位置
         * 用j步
         */

        for(int j=1;j<=k;j++){
            for(int i=0;i<=n-1;i++){
                dp[j][i]= dp[j-1][(i+1)%n] + dp[j-1][(i+n-1)%n];
            }
        }

        return dp[k][0];

            // 下述创建过程有问题

//        int dp[][]=new int[n][k+1];
//        dp[0][0]=1;
//
//        for(int i=0;i<=n-1;i++){
//            for(int j=1;j<k+1;j++){
//
//                // 下列的信息
//                dp[i][j]=dp[(i-1+n)%n][j-1] + dp[(i+ n-1)%n][j-1];
//            }
//        }
//
//        return dp[0][k];

    }

    public static void main(String args[]){

        System.out.println(new Circle().getCircleNum(10,4));

    }
}
