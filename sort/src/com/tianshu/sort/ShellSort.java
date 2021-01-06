package com.tianshu.sort;

/**
 * 希尔排序(不稳定):插入排序的改进版
 *      初始插入排序步长为数组长度的一半, 每次循环将插入步长减少一半,直到步长减为 1
 *      O(NlogN)
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,0};
        shellSort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }

    private static void shellSort(int[] nums) {
        int length = nums.length;
        for(int gap = length >> 1; gap > 0; gap >>= 1){
            for(int j = gap; j < length; ++j){
                int nowNum = nums[j];
                int nowIndex = j;
                while(nowIndex >= gap && nums[nowIndex - gap] > nowNum){
                    nums[nowIndex] = nums[nowIndex - gap];
                    nowIndex -= gap;
                }
                nums[nowIndex] = nowNum;
            }
        }
    }

}
