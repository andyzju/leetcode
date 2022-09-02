package com.alating.alo.leetcode.array;

/**
 * https://leetcode.cn/problems/sort-an-array/
 * 数组排序
 */
public class SortArray {
    /**
     * 先用归并排序
     * @return
     */
    public int[] sortArray(int[] nums) {

        if(nums==null || nums.length==1){
            return nums;
        }
        sortArray(nums,0,nums.length-1);

        return nums;
    }

    private void sortArray(int nums[],int start,int end){

        if(start>=end){
                return;
        }

        int mid = (start + end) / 2;

        sortArray(nums, start, mid);
        sortArray(nums, mid + 1, end);

         mergeArray(nums,start,mid,mid+1,end);

    }

    private void mergeArray(int nums[],int leftStart,int leftEnd,int rigStart, int rigEnd){
        int res[]=new int[rigEnd-leftStart+1];
        int i=leftStart;
        int j=rigStart;
        int k=0;
        while(i<=leftEnd && j<=rigEnd){
            if(nums[i]<nums[j]){
                res[k++]=nums[i];
                i++;
            }else{
                res[k++]=nums[j];
                j++;
            }
        }

        while(i<=leftEnd){
            res[k++]=nums[i];
            i++;
        }

        while (j<=rigEnd){
            res[k++]=nums[j];
            j++;
        }

        k=0;
        for(int t=leftStart;t<=rigEnd;t++){
            nums[t]=res[k++];
        }
    }

    public static void main(String args[]){
        int [] nums= new SortArray().sortArray(new int[]{5,2,3,1});

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }
}
