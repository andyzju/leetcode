package com.alating.alo.leetcode.array;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length==0){
            return "";
        }

        String prefix=strs[0];


        for(int i=1;i<strs.length;i++){

            prefix=longestCommonPrefix(prefix,strs[i]);

            if(prefix.length()==0){
                break;
            }
        }

        return prefix;

    }


    public String longestCommonPrefix(String str1, String str2) {

        int length=Math.min(str1.length(),str2.length());

        int index=0;

        while(index<length && str1.charAt(index)==str2.charAt(index)){
            index++;
        }

        return str1.substring(0,index);
    }


    public static void main(String args[]){

        List<String> strs = Arrays.asList("flower","flow","flight");
        String strss[]= (String[]) strs.toArray();

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strss));

    }
}
