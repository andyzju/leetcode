package com.alating.alo.leetcode.string;

/**
 * https://leetcode.cn/problems/multiply-strings/
 *
 * 字符串相乘
 */
public class Multiply {

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }


        int m=num1.length();
        int n=num2.length();
        String sum="0";

        for(int j=n-1;j>=0;j--){
            int y=num2.charAt(j)-'0';
            int carry=0;
            StringBuffer sb=new StringBuffer();

            // 先在后续添加
            for(int k=n-1;k>j;k--){
                sb.append("0");
            }

            for(int i=m-1;i>=0;i--){
                int x=num1.charAt(i)-'0';

                int res= x*y+carry;
                int r=res%10;
                carry= res/10;
                sb.append(r);
            }
            if(carry!=0){
                sb.append(carry%10);
            }

             sum= addStr(sum,sb.reverse().toString());
        }

        return sum;

    }


    public String addStr(String num1,String num2){

        StringBuffer add=new StringBuffer();

        int len1=num1.length();
        int len2=num2.length();
        int len=Math.max(len1,len2);

        int carry=0;
        for(int i=1;i<=len;i++){
            int x= len1-i>=0? num1.charAt(len1-i)-'0':0;
            int y= len2-i>=0? num2.charAt(len2-i)-'0':0;
            int res= x+y+ carry;
            int r =res%10;
            carry= res/10;

            add.append(r);
        }

        if(carry!=0){
            add.append(carry);
        }

        return add.reverse().toString();


    }


    public static void main(String args[]){

//        String num1="1134";
//        String num2="22";


        String num1="9";
        String num2="9";

        System.out.println(new Multiply().multiply(num1,num2));
    }

}
