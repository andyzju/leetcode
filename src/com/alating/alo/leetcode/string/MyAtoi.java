package com.alating.alo.leetcode.string;

public class MyAtoi {

    public int myAtoi(String s) {

        s=s.trim();
        if(s==null || s.length()==0){
            return 0;
        }

        if(!Character.isDigit(s.charAt(0))
                && s.charAt(0)!='-' && s.charAt(0)!='+'){
            return 0;
        }

        long num=0;
        boolean positive=true;
        if(s.charAt(0)=='-'){
            positive=false;
        }else if(s.charAt(0)=='+'){
            positive=true;
        }

        int start= !Character.isDigit(s.charAt(0))?1:0;
        for(int i=start;i<s.length();i++){
            if('0'<= s.charAt(i) && s.charAt(i) <= '9'){
                num= num*10+ (s.charAt(i)-'0');

                if(!positive && num>(Integer.MAX_VALUE+1l)){
                    return Integer.MIN_VALUE;
                }else if(positive && num>=Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else {
                break;
            }
        }

        if(!positive){
            num=-1*num;
        }


        return (int)num;


    }

    public static void main(String args[]){

       // System.out.println(new MyAtoi().myAtoi("42"));
        System.out.println(new MyAtoi().myAtoi("   -42"));
        System.out.println(new MyAtoi().myAtoi("4193 with words"));
        System.out.println(new MyAtoi().myAtoi("  -4193 with words"));
        System.out.println(new MyAtoi().myAtoi(" with words 4193"));
    }
}
