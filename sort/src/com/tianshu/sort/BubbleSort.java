package com.tianshu.sort;

/**
 * 冒泡排序(稳定):
 *      耗费时间太长,比较相邻元素大小,不符合规则就交换
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,0};
        bubbleSort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }
    
    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if(nums[j - 1] > nums[j]){
                    nums[j - 1] = nums[j - 1] ^ nums[j];
                    nums[j] = nums[j - 1] ^ nums[j];
                    nums[j - 1] = nums[j - 1] ^ nums[j];
                }
            }
        }
    }
    
}
