package com.alating.alo.leetcode.string;


/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 最长回文字符串
 *
 */
public class LongestPalindrome {

    /**
     * 最长回文字符串
     *
     * 从每个字符串开始进行回文判读，中心扩散
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if(s==null || s.length()==0){
            return null;
        }


        int maxLen=0;
        int start=0;
        for(int i=0;i<s.length();i++){

            int len=1;
            int left=i-1;
            int right=i+1;
            while(left>=0 && s.charAt(i)==s.charAt(left)){
                left--;
                len++;
            }


            while(right<=s.length()-1 && s.charAt(i)==s.charAt(right)){
                right++;
                len++;
            }


            while((left>=0 && right<=s.length()-1) && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                len+=2;
            }

            if(len>maxLen){
                maxLen=len;
                start=left+1;
            }

        }

        return s.substring(start,start+maxLen);
    }

    public static void main(String args[]){
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }
}
