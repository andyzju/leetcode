package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 *
 *
 * 这个题目没太懂
 *
 * https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 *
 *
 * 具体地，我们这样描述该算法，对于长度为 nn 的排列 aa：
 *
 * 首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)，满足 a[i] < a[i+1]a[i]<a[i+1]。这样「较小数」即为 a[i]a[i]。此时 [i+1,n)[i+1,n) 必然是下降序列。
 *
 * 如果找到了顺序对，那么在区间 [i+1,n)[i+1,n) 中从后向前查找第一个元素 jj 满足 a[i] < a[j]a[i]<a[j]。这样「较大数」即为 a[j]a[j]。
 *
 * 交换 a[i]a[i] 与 a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 */
public class NextPermutation {

    private void swap(int nums[],int a,int b){
        int temp=nums[b];
        nums[b]=nums[a];
        nums[a]=temp;
    }
    public void nextPermutation(int[] nums){

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
    }

    public static void main(String args[]){

        //int nums[]=new int[]{1,5,8,4,7,6,5,3,1};

        int nums[]=new int[]{1,2,3,5,7,6,4};
        new NextPermutation().nextPermutation(nums);

        System.out.println(nums);
    }
}
