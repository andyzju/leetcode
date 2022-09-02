package com.alating.alo.leetcode.array;

public class TranslateNumCnt {

    public int translateNum(int num){

        String s=String.valueOf(num);

        int len=s.length();
        int res[] =new int[len+1];

        res[0]=1;

        // 从1开始作为下标
        for(int i=1;i<=len;i++){
            // 如果第i个数字作为单独的翻译，那么就和res[i-1]一致
            res[i]=res[i-1];

            if(i>1){
                // 当第i-1 和i作为一个整体数字的时候
                int t= (s.charAt(i-2)-'0')*10 + s.charAt(i-1)-'0';
                if(t>=10 && t<=25){
                    res[i]+=res[i-2];
                }
            }
        }

        return res[len];

    }

    public static void main(String args[]){

        int n=12258;

        System.out.println(new TranslateNumCnt().translateNum(n));

        System.out.println(new TranslateNumCnt().translateNum(122));

    }
}
