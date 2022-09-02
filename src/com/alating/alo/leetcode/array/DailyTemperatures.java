package com.alating.alo.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 非常典型的 单调栈的使用问题
 * https://leetcode.cn/problems/daily-temperatures/
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int answer[]=new int[temperatures.length];
        if(temperatures==null || temperatures.length==0){
            return answer;
        }
        Deque<Integer> stack=new LinkedList<Integer>();

        for(int i=0;i<temperatures.length;i++){

            int temp=temperatures[i];
            //这里需要非常注意
            // stack中记录的是 下标
            // 具体的值 通过数组去查询
            while(!stack.isEmpty() && temp> temperatures[stack.peek()]){

                int idx=stack.pop();
                answer[idx]=i-idx;
            }
            // 如果没有了比自己小的，自己是最大的了，压入栈中
            stack.push(i); // 压入的是下标
        }
        return answer;
    }


    public static void main(String agrs[]){
        System.out.println(new DailyTemperatures().dailyTemperatures(new int[]{30,40,50,60}));
    }
}
