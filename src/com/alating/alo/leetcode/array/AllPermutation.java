package com.alating.alo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class AllPermutation {


    /**
     * 交换
     * @param nums
     * @param a
     * @param b
     */
    private void swap(Integer nums[],int a,int b){
        int temp=nums[b];
        nums[b]=nums[a];
        nums[a]=temp;
    }

    // 是否完全逆序
    private boolean isDesc(Integer[] nums){

        int n=nums.length;
        int cnt=0;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]<nums[i-1]){
                cnt++;
            }
        }

        return cnt==n-1;
    }

    /**
     * 下一个全排序
     * @param next
     */
    public void nextPermutation(Integer[] next,List<List<Integer>> res){

        Integer nums[]=new Integer[next.length];
        // 先拷贝
        System.arraycopy(next,0,nums,0,nums.length);

        if(isDesc(nums)){
            return;
        }

        int len=nums.length;
        int i=len-2;
        int j=len-1;
        int k=len-1;

        // 先找到从后往前第一个升序
        // 找到第一个 升序的前后数据对
        while(i>=0 && nums[i]>=nums[j]){
            i--;
            j--;
        }

        // 找到最小但是比nums[i]大的数据
        if(i>=0){
            while(nums[i]>=nums[k]){
                k--;
            }
        }

        // 将i 和 k 互换，使得 i 位置之后的数据降序；
        swap(nums,i,k);

        // 将j到end之间的数据逆序
        int a=j;
        int b=nums.length-1;
        while(a<b){
            swap(nums,a,b);
            a++;
            b--;
        }

        // 加入res
        List<Integer> ele= Arrays.asList(nums);
        res.add(ele);

        // 下一个全排序
        nextPermutation(nums,res);
    }

    public List<List<Integer>> getAllList(int n){

        Integer nums[]=new Integer[n];
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> ele= Arrays.asList(nums);
        res.add(ele);

        System.out.println(res);

        nextPermutation(nums,res);

        return res;

    }

    private static boolean swapAccepted(Integer[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }


    private  void fullArray(Integer[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i)) {
                    continue;
                }
                swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                swap(array, cursor, i); // 用于对之前交换过的数据进行还原
            }
        }
    }


    public List<List<Integer>> getAllPermutation(int n){
        Integer nums[]=new Integer[n];
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        fullArray(nums,0,n-1);
        return res;

    }

    public static void main(String args[]){

//        System.out.println(new AllPermutation().getAllList(5));

        System.out.println(new AllPermutation().getAllPermutation(3));
    }
}
