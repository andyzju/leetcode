package com.alating.alo.leetcode.array;

import java.util.Stack;

/**
 * 最大矩形面积
 *
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {

    /**
     * 采用[暴力法循环]
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        if(heights==null || heights.length==0){
            return 0;
        }

        int max=0;

        //从第i个开始的矩阵
        for(int i=0;i<heights.length;i++){
            int minHeight=Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++){
                minHeight=Math.min(minHeight,heights[j]);
                max=Math.max(max,(j-i+1)*minHeight);
            }
        }
        return max;

    }

    /**
     *
     * https://leetcode.cn/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     * 单调栈的使用方法
     * @param heights
     * @return
     */
    public int largestRectangleAreanew(int[] heights) {

//        int largestRectangleArea(vector<int>& heights) {
//        int ans=0,n=heights.size();
//        stack<int> stk;
//        for(int i=0;i<n;++i){
//            while(!stk.empty()&&heights[i]<heights[stk.top()]){
//                int cur=stk.top();
//                stk.pop();
//                int pre=stk.empty()?-1:stk.top();
//                ans=max(ans,heights[cur]*(i-pre-1));
//            }
//            stk.push(i);
//        }
//        while(!stk.empty()){
//            int cur=stk.top();
//            stk.pop();
//            int pre=stk.empty()?-1:stk.top();
//            ans=max(ans,heights[cur]*(n-pre-1));
//        }
//        return ans;
//    }

        return 0;

    }


    int largestRectangleArea2(int[] heights) {

        int ans=0,n=heights.length;
        Stack<Integer> stk = new Stack<>();

        for(int i=0;i<n;++i){
            while(!stk.empty()&&heights[i]<heights[stk.peek()]){
                int cur=stk.peek();
                stk.pop();
                int pre=stk.empty()?-1:stk.peek();
                ans=Math.max(ans,heights[cur]*(i-pre-1));
            }
            stk.push(i);
        }
        while(!stk.empty()){
            int cur=stk.peek();
            stk.pop();
            int pre=stk.empty()?-1:stk.peek();
            ans=Math.max(ans,heights[cur]*(n-pre-1));
        }
        return ans;
    }


    public static void main(String args[]){

        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
