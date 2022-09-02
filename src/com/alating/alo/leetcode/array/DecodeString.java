package com.alating.alo.leetcode.array;

import java.util.LinkedList;
import java.util.Stack;

/**
 *  https://leetcode.cn/problems/decode-string/
 *
 *  字符串解码
 */
public class DecodeString {


    public String decodeString(String s) {


        Stack<Integer> multiSta=new Stack<>();

        StringBuffer ans=new StringBuffer();
        Stack<StringBuffer> ansSta=new Stack<>();

        int multi=0;
        for(int i=0;i<s.length();i++){

            if(Character.isDigit(s.charAt(i))){
                multi=10*multi+ s.charAt(i)-'0';
            }else if(s.charAt(i)=='['){
                ansSta.add(ans);
                multiSta.add(multi);
                ans=new StringBuffer();
                multi=0;
            }else if(Character.isAlphabetic(s.charAt(i))){
                ans.append(s.charAt(i));
            }else if(s.charAt(i)==']'){
                StringBuffer ansTmp=ansSta.pop();
                int num=multiSta.pop();
                for(int k=0;k<num;k++){
                    ansTmp.append(ans);
                }
                ans=ansTmp;
            }

        }

        return ans.toString();

    }

    public static void main(String agrs[]){
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}
