package com.alating.alo.leetcode.array;

public class MaxVowels {

    private boolean isVowels(char cha){
        if(cha=='a' || cha=='e'||
                cha=='i'||cha=='o'||cha=='u'){
            return true;
        }
        return false;
    }
    public int maxVowelsOrigin(String s, int k) {

        if(s==null || s.length()==0){
            return 0;
        }

        // 假设最佳的字符串是从i开始
        int max=0;
        for(int i=0;i<=s.length()-k;i++){
            int num=0;
            for(int j=0;j<k;j++){
                if(isVowels(s.charAt(i+j))){
                    num++;
                }
            }

            max=Math.max(num,max);

        }

        return max;
    }


    public int maxVowels(String s, int k) {

        if(s==null || s.length()==0){
            return 0;
        }

        // 假设最佳的字符串是从i开始
        int max=0;
        // 先获取第一个基础窗口的数据
        int num=0;
        for(int i=0;i<k;i++){
            if(isVowels(s.charAt(i))){
                num++;
            }
        }

        max=Math.max(max,num);

        // 接下来滑动窗口开始
        for(int i=k;i<s.length();i++){
           num+= (isVowels(s.charAt(i))?1:0) - (isVowels(s.charAt(i-k))?1:0);
           max=Math.max(num,max);
        }

        return max;
    }
    public static void main(String args[]){
//        System.out.println(new MaxVowels().maxVowels("abciiidef",3));
        System.out.println(new MaxVowels().maxVowels("weallloveyou", 7));
    }
}
