package com.tianshu.sort;

/**
 * 选择排序(不稳定):
 *      时间较长,每次选出最小值与最左侧交换
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,6,5,4,3,2,1,0};
        selectionSort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                nums[i] = nums[i] ^ nums[minIndex];
                nums[minIndex] = nums[i] ^ nums[minIndex];
                nums[i] = nums[i] ^ nums[minIndex];
            }
        }
    }
}
