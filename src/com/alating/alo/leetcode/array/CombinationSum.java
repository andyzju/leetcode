package com.alating.alo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 * <p>
 * 组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class CombinationSum {


    private void dfs(int[] candidates, int target, int beg, int end, List<Integer> ele, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<Integer>(ele));
            return;
        }


        for (int i = beg; i <= end; i++) {

            if (candidates[i] > target) {
                continue;
            } else {
                // 选择i的数据
                ele.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, end, ele, res);  // 允许重复i

                // 不选择i的数据
                ele.remove(ele.size() - 1);
            }
        }


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ele = new ArrayList<Integer>();
        Arrays.sort(candidates);

        int beg = 0;
        dfs(candidates, target, beg, candidates.length - 1, ele, res);
        return res;

    }


    public static void main(String args[]) {

        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
