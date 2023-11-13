package com.alating.alo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class AllPermutation {



    public List<List<Integer>> permute(int[] nums){

        int len=nums.length;

        List<List<Integer>>  res=new ArrayList<>();

        if(len==0){
            return res;
        }

        boolean[] used = new boolean[len];

        List<Integer> path= new ArrayList<>();

        dfs(nums,len,0,path,used,res); // 深度优先搜索

        return res;

    }


    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res){

        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<len;i++){

            if(!used[i]){

                path.add(nums[i]);
                used[i]=true;

                dfs(nums,len,depth+1,path,used,res);
                used[i]=false;
                path.remove(path.size()-1);
            }

        }

    }

    public static void main(String args[]){

        int[] nums={1,2,3};

        System.out.println(new AllPermutation().permute(nums));


    }
}
