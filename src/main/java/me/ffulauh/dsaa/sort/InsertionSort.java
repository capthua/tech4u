package me.ffulauh.dsaa.sort;

public class InsertionSort extends BaseSort {

    public static void main(String[] args) {
        int[] nums = new int[]{51, 2, 7, 14, 8, 9};
        insertionSort(nums);
        printNums(nums);
    }

    /**
     * 位置p上的元素存储于tmp, 而(在位置p之前)所有更大的元素都向右移动一个位置. 然后tmp被置于正确的位置上.
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        int j;
        for (int p = 1; p < nums.length; p++) {
            int tmp = nums[p];
            for (j = p; j > 0 && tmp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
        }
    }
}
