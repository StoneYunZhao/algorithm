package com.zhaoyun.algorithm.sort;

/**
 * @author zhaoyun
 * create at 2019/12/25 19:47
 */
public final class SelectionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = min;
            nums[minIndex] = tmp;
        }
    }
}
