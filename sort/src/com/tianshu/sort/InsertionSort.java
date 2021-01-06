package com.tianshu.sort;

/**
 * 插入排序(稳定):
 *      O(N^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,0};
        insertionSort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int nowNum = nums[i];
            int nowIndex = i;
            while(nowIndex > 0 && nowNum < nums[nowIndex - 1]){
                nums[nowIndex] = nums[nowIndex - 1];
                nowIndex--;
            }
            nums[nowIndex] = nowNum;
        }
    }
}
