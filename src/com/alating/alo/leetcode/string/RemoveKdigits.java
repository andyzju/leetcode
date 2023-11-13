package com.alating.alo.leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移除数字
 */
public class RemoveKdigits {

    /**
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {

        if(num==null){
            return null;
        }

        Deque<Character> deque= new LinkedList<Character>();

        int length= num.length();


        /**
         * 同过deque 将数据加入队列中
         */
        for(int i=0;i<length;i++){
            char digit=num.charAt(i);

            // 如果上一个数据比当前的大，则删除
            while(!deque.isEmpty() && k>0 && deque.peekLast()>digit){
                deque.pollLast();
                k--;
            }

            deque.offerLast(digit);

        }

        /**
         *  如果需要移除5个，但是由于逆序原因，导致不足以移除，则移除最后的k个
         */
        for(int i=0;i<k;i++){
            deque.pollLast();
        }

        // RET, 将栈中数据转换为string
        // 将剩余的deque中数据转换成string
        StringBuilder ret = new StringBuilder();
        Boolean leadingzero=true;
        while(!deque.isEmpty()){

            char digit=deque.pollFirst();

            // 首位的0 移除
            if(leadingzero && digit=='0'){
                continue;
            }

            leadingzero=false;
            ret.append(digit);
        }

        return ret.length()==0?"0":ret.toString();

    }

    public static void main(String args[]){

        System.out.println(new RemoveKdigits().removeKdigits("1356224",2));
    }
}
