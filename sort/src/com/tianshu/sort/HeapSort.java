package com.tianshu.sort;

/**
 * 堆排序(不稳定):构建并维护一个堆,每次从堆顶取出一个元素
 *      O(NlogN)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void heapSort(int[] nums) {
        // 建立大顶堆
        buildMaxHeap(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // 交换堆顶与堆底元素
            swap(nums, 0 , nums.length - i - 1);
            // 维护大顶堆
            heapify(nums, 0, nums.length - i - 2);
        }
    }

    private static void buildMaxHeap(int[] nums) {
        // 从 1/2 处自下而上创建 大顶堆
        for (int i = nums.length >> 1; i >= 0; i--) {
            heapify(nums, i);
        }
    }

    private static void heapify(int[] nums, int i) {
        heapify(nums, i, nums.length - 1);
    }

    /**
     *创建并维护堆的函数
     * @param nums:要维护的堆
     * @param i:从 i 开始向下维护
     * @param maxIndex:要维护到的最大索引
     */
    private static void heapify(int[] nums, int i, int maxIndex) {
        // 左孩子
        int left = (i << 1) + 1;
        // 右孩子
        int right = (i << 1) + 2;
        // 默认三者最大为本节点
        int max = i;
        // 若左孩子存在并大于 当前最大者,交换
        if(left <= maxIndex && nums[max] < nums[left]){
            max = left;
        }
        // 若右孩子存在并大于 当前最大者,交换
        if(right <= maxIndex && nums[max] < nums[right]){
            max = right;
        }
        // 若最大者不是本节点,交换本节点与最大者,继续递归维护
        if(max != i){
            swap(nums, i, max);
            heapify(nums, max, maxIndex);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
