package com.alating.alo.leetcode.string;

public class LengthofLastword {

    public int getLengthOfLastWord(String str){

        if(str==null){
            return 0;
        }

        String arr[]=str.split(" ");
        return arr[arr.length-1].length();

    }

    public static void main(String args[]){


        System.out.println(new LengthofLastword().getLengthOfLastWord("hello nowcoder"));
    }
}
