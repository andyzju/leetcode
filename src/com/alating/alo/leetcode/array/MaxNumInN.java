package com.alating.alo.leetcode.array;

import java.util.TreeSet;

/**
 * 求n范围的符合规则的最大数
 * 这个有难度，到目前为止还是不太会
 */
public class MaxNumInN {

    private int max = 0;
    private TreeSet<Integer> set = new TreeSet<>();

    //传入 数组A 和 x
    public int maxNum(int[] A, int x){
        for (int i : A) {
            set.add(i);
            max = Math.max(max,i);
        }
        return dfs(x-1);
    }

    int dfs(int x){
        if (x<=0) return 0;
        int res = 0, is = -1;
        char[] chars = (x + "").toCharArray();
        for (char c : chars) {

            // 如果前面的高位已经小于高位了
            if (is!=-1){
                res = res*10 + max;
                continue;
            }else if(set.contains(c-'0')){
                // 这一位数相同的处理
                res = res*10+(c-'0');
                continue;
            }else if(set.lower(c-'0')!=null) {
                // 找到小一点的数据
                res = res * 10 + set.lower(c - '0');
            }
//            }else{
//                res= dfs(res-1)*10 + max;
//            }
            is = 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] A = {1,2,4,7,9};
        int x = 8511;
        int i = new MaxNumInN().maxNum(A,x);
        System.out.println(i);
    }

}

