package com.alating.alo.leetcode.array;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
 *
 * 和 coin change
 *  比较下
 *
 *
 * 虽然题目没有写清楚，但是要求是需要 【连续子数组的】
 */
public class SubarraySum {





    /**
     * 采用暴力法进行解决
     *
     *
     * @param nums
     * @param k
     * @return
     */

    public int subarraySum2(int[] nums, int k) {

        if (nums == null || nums.length == 0 ) {
            return 0;
        }

        int n=nums.length;
        int count=0;

        // 以i结尾
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j>=0;j--){
                sum+=nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 1。 还是以i为结尾进行判断
     * 2。 只是将计算k，转化为计算pre-k，通过hashmap记录 pre-k值来计算次数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {



        int n=nums.length;
        int count=0,pre=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        //这一句需要注意,为0的剩余值，就是从o-i 刚好为k
        map.put(0,1);

        for(int i=0;i<n;i++){
            pre+=nums[i];

            int res=pre-k;
            if(map.containsKey(res)){
                count+=map.get(res);
            }

            // 很关键
            //map.put(pre,map.getOrDefault(pre,0)+1);
            // 上述等价于
//            if(map.containsKey(pre)){
//                map.put(pre,map.get(pre)+1);
//            }else{
//                map.put(pre,1);
//            }

            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }






    public static void main(String args[]){

        System.out.println(new SubarraySum().subarraySum3(new int[]{-1,-1,0},0));

        System.out.println(new SubarraySum().subarraySum3(new int[]{1,2,3},3));
    }


}
