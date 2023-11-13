package com.alating.alo.leetcode.array;

import java.util.HashSet;

/**
 * 最长连续序列
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 *
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {

    /**
     *
     * 采用hashset来解决问题
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        HashSet<Integer> hashSet=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }

        int max=1;
        // 以 num为开始计算
        for(int num:hashSet){

            int size=1;

            // 如果存在num-1,回头碰到 num-1 开始的还是会计算，不考虑前面，因为后续还是会计算，只管后续
            if(!hashSet.contains(num-1)){

                while(hashSet.contains(num+1)){  // hashset， 连续的妙用
                    num+=1;
                    size++;
                }
            }

            max=Math.max(max,size);

        }

        return max;
    }


    /**
     * 最长连续序列
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {

        return 0;

    }

    public static void main(String args[]){

    }
}
