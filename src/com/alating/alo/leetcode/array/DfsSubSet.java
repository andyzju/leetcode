package com.alating.alo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class DfsSubSet {


    List<Integer> ele=new ArrayList<Integer>();
    List<List<Integer>> ans=new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {

        int n=nums.length;

        for(int mask=0;mask<(1<<n);++mask){

            ele.clear();

            for(int i=0;i<n;++i){
                if((mask & (1<<i))!=0){
                    ele.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(ele));
        }
        return ans;
    }

}
