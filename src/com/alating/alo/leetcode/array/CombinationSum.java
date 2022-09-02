package com.alating.alo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 *
 * 组合总和
 *
 */
public class CombinationSum {



    public void dfsCombinationSum(int[] candidates, int target,
                                  int beg,int end,
                                  List<Integer> ele,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<Integer>(ele));
            return;
        }
        for (int i = beg; i <=end; i++){

            if(candidates[i]>target){  //当前值大，那么这个i 不需要考虑
                continue;
            }else{  // candidates[i]<target
                ele.add(candidates[i]);
                dfsCombinationSum(candidates,target-candidates[i],i,end,ele,res);
                ele.remove(ele.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> ele=new ArrayList<Integer>();
        Arrays.sort(candidates);

        dfsCombinationSum(candidates,target,0,candidates.length-1,ele,res);

        return res;

    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<>(); // 设置保存结果的数组
//        List<Integer> path = new ArrayList<>(); // 设置保存递归路径的数组
//        Arrays.sort(candidates);  // 对数组进行排序
//        find(candidates, 0, candidates.length - 1, target, ans, path);
//        return ans;
//    }
//    public void find(int[] candidates, int start, int end, int target, List<List<Integer>> ans, List<Integer> path) {
//        if (target == 0) {  // 当target==0时，说明该路径上的数和为目标值，加入结果中
//            ans.add(new ArrayList<Integer> (path));
//            return;
//        }
//        for (int i = end; i >= start; i--) { // 从大的数往前遍历
//            if (candidates[i] > target) { // 如果当前数大于目标值，符合的数只能比当前数更小，即前面的位置
//                continue;
//            } else {
//                path.add(candidates[i]);
//                find(candidates, start, i, target - candidates[i], ans, path);
//                path.remove(path.size() - 1);
//            }
//        }
//    }


    public static void main(String args[]){

        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7},7));
    }
}
