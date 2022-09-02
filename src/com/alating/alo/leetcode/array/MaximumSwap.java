package com.alating.alo.leetcode.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/maximum-swap/
 *
 */
public class MaximumSwap {

    /**
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {

        if(num==0){
            return num;
        }

        char str[]= String.valueOf(num).toCharArray();

        TreeMap<Character,Integer> map=new TreeMap<>();

        for(int i=0;i<str.length;i++){
            map.put(str[i],i);
        }

        char temp[]=new char[str.length];
        for(int i=0;i<str.length;i++){
            temp[i]=str[i];
        }

        Arrays.sort(temp);
        int n=temp.length;


        for(int i=0;i<str.length;i++){

            // 从高到低，如果高位是顺序的，则继续
            if(str[i]==temp[n-1-i]){
                continue;
            }else{
                // 第一个不符合的，进行排序
                char tempChar=temp[n-1-i];
                str[map.get(temp[n-1-i])]=str[i];
                str[i]=tempChar;
                break;
            }
        }

        int ret=0;
        for(int i=0;i<n;i++){
            ret= ret*10 + str[i]-'0';
        }

        return ret;
    }


    public static void main(String args[]){

        System.out.println(new MaximumSwap().maximumSwap(7298));
    }
}
