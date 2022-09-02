package com.alating.alo.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 *
 *  hard模式的题
 * 接雨水
 */
public class TrapRain {

    /** 这个比较好理解一些
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if(height==null || height.length==0){
            return 0;
        }

        int res=0;

        /**
         * 最左边和最右边其实都无法蓄水
         * 1. 以每一个点为基准，向左或者向右去找最大
         * 2。 求最右最大之最小
         */
        for(int i=1;i<height.length-1;i++){
            int maxLeft=0,maxRight=0;
            for(int j=i;j>=0;j--){
                maxLeft=Math.max(maxLeft,height[j]);
            }

            for(int j=i;j<=height.length-1;j++){
                maxRight=Math.max(maxRight,height[j]);
            }

            res+=Math.min(maxLeft,maxRight)-height[i];
        }
        return res;
    }

    /**
     * 动态规划
     */

    public int trap2(int[] height) {

        if(height==null || height.length==0){
            return 0;
        }

        int maxLeft[]=new int[height.length];
        maxLeft[0]=height[0];
        for(int i=1;i<height.length;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i]);
        }


        int maxRight[] =new int[height.length];
        maxRight[height.length-1]=height[height.length-1];

        for(int i=height.length-2;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1],height[i]);
        }

        int res=0;

        for(int i=0;i<height.length;i++){
            res+=Math.min(maxLeft[i],maxRight[i])-height[i];
        }
        return res;
    }
    /**
     * 栈的应用
     */
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String args[]){

        System.out.println(new TrapRain().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new TrapRain().trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new TrapRain().trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
