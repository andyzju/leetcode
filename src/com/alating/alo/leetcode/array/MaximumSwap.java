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
    public int maximumSwap1(int num) {

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


    /**
     * 交换任意两位
     * @param num
     * @return
     */
//    public int maximumSwap(int num){
//
//        if(num==0){
//            return 0;
//        }
//
//        char [] arr= String.valueOf(num).toCharArray();
//
//
//        int max=0;
//        /**
//         * 算法思路
//         * 假设要交换的左边为从 i 开始
//         * 那么求 其后的 最大的数，进行交换
//         */
//        for(int i=0;i<arr.length;i++){
//            int k=i; //求 i 之后的最大的数
//            for(int j=i+1;j<arr.length;j++){  // 通过这种方式找到第一个逆序的相邻两个数
//                if(arr[k]<arr[j]){  //
//                    k=j;
//                }
//            }
//            //k 为该循环之后的最大
//
//            if(k!=i && arr[k]!=arr[i]){
//
//                char temp=arr[i];
//                arr[i]=arr[k];
//                arr[k]=temp;
//                break; // 退出本次循环
//            }
//
//            max=Math.max(max,Integer.valueOf(new String(arr)));
//        }
//
//        return max;
//
//    }


    public int maximumSwap(int num) {

        char arr[]=String.valueOf(num).toCharArray();

        for(int i=0;i<arr.length;i++){// 以每一位为基准，然后先后找最大的
            int k=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[k]<=arr[j]){
                    k=j;
                }
            }

            if(k!=i && arr[k]!=arr[i]){
                char temp=arr[k];
                arr[k]=arr[i];
                arr[i]=temp;
                break;
            }
        }
        return Integer.valueOf(new String(arr));
    }
    public static void main(String args[]){

//        System.out.println(new MaximumSwap().maximumSwap(7298));

        System.out.println(new MaximumSwap().maximumSwap(1993));
    }
}
