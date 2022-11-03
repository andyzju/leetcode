package com.alating.alo.leetcode.array;

public class Sqrt {

    private static Float DEF=0.0000001F;

    public double getSqrt(int n){

        if(n==0){
            return 0;
        }
        double left=0;
        double right=n;
        double mid=(left+right)/2;

        while((right-mid)>DEF){

            if(mid*mid>n){
                right=mid;
                mid=(left+right)/2;
            }else{
                left=mid;
                mid=(left+right)/2;
            }
        }
        return mid;
    }
    public static void main(String args[]){

        System.out.println(new Sqrt().getSqrt(9));
        System.out.println(new Sqrt().getSqrt(4));
        System.out.println(new Sqrt().getSqrt(2));
    }
}
