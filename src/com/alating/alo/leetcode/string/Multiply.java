package com.alating.alo.leetcode.string;

public class Multiply {

    public String multiply(String num1, String num2) {

        String sum="0";
        int i=0;

        String numBuf1=new StringBuffer(num1).reverse().toString();
        String numBuf2=new StringBuffer(num2).reverse().toString();

        for(Character x : numBuf2.toCharArray()){
            String temp=plus(numBuf1,x);
            sum = add(sum,temp,i);
            i++;
        }

        return sum;

    }

    public String plus(String num1,Character x){
        int carry=0;
        StringBuffer sb=new StringBuffer();
       for(Character s:num1.toCharArray()){
            int p= (s-'0')*(x-'0')+carry;
            int r=p%10;
            carry=p/10;
            sb.append(r);
       }
       return sb.reverse().toString();
    }

    public String add(String sum,String temp,int n){


        while(--n>=0){
            temp+='0';
        }

        int length= Math.max(sum.length(),temp.length());

        int leftLen = sum.length();
        int rightLen = temp.length();

        int carry=0;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<=length-1;i++){
            int idx1=leftLen-1-i;
            int idx2=rightLen-1-i;

            int left = idx1>=0? sum.charAt(idx1)-'0':0;
            int right = idx2>=0? temp.charAt(idx2)-'0':0;
            int sumRes = left+right+carry;
            int res=sumRes%10;
            carry=sumRes/10;
            sb.append(res);
        }

        return sb.reverse().toString();
    }


    public static void main(String args[]){

        String num1="1134";
        String num2="22";

        System.out.println(new Multiply().multiply(num1,num2));
    }

}
