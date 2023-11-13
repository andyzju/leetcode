package com.alating.alo.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxProfitSec {

    public int maxProfit(int[] prices) {

        if(prices==null || prices.length==0){
            return 0;
        }

        Deque<Integer> deque= new LinkedList<Integer>();
        deque.offerLast(prices[0]);

        int total=0;
        for(int i=1;i<prices.length;i++){
            if(!deque.isEmpty() && prices[i]<deque.peekLast()){

                if(deque.size()==1){
                    deque.pop();
                }else if( deque.size()>=2){
                    int a = deque.pollLast();
                    int b = deque.pollFirst();
                    deque.clear();
                    total += (a - b);
                }
            }
            deque.offerLast(prices[i]);
        }

        // 然后
         if( deque.size()>=2) {
            int a = deque.pollLast();
            int b = deque.pollFirst();
            total += (a - b);
        }

        return total;

    }

    public static void main(String args[]){

//        System.out.println(new MaxProfitSec().maxProfit(new int[]{7,1,5,3,6,4}));
//
//        System.out.println(new MaxProfitSec().maxProfit(new int[]{1,2,3,4,5}));

        System.out.println(new MaxProfitSec().maxProfit(new int[]{2,1,4,5,2,9,7}));
    }
}
