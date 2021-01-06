package com.tianshu.sort;

/**
 * 归并排序(稳定):
 *      需要额外的空间存储中间产物
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1};
        mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void mergeSort(int[] nums){
        merge(nums, 0, nums.length - 1);
    }

    private static void merge(int[] nums, int start, int end){
        // 只有一个元素返回
        if(start == end){
            return;
        }
        int mid = (start + end) >> 1;
        // 递归排序左半边
        merge(nums, start, mid);
        // 递归排序右半边
        merge(nums, mid + 1,end);

        int[] temp = new int[end - start + 1];
        int i = start,j = mid + 1,count = 0;
        // 将排好序的两边按顺序存入临时数组
        while(i <= mid && j <= end){
            temp[count++] = nums[i] <= nums[j]?nums[i++]:nums[j++];
        }
        // 将剩余元素存入临时数组
        while(i <= mid){
            temp[count++] = nums[i++];
        }
        while(j <= end){
            temp[count++] = nums[j++];
        }

        // 将临时数组中的元素放入原数组的正确位置
        int k = 0;
        while (k < temp.length) {
            nums[start + k] = temp[k];
            ++k;
        }
    }

}
