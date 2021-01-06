package com.tianshu.sort;

/**
 * 快速排序(不稳定):
 *      最坏的情况可能退化到O(N^2)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 6, 4, 5, 9, 7, 10, 2, 9, 0, 10, 0};
        quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    private static void quick(int[] nums, int start, int end) {
        if (start >= end) return;
        int quickNum = nums[start];
//        int left = start,right = end, now = start;
//        while(true){
//            if(now == right){
//                break;
//            }
//            if(nums[now] < quickNum){
//                nums[now] = nums[left] ^ nums[now];
//                nums[left] = nums[left] ^ nums[now];
//                nums[now] = nums[left] ^ nums[now];
//                ++left;
//                ++now;
//            }else if (nums[now] > quickNum){
//                nums[now] = nums[right] ^ nums[now];
//                nums[right] = nums[right] ^ nums[now];
//                nums[now] = nums[right] ^ nums[now];
//                --right;
//            }else{
//                ++now;
//            }
//        }
//        quick(nums,start,left - 1);
//        quick(nums,right + 1, end);

        int i = start, j = end;
        while (i < j) {
            // 右指针左移 找到第一个小于基准值的,将其赋值给 左指针,左指针右移一位
            while (i < j && nums[j] > quickNum) --j;
            if(i < j){
                nums[i] = nums[j];
                ++i;
            }

            // 左指针右移 找到第一个大于基准值的,将其赋值给 右指针.右指针左移一位
            while (i < j && nums[i] <= quickNum) ++i;
            if (i < j) {
                nums[j] = nums[i];
                --j;
            }
        }
        // 跳出循环时,必定满足 i == j
        // 这个位置左侧 <= 基准值; 右侧 > 基准值
        // 将 基准值 赋值到这个位置
        nums[i] = quickNum;
        quick(nums, start,i - 1);
        quick(nums, i + 1, end);

    }


}
