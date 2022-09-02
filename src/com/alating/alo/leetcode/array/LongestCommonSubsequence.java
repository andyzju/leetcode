package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/
 *
 * 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonSubsequence {

    /**
     * DP 问题
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {

        if(text1==null || text1.length()==0 || text2==null || text2.length()==0){
            return 0;
        }

        int m=text1.length();
        int n=text2.length();

        int dp[][]=new int[m+1][n+1];

        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }

        for(int i=0;i<m;i++){
            dp[i][0]=0;
        }

        // 第m个元素对应于 dp[*][j
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
